package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;

class EditInfoActivity$19
  extends ProfileCardObserver
{
  EditInfoActivity$19(EditInfoActivity paramEditInfoActivity) {}
  
  public void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!this.a.j) {}
    do
    {
      return;
      this.a.j = false;
      this.a.runOnUiThread(new EditInfoActivity.19.1(this, paramBoolean, paramCard, paramInt));
    } while (!QLog.isColorLevel());
    QLog.d("EditInfoActivity", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.19
 * JD-Core Version:    0.7.0.1
 */