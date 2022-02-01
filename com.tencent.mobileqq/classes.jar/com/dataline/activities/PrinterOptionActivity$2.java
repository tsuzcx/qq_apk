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
      PrinterOptionActivity.a(this.a).setVisibility(0);
      PrinterOptionActivity.a(this.a).setText(2131691447);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (PrinterOptionActivity.b(this.a))
      {
        PrinterOptionActivity.a(this.a).setVisibility(0);
        PrinterOptionActivity.a(this.a).setText(2131691427);
      }
      else
      {
        PrinterOptionActivity.a(this.a).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity.2
 * JD-Core Version:    0.7.0.1
 */