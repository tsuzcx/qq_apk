package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class V2TIMMessageManagerImpl
  extends V2TIMMessageManager
{
  private final int MAX_ABSTRACT_COUNT = 5;
  private final int MAX_ABSTRACT_LENGTH = 100;
  private final int MAX_FORWARD_COUNT = 300;
  private final String TAG = "V2TIMMessageManagerImpl";
  private Object mLockObject = new Object();
  private MessageListener mMessageListener;
  private List<V2TIMAdvancedMsgListener> mV2TIMMsgListenerList = new CopyOnWriteArrayList();
  
  private V2TIMMessageManagerImpl()
  {
    initListener();
  }
  
  static V2TIMMessageManagerImpl getInstance()
  {
    return V2TIMMessageManagerImpl.V2TIMMessageManagerImplHolder.access$100();
  }
  
  private void initListener()
  {
    this.mMessageListener = new V2TIMMessageManagerImpl.1(this);
    MessageCenter.getInstance().addMessageListener(this.mMessageListener);
  }
  
  public void addAdvancedMsgListener(V2TIMAdvancedMsgListener paramV2TIMAdvancedMsgListener)
  {
    if (paramV2TIMAdvancedMsgListener == null) {
      return;
    }
    synchronized (this.mLockObject)
    {
      if (this.mV2TIMMsgListenerList.contains(paramV2TIMAdvancedMsgListener)) {
        return;
      }
      this.mV2TIMMsgListenerList.add(paramV2TIMAdvancedMsgListener);
      return;
    }
  }
  
  public void clearC2CHistoryMessage(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "userID is empty");
      }
      return;
    }
    MessageCenter.getInstance().clearC2CHistoryMessage(paramString, new V2TIMMessageManagerImpl.21(this, paramV2TIMCallback));
  }
  
  public void clearGroupHistoryMessage(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    MessageCenter.getInstance().clearGroupHistoryMessage(paramString, new V2TIMMessageManagerImpl.22(this, paramV2TIMCallback));
  }
  
  public V2TIMMessage createCustomMessage(byte[] paramArrayOfByte)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    CustomElement localCustomElement = new CustomElement();
    localCustomElement.setData(paramArrayOfByte);
    localMessage.addElement(localCustomElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createCustomMessage(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    CustomElement localCustomElement = new CustomElement();
    localCustomElement.setData(paramArrayOfByte1);
    localCustomElement.setDescription(paramString);
    localCustomElement.setExtension(paramArrayOfByte2);
    localMessage.addElement(localCustomElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createFaceMessage(int paramInt, byte[] paramArrayOfByte)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    FaceElement localFaceElement = new FaceElement();
    localFaceElement.setFaceData(paramArrayOfByte);
    localFaceElement.setFaceIndex(paramInt);
    localMessage.addElement(localFaceElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createFileMessage(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists())
    {
      V2TIMMessage localV2TIMMessage = new V2TIMMessage();
      Message localMessage = new Message();
      FileElement localFileElement = new FileElement();
      localFileElement.setFilePath(paramString1);
      localFileElement.setFileName(paramString2);
      localMessage.addElement(localFileElement);
      localV2TIMMessage.setMessage(localMessage);
      return localV2TIMMessage;
    }
    return null;
  }
  
  public V2TIMMessage createForwardMessage(V2TIMMessage paramV2TIMMessage)
  {
    if (paramV2TIMMessage == null)
    {
      IMLog.e("V2TIMMessageManagerImpl", "createForwardMessage, message cannot be null");
      return null;
    }
    if (2 != paramV2TIMMessage.getStatus())
    {
      IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
      return null;
    }
    if (9 == paramV2TIMMessage.getElemType())
    {
      IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
      return null;
    }
    Message localMessage = new Message();
    localMessage.setMessageBaseElements(paramV2TIMMessage.getMessage().getMessageBaseElements());
    localMessage.setForward(true);
    paramV2TIMMessage = new V2TIMMessage();
    paramV2TIMMessage.setMessage(localMessage);
    return paramV2TIMMessage;
  }
  
  public V2TIMMessage createImageMessage(String paramString)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    ImageElement localImageElement = new ImageElement();
    localImageElement.setOriginImageFilePath(paramString);
    localMessage.addElement(localImageElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createLocationMessage(String paramString, double paramDouble1, double paramDouble2)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    LocationElement localLocationElement = new LocationElement();
    localLocationElement.setLongitude(paramDouble1);
    localLocationElement.setLatitude(paramDouble2);
    localLocationElement.setDescription(paramString);
    localMessage.addElement(localLocationElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createMergerMessage(List<V2TIMMessage> paramList, String paramString1, List<String> paramList1, String paramString2)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramList.size() <= 300))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject;
      if (paramList1 != null)
      {
        int j = paramList1.size();
        int i = j;
        if (j >= 5) {
          i = 5;
        }
        j = 0;
        while (j < i)
        {
          String str = (String)paramList1.get(j);
          if (str != null)
          {
            localObject = str;
            if (str.length() > 100) {
              localObject = str.substring(0, 100);
            }
            localArrayList.add(localObject);
          }
          j += 1;
        }
      }
      paramList1 = paramList.iterator();
      while (paramList1.hasNext())
      {
        localObject = (V2TIMMessage)paramList1.next();
        if (2 != ((V2TIMMessage)localObject).getStatus())
        {
          IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
          return null;
        }
        if (9 == ((V2TIMMessage)localObject).getElemType())
        {
          IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
          return null;
        }
      }
      if (paramString2 == null)
      {
        IMLog.e("V2TIMMessageManagerImpl", "compatibleText invalid, compatibleText cannot be null");
        return null;
      }
      paramList1 = new MergerElement();
      paramList1.setTitle(paramString1);
      paramList1.setAbstractList(localArrayList);
      paramList1.setCompatibleText(paramString2);
      paramString1 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString1.add(((V2TIMMessage)paramList.next()).getMessage());
      }
      paramList1.setMessageList(paramString1);
      paramList = new Message();
      paramList.addElement(paramList1);
      paramList.setForward(true);
      paramString1 = new V2TIMMessage();
      paramString1.setMessage(paramList);
      return paramString1;
    }
    IMLog.e("V2TIMMessageManagerImpl", "messageList invalid, the number of messageList must be between 1 and 300");
    return null;
  }
  
  public V2TIMMessage createSoundMessage(String paramString, int paramInt)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    SoundElement localSoundElement = new SoundElement();
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    localSoundElement.setSoundDuration(i);
    localSoundElement.setSoundFilePath(paramString);
    localMessage.addElement(localSoundElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createTextAtMessage(String paramString, List<String> paramList)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    TextElement localTextElement = new TextElement();
    localTextElement.setTextContent(paramString);
    localMessage.addElement(localTextElement);
    localV2TIMMessage.setMessage(localMessage);
    localV2TIMMessage.setGroupAtUserList(paramList);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createTextMessage(String paramString)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    TextElement localTextElement = new TextElement();
    localTextElement.setTextContent(paramString);
    localMessage.addElement(localTextElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public V2TIMMessage createVideoMessage(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    V2TIMMessage localV2TIMMessage = new V2TIMMessage();
    Message localMessage = new Message();
    VideoElement localVideoElement = new VideoElement();
    localVideoElement.setVideoFilePath(paramString1);
    localVideoElement.setSnapshotFilePath(paramString3);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    localVideoElement.setVideoDuration(i);
    localVideoElement.setVideoType(paramString2);
    localMessage.addElement(localVideoElement);
    localV2TIMMessage.setMessage(localMessage);
    return localV2TIMMessage;
  }
  
  public void deleteMessageFromLocalStorage(V2TIMMessage paramV2TIMMessage, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMMessage == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "message is null");
      }
      return;
    }
    MessageCenter.getInstance().deleteLocalMessage(paramV2TIMMessage.getMessage().getMessageKey(), new V2TIMMessageManagerImpl.19(this, paramV2TIMCallback));
  }
  
  public void deleteMessages(List<V2TIMMessage> paramList, V2TIMCallback paramV2TIMCallback)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((V2TIMMessage)paramList.next()).getMessage().getMessageKey());
      }
      MessageCenter.getInstance().deleteCloudMessageList(localArrayList, new V2TIMMessageManagerImpl.20(this, paramV2TIMCallback));
      return;
    }
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "messages is invalid");
    }
  }
  
  public void findMessages(List<String> paramList, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramV2TIMValueCallback = new V2TIMMessageManagerImpl.27(this, paramV2TIMValueCallback);
      MessageCenter.getInstance().findMessageByMessageId(paramList, new V2TIMMessageManagerImpl.28(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "messages is empty");
    }
  }
  
  public void getC2CHistoryMessageList(String paramString, int paramInt, V2TIMMessage paramV2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt != 0))
    {
      V2TIMMessageManagerImpl.9 local9 = new V2TIMMessageManagerImpl.9(this, paramV2TIMValueCallback);
      paramV2TIMValueCallback = null;
      if (paramV2TIMMessage != null) {
        paramV2TIMValueCallback = paramV2TIMMessage.getMessage().getMessageKey();
      }
      MessageCenter.getInstance().getC2CHistoryMessageList(paramString, paramV2TIMValueCallback, paramInt, true, true, new V2TIMMessageManagerImpl.10(this, local9));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "userID is empty or count is 0");
    }
  }
  
  public void getC2CReceiveMessageOpt(List<String> paramList, V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> paramV2TIMValueCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      paramV2TIMValueCallback = new V2TIMMessageManagerImpl.6(this, paramV2TIMValueCallback);
      RelationshipManager.getInstance().getC2CReceiveMessageOpt(paramList, new V2TIMMessageManagerImpl.7(this, paramV2TIMValueCallback));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "invalid userIDList");
    }
  }
  
  public void getGroupHistoryMessageList(String paramString, int paramInt, V2TIMMessage paramV2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      V2TIMMessageManagerImpl.11 local11 = new V2TIMMessageManagerImpl.11(this, paramV2TIMValueCallback);
      paramV2TIMValueCallback = null;
      if (paramV2TIMMessage != null) {
        paramV2TIMValueCallback = paramV2TIMMessage.getMessage().getMessageKey();
      }
      MessageCenter.getInstance().getGroupHistoryMessageList(paramString, paramV2TIMValueCallback, paramInt, true, true, new V2TIMMessageManagerImpl.12(this, local11));
      return;
    }
    if (paramV2TIMValueCallback != null) {
      paramV2TIMValueCallback.onError(6017, "groupID is empty or count is 0");
    }
  }
  
  public void getHistoryMessageList(V2TIMMessageListGetOption paramV2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> paramV2TIMValueCallback)
  {
    if (paramV2TIMMessageListGetOption == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "option is null");
      }
      return;
    }
    if ((TextUtils.isEmpty(paramV2TIMMessageListGetOption.getUserID())) && (TextUtils.isEmpty(paramV2TIMMessageListGetOption.getGroupID())))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID and userID cannot be null at the same time");
      }
      return;
    }
    if ((!TextUtils.isEmpty(paramV2TIMMessageListGetOption.getUserID())) && (!TextUtils.isEmpty(paramV2TIMMessageListGetOption.getGroupID())))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID and userID cannot set at the same time");
      }
      return;
    }
    if (paramV2TIMMessageListGetOption.getCount() <= 0)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "count less than 0");
      }
      return;
    }
    int i = paramV2TIMMessageListGetOption.getGetType();
    boolean bool1;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (paramV2TIMValueCallback != null) {
              paramV2TIMValueCallback.onError(6017, "getType is invalid");
            }
            return;
          }
          bool1 = false;
        }
        else
        {
          bool1 = true;
        }
        bool2 = false;
        break label188;
      }
      bool1 = false;
    }
    else
    {
      bool1 = true;
    }
    boolean bool2 = true;
    label188:
    V2TIMMessageManagerImpl.13 local13 = new V2TIMMessageManagerImpl.13(this, paramV2TIMValueCallback);
    paramV2TIMValueCallback = null;
    if (paramV2TIMMessageListGetOption.getLastMsg() != null) {
      paramV2TIMValueCallback = paramV2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey();
    }
    if (!TextUtils.isEmpty(paramV2TIMMessageListGetOption.getUserID()))
    {
      MessageCenter.getInstance().getC2CHistoryMessageList(paramV2TIMMessageListGetOption.getUserID(), paramV2TIMValueCallback, paramV2TIMMessageListGetOption.getCount(), bool1, bool2, new V2TIMMessageManagerImpl.14(this, local13));
      return;
    }
    MessageCenter.getInstance().getGroupHistoryMessageList(paramV2TIMMessageListGetOption.getGroupID(), paramV2TIMValueCallback, paramV2TIMMessageListGetOption.getCount(), bool1, bool2, new V2TIMMessageManagerImpl.15(this, local13));
  }
  
  public String insertC2CMessageToLocalStorage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramV2TIMMessage == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "message is null!");
      }
      return "";
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "userID is empty");
      }
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "sender is empty");
      }
      return "";
    }
    Message localMessage = paramV2TIMMessage.getMessage();
    localMessage.setMessageType(Message.MESSAGE_TYPE_C2C);
    localMessage.setSenderUserID(paramString2);
    localMessage.setReceiverUserID(paramString1);
    paramString1 = new V2TIMMessageManagerImpl.25(this, paramV2TIMValueCallback, paramV2TIMMessage);
    return MessageCenter.getInstance().insertLocalMessage(localMessage, new V2TIMMessageManagerImpl.26(this, paramString1, paramV2TIMMessage));
  }
  
  public String insertGroupMessageToLocalStorage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, V2TIMValueCallback<V2TIMMessage> paramV2TIMValueCallback)
  {
    if (paramV2TIMMessage == null)
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "message is null!");
      }
      return "";
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "groupID is empty");
      }
      return "";
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (paramV2TIMValueCallback != null) {
        paramV2TIMValueCallback.onError(6017, "sender is empty");
      }
      return "";
    }
    Message localMessage = paramV2TIMMessage.getMessage();
    localMessage.setMessageType(Message.MESSAGE_TYPE_GROUP);
    localMessage.setSenderUserID(paramString2);
    localMessage.setGroupID(paramString1);
    paramString1 = new V2TIMMessageManagerImpl.23(this, paramV2TIMValueCallback, paramV2TIMMessage);
    return MessageCenter.getInstance().insertLocalMessage(localMessage, new V2TIMMessageManagerImpl.24(this, paramString1, paramV2TIMMessage));
  }
  
  public void markC2CMessageAsRead(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "userID is empty");
      }
      return;
    }
    MessageCenter.getInstance().setC2CMessageRead(paramString, 0L, new V2TIMMessageManagerImpl.17(this, paramV2TIMCallback));
  }
  
  public void markGroupMessageAsRead(String paramString, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    MessageCenter.getInstance().setGroupMessageRead(paramString, 0L, new V2TIMMessageManagerImpl.18(this, paramV2TIMCallback));
  }
  
  protected void onRecvNewMessage(V2TIMMessage paramV2TIMMessage)
  {
    synchronized (this.mLockObject)
    {
      Iterator localIterator = this.mV2TIMMsgListenerList.iterator();
      while (localIterator.hasNext()) {
        ((V2TIMAdvancedMsgListener)localIterator.next()).onRecvNewMessage(paramV2TIMMessage);
      }
      return;
    }
    for (;;)
    {
      throw paramV2TIMMessage;
    }
  }
  
  public void removeAdvancedMsgListener(V2TIMAdvancedMsgListener paramV2TIMAdvancedMsgListener)
  {
    if (paramV2TIMAdvancedMsgListener == null) {
      return;
    }
    synchronized (this.mLockObject)
    {
      this.mV2TIMMsgListenerList.remove(paramV2TIMAdvancedMsgListener);
      return;
    }
  }
  
  public void revokeMessage(V2TIMMessage paramV2TIMMessage, V2TIMCallback paramV2TIMCallback)
  {
    if (paramV2TIMMessage == null)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "msg is null");
      }
      return;
    }
    if (paramV2TIMMessage.getStatus() != 2)
    {
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "msg status must be V2TIM_MSG_STATUS_SEND_SUCC");
      }
      return;
    }
    MessageCenter.getInstance().revokeMessage(paramV2TIMMessage.getMessage().getMessageKey(), new V2TIMMessageManagerImpl.16(this, paramV2TIMCallback));
  }
  
  public String sendMessage(V2TIMMessage paramV2TIMMessage, String paramString1, String paramString2, int paramInt, boolean paramBoolean, V2TIMOfflinePushInfo paramV2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> paramV2TIMSendCallback)
  {
    if (paramV2TIMMessage == null)
    {
      if (paramV2TIMSendCallback != null) {
        paramV2TIMSendCallback.onError(6017, "message is null");
      }
      return null;
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2)))
    {
      if (paramV2TIMSendCallback != null) {
        paramV2TIMSendCallback.onError(6017, "receiver and groupID cannot be empty at the same time!");
      }
      return null;
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramV2TIMSendCallback != null) {
        paramV2TIMSendCallback.onError(6017, "receiver and groupID cannot set at the same time!");
      }
      return null;
    }
    Message localMessage = paramV2TIMMessage.getMessage();
    if (!TextUtils.isEmpty(paramString1))
    {
      localMessage.setMessageType(Message.MESSAGE_TYPE_C2C);
      localMessage.setReceiverUserID(paramString1);
    }
    else
    {
      localMessage.setMessageType(Message.MESSAGE_TYPE_GROUP);
      localMessage.setGroupID(paramString2);
    }
    localMessage.setPriority(paramInt);
    if (paramBoolean) {
      localMessage.setLifeTime(0);
    }
    if (paramV2TIMOfflinePushInfo != null) {
      localMessage.setOfflinePushInfo(paramV2TIMOfflinePushInfo.getMessageOfflinePushInfo());
    }
    localMessage.setPlatform(Message.PLATFORM_ANDROID);
    paramString1 = new V2TIMMessageManagerImpl.2(this, paramV2TIMSendCallback);
    paramString2 = new V2TIMMessageManagerImpl.3(this, paramV2TIMSendCallback, paramV2TIMMessage);
    return MessageCenter.getInstance().sendMessage(localMessage, paramString1, new V2TIMMessageManagerImpl.4(this, paramString2, paramV2TIMMessage));
  }
  
  public void setC2CReceiveMessageOpt(List<String> paramList, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = 2;
      if (paramInt == 0)
      {
        paramInt = 1;
      }
      else if (paramInt == 1)
      {
        paramInt = i;
      }
      else
      {
        if (paramInt != 2) {
          break label64;
        }
        paramInt = 3;
      }
      RelationshipManager.getInstance().setC2CReceiveMessageOpt(paramList, paramInt, new V2TIMMessageManagerImpl.5(this, paramV2TIMCallback));
      return;
      label64:
      paramList = new StringBuilder();
      paramList.append("setC2CReceiveMessageOpt error opt = ");
      paramList.append(paramInt);
      IMLog.e("V2TIMMessageManagerImpl", paramList.toString());
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "opt is error");
      }
      return;
    }
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "invalid userIDList");
    }
  }
  
  public void setGroupReceiveMessageOpt(String paramString, int paramInt, V2TIMCallback paramV2TIMCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt err, groupID is empty");
      if (paramV2TIMCallback != null) {
        paramV2TIMCallback.onError(6017, "groupID is empty");
      }
      return;
    }
    int i = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE;
    if (paramInt == 0)
    {
      paramInt = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE;
    }
    else if (paramInt == 1)
    {
      paramInt = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE;
    }
    else
    {
      if (paramInt != 2) {
        break label86;
      }
      paramInt = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH;
    }
    GroupManager.getInstance().setGroupReceiveMessageOpt(paramString, paramInt, new V2TIMMessageManagerImpl.8(this, paramV2TIMCallback));
    return;
    label86:
    paramString = new StringBuilder();
    paramString.append("setReceiveMessageOpt error opt = ");
    paramString.append(paramInt);
    IMLog.e("V2TIMMessageManagerImpl", paramString.toString());
    if (paramV2TIMCallback != null) {
      paramV2TIMCallback.onError(6017, "opt is error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageManagerImpl
 * JD-Core Version:    0.7.0.1
 */