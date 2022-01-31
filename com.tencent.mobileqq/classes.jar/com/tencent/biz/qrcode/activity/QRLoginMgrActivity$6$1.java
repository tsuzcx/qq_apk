package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import whc;
import wia;
import wig;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(whc paramwhc, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Whc.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Whc.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          wig localwig = (wig)localIterator.next();
          if (localwig.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Whc.a)) {
            localwig.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Whc.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Whc.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Whc.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */