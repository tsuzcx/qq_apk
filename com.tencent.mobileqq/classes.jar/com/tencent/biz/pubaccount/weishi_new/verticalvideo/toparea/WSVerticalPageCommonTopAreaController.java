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
  private WSVerticalPageFragment a;
  private View b;
  private View c;
  
  public WSVerticalPageCommonTopAreaController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.a = paramWSVerticalPageFragment;
  }
  
  private void f()
  {
    if (this.a.a() == null) {
      return;
    }
    WSVerticalVideoHolder localWSVerticalVideoHolder = this.a.a().a();
    if (localWSVerticalVideoHolder != null) {
      localWSVerticalVideoHolder.d();
    }
    g();
  }
  
  private void g()
  {
    if (this.a.a() != null) {
      this.a.a().a(this.a.a());
    }
  }
  
  protected void a() {}
  
  public void a(boolean paramBoolean)
  {
    View localView = this.c;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public void a(boolean paramBoolean, MiniAIOPresenter paramMiniAIOPresenter)
  {
    if ((this.b != null) && (paramMiniAIOPresenter != null))
    {
      paramMiniAIOPresenter.a(paramBoolean);
      View localView = this.b;
      int i;
      if ((paramMiniAIOPresenter.a() > 0) && (paramBoolean)) {
        i = 0;
      } else {
        i = 4;
      }
      localView.setVisibility(i);
    }
  }
  
  protected int b()
  {
    return 2131560010;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380469);
    WSVerticalUtils.a(this.a.getBaseActivity(), localRelativeLayout);
    a(2131380470).setOnClickListener(new WSVerticalPageCommonTopAreaController.1(this));
    this.c = a(2131380472);
    this.c.setOnClickListener(new WSVerticalPageCommonTopAreaController.2(this));
    this.b = a(2131369274);
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController
 * JD-Core Version:    0.7.0.1
 */