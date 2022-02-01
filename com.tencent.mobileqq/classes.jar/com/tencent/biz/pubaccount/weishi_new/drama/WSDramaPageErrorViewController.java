package com.tencent.biz.pubaccount.weishi_new.drama;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSDramaPageErrorViewController
  extends AbsWsUIGroup<Object>
{
  private final WSDramaPageFragment a;
  
  public WSDramaPageErrorViewController(Context paramContext, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext);
    this.a = paramWSDramaPageFragment;
  }
  
  private void f()
  {
    WSDramaPageFragment localWSDramaPageFragment = this.a;
    if (localWSDramaPageFragment != null)
    {
      localWSDramaPageFragment.a(false, true);
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
    a(2131380443).setOnClickListener(new WSDramaPageErrorViewController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageErrorViewController
 * JD-Core Version:    0.7.0.1
 */