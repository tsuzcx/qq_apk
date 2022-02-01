package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import java.util.ArrayList;

public class WSExpABTestManager
{
  private WSExpPolicyEntities a;
  
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
    return WSExpUtils.a(a("QQFeedPlayerType", "type"), 0);
  }
  
  public String a()
  {
    if (this.a != null) {
      return this.a.c();
    }
    return "";
  }
  
  public void a()
  {
    this.a = WSExpPolicyManager.a().a();
    WSReportUtils.a();
    WSLog.e("WSExpABTestManager", "[WSExpABTestManager.java][init] expPolicyEntities:" + this.a.toString());
  }
  
  public boolean a()
  {
    return TextUtils.equals(a("FeedsListClient_Preload", "open_apk_preload"), "1");
  }
  
  public int b()
  {
    return WSExpUtils.a(a("QQFeedScaleType", "type"), 0);
  }
  
  public String b()
  {
    return a("RecommendSubTab", "tabData");
  }
  
  public boolean b()
  {
    return TextUtils.equals(a("AioForwardScene", "scene"), "1");
  }
  
  public String c()
  {
    if (this.a != null) {
      return this.a.b();
    }
    return "";
  }
  
  public boolean c()
  {
    return TextUtils.equals(a("QQFeedPlayerType", "enable_codec_reuse"), "1");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager
 * JD-Core Version:    0.7.0.1
 */