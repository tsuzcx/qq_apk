package com.tencent.biz.pubaccount.readinjoy.engine;

import ajjj;
import alof;
import amnz;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nrt;
import ors;

public class KandianSubscribeManager$MsgBoxSetTopInfo
  implements Serializable
{
  public static final String SP_KEY = "kandian_subscribe_settop_info_key";
  public boolean allowSettop;
  public long lastSetTopTimeMillis;
  public int setTopPosition;
  public int setTopStartTime;
  
  private Pair<Integer, Long> a(int paramInt)
  {
    Pair localPair = new Pair(Integer.valueOf(-1), Long.valueOf(-1L));
    int j = ors.a;
    Object localObject1 = new ArrayList();
    label300:
    label331:
    label334:
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        Object localObject2 = ajjj.a().a;
        if (localObject2 == null) {
          return localPair;
        }
        ((List)localObject1).addAll((Collection)localObject2);
        localObject2 = ((List)localObject1).iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (RecentBaseData)((Iterator)localObject2).next();
          if (!(localObject3 instanceof RecentUserBaseData))
          {
            ((Iterator)localObject2).remove();
            break label334;
          }
          if (!alof.aR.equals(((RecentBaseData)localObject3).a())) {
            break label331;
          }
          i = 1;
          break label334;
        }
        if ((i == 0) || (((List)localObject1).isEmpty()))
        {
          QLog.d(KandianSubscribeManager.a, 2, "has not kandian subscribe recent user, give settop");
          return localPair;
        }
        int k = ((List)localObject1).size();
        i = 0;
        if (i < k)
        {
          localObject2 = (RecentBaseData)((List)localObject1).get(i);
          localObject3 = (RecentUserBaseData)localObject2;
          if (TextUtils.equals(((RecentUserBaseData)localObject3).a(), alof.aR))
          {
            if (i < j)
            {
              QLog.d(KandianSubscribeManager.a, 2, "subscribePos is in screen, give up setTop");
              return localPair;
            }
            if (paramInt != 0)
            {
              QLog.d(KandianSubscribeManager.a, 2, "settop pos is > ori pos, give up");
              return localPair;
            }
          }
          else
          {
            if (paramInt != 0) {
              break label300;
            }
            localObject1 = new Pair(Integer.valueOf(i), Long.valueOf(1L + ((RecentBaseData)localObject2).mDisplayTime));
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d(KandianSubscribeManager.a, 2, "get settop info has error " + localException);
      }
      return localPair;
      long l = ((RecentUserBaseData)localObject3).a().showUpTime;
      if (l == 0L) {
        paramInt -= 1;
      }
      for (;;)
      {
        i += 1;
        break;
      }
    }
  }
  
  private boolean a()
  {
    if (!this.allowSettop) {}
    long l;
    do
    {
      return false;
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      l = localCalendar.getTimeInMillis() / 1000L;
    } while ((System.currentTimeMillis() / 1000L - l < this.setTopStartTime) || (this.lastSetTopTimeMillis > l * 1000L));
    return true;
  }
  
  public String toString()
  {
    return "MsgBoxSetTopInfo{setTopStartTime=" + this.setTopStartTime + ", setTopPosition=" + this.setTopPosition + ", lastSetTopTimeMillis=" + this.lastSetTopTimeMillis + ", allowSettop=" + this.allowSettop + '}';
  }
  
  public void tryToSetTop()
  {
    if (!a()) {}
    Pair localPair;
    QQAppInterface localQQAppInterface;
    amnz localamnz;
    RecentUser localRecentUser;
    do
    {
      do
      {
        do
        {
          return;
          localPair = a(this.setTopPosition);
        } while ((((Integer)localPair.first).intValue() < 0) || (((Long)localPair.second).longValue() < 0L));
        localQQAppInterface = (QQAppInterface)ors.a();
        localObject = localQQAppInterface.a().b(alof.aR, 1008);
      } while ((localObject == null) || (((MessageRecord)localObject).isread));
      localamnz = localQQAppInterface.a().a();
      localRecentUser = localamnz.b(alof.aR, 1008);
    } while (localRecentUser == null);
    localRecentUser.lastmsgtime = ((Long)localPair.second).longValue();
    ((MessageRecord)localObject).time = ((Long)localPair.second).longValue();
    localQQAppInterface.a().a(alof.aR, 1008, ((MessageRecord)localObject).uniseq, "time", Long.valueOf(((MessageRecord)localObject).time));
    localamnz.a(localRecentUser);
    Object localObject = localQQAppInterface.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1009);
    }
    this.lastSetTopTimeMillis = System.currentTimeMillis();
    ors.a("kandian_subscribe_settop_info_key", this, true);
    QLog.d(KandianSubscribeManager.a, 1, "settop successful! pos : " + localPair.first + ", msgtime : " + localPair.second);
    nrt.a(localQQAppInterface, "CliOper", "", "", "0X80097D5", "0X80097D5", 0, 1, String.valueOf(localPair.first), null, null, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager.MsgBoxSetTopInfo
 * JD-Core Version:    0.7.0.1
 */