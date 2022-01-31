import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class araj
  extends arah
{
  arai jdField_a_of_type_Arai;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public araj(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arai.a.jdField_a_of_type_JavaLangString = arni.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_Arai.a.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Arai.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
    try
    {
      this.jdField_a_of_type_Arai.a.c = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramQQAppInterface.toString());
    }
  }
  
  private int a(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403)) {
      if (AppNetConnInfo.isNetSupport())
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {}
      }
      else
      {
        i = 9004;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (bdag.a()) {}
    for (long l = bdag.a() * 1024L;; l = bdag.b() * 1024L)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= l) {
        break;
      }
      return 506;
    }
  }
  
  public void OnOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int i = 3;
    if (paramExcitingTransferOneSlotComplete == null)
    {
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo is null");
      return;
    }
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo : " + paramExcitingTransferOneSlotComplete.toString());
    paramInt = a(paramInt);
    int j = 4;
    if (paramInt == 9004) {
      paramInt = 5;
    }
    for (;;)
    {
      this.jdField_a_of_type_Arai.a(paramInt, i, paramExcitingTransferOneSlotComplete);
      return;
      if (paramInt == 506)
      {
        j = 3;
        i = paramInt;
        paramInt = j;
      }
      else
      {
        i = paramInt;
        paramInt = j;
      }
    }
  }
  
  public void OnSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    paramExcitingTransferDownloadSpeedInfo = aroo.b(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  protected aqzw a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Arai = new arai(paramQQAppInterface);
    return this.jdField_a_of_type_Arai;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    this.jdField_a_of_type_Arai.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new arak(this, paramExcitingTransferDownloadReqInfo));
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 6, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public String b()
  {
    String str1 = this.jdField_a_of_type_Armo.c();
    String str2 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    return str1 + str2;
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download result:" + paramInt);
    if (paramInt != 0)
    {
      paramInt = a(paramInt);
      this.jdField_a_of_type_Arai.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_Arai.a.jdField_a_of_type_Long = 4L;
      if (paramInt == 9004)
      {
        this.jdField_a_of_type_Arai.a.jdField_a_of_type_Long = 5L;
        this.jdField_a_of_type_Arai.a(3);
        a(null, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (paramExcitingTransferDownloadCompletedInfo != null)
        {
          this.jdField_a_of_type_Arai.a(paramExcitingTransferDownloadCompletedInfo);
          paramExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_Arai;
          if (paramInt != 0) {
            break label613;
          }
        }
      }
    }
    label613:
    for (boolean bool = true;; bool = false)
    {
      paramExcitingTransferDownloadCompletedInfo.a(bool);
      return;
      if (paramInt == 506)
      {
        this.jdField_a_of_type_Arai.a.jdField_a_of_type_Long = 3L;
        this.jdField_a_of_type_Arai.a(paramInt);
        break;
      }
      this.jdField_a_of_type_Arai.a(paramInt);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, null);
      this.jdField_a_of_type_Arai.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_Arai.a.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Arai.a(0);
      String str = paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath;
      arni.a(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arni.a(str);
      int i = str.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - i) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - i);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arni.a(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = arni.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = aqzr.a(arni.b(str));
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = aqzr.a(arni.a(str));
        }
      }
      VFSFile localVFSFile = new VFSFile(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = localVFSFile.lastModified();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = ayvc.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { str, "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
      {
        aroa.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        aroa.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        aroa.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      for (;;)
      {
        arni.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
          arni.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
      }
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Arai.a(paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong2 / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     araj
 * JD-Core Version:    0.7.0.1
 */