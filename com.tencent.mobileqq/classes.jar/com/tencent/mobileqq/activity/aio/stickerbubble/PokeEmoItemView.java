package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class PokeEmoItemView
  extends View
  implements Runnable
{
  public int a;
  private long jdField_a_of_type_Long;
  public Paint a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  public Paint b;
  private boolean b;
  public int c;
  public int d;
  private int e = 200;
  
  public PokeEmoItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = AIOUtils.b(16.0F, paramContext.getResources());
    this.c = AIOUtils.b(80.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = AIOUtils.b(2.0F, paramContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(AIOUtils.b(24.0F, paramContext.getResources()));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#418DFF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(AIOUtils.b(4.0F, paramContext.getResources()));
  }
  
  private float a(long paramLong)
  {
    long l = this.jdField_a_of_type_Long;
    if (l == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - l) % 400L;
    Double.isNaN(d1);
    d1 = d1 / 400.0D * 20.0D;
    if (d1 < 10.0D) {
      d1 -= 5.0D;
    } else {
      d1 = 10.0D - (d1 - 10.0D) - 5.0D;
    }
    return (float)d1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    int k = getMeasuredWidth();
    int i = this.d;
    int m = this.c;
    int n = this.jdField_b_of_type_Int;
    int i1 = this.jdField_a_of_type_Int;
    int j = paramCanvas.save();
    if (this.jdField_b_of_type_Boolean) {
      paramCanvas.translate(k - m - (i - n) - i1, 0.0F);
    }
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
    long l = SystemClock.uptimeMillis();
    k = this.c - this.jdField_b_of_type_Int;
    localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    m = getMeasuredHeight() - ((Paint.FontMetricsInt)localObject).descent - 4;
    paramCanvas.rotate(a(l), i / 2 + k, ((Paint.FontMetricsInt)localObject).ascent / 2 + m);
    float f1 = k;
    float f2 = m;
    paramCanvas.drawText(str, f1, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(str, f1, f2, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(j);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l;
    }
    postDelayed(this, this.e);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void run()
  {
    if (getVisibility() == 0) {
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      int i = this.c;
      paramDrawable.setBounds(0, 0, i, i);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    invalidate(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = ((int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString));
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
    else
    {
      this.d = 0;
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setTypeFace(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramTypeface != null)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView
 * JD-Core Version:    0.7.0.1
 */