package com.tencent.mobileqq.app;

class QBaseActivity$3
  implements Runnable
{
  QBaseActivity$3(QBaseActivity paramQBaseActivity) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 29
    //   2: monitorenter
    //   3: invokestatic 33	com/tencent/mobileqq/app/QBaseActivity:access$200	()Lcom/tencent/mobileqq/app/ShakeListener;
    //   6: ifnonnull +45 -> 51
    //   9: invokestatic 37	com/tencent/mobileqq/app/QBaseActivity:access$100	()Lcom/tencent/mobileqq/app/IBaseActivityInjectInterface;
    //   12: invokeinterface 42 1 0
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 12	com/tencent/mobileqq/app/QBaseActivity$3:this$0	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   22: invokevirtual 46	com/tencent/mobileqq/app/QBaseActivity:getApplicationContext	()Landroid/content/Context;
    //   25: ldc 48
    //   27: invokevirtual 54	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   30: checkcast 56	android/hardware/SensorManager
    //   33: astore_1
    //   34: aload_1
    //   35: aload_2
    //   36: aload_1
    //   37: iconst_1
    //   38: invokevirtual 60	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   41: iconst_2
    //   42: invokevirtual 64	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   45: pop
    //   46: aload_2
    //   47: invokestatic 68	com/tencent/mobileqq/app/QBaseActivity:access$202	(Lcom/tencent/mobileqq/app/ShakeListener;)Lcom/tencent/mobileqq/app/ShakeListener;
    //   50: pop
    //   51: ldc 29
    //   53: monitorexit
    //   54: return
    //   55: astore_2
    //   56: new 70	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 72
    //   62: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: ldc 77
    //   68: invokestatic 83	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   71: ldc 85
    //   73: invokevirtual 89	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   76: astore_3
    //   77: aload_3
    //   78: iconst_1
    //   79: invokevirtual 95	java/lang/reflect/Field:setAccessible	(Z)V
    //   82: aload_3
    //   83: aload_1
    //   84: invokevirtual 99	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: checkcast 101	java/util/HashMap
    //   90: invokevirtual 105	java/util/HashMap:keySet	()Ljava/util/Set;
    //   93: invokeinterface 111 1 0
    //   98: astore_1
    //   99: aload_1
    //   100: invokeinterface 117 1 0
    //   105: ifeq +73 -> 178
    //   108: aload_2
    //   109: aload_1
    //   110: invokeinterface 121 1 0
    //   115: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: ldc 127
    //   120: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: goto -25 -> 99
    //   127: astore_1
    //   128: new 70	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   135: ldc 133
    //   137: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_1
    //   141: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic 143	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +16 -> 168
    //   155: aload_2
    //   156: aload_1
    //   157: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 145
    //   163: iconst_1
    //   164: aload_1
    //   165: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: ldc 29
    //   170: monitorexit
    //   171: return
    //   172: astore_1
    //   173: ldc 29
    //   175: monitorexit
    //   176: aload_1
    //   177: athrow
    //   178: aconst_null
    //   179: astore_1
    //   180: goto -32 -> 148
    //   183: astore_1
    //   184: new 70	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   191: ldc 153
    //   193: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_1
    //   197: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore_1
    //   204: goto -56 -> 148
    //   207: astore_1
    //   208: new 70	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   215: ldc 155
    //   217: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: astore_1
    //   228: goto -80 -> 148
    //   231: astore_1
    //   232: new 70	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   239: ldc 157
    //   241: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore_1
    //   252: goto -104 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	3
    //   33	77	1	localObject1	Object
    //   127	14	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   147	18	1	str1	java.lang.String
    //   172	5	1	localObject2	Object
    //   179	1	1	localObject3	Object
    //   183	14	1	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   203	1	1	str2	java.lang.String
    //   207	14	1	localIllegalAccessException	java.lang.IllegalAccessException
    //   227	1	1	str3	java.lang.String
    //   231	14	1	localThrowable	java.lang.Throwable
    //   251	1	1	str4	java.lang.String
    //   17	30	2	localShakeListener	ShakeListener
    //   55	1	2	localIllegalStateException	java.lang.IllegalStateException
    //   65	91	2	localStringBuilder	java.lang.StringBuilder
    //   76	7	3	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   34	46	55	java/lang/IllegalStateException
    //   66	99	127	java/lang/ClassNotFoundException
    //   99	124	127	java/lang/ClassNotFoundException
    //   3	34	172	finally
    //   34	46	172	finally
    //   46	51	172	finally
    //   51	54	172	finally
    //   56	66	172	finally
    //   66	99	172	finally
    //   99	124	172	finally
    //   128	148	172	finally
    //   148	168	172	finally
    //   168	171	172	finally
    //   173	176	172	finally
    //   184	204	172	finally
    //   208	228	172	finally
    //   232	252	172	finally
    //   66	99	183	java/lang/NoSuchFieldException
    //   99	124	183	java/lang/NoSuchFieldException
    //   66	99	207	java/lang/IllegalAccessException
    //   99	124	207	java/lang/IllegalAccessException
    //   66	99	231	java/lang/Throwable
    //   99	124	231	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.3
 * JD-Core Version:    0.7.0.1
 */