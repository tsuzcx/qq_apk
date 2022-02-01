package com.tencent.biz.pubaccount.weishi_new.util;

import NS_KING_SOCIALIZE_META.stMetaUgcImage;
import UserGrowth.stImgReplacement;
import UserGrowth.stSimpleMetaFeed;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportEventConstants;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.WeishiManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.LocalMultiProcConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class WeishiUtils
{
  private static long a = 0L;
  public static String a = "";
  public static boolean a = false;
  
  public static int a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).getMessageFacade() != null)
      {
        if (((QQAppInterface)localObject).getMessageFacade().a() == null) {
          return 0;
        }
        return ((QQAppInterface)localObject).getMessageFacade().a().a(AppConstants.WEISHI_UIN, 1008);
      }
    }
    return 0;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static long a()
  {
    AppRuntime localAppRuntime = a();
    if (localAppRuntime != null) {
      return localAppRuntime.getLongAccountUin();
    }
    return 0L;
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.parseLong(paramString);
        return l;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return paramLong;
  }
  
  private static stMetaUgcImage a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if ((paramstSimpleMetaFeed.images != null) && (paramstSimpleMetaFeed.images.size() > 0))
    {
      if ((!paramBoolean) && (paramstSimpleMetaFeed.images.size() > 1)) {
        return (stMetaUgcImage)paramstSimpleMetaFeed.images.get(1);
      }
      return (stMetaUgcImage)paramstSimpleMetaFeed.images.get(0);
    }
    return null;
  }
  
  private static stImgReplacement a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if ((paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.imgReplacements.size() > 0) && (Build.VERSION.SDK_INT > 17))
    {
      if ((!paramBoolean) && (paramstSimpleMetaFeed.imgReplacements.size() > 1)) {
        return (stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(1);
      }
      return (stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0);
    }
    return null;
  }
  
  public static Uri a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString);
    }
    return null;
  }
  
  public static WSRedDotPushMsg a()
  {
    Object localObject = a();
    if (a((WeishiManager)localObject))
    {
      localObject = ((WeishiManager)localObject).a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WSRedDotPushMsg = ");
      localStringBuilder.append((String)localObject);
      WSLog.d("WSPushLog", localStringBuilder.toString());
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
    return c(paramstSimpleMetaFeed, false);
  }
  
  public static String a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    if (paramstSimpleMetaFeed == null) {
      return "";
    }
    Object localObject1;
    Object localObject2;
    if ((paramstSimpleMetaFeed.imgReplacements != null) && (paramstSimpleMetaFeed.imgReplacements.size() > 0) && (Build.VERSION.SDK_INT > 17))
    {
      if ((!paramBoolean) && (paramstSimpleMetaFeed.imgReplacements.size() > 1)) {
        localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(1)).img;
      } else {
        localObject1 = ((stImgReplacement)paramstSimpleMetaFeed.imgReplacements.get(0)).img;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("使用webp图片资源：");
      ((StringBuilder)localObject2).append((String)localObject1);
      WSLog.b("WeishiUtils", ((StringBuilder)localObject2).toString());
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        return localObject1;
      }
    }
    else
    {
      localObject2 = "";
    }
    if ((paramstSimpleMetaFeed.images != null) && (paramstSimpleMetaFeed.images.size() > 0))
    {
      if ((!paramBoolean) && (paramstSimpleMetaFeed.images.size() > 1)) {
        paramstSimpleMetaFeed = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(1)).url;
      } else {
        paramstSimpleMetaFeed = ((stMetaUgcImage)paramstSimpleMetaFeed.images.get(0)).url;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("使用服务器默认的图片格式资源：");
      ((StringBuilder)localObject1).append(paramstSimpleMetaFeed);
      WSLog.b("WeishiUtils", ((StringBuilder)localObject1).toString());
    }
    else
    {
      paramstSimpleMetaFeed = (stSimpleMetaFeed)localObject2;
    }
    if (!TextUtils.isEmpty(paramstSimpleMetaFeed)) {
      return paramstSimpleMetaFeed;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.contains("@{uid:"))
        {
          str = paramString;
          if (paramString.contains(",nick:"))
          {
            str = paramString;
            if (paramString.contains("}"))
            {
              int i = paramString.indexOf("@{uid:");
              int j = paramString.indexOf(",nick:");
              int k = paramString.indexOf("}");
              str = paramString.substring(i, k + 1);
              Object localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString.substring(j + 6, k));
              ((StringBuilder)localObject).append(" ");
              localObject = ((StringBuilder)localObject).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("@");
              localStringBuilder.append(URLDecoder.decode((String)localObject));
              str = a(paramString.replace(str, localStringBuilder.toString()));
            }
          }
        }
      }
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
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
  
  @NonNull
  public static <T> List<T> a(@Nullable List<T> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramInt1 >= 0) && (paramInt2 <= paramList.size()) && (paramInt1 <= paramInt2)) {
      return paramList.subList(paramInt1, paramInt2);
    }
    return new ArrayList();
  }
  
  public static AppRuntime a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getRuntime();
    }
    return null;
  }
  
  public static void a()
  {
    WeishiManager localWeishiManager = a();
    if (localWeishiManager != null) {
      localWeishiManager.a(null);
    }
  }
  
  private static void a(Context paramContext) {}
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, WeishiUtils.OnDownloadOpenWeishiGoH5Listener paramOnDownloadOpenWeishiGoH5Listener)
  {
    if (paramOnDownloadOpenWeishiGoH5Listener != null)
    {
      if (WeishiGuideUtils.a(paramContext))
      {
        if (!TextUtils.isEmpty(paramString1))
        {
          paramContext = new StringBuilder();
          paramContext.append("走打开shemeUrl:");
          paramContext.append(paramString1);
          WSLog.c("815", paramContext.toString());
          paramOnDownloadOpenWeishiGoH5Listener.a(paramString1, paramInt);
          return;
        }
        if (!TextUtils.isEmpty(paramString3))
        {
          paramContext = new StringBuilder();
          paramContext.append("走打开小程序:");
          paramContext.append(paramString3);
          WSLog.c("833", paramContext.toString());
          paramOnDownloadOpenWeishiGoH5Listener.d(paramString3, paramInt);
          return;
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          paramContext = new StringBuilder();
          paramContext.append("走打开h5Url:");
          paramContext.append(paramString2);
          WSLog.c("815", paramContext.toString());
          paramOnDownloadOpenWeishiGoH5Listener.b(paramString2, paramInt);
          return;
        }
        paramContext = new StringBuilder();
        paramContext.append("走打开兜底:");
        paramContext.append(paramString1);
        WSLog.c("815", paramContext.toString());
        paramOnDownloadOpenWeishiGoH5Listener.a("weishi://main", paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = new StringBuilder();
        paramContext.append("走打开小程序:");
        paramContext.append(paramString3);
        WSLog.c("833", paramContext.toString());
        paramOnDownloadOpenWeishiGoH5Listener.d(paramString3, paramInt);
        return;
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramContext = new StringBuilder();
        paramContext.append("走跳转h5Url:");
        paramContext.append(paramString2);
        WSLog.c("815", paramContext.toString());
        paramOnDownloadOpenWeishiGoH5Listener.b(paramString2, paramInt);
        return;
      }
      paramContext = new StringBuilder();
      paramContext.append("走下载，shemeUrl:");
      paramContext.append(paramString1);
      WSLog.c("815", paramContext.toString());
      paramOnDownloadOpenWeishiGoH5Listener.c(paramString1, paramInt);
      return;
    }
    throw new RuntimeException("downloadOpenWeishiGoH5 must not be null!");
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getVisibility();
    int i = j;
    if (paramView.getTag(-1) != null)
    {
      i = j;
      if (paramView.getAnimation() != null) {
        i = ((Integer)paramView.getTag(-1)).intValue();
      }
    }
    paramView.setTag(-1, Integer.valueOf(paramInt1));
    if (i == paramInt1) {
      return;
    }
    AlphaAnimation localAlphaAnimation;
    if (paramInt1 == 0)
    {
      paramView.setVisibility(0);
      localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(paramInt2);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new WeishiUtils.1(paramView));
      paramView.clearAnimation();
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
    if ((paramInt1 == 8) || (paramInt1 == 4))
    {
      localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(paramInt2);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new WeishiUtils.2(paramView));
      paramView.clearAnimation();
      paramView.startAnimation(localAlphaAnimation);
    }
  }
  
  public static void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (paramAppInfo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveRedDotAppInfo appInfo = ");
      localStringBuilder.append(paramAppInfo.iNewFlag.get());
      WSLog.b("WSRedDotLog", localStringBuilder.toString());
      paramAppInfo = new StringBuilder();
      paramAppInfo.append("saveRedDotAppInfo hasWsRedDot = ");
      paramAppInfo.append(paramBoolean);
      WSLog.b("WSRedDotLog", paramAppInfo.toString());
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
      paramString = c(paramString);
      ClipData localClipData = ClipData.newPlainText("", paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Clipboard copyScheme: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", clip: ");
      localStringBuilder.append(localClipData);
      WSLog.d("WeishiUtils", localStringBuilder.toString());
      if (localClipData != null) {
        localClipboardManager.setPrimaryClip(localClipData);
      }
    }
    a(localContext);
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
  
  public static boolean a(WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
    {
      paramWSRedDotPushMsg = (WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo;
      if (paramWSRedDotPushMsg.mWSPushPreloadModel != null) {
        return paramWSRedDotPushMsg.mWSPushPreloadModel.a;
      }
    }
    return false;
  }
  
  public static boolean a(WeishiManager paramWeishiManager)
  {
    if (paramWeishiManager == null) {
      return false;
    }
    return a(paramWeishiManager.a());
  }
  
  private static boolean a(MessageForStructing paramMessageForStructing)
  {
    boolean bool2 = false;
    if (paramMessageForStructing == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isMsgFromWeishiPush structMsg.frienduin: ");
    localStringBuilder.append(paramMessageForStructing.frienduin);
    WSLog.d("WSPushLog", localStringBuilder.toString());
    boolean bool1 = bool2;
    if (TextUtils.equals(AppConstants.WEISHI_UIN, paramMessageForStructing.frienduin))
    {
      bool1 = bool2;
      if (paramMessageForStructing.issend == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("jpg")) || (paramString.endsWith("jpeg")) || (paramString.endsWith("JPG")) || (paramString.endsWith("JPEG"))) {
      bool1 = true;
    }
    return bool1;
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
    if (paramstSimpleMetaFeed == null) {
      return "";
    }
    String str = e(paramstSimpleMetaFeed, paramBoolean);
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    return d(paramstSimpleMetaFeed, paramBoolean);
  }
  
  public static String b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("0x")))
    {
      paramString = paramString.substring(2);
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append(paramString);
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  public static void b()
  {
    WeishiManager localWeishiManager = a();
    if (localWeishiManager != null)
    {
      stSimpleMetaFeed localstSimpleMetaFeed = new stSimpleMetaFeed();
      localstSimpleMetaFeed.id = localWeishiManager.c();
      localstSimpleMetaFeed.feed_desc = localWeishiManager.d();
      WSAioListHelper.a(localstSimpleMetaFeed, "H5Biz");
    }
  }
  
  public static void b(String paramString)
  {
    LocalMultiProcConfig.putString4Uin("key_qq_connect_person_id", paramString, a());
  }
  
  public static boolean b()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null) {
      return localQQAppInterface.mAutomator.b();
    }
    return true;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("png")) || (paramString.endsWith("PNG"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String c()
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(((Context)localObject).getPackageName(), 0).versionName;
      return localObject;
    }
    catch (Exception localException)
    {
      label22:
      break label22;
    }
    return "";
  }
  
  public static String c(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    return d(a(paramstSimpleMetaFeed, paramBoolean));
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&idx=");
    localStringBuilder.append(WSGlobalConfig.a().e());
    return localStringBuilder.toString();
  }
  
  public static void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      WSReportEventConstants.b = "";
      WSReportEventConstants.a = "";
      WSSharePreferencesUtil.a("key_ref_page_id", "");
      return;
    }
    WSReportEventConstants.b = WSReportEventConstants.a;
    WSSharePreferencesUtil.a("key_ref_page_id", WSReportEventConstants.b);
    WSReportEventConstants.a = paramString;
  }
  
  public static boolean c()
  {
    long l = System.currentTimeMillis();
    if (l - a <= 500L)
    {
      WSLog.f("WeishiUtils", "click too fast");
      a = l;
      return true;
    }
    a = l;
    return false;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramString.endsWith("webp")) || (paramString.endsWith("WEBP"))) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String d()
  {
    String str = LocalMultiProcConfig.getString4Uin("key_qq_connect_person_id", "", a());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[qq_connect_person_id]");
    localStringBuilder.append(str);
    WSLog.f("WeishiUtils", localStringBuilder.toString());
    return str;
  }
  
  private static String d(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramBoolean);
    if (paramstSimpleMetaFeed != null) {
      return b(paramstSimpleMetaFeed.photo_rgb);
    }
    return "";
  }
  
  public static String d(String paramString)
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
  
  private static String e(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramBoolean);
    if (paramstSimpleMetaFeed != null) {
      return b(paramstSimpleMetaFeed.photo_rgb);
    }
    return "";
  }
  
  public static String f()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface == null) {
      return "0";
    }
    long l = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
    return PreferenceManager.getDefaultPreference(localQQAppInterface.getApplication(), l).getString("key_weishi_newest_feed_from", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils
 * JD-Core Version:    0.7.0.1
 */