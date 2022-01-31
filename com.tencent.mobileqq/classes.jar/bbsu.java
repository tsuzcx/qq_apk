import android.text.TextUtils;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenMgr.1;
import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailGenTask;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class bbsu
  implements bbsv
{
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, TroopFileThumbnailGenTask> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<TroopFileThumbnailGenTask> b = new LinkedList();
  private LinkedList<TroopFileThumbnailGenTask> c = new LinkedList();
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PRS:" + this.c.size() + " RS:" + this.b.size();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private LinkedList<TroopFileThumbnailGenTask> a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Map.Entry)localIterator.next()).getValue();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b())))
      {
        localLinkedList.add(localTroopFileThumbnailGenTask);
        localIterator.remove();
      }
    }
    return localLinkedList;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      TroopFileThumbnailGenTask localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)localIterator.next();
      if ((paramInt == localTroopFileThumbnailGenTask.a()) && (paramString.equalsIgnoreCase(localTroopFileThumbnailGenTask.b()))) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (this.b.size() >= 4) {}
    label179:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label179;
        }
        Object localObject = (String)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (TroopFileThumbnailGenTask)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null) {
          if (a(((TroopFileThumbnailGenTask)localObject).b(), ((TroopFileThumbnailGenTask)localObject).a()))
          {
            bbrc.b("TroopFileThumbnailGenMgr", bbrc.a, "[" + ((TroopFileThumbnailGenTask)localObject).a() + "] has same task gening. add WD task");
            this.c.add(localObject);
            ((TroopFileThumbnailGenTask)localObject).b();
          }
          else
          {
            this.b.add(localObject);
            if (((TroopFileThumbnailGenTask)localObject).a()) {
              break;
            }
            bbrc.a("TroopFileThumbnailGenMgr", bbrc.a, "[" + ((TroopFileThumbnailGenTask)localObject).a() + "] start failed!!");
            this.b.remove(localObject);
          }
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt, String paramString)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    if (paramInt == 0) {
      return -5;
    }
    String str = a(paramItem.Id, paramInt);
    if (a(str))
    {
      bbrc.c("TroopFileThumbnailGenMgr", bbrc.a, "[" + str + "] genFileThumbnail task exsited. ");
      return -4;
    }
    paramString = TroopFileThumbnailGenTask.a(paramLong, paramItem, paramInt, paramString, this);
    if (paramString == null) {
      return -3;
    }
    bbsw.a(paramItem, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, paramString);
    this.jdField_a_of_type_JavaUtilLinkedList.add(str);
    bbrc.c("TroopFileThumbnailGenMgr", bbrc.a, "[" + str + "] genFileThumbnail filePath:" + paramItem.LocalFile + a());
    d();
    return 0;
  }
  
  public int a(UUID paramUUID, int paramInt)
  {
    if (paramUUID == null) {
      return -2;
    }
    String str = a(paramUUID, paramInt);
    Object localObject = this.b.iterator();
    TroopFileThumbnailGenTask localTroopFileThumbnailGenTask;
    while (((Iterator)localObject).hasNext())
    {
      localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a()))
      {
        localTroopFileThumbnailGenTask.a();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = this.c.iterator();
        if (((Iterator)localObject).hasNext())
        {
          localTroopFileThumbnailGenTask = (TroopFileThumbnailGenTask)((Iterator)localObject).next();
          if (!str.equalsIgnoreCase(localTroopFileThumbnailGenTask.a())) {
            break label231;
          }
          localTroopFileThumbnailGenTask.a();
          ((Iterator)localObject).remove();
          paramInt = 1;
        }
      }
      label231:
      for (;;)
      {
        break;
        localObject = (TroopFileThumbnailGenTask)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        i = paramInt;
        if (localObject != null)
        {
          ((TroopFileThumbnailGenTask)localObject).a();
          i = paramInt | 0x1;
        }
        boolean bool = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | i;
        if (bool) {
          bbrc.c("TroopFileThumbnailGenMgr", bbrc.a, "[" + str + "] stopGen." + a());
        }
        d();
        return 0;
      }
    }
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    bbqt.a(new TroopFileThumbnailGenMgr.1(this, paramString, paramBoolean, paramInt, paramTroopFileThumbnailGenTask), false);
  }
  
  protected boolean a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((TroopFileThumbnailGenTask)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  public void b(String paramString, boolean paramBoolean, int paramInt, TroopFileThumbnailGenTask paramTroopFileThumbnailGenTask)
  {
    this.b.remove(paramTroopFileThumbnailGenTask);
    this.c.remove(paramTroopFileThumbnailGenTask);
    bbrc.c("TroopFileThumbnailGenMgr", bbrc.a, "[" + paramString + "] onTaskDoneInter.  bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    LinkedList localLinkedList = a(paramTroopFileThumbnailGenTask.b(), paramTroopFileThumbnailGenTask.a());
    if ((localLinkedList != null) && (localLinkedList.size() > 0))
    {
      bbrc.b("TroopFileThumbnailGenMgr", bbrc.a, "[" + paramString + "] onTaskDoneInter. " + localLinkedList.size() + " same task passive complete. " + a());
      paramString = localLinkedList.iterator();
      while (paramString.hasNext()) {
        ((TroopFileThumbnailGenTask)paramString.next()).a(paramBoolean, paramInt, paramTroopFileThumbnailGenTask.c());
      }
    }
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileThumbnailGenTask)localIterator.next()).a();
    }
    this.b.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.c.clear();
    bbrc.c("TroopFileThumbnailGenMgr", bbrc.a, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsu
 * JD-Core Version:    0.7.0.1
 */