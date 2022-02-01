package com.tencent.mobileqq.banner.processor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.banner.Banner;
import mqq.app.AppRuntime;

public abstract interface IBannerProcessor
{
  public abstract int a();
  
  public abstract View a(Banner paramBanner);
  
  public abstract void a();
  
  public abstract void a(Message paramMessage, long paramLong, boolean paramBoolean);
  
  public abstract void a(Banner paramBanner, Message paramMessage);
  
  public abstract int b();
  
  public abstract void b(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.processor.IBannerProcessor
 * JD-Core Version:    0.7.0.1
 */