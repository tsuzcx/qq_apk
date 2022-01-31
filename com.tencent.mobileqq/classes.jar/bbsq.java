import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class bbsq
  implements bbst
{
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, bbsr> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<bbsr> b = new LinkedList();
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " RS:" + this.b.size();
  }
  
  public static String a(UUID paramUUID, int paramInt)
  {
    return paramUUID.toString() + "_" + paramInt;
  }
  
  private void d()
  {
    if (this.b.size() >= 10) {}
    label79:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label79;
        }
        Object localObject = (String)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (bbsr)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((bbsr)localObject).a()) {
            break;
          }
          this.b.remove(localObject);
        }
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, int paramInt)
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
      bbrc.c("TroopFileThumbnailFetchMgr", bbrc.a, "[" + str + "] fetchFileThumbnail worker exsited. ");
      return -4;
    }
    bbsr localbbsr = bbsr.a(paramLong, paramItem, paramInt, this);
    if (localbbsr == null) {
      return -3;
    }
    bbsw.a(paramItem, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, localbbsr);
    this.jdField_a_of_type_JavaUtilLinkedList.add(str);
    bbrc.c("TroopFileThumbnailFetchMgr", bbrc.a, "[" + str + "] fetchFileThumbnail fileName. " + paramItem.FileName + a());
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
    while (((Iterator)localObject).hasNext())
    {
      bbsr localbbsr = (bbsr)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localbbsr.a()))
      {
        localbbsr.a();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = (bbsr)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (localObject == null) {
          break label168;
        }
        ((bbsr)localObject).a();
        paramInt |= 0x1;
      }
      label168:
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | paramInt;
        if (bool) {
          bbrc.c("TroopFileThumbnailFetchMgr", bbrc.a, "[" + str + "] stopFetch. " + a());
        }
        d();
        return 0;
      }
    }
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, bbsr parambbsr)
  {
    bbqt.a(new TroopFileThumbnailFetchMgr.1(this, paramString, paramBoolean, paramInt, parambbsr), false);
  }
  
  protected boolean a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((bbsr)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  public void b(String paramString, boolean paramBoolean, int paramInt, bbsr parambbsr)
  {
    this.b.remove(parambbsr);
    bbrc.c("TroopFileThumbnailFetchMgr", bbrc.a, "[" + paramString + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bbsr)localIterator.next()).a();
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bbsr)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    bbrc.c("TroopFileThumbnailFetchMgr", bbrc.a, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsq
 * JD-Core Version:    0.7.0.1
 */