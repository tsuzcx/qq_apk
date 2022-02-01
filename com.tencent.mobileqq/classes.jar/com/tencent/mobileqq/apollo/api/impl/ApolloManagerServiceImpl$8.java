package com.tencent.mobileqq.apollo.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ApolloManagerServiceImpl$8
  implements IApolloResDownloader.OnApolloDownLoadListener
{
  ApolloManagerServiceImpl$8(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramInt2 = 0;
    Object localObject;
    if (paramBoolean)
    {
      if ((paramInt1 > 0) && (!CMResUtil.b(paramInt1)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, "role rsc NOT complete.");
        }
        return;
      }
      if (paramArrayOfInt != null)
      {
        paramInt1 = paramInt2;
        while (paramInt1 < paramArrayOfInt.length)
        {
          if (!CMResUtil.a(paramArrayOfInt[paramInt1]))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("dress rsc NOT complete, id:");
              paramString.append(paramArrayOfInt[paramInt1]);
              QLog.d("[cmshow]ApolloManager", 2, paramString.toString());
            }
            return;
          }
          paramInt1 += 1;
        }
      }
      paramArrayOfInt = new ArrayList(1);
      paramArrayOfInt.add(paramString);
      localObject = ApolloManagerServiceImpl.access$200(this.a);
      if (localObject != null)
      {
        localObject = (ApolloExtensionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        ((ApolloExtensionHandler)localObject).notifyUI(2, true, paramArrayOfInt);
        ((ApolloExtensionHandler)localObject).a(paramString, null);
      }
      CmGameServerQIPCModule.a().a(paramArrayOfInt);
      if (QLog.isColorLevel())
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("apollo dress download ok notifyUI uin: ");
        paramArrayOfInt.append(((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
        QLog.d("[cmshow]ApolloManager", 2, paramArrayOfInt.toString());
      }
    }
    else
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramArrayOfInt = new ArrayList(1);
        paramArrayOfInt.add(paramString);
        localObject = ApolloManagerServiceImpl.access$200(this.a);
        if (localObject != null)
        {
          localObject = (ApolloExtensionHandler)((AppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          ((ApolloExtensionHandler)localObject).notifyUI(2, false, paramArrayOfInt);
          ((ApolloExtensionHandler)localObject).a(paramString, null);
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayOfInt = new StringBuilder();
        paramArrayOfInt.append("apollo dress download failed ");
        paramArrayOfInt.append(((IApolloUtil)QRoute.api(IApolloUtil.class)).wrapLogUin(paramString));
        QLog.d("[cmshow]ApolloManager", 2, paramArrayOfInt.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */