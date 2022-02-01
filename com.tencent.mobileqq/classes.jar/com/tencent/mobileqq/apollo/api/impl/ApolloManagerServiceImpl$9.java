package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloDress.Dress;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

class ApolloManagerServiceImpl$9
  implements Runnable
{
  ApolloManagerServiceImpl$9(ApolloManagerServiceImpl paramApolloManagerServiceImpl, List paramList) {}
  
  public void run()
  {
    Object localObject2 = ApolloManagerServiceImpl.access$200(this.this$0);
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(8);
    ArrayList localArrayList = new ArrayList(16);
    Object localObject3 = this.a.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)((Iterator)localObject3).next();
      if (localApolloBaseInfo == null) {
        return;
      }
      Object localObject4 = localApolloBaseInfo.getApolloDress();
      Object localObject5 = "\nlocal dress is OK";
      int k = 0;
      Object localObject6 = ", local TS: ";
      long l;
      int j;
      int i;
      Object localObject7;
      Object localObject8;
      if (localObject4 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("updateUserDress uin: ");
          localStringBuilder.append(localApolloBaseInfo.uin);
          localStringBuilder.append(", dress info: ");
          localStringBuilder.append(((ApolloDress)localObject4).toString());
        }
        l = this.this$0.getApolloResLocalTimestamp(1, ((ApolloDress)localObject4).roleId) / 1000L;
        if ((l != ((ApolloDress)localObject4).roleTimeStamp) && (!((ArrayList)localObject1).contains(Integer.valueOf(((ApolloDress)localObject4).roleId))))
        {
          j = ((ApolloDress)localObject4).roleId;
          ((ArrayList)localObject1).add(Integer.valueOf(((ApolloDress)localObject4).roleId));
          i = j;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\nrole id: ");
            localStringBuilder.append(((ApolloDress)localObject4).roleId);
            localStringBuilder.append(", local TS: ");
            localStringBuilder.append(l);
            localStringBuilder.append(", svr TS: ");
            localStringBuilder.append(((ApolloDress)localObject4).roleTimeStamp);
            i = j;
          }
        }
        else
        {
          i = -1;
        }
        Object localObject10;
        if (((ApolloDress)localObject4).dressMap != null)
        {
          localObject11 = new ArrayList();
          localObject7 = ((ApolloDress)localObject4).dressMap.entrySet().iterator();
          localObject4 = localObject2;
          while (((Iterator)localObject7).hasNext())
          {
            localObject2 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject7).next()).getValue();
            l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject2).id) / 1000L;
            if ((l != ((ApolloDress.Dress)localObject2).ts) && (!localArrayList.contains(Integer.valueOf(((ApolloDress.Dress)localObject2).id))))
            {
              ((ArrayList)localObject11).add(Integer.valueOf(((ApolloDress.Dress)localObject2).id));
              localArrayList.add(Integer.valueOf(((ApolloDress.Dress)localObject2).id));
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\ndress id: ");
                localStringBuilder.append(((ApolloDress.Dress)localObject2).id);
                localStringBuilder.append(", local TS: ");
                localStringBuilder.append(l);
                localStringBuilder.append(", svr TS: ");
                localStringBuilder.append(((ApolloDress.Dress)localObject2).ts);
              }
            }
          }
          localObject2 = localObject5;
          localObject7 = localApolloBaseInfo.getApolloPetDress();
          localObject5 = localObject6;
          localObject8 = localObject1;
          if (localObject7 != null)
          {
            localObject5 = localObject6;
            localObject8 = localObject1;
            if (((ApolloDress)localObject7).dressMap != null)
            {
              localObject7 = ((ApolloDress)localObject7).dressMap.entrySet().iterator();
              for (;;)
              {
                localObject5 = localObject6;
                localObject8 = localObject1;
                if (!((Iterator)localObject7).hasNext()) {
                  break;
                }
                localObject5 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject7).next()).getValue();
                l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject5).id) / 1000L;
                if ((l != ((ApolloDress.Dress)localObject5).ts) && (!localArrayList.contains(Integer.valueOf(((ApolloDress.Dress)localObject5).id))))
                {
                  ((ArrayList)localObject11).add(Integer.valueOf(((ApolloDress.Dress)localObject5).id));
                  localArrayList.add(Integer.valueOf(((ApolloDress.Dress)localObject5).id));
                  if (QLog.isColorLevel())
                  {
                    localStringBuilder.append("\npet dress id: ");
                    localStringBuilder.append(((ApolloDress.Dress)localObject5).id);
                    localStringBuilder.append((String)localObject6);
                    localStringBuilder.append(l);
                    localStringBuilder.append(", svr TS: ");
                    localStringBuilder.append(((ApolloDress.Dress)localObject5).ts);
                  }
                }
              }
            }
          }
          localObject1 = localObject5;
          localObject9 = localObject1;
          localObject10 = localObject4;
          localObject6 = localObject8;
          localObject5 = localObject3;
          localObject7 = localObject2;
          if (((ArrayList)localObject11).size() > 0)
          {
            int[] arrayOfInt = new int[((ArrayList)localObject11).size()];
            Iterator localIterator = ((ArrayList)localObject11).iterator();
            j = 0;
            for (;;)
            {
              localObject11 = arrayOfInt;
              localObject9 = localObject1;
              localObject10 = localObject4;
              localObject6 = localObject8;
              localObject5 = localObject3;
              localObject7 = localObject2;
              if (!localIterator.hasNext()) {
                break;
              }
              arrayOfInt[j] = ((Integer)localIterator.next()).intValue();
              j += 1;
            }
          }
        }
        else
        {
          localObject9 = ", local TS: ";
          localObject7 = "\nlocal dress is OK";
          localObject5 = localObject3;
          localObject6 = localObject1;
          localObject10 = localObject2;
        }
        Object localObject11 = null;
        if ((i == -1) && ((localObject11 == null) || (localObject11.length == 0)))
        {
          localStringBuilder.append((String)localObject7);
          i = 1;
        }
        else
        {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(localObject10, localApolloBaseInfo.uin, this.this$0.getResDownloadListener(), i, (int[])localObject11, -1, -1, true);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\ndown load dress");
          }
          i = 0;
        }
        localObject4 = localObject10;
        localObject2 = localObject7;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]ApolloManager", 2, localStringBuilder.toString());
          localObject1 = localObject6;
          localObject3 = localObject5;
          localObject5 = localObject9;
        }
        else
        {
          localObject1 = localObject6;
          localObject3 = localObject5;
          localObject5 = localObject9;
        }
      }
      else
      {
        localObject5 = ", local TS: ";
        localObject6 = "\nlocal dress is OK";
        i = 0;
        localObject4 = localObject2;
        localObject2 = localObject6;
      }
      Object localObject9 = localApolloBaseInfo.getApolloDress3D();
      if (localObject9 != null)
      {
        localObject7 = new StringBuilder();
        if (QLog.isColorLevel())
        {
          ((StringBuilder)localObject7).append("3d updateUserDress uin: ");
          ((StringBuilder)localObject7).append(localApolloBaseInfo.uin);
          ((StringBuilder)localObject7).append(", dress info: ");
          ((StringBuilder)localObject7).append(((ApolloDress)localObject9).toString());
        }
        l = this.this$0.getApolloResLocalTimestamp(1, ((ApolloDress)localObject9).roleId) / 1000L;
        if (l != ((ApolloDress)localObject9).roleTimeStamp)
        {
          j = ((ApolloDress)localObject9).roleId;
          localObject6 = localObject1;
          if (!((ArrayList)localObject6).contains(Integer.valueOf(j)))
          {
            j = ((ApolloDress)localObject9).roleId;
            ((ArrayList)localObject6).add(Integer.valueOf(((ApolloDress)localObject9).roleId));
            if (QLog.isColorLevel())
            {
              ((StringBuilder)localObject7).append("\n3d role id: ");
              ((StringBuilder)localObject7).append(((ApolloDress)localObject9).roleId);
              ((StringBuilder)localObject7).append((String)localObject5);
              ((StringBuilder)localObject7).append(l);
              ((StringBuilder)localObject7).append(", svr TS: ");
              ((StringBuilder)localObject7).append(((ApolloDress)localObject9).roleTimeStamp);
            }
            break label1206;
          }
        }
        j = -1;
        label1206:
        if (((ApolloDress)localObject9).dressMap != null)
        {
          localObject8 = new ArrayList();
          localObject6 = ((ApolloDress)localObject9).dressMap.entrySet().iterator();
          while (((Iterator)localObject6).hasNext())
          {
            localObject9 = (ApolloDress.Dress)((Map.Entry)((Iterator)localObject6).next()).getValue();
            l = this.this$0.getApolloResLocalTimestamp(2, ((ApolloDress.Dress)localObject9).id) / 1000L;
            if ((l != ((ApolloDress.Dress)localObject9).ts) && (!localArrayList.contains(Integer.valueOf(((ApolloDress.Dress)localObject9).id))))
            {
              ((ArrayList)localObject8).add(Integer.valueOf(((ApolloDress.Dress)localObject9).id));
              localArrayList.add(Integer.valueOf(((ApolloDress.Dress)localObject9).id));
              if (QLog.isColorLevel())
              {
                ((StringBuilder)localObject7).append("\n3d dress id: ");
                ((StringBuilder)localObject7).append(((ApolloDress.Dress)localObject9).id);
                ((StringBuilder)localObject7).append((String)localObject5);
                ((StringBuilder)localObject7).append(l);
                ((StringBuilder)localObject7).append(", svr TS: ");
                ((StringBuilder)localObject7).append(((ApolloDress.Dress)localObject9).ts);
              }
            }
          }
          localObject5 = localObject2;
          localObject6 = localObject1;
          if (((ArrayList)localObject8).size() > 0)
          {
            localObject6 = new int[((ArrayList)localObject8).size()];
            localObject5 = ((ArrayList)localObject8).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6[k] = ((Integer)((Iterator)localObject5).next()).intValue();
              k += 1;
            }
            break label1497;
          }
        }
        else
        {
          localObject6 = localObject1;
          localObject5 = localObject2;
        }
        localObject2 = null;
        localObject1 = localObject6;
        localObject6 = localObject2;
        localObject2 = localObject5;
        label1497:
        if ((j == -1) && ((localObject6 == null) || (localObject6.length == 0)))
        {
          ((StringBuilder)localObject7).append((String)localObject2);
          j = 1;
        }
        else
        {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder((AppRuntime)localObject4, localApolloBaseInfo.uin, this.this$0.getResDownloadListener(), j, (int[])localObject6, -1, -1, true);
          j = i;
          if (QLog.isColorLevel())
          {
            ((StringBuilder)localObject7).append("\n3d download dress");
            j = i;
          }
        }
        localObject2 = localObject1;
        localObject1 = localObject2;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]ApolloManager", 2, ((StringBuilder)localObject7).toString());
          localObject1 = localObject2;
          i = j;
        }
      }
      if (i != 0)
      {
        localObject2 = new ArrayList(1);
        ((ArrayList)localObject2).add(localApolloBaseInfo.uin);
        localObject5 = (ApolloExtensionHandler)((AppInterface)localObject4).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        ((ApolloExtensionHandler)localObject5).notifyUI(2, true, localObject2);
        CmGameServerQIPCModule.a().a((ArrayList)localObject2);
        ((ApolloExtensionHandler)localObject5).a(localApolloBaseInfo.uin, localApolloBaseInfo);
      }
      localObject2 = localObject4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.9
 * JD-Core Version:    0.7.0.1
 */