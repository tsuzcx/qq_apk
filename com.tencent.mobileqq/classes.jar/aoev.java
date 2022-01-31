import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aoev
  implements aoex
{
  aoev(aoeu paramaoeu, aoea paramaoea, MessageRecord paramMessageRecord, String paramString, int paramInt) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask success, multiUniseq[ " + this.jdField_a_of_type_Aoeu.jdField_a_of_type_Long + "] uuid[" + paramString + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "]");
    }
    this.jdField_a_of_type_Aoeu.b = 2;
    aoea.a(this.jdField_a_of_type_Aoeu.jdField_a_of_type_Aoea, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramBundle);
    aoea.b(this.jdField_a_of_type_Aoeu.jdField_a_of_type_Aoea, this.jdField_a_of_type_Aoeu.jdField_a_of_type_Long);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "FileUploadTask fail, multiUniseq[ " + this.jdField_a_of_type_Aoeu.jdField_a_of_type_Long + "] fileMrUniseq[" + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq + "] canResume[" + paramBoolean + "] retMsg[" + paramString + "]");
    }
    if (paramBoolean) {}
    for (this.jdField_a_of_type_Aoeu.b = 4;; this.jdField_a_of_type_Aoeu.b = 3)
    {
      aoea.b(this.jdField_a_of_type_Aoeu.jdField_a_of_type_Aoea, this.jdField_a_of_type_Aoeu.jdField_a_of_type_Long);
      return;
      String str = ajjy.a(2131638772) + this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramString = str + "\n" + paramString;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFaildReason", paramString);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoev
 * JD-Core Version:    0.7.0.1
 */