import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;

class amsc
  implements WyDownloader.IDownloadListener
{
  amsc(amsb paramamsb) {}
  
  public void a(String paramString, long paramLong, float paramFloat) {}
  
  /* Error */
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 12
    //   9: iconst_1
    //   10: istore 5
    //   12: iconst_0
    //   13: istore 7
    //   15: iconst_0
    //   16: istore 8
    //   18: iconst_0
    //   19: istore 9
    //   21: iconst_0
    //   22: istore 6
    //   24: iload_3
    //   25: ifeq +827 -> 852
    //   28: new 24	java/io/File
    //   31: dup
    //   32: aload_0
    //   33: getfield 12	amsc:a	Lamsb;
    //   36: getfield 30	amsb:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   39: invokespecial 33	java/io/File:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 12	amsc:a	Lamsb;
    //   47: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   50: invokestatic 40	cooperation/weiyun/utils/SoHelper:a	(Ljava/lang/String;)I
    //   53: istore 13
    //   55: iload 13
    //   57: ifne +39 -> 96
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 12	amsc:a	Lamsb;
    //   65: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   68: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 12	amsc:a	Lamsb;
    //   75: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   78: ifnull +17 -> 95
    //   81: aload_0
    //   82: getfield 12	amsc:a	Lamsb;
    //   85: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   88: aload 4
    //   90: invokeinterface 50 2 0
    //   95: return
    //   96: aload_1
    //   97: invokevirtual 54	java/io/File:length	()J
    //   100: iload 13
    //   102: i2l
    //   103: lcmp
    //   104: ifeq +39 -> 143
    //   107: aload_1
    //   108: aload_0
    //   109: getfield 12	amsc:a	Lamsb;
    //   112: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   118: aload_0
    //   119: getfield 12	amsc:a	Lamsb;
    //   122: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   125: ifnull -30 -> 95
    //   128: aload_0
    //   129: getfield 12	amsc:a	Lamsb;
    //   132: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   135: aload 4
    //   137: invokeinterface 50 2 0
    //   142: return
    //   143: aload_1
    //   144: new 56	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   151: aload_0
    //   152: getfield 12	amsc:a	Lamsb;
    //   155: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   158: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   161: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   164: getstatic 73	java/io/File:separator	Ljava/lang/String;
    //   167: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 83	com/tencent/biz/common/util/ZipUtils:a	(Ljava/io/File;Ljava/lang/String;)V
    //   176: new 24	java/io/File
    //   179: dup
    //   180: aload_0
    //   181: getfield 12	amsc:a	Lamsb;
    //   184: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   187: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   190: ldc 85
    //   192: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   195: invokevirtual 91	java/io/File:exists	()Z
    //   198: ifne +6 -> 204
    //   201: iconst_0
    //   202: istore 5
    //   204: new 24	java/io/File
    //   207: dup
    //   208: aload_0
    //   209: getfield 12	amsc:a	Lamsb;
    //   212: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   215: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   218: ldc 93
    //   220: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   223: invokevirtual 91	java/io/File:exists	()Z
    //   226: ifne +660 -> 886
    //   229: iload 6
    //   231: istore 5
    //   233: aload_1
    //   234: invokevirtual 91	java/io/File:exists	()Z
    //   237: ifeq +14 -> 251
    //   240: aload_1
    //   241: aload_0
    //   242: getfield 12	amsc:a	Lamsb;
    //   245: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   248: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   251: aload_0
    //   252: getfield 12	amsc:a	Lamsb;
    //   255: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   258: ifnull +40 -> 298
    //   261: iload 5
    //   263: ifeq +61 -> 324
    //   266: aload_0
    //   267: getfield 12	amsc:a	Lamsb;
    //   270: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   273: aload_0
    //   274: getfield 12	amsc:a	Lamsb;
    //   277: getfield 96	amsb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   280: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   283: aload_0
    //   284: getfield 12	amsc:a	Lamsb;
    //   287: getfield 101	amsb:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   290: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   293: invokeinterface 104 3 0
    //   298: iload 5
    //   300: ifeq -205 -> 95
    //   303: aload_0
    //   304: getfield 12	amsc:a	Lamsb;
    //   307: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   310: ldc 106
    //   312: ldc 108
    //   314: sipush 1002
    //   317: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   320: invokestatic 119	cooperation/weiyun/utils/PreferenceUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   323: return
    //   324: aload_0
    //   325: getfield 12	amsc:a	Lamsb;
    //   328: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   331: ldc 121
    //   333: invokeinterface 50 2 0
    //   338: goto -40 -> 298
    //   341: astore_2
    //   342: iload 10
    //   344: istore 5
    //   346: new 24	java/io/File
    //   349: dup
    //   350: aload_0
    //   351: getfield 12	amsc:a	Lamsb;
    //   354: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   357: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   360: ldc 85
    //   362: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   365: invokevirtual 91	java/io/File:exists	()Z
    //   368: ifne +6 -> 374
    //   371: iconst_0
    //   372: istore 5
    //   374: new 24	java/io/File
    //   377: dup
    //   378: aload_0
    //   379: getfield 12	amsc:a	Lamsb;
    //   382: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   385: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   388: ldc 93
    //   390: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   393: invokevirtual 91	java/io/File:exists	()Z
    //   396: ifne +487 -> 883
    //   399: iload 7
    //   401: istore 5
    //   403: aload_1
    //   404: invokevirtual 91	java/io/File:exists	()Z
    //   407: ifeq +14 -> 421
    //   410: aload_1
    //   411: aload_0
    //   412: getfield 12	amsc:a	Lamsb;
    //   415: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   418: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   421: aload_0
    //   422: getfield 12	amsc:a	Lamsb;
    //   425: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   428: ifnull +40 -> 468
    //   431: iload 5
    //   433: ifeq +61 -> 494
    //   436: aload_0
    //   437: getfield 12	amsc:a	Lamsb;
    //   440: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   443: aload_0
    //   444: getfield 12	amsc:a	Lamsb;
    //   447: getfield 96	amsb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   450: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   453: aload_0
    //   454: getfield 12	amsc:a	Lamsb;
    //   457: getfield 101	amsb:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   460: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   463: invokeinterface 104 3 0
    //   468: iload 5
    //   470: ifeq -375 -> 95
    //   473: aload_0
    //   474: getfield 12	amsc:a	Lamsb;
    //   477: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   480: ldc 106
    //   482: ldc 108
    //   484: sipush 1002
    //   487: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   490: invokestatic 119	cooperation/weiyun/utils/PreferenceUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   493: return
    //   494: aload_0
    //   495: getfield 12	amsc:a	Lamsb;
    //   498: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   501: ldc 121
    //   503: invokeinterface 50 2 0
    //   508: goto -40 -> 468
    //   511: astore_2
    //   512: iload 11
    //   514: istore 5
    //   516: new 24	java/io/File
    //   519: dup
    //   520: aload_0
    //   521: getfield 12	amsc:a	Lamsb;
    //   524: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   527: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   530: ldc 85
    //   532: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   535: invokevirtual 91	java/io/File:exists	()Z
    //   538: ifne +6 -> 544
    //   541: iconst_0
    //   542: istore 5
    //   544: new 24	java/io/File
    //   547: dup
    //   548: aload_0
    //   549: getfield 12	amsc:a	Lamsb;
    //   552: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   555: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   558: ldc 93
    //   560: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   563: invokevirtual 91	java/io/File:exists	()Z
    //   566: ifne +314 -> 880
    //   569: iload 8
    //   571: istore 5
    //   573: aload_1
    //   574: invokevirtual 91	java/io/File:exists	()Z
    //   577: ifeq +14 -> 591
    //   580: aload_1
    //   581: aload_0
    //   582: getfield 12	amsc:a	Lamsb;
    //   585: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   588: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   591: aload_0
    //   592: getfield 12	amsc:a	Lamsb;
    //   595: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   598: ifnull +40 -> 638
    //   601: iload 5
    //   603: ifeq +61 -> 664
    //   606: aload_0
    //   607: getfield 12	amsc:a	Lamsb;
    //   610: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   613: aload_0
    //   614: getfield 12	amsc:a	Lamsb;
    //   617: getfield 96	amsb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   620: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   623: aload_0
    //   624: getfield 12	amsc:a	Lamsb;
    //   627: getfield 101	amsb:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   630: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   633: invokeinterface 104 3 0
    //   638: iload 5
    //   640: ifeq -545 -> 95
    //   643: aload_0
    //   644: getfield 12	amsc:a	Lamsb;
    //   647: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   650: ldc 106
    //   652: ldc 108
    //   654: sipush 1002
    //   657: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   660: invokestatic 119	cooperation/weiyun/utils/PreferenceUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   663: return
    //   664: aload_0
    //   665: getfield 12	amsc:a	Lamsb;
    //   668: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   671: ldc 121
    //   673: invokeinterface 50 2 0
    //   678: goto -40 -> 638
    //   681: astore_2
    //   682: iload 12
    //   684: istore 5
    //   686: new 24	java/io/File
    //   689: dup
    //   690: aload_0
    //   691: getfield 12	amsc:a	Lamsb;
    //   694: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   697: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   700: ldc 85
    //   702: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   705: invokevirtual 91	java/io/File:exists	()Z
    //   708: ifne +6 -> 714
    //   711: iconst_0
    //   712: istore 5
    //   714: new 24	java/io/File
    //   717: dup
    //   718: aload_0
    //   719: getfield 12	amsc:a	Lamsb;
    //   722: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   725: invokevirtual 66	android/content/Context:getFilesDir	()Ljava/io/File;
    //   728: ldc 93
    //   730: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   733: invokevirtual 91	java/io/File:exists	()Z
    //   736: ifne +141 -> 877
    //   739: iload 9
    //   741: istore 5
    //   743: aload_1
    //   744: invokevirtual 91	java/io/File:exists	()Z
    //   747: ifeq +14 -> 761
    //   750: aload_1
    //   751: aload_0
    //   752: getfield 12	amsc:a	Lamsb;
    //   755: getfield 35	amsb:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   758: invokestatic 43	cooperation/weiyun/utils/SoHelper:a	(Ljava/io/File;Ljava/lang/String;)V
    //   761: aload_0
    //   762: getfield 12	amsc:a	Lamsb;
    //   765: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   768: ifnull +40 -> 808
    //   771: iload 5
    //   773: ifeq +62 -> 835
    //   776: aload_0
    //   777: getfield 12	amsc:a	Lamsb;
    //   780: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   783: aload_0
    //   784: getfield 12	amsc:a	Lamsb;
    //   787: getfield 96	amsb:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   790: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   793: aload_0
    //   794: getfield 12	amsc:a	Lamsb;
    //   797: getfield 101	amsb:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   800: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   803: invokeinterface 104 3 0
    //   808: iload 5
    //   810: ifeq +23 -> 833
    //   813: aload_0
    //   814: getfield 12	amsc:a	Lamsb;
    //   817: getfield 60	amsb:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   820: ldc 106
    //   822: ldc 108
    //   824: sipush 1002
    //   827: invokestatic 114	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   830: invokestatic 119	cooperation/weiyun/utils/PreferenceUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   833: aload_2
    //   834: athrow
    //   835: aload_0
    //   836: getfield 12	amsc:a	Lamsb;
    //   839: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   842: ldc 121
    //   844: invokeinterface 50 2 0
    //   849: goto -41 -> 808
    //   852: aload_0
    //   853: getfield 12	amsc:a	Lamsb;
    //   856: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   859: ifnull -764 -> 95
    //   862: aload_0
    //   863: getfield 12	amsc:a	Lamsb;
    //   866: getfield 46	amsb:jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener	Lcooperation/weiyun/utils/SoHelper$SoListener;
    //   869: aload 4
    //   871: invokeinterface 50 2 0
    //   876: return
    //   877: goto -134 -> 743
    //   880: goto -307 -> 573
    //   883: goto -480 -> 403
    //   886: goto -653 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	889	0	this	amsc
    //   0	889	1	paramString1	String
    //   0	889	2	paramString2	String
    //   0	889	3	paramBoolean	boolean
    //   0	889	4	paramString3	String
    //   0	889	5	paramInt	int
    //   22	208	6	i	int
    //   13	387	7	j	int
    //   16	554	8	k	int
    //   19	721	9	m	int
    //   1	342	10	n	int
    //   4	509	11	i1	int
    //   7	676	12	i2	int
    //   53	48	13	i3	int
    // Exception table:
    //   from	to	target	type
    //   143	176	341	java/util/zip/ZipException
    //   143	176	511	java/io/IOException
    //   143	176	681	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsc
 * JD-Core Version:    0.7.0.1
 */