package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$16$1
  extends NewPublicAccountObserver.ResponseResultListener
{
  AccountDetailGroupListContainer$16$1(AccountDetailGroupListContainer.16 param16) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(Object paramObject)
  {
    AccountDetailGroupListContainer.b(this.a.b, this.a.b.j);
    if (this.a.b.v != null)
    {
      paramObject = this.a.b.v.edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setting_status_");
      localStringBuilder.append(this.a.b.f.uin);
      localStringBuilder.append("_");
      localStringBuilder.append(this.a.b.b.getCurrentAccountUin());
      paramObject.putInt(localStringBuilder.toString(), this.a.b.j).apply();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("New 0xc76 onGetRecvMsgState isSuccess = ");
      paramObject.append(paramBoolean);
      QLog.d("AccountDetailGroupListContainer", 2, paramObject.toString());
    }
  }
  
  public void b(Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.16.1
 * JD-Core Version:    0.7.0.1
 */