package com.tencent.biz.qqstory.album;

import android.content.Context;
import com.tencent.biz.qqstory.album.model.StoryAlbum.PicInfo;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;

public class ScanTask
{
  private Context a = QQStoryContext.a().c().getBaseContext();
  
  private boolean a(StoryAlbum.PicInfo paramPicInfo)
  {
    if ((paramPicInfo.d > 240) && (paramPicInfo.e > 240))
    {
      if (paramPicInfo.e / paramPicInfo.d <= 0.2F)
      {
        SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramPicInfo.d), Integer.valueOf(paramPicInfo.e), paramPicInfo.b);
        return false;
      }
      if (paramPicInfo.e / paramPicInfo.d >= 2.2F)
      {
        SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramPicInfo.d), Integer.valueOf(paramPicInfo.e), paramPicInfo.b);
        return false;
      }
      return true;
    }
    SLog.a("Q.qqstory.recommendAlbum.logic.StoryScanManager.ScanTask", "is not match w=%d,h=%d,path=%s", Integer.valueOf(paramPicInfo.d), Integer.valueOf(paramPicInfo.e), paramPicInfo.b);
    return false;
  }
  
  /* Error */
  public java.util.List<StoryAlbum.PicInfo> a(Context paramContext, long paramLong, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 64	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   7: astore 17
    //   9: aload 17
    //   11: ldc 67
    //   13: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 17
    //   19: lload_2
    //   20: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 17
    //   26: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 17
    //   31: ldc 41
    //   33: astore 20
    //   35: ldc 41
    //   37: aload 17
    //   39: invokestatic 81	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: getstatic 86	android/os/Environment:DIRECTORY_DCIM	Ljava/lang/String;
    //   45: invokestatic 90	android/os/Environment:getExternalStoragePublicDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   48: invokevirtual 96	java/io/File:listFiles	()[Ljava/io/File;
    //   51: astore 19
    //   53: ldc 98
    //   55: astore 18
    //   57: aload 18
    //   59: astore 17
    //   61: aload 19
    //   63: ifnull +100 -> 163
    //   66: aload 19
    //   68: arraylength
    //   69: istore 7
    //   71: iconst_0
    //   72: istore 6
    //   74: aload 18
    //   76: astore 17
    //   78: iload 6
    //   80: iload 7
    //   82: if_icmpge +81 -> 163
    //   85: aload 19
    //   87: iload 6
    //   89: aaload
    //   90: astore 17
    //   92: aload 17
    //   94: invokevirtual 101	java/io/File:getName	()Ljava/lang/String;
    //   97: invokevirtual 106	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   100: ldc 108
    //   102: invokestatic 114	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   105: ifeq +49 -> 154
    //   108: new 64	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   115: astore 18
    //   117: aload 18
    //   119: ldc 98
    //   121: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 18
    //   127: aload 17
    //   129: invokevirtual 101	java/io/File:getName	()Ljava/lang/String;
    //   132: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 18
    //   138: ldc 116
    //   140: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 18
    //   146: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: astore 17
    //   151: goto +12 -> 163
    //   154: iload 6
    //   156: iconst_1
    //   157: iadd
    //   158: istore 6
    //   160: goto -86 -> 74
    //   163: new 118	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 119	java/util/ArrayList:<init>	()V
    //   170: astore 21
    //   172: invokestatic 15	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   175: invokevirtual 122	com/tencent/biz/qqstory/app/QQStoryContext:d	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   178: invokevirtual 128	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   181: astore 23
    //   183: new 64	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   190: astore 18
    //   192: aload 18
    //   194: ldc 130
    //   196: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 18
    //   202: lload_2
    //   203: invokevirtual 74	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 18
    //   209: ldc 132
    //   211: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 18
    //   217: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore 19
    //   222: new 64	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   229: astore 18
    //   231: aload 18
    //   233: ldc 134
    //   235: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 18
    //   241: aload 17
    //   243: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 18
    //   249: ldc 136
    //   251: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload 18
    //   257: ldc 138
    //   259: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 18
    //   265: ldc 139
    //   267: invokestatic 144	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   270: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 18
    //   276: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   279: astore 18
    //   281: aload 18
    //   283: astore 17
    //   285: lload_2
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +35 -> 323
    //   291: new 64	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   298: astore 17
    //   300: aload 17
    //   302: aload 19
    //   304: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 17
    //   310: aload 18
    //   312: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 17
    //   318: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore 17
    //   323: aconst_null
    //   324: astore 22
    //   326: iload 4
    //   328: ifeq +38 -> 366
    //   331: new 64	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   338: astore 18
    //   340: aload 18
    //   342: ldc 146
    //   344: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 18
    //   350: iload 5
    //   352: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 18
    //   358: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: astore 24
    //   363: goto +31 -> 394
    //   366: new 64	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   373: astore 18
    //   375: aload 18
    //   377: ldc 151
    //   379: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 18
    //   385: iload 5
    //   387: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: goto -35 -> 356
    //   394: aload_1
    //   395: invokevirtual 157	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   398: astore 18
    //   400: getstatic 163	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   403: astore 19
    //   405: new 64	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   412: astore_1
    //   413: aload_1
    //   414: ldc 165
    //   416: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload_1
    //   421: aload 24
    //   423: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload_1
    //   428: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: astore 24
    //   433: ldc 167
    //   435: astore_1
    //   436: aload 18
    //   438: aload 19
    //   440: bipush 11
    //   442: anewarray 103	java/lang/String
    //   445: dup
    //   446: iconst_0
    //   447: ldc 169
    //   449: aastore
    //   450: dup
    //   451: iconst_1
    //   452: ldc 138
    //   454: aastore
    //   455: dup
    //   456: iconst_2
    //   457: ldc 171
    //   459: aastore
    //   460: dup
    //   461: iconst_3
    //   462: ldc 165
    //   464: aastore
    //   465: dup
    //   466: iconst_4
    //   467: ldc 173
    //   469: aastore
    //   470: dup
    //   471: iconst_5
    //   472: ldc 175
    //   474: aastore
    //   475: dup
    //   476: bipush 6
    //   478: ldc 177
    //   480: aastore
    //   481: dup
    //   482: bipush 7
    //   484: ldc 167
    //   486: aastore
    //   487: dup
    //   488: bipush 8
    //   490: ldc 179
    //   492: aastore
    //   493: dup
    //   494: bipush 9
    //   496: ldc 181
    //   498: aastore
    //   499: dup
    //   500: bipush 10
    //   502: ldc 183
    //   504: aastore
    //   505: aload 17
    //   507: aconst_null
    //   508: aload 24
    //   510: invokevirtual 189	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   513: astore 17
    //   515: aload 17
    //   517: astore 22
    //   519: goto +56 -> 575
    //   522: astore 17
    //   524: goto +16 -> 540
    //   527: astore 17
    //   529: ldc 167
    //   531: astore_1
    //   532: goto +8 -> 540
    //   535: astore 17
    //   537: ldc 167
    //   539: astore_1
    //   540: new 64	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   547: astore 18
    //   549: aload 18
    //   551: ldc 191
    //   553: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: pop
    //   557: aload 18
    //   559: aload 17
    //   561: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: ldc 41
    //   567: aload 18
    //   569: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 196	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   575: aload 22
    //   577: ifnonnull +6 -> 583
    //   580: aload 21
    //   582: areturn
    //   583: new 64	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   590: astore 17
    //   592: aload 17
    //   594: ldc 198
    //   596: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: aload 17
    //   602: aload 22
    //   604: invokeinterface 204 1 0
    //   609: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: ldc 41
    //   615: aload 17
    //   617: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 81	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 22
    //   625: invokeinterface 204 1 0
    //   630: ifne +13 -> 643
    //   633: aload 22
    //   635: invokeinterface 207 1 0
    //   640: aload 21
    //   642: areturn
    //   643: aload 21
    //   645: astore 18
    //   647: aload 20
    //   649: astore 19
    //   651: aload 23
    //   653: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   656: invokevirtual 218	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   659: aload 21
    //   661: astore 18
    //   663: aload 20
    //   665: astore 19
    //   667: aload 22
    //   669: invokeinterface 222 1 0
    //   674: pop
    //   675: aload 21
    //   677: astore 18
    //   679: aload 20
    //   681: astore 19
    //   683: aload 22
    //   685: ldc 169
    //   687: invokeinterface 226 2 0
    //   692: istore 5
    //   694: aload 21
    //   696: astore 18
    //   698: aload 20
    //   700: astore 19
    //   702: aload 22
    //   704: ldc 165
    //   706: invokeinterface 226 2 0
    //   711: istore 6
    //   713: aload 21
    //   715: astore 18
    //   717: aload 20
    //   719: astore 19
    //   721: aload 22
    //   723: ldc 173
    //   725: invokeinterface 226 2 0
    //   730: istore 7
    //   732: aload 21
    //   734: astore 18
    //   736: aload 20
    //   738: astore 19
    //   740: aload 22
    //   742: ldc 175
    //   744: invokeinterface 226 2 0
    //   749: istore 8
    //   751: aload 21
    //   753: astore 18
    //   755: aload 20
    //   757: astore 19
    //   759: aload 22
    //   761: ldc 177
    //   763: invokeinterface 226 2 0
    //   768: istore 9
    //   770: aload 21
    //   772: astore 18
    //   774: aload 20
    //   776: astore 19
    //   778: aload 22
    //   780: ldc 179
    //   782: invokeinterface 226 2 0
    //   787: istore 10
    //   789: aload 21
    //   791: astore 18
    //   793: aload 20
    //   795: astore 19
    //   797: aload 22
    //   799: aload_1
    //   800: invokeinterface 226 2 0
    //   805: istore 11
    //   807: aload 21
    //   809: astore 18
    //   811: aload 20
    //   813: astore 19
    //   815: aload 22
    //   817: ldc 181
    //   819: invokeinterface 226 2 0
    //   824: istore 12
    //   826: aload 21
    //   828: astore 18
    //   830: aload 20
    //   832: astore 19
    //   834: aload 22
    //   836: ldc 138
    //   838: invokeinterface 226 2 0
    //   843: istore 13
    //   845: aload 21
    //   847: astore 18
    //   849: aload 20
    //   851: astore 19
    //   853: aload 22
    //   855: ldc 183
    //   857: invokeinterface 226 2 0
    //   862: istore 14
    //   864: aload 21
    //   866: astore 18
    //   868: aload 20
    //   870: astore 19
    //   872: aload 22
    //   874: ldc 171
    //   876: invokeinterface 226 2 0
    //   881: istore 15
    //   883: aload 20
    //   885: astore 17
    //   887: aload 21
    //   889: astore_1
    //   890: aload_1
    //   891: astore 18
    //   893: aload 17
    //   895: astore 19
    //   897: new 31	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo
    //   900: dup
    //   901: invokespecial 227	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:<init>	()V
    //   904: astore 20
    //   906: aload 22
    //   908: iload 5
    //   910: invokeinterface 231 2 0
    //   915: istore 16
    //   917: iload 16
    //   919: i2l
    //   920: lstore_2
    //   921: aload 20
    //   923: lload_2
    //   924: putfield 234	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:a	J
    //   927: aload 20
    //   929: aload 22
    //   931: iload 6
    //   933: invokeinterface 238 2 0
    //   938: putfield 241	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:g	J
    //   941: aload 20
    //   943: aload 22
    //   945: iload 7
    //   947: invokeinterface 245 2 0
    //   952: putfield 249	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:j	D
    //   955: aload 20
    //   957: aload 22
    //   959: iload 8
    //   961: invokeinterface 245 2 0
    //   966: putfield 252	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:k	D
    //   969: aload 20
    //   971: aload 22
    //   973: iload 10
    //   975: invokeinterface 231 2 0
    //   980: putfield 38	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:e	I
    //   983: aload 20
    //   985: aload 22
    //   987: iload 11
    //   989: invokeinterface 231 2 0
    //   994: putfield 35	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:d	I
    //   997: aload 20
    //   999: aload 22
    //   1001: iload 12
    //   1003: invokeinterface 231 2 0
    //   1008: putfield 255	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:f	I
    //   1011: aload 20
    //   1013: aload 22
    //   1015: iload 13
    //   1017: invokeinterface 258 2 0
    //   1022: putfield 53	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:b	Ljava/lang/String;
    //   1025: aload 20
    //   1027: aload 22
    //   1029: iload 9
    //   1031: invokeinterface 238 2 0
    //   1036: putfield 261	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:m	J
    //   1039: aload 20
    //   1041: ldc_w 263
    //   1044: putfield 265	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:c	Ljava/lang/String;
    //   1047: aload 20
    //   1049: aload 22
    //   1051: iload 14
    //   1053: invokeinterface 258 2 0
    //   1058: putfield 268	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:n	Ljava/lang/String;
    //   1061: aload 20
    //   1063: aload 22
    //   1065: iload 15
    //   1067: invokeinterface 238 2 0
    //   1072: putfield 271	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:h	J
    //   1075: aload 20
    //   1077: aload 20
    //   1079: getfield 241	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:g	J
    //   1082: putfield 274	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:i	J
    //   1085: aload 20
    //   1087: getfield 53	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:b	Ljava/lang/String;
    //   1090: invokestatic 279	com/tencent/mobileqq/filemanager/util/FileUtil:b	(Ljava/lang/String;)Z
    //   1093: istore 4
    //   1095: iload 4
    //   1097: ifne +6 -> 1103
    //   1100: goto +32 -> 1132
    //   1103: aload_0
    //   1104: aload 20
    //   1106: invokespecial 281	com/tencent/biz/qqstory/album/ScanTask:a	(Lcom/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo;)Z
    //   1109: ifne +6 -> 1115
    //   1112: goto -12 -> 1100
    //   1115: aload 23
    //   1117: aload 20
    //   1119: invokevirtual 284	com/tencent/biz/qqstory/album/model/StoryAlbum$PicInfo:b	()Lcom/tencent/biz/qqstory/database/StoryAlbumPicEntry;
    //   1122: invokevirtual 288	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1125: aload_1
    //   1126: aload 20
    //   1128: invokevirtual 292	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1131: pop
    //   1132: aload_1
    //   1133: astore 18
    //   1135: aload 22
    //   1137: invokeinterface 295 1 0
    //   1142: ifne +32 -> 1174
    //   1145: aload 23
    //   1147: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   1150: invokevirtual 298	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   1153: aload 22
    //   1155: invokeinterface 207 1 0
    //   1160: aload 23
    //   1162: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   1165: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1168: aload 18
    //   1170: astore_1
    //   1171: goto +101 -> 1272
    //   1174: aload 18
    //   1176: astore_1
    //   1177: goto -287 -> 890
    //   1180: astore 18
    //   1182: goto +35 -> 1217
    //   1185: astore 18
    //   1187: goto +5 -> 1192
    //   1190: astore 18
    //   1192: goto +25 -> 1217
    //   1195: astore 18
    //   1197: goto +20 -> 1217
    //   1200: astore_1
    //   1201: goto +112 -> 1313
    //   1204: astore 20
    //   1206: aload 19
    //   1208: astore 17
    //   1210: aload 18
    //   1212: astore_1
    //   1213: aload 20
    //   1215: astore 18
    //   1217: new 64	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1224: astore 19
    //   1226: aload 19
    //   1228: ldc_w 303
    //   1231: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload 19
    //   1237: aload 18
    //   1239: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1242: pop
    //   1243: aload 19
    //   1245: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1248: astore 18
    //   1250: aload 17
    //   1252: aload 18
    //   1254: invokestatic 196	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: aload 22
    //   1259: invokeinterface 207 1 0
    //   1264: aload 23
    //   1266: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   1269: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1272: new 64	java/lang/StringBuilder
    //   1275: dup
    //   1276: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1279: astore 18
    //   1281: aload 18
    //   1283: ldc_w 305
    //   1286: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: pop
    //   1290: aload 18
    //   1292: aload_1
    //   1293: invokevirtual 308	java/util/ArrayList:size	()I
    //   1296: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload 17
    //   1302: aload 18
    //   1304: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1307: invokestatic 81	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1310: aload_1
    //   1311: areturn
    //   1312: astore_1
    //   1313: aload 22
    //   1315: invokeinterface 207 1 0
    //   1320: aload 23
    //   1322: invokevirtual 213	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   1325: invokevirtual 301	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   1328: goto +5 -> 1333
    //   1331: aload_1
    //   1332: athrow
    //   1333: goto -2 -> 1331
    //   1336: astore 17
    //   1338: ldc 167
    //   1340: astore_1
    //   1341: goto -801 -> 540
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1344	0	this	ScanTask
    //   0	1344	1	paramContext	Context
    //   0	1344	2	paramLong	long
    //   0	1344	4	paramBoolean	boolean
    //   0	1344	5	paramInt	int
    //   72	860	6	i	int
    //   69	877	7	j	int
    //   749	211	8	k	int
    //   768	262	9	m	int
    //   787	187	10	n	int
    //   805	183	11	i1	int
    //   824	178	12	i2	int
    //   843	173	13	i3	int
    //   862	190	14	i4	int
    //   881	185	15	i5	int
    //   915	3	16	i6	int
    //   7	509	17	localObject1	Object
    //   522	1	17	localException1	java.lang.Exception
    //   527	1	17	localException2	java.lang.Exception
    //   535	25	17	localException3	java.lang.Exception
    //   590	711	17	localObject2	Object
    //   1336	1	17	localException4	java.lang.Exception
    //   55	1120	18	localObject3	Object
    //   1180	1	18	localException5	java.lang.Exception
    //   1185	1	18	localException6	java.lang.Exception
    //   1190	1	18	localException7	java.lang.Exception
    //   1195	16	18	localException8	java.lang.Exception
    //   1215	88	18	localObject4	Object
    //   51	1193	19	localObject5	Object
    //   33	1094	20	localObject6	Object
    //   1204	10	20	localException9	java.lang.Exception
    //   170	718	21	localArrayList	java.util.ArrayList
    //   324	990	22	localObject7	Object
    //   181	1140	23	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   361	148	24	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   436	515	522	java/lang/Exception
    //   405	433	527	java/lang/Exception
    //   340	356	535	java/lang/Exception
    //   356	363	535	java/lang/Exception
    //   366	391	535	java/lang/Exception
    //   394	405	535	java/lang/Exception
    //   1125	1132	1180	java/lang/Exception
    //   1135	1153	1180	java/lang/Exception
    //   1103	1112	1185	java/lang/Exception
    //   1115	1125	1185	java/lang/Exception
    //   921	1095	1190	java/lang/Exception
    //   906	917	1195	java/lang/Exception
    //   651	659	1200	finally
    //   667	675	1200	finally
    //   683	694	1200	finally
    //   702	713	1200	finally
    //   721	732	1200	finally
    //   740	751	1200	finally
    //   759	770	1200	finally
    //   778	789	1200	finally
    //   797	807	1200	finally
    //   815	826	1200	finally
    //   834	845	1200	finally
    //   853	864	1200	finally
    //   872	883	1200	finally
    //   897	906	1200	finally
    //   906	917	1200	finally
    //   921	1095	1200	finally
    //   651	659	1204	java/lang/Exception
    //   667	675	1204	java/lang/Exception
    //   683	694	1204	java/lang/Exception
    //   702	713	1204	java/lang/Exception
    //   721	732	1204	java/lang/Exception
    //   740	751	1204	java/lang/Exception
    //   759	770	1204	java/lang/Exception
    //   778	789	1204	java/lang/Exception
    //   797	807	1204	java/lang/Exception
    //   815	826	1204	java/lang/Exception
    //   834	845	1204	java/lang/Exception
    //   853	864	1204	java/lang/Exception
    //   872	883	1204	java/lang/Exception
    //   897	906	1204	java/lang/Exception
    //   1103	1112	1312	finally
    //   1115	1125	1312	finally
    //   1125	1132	1312	finally
    //   1135	1153	1312	finally
    //   1217	1250	1312	finally
    //   1250	1257	1312	finally
    //   331	340	1336	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.ScanTask
 * JD-Core Version:    0.7.0.1
 */