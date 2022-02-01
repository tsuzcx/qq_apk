package com.tencent.mobileqq.activity.aio.core;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import mqq.os.MqqHandler;

public abstract class BaseAIOContext
{
  @NonNull
  protected BaseSessionInfo a;
  
  @NonNull
  public BaseSessionInfo a()
  {
    return this.a;
  }
  
  public abstract <T extends IHelper> T a(int paramInt);
  
  public abstract PanelManager a();
  
  public abstract MqqHandler a();
  
  public abstract boolean a(int paramInt);
  
  public abstract int b();
  
  public abstract void b(int paramInt);
  
  public abstract int e();
  
  public abstract void f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseAIOContext
 * JD-Core Version:    0.7.0.1
 */