package com.tencent.biz.pubaccount.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

class PublicAccountCheckImpl$1
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountCheckImpl$1(PublicAccountCheckImpl paramPublicAccountCheckImpl) {}
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PublicAccount onUpdateUserFollowList:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0))
    {
      this.a.mAutomator.d.edit().putBoolean("isPublicAccountListOK", true).commit();
      this.a.setResult(7);
      return;
    }
    if (paramInt != 0) {
      this.a.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountCheckImpl.1
 * JD-Core Version:    0.7.0.1
 */