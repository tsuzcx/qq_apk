package com.taobao.android.dexposed;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;

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
    //   5: astore_0
    //   6: aload_0
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
    //   26: astore_1
    //   27: aload_1
    //   28: ifnonnull +8 -> 36
    //   31: ldc 60
    //   33: astore_0
    //   34: aload_0
    //   35: areturn
    //   36: aload_1
    //   37: aload_0
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
    //   65: ifeq +6 -> 71
    //   68: ldc 62
    //   70: areturn
    //   71: ldc 8
    //   73: aload_1
    //   74: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +6 -> 83
    //   80: ldc 74
    //   82: areturn
    //   83: aload_1
    //   84: astore_0
    //   85: ldc 11
    //   87: aload_1
    //   88: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq -57 -> 34
    //   94: ldc 76
    //   96: areturn
    //   97: astore_0
    //   98: ldc 78
    //   100: areturn
    //   101: astore_0
    //   102: ldc 80
    //   104: areturn
    //   105: astore_0
    //   106: ldc 82
    //   108: areturn
    //   109: astore_0
    //   110: ldc 84
    //   112: areturn
    //   113: astore_0
    //   114: ldc 86
    //   116: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	80	0	localObject1	Object
    //   97	1	0	localIllegalAccessException	java.lang.IllegalAccessException
    //   101	1	0	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   105	1	0	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   109	1	0	localClassNotFoundException	java.lang.ClassNotFoundException
    //   113	1	0	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   26	62	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	68	97	java/lang/IllegalAccessException
    //   71	80	97	java/lang/IllegalAccessException
    //   85	94	97	java/lang/IllegalAccessException
    //   36	68	101	java/lang/reflect/InvocationTargetException
    //   71	80	101	java/lang/reflect/InvocationTargetException
    //   85	94	101	java/lang/reflect/InvocationTargetException
    //   6	27	105	java/lang/NoSuchMethodException
    //   36	68	105	java/lang/NoSuchMethodException
    //   71	80	105	java/lang/NoSuchMethodException
    //   85	94	105	java/lang/NoSuchMethodException
    //   0	6	109	java/lang/ClassNotFoundException
    //   6	27	109	java/lang/ClassNotFoundException
    //   36	68	109	java/lang/ClassNotFoundException
    //   71	80	109	java/lang/ClassNotFoundException
    //   85	94	109	java/lang/ClassNotFoundException
    //   36	68	113	java/lang/IllegalArgumentException
    //   71	80	113	java/lang/IllegalArgumentException
    //   85	94	113	java/lang/IllegalArgumentException
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
    //   1: astore 5
    //   3: invokestatic 138	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: ldc 140
    //   8: invokevirtual 144	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   11: astore_1
    //   12: new 146	java/io/InputStreamReader
    //   15: dup
    //   16: aload_1
    //   17: invokevirtual 152	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   20: invokespecial 155	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: astore 4
    //   25: new 157	java/io/BufferedReader
    //   28: dup
    //   29: aload 4
    //   31: invokespecial 160	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   34: astore_3
    //   35: aload_3
    //   36: invokevirtual 163	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: ldc 165
    //   41: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: istore_0
    //   45: iload_0
    //   46: ifeq +31 -> 77
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 172	java/io/BufferedReader:close	()V
    //   57: aload 4
    //   59: ifnull +8 -> 67
    //   62: aload 4
    //   64: invokevirtual 173	java/io/InputStreamReader:close	()V
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 176	java/lang/Process:destroy	()V
    //   75: iconst_1
    //   76: ireturn
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 172	java/io/BufferedReader:close	()V
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 173	java/io/InputStreamReader:close	()V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 176	java/lang/Process:destroy	()V
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: aload 5
    //   112: astore_3
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 172	java/io/BufferedReader:close	()V
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 173	java/io/InputStreamReader:close	()V
    //   129: aload_2
    //   130: ifnull -27 -> 103
    //   133: aload_2
    //   134: invokevirtual 176	java/lang/Process:destroy	()V
    //   137: goto -34 -> 103
    //   140: astore_1
    //   141: goto -38 -> 103
    //   144: astore_2
    //   145: aconst_null
    //   146: astore 4
    //   148: aconst_null
    //   149: astore_1
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 172	java/io/BufferedReader:close	()V
    //   160: aload 4
    //   162: ifnull +8 -> 170
    //   165: aload 4
    //   167: invokevirtual 173	java/io/InputStreamReader:close	()V
    //   170: aload_1
    //   171: ifnull +7 -> 178
    //   174: aload_1
    //   175: invokevirtual 176	java/lang/Process:destroy	()V
    //   178: aload_2
    //   179: athrow
    //   180: astore_2
    //   181: goto -124 -> 57
    //   184: astore_2
    //   185: goto -118 -> 67
    //   188: astore_1
    //   189: iconst_1
    //   190: ireturn
    //   191: astore_2
    //   192: goto -107 -> 85
    //   195: astore_2
    //   196: goto -101 -> 95
    //   199: astore_1
    //   200: goto -97 -> 103
    //   203: astore_3
    //   204: goto -83 -> 121
    //   207: astore_1
    //   208: goto -79 -> 129
    //   211: astore_3
    //   212: goto -52 -> 160
    //   215: astore_3
    //   216: goto -46 -> 170
    //   219: astore_1
    //   220: goto -42 -> 178
    //   223: astore_2
    //   224: aconst_null
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -77 -> 152
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_3
    //   235: goto -83 -> 152
    //   238: astore_2
    //   239: goto -87 -> 152
    //   242: astore_2
    //   243: aconst_null
    //   244: astore 4
    //   246: aload_1
    //   247: astore_2
    //   248: aload 5
    //   250: astore_3
    //   251: aload 4
    //   253: astore_1
    //   254: goto -141 -> 113
    //   257: astore_2
    //   258: aload_1
    //   259: astore_2
    //   260: aload 5
    //   262: astore_3
    //   263: aload 4
    //   265: astore_1
    //   266: goto -153 -> 113
    //   269: astore_2
    //   270: aload_1
    //   271: astore_2
    //   272: aload 4
    //   274: astore_1
    //   275: goto -162 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	2	0	bool	boolean
    //   11	89	1	localProcess	java.lang.Process
    //   105	1	1	localException1	java.lang.Exception
    //   107	19	1	localObject1	Object
    //   140	1	1	localException2	java.lang.Exception
    //   149	26	1	localObject2	Object
    //   188	1	1	localException3	java.lang.Exception
    //   199	1	1	localException4	java.lang.Exception
    //   207	1	1	localException5	java.lang.Exception
    //   219	28	1	localException6	java.lang.Exception
    //   253	22	1	localObject3	Object
    //   109	25	2	localObject4	Object
    //   144	35	2	localObject5	Object
    //   180	1	2	localException7	java.lang.Exception
    //   184	1	2	localException8	java.lang.Exception
    //   191	1	2	localException9	java.lang.Exception
    //   195	1	2	localException10	java.lang.Exception
    //   223	1	2	localObject6	Object
    //   232	1	2	localObject7	Object
    //   238	1	2	localObject8	Object
    //   242	1	2	localException11	java.lang.Exception
    //   247	1	2	localException12	java.lang.Exception
    //   257	1	2	localException13	java.lang.Exception
    //   259	1	2	localObject9	Object
    //   269	1	2	localException14	java.lang.Exception
    //   271	1	2	localObject10	Object
    //   34	123	3	localObject11	Object
    //   203	1	3	localException15	java.lang.Exception
    //   211	1	3	localException16	java.lang.Exception
    //   215	1	3	localException17	java.lang.Exception
    //   228	35	3	localObject12	Object
    //   23	250	4	localInputStreamReader	java.io.InputStreamReader
    //   1	260	5	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	105	java/lang/Exception
    //   133	137	140	java/lang/Exception
    //   3	12	144	finally
    //   53	57	180	java/lang/Exception
    //   62	67	184	java/lang/Exception
    //   71	75	188	java/lang/Exception
    //   81	85	191	java/lang/Exception
    //   90	95	195	java/lang/Exception
    //   99	103	199	java/lang/Exception
    //   117	121	203	java/lang/Exception
    //   125	129	207	java/lang/Exception
    //   156	160	211	java/lang/Exception
    //   165	170	215	java/lang/Exception
    //   174	178	219	java/lang/Exception
    //   12	25	223	finally
    //   25	35	232	finally
    //   35	45	238	finally
    //   12	25	242	java/lang/Exception
    //   25	35	257	java/lang/Exception
    //   35	45	269	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.SuppressLint({"DefaultLocale"})
  public static boolean isYunOS()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 44
    //   4: invokestatic 50	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   7: ldc 52
    //   9: iconst_1
    //   10: anewarray 46	java/lang/Class
    //   13: dup
    //   14: iconst_0
    //   15: ldc 54
    //   17: aastore
    //   18: invokevirtual 58	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   21: astore_2
    //   22: aload_2
    //   23: aconst_null
    //   24: iconst_1
    //   25: anewarray 4	java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: ldc 181
    //   32: aastore
    //   33: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 54	java/lang/String
    //   39: astore_0
    //   40: aload_2
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 183
    //   50: aastore
    //   51: invokevirtual 68	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast 54	java/lang/String
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +15 -> 76
    //   64: aload_1
    //   65: invokevirtual 186	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   68: ldc 188
    //   70: invokevirtual 169	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifne +17 -> 90
    //   76: aload_0
    //   77: ifnull +15 -> 92
    //   80: aload_0
    //   81: invokevirtual 191	java/lang/String:trim	()Ljava/lang/String;
    //   84: invokevirtual 195	java/lang/String:length	()I
    //   87: ifle +5 -> 92
    //   90: iconst_1
    //   91: ireturn
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_0
    //   97: goto -37 -> 60
    //   100: astore_2
    //   101: goto -41 -> 60
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -47 -> 60
    //   110: astore_2
    //   111: goto -51 -> 60
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -57 -> 60
    //   120: astore_2
    //   121: goto -61 -> 60
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_0
    //   127: goto -67 -> 60
    //   130: astore_2
    //   131: goto -71 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	42	0	str	String
    //   94	1	0	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   96	1	0	localObject1	Object
    //   104	1	0	localIllegalAccessException1	java.lang.IllegalAccessException
    //   106	1	0	localObject2	Object
    //   114	1	0	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   116	1	0	localObject3	Object
    //   124	1	0	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   126	1	0	localObject4	Object
    //   1	64	1	localObject5	Object
    //   21	38	2	localObject6	Object
    //   100	1	2	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   110	1	2	localIllegalAccessException2	java.lang.IllegalAccessException
    //   120	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   130	1	2	localNoSuchMethodException2	java.lang.NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   2	40	94	java/lang/reflect/InvocationTargetException
    //   40	58	100	java/lang/reflect/InvocationTargetException
    //   2	40	104	java/lang/IllegalAccessException
    //   40	58	110	java/lang/IllegalAccessException
    //   2	40	114	java/lang/ClassNotFoundException
    //   40	58	120	java/lang/ClassNotFoundException
    //   2	40	124	java/lang/NoSuchMethodException
    //   40	58	130	java/lang/NoSuchMethodException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */