package com.tencent.mobileqq.activity.aio.tips;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LightalkBlueTipsBarData
{
  public static final String a;
  public static final String b;
  public static final String c;
  private static LightalkBlueTipsBarData f = null;
  public String d;
  public String e;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("lightalkfiles");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("aio_lightalk_tips_config");
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("aio_lightalk_tips_icon");
    c = localStringBuilder.toString();
  }
  
  public static LightalkBlueTipsBarData a()
  {
    long l1 = SystemClock.uptimeMillis();
    b();
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("read config cost ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(" , result is ");
      boolean bool;
      if (f == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("LightalkBlueTipsBar", 2, localStringBuilder.toString());
    }
    return f;
  }
  
  /* Error */
  private static void b()
  {
    // Byte code:
    //   0: getstatic 61	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   3: ifnull +4 -> 7
    //   6: return
    //   7: new 37	java/io/File
    //   10: dup
    //   11: getstatic 55	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:b	Ljava/lang/String;
    //   14: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore_0
    //   18: new 37	java/io/File
    //   21: dup
    //   22: getstatic 59	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:c	Ljava/lang/String;
    //   25: invokespecial 100	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_0
    //   30: invokevirtual 103	java/io/File:exists	()Z
    //   33: ifeq +205 -> 238
    //   36: aload_0
    //   37: invokevirtual 106	java/io/File:length	()J
    //   40: lconst_0
    //   41: lcmp
    //   42: ifle +196 -> 238
    //   45: aload_1
    //   46: invokevirtual 103	java/io/File:exists	()Z
    //   49: ifeq +189 -> 238
    //   52: new 108	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 111	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_1
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 115	java/io/FileInputStream:available	()I
    //   67: newarray byte
    //   69: astore_2
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 119	java/io/FileInputStream:read	([B)I
    //   77: pop
    //   78: aload_1
    //   79: astore_0
    //   80: new 121	java/lang/String
    //   83: dup
    //   84: aload_2
    //   85: ldc 123
    //   87: invokespecial 126	java/lang/String:<init>	([BLjava/lang/String;)V
    //   90: ldc 128
    //   92: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   95: astore_2
    //   96: aload_1
    //   97: astore_0
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_2
    //   101: if_icmpne +37 -> 138
    //   104: aload_1
    //   105: astore_0
    //   106: new 2	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData
    //   109: dup
    //   110: invokespecial 133	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:<init>	()V
    //   113: putstatic 61	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   116: aload_1
    //   117: astore_0
    //   118: getstatic 61	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   121: aload_2
    //   122: iconst_0
    //   123: aaload
    //   124: putfield 135	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:d	Ljava/lang/String;
    //   127: aload_1
    //   128: astore_0
    //   129: getstatic 61	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   132: aload_2
    //   133: iconst_1
    //   134: aaload
    //   135: putfield 137	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:e	Ljava/lang/String;
    //   138: aload_1
    //   139: invokevirtual 140	java/io/FileInputStream:close	()V
    //   142: return
    //   143: astore_0
    //   144: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +105 -> 252
    //   150: ldc 90
    //   152: iconst_2
    //   153: ldc 142
    //   155: aload_0
    //   156: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: return
    //   160: astore_2
    //   161: goto +12 -> 173
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_1
    //   167: goto +42 -> 209
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: astore_0
    //   175: aload_2
    //   176: invokevirtual 148	java/lang/Exception:printStackTrace	()V
    //   179: aload_1
    //   180: astore_0
    //   181: aconst_null
    //   182: putstatic 61	com/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData:f	Lcom/tencent/mobileqq/activity/aio/tips/LightalkBlueTipsBarData;
    //   185: aload_1
    //   186: ifnull +66 -> 252
    //   189: aload_1
    //   190: invokevirtual 140	java/io/FileInputStream:close	()V
    //   193: return
    //   194: astore_0
    //   195: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +54 -> 252
    //   201: goto -51 -> 150
    //   204: astore_2
    //   205: aload_0
    //   206: astore_1
    //   207: aload_2
    //   208: astore_0
    //   209: aload_1
    //   210: ifnull +26 -> 236
    //   213: aload_1
    //   214: invokevirtual 140	java/io/FileInputStream:close	()V
    //   217: goto +19 -> 236
    //   220: astore_1
    //   221: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 90
    //   229: iconst_2
    //   230: ldc 142
    //   232: aload_1
    //   233: invokestatic 145	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: aload_0
    //   237: athrow
    //   238: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +11 -> 252
    //   244: ldc 90
    //   246: iconst_2
    //   247: ldc 150
    //   249: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   17	112	0	localObject1	Object
    //   143	13	0	localIOException1	java.io.IOException
    //   164	1	0	localObject2	Object
    //   174	7	0	localObject3	Object
    //   194	12	0	localIOException2	java.io.IOException
    //   208	29	0	localObject4	Object
    //   28	186	1	localObject5	Object
    //   220	13	1	localIOException3	java.io.IOException
    //   69	64	2	localObject6	Object
    //   160	1	2	localException1	java.lang.Exception
    //   170	6	2	localException2	java.lang.Exception
    //   204	4	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   138	142	143	java/io/IOException
    //   63	70	160	java/lang/Exception
    //   72	78	160	java/lang/Exception
    //   80	96	160	java/lang/Exception
    //   98	104	160	java/lang/Exception
    //   106	116	160	java/lang/Exception
    //   118	127	160	java/lang/Exception
    //   129	138	160	java/lang/Exception
    //   52	61	164	finally
    //   52	61	170	java/lang/Exception
    //   189	193	194	java/io/IOException
    //   63	70	204	finally
    //   72	78	204	finally
    //   80	96	204	finally
    //   98	104	204	finally
    //   106	116	204	finally
    //   118	127	204	finally
    //   129	138	204	finally
    //   175	179	204	finally
    //   181	185	204	finally
    //   213	217	220	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBarData
 * JD-Core Version:    0.7.0.1
 */