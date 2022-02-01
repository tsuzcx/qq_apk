package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar
  implements TipsBarTask
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopAssistTipsBar.2(this);
  private BaseSessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public TroopAioTips a;
  private boolean jdField_a_of_type_Boolean = false;
  private View.OnClickListener b = new TroopAssistTipsBar.3(this);
  
  public TroopAssistTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, BaseActivity paramBaseActivity, BaseSessionInfo paramBaseSessionInfo, TroopAioTips paramTroopAioTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo = paramBaseSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips = paramTroopAioTips;
  }
  
  public int a()
  {
    return 20;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720047);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString) == 3) {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131720048);
    }
    View localView = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramVarArgs, this.b, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "AIOchat", "exp_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopMask(this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString) == 3) {
      paramVarArgs = "1";
    } else {
      paramVarArgs = "0";
    }
    ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "exp_topbar", 0, 0, str, paramVarArgs, "", "");
    return localView;
  }
  
  public void a()
  {
    if ((a()) || (this.jdField_a_of_type_Boolean)) {
      TroopAssistantManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseSessionInfo.jdField_a_of_type_Int != 1) {
      return;
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips;
    if ((paramVarArgs != null) && (paramVarArgs.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistTipsBar", 2, "navigateBar is show, return ");
      }
      return;
    }
    ThreadManager.post(new TroopAssistTipsBar.1(this), 8, null, true);
  }
  
  public boolean a()
  {
    return 3 == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar
 * JD-Core Version:    0.7.0.1
 */