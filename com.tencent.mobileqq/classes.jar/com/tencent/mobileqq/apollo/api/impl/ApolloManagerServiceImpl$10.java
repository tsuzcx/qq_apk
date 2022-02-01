package com.tencent.mobileqq.apollo.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class ApolloManagerServiceImpl$10
  extends Handler
{
  ApolloManagerServiceImpl$10(ApolloManagerServiceImpl paramApolloManagerServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1;
    if (paramMessage.what == 4096)
    {
      AppInterface localAppInterface = ApolloManagerServiceImpl.access$200(this.a);
      if (localAppInterface == null) {
        return;
      }
      paramMessage = (ApolloExtensionHandler)localAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      if (paramMessage != null)
      {
        localObject1 = new ArrayList(ApolloManagerServiceImpl.sBulkPullDressList.size());
        try
        {
          Object localObject2 = ApolloManagerServiceImpl.sBulkPullDressList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if (!((ArrayList)localObject1).contains(str)) {
              ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str)));
            }
          }
          localObject2 = ((ApolloDaoManagerServiceImpl)localAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getSelfApolloBaseInfo();
          if ((localObject2 != null) && (((ApolloBaseInfo)localObject2).apolloLocalTS != ((ApolloBaseInfo)localObject2).apolloServerTS) && (!((ArrayList)localObject1).contains(localAppInterface.getCurrentUin()))) {
            ((ArrayList)localObject1).add(Long.valueOf(localAppInterface.getLongAccountUin()));
          }
        }
        catch (Exception localException)
        {
          QLog.d("[cmshow]ApolloManager", 2, "handle msg MSG_TYPE_QUERY_APOLLO_INFO error! ", localException);
        }
        paramMessage.a((ArrayList)localObject1, "troop");
        ApolloManagerServiceImpl.sBulkPullDressList.clear();
        if (ApolloManagerServiceImpl.sBulkApolloInfoList.size() > 0)
        {
          paramMessage.a((String[])ApolloManagerServiceImpl.sBulkApolloInfoList.toArray(new String[0]));
          ApolloManagerServiceImpl.sBulkApolloInfoList.clear();
        }
      }
    }
    else
    {
      if (paramMessage.what == 4097)
      {
        localObject1 = (String)paramMessage.obj;
        if (paramMessage.arg1 == 1)
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!ApolloManagerServiceImpl.sBulkPullDressList.contains(localObject1)))
          {
            ApolloManagerServiceImpl.sBulkPullDressList.add(localObject1);
            if (QLog.isColorLevel())
            {
              paramMessage = new StringBuilder();
              paramMessage.append("addToBulkPullMap-->dress uin:");
              paramMessage.append((String)localObject1);
              QLog.d("[cmshow]ApolloManager", 2, paramMessage.toString());
            }
          }
        }
        else if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!ApolloManagerServiceImpl.sBulkApolloInfoList.contains(localObject1)))
        {
          ApolloManagerServiceImpl.sBulkApolloInfoList.add(localObject1);
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("addToBulkPullMap-->info uin:");
            paramMessage.append((String)localObject1);
            QLog.d("[cmshow]ApolloManager", 2, paramMessage.toString());
          }
        }
        this.a.mAsyncSubThreadHandler.removeMessages(4096);
        this.a.mAsyncSubThreadHandler.sendEmptyMessageDelayed(4096, 200L);
        return;
      }
      if (paramMessage.what == 4098) {
        ApolloManagerServiceImpl.access$400(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.10
 * JD-Core Version:    0.7.0.1
 */