import com.tencent.qphone.base.util.QLog;

class atxe
  extends atxd
{
  public atxe(atwy paramatwy)
  {
    super(paramatwy);
  }
  
  protected String a()
  {
    return "StateCancelUploadWhenChangeToOff";
  }
  
  protected boolean a()
  {
    if (this.jdField_a_of_type_Atwy.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "]. recvOnLineFile entity is null");
      return false;
    }
    atwy.b(this.jdField_a_of_type_Atwy, 11, 9);
    atwy.c(this.jdField_a_of_type_Atwy, 11, 9);
    QLog.i("OnlineFileSessionWorker<FileAssistant>", 1, "OLfilesession[" + this.jdField_a_of_type_Atwy.jdField_a_of_type_Long + "] state change :(" + this.jdField_a_of_type_Atxd.a() + "->StateCancelUploadWhenRecv)");
    this.jdField_a_of_type_Atxd = new atxg(this.jdField_a_of_type_Atwy);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxe
 * JD-Core Version:    0.7.0.1
 */