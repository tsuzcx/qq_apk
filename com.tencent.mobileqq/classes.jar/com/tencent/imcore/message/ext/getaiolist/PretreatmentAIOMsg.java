package com.tencent.imcore.message.ext.getaiolist;

import com.tencent.mobileqq.activity.aio.BeancurdManager;
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
  public static void a(List<MessageRecord> paramList, QQAppInterface paramQQAppInterface)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    do
    {
      String str;
      do
      {
        return;
        ArrayList localArrayList = new ArrayList(8);
        str = null;
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
            str = localMessageRecord.frienduin;
            if ((localMessageRecord.msgtype == -2006) || (!localMessageRecord.isValid)) {
              localArrayList.add(localMessageRecord);
            }
            for (;;)
            {
              break;
              if ((localMessageRecord.msgtype == -2015) && ((localMessageRecord instanceof MessageForQzoneFeed)))
              {
                ((MessageForQzoneFeed)localMessageRecord).parse();
                if (QZoneHelper.hideAioFeeds())
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间下发配置屏蔽 aiofeeds，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                }
                else if (((MessageForQzoneFeed)localMessageRecord).isOldStructMsg)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,空间aio feeds格式不兼容，不再显示");
                  }
                  localArrayList.add(localMessageRecord);
                }
                else if (FeedsManager.isShowStatus(localMessageRecord.frienduin))
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,当前会话列表中有新动态，先将aio中的feeds隐藏，避免aio中的feeds跳变");
                  }
                  localArrayList.add(localMessageRecord);
                }
              }
            }
          }
        }
        paramList.removeAll(localArrayList);
      } while ((str == null) || (!FeedsManager.isShowStatus(str)) || (paramQQAppInterface == null));
      paramQQAppInterface = (BeancurdManager)paramQQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.a(paramList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.getaiolist.PretreatmentAIOMsg
 * JD-Core Version:    0.7.0.1
 */