import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class atjo
  implements athm
{
  atjo(atjn paramatjn, String paramString, atju paramatju) {}
  
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
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjn.jdField_a_of_type_JavaLangString + " Disc2TroopTaskExcuter send faild:" + paramInt);
      }
      this.jdField_a_of_type_Atju.a(atiy.a(this.jdField_a_of_type_Atjn.jdField_a_of_type_Long, bool2), bool1);
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
    paramString2.putString("_m_ForwardFileType", "3");
    paramString2.putString("_m_ForwardReceiverUin", this.jdField_a_of_type_JavaLangString);
    paramString2.putString("_m_ForwardFileName", this.jdField_a_of_type_Atjn.jdField_a_of_type_JavaLangString);
    paramString2.putString("_m_ForwardSize", this.jdField_a_of_type_Atjn.jdField_a_of_type_Long + "");
    paramString2.putString("_m_ForwardMd5", this.jdField_a_of_type_Atjn.c);
    paramString2.putString("_m_ForwardDeadTime", "0");
    paramString2.putString("_m_ForwardImgWidth", this.jdField_a_of_type_Atjn.e);
    paramString2.putString("_m_ForwardImgHeight", this.jdField_a_of_type_Atjn.f);
    paramString2.putString("_m_ForwardUuid", paramString1);
    int i;
    if (TextUtils.isEmpty(this.jdField_a_of_type_Atjn.e))
    {
      i = 0;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Atjn.f)) {
        break label248;
      }
    }
    label248:
    for (int j = 0;; j = Integer.parseInt(this.jdField_a_of_type_Atjn.f))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_Atjn.jdField_a_of_type_JavaLangString + " Disc2TroopTaskExcuter send success send feeds");
      }
      atiy.a(atiy.a(this.jdField_a_of_type_Atjn.jdField_a_of_type_Atiy), Long.parseLong(this.jdField_a_of_type_JavaLangString), 102, paramString1, this.jdField_a_of_type_Atjn.jdField_a_of_type_Long, 0, i, j, 0, false, paramString2, this.jdField_a_of_type_Atju);
      return;
      i = Integer.parseInt(this.jdField_a_of_type_Atjn.e);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjo
 * JD-Core Version:    0.7.0.1
 */