import com.tencent.qphone.base.util.QLog;

class ator
  extends atnt
{
  public ator(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateSenderCancelSendWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 11, 8);
    atno.c(this.jdField_a_of_type_Atno, 11, 8);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateSenderCancelSend)");
    this.jdField_a_of_type_Atnt = new atoq(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ator
 * JD-Core Version:    0.7.0.1
 */