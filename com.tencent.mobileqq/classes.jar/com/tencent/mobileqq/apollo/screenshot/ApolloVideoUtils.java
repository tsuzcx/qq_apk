package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.av.config.ByteBuffer;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class ApolloVideoUtils
{
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = 48;
    ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = System.currentTimeMillis();
    localTransferRequest.mFileType = paramInt1;
    paramString = new ByteBuffer();
    paramString.a(paramInt2);
    paramString.a(paramInt3);
    localTransferRequest.mExtentionInfo = paramString.a();
    ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "all")).transferAsync(localTransferRequest);
  }
  
  public static void a(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = paramInt1 * paramInt2;
    int m = 0;
    int i = 0;
    int n = 0;
    while (m < paramInt2)
    {
      int i1 = 0;
      while (i1 < paramInt1)
      {
        int k = paramArrayOfInt[n];
        k = (paramArrayOfInt[n] & 0xFF0000) >> 16;
        int i2 = (paramArrayOfInt[n] & 0xFF00) >> 8;
        int i5 = (paramArrayOfInt[n] & 0xFF) >> 0;
        int i4 = (k * 66 + i2 * 129 + i5 * 25 + 128 >> 8) + 16;
        int i3 = (k * -38 - i2 * 74 + i5 * 112 + 128 >> 8) + 128;
        i2 = (k * 112 - i2 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0)
        {
          k = 0;
        }
        else
        {
          k = i4;
          if (i4 > 255) {
            k = 255;
          }
        }
        paramArrayOfByte[i] = ((byte)k);
        k = j;
        if (m % 2 == 0)
        {
          k = j;
          if (n % 2 == 0)
          {
            i4 = j + 1;
            if (i3 < 0)
            {
              k = 0;
            }
            else
            {
              k = i3;
              if (i3 > 255) {
                k = 255;
              }
            }
            paramArrayOfByte[j] = ((byte)k);
            k = i4 + 1;
            if (i2 < 0)
            {
              j = 0;
            }
            else
            {
              j = i2;
              if (i2 > 255) {
                j = 255;
              }
            }
            paramArrayOfByte[i4] = ((byte)j);
          }
        }
        n += 1;
        i1 += 1;
        i += 1;
        j = k;
      }
      m += 1;
    }
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 80	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:initVideoTrim	(Landroid/content/Context;)Z
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: iload 6
    //   11: ifeq +1336 -> 1347
    //   14: aload_0
    //   15: ifnull +1332 -> 1347
    //   18: aload_1
    //   19: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +1325 -> 1347
    //   25: aload_2
    //   26: invokestatic 86	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifne +1318 -> 1347
    //   32: iload_3
    //   33: ifgt +6 -> 39
    //   36: goto +1311 -> 1347
    //   39: aload_0
    //   40: invokestatic 92	com/tencent/video/decode/ShortVideoSoLoad:getShortVideoSoPath	(Landroid/content/Context;)Ljava/lang/String;
    //   43: astore_0
    //   44: invokestatic 98	com/tencent/mobileqq/shortvideo/VideoEnvironment:getShortVideoSoLibName	()Ljava/lang/String;
    //   47: astore 9
    //   49: new 100	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   56: astore 7
    //   58: aload 7
    //   60: ldc 103
    //   62: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 7
    //   68: aload_0
    //   69: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 7
    //   75: ldc 109
    //   77: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: aload 9
    //   85: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: ldc 111
    //   91: iconst_1
    //   92: aload 7
    //   94: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aconst_null
    //   101: astore 12
    //   103: aconst_null
    //   104: astore 13
    //   106: aconst_null
    //   107: astore 8
    //   109: aconst_null
    //   110: astore 7
    //   112: aconst_null
    //   113: astore 11
    //   115: new 122	java/lang/ProcessBuilder
    //   118: dup
    //   119: iconst_0
    //   120: anewarray 124	java/lang/String
    //   123: invokespecial 127	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   126: astore 10
    //   128: aload 10
    //   130: iconst_1
    //   131: invokevirtual 131	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   134: pop
    //   135: aload_1
    //   136: aload_2
    //   137: iload_3
    //   138: invokestatic 134	com/tencent/mobileqq/apollo/screenshot/ApolloVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;I)[Ljava/lang/String;
    //   141: astore 14
    //   143: new 136	java/util/ArrayList
    //   146: dup
    //   147: invokespecial 137	java/util/ArrayList:<init>	()V
    //   150: astore_1
    //   151: new 100	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   158: astore 15
    //   160: aload 15
    //   162: aload_0
    //   163: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload 15
    //   169: ldc 139
    //   171: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: aload 15
    //   178: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokeinterface 145 2 0
    //   186: pop
    //   187: aload 14
    //   189: arraylength
    //   190: istore 4
    //   192: iconst_0
    //   193: istore_3
    //   194: iload_3
    //   195: iload 4
    //   197: if_icmpge +21 -> 218
    //   200: aload_1
    //   201: aload 14
    //   203: iload_3
    //   204: aaload
    //   205: invokeinterface 145 2 0
    //   210: pop
    //   211: iload_3
    //   212: iconst_1
    //   213: iadd
    //   214: istore_3
    //   215: goto -21 -> 194
    //   218: new 100	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   225: astore 14
    //   227: aload 14
    //   229: aload_0
    //   230: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 14
    //   236: aload 9
    //   238: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: aload 14
    //   245: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokeinterface 145 2 0
    //   253: pop
    //   254: aload 10
    //   256: aload_1
    //   257: invokevirtual 149	java/lang/ProcessBuilder:command	(Ljava/util/List;)Ljava/lang/ProcessBuilder;
    //   260: pop
    //   261: new 100	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   268: astore_0
    //   269: aload_0
    //   270: ldc 151
    //   272: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_0
    //   277: aload_1
    //   278: aload_1
    //   279: invokeinterface 155 1 0
    //   284: iconst_1
    //   285: isub
    //   286: invokeinterface 159 2 0
    //   291: checkcast 124	java/lang/String
    //   294: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: ldc 111
    //   300: iconst_1
    //   301: aload_0
    //   302: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aload 10
    //   310: invokevirtual 163	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   313: astore 14
    //   315: aload 14
    //   317: invokevirtual 169	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   320: astore_0
    //   321: new 171	java/io/InputStreamReader
    //   324: dup
    //   325: aload_0
    //   326: invokespecial 174	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   329: astore_1
    //   330: aload 8
    //   332: astore 7
    //   334: aload_0
    //   335: astore 8
    //   337: aload_1
    //   338: astore 9
    //   340: new 176	java/io/BufferedReader
    //   343: dup
    //   344: aload_1
    //   345: invokespecial 179	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   348: astore 10
    //   350: aload 14
    //   352: invokevirtual 182	java/lang/Process:waitFor	()I
    //   355: pop
    //   356: aload 14
    //   358: invokevirtual 185	java/lang/Process:exitValue	()I
    //   361: istore_3
    //   362: new 100	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   369: astore 7
    //   371: aload 7
    //   373: ldc 187
    //   375: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 7
    //   381: iload_3
    //   382: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: ldc 111
    //   388: iconst_1
    //   389: aload 7
    //   391: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 10
    //   399: invokevirtual 193	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   402: astore 7
    //   404: aload 7
    //   406: ifnull +42 -> 448
    //   409: new 100	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   416: astore 8
    //   418: aload 8
    //   420: ldc 195
    //   422: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 8
    //   428: aload 7
    //   430: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: ldc 111
    //   436: iconst_1
    //   437: aload 8
    //   439: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: goto -48 -> 397
    //   448: aload 14
    //   450: invokevirtual 198	java/lang/Process:destroy	()V
    //   453: ldc 111
    //   455: iconst_1
    //   456: ldc 200
    //   458: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: aload 10
    //   463: invokevirtual 203	java/io/BufferedReader:close	()V
    //   466: aload_1
    //   467: invokevirtual 204	java/io/InputStreamReader:close	()V
    //   470: aload_0
    //   471: ifnull +45 -> 516
    //   474: aload_0
    //   475: invokevirtual 207	java/io/InputStream:close	()V
    //   478: goto +38 -> 516
    //   481: astore_0
    //   482: new 100	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   489: astore_1
    //   490: aload_1
    //   491: ldc 209
    //   493: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_1
    //   498: aload_0
    //   499: invokevirtual 210	java/io/IOException:toString	()Ljava/lang/String;
    //   502: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: ldc 111
    //   508: iconst_1
    //   509: aload_1
    //   510: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   516: goto +621 -> 1137
    //   519: astore_2
    //   520: aload 10
    //   522: astore 7
    //   524: goto +755 -> 1279
    //   527: astore 7
    //   529: aload 10
    //   531: astore 11
    //   533: aload 7
    //   535: astore 10
    //   537: goto +101 -> 638
    //   540: astore 7
    //   542: aload 10
    //   544: astore 11
    //   546: aload 7
    //   548: astore 10
    //   550: goto +275 -> 825
    //   553: astore 7
    //   555: aload 10
    //   557: astore 11
    //   559: aload 7
    //   561: astore 10
    //   563: goto +423 -> 986
    //   566: astore 10
    //   568: goto +70 -> 638
    //   571: astore 10
    //   573: aload 12
    //   575: astore 11
    //   577: goto +248 -> 825
    //   580: astore 10
    //   582: aload 13
    //   584: astore 11
    //   586: goto +400 -> 986
    //   589: astore_2
    //   590: aconst_null
    //   591: astore_1
    //   592: goto +687 -> 1279
    //   595: astore 10
    //   597: aconst_null
    //   598: astore_1
    //   599: goto +39 -> 638
    //   602: astore 10
    //   604: aconst_null
    //   605: astore_1
    //   606: aload 12
    //   608: astore 11
    //   610: goto +215 -> 825
    //   613: astore 10
    //   615: aconst_null
    //   616: astore_1
    //   617: aload 13
    //   619: astore 11
    //   621: goto +365 -> 986
    //   624: astore_2
    //   625: aconst_null
    //   626: astore_0
    //   627: aload_0
    //   628: astore_1
    //   629: goto +650 -> 1279
    //   632: astore 10
    //   634: aconst_null
    //   635: astore_0
    //   636: aload_0
    //   637: astore_1
    //   638: sipush -1003
    //   641: istore 4
    //   643: aload 11
    //   645: astore 7
    //   647: aload_0
    //   648: astore 8
    //   650: aload_1
    //   651: astore 9
    //   653: aload 10
    //   655: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   658: aload 11
    //   660: astore 7
    //   662: aload_0
    //   663: astore 8
    //   665: aload_1
    //   666: astore 9
    //   668: new 100	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   675: astore 12
    //   677: aload 11
    //   679: astore 7
    //   681: aload_0
    //   682: astore 8
    //   684: aload_1
    //   685: astore 9
    //   687: aload 12
    //   689: ldc 218
    //   691: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload 11
    //   697: astore 7
    //   699: aload_0
    //   700: astore 8
    //   702: aload_1
    //   703: astore 9
    //   705: aload 12
    //   707: aload 10
    //   709: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   712: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload 11
    //   718: astore 7
    //   720: aload_0
    //   721: astore 8
    //   723: aload_1
    //   724: astore 9
    //   726: ldc 111
    //   728: iconst_1
    //   729: aload 12
    //   731: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: aload 11
    //   739: ifnull +11 -> 750
    //   742: aload 11
    //   744: invokevirtual 203	java/io/BufferedReader:close	()V
    //   747: goto +3 -> 750
    //   750: aload_1
    //   751: ifnull +7 -> 758
    //   754: aload_1
    //   755: invokevirtual 204	java/io/InputStreamReader:close	()V
    //   758: iload 4
    //   760: istore_3
    //   761: aload_0
    //   762: ifnull +375 -> 1137
    //   765: aload_0
    //   766: invokevirtual 207	java/io/InputStream:close	()V
    //   769: iload 4
    //   771: istore_3
    //   772: goto +365 -> 1137
    //   775: new 100	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   782: astore_1
    //   783: iload 4
    //   785: istore_3
    //   786: aload_1
    //   787: ldc 209
    //   789: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: pop
    //   793: aload_1
    //   794: aload_0
    //   795: invokevirtual 210	java/io/IOException:toString	()Ljava/lang/String;
    //   798: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: ldc 111
    //   804: iconst_1
    //   805: aload_1
    //   806: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   812: goto +325 -> 1137
    //   815: astore 10
    //   817: aconst_null
    //   818: astore_0
    //   819: aload_0
    //   820: astore_1
    //   821: aload 12
    //   823: astore 11
    //   825: sipush -1002
    //   828: istore 4
    //   830: aload 11
    //   832: astore 7
    //   834: aload_0
    //   835: astore 8
    //   837: aload_1
    //   838: astore 9
    //   840: aload 10
    //   842: invokevirtual 220	java/lang/InterruptedException:printStackTrace	()V
    //   845: aload 11
    //   847: astore 7
    //   849: aload_0
    //   850: astore 8
    //   852: aload_1
    //   853: astore 9
    //   855: new 100	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   862: astore 12
    //   864: aload 11
    //   866: astore 7
    //   868: aload_0
    //   869: astore 8
    //   871: aload_1
    //   872: astore 9
    //   874: aload 12
    //   876: ldc 222
    //   878: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: aload 11
    //   884: astore 7
    //   886: aload_0
    //   887: astore 8
    //   889: aload_1
    //   890: astore 9
    //   892: aload 12
    //   894: aload 10
    //   896: invokevirtual 223	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   899: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 11
    //   905: astore 7
    //   907: aload_0
    //   908: astore 8
    //   910: aload_1
    //   911: astore 9
    //   913: ldc 111
    //   915: iconst_1
    //   916: aload 12
    //   918: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: aload 11
    //   926: ifnull +11 -> 937
    //   929: aload 11
    //   931: invokevirtual 203	java/io/BufferedReader:close	()V
    //   934: goto +3 -> 937
    //   937: aload_1
    //   938: ifnull +7 -> 945
    //   941: aload_1
    //   942: invokevirtual 204	java/io/InputStreamReader:close	()V
    //   945: iload 4
    //   947: istore_3
    //   948: aload_0
    //   949: ifnull +188 -> 1137
    //   952: aload_0
    //   953: invokevirtual 207	java/io/InputStream:close	()V
    //   956: iload 4
    //   958: istore_3
    //   959: goto +178 -> 1137
    //   962: new 100	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   969: astore_1
    //   970: iload 4
    //   972: istore_3
    //   973: goto -187 -> 786
    //   976: astore 10
    //   978: aconst_null
    //   979: astore_0
    //   980: aload_0
    //   981: astore_1
    //   982: aload 13
    //   984: astore 11
    //   986: sipush -1001
    //   989: istore 4
    //   991: aload 11
    //   993: astore 7
    //   995: aload_0
    //   996: astore 8
    //   998: aload_1
    //   999: astore 9
    //   1001: aload 10
    //   1003: invokevirtual 224	java/io/IOException:printStackTrace	()V
    //   1006: aload 11
    //   1008: astore 7
    //   1010: aload_0
    //   1011: astore 8
    //   1013: aload_1
    //   1014: astore 9
    //   1016: new 100	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1023: astore 12
    //   1025: aload 11
    //   1027: astore 7
    //   1029: aload_0
    //   1030: astore 8
    //   1032: aload_1
    //   1033: astore 9
    //   1035: aload 12
    //   1037: ldc 226
    //   1039: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 11
    //   1045: astore 7
    //   1047: aload_0
    //   1048: astore 8
    //   1050: aload_1
    //   1051: astore 9
    //   1053: aload 12
    //   1055: aload 10
    //   1057: invokevirtual 210	java/io/IOException:toString	()Ljava/lang/String;
    //   1060: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: pop
    //   1064: aload 11
    //   1066: astore 7
    //   1068: aload_0
    //   1069: astore 8
    //   1071: aload_1
    //   1072: astore 9
    //   1074: ldc 111
    //   1076: iconst_1
    //   1077: aload 12
    //   1079: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1085: aload 11
    //   1087: ifnull +11 -> 1098
    //   1090: aload 11
    //   1092: invokevirtual 203	java/io/BufferedReader:close	()V
    //   1095: goto +3 -> 1098
    //   1098: aload_1
    //   1099: ifnull +7 -> 1106
    //   1102: aload_1
    //   1103: invokevirtual 204	java/io/InputStreamReader:close	()V
    //   1106: iload 4
    //   1108: istore_3
    //   1109: aload_0
    //   1110: ifnull +27 -> 1137
    //   1113: aload_0
    //   1114: invokevirtual 207	java/io/InputStream:close	()V
    //   1117: iload 4
    //   1119: istore_3
    //   1120: goto +17 -> 1137
    //   1123: new 100	java/lang/StringBuilder
    //   1126: dup
    //   1127: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1130: astore_1
    //   1131: iload 4
    //   1133: istore_3
    //   1134: goto -348 -> 786
    //   1137: iload_3
    //   1138: ifeq +93 -> 1231
    //   1141: new 228	java/io/File
    //   1144: dup
    //   1145: aload_2
    //   1146: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   1149: astore_0
    //   1150: aload_0
    //   1151: invokevirtual 235	java/io/File:exists	()Z
    //   1154: ifeq +77 -> 1231
    //   1157: aload_0
    //   1158: invokevirtual 238	java/io/File:delete	()Z
    //   1161: pop
    //   1162: new 100	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1169: astore_0
    //   1170: aload_0
    //   1171: ldc 240
    //   1173: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: aload_0
    //   1178: iload_3
    //   1179: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: ldc 111
    //   1185: iconst_1
    //   1186: aload_0
    //   1187: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1190: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1193: goto +38 -> 1231
    //   1196: astore_0
    //   1197: new 100	java/lang/StringBuilder
    //   1200: dup
    //   1201: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1204: astore_1
    //   1205: aload_1
    //   1206: ldc 242
    //   1208: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: pop
    //   1212: aload_1
    //   1213: aload_0
    //   1214: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   1217: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: pop
    //   1221: ldc 111
    //   1223: iconst_1
    //   1224: aload_1
    //   1225: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1231: new 100	java/lang/StringBuilder
    //   1234: dup
    //   1235: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1238: astore_0
    //   1239: aload_0
    //   1240: ldc 244
    //   1242: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: pop
    //   1246: aload_0
    //   1247: iload_3
    //   1248: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: pop
    //   1252: ldc 111
    //   1254: iconst_1
    //   1255: aload_0
    //   1256: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1262: iload_3
    //   1263: ifne +6 -> 1269
    //   1266: iconst_1
    //   1267: istore 5
    //   1269: iload 5
    //   1271: ireturn
    //   1272: astore_2
    //   1273: aload 9
    //   1275: astore_1
    //   1276: aload 8
    //   1278: astore_0
    //   1279: aload 7
    //   1281: ifnull +11 -> 1292
    //   1284: aload 7
    //   1286: invokevirtual 203	java/io/BufferedReader:close	()V
    //   1289: goto +3 -> 1292
    //   1292: aload_1
    //   1293: ifnull +7 -> 1300
    //   1296: aload_1
    //   1297: invokevirtual 204	java/io/InputStreamReader:close	()V
    //   1300: aload_0
    //   1301: ifnull +44 -> 1345
    //   1304: aload_0
    //   1305: invokevirtual 207	java/io/InputStream:close	()V
    //   1308: goto +37 -> 1345
    //   1311: new 100	java/lang/StringBuilder
    //   1314: dup
    //   1315: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1318: astore_0
    //   1319: aload_0
    //   1320: ldc 209
    //   1322: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1325: pop
    //   1326: aload_0
    //   1327: aload_1
    //   1328: invokevirtual 210	java/io/IOException:toString	()Ljava/lang/String;
    //   1331: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: ldc 111
    //   1337: iconst_1
    //   1338: aload_0
    //   1339: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1345: aload_2
    //   1346: athrow
    //   1347: new 100	java/lang/StringBuilder
    //   1350: dup
    //   1351: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1354: astore 7
    //   1356: aload 7
    //   1358: ldc 246
    //   1360: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: aload 7
    //   1366: aload_0
    //   1367: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1370: pop
    //   1371: aload 7
    //   1373: ldc 251
    //   1375: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload 7
    //   1381: aload_1
    //   1382: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 7
    //   1388: ldc 251
    //   1390: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: pop
    //   1394: aload 7
    //   1396: aload_2
    //   1397: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: pop
    //   1401: aload 7
    //   1403: ldc 251
    //   1405: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload 7
    //   1411: iload_3
    //   1412: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1415: pop
    //   1416: ldc 111
    //   1418: iconst_1
    //   1419: aload 7
    //   1421: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: invokestatic 213	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1427: iconst_0
    //   1428: ireturn
    //   1429: astore_0
    //   1430: goto -655 -> 775
    //   1433: astore_0
    //   1434: goto -472 -> 962
    //   1437: astore_0
    //   1438: goto -315 -> 1123
    //   1441: astore_1
    //   1442: goto -131 -> 1311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1445	0	paramContext	android.content.Context
    //   0	1445	1	paramString1	String
    //   0	1445	2	paramString2	String
    //   0	1445	3	paramInt	int
    //   190	942	4	i	int
    //   7	1263	5	bool1	boolean
    //   4	6	6	bool2	boolean
    //   56	467	7	localObject1	Object
    //   527	7	7	localException1	java.lang.Exception
    //   540	7	7	localInterruptedException1	java.lang.InterruptedException
    //   553	7	7	localIOException1	java.io.IOException
    //   645	775	7	localObject2	Object
    //   107	1170	8	localObject3	Object
    //   47	1227	9	str	String
    //   126	436	10	localObject4	Object
    //   566	1	10	localException2	java.lang.Exception
    //   571	1	10	localInterruptedException2	java.lang.InterruptedException
    //   580	1	10	localIOException2	java.io.IOException
    //   595	1	10	localException3	java.lang.Exception
    //   602	1	10	localInterruptedException3	java.lang.InterruptedException
    //   613	1	10	localIOException3	java.io.IOException
    //   632	76	10	localException4	java.lang.Exception
    //   815	80	10	localInterruptedException4	java.lang.InterruptedException
    //   976	80	10	localIOException4	java.io.IOException
    //   113	978	11	localObject5	Object
    //   101	977	12	localStringBuilder1	StringBuilder
    //   104	879	13	localObject6	Object
    //   141	308	14	localObject7	Object
    //   158	19	15	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   461	470	481	java/io/IOException
    //   474	478	481	java/io/IOException
    //   350	397	519	finally
    //   397	404	519	finally
    //   409	445	519	finally
    //   448	461	519	finally
    //   350	397	527	java/lang/Exception
    //   397	404	527	java/lang/Exception
    //   409	445	527	java/lang/Exception
    //   448	461	527	java/lang/Exception
    //   350	397	540	java/lang/InterruptedException
    //   397	404	540	java/lang/InterruptedException
    //   409	445	540	java/lang/InterruptedException
    //   448	461	540	java/lang/InterruptedException
    //   350	397	553	java/io/IOException
    //   397	404	553	java/io/IOException
    //   409	445	553	java/io/IOException
    //   448	461	553	java/io/IOException
    //   340	350	566	java/lang/Exception
    //   340	350	571	java/lang/InterruptedException
    //   340	350	580	java/io/IOException
    //   321	330	589	finally
    //   321	330	595	java/lang/Exception
    //   321	330	602	java/lang/InterruptedException
    //   321	330	613	java/io/IOException
    //   115	192	624	finally
    //   200	211	624	finally
    //   218	321	624	finally
    //   115	192	632	java/lang/Exception
    //   200	211	632	java/lang/Exception
    //   218	321	632	java/lang/Exception
    //   115	192	815	java/lang/InterruptedException
    //   200	211	815	java/lang/InterruptedException
    //   218	321	815	java/lang/InterruptedException
    //   115	192	976	java/io/IOException
    //   200	211	976	java/io/IOException
    //   218	321	976	java/io/IOException
    //   1141	1193	1196	java/lang/Exception
    //   340	350	1272	finally
    //   653	658	1272	finally
    //   668	677	1272	finally
    //   687	695	1272	finally
    //   705	716	1272	finally
    //   726	737	1272	finally
    //   840	845	1272	finally
    //   855	864	1272	finally
    //   874	882	1272	finally
    //   892	903	1272	finally
    //   913	924	1272	finally
    //   1001	1006	1272	finally
    //   1016	1025	1272	finally
    //   1035	1043	1272	finally
    //   1053	1064	1272	finally
    //   1074	1085	1272	finally
    //   742	747	1429	java/io/IOException
    //   754	758	1429	java/io/IOException
    //   765	769	1429	java/io/IOException
    //   929	934	1433	java/io/IOException
    //   941	945	1433	java/io/IOException
    //   952	956	1433	java/io/IOException
    //   1090	1095	1437	java/io/IOException
    //   1102	1106	1437	java/io/IOException
    //   1113	1117	1437	java/io/IOException
    //   1284	1289	1441	java/io/IOException
    //   1296	1300	1441	java/io/IOException
    //   1304	1308	1441	java/io/IOException
  }
  
  private static String[] a(String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt);
    return new String[] { "-d", "-y", "-i", paramString1, "-s", localStringBuilder.toString(), paramString2 };
  }
  
  public static void b(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2;
    int j = i / 4;
    int m = i;
    int k = j + i;
    int i1 = 0;
    i = 0;
    j = 0;
    while (i1 < paramInt2)
    {
      int n = j;
      int i2 = i;
      int i3 = 0;
      j = m;
      i = n;
      m = i2;
      i2 = i3;
      while (i2 < paramInt1)
      {
        n = paramArrayOfInt[m];
        n = (paramArrayOfInt[m] & 0xFF0000) >> 16;
        int i6 = (paramArrayOfInt[m] & 0xFF00) >> 8;
        i3 = paramArrayOfInt[m];
        int i4 = 255;
        int i7 = (i3 & 0xFF) >> 0;
        i3 = (n * 66 + i6 * 129 + i7 * 25 + 128 >> 8) + 16;
        int i5 = (n * -38 - i6 * 74 + i7 * 112 + 128 >> 8) + 128;
        i6 = (n * 112 - i6 * 94 - i7 * 18 + 128 >> 8) + 128;
        if (i3 < 0)
        {
          n = 0;
        }
        else
        {
          n = i3;
          if (i3 > 255) {
            n = 255;
          }
        }
        paramArrayOfByte[i] = ((byte)n);
        i3 = k;
        n = j;
        if (i1 % 2 == 0)
        {
          i3 = k;
          n = j;
          if (m % 2 == 0)
          {
            if (i6 < 0)
            {
              n = 0;
            }
            else
            {
              n = i6;
              if (i6 > 255) {
                n = 255;
              }
            }
            paramArrayOfByte[k] = ((byte)n);
            if (i5 < 0) {
              n = 0;
            } else if (i5 > 255) {
              n = i4;
            } else {
              n = i5;
            }
            paramArrayOfByte[j] = ((byte)n);
            n = j + 1;
            i3 = k + 1;
          }
        }
        m += 1;
        i2 += 1;
        i += 1;
        k = i3;
        j = n;
      }
      i1 += 1;
      n = i;
      i2 = j;
      i = m;
      j = n;
      m = i2;
    }
  }
  
  public static void c(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    int m = 0;
    while (k < paramInt2)
    {
      int n = 0;
      while (n < paramInt1)
      {
        int j = paramArrayOfInt[m];
        j = (paramArrayOfInt[m] & 0xFF0000) >> 16;
        int i1 = (paramArrayOfInt[m] & 0xFF00) >> 8;
        int i3 = (paramArrayOfInt[m] & 0xFF) >> 0;
        int i4 = (j * 66 + i1 * 129 + i3 * 25 + 128 >> 8) + 16;
        int i2 = (j * -38 - i1 * 74 + i3 * 112 + 128 >> 8) + 128;
        i3 = (j * 112 - i1 * 94 - i3 * 18 + 128 >> 8) + 128;
        i1 = i + 1;
        if (i4 < 0)
        {
          j = 0;
        }
        else
        {
          j = i4;
          if (i4 > 255) {
            j = 255;
          }
        }
        paramArrayOfByte[i] = ((byte)j);
        if ((k % 2 == 0) && (m % 2 == 0))
        {
          if (i2 < 0)
          {
            i = 0;
          }
          else
          {
            i = i2;
            if (i2 > 255) {
              i = 255;
            }
          }
          paramArrayOfByte[(i1 + 1)] = ((byte)i);
          if (i3 < 0)
          {
            i = 0;
          }
          else
          {
            i = i3;
            if (i3 > 255) {
              i = 255;
            }
          }
          paramArrayOfByte[(i1 + 3)] = ((byte)i);
        }
        i = i1;
        if (m % 2 == 0) {
          i = i1 + 1;
        }
        m += 1;
        n += 1;
      }
      k += 1;
    }
  }
  
  public static void d(byte[] paramArrayOfByte, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfByte.length / 2;
    int i1 = 0;
    int k = 0;
    int i = 0;
    while (i1 < paramInt2)
    {
      int m = j;
      j = i;
      int i2 = 0;
      int n;
      for (i = m; i2 < paramInt1; i = n)
      {
        m = paramArrayOfInt[j];
        m = (paramArrayOfInt[j] & 0xFF0000) >> 16;
        int i3 = (paramArrayOfInt[j] & 0xFF00) >> 8;
        int i5 = (paramArrayOfInt[j] & 0xFF) >> 0;
        int i4 = (m * 66 + i3 * 129 + i5 * 25 + 128 >> 8) + 16;
        n = (m * -38 - i3 * 74 + i5 * 112 + 128 >> 8) + 128;
        i3 = (m * 112 - i3 * 94 - i5 * 18 + 128 >> 8) + 128;
        i5 = i1 % 2;
        if ((i5 == 0) && (j % 2 == 0))
        {
          if (i4 < 0) {
            m = 0;
          } else {
            m = Math.min(i4, 255);
          }
          paramArrayOfByte[k] = ((byte)m);
          m = k + 1 + 1;
          if (n < 0) {
            k = 0;
          } else {
            k = Math.min(n, 255);
          }
          paramArrayOfByte[m] = ((byte)k);
          if (i3 < 0) {
            k = 0;
          } else {
            k = Math.min(i3, 255);
          }
          paramArrayOfByte[(i + 1)] = ((byte)k);
          n = i;
        }
        else if ((i5 == 0) && (j % 2 == 1))
        {
          if (i4 < 0) {
            m = 0;
          } else {
            m = Math.min(i4, 255);
          }
          paramArrayOfByte[k] = ((byte)m);
          m = k + 1;
          n = i;
        }
        else if ((i5 == 1) && (j % 2 == 0))
        {
          if (i4 < 0) {
            m = 0;
          } else {
            m = Math.min(i4, 255);
          }
          paramArrayOfByte[i] = ((byte)m);
          n = i + 1 + 1;
          m = k;
        }
        else
        {
          m = k;
          n = i;
          if (i5 == 1)
          {
            m = k;
            n = i;
            if (j % 2 == 1)
            {
              if (i4 < 0) {
                m = 0;
              } else {
                m = Math.min(i4, 255);
              }
              paramArrayOfByte[i] = ((byte)m);
              n = i + 1;
              m = k;
            }
          }
        }
        j += 1;
        i2 += 1;
        k = m;
      }
      i1 += 1;
      m = i;
      i = j;
      j = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloVideoUtils
 * JD-Core Version:    0.7.0.1
 */