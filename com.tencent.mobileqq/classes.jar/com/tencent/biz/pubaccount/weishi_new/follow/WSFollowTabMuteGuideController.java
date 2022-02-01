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
  private WSFollowFeedHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  
  public WSFollowTabMuteGuideController(Context paramContext, WSFollowFeedHolder paramWSFollowFeedHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder = paramWSFollowFeedHolder;
  }
  
  private void g()
  {
    f();
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.i())) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a(localWSPlayerManager);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new WSFollowTabMuteGuideController.2(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  public void a() {}
  
  public int b()
  {
    return 2131560523;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131369336));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/muteguide/muteguide.json");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetsFolder("wsfollow/muteguide/images");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new WSFollowTabMuteGuideController.1(this));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.a())
    {
      h();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newHolderWSFollowFeedHolder.d();
      WSLog.e("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.WSFollowTabMuteGuideController
 * JD-Core Version:    0.7.0.1
 */