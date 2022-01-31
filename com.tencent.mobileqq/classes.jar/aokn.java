import com.tencent.qphone.base.util.QLog;

class aokn
  extends aoko
{
  public aokn(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateAcceptByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 11, 5);
    aokk.c(this.jdField_a_of_type_Aokk, 11, 5);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateAcceptByPC)");
    this.jdField_a_of_type_Aoko = new aokl(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aokn
 * JD-Core Version:    0.7.0.1
 */