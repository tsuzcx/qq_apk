package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DrawHbFragment$3
  implements View.OnClickListener
{
  DrawHbFragment$3(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if ((paramView instanceof TextView))
    {
      DrawHbFragment.a(this.a).setText(((TextView)paramView).getText().toString());
      DrawHbFragment.a(this.a).addHbUploadData("draw.wrappacket.choose");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment.3
 * JD-Core Version:    0.7.0.1
 */