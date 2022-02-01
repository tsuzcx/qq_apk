package com.qwallet.temp.impl;

import android.view.View;
import android.view.ViewGroup;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.XBaseAdapter;

public class BaseChatPieProxy
  implements IBaseChatPieProxy
{
  private BaseChatPie a;
  
  public BaseChatPieProxy(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public int a()
  {
    return this.a.d();
  }
  
  public View a()
  {
    return a().findViewById(2131376636);
  }
  
  public ViewGroup a()
  {
    return this.a.c;
  }
  
  public IQWalletAIOLifeCycleHelper a()
  {
    return (IQWalletAIOLifeCycleHelper)this.a.a(27);
  }
  
  public BaseQQAppInterface a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public BaseSessionInfo a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public PanelManager a()
  {
    return this.a.a();
  }
  
  public QBaseActivity a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  public XBaseAdapter a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1;
  }
  
  public int b()
  {
    return this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.BaseChatPieProxy
 * JD-Core Version:    0.7.0.1
 */