package com.tencent.TMG.ptt;

import android.media.AudioTrack;
import android.util.Log;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;

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
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iconst_0
    //   8: istore 4
    //   10: new 53	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual 60	java/io/File:exists	()Z
    //   23: istore 10
    //   25: iload 10
    //   27: ifne +74 -> 101
    //   30: aload_0
    //   31: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   34: astore_1
    //   35: new 62	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   42: astore 11
    //   44: aload 11
    //   46: ldc 65
    //   48: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 11
    //   54: iconst_0
    //   55: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 11
    //   61: ldc 74
    //   63: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 11
    //   69: iconst_0
    //   70: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 11
    //   76: ldc 76
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 11
    //   84: iconst_0
    //   85: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: aload 11
    //   92: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   98: pop
    //   99: iconst_0
    //   100: ireturn
    //   101: new 88	java/io/FileInputStream
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore 11
    //   111: aload 11
    //   113: invokevirtual 94	java/io/FileInputStream:available	()I
    //   116: istore 8
    //   118: iload 8
    //   120: newarray byte
    //   122: astore_1
    //   123: aload 11
    //   125: aload_1
    //   126: invokevirtual 98	java/io/FileInputStream:read	([B)I
    //   129: pop
    //   130: iconst_0
    //   131: istore 4
    //   133: bipush 9
    //   135: istore_2
    //   136: iconst_0
    //   137: istore_3
    //   138: iload_2
    //   139: iload 8
    //   141: if_icmpge +262 -> 403
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore 6
    //   149: aload_1
    //   150: iload_2
    //   151: iconst_1
    //   152: iadd
    //   153: baload
    //   154: bipush 8
    //   156: ishl
    //   157: aload_1
    //   158: iload_2
    //   159: baload
    //   160: iadd
    //   161: istore 9
    //   163: iload 4
    //   165: bipush 20
    //   167: iadd
    //   168: istore 5
    //   170: iload_2
    //   171: iload 9
    //   173: iconst_2
    //   174: iadd
    //   175: iadd
    //   176: istore 7
    //   178: iload 7
    //   180: istore 4
    //   182: iload 6
    //   184: istore_3
    //   185: iload 5
    //   187: istore_2
    //   188: aload_0
    //   189: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   192: astore 11
    //   194: iload 7
    //   196: istore 4
    //   198: iload 6
    //   200: istore_3
    //   201: iload 5
    //   203: istore_2
    //   204: new 62	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   211: astore 12
    //   213: iload 7
    //   215: istore 4
    //   217: iload 6
    //   219: istore_3
    //   220: iload 5
    //   222: istore_2
    //   223: aload 12
    //   225: ldc 100
    //   227: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: iload 7
    //   233: istore 4
    //   235: iload 6
    //   237: istore_3
    //   238: iload 5
    //   240: istore_2
    //   241: aload 12
    //   243: iload 6
    //   245: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: iload 7
    //   251: istore 4
    //   253: iload 6
    //   255: istore_3
    //   256: iload 5
    //   258: istore_2
    //   259: aload 12
    //   261: ldc 102
    //   263: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: iload 7
    //   269: istore 4
    //   271: iload 6
    //   273: istore_3
    //   274: iload 5
    //   276: istore_2
    //   277: aload 12
    //   279: iload 9
    //   281: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: iload 7
    //   287: istore 4
    //   289: iload 6
    //   291: istore_3
    //   292: iload 5
    //   294: istore_2
    //   295: aload 12
    //   297: ldc 104
    //   299: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: iload 7
    //   305: istore 4
    //   307: iload 6
    //   309: istore_3
    //   310: iload 5
    //   312: istore_2
    //   313: aload 12
    //   315: iload 7
    //   317: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: iload 7
    //   323: istore 4
    //   325: iload 6
    //   327: istore_3
    //   328: iload 5
    //   330: istore_2
    //   331: aload 12
    //   333: ldc 106
    //   335: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: iload 7
    //   341: istore 4
    //   343: iload 6
    //   345: istore_3
    //   346: iload 5
    //   348: istore_2
    //   349: aload 12
    //   351: iload 5
    //   353: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: iload 7
    //   359: istore 4
    //   361: iload 6
    //   363: istore_3
    //   364: iload 5
    //   366: istore_2
    //   367: aload 11
    //   369: aload 12
    //   371: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   377: pop
    //   378: iload 7
    //   380: istore_2
    //   381: iload 6
    //   383: istore_3
    //   384: iload 5
    //   386: istore 4
    //   388: goto -250 -> 138
    //   391: astore_1
    //   392: goto +130 -> 522
    //   395: astore_1
    //   396: goto +177 -> 573
    //   399: astore_1
    //   400: goto +224 -> 624
    //   403: aload_0
    //   404: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   407: astore_1
    //   408: new 62	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   415: astore 11
    //   417: aload 11
    //   419: ldc 65
    //   421: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 11
    //   427: iload_2
    //   428: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload 11
    //   434: ldc 74
    //   436: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload 11
    //   442: iload 4
    //   444: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 11
    //   450: ldc 76
    //   452: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload 11
    //   458: iload_3
    //   459: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: aload 11
    //   466: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 86	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   472: pop
    //   473: iload 4
    //   475: ireturn
    //   476: bipush 9
    //   478: istore 4
    //   480: goto +27 -> 507
    //   483: astore_1
    //   484: bipush 9
    //   486: istore 7
    //   488: goto +28 -> 516
    //   491: astore_1
    //   492: bipush 9
    //   494: istore 7
    //   496: goto +71 -> 567
    //   499: astore_1
    //   500: bipush 9
    //   502: istore 7
    //   504: goto +114 -> 618
    //   507: iconst_0
    //   508: istore 5
    //   510: iconst_0
    //   511: istore_3
    //   512: goto +153 -> 665
    //   515: astore_1
    //   516: iconst_0
    //   517: istore 5
    //   519: iconst_0
    //   520: istore 6
    //   522: iload 7
    //   524: istore 4
    //   526: iload 6
    //   528: istore_3
    //   529: iload 5
    //   531: istore_2
    //   532: aload_1
    //   533: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   536: aload_0
    //   537: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   540: astore_1
    //   541: new 62	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   548: astore 11
    //   550: iload 7
    //   552: istore_2
    //   553: iload 6
    //   555: istore_3
    //   556: iload 5
    //   558: istore 4
    //   560: goto -143 -> 417
    //   563: astore_1
    //   564: iload_2
    //   565: istore 7
    //   567: iconst_0
    //   568: istore 5
    //   570: iconst_0
    //   571: istore 6
    //   573: iload 7
    //   575: istore 4
    //   577: iload 6
    //   579: istore_3
    //   580: iload 5
    //   582: istore_2
    //   583: aload_1
    //   584: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   587: aload_0
    //   588: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   591: astore_1
    //   592: new 62	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   599: astore 11
    //   601: iload 7
    //   603: istore_2
    //   604: iload 6
    //   606: istore_3
    //   607: iload 5
    //   609: istore 4
    //   611: goto -194 -> 417
    //   614: astore_1
    //   615: iload_3
    //   616: istore 7
    //   618: iconst_0
    //   619: istore 5
    //   621: iconst_0
    //   622: istore 6
    //   624: iload 7
    //   626: istore 4
    //   628: iload 6
    //   630: istore_3
    //   631: iload 5
    //   633: istore_2
    //   634: aload_1
    //   635: invokevirtual 111	java/io/FileNotFoundException:printStackTrace	()V
    //   638: aload_0
    //   639: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   642: astore_1
    //   643: new 62	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   650: astore 11
    //   652: iload 7
    //   654: istore_2
    //   655: iload 6
    //   657: istore_3
    //   658: iload 5
    //   660: istore 4
    //   662: goto -245 -> 417
    //   665: aload_0
    //   666: getfield 23	com/tencent/TMG/ptt/PCMPlayer:TAG	Ljava/lang/String;
    //   669: astore_1
    //   670: new 62	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   677: astore 11
    //   679: iload 4
    //   681: istore_2
    //   682: iload 5
    //   684: istore 4
    //   686: goto -269 -> 417
    //   689: astore_1
    //   690: goto -183 -> 507
    //   693: astore_1
    //   694: goto -218 -> 476
    //   697: astore_1
    //   698: iload_2
    //   699: istore 5
    //   701: goto -36 -> 665
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	PCMPlayer
    //   0	704	1	paramString	String
    //   4	695	2	i	int
    //   6	652	3	j	int
    //   8	677	4	k	int
    //   168	532	5	m	int
    //   147	509	6	n	int
    //   1	652	7	i1	int
    //   116	26	8	i2	int
    //   161	119	9	i3	int
    //   23	3	10	bool	boolean
    //   42	636	11	localObject	Object
    //   211	159	12	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   188	194	391	java/lang/Exception
    //   204	213	391	java/lang/Exception
    //   223	231	391	java/lang/Exception
    //   241	249	391	java/lang/Exception
    //   259	267	391	java/lang/Exception
    //   277	285	391	java/lang/Exception
    //   295	303	391	java/lang/Exception
    //   313	321	391	java/lang/Exception
    //   331	339	391	java/lang/Exception
    //   349	357	391	java/lang/Exception
    //   367	378	391	java/lang/Exception
    //   188	194	395	java/io/IOException
    //   204	213	395	java/io/IOException
    //   223	231	395	java/io/IOException
    //   241	249	395	java/io/IOException
    //   259	267	395	java/io/IOException
    //   277	285	395	java/io/IOException
    //   295	303	395	java/io/IOException
    //   313	321	395	java/io/IOException
    //   331	339	395	java/io/IOException
    //   349	357	395	java/io/IOException
    //   367	378	395	java/io/IOException
    //   188	194	399	java/io/FileNotFoundException
    //   204	213	399	java/io/FileNotFoundException
    //   223	231	399	java/io/FileNotFoundException
    //   241	249	399	java/io/FileNotFoundException
    //   259	267	399	java/io/FileNotFoundException
    //   277	285	399	java/io/FileNotFoundException
    //   295	303	399	java/io/FileNotFoundException
    //   313	321	399	java/io/FileNotFoundException
    //   331	339	399	java/io/FileNotFoundException
    //   349	357	399	java/io/FileNotFoundException
    //   367	378	399	java/io/FileNotFoundException
    //   118	130	483	java/lang/Exception
    //   118	130	491	java/io/IOException
    //   118	130	499	java/io/FileNotFoundException
    //   10	25	515	java/lang/Exception
    //   101	118	515	java/lang/Exception
    //   10	25	563	java/io/IOException
    //   101	118	563	java/io/IOException
    //   10	25	614	java/io/FileNotFoundException
    //   101	118	614	java/io/FileNotFoundException
    //   10	25	689	finally
    //   101	118	689	finally
    //   118	130	693	finally
    //   188	194	697	finally
    //   204	213	697	finally
    //   223	231	697	finally
    //   241	249	697	finally
    //   259	267	697	finally
    //   277	285	697	finally
    //   295	303	697	finally
    //   313	321	697	finally
    //   331	339	697	finally
    //   349	357	697	finally
    //   367	378	697	finally
    //   532	536	697	finally
    //   583	587	697	finally
    //   634	638	697	finally
  }
  
  public boolean initPCMPlayer()
  {
    if (this.audioTrack != null)
    {
      Log.e(this.TAG, "init pcm player, audio track not null, release first!");
      this.audioTrack.release();
      this.audioTrack = null;
    }
    int i = this.sampleRate;
    int j = this.channel;
    int k = this.format;
    this.audioTrack = new ReportAudioTrack(3, i, j, k, k, 1);
    return true;
  }
  
  public boolean isPlaying()
  {
    return this.pcmPlayer != null;
  }
  
  public void play(String paramString, PttListener.PlayFileListener paramPlayFileListener)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (this.pcmPlayer == null)
      {
        this.pcmPlayer = new PCMPlayer.PlayThread(this, paramString, paramPlayFileListener);
        this.audioTrack.play();
        this.pcmPlayer.start();
        return;
      }
      Log.e(this.TAG, "file is playing , not play again!");
      paramPlayFileListener.onCompleted(20482, null);
      return;
    }
    paramPlayFileListener.onCompleted(4101, null);
  }
  
  public void stop()
  {
    PCMPlayer.PlayThread localPlayThread = this.pcmPlayer;
    int j = 0;
    int i = j;
    if (localPlayThread != null)
    {
      localPlayThread.isRunning = false;
      i = j;
    }
    do
    {
      if (this.pcmPlayer == null) {
        break;
      }
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      j = i + 1;
      i = j;
    } while (j < 100);
    Log.i(this.TAG, "stop silk player end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.PCMPlayer
 * JD-Core Version:    0.7.0.1
 */