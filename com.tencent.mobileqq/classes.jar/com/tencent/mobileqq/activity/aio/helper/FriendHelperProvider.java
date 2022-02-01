package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.os.Handler.Callback;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.pushdialog.AIOPushDialogHelper;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper;

public class FriendHelperProvider
  extends HelperProvider
{
  public FriendHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((FriendChatPie)paramBaseChatPie);
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    a(16, new InputStatusHelper(paramFriendChatPie));
    a(30, new ReactiveHelper(paramFriendChatPie));
    a(32, new C2CListenTogetherPanel(paramFriendChatPie));
    a(35, new AIOSearchBarHelper(paramFriendChatPie));
    a(42, new AIOPushDialogHelper(paramFriendChatPie));
    a(45, new AioFriendTitleHelper(paramFriendChatPie));
    a(50, new LeftSwipeReplyHelper(paramFriendChatPie));
    a(60, new AIOTofuMsgHelper(paramFriendChatPie));
    a(61, new QidianHelper(paramFriendChatPie));
    a(new WTEntranceHelper(paramFriendChatPie));
    Object localObject = new FriendTipsHelper(paramFriendChatPie.bv());
    a(109, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    localObject = new FriendAddFriendHelper(paramFriendChatPie.bv());
    a(113, (ILifeCycleHelper)localObject);
    a((OnActivityResultCallback)localObject);
    localObject = new WTEntranceHelper(paramFriendChatPie);
    a(122, (ILifeCycleHelper)localObject);
    a((OnActivityResultCallback)localObject);
    a(129, new FriendOnlineStatusHelper(paramFriendChatPie.bv()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FriendHelperProvider
 * JD-Core Version:    0.7.0.1
 */