package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSVerticalPageErrorViewController
  extends AbsWsUIGroup
{
  private WSVerticalPageFragment a;
  
  public WSVerticalPageErrorViewController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.a = paramWSVerticalPageFragment;
  }
  
  private void f()
  {
    WSVerticalPageFragment localWSVerticalPageFragment = this.a;
    if (localWSVerticalPageFragment != null)
    {
      localWSVerticalPageFragment.a(false, true);
      this.a.d();
      this.a.c();
    }
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560006;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    a(2131380443).setOnClickListener(new WSVerticalPageErrorViewController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageErrorViewController
 * JD-Core Version:    0.7.0.1
 */