package com.tencent.mobileqq.apollo.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class ApolloManagerServiceImpl$15
  extends Handler
{
  ApolloManagerServiceImpl$15(ApolloManagerServiceImpl paramApolloManagerServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface;
    if (paramMessage.what == 4096)
    {
      localQQAppInterface = ApolloManagerServiceImpl.access$300(this.a);
      if (localQQAppInterface != null) {}
    }
    do
    {
      do
      {
        return;
        paramMessage = (ApolloExtensionHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      } while (paramMessage == null);
      Object localObject = new ArrayList(ApolloManagerServiceImpl.sBulkPullDressList.size());
      try
      {
        Iterator localIterator = ApolloManagerServiceImpl.sBulkPullDressList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((ArrayList)localObject).contains(str))
          {
            ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(str)));
            continue;
            paramMessage.a((ArrayList)localObject, "troop");
          }
        }
      }
      catch (Exception localException) {}
      for (;;)
      {
        ApolloManagerServiceImpl.sBulkPullDressList.clear();
        if (ApolloManagerServiceImpl.sBulkApolloInfoList.size() <= 0) {
          break;
        }
        paramMessage.a((String[])ApolloManagerServiceImpl.sBulkApolloInfoList.toArray(new String[0]));
        ApolloManagerServiceImpl.sBulkApolloInfoList.clear();
        return;
        if ((ApolloManagerServiceImpl.access$1000(this.a) != null) && (ApolloManagerServiceImpl.access$1000(this.a).apolloLocalTS != ApolloManagerServiceImpl.access$1000(this.a).apolloServerTS) && (!((ArrayList)localObject).contains(localException.getCurrentUin()))) {
          ((ArrayList)localObject).add(Long.valueOf(localException.getLongAccountUin()));
        }
      }
      if (paramMessage.what == 4097)
      {
        localObject = (String)paramMessage.obj;
        if (paramMessage.arg1 == 1) {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManagerServiceImpl.sBulkPullDressList.contains(localObject)))
          {
            ApolloManagerServiceImpl.sBulkPullDressList.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
            }
          }
        }
        for (;;)
        {
          this.a.mAsyncSubThreadHandler.removeMessages(4096);
          this.a.mAsyncSubThreadHandler.sendEmptyMessageDelayed(4096, 200L);
          return;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!ApolloManagerServiceImpl.sBulkApolloInfoList.contains(localObject)))
          {
            ApolloManagerServiceImpl.sBulkApolloInfoList.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
            }
          }
        }
      }
    } while (paramMessage.what != 4098);
    ApolloManagerServiceImpl.access$1100(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.15
 * JD-Core Version:    0.7.0.1
 */