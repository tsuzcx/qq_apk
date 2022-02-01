package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMFriendshipManager
{
  static V2TIMFriendshipManager getInstance()
  {
    return V2TIMFriendshipManagerImpl.getInstance();
  }
  
  public abstract void acceptFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, int paramInt, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback);
  
  public abstract void addFriend(V2TIMFriendAddApplication paramV2TIMFriendAddApplication, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback);
  
  public abstract void addFriendsToFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void addToBlackList(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void checkFriend(List<String> paramList, int paramInt, V2TIMValueCallback<List<V2TIMFriendCheckResult>> paramV2TIMValueCallback);
  
  public abstract void createFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void deleteFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, V2TIMCallback paramV2TIMCallback);
  
  public abstract void deleteFriendGroup(List<String> paramList, V2TIMCallback paramV2TIMCallback);
  
  public abstract void deleteFriendsFromFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void deleteFromBlackList(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void deleteFromFriendList(List<String> paramList, int paramInt, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback);
  
  public abstract void getBlackList(V2TIMValueCallback<List<V2TIMFriendInfo>> paramV2TIMValueCallback);
  
  public abstract void getFriendApplicationList(V2TIMValueCallback<V2TIMFriendApplicationResult> paramV2TIMValueCallback);
  
  public abstract void getFriendGroups(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendGroup>> paramV2TIMValueCallback);
  
  public abstract void getFriendList(V2TIMValueCallback<List<V2TIMFriendInfo>> paramV2TIMValueCallback);
  
  public abstract void getFriendsInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendInfoResult>> paramV2TIMValueCallback);
  
  public abstract void refuseFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback);
  
  public abstract void renameFriendGroup(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setFriendApplicationRead(V2TIMCallback paramV2TIMCallback);
  
  public abstract void setFriendInfo(V2TIMFriendInfo paramV2TIMFriendInfo, V2TIMCallback paramV2TIMCallback);
  
  public abstract void setFriendListener(V2TIMFriendshipListener paramV2TIMFriendshipListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManager
 * JD-Core Version:    0.7.0.1
 */