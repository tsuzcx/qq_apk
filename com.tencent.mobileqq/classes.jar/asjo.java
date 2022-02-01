import com.tencent.qphone.base.util.QLog;

class asjo
  extends asjn
{
  public asjo(asji paramasji)
  {
    super(paramasji);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    asji.b(this.jdField_a_of_type_Asji, 11, 9);
    asji.c(this.jdField_a_of_type_Asji, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Asjn = new asjq(this.jdField_a_of_type_Asji);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asjo
 * JD-Core Version:    0.7.0.1
 */