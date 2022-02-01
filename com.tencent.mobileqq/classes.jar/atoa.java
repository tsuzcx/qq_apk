import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class atoa
  extends atnt
{
  public atoa(atno paramatno)
  {
    super(paramatno);
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
    atno.a(this.jdField_a_of_type_Atno, 9, 11);
    atno.a(this.jdField_a_of_type_Atno, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Atnt = new atov(this.jdField_a_of_type_Atno);
    this.jdField_a_of_type_Atno.a(true, 0L);
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
    atno.a(this.jdField_a_of_type_Atno, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Atnt = new atoe(this.jdField_a_of_type_Atno);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((auea.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Atno.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    atno.a(this.jdField_a_of_type_Atno, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Atnt = new atof(this.jdField_a_of_type_Atno);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    atno.a(this.jdField_a_of_type_Atno, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoa
 * JD-Core Version:    0.7.0.1
 */