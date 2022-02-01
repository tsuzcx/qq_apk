package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.ProfileParams;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;

class PublicAccountUtilImpl$11
  implements BusinessObserver
{
  PublicAccountUtilImpl$11(PublicAccountUtilImpl paramPublicAccountUtilImpl, Activity paramActivity, QQAppInterface paramQQAppInterface, ProfileParams paramProfileParams) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new PublicAccountUtilImpl.11.1(this, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.11
 * JD-Core Version:    0.7.0.1
 */