package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class TroopChatPie$8
  extends RoamSettingObserver
{
  TroopChatPie$8(TroopChatPie paramTroopChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("message.group.policy.")) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramString = this.a.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSetGenralSettingsTroopFilter: isSuc = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", size = ");
        int i;
        if (paramMap == null) {
          i = 0;
        } else {
          i = paramMap.size();
        }
        localStringBuilder.append(i);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
      if (paramMap != null)
      {
        if (paramMap.size() == 0) {
          return;
        }
        if (this.a.f.isResume())
        {
          if (paramBoolean)
          {
            QQToast.makeText(this.a.d.getApp(), 2, this.a.f.getString(2131917581), 0).show(this.a.f.getTitleBarHeight());
            return;
          }
          QQToast.makeText(this.a.d.getApp(), 1, this.a.f.getString(2131917580), 0).show(this.a.f.getTitleBarHeight());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */