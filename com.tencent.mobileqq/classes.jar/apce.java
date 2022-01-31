import com.tencent.qphone.base.util.QLog;

class apce
  extends apbi
{
  public apce(apbe paramapbe)
  {
    super(paramapbe);
  }
  
  protected String a()
  {
    return "StateSaveToWeiYunByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Apbe.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    apbe.b(this.jdField_a_of_type_Apbe, 11, 7);
    apbe.c(this.jdField_a_of_type_Apbe, 11, 7);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Apbe.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Apbi.a() + "->StateSaveToWeiYunByPC)");
    this.jdField_a_of_type_Apbi = new apcc(this.jdField_a_of_type_Apbe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apce
 * JD-Core Version:    0.7.0.1
 */