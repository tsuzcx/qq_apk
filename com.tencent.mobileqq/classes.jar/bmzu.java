import NS_USER_ACTION_REPORT.ItemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager.ReportTask.1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class bmzu
{
  private final HashMap<bmzs, ArrayList<ItemInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  protected void a(bmzs parambmzs, ItemInfo paramItemInfo)
  {
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(parambmzs);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
          localArrayList1 = new ArrayList();
        }
        localArrayList1.add(paramItemInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put(parambmzs, localArrayList1);
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("MobileReport.Manager", 4, "start report!!!");
          }
          ThreadManager.post(new MobileReportManager.ReportTask.1(this), 2, null, true);
          return;
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("MobileReport.Manager", 4, "wait to report...");
  }
  
  public void a(HashMap<bmzs, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      bmzw localbmzw = new bmzw(null);
      localbmzw.a((bmzs)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localbmzw.a((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localbmzw.a());
    }
    bcvj.a(localAppRuntime, new bmzx(null).a(localAppRuntime.getLongAccountUin()).a(bnwt.c()).a(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzu
 * JD-Core Version:    0.7.0.1
 */