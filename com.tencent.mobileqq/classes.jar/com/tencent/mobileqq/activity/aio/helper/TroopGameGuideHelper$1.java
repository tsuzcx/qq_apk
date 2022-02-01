package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class TroopGameGuideHelper$1
  extends TroopBusinessObserver
{
  TroopGameGuideHelper$1(TroopGameGuideHelper paramTroopGameGuideHelper) {}
  
  public void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString)
  {
    if (this.a.b == null) {}
    while ((!this.a.b.equals(String.valueOf(paramLong1))) || (paramBoolean)) {
      return;
    }
    String str = paramString;
    if (" onModifyTroopGameCardSwitch fail. errCode = " + paramLong2 + ", errInfo = " + paramString == null) {
      str = "";
    }
    QLog.e("TroopGameGuideHelper", 2, str);
    QQToast.a(TroopGameGuideHelper.a(this.a).a(), 1, HardCodeUtil.a(2131697402), 0).b(TroopGameGuideHelper.a(this.a).a().getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.1
 * JD-Core Version:    0.7.0.1
 */