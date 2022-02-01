package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;

class VoiceChangeToolbar$1
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  VoiceChangeToolbar$1(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(this.a.mApp, paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    AVLog.printAllUserLog(VoiceChangeToolbar.TAG, "onEffectClick| voiceType=" + paramItemInfo.jdField_a_of_type_JavaLangString);
    SessionInfo localSessionInfo = this.a.mApp.a().a();
    int i = Integer.parseInt(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      AVVoiceRecog.a().b(64);
    }
    while (i == 0)
    {
      localSessionInfo.v = null;
      localSessionInfo.U = i;
      localSessionInfo.V = 0;
      paramItemInfo = this.a.getAVActivity();
      if ((paramItemInfo != null) && (paramItemInfo.a != null)) {
        paramItemInfo.a.i(paramLong, 8);
      }
      this.a.mApp.a().y();
      VoiceChangeDataReport.a(localSessionInfo, i);
      EffectSettingUi.a(this.a.mApp, paramLong);
      if (localSessionInfo.d == 4) {
        MultiVideoRichActionReportCollection.e(String.valueOf(i));
      }
      return;
      AVVoiceRecog.a().a(64);
    }
    if ((paramItemInfo.jdField_a_of_type_JavaLangObject instanceof VoiceChangeData.VoiceInfo)) {}
    for (localSessionInfo.v = ((VoiceChangeData.VoiceInfo)paramItemInfo.jdField_a_of_type_JavaLangObject).b;; localSessionInfo.v = paramItemInfo.b)
    {
      DataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar.1
 * JD-Core Version:    0.7.0.1
 */