package com.tencent.mobileqq.activity.aio.audiopanel;

import android.os.Handler;
import com.tencent.mvp.IBasePresenterView;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public abstract interface ICommonRecordSoundPanelView
  extends IBasePresenterView
{
  public abstract void a(String paramString);
  
  public abstract void b(int paramInt);
  
  public abstract void b(String paramString);
  
  public abstract void e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract AppRuntime getApp();
  
  public abstract Handler getCallBack();
  
  public abstract AppActivity getViewContext();
  
  public abstract void setRecordTime(String paramString);
  
  public abstract void setRequestedOrientation4Recording(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ICommonRecordSoundPanelView
 * JD-Core Version:    0.7.0.1
 */