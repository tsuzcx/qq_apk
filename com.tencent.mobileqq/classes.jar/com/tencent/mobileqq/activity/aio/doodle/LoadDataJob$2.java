package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;

class LoadDataJob$2
  implements LoadDataJob.UnmarshallJobListener
{
  LoadDataJob$2(LoadDataJob paramLoadDataJob, Map paramMap, List paramList) {}
  
  public void a(int paramInt, PathDrawer paramPathDrawer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoadDataJob", 2, "unmarshall task finish id:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilMap.notifyAll();
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramPathDrawer);
      if (this.jdField_a_of_type_JavaUtilList.size() == LoadDataJob.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLoadDataJob)) {
        this.jdField_a_of_type_JavaUtilList.notifyAll();
      }
      return;
      paramPathDrawer = finally;
      throw paramPathDrawer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.2
 * JD-Core Version:    0.7.0.1
 */