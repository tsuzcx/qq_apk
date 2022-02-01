package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ListenChangeVoicePanel$3
  extends CallBacker
{
  ListenChangeVoicePanel$3(ListenChangeVoicePanel paramListenChangeVoicePanel) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (1000L == paramLong)
    {
      if (!"changeVoice_json".equals(paramString1)) {
        return;
      }
      if ((QLog.isColorLevel()) || (paramInt1 != 0))
      {
        paramString1 = new StringBuilder();
        paramString1.append("changeVoice jsonLoaded callBacker, errorCode=");
        paramString1.append(paramInt1);
        QLog.d("ListenChangeVoicePanel", 2, paramString1.toString());
      }
      if (paramInt1 == 0) {
        this.a.a(true);
      }
      paramString1 = (IVasQuickUpdateService)((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getRuntimeService(IVasQuickUpdateService.class, "");
      if (paramString1 != null) {
        paramString1.removeCallBacker(this.a.m);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel.3
 * JD-Core Version:    0.7.0.1
 */