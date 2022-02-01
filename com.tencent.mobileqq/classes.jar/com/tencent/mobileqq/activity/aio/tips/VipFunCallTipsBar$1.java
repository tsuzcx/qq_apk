package com.tencent.mobileqq.activity.aio.tips;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VipFunCallTipsBar$1
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  VipFunCallTipsBar$1(VipFunCallTipsBar paramVipFunCallTipsBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      Object localObject = new Intent(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("hide_left_button", false);
      ((Intent)localObject).putExtra("show_right_close_button", false);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      String str = IndividuationUrlHelper.a(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), "call", "mvip.gongneng.anroid.individuation.web");
      VasWebviewUtil.openQQBrowserWithoutAD(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), str, 524288L, (Intent)localObject, false, -1);
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      ((SharedPreferences.Editor)localObject).putInt("funcall_tip_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_JavaLangString, 4);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar.1
 * JD-Core Version:    0.7.0.1
 */