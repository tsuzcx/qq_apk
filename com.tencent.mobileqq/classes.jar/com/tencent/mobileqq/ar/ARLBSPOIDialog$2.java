package com.tencent.mobileqq.ar;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ARLBSPOIDialog$2
  implements View.OnClickListener
{
  ARLBSPOIDialog$2(ARLBSPOIDialog paramARLBSPOIDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSPOIDialog.2
 * JD-Core Version:    0.7.0.1
 */