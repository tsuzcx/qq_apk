package com.dataline.activities;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrinterOptionActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  PrinterOptionActivity$2(PrinterOptionActivity paramPrinterOptionActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      PrinterOptionActivity.b(this.a).setVisibility(0);
      PrinterOptionActivity.b(this.a).setText(2131888324);
    }
    else if (PrinterOptionActivity.c(this.a))
    {
      PrinterOptionActivity.b(this.a).setVisibility(0);
      PrinterOptionActivity.b(this.a).setText(2131888304);
    }
    else
    {
      PrinterOptionActivity.b(this.a).setVisibility(4);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity.2
 * JD-Core Version:    0.7.0.1
 */