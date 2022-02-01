package com.tencent.imcore.message.facade.msg;

import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.facade.ILastMsgGetter;
import com.tencent.imcore.message.facade.QQMessageFacadeRefresher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.Map;

class ConfessLastMsgGetter
  implements ILastMsgGetter<QQMessageFacade, QQAppInterface>
{
  public Message a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return new Message();
    }
    StringBuilder localStringBuilder = new StringBuilder("Case:");
    String str1 = UinTypeUtil.a(paramString, paramInt1);
    Message localMessage = (Message)paramQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject;
    if ((localMessage != null) && (localMessage.isCacheValid))
    {
      localObject = localMessage;
      if (localMessage.getConfessTopicId() == paramInt2) {}
    }
    else
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (((EntityManager)localObject).tabbleIsExist(str2))
      {
        localMessage = paramQQMessageFacade.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a(paramString, paramInt1, (EntityManager)localObject, paramInt2);
        localStringBuilder.append("Check-DB");
        paramQQAppInterface = localMessage;
        if (localMessage == null)
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.frienduin = paramString;
          paramQQAppInterface.istroop = paramInt1;
          paramQQAppInterface.setConfessTopicId(paramInt2);
          paramQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramQQAppInterface);
        }
      }
      else
      {
        if (localMessage == null)
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.frienduin = paramString;
          paramQQAppInterface.istroop = paramInt1;
          paramQQAppInterface.setConfessTopicId(paramInt2);
          paramQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramQQAppInterface);
        }
        else
        {
          localMessage.isCacheValid = true;
          paramQQAppInterface = localMessage;
        }
        localStringBuilder.append("Not-In-TableCache");
      }
      ((EntityManager)localObject).close();
      localObject = paramQQAppInterface;
    }
    if ((localObject != null) && (UinTypeUtil.a(((Message)localObject).frienduin, ((Message)localObject).istroop))) {
      ((Message)localObject).istroop = UinTypeUtil.a(((Message)localObject).istroop);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.ConfessLastMsgGetter
 * JD-Core Version:    0.7.0.1
 */