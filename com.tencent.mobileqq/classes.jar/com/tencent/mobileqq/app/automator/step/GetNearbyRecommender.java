package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GetNearbyRecommender
  extends AsyncStep
{
  private GetNearbyRecommender.MyCardObserver a;
  
  public int a()
  {
    Object localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getCurrentAccountUin());
    long l2 = 0L;
    long l1 = 0L;
    int k = 0;
    int m = 0;
    long l6 = 0L;
    int n = 0;
    int i1 = 0;
    int i = 0;
    if (localObject == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver = new GetNearbyRecommender.MyCardObserver(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetNearbyRecommender doStep|RESULT_WAITING");
      }
      return 2;
    }
    int i2 = ((Card)localObject).age;
    int j = n;
    long l3 = l6;
    long l4;
    if (i2 >= 18)
    {
      i = 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
      l4 = ((Long)NearbySPUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      long l5 = System.currentTimeMillis();
      if (l4 != 0L)
      {
        j = i1;
        k = m;
        l1 = l6;
        if (86400L > Math.abs(l5 - l4) / 1000L) {}
      }
      else
      {
        i = 2;
        m = ((SharedPreferences)localObject).getInt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getCurrentAccountUin() + "_" + "key_login_pull_interval", 86400);
        l6 = ((SharedPreferences)localObject).getLong(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getCurrentAccountUin() + "_" + "key_login_pull_time", 0L);
        if (l6 != 0L)
        {
          j = n;
          k = m;
          l3 = l6;
          l1 = l4;
          l2 = l5;
          if (m > Math.abs(l5 - l6) / 1000L) {
            break label635;
          }
        }
        i = 3;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getMessageFacade();
        k = ((QQMessageFacade)localObject).b();
        j = ((QQMessageFacade)localObject).e();
        n = k - j;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "GetNearbyRecommender doStep|unreadnum|unReadMsgNum=" + n + ",paUnreaded=" + j);
        }
        j = n;
        k = m;
        l3 = l6;
        l1 = l4;
        l2 = l5;
        if (n > 0) {
          break label635;
        }
        i = 4;
        j = n;
        k = m;
        l1 = l6;
        if (((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).isLastLocationSuccess())
        {
          i = 5;
          ((LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(0);
          l1 = l6;
          k = m;
          j = n;
        }
      }
      l2 = l5;
      l3 = l1;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("GetNearbyRecommender doStep|age=").append(i2).append(",currentTime=").append(l2).append(",enter_nearby_time=").append(l4).append(",login_pull_interval=").append(k).append(",login_pull_time=").append(l3).append(",unReadMsgNum=").append(j).append(",lbsInfo=");
        if (0 == 0) {
          break label629;
        }
      }
      label629:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("QQInitHandler", 2, bool + ",step=" + i);
        return 7;
      }
      label635:
      l4 = l1;
    }
  }
  
  public void b()
  {
    NearbyRecommenderUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
    this.c = 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepGetNearbyRecommender$MyCardObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNearbyRecommender
 * JD-Core Version:    0.7.0.1
 */