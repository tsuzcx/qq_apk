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
    switch (paramInt1)
    {
    }
    for (;;)
    {
      BirthdayPickHelper.a(this.a);
      if ((BirthdayPickHelper.a(this.a) != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        BirthdayPickHelper.a(this.a).a(2);
      }
      if (this.a.a != null)
      {
        paramInt1 = BirthdayPickHelper.d(this.a, BirthdayPickHelper.a(this.a));
        paramInt2 = BirthdayPickHelper.e(this.a, BirthdayPickHelper.b(this.a));
        int i = BirthdayPickHelper.f(this.a, BirthdayPickHelper.c(this.a));
        this.a.a.a(paramInt1, paramInt2, i);
      }
      return;
      BirthdayPickHelper.a(this.a, paramInt2);
      continue;
      BirthdayPickHelper.b(this.a, paramInt2);
      continue;
      BirthdayPickHelper.c(this.a, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BirthdayPickHelper.PickListener
 * JD-Core Version:    0.7.0.1
 */