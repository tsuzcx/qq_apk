import com.tencent.mobileqq.troop.filemanager.thumbnail.TroopFileThumbnailFetchMgr.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

public class bfns
  implements bfnv
{
  private LinkedList<String> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<String, bfnt> jdField_a_of_type_JavaUtilMap = new HashMap();
  private LinkedList<bfnt> b = new LinkedList();
  
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
        localObject = (bfnt)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((bfnt)localObject).a()) {
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
      bfmf.c("TroopFileThumbnailFetchMgr", bfmf.a, "[" + str + "] fetchFileThumbnail worker exsited. ");
      return -4;
    }
    bfnt localbfnt = bfnt.a(paramLong, paramItem, paramInt, this);
    if (localbfnt == null) {
      return -3;
    }
    bfny.a(paramItem, paramInt);
    this.jdField_a_of_type_JavaUtilMap.put(str, localbfnt);
    this.jdField_a_of_type_JavaUtilLinkedList.add(str);
    bfmf.c("TroopFileThumbnailFetchMgr", bfmf.a, "[" + str + "] fetchFileThumbnail fileName. " + paramItem.FileName + a());
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
      bfnt localbfnt = (bfnt)((Iterator)localObject).next();
      if (str.equalsIgnoreCase(localbfnt.a()))
      {
        localbfnt.a();
        ((Iterator)localObject).remove();
      }
    }
    for (paramInt = 1;; paramInt = 0)
    {
      int i = paramInt;
      if (paramInt == 0)
      {
        localObject = (bfnt)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (localObject == null) {
          break label168;
        }
        ((bfnt)localObject).a();
        paramInt |= 0x1;
      }
      label168:
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | paramInt;
        if (bool) {
          bfmf.c("TroopFileThumbnailFetchMgr", bfmf.a, "[" + str + "] stopFetch. " + a());
        }
        d();
        return 0;
      }
    }
  }
  
  public void a() {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt, bfnt parambfnt)
  {
    bflv.a(new TroopFileThumbnailFetchMgr.1(this, paramString, paramBoolean, paramInt, parambfnt), false);
  }
  
  protected boolean a(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((bfnt)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
  }
  
  public void b()
  {
    c();
  }
  
  public void b(String paramString, boolean paramBoolean, int paramInt, bfnt parambfnt)
  {
    this.b.remove(parambfnt);
    bfmf.c("TroopFileThumbnailFetchMgr", bfmf.a, "[" + paramString + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    d();
  }
  
  protected void c()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((bfnt)localIterator.next()).a();
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext()) {
      ((bfnt)localIterator.next()).a();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    bfmf.c("TroopFileThumbnailFetchMgr", bfmf.a, "stopAllInter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfns
 * JD-Core Version:    0.7.0.1
 */