package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import xvr;
import xwp;
import xwv;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(xvr paramxvr, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Xvr.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Xvr.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          xwv localxwv = (xwv)localIterator.next();
          if (localxwv.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Xvr.a)) {
            localxwv.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Xvr.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Xvr.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Xvr.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */