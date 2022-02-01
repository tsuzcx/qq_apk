package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TimTipsBar
  implements View.OnClickListener, TipsBarTask
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public TimTipsBar(QQAppInterface paramQQAppInterface, Context paramContext, TipsManager paramTipsManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
  }
  
  public int a()
  {
    return 5;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a();
    this.jdField_a_of_type_JavaLangString = paramVarArgs.tipsUrl;
    paramVarArgs = paramVarArgs.tipsMsg;
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558693, null);
    ((TextView)localView.findViewById(2131362582)).setText(paramVarArgs);
    localView.setOnClickListener(this);
    localView.findViewById(2131362580).setOnClickListener(this);
    return localView;
  }
  
  public void a(int paramInt, Object... paramVarArgs) {}
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 18;
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
        QLog.d("TimTipsBar", 2, "click tips, jump");
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      ReportController.b(null, "dc00898", "", "", "0X8008948", "0X8008948", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TimTipsBar
 * JD-Core Version:    0.7.0.1
 */