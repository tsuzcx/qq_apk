package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;

class AddRequestActivity$13
  extends CardObserver
{
  AddRequestActivity$13(AddRequestActivity paramAddRequestActivity) {}
  
  protected void onImpeach(boolean paramBoolean, String paramString)
  {
    if (!this.a.a.equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a;
      paramString.showToast(2130839806, paramString.getString(2131887672));
      return;
    }
    paramString = this.a;
    paramString.showToast(2130839791, paramString.getString(2131887670));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.13
 * JD-Core Version:    0.7.0.1
 */