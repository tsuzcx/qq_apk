package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.BitmapCache;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.CloseableBitmap;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSConfigManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeBeaconReportConfigInfo;
import com.tencent.biz.pubaccount.weishi_new.config.WeSeeConfigBean;
import com.tencent.biz.pubaccount.weishi_new.download.wsapp.WSFallKeyPicMonitor;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.LocalMultiProcConfig;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class WeishiUtils
{
  private static long a;
  public static String a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static int a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().a() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).getMessageFacade().a().a(AppConstants.WEISHI_UIN, 1008);
    }
    return 0;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  private static Bitmap a(URL paramURL, ImageView paramImageView)
  {
    if ((paramURL != null) && (paramImageView.getWidth() > 0))
    {
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = paramURL;
      localImageRequest.jdField_a_of_type_Int = paramImageView.getWidth();
      localImageRequest.jdField_b_of_type_Int = paramImageView.getHeight();
      paramURL = BitmapCache.a(localImageRequest.a());
      if (paramURL != null) {
        return paramURL.a();
      }
    }
    return null;
  }
  
  public static WeishiManager a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER) instanceof WeishiManager)) {
        return (WeishiManager)((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER);
      }
    }
    return null;
  }
  
  public static WSRedDotPushMsg a()
  {
    Object localObject = a();
    if (a((WeishiManager)localObject))
    {
      localObject = ((WeishiManager)localObject).a();
      WSLog.d("WSPushLog", "WSRedDotPushMsg = " + (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return WSRedDotPushMsg.getInstance((String)localObject);
      }
    }
    return null;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      String str = ((AppRuntime)localObject).getAccount();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    return "";
  }
  
  public static String a(int paramInt)
  {
    return WSReportUtils.a(paramInt);
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return b(paramstSimpleMetaFeed, false);
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    Object localObject2;
    if (paramstSimpleMetaFeed == null) {
      localObject2 = "";
    }
    Object localObject1;
    label73:
    do
    {
      return localObject2;
      localObject2 = "";
      localObject1 = localObject2;
      if (paramstSimpleMetaFeed.imgReplacements == null) {
        break;
      }
      localObject1 = localObject2;
      if (paramstSimpleMetaFeed.imgReplacements.size() <= 0) {
        break;
      }
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT <= 17) {
        break;
      }
      if ((paramBoolean) || (paramstSimpleMetaFeed.imgReplacements.size() <= 1)) {
        break label199;
      }
      localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(1)).img;
      WSLog.b("WeishiUtils", "使用webp图片资源：" + (String)localObject1);
      localObject2 = localObject1;
    } while (!TextUtils.isEmpty((CharSequence)localObject1));
    Object localObject3 = localObject1;
    if (paramstSimpleMetaFeed.images != null)
    {
      localObject3 = localObject1;
      if (paramstSimpleMetaFeed.images.size() > 0) {
        if ((paramBoolean) || (paramstSimpleMetaFeed.images.size() <= 1)) {
          break label217;
        }
      }
    }
    label199:
    label217:
    for (localObject3 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(1)).url;; localObject3 = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url)
    {
      WSLog.b("WeishiUtils", "使用服务器默认的图片格式资源：" + (String)localObject3);
      localObject2 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        break;
      }
      return "";
      localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
      break label73;
    }
  }
  
  public static String a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = paramString;
        if (paramString.contains("@{uid:"))
        {
          str1 = paramString;
          if (paramString.contains(",nick:"))
          {
            str1 = paramString;
            if (paramString.contains("}"))
            {
              int i = paramString.indexOf("@{uid:");
              int j = paramString.indexOf(",nick:");
              int k = paramString.indexOf("}");
              str1 = paramString.substring(i, k + 1);
              String str2 = paramString.substring(j + 6, k) + " ";
              str1 = a(paramString.replace(str1, "@" + URLDecoder.decode(str2)));
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new URL(paramString);
        return paramString;
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static void a()
  {
    WeishiManager localWeishiManager = a();
    if (localWeishiManager != null) {
      localWeishiManager.a(null);
    }
  }
  
  private static void a(Context paramContext)
  {
    if (paramContext != null) {}
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString)
  {
    WSLog.b("AvatarImageLog", "WeishiUtils loadAvatarImage url:" + paramString + ", imageView:" + paramImageView);
    if ((paramContext == null) || (paramImageView == null)) {
      return;
    }
    paramImageView = new WeakReference(paramImageView);
    ThreadManager.getSubThreadHandler().post(new WeishiUtils.4(paramImageView, paramContext, paramString));
  }
  
  public static void a(Context paramContext, KandianUrlImageView paramKandianUrlImageView, URL paramURL, Drawable paramDrawable, String paramString, int paramInt)
  {
    if ((paramContext != null) && (paramKandianUrlImageView != null))
    {
      localObject = a(paramURL, paramKandianUrlImageView);
      if (localObject != null)
      {
        paramKandianUrlImageView.setImageBitmap((Bitmap)localObject);
        paramContext = "";
        if (paramURL != null) {
          paramContext = paramURL.toString();
        }
        WSFallKeyPicMonitor.b(1, paramContext);
      }
    }
    else
    {
      return;
    }
    Object localObject = paramDrawable;
    if (paramDrawable == null) {
      localObject = paramContext.getResources().getDrawable(2130841881);
    }
    if (paramURL == null)
    {
      paramKandianUrlImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    paramKandianUrlImageView.setIsRecyclerView(true);
    paramKandianUrlImageView.setImagePlaceHolder((Drawable)localObject).setImage(paramURL);
    paramKandianUrlImageView.setPublicAccountImageDownListener(new WeishiUtils.1(paramString, paramKandianUrlImageView, paramInt));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, WeishiUtils.OnDownloadOpenWeishiGoH5Listener paramOnDownloadOpenWeishiGoH5Listener)
  {
    if (paramOnDownloadOpenWeishiGoH5Listener == null) {
      throw new RuntimeException("downloadOpenWeishiGoH5 must not be null!");
    }
    if (WeishiGuideUtils.a(paramContext))
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        WSLog.c("815", "走打开shemeUrl:" + paramString1);
        paramOnDownloadOpenWeishiGoH5Listener.a(paramString1, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        WSLog.c("833", "走打开小程序:" + paramString3);
        paramOnDownloadOpenWeishiGoH5Listener.d(paramString3, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        WSLog.c("815", "走打开h5Url:" + paramString2);
        paramOnDownloadOpenWeishiGoH5Listener.b(paramString2, paramInt);
        return;
      }
      WSLog.c("815", "走打开兜底:" + paramString1);
      paramOnDownloadOpenWeishiGoH5Listener.a("weishi://main", paramInt);
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      WSLog.c("833", "走打开小程序:" + paramString3);
      paramOnDownloadOpenWeishiGoH5Listener.d(paramString3, paramInt);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      WSLog.c("815", "走跳转h5Url:" + paramString2);
      paramOnDownloadOpenWeishiGoH5Listener.b(paramString2, paramInt);
      return;
    }
    WSLog.c("815", "走下载，shemeUrl:" + paramString1);
    paramOnDownloadOpenWeishiGoH5Listener.c(paramString1, paramInt);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    do
    {
      int i;
      do
      {
        return;
        int j = paramView.getVisibility();
        i = j;
        if (paramView.getTag(-1) != null)
        {
          i = j;
          if (paramView.getAnimation() != null) {
            i = ((Integer)paramView.getTag(-1)).intValue();
          }
        }
        paramView.setTag(-1, Integer.valueOf(paramInt1));
      } while (i == paramInt1);
      if (paramInt1 == 0)
      {
        paramView.setVisibility(0);
        localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
        localAlphaAnimation.setDuration(paramInt2);
        localAlphaAnimation.setFillAfter(true);
        localAlphaAnimation.setAnimationListener(new WeishiUtils.9(paramView));
        paramView.clearAnimation();
        paramView.startAnimation(localAlphaAnimation);
        return;
      }
    } while ((paramInt1 != 8) && (paramInt1 != 4));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(paramInt2);
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new WeishiUtils.10(paramView));
    paramView.clearAnimation();
    paramView.startAnimation(localAlphaAnimation);
  }
  
  public static void a(ImageView paramImageView, String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramImageView.setImageDrawable(paramDrawable1);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable2;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramImageView.setImageDrawable(paramDrawable1);
    paramDrawable1.setURLDrawableListener(new WeishiUtils.6(paramString2, paramImageView, paramString1));
    paramDrawable1.startDownload();
    if (1 != paramDrawable1.getStatus())
    {
      paramDrawable1.restartDownload();
      return;
    }
    WSLog.a("815", "onLoad ~~~~~~" + paramString2);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, Drawable paramDrawable, String paramString, boolean paramBoolean, int paramInt)
  {
    paramstSimpleMetaFeed = a(a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, paramDrawable, paramString, paramInt);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, String paramString, int paramInt)
  {
    paramstSimpleMetaFeed = a(a(paramstSimpleMetaFeed, paramBoolean));
    a(BaseApplicationImpl.getApplication(), paramKandianUrlImageView, paramstSimpleMetaFeed, null, paramString, paramInt);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString)
  {
    if ((paramKandianUrlImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = a(paramString);
      paramKandianUrlImageView.setImagePlaceHolder(BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(2130841984)).setImage(paramString);
    }
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, String paramString, Drawable paramDrawable)
  {
    if (paramKandianUrlImageView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramKandianUrlImageView.setImageDrawable(paramDrawable);
      return;
    }
    paramString = a(paramString);
    Bitmap localBitmap = a(paramString, paramKandianUrlImageView);
    if (localBitmap != null)
    {
      paramKandianUrlImageView.setImageBitmap(localBitmap);
      return;
    }
    paramKandianUrlImageView.setImagePlaceHolder(paramDrawable).setImage(paramString);
  }
  
  public static void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (paramAppInfo != null)
    {
      WSLog.b("WSRedDotLog", "saveRedDotAppInfo appInfo = " + paramAppInfo.iNewFlag.get());
      WSLog.b("WSRedDotLog", "saveRedDotAppInfo hasWsRedDot = " + paramBoolean);
      LocalMultiProcConfig.putBooleanAsync("wsRedDot", paramBoolean);
    }
  }
  
  public static void a(String paramString)
  {
    Context localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    if (localContext == null) {
      return;
    }
    ClipboardManager localClipboardManager = (ClipboardManager)localContext.getSystemService("clipboard");
    if ((localClipboardManager != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramString = b(paramString);
      ClipData localClipData = ClipData.newPlainText("", paramString);
      WSLog.d("WeishiUtils", "Clipboard copyScheme: " + paramString + ", clip: " + localClipData);
      if (localClipData != null) {
        localClipboardManager.setPrimaryClip(localClipData);
      }
    }
    a(localContext);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    URL localURL = a(paramString1);
    ImageRequest localImageRequest = new ImageRequest();
    localImageRequest.jdField_a_of_type_JavaNetURL = localURL;
    localImageRequest.jdField_b_of_type_Boolean = true;
    long l = SystemClock.uptimeMillis();
    ImageManager.a().a(localImageRequest, new WeishiUtils.8(l, paramString1, paramString2));
  }
  
  public static void a(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
        localstSimpleMetaFeed.feed_desc = a(localstSimpleMetaFeed.feed_desc);
      }
    }
  }
  
  public static void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    a(paramList, paramBoolean, "");
  }
  
  public static void a(List<stSimpleMetaFeed> paramList, boolean paramBoolean, String paramString)
  {
    if (!NetworkUtil.h(BaseApplication.getContext())) {}
    while ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    WSLog.b("PreloadCoverImgLog", "preloadImg size = " + paramList.size());
    ThreadManager.post(new WeishiUtils.7(new ArrayList(paramList), paramBoolean, paramString), 5, null, true);
  }
  
  public static boolean a()
  {
    return a(a());
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-013D;
  }
  
  public static boolean a(int paramInt)
  {
    String str1 = e();
    String str2 = WeiShiCacheManager.a(paramInt);
    return (WeiShiCacheManager.a().a(paramInt)) && ((TextUtils.isEmpty(str1)) || (TextUtils.equals(str1, str2)));
  }
  
  public static boolean a(WeishiManager paramWeishiManager)
  {
    if (paramWeishiManager == null) {
      return false;
    }
    return a(paramWeishiManager.a());
  }
  
  public static boolean a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
    {
      paramWSRedDotPushMsg = (WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg.mWSPushPreloadModel != null) {
        return paramWSRedDotPushMsg.mWSPushPreloadModel.jdField_a_of_type_Boolean;
      }
    }
    return false;
  }
  
  private static boolean a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    do
    {
      return false;
      WSLog.d("WSPushLog", "isMsgFromWeishiPush structMsg.frienduin: " + paramMessageForStructing.frienduin);
    } while ((!TextUtils.equals(AppConstants.WEISHI_UIN, paramMessageForStructing.frienduin)) || (paramMessageForStructing.issend != 0));
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("jpg")) && (!paramString.endsWith("jpeg")) && (!paramString.endsWith("JPG")) && (!paramString.endsWith("JPEG"))) {
      return false;
    }
    return true;
  }
  
  public static String b()
  {
    Object localObject = a();
    if (!a((WeishiManager)localObject)) {
      return "";
    }
    localObject = ((WeishiManager)localObject).a();
    if ((localObject != null) && (((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mArticleIds)))
    {
      localObject = ((MessageForStructing)localObject).structingMsg.mArticleIds.split("\\|");
      if (localObject.length > 0) {
        return localObject[0];
      }
    }
    return "";
  }
  
  public static String b(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    return c(a(paramstSimpleMetaFeed, paramBoolean));
  }
  
  public static String b(String paramString)
  {
    return paramString + "&idx=" + WSGlobalConfig.a().e();
  }
  
  public static void b()
  {
    WeishiManager localWeishiManager = a();
    if (localWeishiManager != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = localWeishiManager.c();
      localstSimpleMetaFeed.feed_desc = localWeishiManager.d();
      localWeishiManager.a(localstSimpleMetaFeed);
    }
  }
  
  private static void b(ImageRequest paramImageRequest, long paramLong, String paramString1, String paramString2)
  {
    WSLog.b("PreloadCoverImgLog", "onSuccess request = " + paramImageRequest);
    long l3 = SystemClock.uptimeMillis();
    long l1;
    int i;
    label51:
    boolean bool;
    if (paramImageRequest != null)
    {
      l1 = paramImageRequest.f;
      if (paramImageRequest == null) {
        break label97;
      }
      i = paramImageRequest.d;
      bool = c(i);
      if (paramImageRequest == null) {
        break label103;
      }
    }
    label97:
    label103:
    for (long l2 = paramImageRequest.i;; l2 = 0L)
    {
      WsBeaconReportPresenter.a().a(true, true, bool, l3 - paramLong, l1, l2, paramString1, paramString2, -1);
      return;
      l1 = 0L;
      break;
      i = 0;
      break label51;
    }
  }
  
  public static void b(String paramString)
  {
    LocalMultiProcConfig.putString4Uin("key_qq_connect_person_id", paramString, a());
  }
  
  private static void b(WeakReference<ImageView> paramWeakReference, Drawable paramDrawable, String paramString)
  {
    ThreadManager.getUIHandler().post(new WeishiUtils.5(paramWeakReference, paramDrawable, paramString));
  }
  
  private static void b(URL paramURL, long paramLong, String paramString, KandianUrlImageView paramKandianUrlImageView, int paramInt)
  {
    String str = paramURL.toString();
    WSFallKeyPicMonitor.b(1, str);
    ThreadManager.executeOnSubThread(new WeishiUtils.2(paramURL, paramLong, paramKandianUrlImageView, str, paramString, paramInt));
  }
  
  public static boolean b()
  {
    boolean bool = true;
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      bool = localQQAppInterface.mAutomator.b();
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("png")) && (!paramString.endsWith("PNG"))) {
      return false;
    }
    return true;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (a(paramString)) {
      return "jpg";
    }
    if (b(paramString)) {
      return "png";
    }
    if (c(paramString)) {
      return "webp";
    }
    return "";
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      WSReportEventConstants.b = "";
      WSReportEventConstants.jdField_a_of_type_JavaLangString = "";
      WSSharePreferencesUtil.a("key_ref_page_id", "");
      return;
    }
    WSReportEventConstants.b = WSReportEventConstants.jdField_a_of_type_JavaLangString;
    WSSharePreferencesUtil.a("key_ref_page_id", WSReportEventConstants.b);
    WSReportEventConstants.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long <= 500L)
    {
      WSLog.f("WeishiUtils", "click too fast");
      jdField_a_of_type_Long = l;
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
  
  private static boolean c(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.endsWith("webp")) && (!paramString.endsWith("WEBP"))) {
      return false;
    }
    return true;
  }
  
  public static String d()
  {
    String str = LocalMultiProcConfig.getString4Uin("key_qq_connect_person_id", "", a());
    WSLog.f("WeishiUtils", "[qq_connect_person_id]" + str);
    return str;
  }
  
  public static boolean d()
  {
    WeSeeConfigBean localWeSeeConfigBean = WSConfigManager.a().a();
    if ((localWeSeeConfigBean == null) || (localWeSeeConfigBean.a == null)) {
      return false;
    }
    return localWeSeeConfigBean.a.jdField_a_of_type_Boolean;
  }
  
  public static String e()
  {
    Object localObject = a();
    if (localObject != null) {
      return ((WSRedDotPushMsg)localObject).mFeedIds;
    }
    localObject = a();
    if (localObject != null) {
      return ((WeishiManager)localObject).c();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils
 * JD-Core Version:    0.7.0.1
 */