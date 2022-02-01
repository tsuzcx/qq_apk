import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.RecentRecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

class anyc
  implements Handler.Callback
{
  anyc(anyb paramanyb) {}
  
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
      anyb.a(this.a);
      return true;
    case 2: 
      anyb.a(this.a).removeMessages(2);
      if (anyb.a(this.a).mAutomator.a() == 1)
      {
        anyb.b(this.a);
        return true;
      }
      synchronized (anyb.a(this.a))
      {
        if (!anyb.a(this.a)) {
          anyb.a(this.a).sendEmptyMessageDelayed(2, 5000L);
        }
        return true;
      }
    case 3: 
      j = ???.arg1;
      k = ???.arg2;
      localBundle = (Bundle)???.obj;
      anyb.a(this.a, k);
    }
    for (;;)
    {
      Object localObject3;
      synchronized (anyb.b(this.a))
      {
        localObject3 = (ArrayList)anyb.a(this.a).get(Integer.valueOf(k));
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
        ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(j, k, null, true, localBundle);
        return true;
      }
      i = ???.arg1;
      j = ???.arg2;
      ??? = (Bundle)???.obj;
      anyb.b(this.a, j);
      byte[] arrayOfByte = (byte[])anyb.a(this.a).get(Integer.valueOf(j));
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        localObject3 = (Boolean)anyb.b(this.a).get(Integer.valueOf(j));
        if ((localObject3 != null) && (((Boolean)localObject3).booleanValue() == true))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage requesting " + j);
          return true;
        }
        anyb.b(this.a).put(Integer.valueOf(j), Boolean.valueOf(true));
        ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getConnectionsPerson(i, j, arrayOfByte, false, ???);
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
      ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getMayKnowRecommend(null, null, i, ???);
      return true;
      ??? = (String)???.obj;
      anyb.a(this.a).delete(RecentRecommendTroopItem.class.getSimpleName(), "uin=?", new String[] { String.valueOf(???) });
      return true;
      this.a.f();
      return true;
      ??? = (String)???.obj;
      this.a.a(???, true);
      ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(108, true, null);
      return true;
      ??? = (Bundle)???.obj;
      boolean bool = ???.getBoolean("key_is_success");
      ??? = ???.getString("key_req_uin");
      if (QLog.isColorLevel()) {
        QLog.d("MayknowRecommendManager", 2, "isSuccess :" + bool + " onAddReqStatesChanged: " + ???);
      }
      this.a.a(???, true);
      ((FriendListHandler)anyb.a(this.a).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(108, true, null);
      return true;
      label759:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyc
 * JD-Core Version:    0.7.0.1
 */