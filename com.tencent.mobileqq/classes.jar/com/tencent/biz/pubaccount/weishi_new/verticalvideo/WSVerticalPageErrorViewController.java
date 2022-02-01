package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSVerticalPageErrorViewController
  extends AbsWsUIGroup
{
  private WSVerticalPageFragment g;
  
  public WSVerticalPageErrorViewController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.g = paramWSVerticalPageFragment;
  }
  
  private void l()
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.g;
    if (localWSVerticalPageFragment != null)
    {
      localWSVerticalPageFragment.b(false, true);
      this.g.s();
      this.g.r();
    }
  }
  
  protected void a() {}
  
  protected void b() {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626049;
  }
  
  protected void j()
  {
    c(2131449395).setOnClickListener(new WSVerticalPageErrorViewController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageErrorViewController
 * JD-Core Version:    0.7.0.1
 */