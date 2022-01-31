package com.tencent.component.media.image.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.utils.ImageManagerLog;
import pgv;
import pgw;
import pgx;
import pgy;
import pgz;
import pha;

public class ExtendImageView
  extends ImageView
{
  private static final ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new pgv();
  private int jdField_a_of_type_Int = 0;
  private ViewForeground jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground = new ViewForeground(this, null);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public ExtendImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.b = true;
    try
    {
      super.setImageResource(paramInt);
      this.b = false;
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      ImageManagerLog.e("ExtendImageView", "out of memory " + localOutOfMemoryError.toString());
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.b = true;
    super.setImageBitmap(paramBitmap);
    this.b = false;
  }
  
  private void a(Drawable paramDrawable)
  {
    this.b = true;
    super.setImageDrawable(paramDrawable);
    this.b = false;
  }
  
  private void a(Uri paramUri)
  {
    this.b = true;
    super.setImageURI(paramUri);
    this.b = false;
  }
  
  private void a(Animation paramAnimation, Runnable paramRunnable)
  {
    if (paramAnimation == null)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
    }
    clearAnimation();
    paramAnimation.setAnimationListener(new pha(this, paramRunnable));
    startAnimation(paramAnimation);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    return (paramInt1 == 1073741824) && (paramInt2 == 1073741824);
  }
  
  private boolean a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Rect localRect = (Rect)jdField_a_of_type_JavaLangThreadLocal.get();
    boolean bool;
    if ((paramDrawable1 != null) && (paramDrawable1.getPadding(localRect))) {
      bool = true;
    }
    while (!bool) {
      if ((paramDrawable2 != null) && (paramDrawable2.getPadding(localRect)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  private void b(Drawable paramDrawable)
  {
    this.b = true;
    this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground.setDrawable(paramDrawable);
    this.b = false;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    ViewForeground localViewForeground = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
    if (localViewForeground != null) {
      localViewForeground.drawableStateChanged();
    }
  }
  
  public boolean getAdjustViewBounds()
  {
    return this.d;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ViewForeground localViewForeground = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
    if (localViewForeground != null) {
      localViewForeground.draw(paramCanvas);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewForeground localViewForeground = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
    if (localViewForeground != null) {
      localViewForeground.boundsChanged();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = a(paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.c) && (!this.d)) {
      setMeasuredDimension(getDefaultSize(getMeasuredWidth(), paramInt1), getDefaultSize(getMeasuredHeight(), paramInt2));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    ViewForeground localViewForeground = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
    if (localViewForeground != null) {
      localViewForeground.boundsChanged();
    }
  }
  
  public void requestLayout()
  {
    if ((this.b) && (this.jdField_a_of_type_Boolean)) {
      return;
    }
    super.requestLayout();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    super.setAdjustViewBounds(paramBoolean);
    this.d = paramBoolean;
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.b = true;
    super.setBackgroundColor(paramInt);
    this.b = false;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (!a(getBackground(), paramDrawable)) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      super.setBackgroundDrawable(paramDrawable);
      this.b = false;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.b = true;
    super.setBackgroundResource(paramInt);
    this.b = false;
  }
  
  public void setForeground(int paramInt)
  {
    if ((paramInt != 0) && (paramInt == this.jdField_a_of_type_Int)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 0) {}
    for (Drawable localDrawable = getResources().getDrawable(paramInt);; localDrawable = null)
    {
      b(localDrawable);
      return;
    }
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (paramDrawable == this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground.getDrawable()) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    b(paramDrawable);
  }
  
  public void setIgnoreContentBounds(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      requestLayout();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap);
  }
  
  public void setImageBitmap(Bitmap paramBitmap, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      a(paramAnimation2, new pgw(this, paramBitmap, paramAnimation1));
    }
    do
    {
      return;
      a(paramBitmap);
    } while (paramAnimation1 == null);
    a(paramAnimation1, null);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    a(paramDrawable);
  }
  
  public void setImageDrawable(Drawable paramDrawable, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      a(paramAnimation2, new pgx(this, paramDrawable, paramAnimation1));
    }
    do
    {
      return;
      a(paramDrawable);
    } while (paramAnimation1 == null);
    a(paramAnimation1, null);
  }
  
  public void setImageResource(int paramInt)
  {
    a(paramInt);
  }
  
  public void setImageResource(int paramInt, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      a(paramAnimation2, new pgy(this, paramInt, paramAnimation1));
    }
    do
    {
      return;
      a(paramInt);
    } while (paramAnimation1 == null);
    a(paramAnimation1, null);
  }
  
  public void setImageURI(Uri paramUri)
  {
    a(paramUri);
  }
  
  public void setImageURI(Uri paramUri, Animation paramAnimation1, Animation paramAnimation2)
  {
    if (paramAnimation2 != null) {
      a(paramAnimation2, new pgz(this, paramUri, paramAnimation1));
    }
    do
    {
      return;
      a(paramUri);
    } while (paramAnimation1 == null);
    a(paramAnimation1, null);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentComponentMediaImageViewViewForeground;
    if (localObject == null) {}
    for (localObject = null; (localObject == paramDrawable) || (super.verifyDrawable(paramDrawable)); localObject = ((ViewForeground)localObject).getDrawable()) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.view.ExtendImageView
 * JD-Core Version:    0.7.0.1
 */