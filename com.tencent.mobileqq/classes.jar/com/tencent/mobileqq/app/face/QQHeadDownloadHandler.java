package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarHandlerApiImpl;
import com.tencent.mobileqq.avatar.handler.AvatarHandler;
import com.tencent.mobileqq.avatar.utils.ApolloUtil;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.Setting;
import java.io.File;
import mqq.os.MqqHandler;

public class QQHeadDownloadHandler
  extends FaceDownloader
{
  private static final String QQ_HEAD_DH = "Q.qqhead.QQHeadDownloadHandler";
  private static final int[] TROOPS_SYSTEM_HEADS = { 2130840707, 2130851183, 2130851184, 2130851185 };
  private static Object syncCopyQQHeadLock = new Object();
  private AppInterface app;
  private AvatarHandler avatarHandler;
  private MqqHandler mSubhandler = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  public QQHeadDownloadHandler(AppInterface paramAppInterface, AvatarHandler paramAvatarHandler)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
    this.avatarHandler = paramAvatarHandler;
  }
  
  private void notifyDownloadHeadComplete(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3)
  {
    if ((paramBoolean2) || (!paramBoolean1))
    {
      if (paramQQHeadInfo.dstUsrType == 11) {
        this.avatarHandler.notifyUI(2, true, new Object[] { paramString1 });
      }
    }
    else {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 4)
    {
      this.avatarHandler.notifyUI(3, true, new Object[] { paramString1 });
      ((IQQAvatarBroadcastService)this.app.getRuntimeService(IQQAvatarBroadcastService.class, "")).sendQQHeadBroadcast(4, paramString1, 0, paramString2);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      this.avatarHandler.notifyUI(4, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      this.avatarHandler.notifyUI(9, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), paramString3 });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      this.avatarHandler.notifyUI(5, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.idType), Boolean.valueOf(true) });
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 116)
    {
      this.avatarHandler.notifyUI(8, true, new Object[] { paramString1, Integer.valueOf(paramQQHeadInfo.sizeType), Boolean.valueOf(true) });
      return;
    }
    paramQQHeadInfo = (IQQAvatarBroadcastService)this.app.getRuntimeService(IQQAvatarBroadcastService.class, "");
    paramQQHeadInfo.sendQQHeadBroadcast(1, paramString1, 0, paramString2);
    if (paramString1.equals(this.app.getCurrentAccountUin())) {
      paramQQHeadInfo.sendSelfQQHeadBroadcast(1, paramString1, 0, paramString2);
    }
    this.app.getBusinessHandler(QQAvatarHandlerApiImpl.MESSAGE_HANDLER).notifyUI(1, true, new Object[] { paramString1 });
  }
  
  private void removeCache(QQHeadInfo paramQQHeadInfo, String paramString, boolean paramBoolean)
  {
    IQQAvatarDataService localIQQAvatarDataService;
    if (paramBoolean)
    {
      localIQQAvatarDataService = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
      if (paramQQHeadInfo.dstUsrType == 4) {
        localIQQAvatarDataService.removeFaceIconCache(4, paramString, paramQQHeadInfo.idType);
      }
    }
    else
    {
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 32)
    {
      localIQQAvatarDataService.removeFaceIconCache(32, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 16)
    {
      localIQQAvatarDataService.removeFaceIconCache(16, paramString, paramQQHeadInfo.idType);
      return;
    }
    if (paramQQHeadInfo.dstUsrType == 116)
    {
      localIQQAvatarDataService.removeFaceIconCacheApollo(116, paramString, paramQQHeadInfo.sizeType);
      return;
    }
    localIQQAvatarDataService.removeFaceIconCache(1, paramString, paramQQHeadInfo.idType);
  }
  
  private void removeFileCache(QQHeadInfo paramQQHeadInfo, String paramString)
  {
    if (paramQQHeadInfo.dstUsrType == 116) {
      ApolloUtil.a(this.app, paramQQHeadInfo.dstUsrType, paramString);
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
    //   23: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   26: invokevirtual 159	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 165	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:TROOPS_SYSTEM_HEADS	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 171	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 6
    //   42: aload 6
    //   44: astore 4
    //   46: sipush 512
    //   49: newarray byte
    //   51: astore 6
    //   53: new 173	java/io/FileOutputStream
    //   56: dup
    //   57: aload_2
    //   58: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_2
    //   62: aload 4
    //   64: aload 6
    //   66: invokevirtual 182	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: ifle +51 -> 122
    //   74: aload_2
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 186	java/io/FileOutputStream:write	([BII)V
    //   82: goto -20 -> 62
    //   85: astore 5
    //   87: invokestatic 192	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +13 -> 103
    //   93: ldc 8
    //   95: iconst_2
    //   96: ldc 194
    //   98: aload 5
    //   100: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 202	java/io/InputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: ifnull +7 -> 130
    //   126: aload_2
    //   127: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   130: aload 4
    //   132: ifnull -11 -> 121
    //   135: aload 4
    //   137: invokevirtual 202	java/io/InputStream:close	()V
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore 4
    //   145: aload 5
    //   147: ifnull +8 -> 155
    //   150: aload 5
    //   152: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   155: aload 4
    //   157: ifnull +8 -> 165
    //   160: aload 4
    //   162: invokevirtual 202	java/io/InputStream:close	()V
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
    //   1: getfield 211	com/tencent/mobileqq/app/face/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   4: astore 35
    //   6: aload_0
    //   7: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:avatarHandler	Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;
    //   10: aload 35
    //   12: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 35
    //   17: getfield 218	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 221	com/tencent/mobileqq/avatar/handler/AvatarHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 36
    //   25: aload_0
    //   26: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:avatarHandler	Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;
    //   29: iconst_0
    //   30: aload 36
    //   32: aload 35
    //   34: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 224	com/tencent/mobileqq/avatar/handler/AvatarHandler:a	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 227	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   45: invokevirtual 230	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
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
    //   80: getfield 233	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
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
    //   138: getfield 233	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   141: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +2438 -> 2582
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
    //   173: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   176: aload 36
    //   178: aload 35
    //   180: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   183: invokestatic 244	com/tencent/mobileqq/avatar/utils/AvatarUtil:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   186: iconst_0
    //   187: invokevirtual 248	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getFaceSetting	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/Object;
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
    //   215: checkcast 99	java/lang/Boolean
    //   218: invokevirtual 251	java/lang/Boolean:booleanValue	()Z
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
    //   246: checkcast 253	com/tencent/mobileqq/data/Setting
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
    //   280: invokespecial 255	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeFileCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;)V
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
    //   303: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   306: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   309: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   312: invokestatic 270	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;)Z
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
    //   337: invokestatic 274	com/tencent/mobileqq/util/SystemUtil:a	()Z
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
    //   390: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   393: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   396: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   399: invokestatic 270	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;)Z
    //   402: ifeq +24 -> 426
    //   405: invokestatic 274	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   408: istore 22
    //   410: iload 22
    //   412: ifeq +14 -> 426
    //   415: ldc_w 276
    //   418: getstatic 281	com/tencent/mobileqq/app/AppConstants:PATH_CUSTOM_HEAD_ROOT_SDCARD	Ljava/lang/String;
    //   421: iconst_1
    //   422: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   425: pop
    //   426: aload_0
    //   427: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   430: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   433: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   436: iconst_0
    //   437: invokestatic 289	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;Z)V
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
    //   463: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   466: ldc 134
    //   468: ldc 77
    //   470: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   473: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   476: aload 37
    //   478: aload 35
    //   480: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   483: aload 35
    //   485: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   488: invokeinterface 293 4 0
    //   493: astore 33
    //   495: iload 14
    //   497: istore 10
    //   499: iload 29
    //   501: istore 24
    //   503: iload 18
    //   505: istore 7
    //   507: aload 32
    //   509: astore 30
    //   511: iload 20
    //   513: istore_3
    //   514: new 295	java/io/File
    //   517: dup
    //   518: aload 33
    //   520: iconst_0
    //   521: aload 33
    //   523: ldc_w 297
    //   526: invokevirtual 301	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   529: invokevirtual 305	java/lang/String:substring	(II)Ljava/lang/String;
    //   532: invokespecial 308	java/io/File:<init>	(Ljava/lang/String;)V
    //   535: astore 31
    //   537: aload 31
    //   539: ifnull +55 -> 594
    //   542: iload 14
    //   544: istore 10
    //   546: iload 29
    //   548: istore 24
    //   550: iload 18
    //   552: istore 7
    //   554: aload 32
    //   556: astore 30
    //   558: iload 20
    //   560: istore_3
    //   561: aload 31
    //   563: invokevirtual 311	java/io/File:exists	()Z
    //   566: ifne +28 -> 594
    //   569: iload 14
    //   571: istore 10
    //   573: iload 29
    //   575: istore 24
    //   577: iload 18
    //   579: istore 7
    //   581: aload 32
    //   583: astore 30
    //   585: iload 20
    //   587: istore_3
    //   588: aload 31
    //   590: invokevirtual 314	java/io/File:mkdirs	()Z
    //   593: pop
    //   594: iload 14
    //   596: istore 10
    //   598: iload 29
    //   600: istore 24
    //   602: iload 18
    //   604: istore 7
    //   606: aload 32
    //   608: astore 30
    //   610: iload 20
    //   612: istore_3
    //   613: new 295	java/io/File
    //   616: dup
    //   617: aload 33
    //   619: invokespecial 308	java/io/File:<init>	(Ljava/lang/String;)V
    //   622: astore 38
    //   624: iload 23
    //   626: istore 22
    //   628: iload 23
    //   630: ifne +37 -> 667
    //   633: iload 14
    //   635: istore 10
    //   637: iload 29
    //   639: istore 24
    //   641: iload 18
    //   643: istore 7
    //   645: aload 32
    //   647: astore 30
    //   649: iload 20
    //   651: istore_3
    //   652: aload 38
    //   654: invokevirtual 311	java/io/File:exists	()Z
    //   657: istore 22
    //   659: iload 22
    //   661: ifne +909 -> 1570
    //   664: iconst_1
    //   665: istore 22
    //   667: iload 22
    //   669: ifeq +1549 -> 2218
    //   672: iload 15
    //   674: istore 11
    //   676: iload 28
    //   678: istore 25
    //   680: iload 17
    //   682: istore 8
    //   684: aload 32
    //   686: astore 31
    //   688: iload 19
    //   690: istore 4
    //   692: iload 14
    //   694: istore 10
    //   696: iload 29
    //   698: istore 24
    //   700: iload 18
    //   702: istore 7
    //   704: aload 32
    //   706: astore 30
    //   708: iload 20
    //   710: istore_3
    //   711: aload_0
    //   712: aload_1
    //   713: iconst_0
    //   714: invokevirtual 318	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   717: astore 34
    //   719: iload 15
    //   721: istore 11
    //   723: iload 28
    //   725: istore 25
    //   727: iload 17
    //   729: istore 8
    //   731: aload 34
    //   733: astore 31
    //   735: iload 19
    //   737: istore 4
    //   739: iload 14
    //   741: istore 10
    //   743: iload 29
    //   745: istore 24
    //   747: iload 18
    //   749: istore 7
    //   751: aload 34
    //   753: astore 30
    //   755: iload 20
    //   757: istore_3
    //   758: aload 35
    //   760: getfield 321	AvatarInfo/QQHeadInfo:cHeadType	B
    //   763: ifne +921 -> 1684
    //   766: iload 15
    //   768: istore 11
    //   770: iload 28
    //   772: istore 25
    //   774: iload 17
    //   776: istore 8
    //   778: aload 34
    //   780: astore 31
    //   782: iload 19
    //   784: istore 4
    //   786: iload 14
    //   788: istore 10
    //   790: iload 29
    //   792: istore 24
    //   794: iload 18
    //   796: istore 7
    //   798: aload 34
    //   800: astore 30
    //   802: iload 20
    //   804: istore_3
    //   805: aload 35
    //   807: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   810: istore 5
    //   812: iload 5
    //   814: iconst_4
    //   815: if_icmpne +869 -> 1684
    //   818: iload 15
    //   820: istore 11
    //   822: iload 28
    //   824: istore 25
    //   826: iload 17
    //   828: istore 8
    //   830: aload 34
    //   832: astore 31
    //   834: iload 19
    //   836: istore 4
    //   838: iload 14
    //   840: istore 10
    //   842: iload 29
    //   844: istore 24
    //   846: iload 18
    //   848: istore 7
    //   850: aload 34
    //   852: astore 30
    //   854: iload 20
    //   856: istore_3
    //   857: aload 38
    //   859: invokevirtual 311	java/io/File:exists	()Z
    //   862: ifne +53 -> 915
    //   865: iload 15
    //   867: istore 11
    //   869: iload 28
    //   871: istore 25
    //   873: iload 17
    //   875: istore 8
    //   877: aload 34
    //   879: astore 31
    //   881: iload 19
    //   883: istore 4
    //   885: iload 14
    //   887: istore 10
    //   889: iload 29
    //   891: istore 24
    //   893: iload 18
    //   895: istore 7
    //   897: aload 34
    //   899: astore 30
    //   901: iload 20
    //   903: istore_3
    //   904: aload_0
    //   905: aload 35
    //   907: getfield 325	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   910: aload 38
    //   912: invokespecial 327	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:writeTroopSystemHead	(ILjava/io/File;)V
    //   915: iconst_1
    //   916: istore 23
    //   918: aload 34
    //   920: astore 32
    //   922: iload 12
    //   924: istore 5
    //   926: iload 13
    //   928: istore 6
    //   930: iload 9
    //   932: istore 11
    //   934: iload 23
    //   936: istore 25
    //   938: iload 5
    //   940: istore 8
    //   942: aload 32
    //   944: astore 31
    //   946: iload_2
    //   947: istore 4
    //   949: iload 6
    //   951: istore 10
    //   953: iload 23
    //   955: istore 24
    //   957: iload 5
    //   959: istore 7
    //   961: aload 32
    //   963: astore 30
    //   965: iload_2
    //   966: istore_3
    //   967: aload_0
    //   968: aload 35
    //   970: aload 36
    //   972: iload 23
    //   974: invokespecial 329	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Z)V
    //   977: iload 9
    //   979: istore 4
    //   981: iload 6
    //   983: istore_3
    //   984: aload 32
    //   986: astore 30
    //   988: aload_0
    //   989: aload 35
    //   991: aload 36
    //   993: aload 33
    //   995: iload 22
    //   997: iload 23
    //   999: aload 30
    //   1001: invokespecial 331	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:notifyDownloadHeadComplete	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    //   1004: iload 4
    //   1006: istore 6
    //   1008: iload_3
    //   1009: istore 4
    //   1011: aload 30
    //   1013: astore 32
    //   1015: iload 23
    //   1017: istore 24
    //   1019: aload 33
    //   1021: astore 30
    //   1023: iload 22
    //   1025: istore 23
    //   1027: iload 24
    //   1029: istore 22
    //   1031: iload 6
    //   1033: istore_3
    //   1034: iload_2
    //   1035: istore 6
    //   1037: iload 4
    //   1039: istore_2
    //   1040: new 333	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1043: dup
    //   1044: aload_0
    //   1045: iload_2
    //   1046: aload 36
    //   1048: aload 35
    //   1050: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1053: aload 35
    //   1055: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1058: aload 35
    //   1060: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1063: iconst_4
    //   1064: iload 5
    //   1066: aload 32
    //   1068: iload 6
    //   1070: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   1073: invokespecial 342	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1076: aconst_null
    //   1077: iconst_0
    //   1078: invokestatic 346	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1081: aload_0
    //   1082: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1085: ldc_w 348
    //   1088: ldc 77
    //   1090: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1093: checkcast 348	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1096: astore 31
    //   1098: iload_2
    //   1099: istore 4
    //   1101: aload 32
    //   1103: astore 33
    //   1105: iload_3
    //   1106: istore 5
    //   1108: iload 22
    //   1110: istore 24
    //   1112: iload 23
    //   1114: istore 25
    //   1116: aload 30
    //   1118: astore 34
    //   1120: iload 22
    //   1122: ifne +99 -> 1221
    //   1125: iload_2
    //   1126: istore 4
    //   1128: aload 32
    //   1130: astore 33
    //   1132: iload_3
    //   1133: istore 5
    //   1135: iload 22
    //   1137: istore 24
    //   1139: iload 23
    //   1141: istore 25
    //   1143: aload 30
    //   1145: astore 34
    //   1147: aload 31
    //   1149: ifnull +72 -> 1221
    //   1152: iload_2
    //   1153: istore 4
    //   1155: aload 32
    //   1157: astore 33
    //   1159: iload_3
    //   1160: istore 5
    //   1162: iload 22
    //   1164: istore 24
    //   1166: iload 23
    //   1168: istore 25
    //   1170: aload 30
    //   1172: astore 34
    //   1174: aload 31
    //   1176: invokeinterface 351 1 0
    //   1181: ifeq +40 -> 1221
    //   1184: aload 31
    //   1186: aload 35
    //   1188: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1191: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1194: invokeinterface 357 2 0
    //   1199: aload 30
    //   1201: astore 34
    //   1203: iload 23
    //   1205: istore 25
    //   1207: iload 22
    //   1209: istore 24
    //   1211: iload_3
    //   1212: istore 5
    //   1214: aload 32
    //   1216: astore 33
    //   1218: iload_2
    //   1219: istore 4
    //   1221: ldc 8
    //   1223: iconst_2
    //   1224: new 359	java/lang/StringBuilder
    //   1227: dup
    //   1228: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1231: ldc_w 362
    //   1234: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: iload 24
    //   1239: invokevirtual 369	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1242: ldc_w 371
    //   1245: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: iload 4
    //   1250: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1253: ldc_w 376
    //   1256: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: iload 25
    //   1261: invokevirtual 369	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1264: ldc_w 378
    //   1267: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: iload 5
    //   1272: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1275: ldc_w 380
    //   1278: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: aload_1
    //   1282: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1285: ldc_w 385
    //   1288: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1291: aload 35
    //   1293: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1296: ldc_w 387
    //   1299: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: aload 34
    //   1304: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1307: ldc_w 389
    //   1310: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload 33
    //   1315: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1318: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1321: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1324: return
    //   1325: astore 30
    //   1327: aload 30
    //   1329: invokevirtual 399	java/lang/Exception:printStackTrace	()V
    //   1332: goto -906 -> 426
    //   1335: astore 33
    //   1337: aload 31
    //   1339: monitorexit
    //   1340: iload 14
    //   1342: istore 10
    //   1344: iload 29
    //   1346: istore 24
    //   1348: iload 18
    //   1350: istore 7
    //   1352: aload 32
    //   1354: astore 30
    //   1356: iload 20
    //   1358: istore_3
    //   1359: aload 33
    //   1361: athrow
    //   1362: astore 30
    //   1364: iconst_0
    //   1365: istore_2
    //   1366: iconst_0
    //   1367: istore 22
    //   1369: aconst_null
    //   1370: astore 30
    //   1372: aload 32
    //   1374: astore 31
    //   1376: iload 6
    //   1378: istore 5
    //   1380: sipush 9204
    //   1383: istore_3
    //   1384: new 333	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1387: dup
    //   1388: aload_0
    //   1389: sipush 9204
    //   1392: aload 36
    //   1394: aload 35
    //   1396: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1399: aload 35
    //   1401: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1404: aload 35
    //   1406: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1409: iconst_4
    //   1410: iload 5
    //   1412: aload 31
    //   1414: iload 4
    //   1416: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   1419: invokespecial 342	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1422: aconst_null
    //   1423: iconst_0
    //   1424: invokestatic 346	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1427: aload_0
    //   1428: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1431: ldc_w 348
    //   1434: ldc 77
    //   1436: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1439: checkcast 348	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1442: astore 32
    //   1444: iload_3
    //   1445: istore 4
    //   1447: aload 31
    //   1449: astore 33
    //   1451: iload_2
    //   1452: istore 5
    //   1454: iload 22
    //   1456: istore 24
    //   1458: iload 23
    //   1460: istore 25
    //   1462: aload 30
    //   1464: astore 34
    //   1466: iload 22
    //   1468: ifne -247 -> 1221
    //   1471: iload_3
    //   1472: istore 4
    //   1474: aload 31
    //   1476: astore 33
    //   1478: iload_2
    //   1479: istore 5
    //   1481: iload 22
    //   1483: istore 24
    //   1485: iload 23
    //   1487: istore 25
    //   1489: aload 30
    //   1491: astore 34
    //   1493: aload 32
    //   1495: ifnull -274 -> 1221
    //   1498: iload_3
    //   1499: istore 4
    //   1501: aload 31
    //   1503: astore 33
    //   1505: iload_2
    //   1506: istore 5
    //   1508: iload 22
    //   1510: istore 24
    //   1512: iload 23
    //   1514: istore 25
    //   1516: aload 30
    //   1518: astore 34
    //   1520: aload 32
    //   1522: invokeinterface 351 1 0
    //   1527: ifeq -306 -> 1221
    //   1530: aload 32
    //   1532: aload 35
    //   1534: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1537: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1540: invokeinterface 357 2 0
    //   1545: iload_3
    //   1546: istore 4
    //   1548: aload 31
    //   1550: astore 33
    //   1552: iload_2
    //   1553: istore 5
    //   1555: iload 22
    //   1557: istore 24
    //   1559: iload 23
    //   1561: istore 25
    //   1563: aload 30
    //   1565: astore 34
    //   1567: goto -346 -> 1221
    //   1570: iconst_0
    //   1571: istore 22
    //   1573: goto -906 -> 667
    //   1576: astore_1
    //   1577: new 333	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1580: dup
    //   1581: aload_0
    //   1582: sipush 9202
    //   1585: aload 36
    //   1587: aload 35
    //   1589: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1592: aload 35
    //   1594: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1597: aload 35
    //   1599: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1602: iconst_4
    //   1603: iconst_0
    //   1604: aload 32
    //   1606: iconst_0
    //   1607: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   1610: invokespecial 342	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1613: aconst_null
    //   1614: iconst_0
    //   1615: invokestatic 346	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1618: aload_0
    //   1619: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1622: ldc_w 348
    //   1625: ldc 77
    //   1627: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1630: checkcast 348	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1633: astore_1
    //   1634: aload_1
    //   1635: ifnull -311 -> 1324
    //   1638: aload_1
    //   1639: invokeinterface 351 1 0
    //   1644: ifeq -320 -> 1324
    //   1647: aload_1
    //   1648: aload 35
    //   1650: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1653: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1656: invokeinterface 357 2 0
    //   1661: return
    //   1662: astore 30
    //   1664: sipush 9202
    //   1667: istore 6
    //   1669: iload 26
    //   1671: istore 23
    //   1673: iload 12
    //   1675: istore 5
    //   1677: aload 34
    //   1679: astore 32
    //   1681: goto -751 -> 930
    //   1684: iload 15
    //   1686: istore 11
    //   1688: iload 28
    //   1690: istore 25
    //   1692: iload 17
    //   1694: istore 8
    //   1696: aload 34
    //   1698: astore 31
    //   1700: iload 19
    //   1702: istore 4
    //   1704: iload 14
    //   1706: istore 10
    //   1708: iload 29
    //   1710: istore 24
    //   1712: iload 18
    //   1714: istore 7
    //   1716: aload 34
    //   1718: astore 30
    //   1720: iload 20
    //   1722: istore_3
    //   1723: aload_0
    //   1724: aload 34
    //   1726: aload 38
    //   1728: aload_1
    //   1729: iconst_0
    //   1730: invokevirtual 403	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1733: istore 5
    //   1735: aload 34
    //   1737: astore 32
    //   1739: iload 5
    //   1741: istore_2
    //   1742: iload 5
    //   1744: ifeq +228 -> 1972
    //   1747: aload 34
    //   1749: astore 32
    //   1751: iload 5
    //   1753: istore_2
    //   1754: iload 15
    //   1756: istore 11
    //   1758: iload 28
    //   1760: istore 25
    //   1762: iload 17
    //   1764: istore 8
    //   1766: aload 34
    //   1768: astore 31
    //   1770: iload 5
    //   1772: istore 4
    //   1774: iload 14
    //   1776: istore 10
    //   1778: iload 29
    //   1780: istore 24
    //   1782: iload 18
    //   1784: istore 7
    //   1786: aload 34
    //   1788: astore 30
    //   1790: iload 5
    //   1792: istore_3
    //   1793: iconst_1
    //   1794: invokestatic 409	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   1797: iconst_3
    //   1798: if_icmpne +174 -> 1972
    //   1801: iload 15
    //   1803: istore 11
    //   1805: iload 28
    //   1807: istore 25
    //   1809: iload 17
    //   1811: istore 8
    //   1813: aload 34
    //   1815: astore 31
    //   1817: iload 5
    //   1819: istore 4
    //   1821: iload 14
    //   1823: istore 10
    //   1825: iload 29
    //   1827: istore 24
    //   1829: iload 18
    //   1831: istore 7
    //   1833: aload 34
    //   1835: astore 30
    //   1837: iload 5
    //   1839: istore_3
    //   1840: aload_0
    //   1841: aload_1
    //   1842: iconst_1
    //   1843: invokevirtual 318	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   1846: astore 32
    //   1848: iload 15
    //   1850: istore 11
    //   1852: iload 28
    //   1854: istore 25
    //   1856: iload 17
    //   1858: istore 8
    //   1860: aload 32
    //   1862: astore 31
    //   1864: iload 5
    //   1866: istore 4
    //   1868: iload 14
    //   1870: istore 10
    //   1872: iload 29
    //   1874: istore 24
    //   1876: iload 18
    //   1878: istore 7
    //   1880: aload 32
    //   1882: astore 30
    //   1884: iload 5
    //   1886: istore_3
    //   1887: aload_0
    //   1888: aload 32
    //   1890: aload 38
    //   1892: aload_1
    //   1893: iconst_0
    //   1894: invokevirtual 403	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   1897: istore_2
    //   1898: iload 15
    //   1900: istore 11
    //   1902: iload 28
    //   1904: istore 25
    //   1906: iload 17
    //   1908: istore 8
    //   1910: aload 32
    //   1912: astore 31
    //   1914: iload_2
    //   1915: istore 4
    //   1917: iload 14
    //   1919: istore 10
    //   1921: iload 29
    //   1923: istore 24
    //   1925: iload 18
    //   1927: istore 7
    //   1929: aload 32
    //   1931: astore 30
    //   1933: iload_2
    //   1934: istore_3
    //   1935: ldc 8
    //   1937: iconst_1
    //   1938: new 359	java/lang/StringBuilder
    //   1941: dup
    //   1942: invokespecial 360	java/lang/StringBuilder:<init>	()V
    //   1945: ldc_w 411
    //   1948: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: aload 32
    //   1953: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1956: ldc_w 413
    //   1959: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1962: iload_2
    //   1963: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 392	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 396	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: iload_2
    //   1973: ifne +202 -> 2175
    //   1976: iload 15
    //   1978: istore 11
    //   1980: iload 28
    //   1982: istore 25
    //   1984: iload 17
    //   1986: istore 8
    //   1988: aload 32
    //   1990: astore 31
    //   1992: iload_2
    //   1993: istore 4
    //   1995: iload 14
    //   1997: istore 10
    //   1999: iload 29
    //   2001: istore 24
    //   2003: iload 18
    //   2005: istore 7
    //   2007: aload 32
    //   2009: astore 30
    //   2011: iload_2
    //   2012: istore_3
    //   2013: aload 38
    //   2015: invokevirtual 416	java/io/File:length	()J
    //   2018: l2i
    //   2019: istore 5
    //   2021: iconst_1
    //   2022: istore 26
    //   2024: iconst_1
    //   2025: istore 27
    //   2027: iconst_1
    //   2028: istore 23
    //   2030: iload 15
    //   2032: istore 11
    //   2034: iload 26
    //   2036: istore 25
    //   2038: iload 5
    //   2040: istore 8
    //   2042: aload 32
    //   2044: astore 31
    //   2046: iload_2
    //   2047: istore 4
    //   2049: iload 14
    //   2051: istore 10
    //   2053: iload 27
    //   2055: istore 24
    //   2057: iload 5
    //   2059: istore 7
    //   2061: aload 32
    //   2063: astore 30
    //   2065: iload_2
    //   2066: istore_3
    //   2067: aload_0
    //   2068: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   2071: ldc 134
    //   2073: ldc 77
    //   2075: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2078: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   2081: aload 37
    //   2083: invokeinterface 420 2 0
    //   2088: iload 15
    //   2090: istore 11
    //   2092: iload 26
    //   2094: istore 25
    //   2096: iload 5
    //   2098: istore 8
    //   2100: aload 32
    //   2102: astore 31
    //   2104: iload_2
    //   2105: istore 4
    //   2107: iload 14
    //   2109: istore 10
    //   2111: iload 27
    //   2113: istore 24
    //   2115: iload 5
    //   2117: istore 7
    //   2119: aload 32
    //   2121: astore 30
    //   2123: iload_2
    //   2124: istore_3
    //   2125: aload_0
    //   2126: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   2129: new 422	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2132: dup
    //   2133: aload_0
    //   2134: aload 37
    //   2136: aload_1
    //   2137: invokespecial 425	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   2140: invokevirtual 429	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2143: pop
    //   2144: iload 13
    //   2146: istore 6
    //   2148: goto -1218 -> 930
    //   2151: astore 30
    //   2153: iload 11
    //   2155: istore_2
    //   2156: iload 22
    //   2158: istore 23
    //   2160: aload 33
    //   2162: astore 30
    //   2164: iload 8
    //   2166: istore 5
    //   2168: iload 25
    //   2170: istore 22
    //   2172: goto -792 -> 1380
    //   2175: iload 14
    //   2177: istore 10
    //   2179: iload 29
    //   2181: istore 24
    //   2183: iload 18
    //   2185: istore 7
    //   2187: aload 32
    //   2189: astore 30
    //   2191: iload_2
    //   2192: istore_3
    //   2193: aload_0
    //   2194: iload_2
    //   2195: invokespecial 431	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:setResultCodeByErrorCode	(I)I
    //   2198: istore 4
    //   2200: iload 4
    //   2202: istore 6
    //   2204: iload_2
    //   2205: istore 9
    //   2207: iload 26
    //   2209: istore 23
    //   2211: iload 12
    //   2213: istore 5
    //   2215: goto -1285 -> 930
    //   2218: iload 15
    //   2220: istore 11
    //   2222: iload 28
    //   2224: istore 25
    //   2226: iload 17
    //   2228: istore 8
    //   2230: aload 32
    //   2232: astore 31
    //   2234: iload 19
    //   2236: istore 4
    //   2238: iload 14
    //   2240: istore 10
    //   2242: iload 29
    //   2244: istore 24
    //   2246: iload 18
    //   2248: istore 7
    //   2250: aload 32
    //   2252: astore 30
    //   2254: iload 20
    //   2256: istore_3
    //   2257: aload_0
    //   2258: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   2261: ldc 134
    //   2263: ldc 77
    //   2265: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2268: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   2271: aload 37
    //   2273: invokeinterface 420 2 0
    //   2278: iload 15
    //   2280: istore 11
    //   2282: iload 28
    //   2284: istore 25
    //   2286: iload 17
    //   2288: istore 8
    //   2290: aload 32
    //   2292: astore 31
    //   2294: iload 19
    //   2296: istore 4
    //   2298: iload 14
    //   2300: istore 10
    //   2302: iload 29
    //   2304: istore 24
    //   2306: iload 18
    //   2308: istore 7
    //   2310: aload 32
    //   2312: astore 30
    //   2314: iload 20
    //   2316: istore_3
    //   2317: aload_0
    //   2318: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   2321: new 422	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   2324: dup
    //   2325: aload_0
    //   2326: aload 37
    //   2328: aload_1
    //   2329: invokespecial 425	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   2332: invokevirtual 429	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   2335: pop
    //   2336: iconst_0
    //   2337: istore 4
    //   2339: iconst_0
    //   2340: istore_3
    //   2341: aload 32
    //   2343: astore 30
    //   2345: iload 27
    //   2347: istore 23
    //   2349: iload 16
    //   2351: istore_2
    //   2352: goto -1364 -> 988
    //   2355: astore_1
    //   2356: iload_3
    //   2357: istore_2
    //   2358: iload 7
    //   2360: istore 5
    //   2362: new 333	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   2365: dup
    //   2366: aload_0
    //   2367: iload 10
    //   2369: aload 36
    //   2371: aload 35
    //   2373: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   2376: aload 35
    //   2378: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   2381: aload 35
    //   2383: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2386: iconst_4
    //   2387: iload 5
    //   2389: aload 30
    //   2391: iload_2
    //   2392: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   2395: invokespecial 342	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   2398: aconst_null
    //   2399: iconst_0
    //   2400: invokestatic 346	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   2403: aload_0
    //   2404: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   2407: ldc_w 348
    //   2410: ldc 77
    //   2412: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   2415: checkcast 348	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   2418: astore 30
    //   2420: iload 24
    //   2422: ifne +33 -> 2455
    //   2425: aload 30
    //   2427: ifnull +28 -> 2455
    //   2430: aload 30
    //   2432: invokeinterface 351 1 0
    //   2437: ifeq +18 -> 2455
    //   2440: aload 30
    //   2442: aload 35
    //   2444: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   2447: invokestatic 354	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2450: invokeinterface 357 2 0
    //   2455: aload_1
    //   2456: athrow
    //   2457: astore_1
    //   2458: iload_3
    //   2459: istore 10
    //   2461: iload 23
    //   2463: istore 24
    //   2465: goto -103 -> 2362
    //   2468: astore 30
    //   2470: iconst_0
    //   2471: istore_2
    //   2472: iconst_0
    //   2473: istore 22
    //   2475: iconst_0
    //   2476: istore 23
    //   2478: aconst_null
    //   2479: astore 30
    //   2481: iload 6
    //   2483: istore 5
    //   2485: aload 32
    //   2487: astore 31
    //   2489: goto -1109 -> 1380
    //   2492: astore 30
    //   2494: iconst_0
    //   2495: istore_2
    //   2496: iconst_0
    //   2497: istore 22
    //   2499: aload 33
    //   2501: astore 30
    //   2503: iload 6
    //   2505: istore 5
    //   2507: aload 32
    //   2509: astore 31
    //   2511: goto -1131 -> 1380
    //   2514: astore 30
    //   2516: iload_2
    //   2517: istore_3
    //   2518: iconst_0
    //   2519: istore 24
    //   2521: iload 22
    //   2523: istore 23
    //   2525: aload 33
    //   2527: astore 30
    //   2529: iload 6
    //   2531: istore 5
    //   2533: aload 32
    //   2535: astore 31
    //   2537: iload_2
    //   2538: istore 4
    //   2540: iload_3
    //   2541: istore_2
    //   2542: iload 24
    //   2544: istore 22
    //   2546: goto -1166 -> 1380
    //   2549: astore 31
    //   2551: iload 4
    //   2553: istore_3
    //   2554: iload 22
    //   2556: istore 24
    //   2558: aload 30
    //   2560: astore 31
    //   2562: iload_2
    //   2563: istore 4
    //   2565: iload_3
    //   2566: istore_2
    //   2567: iload 23
    //   2569: istore 22
    //   2571: iload 24
    //   2573: istore 23
    //   2575: aload 33
    //   2577: astore 30
    //   2579: goto -1199 -> 1380
    //   2582: iconst_0
    //   2583: istore_3
    //   2584: iconst_0
    //   2585: istore 22
    //   2587: iconst_0
    //   2588: istore 23
    //   2590: aconst_null
    //   2591: astore 30
    //   2593: iload 21
    //   2595: istore_2
    //   2596: iload 11
    //   2598: istore 5
    //   2600: iload 8
    //   2602: istore 6
    //   2604: goto -1564 -> 1040
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2607	0	this	QQHeadDownloadHandler
    //   0	2607	1	paramFaceInfo	FaceInfo
    //   116	2480	2	i	int
    //   135	2449	3	j	int
    //   107	2457	4	k	int
    //   61	2538	5	m	int
    //   67	2536	6	n	int
    //   127	2232	7	i1	int
    //   104	2497	8	i2	int
    //   98	2108	9	i3	int
    //   119	2341	10	i4	int
    //   64	2533	11	i5	int
    //   76	2136	12	i6	int
    //   92	2053	13	i7	int
    //   89	2210	14	i8	int
    //   95	2184	15	i9	int
    //   101	2249	16	i10	int
    //   70	2217	17	i11	int
    //   73	2234	18	i12	int
    //   110	2185	19	i13	int
    //   113	2202	20	i14	int
    //   86	2508	21	i15	int
    //   408	2178	22	bool1	boolean
    //   221	2368	23	bool2	boolean
    //   123	2449	24	bool3	boolean
    //   678	1607	25	bool4	boolean
    //   58	2150	26	bool5	boolean
    //   49	2297	27	bool6	boolean
    //   52	2231	28	bool7	boolean
    //   55	2248	29	bool8	boolean
    //   131	1069	30	localObject1	Object
    //   1325	3	30	localException1	java.lang.Exception
    //   1354	1	30	localObject2	Object
    //   1362	1	30	localThrowable1	java.lang.Throwable
    //   1370	194	30	localObject3	Object
    //   1662	1	30	localException2	java.lang.Exception
    //   1718	404	30	localObject4	Object
    //   2151	1	30	localThrowable2	java.lang.Throwable
    //   2162	279	30	localObject5	Object
    //   2468	1	30	localThrowable3	java.lang.Throwable
    //   2479	1	30	localObject6	Object
    //   2492	1	30	localThrowable4	java.lang.Throwable
    //   2501	1	30	localObject7	Object
    //   2514	1	30	localThrowable5	java.lang.Throwable
    //   2527	65	30	localObject8	Object
    //   190	2346	31	localObject9	Object
    //   2549	1	31	localThrowable6	java.lang.Throwable
    //   2560	1	31	localObject10	Object
    //   83	2451	32	localObject11	Object
    //   493	821	33	localObject12	Object
    //   1335	25	33	localObject13	Object
    //   1449	1127	33	localObject14	Object
    //   717	1117	34	localObject15	Object
    //   4	2439	35	localQQHeadInfo	QQHeadInfo
    //   23	2347	36	str	String
    //   249	2078	37	localSetting	Setting
    //   622	1392	38	localFile	File
    // Exception table:
    //   from	to	target	type
    //   415	426	1325	java/lang/Exception
    //   389	410	1335	finally
    //   415	426	1335	finally
    //   426	443	1335	finally
    //   1327	1332	1335	finally
    //   1337	1340	1335	finally
    //   242	251	1362	java/lang/Throwable
    //   275	283	1362	java/lang/Throwable
    //   302	318	1362	java/lang/Throwable
    //   337	343	1362	java/lang/Throwable
    //   362	367	1362	java/lang/Throwable
    //   386	389	1362	java/lang/Throwable
    //   462	495	1362	java/lang/Throwable
    //   1359	1362	1362	java/lang/Throwable
    //   462	495	1576	java/lang/Exception
    //   514	537	1576	java/lang/Exception
    //   561	569	1576	java/lang/Exception
    //   588	594	1576	java/lang/Exception
    //   613	624	1576	java/lang/Exception
    //   652	659	1576	java/lang/Exception
    //   857	865	1662	java/lang/Exception
    //   904	915	1662	java/lang/Exception
    //   711	719	2151	java/lang/Throwable
    //   758	766	2151	java/lang/Throwable
    //   805	812	2151	java/lang/Throwable
    //   857	865	2151	java/lang/Throwable
    //   904	915	2151	java/lang/Throwable
    //   967	977	2151	java/lang/Throwable
    //   1723	1735	2151	java/lang/Throwable
    //   1793	1801	2151	java/lang/Throwable
    //   1840	1848	2151	java/lang/Throwable
    //   1887	1898	2151	java/lang/Throwable
    //   1935	1972	2151	java/lang/Throwable
    //   2013	2021	2151	java/lang/Throwable
    //   2067	2088	2151	java/lang/Throwable
    //   2125	2144	2151	java/lang/Throwable
    //   2257	2278	2151	java/lang/Throwable
    //   2317	2336	2151	java/lang/Throwable
    //   136	147	2355	finally
    //   166	192	2355	finally
    //   211	223	2355	finally
    //   242	251	2355	finally
    //   275	283	2355	finally
    //   302	318	2355	finally
    //   337	343	2355	finally
    //   362	367	2355	finally
    //   386	389	2355	finally
    //   462	495	2355	finally
    //   514	537	2355	finally
    //   561	569	2355	finally
    //   588	594	2355	finally
    //   613	624	2355	finally
    //   652	659	2355	finally
    //   711	719	2355	finally
    //   758	766	2355	finally
    //   805	812	2355	finally
    //   857	865	2355	finally
    //   904	915	2355	finally
    //   967	977	2355	finally
    //   1359	1362	2355	finally
    //   1723	1735	2355	finally
    //   1793	1801	2355	finally
    //   1840	1848	2355	finally
    //   1887	1898	2355	finally
    //   1935	1972	2355	finally
    //   2013	2021	2355	finally
    //   2067	2088	2355	finally
    //   2125	2144	2355	finally
    //   2193	2200	2355	finally
    //   2257	2278	2355	finally
    //   2317	2336	2355	finally
    //   988	1004	2457	finally
    //   136	147	2468	java/lang/Throwable
    //   166	192	2468	java/lang/Throwable
    //   211	223	2468	java/lang/Throwable
    //   514	537	2492	java/lang/Throwable
    //   561	569	2492	java/lang/Throwable
    //   588	594	2492	java/lang/Throwable
    //   613	624	2492	java/lang/Throwable
    //   652	659	2492	java/lang/Throwable
    //   2193	2200	2514	java/lang/Throwable
    //   988	1004	2549	java/lang/Throwable
  }
  
  public String getChoosedIP()
  {
    return PicIPManager.a(0);
  }
  
  public String getChoosedStrangerGroupIp()
  {
    return PicIPManager.a(1);
  }
  
  public Object[] getFaceSetting(QQHeadInfo paramQQHeadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
    Setting localSetting2 = localIQQAvatarDataService.getQQHeadSettingFromDB(paramString2);
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
        break label334;
      }
      if (localSetting1.bHeadType == paramQQHeadInfo.cHeadType) {
        break label278;
      }
      paramBoolean = true;
      label125:
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
              paramString1 = new File(localIQQAvatarDataService.getCustomFaceFilePath(localSetting1.bUsrType, paramString1, paramQQHeadInfo.idType));
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
    label278:
    label334:
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
          break label125;
        }
        paramBoolean = false;
        break label125;
      }
      if (localSetting1.headImgTimestamp != paramQQHeadInfo.dwTimestamp)
      {
        paramBoolean = true;
        break label125;
      }
      paramBoolean = false;
      break label125;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */