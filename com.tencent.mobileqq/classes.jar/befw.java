import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.1;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.10;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.11;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.2;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.3;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.5;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.6;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.7;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.8;
import com.tencent.mobileqq.troop.filemanager.download.TroopFileDownloadMgr.9;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;
import java.util.UUID;
import mqq.os.MqqHandler;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;

public class befw
  extends Observable
  implements begb, INetInfoHandler
{
  private static befw jdField_a_of_type_Befw;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, befz> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<befz> b = new LinkedList();
  
  public static befw a()
  {
    try
    {
      if (jdField_a_of_type_Befw == null) {
        jdField_a_of_type_Befw = new befw();
      }
      befw localbefw = jdField_a_of_type_Befw;
      return localbefw;
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
  
  private void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle, boolean paramBoolean, int paramInt, group_file_common.FileInfo paramFileInfo)
  {
    QLog.i("TroopFileDownloadMgr", 1, "[" + paramItem.Id.toString() + "] refreshOneFileResult:" + paramBoolean + " errorCode:" + paramInt);
    if (a(paramLong, paramItem, paramFileInfo)) {
      return;
    }
    paramFileInfo = befa.a();
    if ((paramFileInfo != null) && (aszt.a(paramItem.FileName) == 2) && (ataw.a(paramFileInfo)))
    {
      ashu.a(new asrv(paramFileInfo, paramItem.getInfo(paramLong))).a();
      return;
    }
    bees.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
  }
  
  private boolean a(long paramLong, TroopFileTransferManager.Item paramItem, group_file_common.FileInfo paramFileInfo)
  {
    QQAppInterface localQQAppInterface = befa.a();
    if ((localQQAppInterface == null) || (paramFileInfo == null))
    {
      QLog.e("TroopFileDownloadMgr", 1, "downloadSucIfLocalExsited para=null");
      return false;
    }
    paramItem.Md5 = paramFileInfo.bytes_md5.get().toByteArray();
    String str1 = asnl.a(paramItem.Md5);
    paramItem.Sha = paramFileInfo.bytes_sha.get().toByteArray();
    String str2 = asnl.a(paramItem.Sha);
    paramItem.Sha3 = asnl.a(paramFileInfo.bytes_sha3.get().toByteArray());
    QLog.i("TroopFileDownloadMgr", 1, "troop findFile md5[" + str1 + "], sha3[" + paramItem.Sha3 + "], sha[" + str2 + "]");
    paramFileInfo = localQQAppInterface.getFileManagerDataCenter().a(paramItem.FileName, paramItem.ProgressTotal).iterator();
    while (paramFileInfo.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramFileInfo.next();
      if (((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.strFileMd5 != null) && (localFileManagerEntity.strFileMd5.equals(str1))) || ((localFileManagerEntity.str10Md5 != null) && (localFileManagerEntity.str10Md5.equals(str1))) || ((localFileManagerEntity.strFileSha3 != null) && (localFileManagerEntity.strFileSha3.equals(paramItem.Sha3))) || ((localFileManagerEntity.strFileSHA != null) && (localFileManagerEntity.strFileSHA.equals(str2))) || ((localFileManagerEntity.strTroopFileSha1 != null) && (localFileManagerEntity.strTroopFileSha1.equals(str2))))
      {
        long l = new VFSFile(localFileManagerEntity.getFilePath()).lastModified();
        if (localFileManagerEntity.localModifyTime != l)
        {
          QLog.w("TroopFileDownloadMgr", 1, "find exsited file, bug file is modified,item.localModifyTime[" + localFileManagerEntity.localModifyTime + "], lastModified[" + l + "]");
        }
        else
        {
          QLog.i("TroopFileDownloadMgr", 1, "sessionid[" + localFileManagerEntity.nSessionId + "]find exsited file, set file download sucessed!");
          paramItem.LocalFile = localFileManagerEntity.getFilePath();
          if ((!FileUtils.fileExistsAndNotEmpty(paramItem.middleThumbnailFile)) && (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strMiddleThumPath))) {
            paramItem.middleThumbnailFile = localFileManagerEntity.strMiddleThumPath;
          }
          if ((!FileUtils.fileExistsAndNotEmpty(paramItem.largeThumbnailFile)) && (FileUtils.fileExistsAndNotEmpty(localFileManagerEntity.strLargeThumPath))) {
            paramItem.largeThumbnailFile = localFileManagerEntity.strLargeThumPath;
          }
          beel.a(paramLong, paramItem, 11);
          a(paramItem.getInfo(paramLong), str1, str2, paramItem.Sha3);
          if (5 == aszt.a(paramItem.FileName)) {
            localQQAppInterface.getFileManagerEngine().a().a(paramLong, paramItem);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private int b(UUID paramUUID, Bundle paramBundle)
  {
    paramBundle = this.b.iterator();
    while (paramBundle.hasNext())
    {
      befz localbefz = (befz)paramBundle.next();
      if (paramUUID.equals(localbefz.a()))
      {
        localbefz.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (befz)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
        if (paramBundle == null) {
          break label154;
        }
        paramBundle.a(0);
        bool1 |= true;
      }
      label154:
      for (;;)
      {
        bool2 = this.jdField_a_of_type_JavaUtilLinkedList.remove(paramUUID) | bool1;
        if (bool2) {
          befc.c("TroopFileDownloadMgr", befc.a, "[" + paramUUID.toString() + "] stopDownload." + a());
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
      befc.c("TroopFileDownloadMgr", befc.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (asnp.a().d()) && (paramItem.ProgressTotal > asnp.a().d())) {}
    for (paramBundle = asnr.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = befz.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    befc.c("TroopFileDownloadMgr", befc.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
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
        localObject = (befz)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((befz)localObject).a()) {
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
      befc.c("TroopFileDownloadMgr", befc.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = begf.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    befc.c("TroopFileDownloadMgr", befc.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
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
    paramItem = begd.a(paramLong, paramItem);
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
      befc.a("TroopFileDownloadMgr", befc.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      befc.a("TroopFileDownloadMgr", befc.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      befc.a("TroopFileDownloadMgr", befc.a, "stopUpload item.id null.");
      return -2;
    }
    bees.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    befc.c("TroopFileDownloadMgr", befc.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    befc.b("TroopFileDownloadMgr", befc.a, "failAll. reason:" + paramInt);
    bees.a(new TroopFileDownloadMgr.9(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    befz localbefz;
    while (localIterator.hasNext())
    {
      localbefz = (befz)localIterator.next();
      localbefz.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbefz.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localbefz = (befz)localIterator.next();
      localbefz.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbefz.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    befc.c("TroopFileDownloadMgr", befc.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface != null)
    {
      zrj.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new befx(this, paramLong, paramItem, paramBundle));
      return;
    }
    QLog.e("TroopFileDownloadMgr", 1, "CheckFileExsited app=null");
  }
  
  protected final void a(becp parambecp, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = befa.a();
    if (localQQAppInterface == null)
    {
      befc.a("TroopFileDownloadMgr", befc.a, "[" + parambecp.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = aszt.a(parambecp);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambecp.b);
    localFileManagerEntity.peerNick = ContactUtils.getTroopNickNameByTroopCode(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (bbko.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = parambecp.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = asnl.a(aszt.c(parambecp.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = asnl.a(aszt.a(parambecp.a));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(aszt.e(parambecp.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambecp.a).lastModified();
      label265:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambecp)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, befz parambefz)
  {
    bees.a(new TroopFileDownloadMgr.8(this, paramUUID, paramBoolean, paramInt, parambefz), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((befz)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      befc.a("TroopFileDownloadMgr", befc.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      befc.a("TroopFileDownloadMgr", befc.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    bees.a(new TroopFileDownloadMgr.6(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    befc.c("TroopFileDownloadMgr", befc.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    bees.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, befz parambefz)
  {
    this.b.remove(parambefz);
    befc.c("TroopFileDownloadMgr", befc.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    befc.c("TroopFileDownloadMgr", befc.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    befc.c("TroopFileDownloadMgr", befc.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    befc.c("TroopFileDownloadMgr", befc.a, "onNetNone2Mobile");
    bees.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    befc.c("TroopFileDownloadMgr", befc.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    bees.a(new TroopFileDownloadMgr.11(this), false);
  }
  
  public void onNetWifi2None()
  {
    befc.c("TroopFileDownloadMgr", befc.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befw
 * JD-Core Version:    0.7.0.1
 */