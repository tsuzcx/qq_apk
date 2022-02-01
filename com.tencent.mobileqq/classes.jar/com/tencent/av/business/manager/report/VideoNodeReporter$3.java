package com.tencent.av.business.manager.report;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lie;
import lig;

public class VideoNodeReporter$3
  implements Runnable
{
  public VideoNodeReporter$3(lie paramlie, int paramInt, long paramLong) {}
  
  public void run()
  {
    QLog.d("VideoNodeReporter", 1, "in runnabe report ,node = " + this.jdField_a_of_type_Int + ",value = " + this.jdField_a_of_type_Long);
    if (this.this$0.a.size() > 0)
    {
      Iterator localIterator = this.this$0.a.iterator();
      while (localIterator.hasNext())
      {
        lig locallig = (lig)localIterator.next();
        this.this$0.a(locallig.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
      }
    }
    QLog.d("VideoNodeReporter", 1, " report ,node = " + this.jdField_a_of_type_Int + ",value = " + this.jdField_a_of_type_Long + ",seesionRecordList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeReporter.3
 * JD-Core Version:    0.7.0.1
 */