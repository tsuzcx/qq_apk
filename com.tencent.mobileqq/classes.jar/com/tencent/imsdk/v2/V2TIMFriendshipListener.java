package com.tencent.imsdk.v2;

import java.util.List;

public abstract class V2TIMFriendshipListener
{
  public void onBlackListAdd(List<V2TIMFriendInfo> paramList) {}
  
  public void onBlackListDeleted(List<String> paramList) {}
  
  public void onFriendApplicationListAdded(List<V2TIMFriendApplication> paramList) {}
  
  public void onFriendApplicationListDeleted(List<String> paramList) {}
  
  public void onFriendApplicationListRead() {}
  
  public void onFriendInfoChanged(List<V2TIMFriendInfo> paramList) {}
  
  public void onFriendListAdded(List<V2TIMFriendInfo> paramList) {}
  
  public void onFriendListDeleted(List<String> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipListener
 * JD-Core Version:    0.7.0.1
 */