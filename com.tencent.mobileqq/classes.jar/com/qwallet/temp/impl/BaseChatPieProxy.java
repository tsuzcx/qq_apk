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
  
  public BaseQQAppInterface a()
  {
    return this.a.d;
  }
  
  public QBaseActivity b()
  {
    return this.a.f;
  }
  
  public PanelManager c()
  {
    return this.a.bq();
  }
  
  public ViewGroup d()
  {
    return this.a.aZ;
  }
  
  public BaseSessionInfo e()
  {
    return this.a.ah;
  }
  
  public IQWalletAIOLifeCycleHelper f()
  {
    return (IQWalletAIOLifeCycleHelper)this.a.q(27);
  }
  
  public int g()
  {
    return this.a.bb();
  }
  
  public XBaseAdapter h()
  {
    return this.a.V;
  }
  
  public int i()
  {
    return this.a.A();
  }
  
  public View j()
  {
    return b().findViewById(2131444897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.BaseChatPieProxy
 * JD-Core Version:    0.7.0.1
 */