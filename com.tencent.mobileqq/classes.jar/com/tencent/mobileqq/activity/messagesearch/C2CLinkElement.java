package com.tencent.mobileqq.activity.messagesearch;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class C2CLinkElement
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String iconUrl;
  public int isSend;
  public int mPos;
  public long msgSeq;
  public String nickname;
  public String sendUin;
  public long time;
  public String timeSecond = "0";
  public String title;
  public String uin;
  public String url;
  
  public static String getStructMsgInfo(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    Object localObject1;
    if (paramString.equals("cover")) {
      localObject1 = paramAbsShareMsg.mContentCover;
    } else {
      localObject1 = paramAbsShareMsg.mContentTitle;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = localObject1;
      if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
      {
        paramAbsShareMsg = (StructMsgForGeneralShare)paramAbsShareMsg;
        localObject2 = localObject1;
        if (paramAbsShareMsg.mStructMsgItemLists != null)
        {
          localObject2 = localObject1;
          if (!paramAbsShareMsg.mStructMsgItemLists.isEmpty())
          {
            Iterator localIterator = paramAbsShareMsg.mStructMsgItemLists.iterator();
            paramAbsShareMsg = (AbsShareMsg)localObject1;
            do
            {
              do
              {
                do
                {
                  localObject2 = paramAbsShareMsg;
                  if (!localIterator.hasNext()) {
                    return localObject2;
                  }
                  localObject1 = (AbsStructMsgElement)localIterator.next();
                  if (!(localObject1 instanceof AbsStructMsgItem)) {
                    break;
                  }
                  localObject1 = (AbsStructMsgItem)localObject1;
                } while ((((AbsStructMsgItem)localObject1).a == null) || (((AbsStructMsgItem)localObject1).a.isEmpty()));
                localObject2 = ((AbsStructMsgItem)localObject1).a.iterator();
                localObject1 = paramAbsShareMsg;
                while (((Iterator)localObject2).hasNext())
                {
                  paramAbsShareMsg = (AbsStructMsgElement)((Iterator)localObject2).next();
                  if (paramString.equals("cover")) {
                    paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                  } else {
                    paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
                  }
                  localObject1 = paramAbsShareMsg;
                  if (!TextUtils.isEmpty(paramAbsShareMsg)) {
                    localObject1 = paramAbsShareMsg;
                  }
                }
                paramAbsShareMsg = (AbsShareMsg)localObject1;
              } while (TextUtils.isEmpty((CharSequence)localObject1));
              return localObject1;
              if (paramString.equals("cover")) {
                localObject1 = StructMsgForGeneralShare.getCoverForChatHistory((AbsStructMsgElement)localObject1);
              } else {
                localObject1 = StructMsgForGeneralShare.getTitleForChatHistory((AbsStructMsgElement)localObject1);
              }
              paramAbsShareMsg = (AbsShareMsg)localObject1;
            } while (TextUtils.isEmpty((CharSequence)localObject1));
            localObject2 = localObject1;
          }
        }
      }
    }
    return localObject2;
  }
  
  public static C2CLinkElement parseFrom(QQAppInterface paramQQAppInterface, Object paramObject, FriendsManager paramFriendsManager, SimpleDateFormat paramSimpleDateFormat, int paramInt)
  {
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      if ((paramObject.structingMsg != null) && ((paramObject.structingMsg instanceof AbsShareMsg)))
      {
        paramFriendsManager = (AbsShareMsg)paramObject.structingMsg;
        C2CLinkElement localC2CLinkElement = new C2CLinkElement();
        localC2CLinkElement.uin = paramObject.frienduin;
        localC2CLinkElement.title = getStructMsgInfo(paramFriendsManager, "title");
        localC2CLinkElement.iconUrl = getStructMsgInfo(paramFriendsManager, "cover");
        localC2CLinkElement.nickname = ContactUtils.a(paramQQAppInterface, paramObject.senderuin);
        localC2CLinkElement.time = paramObject.time;
        localC2CLinkElement.timeSecond = paramSimpleDateFormat.format(new Date(paramObject.time * 1000L));
        localC2CLinkElement.mPos = paramInt;
        localC2CLinkElement.msgSeq = paramObject.shmsgseq;
        localC2CLinkElement.sendUin = paramObject.senderuin;
        localC2CLinkElement.isSend = paramObject.issend;
        localC2CLinkElement.url = paramFriendsManager.mMsgUrl;
        return localC2CLinkElement;
      }
    }
    return null;
  }
  
  public String description()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title);
    localStringBuilder.append('\n');
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\n');
    localStringBuilder.append(this.nickname);
    localStringBuilder.append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkElement
 * JD-Core Version:    0.7.0.1
 */