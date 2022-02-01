package com.tencent.avcore.jni.config;

import android.content.Context;
import com.tencent.avcore.config.Common;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;

public class ConfigInfoJni
{
  public static final String TAG = "ConfigInfoJni";
  protected final Context mContext;
  
  public ConfigInfoJni(Context paramContext)
  {
    this.mContext = paramContext;
    init();
    cacheMethodIds();
  }
  
  private static native void cacheMethodIds();
  
  public static String getSharpConfigPayloadFromFile(Context paramContext)
  {
    paramContext = Common.readFile(paramContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
    if (paramContext != null)
    {
      paramContext = new String(paramContext);
      int i = paramContext.indexOf('|');
      if (i == -1) {
        return "";
      }
      String str1 = paramContext.substring(0, i);
      String str2 = paramContext.substring(i + 1);
      if (AVCoreLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSharpConfigPayloadFromFile FileName=");
        localStringBuilder.append(Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
        localStringBuilder.append("| payloadBuf:");
        localStringBuilder.append(paramContext);
        localStringBuilder.append("| version=");
        localStringBuilder.append(str1);
        localStringBuilder.append("| payload=");
        localStringBuilder.append(str2);
        AVCoreLog.i("ConfigInfoJni", localStringBuilder.toString());
      }
      return str2;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("ConfigInfoJni", "getSharpConfigPayloadFromFile payloadBuf NULL");
    }
    return "";
  }
  
  public static int getSharpConfigVersionFromFile(Context paramContext)
  {
    Object localObject1 = Common.readFile(paramContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
    if (localObject1 != null)
    {
      paramContext = new String((byte[])localObject1);
      int i = paramContext.indexOf('|');
      Object localObject2;
      if (i > 0)
      {
        localObject1 = paramContext.substring(0, i);
        localObject2 = paramContext.substring(i + 1);
        if (AVCoreLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getSharpConfigVersionFromFile, payloadBufTmp[");
          localStringBuilder.append(paramContext);
          localStringBuilder.append("], version[");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("], payload[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("]");
          AVCoreLog.e("ConfigInfoJni", localStringBuilder.toString());
        }
        try
        {
          i = Integer.parseInt((String)localObject1);
          return i;
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSharpConfigVersionFromFile Exception, payloadBufTmp[");
          ((StringBuilder)localObject2).append(paramContext);
          ((StringBuilder)localObject2).append("]");
          AVCoreLog.e("ConfigInfoJni", ((StringBuilder)localObject2).toString(), localException);
          return 0;
        }
      }
      if (AVCoreLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSharpConfigVersionFromFile fail, payloadBufTmp[");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append("]");
        AVCoreLog.d("ConfigInfoJni", ((StringBuilder)localObject2).toString());
        AVCoreUtil.printHexStringEx("ConfigInfoJni", localException);
      }
    }
    return 0;
  }
  
  private native void init();
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.readFile(this.mContext, "VideoConfigInfo");
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    return getSharpConfigPayloadFromFile(this.mContext);
  }
  
  public int getSharpConfigVersionFromFile()
  {
    return getSharpConfigVersionFromFile(this.mContext);
  }
  
  public void writeConfigInfoToFile(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.config.ConfigInfoJni
 * JD-Core Version:    0.7.0.1
 */