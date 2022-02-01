package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.AbsWSVerticalPagePresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemVideoAreaController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private FrameLayout g;
  private KandianUrlImageView h;
  private ProgressBar i;
  private TextView j;
  private View k;
  private View l;
  private WSVerticalVideoHolder m;
  private WSVerticalPageFragment n;
  
  public WSVerticalItemVideoAreaController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.m = paramWSVerticalVideoHolder;
    if (paramWSVerticalVideoHolder != null) {
      this.n = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (s())
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    WSPicLoader.a().a(this.h, paramstSimpleMetaFeed, false, "fullscreen_videoplay", h());
  }
  
  private void a(boolean paramBoolean)
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.n;
    if (localWSVerticalPageFragment != null)
    {
      if (localWSVerticalPageFragment.aO_() == null) {
        return;
      }
      WSVerticalBeaconReport.a(this.n.k(), this.n.l(), this.c, this.n.F(), paramBoolean, ((WSVerticalPageContract.Presenter)this.n.aO_()).n());
    }
  }
  
  private void r()
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.n;
    if ((localWSVerticalPageFragment != null) && (!((WSVerticalPageContract.Presenter)localWSVerticalPageFragment.aO_()).r())) {
      this.b.setPadding(0, 0, 0, 0);
    }
  }
  
  private boolean s()
  {
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.m;
    return (localWSVerticalVideoHolder != null) && (localWSVerticalVideoHolder.f != null) && (this.m.f.d != null) && (this.m.f.d.e());
  }
  
  private stSimpleMetaFeed t()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      return localWSVerticalItemData.b();
    }
    return null;
  }
  
  private void u()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      localObject = ((WSVerticalPageFragment)localObject).b();
      if (localObject != null)
      {
        localObject = ((WSVerticalPageAdapter)localObject).b();
        if (localObject == null) {
          return;
        }
        if ((this.n.aO_() instanceof AbsWSVerticalPagePresenter))
        {
          AbsWSVerticalPagePresenter localAbsWSVerticalPagePresenter = (AbsWSVerticalPagePresenter)this.n.aO_();
          if (!localAbsWSVerticalPagePresenter.e)
          {
            WSVerticalBeaconReport.a(this.n.k(), this.n.l(), ((WSVerticalVideoHolder)localObject).f, ((WSVerticalVideoHolder)localObject).getAdapterPosition() - 1, ((WSVerticalPageContract.Presenter)this.n.aO_()).n());
            localAbsWSVerticalPagePresenter.e = true;
          }
        }
      }
    }
  }
  
  private WSPlayerManager v()
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.n;
    if ((localWSVerticalPageFragment != null) && (localWSVerticalPageFragment.b() != null)) {
      return this.n.b().d();
    }
    return null;
  }
  
  private void w()
  {
    WSPlayerManager localWSPlayerManager = v();
    if (localWSPlayerManager != null)
    {
      WSVerticalVideoHolder localWSVerticalVideoHolder = this.m;
      if (localWSVerticalVideoHolder != null) {
        localWSPlayerManager.b(localWSVerticalVideoHolder.f, false);
      }
    }
  }
  
  protected void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    KandianUrlImageView localKandianUrlImageView = this.h;
    if (localKandianUrlImageView == null) {
      return;
    }
    if (paramInt1 == localKandianUrlImageView.getVisibility()) {
      return;
    }
    WeishiUtils.a(this.h, paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    this.k.setVisibility(0);
    this.j.setVisibility(0);
    this.j.setText(paramString);
  }
  
  protected void b()
  {
    stSimpleMetaFeed localstSimpleMetaFeed = t();
    if (localstSimpleMetaFeed == null) {
      return;
    }
    a(localstSimpleMetaFeed);
    this.l.setVisibility(8);
    q();
  }
  
  public void d(int paramInt)
  {
    View localView = this.l;
    if (localView != null) {
      localView.setVisibility(paramInt);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626092;
  }
  
  protected void j()
  {
    this.g = ((FrameLayout)c(2131449415));
    this.h = ((KandianUrlImageView)c(2131449416));
    this.l = c(2131449420);
    this.i = ((ProgressBar)c(2131449413));
    this.j = ((TextView)c(2131449418));
    this.k = c(2131449417);
    this.k.setOnClickListener(new WSVerticalItemVideoAreaController.1(this));
    r();
  }
  
  public FrameLayout l()
  {
    return this.g;
  }
  
  public View m()
  {
    return this.h;
  }
  
  public void n()
  {
    WSPlayerManager localWSPlayerManager = v();
    if (localWSPlayerManager != null)
    {
      if (localWSPlayerManager.g())
      {
        localWSPlayerManager.c();
        a(false);
        return;
      }
      localWSPlayerManager.d();
      a(true);
      u();
    }
  }
  
  public void o()
  {
    this.i.setVisibility(0);
  }
  
  public void p()
  {
    this.i.setVisibility(8);
  }
  
  public void q()
  {
    this.k.setVisibility(8);
    this.j.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoAreaController
 * JD-Core Version:    0.7.0.1
 */