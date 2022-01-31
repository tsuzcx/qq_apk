package com.qq.android.dexposed;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeviceCheck
{
  private static final String LIB_ART = "libart.so";
  private static final String LIB_ART_D = "libartd.so";
  private static final String LIB_DALVIK = "libdvm.so";
  private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
  private static boolean isCheckedDeviceSupport = false;
  private static boolean isDeviceSupportable = false;
  
  /* Error */
  private static String getCurrentRuntimeValue()
  {
    // Byte code:
    //   0: ldc 44
    //   2: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore_1
    //   6: aload_1
    //   7: ldc 52
    //   9: iconst_2
    //   10: anewarray 46	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 54
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: ldc 54
    //   22: aastore
    //   23: invokevirtual 58	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnonnull +8 -> 36
    //   31: ldc 60
    //   33: astore_1
    //   34: aload_1
    //   35: areturn
    //   36: aload_2
    //   37: aload_1
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: ldc 17
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 62
    //   51: aastore
    //   52: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 54	java/lang/String
    //   58: astore_1
    //   59: ldc 14
    //   61: aload_1
    //   62: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: istore_0
    //   66: iload_0
    //   67: ifeq +6 -> 73
    //   70: ldc 62
    //   72: areturn
    //   73: ldc 8
    //   75: aload_1
    //   76: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: istore_0
    //   80: iload_0
    //   81: ifeq +6 -> 87
    //   84: ldc 74
    //   86: areturn
    //   87: ldc 11
    //   89: aload_1
    //   90: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: istore_0
    //   94: iload_0
    //   95: ifeq -61 -> 34
    //   98: ldc 76
    //   100: areturn
    //   101: astore_1
    //   102: ldc 78
    //   104: areturn
    //   105: astore_1
    //   106: ldc 80
    //   108: areturn
    //   109: astore_1
    //   110: ldc 82
    //   112: areturn
    //   113: astore_1
    //   114: ldc 84
    //   116: areturn
    //   117: astore_1
    //   118: ldc 86
    //   120: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   65	30	0	bool	boolean
    //   5	85	1	localObject	Object
    //   101	1	1	localIllegalAccessException	IllegalAccessException
    //   105	1	1	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   109	1	1	localInvocationTargetException	InvocationTargetException
    //   113	1	1	localNoSuchMethodException	NoSuchMethodException
    //   117	1	1	localClassNotFoundException	ClassNotFoundException
    //   26	11	2	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   36	66	101	java/lang/IllegalAccessException
    //   73	80	101	java/lang/IllegalAccessException
    //   87	94	101	java/lang/IllegalAccessException
    //   36	66	105	java/lang/IllegalArgumentException
    //   73	80	105	java/lang/IllegalArgumentException
    //   87	94	105	java/lang/IllegalArgumentException
    //   36	66	109	java/lang/reflect/InvocationTargetException
    //   73	80	109	java/lang/reflect/InvocationTargetException
    //   87	94	109	java/lang/reflect/InvocationTargetException
    //   6	27	113	java/lang/NoSuchMethodException
    //   36	66	113	java/lang/NoSuchMethodException
    //   73	80	113	java/lang/NoSuchMethodException
    //   87	94	113	java/lang/NoSuchMethodException
    //   0	6	117	java/lang/ClassNotFoundException
    //   6	27	117	java/lang/ClassNotFoundException
    //   36	66	117	java/lang/ClassNotFoundException
    //   73	80	117	java/lang/ClassNotFoundException
    //   87	94	117	java/lang/ClassNotFoundException
  }
  
  private static boolean isDalvikMode()
  {
    return "Dalvik".equals(getCurrentRuntimeValue());
  }
  
  public static boolean isDeviceSupport(Context paramContext)
  {
    try
    {
      if (isCheckedDeviceSupport) {
        bool = isDeviceSupportable;
      }
    }
    finally
    {
      boolean bool;
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
    }
    try
    {
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
      return bool;
    }
    finally {}
    if ((!isX86CPU()) && (!isYunOS())) {}
    for (isDeviceSupportable = true;; isDeviceSupportable = false)
    {
      Log.d("hotpatch", "device support is " + isDeviceSupportable + "checked" + isCheckedDeviceSupport);
      isCheckedDeviceSupport = true;
      bool = isDeviceSupportable;
      break;
    }
  }
  
  private static boolean isSupportSDKVersion()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (Build.VERSION.SDK_INT < 20)) {}
    while ((Build.VERSION.SDK_INT == 10) || (Build.VERSION.SDK_INT == 9)) {
      return true;
    }
    return false;
  }
  
  /* Error */
  private static boolean isX86CPU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 7
    //   8: aconst_null
    //   9: astore 8
    //   11: aconst_null
    //   12: astore 5
    //   14: aconst_null
    //   15: astore 6
    //   17: invokestatic 140	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: ldc 142
    //   22: invokevirtual 146	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   25: astore_1
    //   26: aload_1
    //   27: astore_3
    //   28: aload_1
    //   29: astore 4
    //   31: new 148	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: invokevirtual 154	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: astore_2
    //   43: new 159	java/io/BufferedReader
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 162	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 165	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: ldc 167
    //   58: invokevirtual 171	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   61: istore_0
    //   62: iload_0
    //   63: ifeq +99 -> 162
    //   66: aload_3
    //   67: ifnull +7 -> 74
    //   70: aload_3
    //   71: invokevirtual 174	java/io/BufferedReader:close	()V
    //   74: aload_2
    //   75: ifnull +7 -> 82
    //   78: aload_2
    //   79: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 178	java/lang/Process:destroy	()V
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: aload_3
    //   94: astore_1
    //   95: aload 8
    //   97: astore_2
    //   98: aload 6
    //   100: astore_3
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 174	java/io/BufferedReader:close	()V
    //   109: aload_2
    //   110: ifnull +7 -> 117
    //   113: aload_2
    //   114: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 178	java/lang/Process:destroy	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload 7
    //   130: astore_2
    //   131: aload 5
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +7 -> 142
    //   138: aload_3
    //   139: invokevirtual 174	java/io/BufferedReader:close	()V
    //   142: aload_2
    //   143: ifnull +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 178	java/lang/Process:destroy	()V
    //   160: aload_1
    //   161: athrow
    //   162: aload_3
    //   163: ifnull +7 -> 170
    //   166: aload_3
    //   167: invokevirtual 174	java/io/BufferedReader:close	()V
    //   170: aload_2
    //   171: ifnull +7 -> 178
    //   174: aload_2
    //   175: invokevirtual 175	java/io/InputStreamReader:close	()V
    //   178: aload_1
    //   179: ifnull +95 -> 274
    //   182: aload_1
    //   183: invokevirtual 178	java/lang/Process:destroy	()V
    //   186: goto -61 -> 125
    //   189: astore_1
    //   190: goto -65 -> 125
    //   193: astore_3
    //   194: goto -120 -> 74
    //   197: astore_2
    //   198: goto -116 -> 82
    //   201: astore_1
    //   202: goto -112 -> 90
    //   205: astore_3
    //   206: goto -97 -> 109
    //   209: astore_2
    //   210: goto -93 -> 117
    //   213: astore_1
    //   214: goto -89 -> 125
    //   217: astore_3
    //   218: goto -76 -> 142
    //   221: astore_2
    //   222: goto -72 -> 150
    //   225: astore_2
    //   226: goto -66 -> 160
    //   229: astore_3
    //   230: goto -60 -> 170
    //   233: astore_2
    //   234: goto -56 -> 178
    //   237: astore 6
    //   239: aload 5
    //   241: astore_3
    //   242: aload_1
    //   243: astore 4
    //   245: aload 6
    //   247: astore_1
    //   248: goto -114 -> 134
    //   251: astore 5
    //   253: aload_1
    //   254: astore 4
    //   256: aload 5
    //   258: astore_1
    //   259: goto -125 -> 134
    //   262: astore_3
    //   263: aload 6
    //   265: astore_3
    //   266: goto -165 -> 101
    //   269: astore 4
    //   271: goto -170 -> 101
    //   274: goto -149 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   61	2	0	bool	boolean
    //   25	62	1	localProcess	java.lang.Process
    //   92	1	1	localException1	java.lang.Exception
    //   94	28	1	localObject1	Object
    //   127	56	1	localObject2	Object
    //   189	1	1	localException2	java.lang.Exception
    //   201	1	1	localException3	java.lang.Exception
    //   213	30	1	localException4	java.lang.Exception
    //   247	12	1	localObject3	Object
    //   42	133	2	localObject4	Object
    //   197	1	2	localException5	java.lang.Exception
    //   209	1	2	localException6	java.lang.Exception
    //   221	1	2	localException7	java.lang.Exception
    //   225	1	2	localException8	java.lang.Exception
    //   233	1	2	localException9	java.lang.Exception
    //   4	163	3	localObject5	Object
    //   193	1	3	localException10	java.lang.Exception
    //   205	1	3	localException11	java.lang.Exception
    //   217	1	3	localException12	java.lang.Exception
    //   229	1	3	localException13	java.lang.Exception
    //   241	1	3	localObject6	Object
    //   262	1	3	localException14	java.lang.Exception
    //   265	1	3	localObject7	Object
    //   1	254	4	localObject8	Object
    //   269	1	4	localException15	java.lang.Exception
    //   12	228	5	localObject9	Object
    //   251	6	5	localObject10	Object
    //   15	84	6	localObject11	Object
    //   237	27	6	localObject12	Object
    //   6	123	7	localObject13	Object
    //   9	87	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	92	java/lang/Exception
    //   31	43	92	java/lang/Exception
    //   17	26	127	finally
    //   31	43	127	finally
    //   182	186	189	java/lang/Exception
    //   70	74	193	java/lang/Exception
    //   78	82	197	java/lang/Exception
    //   86	90	201	java/lang/Exception
    //   105	109	205	java/lang/Exception
    //   113	117	209	java/lang/Exception
    //   121	125	213	java/lang/Exception
    //   138	142	217	java/lang/Exception
    //   146	150	221	java/lang/Exception
    //   155	160	225	java/lang/Exception
    //   166	170	229	java/lang/Exception
    //   174	178	233	java/lang/Exception
    //   43	52	237	finally
    //   52	62	251	finally
    //   43	52	262	java/lang/Exception
    //   52	62	269	java/lang/Exception
  }
  
  @SuppressLint({"DefaultLocale"})
  public static boolean isYunOS()
  {
    String str3 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    String str1 = null;
    localObject8 = null;
    localObject5 = str1;
    str2 = str3;
    localObject6 = localObject9;
    localObject7 = localObject10;
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      localObject5 = str1;
      str2 = str3;
      localObject6 = localObject9;
      localObject7 = localObject10;
      str1 = (String)localMethod.invoke(null, new Object[] { "ro.yunos.version" });
      localObject5 = str1;
      str2 = str1;
      localObject6 = str1;
      localObject7 = str1;
      str3 = (String)localMethod.invoke(null, new Object[] { "java.vm.name" });
      localObject5 = str3;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        Object localObject1 = localObject5;
        localObject5 = localObject8;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Object localObject2 = str2;
        localObject5 = localObject8;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject3 = localObject6;
        localObject5 = localObject8;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        Object localObject4 = localObject7;
        localObject5 = localObject8;
      }
    }
    return ((localObject5 != null) && (((String)localObject5).toLowerCase().contains("lemur"))) || ((str1 != null) && (str1.trim().length() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.android.dexposed.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */