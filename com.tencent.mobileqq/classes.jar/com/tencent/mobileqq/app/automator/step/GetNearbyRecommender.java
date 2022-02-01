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
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GetNearbyRecommender
  extends AsyncStep
{
  private GetNearbyRecommender.MyCardObserver a;
  
  protected int doStep()
  {
    Object localObject1 = ((FriendsManager)this.mAutomator.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.mAutomator.a.getCurrentAccountUin());
    int i = 1;
    if (localObject1 == null)
    {
      if (this.a == null) {
        this.a = new GetNearbyRecommender.MyCardObserver(this);
      }
      this.mAutomator.a.addObserver(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "GetNearbyRecommender doStep|RESULT_WAITING");
      }
      return 2;
    }
    int i1 = ((Card)localObject1).age;
    localObject1 = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
    int j = 0;
    long l2;
    long l3;
    long l1;
    if (i1 >= 18)
    {
      localObject1 = this.mAutomator.a.getApplication();
      Object localObject2 = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
      localObject1 = ((MobileQQ)localObject1).getSharedPreferences("sp_nearbyrecommender", 0);
      l2 = ((Long)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.mAutomator.a.getAccount(), "nearby_enter_time", Long.valueOf(0L))).longValue();
      l3 = System.currentTimeMillis();
      if ((l2 != 0L) && (86400L > Math.abs(l3 - l2) / 1000L))
      {
        l1 = 0L;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mAutomator.a.getCurrentAccountUin());
        ((StringBuilder)localObject2).append("_");
        INearbyRecommenderUtils localINearbyRecommenderUtils = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
        ((StringBuilder)localObject2).append("key_login_pull_interval");
        localObject2 = ((StringBuilder)localObject2).toString();
        localINearbyRecommenderUtils = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
        j = ((SharedPreferences)localObject1).getInt((String)localObject2, 86400);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.mAutomator.a.getCurrentAccountUin());
        ((StringBuilder)localObject2).append("_");
        localINearbyRecommenderUtils = (INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class);
        ((StringBuilder)localObject2).append("key_login_pull_time");
        l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
        if ((l1 != 0L) && (j > Math.abs(l3 - l1) / 1000L))
        {
          i = 2;
        }
        else
        {
          i = 3;
          localObject1 = this.mAutomator.a.getMessageFacade();
          m = ((QQMessageFacade)localObject1).b();
          k = ((QQMessageFacade)localObject1).e();
          int n = m - k;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("GetNearbyRecommender doStep|unreadnum|unReadMsgNum=");
            ((StringBuilder)localObject1).append(n);
            ((StringBuilder)localObject1).append(",paUnreaded=");
            ((StringBuilder)localObject1).append(k);
            QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
          }
          l6 = l1;
          m = j;
          k = n;
          l5 = l2;
          l4 = l3;
          if (n > 0) {
            break label629;
          }
          i = 4;
          l6 = l1;
          m = j;
          k = n;
          l5 = l2;
          l4 = l3;
          if (!((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).isLastLocationSuccess()) {
            break label629;
          }
          i = 5;
          ((LBSHandler)this.mAutomator.a.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER)).a(0);
          l6 = l1;
          m = j;
          k = n;
          l5 = l2;
          l4 = l3;
          break label629;
        }
      }
    }
    else
    {
      l1 = 0L;
      l2 = l1;
      l3 = l2;
      i = 0;
      j = 0;
    }
    int k = 0;
    long l4 = l3;
    long l5 = l2;
    int m = j;
    long l6 = l1;
    label629:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetNearbyRecommender doStep|age=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(",currentTime=");
      ((StringBuilder)localObject1).append(l4);
      ((StringBuilder)localObject1).append(",enter_nearby_time=");
      ((StringBuilder)localObject1).append(l5);
      ((StringBuilder)localObject1).append(",login_pull_interval=");
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append(",login_pull_time=");
      ((StringBuilder)localObject1).append(l6);
      ((StringBuilder)localObject1).append(",unReadMsgNum=");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(",lbsInfo=");
      ((StringBuilder)localObject1).append(false);
      ((StringBuilder)localObject1).append(",step=");
      ((StringBuilder)localObject1).append(i);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject1).toString());
    }
    return 7;
  }
  
  public void onCreate()
  {
    ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).checkExpireTime(this.mAutomator.a);
    this.mCountRetry = 1;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.a.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetNearbyRecommender
 * JD-Core Version:    0.7.0.1
 */