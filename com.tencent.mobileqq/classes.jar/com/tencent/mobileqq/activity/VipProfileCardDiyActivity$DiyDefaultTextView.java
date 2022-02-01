package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.TextView;

public class VipProfileCardDiyActivity$DiyDefaultTextView
  extends TextView
{
  public VipProfileCardDiyActivity$DiyDefaultTextView(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, Context paramContext)
  {
    super(paramContext);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    this.a.ao.onMeasured(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.DiyDefaultTextView
 * JD-Core Version:    0.7.0.1
 */