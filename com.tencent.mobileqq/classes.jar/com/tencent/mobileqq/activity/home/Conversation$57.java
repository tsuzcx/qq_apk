package com.tencent.mobileqq.activity.home;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.recent.DrawerFrame.IDrawerCallbacks;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.armap.ConversationPullDownActiveBase;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import java.util.ArrayList;
import java.util.Iterator;

class Conversation$57
  implements DrawerFrame.IDrawerCallbacks
{
  Conversation$57(Conversation paramConversation) {}
  
  public void a(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.hideMenuPop();
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.a())) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.u();
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
    if (this.a.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.a.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ConversationPullDownActiveBase localConversationPullDownActiveBase = (ConversationPullDownActiveBase)localIterator.next();
        if (localConversationPullDownActiveBase != null) {
          localConversationPullDownActiveBase.h();
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.E();
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
      this.a.jdField_a_of_type_ComTencentMobileqqActivityQQSettingMe.D();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.57
 * JD-Core Version:    0.7.0.1
 */