import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqok
  implements aqnr
{
  aqok(aqoj paramaqoj, String paramString, aqot paramaqot) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2DiscTaskExcuter onFaild：");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqoj.jdField_a_of_type_JavaLangString + " Disc2DiscTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqoj.jdField_a_of_type_Long, bool2), bool1);
      return;
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "2");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Aqoj.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Aqoj.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Aqoj.c);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Aqoj.e);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Aqoj.f);
    localBundle.putString("_m_ForwardUuid", paramString);
    if (QLog.isColorLevel()) {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqoj.jdField_a_of_type_JavaLangString + " Disc2DiscTaskExcuter send success");
    }
    this.jdField_a_of_type_Aqot.a(paramString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqok
 * JD-Core Version:    0.7.0.1
 */