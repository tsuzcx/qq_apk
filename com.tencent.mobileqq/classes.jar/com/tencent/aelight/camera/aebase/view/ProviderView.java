package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.os.Handler;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public abstract class ProviderView
  extends FrameLayout
{
  Context a;
  protected AppInterface b;
  protected int c;
  protected boolean d = true;
  protected Handler e;
  protected boolean f = false;
  protected int g = 206;
  protected ProviderView.ProviderViewListener h;
  
  public ProviderView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.e = new Handler(ThreadManager.getSubThreadLooper());
  }
  
  protected abstract int getInflateLayout();
  
  public boolean getNeedTabBar()
  {
    return this.d;
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    this.b = paramAppInterface;
  }
  
  public void setNeedTabBar(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void setProviderViewListener(ProviderView.ProviderViewListener paramProviderViewListener)
  {
    this.h = paramProviderViewListener;
  }
  
  public void setTabBarPosition(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.ProviderView
 * JD-Core Version:    0.7.0.1
 */