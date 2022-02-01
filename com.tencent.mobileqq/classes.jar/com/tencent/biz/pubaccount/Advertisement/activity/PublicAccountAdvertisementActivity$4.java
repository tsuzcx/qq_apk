package com.tencent.biz.pubaccount.Advertisement.activity;

import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnPagerChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.imaxad.ImaxAdPresenter;
import com.tencent.mobileqq.statistics.ReportController;

class PublicAccountAdvertisementActivity$4
  implements VerticalPagerView.OnPagerChangedListener
{
  PublicAccountAdvertisementActivity$4(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void a(VerticalPagerView paramVerticalPagerView, View paramView, int paramInt)
  {
    paramVerticalPagerView = this.a;
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    PublicAccountAdvertisementActivity.c(paramVerticalPagerView, bool);
    if (PublicAccountAdvertisementActivity.f(this.a))
    {
      PublicAccountAdvertisementActivity.l(this.a).b(true);
      PublicAccountAdvertisementActivity.l(this.a).onResume();
      PublicAccountAdvertisementActivity.m(this.a);
      PublicAccountAdvertisementActivity.a(this.a, System.currentTimeMillis());
      if (PublicAccountAdvertisementActivity.n(this.a) > PublicAccountAdvertisementActivity.o(this.a))
      {
        paramVerticalPagerView = this.a;
        PublicAccountAdvertisementActivity.b(paramVerticalPagerView, PublicAccountAdvertisementActivity.p(paramVerticalPagerView) + (PublicAccountAdvertisementActivity.n(this.a) - PublicAccountAdvertisementActivity.o(this.a)));
      }
      paramVerticalPagerView = PublicAccountAdvertisementActivity.i(this.a);
      PublicAccountAdvertisementActivity.i(this.a);
      paramVerticalPagerView.setMode(1);
      if (!PublicAccountAdvertisementActivity.l(this.a).a())
      {
        PublicAccountAdvertisementActivity.i(this.a).setVisibility(8);
        PublicAccountAdvertisementActivity.l(this.a).a(false);
      }
    }
    else
    {
      if (PublicAccountAdvertisementActivity.q(this.a))
      {
        PublicAccountAdvertisementActivity.d(this.a, false);
        if (this.a.a()) {
          this.a.e.sendEmptyMessage(5);
        }
      }
      PublicAccountAdvertisementActivity.g(this.a);
      PublicAccountAdvertisementActivity.l(this.a).b(false);
      PublicAccountAdvertisementActivity.l(this.a).onPause();
      PublicAccountAdvertisementActivity.i(this.a).b();
      paramVerticalPagerView = PublicAccountAdvertisementActivity.i(this.a);
      PublicAccountAdvertisementActivity.i(this.a);
      paramVerticalPagerView.setMode(2);
      PublicAccountAdvertisementActivity.i(this.a).setVisibility(0);
      PublicAccountAdvertisementActivity.c(this.a, System.currentTimeMillis());
      paramVerticalPagerView = PublicAccountAdvertisementActivity.h(this.a).g.a;
      paramView = PublicAccountAdvertisementActivity.h(this.a).g.c;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PublicAccountAdvertisementActivity.r(this.a));
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(PublicAccountAdvertisementActivity.h(this.a).g.n);
      ReportController.a(null, "dc00898", "", paramVerticalPagerView, "0X8008F68", "0X8008F68", 0, 0, paramView, (String)localObject, localStringBuilder.toString(), PublicAccountAdvertisementActivity.h(this.a).g.b);
      paramVerticalPagerView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramVerticalPagerView instanceof ToolAppRuntime)) {
        ImaxAdPresenter.a().a(PublicAccountAdvertisementActivity.h(this.a), this.a, (AppInterface)((ToolAppRuntime)paramVerticalPagerView).onGetSubRuntime("imax"));
      }
      PublicAccountAdvertisementActivity.b(this.a, 0);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    PublicAccountAdvertisementActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.4
 * JD-Core Version:    0.7.0.1
 */