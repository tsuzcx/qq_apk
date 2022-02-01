import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class asjw
  extends asjn
{
  public asjw(asji paramasji)
  {
    super(paramasji);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenChangeToOff";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    asji.b(this.jdField_a_of_type_Asji, 11, 11);
    asji.c(this.jdField_a_of_type_Asji, 11, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateUploadingWhenChangeToOff)");
    this.jdField_a_of_type_Asjn = new askn(this.jdField_a_of_type_Asji);
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    asji.b(this.jdField_a_of_type_Asji, 9, 12);
    asji.c(this.jdField_a_of_type_Asji, 9, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Asjn = new asjy(this.jdField_a_of_type_Asji);
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((aszt.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    asji.b(this.jdField_a_of_type_Asji, 11, 13);
    asji.c(this.jdField_a_of_type_Asji, 11, 13);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateUploadoneWhenChangeToOff)");
    this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Asjn = new askq(this.jdField_a_of_type_Asji);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjw
 * JD-Core Version:    0.7.0.1
 */