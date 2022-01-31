import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class aqut
  extends aquk
{
  public aqut(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateExcepInvalidWhenChangeToOff";
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2);
    aqug.b(this.jdField_a_of_type_Aqug, 11, 11);
    aqug.c(this.jdField_a_of_type_Aqug, 11, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadingWhenChangeToOff)");
    this.jdField_a_of_type_Aquk = new aqvk(this.jdField_a_of_type_Aqug);
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 9, 12);
    aqug.c(this.jdField_a_of_type_Aqug, 9, 12);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateExcepInvalidWhenRecv)");
    this.jdField_a_of_type_Aquk = new aquv(this.jdField_a_of_type_Aqug);
    return true;
  }
  
  protected boolean a(int paramInt, String paramString, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    localFileManagerEntity.Uuid = new String(paramString);
    localFileManagerEntity.fProgress = 0.0F;
    if ((arni.a(localFileManagerEntity.fileName) == 0) && (localFileManagerEntity.Uuid != null) && (localFileManagerEntity.Uuid.length() != 0)) {
      this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localFileManagerEntity, 7);
    }
    localFileManagerEntity.setCloudType(1);
    aqug.b(this.jdField_a_of_type_Aqug, 11, 13);
    aqug.c(this.jdField_a_of_type_Aqug, 11, 13);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateUploadoneWhenChangeToOff)");
    this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 22, new Object[] { Long.valueOf(localFileManagerEntity.nSessionId), Long.valueOf(localFileManagerEntity.nOLfileSessionId) });
    this.jdField_a_of_type_Aquk = new aqvn(this.jdField_a_of_type_Aqug);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqut
 * JD-Core Version:    0.7.0.1
 */