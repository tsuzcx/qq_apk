package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.helper.AddFriendHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper.OneWayFriendListener;

class FriendChatPie$22
  implements OneWayFriendHelper.OneWayFriendListener
{
  FriendChatPie$22(FriendChatPie paramFriendChatPie) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    FriendChatPie.a(this.a, paramBoolean);
    ((AddFriendHelper)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(113)).e();
    paramString = (PlusPanel)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
    if (paramString != null) {
      paramString.setOneWayFriend(FriendChatPie.a(this.a));
    }
    if (FriendChatPie.a(this.a))
    {
      ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      paramString = (AIOShortcutBarHelper)this.a.a(52);
      if (paramString != null) {
        paramString.c(11);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.22
 * JD-Core Version:    0.7.0.1
 */