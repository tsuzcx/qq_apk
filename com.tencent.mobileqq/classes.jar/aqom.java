import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aqom
  implements aqnr
{
  aqom(aqol paramaqol, String paramString, aqot paramaqot) {}
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, "Disc2TroopTaskExcuter onFaild：");
    boolean bool1;
    if ((paramInt == -100001) || (paramInt == -100002) || (paramInt == -100003)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqol.jdField_a_of_type_JavaLangString + " Disc2TroopTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Aqot.a(aqnw.a(this.jdField_a_of_type_Aqol.jdField_a_of_type_Long, bool2), bool1);
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
    localBundle.putString("_m_ForwardFileType", "3");
    localBundle.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_Aqol.jdField_a_of_type_JavaLangString);
    localBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Aqol.jdField_a_of_type_Long + "");
    localBundle.putString("_m_ForwardMd5", this.jdField_a_of_type_Aqol.c);
    localBundle.putString("_m_ForwardDeadTime", "0");
    localBundle.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Aqol.e);
    localBundle.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Aqol.f);
    localBundle.putString("_m_ForwardUuid", paramString);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aqol.e))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Aqol.f)) {
        break label257;
      }
    }
    label257:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Aqol.f))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Aqol.jdField_a_of_type_JavaLangString + " Disc2TroopTaskExcuter send success send feeds");
      }
      aqnw.a(aqnw.a(this.jdField_a_of_type_Aqol.jdField_a_of_type_Aqnw), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString, this.jdField_a_of_type_Aqol.jdField_a_of_type_Long, 0, i, j, 0, false, localBundle, this.jdField_a_of_type_Aqot);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Aqol.e);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqom
 * JD-Core Version:    0.7.0.1
 */