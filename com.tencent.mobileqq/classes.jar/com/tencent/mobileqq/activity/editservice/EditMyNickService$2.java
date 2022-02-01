package com.tencent.mobileqq.activity.editservice;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;

class EditMyNickService$2
  extends ProfileCardObserver
{
  EditMyNickService$2(EditMyNickService paramEditMyNickService) {}
  
  protected void onSetProfileDetail(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (!EditMyNickService.a(this.a).booleanValue()) {
      return;
    }
    EditMyNickService.a(this.a, Boolean.valueOf(false));
    UiThreadUtil.a(new EditMyNickService.2.1(this, paramBoolean, paramCard, paramInt));
    if (QLog.isColorLevel()) {
      QLog.d("EditMyNickService", 2, String.format("onGetDetailInfo, isSuccess: %s, resultCode:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditMyNickService.2
 * JD-Core Version:    0.7.0.1
 */