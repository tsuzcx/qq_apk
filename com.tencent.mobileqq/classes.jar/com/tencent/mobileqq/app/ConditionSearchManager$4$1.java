package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchManager$4$1
  implements Runnable
{
  ConditionSearchManager$4$1(ConditionSearchManager.4 param4) {}
  
  public void run()
  {
    label366:
    for (;;)
    {
      try
      {
        if (this.a.this$0.g != null)
        {
          Card localCard = this.a.this$0.g;
          Object localObject1 = localCard.strLocationCodes;
          String str = "";
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = localCard.strLocationCodes.split("-");
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("parse location codes: ");
              ((StringBuilder)localObject2).append(localCard.strLocationCodes);
              QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject2).toString());
            }
            localObject2 = this.a.this$0.d((String[])localObject1);
            localObject1 = localObject2;
            if (((String)localObject2).equals("不限")) {
              localObject1 = "";
            }
            localCard.strLocationDesc = ((String)localObject1);
          }
          if (localCard.strHometownCodes != null)
          {
            localObject2 = localCard.strHometownCodes.split("-");
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("parse hometown codes: ");
              ((StringBuilder)localObject1).append(localCard.strHometownCodes);
              QLog.d("ConditionSearch.Manager", 2, ((StringBuilder)localObject1).toString());
            }
            localObject1 = this.a.this$0.d((String[])localObject2);
            if (!((String)localObject1).equals("不限")) {
              break label366;
            }
            localObject1 = str;
            localCard.strHometownDesc = ((String)localObject1);
            localObject1 = this.a.this$0.f((String[])localObject2);
            if ((localObject1 != null) && (localObject1.length == 4))
            {
              localCard.strHometownCountry = localObject1[0];
              localCard.strHometownProvince = localObject1[1];
              localCard.strHometownCity = localObject1[2];
            }
          }
          ((FriendsManager)ConditionSearchManager.a(this.a.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(localCard);
          ((CardHandler)ConditionSearchManager.a(this.a.this$0).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(43, true, localCard);
        }
        else
        {
          this.a.this$0.f = false;
          this.a.this$0.g = null;
          this.a.this$0.b(this.a.this$0.h);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ConditionSearch.Manager", 1, "pendCardParseRequest fail!", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.4.1
 * JD-Core Version:    0.7.0.1
 */