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

public class bbrw
  extends Observable
  implements bbsc, INetInfoHandler
{
  private static bbrw jdField_a_of_type_Bbrw;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, bbsa> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<bbsa> b = new LinkedList();
  
  public static bbrw a()
  {
    try
    {
      if (jdField_a_of_type_Bbrw == null) {
        jdField_a_of_type_Bbrw = new bbrw();
      }
      bbrw localbbrw = jdField_a_of_type_Bbrw;
      return localbbrw;
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
      bbsa localbbsa = (bbsa)paramBundle.next();
      if (paramUUID.equals(localbbsa.a()))
      {
        localbbsa.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (bbsa)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
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
          bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramUUID.toString() + "] stopDownload." + a());
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
      bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (aqzy.a().d()) && (paramItem.ProgressTotal > aqzy.a().d())) {}
    for (paramBundle = araa.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = bbsa.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
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
        localObject = (bbsa)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((bbsa)localObject).a()) {
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
      bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = bbsg.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
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
    paramItem = bbse.a(paramLong, paramItem);
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
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "stopUpload item.id null.");
      return -2;
    }
    bbqt.a(new TroopFileDownloadMgr.6(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    bbrc.b("TroopFileDownloadMgr", bbrc.a, "failAll. reason:" + paramInt);
    bbqt.a(new TroopFileDownloadMgr.8(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    bbsa localbbsa;
    while (localIterator.hasNext())
    {
      localbbsa = (bbsa)localIterator.next();
      localbbsa.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbbsa.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localbbsa = (bbsa)localIterator.next();
      localbbsa.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbbsa.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface != null) {
      ypf.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new bbrx(this, paramItem, localQQAppInterface, paramLong, paramBundle));
    }
  }
  
  protected final void a(bbpe parambbpe, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = bbra.a();
    if (localQQAppInterface == null)
    {
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "[" + parambbpe.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = arni.a(parambbpe);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambbpe.b);
    localFileManagerEntity.peerNick = bdbt.o(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (ayvc.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = parambbpe.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = aqzr.a(arni.b(parambbpe.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = aqzr.a(arni.a(parambbpe.a));
      }
    }
    localFileManagerEntity.str10Md5 = bdcv.a(arni.d(parambbpe.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambbpe.a).lastModified();
      label265:
      localQQAppInterface.a().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.a().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambbpe)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bbsa parambbsa)
  {
    bbqt.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBoolean, paramInt, parambbsa), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((bbsa)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bbrc.a("TroopFileDownloadMgr", bbrc.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    bbqt.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    bbqt.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, bbsa parambbsa)
  {
    this.b.remove(parambbsa);
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "onNetNone2Mobile");
    bbqt.a(new TroopFileDownloadMgr.9(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    bbqt.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetWifi2None()
  {
    bbrc.c("TroopFileDownloadMgr", bbrc.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrw
 * JD-Core Version:    0.7.0.1
 */