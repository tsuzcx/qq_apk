package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.AccountDetail.bean.AccountDetailDynamicInfo;
import com.tencent.biz.pubaccount.AccountDetail.model.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailXListView;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.qphone.base.util.QLog;

class PublicAccountDetailActivityImpl$1
  extends PublicAccountObserver
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
    this.a.isFirstDataComplate = true;
    if (paramInt == 0)
    {
      AccountDetailDynamicInfo localAccountDetailDynamicInfo = ((IPublicAccountDetailDynamicDataManagerService)this.a.app.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(this.a.uin);
      if (localAccountDetailDynamicInfo != null)
      {
        this.a.mAccountDetailAdapter.a(localAccountDetailDynamicInfo.b(), localAccountDetailDynamicInfo.a);
        this.a.mAccountDetailAdapter.a(localAccountDetailDynamicInfo.b());
      }
    }
    boolean bool;
    if (paramBoolean) {
      if (this.a.mAccountDetailAdapter.a() == 0)
      {
        paramBoolean = false;
        if (paramBoolean) {
          this.a.resetFootView();
        }
        this.a.mAccountDetailListView.b(paramBoolean);
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "onDynamicListGet: --hasMoreData=" + paramBoolean);
          bool = paramBoolean;
        }
        label176:
        if (paramInt != 1) {
          break label249;
        }
      }
    }
    for (this.a.errorStatus = PublicAccountDetailActivityImpl.NETWORK_ERROR;; this.a.errorStatus = PublicAccountDetailActivityImpl.NO_MORE_DATA) {
      label249:
      do
      {
        this.a.mAccountDetailAdapter.b(this.a.errorStatus);
        this.a.mAccountDetailAdapter.notifyDataSetChanged();
        return;
        paramBoolean = true;
        break;
        this.a.mAccountDetailAdapter.notifyDataSetChanged();
        this.a.mAccountDetailListView.b();
        bool = false;
        break label176;
      } while ((paramInt != 4) && ((paramInt != 0) || (bool)));
    }
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    a();
  }
  
  public void onUnfollowPublicAccount(int paramInt, PublicAccountInfo paramPublicAccountInfo)
  {
    super.onUnfollowPublicAccount(paramInt, paramPublicAccountInfo);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */