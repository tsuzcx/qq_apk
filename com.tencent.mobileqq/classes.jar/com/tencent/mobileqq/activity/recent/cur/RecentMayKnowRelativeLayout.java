package com.tencent.mobileqq.activity.recent.cur;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;

public class RecentMayKnowRelativeLayout
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  SoftReference<Bitmap> jdField_a_of_type_JavaLangRefSoftReference;
  boolean jdField_a_of_type_Boolean;
  Rect jdField_b_of_type_AndroidGraphicsRect;
  SoftReference<Canvas> jdField_b_of_type_JavaLangRefSoftReference;
  
  public RecentMayKnowRelativeLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RecentMayKnowRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RecentMayKnowRelativeLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849646);
      this.jdField_a_of_type_Int = aepi.a(0.5F, getResources());
      return;
    }
    catch (Throwable paramContext)
    {
      this.jdField_a_of_type_Boolean = true;
      QLog.i("RecentMayKnowRelativeLayout", 1, "init error:" + paramContext.getMessage());
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      Canvas localCanvas;
      try
      {
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.jdField_a_of_type_JavaLangRefSoftReference == null) || (this.jdField_a_of_type_JavaLangRefSoftReference.get() == null) || (((Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get()).getWidth() != i) || (((Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get()).getHeight() != j))
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i, j);
          localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(localBitmap);
          localCanvas = new Canvas(localBitmap);
          this.jdField_b_of_type_JavaLangRefSoftReference = new SoftReference(localCanvas);
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, j - this.jdField_a_of_type_Int, i, j);
          this.jdField_b_of_type_AndroidGraphicsRect = new Rect(getLeft(), getBottom() - this.jdField_a_of_type_Int, getRight(), getBottom());
          if ((localBitmap == null) || (localCanvas == null)) {
            break;
          }
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(localCanvas);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, null);
          return;
        }
      }
      catch (Throwable paramCanvas)
      {
        QLog.i("RecentMayKnowRelativeLayout", 1, "dispatchDraw error:" + paramCanvas.getMessage());
        return;
      }
      Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaLangRefSoftReference.get();
      if ((this.jdField_b_of_type_JavaLangRefSoftReference == null) || (this.jdField_b_of_type_JavaLangRefSoftReference.get() == null))
      {
        localCanvas = new Canvas(localBitmap);
        this.jdField_b_of_type_JavaLangRefSoftReference = new SoftReference(localCanvas);
      }
      else
      {
        localCanvas = (Canvas)this.jdField_b_of_type_JavaLangRefSoftReference.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.cur.RecentMayKnowRelativeLayout
 * JD-Core Version:    0.7.0.1
 */