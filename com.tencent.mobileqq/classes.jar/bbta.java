import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScanTask;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.2;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bbta
  implements bbsz
{
  private static long jdField_a_of_type_Long = 1L;
  private static bbta jdField_a_of_type_Bbta;
  private LinkedList<Long> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<Long, TroopFileScanTask> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<TroopFileScanTask> b = new LinkedList();
  private LinkedList<TroopFileScanTask> c = new LinkedList();
  
  public static bbta a()
  {
    try
    {
      if (jdField_a_of_type_Bbta == null) {
        jdField_a_of_type_Bbta = new bbta();
      }
      bbta localbbta = jdField_a_of_type_Bbta;
      return localbbta;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PRS:" + this.c.size() + " RS:" + this.b.size();
  }
  
  private LinkedList<TroopFileScanTask> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    TroopFileScanTask localTroopFileScanTask;
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)((Map.Entry)localIterator.next()).getValue();
      if (paramString.equalsIgnoreCase(localTroopFileScanTask.a()))
      {
        localLinkedList.add(localTroopFileScanTask);
        localIterator.remove();
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
      if (paramString.equalsIgnoreCase(localTroopFileScanTask.a()))
      {
        localLinkedList.add(localTroopFileScanTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private void a()
  {
    if (this.b.size() >= 2) {}
    label146:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label146;
        }
        long l = ((Long)this.jdField_a_of_type_JavaUtilLinkedList.remove(0)).longValue();
        TroopFileScanTask localTroopFileScanTask = (TroopFileScanTask)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(l));
        if (localTroopFileScanTask != null) {
          if (a(localTroopFileScanTask.a()))
          {
            bbrc.b("TroopFileScaner", bbrc.a, "[" + localTroopFileScanTask.a() + "] has same task gening. add WD task");
            this.c.add(localTroopFileScanTask);
            localTroopFileScanTask.b();
          }
          else
          {
            this.b.add(localTroopFileScanTask);
            if (localTroopFileScanTask.a()) {
              break;
            }
            this.b.remove(localTroopFileScanTask);
          }
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    int i = 1;
    Iterator localIterator = this.b.iterator();
    TroopFileScanTask localTroopFileScanTask;
    while (localIterator.hasNext())
    {
      localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
      if (paramLong == localTroopFileScanTask.a())
      {
        localTroopFileScanTask.a();
        localIterator.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          localTroopFileScanTask = (TroopFileScanTask)localIterator.next();
          if (paramLong != localTroopFileScanTask.a()) {
            break label215;
          }
          localTroopFileScanTask.a();
          localIterator.remove();
          bool1 = true;
        }
      }
      label215:
      for (;;)
      {
        break;
        if ((TroopFileScanTask)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(paramLong)) != null) {}
        for (;;)
        {
          bool2 = bool1 | i | this.jdField_a_of_type_JavaUtilLinkedList.remove(Long.valueOf(paramLong));
          if (bool2) {
            bbrc.c("TroopFileScaner", bbrc.a, "[" + paramLong + "] stopScan." + a());
          }
          return bool2;
          i = 0;
        }
      }
    }
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileScanTask)localIterator.next()).a())) {
        return true;
      }
    }
    return false;
  }
  
  private void b(long paramLong, boolean paramBoolean, int paramInt, TroopFileScanTask paramTroopFileScanTask)
  {
    this.b.remove(paramTroopFileScanTask);
    this.c.remove(paramTroopFileScanTask);
    bbrc.c("TroopFileScaner", bbrc.a, "[" + paramLong + "] onTaskDoneInter.  bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    Object localObject = a(paramTroopFileScanTask.a());
    if ((localObject != null) && (((LinkedList)localObject).size() > 0))
    {
      bbrc.b("TroopFileScaner", bbrc.a, "[" + paramLong + "] onTaskDoneInter. " + ((LinkedList)localObject).size() + " same task passive complete. " + a());
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TroopFileScanTask)((Iterator)localObject).next()).a(paramBoolean, paramInt, paramTroopFileScanTask.a(), paramTroopFileScanTask.b(), paramTroopFileScanTask.a(), paramTroopFileScanTask.b(), paramTroopFileScanTask.c(), paramTroopFileScanTask.a());
      }
    }
    a();
  }
  
  public long a(String paramString, bbtb parambbtb, Bundle paramBundle)
  {
    long l2 = jdField_a_of_type_Long;
    jdField_a_of_type_Long = l2 + 1L;
    long l1 = l2;
    if (l2 == 0L)
    {
      l1 = jdField_a_of_type_Long;
      jdField_a_of_type_Long = l1 + 1L;
    }
    parambbtb = TroopFileScanTask.a(l1, paramString, this, parambbtb);
    if (parambbtb == null) {
      return 0L;
    }
    bbqt.a(new TroopFileScaner.1(this, l1, parambbtb, paramString), true);
    return l1;
  }
  
  public void a(long paramLong)
  {
    bbqt.a(new TroopFileScaner.2(this, paramLong), true);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, TroopFileScanTask paramTroopFileScanTask)
  {
    bbqt.a(new TroopFileScaner.3(this, paramLong, paramBoolean, paramInt, paramTroopFileScanTask), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbta
 * JD-Core Version:    0.7.0.1
 */