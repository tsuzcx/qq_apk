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
  
  private static String getCurrentRuntimeValue()
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Object localObject;
      Method localMethod;
      boolean bool;
      label99:
      label102:
      label105:
      label108:
      label111:
      break label111;
    }
    try
    {
      localMethod = ((Class)localObject).getMethod("get", new Class[] { String.class, String.class });
      if (localMethod == null) {
        return "WTF?!";
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label108;
    }
    try
    {
      localObject = (String)localMethod.invoke(localObject, new Object[] { "persist.sys.dalvik.vm.lib", "Dalvik" });
      if ("libdvm.so".equals(localObject)) {
        return "Dalvik";
      }
      bool = "libart.so".equals(localObject);
      if (bool) {
        return "ART";
      }
      bool = "libartd.so".equals(localObject);
      if (bool) {
        return "ART debug build";
      }
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label105;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label102;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      break label99;
    }
    return "InvocationTargetException";
    return "IllegalArgumentException";
    return "IllegalAccessException";
    return "SystemProperties.get(String key, String def) method is not found";
    return "SystemProperties class is not found";
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
      StringBuilder localStringBuilder = new StringBuilder("device support is ");
      localStringBuilder.append(isDeviceSupportable);
      localStringBuilder.append("checked");
      localStringBuilder.append(isCheckedDeviceSupport);
      Log.d("hotpatch", localStringBuilder.toString());
      isCheckedDeviceSupport = true;
    }
    try
    {
      paramContext = new StringBuilder("device support is ");
      paramContext.append(isDeviceSupportable);
      paramContext.append("checked");
      paramContext.append(isCheckedDeviceSupport);
      Log.d("hotpatch", paramContext.toString());
      isCheckedDeviceSupport = true;
      return bool;
    }
    finally {}
    if ((!isX86CPU()) && (!isYunOS())) {
      isDeviceSupportable = true;
    } else {
      isDeviceSupportable = false;
    }
    paramContext = new StringBuilder("device support is ");
    paramContext.append(isDeviceSupportable);
    paramContext.append("checked");
    paramContext.append(isCheckedDeviceSupport);
    Log.d("hotpatch", paramContext.toString());
    isCheckedDeviceSupport = true;
    bool = isDeviceSupportable;
    return bool;
  }
  
  private static boolean isSupportSDKVersion()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (Build.VERSION.SDK_INT < 20)) {
      return true;
    }
    if (Build.VERSION.SDK_INT != 10) {
      return Build.VERSION.SDK_INT == 9;
    }
    return true;
  }
  
  /* Error */
  private static boolean isX86CPU()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 141	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: ldc 143
    //   8: invokevirtual 147	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   11: astore_2
    //   12: new 149	java/io/InputStreamReader
    //   15: dup
    //   16: aload_2
    //   17: invokevirtual 155	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   20: invokespecial 158	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore_3
    //   24: new 160	java/io/BufferedReader
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore 5
    //   34: aload 5
    //   36: invokevirtual 166	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: ldc 168
    //   41: invokevirtual 172	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: istore_0
    //   45: iload_0
    //   46: ifeq +22 -> 68
    //   49: aload 5
    //   51: invokevirtual 175	java/io/BufferedReader:close	()V
    //   54: aload_3
    //   55: invokevirtual 176	java/io/InputStreamReader:close	()V
    //   58: aload_2
    //   59: ifnull +7 -> 66
    //   62: aload_2
    //   63: invokevirtual 179	java/lang/Process:destroy	()V
    //   66: iconst_1
    //   67: ireturn
    //   68: aload 5
    //   70: invokevirtual 175	java/io/BufferedReader:close	()V
    //   73: aload_3
    //   74: invokevirtual 176	java/io/InputStreamReader:close	()V
    //   77: aload_2
    //   78: ifnull +145 -> 223
    //   81: aload_2
    //   82: invokevirtual 179	java/lang/Process:destroy	()V
    //   85: goto +138 -> 223
    //   88: astore_1
    //   89: aload_2
    //   90: astore 4
    //   92: aload 5
    //   94: astore_2
    //   95: goto +59 -> 154
    //   98: aload 5
    //   100: astore 4
    //   102: aload_3
    //   103: astore_1
    //   104: goto +88 -> 192
    //   107: astore_1
    //   108: aconst_null
    //   109: astore 5
    //   111: aload_2
    //   112: astore 4
    //   114: aload 5
    //   116: astore_2
    //   117: goto +37 -> 154
    //   120: aload_3
    //   121: astore_1
    //   122: goto +70 -> 192
    //   125: astore_1
    //   126: aconst_null
    //   127: astore 5
    //   129: aload 5
    //   131: astore_3
    //   132: aload_2
    //   133: astore 4
    //   135: aload 5
    //   137: astore_2
    //   138: goto +16 -> 154
    //   141: aconst_null
    //   142: astore_1
    //   143: goto +49 -> 192
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_3
    //   149: aload_3
    //   150: astore_2
    //   151: aload_2
    //   152: astore 4
    //   154: aload_2
    //   155: ifnull +10 -> 165
    //   158: aload_2
    //   159: invokevirtual 175	java/io/BufferedReader:close	()V
    //   162: goto +3 -> 165
    //   165: aload_3
    //   166: ifnull +10 -> 176
    //   169: aload_3
    //   170: invokevirtual 176	java/io/InputStreamReader:close	()V
    //   173: goto +3 -> 176
    //   176: aload 4
    //   178: ifnull +8 -> 186
    //   181: aload 4
    //   183: invokevirtual 179	java/lang/Process:destroy	()V
    //   186: aload_1
    //   187: athrow
    //   188: aconst_null
    //   189: astore_2
    //   190: aload_2
    //   191: astore_1
    //   192: aload 4
    //   194: ifnull +11 -> 205
    //   197: aload 4
    //   199: invokevirtual 175	java/io/BufferedReader:close	()V
    //   202: goto +3 -> 205
    //   205: aload_1
    //   206: ifnull +10 -> 216
    //   209: aload_1
    //   210: invokevirtual 176	java/io/InputStreamReader:close	()V
    //   213: goto +3 -> 216
    //   216: aload_2
    //   217: ifnull +6 -> 223
    //   220: goto -139 -> 81
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_1
    //   226: goto -38 -> 188
    //   229: astore_1
    //   230: goto -89 -> 141
    //   233: astore_1
    //   234: goto -114 -> 120
    //   237: astore_1
    //   238: goto -140 -> 98
    //   241: astore_1
    //   242: goto -188 -> 54
    //   245: astore_1
    //   246: goto -188 -> 58
    //   249: astore_1
    //   250: goto -184 -> 66
    //   253: astore_1
    //   254: goto -181 -> 73
    //   257: astore_1
    //   258: goto -181 -> 77
    //   261: astore_1
    //   262: goto -39 -> 223
    //   265: astore_2
    //   266: goto -101 -> 165
    //   269: astore_2
    //   270: goto -94 -> 176
    //   273: astore_2
    //   274: goto -88 -> 186
    //   277: astore_3
    //   278: goto -73 -> 205
    //   281: astore_1
    //   282: goto -66 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	2	0	bool	boolean
    //   88	1	1	localObject1	Object
    //   103	1	1	localObject2	Object
    //   107	1	1	localObject3	Object
    //   121	1	1	localObject4	Object
    //   125	1	1	localObject5	Object
    //   142	1	1	localObject6	Object
    //   146	41	1	localObject7	Object
    //   191	19	1	localObject8	Object
    //   225	1	1	localException1	java.lang.Exception
    //   229	1	1	localException2	java.lang.Exception
    //   233	1	1	localException3	java.lang.Exception
    //   237	1	1	localException4	java.lang.Exception
    //   241	1	1	localException5	java.lang.Exception
    //   245	1	1	localException6	java.lang.Exception
    //   249	1	1	localException7	java.lang.Exception
    //   253	1	1	localException8	java.lang.Exception
    //   257	1	1	localException9	java.lang.Exception
    //   261	1	1	localException10	java.lang.Exception
    //   281	1	1	localException11	java.lang.Exception
    //   11	206	2	localObject9	Object
    //   265	1	2	localException12	java.lang.Exception
    //   269	1	2	localException13	java.lang.Exception
    //   273	1	2	localException14	java.lang.Exception
    //   23	147	3	localObject10	Object
    //   277	1	3	localException15	java.lang.Exception
    //   1	197	4	localObject11	Object
    //   32	104	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   34	45	88	finally
    //   24	34	107	finally
    //   12	24	125	finally
    //   3	12	146	finally
    //   3	12	225	java/lang/Exception
    //   12	24	229	java/lang/Exception
    //   24	34	233	java/lang/Exception
    //   34	45	237	java/lang/Exception
    //   49	54	241	java/lang/Exception
    //   54	58	245	java/lang/Exception
    //   62	66	249	java/lang/Exception
    //   68	73	253	java/lang/Exception
    //   73	77	257	java/lang/Exception
    //   81	85	261	java/lang/Exception
    //   158	162	265	java/lang/Exception
    //   169	173	269	java/lang/Exception
    //   181	186	273	java/lang/Exception
    //   197	202	277	java/lang/Exception
    //   209	213	281	java/lang/Exception
  }
  
  @SuppressLint({"DefaultLocale"})
  public static boolean isYunOS()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      str = (String)((Method)localObject2).invoke(null, new Object[] { "ro.yunos.version" });
    }
    catch (NoSuchMethodException|ClassNotFoundException|IllegalAccessException|InvocationTargetException localNoSuchMethodException1)
    {
      Object localObject2;
      String str;
      label63:
      label66:
      label68:
      break label66;
    }
    try
    {
      localObject2 = (String)((Method)localObject2).invoke(null, new Object[] { "java.vm.name" });
      localObject1 = localObject2;
    }
    catch (NoSuchMethodException|ClassNotFoundException|IllegalAccessException|InvocationTargetException localNoSuchMethodException2)
    {
      break label63;
    }
    break label68;
    str = null;
    return ((localObject1 != null) && (localObject1.toLowerCase().contains("lemur"))) || ((str != null) && (str.trim().length() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */