import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class atjf
  implements athm
{
  atjf(atje paramatje, String paramString, atju paramatju) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool3 = false;
    boolean bool4 = true;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Buddy2TroopTaskExcuter onFaild retcode[" + paramInt + "] retMsg[" + paramString + "]");
    boolean bool2 = bool3;
    boolean bool1 = bool4;
    if (paramInt != -100001)
    {
      bool2 = bool3;
      bool1 = bool4;
      if (paramInt != -100002)
      {
        if (paramInt != -100003) {
          break label107;
        }
        bool1 = bool4;
        bool2 = bool3;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atje.jdField_a_of_type_Long, bool2), bool1);
      return;
      label107:
      if ((paramInt == -6101) || (paramInt == -7003))
      {
        bool1 = false;
        bool2 = true;
      }
      else
      {
        bool1 = false;
        bool2 = bool3;
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "3");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Atje.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Atje.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Atje.d);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Atje.e);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Atje.f);
    localBundle.putString("_m_ForwardUuid", paramString1);
    localBundle.putString("_m_ForwardFileIdCrc", paramString2);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Atje.e))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Atje.f)) {
        break label267;
      }
    }
    label267:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Atje.f))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atje.jdField_a_of_type_JavaLangString + " Buddy2TroopTaskExcuter send success, send feeds");
      }
      atiy.a(atiy.a(this.jdField_a_of_type_Atje.jdField_a_of_type_Atiy), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString1, this.jdField_a_of_type_Atje.jdField_a_of_type_Long, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_Atju);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Atje.e);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjf
 * JD-Core Version:    0.7.0.1
 */