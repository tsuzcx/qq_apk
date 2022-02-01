package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class c$b$1
  implements View.OnClickListener
{
  c$b$1(c.b paramb, c.c paramc, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b == 2)
    {
      this.b.setImageResource(2130841439);
      this.a.b = 1;
    }
    else if (this.a.b == 1)
    {
      this.b.setImageResource(2130841437);
      this.a.b = 2;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.c.b.1
 * JD-Core Version:    0.7.0.1
 */