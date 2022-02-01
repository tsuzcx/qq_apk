import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class atjk
  implements athm
{
  atjk(atjj paramatjj, String paramString, atju paramatju) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2BuddyTaskExcuter onFaild：");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjj.jdField_a_of_type_JavaLangString + " Disc2BuddyTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atjj.jdField_a_of_type_Long, bool2), bool1);
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
  
  public void a(String paramString1, String paramString2)
  {
    paramString2 = new Bundle();
    paramString2.putString("_m_ForwardFileType", "1");
    paramString2.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    paramString2.putString("_m_ForwardFileName", this.jdField_a_of_type_Atjj.jdField_a_of_type_JavaLangString);
    paramString2.putString("_m_ForwardSize", this.jdField_a_of_type_Atjj.jdField_a_of_type_Long + "");
    paramString2.putString("_m_ForwardMd5", this.jdField_a_of_type_Atjj.c);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Atjj.e);
    paramString2.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Atjj.f);
    paramString2.putString("_m_ForwardUuid", paramString1);
    if (QLog.isColorLevel()) {
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjj.jdField_a_of_type_JavaLangString + " Disc2BuddyTaskExcuter send success");
    }
    this.jdField_a_of_type_Atju.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjk
 * JD-Core Version:    0.7.0.1
 */