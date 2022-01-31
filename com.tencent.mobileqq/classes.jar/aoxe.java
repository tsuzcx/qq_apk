import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aoxe
  implements aout
{
  aoxe(aoxd paramaoxd, String paramString, aoxt paramaoxt) {}
  
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
      this.jdField_a_of_type_Aoxt.a(aowx.a(this.jdField_a_of_type_Aoxd.jdField_a_of_type_Long, bool2), bool1);
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
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Aoxd.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Aoxd.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Aoxd.c);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Aoxd.d);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Aoxd.e);
    localBundle.putString("_m_ForwardUuid", paramString);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aoxd.d))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aoxd.e)) {
        break label257;
      }
    }
    label257:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Aoxd.e))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aoxd.jdField_a_of_type_JavaLangString + " Buddy2TroopTaskExcuter send success, send feeds");
      }
      aowx.a(aowx.a(this.jdField_a_of_type_Aoxd.jdField_a_of_type_Aowx), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString, this.jdField_a_of_type_Aoxd.jdField_a_of_type_Long, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_Aoxt);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Aoxd.d);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxe
 * JD-Core Version:    0.7.0.1
 */