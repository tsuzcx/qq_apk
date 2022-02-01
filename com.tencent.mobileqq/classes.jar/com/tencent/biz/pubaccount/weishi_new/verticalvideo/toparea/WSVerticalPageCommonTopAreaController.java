package com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.miniaio.MiniAIOPresenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;

public class WSVerticalPageCommonTopAreaController
  extends AbsWsUIGroup<Object>
{
  private View g;
  private View h;
  private WSVerticalPageFragment i;
  
  public WSVerticalPageCommonTopAreaController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.i = paramWSVerticalPageFragment;
  }
  
  private void l()
  {
    if (this.i.b() == null) {
      return;
    }
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.i.b().b();
    if (localWSVerticalVideoHolder != null) {
      localWSVerticalVideoHolder.j();
    }
    m();
  }
  
  private void m()
  {
    if (this.i.J() != null) {
      this.i.J().a(this.i.aY_());
    }
  }
  
  protected void a() {}
  
  public void a(boolean paramBoolean)
  {
    View localView = this.h;
    if (localView != null)
    {
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 8;
      }
      localView.setVisibility(j);
    }
  }
  
  public void a(boolean paramBoolean, MiniAIOPresenter paramMiniAIOPresenter)
  {
    if ((this.g != null) && (paramMiniAIOPresenter != null))
    {
      paramMiniAIOPresenter.a(paramBoolean);
      View localView = this.g;
      int j;
      if ((paramMiniAIOPresenter.b() > 0) && (paramBoolean)) {
        j = 0;
      } else {
        j = 4;
      }
      localView.setVisibility(j);
    }
  }
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626053;
  }
  
  protected void j()
  {
    if (this.i == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)c(2131449422);
    WSVerticalUtils.a(this.i.getBaseActivity(), localRelativeLayout);
    c(2131449423).setOnClickListener(new WSVerticalPageCommonTopAreaController.1(this));
    this.h = c(2131449425);
    this.h.setOnClickListener(new WSVerticalPageCommonTopAreaController.2(this));
    this.g = c(2131436253);
    this.i.a(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController
 * JD-Core Version:    0.7.0.1
 */