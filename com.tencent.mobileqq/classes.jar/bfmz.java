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

public class bfmz
  extends Observable
  implements bfne, INetInfoHandler
{
  private static bfmz jdField_a_of_type_Bfmz;
  private LinkedList<UUID> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Map<UUID, bfnc> jdField_a_of_type_JavaUtilMap = new HashMap();
  public boolean a;
  private LinkedList<bfnc> b = new LinkedList();
  
  public static bfmz a()
  {
    try
    {
      if (jdField_a_of_type_Bfmz == null) {
        jdField_a_of_type_Bfmz = new bfmz();
      }
      bfmz localbfmz = jdField_a_of_type_Bfmz;
      return localbfmz;
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
    paramFileInfo = bfmd.a();
    if ((paramFileInfo != null) && (auea.a(paramItem.FileName) == 2) && (aufd.a(paramFileInfo)))
    {
      atma.a(new atwc(paramFileInfo, paramItem.getInfo(paramLong))).a();
      return;
    }
    bflv.a(new TroopFileDownloadMgr.5(this, paramLong, paramItem, paramBundle), false);
  }
  
  private boolean a(long paramLong, TroopFileTransferManager.Item paramItem, group_file_common.FileInfo paramFileInfo)
  {
    QQAppInterface localQQAppInterface = bfmd.a();
    if ((localQQAppInterface == null) || (paramFileInfo == null))
    {
      QLog.e("TroopFileDownloadMgr", 1, "downloadSucIfLocalExsited para=null");
      return false;
    }
    paramItem.Md5 = paramFileInfo.bytes_md5.get().toByteArray();
    String str1 = atrr.a(paramItem.Md5);
    paramItem.Sha = paramFileInfo.bytes_sha.get().toByteArray();
    String str2 = atrr.a(paramItem.Sha);
    paramItem.Sha3 = atrr.a(paramFileInfo.bytes_sha3.get().toByteArray());
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
          bflo.a(paramLong, paramItem, 11);
          a(paramItem.getInfo(paramLong), str1, str2, paramItem.Sha3);
          if (5 == auea.a(paramItem.FileName)) {
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
      bfnc localbfnc = (bfnc)paramBundle.next();
      if (paramUUID.equals(localbfnc.a()))
      {
        localbfnc.a(0);
        paramBundle.remove();
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        paramBundle = (bfnc)this.jdField_a_of_type_JavaUtilMap.remove(paramUUID);
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
          bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramUUID.toString() + "] stopDownload." + a());
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
      bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startDownload worker exsited. ");
      return -4;
    }
    if ((paramItem.ProgressTotal > 0L) && (atrv.a().d()) && (paramItem.ProgressTotal > atrv.a().d())) {}
    for (paramBundle = atrx.a(paramLong, paramItem, paramBundle, this); paramBundle == null; paramBundle = bfnc.b(paramLong, paramItem, paramBundle, this)) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startDownload filePath. " + paramItem.FilePath + a());
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
        localObject = (bfnc)this.jdField_a_of_type_JavaUtilMap.remove(localObject);
        if (localObject != null)
        {
          this.b.add(localObject);
          if (((bfnc)localObject).a()) {
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
      bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile worker exsited. ");
      return -4;
    }
    paramBundle = bfni.a(paramLong, paramItem, paramBundle, this);
    if (paramBundle == null) {
      return -3;
    }
    this.jdField_a_of_type_JavaUtilMap.put(paramItem.Id, paramBundle);
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramItem.Id);
    paramBundle.e();
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramItem.Id.toString() + "] startDownloadZipInnerFile filePath. " + paramItem.FilePath + a());
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
    paramItem = bfng.a(paramLong, paramItem);
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
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "startDownload key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "startDownload item.id null.");
      return -2;
    }
    a(paramLong, paramItem, paramBundle);
    return 0;
  }
  
  public int a(UUID paramUUID, Bundle paramBundle)
  {
    if (paramUUID == null)
    {
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "stopUpload item.id null.");
      return -2;
    }
    bflv.a(new TroopFileDownloadMgr.7(this, paramUUID, paramBundle), false);
    return 0;
  }
  
  public void a()
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "init");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.1(this));
  }
  
  protected void a(int paramInt)
  {
    bfmf.b("TroopFileDownloadMgr", bfmf.a, "failAll. reason:" + paramInt);
    bflv.a(new TroopFileDownloadMgr.9(this, paramInt), false);
  }
  
  public void a(int paramInt, Set<Long> paramSet)
  {
    Iterator localIterator = this.b.iterator();
    bfnc localbfnc;
    while (localIterator.hasNext())
    {
      localbfnc = (bfnc)localIterator.next();
      localbfnc.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbfnc.a()));
      }
    }
    this.b.clear();
    localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      localbfnc = (bfnc)localIterator.next();
      localbfnc.a(paramInt);
      if (paramSet != null) {
        paramSet.add(Long.valueOf(localbfnc.a()));
      }
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "stopAllInter");
  }
  
  protected void a(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface != null)
    {
      aagu.a(localQQAppInterface, paramLong, paramItem.BusId, paramItem.FilePath, new bfna(this, paramLong, paramItem, paramBundle));
      return;
    }
    QLog.e("TroopFileDownloadMgr", 1, "CheckFileExsited app=null");
  }
  
  protected final void a(bfjs parambfjs, String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = bfmd.a();
    if (localQQAppInterface == null)
    {
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "[" + parambfjs.b + "] addFMEntity fail app=null ");
      return;
    }
    FileManagerEntity localFileManagerEntity = auea.a(parambfjs);
    localFileManagerEntity.isReaded = true;
    localFileManagerEntity.peerUin = String.valueOf(parambfjs.b);
    localFileManagerEntity.peerNick = ContactUtils.getTroopNickNameByTroopCode(localQQAppInterface, localFileManagerEntity.peerUin);
    localFileManagerEntity.srvTime = (bcrg.a() * 1000L);
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.bSend = false;
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fProgress = 1.0F;
    localFileManagerEntity.TroopUin = parambfjs.b;
    localFileManagerEntity.strFileMd5 = paramString1;
    localFileManagerEntity.strFileSHA = paramString2;
    localFileManagerEntity.strFileSha3 = paramString3;
    if ((localFileManagerEntity.nFileType == 0) || (localFileManagerEntity.nFileType == 2))
    {
      if (TextUtils.isEmpty(localFileManagerEntity.strFileSha3)) {
        localFileManagerEntity.strFileSha3 = atrr.a(auea.c(parambfjs.a));
      }
      if ((localFileManagerEntity.fileSize < 104857600L) && (TextUtils.isEmpty(localFileManagerEntity.strFileSHA))) {
        localFileManagerEntity.strFileSHA = atrr.a(auea.a(parambfjs.a));
      }
    }
    localFileManagerEntity.str10Md5 = HexUtil.bytes2HexStr(auea.e(parambfjs.a));
    try
    {
      localFileManagerEntity.localModifyTime = new VFSFile(parambfjs.a).lastModified();
      label265:
      localQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
      localFileManagerEntity.status = 1;
      localQQAppInterface.getFileManagerDataCenter().c(localFileManagerEntity);
      return;
    }
    catch (Exception parambfjs)
    {
      break label265;
    }
  }
  
  public void a(UUID paramUUID, boolean paramBoolean, int paramInt, bfnc parambfnc)
  {
    bflv.a(new TroopFileDownloadMgr.8(this, paramUUID, paramBoolean, paramInt, parambfnc), false);
  }
  
  protected boolean a(UUID paramUUID)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramUUID.equals(((bfnc)localIterator.next()).a())) {
        return true;
      }
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramUUID);
  }
  
  public int b(long paramLong, TroopFileTransferManager.Item paramItem, Bundle paramBundle)
  {
    if ((paramLong == 0L) || (paramItem == null))
    {
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "startDownloadZipInnerFile key param invaild.");
      return -1;
    }
    if (paramItem.Id == null)
    {
      bfmf.a("TroopFileDownloadMgr", bfmf.a, "startDownloadZipInnerFile item.id null.");
      return -2;
    }
    bflv.a(new TroopFileDownloadMgr.6(this, paramLong, paramItem, paramBundle), false);
    return 0;
  }
  
  public void b()
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "release");
    ThreadManager.getSubThreadHandler().post(new TroopFileDownloadMgr.2(this));
    if (Build.VERSION.SDK_INT == 19)
    {
      a(2, null);
      return;
    }
    bflv.a(new TroopFileDownloadMgr.3(this), true);
  }
  
  public void b(UUID paramUUID, boolean paramBoolean, int paramInt, bfnc parambfnc)
  {
    this.b.remove(parambfnc);
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "[" + paramUUID.toString() + "] onWorkDoneInter. bSuc:" + paramBoolean + " errCode:" + paramInt + a());
    c();
  }
  
  public void onNetMobile2None()
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "onNetMobile2None");
    a(3);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "onNetMobile2Wifi");
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "onNetNone2Mobile");
    bflv.a(new TroopFileDownloadMgr.10(this), false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "onNetNone2Wifi");
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    bflv.a(new TroopFileDownloadMgr.11(this), false);
  }
  
  public void onNetWifi2None()
  {
    bfmf.c("TroopFileDownloadMgr", bfmf.a, "onNetWifi2None");
    a(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmz
 * JD-Core Version:    0.7.0.1
 */