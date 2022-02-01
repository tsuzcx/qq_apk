package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import aptw;
import arid;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Setting;
import java.io.File;
import mqq.os.MqqHandler;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static final String QQ_HEAD_DH = "Q.qqhead.QQHeadDownloadHandler";
  private static final int[] TROOPS_SYSTEM_HEADS = { 2130840537, 2130850623, 2130850624, 2130850625 };
  private static Object syncCopyQQHeadLock = new Object();
  private QQAppInterface app;
  private FriendListHandler friendHandler;
  private MqqHandler mSubhandler = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  public QQHeadDownloadHandler(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
    this.friendHandler = paramFriendListHandler;
  }
  
  public static void clearIpList() {}
  
  private void notifyDownloadHeadComplete(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if ((paramBoolean2) || (!paramBoolean1))
    {
      if (paramQQHeadInfo.dstUsrType == 11) {
        this.friendHandler.notifyUI(39, true, new Object[] { paramString1 });
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 4)
    {
      this.friendHandler.notifyUI(30, true, new Object[] { paramString1 });
      this.app.sendQQHeadBroadcast(4, paramString1, 0, paramString2);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.friendHandler.notifyUI(5, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      this.friendHandler.notifyUI(104, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), paramString3 });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.friendHandler.notifyUI(6, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 116)
    {
      this.friendHandler.notifyUI(135, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.sizeType), Boolean.valueOf(true) });
      return;
    }
    this.app.sendQQHeadBroadcast(1, paramString1, 0, paramString2);
    if (paramString1.equals(this.app.getCurrentAccountUin())) {
      this.app.sendSelfQQHeadBroadcast(1, paramString1, 0, paramString2);
    }
    this.friendHandler.notifyUI(4, true, new Object[] { paramString1 });
  }
  
  private void removeCache(QQHeadInfo paramQQHeadInfo, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramQQHeadInfo.dstUsrType == 4) {
        this.app.removeFaceIconCache(4, paramString, paramQQHeadInfo.idType);
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.app.removeFaceIconCache(32, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.app.removeFaceIconCache(16, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 116)
    {
      this.app.removeFaceIconCacheApollo(116, paramString, paramQQHeadInfo.sizeType);
      return;
    }
    this.app.removeFaceIconCache(1, paramString, paramQQHeadInfo.idType);
  }
  
  private void removeFileCache(QQHeadInfo paramQQHeadInfo, String paramString)
  {
    if (paramQQHeadInfo.dstUsrType == 116) {
      arid.a(this.app, paramQQHeadInfo.dstUsrType, paramString);
    }
  }
  
  private int setResultCodeByErrorCode(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 9207;
    case 1: 
      return 9206;
    case 4: 
      return 9202;
    case 33: 
      return 9208;
    }
    return 9204;
  }
  
  /* Error */
  private void writeTroopSystemHead(int paramInt, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: iload_1
    //   7: iflt +13 -> 20
    //   10: iload_1
    //   11: istore_3
    //   12: iload_1
    //   13: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:TROOPS_SYSTEM_HEADS	[I
    //   16: arraylength
    //   17: if_icmplt +5 -> 22
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   26: invokevirtual 138	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 144	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:TROOPS_SYSTEM_HEADS	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 150	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 152	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 161	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 165	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 8
    //   95: iconst_2
    //   96: ldc 173
    //   98: aload 5
    //   100: invokestatic 177	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 181	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 181	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 181	java/io/InputStream:close	()V
    //   165: aload_2
    //   166: athrow
    //   167: astore_2
    //   168: goto -23 -> 145
    //   171: astore 6
    //   173: aload_2
    //   174: astore 5
    //   176: aload 6
    //   178: astore_2
    //   179: goto -34 -> 145
    //   182: astore 6
    //   184: aload_2
    //   185: astore 5
    //   187: aload 6
    //   189: astore_2
    //   190: goto -45 -> 145
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -110 -> 87
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_2
    //   204: goto -117 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	QQHeadDownloadHandler
    //   0	207	1	paramInt	int
    //   0	207	2	paramFile	File
    //   11	25	3	i	int
    //   4	157	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   85	66	5	localException1	java.lang.Exception
    //   174	12	5	localFile	File
    //   193	1	5	localException2	java.lang.Exception
    //   200	1	5	localException3	java.lang.Exception
    //   40	36	6	localObject3	Object
    //   171	6	6	localObject4	Object
    //   182	6	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	85	java/lang/Exception
    //   74	82	85	java/lang/Exception
    //   22	42	141	finally
    //   46	62	167	finally
    //   62	70	171	finally
    //   74	82	171	finally
    //   87	103	182	finally
    //   22	42	193	java/lang/Exception
    //   46	62	200	java/lang/Exception
  }
  
  /* Error */
  protected void doDownloadFace(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 190	com/tencent/mobileqq/app/face/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   4: astore 35
    //   6: aload_0
    //   7: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:friendHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   10: aload 35
    //   12: getfield 194	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 35
    //   17: getfield 197	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 201	com/tencent/mobileqq/app/FriendListHandler:getUinOrMobile	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 36
    //   25: aload_0
    //   26: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:friendHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   29: iconst_0
    //   30: aload 36
    //   32: aload 35
    //   34: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 205	com/tencent/mobileqq/app/FriendListHandler:statGetQQHeadCostTime	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 208	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   45: invokevirtual 211	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   48: iconst_0
    //   49: istore 27
    //   51: iconst_0
    //   52: istore 28
    //   54: iconst_0
    //   55: istore 29
    //   57: iconst_0
    //   58: istore 26
    //   60: iconst_0
    //   61: istore 5
    //   63: iconst_0
    //   64: istore 11
    //   66: iconst_0
    //   67: istore 6
    //   69: iconst_0
    //   70: istore 17
    //   72: iconst_0
    //   73: istore 18
    //   75: iconst_0
    //   76: istore 12
    //   78: aload 35
    //   80: getfield 214	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   83: astore 32
    //   85: iconst_0
    //   86: istore 21
    //   88: iconst_0
    //   89: istore 14
    //   91: iconst_0
    //   92: istore 13
    //   94: iconst_0
    //   95: istore 15
    //   97: iconst_0
    //   98: istore 9
    //   100: iconst_0
    //   101: istore 16
    //   103: iconst_0
    //   104: istore 8
    //   106: iconst_0
    //   107: istore 4
    //   109: iconst_0
    //   110: istore 19
    //   112: iconst_0
    //   113: istore 20
    //   115: iconst_0
    //   116: istore_2
    //   117: iload 14
    //   119: istore 10
    //   121: iload 29
    //   123: istore 24
    //   125: iload 18
    //   127: istore 7
    //   129: aload 32
    //   131: astore 30
    //   133: iload 20
    //   135: istore_3
    //   136: aload 35
    //   138: getfield 214	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   141: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +2378 -> 2522
    //   147: iload 14
    //   149: istore 10
    //   151: iload 29
    //   153: istore 24
    //   155: iload 18
    //   157: istore 7
    //   159: aload 32
    //   161: astore 30
    //   163: iload 20
    //   165: istore_3
    //   166: aload_0
    //   167: aload 35
    //   169: aload 36
    //   171: aload 35
    //   173: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   176: aload 36
    //   178: aload 35
    //   180: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   183: invokestatic 224	com/tencent/mobileqq/app/QQAppInterface:getFaceSettingKey	(ILjava/lang/String;I)Ljava/lang/String;
    //   186: iconst_0
    //   187: invokevirtual 228	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getFaceSetting	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/Object;
    //   190: astore 31
    //   192: iload 14
    //   194: istore 10
    //   196: iload 29
    //   198: istore 24
    //   200: iload 18
    //   202: istore 7
    //   204: aload 32
    //   206: astore 30
    //   208: iload 20
    //   210: istore_3
    //   211: aload 31
    //   213: iconst_0
    //   214: aaload
    //   215: checkcast 92	java/lang/Boolean
    //   218: invokevirtual 231	java/lang/Boolean:booleanValue	()Z
    //   221: istore 23
    //   223: iload 14
    //   225: istore 10
    //   227: iload 29
    //   229: istore 24
    //   231: iload 18
    //   233: istore 7
    //   235: aload 32
    //   237: astore 30
    //   239: iload 20
    //   241: istore_3
    //   242: aload 31
    //   244: iconst_1
    //   245: aaload
    //   246: checkcast 233	com/tencent/mobileqq/data/Setting
    //   249: astore 37
    //   251: iload 23
    //   253: ifeq +30 -> 283
    //   256: iload 14
    //   258: istore 10
    //   260: iload 29
    //   262: istore 24
    //   264: iload 18
    //   266: istore 7
    //   268: aload 32
    //   270: astore 30
    //   272: iload 20
    //   274: istore_3
    //   275: aload_0
    //   276: aload 35
    //   278: aload 36
    //   280: invokespecial 235	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeFileCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;)V
    //   283: iload 14
    //   285: istore 10
    //   287: iload 29
    //   289: istore 24
    //   291: iload 18
    //   293: istore 7
    //   295: aload 32
    //   297: astore 30
    //   299: iload 20
    //   301: istore_3
    //   302: aload_0
    //   303: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   306: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   309: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   312: invokestatic 250	bful:a	(Landroid/content/Context;)Z
    //   315: ifeq +128 -> 443
    //   318: iload 14
    //   320: istore 10
    //   322: iload 29
    //   324: istore 24
    //   326: iload 18
    //   328: istore 7
    //   330: aload 32
    //   332: astore 30
    //   334: iload 20
    //   336: istore_3
    //   337: invokestatic 255	com/tencent/mobileqq/util/SystemUtil:isExistSDCard	()Z
    //   340: ifeq +103 -> 443
    //   343: iload 14
    //   345: istore 10
    //   347: iload 29
    //   349: istore 24
    //   351: iload 18
    //   353: istore 7
    //   355: aload 32
    //   357: astore 30
    //   359: iload 20
    //   361: istore_3
    //   362: getstatic 33	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:syncCopyQQHeadLock	Ljava/lang/Object;
    //   365: astore 31
    //   367: iload 14
    //   369: istore 10
    //   371: iload 29
    //   373: istore 24
    //   375: iload 18
    //   377: istore 7
    //   379: aload 32
    //   381: astore 30
    //   383: iload 20
    //   385: istore_3
    //   386: aload 31
    //   388: monitorenter
    //   389: aload_0
    //   390: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   393: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   396: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   399: invokestatic 250	bful:a	(Landroid/content/Context;)Z
    //   402: ifeq +24 -> 426
    //   405: invokestatic 255	com/tencent/mobileqq/util/SystemUtil:isExistSDCard	()Z
    //   408: istore 22
    //   410: iload 22
    //   412: ifeq +14 -> 426
    //   415: ldc_w 257
    //   418: getstatic 262	com/tencent/mobileqq/app/AppConstants:PATH_CUSTOM_HEAD_ROOT_SDCARD	Ljava/lang/String;
    //   421: iconst_1
    //   422: invokestatic 268	com/tencent/mobileqq/utils/FileUtils:copyDirectory	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   425: pop
    //   426: aload_0
    //   427: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   430: invokevirtual 239	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   433: invokevirtual 245	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   436: iconst_0
    //   437: invokestatic 271	bful:a	(Landroid/content/Context;Z)V
    //   440: aload 31
    //   442: monitorexit
    //   443: iload 14
    //   445: istore 10
    //   447: iload 29
    //   449: istore 24
    //   451: iload 18
    //   453: istore 7
    //   455: aload 32
    //   457: astore 30
    //   459: iload 20
    //   461: istore_3
    //   462: aload_0
    //   463: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   466: aload 37
    //   468: aload 35
    //   470: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   473: aload 35
    //   475: getfield 98	AvatarInfo/QQHeadInfo:sizeType	I
    //   478: invokevirtual 275	com/tencent/mobileqq/app/QQAppInterface:getCustomFaceFilePathBySetting	(Lcom/tencent/mobileqq/data/Setting;II)Ljava/lang/String;
    //   481: astore 33
    //   483: iload 14
    //   485: istore 10
    //   487: iload 29
    //   489: istore 24
    //   491: iload 18
    //   493: istore 7
    //   495: aload 32
    //   497: astore 30
    //   499: iload 20
    //   501: istore_3
    //   502: new 277	java/io/File
    //   505: dup
    //   506: aload 33
    //   508: iconst_0
    //   509: aload 33
    //   511: ldc_w 279
    //   514: invokevirtual 283	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   517: invokevirtual 287	java/lang/String:substring	(II)Ljava/lang/String;
    //   520: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   523: astore 31
    //   525: aload 31
    //   527: ifnull +55 -> 582
    //   530: iload 14
    //   532: istore 10
    //   534: iload 29
    //   536: istore 24
    //   538: iload 18
    //   540: istore 7
    //   542: aload 32
    //   544: astore 30
    //   546: iload 20
    //   548: istore_3
    //   549: aload 31
    //   551: invokevirtual 293	java/io/File:exists	()Z
    //   554: ifne +28 -> 582
    //   557: iload 14
    //   559: istore 10
    //   561: iload 29
    //   563: istore 24
    //   565: iload 18
    //   567: istore 7
    //   569: aload 32
    //   571: astore 30
    //   573: iload 20
    //   575: istore_3
    //   576: aload 31
    //   578: invokevirtual 296	java/io/File:mkdirs	()Z
    //   581: pop
    //   582: iload 14
    //   584: istore 10
    //   586: iload 29
    //   588: istore 24
    //   590: iload 18
    //   592: istore 7
    //   594: aload 32
    //   596: astore 30
    //   598: iload 20
    //   600: istore_3
    //   601: new 277	java/io/File
    //   604: dup
    //   605: aload 33
    //   607: invokespecial 290	java/io/File:<init>	(Ljava/lang/String;)V
    //   610: astore 38
    //   612: iload 23
    //   614: istore 22
    //   616: iload 23
    //   618: ifne +37 -> 655
    //   621: iload 14
    //   623: istore 10
    //   625: iload 29
    //   627: istore 24
    //   629: iload 18
    //   631: istore 7
    //   633: aload 32
    //   635: astore 30
    //   637: iload 20
    //   639: istore_3
    //   640: aload 38
    //   642: invokevirtual 293	java/io/File:exists	()Z
    //   645: istore 22
    //   647: iload 22
    //   649: ifne +897 -> 1546
    //   652: iconst_1
    //   653: istore 22
    //   655: iload 22
    //   657: ifeq +1519 -> 2176
    //   660: iload 15
    //   662: istore 11
    //   664: iload 28
    //   666: istore 25
    //   668: iload 17
    //   670: istore 8
    //   672: aload 32
    //   674: astore 31
    //   676: iload 19
    //   678: istore 4
    //   680: iload 14
    //   682: istore 10
    //   684: iload 29
    //   686: istore 24
    //   688: iload 18
    //   690: istore 7
    //   692: aload 32
    //   694: astore 30
    //   696: iload 20
    //   698: istore_3
    //   699: aload_0
    //   700: aload_1
    //   701: iconst_0
    //   702: invokevirtual 300	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   705: astore 34
    //   707: iload 15
    //   709: istore 11
    //   711: iload 28
    //   713: istore 25
    //   715: iload 17
    //   717: istore 8
    //   719: aload 34
    //   721: astore 31
    //   723: iload 19
    //   725: istore 4
    //   727: iload 14
    //   729: istore 10
    //   731: iload 29
    //   733: istore 24
    //   735: iload 18
    //   737: istore 7
    //   739: aload 34
    //   741: astore 30
    //   743: iload 20
    //   745: istore_3
    //   746: aload 35
    //   748: getfield 303	AvatarInfo/QQHeadInfo:cHeadType	B
    //   751: ifne +903 -> 1654
    //   754: iload 15
    //   756: istore 11
    //   758: iload 28
    //   760: istore 25
    //   762: iload 17
    //   764: istore 8
    //   766: aload 34
    //   768: astore 31
    //   770: iload 19
    //   772: istore 4
    //   774: iload 14
    //   776: istore 10
    //   778: iload 29
    //   780: istore 24
    //   782: iload 18
    //   784: istore 7
    //   786: aload 34
    //   788: astore 30
    //   790: iload 20
    //   792: istore_3
    //   793: aload 35
    //   795: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   798: istore 5
    //   800: iload 5
    //   802: iconst_4
    //   803: if_icmpne +851 -> 1654
    //   806: iload 15
    //   808: istore 11
    //   810: iload 28
    //   812: istore 25
    //   814: iload 17
    //   816: istore 8
    //   818: aload 34
    //   820: astore 31
    //   822: iload 19
    //   824: istore 4
    //   826: iload 14
    //   828: istore 10
    //   830: iload 29
    //   832: istore 24
    //   834: iload 18
    //   836: istore 7
    //   838: aload 34
    //   840: astore 30
    //   842: iload 20
    //   844: istore_3
    //   845: aload 38
    //   847: invokevirtual 293	java/io/File:exists	()Z
    //   850: ifne +53 -> 903
    //   853: iload 15
    //   855: istore 11
    //   857: iload 28
    //   859: istore 25
    //   861: iload 17
    //   863: istore 8
    //   865: aload 34
    //   867: astore 31
    //   869: iload 19
    //   871: istore 4
    //   873: iload 14
    //   875: istore 10
    //   877: iload 29
    //   879: istore 24
    //   881: iload 18
    //   883: istore 7
    //   885: aload 34
    //   887: astore 30
    //   889: iload 20
    //   891: istore_3
    //   892: aload_0
    //   893: aload 35
    //   895: getfield 307	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   898: aload 38
    //   900: invokespecial 309	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:writeTroopSystemHead	(ILjava/io/File;)V
    //   903: iconst_1
    //   904: istore 23
    //   906: aload 34
    //   908: astore 32
    //   910: iload 12
    //   912: istore 5
    //   914: iload 13
    //   916: istore 6
    //   918: iload 9
    //   920: istore 11
    //   922: iload 23
    //   924: istore 25
    //   926: iload 5
    //   928: istore 8
    //   930: aload 32
    //   932: astore 31
    //   934: iload_2
    //   935: istore 4
    //   937: iload 6
    //   939: istore 10
    //   941: iload 23
    //   943: istore 24
    //   945: iload 5
    //   947: istore 7
    //   949: aload 32
    //   951: astore 30
    //   953: iload_2
    //   954: istore_3
    //   955: aload_0
    //   956: aload 35
    //   958: aload 36
    //   960: iload 23
    //   962: invokespecial 311	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Z)V
    //   965: iload 9
    //   967: istore 4
    //   969: iload 6
    //   971: istore_3
    //   972: aload 32
    //   974: astore 30
    //   976: aload_0
    //   977: aload 35
    //   979: aload 36
    //   981: aload 33
    //   983: iload 22
    //   985: iload 23
    //   987: aload 30
    //   989: invokespecial 313	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:notifyDownloadHeadComplete	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    //   992: iload 4
    //   994: istore 6
    //   996: iload_3
    //   997: istore 4
    //   999: aload 30
    //   1001: astore 32
    //   1003: iload 23
    //   1005: istore 24
    //   1007: aload 33
    //   1009: astore 30
    //   1011: iload 22
    //   1013: istore 23
    //   1015: iload 24
    //   1017: istore 22
    //   1019: iload 6
    //   1021: istore_3
    //   1022: iload_2
    //   1023: istore 6
    //   1025: iload 4
    //   1027: istore_2
    //   1028: new 315	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1031: dup
    //   1032: aload_0
    //   1033: iload_2
    //   1034: aload 36
    //   1036: aload 35
    //   1038: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   1041: aload 35
    //   1043: getfield 98	AvatarInfo/QQHeadInfo:sizeType	I
    //   1046: aload 35
    //   1048: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1051: iconst_4
    //   1052: iload 5
    //   1054: aload 32
    //   1056: iload 6
    //   1058: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   1061: invokespecial 324	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1064: aconst_null
    //   1065: iconst_0
    //   1066: invokestatic 328	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1069: aload_0
    //   1070: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1073: sipush 199
    //   1076: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1079: checkcast 334	anwp
    //   1082: astore 31
    //   1084: iload_2
    //   1085: istore 4
    //   1087: aload 32
    //   1089: astore 33
    //   1091: iload_3
    //   1092: istore 5
    //   1094: iload 22
    //   1096: istore 24
    //   1098: iload 23
    //   1100: istore 25
    //   1102: aload 30
    //   1104: astore 34
    //   1106: iload 22
    //   1108: ifne +95 -> 1203
    //   1111: iload_2
    //   1112: istore 4
    //   1114: aload 32
    //   1116: astore 33
    //   1118: iload_3
    //   1119: istore 5
    //   1121: iload 22
    //   1123: istore 24
    //   1125: iload 23
    //   1127: istore 25
    //   1129: aload 30
    //   1131: astore 34
    //   1133: aload 31
    //   1135: ifnull +68 -> 1203
    //   1138: iload_2
    //   1139: istore 4
    //   1141: aload 32
    //   1143: astore 33
    //   1145: iload_3
    //   1146: istore 5
    //   1148: iload 22
    //   1150: istore 24
    //   1152: iload 23
    //   1154: istore 25
    //   1156: aload 30
    //   1158: astore 34
    //   1160: aload 31
    //   1162: invokevirtual 336	anwp:a	()Z
    //   1165: ifeq +38 -> 1203
    //   1168: aload 31
    //   1170: aload 35
    //   1172: getfield 194	AvatarInfo/QQHeadInfo:uin	J
    //   1175: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1178: invokevirtual 341	anwp:a	(Ljava/lang/String;)V
    //   1181: aload 30
    //   1183: astore 34
    //   1185: iload 23
    //   1187: istore 25
    //   1189: iload 22
    //   1191: istore 24
    //   1193: iload_3
    //   1194: istore 5
    //   1196: aload 32
    //   1198: astore 33
    //   1200: iload_2
    //   1201: istore 4
    //   1203: ldc 8
    //   1205: iconst_2
    //   1206: new 343	java/lang/StringBuilder
    //   1209: dup
    //   1210: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   1213: ldc_w 346
    //   1216: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1219: iload 24
    //   1221: invokevirtual 353	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1224: ldc_w 355
    //   1227: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: iload 4
    //   1232: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1235: ldc_w 360
    //   1238: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: iload 25
    //   1243: invokevirtual 353	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1246: ldc_w 362
    //   1249: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: iload 5
    //   1254: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1257: ldc_w 364
    //   1260: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload_1
    //   1264: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1267: ldc_w 369
    //   1270: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload 35
    //   1275: invokevirtual 367	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 371
    //   1281: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: aload 34
    //   1286: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: ldc_w 373
    //   1292: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: aload 33
    //   1297: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1306: return
    //   1307: astore 30
    //   1309: aload 30
    //   1311: invokevirtual 383	java/lang/Exception:printStackTrace	()V
    //   1314: goto -888 -> 426
    //   1317: astore 33
    //   1319: aload 31
    //   1321: monitorexit
    //   1322: iload 14
    //   1324: istore 10
    //   1326: iload 29
    //   1328: istore 24
    //   1330: iload 18
    //   1332: istore 7
    //   1334: aload 32
    //   1336: astore 30
    //   1338: iload 20
    //   1340: istore_3
    //   1341: aload 33
    //   1343: athrow
    //   1344: astore 30
    //   1346: iconst_0
    //   1347: istore_2
    //   1348: iconst_0
    //   1349: istore 22
    //   1351: aconst_null
    //   1352: astore 30
    //   1354: aload 32
    //   1356: astore 31
    //   1358: iload 6
    //   1360: istore 5
    //   1362: sipush 9204
    //   1365: istore_3
    //   1366: new 315	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1369: dup
    //   1370: aload_0
    //   1371: sipush 9204
    //   1374: aload 36
    //   1376: aload 35
    //   1378: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   1381: aload 35
    //   1383: getfield 98	AvatarInfo/QQHeadInfo:sizeType	I
    //   1386: aload 35
    //   1388: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1391: iconst_4
    //   1392: iload 5
    //   1394: aload 31
    //   1396: iload 4
    //   1398: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   1401: invokespecial 324	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1404: aconst_null
    //   1405: iconst_0
    //   1406: invokestatic 328	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1409: aload_0
    //   1410: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1413: sipush 199
    //   1416: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1419: checkcast 334	anwp
    //   1422: astore 32
    //   1424: iload_3
    //   1425: istore 4
    //   1427: aload 31
    //   1429: astore 33
    //   1431: iload_2
    //   1432: istore 5
    //   1434: iload 22
    //   1436: istore 24
    //   1438: iload 23
    //   1440: istore 25
    //   1442: aload 30
    //   1444: astore 34
    //   1446: iload 22
    //   1448: ifne -245 -> 1203
    //   1451: iload_3
    //   1452: istore 4
    //   1454: aload 31
    //   1456: astore 33
    //   1458: iload_2
    //   1459: istore 5
    //   1461: iload 22
    //   1463: istore 24
    //   1465: iload 23
    //   1467: istore 25
    //   1469: aload 30
    //   1471: astore 34
    //   1473: aload 32
    //   1475: ifnull -272 -> 1203
    //   1478: iload_3
    //   1479: istore 4
    //   1481: aload 31
    //   1483: astore 33
    //   1485: iload_2
    //   1486: istore 5
    //   1488: iload 22
    //   1490: istore 24
    //   1492: iload 23
    //   1494: istore 25
    //   1496: aload 30
    //   1498: astore 34
    //   1500: aload 32
    //   1502: invokevirtual 336	anwp:a	()Z
    //   1505: ifeq -302 -> 1203
    //   1508: aload 32
    //   1510: aload 35
    //   1512: getfield 194	AvatarInfo/QQHeadInfo:uin	J
    //   1515: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1518: invokevirtual 341	anwp:a	(Ljava/lang/String;)V
    //   1521: iload_3
    //   1522: istore 4
    //   1524: aload 31
    //   1526: astore 33
    //   1528: iload_2
    //   1529: istore 5
    //   1531: iload 22
    //   1533: istore 24
    //   1535: iload 23
    //   1537: istore 25
    //   1539: aload 30
    //   1541: astore 34
    //   1543: goto -340 -> 1203
    //   1546: iconst_0
    //   1547: istore 22
    //   1549: goto -894 -> 655
    //   1552: astore_1
    //   1553: new 315	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1556: dup
    //   1557: aload_0
    //   1558: sipush 9202
    //   1561: aload 36
    //   1563: aload 35
    //   1565: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   1568: aload 35
    //   1570: getfield 98	AvatarInfo/QQHeadInfo:sizeType	I
    //   1573: aload 35
    //   1575: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1578: iconst_4
    //   1579: iconst_0
    //   1580: aload 32
    //   1582: iconst_0
    //   1583: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   1586: invokespecial 324	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1589: aconst_null
    //   1590: iconst_0
    //   1591: invokestatic 328	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1594: aload_0
    //   1595: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1598: sipush 199
    //   1601: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1604: checkcast 334	anwp
    //   1607: astore_1
    //   1608: aload_1
    //   1609: ifnull -303 -> 1306
    //   1612: aload_1
    //   1613: invokevirtual 336	anwp:a	()Z
    //   1616: ifeq -310 -> 1306
    //   1619: aload_1
    //   1620: aload 35
    //   1622: getfield 194	AvatarInfo/QQHeadInfo:uin	J
    //   1625: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1628: invokevirtual 341	anwp:a	(Ljava/lang/String;)V
    //   1631: return
    //   1632: astore 30
    //   1634: sipush 9202
    //   1637: istore 6
    //   1639: iload 26
    //   1641: istore 23
    //   1643: iload 12
    //   1645: istore 5
    //   1647: aload 34
    //   1649: astore 32
    //   1651: goto -733 -> 918
    //   1654: iload 15
    //   1656: istore 11
    //   1658: iload 28
    //   1660: istore 25
    //   1662: iload 17
    //   1664: istore 8
    //   1666: aload 34
    //   1668: astore 31
    //   1670: iload 19
    //   1672: istore 4
    //   1674: iload 14
    //   1676: istore 10
    //   1678: iload 29
    //   1680: istore 24
    //   1682: iload 18
    //   1684: istore 7
    //   1686: aload 34
    //   1688: astore 30
    //   1690: iload 20
    //   1692: istore_3
    //   1693: aload_0
    //   1694: aload 34
    //   1696: aload 38
    //   1698: aload_1
    //   1699: iconst_0
    //   1700: invokevirtual 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1703: istore 5
    //   1705: aload 34
    //   1707: astore 32
    //   1709: iload 5
    //   1711: istore_2
    //   1712: iload 5
    //   1714: ifeq +228 -> 1942
    //   1717: aload 34
    //   1719: astore 32
    //   1721: iload 5
    //   1723: istore_2
    //   1724: iload 15
    //   1726: istore 11
    //   1728: iload 28
    //   1730: istore 25
    //   1732: iload 17
    //   1734: istore 8
    //   1736: aload 34
    //   1738: astore 31
    //   1740: iload 5
    //   1742: istore 4
    //   1744: iload 14
    //   1746: istore 10
    //   1748: iload 29
    //   1750: istore 24
    //   1752: iload 18
    //   1754: istore 7
    //   1756: aload 34
    //   1758: astore 30
    //   1760: iload 5
    //   1762: istore_3
    //   1763: iconst_1
    //   1764: invokestatic 393	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   1767: iconst_3
    //   1768: if_icmpne +174 -> 1942
    //   1771: iload 15
    //   1773: istore 11
    //   1775: iload 28
    //   1777: istore 25
    //   1779: iload 17
    //   1781: istore 8
    //   1783: aload 34
    //   1785: astore 31
    //   1787: iload 5
    //   1789: istore 4
    //   1791: iload 14
    //   1793: istore 10
    //   1795: iload 29
    //   1797: istore 24
    //   1799: iload 18
    //   1801: istore 7
    //   1803: aload 34
    //   1805: astore 30
    //   1807: iload 5
    //   1809: istore_3
    //   1810: aload_0
    //   1811: aload_1
    //   1812: iconst_1
    //   1813: invokevirtual 300	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   1816: astore 32
    //   1818: iload 15
    //   1820: istore 11
    //   1822: iload 28
    //   1824: istore 25
    //   1826: iload 17
    //   1828: istore 8
    //   1830: aload 32
    //   1832: astore 31
    //   1834: iload 5
    //   1836: istore 4
    //   1838: iload 14
    //   1840: istore 10
    //   1842: iload 29
    //   1844: istore 24
    //   1846: iload 18
    //   1848: istore 7
    //   1850: aload 32
    //   1852: astore 30
    //   1854: iload 5
    //   1856: istore_3
    //   1857: aload_0
    //   1858: aload 32
    //   1860: aload 38
    //   1862: aload_1
    //   1863: iconst_0
    //   1864: invokevirtual 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1867: istore_2
    //   1868: iload 15
    //   1870: istore 11
    //   1872: iload 28
    //   1874: istore 25
    //   1876: iload 17
    //   1878: istore 8
    //   1880: aload 32
    //   1882: astore 31
    //   1884: iload_2
    //   1885: istore 4
    //   1887: iload 14
    //   1889: istore 10
    //   1891: iload 29
    //   1893: istore 24
    //   1895: iload 18
    //   1897: istore 7
    //   1899: aload 32
    //   1901: astore 30
    //   1903: iload_2
    //   1904: istore_3
    //   1905: ldc 8
    //   1907: iconst_1
    //   1908: new 343	java/lang/StringBuilder
    //   1911: dup
    //   1912: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   1915: ldc_w 395
    //   1918: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: aload 32
    //   1923: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1926: ldc_w 397
    //   1929: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: iload_2
    //   1933: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: invokestatic 380	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1942: iload_2
    //   1943: ifne +190 -> 2133
    //   1946: iload 15
    //   1948: istore 11
    //   1950: iload 28
    //   1952: istore 25
    //   1954: iload 17
    //   1956: istore 8
    //   1958: aload 32
    //   1960: astore 31
    //   1962: iload_2
    //   1963: istore 4
    //   1965: iload 14
    //   1967: istore 10
    //   1969: iload 29
    //   1971: istore 24
    //   1973: iload 18
    //   1975: istore 7
    //   1977: aload 32
    //   1979: astore 30
    //   1981: iload_2
    //   1982: istore_3
    //   1983: aload 38
    //   1985: invokevirtual 400	java/io/File:length	()J
    //   1988: l2i
    //   1989: istore 5
    //   1991: iconst_1
    //   1992: istore 26
    //   1994: iconst_1
    //   1995: istore 27
    //   1997: iconst_1
    //   1998: istore 23
    //   2000: iload 15
    //   2002: istore 11
    //   2004: iload 26
    //   2006: istore 25
    //   2008: iload 5
    //   2010: istore 8
    //   2012: aload 32
    //   2014: astore 31
    //   2016: iload_2
    //   2017: istore 4
    //   2019: iload 14
    //   2021: istore 10
    //   2023: iload 27
    //   2025: istore 24
    //   2027: iload 5
    //   2029: istore 7
    //   2031: aload 32
    //   2033: astore 30
    //   2035: iload_2
    //   2036: istore_3
    //   2037: aload_0
    //   2038: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2041: aload 37
    //   2043: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:updateSettingTableCache	(Lcom/tencent/mobileqq/data/Setting;)V
    //   2046: iload 15
    //   2048: istore 11
    //   2050: iload 26
    //   2052: istore 25
    //   2054: iload 5
    //   2056: istore 8
    //   2058: aload 32
    //   2060: astore 31
    //   2062: iload_2
    //   2063: istore 4
    //   2065: iload 14
    //   2067: istore 10
    //   2069: iload 27
    //   2071: istore 24
    //   2073: iload 5
    //   2075: istore 7
    //   2077: aload 32
    //   2079: astore 30
    //   2081: iload_2
    //   2082: istore_3
    //   2083: aload_0
    //   2084: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   2087: new 406	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2090: dup
    //   2091: aload_0
    //   2092: aload 37
    //   2094: aload_1
    //   2095: invokespecial 409	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   2098: invokevirtual 413	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2101: pop
    //   2102: iload 13
    //   2104: istore 6
    //   2106: goto -1188 -> 918
    //   2109: astore 30
    //   2111: iload 11
    //   2113: istore_2
    //   2114: iload 22
    //   2116: istore 23
    //   2118: aload 33
    //   2120: astore 30
    //   2122: iload 8
    //   2124: istore 5
    //   2126: iload 25
    //   2128: istore 22
    //   2130: goto -768 -> 1362
    //   2133: iload 14
    //   2135: istore 10
    //   2137: iload 29
    //   2139: istore 24
    //   2141: iload 18
    //   2143: istore 7
    //   2145: aload 32
    //   2147: astore 30
    //   2149: iload_2
    //   2150: istore_3
    //   2151: aload_0
    //   2152: iload_2
    //   2153: invokespecial 415	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:setResultCodeByErrorCode	(I)I
    //   2156: istore 4
    //   2158: iload 4
    //   2160: istore 6
    //   2162: iload_2
    //   2163: istore 9
    //   2165: iload 26
    //   2167: istore 23
    //   2169: iload 12
    //   2171: istore 5
    //   2173: goto -1255 -> 918
    //   2176: iload 15
    //   2178: istore 11
    //   2180: iload 28
    //   2182: istore 25
    //   2184: iload 17
    //   2186: istore 8
    //   2188: aload 32
    //   2190: astore 31
    //   2192: iload 19
    //   2194: istore 4
    //   2196: iload 14
    //   2198: istore 10
    //   2200: iload 29
    //   2202: istore 24
    //   2204: iload 18
    //   2206: istore 7
    //   2208: aload 32
    //   2210: astore 30
    //   2212: iload 20
    //   2214: istore_3
    //   2215: aload_0
    //   2216: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2219: aload 37
    //   2221: invokevirtual 404	com/tencent/mobileqq/app/QQAppInterface:updateSettingTableCache	(Lcom/tencent/mobileqq/data/Setting;)V
    //   2224: iload 15
    //   2226: istore 11
    //   2228: iload 28
    //   2230: istore 25
    //   2232: iload 17
    //   2234: istore 8
    //   2236: aload 32
    //   2238: astore 31
    //   2240: iload 19
    //   2242: istore 4
    //   2244: iload 14
    //   2246: istore 10
    //   2248: iload 29
    //   2250: istore 24
    //   2252: iload 18
    //   2254: istore 7
    //   2256: aload 32
    //   2258: astore 30
    //   2260: iload 20
    //   2262: istore_3
    //   2263: aload_0
    //   2264: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   2267: new 406	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2270: dup
    //   2271: aload_0
    //   2272: aload 37
    //   2274: aload_1
    //   2275: invokespecial 409	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   2278: invokevirtual 413	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2281: pop
    //   2282: iconst_0
    //   2283: istore 4
    //   2285: iconst_0
    //   2286: istore_3
    //   2287: aload 32
    //   2289: astore 30
    //   2291: iload 27
    //   2293: istore 23
    //   2295: iload 16
    //   2297: istore_2
    //   2298: goto -1322 -> 976
    //   2301: astore_1
    //   2302: iload_3
    //   2303: istore_2
    //   2304: iload 7
    //   2306: istore 5
    //   2308: new 315	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2311: dup
    //   2312: aload_0
    //   2313: iload 10
    //   2315: aload 36
    //   2317: aload 35
    //   2319: getfield 84	AvatarInfo/QQHeadInfo:idType	I
    //   2322: aload 35
    //   2324: getfield 98	AvatarInfo/QQHeadInfo:sizeType	I
    //   2327: aload 35
    //   2329: getfield 68	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2332: iconst_4
    //   2333: iload 5
    //   2335: aload 30
    //   2337: iload_2
    //   2338: invokestatic 321	java/lang/System:currentTimeMillis	()J
    //   2341: invokespecial 324	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   2344: aconst_null
    //   2345: iconst_0
    //   2346: invokestatic 328	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2349: aload_0
    //   2350: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2353: sipush 199
    //   2356: invokevirtual 332	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2359: checkcast 334	anwp
    //   2362: astore 30
    //   2364: iload 24
    //   2366: ifne +29 -> 2395
    //   2369: aload 30
    //   2371: ifnull +24 -> 2395
    //   2374: aload 30
    //   2376: invokevirtual 336	anwp:a	()Z
    //   2379: ifeq +16 -> 2395
    //   2382: aload 30
    //   2384: aload 35
    //   2386: getfield 194	AvatarInfo/QQHeadInfo:uin	J
    //   2389: invokestatic 339	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2392: invokevirtual 341	anwp:a	(Ljava/lang/String;)V
    //   2395: aload_1
    //   2396: athrow
    //   2397: astore_1
    //   2398: iload_3
    //   2399: istore 10
    //   2401: iload 23
    //   2403: istore 24
    //   2405: goto -97 -> 2308
    //   2408: astore 30
    //   2410: iconst_0
    //   2411: istore_2
    //   2412: iconst_0
    //   2413: istore 22
    //   2415: iconst_0
    //   2416: istore 23
    //   2418: aconst_null
    //   2419: astore 30
    //   2421: iload 6
    //   2423: istore 5
    //   2425: aload 32
    //   2427: astore 31
    //   2429: goto -1067 -> 1362
    //   2432: astore 30
    //   2434: iconst_0
    //   2435: istore_2
    //   2436: iconst_0
    //   2437: istore 22
    //   2439: aload 33
    //   2441: astore 30
    //   2443: iload 6
    //   2445: istore 5
    //   2447: aload 32
    //   2449: astore 31
    //   2451: goto -1089 -> 1362
    //   2454: astore 30
    //   2456: iload_2
    //   2457: istore_3
    //   2458: iconst_0
    //   2459: istore 24
    //   2461: iload 22
    //   2463: istore 23
    //   2465: aload 33
    //   2467: astore 30
    //   2469: iload 6
    //   2471: istore 5
    //   2473: aload 32
    //   2475: astore 31
    //   2477: iload_2
    //   2478: istore 4
    //   2480: iload_3
    //   2481: istore_2
    //   2482: iload 24
    //   2484: istore 22
    //   2486: goto -1124 -> 1362
    //   2489: astore 31
    //   2491: iload 4
    //   2493: istore_3
    //   2494: iload 22
    //   2496: istore 24
    //   2498: aload 30
    //   2500: astore 31
    //   2502: iload_2
    //   2503: istore 4
    //   2505: iload_3
    //   2506: istore_2
    //   2507: iload 23
    //   2509: istore 22
    //   2511: iload 24
    //   2513: istore 23
    //   2515: aload 33
    //   2517: astore 30
    //   2519: goto -1157 -> 1362
    //   2522: iconst_0
    //   2523: istore_3
    //   2524: iconst_0
    //   2525: istore 22
    //   2527: iconst_0
    //   2528: istore 23
    //   2530: aconst_null
    //   2531: astore 30
    //   2533: iload 21
    //   2535: istore_2
    //   2536: iload 11
    //   2538: istore 5
    //   2540: iload 8
    //   2542: istore 6
    //   2544: goto -1516 -> 1028
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2547	0	this	QQHeadDownloadHandler
    //   0	2547	1	paramFaceInfo	FaceInfo
    //   116	2420	2	i	int
    //   135	2389	3	j	int
    //   107	2397	4	k	int
    //   61	2478	5	m	int
    //   67	2476	6	n	int
    //   127	2178	7	i1	int
    //   104	2437	8	i2	int
    //   98	2066	9	i3	int
    //   119	2281	10	i4	int
    //   64	2473	11	i5	int
    //   76	2094	12	i6	int
    //   92	2011	13	i7	int
    //   89	2156	14	i8	int
    //   95	2130	15	i9	int
    //   101	2195	16	i10	int
    //   70	2163	17	i11	int
    //   73	2180	18	i12	int
    //   110	2131	19	i13	int
    //   113	2148	20	i14	int
    //   86	2448	21	i15	int
    //   408	2118	22	bool1	boolean
    //   221	2308	23	bool2	boolean
    //   123	2389	24	bool3	boolean
    //   666	1565	25	bool4	boolean
    //   58	2108	26	bool5	boolean
    //   49	2243	27	bool6	boolean
    //   52	2177	28	bool7	boolean
    //   55	2194	29	bool8	boolean
    //   131	1051	30	localObject1	Object
    //   1307	3	30	localException1	java.lang.Exception
    //   1336	1	30	localObject2	Object
    //   1344	1	30	localThrowable1	java.lang.Throwable
    //   1352	188	30	localObject3	Object
    //   1632	1	30	localException2	java.lang.Exception
    //   1688	392	30	localObject4	Object
    //   2109	1	30	localThrowable2	java.lang.Throwable
    //   2120	263	30	localObject5	Object
    //   2408	1	30	localThrowable3	java.lang.Throwable
    //   2419	1	30	localObject6	Object
    //   2432	1	30	localThrowable4	java.lang.Throwable
    //   2441	1	30	localObject7	Object
    //   2454	1	30	localThrowable5	java.lang.Throwable
    //   2467	65	30	localObject8	Object
    //   190	2286	31	localObject9	Object
    //   2489	1	31	localThrowable6	java.lang.Throwable
    //   2500	1	31	localObject10	Object
    //   83	2391	32	localObject11	Object
    //   481	815	33	localObject12	Object
    //   1317	25	33	localObject13	Object
    //   1429	1087	33	localObject14	Object
    //   705	1099	34	localObject15	Object
    //   4	2381	35	localQQHeadInfo	QQHeadInfo
    //   23	2293	36	str	String
    //   249	2024	37	localSetting	Setting
    //   610	1374	38	localFile	File
    // Exception table:
    //   from	to	target	type
    //   415	426	1307	java/lang/Exception
    //   389	410	1317	finally
    //   415	426	1317	finally
    //   426	443	1317	finally
    //   1309	1314	1317	finally
    //   1319	1322	1317	finally
    //   242	251	1344	java/lang/Throwable
    //   275	283	1344	java/lang/Throwable
    //   302	318	1344	java/lang/Throwable
    //   337	343	1344	java/lang/Throwable
    //   362	367	1344	java/lang/Throwable
    //   386	389	1344	java/lang/Throwable
    //   462	483	1344	java/lang/Throwable
    //   1341	1344	1344	java/lang/Throwable
    //   462	483	1552	java/lang/Exception
    //   502	525	1552	java/lang/Exception
    //   549	557	1552	java/lang/Exception
    //   576	582	1552	java/lang/Exception
    //   601	612	1552	java/lang/Exception
    //   640	647	1552	java/lang/Exception
    //   845	853	1632	java/lang/Exception
    //   892	903	1632	java/lang/Exception
    //   699	707	2109	java/lang/Throwable
    //   746	754	2109	java/lang/Throwable
    //   793	800	2109	java/lang/Throwable
    //   845	853	2109	java/lang/Throwable
    //   892	903	2109	java/lang/Throwable
    //   955	965	2109	java/lang/Throwable
    //   1693	1705	2109	java/lang/Throwable
    //   1763	1771	2109	java/lang/Throwable
    //   1810	1818	2109	java/lang/Throwable
    //   1857	1868	2109	java/lang/Throwable
    //   1905	1942	2109	java/lang/Throwable
    //   1983	1991	2109	java/lang/Throwable
    //   2037	2046	2109	java/lang/Throwable
    //   2083	2102	2109	java/lang/Throwable
    //   2215	2224	2109	java/lang/Throwable
    //   2263	2282	2109	java/lang/Throwable
    //   136	147	2301	finally
    //   166	192	2301	finally
    //   211	223	2301	finally
    //   242	251	2301	finally
    //   275	283	2301	finally
    //   302	318	2301	finally
    //   337	343	2301	finally
    //   362	367	2301	finally
    //   386	389	2301	finally
    //   462	483	2301	finally
    //   502	525	2301	finally
    //   549	557	2301	finally
    //   576	582	2301	finally
    //   601	612	2301	finally
    //   640	647	2301	finally
    //   699	707	2301	finally
    //   746	754	2301	finally
    //   793	800	2301	finally
    //   845	853	2301	finally
    //   892	903	2301	finally
    //   955	965	2301	finally
    //   1341	1344	2301	finally
    //   1693	1705	2301	finally
    //   1763	1771	2301	finally
    //   1810	1818	2301	finally
    //   1857	1868	2301	finally
    //   1905	1942	2301	finally
    //   1983	1991	2301	finally
    //   2037	2046	2301	finally
    //   2083	2102	2301	finally
    //   2151	2158	2301	finally
    //   2215	2224	2301	finally
    //   2263	2282	2301	finally
    //   976	992	2397	finally
    //   136	147	2408	java/lang/Throwable
    //   166	192	2408	java/lang/Throwable
    //   211	223	2408	java/lang/Throwable
    //   502	525	2432	java/lang/Throwable
    //   549	557	2432	java/lang/Throwable
    //   576	582	2432	java/lang/Throwable
    //   601	612	2432	java/lang/Throwable
    //   640	647	2432	java/lang/Throwable
    //   2151	2158	2454	java/lang/Throwable
    //   976	992	2489	java/lang/Throwable
  }
  
  public String getChoosedIP()
  {
    return aptw.a(0);
  }
  
  public String getChoosedStrangerGroupIp()
  {
    return aptw.a(1);
  }
  
  public Object[] getFaceSetting(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    Setting localSetting2 = this.app.getQQHeadSettingFromDB(paramString2);
    Setting localSetting1 = localSetting2;
    if (localSetting2 == null)
    {
      localSetting1 = new Setting();
      localSetting1.uin = paramString2;
      paramBoolean = true;
    }
    localSetting1.bFaceFlags = paramQQHeadInfo.dwFaceFlgas;
    localSetting1.bUsrType = paramQQHeadInfo.dstUsrType;
    localSetting1.url = paramQQHeadInfo.downLoadUrl;
    localSetting1.updateTimestamp = System.currentTimeMillis();
    byte b;
    if (paramQQHeadInfo.cHeadType == 0)
    {
      b = 0;
      localSetting1.bSourceType = b;
      if (paramBoolean) {
        break label318;
      }
      if (localSetting1.bHeadType == paramQQHeadInfo.cHeadType) {
        break label262;
      }
      paramBoolean = true;
      label109:
      bool = paramBoolean;
      if (paramQQHeadInfo.dstUsrType != 32)
      {
        bool = paramBoolean;
        if (paramBoolean)
        {
          bool = paramBoolean;
          if (localSetting1.bHeadType == 1)
          {
            bool = paramBoolean;
            if (paramQQHeadInfo.cHeadType == 0)
            {
              paramString1 = new File(this.app.getCustomFaceFilePath(localSetting1.bUsrType, paramString1, paramQQHeadInfo.idType));
              bool = paramBoolean;
              if (paramString1 != null)
              {
                bool = paramBoolean;
                if (paramString1.exists()) {
                  paramString1.delete();
                }
              }
            }
          }
        }
      }
    }
    label262:
    label318:
    for (boolean bool = paramBoolean;; bool = paramBoolean)
    {
      localSetting1.bHeadType = paramQQHeadInfo.cHeadType;
      localSetting1.systemHeadID = paramQQHeadInfo.systemHeadID;
      localSetting1.headImgTimestamp = paramQQHeadInfo.dwTimestamp;
      return new Object[] { Boolean.valueOf(bool), localSetting1 };
      b = paramQQHeadInfo.headLevel;
      break;
      if (paramQQHeadInfo.cHeadType == 0)
      {
        if (localSetting1.systemHeadID != paramQQHeadInfo.systemHeadID)
        {
          paramBoolean = true;
          break label109;
        }
        paramBoolean = false;
        break label109;
      }
      if (localSetting1.headImgTimestamp != paramQQHeadInfo.dwTimestamp)
      {
        paramBoolean = true;
        break label109;
      }
      paramBoolean = false;
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */