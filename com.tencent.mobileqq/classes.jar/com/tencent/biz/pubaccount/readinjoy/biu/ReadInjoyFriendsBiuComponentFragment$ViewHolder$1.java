package com.tencent.biz.pubaccount.readinjoy.biu;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ReadInjoyFriendsBiuComponentFragment$ViewHolder$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ReadInjoyFriendsBiuComponentFragment$ViewHolder$1(ReadInjoyFriendsBiuComponentFragment.ViewHolder paramViewHolder) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, "setComments infoFailed. uin:" + paramString1 + " errMsg:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramReadInJoyUserInfo != null) && (this.a.a != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1(this));
    }
    if (paramReadInJoyUserInfo != null) {}
    for (paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;; paramReadInJoyUserInfo = "null")
    {
      QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setComments infoSuccess nick = ", paramReadInJoyUserInfo, "  uin:" + paramString, " mContents:" + this.a.a });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.1
 * JD-Core Version:    0.7.0.1
 */