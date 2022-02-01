package com.tencent.imcore.message.facade;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

public class QQMessageFacadeVipUtils
{
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = paramQQAppInterface.getMessageProxy(0).b(paramString, 0);
    if (localObject1 != null)
    {
      int i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        localObject2 = (MessageRecord)((List)localObject1).get(i);
        if ((((MessageRecord)localObject2).senderuin != null) && (((MessageRecord)localObject2).senderuin.equals(paramString)))
        {
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break label92;
          }
          QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          localObject1 = localObject2;
          break label92;
        }
        i -= 1;
      }
    }
    localObject1 = null;
    label92:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      paramString = paramQQAppInterface.getMessageProxy(0).a(paramString, 0, 9223372036854775807L, 1, String.format(Locale.US, "issend<>%d and issend<>%d", new Object[] { Integer.valueOf(1), Integer.valueOf(2) }));
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramString != null)
      {
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (!paramString.isEmpty()) {
          paramQQAppInterface = (MessageRecord)paramString.get(0);
        }
      }
      localObject2 = paramQQAppInterface;
      if (QLog.isColorLevel())
      {
        QLog.d("vip", 2, "getLastC2CBubleID find in db");
        localObject2 = paramQQAppInterface;
      }
    }
    if (localObject2 == null) {
      return 0L;
    }
    return ((MessageRecord)localObject2).vipBubbleID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.QQMessageFacadeVipUtils
 * JD-Core Version:    0.7.0.1
 */