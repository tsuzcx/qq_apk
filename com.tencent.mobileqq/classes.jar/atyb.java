import com.tencent.qphone.base.util.QLog;

class atyb
  extends atxd
{
  public atyb(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateSenderCancelSendWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 11, 8);
    atwy.c(this.jdField_a_of_type_Atwy, 11, 8);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateSenderCancelSend)");
    this.jdField_a_of_type_Atxd = new atya(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyb
 * JD-Core Version:    0.7.0.1
 */