package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public abstract class HippyTKDCustomRefreshHeader
  extends FrameLayout
{
  public HippyTKDCustomRefreshHeader(Context paramContext)
  {
    super(paramContext);
    setLayoutParams(new FrameLayout.LayoutParams(-1, getRefreshViewHeight()));
  }
  
  public abstract void endLoadingAnimation(String paramString);
  
  public abstract int getMasterRefreshTextAlpha();
  
  public abstract int getRefreshViewHeight();
  
  public abstract boolean isShowMasterRefreshText();
  
  public abstract boolean isShowMasterRefreshToastBg();
  
  public abstract void onFinishing();
  
  public abstract void onTranslating(int paramInt);
  
  public abstract void startLoadingAnimation();
  
  public abstract void startPulling();
  
  public abstract void startSettling();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDCustomRefreshHeader
 * JD-Core Version:    0.7.0.1
 */