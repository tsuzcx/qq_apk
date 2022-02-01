package com.google.android.exoplayer2.extractor.mkv;

import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.HevcConfig;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

final class MatroskaExtractor$Track
{
  private static final int DEFAULT_MAX_CLL = 1000;
  private static final int DEFAULT_MAX_FALL = 200;
  private static final int DISPLAY_UNIT_PIXELS = 0;
  private static final int MAX_CHROMATICITY = 50000;
  public int audioBitDepth = -1;
  public int channelCount = 1;
  public long codecDelayNs = 0L;
  public String codecId;
  public byte[] codecPrivate;
  public int colorRange = -1;
  public int colorSpace = -1;
  public int colorTransfer = -1;
  public TrackOutput.CryptoData cryptoData;
  public int defaultSampleDurationNs;
  public int displayHeight = -1;
  public int displayUnit = 0;
  public int displayWidth = -1;
  public DrmInitData drmInitData;
  public boolean flagDefault = true;
  public boolean flagForced;
  public boolean hasColorInfo = false;
  public boolean hasContentEncryption;
  public int height = -1;
  private String language = "eng";
  public int maxContentLuminance = 1000;
  public int maxFrameAverageLuminance = 200;
  public float maxMasteringLuminance = -1.0F;
  public float minMasteringLuminance = -1.0F;
  public int nalUnitLengthFieldLength;
  public int number;
  public TrackOutput output;
  public float primaryBChromaticityX = -1.0F;
  public float primaryBChromaticityY = -1.0F;
  public float primaryGChromaticityX = -1.0F;
  public float primaryGChromaticityY = -1.0F;
  public float primaryRChromaticityX = -1.0F;
  public float primaryRChromaticityY = -1.0F;
  public byte[] projectionData = null;
  public int sampleRate = 8000;
  public byte[] sampleStrippedBytes;
  public long seekPreRollNs = 0L;
  public int stereoMode = -1;
  @Nullable
  public MatroskaExtractor.TrueHdSampleRechunker trueHdSampleRechunker;
  public int type;
  public float whitePointChromaticityX = -1.0F;
  public float whitePointChromaticityY = -1.0F;
  public int width = -1;
  
  private byte[] getHdrStaticInfo()
  {
    if ((this.primaryRChromaticityX != -1.0F) && (this.primaryRChromaticityY != -1.0F) && (this.primaryGChromaticityX != -1.0F) && (this.primaryGChromaticityY != -1.0F) && (this.primaryBChromaticityX != -1.0F) && (this.primaryBChromaticityY != -1.0F) && (this.whitePointChromaticityX != -1.0F) && (this.whitePointChromaticityY != -1.0F) && (this.maxMasteringLuminance != -1.0F) && (this.minMasteringLuminance != -1.0F))
    {
      byte[] arrayOfByte = new byte[25];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.put((byte)0);
      localByteBuffer.putShort((short)(int)(this.primaryRChromaticityX * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.primaryRChromaticityY * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.primaryGChromaticityX * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.primaryGChromaticityY * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.primaryBChromaticityX * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.primaryBChromaticityY * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.whitePointChromaticityX * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.whitePointChromaticityY * 50000.0F + 0.5F));
      localByteBuffer.putShort((short)(int)(this.maxMasteringLuminance + 0.5F));
      localByteBuffer.putShort((short)(int)(this.minMasteringLuminance + 0.5F));
      localByteBuffer.putShort((short)this.maxContentLuminance);
      localByteBuffer.putShort((short)this.maxFrameAverageLuminance);
      return arrayOfByte;
    }
    return null;
  }
  
  private static List<byte[]> parseFourCcVc1Private(ParsableByteArray paramParsableByteArray)
  {
    try
    {
      paramParsableByteArray.skipBytes(16);
      if (paramParsableByteArray.readLittleEndianUnsignedInt() != 826496599L) {
        return null;
      }
      i = paramParsableByteArray.getPosition() + 20;
      paramParsableByteArray = paramParsableByteArray.data;
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      for (;;)
      {
        int i;
        continue;
        i += 1;
      }
    }
    if (i < paramParsableByteArray.length - 4)
    {
      if ((paramParsableByteArray[i] == 0) && (paramParsableByteArray[(i + 1)] == 0) && (paramParsableByteArray[(i + 2)] == 1) && (paramParsableByteArray[(i + 3)] == 15)) {
        return Collections.singletonList(Arrays.copyOfRange(paramParsableByteArray, i, paramParsableByteArray.length));
      }
    }
    else
    {
      throw new ParserException("Failed to find FourCC VC1 initialization data");
      paramParsableByteArray = new ParserException("Error parsing FourCC VC1 codec private");
      for (;;)
      {
        throw paramParsableByteArray;
      }
    }
  }
  
  private static boolean parseMsAcmCodecPrivate(ParsableByteArray paramParsableByteArray)
  {
    try
    {
      int i = paramParsableByteArray.readLittleEndianUnsignedShort();
      if (i == 1) {
        return true;
      }
      if (i == 65534)
      {
        paramParsableByteArray.setPosition(24);
        if (paramParsableByteArray.readLong() == MatroskaExtractor.access$400().getMostSignificantBits())
        {
          long l1 = paramParsableByteArray.readLong();
          long l2 = MatroskaExtractor.access$400().getLeastSignificantBits();
          if (l1 == l2) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      label64:
      break label64;
    }
    throw new ParserException("Error parsing MS/ACM codec private");
  }
  
  private static List<byte[]> parseVorbisCodecPrivate(byte[] paramArrayOfByte)
  {
    int i;
    int j;
    if (paramArrayOfByte[0] == 2)
    {
      i = 1;
      j = 0;
    }
    for (;;)
    {
      int k = j + 1;
      j = paramArrayOfByte[j];
      if (paramArrayOfByte[k] == 1) {}
      try
      {
        byte[] arrayOfByte1 = new byte[m];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, m);
        k += m;
        if (paramArrayOfByte[k] == 3)
        {
          i = k + (i + j);
          if (paramArrayOfByte[i] == 5)
          {
            byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
            System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
            paramArrayOfByte = new ArrayList(2);
            paramArrayOfByte.add(arrayOfByte1);
            paramArrayOfByte.add(arrayOfByte2);
            return paramArrayOfByte;
          }
          throw new ParserException("Error parsing vorbis codec private");
        }
        throw new ParserException("Error parsing vorbis codec private");
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        break label159;
      }
      throw new ParserException("Error parsing vorbis codec private");
      throw new ParserException("Error parsing vorbis codec private");
      label159:
      paramArrayOfByte = new ParserException("Error parsing vorbis codec private");
      for (;;)
      {
        throw paramArrayOfByte;
      }
      while (paramArrayOfByte[i] == -1)
      {
        j += 255;
        i += 1;
      }
      k = i + 1;
      int m = j + paramArrayOfByte[i];
      i = 0;
      j = k;
      while (paramArrayOfByte[j] == -1)
      {
        i += 255;
        j += 1;
      }
    }
  }
  
  public void initializeOutput(ExtractorOutput paramExtractorOutput, int paramInt)
  {
    Object localObject1 = this.codecId;
    int i = ((String)localObject1).hashCode();
    int k = 0;
    int m = 3;
    switch (i)
    {
    default: 
      break;
    case 1951062397: 
      if (((String)localObject1).equals("A_OPUS")) {
        i = 11;
      }
      break;
    case 1950789798: 
      if (((String)localObject1).equals("A_FLAC")) {
        i = 21;
      }
      break;
    case 1950749482: 
      if (((String)localObject1).equals("A_EAC3")) {
        i = 16;
      }
      break;
    case 1809237540: 
      if (((String)localObject1).equals("V_MPEG2")) {
        i = 2;
      }
      break;
    case 1422270023: 
      if (((String)localObject1).equals("S_TEXT/UTF8")) {
        i = 24;
      }
      break;
    case 855502857: 
      if (((String)localObject1).equals("V_MPEGH/ISO/HEVC")) {
        i = 7;
      }
      break;
    case 738597099: 
      if (((String)localObject1).equals("S_TEXT/ASS")) {
        i = 25;
      }
      break;
    case 725957860: 
      if (((String)localObject1).equals("A_PCM/INT/LIT")) {
        i = 23;
      }
      break;
    case 542569478: 
      if (((String)localObject1).equals("A_DTS/EXPRESS")) {
        i = 19;
      }
      break;
    case 444813526: 
      if (((String)localObject1).equals("V_THEORA")) {
        i = 9;
      }
      break;
    case 99146302: 
      if (((String)localObject1).equals("S_HDMV/PGS")) {
        i = 27;
      }
      break;
    case 82338134: 
      if (((String)localObject1).equals("V_VP9")) {
        i = 1;
      }
      break;
    case 82338133: 
      if (((String)localObject1).equals("V_VP8")) {
        i = 0;
      }
      break;
    case 62927045: 
      if (((String)localObject1).equals("A_DTS")) {
        i = 18;
      }
      break;
    case 62923603: 
      if (((String)localObject1).equals("A_AC3")) {
        i = 15;
      }
      break;
    case 62923557: 
      if (((String)localObject1).equals("A_AAC")) {
        i = 12;
      }
      break;
    case -356037306: 
      if (((String)localObject1).equals("A_DTS/LOSSLESS")) {
        i = 20;
      }
      break;
    case -425012669: 
      if (((String)localObject1).equals("S_VOBSUB")) {
        i = 26;
      }
      break;
    case -538363109: 
      if (((String)localObject1).equals("V_MPEG4/ISO/AVC")) {
        i = 6;
      }
      break;
    case -538363189: 
      if (((String)localObject1).equals("V_MPEG4/ISO/ASP")) {
        i = 4;
      }
      break;
    case -933872740: 
      if (((String)localObject1).equals("S_DVBSUB")) {
        i = 28;
      }
      break;
    case -1373388978: 
      if (((String)localObject1).equals("V_MS/VFW/FOURCC")) {
        i = 8;
      }
      break;
    case -1482641357: 
      if (((String)localObject1).equals("A_MPEG/L3")) {
        i = 14;
      }
      break;
    case -1482641358: 
      if (((String)localObject1).equals("A_MPEG/L2")) {
        i = 13;
      }
      break;
    case -1730367663: 
      if (((String)localObject1).equals("A_VORBIS")) {
        i = 10;
      }
      break;
    case -1784763192: 
      if (((String)localObject1).equals("A_TRUEHD")) {
        i = 17;
      }
      break;
    case -1985379776: 
      if (((String)localObject1).equals("A_MS/ACM")) {
        i = 22;
      }
      break;
    case -2095575984: 
      if (((String)localObject1).equals("V_MPEG4/ISO/SP")) {
        i = 3;
      }
      break;
    case -2095576542: 
      if (((String)localObject1).equals("V_MPEG4/ISO/AP")) {
        i = 5;
      }
      break;
    }
    i = -1;
    Object localObject4 = null;
    label1254:
    Object localObject3;
    switch (i)
    {
    default: 
      throw new ParserException("Unrecognized codec identifier.");
    case 28: 
      localObject1 = this.codecPrivate;
      localObject1 = Collections.singletonList(new byte[] { localObject1[0], localObject1[1], localObject1[2], localObject1[3] });
      localObject2 = "application/dvbsubs";
      break;
    case 27: 
      localObject1 = "application/pgs";
      break;
    case 26: 
      localObject2 = Collections.singletonList(this.codecPrivate);
      localObject1 = "application/vobsub";
      break;
    case 25: 
      localObject1 = "text/x-ssa";
      break;
    case 24: 
      localObject1 = "application/x-subrip";
      break;
    case 23: 
      j = Util.getPcmEncoding(this.audioBitDepth);
      i = j;
      if (j == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unsupported PCM bit depth: ");
        ((StringBuilder)localObject1).append(this.audioBitDepth);
        ((StringBuilder)localObject1).append(". Setting mimeType to ");
        ((StringBuilder)localObject1).append("audio/x-unknown");
        Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      }
      break;
    case 22: 
      do
      {
        j = i;
        localObject1 = "audio/raw";
        localObject2 = null;
        i = -1;
        break label1705;
        if (!parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
          break;
        }
        j = Util.getPcmEncoding(this.audioBitDepth);
        i = j;
      } while (j != 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unsupported PCM bit depth: ");
      ((StringBuilder)localObject1).append(this.audioBitDepth);
      ((StringBuilder)localObject1).append(". Setting mimeType to ");
      ((StringBuilder)localObject1).append("audio/x-unknown");
      Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      break label1254;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Non-PCM MS/ACM is unsupported. Setting mimeType to ");
      ((StringBuilder)localObject1).append("audio/x-unknown");
      Log.w("MatroskaExtractor", ((StringBuilder)localObject1).toString());
      localObject1 = "audio/x-unknown";
      break;
    case 21: 
      localObject1 = Collections.singletonList(this.codecPrivate);
      localObject2 = "audio/flac";
      break;
    case 20: 
      localObject1 = "audio/vnd.dts.hd";
      break;
    case 18: 
    case 19: 
      localObject1 = "audio/vnd.dts";
      break;
    case 17: 
      this.trueHdSampleRechunker = new MatroskaExtractor.TrueHdSampleRechunker();
      localObject1 = "audio/true-hd";
      break;
    case 16: 
      localObject1 = "audio/eac3";
      break;
    case 15: 
      localObject1 = "audio/ac3";
      break;
    case 14: 
      localObject1 = "audio/mpeg";
      break;
    case 13: 
      localObject1 = "audio/mpeg-L2";
      localObject2 = null;
      i = 4096;
      break;
    case 12: 
      localObject1 = Collections.singletonList(this.codecPrivate);
      localObject2 = "audio/mp4a-latm";
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 7: 
    case 6: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        i = -1;
        j = -1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break label1705;
        localObject2 = new ArrayList(3);
        ((List)localObject2).add(this.codecPrivate);
        ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.codecDelayNs).array());
        ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.seekPreRollNs).array());
        localObject1 = "audio/opus";
        i = 5760;
        break label1702;
        localObject2 = parseVorbisCodecPrivate(this.codecPrivate);
        localObject1 = "audio/vorbis";
        i = 8192;
        break label1702;
        localObject1 = "video/x-unknown";
        break;
        localObject1 = parseFourCcVc1Private(new ParsableByteArray(this.codecPrivate));
        if (localObject1 != null)
        {
          localObject2 = "video/wvc1";
        }
        else
        {
          Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
          localObject2 = localObject1;
          localObject1 = "video/x-unknown";
          break label1699;
          localObject1 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
          localObject2 = ((HevcConfig)localObject1).initializationData;
          this.nalUnitLengthFieldLength = ((HevcConfig)localObject1).nalUnitLengthFieldLength;
          localObject1 = "video/hevc";
          break label1699;
          localObject1 = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
          localObject2 = ((AvcConfig)localObject1).initializationData;
          this.nalUnitLengthFieldLength = ((AvcConfig)localObject1).nalUnitLengthFieldLength;
          localObject1 = "video/avc";
          break label1699;
          localObject1 = this.codecPrivate;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = Collections.singletonList(localObject1);
          }
          localObject2 = "video/mp4v-es";
        }
      }
    case 2: 
      localObject1 = "video/mpeg2";
      break;
    case 1: 
      localObject1 = "video/x-vnd.on2.vp9";
      break;
    }
    localObject1 = "video/x-vnd.on2.vp8";
    Object localObject2 = null;
    label1699:
    i = -1;
    label1702:
    int j = -1;
    label1705:
    boolean bool = this.flagDefault;
    if (this.flagForced) {
      k = 2;
    }
    k |= bool | false;
    if (MimeTypes.isAudio((String)localObject1))
    {
      localObject1 = Format.createAudioSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, i, this.channelCount, this.sampleRate, j, (List)localObject2, this.drmInitData, k, this.language);
      paramInt = 1;
    }
    else if (MimeTypes.isVideo((String)localObject1))
    {
      if (this.displayUnit == 0)
      {
        k = this.displayWidth;
        j = k;
        if (k == -1) {
          j = this.width;
        }
        this.displayWidth = j;
        k = this.displayHeight;
        j = k;
        if (k == -1) {
          j = this.height;
        }
        this.displayHeight = j;
      }
      j = this.displayWidth;
      if (j != -1)
      {
        k = this.displayHeight;
        if (k != -1)
        {
          f = this.height * j / (this.width * k);
          break label1899;
        }
      }
      float f = -1.0F;
      label1899:
      localObject3 = localObject4;
      if (this.hasColorInfo)
      {
        localObject3 = getHdrStaticInfo();
        localObject3 = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, (byte[])localObject3);
      }
      localObject1 = Format.createVideoSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, i, this.width, this.height, -1.0F, (List)localObject2, -1, f, this.projectionData, this.stereoMode, (ColorInfo)localObject3, this.drmInitData);
      paramInt = 2;
    }
    else if ("application/x-subrip".equals(localObject1))
    {
      localObject1 = Format.createTextSampleFormat(Integer.toString(paramInt), (String)localObject1, k, this.language, this.drmInitData);
      paramInt = m;
    }
    else if ("text/x-ssa".equals(localObject1))
    {
      localObject2 = new ArrayList(2);
      ((List)localObject2).add(MatroskaExtractor.access$300());
      ((List)localObject2).add(this.codecPrivate);
      localObject1 = Format.createTextSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, k, this.language, -1, this.drmInitData, 9223372036854775807L, (List)localObject2);
      paramInt = m;
    }
    else
    {
      if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
        throw new ParserException("Unexpected MIME type.");
      }
      localObject1 = Format.createImageSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, k, (List)localObject2, this.language, this.drmInitData);
      paramInt = m;
    }
    this.output = paramExtractorOutput.track(this.number, paramInt);
    this.output.format((Format)localObject1);
  }
  
  public void outputPendingSampleMetadata()
  {
    MatroskaExtractor.TrueHdSampleRechunker localTrueHdSampleRechunker = this.trueHdSampleRechunker;
    if (localTrueHdSampleRechunker != null) {
      localTrueHdSampleRechunker.outputPendingSampleMetadata(this);
    }
  }
  
  public void reset()
  {
    MatroskaExtractor.TrueHdSampleRechunker localTrueHdSampleRechunker = this.trueHdSampleRechunker;
    if (localTrueHdSampleRechunker != null) {
      localTrueHdSampleRechunker.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track
 * JD-Core Version:    0.7.0.1
 */