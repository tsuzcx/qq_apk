package com.tencent.imsdk.v2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.relationship.FriendResponse;
import com.tencent.imsdk.relationship.FriendshipListener;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.util.List;

public class V2TIMFriendshipManagerImpl
  extends V2TIMFriendshipManager
{
  private final String TAG = "V2TIMFriendshipManagerImpl";
  private FriendshipListener mFriendshipInternalListener;
  private V2TIMFriendshipListener mV2TIMFriendshipListener;
  
  private V2TIMFriendshipManagerImpl()
  {
    initFriendshipListener();
  }
  
  static V2TIMFriendshipManagerImpl getInstance()
  {
    return V2TIMFriendshipManagerImpl.V2TIMFriendshipManagerImplHolder.access$100();
  }
  
  private void initFriendshipListener()
  {
    this.mFriendshipInternalListener = new V2TIMFriendshipManagerImpl.36(this);
    RelationshipManager.getInstance().setFriendshipListener(this.mFriendshipInternalListener);
  }
  
  public void acceptFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, int paramInt, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback)
  {
    int i = 1;
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramV2TIMValueCallback != null)
      {
        paramV2TIMFriendApplication = new StringBuilder();
        paramV2TIMFriendApplication.append("responseType is invalid : ");
        paramV2TIMFriendApplication.append(paramInt);
        paramV2TIMValueCallback.onError(6017, paramV2TIMFriendApplication.toString());
      }
      return;
    }
    if (paramV2TIMFriendApplication == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "v2TIMFriendApplication is null");
      }
      return;
    }
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.14(this, paramV2TIMValueCallback);
    FriendResponse localFriendResponse = new FriendResponse();
    localFriendResponse.setUserID(paramV2TIMFriendApplication.getUserID());
    if (paramInt == 0) {
      paramInt = i;
    } else {
      paramInt = 2;
    }
    localFriendResponse.setResponseType(paramInt);
    RelationshipManager.getInstance().responseFriendApplication(localFriendResponse, new V2TIMFriendshipManagerImpl.15(this, paramV2TIMValueCallback));
  }
  
  public void addFriend(V2TIMFriendAddApplication paramV2TIMFriendAddApplication, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback)
  {
    if (paramV2TIMFriendAddApplication == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "v2TIMFriendApplication is null");
      }
      return;
    }
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.6(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().addFriend(paramV2TIMFriendAddApplication.getFriendAddApplication(), new V2TIMFriendshipManagerImpl.7(this, paramV2TIMValueCallback));
  }
  
  public void addFriendsToFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupName is empty");
      }
      return;
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.32(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().addFriendsToFriendGroup(paramString, paramList, new V2TIMFriendshipManagerImpl.33(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList is empty");
    }
  }
  
  public void addToBlackList(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.20(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().addToBlackList(paramList, new V2TIMFriendshipManagerImpl.21(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList is empty");
    }
  }
  
  public void checkFriend(List<String> paramList, int paramInt, V2TIMValueCallback<List<V2TIMFriendCheckResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramV2TIMValueCallback != null)
        {
          paramList = new StringBuilder();
          paramList.append("checkType is invalid : ");
          paramList.append(paramInt);
          paramV2TIMValueCallback.onError(6017, paramList.toString());
        }
        return;
      }
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.10(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().checkFriend(paramList, paramInt, new V2TIMFriendshipManagerImpl.11(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList maybe empty");
    }
  }
  
  public void createFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if (paramString == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupNames is empty");
      }
      return;
    }
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.26(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().createFriendGroup(paramString, paramList, new V2TIMFriendshipManagerImpl.27(this, paramV2TIMValueCallback));
  }
  
  public void deleteFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMFriendApplication == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "application is null");
      }
      return;
    }
    if (TextUtils.isEmpty(paramV2TIMFriendApplication.getUserID()))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "application userID is empty");
      }
      return;
    }
    RelationshipManager.getInstance().deleteFriendApplication(paramV2TIMFriendApplication.getType(), paramV2TIMFriendApplication.getUserID(), new V2TIMFriendshipManagerImpl.18(this, paramV2TIMCallback));
  }
  
  public void deleteFriendGroup(List<String> paramList, V2TIMCallback paramV2TIMCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      RelationshipManager.getInstance().deleteFriendGroup(paramList, new V2TIMFriendshipManagerImpl.30(this, paramV2TIMCallback));
      return;
    }
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "groupNames is empty");
    }
  }
  
  public void deleteFriendsFromFriendGroup(String paramString, List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupName is empty");
      }
      return;
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.34(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().deleteFrendsFromFriendGroup(paramString, paramList, new V2TIMFriendshipManagerImpl.35(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList is empty");
    }
  }
  
  public void deleteFromBlackList(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.22(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().deleteFromBlackList(paramList, new V2TIMFriendshipManagerImpl.23(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList is empty");
    }
  }
  
  public void deleteFromFriendList(List<String> paramList, int paramInt, V2TIMValueCallback<List<V2TIMFriendOperationResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramV2TIMValueCallback != null)
        {
          paramList = new StringBuilder();
          paramList.append("deleteType is invalid : ");
          paramList.append(paramInt);
          paramV2TIMValueCallback.onError(6017, paramList.toString());
        }
        return;
      }
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.8(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().deleteFromFriendList(paramList, paramInt, new V2TIMFriendshipManagerImpl.9(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList maybe empty");
    }
  }
  
  public void getBlackList(V2TIMValueCallback<List<V2TIMFriendInfo>> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.24(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().getBlackList(new V2TIMFriendshipManagerImpl.25(this, paramV2TIMValueCallback));
  }
  
  public void getFriendApplicationList(V2TIMValueCallback<V2TIMFriendApplicationResult> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.12(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().getFriendApplicationList(new V2TIMFriendshipManagerImpl.13(this, paramV2TIMValueCallback));
  }
  
  public void getFriendGroups(List<String> paramList, @NonNull V2TIMValueCallback<List<V2TIMFriendGroup>> paramV2TIMValueCallback)
  {
    List<String> localList = paramList;
    if (paramList != null)
    {
      localList = paramList;
      if (paramList.size() == 0) {
        localList = null;
      }
    }
    paramList = new V2TIMFriendshipManagerImpl.28(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().getFriendGroups(localList, new V2TIMFriendshipManagerImpl.29(this, paramList));
  }
  
  public void getFriendList(V2TIMValueCallback<List<V2TIMFriendInfo>> paramV2TIMValueCallback)
  {
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.1(this, paramV2TIMValueCallback);
    RelationshipManager.getInstance().getFriendList(new V2TIMFriendshipManagerImpl.2(this, paramV2TIMValueCallback));
  }
  
  public void getFriendsInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMFriendInfoResult>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.3(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().getFriendsInfo(paramList, new V2TIMFriendshipManagerImpl.4(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userIDList is empty");
    }
  }
  
  public void refuseFriendApplication(V2TIMFriendApplication paramV2TIMFriendApplication, V2TIMValueCallback<V2TIMFriendOperationResult> paramV2TIMValueCallback)
  {
    if (paramV2TIMFriendApplication == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "application is null");
      }
      return;
    }
    paramV2TIMValueCallback = new V2TIMFriendshipManagerImpl.16(this, paramV2TIMValueCallback);
    FriendResponse localFriendResponse = new FriendResponse();
    localFriendResponse.setUserID(paramV2TIMFriendApplication.getUserID());
    localFriendResponse.setResponseType(3);
    RelationshipManager.getInstance().responseFriendApplication(localFriendResponse, new V2TIMFriendshipManagerImpl.17(this, paramV2TIMValueCallback));
  }
  
  public void renameFriendGroup(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    if (!BaseManager.getInstance().isInited())
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6013, "sdk not init");
      }
      return;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "newName is empty");
      }
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "oldName is empty");
      }
      return;
    }
    RelationshipManager.getInstance().renameFriendGroup(paramString1, paramString2, new V2TIMFriendshipManagerImpl.31(this, paramV2TIMCallback));
  }
  
  public void setFriendApplicationRead(V2TIMCallback paramV2TIMCallback)
  {
    RelationshipManager.getInstance().setFriendApplicationRead(new V2TIMFriendshipManagerImpl.19(this, paramV2TIMCallback));
  }
  
  public void setFriendInfo(V2TIMFriendInfo paramV2TIMFriendInfo, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMFriendInfo == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "info is null");
      }
      return;
    }
    RelationshipManager.getInstance().setFriendInfo(paramV2TIMFriendInfo.getUserID(), paramV2TIMFriendInfo.getModifyFriendInfo(), new V2TIMFriendshipManagerImpl.5(this, paramV2TIMCallback));
  }
  
  public void setFriendListener(V2TIMFriendshipListener paramV2TIMFriendshipListener)
  {
    this.mV2TIMFriendshipListener = paramV2TIMFriendshipListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMFriendshipManagerImpl
 * JD-Core Version:    0.7.0.1
 */