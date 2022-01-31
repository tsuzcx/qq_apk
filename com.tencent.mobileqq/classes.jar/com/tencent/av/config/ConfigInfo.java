package com.tencent.av.config;

import com.tencent.av.AVLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;

public class ConfigInfo
{
  private static String TAG = "ConfigInfo";
  private static volatile ConfigInfo instance;
  
  private ConfigInfo()
  {
    init();
    cacheMethodIds();
  }
  
  private static native void cacheMethodIds();
  
  private native void init();
  
  /* Error */
  public static ConfigInfo instance()
  {
    // Byte code:
    //   0: getstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/av/config/ConfigInfo
    //   20: dup
    //   21: invokespecial 32	com/tencent/av/config/ConfigInfo:<init>	()V
    //   24: putstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: putstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   39: aload_0
    //   40: invokevirtual 35	java/lang/Exception:printStackTrace	()V
    //   43: goto -16 -> 27
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aconst_null
    //   54: putstatic 31	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   57: aload_0
    //   58: invokevirtual 36	java/lang/Error:printStackTrace	()V
    //   61: goto -34 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	2	0	localConfigInfo	ConfigInfo
    //   34	6	0	localException	Exception
    //   46	5	0	localObject	Object
    //   52	6	0	localError	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   17	27	34	java/lang/Exception
    //   9	13	46	finally
    //   17	27	46	finally
    //   27	30	46	finally
    //   35	43	46	finally
    //   47	50	46	finally
    //   53	61	46	finally
    //   17	27	52	java/lang/Error
  }
  
  public byte[] getConfigInfoFromFile()
  {
    return Common.a(BaseApplicationImpl.getContext(), "VideoConfigInfo");
  }
  
  public String getSharpConfigPayloadFromFile()
  {
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    if (localObject != null)
    {
      localObject = new String((byte[])localObject);
      int i = ((String)localObject).indexOf('|');
      if (i == -1) {
        return "";
      }
      String str1 = ((String)localObject).substring(0, i);
      String str2 = ((String)localObject).substring(i + 1);
      AVLog.c(TAG, "getSharpConfigPayloadFromFile " + (String)localObject + "|" + str1 + ". payload: " + str2);
      return str2;
    }
    AVLog.c(TAG, "getSharpConfigPayloadFromFile payloadBuf NULL");
    return "";
  }
  
  public int getSharpConfigVersionFromFile()
  {
    int i = 0;
    Object localObject = Common.a(BaseApplicationImpl.getContext(), "SharpConfigPayload");
    String str1;
    if (localObject != null)
    {
      str1 = new String((byte[])localObject);
      i = str1.indexOf('|');
      if (i <= 0) {
        break label149;
      }
      localObject = str1.substring(0, i);
      String str2 = str1.substring(i + 1);
      if (QLog.isColorLevel()) {
        QLog.w(TAG, 1, "getSharpConfigVersionFromFile, payloadBufTmp[" + str1 + "], version[" + (String)localObject + "], payload[" + str2 + "]");
      }
    }
    try
    {
      i = Integer.parseInt((String)localObject);
      return i;
    }
    catch (Exception localException)
    {
      QLog.w(TAG, 1, "getSharpConfigVersionFromFile Exception, payloadBufTmp[" + str1 + "]", localException);
      return 0;
    }
    label149:
    QLog.w(TAG, 1, "getSharpConfigVersionFromFile fail, payloadBufTmp[" + str1 + "]");
    HexUtil.b(TAG, localException);
    return 0;
  }
  
  public void writeConfigInfoToFile(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */