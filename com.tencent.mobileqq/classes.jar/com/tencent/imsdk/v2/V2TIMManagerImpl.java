package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.PrivatizationInfo;
import com.tencent.imsdk.manager.PrivatizationInfo.ServerAddress;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V2TIMManagerImpl
  extends V2TIMManager
{
  private static final String TAG = "V2TIMManagerImpl";
  private GroupListener mGroupInternalListener;
  private Object mLockObject = new Object();
  private MessageListener mMessageInternalListener;
  private List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();
  private V2TIMGroupListener v2TIMGroupListener;
  
  protected V2TIMManagerImpl()
  {
    initMessageListener();
    initGroupListener();
  }
  
  private void callbackOnError(V2TIMValueCallback<Object> paramV2TIMValueCallback, int paramInt, String paramString)
  {
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(paramInt, paramString);
    }
  }
  
  private void callbackOnSuccess(V2TIMValueCallback<Object> paramV2TIMValueCallback, Object paramObject)
  {
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onSuccess(paramObject);
    }
  }
  
  public static V2TIMManagerImpl getInstance()
  {
    return V2TIMManagerImpl.V2TIMManagerImplHolder.access$000();
  }
  
  private void initGroupListener()
  {
    this.mGroupInternalListener = new V2TIMManagerImpl.18(this);
    GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
  }
  
  private void initLocalStorage(Object paramObject, V2TIMValueCallback<Object> paramV2TIMValueCallback)
  {
    if (!(paramObject instanceof String))
    {
      callbackOnError(paramV2TIMValueCallback, 6017, "param is not string");
      return;
    }
    paramObject = (String)paramObject;
    if (TextUtils.isEmpty(paramObject))
    {
      callbackOnError(paramV2TIMValueCallback, 6017, "invalid userID");
      return;
    }
    BaseManager.getInstance().initLocalStorage(paramObject, new V2TIMManagerImpl.16(this, paramV2TIMValueCallback));
  }
  
  private void initMessageListener()
  {
    this.mMessageInternalListener = new V2TIMManagerImpl.17(this);
    MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
  }
  
  private void setLibraryPath(Object paramObject, V2TIMValueCallback<Object> paramV2TIMValueCallback)
  {
    if (!(paramObject instanceof String))
    {
      callbackOnError(paramV2TIMValueCallback, 6017, "param is not string");
      return;
    }
    paramObject = (String)paramObject;
    if (BaseManager.getInstance().setLibraryPath(paramObject))
    {
      callbackOnSuccess(paramV2TIMValueCallback, null);
      return;
    }
    callbackOnError(paramV2TIMValueCallback, 6017, "system load so library failed");
  }
  
  private void setPrivatizationInfo(Object paramObject, V2TIMValueCallback<Object> paramV2TIMValueCallback)
  {
    if ((paramObject != null) && ((paramObject instanceof String)))
    {
      Object localObject = (String)paramObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        callbackOnError(paramV2TIMValueCallback, 6017, "param is empty");
        return;
      }
      paramObject = new PrivatizationInfo();
      try
      {
        localObject = new JSONObject((String)localObject);
        JSONArray localJSONArray = ((JSONObject)localObject).optJSONArray("serverAddressList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            PrivatizationInfo.ServerAddress localServerAddress = new PrivatizationInfo.ServerAddress();
            localServerAddress.ip = localJSONObject.optString("ip");
            localServerAddress.port = localJSONObject.optInt("port");
            localArrayList.add(localServerAddress);
            i += 1;
          }
          paramObject.serverAddressList = localArrayList;
        }
        paramObject.serverPublicKey = ((JSONObject)localObject).optString("serverPublicKey");
        BaseManager.getInstance().setPrivatizationInfo(paramObject);
        callbackOnSuccess(paramV2TIMValueCallback, null);
        return;
      }
      catch (JSONException paramObject)
      {
        callbackOnError(paramV2TIMValueCallback, 6017, "convert param to json failed");
        paramObject.printStackTrace();
        return;
      }
    }
    callbackOnError(paramV2TIMValueCallback, 6017, "param is not string");
  }
  
  public void addSimpleMsgListener(V2TIMSimpleMsgListener paramV2TIMSimpleMsgListener)
  {
    if (paramV2TIMSimpleMsgListener == null) {
      return;
    }
    synchronized (this.mLockObject)
    {
      if (this.mV2TIMSimpleMsgListenerList.contains(paramV2TIMSimpleMsgListener)) {
        return;
      }
      this.mV2TIMSimpleMsgListenerList.add(paramV2TIMSimpleMsgListener);
      return;
    }
  }
  
  public void callExperimentalAPI(String paramString, Object paramObject, V2TIMValueCallback<Object> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      callbackOnError(paramV2TIMValueCallback, 6017, "invalid api");
      return;
    }
    if (paramString.equals("setPrivatizationInfo"))
    {
      setPrivatizationInfo(paramObject, paramV2TIMValueCallback);
      return;
    }
    if (paramString.equals("setLibraryPath"))
    {
      setLibraryPath(paramObject, paramV2TIMValueCallback);
      return;
    }
    if (paramString.equals("initLocalStorage"))
    {
      initLocalStorage(paramObject, paramV2TIMValueCallback);
      return;
    }
    callbackOnError(paramV2TIMValueCallback, 6017, "unsupported api");
  }
  
  public void createGroup(String paramString1, String paramString2, String paramString3, V2TIMValueCallback<String> paramV2TIMValueCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupType is empty");
      }
      return;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupName is empty");
      }
      return;
    }
    boolean bool = paramString1.equalsIgnoreCase("Work");
    String str = "ChatRoom";
    if (bool) {}
    do
    {
      paramString1 = "Private";
      break;
      if (paramString1.equalsIgnoreCase("Meeting"))
      {
        paramString1 = str;
        break;
      }
    } while (paramString1.equalsIgnoreCase("Private"));
    if (paramString1.equalsIgnoreCase("ChatRoom")) {
      paramString1 = str;
    } else if (paramString1.equalsIgnoreCase("Public")) {
      paramString1 = "Public";
    } else if (paramString1.equalsIgnoreCase("AVChatRoom")) {
      paramString1 = "AVChatRoom";
    }
    GroupManager.getInstance().createGroup(paramString1, paramString2, paramString3, new V2TIMManagerImpl.9(this, paramV2TIMValueCallback));
  }
  
  public void dismissGroup(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "invalid groupID");
      }
      return;
    }
    GroupManager.getInstance().dismissGroup(paramString, new V2TIMManagerImpl.12(this, paramV2TIMCallback));
  }
  
  public int getLoginStatus()
  {
    return BaseManager.getInstance().getLoginStatus();
  }
  
  public String getLoginUser()
  {
    return BaseManager.getInstance().getLoginUser();
  }
  
  public long getServerTime()
  {
    return BaseManager.getInstance().getServerTime();
  }
  
  public void getUsersInfo(List<String> paramList, V2TIMValueCallback<List<V2TIMUserFullInfo>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMManagerImpl.13(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().getUsersInfo(paramList, new V2TIMManagerImpl.14(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "invalid userIDList");
    }
  }
  
  public String getVersion()
  {
    return BaseManager.getInstance().getVersion();
  }
  
  public boolean initSDK(Context paramContext, int paramInt, V2TIMSDKConfig paramV2TIMSDKConfig, V2TIMSDKListener paramV2TIMSDKListener)
  {
    V2TIMSDKConfig localV2TIMSDKConfig = paramV2TIMSDKConfig;
    if (paramV2TIMSDKConfig == null) {
      localV2TIMSDKConfig = new V2TIMSDKConfig();
    }
    paramV2TIMSDKConfig = localV2TIMSDKConfig.getLogListener();
    SDKConfig localSDKConfig = new SDKConfig();
    localSDKConfig.sdkAppId = paramInt;
    localSDKConfig.logSetting.logLevel = localV2TIMSDKConfig.getLogLevel();
    return BaseManager.getInstance().initSDK(paramContext, localSDKConfig, new V2TIMManagerImpl.1(this, paramV2TIMSDKListener, paramV2TIMSDKConfig));
  }
  
  public void joinGroup(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "invalid groupID");
      }
      return;
    }
    GroupManager.getInstance().joinGroup(paramString1, paramString2, new V2TIMManagerImpl.10(this, paramV2TIMCallback));
  }
  
  public void login(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramV2TIMCallback = new V2TIMManagerImpl.2(this, paramV2TIMCallback);
      BaseManager.getInstance().login(paramString1, paramString2, new V2TIMManagerImpl.3(this, paramV2TIMCallback));
      return;
    }
    paramV2TIMCallback.onError(6017, "userID or userSig is empty");
  }
  
  public void logout(V2TIMCallback paramV2TIMCallback)
  {
    BaseManager.getInstance().logout(new V2TIMManagerImpl.4(this, paramV2TIMCallback));
  }
  
  public void quitGroup(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "invalid groupID");
      }
      return;
    }
    GroupManager.getInstance().quitGroup(paramString, new V2TIMManagerImpl.11(this, paramV2TIMCallback));
  }
  
  public void removeSimpleMsgListener(V2TIMSimpleMsgListener paramV2TIMSimpleMsgListener)
  {
    if (paramV2TIMSimpleMsgListener == null) {
      return;
    }
    synchronized (this.mLockObject)
    {
      this.mV2TIMSimpleMsgListenerList.remove(paramV2TIMSimpleMsgListener);
      return;
    }
  }
  
  public String sendC2CCustomMessage(byte[] paramArrayOfByte, String paramString, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramArrayOfByte == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "customData is null");
      }
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "userID is empty");
      }
      return null;
    }
    paramArrayOfByte = V2TIMMessageManagerImpl.getInstance().createCustomMessage(paramArrayOfByte);
    paramV2TIMValueCallback = new V2TIMManagerImpl.6(this, paramV2TIMValueCallback);
    V2TIMMessageManager.getInstance().sendMessage(paramArrayOfByte, paramString, null, 2, false, new V2TIMOfflinePushInfo(), paramV2TIMValueCallback);
    return paramArrayOfByte.getMsgID();
  }
  
  public String sendC2CTextMessage(String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramString1 == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "text is null");
      }
      return null;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "userID is empty");
      }
      return null;
    }
    paramString1 = V2TIMMessageManagerImpl.getInstance().createTextMessage(paramString1);
    paramV2TIMValueCallback = new V2TIMManagerImpl.5(this, paramV2TIMValueCallback);
    V2TIMMessageManager.getInstance().sendMessage(paramString1, paramString2, null, 2, false, new V2TIMOfflinePushInfo(), paramV2TIMValueCallback);
    return paramString1.getMsgID();
  }
  
  public String sendGroupCustomMessage(byte[] paramArrayOfByte, String paramString, int paramInt, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramArrayOfByte == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "customData is null");
      }
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return "";
    }
    paramArrayOfByte = V2TIMMessageManagerImpl.getInstance().createCustomMessage(paramArrayOfByte);
    if (paramInt == 0) {}
    while ((paramInt != 1) && (paramInt != 3))
    {
      paramInt = 2;
      break;
    }
    paramV2TIMValueCallback = new V2TIMManagerImpl.8(this, paramV2TIMValueCallback);
    V2TIMMessageManager.getInstance().sendMessage(paramArrayOfByte, null, paramString, paramInt, false, new V2TIMOfflinePushInfo(), paramV2TIMValueCallback);
    return paramArrayOfByte.getMsgID();
  }
  
  public String sendGroupTextMessage(String paramString1, String paramString2, int paramInt, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramString1 == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "text is null");
      }
      return null;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return "";
    }
    paramString1 = V2TIMMessageManagerImpl.getInstance().createTextMessage(paramString1);
    if (paramInt == 0) {}
    while ((paramInt != 1) && (paramInt != 3))
    {
      paramInt = 2;
      break;
    }
    paramV2TIMValueCallback = new V2TIMManagerImpl.7(this, paramV2TIMValueCallback);
    V2TIMMessageManager.getInstance().sendMessage(paramString1, null, paramString2, paramInt, false, new V2TIMOfflinePushInfo(), paramV2TIMValueCallback);
    return paramString1.getMsgID();
  }
  
  public void setGroupListener(V2TIMGroupListener paramV2TIMGroupListener)
  {
    this.v2TIMGroupListener = paramV2TIMGroupListener;
  }
  
  public void setSelfInfo(V2TIMUserFullInfo paramV2TIMUserFullInfo, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMUserFullInfo == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "invalid params");
      }
      return;
    }
    HashMap localHashMap = paramV2TIMUserFullInfo.getModifyParams();
    if ((localHashMap != null) && (!localHashMap.isEmpty()))
    {
      RelationshipManager.getInstance().setSelfInfo(paramV2TIMUserFullInfo.getModifyParams(), new V2TIMManagerImpl.15(this, paramV2TIMCallback));
      return;
    }
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "no changed info");
    }
  }
  
  public void unInitSDK()
  {
    BaseManager.getInstance().unInitSDK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl
 * JD-Core Version:    0.7.0.1
 */