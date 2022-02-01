package com.tencent.avcore.config;

import android.content.Context;
import com.tencent.avcore.jni.config.ConfigInfoJni;

public class ConfigInfo
  extends ConfigInfoJni
{
  private static volatile ConfigInfo instance = null;
  
  private ConfigInfo(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  public static ConfigInfo instance(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   3: ifnonnull +28 -> 31
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +14 -> 28
    //   17: new 2	com/tencent/avcore/config/ConfigInfo
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 21	com/tencent/avcore/config/ConfigInfo:<init>	(Landroid/content/Context;)V
    //   25: putstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   34: areturn
    //   35: astore_0
    //   36: aconst_null
    //   37: putstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   40: aload_0
    //   41: invokevirtual 24	java/lang/Exception:printStackTrace	()V
    //   44: goto -16 -> 28
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    //   53: astore_0
    //   54: aconst_null
    //   55: putstatic 10	com/tencent/avcore/config/ConfigInfo:instance	Lcom/tencent/avcore/config/ConfigInfo;
    //   58: aload_0
    //   59: invokevirtual 25	java/lang/Error:printStackTrace	()V
    //   62: goto -34 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   12	2	1	localConfigInfo	ConfigInfo
    // Exception table:
    //   from	to	target	type
    //   17	28	35	java/lang/Exception
    //   9	13	47	finally
    //   17	28	47	finally
    //   28	31	47	finally
    //   36	44	47	finally
    //   48	51	47	finally
    //   54	62	47	finally
    //   17	28	53	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.config.ConfigInfo
 * JD-Core Version:    0.7.0.1
 */