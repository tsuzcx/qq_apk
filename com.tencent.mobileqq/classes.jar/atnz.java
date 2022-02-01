import com.tencent.qphone.base.util.QLog;

class atnz
  extends atnt
{
  public atnz(atno paramatno)
  {
    super(paramatno);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atno.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atno.b(this.jdField_a_of_type_Atno, 9, 11);
    atno.c(this.jdField_a_of_type_Atno, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atno.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atnt.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Atnt = new atov(this.jdField_a_of_type_Atno);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atnz
 * JD-Core Version:    0.7.0.1
 */