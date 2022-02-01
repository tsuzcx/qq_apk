package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import qxn;
import qxs;
import qzf;
import qzg;
import qzk;
import qzm;

public class RIJRewardTaskTimingPresenter$1
  implements Runnable
{
  public RIJRewardTaskTimingPresenter$1(qzk paramqzk, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    boolean bool2 = true;
    RIJRewardTask localRIJRewardTask = qzk.a(this.this$0).a();
    if (localRIJRewardTask == null) {
      return;
    }
    boolean bool1;
    if (qzk.a(this.this$0).b() >= qxs.b())
    {
      bool1 = true;
      label44:
      if (localRIJRewardTask.c() <= this.jdField_a_of_type_Int) {
        break label295;
      }
    }
    int i;
    int k;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJRewardTaskTimingPresenter", 2, "start timing --> taskAllCompletedToday: " + bool1 + ", overMaxTaskTime: " + bool2 + ", rowKey: " + this.jdField_a_of_type_JavaLangString + ", maxTaskTimeInMs: " + this.jdField_a_of_type_Int + ", type: " + this.b + ", timeDiff: " + qzk.a(this.this$0));
      }
      if ((bool1) || (bool2)) {
        break;
      }
      i = qzk.a(this.this$0);
      qzk.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
      int j = qxs.a();
      k = qzk.a(this.this$0).a();
      localRIJRewardTask.a().a(localRIJRewardTask.c() + i).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
      if (k <= j) {
        break label301;
      }
      this.this$0.b();
      qzk.a(this.this$0).a(0);
      if (qzk.a(this.this$0) != null) {
        qzk.a(this.this$0).a(0);
      }
      qzk.a(this.this$0).postDelayed(qzk.a(this.this$0), 33L);
      return;
      bool1 = false;
      break label44;
      label295:
      bool2 = false;
    }
    label301:
    qzk.a(this.this$0).a(k + i);
    if (qzk.a(this.this$0) != null) {
      qzk.a(this.this$0).a(k + i);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!qzm.a(l, l - i))
    {
      localRIJRewardTask.a().a(0).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
      qzk.a(this.this$0).a(0);
      if (qzk.a(this.this$0) != null) {
        qzk.a(this.this$0).a(0);
      }
    }
    qzk.a(this.this$0).postDelayed(qzk.a(this.this$0), 33L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter.1
 * JD-Core Version:    0.7.0.1
 */