package com.tencent.biz.pubaccount.readinjoy.viola.reward;

import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskConfig;
import com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskLocalRepo;
import com.tencent.biz.pubaccount.readinjoy.reward.mvp.IRIJRewardTaskTimingContract.IView;

class VKdRewardTaskVideoTimer$2
  implements IRIJRewardTaskTimingContract.IView
{
  VKdRewardTaskVideoTimer$2(VKdRewardTaskVideoTimer paramVKdRewardTaskVideoTimer, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4, TextView paramTextView5) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText("完成任务需要的时间：" + RIJRewardTaskConfig.a() / 1000 + "秒");
    this.b.setText("该视频最大贡献时长：" + RIJRewardTaskConfig.c() / 1000 + "秒");
    this.c.setVisibility(8);
    this.d.setText("已完成任务数：" + RIJRewardTaskLocalRepo.b().a() / RIJRewardTaskConfig.b());
    this.e.setText("累积时间：" + paramInt / 1000 + "秒");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.reward.VKdRewardTaskVideoTimer.2
 * JD-Core Version:    0.7.0.1
 */