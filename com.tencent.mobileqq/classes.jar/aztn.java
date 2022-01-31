import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.10;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.3;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.5;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.6;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.7;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.8;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.9;
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

public class aztn
  extends Observable
  implements aztt, INetInfoHandler
{
  private static aztn jdField_a_of_type_Aztn;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, aztr> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<aztr> b = new LinkedList();
  
  public static aztn a()
  {
    try
    {
      if (jdField_a_of_type_Aztn == null) {
        jdField_a_of_type_Aztn = new aztn();
      }
      aztn localaztn = jdField_a_of_type_Aztn;
      return localaztn;
    }
    finally {}
  }
  
  private String a()
  {
    return " WS:" + this.jdField_a_of_type_JavaUtilMap.size() + " QS:" + this.jdField_a_of_type_JavaUtilLinkedList.size() + " RS:" + this.b.size();
  }
  
  private final void a(int paramInt, Object[] paramArrayOfObject)
  {
    setChanged();
    notifyObservers(new Object[] { Integer.valueOf(paramInt), paramArrayOfObject });
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.b.iterator();
    while (paramBundle.hasNext())
    {
      aztr localaztr = (aztr)paramBundle.next();
      if (paramUUID.equals(localaztr.a()))
      {
        localaztr.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (aztr)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label153;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label153:
      for (;;)
      {
        bool2 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | bool1;
        if (bool2) {
          azst.c("TroopFileDownloadMgr", azst.a, "[" + paramUUID.toString() + "] stopDownload." + a());
        }
        c();
        return 0;
      }
    }
  }
  
  private int c(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      azst.c("TroopFileDownloadMgr", azst.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (apha.a().d()) && (paramItem.ProgressTotal > apha.a().d())) {}
    for (paramBundle = aphc.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = aztr.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    azst.c("TroopFileDownloadMgr", azst.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  private void c()
  {
    if (this.b.size() >= 2) {}
    label78:
    for (;;)
    {
      return;
      for (;;)
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() <= 0) {
          break label78;
        }
        Object localObject = (UUID)this.jdField_a_of_type_JavaUtilLinkedList.remove(0);
        localObject = (aztr)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((aztr)localObject).a()) {
            break;
          }
          this.b.remove(localObject);
        }
      }
    }
  }
  
  private int d(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if (a(paramItem.Id))
    {
      azst.c("TroopFileDownloadMgr", azst.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = aztx.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    azst.c("TroopFileDownloadMgr", azst.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
    c();
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem)
  {
    if ((paramLong == 0L) || (paramItem == null)) {
      return -1;
    }
    if (paramItem.Id == null) {
      return -2;
    }
    paramItem = aztv.a(paramLong, paramItem);
    if (paramItem == null) {
      return -3;
    }
    if (!paramItem.a()) {
      return -5;
    }
    return 0;
  }
  
  public int a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      azst.a("TroopFileDownloadMgr", azst.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopFileDownloadMgr", azst.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      azst.a("TroopFileDownloadMgr", azst.a, "stopUpload item.id null.");
      return -2;
    }
    azsk.a(new TroopFileDownloadMgr.6(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    azst.c("TroopFileDownloadMgr", azst.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    azst.b("TroopFileDownloadMgr", azst.a, "failAll. reason:" + paramInt);
    azsk.a(new TroopFileDownloadMgr.8(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    aztr localaztr;
    while (localIterator.hasNext())
    {
      localaztr = (aztr)localIterator.next();
      localaztr.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localaztr.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localaztr = (aztr)localIterator.next();
      localaztr.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localaztr.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    azst.c("TroopFileDownloadMgr", azst.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface != null) {
      xam.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new azto(this, paramItem, localQQAppInterface, paramLong, paramBundle));
    }
  }
  
  protected final void a(azqv paramazqv, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = azsr.a();
    if (localQQAppInterface == null)
    {
      azst.a("TroopFileDownloadMgr", azst.a, "[" + paramazqv.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = apug.a(paramazqv);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(paramazqv.b);
    localFileManagerEntity.peerNick = bbcz.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (awzy.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = paramazqv.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = apgt.a(apug.b(paramazqv.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = apgt.a(apug.a(paramazqv.a));
      }
    }
    localFileManagerEntity.str10Md5 = bbea.a(apug.d(paramazqv.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(paramazqv.a).lastModified();
      label265:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception paramazqv)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, aztr paramaztr)
  {
    azsk.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBoolean, paramInt, paramaztr), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((aztr)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      azst.a("TroopFileDownloadMgr", azst.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      azst.a("TroopFileDownloadMgr", azst.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    azsk.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    azst.c("TroopFileDownloadMgr", azst.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    azsk.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, aztr paramaztr)
  {
    this.b.remove(paramaztr);
    azst.c("TroopFileDownloadMgr", azst.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    azst.c("TroopFileDownloadMgr", azst.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    azst.c("TroopFileDownloadMgr", azst.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    azst.c("TroopFileDownloadMgr", azst.a, "onNetNone2Mobile");
    azsk.a(new TroopFileDownloadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    azst.c("TroopFileDownloadMgr", azst.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    azsk.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    azst.c("TroopFileDownloadMgr", azst.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztn
 * JD-Core Version:    0.7.0.1
 */