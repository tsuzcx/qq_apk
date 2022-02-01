package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.drawable.Drawable;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDRefreshHeader$ExternalStageInfo
{
  Drawable mBackgroundDrawable;
  String mDescriptionText;
  int mDescriptionTextColor;
  int mDistanceFromTop;
  HippyTKDRefreshHeader.ExternalStageCallback mExternalStageCallback;
  boolean mNeedLoadingRefreshBall;
  boolean mNeedShowBackgroundImage;
  boolean mNeedShowDescriptionText;
  
  public HippyTKDRefreshHeader$ExternalStageInfo(HippyTKDRefreshHeader.ExternalStageCallback paramExternalStageCallback, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, int paramInt2, Drawable paramDrawable)
  {
    this.mExternalStageCallback = paramExternalStageCallback;
    this.mDistanceFromTop = ImmersiveUtils.dpToPx(paramInt1);
    this.mNeedLoadingRefreshBall = paramBoolean1;
    this.mNeedShowDescriptionText = paramBoolean2;
    this.mNeedShowBackgroundImage = paramBoolean3;
    this.mDescriptionText = paramString;
    this.mDescriptionTextColor = paramInt2;
    this.mBackgroundDrawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.ExternalStageInfo
 * JD-Core Version:    0.7.0.1
 */