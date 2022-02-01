package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
  implements Parcelable
{
  public static final Parcelable.Creator<Format> CREATOR = new Format.1();
  public static final int NO_VALUE = -1;
  public static final long OFFSET_SAMPLE_RELATIVE = 9223372036854775807L;
  public final int accessibilityChannel;
  public final int bitrate;
  public final int channelCount;
  public final String codecs;
  public final ColorInfo colorInfo;
  public final String containerMimeType;
  public final DrmInitData drmInitData;
  public final int encoderDelay;
  public final int encoderPadding;
  public final float frameRate;
  private int hashCode;
  public final int height;
  public final String id;
  public final List<byte[]> initializationData;
  public final String language;
  public final int maxInputSize;
  public final Metadata metadata;
  public final int pcmEncoding;
  public final float pixelWidthHeightRatio;
  public final byte[] projectionData;
  public final int rotationDegrees;
  public final String sampleMimeType;
  public final int sampleRate;
  public final int selectionFlags;
  public final int stereoMode;
  public final long subsampleOffsetUs;
  public final int width;
  
  Format(Parcel paramParcel)
  {
    this.id = paramParcel.readString();
    this.containerMimeType = paramParcel.readString();
    this.sampleMimeType = paramParcel.readString();
    this.codecs = paramParcel.readString();
    this.bitrate = paramParcel.readInt();
    this.maxInputSize = paramParcel.readInt();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.frameRate = paramParcel.readFloat();
    this.rotationDegrees = paramParcel.readInt();
    this.pixelWidthHeightRatio = paramParcel.readFloat();
    int i = paramParcel.readInt();
    int j = 0;
    if (i != 0) {
      i = 1;
    } else {
      i = 0;
    }
    byte[] arrayOfByte;
    if (i != 0) {
      arrayOfByte = paramParcel.createByteArray();
    } else {
      arrayOfByte = null;
    }
    this.projectionData = arrayOfByte;
    this.stereoMode = paramParcel.readInt();
    this.colorInfo = ((ColorInfo)paramParcel.readParcelable(ColorInfo.class.getClassLoader()));
    this.channelCount = paramParcel.readInt();
    this.sampleRate = paramParcel.readInt();
    this.pcmEncoding = paramParcel.readInt();
    this.encoderDelay = paramParcel.readInt();
    this.encoderPadding = paramParcel.readInt();
    this.selectionFlags = paramParcel.readInt();
    this.language = paramParcel.readString();
    this.accessibilityChannel = paramParcel.readInt();
    this.subsampleOffsetUs = paramParcel.readLong();
    int k = paramParcel.readInt();
    this.initializationData = new ArrayList(k);
    i = j;
    while (i < k)
    {
      this.initializationData.add(paramParcel.createByteArray());
      i += 1;
    }
    this.drmInitData = ((DrmInitData)paramParcel.readParcelable(DrmInitData.class.getClassLoader()));
    this.metadata = ((Metadata)paramParcel.readParcelable(Metadata.class.getClassLoader()));
  }
  
  Format(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString5, int paramInt13, long paramLong, List<byte[]> paramList, DrmInitData paramDrmInitData, Metadata paramMetadata)
  {
    this.id = paramString1;
    this.containerMimeType = paramString2;
    this.sampleMimeType = paramString3;
    this.codecs = paramString4;
    this.bitrate = paramInt1;
    this.maxInputSize = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.frameRate = paramFloat1;
    this.rotationDegrees = paramInt5;
    this.pixelWidthHeightRatio = paramFloat2;
    this.projectionData = paramArrayOfByte;
    this.stereoMode = paramInt6;
    this.colorInfo = paramColorInfo;
    this.channelCount = paramInt7;
    this.sampleRate = paramInt8;
    this.pcmEncoding = paramInt9;
    this.encoderDelay = paramInt10;
    this.encoderPadding = paramInt11;
    this.selectionFlags = paramInt12;
    this.language = paramString5;
    this.accessibilityChannel = paramInt13;
    this.subsampleOffsetUs = paramLong;
    if (paramList == null) {
      paramList = Collections.emptyList();
    }
    this.initializationData = paramList;
    this.drmInitData = paramDrmInitData;
    this.metadata = paramMetadata;
  }
  
  public static Format createAudioContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, List<byte[]> paramList, int paramInt4, String paramString5)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt2, paramInt3, -1, -1, -1, paramInt4, paramString5, -1, 9223372036854775807L, paramList, null, null);
  }
  
  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt8, String paramString4, Metadata paramMetadata)
  {
    return new Format(paramString1, null, paramString2, paramString3, paramInt1, paramInt2, -1, -1, -1.0F, -1, -1.0F, null, -1, null, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramString4, -1, 9223372036854775807L, paramList, paramDrmInitData, paramMetadata);
  }
  
  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt6, String paramString4)
  {
    return createAudioSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, -1, -1, paramList, paramDrmInitData, paramInt6, paramString4, null);
  }
  
  public static Format createAudioSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<byte[]> paramList, DrmInitData paramDrmInitData, int paramInt5, String paramString4)
  {
    return createAudioSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, -1, paramList, paramDrmInitData, paramInt5, paramString4);
  }
  
  public static Format createContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, -1, 9223372036854775807L, null, null, null);
  }
  
  public static Format createImageSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, List<byte[]> paramList, String paramString4, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, paramString2, paramString3, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
  }
  
  public static Format createSampleFormat(String paramString1, String paramString2, long paramLong)
  {
    return new Format(paramString1, null, paramString2, null, -1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, paramLong, null, null, null);
  }
  
  public static Format createSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, paramString2, paramString3, paramInt, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, null, paramDrmInitData, null);
  }
  
  public static Format createTextContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5)
  {
    return createTextContainerFormat(paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2, paramString5, -1);
  }
  
  public static Format createTextContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, int paramInt3)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString5, paramInt3, 9223372036854775807L, null, null, null);
  }
  
  public static Format createTextSampleFormat(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return createTextSampleFormat(paramString1, paramString2, paramInt, paramString3, null);
  }
  
  public static Format createTextSampleFormat(String paramString1, String paramString2, int paramInt, String paramString3, DrmInitData paramDrmInitData)
  {
    return createTextSampleFormat(paramString1, paramString2, null, -1, paramInt, paramString3, -1, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
  }
  
  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, DrmInitData paramDrmInitData)
  {
    return createTextSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, paramInt3, paramDrmInitData, 9223372036854775807L, Collections.emptyList());
  }
  
  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, int paramInt3, DrmInitData paramDrmInitData, long paramLong, List<byte[]> paramList)
  {
    return new Format(paramString1, null, paramString2, paramString3, paramInt1, -1, -1, -1, -1.0F, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt2, paramString4, paramInt3, paramLong, paramList, paramDrmInitData, null);
  }
  
  public static Format createTextSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, DrmInitData paramDrmInitData, long paramLong)
  {
    return createTextSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4, -1, paramDrmInitData, paramLong, Collections.emptyList());
  }
  
  public static Format createVideoContainerFormat(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, float paramFloat, List<byte[]> paramList, int paramInt4)
  {
    return new Format(paramString1, paramString2, paramString3, paramString4, paramInt1, -1, paramInt2, paramInt3, paramFloat, -1, -1.0F, null, -1, null, -1, -1, -1, -1, -1, paramInt4, null, -1, 9223372036854775807L, paramList, null, null);
  }
  
  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, DrmInitData paramDrmInitData)
  {
    return createVideoSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramList, paramInt5, paramFloat2, null, -1, null, paramDrmInitData);
  }
  
  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, List<byte[]> paramList, int paramInt5, float paramFloat2, byte[] paramArrayOfByte, int paramInt6, ColorInfo paramColorInfo, DrmInitData paramDrmInitData)
  {
    return new Format(paramString1, null, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat1, paramInt5, paramFloat2, paramArrayOfByte, paramInt6, paramColorInfo, -1, -1, -1, -1, -1, 0, null, -1, 9223372036854775807L, paramList, paramDrmInitData, null);
  }
  
  public static Format createVideoSampleFormat(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, List<byte[]> paramList, DrmInitData paramDrmInitData)
  {
    return createVideoSampleFormat(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramList, -1, -1.0F, paramDrmInitData);
  }
  
  @TargetApi(16)
  private static void maybeSetByteBufferV16(MediaFormat paramMediaFormat, String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      paramMediaFormat.setByteBuffer(paramString, ByteBuffer.wrap(paramArrayOfByte));
    }
  }
  
  @TargetApi(24)
  private static void maybeSetColorInfoV24(MediaFormat paramMediaFormat, ColorInfo paramColorInfo)
  {
    if (paramColorInfo == null) {
      return;
    }
    maybeSetIntegerV16(paramMediaFormat, "color-transfer", paramColorInfo.colorTransfer);
    maybeSetIntegerV16(paramMediaFormat, "color-standard", paramColorInfo.colorSpace);
    maybeSetIntegerV16(paramMediaFormat, "color-range", paramColorInfo.colorRange);
    maybeSetByteBufferV16(paramMediaFormat, "hdr-static-info", paramColorInfo.hdrStaticInfo);
  }
  
  @TargetApi(16)
  private static void maybeSetFloatV16(MediaFormat paramMediaFormat, String paramString, float paramFloat)
  {
    if (paramFloat != -1.0F) {
      paramMediaFormat.setFloat(paramString, paramFloat);
    }
  }
  
  @TargetApi(16)
  private static void maybeSetIntegerV16(MediaFormat paramMediaFormat, String paramString, int paramInt)
  {
    if (paramInt != -1) {
      paramMediaFormat.setInteger(paramString, paramInt);
    }
  }
  
  @TargetApi(16)
  private static void maybeSetStringV16(MediaFormat paramMediaFormat, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramMediaFormat.setString(paramString1, paramString2);
    }
  }
  
  public static String toLogString(Format paramFormat)
  {
    if (paramFormat == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(paramFormat.id);
    localStringBuilder.append(", mimeType=");
    localStringBuilder.append(paramFormat.sampleMimeType);
    if (paramFormat.bitrate != -1)
    {
      localStringBuilder.append(", bitrate=");
      localStringBuilder.append(paramFormat.bitrate);
    }
    if ((paramFormat.width != -1) && (paramFormat.height != -1))
    {
      localStringBuilder.append(", res=");
      localStringBuilder.append(paramFormat.width);
      localStringBuilder.append("x");
      localStringBuilder.append(paramFormat.height);
    }
    if (paramFormat.frameRate != -1.0F)
    {
      localStringBuilder.append(", fps=");
      localStringBuilder.append(paramFormat.frameRate);
    }
    if (paramFormat.channelCount != -1)
    {
      localStringBuilder.append(", channels=");
      localStringBuilder.append(paramFormat.channelCount);
    }
    if (paramFormat.sampleRate != -1)
    {
      localStringBuilder.append(", sample_rate=");
      localStringBuilder.append(paramFormat.sampleRate);
    }
    if (paramFormat.language != null)
    {
      localStringBuilder.append(", language=");
      localStringBuilder.append(paramFormat.language);
    }
    return localStringBuilder.toString();
  }
  
  public Format copyWithContainerInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString4)
  {
    return new Format(paramString1, this.containerMimeType, paramString2, paramString3, paramInt1, this.maxInputSize, paramInt2, paramInt3, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, paramInt4, paramString4, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }
  
  public Format copyWithDrmInitData(DrmInitData paramDrmInitData)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, paramDrmInitData, this.metadata);
  }
  
  public Format copyWithGaplessInfo(int paramInt1, int paramInt2)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, paramInt1, paramInt2, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }
  
  public Format copyWithManifestFormatInfo(Format paramFormat)
  {
    if (this == paramFormat) {
      return this;
    }
    String str2 = paramFormat.id;
    Object localObject2 = this.codecs;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFormat.codecs;
    }
    int j = this.bitrate;
    int i = j;
    if (j == -1) {
      i = paramFormat.bitrate;
    }
    float f2 = this.frameRate;
    float f1 = f2;
    if (f2 == -1.0F) {
      f1 = paramFormat.frameRate;
    }
    j = this.selectionFlags;
    int k = paramFormat.selectionFlags;
    String str1 = this.language;
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = paramFormat.language;
    }
    paramFormat = DrmInitData.createSessionCreationData(paramFormat.drmInitData, this.drmInitData);
    return new Format(str2, this.containerMimeType, this.sampleMimeType, (String)localObject1, i, this.maxInputSize, this.width, this.height, f1, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, j | k, (String)localObject2, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, paramFormat, this.metadata);
  }
  
  public Format copyWithMaxInputSize(int paramInt)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, paramInt, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }
  
  public Format copyWithMetadata(Metadata paramMetadata)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, paramMetadata);
  }
  
  public Format copyWithRotationDegrees(int paramInt)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, paramInt, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
  }
  
  public Format copyWithSubsampleOffsetUs(long paramLong)
  {
    return new Format(this.id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, paramLong, this.initializationData, this.drmInitData, this.metadata);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (Format)paramObject;
      if ((this.bitrate == paramObject.bitrate) && (this.maxInputSize == paramObject.maxInputSize) && (this.width == paramObject.width) && (this.height == paramObject.height) && (this.frameRate == paramObject.frameRate) && (this.rotationDegrees == paramObject.rotationDegrees) && (this.pixelWidthHeightRatio == paramObject.pixelWidthHeightRatio) && (this.stereoMode == paramObject.stereoMode) && (this.channelCount == paramObject.channelCount) && (this.sampleRate == paramObject.sampleRate) && (this.pcmEncoding == paramObject.pcmEncoding) && (this.encoderDelay == paramObject.encoderDelay) && (this.encoderPadding == paramObject.encoderPadding) && (this.subsampleOffsetUs == paramObject.subsampleOffsetUs) && (this.selectionFlags == paramObject.selectionFlags) && (Util.areEqual(this.id, paramObject.id)) && (Util.areEqual(this.language, paramObject.language)) && (this.accessibilityChannel == paramObject.accessibilityChannel) && (Util.areEqual(this.containerMimeType, paramObject.containerMimeType)) && (Util.areEqual(this.sampleMimeType, paramObject.sampleMimeType)) && (Util.areEqual(this.codecs, paramObject.codecs)) && (Util.areEqual(this.drmInitData, paramObject.drmInitData)) && (Util.areEqual(this.metadata, paramObject.metadata)) && (Util.areEqual(this.colorInfo, paramObject.colorInfo)) && (Arrays.equals(this.projectionData, paramObject.projectionData)))
      {
        if (this.initializationData.size() != paramObject.initializationData.size()) {
          return false;
        }
        int i = 0;
        while (i < this.initializationData.size())
        {
          if (!Arrays.equals((byte[])this.initializationData.get(i), (byte[])paramObject.initializationData.get(i))) {
            return false;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  @TargetApi(16)
  public final MediaFormat getFrameworkMediaFormatV16()
  {
    MediaFormat localMediaFormat = new MediaFormat();
    localMediaFormat.setString("mime", this.sampleMimeType);
    maybeSetStringV16(localMediaFormat, "language", this.language);
    maybeSetIntegerV16(localMediaFormat, "max-input-size", this.maxInputSize);
    maybeSetIntegerV16(localMediaFormat, "width", this.width);
    maybeSetIntegerV16(localMediaFormat, "height", this.height);
    maybeSetFloatV16(localMediaFormat, "frame-rate", this.frameRate);
    maybeSetIntegerV16(localMediaFormat, "rotation-degrees", this.rotationDegrees);
    maybeSetIntegerV16(localMediaFormat, "channel-count", this.channelCount);
    maybeSetIntegerV16(localMediaFormat, "sample-rate", this.sampleRate);
    int i = 0;
    while (i < this.initializationData.size())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("csd-");
      localStringBuilder.append(i);
      localMediaFormat.setByteBuffer(localStringBuilder.toString(), ByteBuffer.wrap((byte[])this.initializationData.get(i)));
      i += 1;
    }
    maybeSetColorInfoV24(localMediaFormat, this.colorInfo);
    return localMediaFormat;
  }
  
  public int getPixelCount()
  {
    int j = this.width;
    int i = -1;
    if (j != -1)
    {
      i = this.height;
      if (i == -1) {
        return -1;
      }
      i = j * i;
    }
    return i;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      Object localObject = this.id;
      int i2 = 0;
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((String)localObject).hashCode();
      }
      localObject = this.containerMimeType;
      int j;
      if (localObject == null) {
        j = 0;
      } else {
        j = ((String)localObject).hashCode();
      }
      localObject = this.sampleMimeType;
      int k;
      if (localObject == null) {
        k = 0;
      } else {
        k = ((String)localObject).hashCode();
      }
      localObject = this.codecs;
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = ((String)localObject).hashCode();
      }
      int i3 = this.bitrate;
      int i4 = this.width;
      int i5 = this.height;
      int i6 = this.channelCount;
      int i7 = this.sampleRate;
      localObject = this.language;
      int n;
      if (localObject == null) {
        n = 0;
      } else {
        n = ((String)localObject).hashCode();
      }
      int i8 = this.accessibilityChannel;
      localObject = this.drmInitData;
      int i1;
      if (localObject == null) {
        i1 = 0;
      } else {
        i1 = ((DrmInitData)localObject).hashCode();
      }
      localObject = this.metadata;
      if (localObject != null) {
        i2 = ((Metadata)localObject).hashCode();
      }
      this.hashCode = (((((((((((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + n) * 31 + i8) * 31 + i1) * 31 + i2);
    }
    return this.hashCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Format(");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.containerMimeType);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.sampleMimeType);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.bitrate);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.language);
    localStringBuilder.append(", [");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.frameRate);
    localStringBuilder.append("], [");
    localStringBuilder.append(this.channelCount);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.sampleRate);
    localStringBuilder.append("])");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.id);
    paramParcel.writeString(this.containerMimeType);
    paramParcel.writeString(this.sampleMimeType);
    paramParcel.writeString(this.codecs);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.maxInputSize);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.frameRate);
    paramParcel.writeInt(this.rotationDegrees);
    paramParcel.writeFloat(this.pixelWidthHeightRatio);
    if (this.projectionData != null) {
      i = 1;
    } else {
      i = 0;
    }
    paramParcel.writeInt(i);
    byte[] arrayOfByte = this.projectionData;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
    paramParcel.writeInt(this.stereoMode);
    paramParcel.writeParcelable(this.colorInfo, paramInt);
    paramParcel.writeInt(this.channelCount);
    paramParcel.writeInt(this.sampleRate);
    paramParcel.writeInt(this.pcmEncoding);
    paramParcel.writeInt(this.encoderDelay);
    paramParcel.writeInt(this.encoderPadding);
    paramParcel.writeInt(this.selectionFlags);
    paramParcel.writeString(this.language);
    paramParcel.writeInt(this.accessibilityChannel);
    paramParcel.writeLong(this.subsampleOffsetUs);
    int i = this.initializationData.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeByteArray((byte[])this.initializationData.get(paramInt));
      paramInt += 1;
    }
    paramParcel.writeParcelable(this.drmInitData, 0);
    paramParcel.writeParcelable(this.metadata, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.Format
 * JD-Core Version:    0.7.0.1
 */