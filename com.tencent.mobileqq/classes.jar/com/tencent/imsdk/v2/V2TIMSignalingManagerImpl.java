package com.tencent.imsdk.v2;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class V2TIMSignalingManagerImpl
  extends V2TIMSignalingManager
{
  private final String TAG = "V2TIMSigMgrImpl";
  private final int TIMEOUT_DELAY = 5;
  private List<V2TIMSignalingInfo> invitationList = new ArrayList();
  private CopyOnWriteArrayList<V2TIMSignalingListener> mSignalingListenerList = new CopyOnWriteArrayList();
  private Handler mTimeoutHandler = new Handler(Looper.getMainLooper());
  
  private void checkInviteTimeout(V2TIMSignalingInfo paramV2TIMSignalingInfo)
  {
    if (paramV2TIMSignalingInfo.getTimeout() <= 0)
    {
      IMLog.i("V2TIMSigMgrImpl", "signaling checkInviteTimeout timeout is <= 0, ignore to post delay task");
      return;
    }
    this.mTimeoutHandler.postDelayed(new V2TIMSignalingManagerImpl.5(this, paramV2TIMSignalingInfo), (paramV2TIMSignalingInfo.getTimeout() + 5) * 1000);
  }
  
  private void doResponse(String paramString1, String paramString2, boolean paramBoolean, V2TIMCallback paramV2TIMCallback)
  {
    String str = V2TIMManager.getInstance().getLoginUser();
    if (TextUtils.isEmpty(str))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6014, "not login");
      }
      IMLog.e("V2TIMSigMgrImpl", "not login");
      return;
    }
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.invitationList.size()) {
        break;
      }
      V2TIMSignalingInfo localV2TIMSignalingInfo1 = (V2TIMSignalingInfo)this.invitationList.get(i);
      if ((localV2TIMSignalingInfo1.getInviteID().equals(paramString1)) && (localV2TIMSignalingInfo1.getInviteeList().contains(str)))
      {
        V2TIMSignalingInfo localV2TIMSignalingInfo2 = new V2TIMSignalingInfo();
        localV2TIMSignalingInfo2.setBusinessID(1);
        localV2TIMSignalingInfo2.setInviteID(localV2TIMSignalingInfo1.getInviteID());
        localV2TIMSignalingInfo2.setGroupID(localV2TIMSignalingInfo1.getGroupID());
        localV2TIMSignalingInfo2.setInviter(localV2TIMSignalingInfo1.getInviter());
        localV2TIMSignalingInfo2.addInvitee(str);
        localV2TIMSignalingInfo2.setData(paramString2);
        localV2TIMSignalingInfo2.setOnlineUserOnly(localV2TIMSignalingInfo1.isOnlineUserOnly());
        if (paramBoolean) {
          localV2TIMSignalingInfo2.setActionType(3);
        } else {
          localV2TIMSignalingInfo2.setActionType(4);
        }
        sendSignalMessage(localV2TIMSignalingInfo2, new V2TIMSignalingManagerImpl.9(this, paramBoolean, localV2TIMSignalingInfo2, localV2TIMSignalingInfo1, str, paramV2TIMCallback), false);
        j = 1;
        break;
      }
      i += 1;
    }
    if (j == 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append("signaling doResponse failed, inviteID is invalid or invitation has been processed inviteID:");
      paramString2.append(paramString1);
      IMLog.e("V2TIMSigMgrImpl", paramString2.toString());
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(8010, "inviteID is invalid or invitation has been processed");
      }
    }
  }
  
  static V2TIMSignalingManagerImpl getInstance()
  {
    return V2TIMSignalingManagerImpl.V2TIMSignalingManagerImplHolder.access$100();
  }
  
  private V2TIMSignalingInfo jsonStringToSignallingInfo(String paramString)
  {
    V2TIMSignalingInfo localV2TIMSignalingInfo = new V2TIMSignalingInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localV2TIMSignalingInfo.setBusinessID(paramString.optInt("businessID"));
      localV2TIMSignalingInfo.setInviteID(paramString.optString("inviteID"));
      localV2TIMSignalingInfo.setGroupID(paramString.optString("groupID"));
      localV2TIMSignalingInfo.setInviter(paramString.optString("inviter"));
      JSONArray localJSONArray = paramString.optJSONArray("inviteeList");
      if ((localJSONArray != null) && (localJSONArray.length() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(localJSONArray.optString(i));
          i += 1;
        }
        localV2TIMSignalingInfo.setInviteeList(localArrayList);
      }
      localV2TIMSignalingInfo.setData(paramString.optString("data"));
      localV2TIMSignalingInfo.setTimeout(paramString.optInt("timeout"));
      localV2TIMSignalingInfo.setActionType(paramString.optInt("actionType"));
      localV2TIMSignalingInfo.setOnlineUserOnly(paramString.optBoolean("onlineUserOnly"));
      return localV2TIMSignalingInfo;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localV2TIMSignalingInfo;
  }
  
  private void notifyOnRecvMessage(Message paramMessage)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    localV2TIMMessage.setMessage(paramMessage);
    V2TIMMessageManagerImpl.getInstance().onRecvNewMessage(localV2TIMMessage);
  }
  
  private void sendSignalMessage(V2TIMSignalingInfo paramV2TIMSignalingInfo, V2TIMValueCallback<Message> paramV2TIMValueCallback, boolean paramBoolean)
  {
    Object localObject = signallingInfoToJsonString(paramV2TIMSignalingInfo).getBytes();
    CustomElement localCustomElement = new CustomElement();
    localCustomElement.setData((byte[])localObject);
    localObject = new Message();
    if (paramV2TIMSignalingInfo.isOnlineUserOnly()) {
      ((Message)localObject).setLifeTime(0);
    }
    if (paramV2TIMSignalingInfo.getOfflinePushInfo() != null) {
      ((Message)localObject).setOfflinePushInfo(paramV2TIMSignalingInfo.getOfflinePushInfo().getMessageOfflinePushInfo());
    }
    if (TextUtils.isEmpty(paramV2TIMSignalingInfo.getGroupID()))
    {
      ((Message)localObject).setMessageType(Message.MESSAGE_TYPE_C2C);
      if (paramBoolean) {
        ((Message)localObject).setReceiverUserID((String)paramV2TIMSignalingInfo.getInviteeList().get(0));
      } else {
        ((Message)localObject).setReceiverUserID(paramV2TIMSignalingInfo.getInviter());
      }
    }
    else
    {
      ((Message)localObject).setMessageType(Message.MESSAGE_TYPE_GROUP);
      ((Message)localObject).setGroupID(paramV2TIMSignalingInfo.getGroupID());
    }
    ((Message)localObject).addElement(localCustomElement);
    MessageCenter.getInstance().sendMessage((Message)localObject, new V2TIMSignalingManagerImpl.3(this), new V2TIMSignalingManagerImpl.4(this, paramV2TIMValueCallback));
  }
  
  private String signallingInfoToJsonString(V2TIMSignalingInfo paramV2TIMSignalingInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("businessID", paramV2TIMSignalingInfo.getBusinessID());
      localJSONObject.put("inviteID", paramV2TIMSignalingInfo.getInviteID());
      localJSONObject.put("groupID", paramV2TIMSignalingInfo.getGroupID());
      localJSONObject.put("inviter", paramV2TIMSignalingInfo.getInviter());
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramV2TIMSignalingInfo.getInviteeList().iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put((String)localIterator.next());
      }
      localJSONObject.put("inviteeList", localJSONArray);
      localJSONObject.put("data", paramV2TIMSignalingInfo.getData());
      localJSONObject.put("timeout", paramV2TIMSignalingInfo.getTimeout());
      localJSONObject.put("actionType", paramV2TIMSignalingInfo.getActionType());
      localJSONObject.put("onlineUserOnly", paramV2TIMSignalingInfo.isOnlineUserOnly());
    }
    catch (JSONException paramV2TIMSignalingInfo)
    {
      paramV2TIMSignalingInfo.printStackTrace();
    }
    return localJSONObject.toString();
  }
  
  public void accept(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signaling accept invite, inviteID:");
    localStringBuilder.append(paramString1);
    IMLog.i("V2TIMSigMgrImpl", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      IMLog.e("V2TIMSigMgrImpl", "signaling accept failed, inviteID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "inviteID is null");
      }
      return;
    }
    IMContext.getInstance().runOnMainThread(new V2TIMSignalingManagerImpl.7(this, paramString1, paramString2, paramV2TIMCallback));
  }
  
  public void addInvitedSignaling(V2TIMSignalingInfo paramV2TIMSignalingInfo, V2TIMCallback paramV2TIMCallback)
  {
    if ((paramV2TIMSignalingInfo != null) && (!TextUtils.isEmpty(paramV2TIMSignalingInfo.getInviteID())) && (!TextUtils.isEmpty(paramV2TIMSignalingInfo.getInviter())) && (paramV2TIMSignalingInfo.getInviteeList() != null) && (!paramV2TIMSignalingInfo.getInviteeList().isEmpty()))
    {
      if (this.invitationList.contains(paramV2TIMSignalingInfo))
      {
        if (paramV2TIMCallback != null) {
          paramV2TIMCallback.onError(8012, "V2TIMSignalingInfo is exist");
        }
        return;
      }
      Object localObject = this.invitationList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (TextUtils.equals(((V2TIMSignalingInfo)((Iterator)localObject).next()).getInviteID(), paramV2TIMSignalingInfo.getInviteID()))
        {
          if (paramV2TIMCallback != null)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("inviteID ");
            ((StringBuilder)localObject).append(paramV2TIMSignalingInfo.getInviteID());
            ((StringBuilder)localObject).append(" is exist");
            paramV2TIMCallback.onError(8012, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      IMContext.getInstance().runOnMainThread(new V2TIMSignalingManagerImpl.11(this, paramV2TIMSignalingInfo, paramV2TIMCallback));
      return;
    }
    IMLog.e("V2TIMSigMgrImpl", "addInvitedSignaling, info is invalid");
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "V2TIMSignalingInfo is invalid");
    }
  }
  
  public void addSignalingListener(V2TIMSignalingListener paramV2TIMSignalingListener)
  {
    try
    {
      if (this.mSignalingListenerList.contains(paramV2TIMSignalingListener)) {
        return;
      }
      this.mSignalingListenerList.add(paramV2TIMSignalingListener);
      return;
    }
    finally {}
  }
  
  public void cancel(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signaling cancel, inviteID:");
    localStringBuilder.append(paramString1);
    IMLog.i("V2TIMSigMgrImpl", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null)
      {
        IMLog.e("V2TIMSigMgrImpl", "signaling cancel error, inviteID is empty");
        paramV2TIMCallback.onError(6017, "inviteID is empty");
      }
      return;
    }
    IMContext.getInstance().runOnMainThread(new V2TIMSignalingManagerImpl.6(this, paramV2TIMCallback, paramString1, paramString2));
  }
  
  public V2TIMSignalingInfo getSignalingInfo(V2TIMMessage paramV2TIMMessage)
  {
    if (paramV2TIMMessage != null)
    {
      if (paramV2TIMMessage.getElemType() != 2) {
        return null;
      }
      paramV2TIMMessage = paramV2TIMMessage.getMessage();
      int i = 0;
      while (i < paramV2TIMMessage.getMessageBaseElements().size())
      {
        Object localObject = (MessageBaseElement)paramV2TIMMessage.getMessageBaseElements().get(i);
        if ((localObject instanceof CustomElement))
        {
          localObject = ((CustomElement)localObject).getData();
          if (localObject != null)
          {
            try
            {
              paramV2TIMMessage = jsonStringToSignallingInfo(new String((byte[])localObject));
            }
            catch (Exception paramV2TIMMessage)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getSignalingInfo exception:");
              ((StringBuilder)localObject).append(paramV2TIMMessage);
              IMLog.i("V2TIMSigMgrImpl", ((StringBuilder)localObject).toString());
              paramV2TIMMessage = null;
            }
            if ((paramV2TIMMessage != null) && (paramV2TIMMessage.getBusinessID() == 1)) {
              return paramV2TIMMessage;
            }
            return null;
          }
        }
        i += 1;
      }
      return null;
    }
    return null;
  }
  
  public String invite(String paramString1, String paramString2, boolean paramBoolean, V2TIMOfflinePushInfo paramV2TIMOfflinePushInfo, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "invitee is empty");
      }
      IMLog.e("V2TIMSigMgrImpl", "signaling invite error, invitee is empty");
      return null;
    }
    String str = V2TIMManager.getInstance().getLoginUser();
    if (TextUtils.isEmpty(str))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6014, "not login");
      }
      IMLog.e("V2TIMSigMgrImpl", "not login");
      return null;
    }
    V2TIMSignalingInfo localV2TIMSignalingInfo = new V2TIMSignalingInfo();
    localV2TIMSignalingInfo.setBusinessID(1);
    localV2TIMSignalingInfo.setInviter(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString1);
    localV2TIMSignalingInfo.setInviteeList(localArrayList);
    localV2TIMSignalingInfo.setData(paramString2);
    localV2TIMSignalingInfo.setOnlineUserOnly(paramBoolean);
    localV2TIMSignalingInfo.setTimeout(paramInt);
    localV2TIMSignalingInfo.setActionType(1);
    localV2TIMSignalingInfo.setOfflinePushInfo(paramV2TIMOfflinePushInfo);
    paramString2 = new StringBuilder();
    paramString2.append(str);
    paramString2.append(System.currentTimeMillis());
    paramString2.append(new Random().nextInt(2147483647));
    localV2TIMSignalingInfo.setInviteID(SystemUtil.md5(paramString2.toString()));
    sendSignalMessage(localV2TIMSignalingInfo, new V2TIMSignalingManagerImpl.1(this, localV2TIMSignalingInfo, paramV2TIMCallback), true);
    paramString2 = new StringBuilder();
    paramString2.append("signaling invite, inviteID:");
    paramString2.append(localV2TIMSignalingInfo.getInviteID());
    paramString2.append(", invitee:");
    paramString2.append(paramString1);
    paramString2.append(", timeout:");
    paramString2.append(paramInt);
    IMLog.i("V2TIMSigMgrImpl", paramString2.toString());
    return localV2TIMSignalingInfo.getInviteID();
  }
  
  public String inviteInGroup(String paramString1, List<String> paramList, String paramString2, boolean paramBoolean, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      IMLog.e("V2TIMSigMgrImpl", "signaling invite error, groupID is empty");
      return null;
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      String str = V2TIMManager.getInstance().getLoginUser();
      if (TextUtils.isEmpty(str))
      {
        if (paramV2TIMCallback != null) {
          paramV2TIMCallback.onError(6014, "not login");
        }
        IMLog.e("V2TIMSigMgrImpl", "not login");
        return null;
      }
      V2TIMSignalingInfo localV2TIMSignalingInfo = new V2TIMSignalingInfo();
      localV2TIMSignalingInfo.setBusinessID(1);
      localV2TIMSignalingInfo.setInviter(str);
      localV2TIMSignalingInfo.setGroupID(paramString1);
      localV2TIMSignalingInfo.setInviteeList(paramList);
      localV2TIMSignalingInfo.setData(paramString2);
      localV2TIMSignalingInfo.setOnlineUserOnly(paramBoolean);
      localV2TIMSignalingInfo.setTimeout(paramInt);
      localV2TIMSignalingInfo.setActionType(1);
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(System.currentTimeMillis());
      paramString2.append(new Random().nextInt(2147483647));
      localV2TIMSignalingInfo.setInviteID(SystemUtil.md5(paramString2.toString()));
      sendSignalMessage(localV2TIMSignalingInfo, new V2TIMSignalingManagerImpl.2(this, localV2TIMSignalingInfo, paramV2TIMCallback), true);
      paramString2 = new StringBuilder();
      paramString2.append("signaling inviteInGroup, inviteID:");
      paramString2.append(localV2TIMSignalingInfo.getInviteID());
      paramString2.append(", groupID:");
      paramString2.append(paramString1);
      paramString2.append(", inviteeList:");
      paramString2.append(paramList);
      paramString2.append(", timeout:");
      paramString2.append(paramInt);
      IMLog.i("V2TIMSigMgrImpl", paramString2.toString());
      return localV2TIMSignalingInfo.getInviteID();
    }
    if (paramV2TIMCallback != null)
    {
      IMLog.e("V2TIMSigMgrImpl", "signaling invite error, inviteeList is empty");
      paramV2TIMCallback.onError(6017, "inviteeList is empty");
    }
    return null;
  }
  
  protected V2TIMSignalingInfo processSignalingMessage(V2TIMMessage paramV2TIMMessage)
  {
    V2TIMSignalingInfo localV2TIMSignalingInfo = getSignalingInfo(paramV2TIMMessage);
    if (localV2TIMSignalingInfo == null) {
      return null;
    }
    int i = localV2TIMSignalingInfo.getActionType();
    Object localObject1;
    Object localObject2;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              paramV2TIMMessage = new StringBuilder();
              paramV2TIMMessage.append("signaling unknown action type:");
              paramV2TIMMessage.append(localV2TIMSignalingInfo.getActionType());
              IMLog.e("V2TIMSigMgrImpl", paramV2TIMMessage.toString());
              return localV2TIMSignalingInfo;
            }
            paramV2TIMMessage = localV2TIMSignalingInfo.getInviteeList();
            if (paramV2TIMMessage.size() == 0)
            {
              IMLog.e("V2TIMSigMgrImpl", "signaling receive timeout but timeouters is empty");
              return localV2TIMSignalingInfo;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("signaling receive timeout, inviteID:");
            ((StringBuilder)localObject1).append(localV2TIMSignalingInfo.getInviteID());
            ((StringBuilder)localObject1).append(", timeouters:");
            ((StringBuilder)localObject1).append(paramV2TIMMessage);
            IMLog.i("V2TIMSigMgrImpl", ((StringBuilder)localObject1).toString());
            localObject1 = this.invitationList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (V2TIMSignalingInfo)((Iterator)localObject1).next();
              if (((V2TIMSignalingInfo)localObject2).getInviteID().equals(localV2TIMSignalingInfo.getInviteID()))
              {
                ((V2TIMSignalingInfo)localObject2).getInviteeList().removeAll(paramV2TIMMessage);
                if (((V2TIMSignalingInfo)localObject2).getInviteeList().size() == 0) {
                  this.invitationList.remove(localObject2);
                }
              }
            }
            try
            {
              localObject1 = this.mSignalingListenerList.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (V2TIMSignalingListener)((Iterator)localObject1).next();
                if (localObject2 != null) {
                  ((V2TIMSignalingListener)localObject2).onInvitationTimeout(localV2TIMSignalingInfo.getInviteID(), paramV2TIMMessage);
                }
              }
              return localV2TIMSignalingInfo;
            }
            finally {}
          }
          if (localV2TIMSignalingInfo.getInviteeList().size() == 0)
          {
            IMLog.e("V2TIMSigMgrImpl", "signaling receive reject but rejecter is empty");
            return localV2TIMSignalingInfo;
          }
          paramV2TIMMessage = (String)localV2TIMSignalingInfo.getInviteeList().get(0);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("signaling receive reject, inviteID:");
          ((StringBuilder)localObject1).append(localV2TIMSignalingInfo.getInviteID());
          ((StringBuilder)localObject1).append(", rejecter:");
          ((StringBuilder)localObject1).append(paramV2TIMMessage);
          IMLog.i("V2TIMSigMgrImpl", ((StringBuilder)localObject1).toString());
          localObject1 = this.invitationList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (V2TIMSignalingInfo)((Iterator)localObject1).next();
            if (((V2TIMSignalingInfo)localObject2).getInviteID().equals(localV2TIMSignalingInfo.getInviteID()))
            {
              ((V2TIMSignalingInfo)localObject2).getInviteeList().remove(paramV2TIMMessage);
              if (((V2TIMSignalingInfo)localObject2).getInviteeList().size() == 0) {
                this.invitationList.remove(localObject2);
              }
            }
          }
          try
          {
            localObject1 = this.mSignalingListenerList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (V2TIMSignalingListener)((Iterator)localObject1).next();
              if (localObject2 != null) {
                ((V2TIMSignalingListener)localObject2).onInviteeRejected(localV2TIMSignalingInfo.getInviteID(), paramV2TIMMessage, localV2TIMSignalingInfo.getData());
              }
            }
            return localV2TIMSignalingInfo;
          }
          finally {}
        }
        if (localV2TIMSignalingInfo.getInviteeList().size() == 0)
        {
          IMLog.e("V2TIMSigMgrImpl", "signaling receive accept but accepter is empty");
          return localV2TIMSignalingInfo;
        }
        paramV2TIMMessage = (String)localV2TIMSignalingInfo.getInviteeList().get(0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("signaling receive accept, inviteID:");
        ((StringBuilder)localObject1).append(localV2TIMSignalingInfo.getInviteID());
        ((StringBuilder)localObject1).append(", accepter:");
        ((StringBuilder)localObject1).append(paramV2TIMMessage);
        IMLog.i("V2TIMSigMgrImpl", ((StringBuilder)localObject1).toString());
        localObject1 = this.invitationList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (V2TIMSignalingInfo)((Iterator)localObject1).next();
          if (((V2TIMSignalingInfo)localObject2).getInviteID().equals(localV2TIMSignalingInfo.getInviteID()))
          {
            ((V2TIMSignalingInfo)localObject2).getInviteeList().remove(paramV2TIMMessage);
            if (((V2TIMSignalingInfo)localObject2).getInviteeList().size() == 0) {
              this.invitationList.remove(localObject2);
            }
          }
        }
        try
        {
          localObject1 = this.mSignalingListenerList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (V2TIMSignalingListener)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((V2TIMSignalingListener)localObject2).onInviteeAccepted(localV2TIMSignalingInfo.getInviteID(), paramV2TIMMessage, localV2TIMSignalingInfo.getData());
            }
          }
          return localV2TIMSignalingInfo;
        }
        finally {}
      }
      paramV2TIMMessage = new StringBuilder();
      paramV2TIMMessage.append("signaling receive cancel, inviteID:");
      paramV2TIMMessage.append(localV2TIMSignalingInfo.getInviteID());
      paramV2TIMMessage.append(", inviter:");
      paramV2TIMMessage.append(localV2TIMSignalingInfo.getInviter());
      IMLog.i("V2TIMSigMgrImpl", paramV2TIMMessage.toString());
      paramV2TIMMessage = this.invitationList.iterator();
      while (paramV2TIMMessage.hasNext())
      {
        localObject1 = (V2TIMSignalingInfo)paramV2TIMMessage.next();
        if (((V2TIMSignalingInfo)localObject1).getInviteID().equals(localV2TIMSignalingInfo.getInviteID())) {
          this.invitationList.remove(localObject1);
        }
      }
      try
      {
        paramV2TIMMessage = this.mSignalingListenerList.iterator();
        while (paramV2TIMMessage.hasNext())
        {
          localObject1 = (V2TIMSignalingListener)paramV2TIMMessage.next();
          if (localObject1 != null) {
            ((V2TIMSignalingListener)localObject1).onInvitationCancelled(localV2TIMSignalingInfo.getInviteID(), localV2TIMSignalingInfo.getInviter(), localV2TIMSignalingInfo.getData());
          }
        }
        return localV2TIMSignalingInfo;
      }
      finally {}
    }
    i = (int)(V2TIMManager.getInstance().getServerTime() - paramV2TIMMessage.getTimestamp());
    if ((localV2TIMSignalingInfo.getTimeout() > 0) && (i > localV2TIMSignalingInfo.getTimeout()))
    {
      paramV2TIMMessage = new StringBuilder();
      paramV2TIMMessage.append("signaling receive invitation but ignore to callback because timeInterval:");
      paramV2TIMMessage.append(i);
      paramV2TIMMessage.append(" > timeout:");
      paramV2TIMMessage.append(localV2TIMSignalingInfo.getTimeout());
      IMLog.d("V2TIMSigMgrImpl", paramV2TIMMessage.toString());
      return localV2TIMSignalingInfo;
    }
    this.invitationList.add(localV2TIMSignalingInfo);
    paramV2TIMMessage = V2TIMManager.getInstance().getLoginUser();
    if ((!TextUtils.isEmpty(paramV2TIMMessage)) && (localV2TIMSignalingInfo.getInviteeList().contains(paramV2TIMMessage)) && (localV2TIMSignalingInfo.getTimeout() > 0)) {
      this.mTimeoutHandler.postDelayed(new V2TIMSignalingManagerImpl.10(this, localV2TIMSignalingInfo, paramV2TIMMessage), localV2TIMSignalingInfo.getTimeout() * 1000);
    }
    paramV2TIMMessage = new StringBuilder();
    paramV2TIMMessage.append("signaling receive invitation, inviteID:");
    paramV2TIMMessage.append(localV2TIMSignalingInfo.getInviteID());
    paramV2TIMMessage.append(", inviter:");
    paramV2TIMMessage.append(localV2TIMSignalingInfo.getInviter());
    paramV2TIMMessage.append(", groupID:");
    paramV2TIMMessage.append(localV2TIMSignalingInfo.getGroupID());
    paramV2TIMMessage.append(", inviteeList:");
    paramV2TIMMessage.append(localV2TIMSignalingInfo.getInviteeList());
    IMLog.i("V2TIMSigMgrImpl", paramV2TIMMessage.toString());
    try
    {
      paramV2TIMMessage = new ArrayList();
      paramV2TIMMessage.addAll(localV2TIMSignalingInfo.getInviteeList());
      localObject1 = this.mSignalingListenerList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (V2TIMSignalingListener)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((V2TIMSignalingListener)localObject2).onReceiveNewInvitation(localV2TIMSignalingInfo.getInviteID(), localV2TIMSignalingInfo.getInviter(), localV2TIMSignalingInfo.getGroupID(), paramV2TIMMessage, localV2TIMSignalingInfo.getData());
        }
      }
      return localV2TIMSignalingInfo;
    }
    finally {}
    for (;;)
    {
      throw paramV2TIMMessage;
    }
  }
  
  public void reject(String paramString1, String paramString2, V2TIMCallback paramV2TIMCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("signaling reject invite, inviteID:");
    localStringBuilder.append(paramString1);
    IMLog.i("V2TIMSigMgrImpl", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString1))
    {
      IMLog.e("V2TIMSigMgrImpl", "signaling reject invite, inviteID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "inviteID is null");
      }
      return;
    }
    IMContext.getInstance().runOnMainThread(new V2TIMSignalingManagerImpl.8(this, paramString1, paramString2, paramV2TIMCallback));
  }
  
  public void removeSignalingListener(V2TIMSignalingListener paramV2TIMSignalingListener)
  {
    try
    {
      this.mSignalingListenerList.remove(paramV2TIMSignalingListener);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingManagerImpl
 * JD-Core Version:    0.7.0.1
 */