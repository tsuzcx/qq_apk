import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqzt
  extends aqyt
{
  public aqzt(aqyp paramaqyp)
  {
    super(paramaqyp);
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
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 12);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateExcepInvalidWhenChangeToOff");
    this.jdField_a_of_type_Aqyt = new aqzc(this.jdField_a_of_type_Aqyp);
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
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 11);
    aqyp.a(this.jdField_a_of_type_Aqyp, 9, 14, false);
    a("StateUploadingWhenRecv");
    this.jdField_a_of_type_Aqyt = new aqzv(this.jdField_a_of_type_Aqyp);
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((arrr.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 13);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 13);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateUploadoneWhenChangeToOff)");
    this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aqyt = new aqzw(this.jdField_a_of_type_Aqyp);
    return true;
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 9);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyw(this.jdField_a_of_type_Aqyp);
  }
  
  protected void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzt
 * JD-Core Version:    0.7.0.1
 */