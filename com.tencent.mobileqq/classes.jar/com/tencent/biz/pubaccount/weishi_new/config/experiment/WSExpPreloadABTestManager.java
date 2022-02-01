package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSExpPreloadABTestManager
{
  private WSExpPolicyEntities a;
  
  private WSExpPreloadABTestManager()
  {
    b();
  }
  
  public static WSExpPreloadABTestManager a()
  {
    return WSExpPreloadABTestManager.SingletonHolder.a();
  }
  
  private String a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString1, String paramString2)
  {
    return WSExpUtils.a(paramWSExpPolicyEntities, paramString1, paramString2);
  }
  
  private boolean c(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    return TextUtils.equals(a(paramWSExpPolicyEntities, "QQFeedsPreload", "is_preload_data"), "1");
  }
  
  public void a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    this.a = paramWSExpPolicyEntities;
  }
  
  public void b()
  {
    this.a = WSExpPolicyManager.a().c();
  }
  
  public boolean b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    if (paramWSExpPolicyEntities == null) {
      return false;
    }
    return paramWSExpPolicyEntities.equals(this.a);
  }
  
  public boolean c()
  {
    return TextUtils.equals(a(this.a, "AioForwardScene", "scene"), "1");
  }
  
  public boolean d()
  {
    return TextUtils.equals(a(this.a, "AioForwardScene", "image_pre_download"), "1");
  }
  
  public boolean e()
  {
    return c(this.a);
  }
  
  public long f()
  {
    long l = WeishiUtils.a(a(this.a, "QQFeedsPreload", "valid_duration"), 18000L);
    if (l <= 0L) {
      return 18000L;
    }
    return l;
  }
  
  public boolean g()
  {
    return TextUtils.equals(a(this.a, "QQFeedsPreload", "is_preload_out_valid_duration"), "1");
  }
  
  public String h()
  {
    WSExpPolicyEntities localWSExpPolicyEntities = this.a;
    if (localWSExpPolicyEntities != null) {
      return localWSExpPolicyEntities.d();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager
 * JD-Core Version:    0.7.0.1
 */