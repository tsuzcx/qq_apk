package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopGameGuideHelper$1
  extends TroopGameObserver
{
  TroopGameGuideHelper$1(TroopGameGuideHelper paramTroopGameGuideHelper) {}
  
  protected void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (this.a.b == null) {
      return;
    }
    if (!this.a.b.equals(String.valueOf(paramLong1))) {
      return;
    }
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onModifyTroopGameCardSwitch fail. errCode = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(", errInfo = ");
      localStringBuilder.append(paramString);
      if (localStringBuilder.toString() == null) {
        paramString = "";
      }
      QLog.e("TroopGameGuideHelper", 2, paramString);
      QQToast.a(TroopGameGuideHelper.a(this.a).a(), 1, HardCodeUtil.a(2131697421), 0).b(TroopGameGuideHelper.a(this.a).a().getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */