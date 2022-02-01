package com.tencent.biz.pubaccount.weishi_new.drama.holder.controller;

import UserGrowth.stDrama;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSDramaItemTopAreaController
  extends AbsWSDramaUIGroup
{
  private KandianUrlImageView j;
  
  public WSDramaItemTopAreaController(Context paramContext)
  {
    super(paramContext);
  }
  
  private void l()
  {
    if ((this.g != null) && (this.g.tagIcon != null))
    {
      this.j.setVisibility(0);
      WSPicLoader.a().a(this.j, this.g.tagIcon);
      return;
    }
    this.j.setVisibility(8);
  }
  
  protected void b()
  {
    l();
  }
  
  public void d(int paramInt) {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626047;
  }
  
  protected void j()
  {
    this.j = ((KandianUrlImageView)c(2131432164));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.WSDramaItemTopAreaController
 * JD-Core Version:    0.7.0.1
 */