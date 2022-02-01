import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class asju
  extends asjn
{
  public asju(asji paramasji)
  {
    super(paramasji);
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
    asji.a(this.jdField_a_of_type_Asji, 9, 11);
    asji.a(this.jdField_a_of_type_Asji, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Asjn = new askp(this.jdField_a_of_type_Asji);
    this.jdField_a_of_type_Asji.a(true, 0L);
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
    asji.a(this.jdField_a_of_type_Asji, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Asjn = new asjy(this.jdField_a_of_type_Asji);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aszt.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Asji.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    asji.a(this.jdField_a_of_type_Asji, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Asjn = new asjz(this.jdField_a_of_type_Asji);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    asji.a(this.jdField_a_of_type_Asji, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Asjn = new asjq(this.jdField_a_of_type_Asji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asju
 * JD-Core Version:    0.7.0.1
 */