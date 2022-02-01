package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiVideoCtrlLayerUIBase$4
  implements View.OnClickListener
{
  MultiVideoCtrlLayerUIBase$4(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, TextView paramTextView1, ImageView paramImageView1, TextView paramTextView2, ImageView paramImageView2) {}
  
  public void onClick(View paramView)
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.P = true;
    ReportController.b(null, "CliOper", "", "", "0X800AEB8", "0X800AEB8", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.4
 * JD-Core Version:    0.7.0.1
 */