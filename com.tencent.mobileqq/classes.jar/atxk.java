import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atxk
  extends atxd
{
  public atxk(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenToOffFailed";
  }
  
  protected void a()
  {
    if (a("onResumeTrans")) {
      return;
    }
    atwy.a(this.jdField_a_of_type_Atwy, 9, 11);
    atwy.a(this.jdField_a_of_type_Atwy, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Atxd = new atyf(this.jdField_a_of_type_Atwy);
    this.jdField_a_of_type_Atwy.a(true, 0L);
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
    atwy.a(this.jdField_a_of_type_Atwy, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atxd = new atxo(this.jdField_a_of_type_Atwy);
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
    this.jdField_a_of_type_Atwy.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atwy.a(this.jdField_a_of_type_Atwy, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atxd = new atxp(this.jdField_a_of_type_Atwy);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxk
 * JD-Core Version:    0.7.0.1
 */