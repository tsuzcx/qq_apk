import com.tencent.qphone.base.util.QLog;

class askf
  extends asjn
{
  public askf(asji paramasji)
  {
    super(paramasji);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenToOffFailed";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Asji.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    asji.b(this.jdField_a_of_type_Asji, 11, 6);
    asji.c(this.jdField_a_of_type_Asji, 11, 6);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Asji.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Asjn.a() + "->StateRefuseByPC)");
    this.jdField_a_of_type_Asjn = new askd(this.jdField_a_of_type_Asji);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     askf
 * JD-Core Version:    0.7.0.1
 */