import com.tencent.qphone.base.util.QLog;

class aqys
  extends aqyt
{
  public aqys(aqyp paramaqyp)
  {
    super(paramaqyp);
  }
  
  protected String a()
  {
    return "StateAcceptByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 5);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 5);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateAcceptByPC)");
    this.jdField_a_of_type_Aqyt = new aqyq(this.jdField_a_of_type_Aqyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqys
 * JD-Core Version:    0.7.0.1
 */