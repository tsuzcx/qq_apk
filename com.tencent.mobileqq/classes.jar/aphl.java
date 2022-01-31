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

public class aphl
  extends aphj
{
  aphk jdField_a_of_type_Aphk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public aphl(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aphk.a.jdField_a_of_type_JavaLangString = apug.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_Aphk.a.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Aphk.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
    try
    {
      this.jdField_a_of_type_Aphk.a.c = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
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
    if (bbbm.a()) {}
    for (long l = bbbm.a() * 1024L;; l = bbbm.b() * 1024L)
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
      this.jdField_a_of_type_Aphk.a(paramInt, i, paramExcitingTransferOneSlotComplete);
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
    paramExcitingTransferDownloadSpeedInfo = apvm.b(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  protected apgy a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aphk = new aphk(paramQQAppInterface);
    return this.jdField_a_of_type_Aphk;
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
    this.jdField_a_of_type_Aphk.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new aphm(this, paramExcitingTransferDownloadReqInfo));
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
    String str1 = this.jdField_a_of_type_Aptm.c();
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
      this.jdField_a_of_type_Aphk.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_Aphk.a.jdField_a_of_type_Long = 4L;
      if (paramInt == 9004)
      {
        this.jdField_a_of_type_Aphk.a.jdField_a_of_type_Long = 5L;
        this.jdField_a_of_type_Aphk.a(3);
        a(null, paramInt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (paramExcitingTransferDownloadCompletedInfo != null)
        {
          this.jdField_a_of_type_Aphk.a(paramExcitingTransferDownloadCompletedInfo);
          paramExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_Aphk;
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
        this.jdField_a_of_type_Aphk.a.jdField_a_of_type_Long = 3L;
        this.jdField_a_of_type_Aphk.a(paramInt);
        break;
      }
      this.jdField_a_of_type_Aphk.a(paramInt);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, null);
      this.jdField_a_of_type_Aphk.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_Aphk.a.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Aphk.a(0);
      String str = paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath;
      apug.a(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apug.a(str);
      int i = str.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - i) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apug.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - i);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = apug.a(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = apug.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = apgt.a(apug.b(str));
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = apgt.a(apug.a(str));
        }
      }
      VFSFile localVFSFile = new VFSFile(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = localVFSFile.lastModified();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = awzy.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { str, "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
      {
        apuy.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        apuy.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        apuy.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      for (;;)
      {
        apug.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
          apug.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
      }
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Aphk.a(paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong2 / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphl
 * JD-Core Version:    0.7.0.1
 */