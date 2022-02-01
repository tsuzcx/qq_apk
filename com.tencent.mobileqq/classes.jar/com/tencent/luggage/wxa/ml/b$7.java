package com.tencent.luggage.wxa.ml;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public void onClick(View paramView)
  {
    o.d("MicroMsg.Video.AbstractVideoView", "%s seek bar play button on click ", new Object[] { this.a.v() });
    this.a.w();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.b.7
 * JD-Core Version:    0.7.0.1
 */