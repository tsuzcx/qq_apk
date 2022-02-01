package com.tencent.mobileqq.activity.home;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;

class Conversation$58
  implements DrawerFrame.IDrawerCallbacks
{
  Conversation$58(Conversation paramConversation) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.hideMenuPop();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.e();
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, float paramFloat) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.n();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.h();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.f();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.f();
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt1, int paramInt2)
  {
    Conversation.k(this.a);
    if (this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2 != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.o();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.e();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivitySpringfestivalEntrySpringFestivalTaskCallback.i();
    }
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.j();
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentSpecialcareCareNotificationBar.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.58
 * JD-Core Version:    0.7.0.1
 */