package com.tencent.av.ui.effect.toolbar.oldversion;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.recog.AVVoiceRecog;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VoiceChangeData.VoiceInfo;
import com.tencent.av.ui.VoiceChangeDataReport;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;

class VoiceChangeToolbar$1
  implements IEffectCallback
{
  VoiceChangeToolbar$1(VoiceChangeToolbar paramVoiceChangeToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(VoiceChangeToolbar.access$300(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    Object localObject = VoiceChangeToolbar.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectClick| voiceType=");
    localStringBuilder.append(paramItemInfo.a);
    AVLog.printAllUserLog((String)localObject, localStringBuilder.toString());
    localObject = VoiceChangeToolbar.access$000(this.a).b().k();
    int i = Integer.parseInt(paramItemInfo.a);
    if (i == 0) {
      AVVoiceRecog.b().c(64);
    } else {
      AVVoiceRecog.b().b(64);
    }
    if (i == 0)
    {
      ((SessionInfo)localObject).bV = null;
    }
    else
    {
      if ((paramItemInfo.m instanceof VoiceChangeData.VoiceInfo)) {
        ((SessionInfo)localObject).bV = ((VoiceChangeData.VoiceInfo)paramItemInfo.m).b;
      } else {
        ((SessionInfo)localObject).bV = paramItemInfo.b;
      }
      DataReport.a(paramItemInfo.a);
    }
    ((SessionInfo)localObject).cr = i;
    ((SessionInfo)localObject).cs = 0;
    paramItemInfo = this.a.getAVActivity();
    if ((paramItemInfo != null) && (paramItemInfo.K != null)) {
      paramItemInfo.K.f(paramLong, 8);
    }
    VoiceChangeToolbar.access$100(this.a).b().am();
    VoiceChangeDataReport.a((SessionInfo)localObject, i);
    BaseToolbar.keepInToolbar(VoiceChangeToolbar.access$200(this.a), paramLong);
    if (((SessionInfo)localObject).g == 4) {
      MultiVideoRichActionReportCollection.d(String.valueOf(i));
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.oldversion.VoiceChangeToolbar.1
 * JD-Core Version:    0.7.0.1
 */