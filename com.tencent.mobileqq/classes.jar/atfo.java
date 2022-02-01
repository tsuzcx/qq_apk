import com.tencent.qphone.base.util.QLog;

class atfo
  extends atfi
{
  public atfo(atfe paramatfe)
  {
    super(paramatfe);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atfe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atfe.b(this.jdField_a_of_type_Atfe, 9, 11);
    atfe.c(this.jdField_a_of_type_Atfe, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atfe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atfi.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Atfi = new atgk(this.jdField_a_of_type_Atfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atfo
 * JD-Core Version:    0.7.0.1
 */