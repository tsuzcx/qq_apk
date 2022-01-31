package com.tencent.biz.qrcode.activity;

import java.util.ArrayList;
import java.util.Iterator;
import wgz;
import whx;
import wid;

public class QRLoginMgrActivity$6$1
  implements Runnable
{
  public QRLoginMgrActivity$6$1(wgz paramwgz, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      this.jdField_a_of_type_Wgz.a.finish();
    }
    do
    {
      return;
      if (QRLoginMgrActivity.a(this.jdField_a_of_type_Wgz.a) != -1L)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          wid localwid = (wid)localIterator.next();
          if (localwid.a == QRLoginMgrActivity.a(this.jdField_a_of_type_Wgz.a)) {
            localwid.c = QRLoginMgrActivity.a(this.jdField_a_of_type_Wgz.a);
          }
        }
      }
    } while (QRLoginMgrActivity.a(this.jdField_a_of_type_Wgz.a) == null);
    QRLoginMgrActivity.a(this.jdField_a_of_type_Wgz.a).a(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6.1
 * JD-Core Version:    0.7.0.1
 */