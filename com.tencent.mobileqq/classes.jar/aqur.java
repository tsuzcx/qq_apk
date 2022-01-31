import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqur
  extends aquk
{
  public aqur(aqug paramaqug)
  {
    super(paramaqug);
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
    aqug.a(this.jdField_a_of_type_Aqug, 9, 11);
    aqug.a(this.jdField_a_of_type_Aqug, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Aquk = new aqvm(this.jdField_a_of_type_Aqug);
    this.jdField_a_of_type_Aqug.a(true, 0L);
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
    aqug.a(this.jdField_a_of_type_Aqug, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((arni.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aqug.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aqug.a(this.jdField_a_of_type_Aqug, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aquw(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    aqug.a(this.jdField_a_of_type_Aqug, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aquk = new aqun(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqur
 * JD-Core Version:    0.7.0.1
 */