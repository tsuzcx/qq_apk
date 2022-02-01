package com.tencent.mobileqq.apollo.process.video;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameVideoViewController$1
  implements View.OnClickListener
{
  CmGameVideoViewController$1(CmGameVideoViewController paramCmGameVideoViewController) {}
  
  public void onClick(View paramView)
  {
    if (CmGameVideoViewController.a(this.a) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = CmGameVideoViewController.a(this.a).a();
    label63:
    CmGameVideoViewController localCmGameVideoViewController;
    if (bool)
    {
      CmGameVideoViewController.a(this.a).setImageDrawable(CmGameVideoViewController.a(this.a).getContext().getResources().getDrawable(2130838604));
      localCmGameVideoViewController = this.a;
      if (bool) {
        break label133;
      }
    }
    label133:
    for (bool = true;; bool = false)
    {
      CmGameVideoViewController.a(localCmGameVideoViewController, bool);
      CmGameVideoViewController.a(this.a).a(CmGameVideoViewController.a(this.a));
      break;
      CmGameVideoViewController.a(this.a).setImageDrawable(CmGameVideoViewController.a(this.a).getContext().getResources().getDrawable(2130838603));
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.1
 * JD-Core Version:    0.7.0.1
 */