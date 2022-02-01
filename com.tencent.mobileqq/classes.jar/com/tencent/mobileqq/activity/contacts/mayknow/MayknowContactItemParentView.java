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
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
      this.d = getResources().getColor(2131167116);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839491);
    }
    catch (Throwable paramContext)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init error:");
      localStringBuilder.append(paramContext.getMessage());
      QLog.i("MayknowContactItemParentView", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = AIOUtils.b(6.0F, getResources());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
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
        Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        float f2 = i - this.jdField_a_of_type_Int * 2;
        float f1 = i;
        localPath.arcTo(new RectF(f2, 0.0F, f1, this.jdField_a_of_type_Int * 2), -90.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, j - this.jdField_a_of_type_Int);
        localPath = this.jdField_a_of_type_AndroidGraphicsPath;
        f2 = i - this.jdField_a_of_type_Int * 2;
        float f3 = j - this.jdField_a_of_type_Int * 2;
        float f4 = j;
        localPath.arcTo(new RectF(f2, f3, f1, f4), 0.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.lineTo(this.jdField_a_of_type_Int, f4);
        this.jdField_a_of_type_AndroidGraphicsPath.arcTo(new RectF(0.0F, j - this.jdField_a_of_type_Int * 2, this.jdField_a_of_type_Int * 2, f4), 90.0F, 90.0F);
        this.jdField_a_of_type_AndroidGraphicsPath.close();
        this.b = i;
        this.c = j;
      }
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      if ("1103".equals(ThemeUtil.curThemeId)) {
        paramCanvas.drawColor(-15921907);
      } else {
        paramCanvas.drawColor(this.d);
      }
      paramCanvas.restore();
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchDraw error:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.i("MayknowContactItemParentView", 1, localStringBuilder.toString());
    }
    super.dispatchDraw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.MayknowContactItemParentView
 * JD-Core Version:    0.7.0.1
 */