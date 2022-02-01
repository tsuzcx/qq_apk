package com.tencent.imsdk.relationship;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;

public class RelationshipManager
{
  private FriendshipListener mFriendshipInternalListener;
  private FriendshipListener mFriendshipListener;
  
  public static RelationshipManager getInstance()
  {
    return RelationshipManager.RelationshipManagerHolder.access$000();
  }
  
  private void initFriendshipListener()
  {
    if (this.mFriendshipInternalListener == null) {
      this.mFriendshipInternalListener = new RelationshipManager.1(this);
    }
    nativeSetFriendshipListener(this.mFriendshipInternalListener);
  }
  
  public void addFriend(FriendAddApplication paramFriendAddApplication, IMCallback<FriendOperationResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeAddFriend(paramFriendAddApplication, paramIMCallback);
  }
  
  public void addFriendsToFriendGroup(String paramString, List<String> paramList, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeAddFriendsToFriendGroup(paramString, paramList, paramIMCallback);
  }
  
  public void addToBlackList(List<String> paramList, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeAddToBlackList(paramList, paramIMCallback);
  }
  
  public void checkFriend(List<String> paramList, int paramInt, IMCallback<List<FriendCheckResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeCheckFriend(paramList, paramInt, paramIMCallback);
  }
  
  public void createFriendGroup(String paramString, List<String> paramList, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeCreateFromGroup(paramString, paramList, paramIMCallback);
  }
  
  public void deleteFrendsFromFriendGroup(String paramString, List<String> paramList, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteFriendsFromFriendGroup(paramString, paramList, paramIMCallback);
  }
  
  public void deleteFriendApplication(int paramInt, String paramString, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteFriendApplication(paramInt, paramString, paramIMCallback);
  }
  
  public void deleteFriendGroup(List<String> paramList, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteFriendGroup(paramList, paramIMCallback);
  }
  
  public void deleteFromBlackList(List<String> paramList, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteFromBlackList(paramList, paramIMCallback);
  }
  
  public void deleteFromFriendList(List<String> paramList, int paramInt, IMCallback<List<FriendOperationResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeDeleteFromFriendList(paramList, paramInt, paramIMCallback);
  }
  
  public void getBlackList(IMCallback<List<FriendInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetBlackList(paramIMCallback);
  }
  
  public void getC2CReceiveMessageOpt(List<String> paramList, IMCallback<List<ReceiveMessageOptInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetC2CReceiveMessageOpt(paramList, paramIMCallback);
  }
  
  public void getFriendApplicationList(IMCallback<FriendApplicationResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetFriendApplicationList(paramIMCallback);
  }
  
  public void getFriendGroups(List<String> paramList, IMCallback<List<FriendGroup>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetFriendGroups(paramList, paramIMCallback);
  }
  
  public void getFriendList(IMCallback<List<FriendInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetFriendList(paramIMCallback);
  }
  
  public void getFriendsInfo(List<String> paramList, IMCallback<List<FriendInfoResult>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetFriendsInfo(paramList, paramIMCallback);
  }
  
  public void getUsersInfo(List<String> paramList, IMCallback<List<UserInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeGetUsersInfo(paramList, paramIMCallback);
  }
  
  public void init()
  {
    initFriendshipListener();
  }
  
  protected native void nativeAddFriend(FriendAddApplication paramFriendAddApplication, IMCallback paramIMCallback);
  
  protected native void nativeAddFriendsToFriendGroup(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeAddToBlackList(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeCheckFriend(List<String> paramList, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeCreateFromGroup(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteFriendApplication(int paramInt, String paramString, IMCallback paramIMCallback);
  
  protected native void nativeDeleteFriendGroup(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteFriendsFromFriendGroup(String paramString, List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteFromBlackList(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeDeleteFromFriendList(List<String> paramList, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeGetBlackList(IMCallback paramIMCallback);
  
  protected native void nativeGetC2CReceiveMessageOpt(List<String> paramList, IMCallback<List<ReceiveMessageOptInfo>> paramIMCallback);
  
  protected native void nativeGetFriendApplicationList(IMCallback paramIMCallback);
  
  protected native void nativeGetFriendGroups(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetFriendList(IMCallback paramIMCallback);
  
  protected native void nativeGetFriendsInfo(List<String> paramList, IMCallback paramIMCallback);
  
  protected native void nativeGetUsersInfo(List<String> paramList, IMCallback<List<UserInfo>> paramIMCallback);
  
  protected native void nativeRenameFriendGroup(String paramString1, String paramString2, IMCallback paramIMCallback);
  
  protected native void nativeResponseFriendApplication(FriendResponse paramFriendResponse, IMCallback paramIMCallback);
  
  protected native void nativeSearchFriends(FriendSearchParam paramFriendSearchParam, IMCallback paramIMCallback);
  
  protected native void nativeSetC2CReceiveMessageOpt(List<String> paramList, int paramInt, IMCallback paramIMCallback);
  
  protected native void nativeSetFriendApplicationRead(IMCallback paramIMCallback);
  
  protected native void nativeSetFriendInfo(String paramString, HashMap<String, Object> paramHashMap, IMCallback paramIMCallback);
  
  protected native void nativeSetFriendshipListener(FriendshipListener paramFriendshipListener);
  
  protected native void nativeSetSelfInfo(HashMap<String, Object> paramHashMap, IMCallback paramIMCallback);
  
  public void renameFriendGroup(String paramString1, String paramString2, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeRenameFriendGroup(paramString1, paramString2, paramIMCallback);
  }
  
  public void responseFriendApplication(FriendResponse paramFriendResponse, IMCallback<FriendOperationResult> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeResponseFriendApplication(paramFriendResponse, paramIMCallback);
  }
  
  public void searchFriends(FriendSearchParam paramFriendSearchParam, IMCallback<List<FriendInfo>> paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSearchFriends(paramFriendSearchParam, paramIMCallback);
  }
  
  public void setC2CReceiveMessageOpt(List<String> paramList, int paramInt, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetC2CReceiveMessageOpt(paramList, paramInt, paramIMCallback);
  }
  
  public void setFriendApplicationRead(IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetFriendApplicationRead(paramIMCallback);
  }
  
  public void setFriendInfo(String paramString, HashMap<String, Object> paramHashMap, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetFriendInfo(paramString, paramHashMap, paramIMCallback);
  }
  
  public void setFriendshipListener(FriendshipListener paramFriendshipListener)
  {
    this.mFriendshipListener = paramFriendshipListener;
  }
  
  public void setSelfInfo(HashMap<String, Object> paramHashMap, IMCallback paramIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramIMCallback != null) {
        paramIMCallback.fail(6013, "sdk not init");
      }
      return;
    }
    nativeSetSelfInfo(paramHashMap, paramIMCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.relationship.RelationshipManager
 * JD-Core Version:    0.7.0.1
 */