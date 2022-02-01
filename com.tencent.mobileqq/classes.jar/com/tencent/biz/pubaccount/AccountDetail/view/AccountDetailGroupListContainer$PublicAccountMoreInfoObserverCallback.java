package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class AccountDetailGroupListContainer$PublicAccountMoreInfoObserverCallback
  extends IPublicAccountObserver.OnCallback
{
  private AccountDetailGroupListContainer b;
  
  public AccountDetailGroupListContainer$PublicAccountMoreInfoObserverCallback(AccountDetailGroupListContainer paramAccountDetailGroupListContainer1, AccountDetailGroupListContainer paramAccountDetailGroupListContainer2)
  {
    this.b = paramAccountDetailGroupListContainer2;
  }
  
  public void onDestroy()
  {
    this.b = null;
  }
  
  public void onSetRecvMsgState(boolean paramBoolean, Object paramObject)
  {
    paramObject = (SetRecvMsgStateRsp)paramObject;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecvMsgState isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AccountDetailGroupListContainer", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject.result == 0))
    {
      paramObject = this.a;
      AccountDetailGroupListContainer.b(paramObject, paramObject.j);
      if (this.a.v != null)
      {
        paramObject = this.a.v.edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setting_status_");
        localStringBuilder.append(this.a.f.uin);
        localStringBuilder.append("_");
        localStringBuilder.append(this.a.b.getCurrentAccountUin());
        paramObject.putInt(localStringBuilder.toString(), this.a.j).commit();
      }
    }
  }
  
  public void onUpdateFunctionFlag(boolean paramBoolean, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if ((paramBoolean) && (paramPaConfigInfo != null))
    {
      if ((paramPaConfigInfo.g != 3) && (paramPaConfigInfo.g == 6))
      {
        AccountDetailGroupListContainer localAccountDetailGroupListContainer = this.b;
        if (localAccountDetailGroupListContainer != null) {
          AccountDetailGroupListContainer.a(localAccountDetailGroupListContainer, paramPaConfigInfo);
        }
      }
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).sendDetailInfoRequest(this.a.b, this.a.b.getApplication(), this.a.g);
      return;
    }
    paramPaConfigInfo = this.b;
    if (paramPaConfigInfo != null) {
      AccountDetailGroupListContainer.a(paramPaConfigInfo, 2131892951);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.PublicAccountMoreInfoObserverCallback
 * JD-Core Version:    0.7.0.1
 */