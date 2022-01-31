import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileMultiMsgManager.BuddyUploadTaskExcuter.1;
import java.util.concurrent.Executor;

public class aovg
  extends aovw
{
  public long a;
  private Bundle a;
  public String a;
  private long b;
  public String b;
  
  public aovg(aouy paramaouy, MessageRecord paramMessageRecord)
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
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    apus.a().execute(new FileMultiMsgManager.BuddyUploadTaskExcuter.1(this, paramString, paramaovv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovg
 * JD-Core Version:    0.7.0.1
 */