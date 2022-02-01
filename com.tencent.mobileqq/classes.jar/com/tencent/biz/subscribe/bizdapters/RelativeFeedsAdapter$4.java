package com.tencent.biz.subscribe.bizdapters;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class RelativeFeedsAdapter$4
  extends IPublicAccountObserver.OnCallback
{
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    if ((paramBoolean) && (TextUtils.isEmpty(TroopBarAssistantManager.a().a(paramString))))
    {
      paramString = (IPublicAccountHandler)this.a.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT);
      if (paramString != null) {
        paramString.getUserFollowList();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.4
 * JD-Core Version:    0.7.0.1
 */