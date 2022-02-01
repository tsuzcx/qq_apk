public class bbni
{
  private static int a(int paramInt1, int paramInt2)
  {
    int j = paramInt1 % paramInt2;
    int i = paramInt1;
    if (j != 0) {
      i = paramInt1 + (paramInt2 - j);
    }
    return i;
  }
  
  /* Error */
  public static int a(java.lang.String paramString1, java.lang.String paramString2, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 12
    //   9: invokestatic 18	java/lang/System:currentTimeMillis	()J
    //   12: lstore 7
    //   14: fload_2
    //   15: fconst_0
    //   16: fcmpg
    //   17: iflt +39 -> 56
    //   20: fload_2
    //   21: fconst_1
    //   22: fcmpl
    //   23: ifgt +33 -> 56
    //   26: fload_3
    //   27: fconst_0
    //   28: fcmpg
    //   29: iflt +27 -> 56
    //   32: fload_3
    //   33: fconst_1
    //   34: fcmpl
    //   35: ifgt +21 -> 56
    //   38: fload_2
    //   39: fload_3
    //   40: fcmpl
    //   41: ifgt +15 -> 56
    //   44: fload_2
    //   45: fload_3
    //   46: fcmpl
    //   47: ifne +41 -> 88
    //   50: fload_2
    //   51: fconst_0
    //   52: fcmpl
    //   53: ifeq +35 -> 88
    //   56: ldc 20
    //   58: ldc 22
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: fload_2
    //   67: invokestatic 28	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: fload_3
    //   74: invokestatic 28	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   77: aastore
    //   78: invokestatic 34	yuk:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: ldc 35
    //   83: istore 5
    //   85: iload 5
    //   87: ireturn
    //   88: new 37	java/io/File
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 11
    //   98: aload 11
    //   100: invokevirtual 44	java/io/File:length	()J
    //   103: l2i
    //   104: istore 6
    //   106: aload 11
    //   108: invokevirtual 48	java/io/File:exists	()Z
    //   111: ifeq +8 -> 119
    //   114: iload 6
    //   116: ifgt +39 -> 155
    //   119: ldc 20
    //   121: ldc 50
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: fload_2
    //   130: invokestatic 28	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: fload_3
    //   137: invokestatic 28	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: iload 6
    //   145: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 34	yuk:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: ldc 56
    //   154: ireturn
    //   155: aload_0
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokestatic 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lbddn;
    //   161: astore_0
    //   162: fload_3
    //   163: fstore 4
    //   165: fload_3
    //   166: fconst_0
    //   167: fcmpl
    //   168: ifne +6 -> 174
    //   171: fconst_1
    //   172: fstore 4
    //   174: iload 6
    //   176: i2f
    //   177: fload_2
    //   178: fmul
    //   179: f2i
    //   180: aload_0
    //   181: getfield 67	bddn:b	I
    //   184: invokestatic 69	bbni:a	(II)I
    //   187: istore 5
    //   189: iload 6
    //   191: i2f
    //   192: fload 4
    //   194: fmul
    //   195: f2i
    //   196: aload_0
    //   197: getfield 67	bddn:b	I
    //   200: invokestatic 69	bbni:a	(II)I
    //   203: istore 6
    //   205: ldc 20
    //   207: new 71	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   214: ldc 76
    //   216: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: iload 5
    //   221: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: ldc 85
    //   226: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 6
    //   231: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 92	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: iload 6
    //   242: iload 5
    //   244: isub
    //   245: newarray byte
    //   247: astore 15
    //   249: new 37	java/io/File
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 48	java/io/File:exists	()Z
    //   262: ifeq +8 -> 270
    //   265: aload_0
    //   266: invokevirtual 95	java/io/File:delete	()Z
    //   269: pop
    //   270: aload_0
    //   271: invokevirtual 99	java/io/File:getParentFile	()Ljava/io/File;
    //   274: invokevirtual 48	java/io/File:exists	()Z
    //   277: ifne +11 -> 288
    //   280: aload_0
    //   281: invokevirtual 99	java/io/File:getParentFile	()Ljava/io/File;
    //   284: invokevirtual 102	java/io/File:mkdirs	()Z
    //   287: pop
    //   288: aload_0
    //   289: invokevirtual 105	java/io/File:createNewFile	()Z
    //   292: pop
    //   293: new 107	java/io/FileOutputStream
    //   296: dup
    //   297: aload_0
    //   298: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   301: astore_0
    //   302: new 112	java/io/FileInputStream
    //   305: dup
    //   306: aload 11
    //   308: invokespecial 113	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   311: astore 11
    //   313: aload 11
    //   315: ifnull +29 -> 344
    //   318: iload 5
    //   320: ifeq +16 -> 336
    //   323: iload 5
    //   325: i2l
    //   326: lstore 9
    //   328: aload 11
    //   330: lload 9
    //   332: invokevirtual 117	java/io/FileInputStream:skip	(J)J
    //   335: pop2
    //   336: aload 11
    //   338: aload 15
    //   340: invokevirtual 121	java/io/FileInputStream:read	([B)I
    //   343: pop
    //   344: aload_0
    //   345: aload 15
    //   347: invokevirtual 125	java/io/FileOutputStream:write	([B)V
    //   350: aload_0
    //   351: invokevirtual 128	java/io/FileOutputStream:flush	()V
    //   354: aload 11
    //   356: ifnull +8 -> 364
    //   359: aload 11
    //   361: invokevirtual 131	java/io/FileInputStream:close	()V
    //   364: aload_0
    //   365: ifnull +7 -> 372
    //   368: aload_0
    //   369: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   372: ldc 20
    //   374: new 71	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   381: ldc 134
    //   383: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokestatic 18	java/lang/System:currentTimeMillis	()J
    //   389: lload 7
    //   391: lsub
    //   392: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 92	yuk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: iconst_0
    //   402: ireturn
    //   403: astore_1
    //   404: aload_1
    //   405: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   408: goto -44 -> 364
    //   411: astore_0
    //   412: aload_0
    //   413: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   416: goto -44 -> 372
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_0
    //   422: aload 12
    //   424: astore 11
    //   426: aload_1
    //   427: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   430: ldc 141
    //   432: istore 5
    //   434: aload 11
    //   436: ifnull +8 -> 444
    //   439: aload 11
    //   441: invokevirtual 131	java/io/FileInputStream:close	()V
    //   444: aload_0
    //   445: ifnull -360 -> 85
    //   448: aload_0
    //   449: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   452: ldc 141
    //   454: ireturn
    //   455: astore_0
    //   456: aload_0
    //   457: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   460: ldc 141
    //   462: ireturn
    //   463: astore_1
    //   464: aload_1
    //   465: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   468: goto -24 -> 444
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 11
    //   475: aload 13
    //   477: astore_1
    //   478: ldc 20
    //   480: ldc 143
    //   482: invokestatic 145	yuk:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload_0
    //   486: invokevirtual 146	java/lang/Throwable:printStackTrace	()V
    //   489: ldc 141
    //   491: istore 5
    //   493: aload 11
    //   495: ifnull +8 -> 503
    //   498: aload 11
    //   500: invokevirtual 131	java/io/FileInputStream:close	()V
    //   503: aload_1
    //   504: ifnull -419 -> 85
    //   507: aload_1
    //   508: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   511: ldc 141
    //   513: ireturn
    //   514: astore_0
    //   515: aload_0
    //   516: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   519: ldc 141
    //   521: ireturn
    //   522: astore_0
    //   523: aload_0
    //   524: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   527: goto -24 -> 503
    //   530: astore_0
    //   531: aconst_null
    //   532: astore 11
    //   534: aload 14
    //   536: astore_1
    //   537: aload 11
    //   539: ifnull +8 -> 547
    //   542: aload 11
    //   544: invokevirtual 131	java/io/FileInputStream:close	()V
    //   547: aload_1
    //   548: ifnull +7 -> 555
    //   551: aload_1
    //   552: invokevirtual 132	java/io/FileOutputStream:close	()V
    //   555: aload_0
    //   556: athrow
    //   557: astore 11
    //   559: aload 11
    //   561: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   564: goto -17 -> 547
    //   567: astore_1
    //   568: aload_1
    //   569: invokevirtual 140	java/io/IOException:printStackTrace	()V
    //   572: goto -17 -> 555
    //   575: astore 12
    //   577: aconst_null
    //   578: astore 11
    //   580: aload_0
    //   581: astore_1
    //   582: aload 12
    //   584: astore_0
    //   585: goto -48 -> 537
    //   588: astore 12
    //   590: aload_0
    //   591: astore_1
    //   592: aload 12
    //   594: astore_0
    //   595: goto -58 -> 537
    //   598: astore 12
    //   600: aload_0
    //   601: astore_1
    //   602: aload 12
    //   604: astore_0
    //   605: goto -68 -> 537
    //   608: astore_0
    //   609: goto -72 -> 537
    //   612: astore 12
    //   614: aconst_null
    //   615: astore 11
    //   617: aload_0
    //   618: astore_1
    //   619: aload 12
    //   621: astore_0
    //   622: goto -144 -> 478
    //   625: astore 12
    //   627: aload_0
    //   628: astore_1
    //   629: aload 12
    //   631: astore_0
    //   632: goto -154 -> 478
    //   635: astore_1
    //   636: aload 12
    //   638: astore 11
    //   640: goto -214 -> 426
    //   643: astore_1
    //   644: goto -218 -> 426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	paramString1	java.lang.String
    //   0	647	1	paramString2	java.lang.String
    //   0	647	2	paramFloat1	float
    //   0	647	3	paramFloat2	float
    //   163	30	4	f	float
    //   83	409	5	i	int
    //   104	141	6	j	int
    //   12	378	7	l1	long
    //   326	5	9	l2	long
    //   96	447	11	localObject1	Object
    //   557	3	11	localIOException	java.io.IOException
    //   578	61	11	localThrowable1	java.lang.Throwable
    //   7	416	12	localObject2	Object
    //   575	8	12	localObject3	Object
    //   588	5	12	localObject4	Object
    //   598	5	12	localObject5	Object
    //   612	8	12	localThrowable2	java.lang.Throwable
    //   625	12	12	localThrowable3	java.lang.Throwable
    //   1	475	13	localObject6	Object
    //   4	531	14	localObject7	Object
    //   247	99	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   359	364	403	java/io/IOException
    //   368	372	411	java/io/IOException
    //   249	270	419	java/io/IOException
    //   270	288	419	java/io/IOException
    //   288	302	419	java/io/IOException
    //   448	452	455	java/io/IOException
    //   439	444	463	java/io/IOException
    //   249	270	471	java/lang/Throwable
    //   270	288	471	java/lang/Throwable
    //   288	302	471	java/lang/Throwable
    //   507	511	514	java/io/IOException
    //   498	503	522	java/io/IOException
    //   249	270	530	finally
    //   270	288	530	finally
    //   288	302	530	finally
    //   542	547	557	java/io/IOException
    //   551	555	567	java/io/IOException
    //   302	313	575	finally
    //   328	336	588	finally
    //   336	344	588	finally
    //   344	354	588	finally
    //   426	430	598	finally
    //   478	489	608	finally
    //   302	313	612	java/lang/Throwable
    //   328	336	625	java/lang/Throwable
    //   336	344	625	java/lang/Throwable
    //   344	354	625	java/lang/Throwable
    //   302	313	635	java/io/IOException
    //   328	336	643	java/io/IOException
    //   336	344	643	java/io/IOException
    //   344	354	643	java/io/IOException
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    paramInt2 = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2);
    System.arraycopy(paramArrayOfByte1, paramInt1, paramArrayOfByte2, 0, paramInt2);
    return paramInt2;
  }
  
  public static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2 * 2);
    paramInt2 = 0;
    while (paramInt2 < i / 2)
    {
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(paramInt2 * 2 + paramInt1)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt2 * 2 + paramInt1 + 1)];
      paramInt2 += 2;
    }
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2 / 2);
    paramInt2 = 0;
    while (paramInt2 < i - 1)
    {
      paramArrayOfByte2[(paramInt2 * 2)] = paramArrayOfByte1[(paramInt1 + paramInt2)];
      paramArrayOfByte2[(paramInt2 * 2 + 1)] = paramArrayOfByte1[(paramInt1 + paramInt2 + 1)];
      paramArrayOfByte2[(paramInt2 * 2 + 2)] = paramArrayOfByte1[(paramInt1 + paramInt2)];
      paramArrayOfByte2[(paramInt2 * 2 + 3)] = paramArrayOfByte1[(paramInt1 + paramInt2 + 1)];
      paramInt2 += 2;
    }
    return i;
  }
  
  public static int d(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    int j = paramArrayOfByte1.length - paramInt1 - paramInt2;
    paramInt1 = j;
    if (j < 0) {
      paramInt1 = 0;
    }
    j = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2);
    paramInt2 = i;
    while (paramInt2 < j - 1)
    {
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(paramInt1 + j - paramInt2 - 2)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt1 + j - paramInt2 - 1)];
      paramInt2 += 2;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbni
 * JD-Core Version:    0.7.0.1
 */