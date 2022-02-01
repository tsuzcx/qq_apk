package com.tencent.mobileqq.activity.aio.intimate.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.intimate.info.NewDnaInfo;

class IntimateContentItemNewDnaView$1
  implements IntimateContentItemNewDnaView.FriendDnaRvItemListener
{
  IntimateContentItemNewDnaView$1(IntimateContentItemNewDnaView paramIntimateContentItemNewDnaView) {}
  
  public void a(View paramView, int paramInt, NewDnaInfo paramNewDnaInfo)
  {
    if ((paramNewDnaInfo != null) && (!TextUtils.isEmpty(paramNewDnaInfo.c)))
    {
      IntimateContentItemNewDnaView.a(this.a, paramNewDnaInfo);
      return;
    }
    if ((paramNewDnaInfo != null) && (paramNewDnaInfo.a == 23))
    {
      IntimateContentItemNewDnaView.b(this.a, paramNewDnaInfo);
      return;
    }
    if ((paramNewDnaInfo != null) && (!TextUtils.isEmpty(paramNewDnaInfo.f))) {
      IntimateContentItemNewDnaView.c(this.a, paramNewDnaInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView.1
 * JD-Core Version:    0.7.0.1
 */