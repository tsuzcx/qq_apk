package com.dataline.activities;

import java.io.InputStream;

class LiteActivity$46
  implements Runnable
{
  LiteActivity$46(LiteActivity paramLiteActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 13
    //   6: aconst_null
    //   7: astore 15
    //   9: aconst_null
    //   10: astore 14
    //   12: new 33	com/tencent/mm/vfs/VFSFile
    //   15: dup
    //   16: aload_0
    //   17: getfield 18	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokespecial 36	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   23: astore 17
    //   25: aload 17
    //   27: invokevirtual 40	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   30: ifne +48 -> 78
    //   33: aload 17
    //   35: invokevirtual 43	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   38: ifne +40 -> 78
    //   41: aload_0
    //   42: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   45: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   48: iconst_1
    //   49: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   52: pop
    //   53: aload_0
    //   54: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   57: iconst_0
    //   58: invokestatic 57	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   61: pop
    //   62: aload_0
    //   63: getfield 20	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   66: invokevirtual 62	java/io/InputStream:close	()V
    //   69: return
    //   70: astore 12
    //   72: aload 12
    //   74: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   77: return
    //   78: new 67	java/io/FileOutputStream
    //   81: dup
    //   82: aload_0
    //   83: getfield 18	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: invokespecial 68	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   89: astore 16
    //   91: aload 13
    //   93: astore 12
    //   95: aload 16
    //   97: astore 13
    //   99: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   102: sipush 8192
    //   105: invokevirtual 78	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   108: astore 15
    //   110: lconst_0
    //   111: lstore 6
    //   113: lconst_0
    //   114: lstore 8
    //   116: aload 15
    //   118: astore 14
    //   120: aload 15
    //   122: astore 12
    //   124: aload 16
    //   126: astore 13
    //   128: aload_0
    //   129: getfield 20	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   132: aload 15
    //   134: invokevirtual 82	java/io/InputStream:read	([B)I
    //   137: istore 5
    //   139: iload 5
    //   141: iconst_m1
    //   142: if_icmpeq +226 -> 368
    //   145: aload 15
    //   147: astore 14
    //   149: aload 15
    //   151: astore 12
    //   153: aload 16
    //   155: astore 13
    //   157: aload_0
    //   158: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   161: invokestatic 86	com/dataline/activities/LiteActivity:b	(Lcom/dataline/activities/LiteActivity;)Z
    //   164: ifeq +204 -> 368
    //   167: iload 5
    //   169: i2l
    //   170: lload 6
    //   172: ladd
    //   173: lstore 6
    //   175: aload 15
    //   177: astore 14
    //   179: aload 15
    //   181: astore 12
    //   183: aload 16
    //   185: astore 13
    //   187: aload 16
    //   189: aload 15
    //   191: iconst_0
    //   192: iload 5
    //   194: invokevirtual 90	java/io/FileOutputStream:write	([BII)V
    //   197: lload 6
    //   199: lload 8
    //   201: lsub
    //   202: l2d
    //   203: dstore_1
    //   204: aload 15
    //   206: astore 14
    //   208: aload 15
    //   210: astore 12
    //   212: aload 16
    //   214: astore 13
    //   216: aload_0
    //   217: getfield 22	com/dataline/activities/LiteActivity$46:jdField_a_of_type_Long	J
    //   220: lstore 10
    //   222: lload 10
    //   224: l2d
    //   225: dstore_3
    //   226: dload_1
    //   227: invokestatic 96	java/lang/Double:isNaN	(D)Z
    //   230: pop
    //   231: dload_3
    //   232: invokestatic 96	java/lang/Double:isNaN	(D)Z
    //   235: pop
    //   236: dload_1
    //   237: dload_3
    //   238: ddiv
    //   239: ldc2_w 97
    //   242: dcmpl
    //   243: ifle +568 -> 811
    //   246: aload 15
    //   248: astore 14
    //   250: aload 15
    //   252: astore 12
    //   254: aload 16
    //   256: astore 13
    //   258: aload_0
    //   259: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   262: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   265: astore 18
    //   267: aload 15
    //   269: astore 14
    //   271: aload 15
    //   273: astore 12
    //   275: aload 16
    //   277: astore 13
    //   279: aload_0
    //   280: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   283: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: astore 19
    //   288: lload 6
    //   290: l2d
    //   291: dstore_1
    //   292: aload 15
    //   294: astore 14
    //   296: aload 15
    //   298: astore 12
    //   300: aload 16
    //   302: astore 13
    //   304: aload_0
    //   305: getfield 22	com/dataline/activities/LiteActivity$46:jdField_a_of_type_Long	J
    //   308: lstore 8
    //   310: lload 8
    //   312: l2d
    //   313: dstore_3
    //   314: dload_1
    //   315: invokestatic 96	java/lang/Double:isNaN	(D)Z
    //   318: pop
    //   319: dload_3
    //   320: invokestatic 96	java/lang/Double:isNaN	(D)Z
    //   323: pop
    //   324: dload_1
    //   325: dload_3
    //   326: ddiv
    //   327: ldc2_w 99
    //   330: dmul
    //   331: d2i
    //   332: istore 5
    //   334: aload 15
    //   336: astore 14
    //   338: aload 15
    //   340: astore 12
    //   342: aload 16
    //   344: astore 13
    //   346: aload 18
    //   348: aload 19
    //   350: iconst_3
    //   351: iload 5
    //   353: iconst_0
    //   354: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   357: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   360: pop
    //   361: lload 6
    //   363: lstore 8
    //   365: goto -249 -> 116
    //   368: lload 6
    //   370: lconst_0
    //   371: lcmp
    //   372: ifne +51 -> 423
    //   375: aload 15
    //   377: astore 14
    //   379: aload 15
    //   381: astore 12
    //   383: aload 16
    //   385: astore 13
    //   387: aload_0
    //   388: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   391: ldc 109
    //   393: invokevirtual 113	com/dataline/activities/LiteActivity:getString	(I)Ljava/lang/String;
    //   396: putstatic 116	com/dataline/activities/LiteActivity:c	Ljava/lang/String;
    //   399: aload 15
    //   401: astore 14
    //   403: aload 15
    //   405: astore 12
    //   407: aload 16
    //   409: astore 13
    //   411: aload_0
    //   412: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   415: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   418: iconst_1
    //   419: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   422: pop
    //   423: aload 15
    //   425: astore 14
    //   427: aload 15
    //   429: astore 12
    //   431: aload 16
    //   433: astore 13
    //   435: aload_0
    //   436: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   439: invokestatic 86	com/dataline/activities/LiteActivity:b	(Lcom/dataline/activities/LiteActivity;)Z
    //   442: ifeq +70 -> 512
    //   445: aload 15
    //   447: astore 14
    //   449: aload 15
    //   451: astore 12
    //   453: aload 16
    //   455: astore 13
    //   457: aload_0
    //   458: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   461: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   464: aload_0
    //   465: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   468: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   471: iconst_3
    //   472: bipush 100
    //   474: iconst_0
    //   475: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   478: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   481: pop
    //   482: aload 15
    //   484: astore 14
    //   486: aload 15
    //   488: astore 12
    //   490: aload 16
    //   492: astore 13
    //   494: aload_0
    //   495: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   498: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   501: iconst_2
    //   502: ldc2_w 117
    //   505: invokevirtual 122	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   508: pop
    //   509: goto +38 -> 547
    //   512: aload 15
    //   514: astore 14
    //   516: aload 15
    //   518: astore 12
    //   520: aload 16
    //   522: astore 13
    //   524: aload 16
    //   526: invokestatic 128	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   529: aload 15
    //   531: astore 14
    //   533: aload 15
    //   535: astore 12
    //   537: aload 16
    //   539: astore 13
    //   541: aload 17
    //   543: invokevirtual 131	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   546: pop
    //   547: aload 15
    //   549: ifnull +11 -> 560
    //   552: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   555: aload 15
    //   557: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   560: aload_0
    //   561: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   564: iconst_0
    //   565: invokestatic 57	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   568: pop
    //   569: aload_0
    //   570: getfield 20	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   573: invokevirtual 62	java/io/InputStream:close	()V
    //   576: goto +10 -> 586
    //   579: astore 12
    //   581: aload 12
    //   583: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   586: aload 16
    //   588: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   591: return
    //   592: astore 17
    //   594: aload 14
    //   596: astore 15
    //   598: aload 16
    //   600: astore 14
    //   602: goto +20 -> 622
    //   605: astore 12
    //   607: aconst_null
    //   608: astore 13
    //   610: goto +133 -> 743
    //   613: astore 17
    //   615: aconst_null
    //   616: astore 14
    //   618: aload 12
    //   620: astore 15
    //   622: aload 15
    //   624: astore 12
    //   626: aload 14
    //   628: astore 13
    //   630: invokestatic 141	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   633: ifeq +22 -> 655
    //   636: aload 15
    //   638: astore 12
    //   640: aload 14
    //   642: astore 13
    //   644: getstatic 142	com/dataline/activities/LiteActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   647: iconst_2
    //   648: ldc 144
    //   650: aload 17
    //   652: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   655: aload 15
    //   657: astore 12
    //   659: aload 14
    //   661: astore 13
    //   663: aload_0
    //   664: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   667: getfield 48	com/dataline/activities/LiteActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   670: iconst_1
    //   671: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   674: pop
    //   675: aload 15
    //   677: ifnull +11 -> 688
    //   680: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   683: aload 15
    //   685: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   688: aload_0
    //   689: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   692: iconst_0
    //   693: invokestatic 57	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   696: pop
    //   697: aload_0
    //   698: getfield 20	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   701: invokevirtual 62	java/io/InputStream:close	()V
    //   704: goto +10 -> 714
    //   707: astore 12
    //   709: aload 12
    //   711: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   714: aload 14
    //   716: ifnull +16 -> 732
    //   719: aload 14
    //   721: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   724: return
    //   725: astore 12
    //   727: aload 12
    //   729: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   732: return
    //   733: astore 14
    //   735: aload 12
    //   737: astore 15
    //   739: aload 14
    //   741: astore 12
    //   743: aload 15
    //   745: ifnull +11 -> 756
    //   748: invokestatic 74	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   751: aload 15
    //   753: invokevirtual 135	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   756: aload_0
    //   757: getfield 16	com/dataline/activities/LiteActivity$46:this$0	Lcom/dataline/activities/LiteActivity;
    //   760: iconst_0
    //   761: invokestatic 57	com/dataline/activities/LiteActivity:a	(Lcom/dataline/activities/LiteActivity;Z)Z
    //   764: pop
    //   765: aload_0
    //   766: getfield 20	com/dataline/activities/LiteActivity$46:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   769: invokevirtual 62	java/io/InputStream:close	()V
    //   772: goto +10 -> 782
    //   775: astore 14
    //   777: aload 14
    //   779: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   782: aload 13
    //   784: ifnull +18 -> 802
    //   787: aload 13
    //   789: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   792: goto +10 -> 802
    //   795: astore 13
    //   797: aload 13
    //   799: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   802: goto +6 -> 808
    //   805: aload 12
    //   807: athrow
    //   808: goto -3 -> 805
    //   811: goto -695 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	this	46
    //   203	122	1	d1	double
    //   225	101	3	d2	double
    //   137	215	5	i	int
    //   111	258	6	l1	long
    //   114	250	8	l2	long
    //   220	3	10	l3	long
    //   1	1	12	localObject1	Object
    //   70	3	12	localIOException1	java.io.IOException
    //   93	443	12	localObject2	Object
    //   579	3	12	localIOException2	java.io.IOException
    //   605	14	12	localObject3	Object
    //   624	34	12	localObject4	Object
    //   707	3	12	localIOException3	java.io.IOException
    //   725	11	12	localIOException4	java.io.IOException
    //   741	65	12	localObject5	Object
    //   4	784	13	localObject6	Object
    //   795	3	13	localIOException5	java.io.IOException
    //   10	710	14	localObject7	Object
    //   733	7	14	localObject8	Object
    //   775	3	14	localIOException6	java.io.IOException
    //   7	745	15	localObject9	Object
    //   89	510	16	localFileOutputStream	java.io.FileOutputStream
    //   23	519	17	localVFSFile	com.tencent.mm.vfs.VFSFile
    //   592	1	17	localException1	java.lang.Exception
    //   613	38	17	localException2	java.lang.Exception
    //   265	82	18	localMqqHandler1	mqq.os.MqqHandler
    //   286	63	19	localMqqHandler2	mqq.os.MqqHandler
    // Exception table:
    //   from	to	target	type
    //   62	69	70	java/io/IOException
    //   569	576	579	java/io/IOException
    //   99	110	592	java/lang/Exception
    //   128	139	592	java/lang/Exception
    //   157	167	592	java/lang/Exception
    //   187	197	592	java/lang/Exception
    //   216	222	592	java/lang/Exception
    //   258	267	592	java/lang/Exception
    //   279	288	592	java/lang/Exception
    //   304	310	592	java/lang/Exception
    //   346	361	592	java/lang/Exception
    //   387	399	592	java/lang/Exception
    //   411	423	592	java/lang/Exception
    //   435	445	592	java/lang/Exception
    //   457	482	592	java/lang/Exception
    //   494	509	592	java/lang/Exception
    //   524	529	592	java/lang/Exception
    //   541	547	592	java/lang/Exception
    //   12	53	605	finally
    //   78	91	605	finally
    //   12	53	613	java/lang/Exception
    //   78	91	613	java/lang/Exception
    //   697	704	707	java/io/IOException
    //   586	591	725	java/io/IOException
    //   719	724	725	java/io/IOException
    //   99	110	733	finally
    //   128	139	733	finally
    //   157	167	733	finally
    //   187	197	733	finally
    //   216	222	733	finally
    //   258	267	733	finally
    //   279	288	733	finally
    //   304	310	733	finally
    //   346	361	733	finally
    //   387	399	733	finally
    //   411	423	733	finally
    //   435	445	733	finally
    //   457	482	733	finally
    //   494	509	733	finally
    //   524	529	733	finally
    //   541	547	733	finally
    //   630	636	733	finally
    //   644	655	733	finally
    //   663	675	733	finally
    //   765	772	775	java/io/IOException
    //   787	792	795	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.46
 * JD-Core Version:    0.7.0.1
 */