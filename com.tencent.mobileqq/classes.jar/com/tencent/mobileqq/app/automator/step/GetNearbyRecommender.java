package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import anvk;
import anxi;
import aoip;
import axqc;
import ayoa;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GetNearbyRecommender
  extends AsyncStep
{
  private aoip a;
  
  public int a()
  {
    Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin());
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
      if (this.jdField_a_of_type_Aoip == null) {
        this.jdField_a_of_type_Aoip = new aoip(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Aoip, true);
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
      k = 1;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApplication().getSharedPreferences("sp_nearbyrecommender", 0);
      l4 = ((Long)axqc.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      long l5 = System.currentTimeMillis();
      if (l4 != 0L)
      {
        j = i1;
        i = m;
        l1 = l6;
        if (86400L > Math.abs(l5 - l4) / 1000L) {}
      }
      else
      {
        i = 2;
        m = ((SharedPreferences)localObject).getInt(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin() + "_" + "key_login_pull_interval", 86400);
        l6 = ((SharedPreferences)localObject).getLong(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getCurrentAccountUin() + "_" + "key_login_pull_time", 0L);
        if (l6 != 0L)
        {
          j = n;
          k = m;
          l3 = l6;
          l1 = l4;
          l2 = l5;
          if (m > Math.abs(l5 - l6) / 1000L) {
            break label639;
          }
        }
        i = 3;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getMessageFacade();
        k = ((QQMessageFacade)localObject).getUnreadMsgsNum();
        j = ((QQMessageFacade)localObject).getUnreadMsgsNumForPublicAccount();
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
          break label639;
        }
        i = 4;
        j = n;
        k = m;
        l3 = l6;
        l1 = l4;
        l2 = l5;
        if (!LbsManagerService.isLastLocationSuccess()) {
          break label639;
        }
        k = 5;
        ((anxi)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(0);
        l1 = l6;
        i = m;
        j = n;
      }
      l2 = l5;
      m = i;
      l3 = l1;
      i = k;
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("GetNearbyRecommender doStep|age=").append(i2).append(",currentTime=").append(l2).append(",enter_nearby_time=").append(l4).append(",login_pull_interval=").append(m).append(",login_pull_time=").append(l3).append(",unReadMsgNum=").append(j).append(",lbsInfo=");
        if (0 == 0) {
          break label633;
        }
      }
      label633:
      for (boolean bool = true;; bool = false)
      {
        QLog.d("QQInitHandler", 2, bool + ",step=" + i);
        return 7;
      }
      label639:
      m = k;
      l4 = l1;
    }
  }
  
  public void b()
  {
    ayoa.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    this.c = 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aoip != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Aoip);
      this.jdField_a_of_type_Aoip = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNearbyRecommender
 * JD-Core Version:    0.7.0.1
 */