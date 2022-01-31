import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aogq
  extends aogx
{
  protected long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected String a;
  private long b;
  protected String b;
  
  aogq(aofz paramaofz, MessageRecord paramMessageRecord)
  {
    super(paramaofz);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramaofz = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgWidth", paramaofz);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, aogv paramaogv)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "2");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    String str1 = aopg.a(apck.d(this.jdField_b_of_type_JavaLangString));
    String str2 = aopg.a(apck.a(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Long = apck.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Long + "");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardMd5", str1);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSha", str2);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardDeadTime", "0");
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start DiscUploadTaskExcuter:" + this.jdField_a_of_type_JavaLangString);
    }
    aofz.a(this.jdField_a_of_type_Aofz).a().a(str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramString, aofz.a(this.jdField_a_of_type_Aofz).getCurrentAccountUin(), new aogr(this, paramaogv, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aogq
 * JD-Core Version:    0.7.0.1
 */