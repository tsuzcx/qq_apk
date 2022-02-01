package com.tencent.av.ui.effect.toolbar.newversion;

import android.text.TextUtils;
import com.tencent.av.business.manager.material.EffectMaterialManager;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.interfaces.IEffectCallback;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class SubtitlesToolbar$1
  implements IEffectCallback
{
  SubtitlesToolbar$1(SubtitlesToolbar paramSubtitlesToolbar) {}
  
  public void a(long paramLong)
  {
    BaseToolbar.keepInToolbar(SubtitlesToolbar.access$300(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    BaseToolbar.keepInToolbar(SubtitlesToolbar.access$100(this.a), paramLong);
    String str = this.a.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectClick, 自己点击了字幕, id[");
    localStringBuilder.append(paramItemInfo.a);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    SubtitlesToolbar.access$200(this.a, paramLong, paramItemInfo.a);
    if ((!TextUtils.isEmpty(paramItemInfo.a)) && (!"0".equalsIgnoreCase(paramItemInfo.a))) {
      EffectZimuManager.DataReport.a("0X80085CD", paramItemInfo.a);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo)
  {
    SubtitlesToolbar.access$000(this.a).h(paramItemInfo.a);
    ReportController.b(null, "dc00898", "", "", "0X800BC1A", "0X800BC1A", 0, 0, "", "", "", paramItemInfo.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.toolbar.newversion.SubtitlesToolbar.1
 * JD-Core Version:    0.7.0.1
 */