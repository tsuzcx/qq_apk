package com.tencent.biz.subscribe;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalDetailFragment;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.biz.subscribe.preloader.task.SubscribeDetailPreLoaderTask;
import com.tencent.biz.subscribe.preloader.task.SubscribePersonalDetailPreLoaderTask;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class SubscribeLaucher
{
  private static long a;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return 0;
    case 2: 
    case 7: 
      return 7001;
    case 1: 
    case 8: 
      return 8001;
    }
    return 7000;
  }
  
  public static CertifiedAccountMeta.StFeed a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    if (paramString1 != null) {
      localStFeed.id.set(paramString1);
    }
    localStFeed.type.set(paramInt1);
    localStFeed.createTime.set(paramLong);
    paramString1 = new CertifiedAccountMeta.StUser();
    if (paramString2 != null) {
      paramString1.id.set(paramString2);
    }
    localStFeed.poster.set(paramString1);
    if (a(paramInt1))
    {
      paramString1 = new CertifiedAccountMeta.StVideo();
      paramString1.height.set(paramInt3);
      paramString1.width.set(paramInt2);
      localStFeed.video.set(paramString1);
    }
    return localStFeed;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    return str;
  }
  
  private static void a()
  {
    SubscribeGlobalInfo.a();
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Intent paramIntent)
  {
    a(paramContext, null, null, new ExtraTypeInfo(paramInt2, paramInt1), paramIntent);
  }
  
  public static void a(Context paramContext, int paramInt, Intent paramIntent)
  {
    a(paramContext, paramInt, 7004, paramIntent);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed)
  {
    a(paramContext, paramStFeed, 0);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, int paramInt)
  {
    a(paramContext, paramStFeed, paramInt, null);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, int paramInt, Intent paramIntent)
  {
    a(paramContext, "", paramStFeed, new ExtraTypeInfo(0, paramInt), paramIntent);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    a(paramContext, "", paramStFeed, paramExtraTypeInfo, null);
  }
  
  public static void a(Context paramContext, CertifiedAccountMeta.StUser paramStUser)
  {
    a(paramContext, paramStUser.id.get(), paramStUser, 0, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    a(paramContext, paramString, 0);
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, paramString, null, paramInt, null);
  }
  
  public static void a(Context paramContext, String paramString, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    if (Math.abs(System.currentTimeMillis() - a) < 500L)
    {
      QLog.i("SubscribeLauncher", 2, "prevent SubscribeLaucher from doubleClick");
      return;
    }
    a();
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramString != null) {
      localIntent.putExtra("url", paramString);
    }
    if (paramStFeed != null)
    {
      ((CertifiedAccountMeta.StUser)paramStFeed.poster.get()).setHasFlag(true);
      ((CertifiedAccountMeta.StImage)paramStFeed.cover.get()).setHasFlag(true);
      ((CertifiedAccountMeta.StVideo)paramStFeed.video.get()).setHasFlag(true);
      localIntent.putExtra("bundle_key_subscribe_feed_bytes_array", paramStFeed.toByteArray());
      localIntent.putExtra("bundle_key_feed_type", paramStFeed.type.get());
    }
    a = System.currentTimeMillis();
    localIntent.putExtra("PERF_OPEN_PAGE_TIME", System.currentTimeMillis());
    if (paramContext == null) {
      paramString = BaseApplicationImpl.getContext();
    } else {
      paramString = paramContext;
    }
    if (a(paramString, paramStFeed, paramExtraTypeInfo, localIntent)) {
      return;
    }
    localIntent.setClass(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("fragment_class", SubscribeHybirdFragment.class.getCanonicalName());
    if ((paramContext instanceof Activity))
    {
      paramContext.startActivity(localIntent);
      return;
    }
    localIntent.addFlags(268435456);
    BaseApplicationImpl.getContext().startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, CertifiedAccountMeta.StUser paramStUser, int paramInt, Intent paramIntent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("1001");
    ((StringBuilder)localObject).append(paramString);
    PreLoader.remove(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("1001");
    ((StringBuilder)localObject).append(paramString);
    PreLoader.preLoad(((StringBuilder)localObject).toString(), new SubscribePersonalDetailPreLoaderTask(paramString));
    localObject = new ExtraTypeInfo(7002, paramInt);
    paramString = a("", paramString, -1, 0, 0, 0L);
    if (paramStUser != null) {
      paramString.poster.set(paramStUser);
    }
    a(paramContext, null, paramString, (ExtraTypeInfo)localObject, paramIntent);
  }
  
  public static void a(Context paramContext, String paramString, Intent paramIntent)
  {
    a(paramContext, paramString, null, 0, paramIntent);
  }
  
  public static void a(Context paramContext, String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramString != null)
    {
      if (paramString.startsWith("opendetail"))
      {
        QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema detail");
        paramContext = a(a((String)paramHashMap.get("feedid")), a((String)paramHashMap.get("uin")), Integer.parseInt(b((String)paramHashMap.get("type"))), Integer.parseInt(b((String)paramHashMap.get("width"))), Integer.parseInt(b((String)paramHashMap.get("height"))), Long.parseLong(b((String)paramHashMap.get("createtime"))));
        paramString = (String)paramHashMap.get("commentid");
        if (TextUtils.isEmpty(paramString))
        {
          a(null, paramContext);
          return;
        }
        ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo(0, 0);
        localExtraTypeInfo.setReplyId((String)paramHashMap.get("replyid"));
        localExtraTypeInfo.setCommentId(paramString);
        a(null, paramContext, localExtraTypeInfo);
        return;
      }
      if (paramString.startsWith("openhomepage"))
      {
        QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema personal page");
        a(paramContext, a((String)paramHashMap.get("uid")));
        return;
      }
      if (paramString.startsWith("opendiscoverpage"))
      {
        QLog.i("SubscribeLauncher", 2, "launchSubscribeBySchema ServiceAccountFolder page");
        a(paramContext, 0, 7004, null);
      }
    }
    else
    {
      QLog.e("SubscribeLauncher", 2, "launchSubscribeBySchema failed");
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, 8000);
  }
  
  public static void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, 0);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(null, paramString, new CertifiedAccountMeta.StFeed(), new ExtraTypeInfo(paramInt1, paramInt2), null);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 3) || (paramInt == 5) || (paramInt == 6);
  }
  
  private static boolean a(Context paramContext, CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo, Intent paramIntent)
  {
    ExtraTypeInfo localExtraTypeInfo = paramExtraTypeInfo;
    if (paramExtraTypeInfo == null) {
      localExtraTypeInfo = new ExtraTypeInfo();
    }
    if ((localExtraTypeInfo.pageType == 0) && (paramStFeed != null)) {
      localExtraTypeInfo.pageType = a(paramStFeed.type.get());
    }
    int j = localExtraTypeInfo.pageType;
    int i = 1;
    switch (j)
    {
    default: 
    case 7003: 
    case 7004: 
    case 7002: 
      for (bool1 = false;; bool1 = true)
      {
        k = 0;
        i = 0;
        break;
        paramIntent.setClass(paramContext, ServiceAccountFolderActivity.class);
        paramIntent.setFlags(67108864);
        continue;
        paramIntent.setClass(paramContext, PublicFragmentActivity.class);
        paramIntent.putExtra("public_fragment_class", SubscribePersonalDetailFragment.class.getName());
        paramIntent.addFlags(268435456);
      }
    case 7001: 
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeMultiPicFragment.class.getName());
      paramIntent.addFlags(268435456);
      bool1 = TransitionAnimHelper.a();
      break;
    case 7000: 
      paramIntent.setClass(paramContext, PublicFragmentActivity.class);
      paramIntent.putExtra("public_fragment_class", SubscribeVideoDetailFragment.class.getName());
      paramIntent.addFlags(268435456);
      bool1 = TransitionAnimHelper.a();
    }
    boolean bool2 = true;
    int k = bool1;
    boolean bool1 = bool2;
    paramIntent.putExtra("key_subscribe_intent_extra_type_info", localExtraTypeInfo);
    if (i != 0)
    {
      paramExtraTypeInfo = new StringBuilder();
      paramExtraTypeInfo.append("1002");
      paramExtraTypeInfo.append(paramStFeed.id.get());
      PreLoader.remove(paramExtraTypeInfo.toString());
      paramExtraTypeInfo = new StringBuilder();
      paramExtraTypeInfo.append("1002");
      paramExtraTypeInfo.append(paramStFeed.id.get());
      PreLoader.preLoad(paramExtraTypeInfo.toString(), new SubscribeDetailPreLoaderTask(paramStFeed));
    }
    if (bool1)
    {
      if ((k != 0) && ((paramContext instanceof Activity)) && (Build.VERSION.SDK_INT >= 16))
      {
        paramContext = (Activity)paramContext;
        paramContext.startActivity(paramIntent, TransitionAnimHelper.a());
        paramContext.overridePendingTransition(0, 0);
        return bool1;
      }
      if (!(paramContext instanceof Activity)) {
        paramIntent.addFlags(268435456);
      }
      paramContext.startActivity(paramIntent);
    }
    return bool1;
  }
  
  private static String b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return paramString;
    }
    return "0";
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 7);
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 8) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeLaucher
 * JD-Core Version:    0.7.0.1
 */