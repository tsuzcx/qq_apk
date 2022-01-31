import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aqul
  implements aqsa
{
  aqul(aquk paramaquk, String paramString, aqva paramaqva) {}
  
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
      this.jdField_a_of_type_Aqva.a(aque.a(this.jdField_a_of_type_Aquk.jdField_a_of_type_Long, bool2), bool1);
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
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_m_ForwardFileType", "3");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Aquk.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Aquk.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Aquk.c);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Aquk.d);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Aquk.e);
    localBundle.putString("_m_ForwardUuid", paramString);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aquk.d))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aquk.e)) {
        break label257;
      }
    }
    label257:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Aquk.e))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aquk.jdField_a_of_type_JavaLangString + " Buddy2TroopTaskExcuter send success, send feeds");
      }
      aque.a(aque.a(this.jdField_a_of_type_Aquk.jdField_a_of_type_Aque), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString, this.jdField_a_of_type_Aquk.jdField_a_of_type_Long, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_Aqva);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Aquk.d);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqul
 * JD-Core Version:    0.7.0.1
 */