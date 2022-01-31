import com.tencent.qphone.base.util.QLog;

class apbn
  extends apbm
{
  public apbn(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 11, 9);
    apbi.c(this.jdField_a_of_type_Apbi, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Apbm = new apbp(this.jdField_a_of_type_Apbi);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbn
 * JD-Core Version:    0.7.0.1
 */