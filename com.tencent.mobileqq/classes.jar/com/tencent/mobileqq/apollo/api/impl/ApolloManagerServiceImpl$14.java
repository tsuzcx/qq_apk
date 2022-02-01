package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class ApolloManagerServiceImpl$14
  implements Runnable
{
  ApolloManagerServiceImpl$14(ApolloManagerServiceImpl paramApolloManagerServiceImpl, List paramList) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = ApolloManagerServiceImpl.access$300(this.this$0);
    if (localQQAppInterface == null) {}
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    label48:
    ApolloBaseInfo localApolloBaseInfo;
    do
    {
      return;
      localArrayList1 = new ArrayList(8);
      localArrayList2 = new ArrayList(16);
      Iterator localIterator = this.a.iterator();
      if (!localIterator.hasNext()) {
        break;
      }
      localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
    } while (localApolloBaseInfo == null);
    int i = 0;
    Object localObject4 = localApolloBaseInfo.getApolloDress();
    StringBuilder localStringBuilder;
    int j;
    long l;
    Object localObject2;
    Object localObject3;
    if (localObject4 != null)
    {
      localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel()) {
        localStringBuilder.append("updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((ApolloDress)localObject4).toString());
      }
      j = -1;
      l = this.this$0.getApolloResLocalTimestamp(1, ((ApolloDress)localObject4).roleId) / 1000L;
      i = j;
      if (l != ((ApolloDress)localObject4).roleTimeStamp)
      {
        i = j;
        if (!localArrayList1.contains(Integer.valueOf(((ApolloDress)localObject4).roleId)))
        {
          j = ((ApolloDress)localObject4).roleId;
          localArrayList1.add(Integer.valueOf(((ApolloDress)localObject4).roleId));
          i = j;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\nrole id: ").append(((ApolloDress)localObject4).roleId).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress)localObject4).roleTimeStamp);
            i = j;
          }
        }
      }
      localObject2 = null;
      localObject1 = localObject2;
      if (((ApolloDress)localObject4).dressMap != null)
      {
        localObject3 = new ArrayList();
        localObject1 = ((ApolloDress)localObject4).dressMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject1).next()).getValue();
          l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject4).id) / 1000L;
          if ((l != ((ApolloDress.Dress)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((ApolloDress.Dress)localObject4).id))))
          {
            ((ArrayList)localObject3).add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
            localArrayList2.add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
            if (QLog.isColorLevel()) {
              localStringBuilder.append("\ndress id: ").append(((ApolloDress.Dress)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress.Dress)localObject4).ts);
            }
          }
        }
        localObject1 = localApolloBaseInfo.getApolloPetDress();
        if ((localObject1 != null) && (((ApolloDress)localObject1).dressMap != null))
        {
          localObject1 = ((ApolloDress)localObject1).dressMap.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject1).next()).getValue();
            l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject4).id) / 1000L;
            if ((l != ((ApolloDress.Dress)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((ApolloDress.Dress)localObject4).id))))
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
              localArrayList2.add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\npet dress id: ").append(((ApolloDress.Dress)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress.Dress)localObject4).ts);
              }
            }
          }
        }
        localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject2 = new int[((ArrayList)localObject3).size()];
          localObject3 = ((ArrayList)localObject3).iterator();
          j = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2[j] = ((Integer)((Iterator)localObject3).next()).intValue();
            j += 1;
          }
        }
      }
      if ((i != -1) || ((localObject1 != null) && (localObject1.length != 0))) {
        break label1113;
      }
      i = 1;
      localStringBuilder.append("\nlocal dress is OK");
    }
    int k;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, localStringBuilder.toString());
      }
      localObject4 = localApolloBaseInfo.getApolloDress3D();
      k = i;
      if (localObject4 == null) {
        break label1280;
      }
      localStringBuilder = new StringBuilder();
      if (QLog.isColorLevel()) {
        localStringBuilder.append("3d updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((ApolloDress)localObject4).toString());
      }
      k = -1;
      l = this.this$0.getApolloResLocalTimestamp(1, ((ApolloDress)localObject4).roleId) / 1000L;
      j = k;
      if (l != ((ApolloDress)localObject4).roleTimeStamp)
      {
        j = k;
        if (!localArrayList1.contains(Integer.valueOf(((ApolloDress)localObject4).roleId)))
        {
          k = ((ApolloDress)localObject4).roleId;
          localArrayList1.add(Integer.valueOf(((ApolloDress)localObject4).roleId));
          j = k;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\n3d role id: ").append(((ApolloDress)localObject4).roleId).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress)localObject4).roleTimeStamp);
            j = k;
          }
        }
      }
      localObject2 = null;
      localObject1 = localObject2;
      if (((ApolloDress)localObject4).dressMap == null) {
        break label1233;
      }
      localObject3 = new ArrayList();
      localObject1 = ((ApolloDress)localObject4).dressMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject1).next()).getValue();
        l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject4).id) / 1000L;
        if ((l != ((ApolloDress.Dress)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((ApolloDress.Dress)localObject4).id))))
        {
          ((ArrayList)localObject3).add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
          localArrayList2.add(Integer.valueOf(((ApolloDress.Dress)localObject4).id));
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\n3d dress id: ").append(((ApolloDress.Dress)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((ApolloDress.Dress)localObject4).ts);
          }
        }
      }
      label1113:
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localApolloBaseInfo.uin, this.this$0.getResDownloadListener(), i, (int[])localObject1, -1, -1, true);
      if (QLog.isColorLevel()) {
        localStringBuilder.append("\ndown load dress");
      }
      i = 0;
    }
    Object localObject1 = localObject2;
    if (((ArrayList)localObject3).size() > 0)
    {
      localObject2 = new int[((ArrayList)localObject3).size()];
      localObject3 = ((ArrayList)localObject3).iterator();
      k = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject2[k] = ((Integer)((Iterator)localObject3).next()).intValue();
        k += 1;
      }
    }
    label1233:
    if ((j == -1) && ((localObject1 == null) || (localObject1.length == 0)))
    {
      j = 1;
      localStringBuilder.append("\nlocal dress is OK");
    }
    for (;;)
    {
      k = j;
      if (QLog.isColorLevel())
      {
        QLog.d("ApolloManager", 2, localStringBuilder.toString());
        k = j;
      }
      label1280:
      if (k == 0) {
        break label48;
      }
      localObject1 = new ArrayList(1);
      ((ArrayList)localObject1).add(localApolloBaseInfo.uin);
      localObject2 = (ApolloExtensionHandlerImpl)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      ((ApolloExtensionHandlerImpl)localObject2).notifyUI(2, true, localObject1);
      CmGameServerQIPCModule.a().a((ArrayList)localObject1);
      ((ApolloExtensionHandlerImpl)localObject2).a(localApolloBaseInfo.uin, localApolloBaseInfo);
      break label48;
      break;
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localQQAppInterface, localApolloBaseInfo.uin, this.this$0.getResDownloadListener(), j, (int[])localObject1, -1, -1, true);
      j = i;
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("\n3d download dress");
        j = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.14
 * JD-Core Version:    0.7.0.1
 */