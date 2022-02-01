package com.tencent.chirp;

class PcmPlayer$PlayThread
  extends Thread
{
  volatile boolean a = true;
  
  private PcmPlayer$PlayThread(PcmPlayer paramPcmPlayer) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 26	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   8: invokestatic 31	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;)Ljava/lang/String;
    //   11: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 5
    //   16: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: istore 4
    //   21: iconst_2
    //   22: istore_2
    //   23: iload 4
    //   25: ifeq +42 -> 67
    //   28: new 42	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc 45
    //   41: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 6
    //   47: aload 5
    //   49: invokevirtual 53	java/io/File:length	()J
    //   52: invokevirtual 56	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 58
    //   58: iconst_2
    //   59: aload 6
    //   61: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 5
    //   69: invokevirtual 69	java/io/File:exists	()Z
    //   72: istore 4
    //   74: iconst_1
    //   75: istore_1
    //   76: iload 4
    //   78: ifne +36 -> 114
    //   81: aload_0
    //   82: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   85: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   88: ifnull +16 -> 104
    //   91: aload_0
    //   92: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   95: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   98: iconst_1
    //   99: invokeinterface 79 2 0
    //   104: aload_0
    //   105: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   108: aconst_null
    //   109: invokestatic 82	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
    //   112: pop
    //   113: return
    //   114: aload_0
    //   115: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   118: invokestatic 85	com/tencent/chirp/PcmPlayer:c	(Lcom/tencent/chirp/PcmPlayer;)I
    //   121: newarray byte
    //   123: astore 6
    //   125: new 87	java/io/FileInputStream
    //   128: dup
    //   129: aload 5
    //   131: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   134: astore 5
    //   136: new 92	java/io/BufferedInputStream
    //   139: dup
    //   140: aload 5
    //   142: invokespecial 95	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   145: astore 7
    //   147: aload_0
    //   148: getfield 17	com/tencent/chirp/PcmPlayer$PlayThread:a	Z
    //   151: ifeq +40 -> 191
    //   154: aload 7
    //   156: aload 6
    //   158: iconst_0
    //   159: aload 6
    //   161: arraylength
    //   162: invokevirtual 99	java/io/BufferedInputStream:read	([BII)I
    //   165: istore_3
    //   166: iload_3
    //   167: ifgt +6 -> 173
    //   170: goto +21 -> 191
    //   173: aload_0
    //   174: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   177: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   180: aload 6
    //   182: iconst_0
    //   183: iload_3
    //   184: invokevirtual 107	android/media/AudioTrack:write	([BII)I
    //   187: pop
    //   188: goto -41 -> 147
    //   191: aload_0
    //   192: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   195: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   198: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   201: aload_0
    //   202: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   205: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   208: invokevirtual 113	android/media/AudioTrack:release	()V
    //   211: aload 5
    //   213: invokevirtual 116	java/io/FileInputStream:close	()V
    //   216: aload_0
    //   217: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   220: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   223: ifnull +113 -> 336
    //   226: aload_0
    //   227: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   230: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   233: iconst_0
    //   234: invokeinterface 79 2 0
    //   239: goto +97 -> 336
    //   242: astore 6
    //   244: goto +13 -> 257
    //   247: astore 6
    //   249: goto +18 -> 267
    //   252: astore 6
    //   254: aconst_null
    //   255: astore 5
    //   257: iconst_0
    //   258: istore_1
    //   259: goto +98 -> 357
    //   262: astore 6
    //   264: aconst_null
    //   265: astore 5
    //   267: invokestatic 40	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +13 -> 283
    //   273: ldc 58
    //   275: iconst_2
    //   276: ldc 118
    //   278: aload 6
    //   280: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   287: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   290: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   293: aload_0
    //   294: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   297: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   300: invokevirtual 113	android/media/AudioTrack:release	()V
    //   303: aload 5
    //   305: ifnull +8 -> 313
    //   308: aload 5
    //   310: invokevirtual 116	java/io/FileInputStream:close	()V
    //   313: aload_0
    //   314: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   317: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   320: ifnull +16 -> 336
    //   323: aload_0
    //   324: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   327: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   330: iconst_2
    //   331: invokeinterface 79 2 0
    //   336: aload_0
    //   337: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   340: aconst_null
    //   341: invokestatic 82	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
    //   344: pop
    //   345: aload_0
    //   346: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   349: aconst_null
    //   350: invokestatic 124	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   353: pop
    //   354: return
    //   355: astore 6
    //   357: aload_0
    //   358: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   361: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   364: invokevirtual 110	android/media/AudioTrack:stop	()V
    //   367: aload_0
    //   368: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   371: invokestatic 102	com/tencent/chirp/PcmPlayer:d	(Lcom/tencent/chirp/PcmPlayer;)Landroid/media/AudioTrack;
    //   374: invokevirtual 113	android/media/AudioTrack:release	()V
    //   377: aload 5
    //   379: ifnull +8 -> 387
    //   382: aload 5
    //   384: invokevirtual 116	java/io/FileInputStream:close	()V
    //   387: aload_0
    //   388: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   391: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   394: ifnull +31 -> 425
    //   397: aload_0
    //   398: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   401: invokestatic 73	com/tencent/chirp/PcmPlayer:b	(Lcom/tencent/chirp/PcmPlayer;)Lcom/tencent/chirp/PcmPlayer$QQPlayerListener;
    //   404: astore 5
    //   406: iload_1
    //   407: ifeq +8 -> 415
    //   410: iload_2
    //   411: istore_1
    //   412: goto +5 -> 417
    //   415: iconst_0
    //   416: istore_1
    //   417: aload 5
    //   419: iload_1
    //   420: invokeinterface 79 2 0
    //   425: aload_0
    //   426: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   429: aconst_null
    //   430: invokestatic 82	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Lcom/tencent/chirp/PcmPlayer$PlayThread;)Lcom/tencent/chirp/PcmPlayer$PlayThread;
    //   433: pop
    //   434: aload_0
    //   435: getfield 12	com/tencent/chirp/PcmPlayer$PlayThread:this$0	Lcom/tencent/chirp/PcmPlayer;
    //   438: aconst_null
    //   439: invokestatic 124	com/tencent/chirp/PcmPlayer:a	(Lcom/tencent/chirp/PcmPlayer;Landroid/media/AudioTrack;)Landroid/media/AudioTrack;
    //   442: pop
    //   443: goto +6 -> 449
    //   446: aload 6
    //   448: athrow
    //   449: goto -3 -> 446
    //   452: astore 5
    //   454: goto -238 -> 216
    //   457: astore 5
    //   459: goto -146 -> 313
    //   462: astore 5
    //   464: goto -77 -> 387
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	PlayThread
    //   75	345	1	i	int
    //   22	389	2	j	int
    //   165	19	3	k	int
    //   19	58	4	bool	boolean
    //   14	404	5	localObject1	java.lang.Object
    //   452	1	5	localException1	java.lang.Exception
    //   457	1	5	localException2	java.lang.Exception
    //   462	1	5	localException3	java.lang.Exception
    //   35	146	6	localObject2	java.lang.Object
    //   242	1	6	localObject3	java.lang.Object
    //   247	1	6	localException4	java.lang.Exception
    //   252	1	6	localObject4	java.lang.Object
    //   262	17	6	localException5	java.lang.Exception
    //   355	92	6	localObject5	java.lang.Object
    //   145	10	7	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   136	147	242	finally
    //   147	166	242	finally
    //   173	188	242	finally
    //   136	147	247	java/lang/Exception
    //   147	166	247	java/lang/Exception
    //   173	188	247	java/lang/Exception
    //   125	136	252	finally
    //   125	136	262	java/lang/Exception
    //   267	283	355	finally
    //   211	216	452	java/lang/Exception
    //   308	313	457	java/lang/Exception
    //   382	387	462	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.chirp.PcmPlayer.PlayThread
 * JD-Core Version:    0.7.0.1
 */