package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import yaa;
import yay;
import ybe;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(yaa paramyaa, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Yaa.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Yaa.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          ybe localybe = (ybe)localIterator.next();
          if (localybe.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Yaa.a)) {
            localybe.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Yaa.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Yaa.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Yaa.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */