package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import java.util.ArrayList;

public class WSExpABTestManager
{
  private WSExpPolicyEntities a = WSExpPolicyManager.a().a();
  
  public static WSExpABTestManager a()
  {
    return WSExpABTestManager.SingletonHolder.a();
  }
  
  private String a(String paramString1, String paramString2)
  {
    return WSExpUtils.a(this.a, paramString1, paramString2);
  }
  
  public int a()
  {
    return WeishiUtils.a(a("QQFeedPlayerType", "type"), 0);
  }
  
  @NonNull
  public WSOpenWeiShiData a()
  {
    WSOpenWeiShiData localWSOpenWeiShiData = new WSOpenWeiShiData();
    localWSOpenWeiShiData.a(a("AppPullOptimization", "image"));
    localWSOpenWeiShiData.b(a("AppPullOptimization", "title"));
    localWSOpenWeiShiData.c(a("AppPullOptimization", "desc"));
    localWSOpenWeiShiData.d(a("AppPullOptimization", "buttonText"));
    String str1 = a("AppPullOptimization", "openTime");
    String str2 = a("AppPullOptimization", "closeTime");
    localWSOpenWeiShiData.b(WeishiUtils.a(str1, 0));
    localWSOpenWeiShiData.a(WeishiUtils.a(str2, 0));
    return localWSOpenWeiShiData;
  }
  
  public String a()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.c();
    }
    return "";
  }
  
  public void a()
  {
    this.a = WSExpPolicyManager.a().a();
    WSReportUtils.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSExpABTestManager.java][init] expPolicyEntities:");
    localStringBuilder.append(this.a.toString());
    WSLog.d("WSExpABTestManager", localStringBuilder.toString());
  }
  
  public boolean a()
  {
    return TextUtils.equals(a("FeedsListClient_Preload", "open_apk_preload"), "1");
  }
  
  public int b()
  {
    return WeishiUtils.a(a("QQFeedScaleType", "type"), 0);
  }
  
  public String b()
  {
    return a("RecommendSubTab", "tabData");
  }
  
  public boolean b()
  {
    return TextUtils.equals(a("AioForwardScene", "scene"), "1");
  }
  
  public int c()
  {
    return WeishiUtils.a(a("LoadMoreCount", "count_load_more_first"), 12);
  }
  
  public String c()
  {
    return a("TrendsEntrance", "jump_type");
  }
  
  public boolean c()
  {
    return TextUtils.equals(a("QQFeedPlayerType", "enable_codec_reuse"), "1");
  }
  
  public int d()
  {
    return WeishiUtils.a(a("LoadMoreCount", "count_load_more_common"), 12);
  }
  
  public String d()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.b();
    }
    return "";
  }
  
  public boolean d()
  {
    return TextUtils.equals(a("FeedLoopPlay", "loop_play_type"), "1");
  }
  
  public boolean e()
  {
    return TextUtils.equals(a("QQFollowPageMute", "show"), "1");
  }
  
  public boolean f()
  {
    WSSubTabData localWSSubTabData = WSSubTabsHelper.a(a().b());
    return (localWSSubTabData != null) && (localWSSubTabData.a != null) && (localWSSubTabData.a.size() != 0);
  }
  
  public boolean g()
  {
    return "1".equals(a("DramaCleanMode", "showType"));
  }
  
  public boolean h()
  {
    return "1".equals(a("ShowDramaPage", "follow_show"));
  }
  
  public boolean i()
  {
    return "1".equals(a("AppPullOptimization", "switch"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager
 * JD-Core Version:    0.7.0.1
 */