package com.tencent.biz.pubaccount.readinjoy.webarticle;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/webarticle/RIJWebArticleOptimizeUtil;", "", "()V", "TAG", "", "getUrlUseVasSonic", "url", "getUrlUseWebViewPool", "getWebUrlWithOptimization", "usePendingTransition", "", "context", "Landroid/content/Context;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJWebArticleOptimizeUtil
{
  public static final RIJWebArticleOptimizeUtil a = new RIJWebArticleOptimizeUtil();
  
  private final String b(String paramString)
  {
    if (!RIJWebArticleUtil.a.b()) {
      return paramString;
    }
    QLog.i("RIJWebArticleOptimizeUtil", 1, "[getUrlUseWebViewPool] before url = " + paramString);
    paramString = HtmlOffline.a(paramString, "_wwv=64");
    QLog.i("RIJWebArticleOptimizeUtil", 1, "[getUrlUseWebViewPool] after result = " + paramString);
    return paramString;
  }
  
  private final String c(String paramString)
  {
    if (!RIJWebArticleUtil.a.c()) {
      return paramString;
    }
    QLog.i("RIJWebArticleOptimizeUtil", 1, "[getUrlUseVasSonic] before url = " + paramString);
    paramString = HtmlOffline.a(HtmlOffline.a(HtmlOffline.a(paramString, "_sonic_xv=" + 15L), "sonic=1"), "_tbs_xv=1");
    QLog.i("RIJWebArticleOptimizeUtil", 1, "[getUrlUseVasSonic] after result = " + paramString);
    return paramString;
  }
  
  @Nullable
  public final String a(@Nullable String paramString)
  {
    return c(b(paramString));
  }
  
  public final void a(@Nullable Context paramContext)
  {
    if ((RIJWebArticleUtil.a.d()) && ((paramContext instanceof Activity))) {
      ((Activity)paramContext).overridePendingTransition(2130771984, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */