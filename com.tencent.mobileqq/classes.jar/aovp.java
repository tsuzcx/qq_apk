import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aovp
  extends aovw
{
  protected long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected String a;
  private long b;
  protected String b;
  
  public aovp(aouy paramaouy, MessageRecord paramMessageRecord)
  {
    super(paramaouy);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramaouy = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgWidth", paramaouy);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, aovv paramaovv)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "2");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    String str1 = apgt.a(apug.d(this.jdField_b_of_type_JavaLangString));
    String str2 = apgt.a(apug.a(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Long = apug.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Long + "");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardMd5", str1);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSha", str2);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardDeadTime", "0");
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start DiscUploadTaskExcuter:" + this.jdField_a_of_type_JavaLangString);
    }
    aouy.a(this.jdField_a_of_type_Aouy).a().a(str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramString, aouy.a(this.jdField_a_of_type_Aouy).getCurrentAccountUin(), new aovq(this, paramaovv, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovp
 * JD-Core Version:    0.7.0.1
 */