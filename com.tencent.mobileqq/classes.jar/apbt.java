import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class apbt
  extends apbm
{
  public apbt(apbi paramapbi)
  {
    super(paramapbi);
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
    apbi.a(this.jdField_a_of_type_Apbi, 9, 11);
    apbi.a(this.jdField_a_of_type_Apbi, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Apbm = new apco(this.jdField_a_of_type_Apbi);
    this.jdField_a_of_type_Apbi.a(true, 0L);
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
    apbi.a(this.jdField_a_of_type_Apbi, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Apbm = new apbx(this.jdField_a_of_type_Apbi);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apug.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Apbi.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    apbi.a(this.jdField_a_of_type_Apbi, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Apbm = new apby(this.jdField_a_of_type_Apbi);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    apbi.a(this.jdField_a_of_type_Apbi, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Apbm = new apbp(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbt
 * JD-Core Version:    0.7.0.1
 */