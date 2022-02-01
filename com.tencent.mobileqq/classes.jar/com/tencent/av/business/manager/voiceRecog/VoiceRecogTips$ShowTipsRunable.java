package com.tencent.av.business.manager.voiceRecog;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lff;
import lgy;
import lip;
import ltr;
import mbb;

class VoiceRecogTips$ShowTipsRunable
  implements Runnable
{
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  lgy jdField_a_of_type_Lgy;
  
  VoiceRecogTips$ShowTipsRunable(VideoAppInterface paramVideoAppInterface, lgy paramlgy)
  {
    this.jdField_a_of_type_Lgy = paramlgy;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void run()
  {
    if (!ltr.a().a()) {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
    }
    do
    {
      return;
      if (VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Lgy.a))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 已经显示过了, time[" + VoiceRecogTips.a + "]");
        return;
      }
      if (ltr.a().a(2))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
        return;
      }
      lff locallff = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (locallff == null)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
        return;
      }
      if (!locallff.j)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
        return;
      }
      if (!locallff.k)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
        return;
      }
    } while (!mbb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1026, this.jdField_a_of_type_Lgy.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Lgy.jdField_b_of_type_Int, null));
    VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Lgy.a);
    lip.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips.ShowTipsRunable
 * JD-Core Version:    0.7.0.1
 */