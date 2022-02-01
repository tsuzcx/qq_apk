package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;

class LimitChatPie$21
  implements Runnable
{
  LimitChatPie$21(LimitChatPie paramLimitChatPie, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.this$0.I.setText(this.this$0.e.getString(2131896838));
    } else {
      this.this$0.I.setText(this.a);
    }
    Object localObject = (AioFriendTitleHelper)this.this$0.q(45);
    if (((AioFriendTitleHelper)localObject).h()) {
      return;
    }
    boolean bool = true;
    if ((this.b) || (((AioFriendTitleHelper)localObject).g()) || (!this.this$0.bf)) {
      bool = false;
    }
    localObject = ((FriendsManager)this.this$0.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).m(this.this$0.ah.b);
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).setSubtitleOnlineDrawable(this.this$0.d, (Friends)localObject, this.this$0.I, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.21
 * JD-Core Version:    0.7.0.1
 */