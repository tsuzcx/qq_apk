package com.tencent.mobileqq.activity.messagesearch;

import ajxn;
import android.text.TextUtils;
import axun;
import axuo;
import bbcl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
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
    Object localObject2;
    if (paramString.equals("cover"))
    {
      localObject1 = paramAbsShareMsg.mContentCover;
      localObject2 = localObject1;
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
              if (!localIterator.hasNext()) {
                return paramAbsShareMsg;
              }
              localObject2 = (axun)localIterator.next();
              if (!(localObject2 instanceof axuo)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((axuo)localObject2).a == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((axuo)localObject2).a.isEmpty()) {
                break label248;
              }
              localObject2 = ((axuo)localObject2).a.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (axun)((Iterator)localObject2).next();
                if (!paramString.equals("cover")) {
                  break label206;
                }
                paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory(paramAbsShareMsg);
                localObject1 = paramAbsShareMsg;
              } while (TextUtils.isEmpty(paramAbsShareMsg));
              localObject1 = paramAbsShareMsg;
              if (TextUtils.isEmpty(paramAbsShareMsg)) {
                break label248;
              }
              localObject2 = paramAbsShareMsg;
            }
          }
        }
      }
    }
    label206:
    label214:
    label228:
    do
    {
      return localObject2;
      localObject1 = paramAbsShareMsg.mContentTitle;
      break;
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory(paramAbsShareMsg);
      break label176;
      if (!paramString.equals("cover")) {
        break label240;
      }
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((axun)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((axun)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public static C2CLinkElement parseFrom(QQAppInterface paramQQAppInterface, Object paramObject, ajxn paramajxn, SimpleDateFormat paramSimpleDateFormat, int paramInt)
  {
    AbsShareMsg localAbsShareMsg = null;
    paramajxn = localAbsShareMsg;
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      paramajxn = localAbsShareMsg;
      if (paramObject.structingMsg != null)
      {
        paramajxn = localAbsShareMsg;
        if ((paramObject.structingMsg instanceof AbsShareMsg))
        {
          localAbsShareMsg = (AbsShareMsg)paramObject.structingMsg;
          paramajxn = new C2CLinkElement();
          paramajxn.uin = paramObject.frienduin;
          paramajxn.title = getStructMsgInfo(localAbsShareMsg, "title");
          paramajxn.iconUrl = getStructMsgInfo(localAbsShareMsg, "cover");
          paramajxn.nickname = bbcl.a(paramQQAppInterface, paramObject.senderuin);
          paramajxn.time = paramObject.time;
          paramajxn.timeSecond = paramSimpleDateFormat.format(new Date(paramObject.time * 1000L));
          paramajxn.mPos = paramInt;
          paramajxn.msgSeq = paramObject.shmsgseq;
          paramajxn.sendUin = paramObject.senderuin;
          paramajxn.isSend = paramObject.issend;
          paramajxn.url = localAbsShareMsg.mMsgUrl;
        }
      }
    }
    return paramajxn;
  }
  
  public String description()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.title).append('\n');
    localStringBuilder.append(this.uin).append('\n');
    localStringBuilder.append(this.nickname).append('\n');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkElement
 * JD-Core Version:    0.7.0.1
 */