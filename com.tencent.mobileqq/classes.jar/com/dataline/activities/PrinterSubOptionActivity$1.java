package com.dataline.activities;

import android.view.View;
import com.dataline.data.PrinterManager;
import com.dataline.data.PrinterManager.PrinterUpdateObserver;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.widget.XListView;
import java.util.List;

class PrinterSubOptionActivity$1
  implements PrinterManager.PrinterUpdateObserver
{
  PrinterSubOptionActivity$1(PrinterSubOptionActivity paramPrinterSubOptionActivity) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a != null)
    {
      List localList = this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a();
      if ((localList != null) && (localList.size() <= 0))
      {
        this.a.findViewById(2131366222).setVisibility(0);
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
      }
      else
      {
        PrinterSubOptionActivity.a(this.a);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.PrinterSubOptionActivity.1
 * JD-Core Version:    0.7.0.1
 */