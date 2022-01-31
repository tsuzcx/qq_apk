import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

class aofb
  extends aoey
{
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private aoex jdField_a_of_type_Aoex;
  private ayui jdField_a_of_type_Ayui = new aofc(this);
  private String jdField_a_of_type_JavaLangString;
  private UUID jdField_a_of_type_JavaUtilUUID;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  
  private aofb(aoea paramaoea, String paramString1, String paramString2)
  {
    super(paramaoea);
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
    ayue.a().a(this.jdField_a_of_type_JavaUtilUUID, null);
  }
  
  void a(String paramString, int paramInt, aoex paramaoex)
  {
    if (paramaoex == null)
    {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run but callback is null filename " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_Aoex = paramaoex;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilUUID = UUID.randomUUID();
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, "TroopUploadTaskExcuter run WorkerId[" + this.jdField_a_of_type_JavaUtilUUID + "] filename " + this.jdField_a_of_type_JavaLangString);
    ayue.a().a(this.jdField_a_of_type_JavaUtilUUID, this.jdField_b_of_type_Long, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Ayui);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aofb
 * JD-Core Version:    0.7.0.1
 */