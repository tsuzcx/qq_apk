package com.qwallet.temp;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.XBaseAdapter;

public abstract interface IBaseChatPieProxy
{
  public abstract BaseQQAppInterface a();
  
  public abstract QBaseActivity b();
  
  public abstract PanelManager c();
  
  public abstract ViewGroup d();
  
  public abstract BaseSessionInfo e();
  
  public abstract IQWalletAIOLifeCycleHelper f();
  
  public abstract int g();
  
  public abstract XBaseAdapter h();
  
  public abstract int i();
  
  public abstract View j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IBaseChatPieProxy
 * JD-Core Version:    0.7.0.1
 */