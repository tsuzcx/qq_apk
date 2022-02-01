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
    Object localObject = VoiceChangeToolbar.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectClick| voiceType=");
    localStringBuilder.append(paramItemInfo.jdField_a_of_type_JavaLangString);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    localObject = this.a.mApp.a().a();
    int i = Integer.parseInt(paramItemInfo.jdField_a_of_type_JavaLangString);
    if (i == 0) {
      AVVoiceRecog.a().b(64);
    } else {
      AVVoiceRecog.a().a(64);
    }
    if (i == 0)
    {
      ((SessionInfo)localObject).u = null;
    }
    else
    {
      if ((paramItemInfo.jdField_a_of_type_JavaLangObject instanceof VoiceChangeData.VoiceInfo)) {
        ((SessionInfo)localObject).u = ((VoiceChangeData.VoiceInfo)paramItemInfo.jdField_a_of_type_JavaLangObject).b;
      } else {
        ((SessionInfo)localObject).u = paramItemInfo.b;
      }
      DataReport.a(paramItemInfo.jdField_a_of_type_JavaLangString);
    }
    ((SessionInfo)localObject).ad = i;
    ((SessionInfo)localObject).ae = 0;
    paramItemInfo = this.a.getAVActivity();
    if ((paramItemInfo != null) && (paramItemInfo.a != null)) {
      paramItemInfo.a.i(paramLong, 8);
    }
    this.a.mApp.a().z();
    VoiceChangeDataReport.a((SessionInfo)localObject, i);
    EffectSettingUi.a(this.a.mApp, paramLong);
    if (((SessionInfo)localObject).d == 4) {
      MultiVideoRichActionReportCollection.d(String.valueOf(i));
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeToolbar.1
 * JD-Core Version:    0.7.0.1
 */