package com.dataline.activities;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.data.PrinterEntity;
import com.dataline.data.PrinterManager;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class PrinterSubOptionActivity$PrinterItemAdapter$1
  implements View.OnClickListener
{
  PrinterSubOptionActivity$PrinterItemAdapter$1(PrinterSubOptionActivity.PrinterItemAdapter paramPrinterItemAdapter) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (TextView)paramView.findViewById(2131430390);
    if (localObject != null)
    {
      PrinterSubOptionActivity.CloudPrinter localCloudPrinter = (PrinterSubOptionActivity.CloudPrinter)this.a.a.h.get(((Integer)((TextView)localObject).getTag()).intValue());
      if (localCloudPrinter.a != 0L) {
        localObject = this.a.a.c.h.a(localCloudPrinter.a);
      } else {
        localObject = this.a.a.c.h.b(localCloudPrinter.b);
      }
      this.a.a.c.h.a = ((PrinterEntity)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sPrinterName", localCloudPrinter.b);
      ((Intent)localObject).putExtra("sPrintDin", localCloudPrinter.a);
      this.a.a.setResult(-1, (Intent)localObject);
      this.a.a.finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter.1
 * JD-Core Version:    0.7.0.1
 */