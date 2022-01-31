import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class aqob
  implements aqnr
{
  aqob(aqoa paramaqoa, String paramString, aqot paramaqot) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2DiscTaskExcuter faild");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqoa.jdField_a_of_type_JavaLangString + " Buddy2DiscTaskExcuter faild:" + paramInt);
      }
      this.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqoa.jdField_a_of_type_Long, bool2), bool1);
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
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Aqoa.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Aqoa.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Aqoa.c);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Aqoa.d);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Aqoa.e);
    localBundle.putString("_m_ForwardUuid", paramString);
    if (QLog.isColorLevel()) {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqoa.jdField_a_of_type_JavaLangString + " Buddy2DiscTaskExcuter success");
    }
    this.jdField_a_of_type_Aqot.a(paramString, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqob
 * JD-Core Version:    0.7.0.1
 */