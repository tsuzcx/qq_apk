package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public final class Mp4Extractor
  implements Extractor, SeekMap
{
  private static final int BRAND_QUICKTIME = Util.getIntegerCodeForString("qt  ");
  public static final ExtractorsFactory FACTORY = new Mp4Extractor.1();
  public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
  private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760L;
  private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144L;
  private static final int STATE_READING_ATOM_HEADER = 0;
  private static final int STATE_READING_ATOM_PAYLOAD = 1;
  private static final int STATE_READING_SAMPLE = 2;
  private long[][] accumulatedSampleSizes;
  private ParsableByteArray atomData;
  private final ParsableByteArray atomHeader;
  private int atomHeaderBytesRead;
  private long atomSize;
  private int atomType;
  private final Stack<Atom.ContainerAtom> containerAtoms;
  private long durationUs;
  private ExtractorOutput extractorOutput;
  private int firstVideoTrackIndex;
  private final int flags;
  private boolean isQuickTime;
  private final ParsableByteArray nalLength;
  private final ParsableByteArray nalStartCode;
  private int parserState;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private int sampleTrackIndex;
  private Mp4Extractor.Mp4Track[] tracks;
  
  public Mp4Extractor()
  {
    this(0);
  }
  
  public Mp4Extractor(int paramInt)
  {
    this.flags = paramInt;
    this.atomHeader = new ParsableByteArray(16);
    this.containerAtoms = new Stack();
    this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    this.nalLength = new ParsableByteArray(4);
    this.sampleTrackIndex = -1;
  }
  
  private static long[][] calculateAccumulatedSampleSizes(Mp4Extractor.Mp4Track[] paramArrayOfMp4Track)
  {
    long[][] arrayOfLong = new long[paramArrayOfMp4Track.length][];
    int[] arrayOfInt = new int[paramArrayOfMp4Track.length];
    long[] arrayOfLong1 = new long[paramArrayOfMp4Track.length];
    boolean[] arrayOfBoolean = new boolean[paramArrayOfMp4Track.length];
    int i = 0;
    while (i < paramArrayOfMp4Track.length)
    {
      arrayOfLong[i] = new long[paramArrayOfMp4Track[i].sampleTable.sampleCount];
      arrayOfLong1[i] = paramArrayOfMp4Track[i].sampleTable.timestampsUs[0];
      i += 1;
    }
    long l1 = 0L;
    int j = 0;
    while (j < paramArrayOfMp4Track.length)
    {
      int k = -1;
      long l2 = 9223372036854775807L;
      i = 0;
      while (i < paramArrayOfMp4Track.length)
      {
        int m = k;
        long l3 = l2;
        if (arrayOfBoolean[i] == 0)
        {
          m = k;
          l3 = l2;
          if (arrayOfLong1[i] <= l2)
          {
            l3 = arrayOfLong1[i];
            m = i;
          }
        }
        i += 1;
        k = m;
        l2 = l3;
      }
      i = arrayOfInt[k];
      arrayOfLong[k][i] = l1;
      l1 += paramArrayOfMp4Track[k].sampleTable.sizes[i];
      i += 1;
      arrayOfInt[k] = i;
      if (i < arrayOfLong[k].length)
      {
        arrayOfLong1[k] = paramArrayOfMp4Track[k].sampleTable.timestampsUs[i];
      }
      else
      {
        arrayOfBoolean[k] = true;
        j += 1;
      }
    }
    return arrayOfLong;
  }
  
  private void enterReadingAtomHeaderState()
  {
    this.parserState = 0;
    this.atomHeaderBytesRead = 0;
  }
  
  private static int getSynchronizationSampleIndex(TrackSampleTable paramTrackSampleTable, long paramLong)
  {
    int j = paramTrackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(paramLong);
    int i = j;
    if (j == -1) {
      i = paramTrackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(paramLong);
    }
    return i;
  }
  
  private int getTrackIndexOfNextReadSample(long paramLong)
  {
    int i = 0;
    long l5 = 9223372036854775807L;
    int i3 = 1;
    long l3 = 9223372036854775807L;
    int m = -1;
    int j = -1;
    int n = 1;
    long l1 = 9223372036854775807L;
    for (;;)
    {
      Object localObject = this.tracks;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      int k = ((Mp4Extractor.Mp4Track)localObject).sampleIndex;
      long l7;
      if (k == ((Mp4Extractor.Mp4Track)localObject).sampleTable.sampleCount)
      {
        l7 = l5;
      }
      else
      {
        long l2 = localObject.sampleTable.offsets[k];
        long l6 = this.accumulatedSampleSizes[i][k];
        l7 = l2 - paramLong;
        if ((l7 >= 0L) && (l7 < 262144L)) {
          k = 0;
        } else {
          k = 1;
        }
        long l4;
        int i2;
        int i1;
        if ((k != 0) || (n == 0))
        {
          l4 = l3;
          i2 = j;
          i1 = n;
          l2 = l1;
          if (k == n)
          {
            l4 = l3;
            i2 = j;
            i1 = n;
            l2 = l1;
            if (l7 >= l1) {}
          }
        }
        else
        {
          i1 = k;
          i2 = i;
          l2 = l7;
          l4 = l6;
        }
        l7 = l5;
        l3 = l4;
        j = i2;
        n = i1;
        l1 = l2;
        if (l6 < l5)
        {
          m = i;
          l1 = l2;
          n = i1;
          j = i2;
          l3 = l4;
          i3 = k;
          l7 = l6;
        }
      }
      i += 1;
      l5 = l7;
    }
    if ((l5 == 9223372036854775807L) || (i3 == 0) || (l3 < l5 + 10485760L)) {
      m = j;
    }
    return m;
  }
  
  private static long maybeAdjustSeekOffset(TrackSampleTable paramTrackSampleTable, long paramLong1, long paramLong2)
  {
    int i = getSynchronizationSampleIndex(paramTrackSampleTable, paramLong1);
    if (i == -1) {
      return paramLong2;
    }
    return Math.min(paramTrackSampleTable.offsets[i], paramLong2);
  }
  
  private void processAtomEnded(long paramLong)
  {
    while ((!this.containerAtoms.isEmpty()) && (((Atom.ContainerAtom)this.containerAtoms.peek()).endPosition == paramLong))
    {
      Atom.ContainerAtom localContainerAtom = (Atom.ContainerAtom)this.containerAtoms.pop();
      if (localContainerAtom.type == Atom.TYPE_moov)
      {
        TraceUtil.beginSection("Mp4Extractor.processMoovAtom");
        processMoovAtom(localContainerAtom);
        TraceUtil.endSection();
        this.containerAtoms.clear();
        this.parserState = 2;
      }
      else if (!this.containerAtoms.isEmpty())
      {
        ((Atom.ContainerAtom)this.containerAtoms.peek()).add(localContainerAtom);
      }
    }
    if (this.parserState != 2) {
      enterReadingAtomHeaderState();
    }
  }
  
  private static boolean processFtypAtom(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(8);
    if (paramParsableByteArray.readInt() == BRAND_QUICKTIME) {
      return true;
    }
    paramParsableByteArray.skipBytes(4);
    while (paramParsableByteArray.bytesLeft() > 0) {
      if (paramParsableByteArray.readInt() == BRAND_QUICKTIME) {
        return true;
      }
    }
    return false;
  }
  
  private void processMoovAtom(Atom.ContainerAtom paramContainerAtom)
  {
    ArrayList localArrayList = new ArrayList();
    GaplessInfoHolder localGaplessInfoHolder = new GaplessInfoHolder();
    Object localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_udta);
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = AtomParsers.parseUdta((Atom.LeafAtom)localObject1, this.isQuickTime);
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        localGaplessInfoHolder.setFromMetadata((Metadata)localObject1);
        localObject3 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
    }
    int k = 0;
    int i = -1;
    long l1 = -9223372036854775807L;
    while (k < paramContainerAtom.containerChildren.size())
    {
      localObject1 = (Atom.ContainerAtom)paramContainerAtom.containerChildren.get(k);
      Track localTrack;
      TrackSampleTable localTrackSampleTable;
      if (((Atom.ContainerAtom)localObject1).type == Atom.TYPE_trak)
      {
        localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
        boolean bool;
        if ((this.flags & 0x1) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localTrack = AtomParsers.parseTrak((Atom.ContainerAtom)localObject1, (Atom.LeafAtom)localObject2, -9223372036854775807L, null, bool, this.isQuickTime);
        if (localTrack != null)
        {
          localTrackSampleTable = AtomParsers.parseStbl(localTrack, ((Atom.ContainerAtom)localObject1).getContainerAtomOfType(Atom.TYPE_mdia).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl), localGaplessInfoHolder);
          if (localTrackSampleTable.sampleCount == 0) {
            break label418;
          }
        }
      }
      Mp4Extractor.Mp4Track localMp4Track = new Mp4Extractor.Mp4Track(localTrack, localTrackSampleTable, this.extractorOutput.track(k, localTrack.type));
      int j = localTrackSampleTable.maximumSize;
      Format localFormat = localTrack.format.copyWithMaxInputSize(j + 30);
      Object localObject2 = localFormat;
      if (localTrack.type == 1)
      {
        localObject1 = localFormat;
        if (localGaplessInfoHolder.hasGaplessInfo()) {
          localObject1 = localFormat.copyWithGaplessInfo(localGaplessInfoHolder.encoderDelay, localGaplessInfoHolder.encoderPadding);
        }
        localObject2 = localObject1;
        if (localObject3 != null) {
          localObject2 = ((Format)localObject1).copyWithMetadata(localObject3);
        }
      }
      localMp4Track.trackOutput.format((Format)localObject2);
      long l2;
      if (localTrack.durationUs != -9223372036854775807L) {
        l2 = localTrack.durationUs;
      } else {
        l2 = localTrackSampleTable.durationUs;
      }
      l1 = Math.max(l1, l2);
      if (localTrack.type == 2)
      {
        j = i;
        if (i == -1) {
          j = localArrayList.size();
        }
      }
      else
      {
        j = i;
      }
      localArrayList.add(localMp4Track);
      i = j;
      label418:
      k += 1;
    }
    this.firstVideoTrackIndex = i;
    this.durationUs = l1;
    this.tracks = ((Mp4Extractor.Mp4Track[])localArrayList.toArray(new Mp4Extractor.Mp4Track[localArrayList.size()]));
    this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(this.tracks);
    this.extractorOutput.endTracks();
    this.extractorOutput.seekMap(this);
  }
  
  private boolean readAtomHeader(ExtractorInput paramExtractorInput)
  {
    if (this.atomHeaderBytesRead == 0)
    {
      if (!paramExtractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
        return false;
      }
      this.atomHeaderBytesRead = 8;
      this.atomHeader.setPosition(0);
      this.atomSize = this.atomHeader.readUnsignedInt();
      this.atomType = this.atomHeader.readInt();
    }
    long l1 = this.atomSize;
    if (l1 == 1L)
    {
      paramExtractorInput.readFully(this.atomHeader.data, 8, 8);
      this.atomHeaderBytesRead += 8;
      this.atomSize = this.atomHeader.readUnsignedLongToLong();
    }
    else if (l1 == 0L)
    {
      long l2 = paramExtractorInput.getLength();
      l1 = l2;
      if (l2 == -1L)
      {
        l1 = l2;
        if (!this.containerAtoms.isEmpty()) {
          l1 = ((Atom.ContainerAtom)this.containerAtoms.peek()).endPosition;
        }
      }
      if (l1 != -1L) {
        this.atomSize = (l1 - paramExtractorInput.getPosition() + this.atomHeaderBytesRead);
      }
    }
    if (this.atomSize >= this.atomHeaderBytesRead)
    {
      if (shouldParseContainerAtom(this.atomType))
      {
        l1 = paramExtractorInput.getPosition() + this.atomSize - this.atomHeaderBytesRead;
        this.containerAtoms.add(new Atom.ContainerAtom(this.atomType, l1));
        if (this.atomSize == this.atomHeaderBytesRead)
        {
          processAtomEnded(l1);
          return true;
        }
        enterReadingAtomHeaderState();
        return true;
      }
      if (shouldParseLeafAtom(this.atomType))
      {
        boolean bool;
        if (this.atomHeaderBytesRead == 8) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        if (this.atomSize <= 2147483647L) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        this.atomData = new ParsableByteArray((int)this.atomSize);
        System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
        this.parserState = 1;
        return true;
      }
      this.atomData = null;
      this.parserState = 1;
      return true;
    }
    throw new ParserException("Atom size less than header length (unsupported).");
  }
  
  private boolean readAtomPayload(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    long l1 = this.atomSize - this.atomHeaderBytesRead;
    long l2 = paramExtractorInput.getPosition();
    ParsableByteArray localParsableByteArray = this.atomData;
    if (localParsableByteArray != null)
    {
      paramExtractorInput.readFully(localParsableByteArray.data, this.atomHeaderBytesRead, (int)l1);
      if (this.atomType == Atom.TYPE_ftyp) {
        this.isQuickTime = processFtypAtom(this.atomData);
      } else if (!this.containerAtoms.isEmpty()) {
        ((Atom.ContainerAtom)this.containerAtoms.peek()).add(new Atom.LeafAtom(this.atomType, this.atomData));
      }
    }
    else
    {
      if (l1 >= 262144L) {
        break label137;
      }
      paramExtractorInput.skipFully((int)l1);
    }
    int i = 0;
    break label152;
    label137:
    paramPositionHolder.position = (paramExtractorInput.getPosition() + l1);
    i = 1;
    label152:
    processAtomEnded(l2 + l1);
    return (i != 0) && (this.parserState != 2);
  }
  
  private int readSample(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    long l2 = paramExtractorInput.getPosition();
    if (this.sampleTrackIndex == -1)
    {
      this.sampleTrackIndex = getTrackIndexOfNextReadSample(l2);
      if (this.sampleTrackIndex == -1) {
        return -1;
      }
    }
    Mp4Extractor.Mp4Track localMp4Track = this.tracks[this.sampleTrackIndex];
    TrackOutput localTrackOutput = localMp4Track.trackOutput;
    int k = localMp4Track.sampleIndex;
    long l1 = localMp4Track.sampleTable.offsets[k];
    int j = localMp4Track.sampleTable.sizes[k];
    l2 = l1 - l2 + this.sampleBytesWritten;
    if ((l2 >= 0L) && (l2 < 262144L))
    {
      l1 = l2;
      int i = j;
      if (localMp4Track.track.sampleTransformation == 1)
      {
        l1 = l2 + 8L;
        i = j - 8;
      }
      paramExtractorInput.skipFully((int)l1);
      int m;
      if (localMp4Track.track.nalUnitLengthFieldLength != 0)
      {
        paramPositionHolder = this.nalLength.data;
        paramPositionHolder[0] = 0;
        paramPositionHolder[1] = 0;
        paramPositionHolder[2] = 0;
        m = localMp4Track.track.nalUnitLengthFieldLength;
        int n = 4 - localMp4Track.track.nalUnitLengthFieldLength;
        for (;;)
        {
          j = i;
          if (this.sampleBytesWritten >= i) {
            break;
          }
          j = this.sampleCurrentNalBytesRemaining;
          if (j == 0)
          {
            paramExtractorInput.readFully(this.nalLength.data, n, m);
            this.nalLength.setPosition(0);
            this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
            this.nalStartCode.setPosition(0);
            localTrackOutput.sampleData(this.nalStartCode, 4);
            this.sampleBytesWritten += 4;
            i += n;
          }
          else
          {
            j = localTrackOutput.sampleData(paramExtractorInput, j, false);
            this.sampleBytesWritten += j;
            this.sampleCurrentNalBytesRemaining -= j;
          }
        }
      }
      for (;;)
      {
        m = this.sampleBytesWritten;
        j = i;
        if (m >= i) {
          break;
        }
        j = localTrackOutput.sampleData(paramExtractorInput, i - m, false);
        this.sampleBytesWritten += j;
        this.sampleCurrentNalBytesRemaining -= j;
      }
      localTrackOutput.sampleMetadata(localMp4Track.sampleTable.timestampsUs[k], localMp4Track.sampleTable.flags[k], j, 0, null);
      localMp4Track.sampleIndex += 1;
      this.sampleTrackIndex = -1;
      this.sampleBytesWritten = 0;
      this.sampleCurrentNalBytesRemaining = 0;
      return 0;
    }
    paramPositionHolder.position = l1;
    return 1;
  }
  
  private static boolean shouldParseContainerAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_moov) || (paramInt == Atom.TYPE_trak) || (paramInt == Atom.TYPE_mdia) || (paramInt == Atom.TYPE_minf) || (paramInt == Atom.TYPE_stbl) || (paramInt == Atom.TYPE_edts);
  }
  
  private static boolean shouldParseLeafAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_mdhd) || (paramInt == Atom.TYPE_mvhd) || (paramInt == Atom.TYPE_hdlr) || (paramInt == Atom.TYPE_stsd) || (paramInt == Atom.TYPE_stts) || (paramInt == Atom.TYPE_stss) || (paramInt == Atom.TYPE_ctts) || (paramInt == Atom.TYPE_elst) || (paramInt == Atom.TYPE_stsc) || (paramInt == Atom.TYPE_stsz) || (paramInt == Atom.TYPE_stz2) || (paramInt == Atom.TYPE_stco) || (paramInt == Atom.TYPE_co64) || (paramInt == Atom.TYPE_tkhd) || (paramInt == Atom.TYPE_ftyp) || (paramInt == Atom.TYPE_udta);
  }
  
  private void updateSampleIndices(long paramLong)
  {
    Mp4Extractor.Mp4Track[] arrayOfMp4Track = this.tracks;
    int m = arrayOfMp4Track.length;
    int i = 0;
    while (i < m)
    {
      Mp4Extractor.Mp4Track localMp4Track = arrayOfMp4Track[i];
      TrackSampleTable localTrackSampleTable = localMp4Track.sampleTable;
      int k = localTrackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(paramLong);
      int j = k;
      if (k == -1) {
        j = localTrackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(paramLong);
      }
      localMp4Track.sampleIndex = j;
      i += 1;
    }
  }
  
  public long getDurationUs()
  {
    return this.durationUs;
  }
  
  public SeekMap.SeekPoints getSeekPoints(long paramLong)
  {
    Object localObject = this.tracks;
    if (localObject.length == 0) {
      return new SeekMap.SeekPoints(SeekPoint.START);
    }
    int i = this.firstVideoTrackIndex;
    long l3;
    long l4;
    long l1;
    label152:
    long l2;
    if (i != -1)
    {
      localObject = localObject[i].sampleTable;
      i = getSynchronizationSampleIndex((TrackSampleTable)localObject, paramLong);
      if (i == -1) {
        return new SeekMap.SeekPoints(SeekPoint.START);
      }
      l3 = localObject.timestampsUs[i];
      l4 = localObject.offsets[i];
      if ((l3 < paramLong) && (i < ((TrackSampleTable)localObject).sampleCount - 1))
      {
        int j = ((TrackSampleTable)localObject).getIndexOfLaterOrEqualSynchronizationSample(paramLong);
        if ((j != -1) && (j != i))
        {
          paramLong = localObject.timestampsUs[j];
          l1 = localObject.offsets[j];
          break label152;
        }
      }
      l1 = -1L;
      paramLong = -9223372036854775807L;
      l2 = paramLong;
      paramLong = l1;
      l1 = l4;
    }
    else
    {
      l1 = 9223372036854775807L;
      l4 = -1L;
      l2 = -9223372036854775807L;
      l3 = paramLong;
      paramLong = l4;
    }
    i = 0;
    for (;;)
    {
      localObject = this.tracks;
      if (i >= localObject.length) {
        break;
      }
      long l5 = paramLong;
      l4 = l1;
      if (i != this.firstVideoTrackIndex)
      {
        localObject = localObject[i].sampleTable;
        l4 = maybeAdjustSeekOffset((TrackSampleTable)localObject, l3, l1);
        l1 = paramLong;
        if (l2 != -9223372036854775807L) {
          l1 = maybeAdjustSeekOffset((TrackSampleTable)localObject, l2, paramLong);
        }
        l5 = l1;
      }
      i += 1;
      paramLong = l5;
      l1 = l4;
    }
    localObject = new SeekPoint(l3, l1);
    if (l2 == -9223372036854775807L) {
      return new SeekMap.SeekPoints((SeekPoint)localObject);
    }
    return new SeekMap.SeekPoints((SeekPoint)localObject, new SeekPoint(l2, paramLong));
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
  }
  
  public boolean isSeekable()
  {
    return true;
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    for (;;)
    {
      int i = this.parserState;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2)
          {
            TraceUtil.beginSection("Mp4Extractor.readSample");
            i = readSample(paramExtractorInput, paramPositionHolder);
            TraceUtil.endSection();
            return i;
          }
          throw new IllegalStateException();
        }
        TraceUtil.beginSection("Mp4Extractor.readAtomPayload");
        if (readAtomPayload(paramExtractorInput, paramPositionHolder))
        {
          TraceUtil.endSection();
          return 1;
        }
        TraceUtil.endSection();
      }
      else
      {
        TraceUtil.beginSection("Mp4Extractor.readAtomHeader");
        if (!readAtomHeader(paramExtractorInput))
        {
          TraceUtil.endSection();
          return -1;
        }
        TraceUtil.endSection();
      }
    }
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.containerAtoms.clear();
    this.atomHeaderBytesRead = 0;
    this.sampleTrackIndex = -1;
    this.sampleBytesWritten = 0;
    this.sampleCurrentNalBytesRemaining = 0;
    if (paramLong1 == 0L)
    {
      enterReadingAtomHeaderState();
      return;
    }
    if (this.tracks != null) {
      updateSampleIndices(paramLong2);
    }
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    return Sniffer.sniffUnfragmented(paramExtractorInput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.Mp4Extractor
 * JD-Core Version:    0.7.0.1
 */