package com.tencent.imcore.message.ext.getaiolist;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildOneClickJumpMsgFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PretreatmentAIOMsg
{
  public static void a(int paramInt, List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList(8);
      Object localObject = null;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord == null)
        {
          localArrayList.add(localMessageRecord);
        }
        else
        {
          String str = localMessageRecord.frienduin;
          if ((localMessageRecord.msgtype != -2006) && (localMessageRecord.isValid))
          {
            localObject = str;
            if (localMessageRecord.msgtype == -2015)
            {
              localObject = str;
              if ((localMessageRecord instanceof MessageForQzoneFeed))
              {
                localObject = (MessageForQzoneFeed)localMessageRecord;
                ((MessageForQzoneFeed)localObject).parse();
                if (QZoneHelper.hideAioFeeds())
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间下发配置屏蔽 aiofeeds，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                  localObject = str;
                }
                else if (((MessageForQzoneFeed)localObject).isOldStructMsg)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间aio feeds格式不兼容，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                  localObject = str;
                }
                else
                {
                  localObject = str;
                  if (FeedsManager.isShowStatus(localMessageRecord.frienduin))
                  {
                    if (QLog.isColorLevel()) {
                      QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,当前会话列表中有新动态，先将aio中的feeds隐藏，避免aio中的feeds跳变");
                    }
                    localArrayList.add(localMessageRecord);
                    localObject = str;
                  }
                }
              }
            }
          }
          else
          {
            localArrayList.add(localMessageRecord);
            localObject = str;
          }
        }
      }
      paramList.removeAll(localArrayList);
      if (paramInt == 10014) {
        GuildOneClickJumpMsgFilter.a(localArrayList);
      }
      if ((localObject != null) && (FeedsManager.isShowStatus((String)localObject)) && (paramQQAppInterface != null))
      {
        paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(paramList, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.getaiolist.PretreatmentAIOMsg
 * JD-Core Version:    0.7.0.1
 */