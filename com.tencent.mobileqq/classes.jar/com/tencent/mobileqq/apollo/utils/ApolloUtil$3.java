package com.tencent.mobileqq.apollo.utils;

import airx;
import ajkn;
import ajmu;
import axau;
import aykk;
import aykr;
import aylc;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class ApolloUtil$3
  implements Runnable
{
  ApolloUtil$3(int paramInt, boolean paramBoolean, CharSequence paramCharSequence, ajmu paramajmu, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (int j = 0;; j = 1)
    {
      Object localObject1 = (aykk)this.jdField_a_of_type_JavaLangCharSequence;
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = (aykr[])((aykk)localObject1).getSpans(0, ((aykk)localObject1).length(), aykr.class);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int n = localObject2.length;
        int k = 0;
        for (i = 0;; i = m)
        {
          m = i;
          if (k >= n) {
            break;
          }
          int i1 = localObject2[k].a();
          m = i;
          if (aylc.a(i1))
          {
            m = i;
            if (i1 >= 0)
            {
              m = i;
              if (i1 < axau.a.length)
              {
                if (j != 0)
                {
                  i = ApolloUtil.a(this.jdField_a_of_type_Ajmu, axau.a[i1], this.jdField_a_of_type_Int);
                  if (i > 0) {
                    localArrayList.add(Integer.valueOf(i));
                  }
                }
                m = 1;
              }
            }
          }
          k += 1;
        }
      }
      int m = 0;
      if ((j == 0) && (m != 0)) {
        ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      if ((localArrayList.size() == 0) && (1 == airx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        ApolloUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (aykk)localObject1, localArrayList);
      }
      for (int i = 1;; i = 0)
      {
        QQAppInterface localQQAppInterface;
        ChatMessage localChatMessage;
        if (localArrayList.size() > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] send action list to play, actionList=", localArrayList });
          }
          localObject2 = ajkn.a();
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          localChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (i == 0) {
            break label369;
          }
        }
        label369:
        for (localObject1 = localArrayList;; localObject1 = null)
        {
          ((ajkn)localObject2).a(localQQAppInterface, localChatMessage, localArrayList, (ArrayList)localObject1);
          localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null)
          {
            localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(20);
            if (localObject1 != null) {
              ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extStr);
            }
          }
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloUtil.3
 * JD-Core Version:    0.7.0.1
 */