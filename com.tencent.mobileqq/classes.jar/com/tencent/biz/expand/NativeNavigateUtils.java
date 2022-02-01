package com.tencent.biz.expand;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/NativeNavigateUtils;", "", "()V", "TAG", "", "navigateBySchema", "", "context", "Landroid/content/Context;", "url", "navigateMiniApp", "navigateWebView", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class NativeNavigateUtils
{
  public static final NativeNavigateUtils a = new NativeNavigateUtils();
  
  public final void a(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (!((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString))
    {
      paramContext = LogUtils.a;
      paramContext = (Throwable)null;
      QLog.e("NativeNavigateUtils", 1, "jumpUrl: " + paramString + " is not miniapp ", paramContext);
      return;
    }
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("NativeNavigateUtils", 2, "navigateMiniApp: " + paramString + ' ');
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, 2065, null);
  }
  
  public final void b(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramContext = LogUtils.a;
      QLog.e("NativeNavigateUtils", 1, "web url is null", (Throwable)null);
      return;
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("NativeNavigateUtils", 2, "navigateWebView: " + paramString + ' ');
    }
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramContext.startActivity((Intent)localObject);
  }
  
  public final void c(@NotNull Context paramContext, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      paramContext = LogUtils.a;
      QLog.e("NativeNavigateUtils", 1, "schema url is null", (Throwable)null);
      return;
    }
    Object localObject = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("NativeNavigateUtils", 2, "navigateBySchema: " + paramString + ' ');
    }
    localObject = new Intent((Context)BaseApplicationImpl.getContext(), JumpActivity.class);
    ((Intent)localObject).setData(Uri.parse(paramString));
    if (!(paramContext instanceof Activity)) {
      ((Intent)localObject).addFlags(268435456);
    }
    paramContext.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.NativeNavigateUtils
 * JD-Core Version:    0.7.0.1
 */