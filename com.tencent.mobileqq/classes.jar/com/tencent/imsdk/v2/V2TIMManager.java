package com.tencent.imsdk.v2;

import android.content.Context;
import java.util.List;

public abstract class V2TIMManager
{
  public static final String GROUP_TYPE_AVCHATROOM = "AVChatRoom";
  public static final String GROUP_TYPE_MEETING = "Meeting";
  public static final String GROUP_TYPE_PUBLIC = "Public";
  public static final String GROUP_TYPE_WORK = "Work";
  public static final int V2TIM_STATUS_LOGINED = 1;
  public static final int V2TIM_STATUS_LOGINING = 2;
  public static final int V2TIM_STATUS_LOGOUT = 3;
  
  public static V2TIMConversationManager getConversationManager()
  {
    return V2TIMConversationManagerImpl.getInstance();
  }
  
  public static V2TIMFriendshipManager getFriendshipManager()
  {
    return V2TIMFriendshipManagerImpl.getInstance();
  }
  
  public static V2TIMGroupManager getGroupManager()
  {
    return V2TIMGroupManager.getInstance();
  }
  
  public static V2TIMManager getInstance()
  {
    return V2TIMManagerImpl.getInstance();
  }
  
  public static V2TIMMessageManager getMessageManager()
  {
    return V2TIMMessageManagerImpl.getInstance();
  }
  
  public static V2TIMOfflinePushManager getOfflinePushManager()
  {
    return V2TIMOfflinePushManager.getInstance();
  }
  
  public static V2TIMSignalingManager getSignalingManager()
  {
    return V2TIMSignalingManager.getInstance();
  }
  
  public abstract void addSimpleMsgListener(V2TIMSimpleMsgListener paramV2TIMSimpleMsgListener);
  
  public abstract void callExperimentalAPI(String paramString, Object paramObject, V2TIMValueCallback<Object> paramV2TIMValueCallback);
  
  public abstract void createGroup(String paramString1, String paramString2, String paramString3, V2TIMValueCallback<String> paramV2TIMValueCallback);
  
  public abstract void dismissGroup(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract int getLoginStatus();
  
  public abstract String getLoginUser();
  
  public abstract long getServerTime();
  
  public abstract void getUsersInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMUserFullInfo>> paramV2TIMValueCallback);
  
  public abstract String getVersion();
  
  public abstract boolean initSDK(Context paramContext, int paramInt, V2TIMSDKConfig paramV2TIMSDKConfig, V2TIMSDKListener paramV2TIMSDKListener);
  
  public abstract void joinGroup(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void login(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback);
  
  public abstract void logout(V2TIMCallback paramV2TIMCallback);
  
  public abstract void quitGroup(String paramString, V2TIMCallback paramV2TIMCallback);
  
  public abstract void removeSimpleMsgListener(V2TIMSimpleMsgListener paramV2TIMSimpleMsgListener);
  
  public abstract String sendC2CCustomMessage(byte[] paramArrayOfByte, String paramString, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract String sendC2CTextMessage(String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract String sendGroupCustomMessage(byte[] paramArrayOfByte, String paramString, int paramInt, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract String sendGroupTextMessage(String paramString1, String paramString2, int paramInt, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback);
  
  public abstract void setGroupListener(V2TIMGroupListener paramV2TIMGroupListener);
  
  public abstract void setSelfInfo(V2TIMUserFullInfo paramV2TIMUserFullInfo, V2TIMCallback paramV2TIMCallback);
  
  public abstract void unInitSDK();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManager
 * JD-Core Version:    0.7.0.1
 */