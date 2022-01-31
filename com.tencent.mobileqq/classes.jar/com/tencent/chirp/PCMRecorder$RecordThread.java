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
    //   45: astore_3
    //   46: aload_3
    //   47: invokevirtual 53	android/media/AudioRecord:getState	()I
    //   50: iconst_1
    //   51: if_icmpeq +60 -> 111
    //   54: aload_0
    //   55: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   58: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lxol;
    //   61: iconst_m1
    //   62: invokeinterface 61 2 0
    //   67: aload_0
    //   68: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   71: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   74: iconst_0
    //   75: invokestatic 69	bbbr:a	(Landroid/content/Context;Z)Z
    //   78: pop
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 72	android/media/AudioRecord:release	()V
    //   87: aload_0
    //   88: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   91: aconst_null
    //   92: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   95: pop
    //   96: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +11 -> 110
    //   102: ldc 29
    //   104: iconst_2
    //   105: ldc 77
    //   107: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: return
    //   111: aload_0
    //   112: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   115: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   118: iconst_1
    //   119: invokestatic 69	bbbr:a	(Landroid/content/Context;Z)Z
    //   122: pop
    //   123: aload_3
    //   124: invokevirtual 80	android/media/AudioRecord:startRecording	()V
    //   127: aload_0
    //   128: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   131: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   134: newarray byte
    //   136: astore 4
    //   138: iconst_0
    //   139: istore_1
    //   140: aload_0
    //   141: getfield 17	com/tencent/chirp/PCMRecorder$RecordThread:a	Z
    //   144: ifeq +54 -> 198
    //   147: iload_1
    //   148: aload_3
    //   149: aload 4
    //   151: iload_1
    //   152: aload_0
    //   153: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   156: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   159: iload_1
    //   160: isub
    //   161: invokevirtual 87	android/media/AudioRecord:read	([BII)I
    //   164: iadd
    //   165: istore_2
    //   166: iload_2
    //   167: istore_1
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   173: invokestatic 83	com/tencent/chirp/PCMRecorder:b	(Lcom/tencent/chirp/PCMRecorder;)I
    //   176: if_icmpne -36 -> 140
    //   179: aload_0
    //   180: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   183: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lxol;
    //   186: aload 4
    //   188: invokeinterface 90 2 0
    //   193: iconst_0
    //   194: istore_1
    //   195: goto -55 -> 140
    //   198: aload_0
    //   199: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   202: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   205: iconst_0
    //   206: invokestatic 69	bbbr:a	(Landroid/content/Context;Z)Z
    //   209: pop
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 72	android/media/AudioRecord:release	()V
    //   218: aload_0
    //   219: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   222: aconst_null
    //   223: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   226: pop
    //   227: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq -120 -> 110
    //   233: ldc 29
    //   235: iconst_2
    //   236: ldc 77
    //   238: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: return
    //   242: astore 4
    //   244: aconst_null
    //   245: astore_3
    //   246: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +13 -> 262
    //   252: ldc 29
    //   254: iconst_2
    //   255: ldc 92
    //   257: aload 4
    //   259: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload_0
    //   263: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   266: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lxol;
    //   269: ifnull +17 -> 286
    //   272: aload_0
    //   273: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   276: invokestatic 56	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Lxol;
    //   279: bipush 254
    //   281: invokeinterface 61 2 0
    //   286: aload_0
    //   287: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   290: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   293: iconst_0
    //   294: invokestatic 69	bbbr:a	(Landroid/content/Context;Z)Z
    //   297: pop
    //   298: aload_3
    //   299: ifnull +7 -> 306
    //   302: aload_3
    //   303: invokevirtual 72	android/media/AudioRecord:release	()V
    //   306: aload_0
    //   307: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   310: aconst_null
    //   311: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   314: pop
    //   315: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq -208 -> 110
    //   321: ldc 29
    //   323: iconst_2
    //   324: ldc 77
    //   326: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: return
    //   330: astore 4
    //   332: aconst_null
    //   333: astore_3
    //   334: aload_0
    //   335: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   338: invokestatic 64	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;)Landroid/content/Context;
    //   341: iconst_0
    //   342: invokestatic 69	bbbr:a	(Landroid/content/Context;Z)Z
    //   345: pop
    //   346: aload_3
    //   347: ifnull +7 -> 354
    //   350: aload_3
    //   351: invokevirtual 72	android/media/AudioRecord:release	()V
    //   354: aload_0
    //   355: getfield 12	com/tencent/chirp/PCMRecorder$RecordThread:this$0	Lcom/tencent/chirp/PCMRecorder;
    //   358: aconst_null
    //   359: invokestatic 75	com/tencent/chirp/PCMRecorder:a	(Lcom/tencent/chirp/PCMRecorder;Lcom/tencent/chirp/PCMRecorder$RecordThread;)Lcom/tencent/chirp/PCMRecorder$RecordThread;
    //   362: pop
    //   363: invokestatic 27	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +11 -> 377
    //   369: ldc 29
    //   371: iconst_2
    //   372: ldc 77
    //   374: invokestatic 35	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 4
    //   379: athrow
    //   380: astore 4
    //   382: goto -48 -> 334
    //   385: astore 4
    //   387: goto -53 -> 334
    //   390: astore 4
    //   392: goto -146 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	RecordThread
    //   26	169	1	i	int
    //   165	12	2	j	int
    //   45	306	3	localAudioRecord	android.media.AudioRecord
    //   136	51	4	arrayOfByte	byte[]
    //   242	16	4	localThrowable1	java.lang.Throwable
    //   330	48	4	localObject1	java.lang.Object
    //   380	1	4	localObject2	java.lang.Object
    //   385	1	4	localObject3	java.lang.Object
    //   390	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	242	java/lang/Throwable
    //   14	46	330	finally
    //   46	67	380	finally
    //   111	138	380	finally
    //   140	166	380	finally
    //   168	193	380	finally
    //   246	262	385	finally
    //   262	286	385	finally
    //   46	67	390	java/lang/Throwable
    //   111	138	390	java/lang/Throwable
    //   140	166	390	java/lang/Throwable
    //   168	193	390	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.chirp.PCMRecorder.RecordThread
 * JD-Core Version:    0.7.0.1
 */