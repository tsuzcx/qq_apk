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
    if ((this.primaryRChromaticityX == -1.0F) || (this.primaryRChromaticityY == -1.0F) || (this.primaryGChromaticityX == -1.0F) || (this.primaryGChromaticityY == -1.0F) || (this.primaryBChromaticityX == -1.0F) || (this.primaryBChromaticityY == -1.0F) || (this.whitePointChromaticityX == -1.0F) || (this.whitePointChromaticityY == -1.0F) || (this.maxMasteringLuminance == -1.0F) || (this.minMasteringLuminance == -1.0F)) {
      return null;
    }
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
  
  private static List<byte[]> parseFourCcVc1Private(ParsableByteArray paramParsableByteArray)
  {
    for (;;)
    {
      int i;
      try
      {
        paramParsableByteArray.skipBytes(16);
        if (paramParsableByteArray.readLittleEndianUnsignedInt() != 826496599L) {
          return null;
        }
        i = paramParsableByteArray.getPosition() + 20;
        paramParsableByteArray = paramParsableByteArray.data;
        if (i < paramParsableByteArray.length - 4)
        {
          if ((paramParsableByteArray[i] == 0) && (paramParsableByteArray[(i + 1)] == 0) && (paramParsableByteArray[(i + 2)] == 1) && (paramParsableByteArray[(i + 3)] == 15)) {
            return Collections.singletonList(Arrays.copyOfRange(paramParsableByteArray, i, paramParsableByteArray.length));
          }
        }
        else {
          throw new ParserException("Failed to find FourCC VC1 initialization data");
        }
      }
      catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
      {
        throw new ParserException("Error parsing FourCC VC1 codec private");
      }
      i += 1;
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
          if (l1 == l2) {}
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    catch (ArrayIndexOutOfBoundsException paramParsableByteArray)
    {
      throw new ParserException("Error parsing MS/ACM codec private");
    }
    return true;
  }
  
  private static List<byte[]> parseVorbisCodecPrivate(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte[0] != 2) {
      try
      {
        throw new ParserException("Error parsing vorbis codec private");
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        throw new ParserException("Error parsing vorbis codec private");
      }
    }
    int i = 0;
    int j = 1;
    while (paramArrayOfByte[j] == -1)
    {
      j += 1;
      i += 255;
    }
    for (;;)
    {
      k = j + 1;
      j = paramArrayOfByte[j];
      if (paramArrayOfByte[k] != 1) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      byte[] arrayOfByte1 = new byte[n];
      System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, n);
      k = n + k;
      if (paramArrayOfByte[k] != 3) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      i = i + j + k;
      if (paramArrayOfByte[i] != 5) {
        throw new ParserException("Error parsing vorbis codec private");
      }
      byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
      System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
      paramArrayOfByte = new ArrayList(2);
      paramArrayOfByte.add(arrayOfByte1);
      paramArrayOfByte.add(arrayOfByte2);
      return paramArrayOfByte;
      int m = j + 1;
      int n = i + paramArrayOfByte[j];
      j = m;
      i = k;
      while (paramArrayOfByte[j] == -1)
      {
        i += 255;
        j += 1;
      }
    }
  }
  
  public void initializeOutput(ExtractorOutput paramExtractorOutput, int paramInt)
  {
    int k = -1;
    int j = -1;
    Object localObject3 = null;
    Object localObject1 = this.codecId;
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new ParserException("Unrecognized codec identifier.");
        if (((String)localObject1).equals("V_VP8"))
        {
          i = 0;
          continue;
          if (((String)localObject1).equals("V_VP9"))
          {
            i = 1;
            continue;
            if (((String)localObject1).equals("V_MPEG2"))
            {
              i = 2;
              continue;
              if (((String)localObject1).equals("V_MPEG4/ISO/SP"))
              {
                i = 3;
                continue;
                if (((String)localObject1).equals("V_MPEG4/ISO/ASP"))
                {
                  i = 4;
                  continue;
                  if (((String)localObject1).equals("V_MPEG4/ISO/AP"))
                  {
                    i = 5;
                    continue;
                    if (((String)localObject1).equals("V_MPEG4/ISO/AVC"))
                    {
                      i = 6;
                      continue;
                      if (((String)localObject1).equals("V_MPEGH/ISO/HEVC"))
                      {
                        i = 7;
                        continue;
                        if (((String)localObject1).equals("V_MS/VFW/FOURCC"))
                        {
                          i = 8;
                          continue;
                          if (((String)localObject1).equals("V_THEORA"))
                          {
                            i = 9;
                            continue;
                            if (((String)localObject1).equals("A_VORBIS"))
                            {
                              i = 10;
                              continue;
                              if (((String)localObject1).equals("A_OPUS"))
                              {
                                i = 11;
                                continue;
                                if (((String)localObject1).equals("A_AAC"))
                                {
                                  i = 12;
                                  continue;
                                  if (((String)localObject1).equals("A_MPEG/L2"))
                                  {
                                    i = 13;
                                    continue;
                                    if (((String)localObject1).equals("A_MPEG/L3"))
                                    {
                                      i = 14;
                                      continue;
                                      if (((String)localObject1).equals("A_AC3"))
                                      {
                                        i = 15;
                                        continue;
                                        if (((String)localObject1).equals("A_EAC3"))
                                        {
                                          i = 16;
                                          continue;
                                          if (((String)localObject1).equals("A_TRUEHD"))
                                          {
                                            i = 17;
                                            continue;
                                            if (((String)localObject1).equals("A_DTS"))
                                            {
                                              i = 18;
                                              continue;
                                              if (((String)localObject1).equals("A_DTS/EXPRESS"))
                                              {
                                                i = 19;
                                                continue;
                                                if (((String)localObject1).equals("A_DTS/LOSSLESS"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (((String)localObject1).equals("A_FLAC"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (((String)localObject1).equals("A_MS/ACM"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (((String)localObject1).equals("A_PCM/INT/LIT"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (((String)localObject1).equals("S_TEXT/UTF8"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (((String)localObject1).equals("S_TEXT/ASS"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (((String)localObject1).equals("S_VOBSUB"))
                                                            {
                                                              i = 26;
                                                              continue;
                                                              if (((String)localObject1).equals("S_HDMV/PGS"))
                                                              {
                                                                i = 27;
                                                                continue;
                                                                if (((String)localObject1).equals("S_DVBSUB")) {
                                                                  i = 28;
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    localObject1 = "video/x-vnd.on2.vp8";
    Object localObject2 = localObject3;
    i = k;
    label946:
    int m;
    if (this.flagDefault)
    {
      k = 1;
      if (!this.flagForced) {
        break label1931;
      }
      m = 2;
      label956:
      k = 0x0 | k | m;
      if (!MimeTypes.isAudio((String)localObject1)) {
        break label1937;
      }
      localObject1 = Format.createAudioSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, i, this.channelCount, this.sampleRate, j, (List)localObject2, this.drmInitData, k, this.language);
      paramInt = 1;
    }
    for (;;)
    {
      this.output = paramExtractorOutput.track(this.number, paramInt);
      this.output.format((Format)localObject1);
      return;
      localObject1 = "video/x-vnd.on2.vp9";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "video/mpeg2";
      i = k;
      localObject2 = localObject3;
      break;
      localObject3 = "video/mp4v-es";
      if (this.codecPrivate == null) {}
      for (localObject1 = null;; localObject1 = Collections.singletonList(this.codecPrivate))
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        i = k;
        break;
      }
      localObject1 = "video/avc";
      localObject3 = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
      localObject2 = ((AvcConfig)localObject3).initializationData;
      this.nalUnitLengthFieldLength = ((AvcConfig)localObject3).nalUnitLengthFieldLength;
      i = k;
      break;
      localObject1 = "video/hevc";
      localObject3 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
      localObject2 = ((HevcConfig)localObject3).initializationData;
      this.nalUnitLengthFieldLength = ((HevcConfig)localObject3).nalUnitLengthFieldLength;
      i = k;
      break;
      localObject2 = parseFourCcVc1Private(new ParsableByteArray(this.codecPrivate));
      if (localObject2 != null)
      {
        localObject1 = "video/wvc1";
        i = k;
        break;
      }
      Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
      localObject1 = "video/x-unknown";
      i = k;
      break;
      localObject1 = "video/x-unknown";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/vorbis";
      i = 8192;
      localObject2 = parseVorbisCodecPrivate(this.codecPrivate);
      break;
      localObject1 = "audio/opus";
      i = 5760;
      localObject2 = new ArrayList(3);
      ((List)localObject2).add(this.codecPrivate);
      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.codecDelayNs).array());
      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.seekPreRollNs).array());
      break;
      localObject1 = "audio/mp4a-latm";
      localObject2 = Collections.singletonList(this.codecPrivate);
      i = k;
      break;
      localObject1 = "audio/mpeg-L2";
      i = 4096;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/mpeg";
      i = 4096;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/ac3";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/eac3";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/true-hd";
      this.trueHdSampleRechunker = new MatroskaExtractor.TrueHdSampleRechunker();
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/vnd.dts";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/vnd.dts.hd";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/flac";
      localObject2 = Collections.singletonList(this.codecPrivate);
      i = k;
      break;
      localObject1 = "audio/raw";
      if (parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate)))
      {
        m = Util.getPcmEncoding(this.audioBitDepth);
        i = k;
        j = m;
        localObject2 = localObject3;
        if (m != 0) {
          break;
        }
        j = -1;
        localObject1 = "audio/x-unknown";
        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + "audio/x-unknown");
        i = k;
        localObject2 = localObject3;
        break;
      }
      localObject1 = "audio/x-unknown";
      Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to " + "audio/x-unknown");
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "audio/raw";
      m = Util.getPcmEncoding(this.audioBitDepth);
      i = k;
      j = m;
      localObject2 = localObject3;
      if (m != 0) {
        break;
      }
      j = -1;
      localObject1 = "audio/x-unknown";
      Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to " + "audio/x-unknown");
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "application/x-subrip";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "text/x-ssa";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "application/vobsub";
      localObject2 = Collections.singletonList(this.codecPrivate);
      i = k;
      break;
      localObject1 = "application/pgs";
      i = k;
      localObject2 = localObject3;
      break;
      localObject1 = "application/dvbsubs";
      localObject2 = Collections.singletonList(new byte[] { this.codecPrivate[0], this.codecPrivate[1], this.codecPrivate[2], this.codecPrivate[3] });
      i = k;
      break;
      k = 0;
      break label946;
      label1931:
      m = 0;
      break label956;
      label1937:
      if (MimeTypes.isVideo((String)localObject1))
      {
        if (this.displayUnit == 0)
        {
          if (this.displayWidth != -1) {
            break label2127;
          }
          j = this.width;
          label1966:
          this.displayWidth = j;
          if (this.displayHeight != -1) {
            break label2136;
          }
        }
        label2127:
        label2136:
        for (j = this.height;; j = this.displayHeight)
        {
          this.displayHeight = j;
          float f2 = -1.0F;
          float f1 = f2;
          if (this.displayWidth != -1)
          {
            f1 = f2;
            if (this.displayHeight != -1) {
              f1 = this.height * this.displayWidth / (this.width * this.displayHeight);
            }
          }
          localObject3 = null;
          if (this.hasColorInfo)
          {
            localObject3 = getHdrStaticInfo();
            localObject3 = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, (byte[])localObject3);
          }
          localObject1 = Format.createVideoSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, i, this.width, this.height, -1.0F, (List)localObject2, -1, f1, this.projectionData, this.stereoMode, (ColorInfo)localObject3, this.drmInitData);
          paramInt = 2;
          break;
          j = this.displayWidth;
          break label1966;
        }
      }
      if ("application/x-subrip".equals(localObject1))
      {
        localObject1 = Format.createTextSampleFormat(Integer.toString(paramInt), (String)localObject1, k, this.language, this.drmInitData);
        paramInt = 3;
      }
      else if ("text/x-ssa".equals(localObject1))
      {
        localObject2 = new ArrayList(2);
        ((List)localObject2).add(MatroskaExtractor.access$300());
        ((List)localObject2).add(this.codecPrivate);
        localObject1 = Format.createTextSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, k, this.language, -1, this.drmInitData, 9223372036854775807L, (List)localObject2);
        paramInt = 3;
      }
      else
      {
        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
          break label2323;
        }
        localObject1 = Format.createImageSampleFormat(Integer.toString(paramInt), (String)localObject1, null, -1, k, (List)localObject2, this.language, this.drmInitData);
        paramInt = 3;
      }
    }
    label2323:
    throw new ParserException("Unexpected MIME type.");
  }
  
  public void outputPendingSampleMetadata()
  {
    if (this.trueHdSampleRechunker != null) {
      this.trueHdSampleRechunker.outputPendingSampleMetadata(this);
    }
  }
  
  public void reset()
  {
    if (this.trueHdSampleRechunker != null) {
      this.trueHdSampleRechunker.reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.Track
 * JD-Core Version:    0.7.0.1
 */