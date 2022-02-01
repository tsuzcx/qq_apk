package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class FragmentedMp4Extractor
  implements Extractor
{
  private static final Format EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", 9223372036854775807L);
  public static final ExtractorsFactory FACTORY = new FragmentedMp4Extractor.1();
  public static final int FLAG_ENABLE_EMSG_TRACK = 4;
  private static final int FLAG_SIDELOADED = 8;
  public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
  public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
  public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
  private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE;
  private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
  private static final int STATE_READING_ATOM_HEADER = 0;
  private static final int STATE_READING_ATOM_PAYLOAD = 1;
  private static final int STATE_READING_ENCRYPTION_DATA = 2;
  private static final int STATE_READING_SAMPLE_CONTINUE = 4;
  private static final int STATE_READING_SAMPLE_START = 3;
  private static final String TAG = "FragmentedMp4Extractor";
  @Nullable
  private final TrackOutput additionalEmsgTrackOutput;
  private ParsableByteArray atomData;
  private final ParsableByteArray atomHeader;
  private int atomHeaderBytesRead;
  private long atomSize;
  private int atomType;
  private TrackOutput[] cea608TrackOutputs;
  private final List<Format> closedCaptionFormats;
  private final Stack<Atom.ContainerAtom> containerAtoms;
  private FragmentedMp4Extractor.TrackBundle currentTrackBundle;
  private final ParsableByteArray defaultInitializationVector;
  private long durationUs;
  private TrackOutput[] emsgTrackOutputs;
  private final ParsableByteArray encryptionSignalByte;
  private long endOfMdatPosition;
  private final byte[] extendedTypeScratch;
  private ExtractorOutput extractorOutput;
  private final int flags;
  private boolean haveOutputSeekMap;
  private final ParsableByteArray nalBuffer;
  private final ParsableByteArray nalPrefix;
  private final ParsableByteArray nalStartCode;
  private int parserState;
  private int pendingMetadataSampleBytes;
  private final ArrayDeque<FragmentedMp4Extractor.MetadataSampleInfo> pendingMetadataSampleInfos;
  private boolean processSeiNalUnitPayload;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private int sampleSize;
  private long segmentIndexEarliestPresentationTimeUs;
  private final DrmInitData sideloadedDrmInitData;
  private final Track sideloadedTrack;
  private final TimestampAdjuster timestampAdjuster;
  private final SparseArray<FragmentedMp4Extractor.TrackBundle> trackBundles;
  
  static
  {
    PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  }
  
  public FragmentedMp4Extractor()
  {
    this(0);
  }
  
  public FragmentedMp4Extractor(int paramInt)
  {
    this(paramInt, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster)
  {
    this(paramInt, paramTimestampAdjuster, null, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData)
  {
    this(paramInt, paramTimestampAdjuster, paramTrack, paramDrmInitData, Collections.emptyList());
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData, List<Format> paramList)
  {
    this(paramInt, paramTimestampAdjuster, paramTrack, paramDrmInitData, paramList, null);
  }
  
  public FragmentedMp4Extractor(int paramInt, TimestampAdjuster paramTimestampAdjuster, Track paramTrack, DrmInitData paramDrmInitData, List<Format> paramList, @Nullable TrackOutput paramTrackOutput)
  {
    int i;
    if (paramTrack != null) {
      i = 8;
    } else {
      i = 0;
    }
    this.flags = (paramInt | i);
    this.timestampAdjuster = paramTimestampAdjuster;
    this.sideloadedTrack = paramTrack;
    this.sideloadedDrmInitData = paramDrmInitData;
    this.closedCaptionFormats = Collections.unmodifiableList(paramList);
    this.additionalEmsgTrackOutput = paramTrackOutput;
    this.atomHeader = new ParsableByteArray(16);
    this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    this.nalPrefix = new ParsableByteArray(5);
    this.nalBuffer = new ParsableByteArray();
    this.encryptionSignalByte = new ParsableByteArray(1);
    this.defaultInitializationVector = new ParsableByteArray();
    this.extendedTypeScratch = new byte[16];
    this.containerAtoms = new Stack();
    this.pendingMetadataSampleInfos = new ArrayDeque();
    this.trackBundles = new SparseArray();
    this.durationUs = -9223372036854775807L;
    this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
    enterReadingAtomHeaderState();
  }
  
  private int appendSampleEncryptionData(FragmentedMp4Extractor.TrackBundle paramTrackBundle)
  {
    TrackFragment localTrackFragment = paramTrackBundle.fragment;
    int i = localTrackFragment.header.sampleDescriptionIndex;
    if (localTrackFragment.trackEncryptionBox != null) {
      localObject1 = localTrackFragment.trackEncryptionBox;
    } else {
      localObject1 = paramTrackBundle.track.getSampleDescriptionEncryptionBox(i);
    }
    if (((TrackEncryptionBox)localObject1).initializationVectorSize != 0)
    {
      localObject2 = localTrackFragment.sampleEncryptionData;
      i = ((TrackEncryptionBox)localObject1).initializationVectorSize;
      localObject1 = localObject2;
    }
    else
    {
      localObject2 = ((TrackEncryptionBox)localObject1).defaultInitializationVector;
      this.defaultInitializationVector.reset((byte[])localObject2, localObject2.length);
      localObject1 = this.defaultInitializationVector;
      i = localObject2.length;
    }
    int k = localTrackFragment.sampleHasSubsampleEncryptionTable[paramTrackBundle.currentSampleIndex];
    Object localObject2 = this.encryptionSignalByte.data;
    if (k != 0) {
      j = 128;
    } else {
      j = 0;
    }
    localObject2[0] = ((byte)(j | i));
    this.encryptionSignalByte.setPosition(0);
    paramTrackBundle = paramTrackBundle.output;
    paramTrackBundle.sampleData(this.encryptionSignalByte, 1);
    paramTrackBundle.sampleData((ParsableByteArray)localObject1, i);
    if (k == 0) {
      return i + 1;
    }
    Object localObject1 = localTrackFragment.sampleEncryptionData;
    int j = ((ParsableByteArray)localObject1).readUnsignedShort();
    ((ParsableByteArray)localObject1).skipBytes(-2);
    j = j * 6 + 2;
    paramTrackBundle.sampleData((ParsableByteArray)localObject1, j);
    return i + 1 + j;
  }
  
  private void enterReadingAtomHeaderState()
  {
    this.parserState = 0;
    this.atomHeaderBytesRead = 0;
  }
  
  private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> paramList)
  {
    int j = paramList.size();
    int i = 0;
    Object localObject1;
    for (Object localObject2 = null; i < j; localObject2 = localObject1)
    {
      Object localObject3 = (Atom.LeafAtom)paramList.get(i);
      localObject1 = localObject2;
      if (((Atom.LeafAtom)localObject3).type == Atom.TYPE_pssh)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((Atom.LeafAtom)localObject3).data.data;
        localObject3 = PsshAtomUtil.parseUuid((byte[])localObject2);
        if (localObject3 == null) {
          Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
        } else {
          ((ArrayList)localObject1).add(new DrmInitData.SchemeData((UUID)localObject3, "video/mp4", (byte[])localObject2));
        }
      }
      i += 1;
    }
    if (localObject2 == null) {
      return null;
    }
    return new DrmInitData((List)localObject2);
  }
  
  private static FragmentedMp4Extractor.TrackBundle getNextFragmentRun(SparseArray<FragmentedMp4Extractor.TrackBundle> paramSparseArray)
  {
    int j = paramSparseArray.size();
    Object localObject = null;
    long l1 = 9223372036854775807L;
    int i = 0;
    while (i < j)
    {
      FragmentedMp4Extractor.TrackBundle localTrackBundle = (FragmentedMp4Extractor.TrackBundle)paramSparseArray.valueAt(i);
      long l2;
      if (localTrackBundle.currentTrackRunIndex == localTrackBundle.fragment.trunCount)
      {
        l2 = l1;
      }
      else
      {
        long l3 = localTrackBundle.fragment.trunDataPosition[localTrackBundle.currentTrackRunIndex];
        l2 = l1;
        if (l3 < l1)
        {
          localObject = localTrackBundle;
          l2 = l3;
        }
      }
      i += 1;
      l1 = l2;
    }
    return localObject;
  }
  
  private void maybeInitExtraTracks()
  {
    Object localObject = this.emsgTrackOutputs;
    int k = 0;
    int i;
    if (localObject == null)
    {
      this.emsgTrackOutputs = new TrackOutput[2];
      localObject = this.additionalEmsgTrackOutput;
      if (localObject != null)
      {
        this.emsgTrackOutputs[0] = localObject;
        i = 1;
      }
      else
      {
        i = 0;
      }
      int j = i;
      if ((this.flags & 0x4) != 0)
      {
        this.emsgTrackOutputs[i] = this.extractorOutput.track(this.trackBundles.size(), 4);
        j = i + 1;
      }
      this.emsgTrackOutputs = ((TrackOutput[])Arrays.copyOf(this.emsgTrackOutputs, j));
      localObject = this.emsgTrackOutputs;
      j = localObject.length;
      i = 0;
      while (i < j)
      {
        localObject[i].format(EMSG_FORMAT);
        i += 1;
      }
    }
    if (this.cea608TrackOutputs == null)
    {
      this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
      i = k;
      while (i < this.cea608TrackOutputs.length)
      {
        localObject = this.extractorOutput.track(this.trackBundles.size() + 1 + i, 3);
        ((TrackOutput)localObject).format((Format)this.closedCaptionFormats.get(i));
        this.cea608TrackOutputs[i] = localObject;
        i += 1;
      }
    }
  }
  
  private void onContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
  {
    if (paramContainerAtom.type == Atom.TYPE_moov)
    {
      onMoovContainerAtomRead(paramContainerAtom);
      return;
    }
    if (paramContainerAtom.type == Atom.TYPE_moof)
    {
      onMoofContainerAtomRead(paramContainerAtom);
      return;
    }
    if (!this.containerAtoms.isEmpty()) {
      ((Atom.ContainerAtom)this.containerAtoms.peek()).add(paramContainerAtom);
    }
  }
  
  private void onEmsgLeafAtomRead(ParsableByteArray paramParsableByteArray)
  {
    TrackOutput[] arrayOfTrackOutput = this.emsgTrackOutputs;
    if (arrayOfTrackOutput != null)
    {
      if (arrayOfTrackOutput.length == 0) {
        return;
      }
      paramParsableByteArray.setPosition(12);
      int j = paramParsableByteArray.bytesLeft();
      paramParsableByteArray.readNullTerminatedString();
      paramParsableByteArray.readNullTerminatedString();
      long l = paramParsableByteArray.readUnsignedInt();
      l = Util.scaleLargeTimestamp(paramParsableByteArray.readUnsignedInt(), 1000000L, l);
      arrayOfTrackOutput = this.emsgTrackOutputs;
      int k = arrayOfTrackOutput.length;
      int i = 0;
      while (i < k)
      {
        TrackOutput localTrackOutput = arrayOfTrackOutput[i];
        paramParsableByteArray.setPosition(12);
        localTrackOutput.sampleData(paramParsableByteArray, j);
        i += 1;
      }
      if (this.segmentIndexEarliestPresentationTimeUs != -9223372036854775807L)
      {
        paramParsableByteArray = this.emsgTrackOutputs;
        k = paramParsableByteArray.length;
        i = 0;
        while (i < k)
        {
          paramParsableByteArray[i].sampleMetadata(this.segmentIndexEarliestPresentationTimeUs + l, 1, j, 0, null);
          i += 1;
        }
      }
      this.pendingMetadataSampleInfos.addLast(new FragmentedMp4Extractor.MetadataSampleInfo(l, j));
      this.pendingMetadataSampleBytes += j;
    }
  }
  
  private void onLeafAtomRead(Atom.LeafAtom paramLeafAtom, long paramLong)
  {
    if (!this.containerAtoms.isEmpty())
    {
      ((Atom.ContainerAtom)this.containerAtoms.peek()).add(paramLeafAtom);
      return;
    }
    if (paramLeafAtom.type == Atom.TYPE_sidx)
    {
      paramLeafAtom = parseSidx(paramLeafAtom.data, paramLong);
      this.segmentIndexEarliestPresentationTimeUs = ((Long)paramLeafAtom.first).longValue();
      this.extractorOutput.seekMap((SeekMap)paramLeafAtom.second);
      this.haveOutputSeekMap = true;
      return;
    }
    if (paramLeafAtom.type == Atom.TYPE_emsg) {
      onEmsgLeafAtomRead(paramLeafAtom.data);
    }
  }
  
  private void onMoofContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
  {
    parseMoof(paramContainerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
    if (this.sideloadedDrmInitData != null) {
      paramContainerAtom = null;
    } else {
      paramContainerAtom = getDrmInitDataFromAtoms(paramContainerAtom.leafChildren);
    }
    if (paramContainerAtom != null)
    {
      int j = this.trackBundles.size();
      int i = 0;
      while (i < j)
      {
        ((FragmentedMp4Extractor.TrackBundle)this.trackBundles.valueAt(i)).updateDrmInitData(paramContainerAtom);
        i += 1;
      }
    }
  }
  
  private void onMoovContainerAtomRead(Atom.ContainerAtom paramContainerAtom)
  {
    Object localObject1 = this.sideloadedTrack;
    boolean bool2 = true;
    int m = 0;
    int k = 0;
    boolean bool1;
    if (localObject1 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1, "Unexpected moov box.");
    localObject1 = this.sideloadedDrmInitData;
    if (localObject1 == null) {
      localObject1 = getDrmInitDataFromAtoms(paramContainerAtom.leafChildren);
    }
    Object localObject2 = paramContainerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
    SparseArray localSparseArray = new SparseArray();
    int j = ((Atom.ContainerAtom)localObject2).leafChildren.size();
    long l = -9223372036854775807L;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = (Atom.LeafAtom)((Atom.ContainerAtom)localObject2).leafChildren.get(i);
      if (((Atom.LeafAtom)localObject3).type == Atom.TYPE_trex)
      {
        localObject3 = parseTrex(((Atom.LeafAtom)localObject3).data);
        localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
      }
      else if (((Atom.LeafAtom)localObject3).type == Atom.TYPE_mehd)
      {
        l = parseMehd(((Atom.LeafAtom)localObject3).data);
      }
      i += 1;
    }
    localObject2 = new SparseArray();
    i = paramContainerAtom.containerChildren.size();
    j = 0;
    while (j < i)
    {
      localObject3 = (Atom.ContainerAtom)paramContainerAtom.containerChildren.get(j);
      if (((Atom.ContainerAtom)localObject3).type == Atom.TYPE_trak)
      {
        Atom.LeafAtom localLeafAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
        if ((this.flags & 0x10) != 0) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject3 = AtomParsers.parseTrak((Atom.ContainerAtom)localObject3, localLeafAtom, l, (DrmInitData)localObject1, bool1, false);
        if (localObject3 != null) {
          ((SparseArray)localObject2).put(((Track)localObject3).id, localObject3);
        }
      }
      j += 1;
    }
    j = ((SparseArray)localObject2).size();
    if (this.trackBundles.size() == 0)
    {
      i = k;
      while (i < j)
      {
        paramContainerAtom = (Track)((SparseArray)localObject2).valueAt(i);
        localObject1 = new FragmentedMp4Extractor.TrackBundle(this.extractorOutput.track(i, paramContainerAtom.type));
        ((FragmentedMp4Extractor.TrackBundle)localObject1).init(paramContainerAtom, (DefaultSampleValues)localSparseArray.get(paramContainerAtom.id));
        this.trackBundles.put(paramContainerAtom.id, localObject1);
        this.durationUs = Math.max(this.durationUs, paramContainerAtom.durationUs);
        i += 1;
      }
      maybeInitExtraTracks();
      this.extractorOutput.endTracks();
      return;
    }
    if (this.trackBundles.size() == j) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkState(bool1);
    i = m;
    while (i < j)
    {
      paramContainerAtom = (Track)((SparseArray)localObject2).valueAt(i);
      ((FragmentedMp4Extractor.TrackBundle)this.trackBundles.get(paramContainerAtom.id)).init(paramContainerAtom, (DefaultSampleValues)localSparseArray.get(paramContainerAtom.id));
      i += 1;
    }
  }
  
  private void outputPendingMetadataSamples(long paramLong)
  {
    if (!this.pendingMetadataSampleInfos.isEmpty())
    {
      FragmentedMp4Extractor.MetadataSampleInfo localMetadataSampleInfo = (FragmentedMp4Extractor.MetadataSampleInfo)this.pendingMetadataSampleInfos.removeFirst();
      this.pendingMetadataSampleBytes -= localMetadataSampleInfo.size;
      TrackOutput[] arrayOfTrackOutput = this.emsgTrackOutputs;
      int j = arrayOfTrackOutput.length;
      int i = 0;
      while (i < j)
      {
        arrayOfTrackOutput[i].sampleMetadata(localMetadataSampleInfo.presentationTimeDeltaUs + paramLong, 1, localMetadataSampleInfo.size, this.pendingMetadataSampleBytes, null);
        i += 1;
      }
    }
  }
  
  private static long parseMehd(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) == 0) {
      return paramParsableByteArray.readUnsignedInt();
    }
    return paramParsableByteArray.readUnsignedLongToLong();
  }
  
  private static void parseMoof(Atom.ContainerAtom paramContainerAtom, SparseArray<FragmentedMp4Extractor.TrackBundle> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    int j = paramContainerAtom.containerChildren.size();
    int i = 0;
    while (i < j)
    {
      Atom.ContainerAtom localContainerAtom = (Atom.ContainerAtom)paramContainerAtom.containerChildren.get(i);
      if (localContainerAtom.type == Atom.TYPE_traf) {
        parseTraf(localContainerAtom, paramSparseArray, paramInt, paramArrayOfByte);
      }
      i += 1;
    }
  }
  
  private static void parseSaio(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
  {
    paramParsableByteArray.setPosition(8);
    int i = paramParsableByteArray.readInt();
    if ((Atom.parseFullAtomFlags(i) & 0x1) == 1) {
      paramParsableByteArray.skipBytes(8);
    }
    int j = paramParsableByteArray.readUnsignedIntToInt();
    if (j == 1)
    {
      i = Atom.parseFullAtomVersion(i);
      long l2 = paramTrackFragment.auxiliaryDataPosition;
      long l1;
      if (i == 0) {
        l1 = paramParsableByteArray.readUnsignedInt();
      } else {
        l1 = paramParsableByteArray.readUnsignedLongToLong();
      }
      paramTrackFragment.auxiliaryDataPosition = (l2 + l1);
      return;
    }
    paramParsableByteArray = new StringBuilder();
    paramParsableByteArray.append("Unexpected saio entry count: ");
    paramParsableByteArray.append(j);
    throw new ParserException(paramParsableByteArray.toString());
  }
  
  private static void parseSaiz(TrackEncryptionBox paramTrackEncryptionBox, ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
  {
    int m = paramTrackEncryptionBox.initializationVectorSize;
    paramParsableByteArray.setPosition(8);
    int i = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    boolean bool = true;
    if ((i & 0x1) == 1) {
      paramParsableByteArray.skipBytes(8);
    }
    i = paramParsableByteArray.readUnsignedByte();
    int n = paramParsableByteArray.readUnsignedIntToInt();
    if (n == paramTrackFragment.sampleCount)
    {
      if (i == 0)
      {
        paramTrackEncryptionBox = paramTrackFragment.sampleHasSubsampleEncryptionTable;
        int j = 0;
        i = 0;
        for (;;)
        {
          k = i;
          if (j >= n) {
            break;
          }
          k = paramParsableByteArray.readUnsignedByte();
          i += k;
          if (k > m) {
            bool = true;
          } else {
            bool = false;
          }
          paramTrackEncryptionBox[j] = bool;
          j += 1;
        }
      }
      if (i <= m) {
        bool = false;
      }
      int k = i * n + 0;
      Arrays.fill(paramTrackFragment.sampleHasSubsampleEncryptionTable, 0, n, bool);
      paramTrackFragment.initEncryptionData(k);
      return;
    }
    paramTrackEncryptionBox = new StringBuilder();
    paramTrackEncryptionBox.append("Length mismatch: ");
    paramTrackEncryptionBox.append(n);
    paramTrackEncryptionBox.append(", ");
    paramTrackEncryptionBox.append(paramTrackFragment.sampleCount);
    paramTrackEncryptionBox = new ParserException(paramTrackEncryptionBox.toString());
    for (;;)
    {
      throw paramTrackEncryptionBox;
    }
  }
  
  private static void parseSenc(ParsableByteArray paramParsableByteArray, int paramInt, TrackFragment paramTrackFragment)
  {
    paramParsableByteArray.setPosition(paramInt + 8);
    paramInt = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    if ((paramInt & 0x1) == 0)
    {
      boolean bool;
      if ((paramInt & 0x2) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramInt = paramParsableByteArray.readUnsignedIntToInt();
      if (paramInt == paramTrackFragment.sampleCount)
      {
        Arrays.fill(paramTrackFragment.sampleHasSubsampleEncryptionTable, 0, paramInt, bool);
        paramTrackFragment.initEncryptionData(paramParsableByteArray.bytesLeft());
        paramTrackFragment.fillEncryptionData(paramParsableByteArray);
        return;
      }
      paramParsableByteArray = new StringBuilder();
      paramParsableByteArray.append("Length mismatch: ");
      paramParsableByteArray.append(paramInt);
      paramParsableByteArray.append(", ");
      paramParsableByteArray.append(paramTrackFragment.sampleCount);
      throw new ParserException(paramParsableByteArray.toString());
    }
    throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
  }
  
  private static void parseSenc(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment)
  {
    parseSenc(paramParsableByteArray, 0, paramTrackFragment);
  }
  
  private static void parseSgpd(ParsableByteArray paramParsableByteArray1, ParsableByteArray paramParsableByteArray2, String paramString, TrackFragment paramTrackFragment)
  {
    paramParsableByteArray1.setPosition(8);
    int i = paramParsableByteArray1.readInt();
    if (paramParsableByteArray1.readInt() != SAMPLE_GROUP_TYPE_seig) {
      return;
    }
    if (Atom.parseFullAtomVersion(i) == 1) {
      paramParsableByteArray1.skipBytes(4);
    }
    if (paramParsableByteArray1.readInt() == 1)
    {
      paramParsableByteArray2.setPosition(8);
      i = paramParsableByteArray2.readInt();
      if (paramParsableByteArray2.readInt() != SAMPLE_GROUP_TYPE_seig) {
        return;
      }
      i = Atom.parseFullAtomVersion(i);
      if (i == 1)
      {
        if (paramParsableByteArray2.readUnsignedInt() == 0L) {
          throw new ParserException("Variable length description in sgpd found (unsupported)");
        }
      }
      else if (i >= 2) {
        paramParsableByteArray2.skipBytes(4);
      }
      if (paramParsableByteArray2.readUnsignedInt() == 1L)
      {
        paramParsableByteArray2.skipBytes(1);
        i = paramParsableByteArray2.readUnsignedByte();
        boolean bool;
        if (paramParsableByteArray2.readUnsignedByte() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        if (!bool) {
          return;
        }
        int j = paramParsableByteArray2.readUnsignedByte();
        byte[] arrayOfByte = new byte[16];
        paramParsableByteArray2.readBytes(arrayOfByte, 0, arrayOfByte.length);
        if ((bool) && (j == 0))
        {
          int k = paramParsableByteArray2.readUnsignedByte();
          paramParsableByteArray1 = new byte[k];
          paramParsableByteArray2.readBytes(paramParsableByteArray1, 0, k);
        }
        else
        {
          paramParsableByteArray1 = null;
        }
        paramTrackFragment.definesEncryptionData = true;
        paramTrackFragment.trackEncryptionBox = new TrackEncryptionBox(bool, paramString, j, arrayOfByte, (i & 0xF0) >> 4, i & 0xF, paramParsableByteArray1);
        return;
      }
      throw new ParserException("Entry count in sgpd != 1 (unsupported).");
    }
    throw new ParserException("Entry count in sbgp != 1 (unsupported).");
  }
  
  private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray paramParsableByteArray, long paramLong)
  {
    paramParsableByteArray.setPosition(8);
    int i = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    paramParsableByteArray.skipBytes(4);
    long l4 = paramParsableByteArray.readUnsignedInt();
    if (i == 0)
    {
      l1 = paramParsableByteArray.readUnsignedInt();
      l2 = paramParsableByteArray.readUnsignedInt();
    }
    else
    {
      l1 = paramParsableByteArray.readUnsignedLongToLong();
      l2 = paramParsableByteArray.readUnsignedLongToLong();
    }
    paramLong += l2;
    long l3 = Util.scaleLargeTimestamp(l1, 1000000L, l4);
    paramParsableByteArray.skipBytes(2);
    i = paramParsableByteArray.readUnsignedShort();
    int[] arrayOfInt = new int[i];
    long[] arrayOfLong1 = new long[i];
    long[] arrayOfLong2 = new long[i];
    long[] arrayOfLong3 = new long[i];
    long l2 = l1;
    long l1 = l3;
    int j = 0;
    while (j < i)
    {
      int k = paramParsableByteArray.readInt();
      if ((k & 0x80000000) == 0)
      {
        long l5 = paramParsableByteArray.readUnsignedInt();
        arrayOfInt[j] = (k & 0x7FFFFFFF);
        arrayOfLong1[j] = paramLong;
        arrayOfLong3[j] = l1;
        l2 += l5;
        l1 = Util.scaleLargeTimestamp(l2, 1000000L, l4);
        arrayOfLong2[j] = (l1 - arrayOfLong3[j]);
        paramParsableByteArray.skipBytes(4);
        paramLong += arrayOfInt[j];
        j += 1;
      }
      else
      {
        throw new ParserException("Unhandled indirect reference");
      }
    }
    return Pair.create(Long.valueOf(l3), new ChunkIndex(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3));
  }
  
  private static long parseTfdt(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) == 1) {
      return paramParsableByteArray.readUnsignedLongToLong();
    }
    return paramParsableByteArray.readUnsignedInt();
  }
  
  private static FragmentedMp4Extractor.TrackBundle parseTfhd(ParsableByteArray paramParsableByteArray, SparseArray<FragmentedMp4Extractor.TrackBundle> paramSparseArray, int paramInt)
  {
    paramParsableByteArray.setPosition(8);
    int k = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    int i = paramParsableByteArray.readInt();
    if ((paramInt & 0x8) == 0) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    paramSparseArray = (FragmentedMp4Extractor.TrackBundle)paramSparseArray.get(paramInt);
    if (paramSparseArray == null) {
      return null;
    }
    if ((k & 0x1) != 0)
    {
      long l = paramParsableByteArray.readUnsignedLongToLong();
      paramSparseArray.fragment.dataPosition = l;
      paramSparseArray.fragment.auxiliaryDataPosition = l;
    }
    DefaultSampleValues localDefaultSampleValues = paramSparseArray.defaultSampleValues;
    if ((k & 0x2) != 0) {
      paramInt = paramParsableByteArray.readUnsignedIntToInt() - 1;
    } else {
      paramInt = localDefaultSampleValues.sampleDescriptionIndex;
    }
    if ((k & 0x8) != 0) {
      i = paramParsableByteArray.readUnsignedIntToInt();
    } else {
      i = localDefaultSampleValues.duration;
    }
    int j;
    if ((k & 0x10) != 0) {
      j = paramParsableByteArray.readUnsignedIntToInt();
    } else {
      j = localDefaultSampleValues.size;
    }
    if ((k & 0x20) != 0) {
      k = paramParsableByteArray.readUnsignedIntToInt();
    } else {
      k = localDefaultSampleValues.flags;
    }
    paramSparseArray.fragment.header = new DefaultSampleValues(paramInt, i, j, k);
    return paramSparseArray;
  }
  
  private static void parseTraf(Atom.ContainerAtom paramContainerAtom, SparseArray<FragmentedMp4Extractor.TrackBundle> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    paramSparseArray = parseTfhd(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, paramSparseArray, paramInt);
    if (paramSparseArray == null) {
      return;
    }
    TrackFragment localTrackFragment = paramSparseArray.fragment;
    long l2 = localTrackFragment.nextFragmentDecodeTime;
    paramSparseArray.reset();
    long l1 = l2;
    if (paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfdt) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = parseTfdt(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tfdt).data);
      }
    }
    parseTruns(paramContainerAtom, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.track.getSampleDescriptionEncryptionBox(localTrackFragment.header.sampleDescriptionIndex);
    Object localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
    if (localObject1 != null) {
      parseSaiz(paramSparseArray, ((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_saio);
    if (localObject1 != null) {
      parseSaio(((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_senc);
    if (localObject1 != null) {
      parseSenc(((Atom.LeafAtom)localObject1).data, localTrackFragment);
    }
    localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
    Object localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((Atom.LeafAtom)localObject1).data;
      localObject2 = ((Atom.LeafAtom)localObject2).data;
      if (paramSparseArray != null) {
        paramSparseArray = paramSparseArray.schemeType;
      } else {
        paramSparseArray = null;
      }
      parseSgpd((ParsableByteArray)localObject1, (ParsableByteArray)localObject2, paramSparseArray, localTrackFragment);
    }
    int i = paramContainerAtom.leafChildren.size();
    paramInt = 0;
    while (paramInt < i)
    {
      paramSparseArray = (Atom.LeafAtom)paramContainerAtom.leafChildren.get(paramInt);
      if (paramSparseArray.type == Atom.TYPE_uuid) {
        parseUuid(paramSparseArray.data, localTrackFragment, paramArrayOfByte);
      }
      paramInt += 1;
    }
  }
  
  private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(12);
    return Pair.create(Integer.valueOf(paramParsableByteArray.readInt()), new DefaultSampleValues(paramParsableByteArray.readUnsignedIntToInt() - 1, paramParsableByteArray.readUnsignedIntToInt(), paramParsableByteArray.readUnsignedIntToInt(), paramParsableByteArray.readInt()));
  }
  
  private static int parseTrun(FragmentedMp4Extractor.TrackBundle paramTrackBundle, int paramInt1, long paramLong, int paramInt2, ParsableByteArray paramParsableByteArray, int paramInt3)
  {
    paramParsableByteArray.setPosition(8);
    int n = Atom.parseFullAtomFlags(paramParsableByteArray.readInt());
    Track localTrack = paramTrackBundle.track;
    paramTrackBundle = paramTrackBundle.fragment;
    DefaultSampleValues localDefaultSampleValues = paramTrackBundle.header;
    paramTrackBundle.trunLength[paramInt1] = paramParsableByteArray.readUnsignedIntToInt();
    paramTrackBundle.trunDataPosition[paramInt1] = paramTrackBundle.dataPosition;
    if ((n & 0x1) != 0)
    {
      localObject = paramTrackBundle.trunDataPosition;
      localObject[paramInt1] += paramParsableByteArray.readInt();
    }
    int j;
    if ((n & 0x4) != 0) {
      j = 1;
    } else {
      j = 0;
    }
    int i = localDefaultSampleValues.flags;
    if (j != 0) {
      i = paramParsableByteArray.readUnsignedIntToInt();
    }
    int k;
    if ((n & 0x100) != 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if ((n & 0x200) != 0) {
      m = 1;
    } else {
      m = 0;
    }
    int i1;
    if ((n & 0x400) != 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((n & 0x800) != 0) {
      n = 1;
    } else {
      n = 0;
    }
    Object localObject = localTrack.editListDurations;
    long l2 = 0L;
    long l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localTrack.editListDurations.length == 1)
      {
        l1 = l2;
        if (localTrack.editListDurations[0] == 0L) {
          l1 = Util.scaleLargeTimestamp(localTrack.editListMediaTimes[0], 1000L, localTrack.timescale);
        }
      }
    }
    localObject = paramTrackBundle.sampleSizeTable;
    int[] arrayOfInt = paramTrackBundle.sampleCompositionTimeOffsetTable;
    long[] arrayOfLong = paramTrackBundle.sampleDecodingTimeTable;
    boolean[] arrayOfBoolean = paramTrackBundle.sampleIsSyncFrameTable;
    if ((localTrack.type == 2) && ((paramInt2 & 0x1) != 0)) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i3 = paramInt3 + paramTrackBundle.trunLength[paramInt1];
    l2 = localTrack.timescale;
    if (paramInt1 > 0) {
      paramLong = paramTrackBundle.nextFragmentDecodeTime;
    }
    int i2 = paramInt3;
    paramInt3 = i3;
    while (i2 < paramInt3)
    {
      if (k != 0) {
        i3 = paramParsableByteArray.readUnsignedIntToInt();
      } else {
        i3 = localDefaultSampleValues.duration;
      }
      int i4;
      if (m != 0) {
        i4 = paramParsableByteArray.readUnsignedIntToInt();
      } else {
        i4 = localDefaultSampleValues.size;
      }
      if ((i2 == 0) && (j != 0)) {
        paramInt1 = i;
      } else if (i1 != 0) {
        paramInt1 = paramParsableByteArray.readInt();
      } else {
        paramInt1 = localDefaultSampleValues.flags;
      }
      if (n != 0) {
        arrayOfInt[i2] = ((int)(paramParsableByteArray.readInt() * 1000L / l2));
      } else {
        arrayOfInt[i2] = 0;
      }
      arrayOfLong[i2] = (Util.scaleLargeTimestamp(paramLong, 1000L, l2) - l1);
      localObject[i2] = i4;
      int i5;
      if (((paramInt1 >> 16 & 0x1) == 0) && ((paramInt2 == 0) || (i2 == 0))) {
        i5 = 1;
      } else {
        i5 = 0;
      }
      arrayOfBoolean[i2] = i5;
      long l3 = i3;
      i2 += 1;
      paramLong += l3;
    }
    paramTrackBundle.nextFragmentDecodeTime = paramLong;
    return paramInt3;
  }
  
  private static void parseTruns(Atom.ContainerAtom paramContainerAtom, FragmentedMp4Extractor.TrackBundle paramTrackBundle, long paramLong, int paramInt)
  {
    paramContainerAtom = paramContainerAtom.leafChildren;
    int i2 = paramContainerAtom.size();
    int i1 = 0;
    int i = 0;
    int j = 0;
    Object localObject;
    int n;
    int m;
    for (int k = 0; i < i2; k = m)
    {
      localObject = (Atom.LeafAtom)paramContainerAtom.get(i);
      n = j;
      m = k;
      if (((Atom.LeafAtom)localObject).type == Atom.TYPE_trun)
      {
        localObject = ((Atom.LeafAtom)localObject).data;
        ((ParsableByteArray)localObject).setPosition(12);
        int i3 = ((ParsableByteArray)localObject).readUnsignedIntToInt();
        n = j;
        m = k;
        if (i3 > 0)
        {
          m = k + i3;
          n = j + 1;
        }
      }
      i += 1;
      j = n;
    }
    paramTrackBundle.currentTrackRunIndex = 0;
    paramTrackBundle.currentSampleInTrackRun = 0;
    paramTrackBundle.currentSampleIndex = 0;
    paramTrackBundle.fragment.initTables(j, k);
    j = 0;
    k = 0;
    i = i1;
    while (i < i2)
    {
      localObject = (Atom.LeafAtom)paramContainerAtom.get(i);
      n = j;
      m = k;
      if (((Atom.LeafAtom)localObject).type == Atom.TYPE_trun)
      {
        m = parseTrun(paramTrackBundle, j, paramLong, paramInt, ((Atom.LeafAtom)localObject).data, k);
        n = j + 1;
      }
      i += 1;
      j = n;
      k = m;
    }
  }
  
  private static void parseUuid(ParsableByteArray paramParsableByteArray, TrackFragment paramTrackFragment, byte[] paramArrayOfByte)
  {
    paramParsableByteArray.setPosition(8);
    paramParsableByteArray.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
      return;
    }
    parseSenc(paramParsableByteArray, 16, paramTrackFragment);
  }
  
  private void processAtomEnded(long paramLong)
  {
    while ((!this.containerAtoms.isEmpty()) && (((Atom.ContainerAtom)this.containerAtoms.peek()).endPosition == paramLong)) {
      onContainerAtomRead((Atom.ContainerAtom)this.containerAtoms.pop());
    }
    enterReadingAtomHeaderState();
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
      l1 = paramExtractorInput.getPosition() - this.atomHeaderBytesRead;
      if (this.atomType == Atom.TYPE_moof)
      {
        int j = this.trackBundles.size();
        int i = 0;
        while (i < j)
        {
          TrackFragment localTrackFragment = ((FragmentedMp4Extractor.TrackBundle)this.trackBundles.valueAt(i)).fragment;
          localTrackFragment.atomPosition = l1;
          localTrackFragment.auxiliaryDataPosition = l1;
          localTrackFragment.dataPosition = l1;
          i += 1;
        }
      }
      if (this.atomType == Atom.TYPE_mdat)
      {
        this.currentTrackBundle = null;
        this.endOfMdatPosition = (this.atomSize + l1);
        if (!this.haveOutputSeekMap)
        {
          this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, l1));
          this.haveOutputSeekMap = true;
        }
        this.parserState = 2;
        return true;
      }
      if (shouldParseContainerAtom(this.atomType))
      {
        l1 = paramExtractorInput.getPosition() + this.atomSize - 8L;
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
        if (this.atomHeaderBytesRead == 8)
        {
          l1 = this.atomSize;
          if (l1 <= 2147483647L)
          {
            this.atomData = new ParsableByteArray((int)l1);
            System.arraycopy(this.atomHeader.data, 0, this.atomData.data, 0, 8);
            this.parserState = 1;
            return true;
          }
          throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
        }
        throw new ParserException("Leaf atom defines extended atom size (unsupported).");
      }
      if (this.atomSize <= 2147483647L)
      {
        this.atomData = null;
        this.parserState = 1;
        return true;
      }
      throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
    }
    paramExtractorInput = new ParserException("Atom size less than header length (unsupported).");
    for (;;)
    {
      throw paramExtractorInput;
    }
  }
  
  private void readAtomPayload(ExtractorInput paramExtractorInput)
  {
    int i = (int)this.atomSize - this.atomHeaderBytesRead;
    ParsableByteArray localParsableByteArray = this.atomData;
    if (localParsableByteArray != null)
    {
      paramExtractorInput.readFully(localParsableByteArray.data, 8, i);
      onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), paramExtractorInput.getPosition());
    }
    else
    {
      paramExtractorInput.skipFully(i);
    }
    processAtomEnded(paramExtractorInput.getPosition());
  }
  
  private void readEncryptionData(ExtractorInput paramExtractorInput)
  {
    int j = this.trackBundles.size();
    Object localObject1 = null;
    long l1 = 9223372036854775807L;
    int i = 0;
    while (i < j)
    {
      TrackFragment localTrackFragment = ((FragmentedMp4Extractor.TrackBundle)this.trackBundles.valueAt(i)).fragment;
      Object localObject2 = localObject1;
      long l2 = l1;
      if (localTrackFragment.sampleEncryptionDataNeedsFill)
      {
        localObject2 = localObject1;
        l2 = l1;
        if (localTrackFragment.auxiliaryDataPosition < l1)
        {
          l2 = localTrackFragment.auxiliaryDataPosition;
          localObject2 = (FragmentedMp4Extractor.TrackBundle)this.trackBundles.valueAt(i);
        }
      }
      i += 1;
      localObject1 = localObject2;
      l1 = l2;
    }
    if (localObject1 == null)
    {
      this.parserState = 3;
      return;
    }
    i = (int)(l1 - paramExtractorInput.getPosition());
    if (i >= 0)
    {
      paramExtractorInput.skipFully(i);
      localObject1.fragment.fillEncryptionData(paramExtractorInput);
      return;
    }
    paramExtractorInput = new ParserException("Offset to encryption data was negative.");
    for (;;)
    {
      throw paramExtractorInput;
    }
  }
  
  private boolean readSample(ExtractorInput paramExtractorInput)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static boolean shouldParseContainerAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_moov) || (paramInt == Atom.TYPE_trak) || (paramInt == Atom.TYPE_mdia) || (paramInt == Atom.TYPE_minf) || (paramInt == Atom.TYPE_stbl) || (paramInt == Atom.TYPE_moof) || (paramInt == Atom.TYPE_traf) || (paramInt == Atom.TYPE_mvex) || (paramInt == Atom.TYPE_edts);
  }
  
  private static boolean shouldParseLeafAtom(int paramInt)
  {
    return (paramInt == Atom.TYPE_hdlr) || (paramInt == Atom.TYPE_mdhd) || (paramInt == Atom.TYPE_mvhd) || (paramInt == Atom.TYPE_sidx) || (paramInt == Atom.TYPE_stsd) || (paramInt == Atom.TYPE_tfdt) || (paramInt == Atom.TYPE_tfhd) || (paramInt == Atom.TYPE_tkhd) || (paramInt == Atom.TYPE_trex) || (paramInt == Atom.TYPE_trun) || (paramInt == Atom.TYPE_pssh) || (paramInt == Atom.TYPE_saiz) || (paramInt == Atom.TYPE_saio) || (paramInt == Atom.TYPE_senc) || (paramInt == Atom.TYPE_uuid) || (paramInt == Atom.TYPE_sbgp) || (paramInt == Atom.TYPE_sgpd) || (paramInt == Atom.TYPE_elst) || (paramInt == Atom.TYPE_mehd) || (paramInt == Atom.TYPE_emsg);
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
    Track localTrack = this.sideloadedTrack;
    if (localTrack != null)
    {
      paramExtractorOutput = new FragmentedMp4Extractor.TrackBundle(paramExtractorOutput.track(0, localTrack.type));
      paramExtractorOutput.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
      this.trackBundles.put(0, paramExtractorOutput);
      maybeInitExtraTracks();
      this.extractorOutput.endTracks();
    }
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    do
    {
      for (;;)
      {
        int i = this.parserState;
        if (i == 0) {
          break;
        }
        if (i != 1)
        {
          if (i != 2)
          {
            if (readSample(paramExtractorInput)) {
              return 0;
            }
          }
          else {
            readEncryptionData(paramExtractorInput);
          }
        }
        else {
          readAtomPayload(paramExtractorInput);
        }
      }
    } while (readAtomHeader(paramExtractorInput));
    return -1;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    int j = this.trackBundles.size();
    int i = 0;
    while (i < j)
    {
      ((FragmentedMp4Extractor.TrackBundle)this.trackBundles.valueAt(i)).reset();
      i += 1;
    }
    this.pendingMetadataSampleInfos.clear();
    this.pendingMetadataSampleBytes = 0;
    this.containerAtoms.clear();
    enterReadingAtomHeaderState();
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    return Sniffer.sniffFragmented(paramExtractorInput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
 * JD-Core Version:    0.7.0.1
 */