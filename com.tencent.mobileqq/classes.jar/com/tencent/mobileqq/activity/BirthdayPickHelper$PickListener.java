package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;

class BirthdayPickHelper$PickListener
  implements IphonePickerView.IphonePickListener
{
  private BirthdayPickHelper$PickListener(BirthdayPickHelper paramBirthdayPickHelper) {}
  
  public void onConfirmBtClicked()
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          BirthdayPickHelper.c(this.a, paramInt2);
        }
      }
      else {
        BirthdayPickHelper.b(this.a, paramInt2);
      }
    }
    else {
      BirthdayPickHelper.a(this.a, paramInt2);
    }
    BirthdayPickHelper.a(this.a);
    if ((BirthdayPickHelper.b(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
      BirthdayPickHelper.b(this.a).a(2);
    }
    if (this.a.a != null)
    {
      BirthdayPickHelper localBirthdayPickHelper = this.a;
      paramInt1 = BirthdayPickHelper.d(localBirthdayPickHelper, BirthdayPickHelper.c(localBirthdayPickHelper));
      localBirthdayPickHelper = this.a;
      paramInt2 = BirthdayPickHelper.e(localBirthdayPickHelper, BirthdayPickHelper.d(localBirthdayPickHelper));
      localBirthdayPickHelper = this.a;
      int i = BirthdayPickHelper.f(localBirthdayPickHelper, BirthdayPickHelper.e(localBirthdayPickHelper));
      this.a.a.a(paramInt1, paramInt2, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper.PickListener
 * JD-Core Version:    0.7.0.1
 */