package com.tencent.av.business.manager.voiceRecog;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import lid;
import ljv;
import llk;
import lvt;
import mdd;

class VoiceRecogTips$ShowTipsRunable
  implements Runnable
{
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  ljv jdField_a_of_type_Ljv;
  
  VoiceRecogTips$ShowTipsRunable(VideoAppInterface paramVideoAppInterface, ljv paramljv)
  {
    this.jdField_a_of_type_Ljv = paramljv;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void run()
  {
    if (!lvt.a().a()) {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
    }
    do
    {
      return;
      if (VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Ljv.a))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 已经显示过了, time[" + VoiceRecogTips.a + "]");
        return;
      }
      if (lvt.a().a(2))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
        return;
      }
      lid locallid = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (locallid == null)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
        return;
      }
      if (!locallid.j)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
        return;
      }
      if (!locallid.k)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
        return;
      }
    } while (!mdd.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1026, this.jdField_a_of_type_Ljv.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_Ljv.jdField_b_of_type_Int, null));
    VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Ljv.a);
    llk.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips.ShowTipsRunable
 * JD-Core Version:    0.7.0.1
 */