package com.tencent.biz.pubaccount.weishi_new.config.experiment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

public class WSExpPreloadABTestManager
{
  private WSExpPolicyEntities a;
  
  private WSExpPreloadABTestManager()
  {
    a();
  }
  
  public static WSExpPreloadABTestManager a()
  {
    return WSExpPreloadABTestManager.SingletonHolder.a();
  }
  
  private String a(WSExpPolicyEntities paramWSExpPolicyEntities, String paramString1, String paramString2)
  {
    return WSExpUtils.a(paramWSExpPolicyEntities, paramString1, paramString2);
  }
  
  private boolean b(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    return TextUtils.equals(a(paramWSExpPolicyEntities, "QQFeedsPreload", "is_preload_data"), "1");
  }
  
  public long a()
  {
    long l = WeishiUtils.a(a(this.a, "QQFeedsPreload", "valid_duration"), 18000L);
    if (l <= 0L) {
      return 18000L;
    }
    return l;
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
  }
  
  public void a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    this.a = paramWSExpPolicyEntities;
  }
  
  public boolean a()
  {
    return TextUtils.equals(a(this.a, "AioForwardScene", "scene"), "1");
  }
  
  public boolean a(WSExpPolicyEntities paramWSExpPolicyEntities)
  {
    if (paramWSExpPolicyEntities == null) {
      return false;
    }
    return paramWSExpPolicyEntities.equals(this.a);
  }
  
  public boolean b()
  {
    return TextUtils.equals(a(this.a, "AioForwardScene", "image_pre_download"), "1");
  }
  
  public boolean c()
  {
    return b(this.a);
  }
  
  public boolean d()
  {
    return TextUtils.equals(a(this.a, "QQFeedsPreload", "is_preload_out_valid_duration"), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPreloadABTestManager
 * JD-Core Version:    0.7.0.1
 */