package com.tencent.TMG.ptt;

import android.media.AudioTrack;
import android.util.Log;

public class PCMPlayer
{
  public String TAG = "PCMPlayer";
  private AudioTrack audioTrack;
  private int bufferSize;
  private int channel = 4;
  private int format = 2;
  PCMPlayer.PlayThread pcmPlayer = null;
  private int sampleRate = 16000;
  
  public PCMPlayer() {}
  
  public PCMPlayer(int paramInt1, int paramInt2, int paramInt3)
  {
    this.sampleRate = paramInt1;
    this.channel = paramInt2;
    this.format = paramInt3;
  }
  
  public int getBufferSize()
  {
    return this.bufferSize;
  }
  
  /* Error */
  public int getSilkFilePlayTime(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: iconst_0
    //   9: istore 5
    //   11: iconst_0
    //   12: istore 6
    //   14: new 53	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 60	java/io/File:exists	()Z
    //   27: istore 9
    //   29: iload 9
    //   31: ifne +50 -> 81
    //   34: aload_0
    //   35: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   38: new 62	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   45: ldc 65
    //   47: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iconst_0
    //   51: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc 74
    //   56: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iconst_0
    //   60: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc 76
    //   65: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iconst_0
    //   69: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   78: pop
    //   79: iconst_0
    //   80: ireturn
    //   81: new 88	java/io/FileInputStream
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 94	java/io/FileInputStream:available	()I
    //   94: istore 8
    //   96: bipush 9
    //   98: istore_2
    //   99: iload 8
    //   101: newarray byte
    //   103: astore 10
    //   105: aload_1
    //   106: aload 10
    //   108: invokevirtual 98	java/io/FileInputStream:read	([B)I
    //   111: pop
    //   112: iconst_0
    //   113: istore 5
    //   115: iload_2
    //   116: istore_3
    //   117: iload 6
    //   119: istore 4
    //   121: iload_3
    //   122: iload 8
    //   124: if_icmpge +104 -> 228
    //   127: iload 5
    //   129: iconst_1
    //   130: iadd
    //   131: istore_2
    //   132: aload 10
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: baload
    //   138: istore 5
    //   140: aload 10
    //   142: iload_3
    //   143: baload
    //   144: iload 5
    //   146: bipush 8
    //   148: ishl
    //   149: iadd
    //   150: istore 5
    //   152: iload 4
    //   154: bipush 20
    //   156: iadd
    //   157: istore 4
    //   159: iload_3
    //   160: iload 5
    //   162: iconst_2
    //   163: iadd
    //   164: iadd
    //   165: istore_3
    //   166: aload_0
    //   167: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   170: new 62	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   177: ldc 100
    //   179: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload_2
    //   183: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: ldc 102
    //   188: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload 5
    //   193: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: ldc 104
    //   198: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: iload_3
    //   202: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   205: ldc 106
    //   207: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload 4
    //   212: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   221: pop
    //   222: iload_2
    //   223: istore 5
    //   225: goto -104 -> 121
    //   228: aload_0
    //   229: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   232: new 62	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   239: ldc 65
    //   241: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_3
    //   245: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: ldc 74
    //   250: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: iload 4
    //   255: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   258: ldc 76
    //   260: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: iload 5
    //   265: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   268: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: iload 4
    //   277: ireturn
    //   278: astore_1
    //   279: iconst_0
    //   280: istore 5
    //   282: iconst_0
    //   283: istore 6
    //   285: iload 7
    //   287: istore 4
    //   289: iload 5
    //   291: istore_3
    //   292: iload 6
    //   294: istore_2
    //   295: aload_1
    //   296: invokevirtual 109	java/io/FileNotFoundException:printStackTrace	()V
    //   299: aload_0
    //   300: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   303: new 62	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   310: ldc 65
    //   312: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: iload 5
    //   317: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: ldc 74
    //   322: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: iload 7
    //   327: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc 76
    //   332: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload 6
    //   337: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   346: pop
    //   347: iload 7
    //   349: ireturn
    //   350: astore_1
    //   351: iconst_0
    //   352: istore 5
    //   354: iconst_0
    //   355: istore 6
    //   357: iload_3
    //   358: istore 7
    //   360: iload 7
    //   362: istore 4
    //   364: iload 5
    //   366: istore_3
    //   367: iload 6
    //   369: istore_2
    //   370: aload_1
    //   371: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   374: aload_0
    //   375: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   378: new 62	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   385: ldc 65
    //   387: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 5
    //   392: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc 74
    //   397: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload 7
    //   402: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc 76
    //   407: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 6
    //   412: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   421: pop
    //   422: iload 7
    //   424: ireturn
    //   425: astore_1
    //   426: iconst_0
    //   427: istore 5
    //   429: iconst_0
    //   430: istore 6
    //   432: iload 4
    //   434: istore 7
    //   436: iload 7
    //   438: istore 4
    //   440: iload 5
    //   442: istore_3
    //   443: iload 6
    //   445: istore_2
    //   446: aload_1
    //   447: invokevirtual 111	java/lang/Exception:printStackTrace	()V
    //   450: aload_0
    //   451: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   454: new 62	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   461: ldc 65
    //   463: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: iload 5
    //   468: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: ldc 74
    //   473: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload 7
    //   478: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc 76
    //   483: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: iload 6
    //   488: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   497: pop
    //   498: iload 7
    //   500: ireturn
    //   501: astore_1
    //   502: iconst_0
    //   503: istore_3
    //   504: iconst_0
    //   505: istore_2
    //   506: iload 5
    //   508: istore 4
    //   510: aload_0
    //   511: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   514: new 62	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   521: ldc 65
    //   523: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: iload_3
    //   527: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   530: ldc 74
    //   532: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: iload 4
    //   537: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: ldc 76
    //   542: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: iload_2
    //   546: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   555: pop
    //   556: iload 4
    //   558: ireturn
    //   559: astore_1
    //   560: iconst_0
    //   561: istore 6
    //   563: iload 5
    //   565: istore 4
    //   567: iload_2
    //   568: istore_3
    //   569: iload 6
    //   571: istore_2
    //   572: goto -62 -> 510
    //   575: astore_1
    //   576: goto -66 -> 510
    //   579: astore_1
    //   580: goto -70 -> 510
    //   583: astore_1
    //   584: iconst_0
    //   585: istore 6
    //   587: iload 4
    //   589: istore 7
    //   591: iload_2
    //   592: istore 5
    //   594: goto -158 -> 436
    //   597: astore_1
    //   598: iload 4
    //   600: istore 7
    //   602: iload_3
    //   603: istore 5
    //   605: iload_2
    //   606: istore 6
    //   608: goto -172 -> 436
    //   611: astore_1
    //   612: iconst_0
    //   613: istore 6
    //   615: iload_3
    //   616: istore 7
    //   618: iload_2
    //   619: istore 5
    //   621: goto -261 -> 360
    //   624: astore_1
    //   625: iload 4
    //   627: istore 7
    //   629: iload_3
    //   630: istore 5
    //   632: iload_2
    //   633: istore 6
    //   635: goto -275 -> 360
    //   638: astore_1
    //   639: iconst_0
    //   640: istore 6
    //   642: iload_2
    //   643: istore 5
    //   645: goto -360 -> 285
    //   648: astore_1
    //   649: iload 4
    //   651: istore 7
    //   653: iload_3
    //   654: istore 5
    //   656: iload_2
    //   657: istore 6
    //   659: goto -374 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	PCMPlayer
    //   0	662	1	paramString	String
    //   98	559	2	i	int
    //   4	650	3	j	int
    //   6	644	4	k	int
    //   9	646	5	m	int
    //   12	646	6	n	int
    //   1	651	7	i1	int
    //   94	31	8	i2	int
    //   27	3	9	bool	boolean
    //   103	38	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	29	278	java/io/FileNotFoundException
    //   81	96	278	java/io/FileNotFoundException
    //   14	29	350	java/io/IOException
    //   81	96	350	java/io/IOException
    //   14	29	425	java/lang/Exception
    //   81	96	425	java/lang/Exception
    //   14	29	501	finally
    //   81	96	501	finally
    //   99	112	559	finally
    //   295	299	575	finally
    //   370	374	575	finally
    //   446	450	575	finally
    //   166	222	579	finally
    //   99	112	583	java/lang/Exception
    //   166	222	597	java/lang/Exception
    //   99	112	611	java/io/IOException
    //   166	222	624	java/io/IOException
    //   99	112	638	java/io/FileNotFoundException
    //   166	222	648	java/io/FileNotFoundException
  }
  
