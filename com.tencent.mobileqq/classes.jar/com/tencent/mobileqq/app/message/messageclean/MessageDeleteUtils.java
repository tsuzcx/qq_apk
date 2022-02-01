package com.tencent.mobileqq.app.message.messageclean;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class MessageDeleteUtils
{
  private static int a(String paramString, int paramInt, StringBuilder paramStringBuilder, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getReadableDatabase();
    if (paramQQAppInterface == null) {
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder(" where msgtype != ");
    localStringBuilder.append(-2006);
    paramString = MessageDBUtils.a(MessageRecord.getOldTableName(paramString, paramInt), MessageRecord.getTableName(paramString, paramInt), paramQQAppInterface, localStringBuilder.toString());
    if (paramString == null) {
      return 0;
    }
    paramString = paramQQAppInterface.rawQuery(paramString.toString(), null);
    if (paramString == null) {
      return 0;
    }
    if ((paramString.getCount() > 0) && (paramStringBuilder != null))
    {
      paramString.moveToLast();
      long l;
      if (paramInt == 3000) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else if (paramInt == 0) {
        l = paramString.getLong(paramString.getColumnIndex("time"));
      } else if (paramInt == 1) {
        l = paramString.getLong(paramString.getColumnIndex("shmsgseq"));
      } else {
        l = 0L;
      }
      if (l > 0L) {
        paramStringBuilder.append(String.valueOf(l));
      }
    }
    paramInt = paramString.getCount();
    paramString.close();
    return paramInt;
  }
  
  public static void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    if ((TextUtils.isEmpty(paramString)) || ((paramInt == 0) || ((paramInt == 1) || ((paramInt != 1000) && (paramInt != 1004) && ((paramInt == 3000) || (paramInt != 10010)))))) {}
    try
    {
      if (!QLog.isColorLevel()) {
        break label165;
      }
      paramString = new StringBuilder();
      paramString.append("cleanMessage type not support = ");
      paramString.append(paramInt);
      QLog.d("MessageDeleteUtils", 2, paramString.toString());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      break label121;
    }
    a(paramString, paramInt, c(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
    return;
    a(paramString, paramInt, c(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
    return;
    a(paramString, paramInt, b(paramString, paramInt, paramQQAppInterface), paramQQAppInterface);
    return;
    label121:
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("cleanMessage exception = ");
      paramString.append(paramQQAppInterface.getMessage());
      QLog.d("MessageDeleteUtils", 2, paramString.toString());
    }
    paramQQAppInterface.printStackTrace();
    label165:
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, QQAppInterface paramQQAppInterface)
  {
    List localList = paramQQAppInterface.getMessageFacade().h(paramString1, paramInt);
    long l1;
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (((MessageRecord)localList.get(localList.size() - 1)).isSendFromLocal()) {
        l1 = ((MessageRecord)localList.get(localList.size() - 1)).time + 2L;
      } else {
        l1 = ((MessageRecord)localList.get(localList.size() - 1)).time;
      }
    }
    else {
      l1 = 0L;
    }
    paramQQAppInterface.getMessageFacade().c(paramString1, paramInt);
    paramQQAppInterface.getMessageFacade().g(paramString1, paramInt);
    if (paramString2 != null)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramString2);
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
        l2 = 0L;
      }
      l1 = Math.max(l2, l1);
      if (l1 > 0L) {
        paramQQAppInterface.getMsgCache().a(paramString1, paramInt, l1);
      }
    }
  }
  
  private static String b(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((((MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).a(paramString, paramInt, localStringBuilder) > 0) && (localStringBuilder.length() > 0)) {
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static String c(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (a(paramString, paramInt, localStringBuilder, paramQQAppInterface) > 0) {
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.MessageDeleteUtils
 * JD-Core Version:    0.7.0.1
 */