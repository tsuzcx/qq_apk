import com.tencent.qphone.base.util.QLog;

class atxj
  extends atxd
{
  public atxj(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 9, 11);
    atwy.c(this.jdField_a_of_type_Atwy, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Atxd = new atyf(this.jdField_a_of_type_Atwy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxj
 * JD-Core Version:    0.7.0.1
 */