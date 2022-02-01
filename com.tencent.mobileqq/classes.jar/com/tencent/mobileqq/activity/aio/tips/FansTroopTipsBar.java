package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.FansTroopUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class FansTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  View jdField_a_of_type_AndroidViewView;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FansTroopTipsBar(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    return 59;
  }
  
  public View a(Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560643, null);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public boolean a(@NonNull TipsManager paramTipsManager)
  {
    int i = paramTipsManager.a();
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, new Object[] { "show cur type=", Integer.valueOf(i) });
    }
    return i == b();
  }
  
  public boolean a(TipsManager paramTipsManager, boolean paramBoolean)
  {
    if (paramTipsManager == null) {
      return false;
    }
    boolean bool = a(paramTipsManager);
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, new Object[] { "show() isShowing=", Boolean.valueOf(bool), ", show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      if (!bool)
      {
        if (paramTipsManager.a(this, new Object[0]))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B57A", "0X800B57A", 0, 0, "", "", "", "");
          return true;
        }
        return false;
      }
    }
    else if (bool) {
      paramTipsManager.a();
    }
    return false;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 31;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FansTroopTipsBar", 2, "click tips, jump to web");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    if (localObject != null) {
      FansTroopUtils.a(this.jdField_a_of_type_AndroidAppActivity, ((SessionInfo)localObject).a);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if (localObject != null) {
      ((TroopChatPie)localObject).b().a();
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B57B", "0X800B57B", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FansTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */