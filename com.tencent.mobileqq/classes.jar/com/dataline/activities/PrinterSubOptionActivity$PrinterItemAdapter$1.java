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
    Object localObject = (TextView)paramView.findViewById(2131364472);
    PrinterSubOptionActivity.CloudPrinter localCloudPrinter;
    if (localObject != null)
    {
      localCloudPrinter = (PrinterSubOptionActivity.CloudPrinter)this.a.a.b.get(((Integer)((TextView)localObject).getTag()).intValue());
      if (localCloudPrinter.jdField_a_of_type_Long == 0L) {
        break label150;
      }
    }
    label150:
    for (localObject = this.a.a.a.a.a(localCloudPrinter.jdField_a_of_type_Long);; localObject = this.a.a.a.a.b(localCloudPrinter.jdField_a_of_type_JavaLangString))
    {
      this.a.a.a.a.a = ((PrinterEntity)localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("sPrinterName", localCloudPrinter.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("sPrintDin", localCloudPrinter.jdField_a_of_type_Long);
      this.a.a.setResult(-1, (Intent)localObject);
      this.a.a.finish();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.PrinterItemAdapter.1
 * JD-Core Version:    0.7.0.1
 */