package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.IQQDynamicAvatarService;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;

public class NearByFaceDecodeTask
  extends FaceDecodeTask
{
  AppInterface a;
  
  public NearByFaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, DecodeCompletionListener paramDecodeCompletionListener)
  {
    super(paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
    this.a = paramAppInterface;
  }
  
  private void a(IQQAvatarManagerService paramIQQAvatarManagerService, BitmapManager.BitmapDecodeResult paramBitmapDecodeResult)
  {
    if (paramBitmapDecodeResult.a != null)
    {
      int i = this.faceInfo.e;
      if (i != 1) {
        if (i != 3) {
          paramBitmapDecodeResult.a = BaseImageUtil.c(paramBitmapDecodeResult.a, 50, 50);
        } else {
          paramBitmapDecodeResult.a = BaseImageUtil.a(paramBitmapDecodeResult.a, 50, 50);
        }
      }
      this.bitmap = paramBitmapDecodeResult.a;
      paramIQQAvatarManagerService.putFaceToCache(this.faceInfo.a(), paramBitmapDecodeResult.a, (byte)1);
    }
    if (this.bitmap == null)
    {
      paramIQQAvatarManagerService = new StringBuilder();
      paramIQQAvatarManagerService.append("doDecodeBitmap fail. uin=");
      paramIQQAvatarManagerService.append(this.faceInfo.c);
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, paramIQQAvatarManagerService.toString());
    }
  }
  
  private boolean a(IQQAvatarManagerService paramIQQAvatarManagerService)
  {
    if (this.needDownload)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doDecodeBitmap file not exist.. needDownload.faceInfo=");
        ((StringBuilder)localObject).append(this.faceInfo);
        QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, ((StringBuilder)localObject).toString());
      }
      if (this.faceInfo.p != null) {
        paramIQQAvatarManagerService.downloadFace(this.faceInfo);
      }
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("stranger_");
    ((StringBuilder)localObject).append(Integer.toString(this.faceInfo.d));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(this.faceInfo.c);
    localObject = ((StringBuilder)localObject).toString();
    Setting localSetting = paramIQQAvatarManagerService.getFaceSetting((String)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doDecodeBitmap key=");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(",faceinfo=");
      localStringBuilder.append(this.faceInfo);
      localStringBuilder.append(",setting=");
      localStringBuilder.append(localSetting);
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, localStringBuilder.toString());
    }
    if (localSetting != null)
    {
      if (this.faceInfo.p != null)
      {
        if (this.faceInfo.p.dwTimestamp > localSetting.headImgTimestamp)
        {
          this.needDownload = true;
          paramIQQAvatarManagerService.downloadFace(this.faceInfo);
          return true;
        }
        if ((this.faceInfo.a) && (((IQQDynamicAvatarService)this.a.getRuntimeService(IQQDynamicAvatarService.class, "nearby")).isNeed2UpdateSettingInfo(this.faceInfo, localSetting, this.faceInfo.b)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, "NearbyFaceDecodeTask isNeed2UpdateSettingInfo.");
          }
          this.needDownload = true;
          paramIQQAvatarManagerService.downloadFace(this.faceInfo);
          return true;
        }
      }
      else if (Math.abs(System.currentTimeMillis() - localSetting.updateTimestamp) > 86400000L)
      {
        if (QLog.isColorLevel())
        {
          paramIQQAvatarManagerService = new StringBuilder();
          paramIQQAvatarManagerService.append("doDecodeBitmap need to checkupdate.faceInfo=");
          paramIQQAvatarManagerService.append(this.faceInfo);
          QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, paramIQQAvatarManagerService.toString());
        }
        this.faceInfo.g = 1;
        ((FaceHandler)this.a.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).a(this.faceInfo);
      }
      return false;
    }
    this.needDownload = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDecodeBitmap setting is null. faceInfo=");
      ((StringBuilder)localObject).append(this.faceInfo);
      QLog.i("Q.qqhead.NearByFaceDecodeTask", 2, ((StringBuilder)localObject).toString());
    }
    if (this.faceInfo.p != null) {
      paramIQQAvatarManagerService.downloadFace(this.faceInfo);
    }
    return true;
  }
  
  /* Error */
  protected void doDecodeBitmap()
  {
    // Byte code:
    //   0: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +41 -> 44
    //   6: new 51	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 197
    //   19: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_0
    //   26: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   29: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: ldc 65
    //   35: iconst_2
    //   36: aload 4
    //   38: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aload_0
    //   45: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   48: getstatic 199	com/tencent/mobileqq/app/face/FaceInfo:B	I
    //   51: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   54: aload_0
    //   55: getfield 12	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:a	Lcom/tencent/common/app/AppInterface;
    //   58: ldc 45
    //   60: ldc 135
    //   62: invokevirtual 141	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   65: checkcast 45	com/tencent/mobileqq/avatar/api/IQQAvatarManagerService
    //   68: astore 4
    //   70: aload 4
    //   72: aload_0
    //   73: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   76: invokeinterface 206 2 0
    //   81: istore_3
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_3
    //   85: ifne +734 -> 819
    //   88: iconst_1
    //   89: istore_3
    //   90: goto +3 -> 93
    //   93: aload_0
    //   94: iload_3
    //   95: putfield 79	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:needDownload	Z
    //   98: aload_0
    //   99: aload 4
    //   101: invokespecial 208	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:a	(Lcom/tencent/mobileqq/avatar/api/IQQAvatarManagerService;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +97 -> 203
    //   109: aload_0
    //   110: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   113: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:C	I
    //   116: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   119: getstatic 215	com/tencent/mobileqq/app/face/FaceDecodeTask:sPendingResultList	Ljava/util/ArrayList;
    //   122: aload_0
    //   123: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   126: pop
    //   127: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   130: ifnull +72 -> 202
    //   133: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   136: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   139: getstatic 228	com/tencent/mobileqq/app/face/FaceDecodeTask:EVENT_TASK_COMPLETED	I
    //   142: aload_0
    //   143: invokevirtual 234	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   146: invokevirtual 238	mqq/os/MqqHandler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
    //   149: pop
    //   150: return
    //   151: astore 4
    //   153: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +46 -> 202
    //   159: new 51	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   166: astore 5
    //   168: aload 5
    //   170: ldc 240
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 5
    //   178: aload_0
    //   179: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   182: getfield 63	com/tencent/mobileqq/app/face/FaceInfo:c	Ljava/lang/String;
    //   185: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 65
    //   191: iconst_2
    //   192: aload 5
    //   194: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload 4
    //   199: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   202: return
    //   203: new 16	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult
    //   206: dup
    //   207: invokespecial 244	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:<init>	()V
    //   210: astore 5
    //   212: new 246	android/graphics/BitmapFactory$Options
    //   215: dup
    //   216: invokespecial 247	android/graphics/BitmapFactory$Options:<init>	()V
    //   219: astore 6
    //   221: aload 6
    //   223: getstatic 253	com/tencent/mobileqq/app/face/FaceConstant$HeadConfig:FACE_BITMAP_CONFIG	Landroid/graphics/Bitmap$Config;
    //   226: putfield 256	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   229: aload 4
    //   231: aload_0
    //   232: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   235: invokeinterface 260 2 0
    //   240: aload 6
    //   242: aload 5
    //   244: invokestatic 265	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;)V
    //   247: aload 5
    //   249: getfield 266	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   252: iconst_1
    //   253: if_icmpne +27 -> 280
    //   256: getstatic 271	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   259: ifnull +21 -> 280
    //   262: getstatic 271	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   265: invokevirtual 277	android/support/v4/util/MQLruCache:size	()I
    //   268: iconst_3
    //   269: imul
    //   270: iconst_4
    //   271: idiv
    //   272: istore_2
    //   273: getstatic 271	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   276: iload_2
    //   277: invokevirtual 280	android/support/v4/util/MQLruCache:trimToSize	(I)V
    //   280: iload_1
    //   281: iconst_1
    //   282: iadd
    //   283: istore_1
    //   284: iload_1
    //   285: iconst_2
    //   286: if_icmpge +12 -> 298
    //   289: aload 5
    //   291: getfield 266	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   294: iconst_1
    //   295: if_icmpeq -66 -> 229
    //   298: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifne +11 -> 312
    //   304: aload 5
    //   306: getfield 266	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   309: ifeq +82 -> 391
    //   312: new 51	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   319: astore 6
    //   321: aload 6
    //   323: ldc_w 282
    //   326: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 6
    //   332: aload_0
    //   333: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   336: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 6
    //   342: ldc_w 284
    //   345: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload 6
    //   351: aload 5
    //   353: getfield 266	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:b	I
    //   356: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload 6
    //   362: ldc_w 289
    //   365: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 6
    //   371: aload 5
    //   373: getfield 19	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   376: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: ldc 65
    //   382: iconst_1
    //   383: aload 6
    //   385: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 74	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_0
    //   392: aload 4
    //   394: aload 5
    //   396: invokespecial 291	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:a	(Lcom/tencent/mobileqq/avatar/api/IQQAvatarManagerService;Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;)V
    //   399: aload_0
    //   400: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   403: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:C	I
    //   406: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   409: getstatic 215	com/tencent/mobileqq/app/face/FaceDecodeTask:sPendingResultList	Ljava/util/ArrayList;
    //   412: aload_0
    //   413: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   416: pop
    //   417: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   420: ifnull +294 -> 714
    //   423: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   426: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   429: getstatic 228	com/tencent/mobileqq/app/face/FaceDecodeTask:EVENT_TASK_COMPLETED	I
    //   432: aload_0
    //   433: invokevirtual 234	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   436: invokevirtual 238	mqq/os/MqqHandler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
    //   439: pop
    //   440: return
    //   441: astore 4
    //   443: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +268 -> 714
    //   449: new 51	java/lang/StringBuilder
    //   452: dup
    //   453: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   456: astore 5
    //   458: aload 5
    //   460: ldc 240
    //   462: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload 5
    //   468: aload_0
    //   469: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   472: getfield 63	com/tencent/mobileqq/app/face/FaceInfo:c	Ljava/lang/String;
    //   475: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: ldc 65
    //   481: iconst_2
    //   482: aload 5
    //   484: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: aload 4
    //   489: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: return
    //   493: astore 4
    //   495: goto +220 -> 715
    //   498: astore 4
    //   500: new 51	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   507: astore 5
    //   509: aload 5
    //   511: ldc_w 293
    //   514: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 5
    //   520: aload_0
    //   521: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   524: getfield 63	com/tencent/mobileqq/app/face/FaceInfo:c	Ljava/lang/String;
    //   527: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: ldc 65
    //   533: iconst_1
    //   534: aload 5
    //   536: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: aload 4
    //   541: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   544: aload_0
    //   545: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   548: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:C	I
    //   551: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   554: getstatic 215	com/tencent/mobileqq/app/face/FaceDecodeTask:sPendingResultList	Ljava/util/ArrayList;
    //   557: aload_0
    //   558: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   561: pop
    //   562: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   565: ifnull +149 -> 714
    //   568: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   571: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   574: getstatic 228	com/tencent/mobileqq/app/face/FaceDecodeTask:EVENT_TASK_COMPLETED	I
    //   577: aload_0
    //   578: invokevirtual 234	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   581: invokevirtual 238	mqq/os/MqqHandler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
    //   584: pop
    //   585: return
    //   586: astore 4
    //   588: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +123 -> 714
    //   594: new 51	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   601: astore 5
    //   603: goto -145 -> 458
    //   606: astore 4
    //   608: new 51	java/lang/StringBuilder
    //   611: dup
    //   612: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   615: astore 5
    //   617: aload 5
    //   619: ldc_w 295
    //   622: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 5
    //   628: aload_0
    //   629: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   632: getfield 63	com/tencent/mobileqq/app/face/FaceInfo:c	Ljava/lang/String;
    //   635: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: ldc 65
    //   641: iconst_1
    //   642: aload 5
    //   644: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: aload 4
    //   649: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   652: aload_0
    //   653: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   656: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:C	I
    //   659: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   662: getstatic 215	com/tencent/mobileqq/app/face/FaceDecodeTask:sPendingResultList	Ljava/util/ArrayList;
    //   665: aload_0
    //   666: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   669: pop
    //   670: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   673: ifnull +41 -> 714
    //   676: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   679: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   682: getstatic 228	com/tencent/mobileqq/app/face/FaceDecodeTask:EVENT_TASK_COMPLETED	I
    //   685: aload_0
    //   686: invokevirtual 234	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   689: invokevirtual 238	mqq/os/MqqHandler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
    //   692: pop
    //   693: return
    //   694: astore 4
    //   696: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +15 -> 714
    //   702: new 51	java/lang/StringBuilder
    //   705: dup
    //   706: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   709: astore 5
    //   711: goto -253 -> 458
    //   714: return
    //   715: aload_0
    //   716: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   719: getstatic 211	com/tencent/mobileqq/app/face/FaceInfo:C	I
    //   722: invokevirtual 202	com/tencent/mobileqq/app/face/FaceInfo:a	(I)V
    //   725: getstatic 215	com/tencent/mobileqq/app/face/FaceDecodeTask:sPendingResultList	Ljava/util/ArrayList;
    //   728: aload_0
    //   729: invokevirtual 221	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   732: pop
    //   733: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   736: ifnull +74 -> 810
    //   739: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   742: getstatic 225	com/tencent/mobileqq/app/face/FaceDecodeTask:handler	Lmqq/os/MqqHandler;
    //   745: getstatic 228	com/tencent/mobileqq/app/face/FaceDecodeTask:EVENT_TASK_COMPLETED	I
    //   748: aload_0
    //   749: invokevirtual 234	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   752: invokevirtual 238	mqq/os/MqqHandler:sendMessageAtFrontOfQueue	(Landroid/os/Message;)Z
    //   755: pop
    //   756: goto +54 -> 810
    //   759: astore 5
    //   761: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   764: ifeq +46 -> 810
    //   767: new 51	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   774: astore 6
    //   776: aload 6
    //   778: ldc 240
    //   780: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload 6
    //   786: aload_0
    //   787: getfield 23	com/tencent/mobileqq/app/face/NearByFaceDecodeTask:faceInfo	Lcom/tencent/mobileqq/app/face/FaceInfo;
    //   790: getfield 63	com/tencent/mobileqq/app/face/FaceInfo:c	Ljava/lang/String;
    //   793: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: ldc 65
    //   799: iconst_2
    //   800: aload 6
    //   802: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: aload 5
    //   807: invokestatic 243	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   810: goto +6 -> 816
    //   813: aload 4
    //   815: athrow
    //   816: goto -3 -> 813
    //   819: iconst_0
    //   820: istore_3
    //   821: goto -728 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	824	0	this	NearByFaceDecodeTask
    //   83	204	1	i	int
    //   272	5	2	j	int
    //   81	740	3	bool	boolean
    //   13	87	4	localObject1	Object
    //   151	242	4	localException1	java.lang.Exception
    //   441	47	4	localException2	java.lang.Exception
    //   493	1	4	localObject2	Object
    //   498	42	4	localThrowable	java.lang.Throwable
    //   586	1	4	localException3	java.lang.Exception
    //   606	42	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   694	120	4	localException4	java.lang.Exception
    //   166	544	5	localObject3	Object
    //   759	47	5	localException5	java.lang.Exception
    //   219	582	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	150	151	java/lang/Exception
    //   409	440	441	java/lang/Exception
    //   54	82	493	finally
    //   93	105	493	finally
    //   203	229	493	finally
    //   229	280	493	finally
    //   289	298	493	finally
    //   298	312	493	finally
    //   312	391	493	finally
    //   391	399	493	finally
    //   500	544	493	finally
    //   608	652	493	finally
    //   54	82	498	java/lang/Throwable
    //   93	105	498	java/lang/Throwable
    //   203	229	498	java/lang/Throwable
    //   229	280	498	java/lang/Throwable
    //   289	298	498	java/lang/Throwable
    //   298	312	498	java/lang/Throwable
    //   312	391	498	java/lang/Throwable
    //   391	399	498	java/lang/Throwable
    //   554	585	586	java/lang/Exception
    //   54	82	606	java/lang/OutOfMemoryError
    //   93	105	606	java/lang/OutOfMemoryError
    //   203	229	606	java/lang/OutOfMemoryError
    //   229	280	606	java/lang/OutOfMemoryError
    //   289	298	606	java/lang/OutOfMemoryError
    //   298	312	606	java/lang/OutOfMemoryError
    //   312	391	606	java/lang/OutOfMemoryError
    //   391	399	606	java/lang/OutOfMemoryError
    //   662	693	694	java/lang/Exception
    //   725	756	759	java/lang/Exception
  }
  
  protected boolean isExpired()
  {
    return this.a == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */