package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import vuf;
import vvd;
import vvj;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(vuf paramvuf, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Vuf.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Vuf.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          vvj localvvj = (vvj)localIterator.next();
          if (localvvj.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Vuf.a)) {
            localvvj.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Vuf.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Vuf.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Vuf.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */