package com.tencent.mobileqq.activity.aio.core;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class DiscussChatPie$2
  implements View.OnClickListener
{
  DiscussChatPie$2(DiscussChatPie paramDiscussChatPie, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((DiscussChatPie.a(this.b) != null) && (DiscussChatPie.a(this.b).isShowing())) {
      DiscussChatPie.a(this.b).dismiss();
    }
    if ((this.b.bi != null) && (this.b.bi.isShowing()))
    {
      this.b.bi.dismiss();
      this.b.bi = null;
    }
    DiscussChatPie.a(this.b, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.2
 * JD-Core Version:    0.7.0.1
 */