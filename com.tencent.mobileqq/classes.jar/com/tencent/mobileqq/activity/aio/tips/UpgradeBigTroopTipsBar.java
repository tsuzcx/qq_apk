package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class UpgradeBigTroopTipsBar
  implements View.OnClickListener, TipsBarTask
{
  public static String a;
  private Context jdField_a_of_type_AndroidContentContext;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://imgcache.qq.com/club/client/group/release/index.html?_bid=199&groupId=";
  }
  
  public UpgradeBigTroopTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
  }
  
  public int a()
  {
    return 25;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558694, null);
    paramVarArgs.setOnClickListener(this);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 21;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeBigTroopTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", jdField_a_of_type_JavaLangString + this.b + "&from=aio");
      localIntent.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.b, 3);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_up", "", "Grp_AIO", "clk", 0, 0, this.b, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.UpgradeBigTroopTipsBar
 * JD-Core Version:    0.7.0.1
 */