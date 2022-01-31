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

public class bbwf
  extends Observable
  implements bbwl, INetInfoHandler
{
  private static bbwf jdField_a_of_type_Bbwf;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, bbwj> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<bbwj> b = new LinkedList();
  
  public static bbwf a()
  {
    try
    {
      if (jdField_a_of_type_Bbwf == null) {
        jdField_a_of_type_Bbwf = new bbwf();
      }
      bbwf localbbwf = jdField_a_of_type_Bbwf;
      return localbbwf;
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
      bbwj localbbwj = (bbwj)paramBundle.next();
      if (paramUUID.equals(localbbwj.a()))
      {
        localbbwj.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (bbwj)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
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
          bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramUUID.toString() + "] stopDownload." + a());
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
      bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (areh.a().d()) && (paramItem.ProgressTotal > areh.a().d())) {}
    for (paramBundle = arej.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = bbwj.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
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
        localObject = (bbwj)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((bbwj)localObject).a()) {
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
      bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = bbwp.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
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
    paramItem = bbwn.a(paramLong, paramItem);
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
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "stopUpload item.id null.");
      return -2;
    }
    bbvc.a(new TroopFileDownloadMgr.6(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    bbvl.b("TroopFileDownloadMgr", bbvl.a, "failAll. reason:" + paramInt);
    bbvc.a(new TroopFileDownloadMgr.8(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    bbwj localbbwj;
    while (localIterator.hasNext())
    {
      localbbwj = (bbwj)localIterator.next();
      localbbwj.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbbwj.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localbbwj = (bbwj)localIterator.next();
      localbbwj.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbbwj.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface != null) {
      ytu.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new bbwg(this, paramItem, localQQAppInterface, paramLong, paramBundle));
    }
  }
  
  protected final void a(bbtn parambbtn, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = bbvj.a();
    if (localQQAppInterface == null)
    {
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "[" + parambbtn.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = arrr.a(parambbtn);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambbtn.b);
    localFileManagerEntity.peerNick = bdgc.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (ayzl.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = parambbtn.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = area.a(arrr.b(parambbtn.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = area.a(arrr.a(parambbtn.a));
      }
    }
    localFileManagerEntity.str10Md5 = bdhe.a(arrr.d(parambbtn.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambbtn.a).lastModified();
      label265:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambbtn)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbwj parambbwj)
  {
    bbvc.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBoolean, paramInt, parambbwj), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((bbwj)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bbvl.a("TroopFileDownloadMgr", bbvl.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    bbvc.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    bbvc.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, bbwj parambbwj)
  {
    this.b.remove(parambbwj);
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "onNetNone2Mobile");
    bbvc.a(new TroopFileDownloadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    bbvc.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    bbvl.c("TroopFileDownloadMgr", bbvl.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwf
 * JD-Core Version:    0.7.0.1
 */