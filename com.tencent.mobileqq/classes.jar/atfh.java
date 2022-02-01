import com.tencent.qphone.base.util.QLog;

class atfh
  extends atfi
{
  public atfh(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateAcceptByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 11, 5);
    atfe.c(this.jdField_a_of_type_Atfe, 11, 5);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateAcceptByPC)");
    this.jdField_a_of_type_Atfi = new atff(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfh
 * JD-Core Version:    0.7.0.1
 */