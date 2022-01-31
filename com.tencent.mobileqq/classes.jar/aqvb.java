import com.tencent.qphone.base.util.QLog;

class aqvb
  extends aquk
{
  public aqvb(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateRefuseByPCWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 11, 6);
    aqug.c(this.jdField_a_of_type_Aqug, 11, 6);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateRefuseByPC)");
    this.jdField_a_of_type_Aquk = new aqva(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvb
 * JD-Core Version:    0.7.0.1
 */