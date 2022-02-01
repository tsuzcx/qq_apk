package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.AddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper.OneWayFriendListener;

class FriendChatPie$23
  implements OneWayFriendHelper.OneWayFriendListener
{
  FriendChatPie$23(FriendChatPie paramFriendChatPie) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    FriendChatPie.a(this.a, paramBoolean);
    ((AddFriendHelper)this.a.g.a(113)).g();
    paramString = (PlusPanel)this.a.ae.d(8);
    if (paramString != null) {
      paramString.setOneWayFriend(FriendChatPie.c(this.a));
    }
    if (FriendChatPie.c(this.a))
    {
      ChatActivityFacade.a(this.a.d, this.a.f, this.a.ah);
      paramString = (AIOShortcutBarHelper)this.a.q(52);
      if (paramString != null) {
        paramString.d(11);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.23
 * JD-Core Version:    0.7.0.1
 */