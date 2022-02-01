package com.google.android.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
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
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

public final class MatroskaExtractor
  implements Extractor
{
  private static final int BLOCK_STATE_DATA = 2;
  private static final int BLOCK_STATE_HEADER = 1;
  private static final int BLOCK_STATE_START = 0;
  private static final String CODEC_ID_AAC = "A_AAC";
  private static final String CODEC_ID_AC3 = "A_AC3";
  private static final String CODEC_ID_ACM = "A_MS/ACM";
  private static final String CODEC_ID_ASS = "S_TEXT/ASS";
  private static final String CODEC_ID_DTS = "A_DTS";
  private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
  private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
  private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
  private static final String CODEC_ID_E_AC3 = "A_EAC3";
  private static final String CODEC_ID_FLAC = "A_FLAC";
  private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
  private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
  private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
  private static final String CODEC_ID_MP2 = "A_MPEG/L2";
  private static final String CODEC_ID_MP3 = "A_MPEG/L3";
  private static final String CODEC_ID_MPEG2 = "V_MPEG2";
  private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
  private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
  private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
  private static final String CODEC_ID_OPUS = "A_OPUS";
  private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
  private static final String CODEC_ID_PGS = "S_HDMV/PGS";
  private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
  private static final String CODEC_ID_THEORA = "V_THEORA";
  private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
  private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
  private static final String CODEC_ID_VORBIS = "A_VORBIS";
  private static final String CODEC_ID_VP8 = "V_VP8";
  private static final String CODEC_ID_VP9 = "V_VP9";
  private static final String DOC_TYPE_MATROSKA = "matroska";
  private static final String DOC_TYPE_WEBM = "webm";
  private static final int ENCRYPTION_IV_SIZE = 8;
  public static final ExtractorsFactory FACTORY = new MatroskaExtractor.1();
  public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
  private static final int FOURCC_COMPRESSION_VC1 = 826496599;
  private static final int ID_AUDIO = 225;
  private static final int ID_AUDIO_BIT_DEPTH = 25188;
  private static final int ID_BLOCK = 161;
  private static final int ID_BLOCK_DURATION = 155;
  private static final int ID_BLOCK_GROUP = 160;
  private static final int ID_CHANNELS = 159;
  private static final int ID_CLUSTER = 524531317;
  private static final int ID_CODEC_DELAY = 22186;
  private static final int ID_CODEC_ID = 134;
  private static final int ID_CODEC_PRIVATE = 25506;
  private static final int ID_COLOUR = 21936;
  private static final int ID_COLOUR_PRIMARIES = 21947;
  private static final int ID_COLOUR_RANGE = 21945;
  private static final int ID_COLOUR_TRANSFER = 21946;
  private static final int ID_CONTENT_COMPRESSION = 20532;
  private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
  private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
  private static final int ID_CONTENT_ENCODING = 25152;
  private static final int ID_CONTENT_ENCODINGS = 28032;
  private static final int ID_CONTENT_ENCODING_ORDER = 20529;
  private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
  private static final int ID_CONTENT_ENCRYPTION = 20533;
  private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
  private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
  private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
  private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
  private static final int ID_CUES = 475249515;
  private static final int ID_CUE_CLUSTER_POSITION = 241;
  private static final int ID_CUE_POINT = 187;
  private static final int ID_CUE_TIME = 179;
  private static final int ID_CUE_TRACK_POSITIONS = 183;
  private static final int ID_DEFAULT_DURATION = 2352003;
  private static final int ID_DISPLAY_HEIGHT = 21690;
  private static final int ID_DISPLAY_UNIT = 21682;
  private static final int ID_DISPLAY_WIDTH = 21680;
  private static final int ID_DOC_TYPE = 17026;
  private static final int ID_DOC_TYPE_READ_VERSION = 17029;
  private static final int ID_DURATION = 17545;
  private static final int ID_EBML = 440786851;
  private static final int ID_EBML_READ_VERSION = 17143;
  private static final int ID_FLAG_DEFAULT = 136;
  private static final int ID_FLAG_FORCED = 21930;
  private static final int ID_INFO = 357149030;
  private static final int ID_LANGUAGE = 2274716;
  private static final int ID_LUMNINANCE_MAX = 21977;
  private static final int ID_LUMNINANCE_MIN = 21978;
  private static final int ID_MASTERING_METADATA = 21968;
  private static final int ID_MAX_CLL = 21948;
  private static final int ID_MAX_FALL = 21949;
  private static final int ID_PIXEL_HEIGHT = 186;
  private static final int ID_PIXEL_WIDTH = 176;
  private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
  private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
  private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
  private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
  private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
  private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
  private static final int ID_PROJECTION = 30320;
  private static final int ID_PROJECTION_PRIVATE = 30322;
  private static final int ID_REFERENCE_BLOCK = 251;
  private static final int ID_SAMPLING_FREQUENCY = 181;
  private static final int ID_SEEK = 19899;
  private static final int ID_SEEK_HEAD = 290298740;
  private static final int ID_SEEK_ID = 21419;
  private static final int ID_SEEK_POSITION = 21420;
  private static final int ID_SEEK_PRE_ROLL = 22203;
  private static final int ID_SEGMENT = 408125543;
  private static final int ID_SEGMENT_INFO = 357149030;
  private static final int ID_SIMPLE_BLOCK = 163;
  private static final int ID_STEREO_MODE = 21432;
  private static final int ID_TIMECODE_SCALE = 2807729;
  private static final int ID_TIME_CODE = 231;
  private static final int ID_TRACKS = 374648427;
  private static final int ID_TRACK_ENTRY = 174;
  private static final int ID_TRACK_NUMBER = 215;
  private static final int ID_TRACK_TYPE = 131;
  private static final int ID_VIDEO = 224;
  private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
  private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
  private static final int LACING_EBML = 3;
  private static final int LACING_FIXED_SIZE = 2;
  private static final int LACING_NONE = 0;
  private static final int LACING_XIPH = 1;
  private static final int OPUS_MAX_INPUT_SIZE = 5760;
  private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
  private static final byte[] SSA_PREFIX = { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
  private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
  private static final byte[] SSA_TIMECODE_EMPTY = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
  private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000L;
  private static final byte[] SUBRIP_PREFIX = { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
  private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
  private static final byte[] SUBRIP_TIMECODE_EMPTY = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
  private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
  private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000L;
  private static final String TAG = "MatroskaExtractor";
  private static final int TRACK_TYPE_AUDIO = 2;
  private static final int UNSET_ENTRY_ID = -1;
  private static final int VORBIS_MAX_INPUT_SIZE = 8192;
  private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
  private static final int WAVE_FORMAT_PCM = 1;
  private static final int WAVE_FORMAT_SIZE = 18;
  private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);
  private long blockDurationUs;
  private int blockFlags;
  private int blockLacingSampleCount;
  private int blockLacingSampleIndex;
  private int[] blockLacingSampleSizes;
  private int blockState;
  private long blockTimeUs;
  private int blockTrackNumber;
  private int blockTrackNumberLength;
  private long clusterTimecodeUs = -9223372036854775807L;
  private LongArray cueClusterPositions;
  private LongArray cueTimesUs;
  private long cuesContentPosition = -1L;
  private MatroskaExtractor.Track currentTrack;
  private long durationTimecode = -9223372036854775807L;
  private long durationUs = -9223372036854775807L;
  private final ParsableByteArray encryptionInitializationVector;
  private final ParsableByteArray encryptionSubsampleData;
  private ByteBuffer encryptionSubsampleDataBuffer;
  private ExtractorOutput extractorOutput;
  private final ParsableByteArray nalLength;
  private final ParsableByteArray nalStartCode;
  private final EbmlReader reader;
  private int sampleBytesRead;
  private int sampleBytesWritten;
  private int sampleCurrentNalBytesRemaining;
  private boolean sampleEncodingHandled;
  private boolean sampleInitializationVectorRead;
  private int samplePartitionCount;
  private boolean samplePartitionCountRead;
  private boolean sampleRead;
  private boolean sampleSeenReferenceBlock;
  private byte sampleSignalByte;
  private boolean sampleSignalByteRead;
  private final ParsableByteArray sampleStrippedBytes;
  private final ParsableByteArray scratch;
  private int seekEntryId;
  private final ParsableByteArray seekEntryIdBytes;
  private long seekEntryPosition;
  private boolean seekForCues;
  private final boolean seekForCuesEnabled;
  private long seekPositionAfterBuildingCues = -1L;
  private boolean seenClusterPositionForCurrentCuePoint;
  private long segmentContentPosition = -1L;
  private long segmentContentSize;
  private boolean sentSeekMap;
  private final ParsableByteArray subtitleSample;
  private long timecodeScale = -9223372036854775807L;
  private final SparseArray<MatroskaExtractor.Track> tracks;
  private final VarintReader varintReader;
  private final ParsableByteArray vorbisNumPageSamples;
  
  public MatroskaExtractor()
  {
    this(0);
  }
  
  public MatroskaExtractor(int paramInt)
  {
    this(new DefaultEbmlReader(), paramInt);
  }
  
  MatroskaExtractor(EbmlReader paramEbmlReader, int paramInt)
  {
    this.reader = paramEbmlReader;
    this.reader.init(new MatroskaExtractor.InnerEbmlReaderOutput(this, null));
    boolean bool = true;
    if ((paramInt & 0x1) != 0) {
      bool = false;
    }
    this.seekForCuesEnabled = bool;
    this.varintReader = new VarintReader();
    this.tracks = new SparseArray();
    this.scratch = new ParsableByteArray(4);
    this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
    this.seekEntryIdBytes = new ParsableByteArray(4);
    this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
    this.nalLength = new ParsableByteArray(4);
    this.sampleStrippedBytes = new ParsableByteArray();
    this.subtitleSample = new ParsableByteArray();
    this.encryptionInitializationVector = new ParsableByteArray(8);
    this.encryptionSubsampleData = new ParsableByteArray();
  }
  
  private SeekMap buildSeekMap()
  {
    if ((this.segmentContentPosition != -1L) && (this.durationUs != -9223372036854775807L))
    {
      Object localObject = this.cueTimesUs;
      if ((localObject != null) && (((LongArray)localObject).size() != 0))
      {
        localObject = this.cueClusterPositions;
        if ((localObject != null) && (((LongArray)localObject).size() == this.cueTimesUs.size()))
        {
          int m = this.cueTimesUs.size();
          localObject = new int[m];
          long[] arrayOfLong1 = new long[m];
          long[] arrayOfLong2 = new long[m];
          long[] arrayOfLong3 = new long[m];
          int k = 0;
          int j = 0;
          int i;
          for (;;)
          {
            i = k;
            if (j >= m) {
              break;
            }
            arrayOfLong3[j] = this.cueTimesUs.get(j);
            arrayOfLong1[j] = (this.segmentContentPosition + this.cueClusterPositions.get(j));
            j += 1;
          }
          for (;;)
          {
            j = m - 1;
            if (i >= j) {
              break;
            }
            j = i + 1;
            localObject[i] = ((int)(arrayOfLong1[j] - arrayOfLong1[i]));
            arrayOfLong3[j] -= arrayOfLong3[i];
            i = j;
          }
          localObject[j] = ((int)(this.segmentContentPosition + this.segmentContentSize - arrayOfLong1[j]));
          arrayOfLong2[j] = (this.durationUs - arrayOfLong3[j]);
          this.cueTimesUs = null;
          this.cueClusterPositions = null;
          return new ChunkIndex((int[])localObject, arrayOfLong1, arrayOfLong2, arrayOfLong3);
        }
      }
    }
    this.cueTimesUs = null;
    this.cueClusterPositions = null;
    return new SeekMap.Unseekable(this.durationUs);
  }
  
  private void commitSampleToOutput(MatroskaExtractor.Track paramTrack, long paramLong)
  {
    if (paramTrack.trueHdSampleRechunker != null)
    {
      paramTrack.trueHdSampleRechunker.sampleMetadata(paramTrack, paramLong);
    }
    else
    {
      if ("S_TEXT/UTF8".equals(paramTrack.codecId)) {
        commitSubtitleSample(paramTrack, "%02d:%02d:%02d,%03d", 19, 1000L, SUBRIP_TIMECODE_EMPTY);
      } else if ("S_TEXT/ASS".equals(paramTrack.codecId)) {
        commitSubtitleSample(paramTrack, "%01d:%02d:%02d:%02d", 21, 10000L, SSA_TIMECODE_EMPTY);
      }
      paramTrack.output.sampleMetadata(paramLong, this.blockFlags, this.sampleBytesWritten, 0, paramTrack.cryptoData);
    }
    this.sampleRead = true;
    resetSample();
  }
  
  private void commitSubtitleSample(MatroskaExtractor.Track paramTrack, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    setSampleDuration(this.subtitleSample.data, this.blockDurationUs, paramString, paramInt, paramLong, paramArrayOfByte);
    paramTrack = paramTrack.output;
    paramString = this.subtitleSample;
    paramTrack.sampleData(paramString, paramString.limit());
    this.sampleBytesWritten += this.subtitleSample.limit();
  }
  
  private static int[] ensureArrayCapacity(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {
      return new int[paramInt];
    }
    if (paramArrayOfInt.length >= paramInt) {
      return paramArrayOfInt;
    }
    return new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
  }
  
  private static boolean isCodecSupported(String paramString)
  {
    return ("V_VP8".equals(paramString)) || ("V_VP9".equals(paramString)) || ("V_MPEG2".equals(paramString)) || ("V_MPEG4/ISO/SP".equals(paramString)) || ("V_MPEG4/ISO/ASP".equals(paramString)) || ("V_MPEG4/ISO/AP".equals(paramString)) || ("V_MPEG4/ISO/AVC".equals(paramString)) || ("V_MPEGH/ISO/HEVC".equals(paramString)) || ("V_MS/VFW/FOURCC".equals(paramString)) || ("V_THEORA".equals(paramString)) || ("A_OPUS".equals(paramString)) || ("A_VORBIS".equals(paramString)) || ("A_AAC".equals(paramString)) || ("A_MPEG/L2".equals(paramString)) || ("A_MPEG/L3".equals(paramString)) || ("A_AC3".equals(paramString)) || ("A_EAC3".equals(paramString)) || ("A_TRUEHD".equals(paramString)) || ("A_DTS".equals(paramString)) || ("A_DTS/EXPRESS".equals(paramString)) || ("A_DTS/LOSSLESS".equals(paramString)) || ("A_FLAC".equals(paramString)) || ("A_MS/ACM".equals(paramString)) || ("A_PCM/INT/LIT".equals(paramString)) || ("S_TEXT/UTF8".equals(paramString)) || ("S_TEXT/ASS".equals(paramString)) || ("S_VOBSUB".equals(paramString)) || ("S_HDMV/PGS".equals(paramString)) || ("S_DVBSUB".equals(paramString));
  }
  
  private boolean maybeSeekForCues(PositionHolder paramPositionHolder, long paramLong)
  {
    if (this.seekForCues)
    {
      this.seekPositionAfterBuildingCues = paramLong;
      paramPositionHolder.position = this.cuesContentPosition;
      this.seekForCues = false;
      return true;
    }
    if (this.sentSeekMap)
    {
      paramLong = this.seekPositionAfterBuildingCues;
      if (paramLong != -1L)
      {
        paramPositionHolder.position = paramLong;
        this.seekPositionAfterBuildingCues = -1L;
        return true;
      }
    }
    return false;
  }
  
  private void readScratch(ExtractorInput paramExtractorInput, int paramInt)
  {
    if (this.scratch.limit() >= paramInt) {
      return;
    }
    if (this.scratch.capacity() < paramInt)
    {
      ParsableByteArray localParsableByteArray = this.scratch;
      localParsableByteArray.reset(Arrays.copyOf(localParsableByteArray.data, Math.max(this.scratch.data.length * 2, paramInt)), this.scratch.limit());
    }
    paramExtractorInput.readFully(this.scratch.data, this.scratch.limit(), paramInt - this.scratch.limit());
    this.scratch.setLimit(paramInt);
  }
  
  private int readToOutput(ExtractorInput paramExtractorInput, TrackOutput paramTrackOutput, int paramInt)
  {
    int i = this.sampleStrippedBytes.bytesLeft();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramTrackOutput.sampleData(this.sampleStrippedBytes, paramInt);
    }
    else
    {
      paramInt = paramTrackOutput.sampleData(paramExtractorInput, paramInt, false);
    }
    this.sampleBytesRead += paramInt;
    this.sampleBytesWritten += paramInt;
    return paramInt;
  }
  
  private void readToTarget(ExtractorInput paramExtractorInput, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = Math.min(paramInt2, this.sampleStrippedBytes.bytesLeft());
    paramExtractorInput.readFully(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
    if (i > 0) {
      this.sampleStrippedBytes.readBytes(paramArrayOfByte, paramInt1, i);
    }
    this.sampleBytesRead += paramInt2;
  }
  
  private void resetSample()
  {
    this.sampleBytesRead = 0;
    this.sampleBytesWritten = 0;
    this.sampleCurrentNalBytesRemaining = 0;
    this.sampleEncodingHandled = false;
    this.sampleSignalByteRead = false;
    this.samplePartitionCountRead = false;
    this.samplePartitionCount = 0;
    this.sampleSignalByte = 0;
    this.sampleInitializationVectorRead = false;
    this.sampleStrippedBytes.reset();
  }
  
  private long scaleTimecodeToUs(long paramLong)
  {
    long l = this.timecodeScale;
    if (l != -9223372036854775807L) {
      return Util.scaleLargeTimestamp(paramLong, l, 1000L);
    }
    throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
  }
  
  private static void setSampleDuration(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    if (paramLong1 == -9223372036854775807L)
    {
      paramString = paramArrayOfByte2;
    }
    else
    {
      int i = (int)(paramLong1 / 3600000000L);
      paramLong1 -= i * 3600 * 1000000L;
      int j = (int)(paramLong1 / 60000000L);
      paramLong1 -= j * 60 * 1000000L;
      int k = (int)(paramLong1 / 1000000L);
      int m = (int)((paramLong1 - k * 1000000L) / paramLong2);
      paramString = Util.getUtf8Bytes(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) }));
    }
    System.arraycopy(paramString, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
  }
  
  private void writeSampleData(ExtractorInput paramExtractorInput, MatroskaExtractor.Track paramTrack, int paramInt)
  {
    if ("S_TEXT/UTF8".equals(paramTrack.codecId))
    {
      writeSubtitleSampleData(paramExtractorInput, SUBRIP_PREFIX, paramInt);
      return;
    }
    if ("S_TEXT/ASS".equals(paramTrack.codecId))
    {
      writeSubtitleSampleData(paramExtractorInput, SSA_PREFIX, paramInt);
      return;
    }
    TrackOutput localTrackOutput = paramTrack.output;
    boolean bool2 = this.sampleEncodingHandled;
    boolean bool1 = true;
    int k;
    if (!bool2)
    {
      if (paramTrack.hasContentEncryption)
      {
        this.blockFlags &= 0xBFFFFFFF;
        bool2 = this.sampleSignalByteRead;
        j = 128;
        if (!bool2)
        {
          paramExtractorInput.readFully(this.scratch.data, 0, 1);
          this.sampleBytesRead += 1;
          if ((this.scratch.data[0] & 0x80) != 128)
          {
            this.sampleSignalByte = this.scratch.data[0];
            this.sampleSignalByteRead = true;
          }
          else
          {
            throw new ParserException("Extension bit is set in signal byte");
          }
        }
        if ((this.sampleSignalByte & 0x1) == 1) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if ((this.sampleSignalByte & 0x2) == 2) {
            i = 1;
          } else {
            i = 0;
          }
          this.blockFlags |= 0x40000000;
          if (!this.sampleInitializationVectorRead)
          {
            paramExtractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
            this.sampleBytesRead += 8;
            this.sampleInitializationVectorRead = true;
            localObject = this.scratch.data;
            if (i == 0) {
              j = 0;
            }
            localObject[0] = ((byte)(j | 0x8));
            this.scratch.setPosition(0);
            localTrackOutput.sampleData(this.scratch, 1);
            this.sampleBytesWritten += 1;
            this.encryptionInitializationVector.setPosition(0);
            localTrackOutput.sampleData(this.encryptionInitializationVector, 8);
            this.sampleBytesWritten += 8;
          }
          if (i != 0)
          {
            if (!this.samplePartitionCountRead)
            {
              paramExtractorInput.readFully(this.scratch.data, 0, 1);
              this.sampleBytesRead += 1;
              this.scratch.setPosition(0);
              this.samplePartitionCount = this.scratch.readUnsignedByte();
              this.samplePartitionCountRead = true;
            }
            i = this.samplePartitionCount * 4;
            this.scratch.reset(i);
            paramExtractorInput.readFully(this.scratch.data, 0, i);
            this.sampleBytesRead += i;
            short s = (short)(this.samplePartitionCount / 2 + 1);
            int m = s * 6 + 2;
            localObject = this.encryptionSubsampleDataBuffer;
            if ((localObject == null) || (((ByteBuffer)localObject).capacity() < m)) {
              this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(m);
            }
            this.encryptionSubsampleDataBuffer.position(0);
            this.encryptionSubsampleDataBuffer.putShort(s);
            i = 0;
            for (j = 0;; j = k)
            {
              k = this.samplePartitionCount;
              if (i >= k) {
                break;
              }
              k = this.scratch.readUnsignedIntToInt();
              if (i % 2 == 0) {
                this.encryptionSubsampleDataBuffer.putShort((short)(k - j));
              } else {
                this.encryptionSubsampleDataBuffer.putInt(k - j);
              }
              i += 1;
            }
            i = paramInt - this.sampleBytesRead - j;
            if (k % 2 == 1)
            {
              this.encryptionSubsampleDataBuffer.putInt(i);
            }
            else
            {
              this.encryptionSubsampleDataBuffer.putShort((short)i);
              this.encryptionSubsampleDataBuffer.putInt(0);
            }
            this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), m);
            localTrackOutput.sampleData(this.encryptionSubsampleData, m);
            this.sampleBytesWritten += m;
          }
        }
      }
      else if (paramTrack.sampleStrippedBytes != null)
      {
        this.sampleStrippedBytes.reset(paramTrack.sampleStrippedBytes, paramTrack.sampleStrippedBytes.length);
      }
      this.sampleEncodingHandled = true;
    }
    paramInt += this.sampleStrippedBytes.limit();
    if ((!"V_MPEG4/ISO/AVC".equals(paramTrack.codecId)) && (!"V_MPEGH/ISO/HEVC".equals(paramTrack.codecId)))
    {
      if (paramTrack.trueHdSampleRechunker != null)
      {
        if (this.sampleStrippedBytes.limit() != 0) {
          bool1 = false;
        }
        Assertions.checkState(bool1);
        paramTrack.trueHdSampleRechunker.startSample(paramExtractorInput, this.blockFlags, paramInt);
      }
      for (;;)
      {
        i = this.sampleBytesRead;
        if (i >= paramInt) {
          break;
        }
        readToOutput(paramExtractorInput, localTrackOutput, paramInt - i);
      }
    }
    Object localObject = this.nalLength.data;
    localObject[0] = 0;
    localObject[1] = 0;
    localObject[2] = 0;
    int i = paramTrack.nalUnitLengthFieldLength;
    int j = paramTrack.nalUnitLengthFieldLength;
    while (this.sampleBytesRead < paramInt)
    {
      k = this.sampleCurrentNalBytesRemaining;
      if (k == 0)
      {
        readToTarget(paramExtractorInput, (byte[])localObject, 4 - j, i);
        this.nalLength.setPosition(0);
        this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
        this.nalStartCode.setPosition(0);
        localTrackOutput.sampleData(this.nalStartCode, 4);
        this.sampleBytesWritten += 4;
      }
      else
      {
        this.sampleCurrentNalBytesRemaining = (k - readToOutput(paramExtractorInput, localTrackOutput, k));
      }
    }
    if ("A_VORBIS".equals(paramTrack.codecId))
    {
      this.vorbisNumPageSamples.setPosition(0);
      localTrackOutput.sampleData(this.vorbisNumPageSamples, 4);
      this.sampleBytesWritten += 4;
    }
  }
  
  private void writeSubtitleSampleData(ExtractorInput paramExtractorInput, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length + paramInt;
    if (this.subtitleSample.capacity() < i) {
      this.subtitleSample.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    } else {
      System.arraycopy(paramArrayOfByte, 0, this.subtitleSample.data, 0, paramArrayOfByte.length);
    }
    paramExtractorInput.readFully(this.subtitleSample.data, paramArrayOfByte.length, paramInt);
    this.subtitleSample.reset(i);
  }
  
  void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
  {
    if ((paramInt1 != 161) && (paramInt1 != 163))
    {
      if (paramInt1 != 16981)
      {
        if (paramInt1 != 18402)
        {
          if (paramInt1 != 21419)
          {
            if (paramInt1 != 25506)
            {
              if (paramInt1 == 30322)
              {
                localObject1 = this.currentTrack;
                ((MatroskaExtractor.Track)localObject1).projectionData = new byte[paramInt2];
                paramExtractorInput.readFully(((MatroskaExtractor.Track)localObject1).projectionData, 0, paramInt2);
                return;
              }
              paramExtractorInput = new StringBuilder();
              paramExtractorInput.append("Unexpected id: ");
              paramExtractorInput.append(paramInt1);
              throw new ParserException(paramExtractorInput.toString());
            }
            localObject1 = this.currentTrack;
            ((MatroskaExtractor.Track)localObject1).codecPrivate = new byte[paramInt2];
            paramExtractorInput.readFully(((MatroskaExtractor.Track)localObject1).codecPrivate, 0, paramInt2);
            return;
          }
          Arrays.fill(this.seekEntryIdBytes.data, (byte)0);
          paramExtractorInput.readFully(this.seekEntryIdBytes.data, 4 - paramInt2, paramInt2);
          this.seekEntryIdBytes.setPosition(0);
          this.seekEntryId = ((int)this.seekEntryIdBytes.readUnsignedInt());
          return;
        }
        localObject1 = new byte[paramInt2];
        paramExtractorInput.readFully((byte[])localObject1, 0, paramInt2);
        this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, (byte[])localObject1, 0, 0);
        return;
      }
      localObject1 = this.currentTrack;
      ((MatroskaExtractor.Track)localObject1).sampleStrippedBytes = new byte[paramInt2];
      paramExtractorInput.readFully(((MatroskaExtractor.Track)localObject1).sampleStrippedBytes, 0, paramInt2);
      return;
    }
    if (this.blockState == 0)
    {
      this.blockTrackNumber = ((int)this.varintReader.readUnsignedVarint(paramExtractorInput, false, true, 8));
      this.blockTrackNumberLength = this.varintReader.getLastLength();
      this.blockDurationUs = -9223372036854775807L;
      this.blockState = 1;
      this.scratch.reset();
    }
    Object localObject1 = (MatroskaExtractor.Track)this.tracks.get(this.blockTrackNumber);
    if (localObject1 == null)
    {
      paramExtractorInput.skipFully(paramInt2 - this.blockTrackNumberLength);
      this.blockState = 0;
      return;
    }
    if (this.blockState == 1)
    {
      readScratch(paramExtractorInput, 3);
      int i = (this.scratch.data[2] & 0x6) >> 1;
      if (i == 0)
      {
        this.blockLacingSampleCount = 1;
        this.blockLacingSampleSizes = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
        this.blockLacingSampleSizes[0] = (paramInt2 - this.blockTrackNumberLength - 3);
      }
      else
      {
        if (paramInt1 != 163) {
          break label1209;
        }
        readScratch(paramExtractorInput, 4);
        this.blockLacingSampleCount = ((this.scratch.data[3] & 0xFF) + 1);
        this.blockLacingSampleSizes = ensureArrayCapacity(this.blockLacingSampleSizes, this.blockLacingSampleCount);
        int j;
        if (i == 2)
        {
          j = this.blockTrackNumberLength;
          i = this.blockLacingSampleCount;
          paramInt2 = (paramInt2 - j - 4) / i;
          Arrays.fill(this.blockLacingSampleSizes, 0, i, paramInt2);
        }
        else
        {
          int k;
          int m;
          int n;
          Object localObject2;
          if (i == 1)
          {
            k = 0;
            i = 4;
            j = 0;
            for (;;)
            {
              m = this.blockLacingSampleCount;
              if (k >= m - 1) {
                break;
              }
              this.blockLacingSampleSizes[k] = 0;
              m = i;
              do
              {
                i = m + 1;
                readScratch(paramExtractorInput, i);
                n = this.scratch.data[(i - 1)] & 0xFF;
                localObject2 = this.blockLacingSampleSizes;
                localObject2[k] += n;
                m = i;
              } while (n == 255);
              j += localObject2[k];
              k += 1;
            }
            this.blockLacingSampleSizes[(m - 1)] = (paramInt2 - this.blockTrackNumberLength - i - j);
          }
          else
          {
            if (i != 3) {
              break label1174;
            }
            k = 0;
            i = 4;
            j = 0;
            for (;;)
            {
              m = this.blockLacingSampleCount;
              if (k >= m - 1) {
                break label999;
              }
              this.blockLacingSampleSizes[k] = 0;
              n = i + 1;
              readScratch(paramExtractorInput, n);
              localObject2 = this.scratch.data;
              int i1 = n - 1;
              if (localObject2[i1] == 0) {
                break label988;
              }
              long l2 = 0L;
              m = 0;
              long l1;
              for (;;)
              {
                i = n;
                l1 = l2;
                if (m >= 8) {
                  break;
                }
                i = 1 << 7 - m;
                if ((this.scratch.data[i1] & i) != 0)
                {
                  n += m;
                  readScratch(paramExtractorInput, n);
                  l1 = this.scratch.data[i1] & 0xFF & (i ^ 0xFFFFFFFF);
                  i = i1 + 1;
                  for (;;)
                  {
                    l2 = l1;
                    if (i >= n) {
                      break;
                    }
                    l1 = l2 << 8 | this.scratch.data[i] & 0xFF;
                    i += 1;
                  }
                  i = n;
                  l1 = l2;
                  if (k <= 0) {
                    break;
                  }
                  l1 = l2 - ((1L << m * 7 + 6) - 1L);
                  i = n;
                  break;
                }
                m += 1;
              }
              if ((l1 < -2147483648L) || (l1 > 2147483647L)) {
                break;
              }
              m = (int)l1;
              localObject2 = this.blockLacingSampleSizes;
              if (k != 0) {
                m += localObject2[(k - 1)];
              }
              localObject2[k] = m;
              j += this.blockLacingSampleSizes[k];
              k += 1;
            }
            throw new ParserException("EBML lacing sample size out of range.");
            label988:
            throw new ParserException("No valid varint length mask found");
            label999:
            this.blockLacingSampleSizes[(m - 1)] = (paramInt2 - this.blockTrackNumberLength - i - j);
          }
        }
      }
      paramInt2 = this.scratch.data[0];
      i = this.scratch.data[1];
      this.blockTimeUs = (this.clusterTimecodeUs + scaleTimecodeToUs(paramInt2 << 8 | i & 0xFF));
      if ((this.scratch.data[2] & 0x8) == 8) {
        i = 1;
      } else {
        i = 0;
      }
      if ((((MatroskaExtractor.Track)localObject1).type != 2) && ((paramInt1 != 163) || ((this.scratch.data[2] & 0x80) != 128))) {
        paramInt2 = 0;
      } else {
        paramInt2 = 1;
      }
      if (i != 0) {
        i = -2147483648;
      } else {
        i = 0;
      }
      this.blockFlags = (paramInt2 | i);
      this.blockState = 2;
      this.blockLacingSampleIndex = 0;
      break label1220;
      label1174:
      paramExtractorInput = new StringBuilder();
      paramExtractorInput.append("Unexpected lacing value: ");
      paramExtractorInput.append(i);
      throw new ParserException(paramExtractorInput.toString());
      label1209:
      throw new ParserException("Lacing only supported in SimpleBlocks.");
    }
    label1220:
    if (paramInt1 == 163)
    {
      for (;;)
      {
        paramInt1 = this.blockLacingSampleIndex;
        if (paramInt1 >= this.blockLacingSampleCount) {
          break;
        }
        writeSampleData(paramExtractorInput, (MatroskaExtractor.Track)localObject1, this.blockLacingSampleSizes[paramInt1]);
        commitSampleToOutput((MatroskaExtractor.Track)localObject1, this.blockTimeUs + this.blockLacingSampleIndex * ((MatroskaExtractor.Track)localObject1).defaultSampleDurationNs / 1000);
        this.blockLacingSampleIndex += 1;
      }
      this.blockState = 0;
      return;
    }
    writeSampleData(paramExtractorInput, (MatroskaExtractor.Track)localObject1, this.blockLacingSampleSizes[0]);
  }
  
  void endMasterElement(int paramInt)
  {
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        long l;
        if (paramInt != 19899)
        {
          if (paramInt != 25152)
          {
            if (paramInt != 28032)
            {
              if (paramInt != 357149030)
              {
                if (paramInt != 374648427)
                {
                  if (paramInt != 475249515) {
                    return;
                  }
                  if (!this.sentSeekMap)
                  {
                    this.extractorOutput.seekMap(buildSeekMap());
                    this.sentSeekMap = true;
                  }
                }
                else
                {
                  if (this.tracks.size() != 0)
                  {
                    this.extractorOutput.endTracks();
                    return;
                  }
                  throw new ParserException("No valid tracks were found");
                }
              }
              else
              {
                if (this.timecodeScale == -9223372036854775807L) {
                  this.timecodeScale = 1000000L;
                }
                l = this.durationTimecode;
                if (l != -9223372036854775807L) {
                  this.durationUs = scaleTimecodeToUs(l);
                }
              }
            }
            else if (this.currentTrack.hasContentEncryption)
            {
              if (this.currentTrack.sampleStrippedBytes == null) {
                return;
              }
              throw new ParserException("Combining encryption and compression is not supported");
            }
          }
          else if (this.currentTrack.hasContentEncryption)
          {
            if (this.currentTrack.cryptoData != null)
            {
              this.currentTrack.drmInitData = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey) });
              return;
            }
            throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
          }
        }
        else
        {
          paramInt = this.seekEntryId;
          if (paramInt != -1)
          {
            l = this.seekEntryPosition;
            if (l != -1L)
            {
              if (paramInt != 475249515) {
                return;
              }
              this.cuesContentPosition = l;
              return;
            }
          }
          throw new ParserException("Mandatory element SeekID or SeekPosition not found");
        }
      }
      else
      {
        if (isCodecSupported(this.currentTrack.codecId))
        {
          MatroskaExtractor.Track localTrack = this.currentTrack;
          localTrack.initializeOutput(this.extractorOutput, localTrack.number);
          this.tracks.put(this.currentTrack.number, this.currentTrack);
        }
        this.currentTrack = null;
      }
    }
    else
    {
      if (this.blockState != 2) {
        return;
      }
      if (!this.sampleSeenReferenceBlock) {
        this.blockFlags |= 0x1;
      }
      commitSampleToOutput((MatroskaExtractor.Track)this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
      this.blockState = 0;
    }
  }
  
  void floatElement(int paramInt, double paramDouble)
  {
    if (paramInt != 181)
    {
      if (paramInt != 17545)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 21978: 
          this.currentTrack.minMasteringLuminance = ((float)paramDouble);
          return;
        case 21977: 
          this.currentTrack.maxMasteringLuminance = ((float)paramDouble);
          return;
        case 21976: 
          this.currentTrack.whitePointChromaticityY = ((float)paramDouble);
          return;
        case 21975: 
          this.currentTrack.whitePointChromaticityX = ((float)paramDouble);
          return;
        case 21974: 
          this.currentTrack.primaryBChromaticityY = ((float)paramDouble);
          return;
        case 21973: 
          this.currentTrack.primaryBChromaticityX = ((float)paramDouble);
          return;
        case 21972: 
          this.currentTrack.primaryGChromaticityY = ((float)paramDouble);
          return;
        case 21971: 
          this.currentTrack.primaryGChromaticityX = ((float)paramDouble);
          return;
        case 21970: 
          this.currentTrack.primaryRChromaticityY = ((float)paramDouble);
          return;
        }
        this.currentTrack.primaryRChromaticityX = ((float)paramDouble);
        return;
      }
      this.durationTimecode = (paramDouble);
      return;
    }
    this.currentTrack.sampleRate = ((int)paramDouble);
  }
  
  int getElementType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 181: 
    case 17545: 
    case 21969: 
    case 21970: 
    case 21971: 
    case 21972: 
    case 21973: 
    case 21974: 
    case 21975: 
    case 21976: 
    case 21977: 
    case 21978: 
      return 5;
    case 161: 
    case 163: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
    case 30322: 
      return 4;
    case 160: 
    case 174: 
    case 183: 
    case 187: 
    case 224: 
    case 225: 
    case 18407: 
    case 19899: 
    case 20532: 
    case 20533: 
    case 21936: 
    case 21968: 
    case 25152: 
    case 28032: 
    case 30320: 
    case 290298740: 
    case 357149030: 
    case 374648427: 
    case 408125543: 
    case 440786851: 
    case 475249515: 
    case 524531317: 
      return 1;
    case 134: 
    case 17026: 
    case 2274716: 
      return 3;
    }
    return 2;
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
  }
  
  void integerElement(int paramInt, long paramLong)
  {
    if (paramInt != 20529)
    {
      if (paramInt != 20530)
      {
        boolean bool2 = false;
        boolean bool1 = false;
        switch (paramInt)
        {
        default: 
          switch (paramInt)
          {
          default: 
            return;
          case 21949: 
            this.currentTrack.maxFrameAverageLuminance = ((int)paramLong);
            return;
          case 21948: 
            this.currentTrack.maxContentLuminance = ((int)paramLong);
            return;
          case 21947: 
            localObject = this.currentTrack;
            ((MatroskaExtractor.Track)localObject).hasColorInfo = true;
            paramInt = (int)paramLong;
            if (paramInt != 1)
            {
              if (paramInt != 9)
              {
                if ((paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7)) {
                  return;
                }
                this.currentTrack.colorSpace = 2;
                return;
              }
              ((MatroskaExtractor.Track)localObject).colorSpace = 6;
              return;
            }
            ((MatroskaExtractor.Track)localObject).colorSpace = 1;
            return;
          case 21946: 
            paramInt = (int)paramLong;
            if (paramInt != 1) {
              if (paramInt != 16)
              {
                if (paramInt != 18)
                {
                  if ((paramInt == 6) || (paramInt == 7)) {}
                }
                else {
                  this.currentTrack.colorTransfer = 7;
                }
              }
              else
              {
                this.currentTrack.colorTransfer = 6;
                return;
              }
            }
            this.currentTrack.colorTransfer = 3;
            return;
          }
          paramInt = (int)paramLong;
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return;
            }
            this.currentTrack.colorRange = 1;
            return;
          }
          this.currentTrack.colorRange = 2;
          return;
        case 2807729: 
          this.timecodeScale = paramLong;
          return;
        case 2352003: 
          this.currentTrack.defaultSampleDurationNs = ((int)paramLong);
          return;
        case 25188: 
          this.currentTrack.audioBitDepth = ((int)paramLong);
          return;
        case 22203: 
          this.currentTrack.seekPreRollNs = paramLong;
          return;
        case 22186: 
          this.currentTrack.codecDelayNs = paramLong;
          return;
        case 21930: 
          localObject = this.currentTrack;
          if (paramLong == 1L) {
            bool1 = true;
          }
          ((MatroskaExtractor.Track)localObject).flagDefault = bool1;
          return;
        case 21690: 
          this.currentTrack.displayHeight = ((int)paramLong);
          return;
        case 21682: 
          this.currentTrack.displayUnit = ((int)paramLong);
          return;
        case 21680: 
          this.currentTrack.displayWidth = ((int)paramLong);
          return;
        case 21432: 
          paramInt = (int)paramLong;
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              if (paramInt != 3)
              {
                if (paramInt != 15) {
                  return;
                }
                this.currentTrack.stereoMode = 3;
                return;
              }
              this.currentTrack.stereoMode = 1;
              return;
            }
            this.currentTrack.stereoMode = 2;
            return;
          }
          this.currentTrack.stereoMode = 0;
          return;
        case 21420: 
          this.seekEntryPosition = (paramLong + this.segmentContentPosition);
          return;
        case 18408: 
          if (paramLong == 1L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AESSettingsCipherMode ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new ParserException(((StringBuilder)localObject).toString());
        case 18401: 
          if (paramLong == 5L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContentEncAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new ParserException(((StringBuilder)localObject).toString());
        case 17143: 
          if (paramLong == 1L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("EBMLReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new ParserException(((StringBuilder)localObject).toString());
        case 17029: 
          if ((paramLong >= 1L) && (paramLong <= 2L)) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DocTypeReadVersion ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new ParserException(((StringBuilder)localObject).toString());
        case 16980: 
          if (paramLong == 3L) {
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ContentCompAlgo ");
          ((StringBuilder)localObject).append(paramLong);
          ((StringBuilder)localObject).append(" not supported");
          throw new ParserException(((StringBuilder)localObject).toString());
        case 251: 
          this.sampleSeenReferenceBlock = true;
          return;
        case 241: 
          if (this.seenClusterPositionForCurrentCuePoint) {
            break;
          }
          this.cueClusterPositions.add(paramLong);
          this.seenClusterPositionForCurrentCuePoint = true;
          return;
        case 231: 
          this.clusterTimecodeUs = scaleTimecodeToUs(paramLong);
          return;
        case 215: 
          this.currentTrack.number = ((int)paramLong);
          return;
        case 186: 
          this.currentTrack.height = ((int)paramLong);
          return;
        case 179: 
          this.cueTimesUs.add(scaleTimecodeToUs(paramLong));
          return;
        case 176: 
          this.currentTrack.width = ((int)paramLong);
          return;
        case 159: 
          this.currentTrack.channelCount = ((int)paramLong);
          return;
        case 155: 
          this.blockDurationUs = scaleTimecodeToUs(paramLong);
          return;
        case 136: 
          localObject = this.currentTrack;
          bool1 = bool2;
          if (paramLong == 1L) {
            bool1 = true;
          }
          ((MatroskaExtractor.Track)localObject).flagForced = bool1;
          return;
        case 131: 
          this.currentTrack.type = ((int)paramLong);
          return;
        }
      }
      else
      {
        if (paramLong == 1L) {
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ContentEncodingScope ");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" not supported");
        throw new ParserException(((StringBuilder)localObject).toString());
      }
    }
    else {
      if (paramLong != 0L) {
        break label1120;
      }
    }
    return;
    label1120:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ContentEncodingOrder ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" not supported");
    throw new ParserException(((StringBuilder)localObject).toString());
  }
  
  boolean isLevel1Element(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  public int read(ExtractorInput paramExtractorInput, PositionHolder paramPositionHolder)
  {
    int i = 0;
    this.sampleRead = false;
    int j = 1;
    while ((j != 0) && (!this.sampleRead))
    {
      boolean bool = this.reader.read(paramExtractorInput);
      j = bool;
      if (bool)
      {
        j = bool;
        if (maybeSeekForCues(paramPositionHolder, paramExtractorInput.getPosition())) {
          return 1;
        }
      }
    }
    if (j == 0)
    {
      while (i < this.tracks.size())
      {
        ((MatroskaExtractor.Track)this.tracks.valueAt(i)).outputPendingSampleMetadata();
        i += 1;
      }
      return -1;
    }
    return 0;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.clusterTimecodeUs = -9223372036854775807L;
    int i = 0;
    this.blockState = 0;
    this.reader.reset();
    this.varintReader.reset();
    resetSample();
    while (i < this.tracks.size())
    {
      ((MatroskaExtractor.Track)this.tracks.valueAt(i)).reset();
      i += 1;
    }
  }
  
  public boolean sniff(ExtractorInput paramExtractorInput)
  {
    return new Sniffer().sniff(paramExtractorInput);
  }
  
  void startMasterElement(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt != 160)
    {
      if (paramInt != 174)
      {
        if (paramInt != 187)
        {
          if (paramInt != 19899)
          {
            if (paramInt != 20533)
            {
              if (paramInt != 21968)
              {
                if (paramInt != 25152) {
                  if (paramInt != 408125543)
                  {
                    if (paramInt != 475249515)
                    {
                      if (paramInt != 524531317) {
                        return;
                      }
                      if (!this.sentSeekMap)
                      {
                        if ((this.seekForCuesEnabled) && (this.cuesContentPosition != -1L))
                        {
                          this.seekForCues = true;
                          return;
                        }
                        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                        this.sentSeekMap = true;
                      }
                    }
                    else
                    {
                      this.cueTimesUs = new LongArray();
                      this.cueClusterPositions = new LongArray();
                    }
                  }
                  else
                  {
                    long l = this.segmentContentPosition;
                    if ((l != -1L) && (l != paramLong1)) {
                      throw new ParserException("Multiple Segment elements not supported");
                    }
                    this.segmentContentPosition = paramLong1;
                    this.segmentContentSize = paramLong2;
                  }
                }
              }
              else {
                this.currentTrack.hasColorInfo = true;
              }
            }
            else {
              this.currentTrack.hasContentEncryption = true;
            }
          }
          else
          {
            this.seekEntryId = -1;
            this.seekEntryPosition = -1L;
          }
        }
        else {
          this.seenClusterPositionForCurrentCuePoint = false;
        }
      }
      else {
        this.currentTrack = new MatroskaExtractor.Track(null);
      }
    }
    else {
      this.sampleSeenReferenceBlock = false;
    }
  }
  
  void stringElement(int paramInt, String paramString)
  {
    if (paramInt != 134)
    {
      if (paramInt != 17026)
      {
        if (paramInt != 2274716) {
          return;
        }
        MatroskaExtractor.Track.access$202(this.currentTrack, paramString);
        return;
      }
      if (!"webm".equals(paramString))
      {
        if ("matroska".equals(paramString)) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DocType ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" not supported");
        throw new ParserException(localStringBuilder.toString());
      }
    }
    else
    {
      this.currentTrack.codecId = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
 * JD-Core Version:    0.7.0.1
 */