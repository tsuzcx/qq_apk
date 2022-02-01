package com.tencent.mobileqq.activity.aio.tips;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class GatherContactsTipsHelper
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      c(paramQQAppInterface, paramString);
      Object localObject = MessageRecordFactory.a(-1026);
      long l = MessageCache.c();
      ((MessageRecord)localObject).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1026, 0, l);
      ((MessageRecord)localObject).isread = true;
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C56", "0X8004C56", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertUncommonlyUsedContactsTips success, currentUin: ");
        ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append(" friendUin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("GatherContactsTipsHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      c(paramQQAppInterface, paramString);
      Object localObject = MessageRecordFactory.a(-1027);
      long l = MessageCache.c();
      ((MessageRecord)localObject).init(paramQQAppInterface.getCurrentAccountUin(), paramString, paramString, "", l, -1027, 0, l);
      ((MessageRecord)localObject).isread = true;
      paramQQAppInterface.getMessageFacade().a((MessageRecord)localObject, ((MessageRecord)localObject).selfuin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004C57", "0X8004C57", 0, 0, "", "", "", "");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertUncommonlyUsedContactsCancelSetTips success, currentUin: ");
        ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append(" friendUin:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("GatherContactsTipsHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, List<String> paramList)
  {
    if ((paramQQAppInterface != null) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b(paramQQAppInterface, (String)paramList.next());
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().h(paramString, 0).iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if ((localMessageRecord.msgtype == -1026) || (localMessageRecord.msgtype == -1027))
      {
        paramQQAppInterface.getMessageFacade().h(paramString, 0, localMessageRecord.uniseq);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("deleteUncommonlyUsedContactsAndCancelTips, currentUin: ");
          localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
          localStringBuilder.append(" friendUin:");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" msgtype:");
          localStringBuilder.append(localMessageRecord.msgtype);
          QLog.d("GatherContactsTipsHelper", 2, localStringBuilder.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper
 * JD-Core Version:    0.7.0.1
 */