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
    if ((paramInt & 0x1) == 0) {}
    for (boolean bool = true;; bool = false)
    {
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
      return;
    }
  }
  
  private SeekMap buildSeekMap()
  {
    int k = 0;
    if ((this.segmentContentPosition == -1L) || (this.durationUs == -9223372036854775807L) || (this.cueTimesUs == null) || (this.cueTimesUs.size() == 0) || (this.cueClusterPositions == null) || (this.cueClusterPositions.size() != this.cueTimesUs.size()))
    {
      this.cueTimesUs = null;
      this.cueClusterPositions = null;
      return new SeekMap.Unseekable(this.durationUs);
    }
    int m = this.cueTimesUs.size();
    int[] arrayOfInt = new int[m];
    long[] arrayOfLong1 = new long[m];
    long[] arrayOfLong2 = new long[m];
    long[] arrayOfLong3 = new long[m];
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      arrayOfLong3[i] = this.cueTimesUs.get(i);
      arrayOfLong1[i] = (this.segmentContentPosition + this.cueClusterPositions.get(i));
      i += 1;
    }
    while (j < m - 1)
    {
      arrayOfInt[j] = ((int)(arrayOfLong1[(j + 1)] - arrayOfLong1[j]));
      arrayOfLong2[j] = (arrayOfLong3[(j + 1)] - arrayOfLong3[j]);
      j += 1;
    }
    arrayOfInt[(m - 1)] = ((int)(this.segmentContentPosition + this.segmentContentSize - arrayOfLong1[(m - 1)]));
    arrayOfLong2[(m - 1)] = (this.durationUs - arrayOfLong3[(m - 1)]);
    this.cueTimesUs = null;
    this.cueClusterPositions = null;
    return new ChunkIndex(arrayOfInt, arrayOfLong1, arrayOfLong2, arrayOfLong3);
  }
  
  private void commitSampleToOutput(MatroskaExtractor.Track paramTrack, long paramLong)
  {
    if (paramTrack.trueHdSampleRechunker != null)
    {
      paramTrack.trueHdSampleRechunker.sampleMetadata(paramTrack, paramLong);
      this.sampleRead = true;
      resetSample();
      return;
    }
    if ("S_TEXT/UTF8".equals(paramTrack.codecId)) {
      commitSubtitleSample(paramTrack, "%02d:%02d:%02d,%03d", 19, 1000L, SUBRIP_TIMECODE_EMPTY);
    }
    for (;;)
    {
      paramTrack.output.sampleMetadata(paramLong, this.blockFlags, this.sampleBytesWritten, 0, paramTrack.cryptoData);
      break;
      if ("S_TEXT/ASS".equals(paramTrack.codecId)) {
        commitSubtitleSample(paramTrack, "%01d:%02d:%02d:%02d", 21, 10000L, SSA_TIMECODE_EMPTY);
      }
    }
  }
  
  private void commitSubtitleSample(MatroskaExtractor.Track paramTrack, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    setSampleDuration(this.subtitleSample.data, this.blockDurationUs, paramString, paramInt, paramLong, paramArrayOfByte);
    paramTrack.output.sampleData(this.subtitleSample, this.subtitleSample.limit());
    this.sampleBytesWritten += this.subtitleSample.limit();
  }
  
  private static int[] ensureArrayCapacity(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt;
    if (paramArrayOfInt == null) {
      arrayOfInt = new int[paramInt];
    }
    do
    {
      return arrayOfInt;
      arrayOfInt = paramArrayOfInt;
    } while (paramArrayOfInt.length >= paramInt);
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
    if ((this.sentSeekMap) && (this.seekPositionAfterBuildingCues != -1L))
    {
      paramPositionHolder.position = this.seekPositionAfterBuildingCues;
      this.seekPositionAfterBuildingCues = -1L;
      return true;
    }
    return false;
  }
  
  private void readScratch(ExtractorInput paramExtractorInput, int paramInt)
  {
    if (this.scratch.limit() >= paramInt) {
      return;
    }
    if (this.scratch.capacity() < paramInt) {
      this.scratch.reset(Arrays.copyOf(this.scratch.data, Math.max(this.scratch.data.length * 2, paramInt)), this.scratch.limit());
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
    for (;;)
    {
      this.sampleBytesRead += paramInt;
      this.sampleBytesWritten += paramInt;
      return paramInt;
      paramInt = paramTrackOutput.sampleData(paramExtractorInput, paramInt, false);
    }
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
    if (this.timecodeScale == -9223372036854775807L) {
      throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }
    return Util.scaleLargeTimestamp(paramLong, this.timecodeScale, 1000L);
  }
  
  private static void setSampleDuration(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    if (paramLong1 == -9223372036854775807L) {}
    int i;
    int j;
    int k;
    int m;
    for (paramString = paramArrayOfByte2;; paramString = Util.getUtf8Bytes(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
    {
      System.arraycopy(paramString, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
      return;
      i = (int)(paramLong1 / 3600000000L);
      paramLong1 -= i * 3600 * 1000000L;
      j = (int)(paramLong1 / 60000000L);
      paramLong1 -= j * 60 * 1000000L;
      k = (int)(paramLong1 / 1000000L);
      m = (int)((paramLong1 - k * 1000000L) / paramLong2);
    }
  }
  
  private void writeSampleData(ExtractorInput paramExtractorInput, MatroskaExtractor.Track paramTrack, int paramInt)
  {
    boolean bool = true;
    if ("S_TEXT/UTF8".equals(paramTrack.codecId)) {
      writeSubtitleSampleData(paramExtractorInput, SUBRIP_PREFIX, paramInt);
    }
    TrackOutput localTrackOutput;
    label190:
    label510:
    do
    {
      return;
      if ("S_TEXT/ASS".equals(paramTrack.codecId))
      {
        writeSubtitleSampleData(paramExtractorInput, SSA_PREFIX, paramInt);
        return;
      }
      localTrackOutput = paramTrack.output;
      int i;
      byte[] arrayOfByte;
      int j;
      if (!this.sampleEncodingHandled)
      {
        if (!paramTrack.hasContentEncryption) {
          break label845;
        }
        this.blockFlags &= 0xBFFFFFFF;
        if (!this.sampleSignalByteRead)
        {
          paramExtractorInput.readFully(this.scratch.data, 0, 1);
          this.sampleBytesRead += 1;
          if ((this.scratch.data[0] & 0x80) == 128) {
            throw new ParserException("Extension bit is set in signal byte");
          }
          this.sampleSignalByte = this.scratch.data[0];
          this.sampleSignalByteRead = true;
        }
        int m;
        int k;
        if ((this.sampleSignalByte & 0x1) == 1)
        {
          i = 1;
          if (i == 0) {
            break label667;
          }
          if ((this.sampleSignalByte & 0x2) != 2) {
            break label568;
          }
          i = 1;
          this.blockFlags |= 0x40000000;
          if (!this.sampleInitializationVectorRead)
          {
            paramExtractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
            this.sampleBytesRead += 8;
            this.sampleInitializationVectorRead = true;
            arrayOfByte = this.scratch.data;
            if (i == 0) {
              break label574;
            }
            j = 128;
            arrayOfByte[0] = ((byte)(j | 0x8));
            this.scratch.setPosition(0);
            localTrackOutput.sampleData(this.scratch, 1);
            this.sampleBytesWritten += 1;
            this.encryptionInitializationVector.setPosition(0);
            localTrackOutput.sampleData(this.encryptionInitializationVector, 8);
            this.sampleBytesWritten += 8;
          }
          if (i == 0) {
            break label667;
          }
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
          this.sampleBytesRead = (i + this.sampleBytesRead);
          short s = (short)(this.samplePartitionCount / 2 + 1);
          m = s * 6 + 2;
          if ((this.encryptionSubsampleDataBuffer == null) || (this.encryptionSubsampleDataBuffer.capacity() < m)) {
            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(m);
          }
          this.encryptionSubsampleDataBuffer.position(0);
          this.encryptionSubsampleDataBuffer.putShort(s);
          i = 0;
          j = 0;
          if (i >= this.samplePartitionCount) {
            break label596;
          }
          k = this.scratch.readUnsignedIntToInt();
          if (i % 2 != 0) {
            break label580;
          }
          this.encryptionSubsampleDataBuffer.putShort((short)(k - j));
        }
        for (;;)
        {
          i += 1;
          j = k;
          break label510;
          i = 0;
          break;
          i = 0;
          break label190;
          j = 0;
          break label260;
          this.encryptionSubsampleDataBuffer.putInt(k - j);
        }
        i = paramInt - this.sampleBytesRead - j;
        if (this.samplePartitionCount % 2 == 1)
        {
          this.encryptionSubsampleDataBuffer.putInt(i);
          this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), m);
          localTrackOutput.sampleData(this.encryptionSubsampleData, m);
          this.sampleBytesWritten += m;
          this.sampleEncodingHandled = true;
        }
      }
      else
      {
        paramInt = this.sampleStrippedBytes.limit() + paramInt;
        if ((!"V_MPEG4/ISO/AVC".equals(paramTrack.codecId)) && (!"V_MPEGH/ISO/HEVC".equals(paramTrack.codecId))) {
          break label894;
        }
        arrayOfByte = this.nalLength.data;
        arrayOfByte[0] = 0;
        arrayOfByte[1] = 0;
        arrayOfByte[2] = 0;
        i = paramTrack.nalUnitLengthFieldLength;
        j = paramTrack.nalUnitLengthFieldLength;
      }
      for (;;)
      {
        if (this.sampleBytesRead < paramInt)
        {
          if (this.sampleCurrentNalBytesRemaining == 0)
          {
            readToTarget(paramExtractorInput, arrayOfByte, 4 - j, i);
            this.nalLength.setPosition(0);
            this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
            this.nalStartCode.setPosition(0);
            localTrackOutput.sampleData(this.nalStartCode, 4);
            this.sampleBytesWritten += 4;
            continue;
            this.encryptionSubsampleDataBuffer.putShort((short)i);
            this.encryptionSubsampleDataBuffer.putInt(0);
            break;
            if (paramTrack.sampleStrippedBytes == null) {
              break label667;
            }
            this.sampleStrippedBytes.reset(paramTrack.sampleStrippedBytes, paramTrack.sampleStrippedBytes.length);
            break label667;
          }
          this.sampleCurrentNalBytesRemaining -= readToOutput(paramExtractorInput, localTrackOutput, this.sampleCurrentNalBytesRemaining);
          continue;
          if (paramTrack.trueHdSampleRechunker != null) {
            if (this.sampleStrippedBytes.limit() != 0) {
              break label954;
            }
          }
          for (;;)
          {
            Assertions.checkState(bool);
            paramTrack.trueHdSampleRechunker.startSample(paramExtractorInput, this.blockFlags, paramInt);
            while (this.sampleBytesRead < paramInt) {
              readToOutput(paramExtractorInput, localTrackOutput, paramInt - this.sampleBytesRead);
            }
            bool = false;
          }
        }
      }
    } while (!"A_VORBIS".equals(paramTrack.codecId));
    label260:
    label568:
    label574:
    label580:
    label596:
    label894:
    this.vorbisNumPageSamples.setPosition(0);
    label667:
    label845:
    localTrackOutput.sampleData(this.vorbisNumPageSamples, 4);
    label954:
    this.sampleBytesWritten += 4;
  }
  
  private void writeSubtitleSampleData(ExtractorInput paramExtractorInput, byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length + paramInt;
    if (this.subtitleSample.capacity() < i) {
      this.subtitleSample.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramExtractorInput.readFully(this.subtitleSample.data, paramArrayOfByte.length, paramInt);
      this.subtitleSample.reset(i);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.subtitleSample.data, 0, paramArrayOfByte.length);
    }
  }
  
  void binaryElement(int paramInt1, int paramInt2, ExtractorInput paramExtractorInput)
  {
    switch (paramInt1)
    {
    default: 
      throw new ParserException("Unexpected id: " + paramInt1);
    case 21419: 
      Arrays.fill(this.seekEntryIdBytes.data, (byte)0);
      paramExtractorInput.readFully(this.seekEntryIdBytes.data, 4 - paramInt2, paramInt2);
      this.seekEntryIdBytes.setPosition(0);
      this.seekEntryId = ((int)this.seekEntryIdBytes.readUnsignedInt());
      return;
    case 25506: 
      this.currentTrack.codecPrivate = new byte[paramInt2];
      paramExtractorInput.readFully(this.currentTrack.codecPrivate, 0, paramInt2);
      return;
    case 30322: 
      this.currentTrack.projectionData = new byte[paramInt2];
      paramExtractorInput.readFully(this.currentTrack.projectionData, 0, paramInt2);
      return;
    case 16981: 
      this.currentTrack.sampleStrippedBytes = new byte[paramInt2];
      paramExtractorInput.readFully(this.currentTrack.sampleStrippedBytes, 0, paramInt2);
      return;
    case 18402: 
      localObject = new byte[paramInt2];
      paramExtractorInput.readFully((byte[])localObject, 0, paramInt2);
      this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, (byte[])localObject, 0, 0);
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
    Object localObject = (MatroskaExtractor.Track)this.tracks.get(this.blockTrackNumber);
    if (localObject == null)
    {
      paramExtractorInput.skipFully(paramInt2 - this.blockTrackNumberLength);
      this.blockState = 0;
      return;
    }
    int i;
    if (this.blockState == 1)
    {
      readScratch(paramExtractorInput, 3);
      i = (this.scratch.data[2] & 0x6) >> 1;
      if (i != 0) {
        break label627;
      }
      this.blockLacingSampleCount = 1;
      this.blockLacingSampleSizes = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
      this.blockLacingSampleSizes[0] = (paramInt2 - this.blockTrackNumberLength - 3);
      paramInt2 = this.scratch.data[0];
      i = this.scratch.data[1];
      this.blockTimeUs = (this.clusterTimecodeUs + scaleTimecodeToUs(paramInt2 << 8 | i & 0xFF));
      if ((this.scratch.data[2] & 0x8) != 8) {
        break label1264;
      }
      paramInt2 = 1;
      label482:
      if ((((MatroskaExtractor.Track)localObject).type != 2) && ((paramInt1 != 163) || ((this.scratch.data[2] & 0x80) != 128))) {
        break label1269;
      }
      i = 1;
      label520:
      if (i == 0) {
        break label1275;
      }
      i = 1;
      label528:
      if (paramInt2 == 0) {
        break label1281;
      }
    }
    label1281:
    for (paramInt2 = -2147483648;; paramInt2 = 0)
    {
      this.blockFlags = (paramInt2 | i);
      this.blockState = 2;
      this.blockLacingSampleIndex = 0;
      if (paramInt1 != 163) {
        break label1292;
      }
      while (this.blockLacingSampleIndex < this.blockLacingSampleCount)
      {
        writeSampleData(paramExtractorInput, (MatroskaExtractor.Track)localObject, this.blockLacingSampleSizes[this.blockLacingSampleIndex]);
        commitSampleToOutput((MatroskaExtractor.Track)localObject, this.blockTimeUs + this.blockLacingSampleIndex * ((MatroskaExtractor.Track)localObject).defaultSampleDurationNs / 1000);
        this.blockLacingSampleIndex += 1;
      }
      label627:
      if (paramInt1 != 163) {
        throw new ParserException("Lacing only supported in SimpleBlocks.");
      }
      readScratch(paramExtractorInput, 4);
      this.blockLacingSampleCount = ((this.scratch.data[3] & 0xFF) + 1);
      this.blockLacingSampleSizes = ensureArrayCapacity(this.blockLacingSampleSizes, this.blockLacingSampleCount);
      if (i == 2)
      {
        paramInt2 = (paramInt2 - this.blockTrackNumberLength - 4) / this.blockLacingSampleCount;
        Arrays.fill(this.blockLacingSampleSizes, 0, this.blockLacingSampleCount, paramInt2);
        break;
      }
      int j;
      int k;
      int m;
      int n;
      int[] arrayOfInt;
      if (i == 1)
      {
        j = 0;
        i = 4;
        k = 0;
        while (k < this.blockLacingSampleCount - 1)
        {
          this.blockLacingSampleSizes[k] = 0;
          m = i;
          do
          {
            i = m + 1;
            readScratch(paramExtractorInput, i);
            n = this.scratch.data[(i - 1)] & 0xFF;
            arrayOfInt = this.blockLacingSampleSizes;
            arrayOfInt[k] += n;
            m = i;
          } while (n == 255);
          j += this.blockLacingSampleSizes[k];
          k += 1;
        }
        this.blockLacingSampleSizes[(this.blockLacingSampleCount - 1)] = (paramInt2 - this.blockTrackNumberLength - i - j);
        break;
      }
      if (i == 3)
      {
        j = 0;
        i = 4;
        k = 0;
        if (k < this.blockLacingSampleCount - 1)
        {
          this.blockLacingSampleSizes[k] = 0;
          n = i + 1;
          readScratch(paramExtractorInput, n);
          if (this.scratch.data[(n - 1)] == 0) {
            throw new ParserException("No valid varint length mask found");
          }
          long l2 = 0L;
          m = 0;
          long l1;
          for (;;)
          {
            i = n;
            l1 = l2;
            if (m < 8)
            {
              i = 1 << 7 - m;
              if ((this.scratch.data[(n - 1)] & i) == 0) {
                break label1139;
              }
              int i1 = n - 1;
              n += m;
              readScratch(paramExtractorInput, n);
              l2 = this.scratch.data[i1] & 0xFF & (i ^ 0xFFFFFFFF);
              i = i1 + 1;
              while (i < n)
              {
                l2 = this.scratch.data[i] & 0xFF | l2 << 8;
                i += 1;
              }
              i = n;
              l1 = l2;
              if (k > 0)
              {
                l1 = l2 - ((1L << m * 7 + 6) - 1L);
                i = n;
              }
            }
            if ((l1 >= -2147483648L) && (l1 <= 2147483647L)) {
              break;
            }
            throw new ParserException("EBML lacing sample size out of range.");
            label1139:
            m += 1;
          }
          m = (int)l1;
          arrayOfInt = this.blockLacingSampleSizes;
          if (k == 0) {}
          for (;;)
          {
            arrayOfInt[k] = m;
            j += this.blockLacingSampleSizes[k];
            k += 1;
            break;
            m += this.blockLacingSampleSizes[(k - 1)];
          }
        }
        this.blockLacingSampleSizes[(this.blockLacingSampleCount - 1)] = (paramInt2 - this.blockTrackNumberLength - i - j);
        break;
      }
      throw new ParserException("Unexpected lacing value: " + i);
      label1264:
      paramInt2 = 0;
      break label482;
      label1269:
      i = 0;
      break label520;
      label1275:
      i = 0;
      break label528;
    }
    this.blockState = 0;
    return;
    label1292:
    writeSampleData(paramExtractorInput, (MatroskaExtractor.Track)localObject, this.blockLacingSampleSizes[0]);
  }
  
  void endMasterElement(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 357149030: 
    case 19899: 
    case 475249515: 
    case 160: 
    case 25152: 
    case 28032: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (this.timecodeScale == -9223372036854775807L) {
                    this.timecodeScale = 1000000L;
                  }
                } while (this.durationTimecode == -9223372036854775807L);
                this.durationUs = scaleTimecodeToUs(this.durationTimecode);
                return;
                if ((this.seekEntryId == -1) || (this.seekEntryPosition == -1L)) {
                  throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
              } while (this.seekEntryId != 475249515);
              this.cuesContentPosition = this.seekEntryPosition;
              return;
            } while (this.sentSeekMap);
            this.extractorOutput.seekMap(buildSeekMap());
            this.sentSeekMap = true;
            return;
          } while (this.blockState != 2);
          if (!this.sampleSeenReferenceBlock) {
            this.blockFlags |= 0x1;
          }
          commitSampleToOutput((MatroskaExtractor.Track)this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
          this.blockState = 0;
          return;
        } while (!this.currentTrack.hasContentEncryption);
        if (this.currentTrack.cryptoData == null) {
          throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
        }
        this.currentTrack.drmInitData = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey) });
        return;
      } while ((!this.currentTrack.hasContentEncryption) || (this.currentTrack.sampleStrippedBytes == null));
      throw new ParserException("Combining encryption and compression is not supported");
    case 174: 
      if (isCodecSupported(this.currentTrack.codecId))
      {
        this.currentTrack.initializeOutput(this.extractorOutput, this.currentTrack.number);
        this.tracks.put(this.currentTrack.number, this.currentTrack);
      }
      this.currentTrack = null;
      return;
    }
    if (this.tracks.size() == 0) {
      throw new ParserException("No valid tracks were found");
    }
    this.extractorOutput.endTracks();
  }
  
  void floatElement(int paramInt, double paramDouble)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 17545: 
      this.durationTimecode = (paramDouble);
      return;
    case 181: 
      this.currentTrack.sampleRate = ((int)paramDouble);
      return;
    case 21969: 
      this.currentTrack.primaryRChromaticityX = ((float)paramDouble);
      return;
    case 21970: 
      this.currentTrack.primaryRChromaticityY = ((float)paramDouble);
      return;
    case 21971: 
      this.currentTrack.primaryGChromaticityX = ((float)paramDouble);
      return;
    case 21972: 
      this.currentTrack.primaryGChromaticityY = ((float)paramDouble);
      return;
    case 21973: 
      this.currentTrack.primaryBChromaticityX = ((float)paramDouble);
      return;
    case 21974: 
      this.currentTrack.primaryBChromaticityY = ((float)paramDouble);
      return;
    case 21975: 
      this.currentTrack.whitePointChromaticityX = ((float)paramDouble);
      return;
    case 21976: 
      this.currentTrack.whitePointChromaticityY = ((float)paramDouble);
      return;
    case 21977: 
      this.currentTrack.maxMasteringLuminance = ((float)paramDouble);
      return;
    }
    this.currentTrack.minMasteringLuminance = ((float)paramDouble);
  }
  
  int getElementType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
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
    case 131: 
    case 136: 
    case 155: 
    case 159: 
    case 176: 
    case 179: 
    case 186: 
    case 215: 
    case 231: 
    case 241: 
    case 251: 
    case 16980: 
    case 17029: 
    case 17143: 
    case 18401: 
    case 18408: 
    case 20529: 
    case 20530: 
    case 21420: 
    case 21432: 
    case 21680: 
    case 21682: 
    case 21690: 
    case 21930: 
    case 21945: 
    case 21946: 
    case 21947: 
    case 21948: 
    case 21949: 
    case 22186: 
    case 22203: 
    case 25188: 
    case 2352003: 
    case 2807729: 
      return 2;
    case 134: 
    case 17026: 
    case 2274716: 
      return 3;
    case 161: 
    case 163: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
    case 30322: 
      return 4;
    }
    return 5;
  }
  
  public void init(ExtractorOutput paramExtractorOutput)
  {
    this.extractorOutput = paramExtractorOutput;
  }
  
  void integerElement(int paramInt, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramInt)
    {
    default: 
    case 17143: 
    case 17029: 
    case 21420: 
    case 2807729: 
    case 176: 
    case 186: 
    case 21680: 
    case 21690: 
    case 21682: 
    case 215: 
    case 136: 
    case 21930: 
    case 131: 
    case 2352003: 
    case 22186: 
    case 22203: 
    case 159: 
    case 25188: 
    case 251: 
    case 20529: 
    case 20530: 
    case 16980: 
    case 18401: 
    case 18408: 
    case 179: 
    case 241: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                    } while (paramLong == 1L);
                    throw new ParserException("EBMLReadVersion " + paramLong + " not supported");
                  } while ((paramLong >= 1L) && (paramLong <= 2L));
                  throw new ParserException("DocTypeReadVersion " + paramLong + " not supported");
                  this.seekEntryPosition = (this.segmentContentPosition + paramLong);
                  return;
                  this.timecodeScale = paramLong;
                  return;
                  this.currentTrack.width = ((int)paramLong);
                  return;
                  this.currentTrack.height = ((int)paramLong);
                  return;
                  this.currentTrack.displayWidth = ((int)paramLong);
                  return;
                  this.currentTrack.displayHeight = ((int)paramLong);
                  return;
                  this.currentTrack.displayUnit = ((int)paramLong);
                  return;
                  this.currentTrack.number = ((int)paramLong);
                  return;
                  MatroskaExtractor.Track localTrack = this.currentTrack;
                  if (paramLong == 1L) {}
                  for (;;)
                  {
                    localTrack.flagForced = bool1;
                    return;
                    bool1 = false;
                  }
                  localTrack = this.currentTrack;
                  if (paramLong == 1L) {}
                  for (bool1 = bool2;; bool1 = false)
                  {
                    localTrack.flagDefault = bool1;
                    return;
                  }
                  this.currentTrack.type = ((int)paramLong);
                  return;
                  this.currentTrack.defaultSampleDurationNs = ((int)paramLong);
                  return;
                  this.currentTrack.codecDelayNs = paramLong;
                  return;
                  this.currentTrack.seekPreRollNs = paramLong;
                  return;
                  this.currentTrack.channelCount = ((int)paramLong);
                  return;
                  this.currentTrack.audioBitDepth = ((int)paramLong);
                  return;
                  this.sampleSeenReferenceBlock = true;
                  return;
                } while (paramLong == 0L);
                throw new ParserException("ContentEncodingOrder " + paramLong + " not supported");
              } while (paramLong == 1L);
              throw new ParserException("ContentEncodingScope " + paramLong + " not supported");
            } while (paramLong == 3L);
            throw new ParserException("ContentCompAlgo " + paramLong + " not supported");
          } while (paramLong == 5L);
          throw new ParserException("ContentEncAlgo " + paramLong + " not supported");
        } while (paramLong == 1L);
        throw new ParserException("AESSettingsCipherMode " + paramLong + " not supported");
        this.cueTimesUs.add(scaleTimecodeToUs(paramLong));
        return;
      } while (this.seenClusterPositionForCurrentCuePoint);
      this.cueClusterPositions.add(paramLong);
      this.seenClusterPositionForCurrentCuePoint = true;
      return;
    case 231: 
      this.clusterTimecodeUs = scaleTimecodeToUs(paramLong);
      return;
    case 155: 
      this.blockDurationUs = scaleTimecodeToUs(paramLong);
      return;
    case 21432: 
      switch ((int)paramLong)
      {
      default: 
        return;
      case 0: 
        this.currentTrack.stereoMode = 0;
        return;
      case 1: 
        this.currentTrack.stereoMode = 2;
        return;
      case 3: 
        this.currentTrack.stereoMode = 1;
        return;
      }
      this.currentTrack.stereoMode = 3;
      return;
    case 21947: 
      this.currentTrack.hasColorInfo = true;
      switch ((int)paramLong)
      {
      case 2: 
      case 3: 
      case 8: 
      default: 
        return;
      case 1: 
        this.currentTrack.colorSpace = 1;
        return;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
        this.currentTrack.colorSpace = 2;
        return;
      }
      this.currentTrack.colorSpace = 6;
      return;
    case 21946: 
      switch ((int)paramLong)
      {
      default: 
        return;
      case 1: 
      case 6: 
      case 7: 
        this.currentTrack.colorTransfer = 3;
        return;
      case 16: 
        this.currentTrack.colorTransfer = 6;
        return;
      }
      this.currentTrack.colorTransfer = 7;
      return;
    case 21945: 
      switch ((int)paramLong)
      {
      default: 
        return;
      case 1: 
        this.currentTrack.colorRange = 2;
        return;
      }
      this.currentTrack.colorRange = 1;
      return;
    case 21948: 
      this.currentTrack.maxContentLuminance = ((int)paramLong);
      return;
    }
    this.currentTrack.maxFrameAverageLuminance = ((int)paramLong);
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
      bool = this.reader.read(paramExtractorInput);
      j = bool;
      if (bool)
      {
        j = bool;
        if (maybeSeekForCues(paramPositionHolder, paramExtractorInput.getPosition())) {
          i = 1;
        }
      }
    }
    while (j != 0)
    {
      boolean bool;
      return i;
    }
    i = 0;
    while (i < this.tracks.size())
    {
      ((MatroskaExtractor.Track)this.tracks.valueAt(i)).outputPendingSampleMetadata();
      i += 1;
    }
    return -1;
  }
  
  public void release() {}
  
  public void seek(long paramLong1, long paramLong2)
  {
    this.clusterTimecodeUs = -9223372036854775807L;
    this.blockState = 0;
    this.reader.reset();
    this.varintReader.reset();
    resetSample();
    int i = 0;
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
    switch (paramInt)
    {
    case 25152: 
    default: 
    case 408125543: 
    case 19899: 
    case 475249515: 
    case 187: 
    case 524531317: 
      do
      {
        return;
        if ((this.segmentContentPosition != -1L) && (this.segmentContentPosition != paramLong1)) {
          throw new ParserException("Multiple Segment elements not supported");
        }
        this.segmentContentPosition = paramLong1;
        this.segmentContentSize = paramLong2;
        return;
        this.seekEntryId = -1;
        this.seekEntryPosition = -1L;
        return;
        this.cueTimesUs = new LongArray();
        this.cueClusterPositions = new LongArray();
        return;
        this.seenClusterPositionForCurrentCuePoint = false;
        return;
      } while (this.sentSeekMap);
      if ((this.seekForCuesEnabled) && (this.cuesContentPosition != -1L))
      {
        this.seekForCues = true;
        return;
      }
      this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
      this.sentSeekMap = true;
      return;
    case 160: 
      this.sampleSeenReferenceBlock = false;
      return;
    case 20533: 
      this.currentTrack.hasContentEncryption = true;
      return;
    case 174: 
      this.currentTrack = new MatroskaExtractor.Track(null);
      return;
    }
    this.currentTrack.hasColorInfo = true;
  }
  
  void stringElement(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
    case 17026: 
      do
      {
        return;
      } while (("webm".equals(paramString)) || ("matroska".equals(paramString)));
      throw new ParserException("DocType " + paramString + " not supported");
    case 134: 
      this.currentTrack.codecId = paramString;
      return;
    }
    MatroskaExtractor.Track.access$202(this.currentTrack, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
 * JD-Core Version:    0.7.0.1
 */