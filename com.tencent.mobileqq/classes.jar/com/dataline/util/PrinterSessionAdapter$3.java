package com.dataline.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PrinterSessionAdapter$3
  implements View.OnClickListener
{
  PrinterSessionAdapter$3(PrinterSessionAdapter paramPrinterSessionAdapter, PrinterItemMsgRecord paramPrinterItemMsgRecord, Context paramContext) {}
  
  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    if (2131431703 == paramView.getId())
    {
      PrinterSessionAdapter.3.1 local1 = new PrinterSessionAdapter.3.1(this);
      PrinterSessionAdapter.3.2 local2 = new PrinterSessionAdapter.3.2(this);
      Context localContext = this.b;
      DialogUtil.a(localContext, 230, localContext.getString(2131891303), this.b.getString(2131891281), 2131887648, 2131891322, local1, local2).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter.3
 * JD-Core Version:    0.7.0.1
 */