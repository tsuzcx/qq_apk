package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.ApolloMsgPlayController;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
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

class ApolloUtilImpl$2
  implements Runnable
{
  ApolloUtilImpl$2(ApolloUtilImpl paramApolloUtilImpl, int paramInt, boolean paramBoolean, CharSequence paramCharSequence, ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, ApolloManagerServiceImpl paramApolloManagerServiceImpl, AppRuntime paramAppRuntime, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    int j;
    if ((this.a == 2) && (!this.b)) {
      j = 0;
    } else {
      j = 1;
    }
    Object localObject1 = (QQText)this.c;
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = (EmoticonSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), EmoticonSpan.class);
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      int m = localObject2.length;
      int k = 0;
      while (k < m)
      {
        int n = localObject2[k].getIndex();
        if (TextUtils.isApolloEmoticon(n))
        {
          n = QQSysFaceUtil.convertToServer(n);
          if ((n >= 0) && (j != 0))
          {
            n = ApolloUtilImpl.access$000(this.d, n, this.a);
            if (n > 0) {
              localArrayList.add(Integer.valueOf(n));
            }
          }
        }
        k += 1;
      }
    }
    if ((localArrayList.size() == 0) && (1 == this.e.getApolloUserStatus()) && (!ApolloUtilImpl.access$100(this.this$0, this.f)))
    {
      ApolloUtilImpl.access$200(this.g, this.h, (QQText)localObject1, localArrayList);
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (localArrayList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloUtil", 2, new Object[] { "[playApolloEmoticonAction] send action list to play, actionList=", localArrayList });
      }
      localObject2 = ApolloMsgPlayController.a();
      QQAppInterface localQQAppInterface = this.g;
      MessageRecord localMessageRecord = this.i;
      if (j != 0) {
        localObject1 = localArrayList;
      } else {
        localObject1 = null;
      }
      ((ApolloMsgPlayController)localObject2).a(localQQAppInterface, localMessageRecord, localArrayList, (ArrayList)localObject1);
    }
    localObject1 = (QQMessageFacade)this.f.getManager(QQManagerFactory.MGR_MSG_FACADE);
    if (localObject1 != null) {
      ((QQMessageFacade)localObject1).a(this.i.frienduin, this.i.istroop, this.i.uniseq, "extStr", this.i.extStr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.2
 * JD-Core Version:    0.7.0.1
 */