  public boolean initPCMPlayer()
  {
    if (this.audioTrack != null)
    {
      Log.e(this.TAG, "init pcm player, audio track not null, release first!");
      this.audioTrack.release();
      this.audioTrack = null;
    }
    this.audioTrack = new AudioTrack(3, this.sampleRate, this.channel, this.format, this.format, 1);
    return true;
  }
  
  public boolean isPlaying()
  {
    return this.pcmPlayer != null;
  }
  
  public void play(String paramString, PttListener.PlayFileListener paramPlayFileListener)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramPlayFileListener.onCompleted(4101, null);
      return;
    }
    if (this.pcmPlayer == null)
    {
      this.pcmPlayer = new PCMPlayer.PlayThread(this, paramString, paramPlayFileListener);
      this.audioTrack.play();
      this.pcmPlayer.start();
      return;
    }
    Log.e(this.TAG, "file is playing , not play again!");
    paramPlayFileListener.onCompleted(20482, null);
  }
  
  public void stop()
  {
    int j = 0;
    int i = j;
    if (this.pcmPlayer != null)
    {
      this.pcmPlayer.isRunning = false;
      i = j;
    }
    for (;;)
    {
      if (this.pcmPlayer != null) {}
      try
      {
        Thread.sleep(10L);
        j = i + 1;
        i = j;
        if (j < 100) {
          continue;
        }
        Log.i(this.TAG, "stop silk player end!");
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.ptt.PCMPlayer
 * JD-Core Version:    0.7.0.1
 */