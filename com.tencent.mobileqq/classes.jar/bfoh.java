import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.1;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.10;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.2;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.3;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.4;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.5;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.7;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.8;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadMgr.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.UUID;
import mqq.os.MqqHandler;

public class bfoh
  extends Observable
  implements INetInfoHandler
{
  private static bfoh jdField_a_of_type_Bfoh;
  bfol jdField_a_of_type_Bfol = new bfoi(this);
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, bfok> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<UUID> b = new LinkedList();
  private LinkedList<UUID> c = new LinkedList();
  private LinkedList<bfok> d = new LinkedList();
  
  public static bfoh a()
  {
    try
    {
      if (jdField_a_of_type_Bfoh == null) {
        jdField_a_of_type_Bfoh = new bfoh();
      }
      bfoh localbfoh = jdField_a_of_type_Bfoh;
      return localbfoh;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " PS:" + this.b.size() + " PPS:" + this.c.size() + " RS:" + this.d.size();
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equalsIgnoreCase(((bfok)localIterator.next()).b())) {
        return true;
      }
    }
    return false;
  }
  
  private int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    long l = auea.a(paramItem.LocalFile);
    if ((l > 0L) && (atrv.a().c()) && (l > atrv.a().c())) {}
    for (paramBundle = atsj.a(paramLong, paramItem, paramBundle, this.jdField_a_of_type_Bfol); paramBundle == null; paramBundle = bfoo.b(paramLong, paramItem, paramBundle, this.jdField_a_of_type_Bfol)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.k();
    bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startUpload filePath. " + paramItem.LocalFile + a());
    c();
    return 0;
  }
  
  private int b(UUID paramUUID, long paramLong, String paramString1, String paramString2, bfol parambfol)
  {
    if (a(paramUUID))
    {
      bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramUUID.toString() + "] startUpload worker exsited. ");
      return -4;
    }
    paramString1 = new bfom(paramUUID, paramLong, paramString1, paramString2);
    paramString1.a(parambfol);
    paramString1.a(this.jdField_a_of_type_Bfol);
    this.jdField_a_of_type_JavaUtilMap.put(paramUUID, paramString1);
    this.b.add(paramUUID);
    paramString1.a();
    bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramUUID.toString() + "] startUpload filePath. " + paramString2 + a());
    c();
    return 0;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.d.iterator();
    while (paramBundle.hasNext())
    {
      bfok localbfok = (bfok)paramBundle.next();
      if (paramUUID.equals(localbfok.a()))
      {
        localbfok.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (bfok)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label185;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label185:
      for (;;)
      {
        boolean bool3 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID);
        boolean bool4 = this.b.remove(paramUUID);
        bool2 = this.c.remove(paramUUID) | bool1 | bool3 | bool4;
        if (bool2) {
          bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramUUID.toString() + "] stopUpload." + a());
        }
        c();
        return 0;
      }
    }
  }
  
  private void c()
  {
    if (this.d.size() >= 4) {}
    label592:
    label594:
    label597:
    for (;;)
    {
      return;
      Object localObject1 = this.c.iterator();
      Object localObject2;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label594;
        }
        localObject2 = (UUID)((Iterator)localObject1).next();
        bfok localbfok = (bfok)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        if (localbfok == null)
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          bfmf.a("TroopFileUploadMgr", bfmf.a, "[" + ((UUID)localObject2).toString() + "] runNextWorker worker not find." + a());
        }
        else if (!a(localbfok.b()))
        {
          ((Iterator)localObject1).remove();
          this.jdField_a_of_type_JavaUtilMap.remove(localObject2);
          this.d.add(localbfok);
          if (localbfok.a()) {
            break;
          }
          this.d.remove(localbfok);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label597;
        }
        while (this.b.size() > 0)
        {
          localObject1 = (UUID)this.b.remove(0);
          localObject2 = (bfok)this.jdField_a_of_type_JavaUtilMap.remove(localObject1);
          if (localObject2 != null)
          {
            if (a(((bfok)localObject2).b()))
            {
              this.c.add(localObject1);
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
              bfmf.b("TroopFileUploadMgr", bfmf.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + a());
            }
            else
            {
              this.d.add(localObject2);
              if (((bfok)localObject2).a()) {
                break;
              }
              this.d.remove(localObject2);
            }
          }
          else {
            bfmf.a("TroopFileUploadMgr", bfmf.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 2." + a());
          }
        }
        if (this.d.size() >= 2) {
          break;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
            break label592;
          }
          localObject1 = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
          localObject2 = (bfok)this.jdField_a_of_type_JavaUtilMap.remove(localObject1);
          if (localObject2 != null)
          {
            if (a(((bfok)localObject2).b()))
            {
              this.c.add(localObject1);
              this.jdField_a_of_type_JavaUtilMap.put(localObject1, localObject2);
              bfmf.b("TroopFileUploadMgr", bfmf.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker. the file is uploading and continue wait" + a());
              continue;
            }
            this.d.add(localObject2);
            if (((bfok)localObject2).a()) {
              break;
            }
            this.d.remove(localObject2);
            continue;
          }
          bfmf.a("TroopFileUploadMgr", bfmf.a, "[" + ((UUID)localObject1).toString() + "] runNextWorker worker not find 3." + a());
        }
        break;
      }
    }
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      bfmf.a("TroopFileUploadMgr", bfmf.a, "startUpload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bfmf.a("TroopFileUploadMgr", bfmf.a, "startUpload item.id null.");
      return -2;
    }
    bflv.a(new TroopFileUploadMgr.4(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public int a(UUID paramUUID, long paramLong, String paramString1, String paramString2, bfol parambfol)
  {
    bflv.a(new TroopFileUploadMgr.5(this, paramUUID, paramLong, paramString1, paramString2, parambfol), false);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      bfmf.a("TroopFileUploadMgr", bfmf.a, "stopUpload item.id null.");
      return -2;
    }
    bflv.a(new TroopFileUploadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    bfmf.c("TroopFileUploadMgr", bfmf.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    bfmf.b("TroopFileUploadMgr", bfmf.a, "failAll. reason:" + paramInt);
    bflv.a(new TroopFileUploadMgr.8(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.d.iterator();
    bfok localbfok;
    while (localIterator.hasNext())
    {
      localbfok = (bfok)localIterator.next();
      localbfok.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbfok.a()));
      }
    }
    this.d.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localbfok = (bfok)localIterator.next();
      localbfok.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbfok.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.b.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.c.clear();
    bfmf.c("TroopFileUploadMgr", bfmf.a, "stopAllInter. reason:" + paramInt);
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bfok parambfok)
  {
    this.d.remove(parambfok);
    bfmf.c("TroopFileUploadMgr", bfmf.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((bfok)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public void b()
  {
    bfmf.c("TroopFileUploadMgr", bfmf.a, "release");
    try
    {
      ThreadManager.getSubThreadHandler().post(new TroopFileUploadMgr.2(this));
      if (Build.VERSION.SDK_INT == 19)
      {
        a(2, null);
        return;
      }
      bflv.a(new TroopFileUploadMgr.3(this), true);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onNetMobile2None()
  {
    bfmf.c("TroopFileUploadMgr", bfmf.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    bfmf.c("TroopFileUploadMgr", bfmf.a, "onNetNone2Mobile");
    bflv.a(new TroopFileUploadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    bflv.a(new TroopFileUploadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    bfmf.c("TroopFileUploadMgr", bfmf.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfoh
 * JD-Core Version:    0.7.0.1
 */