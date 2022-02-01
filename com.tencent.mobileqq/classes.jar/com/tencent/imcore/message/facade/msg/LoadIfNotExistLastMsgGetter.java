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

class LoadIfNotExistLastMsgGetter
  implements ILastMsgGetter<QQMessageFacade, QQAppInterface>
{
  public Message a(QQMessageFacade paramQQMessageFacade, QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return null;
    }
    String str1 = UinTypeUtil.a(paramString, paramInt1);
    Message localMessage = (Message)paramQQMessageFacade.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject = localMessage;
    if (localMessage == null)
    {
      String str2 = MessageRecord.getTableName(paramString, paramInt1);
      String str3 = MessageRecord.getOldTableName(paramString, paramInt1);
      localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((!((EntityManager)localObject).tabbleIsExist(str2)) && (!((EntityManager)localObject).tabbleIsExist(str3)))
      {
        if (localMessage == null)
        {
          paramQQAppInterface = new Message();
          paramQQAppInterface.frienduin = paramString;
          paramQQAppInterface.istroop = paramInt1;
          paramQQMessageFacade.jdField_a_of_type_JavaUtilMap.put(str1, paramQQAppInterface);
          paramQQMessageFacade = paramQQAppInterface;
        }
        else
        {
          localMessage.isCacheValid = true;
          paramQQMessageFacade = localMessage;
        }
      }
      else {
        paramQQMessageFacade = paramQQMessageFacade.jdField_a_of_type_ComTencentImcoreMessageFacadeQQMessageFacadeRefresher.a(paramString, paramInt1, (EntityManager)localObject);
      }
      ((EntityManager)localObject).close();
      localObject = paramQQMessageFacade;
    }
    if ((localObject != null) && (UinTypeUtil.a(((Message)localObject).frienduin, ((Message)localObject).istroop))) {
      ((Message)localObject).istroop = UinTypeUtil.a(((Message)localObject).istroop);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.msg.LoadIfNotExistLastMsgGetter
 * JD-Core Version:    0.7.0.1
 */