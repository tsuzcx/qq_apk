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
  public MutableLiveData<QQSettingMeProfileBubbleBean> a;
  private boolean b;
  private boolean c;
  
  public QQSettingMeProfileBubbleProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData(new QQSettingMeProfileBubbleBean());
  }
  
  @NonNull
  private QQSettingMeProfileBubbleBean a()
  {
    if (this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue() == null) {
      return new QQSettingMeProfileBubbleBean();
    }
    return (QQSettingMeProfileBubbleBean)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  public String a()
  {
    return "d_profile_bubble";
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeProfileBubbleProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    if (this.b) {
      g();
    }
  }
  
  public void b()
  {
    super.b();
    g();
    this.b = true;
  }
  
  public void c()
  {
    super.c();
    this.c = false;
  }
  
  public void f()
  {
    g();
  }
  
  public void g()
  {
    QQSettingMeProfileBubbleBean localQQSettingMeProfileBubbleBean = new QQSettingMeProfileBubbleBean();
    Object localObject1 = (LocalRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject1).a(-4);
    boolean bool;
    if ((((LocalRedTouchManager)localObject1).a(localRedTouchItem, true)) && (localRedTouchItem.count > 0)) {
      bool = true;
    } else {
      bool = false;
    }
    localQQSettingMeProfileBubbleBean.jdField_a_of_type_Boolean = bool;
    if (localQQSettingMeProfileBubbleBean.jdField_a_of_type_Boolean)
    {
      localQQSettingMeProfileBubbleBean.jdField_a_of_type_Int = localRedTouchItem.count;
      localQQSettingMeProfileBubbleBean.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedTouchItem = ((LocalRedTouchManager)localObject1).a(10028);
      ProfileCardUtil.b((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
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
      localQQSettingMeProfileBubbleBean.jdField_a_of_type_TencentImOidbRedInfo$RedInfo = ((redInfo.RedInfo)localObject2);
      localQQSettingMeProfileBubbleBean.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ImageUtil.a(true);
    }
    if ((localQQSettingMeProfileBubbleBean.jdField_a_of_type_Boolean) && (localQQSettingMeProfileBubbleBean.jdField_a_of_type_TencentImOidbRedInfo$RedInfo != null) && (!this.c))
    {
      if ((localQQSettingMeProfileBubbleBean.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedTouchItem != null) && (localQQSettingMeProfileBubbleBean.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedTouchItem.count > 0) && (localQQSettingMeProfileBubbleBean.jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedTouchItem.unReadFlag))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgExpose");
        }
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B47F", "0X800B47F", 0, 0, "", "", "", "");
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A97E", "0X800A97E", 0, 0, "0", "0", "", "");
      this.c = true;
    }
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeProfileBubbleBean);
  }
  
  public void onClick(View paramView)
  {
    paramView = a().jdField_a_of_type_ComTencentMobileqqNearbyRedtouchRedTouchItem;
    if ((paramView != null) && (paramView.count > 0) && (paramView.unReadFlag))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "checkAndReportAnonymousAnswerMsgClick");
      }
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800B480", "0X800B480", 0, 0, "", "", "", "");
    }
    ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A97F", "0X800A97F", 0, 0, "0", "0", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeProfileBubbleProcessor
 * JD-Core Version:    0.7.0.1
 */