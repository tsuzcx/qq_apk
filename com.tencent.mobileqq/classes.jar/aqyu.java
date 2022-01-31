import com.tencent.qphone.base.util.QLog;

class aqyu
  extends aqyt
{
  public aqyu(aqyp paramaqyp)
  {
    super(paramaqyp);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 9);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyw(this.jdField_a_of_type_Aqyp);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyu
 * JD-Core Version:    0.7.0.1
 */