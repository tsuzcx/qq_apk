package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.view.View;
import com.tencent.mtt.hippy.modules.Promise;

public abstract interface IHippyTKDRefreshHeader
{
  public abstract boolean checkRefreshState(int paramInt);
  
  public abstract void completeRefresh(int paramInt);
  
  public abstract void completeRefresh(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, boolean paramBoolean, long paramLong, Promise paramPromise, int paramInt6);
  
  public abstract boolean isRefreshHeaderShowing();
  
  public abstract boolean isRefreshing();
  
  public abstract void onCancelTouch();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract boolean onScrolled();
  
  public abstract void onSwitchSkin();
  
  public abstract boolean onUpAction(boolean paramBoolean);
  
  public abstract void restoreRefresh();
  
  public abstract void setCustomHippyRefreshView(View paramView);
  
  public abstract void setCustomRefreshBallColor(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setRefreshPromptInfo(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, int paramInt5);
  
  public abstract void setRefreshWithTargetType(int paramInt);
  
  public abstract void startRefresh(boolean paramBoolean);
  
  public abstract void startRefreshOnlyWithAimation(boolean paramBoolean);
  
  public abstract void startRefreshWithType(boolean paramBoolean);
  
  public abstract void stopRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.IHippyTKDRefreshHeader
 * JD-Core Version:    0.7.0.1
 */