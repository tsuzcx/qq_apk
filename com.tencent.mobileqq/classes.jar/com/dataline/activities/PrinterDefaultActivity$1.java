package com.dataline.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrinterDefaultActivity$1
  implements View.OnClickListener
{
  PrinterDefaultActivity$1(PrinterDefaultActivity paramPrinterDefaultActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity.1
 * JD-Core Version:    0.7.0.1
 */