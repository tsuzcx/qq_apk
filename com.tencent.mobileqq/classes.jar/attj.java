import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class attj
  extends attg
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private atte jdField_a_of_type_Atte;
  private bfxx jdField_a_of_type_Bfxx = new attk(this);
  private String jdField_a_of_type_JavaLangString;
  private UUID jdField_a_of_type_JavaUtilUUID;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  private attj(atsi paramatsi, String paramString1, String paramString2)
  {
    super(paramatsi);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFilePath", this.jdField_b_of_type_JavaLangString);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter begin filename " + this.jdField_a_of_type_JavaLangString);
  }
  
  void a(String paramString, int paramInt)
  {
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter stopped WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Boolean = true;
    bfxt.a().a(this.jdField_a_of_type_JavaUtilUUID, null);
  }
  
  void a(String paramString, int paramInt, atte paramatte)
  {
    if (paramatte == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Atte = paramatte;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    bfxt.a().a(this.jdField_a_of_type_JavaUtilUUID, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bfxx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     attj
 * JD-Core Version:    0.7.0.1
 */