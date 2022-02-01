package com.tencent.mobileqq.activity.aio.tips;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.BaseApplication;

public class GamePartyTipsBar
  implements TipsBarTask
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public GamePartyTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558690, null);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramVarArgs.findViewById(2131362563));
    a();
    paramVarArgs.setOnClickListener(new GamePartyTipsBar.1(this));
    ReportCenter.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "", "", "2000", "2015", "0", false);
    return paramVarArgs;
  }
  
  public void a()
  {
    Object localObject = (GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER);
    if (((GamePartyManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = ((GamePartyManager)localObject).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Int = ((GamePartyManager)localObject).jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = ((GamePartyManager)localObject).c;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((GamePartyManager)localObject).jdField_b_of_type_JavaLangString)) {
        break label173;
      }
      if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int) {
        break label157;
      }
      localObject = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692851), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) });
    }
    Looper localLooper;
    for (;;)
    {
      localLooper = Looper.getMainLooper();
      if (Thread.currentThread() != localLooper.getThread()) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
      label157:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692849);
      continue;
      label173:
      if ((((GamePartyManager)localObject).e == 3) || (((GamePartyManager)localObject).e == 4)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692853);
      } else if (this.jdField_a_of_type_Int < this.jdField_b_of_type_Int) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692852);
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692850);
      }
    }
    new Handler(localLooper).post(new GamePartyTipsBar.2(this, (String)localObject));
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    while (!((GamePartyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.GamePartyTipsBar
 * JD-Core Version:    0.7.0.1
 */