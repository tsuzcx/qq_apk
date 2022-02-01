package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import zts;
import zuq;
import zuw;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(zts paramzts, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Zts.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Zts.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          zuw localzuw = (zuw)localIterator.next();
          if (localzuw.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Zts.a)) {
            localzuw.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Zts.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Zts.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Zts.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */