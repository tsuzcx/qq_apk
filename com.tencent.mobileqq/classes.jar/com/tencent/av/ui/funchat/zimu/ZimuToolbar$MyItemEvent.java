package com.tencent.av.ui.funchat.zimu;

import android.text.TextUtils;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QAVPtvTemplateAdapter.IEffectCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.qphone.base.util.QLog;

class ZimuToolbar$MyItemEvent
  implements QAVPtvTemplateAdapter.IEffectCallback
{
  ZimuToolbar$MyItemEvent(ZimuToolbar paramZimuToolbar) {}
  
  public void a(long paramLong)
  {
    EffectSettingUi.a(ZimuToolbar.access$200(this.a), paramLong);
  }
  
  public void a(long paramLong, QavListItemBase.ItemInfo paramItemInfo)
  {
    EffectSettingUi.a(ZimuToolbar.access$000(this.a), paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEffectClick, 自己点击了字幕, id[");
    localStringBuilder.append(paramItemInfo.a);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("ZimuToolbar", 1, localStringBuilder.toString());
    ZimuToolbar.access$100(this.a, paramLong, paramItemInfo.a);
    if ((!TextUtils.isEmpty(paramItemInfo.a)) && (!"0".equalsIgnoreCase(paramItemInfo.a))) {
      EffectZimuManager.DataReport.a("0X80085CD", paramItemInfo.a);
    }
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.zimu.ZimuToolbar.MyItemEvent
 * JD-Core Version:    0.7.0.1
 */