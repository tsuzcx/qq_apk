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
    if (this.a != null)
    {
      this.a.a(false, true);
      this.a.d();
      this.a.c();
    }
  }
  
  public void a() {}
  
  public int b()
  {
    return 2131560126;
  }
  
  public void b() {}
  
  public void c() {}
  
  public void e()
  {
    a(2131381190).setOnClickListener(new WSVerticalPageErrorViewController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageErrorViewController
 * JD-Core Version:    0.7.0.1
 */