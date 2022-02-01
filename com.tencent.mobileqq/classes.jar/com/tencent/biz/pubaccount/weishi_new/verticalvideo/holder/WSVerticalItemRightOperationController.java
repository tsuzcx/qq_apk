package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi_new.event.WSClearModeEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import java.util.Map;

public class WSVerticalItemRightOperationController
  extends WSVerticalItemBottomOperationController
{
  @Nullable
  private ImageView m;
  private boolean n;
  
  public WSVerticalItemRightOperationController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext, paramWSVerticalVideoHolder);
  }
  
  private Map<String, String> a(@Nullable WSVerticalPageContract.Presenter paramPresenter)
  {
    if ((paramPresenter instanceof AbsWSVerticalPagePresenter)) {
      return ((AbsWSVerticalPagePresenter)paramPresenter).n();
    }
    return null;
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.m == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 2130853548;
    } else {
      i = 2130853549;
    }
    this.m.setImageResource(i);
  }
  
  private void u()
  {
    WSSimpleEventBus.a().a(new WSClearModeEvent(this.n ^ true));
    WSVerticalBeaconReport.h(this.g.k(), this.g.l(), this.g.F(), a((WSVerticalPageContract.Presenter)this.g.aO_()));
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    this.m = ((ImageView)((ViewStub)c(2131450020)).inflate());
    this.m.setOnClickListener(this);
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
    c(paramBoolean);
    a(this.i, l());
    a(this.h, m());
    a(this.j, n());
    a(this.k, o());
    a(this.l, p());
  }
  
  protected int i()
  {
    return 2131626088;
  }
  
  protected boolean l()
  {
    return (super.l()) && (!this.n);
  }
  
  protected boolean m()
  {
    return (super.m()) && (!this.n);
  }
  
  protected boolean n()
  {
    return (super.n()) && (!this.n);
  }
  
  protected boolean o()
  {
    return (super.o()) && (!this.n);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() != 2131449501) {
      return;
    }
    u();
  }
  
  protected boolean p()
  {
    return (super.p()) && (!this.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemRightOperationController
 * JD-Core Version:    0.7.0.1
 */