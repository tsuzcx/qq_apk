import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aquz
  implements aqva
{
  aquz(aquy paramaquy, aque paramaque, MessageRecord paramMessageRecord) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask success, multiUniseq[ " + this.jdField_a_of_type_Aquy.jdField_a_of_type_JavaLangString + "] uuid[" + paramString + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "]");
    }
    this.jdField_a_of_type_Aquy.b = 2;
    aque.a(this.jdField_a_of_type_Aquy.jdField_a_of_type_Aque, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramBundle);
    aque.b(this.jdField_a_of_type_Aquy.jdField_a_of_type_Aque, this.jdField_a_of_type_Aquy.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask fail, multiUniseq[ " + this.jdField_a_of_type_Aquy.jdField_a_of_type_JavaLangString + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "] canResume[" + paramBoolean + "] retMsg[" + paramString + "]");
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Aquy.b = 4;; this.jdField_a_of_type_Aquy.b = 3)
    {
      aque.b(this.jdField_a_of_type_Aquy.jdField_a_of_type_Aque, this.jdField_a_of_type_Aquy.jdField_a_of_type_JavaLangString);
      return;
      String str = alud.a(2131710087) + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramString = str + "\n" + paramString;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFaildReason", paramString);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aquz
 * JD-Core Version:    0.7.0.1
 */