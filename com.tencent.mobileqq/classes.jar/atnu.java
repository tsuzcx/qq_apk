import com.tencent.qphone.base.util.QLog;

class atnu
  extends atnt
{
  public atnu(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atno.b(this.jdField_a_of_type_Atno, 11, 9);
    atno.c(this.jdField_a_of_type_Atno, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Atnt = new atnw(this.jdField_a_of_type_Atno);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnu
 * JD-Core Version:    0.7.0.1
 */