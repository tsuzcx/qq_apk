import com.tencent.qphone.base.util.QLog;

class atfj
  extends atfi
{
  public atfj(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 11, 9);
    atfe.c(this.jdField_a_of_type_Atfe, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Atfi = new atfl(this.jdField_a_of_type_Atfe);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfj
 * JD-Core Version:    0.7.0.1
 */