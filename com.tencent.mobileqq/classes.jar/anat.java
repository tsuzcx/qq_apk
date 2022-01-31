import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.QIMReportController;
import com.tencent.mobileqq.statistics.reportitem.QIMMsgReportItem;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.DataReporter;
import java.util.Iterator;
import java.util.List;

public class anat
  implements Runnable
{
  public anat(DataReporter paramDataReporter, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QIMMsgReportItem localQIMMsgReportItem = (QIMMsgReportItem)localIterator.next();
        QIMReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQIMMsgReportItem);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMReportController.DataReporter", 2, Log.getStackTraceString(localThrowable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */