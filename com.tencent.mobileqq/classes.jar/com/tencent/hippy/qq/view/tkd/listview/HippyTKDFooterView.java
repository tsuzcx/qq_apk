package com.tencent.hippy.qq.view.tkd.listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class HippyTKDFooterView
  extends FrameLayout
{
  private LinearLayout mContentContainer;
  private int mImageVisibility = 0;
  private ImageView mLeftImage;
  private TextView mRightText;
  private int mTextVisibility = 0;
  
  public HippyTKDFooterView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.mContentContainer = new LinearLayout(paramContext);
    this.mContentContainer.setOrientation(0);
    Object localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.mContentContainer, (ViewGroup.LayoutParams)localObject);
    this.mLeftImage = new ImageView(paramContext);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.mContentContainer.addView(this.mLeftImage, (ViewGroup.LayoutParams)localObject);
    this.mRightText = new TextView(paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.leftMargin = ImmersiveUtils.dpToPx(8.0F);
    this.mContentContainer.addView(this.mRightText, paramContext);
  }
  
  private void changeVisibility(int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 ^ paramInt2;
    if (paramInt2 == 0) {}
    do
    {
      return;
      if ((paramInt1 == 0) || ((paramInt2 & 0x4) != 0)) {
        invalidate();
      }
    } while ((paramInt2 & 0x8) == 0);
    requestLayout();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mLeftImage.setBackgroundDrawable(paramDrawable);
  }
  
  public void setImageVisibility(int paramInt)
  {
    int i = this.mImageVisibility;
    this.mImageVisibility = paramInt;
    changeVisibility(this.mImageVisibility, i);
  }
  
  public void setText(String paramString)
  {
    this.mRightText.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.mRightText.setTextColor(paramInt);
  }
  
  public void setTextMargins(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.mRightText.getLayoutParams();
    localLayoutParams.leftMargin = paramInt1;
    localLayoutParams.topMargin = paramInt2;
    localLayoutParams.rightMargin = paramInt3;
    localLayoutParams.bottomMargin = paramInt4;
    this.mRightText.setLayoutParams(localLayoutParams);
    requestLayout();
  }
  
  public void setTextSize(int paramInt)
  {
    this.mRightText.setTextSize(paramInt);
  }
  
  public void setTextVisisbility(int paramInt)
  {
    int i = this.mTextVisibility;
    this.mTextVisibility = paramInt;
    changeVisibility(this.mTextVisibility, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDFooterView
 * JD-Core Version:    0.7.0.1
 */