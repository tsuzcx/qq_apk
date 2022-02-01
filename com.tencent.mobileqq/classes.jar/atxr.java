import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atxr
  extends atxd
{
  public atxr(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateLocalFailedWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.c(this.jdField_a_of_type_Atwy, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Atxd = new atyf(this.jdField_a_of_type_Atwy);
    this.jdField_a_of_type_Atwy.a(true, 0L);
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 12, true);
    a("StateExcepInvalidWhenPause");
    this.jdField_a_of_type_Atxd = new atxn(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aunj.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atwy.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atwy.b(this.jdField_a_of_type_Atwy, 1, 3);
    atwy.c(this.jdField_a_of_type_Atwy, 1, 3);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateGotoOffFileProcess)");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atxp(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 10, 9, true);
    a("StateCancelUploadWhenPause");
    this.jdField_a_of_type_Atxd = new atxf(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxr
 * JD-Core Version:    0.7.0.1
 */