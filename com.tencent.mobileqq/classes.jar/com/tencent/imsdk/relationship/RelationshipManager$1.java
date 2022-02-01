package com.tencent.imsdk.relationship;

import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import java.util.List;

class RelationshipManager$1
  extends FriendshipListener
{
  RelationshipManager$1(RelationshipManager paramRelationshipManager) {}
  
  public void OnBlackListAdded(List<FriendInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.4(this, paramList));
  }
  
  public void OnBlackListDeleted(List<String> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.5(this, paramList));
  }
  
  public void OnFriendApplicationListAdded(List<FriendApplication> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.6(this, paramList));
  }
  
  public void OnFriendApplicationListDelete(List<String> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.7(this, paramList));
  }
  
  public void OnFriendApplicationListRead()
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.8(this));
  }
  
  public void OnFriendInfoChanged(List<FriendInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.1(this, paramList));
  }
  
  public void OnFriendListAdded(List<FriendInfo> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.2(this, paramList));
  }
  
  public void OnFriendListDeleted(List<String> paramList)
  {
    IMContext.getInstance().runOnMainThread(new RelationshipManager.1.3(this, paramList));
  }
  
  public void OnSelfInfoUpdated(UserInfo paramUserInfo)
  {
    BaseManager.getInstance().notifySelfInfoUpdated(paramUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.RelationshipManager.1
 * JD-Core Version:    0.7.0.1
 */