import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class atyd
  extends atxd
{
  public atyd(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateUploadingWhenChangeToOff";
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
    atwy.b(this.jdField_a_of_type_Atwy, 11, 12);
    atwy.c(this.jdField_a_of_type_Atwy, 11, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateExcepInvalidWhenChangeToOff");
    this.jdField_a_of_type_Atxd = new atxm(this.jdField_a_of_type_Atwy);
  }
  
  protected void a(long paramLong)
  {
    b(paramLong);
  }
  
  protected boolean a()
  {
    if (a("onRecvOnLineFile")) {
      return false;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 9, 11);
    atwy.a(this.jdField_a_of_type_Atwy, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Atxd = new atyf(this.jdField_a_of_type_Atwy);
    return true;
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
    localFileManagerEntity.setCloudType(1);
    atwy.b(this.jdField_a_of_type_Atwy, 11, 13);
    atwy.c(this.jdField_a_of_type_Atwy, 11, 13);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadoneWhenChangeToOff)");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atyg(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 11, 9);
    atwy.c(this.jdField_a_of_type_Atwy, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Atxd = new atxg(this.jdField_a_of_type_Atwy);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyd
 * JD-Core Version:    0.7.0.1
 */