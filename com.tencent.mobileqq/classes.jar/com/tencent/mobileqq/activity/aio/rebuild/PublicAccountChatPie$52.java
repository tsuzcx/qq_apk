package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;

class PublicAccountChatPie$52
  extends IPublicAccountObserver.OnCallback
{
  PublicAccountChatPie$52(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onFollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      paramObject = this.a;
      paramObject.d(paramObject.f.getIntent());
    }
  }
  
  public void onGetHistoryMsgRet(int paramInt)
  {
    ((PAListUI)PublicAccountChatPie.B(this.a).b()).e(paramInt);
  }
  
  public void onUnfollowPublicAccount(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      if ((paramObject != null) && (this.a.ah != null) && (this.a.ah.b.equals(((PublicAccountInfo)paramObject).getUin())))
      {
        this.a.f(1);
        return;
      }
      paramObject = this.a;
      paramObject.d(paramObject.f.getIntent());
    }
  }
  
  public void onUpdateUserFollowList(int paramInt, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.a;
      ((PublicAccountChatPie)localObject).d(((PublicAccountChatPie)localObject).f.getIntent());
    }
    if ((paramBoolean) && (!PublicAccountChatPie.i(this.a)))
    {
      localObject = null;
      IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)this.a.d.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localIPublicAccountDataManager != null) {
        localObject = (PublicAccountInfo)localIPublicAccountDataManager.findPublicAccountInfo(this.a.ah.b);
      }
      if ((localObject != null) && (this.a.bl != null) && (!PublicAccountChatPie.C(this.a))) {
        this.a.bA();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.52
 * JD-Core Version:    0.7.0.1
 */