import com.tencent.qphone.base.util.QLog;

class apbj
  extends apbi
{
  public apbj(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    apbe.b(this.jdField_a_of_type_Apbe, 11, 9);
    apbe.c(this.jdField_a_of_type_Apbe, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Apbi = new apbl(this.jdField_a_of_type_Apbe);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbj
 * JD-Core Version:    0.7.0.1
 */