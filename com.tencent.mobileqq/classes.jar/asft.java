import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class asft
  extends asfq
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private asfo jdField_a_of_type_Asfo;
  private behi jdField_a_of_type_Behi = new asfu(this);
  private String jdField_a_of_type_JavaLangString;
  private UUID jdField_a_of_type_JavaUtilUUID;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  private asft(ases paramases, String paramString1, String paramString2)
  {
    super(paramases);
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
    behe.a().a(this.jdField_a_of_type_JavaUtilUUID, null);
  }
  
  void a(String paramString, int paramInt, asfo paramasfo)
  {
    if (paramasfo == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Asfo = paramasfo;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    behe.a().a(this.jdField_a_of_type_JavaUtilUUID, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Behi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asft
 * JD-Core Version:    0.7.0.1
 */