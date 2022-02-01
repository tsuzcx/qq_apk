package com.tencent.biz.pubaccount.weishi_new.combo.publisher;

import UserGrowth.stPublisherRsp;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.biz.pubaccount.weishi_new.WSPublisherDialog;
import com.tencent.biz.pubaccount.weishi_new.WeishiActivityHelper;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/combo/publisher/WSPublisherUtil;", "", "()V", "DIALOG_SHOW", "", "TAG", "", "defaultSchema", "jumpH5", "", "context", "Landroid/content/Context;", "h5Url", "sopName", "jumpMiniApp", "miniAppSchema", "jumpWeiShi", "schemeUrl", "performCheckDialogShow", "data", "LUserGrowth/stPublisherRsp;", "performCheckWeiShiInstall", "performJump", "performPublisher", "reportPublisher", "eventName", "position", "actionId", "setDefaultSchema", "showPublisherDialog", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPublisherUtil
{
  public static final WSPublisherUtil a = new WSPublisherUtil();
  private static String b = "";
  
  private final void a(Context paramContext, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPublisherHelper.kt][jumpMiniApp] miniAppSchema:");
    localStringBuilder.append(paramString1);
    WSLog.e("WSPublisherHelper", localStringBuilder.toString());
    WeishiActivityHelper.a(paramContext, paramString1, (MiniAppLaunchListener)WSPublisherUtil.jumpMiniApp.1.a);
    a("gzh_click", "publish", 1000007, paramString2);
  }
  
  private final void b(Context paramContext, stPublisherRsp paramstPublisherRsp, String paramString)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][performCheckDialogShow]");
    Integer localInteger;
    if (paramstPublisherRsp != null) {
      localInteger = Integer.valueOf(paramstPublisherRsp.showGuide);
    } else {
      localInteger = null;
    }
    if ((localInteger != null) && (localInteger.intValue() == 1))
    {
      e(paramContext, paramstPublisherRsp, paramString);
      return;
    }
    c(paramContext, paramstPublisherRsp, paramString);
  }
  
  private final void b(Context paramContext, String paramString1, String paramString2)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][jumpH5]");
    WeishiActivityHelper.a(paramContext, paramString1);
    a("gzh_click", "publish", 1000004, paramString2);
  }
  
  private final void c(Context paramContext, stPublisherRsp paramstPublisherRsp, String paramString)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][performJump]");
    String str;
    if (paramstPublisherRsp != null) {
      str = paramstPublisherRsp.weishiSchema;
    } else {
      str = null;
    }
    if (str == null)
    {
      if (paramstPublisherRsp != null)
      {
        paramstPublisherRsp = paramstPublisherRsp.h5Url;
        if (paramstPublisherRsp != null) {
          a.b(paramContext, paramstPublisherRsp, paramString);
        }
      }
    }
    else {
      d(paramContext, paramstPublisherRsp, paramString);
    }
  }
  
  private final void c(Context paramContext, String paramString1, String paramString2)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][jumpWeiShi]");
    WSGlobalConfig localWSGlobalConfig = WSGlobalConfig.a();
    Intrinsics.checkExpressionValueIsNotNull(localWSGlobalConfig, "WSGlobalConfig.getInstance()");
    WeishiScehmeUtil.a(paramContext, "biz_src_jc_gzh_weishi", paramString1, 1, localWSGlobalConfig.d(), 0);
    a("gzh_click", "publish_popup", 1000003, paramString2);
  }
  
  private final void d(Context paramContext, stPublisherRsp paramstPublisherRsp, String paramString)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][performCheckWeiShiInstall]");
    if (WeishiGuideUtils.a(paramContext))
    {
      if (paramstPublisherRsp != null)
      {
        paramstPublisherRsp = paramstPublisherRsp.weishiSchema;
        if (paramstPublisherRsp != null) {
          a.c(paramContext, paramstPublisherRsp, paramString);
        }
      }
    }
    else if (paramstPublisherRsp != null)
    {
      paramstPublisherRsp = paramstPublisherRsp.h5Url;
      if (paramstPublisherRsp != null) {
        a.b(paramContext, paramstPublisherRsp, paramString);
      }
    }
  }
  
  private final void e(Context paramContext, stPublisherRsp paramstPublisherRsp, String paramString)
  {
    WSLog.e("WSPublisherHelper", "[WSPublisherHelper.kt][showPublisherDialog]");
    WSPublisherDialog localWSPublisherDialog = new WSPublisherDialog(paramContext);
    localWSPublisherDialog.a(paramstPublisherRsp);
    localWSPublisherDialog.a((IWSPublisherDialogClickListener)new WSPublisherUtil.showPublisherDialog.1(paramContext, paramstPublisherRsp, paramString));
    localWSPublisherDialog.a(WSHomeFragment.f);
    localWSPublisherDialog.show();
    a("gzh_click", "publish", 1000006, paramString);
  }
  
  public final void a(@NotNull Context paramContext, @Nullable stPublisherRsp paramstPublisherRsp, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "sopName");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSPublisherHelper.kt][performPublisher] data:");
    localStringBuilder.append(paramstPublisherRsp);
    WSLog.e("WSPublisherHelper", localStringBuilder.toString());
    if (paramstPublisherRsp == null)
    {
      a(paramContext, b, paramString);
      return;
    }
    if (paramstPublisherRsp.noInstallAction != 2)
    {
      b(paramContext, paramstPublisherRsp, paramString);
      return;
    }
    paramstPublisherRsp = paramstPublisherRsp.miniAppSchema;
    Intrinsics.checkExpressionValueIsNotNull(paramstPublisherRsp, "data.miniAppSchema");
    a(paramContext, paramstPublisherRsp, paramString);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "schemeUrl");
    b = paramString;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    Intrinsics.checkParameterIsNotNull(paramString2, "position");
    Intrinsics.checkParameterIsNotNull(paramString3, "sopName");
    WSPublicAccReport.getInstance().reportPublisher(paramString1, paramString3, paramString2, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.combo.publisher.WSPublisherUtil
 * JD-Core Version:    0.7.0.1
 */