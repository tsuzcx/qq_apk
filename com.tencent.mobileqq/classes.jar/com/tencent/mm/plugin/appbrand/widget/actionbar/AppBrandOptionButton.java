package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;

public class AppBrandOptionButton
  extends FrameLayout
{
  private ImageButton a;
  
  public AppBrandOptionButton(@NonNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AppBrandOptionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AppBrandOptionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public AppBrandOptionButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new ImageButton(paramContext);
    this.a.setClickable(false);
    this.a.setBackground(null);
    addView(this.a, new FrameLayout.LayoutParams(getActionBarHeight(), -1, 17));
    setAccessibilityLabel(getDefaultAccessibilityLabel());
  }
  
  private int getActionBarHeight()
  {
    return getResources().getDimensionPixelSize(2131296295);
  }
  
  public void a()
  {
    this.a.setVisibility(0);
    this.a.setAlpha(1.0F);
    this.a.setImageDrawable(getDefaultImageDrawable());
  }
  
  public ImageView getButtonImage()
  {
    return this.a;
  }
  
  protected String getDefaultAccessibilityLabel()
  {
    return getContext().getString(2131886751);
  }
  
  protected Drawable getDefaultImageDrawable()
  {
    return ContextCompat.getDrawable(getContext(), 2130838659);
  }
  
  public final void setAccessibilityLabel(String paramString)
  {
    ImageButton localImageButton = this.a;
    if ((localImageButton != null) && (localImageButton.getVisibility() == 0)) {
      this.a.setContentDescription(paramString);
    }
  }
  
  public void setColor(int paramInt)
  {
    this.a.setImageDrawable(getDefaultImageDrawable());
    this.a.setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    this.a.setBackground(getBackground());
    if (this.a.getBackground() != null) {
      this.a.getBackground().setColorFilter(paramInt, PorterDuff.Mode.SRC_ATOP);
    }
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return;
      }
      this.a.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
 * JD-Core Version:    0.7.0.1
 */