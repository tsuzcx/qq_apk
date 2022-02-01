package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.recommend.data.RecentRecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class MayknowRecommendManager$1
  implements Handler.Callback
{
  MayknowRecommendManager$1(MayknowRecommendManager paramMayknowRecommendManager) {}
  
  public boolean handleMessage(Message arg1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleMessage msg.what = ");
      ((StringBuilder)localObject1).append(???.what);
      QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
    }
    int j = ???.what;
    int i = 0;
    boolean bool;
    Object localObject4;
    switch (j)
    {
    default: 
      return true;
    case 9: 
      ??? = (Bundle)???.obj;
      bool = ???.getBoolean("key_is_success");
      ??? = ???.getString("key_req_uin");
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isSuccess :");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(" onAddReqStatesChanged: ");
        ((StringBuilder)localObject1).append(???);
        QLog.d("MayknowRecommendManager", 2, ((StringBuilder)localObject1).toString());
      }
      this.a.a(???, true);
      ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(105, true, null);
      return true;
    case 8: 
      ??? = (String)???.obj;
      this.a.a(???, true);
      ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(105, true, null);
      return true;
    case 7: 
      this.a.j();
      return true;
    case 6: 
      ??? = (String)???.obj;
      MayknowRecommendManager.k(this.a).delete(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(???) });
      return true;
    case 5: 
      i = ???.arg1;
      ??? = (Bundle)???.obj;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getMayKnowRecommendRemote, real start, entryType = ");
      ((StringBuilder)localObject1).append(i);
      QLog.i("MayknowRecommendManager", 1, String.format(((StringBuilder)localObject1).toString(), new Object[0]));
      ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMayKnowRecommend(null, null, i, ???);
      return true;
    case 4: 
      i = ???.arg1;
      j = ???.arg2;
      ??? = (Bundle)???.obj;
      MayknowRecommendManager.b(this.a, j);
      localObject1 = (byte[])MayknowRecommendManager.i(this.a).get(Integer.valueOf(j));
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject4 = (Boolean)MayknowRecommendManager.j(this.a).get(Integer.valueOf(j));
        if ((localObject4 != null) && (((Boolean)localObject4).booleanValue() == true))
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ???.append("getConnectionsPersonRemoteNextPage requesting ");
            ???.append(j);
            QLog.d("MayknowRecommendManager", 2, ???.toString());
            return true;
          }
        }
        else
        {
          MayknowRecommendManager.j(this.a).put(Integer.valueOf(j), Boolean.valueOf(true));
          ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(i, j, (byte[])localObject1, false, ???);
          return true;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage no cookie! no need to request");
        return true;
      }
      break;
    case 3: 
      j = ???.arg1;
      int k = ???.arg2;
      localObject1 = (Bundle)???.obj;
      MayknowRecommendManager.a(this.a, k);
      synchronized (MayknowRecommendManager.g(this.a))
      {
        localObject4 = (ArrayList)MayknowRecommendManager.h(this.a).get(Integer.valueOf(k));
        if ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())) {
          i = 1;
        }
        if (i == 0) {
          bool = this.a.h(j);
        } else {
          bool = true;
        }
        if (bool)
        {
          ((FriendListHandler)MayknowRecommendManager.c(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(j, k, null, true, (Bundle)localObject1);
          return true;
        }
      }
    case 2: 
      MayknowRecommendManager.b(this.a).removeMessages(2);
      if (MayknowRecommendManager.c(this.a).mAutomator.f() == 1)
      {
        MayknowRecommendManager.d(this.a);
        return true;
      }
      synchronized (MayknowRecommendManager.e(this.a))
      {
        if (!MayknowRecommendManager.f(this.a)) {
          MayknowRecommendManager.b(this.a).sendEmptyMessageDelayed(2, 5000L);
        }
        return true;
      }
    case 1: 
      MayknowRecommendManager.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */