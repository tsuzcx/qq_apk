package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.task.ApolloMsgPlayController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ApolloUtilImpl$2
  implements Runnable
{
  ApolloUtilImpl$2(ApolloUtilImpl paramApolloUtilImpl, int paramInt, boolean paramBoolean, CharSequence paramCharSequence, ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ApolloManagerServiceImpl paramApolloManagerServiceImpl, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    int j;
    if ((this.jdField_a_of_type_Int == 2) && (!this.jdField_a_of_type_Boolean)) {
      j = 0;
    } else {
      j = 1;
    }
    Object localObject1 = (QQText)this.jdField_a_of_type_JavaLangCharSequence;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (EmoticonSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), EmoticonSpan.class);
    int i;
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
        int i1 = localObject2[k].getIndex();
        m = i;
        if (TextUtils.isApolloEmoticon(i1))
        {
          i1 = QQSysFaceUtil.convertToServer(i1);
          m = i;
          if (i1 >= 0)
          {
            if (j != 0)
            {
              i = ApolloUtilImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqApolloPersistenceApiImplApolloDaoManagerServiceImpl, i1, this.jdField_a_of_type_Int);
              if (i > 0) {
                localArrayList.add(Integer.valueOf(i));
              }
            }
            m = 1;
          }
        }
        k += 1;
      }
    }
    int m = 0;
    if ((j == 0) && (m != 0)) {
      ApolloUtilImpl.addWhiteFaceUnSupportTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if ((localArrayList.size() == 0) && (1 == this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloManagerServiceImpl.getApolloUserStatus()))
    {
      ApolloUtilImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (QQText)localObject1, localArrayList);
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (localArrayList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] send action list to play, actionList=", localArrayList });
      }
      localObject2 = ApolloMsgPlayController.a();
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      if (i != 0) {
        localObject1 = localArrayList;
      } else {
        localObject1 = null;
      }
      ((ApolloMsgPlayController)localObject2).a(localQQAppInterface, localMessageRecord, localArrayList, (ArrayList)localObject1);
    }
    localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 != null)
    {
      localObject1 = (QQMessageFacade)((AppRuntime)localObject1).getManager(QQManagerFactory.MGR_MSG_FACADE);
      if (localObject1 != null) {
        ((QQMessageFacade)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, "extStr", this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extStr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */