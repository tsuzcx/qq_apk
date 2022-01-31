import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aokv
  extends aoko
{
  public aokv(aokk paramaokk)
  {
    super(paramaokk);
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
    aokk.a(this.jdField_a_of_type_Aokk, 9, 11);
    aokk.a(this.jdField_a_of_type_Aokk, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Aoko = new aolq(this.jdField_a_of_type_Aokk);
    this.jdField_a_of_type_Aokk.a(true, 0L);
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
    aokk.a(this.jdField_a_of_type_Aokk, 9, 12, true);
    a("StateExcepInvalidWhenRecv");
    this.jdField_a_of_type_Aoko = new aokz(this.jdField_a_of_type_Aokk);
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    if (a("onSenderUploadCompleted")) {
      return false;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((apck.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    this.jdField_a_of_type_Aokk.a(paramLong, localFileManagerEntity.peerUin);
    localFileManagerEntity.setCloudType(1);
    aokk.a(this.jdField_a_of_type_Aokk, 1, 0, true);
    a("StateGotoOffFileProcess");
    this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aoko = new aola(this.jdField_a_of_type_Aokk);
    return true;
  }
  
  protected void b()
  {
    if (a("onSenderCancelUpload")) {
      return;
    }
    aokk.a(this.jdField_a_of_type_Aokk, 11, 9, true);
    a("StateCancelUploadWhenRecv");
    this.jdField_a_of_type_Aoko = new aokr(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aokv
 * JD-Core Version:    0.7.0.1
 */