package com.tencent.mobileqq.app;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
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
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MayknowRecommendManager", 2, "handleMessage msg.what = " + ???.what);
    }
    int j;
    int k;
    Bundle localBundle;
    switch (???.what)
    {
    default: 
      return true;
    case 1: 
      MayknowRecommendManager.a(this.a);
      return true;
    case 2: 
      MayknowRecommendManager.a(this.a).removeMessages(2);
      if (MayknowRecommendManager.a(this.a).mAutomator.a() == 1)
      {
        MayknowRecommendManager.b(this.a);
        return true;
      }
      synchronized (MayknowRecommendManager.a(this.a))
      {
        if (!MayknowRecommendManager.a(this.a)) {
          MayknowRecommendManager.a(this.a).sendEmptyMessageDelayed(2, 5000L);
        }
        return true;
      }
    case 3: 
      j = ???.arg1;
      k = ???.arg2;
      localBundle = (Bundle)???.obj;
      MayknowRecommendManager.a(this.a, k);
    }
    for (;;)
    {
      Object localObject3;
      synchronized (MayknowRecommendManager.b(this.a))
      {
        localObject3 = (ArrayList)MayknowRecommendManager.a(this.a).get(Integer.valueOf(k));
        if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
          i = 1;
        }
        if (i != 0) {
          break label759;
        }
        bool = this.a.b(j);
        if (!bool) {
          break;
        }
        ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(j, k, null, true, localBundle);
        return true;
      }
      i = ???.arg1;
      j = ???.arg2;
      ??? = (Bundle)???.obj;
      MayknowRecommendManager.b(this.a, j);
      byte[] arrayOfByte = (byte[])MayknowRecommendManager.a(this.a).get(Integer.valueOf(j));
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        localObject3 = (Boolean)MayknowRecommendManager.b(this.a).get(Integer.valueOf(j));
        if ((localObject3 != null) && (((Boolean)localObject3).booleanValue() == true))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage requesting " + j);
          return true;
        }
        MayknowRecommendManager.b(this.a).put(Integer.valueOf(j), Boolean.valueOf(true));
        ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(i, j, arrayOfByte, false, ???);
        return true;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage no cookie! no need to request");
      return true;
      i = ???.arg1;
      ??? = (Bundle)???.obj;
      QLog.i("MayknowRecommendManager", 1, String.format("getMayKnowRecommendRemote, real start, entryType = " + i, new Object[0]));
      ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMayKnowRecommend(null, null, i, ???);
      return true;
      ??? = (String)???.obj;
      MayknowRecommendManager.a(this.a).delete(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(???) });
      return true;
      this.a.f();
      return true;
      ??? = (String)???.obj;
      this.a.a(???, true);
      ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(107, true, null);
      return true;
      ??? = (Bundle)???.obj;
      boolean bool = ???.getBoolean("key_is_success");
      ??? = ???.getString("key_req_uin");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "isSuccess :" + bool + " onAddReqStatesChanged: " + ???);
      }
      this.a.a(???, true);
      ((FriendListHandler)MayknowRecommendManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(107, true, null);
      return true;
      label759:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.1
 * JD-Core Version:    0.7.0.1
 */