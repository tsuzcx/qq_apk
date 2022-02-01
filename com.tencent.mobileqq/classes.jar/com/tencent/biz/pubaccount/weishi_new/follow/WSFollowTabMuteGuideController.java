package com.tencent.biz.pubaccount.weishi_new.follow;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class WSFollowTabMuteGuideController
  extends AbsWsUIGroup
{
  private DiniFlyAnimationView g;
  private WSFollowFeedHolder h;
  
  public WSFollowTabMuteGuideController(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    this.h = paramWSFollowFeedHolder;
  }
  
  private void m()
  {
    l();
    WSPlayerManager localWSPlayerManager = this.h.d();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.o())) {
      this.h.a(localWSPlayerManager);
    }
  }
  
  private void n()
  {
    this.g.addAnimatorListener(new WSFollowTabMuteGuideController.2(this));
    this.g.playAnimation();
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626455;
  }
  
  protected void j()
  {
    this.g = ((DiniFlyAnimationView)c(2131436031));
    this.g.setAnimation("wsfollow/muteguide/muteguide.json");
    this.g.setImageAssetsFolder("wsfollow/muteguide/images");
    this.g.setOnClickListener(new WSFollowTabMuteGuideController.1(this));
  }
  
  public void l()
  {
    if (this.h.f())
    {
      n();
      this.h.e();
      WSLog.e("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.WSFollowTabMuteGuideController
 * JD-Core Version:    0.7.0.1
 */