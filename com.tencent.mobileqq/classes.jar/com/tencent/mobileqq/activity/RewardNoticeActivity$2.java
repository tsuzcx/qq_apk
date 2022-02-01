package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

class RewardNoticeActivity$2
  extends BabyQObserver
{
  RewardNoticeActivity$2(RewardNoticeActivity paramRewardNoticeActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(this.a.q)) {
        QQToast.makeText(this.a.app.getApp(), 2, this.a.q, 0).show();
      }
      if (this.a.j == 13) {
        this.a.b();
      }
      this.a.finish();
      return;
    }
    QQToast.makeText(this.a.app.getApp(), 1, HardCodeUtil.a(2131910921), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RewardNoticeActivity.2
 * JD-Core Version:    0.7.0.1
 */