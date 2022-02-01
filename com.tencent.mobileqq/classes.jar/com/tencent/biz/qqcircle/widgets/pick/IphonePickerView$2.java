package com.tencent.biz.qqcircle.widgets.pick;

import android.view.View;

class IphonePickerView$2
  implements AdapterView.OnItemSelectedListener
{
  IphonePickerView$2(IphonePickerView paramIphonePickerView) {}
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    IphonePickerView.a(this.a, paramView, 1);
    IphonePickerView.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          IphonePickerView.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          IphonePickerView.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.IphonePickerView.2
 * JD-Core Version:    0.7.0.1
 */