package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import friendlist.GetOnlineInfoResp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class BaseChatPie$51
  extends FriendListObserver
{
  BaseChatPie$51(BaseChatPie paramBaseChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    this.a.f(paramString);
  }
  
  public void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2)
  {
    BaseChatPie.b(this.a, paramBoolean, paramString1, paramString2);
  }
  
  public void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.c(this.a, paramBoolean, paramObject);
  }
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if (TextUtils.equals(paramString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
      this.a.F();
    }
  }
  
  public void onGetSigZanInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.a, paramObject);
  }
  
  public void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet)
  {
    if (AioApolloHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
    {
      AioApolloHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramHashSet);
      return;
    }
    AvatarLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, paramHashSet);
  }
  
  public void onGetStrangerInfo(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.b(this.a, paramBoolean, paramObject);
  }
  
  public void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    BaseChatPie.a(this.a, paramBoolean, paramLong, paramInt1, paramInt2);
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    BaseChatPie.a(this.a, paramBoolean, paramString1, paramString2);
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap)
  {
    BaseChatPie.b(this.a, paramBoolean);
  }
  
  public void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    BaseChatPie.a(this.a, paramHashMap);
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    BaseChatPie.a(this.a, paramBoolean, paramObject);
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    BaseChatPie.a(this.a, paramString, paramBoolean);
  }
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    this.a.F();
  }
  
  public void onUpdateRecentList() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.51
 * JD-Core Version:    0.7.0.1
 */