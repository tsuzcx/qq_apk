package com.dataline.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class PrinterSessionAdapter$3$1
  implements DialogInterface.OnClickListener
{
  PrinterSessionAdapter$3$1(PrinterSessionAdapter.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.status < 10) {
      this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a(0, this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord.uSessionID, true);
    }
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.a.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataPrinterItemMsgRecord);
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.b();
    this.a.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */