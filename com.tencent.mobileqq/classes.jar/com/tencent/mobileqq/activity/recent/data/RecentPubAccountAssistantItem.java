package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import java.util.ArrayList;
import java.util.List;

public class RecentPubAccountAssistantItem
  extends RecentBaseData
{
  private PubAccountAssistantData mData;
  
  public RecentPubAccountAssistantItem(PubAccountAssistantData paramPubAccountAssistantData)
  {
    if (paramPubAccountAssistantData != null)
    {
      this.mData = paramPubAccountAssistantData;
      this.mUnreadFlag = 3;
      return;
    }
    throw new NullPointerException("PubAccountAssistantData is null");
  }
  
  private void a()
  {
    if (AppSetting.e)
    {
      StringBuilder localStringBuilder1 = new StringBuilder(24);
      localStringBuilder1.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        if (this.mUnreadNum == 1)
        {
          localStringBuilder1.append("有一条未读");
        }
        else if (this.mUnreadNum == 2)
        {
          localStringBuilder1.append("有两条未读");
        }
        else if (this.mUnreadNum > 0)
        {
          localStringBuilder1.append("有");
          localStringBuilder1.append(this.mUnreadNum);
          localStringBuilder1.append("条未读");
        }
      }
      if (this.mMsgExtroInfo != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(this.mMsgExtroInfo);
        localStringBuilder2.append(",");
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder1.append(this.mLastMsg);
      localStringBuilder1.append(' ');
      localStringBuilder1.append(this.mShowTime);
      this.mContentDesc = localStringBuilder1.toString();
    }
  }
  
  public long getLastDraftTime()
  {
    return this.mData.mLastDraftTime;
  }
  
  public long getLastMsgTime()
  {
    return this.mData.mLastMsgTime;
  }
  
  public int getRecentUserType()
  {
    return this.mData.mType;
  }
  
  public String getRecentUserUin()
  {
    return this.mData.mUin;
  }
  
  public boolean isUnreadMsgNumInTabNum()
  {
    return false;
  }
  
  public void update(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)paramBaseQQAppInterface;
    if (localQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Object localObject3 = getRecentUserUin();
      int i = getRecentUserType();
      paramBaseQQAppInterface = localQQAppInterface.getMessageFacade();
      Object localObject1 = null;
      Object localObject2;
      if (paramBaseQQAppInterface != null) {
        localObject2 = paramBaseQQAppInterface.getLastMessage((String)localObject3, i);
      } else {
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        this.mDisplayTime = ((Message)localObject2).time;
        paramBaseQQAppInterface = localQQAppInterface.getConversationFacade();
        if (paramBaseQQAppInterface != null) {
          this.mUnreadNum = paramBaseQQAppInterface.a(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
        } else {
          this.mUnreadNum = 0;
        }
      }
      else
      {
        this.mDisplayTime = 0L;
        this.mUnreadNum = 0;
      }
      paramBaseQQAppInterface = (IPublicAccountDataManager)localQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
      if (paramBaseQQAppInterface != null)
      {
        paramBaseQQAppInterface = (PublicAccountInfo)paramBaseQQAppInterface.findPublicAccountInfo((String)localObject3);
        if (paramBaseQQAppInterface != null)
        {
          localObject1 = paramBaseQQAppInterface.name;
          paramBaseQQAppInterface = paramBaseQQAppInterface.summary;
          break label175;
        }
      }
      paramBaseQQAppInterface = null;
      label175:
      if (localObject1 == null) {
        localObject1 = localObject3;
      }
      this.mTitleName = ((String)localObject1);
      localObject3 = getMsgSummaryTemp();
      if (localObject2 != null)
      {
        int j = ((Message)localObject2).msgtype;
        if ((j != -3006) && (j != -5004))
        {
          buildMessageBody((Message)localObject2, i, localQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
        else
        {
          ((MsgSummary)localObject3).strContent = "";
          PAMessage localPAMessage = XMLMessageUtils.a((MessageRecord)localObject2);
          if ((localPAMessage != null) && (localPAMessage.items != null) && (localPAMessage.items.size() != 0))
          {
            localObject2 = ((PAMessage.Item)localPAMessage.items.get(0)).title;
            localObject1 = localObject2;
            if (((PAMessage.Item)localPAMessage.items.get(0)).cover == null)
            {
              localObject1 = localObject2;
              if (((PAMessage.Item)localPAMessage.items.get(0)).digestList != null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append((String)localObject2);
                ((StringBuilder)localObject1).append("：");
                ((StringBuilder)localObject1).append((String)((PAMessage.Item)localPAMessage.items.get(0)).digestList.get(0));
                localObject1 = ((StringBuilder)localObject1).toString();
              }
            }
            ((MsgSummary)localObject3).strContent = ((CharSequence)localObject1);
          }
          else
          {
            buildMessageBody((Message)localObject2, i, localQQAppInterface, paramContext, (MsgSummary)localObject3);
          }
        }
      }
      if ((TextUtils.isEmpty(((MsgSummary)localObject3).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject3).suffix)))
      {
        localObject1 = paramBaseQQAppInterface;
        if (paramBaseQQAppInterface == null) {
          localObject1 = "";
        }
        ((MsgSummary)localObject3).strContent = ((CharSequence)localObject1);
      }
      dealStatus(localQQAppInterface);
      dealDraft(localQQAppInterface, (MsgSummary)localObject3);
      extraUpdate(localQQAppInterface, paramContext, (MsgSummary)localObject3);
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem
 * JD-Core Version:    0.7.0.1
 */