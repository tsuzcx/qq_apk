package com.tencent.imcore.message.facade.msg;

import android.os.Looper;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.imcore.message.facade.QQMessageFacadeRefresher;
import com.tencent.mobileqq.activity.recent.RecentParcelUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.Map;

public class CommonLastMsgGetter
  implements ILastMsgGetter<QQMessageFacade, QQAppInterface>
{
  public Message a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return new Message();
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = UinTypeUtil.a(paramString, paramInt1);
    Message localMessage = (Message)paramQQMessageFacade.a.get(str1);
    Object localObject;
    if (localMessage != null)
    {
      localObject = localMessage;
      if (localMessage.isCacheValid) {}
    }
    else if (paramQQMessageFacade.m.b() == 0)
    {
      localObject = new Message();
      ((Message)localObject).frienduin = paramString;
      ((Message)localObject).istroop = paramInt1;
      paramQQMessageFacade.a.put(str1, localObject);
      localStringBuilder.append("All-In");
    }
    else if (!paramQQMessageFacade.m.a())
    {
      localObject = localMessage;
      if (localMessage == null) {
        if ((RecentParcelUtil.a(paramQQAppInterface)) && (Looper.getMainLooper() != Looper.myLooper()))
        {
          localObject = MessageRecord.getTableName(paramString, paramInt1);
          paramQQAppInterface = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          if (paramQQAppInterface.tabbleIsExist((String)localObject))
          {
            localMessage = paramQQMessageFacade.m.a(paramString, paramInt1, paramQQAppInterface);
            localStringBuilder.append("Not-Finish-Yet，force Check DB");
          }
          paramQQAppInterface.close();
          localObject = localMessage;
          if (localMessage == null)
          {
            localObject = new Message();
            ((Message)localObject).frienduin = paramString;
            ((Message)localObject).istroop = paramInt1;
            ((Message)localObject).isCacheValid = false;
            paramQQMessageFacade.a.put(str1, localObject);
            localStringBuilder.append("Not-Finish-Yet，force Check DB But Null");
          }
        }
        else
        {
          localObject = new Message();
          ((Message)localObject).frienduin = paramString;
          ((Message)localObject).istroop = paramInt1;
          ((Message)localObject).isCacheValid = false;
          paramQQMessageFacade.a.put(str1, localObject);
        }
      }
      localStringBuilder.append("Not-Finish-Yet");
    }
    else
    {
      localObject = MessageRecord.getTableName(paramString, paramInt1);
      String str2 = MessageRecord.getOldTableName(paramString, paramInt1);
      EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!localEntityManager.tabbleIsExist((String)localObject)) && (!localEntityManager.tabbleIsExist(str2)))
      {
        if (localMessage == null)
        {
          localObject = new Message();
          ((Message)localObject).frienduin = paramString;
          ((Message)localObject).istroop = paramInt1;
          paramQQMessageFacade.a.put(str1, localObject);
        }
        else
        {
          localMessage.isCacheValid = true;
          localObject = localMessage;
        }
        localStringBuilder.append("Not-In-TableCache");
      }
      else
      {
        paramQQAppInterface = paramQQMessageFacade.m.a(paramString, paramInt1, localEntityManager);
        localStringBuilder.append("Check-DB");
        localObject = paramQQAppInterface;
        if (paramQQAppInterface == null)
        {
          localObject = new Message();
          ((Message)localObject).frienduin = paramString;
          ((Message)localObject).istroop = paramInt1;
          paramQQMessageFacade.a.put(str1, localObject);
        }
      }
      localEntityManager.close();
    }
    if ((localObject != null) && (UinTypeUtil.c(((Message)localObject).frienduin, ((Message)localObject).istroop))) {
      ((Message)localObject).istroop = UinTypeUtil.e(((Message)localObject).istroop);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.CommonLastMsgGetter
 * JD-Core Version:    0.7.0.1
 */