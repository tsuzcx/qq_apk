package com.tencent.av.config;

import android.content.Context;
import bgmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import lbc;

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
  
  public static String getSharpConfigPayloadFromFile(Context paramContext)
  {
    paramContext = Common.a(paramContext, Common.b);
    if (paramContext != null)
    {
      paramContext = new String(paramContext);
      int i = paramContext.indexOf('|');
      if (i == -1) {
        return "";
      }
      String str1 = paramContext.substring(0, i);
      String str2 = paramContext.substring(i + 1);
      lbc.c(TAG, "getSharpConfigPayloadFromFile FileName=" + Common.b + "| payloadBuf:" + paramContext + "| version=" + str1 + "| payload=" + str2);
      return str2;
    }
    lbc.c(TAG, "getSharpConfigPayloadFromFile payloadBuf NULL");
    return "";
  }
  
  public static int getSharpConfigVersionFromFile(Context paramContext)
  {
    int j = 0;
    Object localObject = Common.a(paramContext, Common.b);
    int i = j;
    if (localObject != null)
    {
      paramContext = new String((byte[])localObject);
      i = paramContext.indexOf('|');
      if (i <= 0) {
        break label150;
      }
      localObject = paramContext.substring(0, i);
      String str = paramContext.substring(i + 1);
      if (QLog.isDevelopLevel()) {
        QLog.w(TAG, 1, "getSharpConfigVersionFromFile, payloadBufTmp[" + paramContext + "], version[" + (String)localObject + "], payload[" + str + "]");
      }
    }
    label150:
    do
    {
      try
      {
        i = Integer.parseInt((String)localObject);
        return i;
      }
      catch (Exception localException)
      {
        QLog.w(TAG, 1, "getSharpConfigVersionFromFile Exception, payloadBufTmp[" + paramContext + "]", localException);
        return 0;
      }
      i = j;
    } while (!QLog.isDevelopLevel());
    QLog.w(TAG, 1, "getSharpConfigVersionFromFile fail, payloadBufTmp[" + paramContext + "]");
    bgmj.b(TAG, localException);
    return 0;
  }
  
  private native void init();
  
  /* Error */
  public static ConfigInfo instance()
  {
    // Byte code:
    //   0: getstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   3: ifnonnull +27 -> 30
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +13 -> 27
    //   17: new 2	com/tencent/av/config/ConfigInfo
    //   20: dup
    //   21: invokespecial 126	com/tencent/av/config/ConfigInfo:<init>	()V
    //   24: putstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   27: ldc 2
    //   29: monitorexit
    //   30: getstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: putstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   39: aload_0
    //   40: invokevirtual 129	java/lang/Exception:printStackTrace	()V
    //   43: goto -16 -> 27
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aconst_null
    //   54: putstatic 125	com/tencent/av/config/ConfigInfo:instance	Lcom/tencent/av/config/ConfigInfo;
    //   57: aload_0
    //   58: invokevirtual 130	java/lang/Error:printStackTrace	()V
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
  
  @Deprecated
  public String getSharpConfigPayloadFromFile()
  {
    return getSharpConfigPayloadFromFile(BaseApplicationImpl.getContext());
  }
  
  @Deprecated
  public int getSharpConfigVersionFromFile()
  {
    return getSharpConfigVersionFromFile(BaseApplicationImpl.getContext());
  }
  
  public void writeConfigInfoToFile(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */