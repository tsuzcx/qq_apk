package com.tencent.mobileqq.activity.aio.doodle;

import addv;
import adeq;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class LoadDataJob$1
  implements Runnable
{
  LoadDataJob$1(LoadDataJob paramLoadDataJob, addv paramaddv, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel begin:");
    }
    this.this$0.a(this.jdField_a_of_type_Addv, LoadDataJob.a(this.this$0, this.this$0.a, false));
    if (this.this$0.a(this.jdField_a_of_type_JavaUtilList, LoadDataJob.b(this.this$0, this.this$0.a, false)))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((adeq)localIterator.next()).b();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "run write parcel end:");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.1
 * JD-Core Version:    0.7.0.1
 */