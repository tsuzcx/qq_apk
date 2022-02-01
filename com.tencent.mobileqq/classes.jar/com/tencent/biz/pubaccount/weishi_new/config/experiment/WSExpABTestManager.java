package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.weishi_new.openws.data.WSOpenWeiShiData;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import java.util.ArrayList;
import java.util.Map;

public class WSExpABTestManager
{
  private WSExpPolicyEntities a = WSExpPolicyManager.a().c();
  
  public static WSExpABTestManager a()
  {
    return WSExpABTestManager.SingletonHolder.a();
  }
  
  @NonNull
  private String a(String paramString1, String paramString2)
  {
    return WSExpUtils.a(this.a, paramString1, paramString2);
  }
  
  public String A()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.b();
    }
    return "";
  }
  
  public void b()
  {
    this.a = WSExpPolicyManager.a().c();
    WSReportUtils.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSExpABTestManager.java][init] expPolicyEntities:");
    localStringBuilder.append(this.a.toString());
    WSLog.d("WSExpABTestManager", localStringBuilder.toString());
  }
  
  public String c()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.a();
    }
    return "";
  }
  
  public String d()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.d();
    }
    return "";
  }
  
  public boolean e()
  {
    return TextUtils.equals(a("FeedsListClient_Preload", "open_apk_preload"), "1");
  }
  
  public boolean f()
  {
    return TextUtils.equals(h(), "1");
  }
  
  public boolean g()
  {
    return TextUtils.equals(a("AioForwardScene", "scene"), "2");
  }
  
  public String h()
  {
    return a("AioForwardScene", "scene");
  }
  
  public boolean i()
  {
    return TextUtils.equals(a("QQFeedPlayerType", "enable_codec_reuse"), "1");
  }
  
  public boolean j()
  {
    return TextUtils.equals(a("FeedLoopPlay", "loop_play_type"), "1");
  }
  
  public boolean k()
  {
    return TextUtils.equals(a("QQFollowPageMute", "show"), "1");
  }
  
  public int l()
  {
    return WeishiUtils.a(a("QQFeedScaleType", "type"), 0);
  }
  
  public boolean m()
  {
    WSSubTabData localWSSubTabData = WSSubTabsHelper.a(a().n());
    return (localWSSubTabData != null) && (localWSSubTabData.a != null) && (localWSSubTabData.a.size() != 0);
  }
  
  public String n()
  {
    return a("RecommendSubTab", "tabData");
  }
  
  public int o()
  {
    return WeishiUtils.a(a("LoadMoreCount", "count_load_more_first"), 12);
  }
  
  public int p()
  {
    return WeishiUtils.a(a("LoadMoreCount", "count_load_more_common"), 12);
  }
  
  public int q()
  {
    return WeishiUtils.a(a("exp_wesee_mqq_app_loadmorecount_verticalpage", "count"), 3);
  }
  
  public String r()
  {
    return a("TrendsEntrance", "jump_type");
  }
  
  public boolean s()
  {
    return "1".equals(a("DramaCleanMode", "showType"));
  }
  
  public boolean t()
  {
    return "1".equals(a("ShowDramaPage", "follow_show"));
  }
  
  public int u()
  {
    return WeishiUtils.a(a("StickWSAioEntrance", "threshold_index"), 9);
  }
  
  public boolean v()
  {
    return "1".equals(a("StickWSAioEntrance", "switch"));
  }
  
  public boolean w()
  {
    return "1".equals(a("AppPullOptimization", "switch"));
  }
  
  @NonNull
  public WSOpenWeiShiData x()
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
  
  @Nullable
  public Map<String, String> y()
  {
    return WSExpUtils.a(this.a, "exp_wesee_mqq_comment_at");
  }
  
  @Nullable
  public Map<String, String> z()
  {
    return WSExpUtils.a(this.a, "exp_wesee_mqq_combo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager
 * JD-Core Version:    0.7.0.1
 */