import com.tencent.qphone.base.util.QLog;

class apbs
  extends apbm
{
  public apbs(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 9, 11);
    apbi.c(this.jdField_a_of_type_Apbi, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Apbm = new apco(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbs
 * JD-Core Version:    0.7.0.1
 */