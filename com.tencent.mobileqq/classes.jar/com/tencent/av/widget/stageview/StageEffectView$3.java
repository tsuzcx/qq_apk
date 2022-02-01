package com.tencent.av.widget.stageview;

import java.util.Comparator;

class StageEffectView$3
  implements Comparator<StageMemberView>
{
  StageEffectView$3(StageEffectView paramStageEffectView) {}
  
  public int a(StageMemberView paramStageMemberView1, StageMemberView paramStageMemberView2)
  {
    if ((paramStageMemberView1 == null) && (paramStageMemberView2 == null)) {
      return 0;
    }
    if (paramStageMemberView2 == null) {
      return -1;
    }
    if (paramStageMemberView1 == null) {
      return 1;
    }
    paramStageMemberView1 = (StageEffectView.StageMemberInfo)paramStageMemberView1.getTag();
    paramStageMemberView2 = (StageEffectView.StageMemberInfo)paramStageMemberView2.getTag();
    if (paramStageMemberView1.a == paramStageMemberView2.a) {
      return 0;
    }
    if (MathUtils.a(paramStageMemberView1.a - 10000, 20000) < MathUtils.a(paramStageMemberView2.a - 10000, 20000)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.3
 * JD-Core Version:    0.7.0.1
 */