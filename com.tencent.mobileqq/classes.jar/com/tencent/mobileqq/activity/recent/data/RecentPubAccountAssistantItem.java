package com.tencent.mobileqq.activity.recent.data;

import acvy;
import agaw;
import android.content.Context;
import android.text.TextUtils;
import anrs;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.PubAccountAssistantData;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import java.util.ArrayList;
import java.util.List;

public class RecentPubAccountAssistantItem
  extends RecentBaseData
{
  private PubAccountAssistantData mData;
  
  public RecentPubAccountAssistantItem(PubAccountAssistantData paramPubAccountAssistantData)
  {
    if (paramPubAccountAssistantData == null) {
      throw new NullPointerException("PubAccountAssistantData is null");
    }
    this.mData = paramPubAccountAssistantData;
    this.mUnreadFlag = 3;
  }
  
  private void a()
  {
    StringBuilder localStringBuilder;
    if (AppSetting.c)
    {
      localStringBuilder = new StringBuilder(24);
      localStringBuilder.append(this.mTitleName);
      if (this.mUnreadNum != 0) {
        break label96;
      }
    }
    for (;;)
    {
      if (this.mMsgExtroInfo != null) {
        localStringBuilder.append(this.mMsgExtroInfo + ",");
      }
      localStringBuilder.append(this.mLastMsg).append(' ').append(this.mShowTime);
      this.mContentDesc = localStringBuilder.toString();
      return;
      label96:
      if (this.mUnreadNum == 1) {
        localStringBuilder.append("有一条未读");
      } else if (this.mUnreadNum == 2) {
        localStringBuilder.append("有两条未读");
      } else if (this.mUnreadNum > 0) {
        localStringBuilder.append("有").append(this.mUnreadNum).append("条未读");
      }
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
  
  public void update(IMCoreAppRuntime paramIMCoreAppRuntime, Context paramContext)
  {
    Object localObject1 = null;
    if (!(paramIMCoreAppRuntime instanceof QQAppInterface)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)paramIMCoreAppRuntime;
    } while ((localQQAppInterface == null) || (paramContext == null));
    Object localObject2 = getRecentUserUin();
    int i = getRecentUserType();
    paramIMCoreAppRuntime = localQQAppInterface.a();
    if (paramIMCoreAppRuntime != null) {}
    for (QQMessageFacade.Message localMessage = paramIMCoreAppRuntime.a((String)localObject2, i);; localMessage = null)
    {
      String str;
      if (localMessage != null)
      {
        this.mDisplayTime = localMessage.time;
        paramIMCoreAppRuntime = localQQAppInterface.a();
        if (paramIMCoreAppRuntime != null)
        {
          this.mUnreadNum = paramIMCoreAppRuntime.a(localMessage.frienduin, localMessage.istroop);
          paramIMCoreAppRuntime = (anrs)localQQAppInterface.getManager(56);
          if (paramIMCoreAppRuntime == null) {
            break label455;
          }
          paramIMCoreAppRuntime = paramIMCoreAppRuntime.b((String)localObject2);
          if (paramIMCoreAppRuntime == null) {
            break label455;
          }
          str = paramIMCoreAppRuntime.name;
        }
      }
      for (paramIMCoreAppRuntime = paramIMCoreAppRuntime.summary;; paramIMCoreAppRuntime = (IMCoreAppRuntime)localObject1)
      {
        localObject1 = str;
        if (str == null) {
          localObject1 = localObject2;
        }
        this.mTitleName = ((String)localObject1);
        localObject1 = getMsgSummaryTemp();
        if (localMessage != null)
        {
          int j = localMessage.msgtype;
          if ((j != -3006) && (j != -5004)) {
            buildMessageBody(localMessage, i, localQQAppInterface, paramContext, (MsgSummary)localObject1);
          }
        }
        else
        {
          label200:
          if ((TextUtils.isEmpty(((MsgSummary)localObject1).strContent)) && (TextUtils.isEmpty(((MsgSummary)localObject1).suffix)))
          {
            if (paramIMCoreAppRuntime != null) {
              break label452;
            }
            paramIMCoreAppRuntime = "";
          }
        }
        label452:
        for (;;)
        {
          ((MsgSummary)localObject1).strContent = paramIMCoreAppRuntime;
          dealStatus(localQQAppInterface);
          dealDraft(localQQAppInterface, (MsgSummary)localObject1);
          extraUpdate(localQQAppInterface, paramContext, (MsgSummary)localObject1);
          a();
          return;
          this.mUnreadNum = 0;
          break;
          this.mDisplayTime = 0L;
          this.mUnreadNum = 0;
          break;
          ((MsgSummary)localObject1).strContent = "";
          localObject2 = agaw.a(localMessage);
          if ((localObject2 == null) || (((PAMessage)localObject2).items == null) || (((PAMessage)localObject2).items.size() == 0))
          {
            buildMessageBody(localMessage, i, localQQAppInterface, paramContext, (MsgSummary)localObject1);
            break label200;
          }
          str = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
          if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null)) {
            str = str + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
          }
          for (;;)
          {
            ((MsgSummary)localObject1).strContent = str;
            break;
          }
        }
        label455:
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentPubAccountAssistantItem
 * JD-Core Version:    0.7.0.1
 */