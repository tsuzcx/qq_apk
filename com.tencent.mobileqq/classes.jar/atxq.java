import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atxq
  extends atxd
{
  public atxq(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateLocalFailedWhenChangeToOff";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (a("onSenderUploadException")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 11, 12, true);
    a("StateExcepInvalidWhenChangeToOff");
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
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aunj.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    atwy.a(this.jdField_a_of_type_Atwy, 11, 13, true);
    a("StateUploadoneWhenChangeToOff");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atyg(this.jdField_a_of_type_Atwy);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atxd = new atxg(this.jdField_a_of_type_Atwy);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxq
 * JD-Core Version:    0.7.0.1
 */