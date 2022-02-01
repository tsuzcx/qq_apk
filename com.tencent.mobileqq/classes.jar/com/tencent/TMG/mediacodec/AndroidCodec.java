package com.tencent.TMG.mediacodec;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.TMG.mediacodec.config.CodecConfigParser;
import com.tencent.TMG.utils.QLog;
import com.tencent.TMG.utils.SoUtil;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class AndroidCodec
{
  public static String AVC_CODEC_MIME = "video/avc";
  public static int DEC_CODEC = 0;
  public static int ENC_CODEC = 1;
  public static String ForceIFrame = "request-sync";
  public static final int SUPPORT_AVC_DEC = 1;
  public static final int SUPPORT_AVC_ENC = 2;
  public static final int SUPPORT_HEVC_DEC = 4;
  public static final int SUPPORT_HEVC_ENC = 8;
  public static final int SUPPORT_NONE = 0;
  public static String TAG = "AndroidCodec";
  public static int TIMEOUTDECFIST_US = 5000;
  public static int TIMEOUT_US = 33000;
  protected static boolean gfLoaded = false;
  protected ByteBuffer[] inputBuffers;
  protected int mCodecType = DEC_CODEC;
  protected MediaFormat mFormat;
  protected MediaCodec mMediaCodec;
  protected MediaFormat mOutputFormat;
  protected ByteBuffer[] outputBuffers;
  
  public AndroidCodec()
  {
    loadCodecLibrarys();
  }
  
  public static int checkSupportMediaCodecFeature()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return 0;
    }
    if (!gfLoaded) {
      return 0;
    }
    boolean bool = DeviceCheck.isAVCDecWhitelistDevices();
    int i = 1;
    CodecConfigParser localCodecConfigParser;
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 0, "checkSupportMediaCodecFeature device is in decoder white list.");
      }
      if (DeviceCheck.isAVCDecSupportColorformats()) {
        break label156;
      }
    }
    else
    {
      localCodecConfigParser = new CodecConfigParser();
      str1 = localCodecConfigParser.getConfig();
      if (!TextUtils.isEmpty(str1))
      {
        localCodecConfigParser.setConfig(str1);
        if (QLog.isColorLevel())
        {
          str2 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkSupportMediaCodecFeature decoder sharpConfigPayload:\n");
          localStringBuilder.append(str1);
          QLog.d(str2, 0, localStringBuilder.toString());
        }
        if (localCodecConfigParser.getAVCDecoderAbility())
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 0, "checkSupportMediaCodecFeature hwcodec avc decoder enabled.");
          }
          if (DeviceCheck.isAVCDecSupportColorformats()) {
            break label156;
          }
        }
      }
    }
    i = 0;
    label156:
    if (DeviceCheck.isAVCEncWhitelistDevices())
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 0, "checkSupportMediaCodecFeature device is in encoder white list.");
      }
      if (!DeviceCheck.isAVCEncSupportColorformats()) {}
    }
    else
    {
      do
      {
        return i + 2;
        localCodecConfigParser = new CodecConfigParser();
        str1 = localCodecConfigParser.getConfig();
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        localCodecConfigParser.setConfig(str1);
        if (QLog.isColorLevel())
        {
          str2 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkSupportMediaCodecFeature encoder sharpConfigPayload:\n");
          localStringBuilder.append(str1);
          QLog.d(str2, 0, localStringBuilder.toString());
        }
        if (!localCodecConfigParser.getAVCEncoderAbility()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 0, "checkSupportMediaCodecFeature hwcodec avc encoder enabled.");
        }
      } while (DeviceCheck.isAVCEncSupportColorformats());
    }
    return i;
  }
  
  public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception paramMediaCodecInfo)
    {
      paramMediaCodecInfo.printStackTrace();
    }
    return null;
  }
  
  public static MediaCodecInfo getCodecInfo(String paramString)
  {
    int j = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < j)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.getName().equalsIgnoreCase(paramString)) {
        return localMediaCodecInfo;
      }
      i += 1;
    }
    return null;
  }
  
  public static List<MediaCodecInfo> getDecoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if ((!localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<MediaCodecInfo> getEndoderInfos(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if ((localMediaCodecInfo != null) && (localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            localArrayList.add(localMediaCodecInfo);
          }
          j += 1;
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void loadCodecLibrarys()
  {
    if (!gfLoaded)
    {
      boolean bool;
      if ((SoUtil.loadSo("stlport_shared")) && (SoUtil.loadSo("hwcodec"))) {
        bool = true;
      } else {
        bool = false;
      }
      gfLoaded = bool;
    }
  }
  
  private void setCallback(IMediaCodecCallback paramIMediaCodecCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 0, "setCallback");
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "setCallback api level lower 21.");
      }
      return;
    }
    this.mMediaCodec.setCallback(new AndroidCodec.1(this, paramIMediaCodecCallback));
  }
  
  public static void setDeviceInfos(Context paramContext)
  {
    Object localObject;
    if (SoUtil.customLibPath != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(SoUtil.customLibPath);
      ((StringBuilder)localObject).append("/libhwcodec.so");
      if (new File(((StringBuilder)localObject).toString()).exists())
      {
        j = 1;
        break label53;
      }
    }
    int j = 0;
    label53:
    int i = j;
    if (j == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getApplicationInfo().nativeLibraryDir);
      ((StringBuilder)localObject).append("/libhwcodec.so");
      i = j;
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        i = 1;
      }
    }
    j = i;
    if (i == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext.getFilesDir().getParent());
      ((StringBuilder)localObject).append("/txav/libhwcodec.so");
      j = i;
      if (new File(((StringBuilder)localObject).toString()).exists()) {
        j = 1;
      }
    }
    i = j;
    if (j == 0)
    {
      i = j;
      if (new File("/system/lib/libhwcodec.so").exists()) {
        i = 1;
      }
    }
    if (i == 0)
    {
      QLog.d(TAG, 0, "setDeviceInfos  ! soExist");
      return;
    }
    if (!gfLoaded)
    {
      loadCodecLibrarys();
      if (gfLoaded)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PRODUCT=");
        ((StringBuilder)localObject).append(Build.PRODUCT.toLowerCase());
        ((StringBuilder)localObject).append(";");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("MODEL=");
        localStringBuilder.append(Build.MODEL.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("SDK=");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("FINGERPRINT=");
        localStringBuilder.append(Build.FINGERPRINT.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("MANUFACTURER=");
        localStringBuilder.append(Build.MANUFACTURER.toLowerCase());
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        paramContext = paramContext.getApplicationInfo();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("DATADIR=");
        localStringBuilder.append(paramContext.dataDir);
        localStringBuilder.append(";");
        localObject = localStringBuilder.toString();
        if (Build.VERSION.SDK_INT >= 9)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("LIBDIR=");
          localStringBuilder.append(paramContext.nativeLibraryDir);
          localStringBuilder.append(";");
          paramContext = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("LIBDIR=");
          localStringBuilder.append(paramContext.dataDir);
          localStringBuilder.append("/lib;");
          paramContext = localStringBuilder.toString();
        }
        NativeCodec.set_device_infos(paramContext);
      }
    }
  }
  
  public AndroidCodec.BufferData dequeueOutputBuffer()
  {
    try
    {
      Object localObject1 = this.mMediaCodec;
      if (localObject1 == null) {
        return null;
      }
      localObject1 = new AndroidCodec.BufferData(this);
      int i = this.mMediaCodec.dequeueOutputBuffer(((AndroidCodec.BufferData)localObject1).info, TIMEOUT_US);
      if (i != -3)
      {
        if (i != -2)
        {
          if (i != -1)
          {
            if (i >= 0)
            {
              if (Build.VERSION.SDK_INT <= 20)
              {
                ((AndroidCodec.BufferData)localObject1).buffer = this.outputBuffers[i];
                ((AndroidCodec.BufferData)localObject1).index = i;
                ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
              }
              else
              {
                ((AndroidCodec.BufferData)localObject1).index = i;
                try
                {
                  ((AndroidCodec.BufferData)localObject1).format = this.mMediaCodec.getOutputFormat(i);
                  ((AndroidCodec.BufferData)localObject1).buffer = this.mMediaCodec.getOutputBuffer(i);
                }
                catch (IllegalStateException localIllegalStateException)
                {
                  localIllegalStateException.printStackTrace();
                  ((AndroidCodec.BufferData)localObject1).success = false;
                }
              }
            }
            else
            {
              ((AndroidCodec.BufferData)localObject1).index = i;
              ((AndroidCodec.BufferData)localObject1).success = false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 0, "dequeueOutputBuffer timed out!");
            }
            ((AndroidCodec.BufferData)localObject1).index = -1;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 0, "INFO_OUTPUT_FORMAT_CHANGED");
          }
          ((AndroidCodec.BufferData)localObject1).index = -2;
          this.mOutputFormat = this.mMediaCodec.getOutputFormat();
          if (this.mOutputFormat != null) {
            if (this.mCodecType == DEC_CODEC)
            {
              i = this.mOutputFormat.getInteger("color-format");
              if (QLog.isColorLevel())
              {
                String str = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("New color format: ");
                localStringBuilder.append(i);
                localStringBuilder.append("[0x");
                localStringBuilder.append(Integer.toHexString(i));
                localStringBuilder.append("]");
                QLog.e(str, 0, localStringBuilder.toString());
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e(TAG, 0, "EncCodec, INFO_OUTPUT_FORMAT_CHANGED");
            }
          }
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "INFO_OUTPUT_BUFFERS_CHANGED");
        }
        this.outputBuffers = this.mMediaCodec.getOutputBuffers();
        ((AndroidCodec.BufferData)localObject1).index = -3;
      }
      return localObject1;
    }
    finally {}
  }
  
  public AndroidCodec.BufferData dequeueOutputBuffer_First()
  {
    try
    {
      Object localObject1 = this.mMediaCodec;
      if (localObject1 == null) {
        return null;
      }
      while (this.mMediaCodec != null)
      {
        localObject1 = new AndroidCodec.BufferData(this);
        int i = this.mMediaCodec.dequeueOutputBuffer(((AndroidCodec.BufferData)localObject1).info, TIMEOUTDECFIST_US);
        if (i == -3)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 0, " dequeueOutputBuffer_First INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          ((AndroidCodec.BufferData)localObject1).index = -3;
        }
        else if (i == -2)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 0, "dequeueOutputBuffer_First INFO_OUTPUT_FORMAT_CHANGED");
          }
          ((AndroidCodec.BufferData)localObject1).index = -2;
          this.mOutputFormat = this.mMediaCodec.getOutputFormat();
          if (this.mOutputFormat != null) {
            if (this.mCodecType == DEC_CODEC)
            {
              i = this.mOutputFormat.getInteger("color-format");
              if (QLog.isColorLevel())
              {
                localObject1 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("dequeueOutputBuffer_First New color format: ");
                localStringBuilder.append(i);
                localStringBuilder.append("[0x");
                localStringBuilder.append(Integer.toHexString(i));
                localStringBuilder.append("]");
                QLog.e((String)localObject1, 0, localStringBuilder.toString());
              }
            }
            else if (QLog.isColorLevel())
            {
              QLog.e(TAG, 0, "EncCodec, dequeueOutputBuffer_First INFO_OUTPUT_FORMAT_CHANGED");
            }
          }
        }
        else
        {
          if (i == -1)
          {
            if (QLog.isColorLevel()) {
              QLog.e(TAG, 0, "dequeueOutputBuffer_First dequeueOutputBuffer timed out!");
            }
            ((AndroidCodec.BufferData)localObject1).index = -1;
            return localObject1;
          }
          if (i >= 0)
          {
            if (Build.VERSION.SDK_INT <= 20)
            {
              ((AndroidCodec.BufferData)localObject1).buffer = this.outputBuffers[i];
              ((AndroidCodec.BufferData)localObject1).index = i;
              ((AndroidCodec.BufferData)localObject1).format = this.mOutputFormat;
            }
            else
            {
              ((AndroidCodec.BufferData)localObject1).index = i;
              try
              {
                ((AndroidCodec.BufferData)localObject1).format = this.mMediaCodec.getOutputFormat(i);
                ((AndroidCodec.BufferData)localObject1).buffer = this.mMediaCodec.getOutputBuffer(i);
              }
              catch (IllegalStateException localIllegalStateException)
              {
                localIllegalStateException.printStackTrace();
                ((AndroidCodec.BufferData)localObject1).success = false;
              }
            }
          }
          else
          {
            ((AndroidCodec.BufferData)localObject1).index = i;
            ((AndroidCodec.BufferData)localObject1).success = false;
          }
          return localObject1;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void flush()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.flush();
    }
  }
  
  public AndroidCodec.BufferData getInputBuffer()
  {
    if (this.mMediaCodec == null) {
      return null;
    }
    AndroidCodec.BufferData localBufferData1 = new AndroidCodec.BufferData(this);
    int i = this.mMediaCodec.dequeueInputBuffer(TIMEOUT_US);
    if (i >= 0)
    {
      if (Build.VERSION.SDK_INT <= 20) {
        try
        {
          localBufferData1.index = i;
          localBufferData1.buffer = this.inputBuffers[i];
          return localBufferData1;
        }
        finally {}
      }
      try
      {
        localBufferData2.index = i;
        try
        {
          localBufferData2.buffer = this.mMediaCodec.getInputBuffer(i);
        }
        catch (IllegalStateException localIllegalStateException)
        {
          localIllegalStateException.printStackTrace();
          localBufferData2.success = false;
        }
        return localBufferData2;
      }
      finally {}
    }
    return null;
  }
  
  public ByteBuffer getInputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = this.mMediaCodec.getInputBuffer(paramInt);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public ByteBuffer getOutputBuffer(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = this.mMediaCodec.getOutputBuffer(paramInt);
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public MediaFormat getOutputFormat(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = this.mMediaCodec.getOutputFormat(paramInt);
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  public boolean init(MediaFormat paramMediaFormat, int paramInt, IMediaCodecCallback paramIMediaCodecCallback)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init codecType: ");
      localStringBuilder.append(paramInt);
      QLog.e(str, 0, localStringBuilder.toString());
    }
    this.mFormat = paramMediaFormat;
    if (paramInt == DEC_CODEC) {
      try
      {
        this.mMediaCodec = MediaCodec.createDecoderByType(this.mFormat.getString("mime"));
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "init exception", paramMediaFormat);
        }
        return false;
      }
    }
    for (;;)
    {
      try
      {
        this.mMediaCodec = MediaCodec.createEncoderByType(this.mFormat.getString("mime"));
        this.mCodecType = paramInt;
        try
        {
          if (this.mMediaCodec != null)
          {
            if (paramInt == ENC_CODEC)
            {
              paramInt = 1;
              if ((paramIMediaCodecCallback != null) && (DeviceCheck.isSupportAsyncAPI())) {
                setCallback(paramIMediaCodecCallback);
              }
              this.mMediaCodec.configure(this.mFormat, null, null, paramInt);
            }
          }
          else {
            return this.mMediaCodec != null;
          }
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e(TAG, 0, "init exception", paramMediaFormat);
          }
          return false;
        }
        paramInt = 0;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "init exception", paramMediaFormat);
        }
        return false;
      }
    }
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, IMediaCodecCallback paramIMediaCodecCallback)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init name: ");
      localStringBuilder.append(paramString);
      QLog.e(str, 0, localStringBuilder.toString());
    }
    this.mFormat = paramMediaFormat;
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      paramMediaFormat = getCodecInfo(paramString);
      int i;
      if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
      {
        this.mCodecType = ENC_CODEC;
        i = 1;
      }
      else
      {
        i = 0;
      }
      try
      {
        if (this.mMediaCodec != null)
        {
          if ((paramIMediaCodecCallback != null) && (DeviceCheck.isSupportAsyncAPI())) {
            setCallback(paramIMediaCodecCallback);
          }
          this.mMediaCodec.configure(this.mFormat, paramSurface, null, i);
        }
        return this.mMediaCodec != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "init exception", paramMediaFormat);
        }
        return false;
      }
      return false;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "init exception", paramMediaFormat);
      }
    }
  }
  
  public boolean init(MediaFormat paramMediaFormat, String paramString, IMediaCodecCallback paramIMediaCodecCallback)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init name: ");
      localStringBuilder.append(paramString);
      QLog.e(str, 0, localStringBuilder.toString());
    }
    this.mFormat = paramMediaFormat;
    paramMediaFormat = getCodecInfo(paramString);
    int i;
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
    {
      this.mCodecType = ENC_CODEC;
      i = 1;
    }
    else
    {
      i = 0;
    }
    try
    {
      this.mMediaCodec = MediaCodec.createByCodecName(paramString);
      try
      {
        if (this.mMediaCodec != null)
        {
          if ((paramIMediaCodecCallback != null) && (DeviceCheck.isSupportAsyncAPI())) {
            setCallback(paramIMediaCodecCallback);
          }
          this.mMediaCodec.configure(this.mFormat, null, null, i);
        }
        return this.mMediaCodec != null;
      }
      catch (Exception paramMediaFormat)
      {
        paramMediaFormat.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "init exception", paramMediaFormat);
        }
        return false;
      }
      return false;
    }
    catch (Exception paramMediaFormat)
    {
      paramMediaFormat.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 0, "init exception", paramMediaFormat);
      }
    }
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      try
      {
        this.mMediaCodec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(TAG, 0, "queueInputBuffer exception", localException);
        }
      }
      return;
    }
    finally {}
  }
  
  public void release()
  {
    try
    {
      this.inputBuffers = null;
      this.outputBuffers = null;
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.release();
        this.mMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void releaseOutputBuffer(int paramInt)
  {
    try
    {
      MediaCodec localMediaCodec = this.mMediaCodec;
      if (localMediaCodec == null) {
        return;
      }
      this.mMediaCodec.releaseOutputBuffer(paramInt, false);
      return;
    }
    finally {}
  }
  
  public void reset() {}
  
  public void setParameters(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec == null) {
      return;
    }
    try
    {
      localMediaCodec.setParameters(paramBundle);
      return;
    }
    catch (IllegalStateException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void setSurface(Surface paramSurface) {}
  
  public boolean start()
  {
    try
    {
      if (this.mMediaCodec != null)
      {
        this.mMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.inputBuffers = this.mMediaCodec.getInputBuffers();
            this.outputBuffers = this.mMediaCodec.getOutputBuffers();
          }
          finally {}
        }
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public void stop()
  {
    MediaCodec localMediaCodec = this.mMediaCodec;
    if (localMediaCodec != null) {
      localMediaCodec.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.AndroidCodec
 * JD-Core Version:    0.7.0.1
 */