package com.tencent.chirp;

class PCMRecorder$RecordThread
  extends Thread
{
  public volatile boolean a = true;
  
  PCMRecorder$RecordThread(PCMRecorder paramPCMRecorder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 29
    //   8: iconst_2
    //   9: ldc 31
    //   11: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   18: invokestatic 40	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)I
    //   21: iconst_2
    //   22: iconst_2
    //   23: invokestatic 46	android/media/AudioRecord:getMinBufferSize	(III)I
    //   26: istore_1
    //   27: new 42	android/media/AudioRecord
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   36: invokestatic 40	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)I
    //   39: iconst_2
    //   40: iconst_2
    //   41: iload_1
    //   42: invokespecial 49	android/media/AudioRecord:<init>	(IIIII)V
    //   45: astore 4
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokevirtual 53	android/media/AudioRecord:getState	()I
    //   55: iconst_1
    //   56: if_icmpeq +60 -> 116
    //   59: aload 4
    //   61: astore_3
    //   62: aload_0
    //   63: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   66: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   69: iconst_m1
    //   70: invokeinterface 61 2 0
    //   75: aload_0
    //   76: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   79: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   82: iconst_0
    //   83: invokestatic 69	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   86: pop
    //   87: aload 4
    //   89: invokevirtual 72	android/media/AudioRecord:release	()V
    //   92: aload_0
    //   93: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   96: aconst_null
    //   97: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   100: pop
    //   101: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +11 -> 115
    //   107: ldc 29
    //   109: iconst_2
    //   110: ldc 77
    //   112: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: return
    //   116: aload 4
    //   118: astore_3
    //   119: aload_0
    //   120: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   123: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   126: iconst_1
    //   127: invokestatic 69	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   130: pop
    //   131: aload 4
    //   133: astore_3
    //   134: aload 4
    //   136: invokevirtual 80	android/media/AudioRecord:startRecording	()V
    //   139: aload 4
    //   141: astore_3
    //   142: aload_0
    //   143: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   146: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   149: newarray byte
    //   151: astore 5
    //   153: goto +276 -> 429
    //   156: aload 4
    //   158: astore_3
    //   159: aload_0
    //   160: getfield 17	com/tencent/chirp/PCMRecorder$RecordThread:a	Z
    //   163: ifeq +62 -> 225
    //   166: aload 4
    //   168: astore_3
    //   169: iload_1
    //   170: aload 4
    //   172: aload 5
    //   174: iload_1
    //   175: aload_0
    //   176: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   179: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   182: iload_1
    //   183: isub
    //   184: invokevirtual 87	android/media/AudioRecord:read	([BII)I
    //   187: iadd
    //   188: istore_2
    //   189: iload_2
    //   190: istore_1
    //   191: aload 4
    //   193: astore_3
    //   194: iload_2
    //   195: aload_0
    //   196: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   199: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   202: if_icmpne -46 -> 156
    //   205: aload 4
    //   207: astore_3
    //   208: aload_0
    //   209: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   212: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   215: aload 5
    //   217: invokeinterface 90 2 0
    //   222: goto +207 -> 429
    //   225: aload_0
    //   226: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   229: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   232: iconst_0
    //   233: invokestatic 69	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   236: pop
    //   237: aload 4
    //   239: invokevirtual 72	android/media/AudioRecord:release	()V
    //   242: aload_0
    //   243: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   246: aconst_null
    //   247: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   250: pop
    //   251: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +120 -> 374
    //   257: goto +109 -> 366
    //   260: astore 5
    //   262: goto +15 -> 277
    //   265: astore 4
    //   267: aconst_null
    //   268: astore_3
    //   269: goto +108 -> 377
    //   272: astore 5
    //   274: aconst_null
    //   275: astore 4
    //   277: aload 4
    //   279: astore_3
    //   280: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +16 -> 299
    //   286: aload 4
    //   288: astore_3
    //   289: ldc 29
    //   291: iconst_2
    //   292: ldc 92
    //   294: aload 5
    //   296: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   299: aload 4
    //   301: astore_3
    //   302: aload_0
    //   303: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   306: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   309: ifnull +20 -> 329
    //   312: aload 4
    //   314: astore_3
    //   315: aload_0
    //   316: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   319: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lcom/tencent/chirp/PCMRecorder$OnQQRecorderListener;
    //   322: bipush 254
    //   324: invokeinterface 61 2 0
    //   329: aload_0
    //   330: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   333: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   336: iconst_0
    //   337: invokestatic 69	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   340: pop
    //   341: aload 4
    //   343: ifnull +8 -> 351
    //   346: aload 4
    //   348: invokevirtual 72	android/media/AudioRecord:release	()V
    //   351: aload_0
    //   352: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   355: aconst_null
    //   356: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   359: pop
    //   360: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +11 -> 374
    //   366: ldc 29
    //   368: iconst_2
    //   369: ldc 77
    //   371: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: return
    //   375: astore 4
    //   377: aload_0
    //   378: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   381: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   384: iconst_0
    //   385: invokestatic 69	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Landroid/content/Context;Z)Z
    //   388: pop
    //   389: aload_3
    //   390: ifnull +7 -> 397
    //   393: aload_3
    //   394: invokevirtual 72	android/media/AudioRecord:release	()V
    //   397: aload_0
    //   398: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   401: aconst_null
    //   402: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   405: pop
    //   406: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +11 -> 420
    //   412: ldc 29
    //   414: iconst_2
    //   415: ldc 77
    //   417: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: goto +6 -> 426
    //   423: aload 4
    //   425: athrow
    //   426: goto -3 -> 423
    //   429: iconst_0
    //   430: istore_1
    //   431: goto -275 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	RecordThread
    //   26	405	1	i	int
    //   188	15	2	j	int
    //   49	345	3	localObject1	java.lang.Object
    //   45	193	4	localAudioRecord	android.media.AudioRecord
    //   265	1	4	localObject2	java.lang.Object
    //   275	72	4	localObject3	java.lang.Object
    //   375	49	4	localObject4	java.lang.Object
    //   151	65	5	arrayOfByte	byte[]
    //   260	1	5	localThrowable1	java.lang.Throwable
    //   272	23	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   50	59	260	java/lang/Throwable
    //   62	75	260	java/lang/Throwable
    //   119	131	260	java/lang/Throwable
    //   134	139	260	java/lang/Throwable
    //   142	153	260	java/lang/Throwable
    //   159	166	260	java/lang/Throwable
    //   169	189	260	java/lang/Throwable
    //   194	205	260	java/lang/Throwable
    //   208	222	260	java/lang/Throwable
    //   14	47	265	finally
    //   14	47	272	java/lang/Throwable
    //   50	59	375	finally
    //   62	75	375	finally
    //   119	131	375	finally
    //   134	139	375	finally
    //   142	153	375	finally
    //   159	166	375	finally
    //   169	189	375	finally
    //   194	205	375	finally
    //   208	222	375	finally
    //   280	286	375	finally
    //   289	299	375	finally
    //   302	312	375	finally
    //   315	329	375	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */