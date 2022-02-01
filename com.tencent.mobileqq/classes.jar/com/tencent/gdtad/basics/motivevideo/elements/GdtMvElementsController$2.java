package com.tencent.gdtad.basics.motivevideo.elements;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtMvElementsController$2
  implements View.OnClickListener
{
  GdtMvElementsController$2(GdtMvElementsController paramGdtMvElementsController) {}
  
  public void onClick(View paramView)
  {
    GdtLog.b("GdtMvElementsController", "tips industry view onClick, do nothing");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.elements.GdtMvElementsController.2
 * JD-Core Version:    0.7.0.1
 */