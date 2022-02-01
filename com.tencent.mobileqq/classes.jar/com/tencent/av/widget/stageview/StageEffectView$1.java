package com.tencent.av.widget.stageview;

import android.view.View;
import java.util.Comparator;

class StageEffectView$1
  implements Comparator<Integer>
{
  StageEffectView$1(StageEffectView paramStageEffectView) {}
  
  public int a(Integer paramInteger1, Integer paramInteger2)
  {
    paramInteger1 = (StageEffectView.StageMemberInfo)this.a.getChildAt(paramInteger1.intValue()).getTag();
    paramInteger2 = (StageEffectView.StageMemberInfo)this.a.getChildAt(paramInteger2.intValue()).getTag();
    if (paramInteger1.c < paramInteger2.c) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectView.1
 * JD-Core Version:    0.7.0.1
 */