package com.tencent.biz.pubaccount.accountdetail.api.impl;

import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailXListView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$1
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountDetailActivityImpl$1(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  void a()
  {
    if (this.a.mIsChangedFromOutSide) {
      this.a.initData();
    }
    this.a.mIsChangedFromOutSide = true;
  }
  
  public void onDynamicListGet(boolean paramBoolean, int paramInt)
  {
    super.onDynamicListGet(paramBoolean, paramInt);
    if (this.a.mAccountDetailAdapter == null) {
      return;
    }
    Object localObject = this.a;
    ((PublicAccountDetailActivityImpl)localObject).isFirstDataComplate = true;
    if (paramInt == 0)
    {
      localObject = (AccountDetailDynamicInfo)((IPublicAccountDetailDynamicDataManagerService)((PublicAccountDetailActivityImpl)localObject).app.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(this.a.uin);
      if (localObject != null)
      {
        this.a.mAccountDetailAdapter.a(((AccountDetailDynamicInfo)localObject).b(), ((AccountDetailDynamicInfo)localObject).a);
        this.a.mAccountDetailAdapter.a(((AccountDetailDynamicInfo)localObject).b());
      }
    }
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean)
    {
      if (this.a.mAccountDetailAdapter.a() == 0) {
        paramBoolean = bool1;
      } else {
        paramBoolean = true;
      }
      if (paramBoolean) {
        this.a.resetFootView();
      }
      this.a.mAccountDetailListView.b(paramBoolean);
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDynamicListGet: --hasMoreData=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
        bool1 = paramBoolean;
      }
    }
    else
    {
      this.a.mAccountDetailAdapter.notifyDataSetChanged();
      this.a.mAccountDetailListView.b();
      bool1 = bool2;
    }
    if (paramInt == 1) {
      this.a.errorStatus = PublicAccountDetailActivityImpl.NETWORK_ERROR;
    } else if ((paramInt == 4) || ((paramInt == 0) && (!bool1))) {
      this.a.errorStatus = PublicAccountDetailActivityImpl.NO_MORE_DATA;
    }
    this.a.mAccountDetailAdapter.b(this.a.errorStatus);
    this.a.mAccountDetailAdapter.notifyDataSetChanged();
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    a();
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    super.onUnfollowPublicAccount(paramInt, paramObject);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */