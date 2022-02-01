package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.DrawableController;

public class KandianUrlImageView
  extends ResizeURLImageView
{
  private boolean mIsRecyclerView;
  private KandianUrlImageView.OnVisibilityChangedListener mVisibilityChangedListener;
  
  public KandianUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    if (!this.mIsRecyclerView) {
      super.onDetachedFromWindow();
    }
  }
  
  public void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mVisibilityChangedListener != null) {
      this.mVisibilityChangedListener.a(paramView, paramInt);
    }
  }
  
  public void release()
  {
    if (this.mController != null) {
      this.mController.a("onKandianUrlImageView release");
    }
  }
  
  public void setIsRecyclerView(boolean paramBoolean)
  {
    this.mIsRecyclerView = paramBoolean;
  }
  
  public void setVisibilityChangedListener(KandianUrlImageView.OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    this.mVisibilityChangedListener = paramOnVisibilityChangedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView
 * JD-Core Version:    0.7.0.1
 */