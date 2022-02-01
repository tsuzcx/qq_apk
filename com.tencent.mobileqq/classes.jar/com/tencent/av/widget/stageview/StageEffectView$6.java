package com.tencent.av.widget.stageview;

import java.util.Comparator;

class StageEffectView$6
  implements Comparator<StageEffectView.StageMemberInfo>
{
  public int a(StageEffectView.StageMemberInfo paramStageMemberInfo1, StageEffectView.StageMemberInfo paramStageMemberInfo2)
  {
    if (paramStageMemberInfo1.a.a == paramStageMemberInfo2.a.a) {
      return 0;
    }
    if (paramStageMemberInfo1.a.a < paramStageMemberInfo2.a.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.6
 * JD-Core Version:    0.7.0.1
 */