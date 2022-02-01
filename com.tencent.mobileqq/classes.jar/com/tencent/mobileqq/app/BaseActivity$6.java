package com.tencent.mobileqq.app;

class BaseActivity$6
  implements Runnable
{
  BaseActivity$6(BaseActivity paramBaseActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 29
    //   2: monitorenter
    //   3: invokestatic 33	com/tencent/mobileqq/app/BaseActivity:access$300	()Lanuu;
    //   6: ifnonnull +60 -> 66
    //   9: new 35	ania
    //   12: dup
    //   13: aconst_null
    //   14: invokespecial 38	ania:<init>	(Lcom/tencent/mobileqq/app/BaseActivity$1;)V
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 12	com/tencent/mobileqq/app/BaseActivity$6:this$0	Lcom/tencent/mobileqq/app/BaseActivity;
    //   22: invokevirtual 42	com/tencent/mobileqq/app/BaseActivity:getApplicationContext	()Landroid/content/Context;
    //   25: ldc 44
    //   27: invokevirtual 50	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 52	android/hardware/SensorManager
    //   33: astore_2
    //   34: aload_2
    //   35: iconst_1
    //   36: invokevirtual 56	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   39: astore 4
    //   41: invokestatic 62	bcuf:a	()Lbcuf;
    //   44: invokevirtual 65	bcuf:a	()Z
    //   47: ifeq +238 -> 285
    //   50: iconst_2
    //   51: istore_1
    //   52: aload_2
    //   53: aload_3
    //   54: aload 4
    //   56: iload_1
    //   57: invokevirtual 69	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   60: pop
    //   61: aload_3
    //   62: invokestatic 73	com/tencent/mobileqq/app/BaseActivity:access$302	(Lanuu;)Lanuu;
    //   65: pop
    //   66: ldc 29
    //   68: monitorexit
    //   69: return
    //   70: astore_3
    //   71: new 75	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 77
    //   77: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: astore 4
    //   82: ldc 82
    //   84: invokestatic 88	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   87: ldc 90
    //   89: invokevirtual 94	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   92: astore 5
    //   94: aload 5
    //   96: iconst_1
    //   97: invokevirtual 100	java/lang/reflect/Field:setAccessible	(Z)V
    //   100: aload 5
    //   102: aload_2
    //   103: invokevirtual 104	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 106	java/util/HashMap
    //   109: invokevirtual 110	java/util/HashMap:keySet	()Ljava/util/Set;
    //   112: invokeinterface 116 1 0
    //   117: astore_2
    //   118: aload_2
    //   119: invokeinterface 121 1 0
    //   124: ifeq +84 -> 208
    //   127: aload 4
    //   129: aload_2
    //   130: invokeinterface 125 1 0
    //   135: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: ldc 131
    //   140: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: goto -26 -> 118
    //   147: astore_2
    //   148: new 75	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   155: ldc 137
    //   157: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_2
    //   161: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: astore_2
    //   168: aload_2
    //   169: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +17 -> 189
    //   175: aload 4
    //   177: aload_2
    //   178: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 149
    //   184: iconst_1
    //   185: aload_2
    //   186: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_3
    //   190: aload 4
    //   192: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 160	bcrp:a	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   198: ldc 29
    //   200: monitorexit
    //   201: return
    //   202: astore_2
    //   203: ldc 29
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -42 -> 168
    //   213: astore_2
    //   214: new 75	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   221: ldc 162
    //   223: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload_2
    //   227: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore_2
    //   234: goto -66 -> 168
    //   237: astore_2
    //   238: new 75	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   245: ldc 164
    //   247: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_2
    //   251: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: astore_2
    //   258: goto -90 -> 168
    //   261: astore_2
    //   262: new 75	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   269: ldc 166
    //   271: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_2
    //   275: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore_2
    //   282: goto -114 -> 168
    //   285: iconst_0
    //   286: istore_1
    //   287: goto -235 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	6
    //   51	236	1	i	int
    //   33	97	2	localObject1	Object
    //   147	14	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   167	19	2	str1	java.lang.String
    //   202	5	2	localObject2	Object
    //   209	1	2	localObject3	Object
    //   213	14	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   233	1	2	str2	java.lang.String
    //   237	14	2	localIllegalAccessException	java.lang.IllegalAccessException
    //   257	1	2	str3	java.lang.String
    //   261	14	2	localThrowable	java.lang.Throwable
    //   281	1	2	str4	java.lang.String
    //   17	45	3	localania	ania
    //   70	120	3	localIllegalStateException	java.lang.IllegalStateException
    //   39	152	4	localObject4	Object
    //   92	9	5	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   34	50	70	java/lang/IllegalStateException
    //   52	61	70	java/lang/IllegalStateException
    //   82	118	147	java/lang/ClassNotFoundException
    //   118	144	147	java/lang/ClassNotFoundException
    //   3	34	202	finally
    //   34	50	202	finally
    //   52	61	202	finally
    //   61	66	202	finally
    //   66	69	202	finally
    //   71	82	202	finally
    //   82	118	202	finally
    //   118	144	202	finally
    //   148	168	202	finally
    //   168	189	202	finally
    //   189	201	202	finally
    //   203	206	202	finally
    //   214	234	202	finally
    //   238	258	202	finally
    //   262	282	202	finally
    //   82	118	213	java/lang/NoSuchFieldException
    //   118	144	213	java/lang/NoSuchFieldException
    //   82	118	237	java/lang/IllegalAccessException
    //   118	144	237	java/lang/IllegalAccessException
    //   82	118	261	java/lang/Throwable
    //   118	144	261	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity.6
 * JD-Core Version:    0.7.0.1
 */