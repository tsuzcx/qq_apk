import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atne
  extends atib
{
  atne(atnd paramatnd) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      atnd.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      atnd.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      atnd.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      atnd.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      atnd.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      atnd.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.jdField_a_of_type_Atmi != null)
    {
      localObject1 = localObject2;
      if (this.a.jdField_a_of_type_Atmi.a() > 0) {
        localObject1 = "ChanedUrlCount[" + this.a.jdField_a_of_type_Atmi.a() + "]";
      }
    }
    this.a.b((String)localObject1);
    agfe.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong3);
  }
  
  protected void a(boolean paramBoolean, athx paramathx, anza paramanza)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      atnd.a(this.a, 1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, paramathx.jdField_a_of_type_Int, paramathx.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramathx.jdField_a_of_type_Int) {
        i = 9043;
      }
      atnd.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      atnd.b(this.a, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, atnd.a(this.a));
  }
  
  protected void a(boolean paramBoolean, athx paramathx, anza paramanza, List<String> paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    if (!paramBoolean)
    {
      atnd.a(this.a, paramathx);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if (atnd.a(this.a, paramathx))
    {
      atnd.b(this.a, paramathx);
      return;
    }
    atnd.a(this.a, paramathx, paramList);
  }
  
  protected void b(boolean paramBoolean, athx paramathx, anza paramanza, List<String> paramList)
  {
    if (this.a.a()) {}
    while (paramathx.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramathx.jdField_a_of_type_ArrayOfByte != null) && (paramathx.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(paramathx.jdField_a_of_type_ArrayOfByte);
      this.a.b();
      this.a.b = true;
      atnd.a(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atne
 * JD-Core Version:    0.7.0.1
 */