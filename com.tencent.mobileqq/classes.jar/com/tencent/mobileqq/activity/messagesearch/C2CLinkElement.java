package com.tencent.mobileqq.activity.messagesearch;

import alto;
import android.text.TextUtils;
import azus;
import azut;
import bdgc;
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
              localObject2 = (azus)localIterator.next();
              if (!(localObject2 instanceof azut)) {
                break label214;
              }
              localObject1 = paramAbsShareMsg;
              if (((azut)localObject2).a == null) {
                break label248;
              }
              localObject1 = paramAbsShareMsg;
              if (((azut)localObject2).a.isEmpty()) {
                break label248;
              }
              localObject2 = ((azut)localObject2).a.iterator();
              localObject1 = paramAbsShareMsg;
              label176:
              do
              {
                paramAbsShareMsg = (AbsShareMsg)localObject1;
                if (!((Iterator)localObject2).hasNext()) {
                  break;
                }
                paramAbsShareMsg = (azus)((Iterator)localObject2).next();
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
      paramAbsShareMsg = StructMsgForGeneralShare.getCoverForChatHistory((azus)localObject2);
      localObject2 = paramAbsShareMsg;
    } while (!TextUtils.isEmpty(paramAbsShareMsg));
    for (;;)
    {
      break;
      label240:
      paramAbsShareMsg = StructMsgForGeneralShare.getTitleForChatHistory((azus)localObject2);
      break label228;
      label248:
      paramAbsShareMsg = (AbsShareMsg)localObject1;
    }
    return paramAbsShareMsg;
  }
  
  public static C2CLinkElement parseFrom(QQAppInterface paramQQAppInterface, Object paramObject, alto paramalto, SimpleDateFormat paramSimpleDateFormat, int paramInt)
  {
    AbsShareMsg localAbsShareMsg = null;
    paramalto = localAbsShareMsg;
    if ((paramObject instanceof MessageForStructing))
    {
      paramObject = (MessageForStructing)paramObject;
      paramalto = localAbsShareMsg;
      if (paramObject.structingMsg != null)
      {
        paramalto = localAbsShareMsg;
        if ((paramObject.structingMsg instanceof AbsShareMsg))
        {
          localAbsShareMsg = (AbsShareMsg)paramObject.structingMsg;
          paramalto = new C2CLinkElement();
          paramalto.uin = paramObject.frienduin;
          paramalto.title = getStructMsgInfo(localAbsShareMsg, "title");
          paramalto.iconUrl = getStructMsgInfo(localAbsShareMsg, "cover");
          paramalto.nickname = bdgc.a(paramQQAppInterface, paramObject.senderuin);
          paramalto.time = paramObject.time;
          paramalto.timeSecond = paramSimpleDateFormat.format(new Date(paramObject.time * 1000L));
          paramalto.mPos = paramInt;
          paramalto.msgSeq = paramObject.shmsgseq;
          paramalto.sendUin = paramObject.senderuin;
          paramalto.isSend = paramObject.issend;
          paramalto.url = localAbsShareMsg.mMsgUrl;
        }
      }
    }
    return paramalto;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkElement
 * JD-Core Version:    0.7.0.1
 */