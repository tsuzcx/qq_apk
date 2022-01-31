import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter.1;
import java.util.concurrent.Executor;

public class aoxf
  extends aoxv
{
  public long a;
  private Bundle a;
  public String a;
  private long b;
  public String b;
  
  public aoxf(aowx paramaowx, MessageRecord paramMessageRecord)
  {
    super(paramaowx);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramaowx = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgWidth", paramaowx);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, aoxt paramaoxt)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    apus.a().execute(new QFileMsgForwardManager.BuddyUploadTaskExcuter.1(this, paramString, paramaoxt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxf
 * JD-Core Version:    0.7.0.1
 */