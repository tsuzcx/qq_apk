package com.tencent.mobileqq.apollo.screenshot.api.impl;

import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoEncoder.OnEncodeFinishListener;
import com.tencent.mobileqq.apollo.screenshot.ApolloVideoUtils;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

@RequiresApi(api=21)
public class ApolloAvatarVideoProcessorImpl
  implements IApolloAvatarVideoProcessor
{
  private static final String COMPRESS_VIDEO_SUFFIX = "_compress.mp4";
  private static final int[] RESOLUTIONS_DEFAULT = { 640, 200, 100 };
  private static final int[] RESOLUTIONS_HIGH = { 640, 200, 176 };
  private static final String SUFFIX = ".mp4";
  private static final String TAG = "[cmshow]ApolloAvatarVideoProcessor";
  private static final int UPLOAD_DELAY = 0;
  private int mActionId;
  private int mActionType;
  private WeakReference<AppInterface> mAppRef;
  private IApolloAvatarVideoProcessor.OnProcessFinishListener mFinishListener;
  private volatile boolean mIsUploading = false;
  private ApolloAvatarVideoProcessorImpl.OnCompressFinishListener mOnCompressFinishListener = new ApolloAvatarVideoProcessorImpl.6(this);
  ApolloVideoEncoder.OnEncodeFinishListener mOnEncodeListener = new ApolloAvatarVideoProcessorImpl.5(this);
  private List<String> mPicList;
  private ApolloAvatarVideoProcessorImpl.VideoUploadProcessorHandler mUploadHandler;
  private int mUploadKey;
  private String mVideoCoverPath;
  private String mVideoDirPath;
  private String mVideoPathBig;
  private String mVideoPathMedium;
  private String mVideoPathSmall;
  
  private void compressWithResolution(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("compressWithResolution inputVideoPath: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", resolution: ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject).toString());
    localObject = (AppInterface)this.mAppRef.get();
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, "compressWithResolution exits due to app null");
      return;
    }
    if (!TextUtils.isEmpty(this.mVideoDirPath))
    {
      ThreadManager.getSubThreadHandler().post(new ApolloAvatarVideoProcessorImpl.7(this, paramInt, (AppInterface)localObject, paramString));
      return;
    }
    QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, "mVideoDirPath is empty");
  }
  
  private void doProcess(int paramInt1, int paramInt2)
  {
    reset();
    this.mActionId = paramInt1;
    this.mActionType = paramInt2;
    AppInterface localAppInterface = (AppInterface)this.mAppRef.get();
    if (localAppInterface == null)
    {
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, "process exits due to app null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("process ");
    localStringBuilder.append(paramInt1);
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, localStringBuilder.toString());
    ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getAllFrameFiles(paramInt1, paramInt2, localAppInterface.getCurrentUin(), getResolution(0), getResolution(0), new ApolloAvatarVideoProcessorImpl.3(this));
  }
  
  private void encodeWithResolution(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    Object localObject = this.mPicList;
    if ((localObject != null) && (!((List)localObject).isEmpty()) && (!TextUtils.isEmpty(this.mVideoDirPath)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.mVideoDirPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".mp4");
      localObject = ((StringBuilder)localObject).toString();
      localObject = new ApolloVideoEncoder(this.mPicList, (String)localObject, paramInt, paramInt);
      ((ApolloVideoEncoder)localObject).a(this.mOnEncodeListener);
      ((ApolloVideoEncoder)localObject).b();
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mPicList == null: ");
    ((StringBuilder)localObject).append(this.mPicList);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(null);
    localStringBuilder.append(" mPicList is empty: ");
    localStringBuilder.append(this.mPicList.isEmpty());
    localStringBuilder.append(" mVideoDirPath is empty: ");
    localStringBuilder.append(TextUtils.isEmpty(this.mVideoDirPath));
    boolean bool;
    if (localObject == localStringBuilder.toString()) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, new Object[] { Boolean.valueOf(bool) });
  }
  
  private int getResolution(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return RESOLUTIONS_HIGH[paramInt];
    }
    return RESOLUTIONS_DEFAULT[paramInt];
  }
  
  private String getVideoDirPath(int paramInt)
  {
    Object localObject = ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).getVideoFilePath(paramInt);
    if (localObject == null)
    {
      QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, "getVideoFilePath is null");
      return null;
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return ((File)localObject).getAbsolutePath();
  }
  
  private void onFinalUploadProcess(FileMsg paramFileMsg)
  {
    AppInterface localAppInterface = (AppInterface)this.mAppRef.get();
    if (localAppInterface == null) {
      return;
    }
    paramFileMsg = ((NearbyPeoplePhotoUploadProcessor)paramFileMsg.processor).mPhotoUrl;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFinalUploadProcess. photoId = ");
    localStringBuilder.append(paramFileMsg);
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, localStringBuilder.toString());
    paramFileMsg = (CardHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramFileMsg != null) {
      paramFileMsg.a(true, localAppInterface.getCurrentAccountUin(), 0);
    }
    FaceUtil.e(null);
    if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(localAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(localAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
    }
    paramFileMsg = this.mFinishListener;
    if (paramFileMsg != null) {
      paramFileMsg.a(true, this.mActionId);
    }
    this.mIsUploading = false;
  }
  
  private void onVideoFinished(int paramInt, String paramString)
  {
    int[] arrayOfInt = RESOLUTIONS_DEFAULT;
    if (paramInt == arrayOfInt[0])
    {
      this.mVideoPathBig = paramString;
      if (CmShowWnsUtils.A()) {
        compressWithResolution(this.mVideoPathBig, RESOLUTIONS_DEFAULT[1]);
      } else {
        encodeWithResolution(getResolution(1));
      }
    }
    else if (paramInt == arrayOfInt[1])
    {
      this.mVideoPathMedium = paramString;
      if (CmShowWnsUtils.A()) {
        compressWithResolution(this.mVideoPathBig, RESOLUTIONS_DEFAULT[2]);
      } else {
        encodeWithResolution(getResolution(2));
      }
    }
    else if ((paramInt == arrayOfInt[2]) || (paramInt == getResolution(2)))
    {
      this.mVideoPathSmall = paramString;
    }
    paramString = new StringBuilder();
    paramString.append("getVideoFinished paths = ");
    paramString.append(this.mVideoPathBig);
    paramString.append(", ");
    paramString.append(this.mVideoPathMedium);
    paramString.append(", ");
    paramString.append(this.mVideoPathSmall);
    paramString.append(", ");
    paramString.append(this.mVideoCoverPath);
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, paramString.toString());
    if ((!TextUtils.isEmpty(this.mVideoPathBig)) && (!TextUtils.isEmpty(this.mVideoPathMedium)) && (!TextUtils.isEmpty(this.mVideoPathSmall))) {
      ThreadManager.getSubThreadHandler().postDelayed(new ApolloAvatarVideoProcessorImpl.4(this), 0L);
    }
  }
  
  private void reset()
  {
    this.mActionId = 0;
    this.mActionType = 0;
    this.mUploadKey = 0;
    this.mVideoCoverPath = null;
    this.mVideoPathBig = null;
    this.mVideoPathMedium = null;
    this.mVideoPathSmall = null;
  }
  
  /* Error */
  private String saveCoverFromPicList(List<String> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 6
    //   13: aload_1
    //   14: ifnull +337 -> 351
    //   17: aload_1
    //   18: invokeinterface 272 1 0
    //   23: ifeq +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: ldc 22
    //   30: iconst_2
    //   31: ldc_w 419
    //   34: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: new 274	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 146	com/tencent/mobileqq/apollo/screenshot/api/impl/ApolloAvatarVideoProcessorImpl:mActionId	I
    //   46: invokespecial 164	com/tencent/mobileqq/apollo/screenshot/api/impl/ApolloAvatarVideoProcessorImpl:getVideoDirPath	(I)Ljava/lang/String;
    //   49: ldc_w 424
    //   52: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: astore 8
    //   57: new 429	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 430	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: getstatic 436	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   71: putfield 439	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   74: aload_1
    //   75: iconst_0
    //   76: invokeinterface 442 2 0
    //   81: checkcast 444	java/lang/String
    //   84: aload 5
    //   86: invokestatic 450	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: astore 5
    //   91: aload 7
    //   93: astore 4
    //   95: aload 5
    //   97: ifnull +164 -> 261
    //   100: aload 6
    //   102: astore_2
    //   103: aload 5
    //   105: sipush 480
    //   108: sipush 480
    //   111: iconst_1
    //   112: invokestatic 456	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +111 -> 230
    //   122: aload 4
    //   124: astore_2
    //   125: aload 4
    //   127: astore_3
    //   128: aload 4
    //   130: bipush 100
    //   132: aload 8
    //   134: invokestatic 461	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;ILjava/io/File;)Z
    //   137: pop
    //   138: aload 4
    //   140: astore_2
    //   141: aload 4
    //   143: astore_3
    //   144: aload 8
    //   146: invokevirtual 321	java/io/File:exists	()Z
    //   149: ifeq +70 -> 219
    //   152: aload 4
    //   154: astore_2
    //   155: aload 4
    //   157: astore_3
    //   158: aload 8
    //   160: invokevirtual 465	java/io/File:length	()J
    //   163: lconst_0
    //   164: lcmp
    //   165: ifle +54 -> 219
    //   168: aload 4
    //   170: astore_2
    //   171: aload 4
    //   173: astore_3
    //   174: ldc 22
    //   176: iconst_2
    //   177: ldc_w 467
    //   180: invokestatic 422	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: aload 4
    //   185: astore_2
    //   186: aload 4
    //   188: astore_3
    //   189: aload 8
    //   191: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   194: astore 6
    //   196: aload 5
    //   198: ifnull +8 -> 206
    //   201: aload 5
    //   203: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   206: aload 4
    //   208: ifnull +8 -> 216
    //   211: aload 4
    //   213: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   216: aload 6
    //   218: areturn
    //   219: aload 4
    //   221: astore_2
    //   222: aload 4
    //   224: astore_3
    //   225: aload 4
    //   227: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   230: aload 4
    //   232: astore_2
    //   233: aload 4
    //   235: astore_3
    //   236: aload 5
    //   238: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   241: goto +20 -> 261
    //   244: astore_1
    //   245: aload_2
    //   246: astore_3
    //   247: aload 5
    //   249: astore_2
    //   250: goto +83 -> 333
    //   253: astore 4
    //   255: aload 5
    //   257: astore_2
    //   258: goto +39 -> 297
    //   261: aload 5
    //   263: ifnull +8 -> 271
    //   266: aload 5
    //   268: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   271: aload 4
    //   273: ifnull +48 -> 321
    //   276: aload 4
    //   278: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   281: goto +40 -> 321
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_3
    //   287: aload 4
    //   289: astore_2
    //   290: goto +43 -> 333
    //   293: astore 4
    //   295: aconst_null
    //   296: astore_3
    //   297: aload 4
    //   299: invokevirtual 473	java/lang/Throwable:printStackTrace	()V
    //   302: invokestatic 478	java/lang/System:gc	()V
    //   305: aload_2
    //   306: ifnull +7 -> 313
    //   309: aload_2
    //   310: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   313: aload_3
    //   314: ifnull +7 -> 321
    //   317: aload_3
    //   318: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   321: aload_1
    //   322: iconst_0
    //   323: invokeinterface 442 2 0
    //   328: checkcast 444	java/lang/String
    //   331: areturn
    //   332: astore_1
    //   333: aload_2
    //   334: ifnull +7 -> 341
    //   337: aload_2
    //   338: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   341: aload_3
    //   342: ifnull +7 -> 349
    //   345: aload_3
    //   346: invokevirtual 470	android/graphics/Bitmap:recycle	()V
    //   349: aload_1
    //   350: athrow
    //   351: aconst_null
    //   352: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	ApolloAvatarVideoProcessorImpl
    //   0	353	1	paramList	List<String>
    //   6	332	2	localObject1	Object
    //   1	345	3	localObject2	Object
    //   8	226	4	localObject3	Object
    //   253	35	4	localThrowable1	java.lang.Throwable
    //   293	5	4	localThrowable2	java.lang.Throwable
    //   64	203	5	localObject4	Object
    //   11	206	6	str	String
    //   3	89	7	localObject5	Object
    //   55	135	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   103	117	244	finally
    //   128	138	244	finally
    //   144	152	244	finally
    //   158	168	244	finally
    //   174	183	244	finally
    //   189	196	244	finally
    //   225	230	244	finally
    //   236	241	244	finally
    //   103	117	253	java/lang/Throwable
    //   128	138	253	java/lang/Throwable
    //   144	152	253	java/lang/Throwable
    //   158	168	253	java/lang/Throwable
    //   174	183	253	java/lang/Throwable
    //   189	196	253	java/lang/Throwable
    //   225	230	253	java/lang/Throwable
    //   236	241	253	java/lang/Throwable
    //   57	91	284	finally
    //   57	91	293	java/lang/Throwable
    //   297	305	332	finally
  }
  
  private void startUpload()
  {
    QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, "startUpload");
    this.mIsUploading = true;
    uploadVideoBig();
  }
  
  private void uploadVideoBig()
  {
    Object localObject2 = (AppInterface)this.mAppRef.get();
    if (localObject2 == null) {
      return;
    }
    this.mUploadKey = ((int)(System.currentTimeMillis() / 1000L));
    if (TextUtils.isEmpty(this.mVideoPathBig))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mVideoPathBig is empty: ");
      ((StringBuilder)localObject1).append(this.mVideoPathBig);
      QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.mFinishListener;
      if (localObject1 != null) {
        ((IApolloAvatarVideoProcessor.OnProcessFinishListener)localObject1).a(false, this.mActionId);
      }
      return;
    }
    Object localObject1 = new File(this.mVideoPathBig);
    if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      ApolloVideoUtils.a((AppInterface)localObject2, this.mVideoPathBig, 36, this.mUploadKey, 640);
      FaceUtil.e(this.mVideoPathBig);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uploadVideoBig ");
      ((StringBuilder)localObject2).append(((File)localObject1).length());
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("uploadVideoBig file empty: ");
    ((StringBuilder)localObject1).append(this.mVideoPathBig);
    QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.mFinishListener;
    if (localObject1 != null) {
      ((IApolloAvatarVideoProcessor.OnProcessFinishListener)localObject1).a(false, this.mActionId);
    }
  }
  
  private void uploadVideoCover()
  {
    Object localObject = (AppInterface)this.mAppRef.get();
    if (localObject == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.mVideoCoverPath))
    {
      File localFile = new File(this.mVideoCoverPath);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        ApolloVideoUtils.a((AppInterface)localObject, this.mVideoCoverPath);
        FaceUtil.e(this.mVideoCoverPath);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("uploadVideoCover ");
        ((StringBuilder)localObject).append(localFile.length());
        QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void uploadVideoMedium()
  {
    Object localObject2 = (AppInterface)this.mAppRef.get();
    if (localObject2 == null) {
      return;
    }
    if (TextUtils.isEmpty(this.mVideoPathMedium))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mVideoPathMedium is empty: ");
      ((StringBuilder)localObject1).append(this.mVideoPathMedium);
      QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.mFinishListener;
      if (localObject1 != null) {
        ((IApolloAvatarVideoProcessor.OnProcessFinishListener)localObject1).a(false, this.mActionId);
      }
      return;
    }
    Object localObject1 = new File(this.mVideoPathMedium);
    if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      ApolloVideoUtils.a((AppInterface)localObject2, this.mVideoPathMedium, 37, this.mUploadKey, 200);
      FaceUtil.e(this.mVideoPathMedium);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uploadVideoMedium ");
      ((StringBuilder)localObject2).append(((File)localObject1).length());
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void uploadVideoSmall()
  {
    Object localObject2 = (AppInterface)this.mAppRef.get();
    if (localObject2 == null) {
      return;
    }
    if (TextUtils.isEmpty(this.mVideoPathSmall))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mVideoPathSmall is empty: ");
      ((StringBuilder)localObject1).append(this.mVideoPathSmall);
      QLog.e("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.mFinishListener;
      if (localObject1 != null) {
        ((IApolloAvatarVideoProcessor.OnProcessFinishListener)localObject1).a(false, this.mActionId);
      }
      return;
    }
    Object localObject1 = new File(this.mVideoPathSmall);
    if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      ApolloVideoUtils.a((AppInterface)localObject2, this.mVideoPathSmall, 38, this.mUploadKey, 100);
      FaceUtil.e(this.mVideoPathSmall);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("uploadVideoSmall ");
      ((StringBuilder)localObject2).append(((File)localObject1).length());
      QLog.i("[cmshow]ApolloAvatarVideoProcessor", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void init(AppInterface paramAppInterface)
  {
    this.mAppRef = new WeakReference(paramAppInterface);
    ThreadManager.getSubThreadHandler().post(new ApolloAvatarVideoProcessorImpl.1(this, paramAppInterface));
  }
  
  public void onDestroy()
  {
    AppInterface localAppInterface = (AppInterface)this.mAppRef.get();
    if ((this.mUploadHandler != null) && (localAppInterface != null))
    {
      ((ITransFileController)localAppInterface.getRuntimeService(ITransFileController.class, "all")).removeHandle(this.mUploadHandler);
      FaceUtil.e(null);
    }
  }
  
  public void process(int paramInt1, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().post(new ApolloAvatarVideoProcessorImpl.2(this, paramInt1, paramInt2));
  }
  
  public void setProcessFinishListener(IApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener)
  {
    this.mFinishListener = paramOnProcessFinishListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.impl.ApolloAvatarVideoProcessorImpl
 * JD-Core Version:    0.7.0.1
 */