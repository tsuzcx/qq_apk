package com.tencent.imsdk.v2;

import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageAtInfo;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.MessageOfflinePushInfo;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class V2TIMMessage
  implements Serializable
{
  public static final int V2TIM_ELEM_TYPE_CUSTOM = 2;
  public static final int V2TIM_ELEM_TYPE_FACE = 8;
  public static final int V2TIM_ELEM_TYPE_FILE = 6;
  public static final int V2TIM_ELEM_TYPE_GROUP_TIPS = 9;
  public static final int V2TIM_ELEM_TYPE_IMAGE = 3;
  public static final int V2TIM_ELEM_TYPE_LOCATION = 7;
  public static final int V2TIM_ELEM_TYPE_MERGER = 10;
  public static final int V2TIM_ELEM_TYPE_NONE = 0;
  public static final int V2TIM_ELEM_TYPE_SOUND = 4;
  public static final int V2TIM_ELEM_TYPE_TEXT = 1;
  public static final int V2TIM_ELEM_TYPE_VIDEO = 5;
  public static final int V2TIM_MSG_STATUS_HAS_DELETED = 4;
  public static final int V2TIM_MSG_STATUS_LOCAL_IMPORTED = 5;
  public static final int V2TIM_MSG_STATUS_LOCAL_REVOKED = 6;
  public static final int V2TIM_MSG_STATUS_SENDING = 1;
  public static final int V2TIM_MSG_STATUS_SEND_FAIL = 3;
  public static final int V2TIM_MSG_STATUS_SEND_SUCC = 2;
  public static final int V2TIM_NOT_RECEIVE_MESSAGE = 1;
  public static final int V2TIM_PRIORITY_DEFAULT = 0;
  public static final int V2TIM_PRIORITY_HIGH = 1;
  public static final int V2TIM_PRIORITY_LOW = 3;
  public static final int V2TIM_PRIORITY_NORMAL = 2;
  public static final int V2TIM_RECEIVE_MESSAGE = 0;
  public static final int V2TIM_RECEIVE_NOT_NOTIFY_MESSAGE = 2;
  private Message message = new Message();
  
  public V2TIMMessage()
  {
    this.message.setClientTime(BaseManager.getInstance().getServerTime());
  }
  
  public String getCloudCustomData()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return "";
    }
    return localMessage.getCloudCustomString();
  }
  
  public V2TIMCustomElem getCustomElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 2)
    {
      V2TIMCustomElem localV2TIMCustomElem = new V2TIMCustomElem();
      localV2TIMCustomElem.setMessage(this.message);
      localV2TIMCustomElem.setElemIndex(0);
      return localV2TIMCustomElem;
    }
    return null;
  }
  
  public int getElemType()
  {
    Object localObject = this.message;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    if (((Message)localObject).getMessageBaseElements().size() <= 0) {
      return 0;
    }
    localObject = (MessageBaseElement)this.message.getMessageBaseElements().get(0);
    if ((localObject instanceof TextElement)) {
      return 1;
    }
    if ((localObject instanceof ImageElement)) {
      return 3;
    }
    if ((localObject instanceof VideoElement)) {
      return 5;
    }
    if ((localObject instanceof SoundElement)) {
      return 4;
    }
    if ((localObject instanceof FaceElement)) {
      return 8;
    }
    if ((localObject instanceof FileElement)) {
      return 6;
    }
    if ((localObject instanceof CustomElement)) {
      return 2;
    }
    if ((localObject instanceof LocationElement)) {
      return 7;
    }
    if ((localObject instanceof GroupTipsElement)) {
      return 9;
    }
    if ((localObject instanceof MergerElement)) {
      i = 10;
    }
    return i;
  }
  
  public V2TIMFaceElem getFaceElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 8)
    {
      V2TIMFaceElem localV2TIMFaceElem = new V2TIMFaceElem();
      localV2TIMFaceElem.setMessage(this.message);
      localV2TIMFaceElem.setElemIndex(0);
      return localV2TIMFaceElem;
    }
    return null;
  }
  
  public String getFaceUrl()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getFaceUrl();
    }
    return null;
  }
  
  public V2TIMFileElem getFileElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 6)
    {
      V2TIMFileElem localV2TIMFileElem = new V2TIMFileElem();
      localV2TIMFileElem.setMessage(this.message);
      localV2TIMFileElem.setElemIndex(0);
      return localV2TIMFileElem;
    }
    return null;
  }
  
  public String getFriendRemark()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getFriendRemark();
    }
    return null;
  }
  
  public List<String> getGroupAtUserList()
  {
    Object localObject1 = this.message;
    if (localObject1 == null) {
      return new ArrayList();
    }
    Object localObject2 = ((Message)localObject1).getMessageGroupAtInfoList();
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(((MessageAtInfo)((Iterator)localObject2).next()).getAtUserID());
    }
    return localObject1;
  }
  
  public String getGroupID()
  {
    Message localMessage = this.message;
    if ((localMessage != null) && (localMessage.getMessageType() == Message.MESSAGE_TYPE_GROUP)) {
      return this.message.getGroupID();
    }
    return null;
  }
  
  public V2TIMGroupTipsElem getGroupTipsElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 9)
    {
      V2TIMGroupTipsElem localV2TIMGroupTipsElem = new V2TIMGroupTipsElem();
      localV2TIMGroupTipsElem.setMessage(this.message);
      localV2TIMGroupTipsElem.setElemIndex(0);
      return localV2TIMGroupTipsElem;
    }
    return null;
  }
  
  public V2TIMImageElem getImageElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 3)
    {
      V2TIMImageElem localV2TIMImageElem = new V2TIMImageElem();
      localV2TIMImageElem.setMessage(this.message);
      localV2TIMImageElem.setElemIndex(0);
      return localV2TIMImageElem;
    }
    return null;
  }
  
  public String getLocalCustomData()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return "";
    }
    return localMessage.getLocalCustomString();
  }
  
  public int getLocalCustomInt()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return 0;
    }
    return localMessage.getLocalCustomNumber();
  }
  
  public V2TIMLocationElem getLocationElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 7)
    {
      V2TIMLocationElem localV2TIMLocationElem = new V2TIMLocationElem();
      localV2TIMLocationElem.setMessage(this.message);
      localV2TIMLocationElem.setElemIndex(0);
      return localV2TIMLocationElem;
    }
    return null;
  }
  
  public V2TIMMergerElem getMergerElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 10)
    {
      V2TIMMergerElem localV2TIMMergerElem = new V2TIMMergerElem();
      localV2TIMMergerElem.setMessage(this.message);
      localV2TIMMergerElem.setElemIndex(0);
      return localV2TIMMergerElem;
    }
    return null;
  }
  
  public Message getMessage()
  {
    return this.message;
  }
  
  public String getMsgID()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getMsgID();
    }
    return "";
  }
  
  public String getNameCard()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getNameCard();
    }
    return null;
  }
  
  public String getNickName()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getNickName();
    }
    return null;
  }
  
  public V2TIMOfflinePushInfo getOfflinePushInfo()
  {
    Object localObject = this.message;
    if (localObject == null) {
      return null;
    }
    localObject = ((Message)localObject).getOfflinePushInfo();
    V2TIMOfflinePushInfo localV2TIMOfflinePushInfo = new V2TIMOfflinePushInfo();
    localV2TIMOfflinePushInfo.setMessageOfflinePushInfo((MessageOfflinePushInfo)localObject);
    return localV2TIMOfflinePushInfo;
  }
  
  public int getPriority()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getPriority();
    }
    return 0;
  }
  
  public long getRandom()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return 0L;
    }
    return localMessage.getRandom();
  }
  
  public String getSender()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getSenderUserID();
    }
    return null;
  }
  
  public long getSeq()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return 0L;
    }
    return localMessage.getSeq();
  }
  
  public V2TIMSoundElem getSoundElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 4)
    {
      V2TIMSoundElem localV2TIMSoundElem = new V2TIMSoundElem();
      localV2TIMSoundElem.setMessage(this.message);
      localV2TIMSoundElem.setElemIndex(0);
      return localV2TIMSoundElem;
    }
    return null;
  }
  
  public int getStatus()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return 1;
    }
    return localMessage.getMessageStatus();
  }
  
  public V2TIMTextElem getTextElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 1)
    {
      V2TIMTextElem localV2TIMTextElem = new V2TIMTextElem();
      localV2TIMTextElem.setMessage(this.message);
      localV2TIMTextElem.setElemIndex(0);
      return localV2TIMTextElem;
    }
    return null;
  }
  
  public long getTimestamp()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.getTimestamp();
    }
    return 0L;
  }
  
  public String getUserID()
  {
    Message localMessage = this.message;
    if ((localMessage != null) && (localMessage.getMessageType() == Message.MESSAGE_TYPE_C2C))
    {
      if (this.message.isMessageSender()) {
        return this.message.getReceiverUserID();
      }
      return this.message.getSenderUserID();
    }
    return null;
  }
  
  public V2TIMVideoElem getVideoElem()
  {
    if (getElemType() == 0) {
      return null;
    }
    if (getElemType() == 5)
    {
      V2TIMVideoElem localV2TIMVideoElem = new V2TIMVideoElem();
      localV2TIMVideoElem.setMessage(this.message);
      localV2TIMVideoElem.setElemIndex(0);
      return localV2TIMVideoElem;
    }
    return null;
  }
  
  public boolean isExcludedFromUnreadCount()
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return false;
    }
    return localMessage.isExcludedFromUnreadCount();
  }
  
  public boolean isPeerRead()
  {
    int i = getStatus();
    if (i != 1)
    {
      if (i == 3) {
        return false;
      }
      Message localMessage = this.message;
      if (localMessage != null) {
        return localMessage.isPeerRead();
      }
    }
    return false;
  }
  
  public boolean isRead()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.isSelfRead();
    }
    return true;
  }
  
  public boolean isSelf()
  {
    Message localMessage = this.message;
    if (localMessage != null) {
      return localMessage.isMessageSender();
    }
    return true;
  }
  
  public void setCloudCustomData(String paramString)
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return;
    }
    localMessage.setCloudCustomString(paramString);
  }
  
  public void setExcludedFromUnreadCount(boolean paramBoolean)
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return;
    }
    localMessage.setExcludedFromUnreadCount(paramBoolean);
  }
  
  protected void setGroupAtUserList(List<String> paramList)
  {
    if (this.message != null)
    {
      if (paramList == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        MessageAtInfo localMessageAtInfo = new MessageAtInfo();
        localMessageAtInfo.setAtUserID(str);
        localArrayList.add(localMessageAtInfo);
      }
      this.message.setMessageGroupAtInfoList(localArrayList);
    }
  }
  
  public void setLocalCustomData(String paramString)
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return;
    }
    localMessage.setLocalCustomString(paramString);
  }
  
  public void setLocalCustomInt(int paramInt)
  {
    Message localMessage = this.message;
    if (localMessage == null) {
      return;
    }
    localMessage.setLocalCustomNumber(paramInt);
  }
  
  void setMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    this.message = paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessage
 * JD-Core Version:    0.7.0.1
 */