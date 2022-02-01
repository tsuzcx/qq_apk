package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager;
import com.tencent.biz.pubaccount.weishi_new.combo.home.rightpager.WSComboVerticalVideoProgressManager.Companion;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSPlayerControlBar;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class WSVerticalItemVideoProgressController
  extends AbsWsUIGroup<WSVerticalItemData>
{
  private static final int g = ScreenUtil.dip2px(2.5F);
  private static final int h = ScreenUtil.dip2px(5.5F);
  private WSVerticalVideoRelativeLayout i;
  private WSVerticalVideoHolder j;
  private FrameLayout k;
  private WSPlayerControlBar l;
  private WSPlayerManager m;
  private boolean n;
  private final SeekBar.OnSeekBarChangeListener o = new WSVerticalItemVideoProgressController.3(this);
  
  public WSVerticalItemVideoProgressController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder, WSVerticalVideoRelativeLayout paramWSVerticalVideoRelativeLayout)
  {
    super(paramContext);
    this.j = paramWSVerticalVideoHolder;
    this.i = paramWSVerticalVideoRelativeLayout;
    paramContext = this.j;
    if ((paramContext != null) && (paramContext.d != null)) {
      this.m = this.j.d.e();
    }
  }
  
  private void q()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      localObject = ((WSVerticalVideoHolder)localObject).d;
      if ((localObject != null) && (!((WSVerticalPageContract.Presenter)((WSVerticalPageFragment)localObject).aO_()).r()))
      {
        localObject = (FrameLayout.LayoutParams)this.l.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
        this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (LinearLayout.LayoutParams)this.k.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).bottomMargin = (-g);
        ((LinearLayout.LayoutParams)localObject).height = h;
        this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void r()
  {
    if (this.i == null) {
      return;
    }
    WSVerticalItemVideoProgressController.1 local1 = new WSVerticalItemVideoProgressController.1(this);
    this.i.setDispatchTouchEventListener(new WSVerticalItemVideoProgressController.2(this, local1));
  }
  
  protected void a() {}
  
  public void a(float paramFloat)
  {
    WSPlayerControlBar localWSPlayerControlBar = this.l;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.setProgress(paramFloat);
    }
  }
  
  protected void b()
  {
    a(0.0F);
  }
  
  protected void f()
  {
    o();
  }
  
  protected int i()
  {
    return 2131626087;
  }
  
  protected void j()
  {
    this.k = ((FrameLayout)c(2131449763));
    this.l = ((WSPlayerControlBar)c(2131449754));
    this.l.setSeekBarChangeListener(this.o);
    r();
    q();
  }
  
  public WSPlayerControlBar l()
  {
    return this.l;
  }
  
  public void m()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.l;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.a();
    }
  }
  
  public void n()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.l;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.b();
    }
  }
  
  public void o()
  {
    WSPlayerControlBar localWSPlayerControlBar = this.l;
    if (localWSPlayerControlBar != null) {
      localWSPlayerControlBar.c();
    }
  }
  
  public boolean p()
  {
    return (this.n) || (WSComboVerticalVideoProgressManager.a.a().b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemVideoProgressController
 * JD-Core Version:    0.7.0.1
 */