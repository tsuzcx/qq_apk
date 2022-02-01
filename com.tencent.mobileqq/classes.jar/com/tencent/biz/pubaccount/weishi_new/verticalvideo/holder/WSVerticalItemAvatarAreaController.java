package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.data.WSUserBusiness;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.open.base.ToastUtil;

public class WSVerticalItemAvatarAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private WSRoundedImageView g;
  private DiniFlyAnimationView h;
  private WSVerticalPageFragment i;
  private stSimpleMetaFeed j;
  
  public WSVerticalItemAvatarAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.i = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(stSimpleMetaPerson paramstSimpleMetaPerson)
  {
    if (paramstSimpleMetaPerson == null) {
      return;
    }
    if (TextUtils.equals(WeishiUtils.n(), paramstSimpleMetaPerson.id))
    {
      this.h.setVisibility(8);
      return;
    }
    if (this.h.isAnimating()) {
      this.h.cancelAnimation();
    }
    if (WSFeedUtils.b(paramstSimpleMetaPerson.followStatus))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setFrame(1);
    this.h.setVisibility(0);
  }
  
  private void l()
  {
    ((WSVerticalPageContract.Presenter)this.i.aO_()).a("profile", this.i, this.j);
  }
  
  private void m()
  {
    if (!NetworkUtil.a(d()))
    {
      ToastUtil.a().a(2131918123);
      return;
    }
    stSimpleMetaFeed localstSimpleMetaFeed = this.j;
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null))
    {
      if (this.h.isAnimating()) {
        return;
      }
      WSUserBusiness.a().a(this.j.poster.id, 1);
      WSVerticalBeaconReport.d(this.i.k(), this.i.l(), this.j, ((WSVerticalPageContract.Presenter)this.i.aO_()).n());
      WSReportDC898Vertical.d();
      n();
    }
  }
  
  private void n()
  {
    this.h.addAnimatorListener(new WSVerticalItemAvatarAreaController.1(this));
    this.h.playAnimation();
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData == null) {
      return;
    }
    if ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)) {
      this.j = localWSVerticalItemData.b();
    }
  }
  
  @UiThread
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.j;
    if (localstSimpleMetaFeed != null)
    {
      if (localstSimpleMetaFeed.poster == null) {
        return;
      }
      WSPicLoader.a().a(this.a, this.g, this.j.poster.avatar);
      a(this.j.poster);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626075;
  }
  
  protected void j()
  {
    this.g = ((WSRoundedImageView)c(2131449397));
    this.g.setOnClickListener(this);
    this.h = ((DiniFlyAnimationView)c(2131436295));
    this.h.setOnClickListener(this);
    this.h.setAnimation("wsfollow/followbtn.json");
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131436295)
    {
      if (k != 2131449397) {
        return;
      }
      l();
      return;
    }
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemAvatarAreaController
 * JD-Core Version:    0.7.0.1
 */