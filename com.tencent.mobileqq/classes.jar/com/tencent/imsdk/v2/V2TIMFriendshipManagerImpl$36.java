package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FriendApplication;
import com.tencent.imsdk.relationship.FriendInfo;
import com.tencent.imsdk.relationship.FriendshipListener;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class V2TIMFriendshipManagerImpl$36
  extends FriendshipListener
{
  V2TIMFriendshipManagerImpl$36(V2TIMFriendshipManagerImpl paramV2TIMFriendshipManagerImpl) {}
  
  public void OnBlackListAdded(List<FriendInfo> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onBlackListAdd(convertToV2FriendInfoList(paramList));
    }
  }
  
  public void OnBlackListDeleted(List<String> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onBlackListDeleted(paramList);
    }
  }
  
  public void OnFriendApplicationListAdded(List<FriendApplication> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FriendApplication localFriendApplication = (FriendApplication)paramList.next();
        V2TIMFriendApplication localV2TIMFriendApplication = new V2TIMFriendApplication();
        localV2TIMFriendApplication.setFriendApplication(localFriendApplication);
        localArrayList.add(localV2TIMFriendApplication);
      }
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendApplicationListAdded(localArrayList);
    }
  }
  
  public void OnFriendApplicationListDelete(List<String> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendApplicationListDeleted(paramList);
    }
  }
  
  public void OnFriendApplicationListRead()
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendApplicationListRead();
    }
  }
  
  public void OnFriendInfoChanged(List<FriendInfo> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendInfoChanged(convertToV2FriendInfoList(paramList));
    }
  }
  
  public void OnFriendListAdded(List<FriendInfo> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendListAdded(convertToV2FriendInfoList(paramList));
    }
  }
  
  public void OnFriendListDeleted(List<String> paramList)
  {
    if (V2TIMFriendshipManagerImpl.access$200(this.this$0) != null) {
      V2TIMFriendshipManagerImpl.access$200(this.this$0).onFriendListDeleted(paramList);
    }
  }
  
  public void OnSelfInfoUpdated(UserInfo paramUserInfo) {}
  
  V2TIMFriendInfo convertToV2FriendInfo(FriendInfo paramFriendInfo)
  {
    V2TIMFriendInfo localV2TIMFriendInfo = new V2TIMFriendInfo();
    if (paramFriendInfo != null) {
      localV2TIMFriendInfo.setFriendInfo(paramFriendInfo);
    }
    return localV2TIMFriendInfo;
  }
  
  List<V2TIMFriendInfo> convertToV2FriendInfoList(List<FriendInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(convertToV2FriendInfo((FriendInfo)paramList.next()));
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl.36
 * JD-Core Version:    0.7.0.1
 */