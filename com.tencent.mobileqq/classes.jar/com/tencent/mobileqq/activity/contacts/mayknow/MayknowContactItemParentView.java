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
  int a;
  Drawable b;
  Path c;
  int d;
  int e;
  int f;
  
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
      this.f = getResources().getColor(2131168094);
      this.b = getResources().getDrawable(2130839681);
    }
    catch (Throwable paramContext)
    {
      this.b = null;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init error:");
      localStringBuilder.append(paramContext.getMessage());
      QLog.i("MayknowContactItemParentView", 1, localStringBuilder.toString());
    }
    this.a = AIOUtils.b(6.0F, getResources());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      paramCanvas.save();
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      if ((this.c == null) || (i != this.d) || (j != this.e))
      {
        this.c = new Path();
        this.c.moveTo(0.0F, this.a);
        this.c.arcTo(new RectF(0.0F, 0.0F, this.a * 2, this.a * 2), -180.0F, 90.0F);
        this.c.lineTo(i - this.a, 0.0F);
        Path localPath = this.c;
        float f2 = i - this.a * 2;
        float f1 = i;
        localPath.arcTo(new RectF(f2, 0.0F, f1, this.a * 2), -90.0F, 90.0F);
        this.c.lineTo(f1, j - this.a);
        localPath = this.c;
        f2 = i - this.a * 2;
        float f3 = j - this.a * 2;
        float f4 = j;
        localPath.arcTo(new RectF(f2, f3, f1, f4), 0.0F, 90.0F);
        this.c.lineTo(this.a, f4);
        this.c.arcTo(new RectF(0.0F, j - this.a * 2, this.a * 2, f4), 90.0F, 90.0F);
        this.c.close();
        this.d = i;
        this.e = j;
      }
      paramCanvas.clipPath(this.c);
      if ("1103".equals(ThemeUtil.curThemeId)) {
        paramCanvas.drawColor(-15921907);
      } else {
        paramCanvas.drawColor(this.f);
      }
      paramCanvas.restore();
      if (this.b != null)
      {
        this.b.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.b.draw(paramCanvas);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.MayknowContactItemParentView
 * JD-Core Version:    0.7.0.1
 */