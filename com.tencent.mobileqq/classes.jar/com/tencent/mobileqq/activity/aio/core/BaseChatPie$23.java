package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import java.util.HashMap;
import java.util.HashSet;

class BaseChatPie$23
  extends FriendListObserver
{
  BaseChatPie$23(BaseChatPie paramBaseChatPie) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    BaseChatPie.b(this.a, paramBoolean, paramString1, paramString2);
  }
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.c(this.a, paramBoolean, paramObject);
  }
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramHashSet);
  }
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.b(this.a, paramBoolean, paramObject);
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    BaseChatPie.a(this.a, paramBoolean, paramString1, paramString2);
  }
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    BaseChatPie.a(this.a, paramHashMap);
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.a, paramBoolean, paramObject);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    BaseChatPie.a(this.a, paramString, paramBoolean);
  }
  
  protected void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.23
 * JD-Core Version:    0.7.0.1
 */