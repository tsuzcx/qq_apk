package com.tencent.av.business.manager.voiceRecog;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lfe;
import lhe;
import liv;
import ltm;
import mbf;

class VoiceRecogTips$ShowTipsRunable
  implements Runnable
{
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  lhe jdField_a_of_type_Lhe;
  
  VoiceRecogTips$ShowTipsRunable(VideoAppInterface paramVideoAppInterface, lhe paramlhe)
  {
    this.jdField_a_of_type_Lhe = paramlhe;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void run()
  {
    if (!ltm.a().a()) {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
    }
    do
    {
      return;
      if (VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Lhe.a))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 已经显示过了, time[" + VoiceRecogTips.a + "]");
        return;
      }
      if (ltm.a().a(2))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
        return;
      }
      lfe locallfe = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (locallfe == null)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
        return;
      }
      if (!locallfe.j)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
        return;
      }
      if (!locallfe.k)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
        return;
      }
    } while (!mbf.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1026, this.jdField_a_of_type_Lhe.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Lhe.jdField_b_of_type_Int, null));
    VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Lhe.a);
    liv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips.ShowTipsRunable
 * JD-Core Version:    0.7.0.1
 */