package com.tencent.mobileqq.activity.contacts.mayknow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class MayknowContactItemParentView
  extends RelativeLayout
{
  int jdField_a_of_type_Int;
  Path jdField_a_of_type_AndroidGraphicsPath;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  int b;
  int c;
  int d;
  
  public MayknowContactItemParentView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public MayknowContactItemParentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MayknowContactItemParentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.d = getResources().getColor(2131167093);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839633);
      this.jdField_a_of_type_Int = AIOUtils.a(6.0F, getResources());
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        QLog.i("MayknowContactItemParentView", 1, "init error:" + paramContext.getMessage());
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      try
      {
        paramCanvas.save();
        int i = getMeasuredWidth();
        int j = getMeasuredHeight();
        if ((this.jdField_a_of_type_AndroidGraphicsPath == null) || (i != this.b) || (j != this.c))
        {
          this.jdField_a_of_type_AndroidGraphicsPath = new Path();
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(0.0F, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, 0.0F, this.jdField_a_of_type_Int * 2, this.jdField_a_of_type_Int * 2), -180.0F, 90.0F);
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i - this.jdField_a_of_type_Int, 0.0F);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(i - this.jdField_a_of_type_Int * 2, 0.0F, i, this.jdField_a_of_type_Int * 2), -90.0F, 90.0F);
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(i, j - this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(i - this.jdField_a_of_type_Int * 2, j - this.jdField_a_of_type_Int * 2, i, j), 0.0F, 90.0F);
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int, j);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, j - this.jdField_a_of_type_Int * 2, this.jdField_a_of_type_Int * 2, j), 90.0F, 90.0F);
          this.jdField_a_of_type_AndroidGraphicsPath.close();
          this.b = i;
          this.c = j;
        }
        paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
        if (!"1103".equals(ThemeUtil.curThemeId)) {
          continue;
        }
        paramCanvas.drawColor(-15921907);
        paramCanvas.restore();
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.i("MayknowContactItemParentView", 1, "dispatchDraw error:" + localThrowable.getMessage());
        continue;
      }
      super.dispatchDraw(paramCanvas);
      return;
      paramCanvas.drawColor(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.MayknowContactItemParentView
 * JD-Core Version:    0.7.0.1
 */