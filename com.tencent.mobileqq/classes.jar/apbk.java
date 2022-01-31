import com.tencent.qphone.base.util.QLog;

class apbk
  extends apbm
{
  public apbk(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateAcceptByPCWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 11, 5);
    apbi.c(this.jdField_a_of_type_Apbi, 11, 5);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateAcceptByPC)");
    this.jdField_a_of_type_Apbm = new apbj(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbk
 * JD-Core Version:    0.7.0.1
 */