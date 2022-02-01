package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class IntimateInfoView$5
  implements ActionSheet.OnButtonClickListener
{
  IntimateInfoView$5(IntimateInfoView paramIntimateInfoView, String paramString) {}
  
  public void onClick(View paramView, int paramInt)
  {
    IntimateInfoView.d(this.b).dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (!TextUtils.isEmpty(this.a))
      {
        if (IntimateInfoView.e(this.b))
        {
          IntimateInfoView.f(this.b);
          return;
        }
        IntimateInfoView.g(this.b);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.a))
      {
        IntimateInfoView.a(this.b, this.a);
        return;
      }
      if (IntimateInfoView.e(this.b))
      {
        IntimateInfoView.f(this.b);
        return;
      }
      IntimateInfoView.g(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.5
 * JD-Core Version:    0.7.0.1
 */