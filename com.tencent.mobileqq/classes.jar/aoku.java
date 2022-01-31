import com.tencent.qphone.base.util.QLog;

class aoku
  extends aoko
{
  public aoku(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateChangeToOffWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 9, 11);
    aokk.c(this.jdField_a_of_type_Aokk, 9, 14);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateUploadingWhenRecv)");
    this.jdField_a_of_type_Aoko = new aolq(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoku
 * JD-Core Version:    0.7.0.1
 */