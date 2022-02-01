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

public class blys
{
  private final HashMap<blyq, ArrayList<ItemInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  protected void a(blyq paramblyq, ItemInfo paramItemInfo)
  {
    do
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramblyq);
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
          localArrayList1 = new ArrayList();
        }
        localArrayList1.add(paramItemInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put(paramblyq, localArrayList1);
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
  
  public void a(HashMap<blyq, ArrayList<ItemInfo>> paramHashMap)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    ArrayList localArrayList = new ArrayList();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      blyu localblyu = new blyu(null);
      localblyu.a((blyq)((Map.Entry)localObject).getKey());
      localObject = ((ArrayList)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext()) {
        localblyu.a((ItemInfo)((Iterator)localObject).next());
      }
      localArrayList.add(localblyu.a());
    }
    bccr.a(localAppRuntime, new blyv(null).a(localAppRuntime.getLongAccountUin()).a(bmvl.c()).a(), localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blys
 * JD-Core Version:    0.7.0.1
 */