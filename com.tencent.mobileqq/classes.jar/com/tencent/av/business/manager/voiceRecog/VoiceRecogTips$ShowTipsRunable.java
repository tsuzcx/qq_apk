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
  VideoAppInterface a;
  EffectFaceManager.BlessingTips b;
  
  VoiceRecogTips$ShowTipsRunable(VideoAppInterface paramVideoAppInterface, EffectFaceManager.BlessingTips paramBlessingTips)
  {
    this.b = paramBlessingTips;
    this.a = paramVideoAppInterface;
  }
  
  public void run()
  {
    if (!AVVoiceRecog.b().a())
    {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog disable");
      return;
    }
    if (VoiceRecogTips.b(this.a, this.b.a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ShowTipsRunable, 已经显示过了, time[");
      ((StringBuilder)localObject).append(VoiceRecogTips.d);
      ((StringBuilder)localObject).append("]");
      QLog.w("VoiceRecogTips", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (AVVoiceRecog.b().a(2))
    {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, AVVoiceRecog isPause");
      return;
    }
    Object localObject = this.a.b().k();
    if (localObject == null)
    {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, sessionInfo为空");
      return;
    }
    if (!((SessionInfo)localObject).H)
    {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 本地没开摄像头");
      return;
    }
    if (!((SessionInfo)localObject).I)
    {
      QLog.w("VoiceRecogTips", 1, "ShowTipsRunable, 对端没开摄像头");
      return;
    }
    if (TipsUtil.a(this.a, 1026, this.b.d, null, this.b.g, null))
    {
      VoiceRecogTips.a(this.a, this.b.a);
      VoiceRecogReport.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.voiceRecog.VoiceRecogTips.ShowTipsRunable
 * JD-Core Version:    0.7.0.1
 */