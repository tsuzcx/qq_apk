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
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    View localView;
    if (this.c != null)
    {
      localView = this.c;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, MiniAIOPresenter paramMiniAIOPresenter)
  {
    View localView;
    if ((this.b != null) && (paramMiniAIOPresenter != null))
    {
      paramMiniAIOPresenter.a(paramBoolean);
      localView = this.b;
      if ((paramMiniAIOPresenter.a() <= 0) || (!paramBoolean)) {
        break label42;
      }
    }
    label42:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public int b()
  {
    return 2131560129;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void e()
  {
    if (this.a == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131381213);
    WSVerticalUtils.a(this.a.getActivity(), localRelativeLayout);
    a(2131381214).setOnClickListener(new WSVerticalPageCommonTopAreaController.1(this));
    this.c = a(2131381216);
    this.c.setOnClickListener(new WSVerticalPageCommonTopAreaController.2(this));
    this.b = a(2131369561);
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.toparea.WSVerticalPageCommonTopAreaController
 * JD-Core Version:    0.7.0.1
 */