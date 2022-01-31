import com.tencent.qphone.base.util.QLog;

class aolg
  extends aoko
{
  public aolg(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 11, 6);
    aokk.c(this.jdField_a_of_type_Aokk, 11, 6);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateRefuseByPC)");
    this.jdField_a_of_type_Aoko = new aole(this.jdField_a_of_type_Aokk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aolg
 * JD-Core Version:    0.7.0.1
 */