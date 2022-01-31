import com.tencent.qphone.base.util.QLog;

class apbo
  extends apbi
{
  public apbo(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.b(this.jdField_a_of_type_Apbe, 9, 11);
    apbe.c(this.jdField_a_of_type_Apbe, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Apbi = new apck(this.jdField_a_of_type_Apbe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbo
 * JD-Core Version:    0.7.0.1
 */