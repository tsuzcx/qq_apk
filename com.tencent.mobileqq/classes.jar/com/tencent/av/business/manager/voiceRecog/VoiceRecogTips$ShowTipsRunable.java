package com.tencent.av.business.manager.voiceRecog;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager.BlessingTips;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.tips.TipsUtil;
import com.tencent.qphone.base.util.QLog;

class VoiceRecogTips$ShowTipsRunable
  implements Runnable
{
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  EffectFaceManager.BlessingTips jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips;
  
  VoiceRecogTips$ShowTipsRunable(VideoAppInterface paramVideoAppInterface, EffectFaceManager.BlessingTips paramBlessingTips)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips = paramBlessingTips;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  public void run()
  {
    if (!AVVoiceRecog.a().a()) {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
    }
    do
    {
      return;
      if (VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips.a))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 已经显示过了, time[" + VoiceRecogTips.a + "]");
        return;
      }
      if (AVVoiceRecog.a().a(2))
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
        return;
      }
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a();
      if (localSessionInfo == null)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
        return;
      }
      if (!localSessionInfo.j)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
        return;
      }
      if (!localSessionInfo.k)
      {
        QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
        return;
      }
    } while (!TipsUtil.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1026, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips.jdField_b_of_type_JavaLangString, null, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips.jdField_b_of_type_Int, null));
    VoiceRecogTips.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceEffectFaceManager$BlessingTips.a);
    VoiceRecogReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips.ShowTipsRunable
 * JD-Core Version:    0.7.0.1
 */