package com.tencent.mobileqq.activity.qqsettingme;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeProfileBubbleBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.DefaultRedPointPrePostHandler;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.oidb.redInfo.RedInfo;

public class QQSettingMeProfileBubbleProcessor
  extends QQSettingMeBaseProcessor
{
  public MutableLiveData<QQSettingMeProfileBubbleBean> a = new MutableLiveData(new QQSettingMeProfileBubbleBean());
  private boolean b;
  private boolean i;
  
  @NonNull
  private QQSettingMeProfileBubbleBean a()
  {
    if (this.a.getValue() == null) {
      return new QQSettingMeProfileBubbleBean();
    }
    return (QQSettingMeProfileBubbleBean)this.a.getValue();
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeProfileBubbleProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.c = paramAppRuntime;
    if (this.b) {
      i();
    }
  }
  
  public String b()
  {
    return "d_profile_bubble";
  }
  
  public void d()
  {
    super.d();
    i();
    this.b = true;
  }
  
  public void e()
  {
    super.e();
    this.i = false;
  }
  
  public void h()
  {
    i();
  }
  
  public void i()
  {
    QQSettingMeProfileBubbleBean localQQSettingMeProfileBubbleBean = new QQSettingMeProfileBubbleBean();
    Object localObject1 = (LocalRedTouchManager)this.c.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject1).a(-4);
    boolean bool;
    if ((((LocalRedTouchManager)localObject1).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMeProfileBubbleBean.a = bool;
    if (localQQSettingMeProfileBubbleBean.a)
    {
      localQQSettingMeProfileBubbleBean.b = localRedTouchItem.count;
      localQQSettingMeProfileBubbleBean.d = ((LocalRedTouchManager)localObject1).a(10028);
      ProfileCardUtil.c((QQAppInterface)this.c);
      redInfo.RedInfo localRedInfo = new redInfo.RedInfo();
      Object localObject2;
      if ((((LocalRedTouchManager)localObject1).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
      {
        try
        {
          localObject1 = FileUtils.readObject(DefaultRedPointPrePostHandler.a(-4));
          if ((localObject1 instanceof RedTouchItemExtMsg)) {
            localRedInfo.mergeFrom(((RedTouchItemExtMsg)localObject1).bytesData);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QQSettingRedesign", 2, localException.getMessage(), localException);
          }
        }
        localObject2 = localRedInfo;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("updateProfileBubbleMsgInfo red point: ");
          ((StringBuilder)localObject2).append(localRedTouchItem.redtouchType);
          QLog.d("QQSettingRedesign", 2, ((StringBuilder)localObject2).toString());
          localObject2 = localRedInfo;
        }
      }
      else
      {
        localObject2 = null;
      }
      localQQSettingMeProfileBubbleBean.c = ((redInfo.RedInfo)localObject2);
      localQQSettingMeProfileBubbleBean.e = ImageUtil.a(true);
    }
    if ((localQQSettingMeProfileBubbleBean.a) && (localQQSettingMeProfileBubbleBean.c != null) && (!this.i))
    {
      if ((localQQSettingMeProfileBubbleBean.d != null) && (localQQSettingMeProfileBubbleBean.d.count > 0) && (localQQSettingMeProfileBubbleBean.d.unReadFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgExpose");
        }
        ReportController.b(this.c, "dc00898", "", "", "0X800B47F", "0X800B47F", 0, 0, "", "", "", "");
      }
      ReportController.b(this.c, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
      this.i = true;
    }
    this.a.setValue(localQQSettingMeProfileBubbleBean);
  }
  
  public void onClick(View paramView)
  {
    paramView = a().d;
    if ((paramView != null) && (paramView.count > 0) && (paramView.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgClick");
      }
      ReportController.b(this.c, "dc00898", "", "", "0X800B480", "0X800B480", 0, 0, "", "", "", "");
    }
    ProfileCardUtil.c(this.d);
    ReportController.b(this.c, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeProfileBubbleProcessor
 * JD-Core Version:    0.7.0.1
 */