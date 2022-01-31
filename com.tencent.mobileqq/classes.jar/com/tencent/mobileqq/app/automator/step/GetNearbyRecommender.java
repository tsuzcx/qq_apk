package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import zns;

public class GetNearbyRecommender
  extends AsyncStep
{
  private zns a;
  
  protected int a()
  {
    Object localObject1 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getCurrentAccountUin());
    long l5 = 0L;
    long l4 = 0L;
    int n = 0;
    long l6 = 0L;
    int k = 0;
    int i = 0;
    if (localObject1 == null)
    {
      if (this.jdField_a_of_type_Zns == null) {
        this.jdField_a_of_type_Zns = new zns(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.addObserver(this.jdField_a_of_type_Zns, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetNearbyRecommender doStep|RESULT_WAITING");
      }
      return 2;
    }
    int i1 = ((Card)localObject1).age;
    int m = k;
    long l3 = l6;
    long l2;
    long l1;
    int j;
    Object localObject2;
    if (i1 >= 18)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
      l2 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      l1 = System.currentTimeMillis();
      if ((l2 != 0L) && (86400L > Math.abs(l1 - l2) / 1000L)) {
        break label713;
      }
      i = 2;
      j = ((SharedPreferences)localObject1).getInt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getCurrentAccountUin() + "_" + "key_login_pull_interval", 86400);
      l6 = ((SharedPreferences)localObject1).getLong(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getCurrentAccountUin() + "_" + "key_login_pull_time", 0L);
      if (l6 != 0L)
      {
        m = k;
        l3 = l6;
        n = j;
        l4 = l2;
        l5 = l1;
        if (j > Math.abs(l1 - l6) / 1000L) {}
      }
      else
      {
        i = 3;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a();
        k = ((QQMessageFacade)localObject1).b();
        m = ((QQMessageFacade)localObject1).d();
        k -= m;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "GetNearbyRecommender doStep|unreadnum|unReadMsgNum=" + k + ",paUnreaded=" + m);
        }
        m = k;
        l3 = l6;
        n = j;
        l4 = l2;
        l5 = l1;
        if (k <= 0)
        {
          i = 4;
          localObject2 = SosoInterface.a();
          if ((localObject2 != null) && (((SosoInterface.SosoLbsInfo)localObject2).a != null) && (((SosoInterface.SosoLbsInfo)localObject2).a.c != 0.0D))
          {
            localObject1 = localObject2;
            if (((SosoInterface.SosoLbsInfo)localObject2).a.d != 0.0D) {}
          }
          else
          {
            SosoInterface.a(60000L, getClass().getSimpleName());
            localObject1 = SosoInterface.a();
          }
          if (localObject1 != null)
          {
            ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(3)).a(0);
            m = 5;
            i = k;
            l3 = l2;
            l2 = l1;
            l1 = l3;
            l3 = l6;
            k = j;
            j = i;
            i = m;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("GetNearbyRecommender doStep|age=").append(i1).append(",currentTime=").append(l2).append(",enter_nearby_time=").append(l1).append(",login_pull_interval=").append(k).append(",login_pull_time=").append(l3).append(",unReadMsgNum=").append(j).append(",lbsInfo=");
        if (localObject1 == null) {
          break label660;
        }
      }
      label660:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("QQInitHandler", 2, bool + ",step=" + i);
        return 7;
      }
      m = j;
      l4 = l1;
      j = k;
      k = m;
      l3 = l6;
      l1 = l2;
      l2 = l4;
      continue;
      localObject1 = null;
      j = m;
      k = n;
      l1 = l4;
      l2 = l5;
      continue;
      label713:
      i = 1;
      localObject1 = null;
      j = 0;
      k = 0;
      l4 = l1;
      l3 = l6;
      l1 = l2;
      l2 = l4;
    }
  }
  
  public void a()
  {
    NearbyRecommenderUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
    this.c = 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Zns != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.removeObserver(this.jdField_a_of_type_Zns);
      this.jdField_a_of_type_Zns = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNearbyRecommender
 * JD-Core Version:    0.7.0.1
 */