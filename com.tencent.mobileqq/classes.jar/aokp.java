import com.tencent.qphone.base.util.QLog;

class aokp
  extends aoko
{
  public aokp(aokk paramaokk)
  {
    super(paramaokk);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Aokk.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    aokk.b(this.jdField_a_of_type_Aokk, 11, 9);
    aokk.c(this.jdField_a_of_type_Aokk, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Aokk.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Aoko.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Aoko = new aokr(this.jdField_a_of_type_Aokk);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aokp
 * JD-Core Version:    0.7.0.1
 */