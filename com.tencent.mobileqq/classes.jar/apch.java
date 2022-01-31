import com.tencent.qphone.base.util.QLog;

class apch
  extends apbm
{
  public apch(apbi paramapbi)
  {
    super(paramapbi);
  }
  
  protected String a()
  {
    return "StateSaveToWeiYunByPCWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbi.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbi.b(this.jdField_a_of_type_Apbi, 11, 7);
    apbi.c(this.jdField_a_of_type_Apbi, 11, 7);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbi.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbm.a() + "->StateSaveToWeiYunByPC)");
    this.jdField_a_of_type_Apbm = new apcg(this.jdField_a_of_type_Apbi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apch
 * JD-Core Version:    0.7.0.1
 */