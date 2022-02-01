package com.tencent.mobileqq.apollo.process.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameVideoViewController$4
  implements View.OnClickListener
{
  CmGameVideoViewController$4(CmGameVideoViewController paramCmGameVideoViewController) {}
  
  public void onClick(View paramView)
  {
    if ((CmGameVideoViewController.a(this.a).d()) || (CmGameVideoViewController.b(this.a)))
    {
      CmGameVideoViewController.b(this.a, false);
      CmGameVideoViewController.a(this.a).a();
      CmGameVideoViewController.c(this.a).setVisibility(8);
      CmGameVideoViewController.b(this.a).setVisibility(8);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (CmGameVideoViewController.a(this.a).c())
      {
        CmGameVideoViewController.b(this.a, true);
        CmGameVideoViewController.a(this.a).b();
        CmGameVideoViewController.b(this.a).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.4
 * JD-Core Version:    0.7.0.1
 */