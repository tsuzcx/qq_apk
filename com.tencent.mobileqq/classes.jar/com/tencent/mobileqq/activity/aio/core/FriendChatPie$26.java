package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper.OneWayFriendListener;

class FriendChatPie$26
  implements OneWayFriendHelper.OneWayFriendListener
{
  FriendChatPie$26(FriendChatPie paramFriendChatPie) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    FriendChatPie.a(this.a, paramBoolean);
    this.a.p();
    paramString = (PlusPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if (paramString != null) {
      paramString.setOneWayFriend(FriendChatPie.a(this.a));
    }
    if (FriendChatPie.a(this.a))
    {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramString = (ShortcutBarAIOHelper)this.a.a(52);
      if (paramString != null) {
        paramString.i();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.26
 * JD-Core Version:    0.7.0.1
 */