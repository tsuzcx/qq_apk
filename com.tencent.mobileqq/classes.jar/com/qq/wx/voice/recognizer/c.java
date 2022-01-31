package com.qq.wx.voice.recognizer;

import android.media.AudioRecord;
import com.qq.wx.voice.vad.EVad;

final class c
  implements Runnable
{
  private boolean a = false;
  private boolean b = false;
  private AudioRecord c = null;
  private int d = 16;
  private int e = 2;
  private EVad f = null;
  private InnerAudioList g = null;
  
  protected final int a()
  {
    try
    {
      InfoRecorder.b = AudioRecord.getMinBufferSize(InfoRecorder.a, this.d, this.e);
      this.c = new AudioRecord(1, InfoRecorder.a, this.d, this.e, InfoRecorder.b);
      this.f = new EVad();
      return 0;
    }
    catch (Exception localException)
    {
      InfoRecognizer.b.b(-301);
      localException.printStackTrace();
    }
    return -1;
  }
  
  protected final int a(InnerAudioList paramInnerAudioList)
  {
    this.g = paramInnerAudioList;
    if (this.c.getState() != 1)
    {
      InfoRecognizer.b.b(-301);
      return -1;
    }
    if (this.f.Init(InfoRecorder.a, InfoRecorder.c, InfoRecorder.e, InfoRecorder.f, InfoRecorder.g) != 0)
    {
      InfoRecognizer.b.b(-304);
      return -1;
    }
    this.a = true;
    this.b = true;
    return 0;
  }
  
  protected final void b()
  {
    this.b = false;
  }
  
  protected final void c()
  {
    this.a = false;
  }
  
  protected final void d()
  {
    this.f.Release();
    this.f = null;
    this.c.release();
    this.c = null;
  }
  
  protected final void e()
  {
    try
    {
      notify();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: getstatic 106	com/qq/wx/voice/recognizer/VoiceRecordState:Start	Lcom/qq/wx/voice/recognizer/VoiceRecordState;
    //   3: astore 9
    //   5: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   8: aload 9
    //   10: invokevirtual 109	com/qq/wx/voice/recognizer/d:a	(Lcom/qq/wx/voice/recognizer/VoiceRecordState;)V
    //   13: aload_0
    //   14: getfield 28	com/qq/wx/voice/recognizer/c:c	Landroid/media/AudioRecord;
    //   17: invokevirtual 112	android/media/AudioRecord:startRecording	()V
    //   20: getstatic 115	com/qq/wx/voice/recognizer/VoiceRecordState:Recording	Lcom/qq/wx/voice/recognizer/VoiceRecordState;
    //   23: astore 9
    //   25: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   28: aload 9
    //   30: invokevirtual 109	com/qq/wx/voice/recognizer/d:a	(Lcom/qq/wx/voice/recognizer/VoiceRecordState;)V
    //   33: new 117	java/util/LinkedList
    //   36: dup
    //   37: invokespecial 118	java/util/LinkedList:<init>	()V
    //   40: astore 9
    //   42: getstatic 121	com/qq/wx/voice/recognizer/InfoRecorder:h	I
    //   45: getstatic 52	com/qq/wx/voice/recognizer/InfoRecorder:b	I
    //   48: idiv
    //   49: istore 8
    //   51: iconst_0
    //   52: istore_3
    //   53: new 123	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 125
    //   59: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload 8
    //   64: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 140	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   73: iconst_0
    //   74: istore_2
    //   75: iconst_3
    //   76: istore 5
    //   78: iconst_1
    //   79: istore_1
    //   80: aload_0
    //   81: getfield 24	com/qq/wx/voice/recognizer/c:a	Z
    //   84: ifne +23 -> 107
    //   87: aload_0
    //   88: getfield 28	com/qq/wx/voice/recognizer/c:c	Landroid/media/AudioRecord;
    //   91: invokevirtual 143	android/media/AudioRecord:stop	()V
    //   94: return
    //   95: astore 9
    //   97: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   100: sipush -302
    //   103: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   106: return
    //   107: getstatic 52	com/qq/wx/voice/recognizer/InfoRecorder:b	I
    //   110: newarray byte
    //   112: astore 10
    //   114: aload_0
    //   115: getfield 28	com/qq/wx/voice/recognizer/c:c	Landroid/media/AudioRecord;
    //   118: aload 10
    //   120: iconst_0
    //   121: getstatic 52	com/qq/wx/voice/recognizer/InfoRecorder:b	I
    //   124: invokevirtual 147	android/media/AudioRecord:read	([BII)I
    //   127: istore 4
    //   129: iload 4
    //   131: bipush 253
    //   133: if_icmpne +15 -> 148
    //   136: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   139: sipush 10131
    //   142: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   145: goto -58 -> 87
    //   148: iload 4
    //   150: bipush 254
    //   152: if_icmpne +15 -> 167
    //   155: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   158: sipush 10132
    //   161: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   164: goto -77 -> 87
    //   167: iload 4
    //   169: getstatic 52	com/qq/wx/voice/recognizer/InfoRecorder:b	I
    //   172: if_icmpeq +15 -> 187
    //   175: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   178: sipush -303
    //   181: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   184: goto -97 -> 87
    //   187: iload_3
    //   188: iload 4
    //   190: iadd
    //   191: istore 6
    //   193: getstatic 148	com/qq/wx/voice/recognizer/InfoRecorder:d	I
    //   196: ifle +80 -> 276
    //   199: new 123	java/lang/StringBuilder
    //   202: dup
    //   203: iload 6
    //   205: sipush 1000
    //   208: imul
    //   209: invokestatic 154	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: ldc 156
    //   217: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: getstatic 44	com/qq/wx/voice/recognizer/InfoRecorder:a	I
    //   223: iconst_1
    //   224: ishl
    //   225: getstatic 148	com/qq/wx/voice/recognizer/InfoRecorder:d	I
    //   228: imul
    //   229: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 140	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   238: iload_1
    //   239: ifeq +37 -> 276
    //   242: iload 6
    //   244: i2l
    //   245: ldc2_w 160
    //   248: lmul
    //   249: getstatic 44	com/qq/wx/voice/recognizer/InfoRecorder:a	I
    //   252: i2l
    //   253: iconst_1
    //   254: lshl
    //   255: getstatic 148	com/qq/wx/voice/recognizer/InfoRecorder:d	I
    //   258: i2l
    //   259: lmul
    //   260: lcmp
    //   261: ifle +15 -> 276
    //   264: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   267: sipush -307
    //   270: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   273: goto -186 -> 87
    //   276: aload 10
    //   278: iload 4
    //   280: invokestatic 167	com/qq/wx/voice/util/Common:calculateVolumn	([BI)I
    //   283: istore_3
    //   284: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   287: iload_3
    //   288: invokevirtual 169	com/qq/wx/voice/recognizer/d:a	(I)V
    //   291: aload_0
    //   292: getfield 26	com/qq/wx/voice/recognizer/c:b	Z
    //   295: ifne +118 -> 413
    //   298: getstatic 172	com/qq/wx/voice/recognizer/VoiceRecordState:Complete	Lcom/qq/wx/voice/recognizer/VoiceRecordState;
    //   301: astore 11
    //   303: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   306: aload 11
    //   308: invokevirtual 109	com/qq/wx/voice/recognizer/d:a	(Lcom/qq/wx/voice/recognizer/VoiceRecordState;)V
    //   311: iload_2
    //   312: ifne +47 -> 359
    //   315: new 174	com/qq/wx/voice/recognizer/a
    //   318: dup
    //   319: aconst_null
    //   320: getstatic 180	com/qq/wx/voice/recognizer/InnerAudioState:cancel	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   323: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   326: astore 9
    //   328: aload 9
    //   330: iload 6
    //   332: putfield 184	com/qq/wx/voice/recognizer/a:c	I
    //   335: aload_0
    //   336: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   339: aload 9
    //   341: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   344: ifne -257 -> 87
    //   347: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   350: sipush -305
    //   353: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   356: goto -269 -> 87
    //   359: iload_2
    //   360: ifeq +53 -> 413
    //   363: ldc 191
    //   365: invokestatic 140	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   368: new 174	com/qq/wx/voice/recognizer/a
    //   371: dup
    //   372: aload 10
    //   374: getstatic 193	com/qq/wx/voice/recognizer/InnerAudioState:stop	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   377: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   380: astore 9
    //   382: aload 9
    //   384: iload 6
    //   386: putfield 184	com/qq/wx/voice/recognizer/a:c	I
    //   389: aload_0
    //   390: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   393: aload 9
    //   395: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   398: ifne -311 -> 87
    //   401: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   404: sipush -305
    //   407: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   410: goto -323 -> 87
    //   413: aload_0
    //   414: getfield 34	com/qq/wx/voice/recognizer/c:f	Lcom/qq/wx/voice/vad/EVad;
    //   417: aload 10
    //   419: iload 4
    //   421: invokevirtual 196	com/qq/wx/voice/vad/EVad:AddData	([BI)I
    //   424: istore 7
    //   426: iload_1
    //   427: istore_3
    //   428: iload_2
    //   429: istore 4
    //   431: iload_2
    //   432: ifne +265 -> 697
    //   435: iload_1
    //   436: istore_3
    //   437: iload_2
    //   438: istore 4
    //   440: iload 7
    //   442: iconst_2
    //   443: if_icmpne +254 -> 697
    //   446: iload_1
    //   447: istore_3
    //   448: iload_2
    //   449: istore 4
    //   451: iload 5
    //   453: iconst_3
    //   454: if_icmpne +243 -> 697
    //   457: iconst_1
    //   458: istore 4
    //   460: iconst_0
    //   461: istore_3
    //   462: iconst_0
    //   463: istore_1
    //   464: new 123	java/lang/StringBuilder
    //   467: dup
    //   468: ldc 198
    //   470: invokespecial 128	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload 9
    //   475: invokevirtual 201	java/util/LinkedList:size	()I
    //   478: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 140	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   487: aload 9
    //   489: invokevirtual 205	java/util/LinkedList:isEmpty	()Z
    //   492: ifne +197 -> 689
    //   495: new 174	com/qq/wx/voice/recognizer/a
    //   498: dup
    //   499: aload 9
    //   501: invokevirtual 209	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   504: checkcast 211	[B
    //   507: getstatic 214	com/qq/wx/voice/recognizer/InnerAudioState:begin	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   510: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   513: astore 11
    //   515: aload 11
    //   517: iload 6
    //   519: putfield 184	com/qq/wx/voice/recognizer/a:c	I
    //   522: aload_0
    //   523: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   526: aload 11
    //   528: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   531: ifne +158 -> 689
    //   534: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   537: sipush -305
    //   540: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   543: goto -456 -> 87
    //   546: new 174	com/qq/wx/voice/recognizer/a
    //   549: dup
    //   550: aload 9
    //   552: invokevirtual 209	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   555: checkcast 211	[B
    //   558: getstatic 217	com/qq/wx/voice/recognizer/InnerAudioState:middle	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   561: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   564: astore 11
    //   566: aload_0
    //   567: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   570: aload 11
    //   572: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   575: ifne +114 -> 689
    //   578: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   581: sipush -305
    //   584: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   587: iconst_1
    //   588: istore_2
    //   589: iload_2
    //   590: istore_3
    //   591: iload_2
    //   592: ifeq +198 -> 790
    //   595: iload 7
    //   597: iconst_3
    //   598: if_icmpne +152 -> 750
    //   601: iload 5
    //   603: iconst_2
    //   604: if_icmpne +146 -> 750
    //   607: getstatic 219	com/qq/wx/voice/recognizer/InfoRecognizer:f	Z
    //   610: ifne +16 -> 626
    //   613: getstatic 172	com/qq/wx/voice/recognizer/VoiceRecordState:Complete	Lcom/qq/wx/voice/recognizer/VoiceRecordState;
    //   616: astore 11
    //   618: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   621: aload 11
    //   623: invokevirtual 109	com/qq/wx/voice/recognizer/d:a	(Lcom/qq/wx/voice/recognizer/VoiceRecordState;)V
    //   626: iconst_0
    //   627: istore_3
    //   628: ldc 191
    //   630: invokestatic 140	com/qq/wx/voice/util/LogTool:d	(Ljava/lang/String;)V
    //   633: aload 9
    //   635: invokevirtual 222	java/util/LinkedList:clear	()V
    //   638: getstatic 219	com/qq/wx/voice/recognizer/InfoRecognizer:f	Z
    //   641: ifne +64 -> 705
    //   644: new 174	com/qq/wx/voice/recognizer/a
    //   647: dup
    //   648: aload 10
    //   650: getstatic 193	com/qq/wx/voice/recognizer/InnerAudioState:stop	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   653: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   656: astore 9
    //   658: aload 9
    //   660: iload 6
    //   662: putfield 184	com/qq/wx/voice/recognizer/a:c	I
    //   665: aload_0
    //   666: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   669: aload 9
    //   671: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   674: ifne -587 -> 87
    //   677: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   680: sipush -305
    //   683: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   686: goto -599 -> 87
    //   689: aload 9
    //   691: invokevirtual 205	java/util/LinkedList:isEmpty	()Z
    //   694: ifeq -148 -> 546
    //   697: iload 4
    //   699: istore_2
    //   700: iload_3
    //   701: istore_1
    //   702: goto -113 -> 589
    //   705: new 174	com/qq/wx/voice/recognizer/a
    //   708: dup
    //   709: aload 10
    //   711: getstatic 225	com/qq/wx/voice/recognizer/InnerAudioState:end	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   714: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   717: astore 11
    //   719: aload 11
    //   721: iload 6
    //   723: putfield 184	com/qq/wx/voice/recognizer/a:c	I
    //   726: aload_0
    //   727: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   730: aload 11
    //   732: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   735: ifne +55 -> 790
    //   738: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   741: sipush -305
    //   744: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   747: goto -660 -> 87
    //   750: new 174	com/qq/wx/voice/recognizer/a
    //   753: dup
    //   754: aload 10
    //   756: getstatic 217	com/qq/wx/voice/recognizer/InnerAudioState:middle	Lcom/qq/wx/voice/recognizer/InnerAudioState;
    //   759: invokespecial 183	com/qq/wx/voice/recognizer/a:<init>	([BLcom/qq/wx/voice/recognizer/InnerAudioState;)V
    //   762: astore 11
    //   764: iload_2
    //   765: istore_3
    //   766: aload_0
    //   767: getfield 36	com/qq/wx/voice/recognizer/c:g	Lcom/qq/wx/voice/recognizer/InnerAudioList;
    //   770: aload 11
    //   772: invokevirtual 189	com/qq/wx/voice/recognizer/InnerAudioList:a	(Lcom/qq/wx/voice/recognizer/a;)Z
    //   775: ifne +15 -> 790
    //   778: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   781: sipush -305
    //   784: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   787: goto -700 -> 87
    //   790: aload 9
    //   792: aload 10
    //   794: invokevirtual 229	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   797: pop
    //   798: aload 9
    //   800: invokevirtual 201	java/util/LinkedList:size	()I
    //   803: iload 8
    //   805: if_icmple +9 -> 814
    //   808: aload 9
    //   810: invokevirtual 209	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   813: pop
    //   814: iload 7
    //   816: istore 5
    //   818: iload_3
    //   819: istore_2
    //   820: iload 6
    //   822: istore_3
    //   823: goto -743 -> 80
    //   826: astore 9
    //   828: getstatic 63	com/qq/wx/voice/recognizer/InfoRecognizer:b	Lcom/qq/wx/voice/recognizer/d;
    //   831: sipush -306
    //   834: invokevirtual 68	com/qq/wx/voice/recognizer/d:b	(I)V
    //   837: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	c
    //   79	623	1	i	int
    //   74	746	2	j	int
    //   52	771	3	k	int
    //   127	571	4	m	int
    //   76	741	5	n	int
    //   191	630	6	i1	int
    //   424	391	7	i2	int
    //   49	757	8	i3	int
    //   3	38	9	localObject1	Object
    //   95	1	9	localIllegalStateException1	java.lang.IllegalStateException
    //   326	483	9	locala	a
    //   826	1	9	localIllegalStateException2	java.lang.IllegalStateException
    //   112	681	10	arrayOfByte	byte[]
    //   301	470	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	95	java/lang/IllegalStateException
    //   87	94	826	java/lang/IllegalStateException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qq.wx.voice.recognizer.c
 * JD-Core Version:    0.7.0.1
 */