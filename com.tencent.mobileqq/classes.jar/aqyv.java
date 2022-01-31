import com.tencent.qphone.base.util.QLog;

class aqyv
  extends aqyt
{
  public aqyv(aqyp paramaqyp)
  {
    super(paramaqyp);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqyp.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqyp.b(this.jdField_a_of_type_Aqyp, 11, 9);
    aqyp.c(this.jdField_a_of_type_Aqyp, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqyp.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aqyt.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Aqyt = new aqyw(this.jdField_a_of_type_Aqyp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyv
 * JD-Core Version:    0.7.0.1
 */