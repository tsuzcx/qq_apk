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
      String str2 = new String(paramContext);
      int i = str2.indexOf('|');
      if (i == -1) {
        paramContext = "";
      }
      String str3;
      String str1;
      do
      {
        return paramContext;
        str3 = str2.substring(0, i);
        str1 = str2.substring(i + 1);
        paramContext = str1;
      } while (!AVCoreLog.isColorLevel());
      AVCoreLog.i("ConfigInfoJni", "getSharpConfigPayloadFromFile FileName=" + Common.SHARP_CONFIG_PAYLOAD_FILE_NAME + "| payloadBuf:" + str2 + "| version=" + str3 + "| payload=" + str1);
      return str1;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.i("ConfigInfoJni", "getSharpConfigPayloadFromFile payloadBuf NULL");
    }
    return "";
  }
  
  public static int getSharpConfigVersionFromFile(Context paramContext)
  {
    int j = 0;
    Object localObject = Common.readFile(paramContext, Common.SHARP_CONFIG_PAYLOAD_FILE_NAME);
    int i = j;
    if (localObject != null)
    {
      paramContext = new String((byte[])localObject);
      i = paramContext.indexOf('|');
      if (i <= 0) {
        break label146;
      }
      localObject = paramContext.substring(0, i);
      String str = paramContext.substring(i + 1);
      if (AVCoreLog.isDevelopLevel()) {
        AVCoreLog.e("ConfigInfoJni", "getSharpConfigVersionFromFile, payloadBufTmp[" + paramContext + "], version[" + (String)localObject + "], payload[" + str + "]");
      }
    }
    label146:
    do
    {
      try
      {
        i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (Exception localException)
      {
        AVCoreLog.e("ConfigInfoJni", "getSharpConfigVersionFromFile Exception, payloadBufTmp[" + paramContext + "]", localException);
        return 0;
      }
      i = j;
    } while (!AVCoreLog.isDevelopLevel());
    AVCoreLog.d("ConfigInfoJni", "getSharpConfigVersionFromFile fail, payloadBufTmp[" + paramContext + "]");
    AVCoreUtil.printHexStringEx("ConfigInfoJni", localException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.config.ConfigInfoJni
 * JD-Core Version:    0.7.0.1
 */