package com.tencent.imsdk.relationship;

import java.util.List;

public abstract class FriendshipListener
{
  public void OnBlackListAdded(List<FriendInfo> paramList) {}
  
  public void OnBlackListDeleted(List<String> paramList) {}
  
  public void OnFriendApplicationListAdded(List<FriendApplication> paramList) {}
  
  public void OnFriendApplicationListDelete(List<String> paramList) {}
  
  public void OnFriendApplicationListRead() {}
  
  public void OnFriendInfoChanged(List<FriendInfo> paramList) {}
  
  public void OnFriendListAdded(List<FriendInfo> paramList) {}
  
  public void OnFriendListDeleted(List<String> paramList) {}
  
  public void OnSelfInfoUpdated(UserInfo paramUserInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.FriendshipListener
 * JD-Core Version:    0.7.0.1
 */