import com.tencent.qphone.base.util.QLog;

class aqvi
  extends aquk
{
  public aqvi(aqug paramaqug)
  {
    super(paramaqug);
  }
  
  protected String a()
  {
    return "StateSenderCancelSendWhenPause";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Aqug.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return;
    }
    aqug.b(this.jdField_a_of_type_Aqug, 11, 8);
    aqug.c(this.jdField_a_of_type_Aqug, 11, 8);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aqug.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aquk.a() + "->StateSenderCancelSend)");
    this.jdField_a_of_type_Aquk = new aqvh(this.jdField_a_of_type_Aqug);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvi
 * JD-Core Version:    0.7.0.1
 */