import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.CancellationSignalCompat;
import com.tencent.mm.vfs.StatisticsCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class bdze
  implements StatisticsCallback
{
  private static CopyOnWriteArrayList<Map<String, Object>> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static CopyOnWriteArrayList<Throwable> b = new CopyOnWriteArrayList();
  
  private void a(Throwable paramThrowable)
  {
    azpo.a(paramThrowable);
  }
  
  protected void a()
  {
    try
    {
      jdField_a_of_type_Boolean = true;
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      Iterator localIterator2 = jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator2.hasNext())
      {
        Map localMap = (Map)localIterator2.next();
        if (QLog.isColorLevel()) {
          QLog.d("VFSRegisterProxy", 2, "statisticsReportCache params -> " + localMap);
        }
        azri.a(BaseApplicationImpl.getContext()).a(str, "vfs_statistics_tag", true, 0L, 0L, (HashMap)localMap, null);
      }
      jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    }
    catch (Exception localException)
    {
      QLog.d("VFSRegisterProxy", 1, "statisticsReportCache report error!", localException);
      return;
    }
    Iterator localIterator1 = b.iterator();
    while (localIterator1.hasNext()) {
      a((Throwable)localIterator1.next());
    }
    b.clear();
  }
  
  public void deleteFiles(CancellationSignalCompat paramCancellationSignalCompat) {}
  
  public void reportError(Throwable paramThrowable)
  {
    QLog.e("VFSRegisterProxy", 1, paramThrowable, new Object[0]);
    if (jdField_a_of_type_Boolean)
    {
      a(paramThrowable);
      return;
    }
    b.add(paramThrowable);
  }
  
  public void statistics(String paramString, int paramInt, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      try
      {
        paramMap.put("id", paramString);
        paramMap.put("phase", String.valueOf(paramInt));
        if (jdField_a_of_type_Boolean)
        {
          paramString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          azri.a(BaseApplicationImpl.getContext()).a(paramString, "vfs_statistics_tag", true, 0L, 0L, (HashMap)paramMap, null);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("VFSRegisterProxy", 2, "report params -> " + paramMap + ", mCanAccurReport = " + jdField_a_of_type_Boolean);
          return;
          jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramMap);
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.d("VFSRegisterProxy", 1, "vfs report error!", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdze
 * JD-Core Version:    0.7.0.1
 */