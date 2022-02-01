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
  private static final int[] TROOPS_SYSTEM_HEADS = { 2130840582, 2130851099, 2130851100, 2130851101 };
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
      if (paramQQHeadInfo.dstUsrType == 11)
      {
        this.avatarHandler.notifyUI(2, true, new Object[] { paramString1 });
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
  }
  
  private void removeCache(QQHeadInfo paramQQHeadInfo, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)this.app.getRuntimeService(IQQAvatarDataService.class, "");
      if (paramQQHeadInfo.dstUsrType == 4)
      {
        localIQQAvatarDataService.removeFaceIconCache(4, paramString, paramQQHeadInfo.idType);
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
  }
  
  private void removeFileCache(QQHeadInfo paramQQHeadInfo, String paramString)
  {
    if (paramQQHeadInfo.dstUsrType == 116) {
      ApolloUtil.a(this.app, paramQQHeadInfo.dstUsrType, paramString);
    }
  }
  
  private int setResultCodeByErrorCode(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 33)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5) {
            return 9207;
          }
          return 9204;
        }
        return 9202;
      }
      return 9208;
    }
    return 9206;
  }
  
  /* Error */
  private void writeTroopSystemHead(int paramInt, File paramFile)
  {
    // Byte code:
    //   0: iload_1
    //   1: iflt +13 -> 14
    //   4: iload_1
    //   5: istore_3
    //   6: iload_1
    //   7: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:TROOPS_SYSTEM_HEADS	[I
    //   10: arraylength
    //   11: if_icmplt +5 -> 16
    //   14: iconst_0
    //   15: istore_3
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: aload_0
    //   23: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   26: invokevirtual 159	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   29: invokevirtual 165	mqq/app/MobileQQ:getResources	()Landroid/content/res/Resources;
    //   32: getstatic 26	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:TROOPS_SYSTEM_HEADS	[I
    //   35: iload_3
    //   36: iaload
    //   37: invokevirtual 171	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   40: astore 4
    //   42: sipush 512
    //   45: newarray byte
    //   47: astore 6
    //   49: new 173	java/io/FileOutputStream
    //   52: dup
    //   53: aload_2
    //   54: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: astore_2
    //   58: aload 4
    //   60: aload 6
    //   62: invokevirtual 182	java/io/InputStream:read	([B)I
    //   65: istore_1
    //   66: iload_1
    //   67: ifle +14 -> 81
    //   70: aload_2
    //   71: aload 6
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual 186	java/io/FileOutputStream:write	([BII)V
    //   78: goto -20 -> 58
    //   81: aload_2
    //   82: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   85: aload 4
    //   87: ifnull +95 -> 182
    //   90: aload 4
    //   92: invokevirtual 190	java/io/InputStream:close	()V
    //   95: return
    //   96: astore 5
    //   98: goto +87 -> 185
    //   101: astore 5
    //   103: goto +19 -> 122
    //   106: astore 6
    //   108: aload 5
    //   110: astore_2
    //   111: aload 6
    //   113: astore 5
    //   115: goto +70 -> 185
    //   118: astore 5
    //   120: aconst_null
    //   121: astore_2
    //   122: goto +26 -> 148
    //   125: astore 6
    //   127: aconst_null
    //   128: astore 4
    //   130: aload 5
    //   132: astore_2
    //   133: aload 6
    //   135: astore 5
    //   137: goto +48 -> 185
    //   140: astore 5
    //   142: aconst_null
    //   143: astore_2
    //   144: aload 6
    //   146: astore 4
    //   148: invokestatic 196	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +13 -> 164
    //   154: ldc 8
    //   156: iconst_2
    //   157: ldc 198
    //   159: aload 5
    //   161: invokestatic 202	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: ifnull +7 -> 172
    //   168: aload_2
    //   169: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 190	java/io/InputStream:close	()V
    //   182: return
    //   183: astore 5
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 189	java/io/FileOutputStream:close	()V
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 190	java/io/InputStream:close	()V
    //   203: goto +6 -> 209
    //   206: aload 5
    //   208: athrow
    //   209: goto -3 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	QQHeadDownloadHandler
    //   0	212	1	paramInt	int
    //   0	212	2	paramFile	File
    //   5	31	3	i	int
    //   40	159	4	localObject1	Object
    //   17	1	5	localObject2	Object
    //   96	1	5	localObject3	Object
    //   101	8	5	localException1	java.lang.Exception
    //   113	1	5	localObject4	Object
    //   118	13	5	localException2	java.lang.Exception
    //   135	1	5	localObject5	Object
    //   140	20	5	localException3	java.lang.Exception
    //   183	24	5	localObject6	Object
    //   20	52	6	arrayOfByte	byte[]
    //   106	6	6	localObject7	Object
    //   125	20	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   58	66	96	finally
    //   70	78	96	finally
    //   58	66	101	java/lang/Exception
    //   70	78	101	java/lang/Exception
    //   42	58	106	finally
    //   42	58	118	java/lang/Exception
    //   22	42	125	finally
    //   22	42	140	java/lang/Exception
    //   148	164	183	finally
  }
  
  /* Error */
  protected void doDownloadFace(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 211	com/tencent/mobileqq/app/face/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   4: astore 16
    //   6: aload_0
    //   7: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:avatarHandler	Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;
    //   10: aload 16
    //   12: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   15: aload 16
    //   17: getfield 218	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   20: invokevirtual 221	com/tencent/mobileqq/avatar/handler/AvatarHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   23: astore 19
    //   25: aload_0
    //   26: getfield 55	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:avatarHandler	Lcom/tencent/mobileqq/avatar/handler/AvatarHandler;
    //   29: iconst_0
    //   30: aload 19
    //   32: aload 16
    //   34: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   37: iconst_3
    //   38: invokevirtual 224	com/tencent/mobileqq/avatar/handler/AvatarHandler:a	(ILjava/lang/String;II)V
    //   41: aload_1
    //   42: getstatic 227	com/tencent/mobileqq/app/face/FaceInfo:n	I
    //   45: invokevirtual 230	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   48: aload 16
    //   50: getfield 233	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   53: astore 13
    //   55: iconst_0
    //   56: istore 5
    //   58: iconst_0
    //   59: istore 7
    //   61: iconst_0
    //   62: istore 6
    //   64: iconst_0
    //   65: istore_3
    //   66: aload 16
    //   68: getfield 233	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   71: astore 14
    //   73: aload 14
    //   75: invokestatic 239	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: istore 8
    //   80: iload 8
    //   82: ifne +1138 -> 1220
    //   85: aload_0
    //   86: aload 16
    //   88: aload 19
    //   90: aload 16
    //   92: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   95: aload 19
    //   97: aload 16
    //   99: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   102: invokestatic 244	com/tencent/mobileqq/avatar/utils/AvatarUtil:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   105: iconst_0
    //   106: invokevirtual 248	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getFaceSetting	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;Z)[Ljava/lang/Object;
    //   109: astore 14
    //   111: aload 14
    //   113: iconst_0
    //   114: aaload
    //   115: checkcast 99	java/lang/Boolean
    //   118: invokevirtual 251	java/lang/Boolean:booleanValue	()Z
    //   121: istore 9
    //   123: aload 14
    //   125: iconst_1
    //   126: aaload
    //   127: checkcast 253	com/tencent/mobileqq/data/Setting
    //   130: astore 20
    //   132: iload 9
    //   134: ifeq +18 -> 152
    //   137: aload_0
    //   138: aload 16
    //   140: aload 19
    //   142: invokespecial 255	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeFileCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;)V
    //   145: goto +7 -> 152
    //   148: astore_1
    //   149: goto +1055 -> 1204
    //   152: aload_0
    //   153: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   156: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   159: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   162: invokestatic 270	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;)Z
    //   165: istore 8
    //   167: iload 8
    //   169: ifeq +92 -> 261
    //   172: invokestatic 274	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   175: ifeq +86 -> 261
    //   178: getstatic 33	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:syncCopyQQHeadLock	Ljava/lang/Object;
    //   181: astore 14
    //   183: aload 14
    //   185: monitorenter
    //   186: aload_0
    //   187: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   190: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   193: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   196: invokestatic 270	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;)Z
    //   199: ifeq +34 -> 233
    //   202: invokestatic 274	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   205: istore 8
    //   207: iload 8
    //   209: ifeq +24 -> 233
    //   212: ldc_w 276
    //   215: getstatic 281	com/tencent/mobileqq/app/AppConstants:PATH_CUSTOM_HEAD_ROOT_SDCARD	Ljava/lang/String;
    //   218: iconst_1
    //   219: invokestatic 287	com/tencent/mobileqq/utils/FileUtils:copyDirectory	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   222: pop
    //   223: goto +10 -> 233
    //   226: astore 15
    //   228: aload 15
    //   230: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   233: aload_0
    //   234: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   237: invokevirtual 259	com/tencent/common/app/AppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   240: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   243: iconst_0
    //   244: invokestatic 293	com/tencent/mobileqq/app/face/util/FaceUtil:a	(Landroid/content/Context;Z)V
    //   247: aload 14
    //   249: monitorexit
    //   250: goto +11 -> 261
    //   253: astore 15
    //   255: aload 14
    //   257: monitorexit
    //   258: aload 15
    //   260: athrow
    //   261: aload_0
    //   262: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   265: ldc 134
    //   267: ldc 77
    //   269: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   272: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   275: aload 20
    //   277: aload 16
    //   279: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   282: aload 16
    //   284: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   287: invokeinterface 297 4 0
    //   292: astore 14
    //   294: new 299	java/io/File
    //   297: dup
    //   298: aload 14
    //   300: iconst_0
    //   301: aload 14
    //   303: ldc_w 301
    //   306: invokevirtual 305	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   309: invokevirtual 309	java/lang/String:substring	(II)Ljava/lang/String;
    //   312: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: astore 15
    //   317: aload 15
    //   319: invokevirtual 315	java/io/File:exists	()Z
    //   322: ifne +9 -> 331
    //   325: aload 15
    //   327: invokevirtual 318	java/io/File:mkdirs	()Z
    //   330: pop
    //   331: new 299	java/io/File
    //   334: dup
    //   335: aload 14
    //   337: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   340: astore 21
    //   342: iload 9
    //   344: istore 8
    //   346: iload 9
    //   348: ifne +16 -> 364
    //   351: aload 21
    //   353: invokevirtual 315	java/io/File:exists	()Z
    //   356: istore 8
    //   358: iload 8
    //   360: iconst_1
    //   361: ixor
    //   362: istore 8
    //   364: iload 8
    //   366: ifeq +597 -> 963
    //   369: aload_0
    //   370: aload_1
    //   371: iconst_0
    //   372: invokevirtual 322	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   375: astore 15
    //   377: aload 16
    //   379: getfield 325	AvatarInfo/QQHeadInfo:cHeadType	B
    //   382: ifne +73 -> 455
    //   385: aload 16
    //   387: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   390: istore_2
    //   391: iload_2
    //   392: iconst_4
    //   393: if_icmpne +62 -> 455
    //   396: aload 21
    //   398: invokevirtual 315	java/io/File:exists	()Z
    //   401: ifne +14 -> 415
    //   404: aload_0
    //   405: aload 16
    //   407: getfield 329	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   410: aload 21
    //   412: invokespecial 331	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:writeTroopSystemHead	(ILjava/io/File;)V
    //   415: aload 15
    //   417: astore 13
    //   419: iconst_1
    //   420: istore 9
    //   422: iconst_0
    //   423: istore_2
    //   424: iconst_0
    //   425: istore 4
    //   427: iload 7
    //   429: istore 5
    //   431: goto +409 -> 840
    //   434: aload 15
    //   436: astore 13
    //   438: iconst_0
    //   439: istore 9
    //   441: iconst_0
    //   442: istore_2
    //   443: sipush 9202
    //   446: istore 4
    //   448: iload 7
    //   450: istore 5
    //   452: goto +388 -> 840
    //   455: aload_0
    //   456: aload 15
    //   458: aload 21
    //   460: aload_1
    //   461: iconst_0
    //   462: invokevirtual 335	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   465: istore_2
    //   466: iload_2
    //   467: ifeq +1421 -> 1888
    //   470: aload 15
    //   472: astore 17
    //   474: aload 15
    //   476: astore 18
    //   478: iconst_1
    //   479: invokestatic 341	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getActiveNetIpFamily	(Z)I
    //   482: iconst_3
    //   483: if_icmpne +1405 -> 1888
    //   486: aload 15
    //   488: astore 17
    //   490: aload 15
    //   492: astore 18
    //   494: aload_0
    //   495: aload_1
    //   496: iconst_1
    //   497: invokevirtual 322	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:getQQHeadDownloadUrl	(Lcom/tencent/mobileqq/app/face/FaceInfo;Z)Ljava/lang/String;
    //   500: astore 13
    //   502: aload 13
    //   504: astore 17
    //   506: aload 13
    //   508: astore 18
    //   510: aload_0
    //   511: aload 13
    //   513: aload 21
    //   515: aload_1
    //   516: iconst_0
    //   517: invokevirtual 335	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:downloadData	(Ljava/lang/String;Ljava/io/File;Lcom/tencent/mobileqq/app/face/FaceInfo;Z)I
    //   520: istore 5
    //   522: aload 13
    //   524: astore 15
    //   526: iload 5
    //   528: istore_3
    //   529: aload 13
    //   531: astore 17
    //   533: iload 5
    //   535: istore 4
    //   537: new 343	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   544: astore 18
    //   546: aload 13
    //   548: astore 15
    //   550: iload 5
    //   552: istore_3
    //   553: aload 13
    //   555: astore 17
    //   557: iload 5
    //   559: istore 4
    //   561: aload 18
    //   563: ldc_w 346
    //   566: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 13
    //   572: astore 15
    //   574: iload 5
    //   576: istore_3
    //   577: aload 13
    //   579: astore 17
    //   581: iload 5
    //   583: istore 4
    //   585: aload 18
    //   587: aload 13
    //   589: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload 13
    //   595: astore 15
    //   597: iload 5
    //   599: istore_3
    //   600: aload 13
    //   602: astore 17
    //   604: iload 5
    //   606: istore 4
    //   608: aload 18
    //   610: ldc_w 352
    //   613: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: pop
    //   617: aload 13
    //   619: astore 15
    //   621: iload 5
    //   623: istore_3
    //   624: aload 13
    //   626: astore 17
    //   628: iload 5
    //   630: istore 4
    //   632: aload 18
    //   634: iload 5
    //   636: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: pop
    //   640: aload 13
    //   642: astore 15
    //   644: iload 5
    //   646: istore_3
    //   647: aload 13
    //   649: astore 17
    //   651: iload 5
    //   653: istore 4
    //   655: ldc 8
    //   657: iconst_1
    //   658: aload 18
    //   660: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: iload 5
    //   668: istore_2
    //   669: goto +3 -> 672
    //   672: iload_2
    //   673: ifne +139 -> 812
    //   676: aload 13
    //   678: astore 15
    //   680: iload_2
    //   681: istore_3
    //   682: aload 13
    //   684: astore 17
    //   686: iload_2
    //   687: istore 4
    //   689: aload 21
    //   691: invokevirtual 366	java/io/File:length	()J
    //   694: lstore 11
    //   696: lload 11
    //   698: l2i
    //   699: istore_3
    //   700: aload_0
    //   701: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   704: ldc 134
    //   706: ldc 77
    //   708: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   711: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   714: aload 20
    //   716: invokeinterface 370 2 0
    //   721: aload_0
    //   722: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   725: new 372	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   728: dup
    //   729: aload_0
    //   730: aload 20
    //   732: aload_1
    //   733: invokespecial 375	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   736: invokevirtual 379	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   739: pop
    //   740: iload_2
    //   741: istore 6
    //   743: iconst_0
    //   744: istore_2
    //   745: iconst_0
    //   746: istore 4
    //   748: iconst_1
    //   749: istore 9
    //   751: iload_3
    //   752: istore 5
    //   754: iload 6
    //   756: istore_3
    //   757: goto +83 -> 840
    //   760: astore_1
    //   761: iconst_1
    //   762: istore 8
    //   764: iload_3
    //   765: istore 4
    //   767: goto +149 -> 916
    //   770: iconst_1
    //   771: istore 9
    //   773: goto +15 -> 788
    //   776: aload 17
    //   778: astore 13
    //   780: iconst_0
    //   781: istore_3
    //   782: iconst_0
    //   783: istore 9
    //   785: iload 4
    //   787: istore_2
    //   788: iload 8
    //   790: istore 10
    //   792: iconst_0
    //   793: istore 5
    //   795: iload_2
    //   796: istore 4
    //   798: iload 9
    //   800: istore 8
    //   802: iload 5
    //   804: istore_2
    //   805: iload 10
    //   807: istore 9
    //   809: goto +678 -> 1487
    //   812: aload 13
    //   814: astore 15
    //   816: iload_2
    //   817: istore_3
    //   818: aload_0
    //   819: iload_2
    //   820: invokespecial 381	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:setResultCodeByErrorCode	(I)I
    //   823: istore 4
    //   825: iload_2
    //   826: istore 6
    //   828: iconst_0
    //   829: istore 9
    //   831: iload_2
    //   832: istore_3
    //   833: iload 7
    //   835: istore 5
    //   837: iload 6
    //   839: istore_2
    //   840: aload_0
    //   841: aload 16
    //   843: aload 19
    //   845: iload 9
    //   847: invokespecial 383	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:removeCache	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Z)V
    //   850: iload 5
    //   852: istore 6
    //   854: iload_2
    //   855: istore 5
    //   857: iload_3
    //   858: istore_2
    //   859: iload 6
    //   861: istore_3
    //   862: goto +154 -> 1016
    //   865: astore_1
    //   866: iload 4
    //   868: istore_2
    //   869: iload 9
    //   871: istore 8
    //   873: iload_3
    //   874: istore 4
    //   876: iload 5
    //   878: istore_3
    //   879: goto +498 -> 1377
    //   882: iload_3
    //   883: istore 4
    //   885: iload 8
    //   887: istore 10
    //   889: iload 9
    //   891: istore 8
    //   893: iload 5
    //   895: istore_3
    //   896: iload 10
    //   898: istore 9
    //   900: goto +587 -> 1487
    //   903: astore_1
    //   904: aload 15
    //   906: astore 13
    //   908: iconst_0
    //   909: istore 4
    //   911: iconst_0
    //   912: istore 8
    //   914: iload_3
    //   915: istore_2
    //   916: iconst_0
    //   917: istore_3
    //   918: iload_2
    //   919: istore 5
    //   921: iload_3
    //   922: istore_2
    //   923: iload 4
    //   925: istore_3
    //   926: iload 5
    //   928: istore 4
    //   930: goto +447 -> 1377
    //   933: iload 8
    //   935: istore 9
    //   937: iconst_0
    //   938: istore_3
    //   939: iconst_0
    //   940: istore 8
    //   942: iload_2
    //   943: istore 4
    //   945: goto +542 -> 1487
    //   948: astore_1
    //   949: aload 15
    //   951: astore 13
    //   953: goto +251 -> 1204
    //   956: aload 15
    //   958: astore 13
    //   960: goto +132 -> 1092
    //   963: aload_0
    //   964: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   967: ldc 134
    //   969: ldc 77
    //   971: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   974: checkcast 134	com/tencent/mobileqq/avatar/api/IQQAvatarDataService
    //   977: aload 20
    //   979: invokeinterface 370 2 0
    //   984: aload_0
    //   985: getfield 51	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:mSubhandler	Lmqq/os/MqqHandler;
    //   988: new 372	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable
    //   991: dup
    //   992: aload_0
    //   993: aload 20
    //   995: aload_1
    //   996: invokespecial 375	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$UpdateSettingRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;Lcom/tencent/mobileqq/data/Setting;Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   999: invokevirtual 379	mqq/os/MqqHandler:postAtFrontOfQueue	(Ljava/lang/Runnable;)Z
    //   1002: pop
    //   1003: iconst_0
    //   1004: istore 9
    //   1006: iconst_0
    //   1007: istore 5
    //   1009: iconst_0
    //   1010: istore_2
    //   1011: iconst_0
    //   1012: istore_3
    //   1013: iconst_0
    //   1014: istore 4
    //   1016: aload_0
    //   1017: aload 16
    //   1019: aload 19
    //   1021: aload 14
    //   1023: iload 8
    //   1025: iload 9
    //   1027: aload 13
    //   1029: invokespecial 385	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:notifyDownloadHeadComplete	(LAvatarInfo/QQHeadInfo;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;)V
    //   1032: aload 14
    //   1034: astore 15
    //   1036: aload 13
    //   1038: astore 14
    //   1040: iload_2
    //   1041: istore 6
    //   1043: iload 5
    //   1045: istore_2
    //   1046: aload 15
    //   1048: astore 13
    //   1050: goto +191 -> 1241
    //   1053: astore_1
    //   1054: iload 4
    //   1056: istore 5
    //   1058: iload_2
    //   1059: istore 4
    //   1061: iload 9
    //   1063: istore 8
    //   1065: iload 5
    //   1067: istore_2
    //   1068: goto +309 -> 1377
    //   1071: iload 8
    //   1073: istore 10
    //   1075: iload 9
    //   1077: istore 8
    //   1079: iload_2
    //   1080: istore 4
    //   1082: iload 5
    //   1084: istore_2
    //   1085: iload 10
    //   1087: istore 9
    //   1089: goto +398 -> 1487
    //   1092: iload 8
    //   1094: istore 9
    //   1096: goto +94 -> 1190
    //   1099: goto +91 -> 1190
    //   1102: new 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1105: dup
    //   1106: aload_0
    //   1107: sipush 9202
    //   1110: aload 19
    //   1112: aload 16
    //   1114: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1117: aload 16
    //   1119: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1122: aload 16
    //   1124: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1127: iconst_4
    //   1128: iconst_0
    //   1129: aload 13
    //   1131: iconst_0
    //   1132: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   1135: invokespecial 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1138: aconst_null
    //   1139: iconst_0
    //   1140: invokestatic 399	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1143: aload_0
    //   1144: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1147: ldc_w 401
    //   1150: ldc 77
    //   1152: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1155: checkcast 401	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1158: astore_1
    //   1159: aload_1
    //   1160: ifnull +26 -> 1186
    //   1163: aload_1
    //   1164: invokeinterface 404 1 0
    //   1169: ifeq +17 -> 1186
    //   1172: aload_1
    //   1173: aload 16
    //   1175: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1178: invokestatic 407	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1181: invokeinterface 410 2 0
    //   1186: return
    //   1187: aconst_null
    //   1188: astore 14
    //   1190: iconst_0
    //   1191: istore_3
    //   1192: iconst_0
    //   1193: istore 4
    //   1195: iconst_0
    //   1196: istore 8
    //   1198: iconst_0
    //   1199: istore_2
    //   1200: goto +287 -> 1487
    //   1203: astore_1
    //   1204: iconst_0
    //   1205: istore_2
    //   1206: iconst_0
    //   1207: istore_3
    //   1208: iconst_0
    //   1209: istore 8
    //   1211: iconst_0
    //   1212: istore 4
    //   1214: goto +163 -> 1377
    //   1217: goto +254 -> 1471
    //   1220: aload 13
    //   1222: astore 14
    //   1224: aconst_null
    //   1225: astore 13
    //   1227: iconst_0
    //   1228: istore 9
    //   1230: iconst_0
    //   1231: istore_2
    //   1232: iconst_0
    //   1233: istore 4
    //   1235: iconst_0
    //   1236: istore 8
    //   1238: iload 5
    //   1240: istore_3
    //   1241: new 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1244: dup
    //   1245: aload_0
    //   1246: iload 4
    //   1248: aload 19
    //   1250: aload 16
    //   1252: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1255: aload 16
    //   1257: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1260: aload 16
    //   1262: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1265: iconst_4
    //   1266: iload_3
    //   1267: aload 14
    //   1269: iload 6
    //   1271: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   1274: invokespecial 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1277: aconst_null
    //   1278: iconst_0
    //   1279: invokestatic 399	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1282: aload_0
    //   1283: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1286: ldc_w 401
    //   1289: ldc 77
    //   1291: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1294: checkcast 401	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1297: astore 15
    //   1299: iload 9
    //   1301: ifne +36 -> 1337
    //   1304: aload 15
    //   1306: ifnull +31 -> 1337
    //   1309: aload 15
    //   1311: invokeinterface 404 1 0
    //   1316: ifeq +21 -> 1337
    //   1319: aload 15
    //   1321: aload 16
    //   1323: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1326: invokestatic 407	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1329: invokeinterface 410 2 0
    //   1334: goto +3 -> 1337
    //   1337: iload 4
    //   1339: istore_3
    //   1340: iload 8
    //   1342: istore 10
    //   1344: goto +264 -> 1608
    //   1347: aconst_null
    //   1348: astore 14
    //   1350: iconst_0
    //   1351: istore_3
    //   1352: iconst_0
    //   1353: istore 4
    //   1355: iconst_0
    //   1356: istore 8
    //   1358: iconst_0
    //   1359: istore_2
    //   1360: iconst_0
    //   1361: istore 9
    //   1363: goto +124 -> 1487
    //   1366: astore_1
    //   1367: iconst_0
    //   1368: istore_2
    //   1369: iconst_0
    //   1370: istore_3
    //   1371: iconst_0
    //   1372: istore 4
    //   1374: iconst_0
    //   1375: istore 8
    //   1377: new 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1380: dup
    //   1381: aload_0
    //   1382: iload_2
    //   1383: aload 19
    //   1385: aload 16
    //   1387: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1390: aload 16
    //   1392: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1395: aload 16
    //   1397: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1400: iconst_4
    //   1401: iload_3
    //   1402: aload 13
    //   1404: iload 4
    //   1406: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   1409: invokespecial 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1412: aconst_null
    //   1413: iconst_0
    //   1414: invokestatic 399	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1417: aload_0
    //   1418: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1421: ldc_w 401
    //   1424: ldc 77
    //   1426: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1429: checkcast 401	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1432: astore 13
    //   1434: iload 8
    //   1436: ifne +33 -> 1469
    //   1439: aload 13
    //   1441: ifnull +28 -> 1469
    //   1444: aload 13
    //   1446: invokeinterface 404 1 0
    //   1451: ifeq +18 -> 1469
    //   1454: aload 13
    //   1456: aload 16
    //   1458: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1461: invokestatic 407	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1464: invokeinterface 410 2 0
    //   1469: aload_1
    //   1470: athrow
    //   1471: aconst_null
    //   1472: astore 14
    //   1474: iconst_0
    //   1475: istore_3
    //   1476: iconst_0
    //   1477: istore 4
    //   1479: iconst_0
    //   1480: istore 8
    //   1482: iconst_0
    //   1483: istore_2
    //   1484: iconst_0
    //   1485: istore 9
    //   1487: new 387	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable
    //   1490: dup
    //   1491: aload_0
    //   1492: sipush 9204
    //   1495: aload 19
    //   1497: aload 16
    //   1499: getfield 91	AvatarInfo/QQHeadInfo:idType	I
    //   1502: aload 16
    //   1504: getfield 105	AvatarInfo/QQHeadInfo:sizeType	I
    //   1507: aload 16
    //   1509: getfield 67	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1512: iconst_4
    //   1513: iload_3
    //   1514: aload 13
    //   1516: iload 4
    //   1518: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   1521: invokespecial 395	com/tencent/mobileqq/app/face/QQHeadDownloadHandler$HeadCostStatRunnable:<init>	(Lcom/tencent/mobileqq/app/face/QQHeadDownloadHandler;ILjava/lang/String;IIIIILjava/lang/String;IJ)V
    //   1524: aconst_null
    //   1525: iconst_0
    //   1526: invokestatic 399	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1529: aload_0
    //   1530: getfield 53	com/tencent/mobileqq/app/face/QQHeadDownloadHandler:app	Lcom/tencent/common/app/AppInterface;
    //   1533: ldc_w 401
    //   1536: ldc 77
    //   1538: invokevirtual 83	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1541: checkcast 401	com/tencent/mobileqq/avatar/api/IQQClassicAvatarService
    //   1544: astore 15
    //   1546: iload 8
    //   1548: ifne +36 -> 1584
    //   1551: aload 15
    //   1553: ifnull +31 -> 1584
    //   1556: aload 15
    //   1558: invokeinterface 404 1 0
    //   1563: ifeq +21 -> 1584
    //   1566: aload 15
    //   1568: aload 16
    //   1570: getfield 215	AvatarInfo/QQHeadInfo:uin	J
    //   1573: invokestatic 407	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1576: invokeinterface 410 2 0
    //   1581: goto +3 -> 1584
    //   1584: aload 14
    //   1586: astore 15
    //   1588: sipush 9204
    //   1591: istore_3
    //   1592: aload 13
    //   1594: astore 14
    //   1596: aload 15
    //   1598: astore 13
    //   1600: iload 9
    //   1602: istore 10
    //   1604: iload 8
    //   1606: istore 9
    //   1608: new 343	java/lang/StringBuilder
    //   1611: dup
    //   1612: invokespecial 344	java/lang/StringBuilder:<init>	()V
    //   1615: astore 15
    //   1617: aload 15
    //   1619: ldc_w 412
    //   1622: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: pop
    //   1626: aload 15
    //   1628: iload 9
    //   1630: invokevirtual 415	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1633: pop
    //   1634: aload 15
    //   1636: ldc_w 417
    //   1639: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: aload 15
    //   1645: iload_3
    //   1646: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1649: pop
    //   1650: aload 15
    //   1652: ldc_w 419
    //   1655: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 15
    //   1661: iload 10
    //   1663: invokevirtual 415	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1666: pop
    //   1667: aload 15
    //   1669: ldc_w 421
    //   1672: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: pop
    //   1676: aload 15
    //   1678: iload_2
    //   1679: invokevirtual 355	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1682: pop
    //   1683: aload 15
    //   1685: ldc_w 423
    //   1688: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1691: pop
    //   1692: aload 15
    //   1694: aload_1
    //   1695: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1698: pop
    //   1699: aload 15
    //   1701: ldc_w 428
    //   1704: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: pop
    //   1708: aload 15
    //   1710: aload 16
    //   1712: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: aload 15
    //   1718: ldc_w 430
    //   1721: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: aload 15
    //   1727: aload 13
    //   1729: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1732: pop
    //   1733: aload 15
    //   1735: ldc_w 432
    //   1738: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1741: pop
    //   1742: aload 15
    //   1744: aload 14
    //   1746: invokevirtual 350	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1749: pop
    //   1750: ldc 8
    //   1752: iconst_1
    //   1753: aload 15
    //   1755: invokevirtual 358	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1758: invokestatic 362	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1761: return
    //   1762: astore 14
    //   1764: goto -293 -> 1471
    //   1767: astore 14
    //   1769: goto -422 -> 1347
    //   1772: astore 14
    //   1774: goto -557 -> 1217
    //   1777: astore 14
    //   1779: goto -592 -> 1187
    //   1782: astore 14
    //   1784: goto -597 -> 1187
    //   1787: astore_1
    //   1788: goto -686 -> 1102
    //   1791: astore 15
    //   1793: goto -694 -> 1099
    //   1796: astore 15
    //   1798: goto -706 -> 1092
    //   1801: astore 13
    //   1803: goto -847 -> 956
    //   1806: astore 13
    //   1808: goto -1374 -> 434
    //   1811: astore 13
    //   1813: goto +50 -> 1863
    //   1816: astore 13
    //   1818: goto -1042 -> 776
    //   1821: astore 15
    //   1823: goto -1053 -> 770
    //   1826: astore 15
    //   1828: goto -895 -> 933
    //   1831: astore 15
    //   1833: goto -951 -> 882
    //   1836: astore 15
    //   1838: goto -767 -> 1071
    //   1841: astore_1
    //   1842: aload 18
    //   1844: astore 13
    //   1846: iconst_0
    //   1847: istore 5
    //   1849: iconst_0
    //   1850: istore_3
    //   1851: iconst_0
    //   1852: istore 8
    //   1854: iload_2
    //   1855: istore 4
    //   1857: iload 5
    //   1859: istore_2
    //   1860: goto -483 -> 1377
    //   1863: aload 17
    //   1865: astore 13
    //   1867: iload 8
    //   1869: istore 9
    //   1871: iconst_0
    //   1872: istore_3
    //   1873: iconst_0
    //   1874: istore 8
    //   1876: iconst_0
    //   1877: istore 5
    //   1879: iload_2
    //   1880: istore 4
    //   1882: iload 5
    //   1884: istore_2
    //   1885: goto -398 -> 1487
    //   1888: aload 15
    //   1890: astore 13
    //   1892: goto -1220 -> 672
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1895	0	this	QQHeadDownloadHandler
    //   0	1895	1	paramFaceInfo	FaceInfo
    //   390	1495	2	i	int
    //   65	1808	3	j	int
    //   425	1456	4	k	int
    //   56	1827	5	m	int
    //   62	1208	6	n	int
    //   59	775	7	i1	int
    //   78	1797	8	bool1	boolean
    //   121	1749	9	bool2	boolean
    //   790	872	10	bool3	boolean
    //   694	3	11	l	long
    //   53	1675	13	localObject1	Object
    //   1801	1	13	localThrowable1	java.lang.Throwable
    //   1806	1	13	localException1	java.lang.Exception
    //   1811	1	13	localThrowable2	java.lang.Throwable
    //   1816	1	13	localThrowable3	java.lang.Throwable
    //   1844	47	13	localObject2	Object
    //   71	1674	14	localObject3	Object
    //   1762	1	14	localThrowable4	java.lang.Throwable
    //   1767	1	14	localThrowable5	java.lang.Throwable
    //   1772	1	14	localThrowable6	java.lang.Throwable
    //   1777	1	14	localThrowable7	java.lang.Throwable
    //   1782	1	14	localThrowable8	java.lang.Throwable
    //   226	3	15	localException2	java.lang.Exception
    //   253	6	15	localObject4	Object
    //   315	1439	15	localObject5	Object
    //   1791	1	15	localThrowable9	java.lang.Throwable
    //   1796	1	15	localThrowable10	java.lang.Throwable
    //   1821	1	15	localThrowable11	java.lang.Throwable
    //   1826	1	15	localThrowable12	java.lang.Throwable
    //   1831	1	15	localThrowable13	java.lang.Throwable
    //   1836	53	15	localThrowable14	java.lang.Throwable
    //   4	1707	16	localQQHeadInfo	QQHeadInfo
    //   472	1392	17	localObject6	Object
    //   476	1367	18	localObject7	Object
    //   23	1473	19	str	String
    //   130	864	20	localSetting	Setting
    //   340	350	21	localFile	File
    // Exception table:
    //   from	to	target	type
    //   137	145	148	finally
    //   172	186	148	finally
    //   258	261	148	finally
    //   261	294	148	finally
    //   294	331	148	finally
    //   331	342	148	finally
    //   351	358	148	finally
    //   369	377	148	finally
    //   963	1003	148	finally
    //   212	223	226	java/lang/Exception
    //   186	207	253	finally
    //   212	223	253	finally
    //   228	233	253	finally
    //   233	250	253	finally
    //   255	258	253	finally
    //   700	740	760	finally
    //   840	850	865	finally
    //   537	546	903	finally
    //   561	570	903	finally
    //   585	593	903	finally
    //   608	617	903	finally
    //   632	640	903	finally
    //   655	666	903	finally
    //   689	696	903	finally
    //   818	825	903	finally
    //   377	391	948	finally
    //   396	415	948	finally
    //   455	466	948	finally
    //   1016	1032	1053	finally
    //   85	123	1203	finally
    //   123	132	1203	finally
    //   152	167	1203	finally
    //   66	73	1366	finally
    //   73	80	1366	finally
    //   66	73	1762	java/lang/Throwable
    //   73	80	1767	java/lang/Throwable
    //   85	123	1772	java/lang/Throwable
    //   123	132	1777	java/lang/Throwable
    //   152	167	1777	java/lang/Throwable
    //   137	145	1782	java/lang/Throwable
    //   172	186	1782	java/lang/Throwable
    //   258	261	1782	java/lang/Throwable
    //   261	294	1782	java/lang/Throwable
    //   261	294	1787	java/lang/Exception
    //   294	331	1787	java/lang/Exception
    //   331	342	1787	java/lang/Exception
    //   351	358	1787	java/lang/Exception
    //   294	331	1791	java/lang/Throwable
    //   331	342	1791	java/lang/Throwable
    //   351	358	1791	java/lang/Throwable
    //   369	377	1796	java/lang/Throwable
    //   963	1003	1796	java/lang/Throwable
    //   377	391	1801	java/lang/Throwable
    //   396	415	1801	java/lang/Throwable
    //   455	466	1801	java/lang/Throwable
    //   396	415	1806	java/lang/Exception
    //   478	486	1811	java/lang/Throwable
    //   494	502	1811	java/lang/Throwable
    //   510	522	1811	java/lang/Throwable
    //   537	546	1816	java/lang/Throwable
    //   561	570	1816	java/lang/Throwable
    //   585	593	1816	java/lang/Throwable
    //   608	617	1816	java/lang/Throwable
    //   632	640	1816	java/lang/Throwable
    //   655	666	1816	java/lang/Throwable
    //   689	696	1816	java/lang/Throwable
    //   700	740	1821	java/lang/Throwable
    //   818	825	1826	java/lang/Throwable
    //   840	850	1831	java/lang/Throwable
    //   1016	1032	1836	java/lang/Throwable
    //   478	486	1841	finally
    //   494	502	1841	finally
    //   510	522	1841	finally
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
    if (paramQQHeadInfo.cHeadType == 0) {
      b = 0;
    } else {
      b = paramQQHeadInfo.headLevel;
    }
    localSetting1.bSourceType = b;
    boolean bool = paramBoolean;
    if (!paramBoolean)
    {
      if (localSetting1.bHeadType != paramQQHeadInfo.cHeadType) {
        paramBoolean = true;
      } else if (paramQQHeadInfo.cHeadType == 0 ? localSetting1.systemHeadID != paramQQHeadInfo.systemHeadID : localSetting1.headImgTimestamp != paramQQHeadInfo.dwTimestamp) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
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
              if (paramString1.exists())
              {
                paramString1.delete();
                bool = paramBoolean;
              }
            }
          }
        }
      }
    }
    localSetting1.bHeadType = paramQQHeadInfo.cHeadType;
    localSetting1.systemHeadID = paramQQHeadInfo.systemHeadID;
    localSetting1.headImgTimestamp = paramQQHeadInfo.dwTimestamp;
    return new Object[] { Boolean.valueOf(bool), localSetting1 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.QQHeadDownloadHandler
 * JD-Core Version:    0.7.0.1
 */