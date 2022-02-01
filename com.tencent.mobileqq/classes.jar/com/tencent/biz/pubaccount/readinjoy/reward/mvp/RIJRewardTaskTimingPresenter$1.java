package com.tencent.biz.pubaccount.readinjoy.reward.mvp;

import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTask;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import rjt;
import rjy;
import rll;
import rlm;
import rlq;
import rls;

public class RIJRewardTaskTimingPresenter$1
  implements Runnable
{
  public RIJRewardTaskTimingPresenter$1(rlq paramrlq, int paramInt1, String paramString, int paramInt2) {}
  
  public void run()
  {
    boolean bool2 = true;
    RIJRewardTask localRIJRewardTask = rlq.a(this.this$0).a();
    if (localRIJRewardTask == null) {
      return;
    }
    boolean bool1;
    if (rlq.a(this.this$0).b() >= rjy.b())
    {
      bool1 = true;
      label44:
      if (localRIJRewardTask.c() <= this.jdField_a_of_type_Int) {
        break label303;
      }
    }
    int i;
    int k;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJRewardTaskTimingPresenter", 2, "start timing --> taskAllCompletedToday: " + bool1 + ", overMaxTaskTime: " + bool2 + ", rowKey: " + this.jdField_a_of_type_JavaLangString + ", maxTaskTimeInMs: " + this.jdField_a_of_type_Int + ", type: " + this.b + ", timeDiff: " + rlq.a(this.this$0));
      }
      if (rlq.a(this.this$0, bool1, localRIJRewardTask, this.jdField_a_of_type_Int)) {
        break;
      }
      i = rlq.a(this.this$0);
      rlq.a(this.this$0, NetConnInfoCenter.getServerTimeMillis());
      int j = rjy.a();
      k = rlq.a(this.this$0).a();
      localRIJRewardTask.a().a(localRIJRewardTask.c() + i).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
      if (!rlq.a(this.this$0, k, j)) {
        break label309;
      }
      rlq.a(this.this$0).a(0);
      if (rlq.a(this.this$0) != null) {
        rlq.a(this.this$0).a(0);
      }
      rlq.a(this.this$0).postDelayed(rlq.a(this.this$0), 33L);
      return;
      bool1 = false;
      break label44;
      label303:
      bool2 = false;
    }
    label309:
    rlq.a(this.this$0).a(k + i);
    if (rlq.a(this.this$0) != null) {
      rlq.a(this.this$0).a(k + i);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (!rls.a(l, l - i))
    {
      localRIJRewardTask.a().a(0).a("RIJ_REWARD_TASK_KEY_KEY_CURRENT_TASK");
      rlq.a(this.this$0).a(0);
      if (rlq.a(this.this$0) != null) {
        rlq.a(this.this$0).a(0);
      }
    }
    rlq.a(this.this$0).postDelayed(rlq.a(this.this$0), 33L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.mvp.RIJRewardTaskTimingPresenter.1
 * JD-Core Version:    0.7.0.1
 */