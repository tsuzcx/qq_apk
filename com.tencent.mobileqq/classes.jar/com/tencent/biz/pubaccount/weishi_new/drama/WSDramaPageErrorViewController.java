package com.tencent.biz.pubaccount.weishi_new.drama;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;

public class WSDramaPageErrorViewController
  extends AbsWsUIGroup<Object>
{
  private final WSDramaPageFragment g;
  
  public WSDramaPageErrorViewController(Context paramContext, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext);
    this.g = paramWSDramaPageFragment;
  }
  
  private void l()
  {
    WSDramaPageFragment localWSDramaPageFragment = this.g;
    if (localWSDramaPageFragment != null)
    {
      localWSDramaPageFragment.b(false, true);
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
    c(2131449395).setOnClickListener(new WSDramaPageErrorViewController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageErrorViewController
 * JD-Core Version:    0.7.0.1
 */