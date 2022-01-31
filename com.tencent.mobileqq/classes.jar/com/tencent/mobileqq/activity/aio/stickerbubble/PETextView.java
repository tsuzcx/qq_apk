package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class PETextView
  extends TextView
  implements Runnable
{
  private int jdField_a_of_type_Int = 200;
  private long jdField_a_of_type_Long;
  public Paint a;
  private boolean jdField_a_of_type_Boolean;
  public Paint b;
  
  public PETextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(AIOUtils.a(24.0F, paramContext.getResources()));
    this.b = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(Color.parseColor("#418DFF"));
    this.b.setStrokeWidth(10.0F);
  }
  
  private float a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return 0.0F;
    }
    double d = (paramLong - this.jdField_a_of_type_Long) % 400L / 400.0D * 20.0D;
    if (d < 10.0D) {}
    for (d -= 5.0D;; d = 10.0D - (d - 10.0D) - 5.0D) {
      return (float)d;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    long l = SystemClock.uptimeMillis();
    String str = getText().toString();
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
    int i = (int)((getMeasuredWidth() - f1) / 2.0F);
    Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    int j = (getMeasuredHeight() - localFontMetricsInt.bottom + localFontMetricsInt.top) / 2 - localFontMetricsInt.top;
    int k = paramCanvas.save();
    float f2 = a(l);
    float f3 = i;
    paramCanvas.rotate(f2, f1 / 2.0F + f3, j + this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics().ascent / 2.0F);
    paramCanvas.drawText(str, i, j, this.b);
    paramCanvas.drawText(str, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restoreToCount(k);
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = l;
    }
    postDelayed(this, this.jdField_a_of_type_Int);
  }
  
  public void run()
  {
    if (getVisibility() == 0) {
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
  }
  
  public void setTypeFace(Typeface paramTypeface)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (paramTypeface == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
    this.b.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PETextView
 * JD-Core Version:    0.7.0.1
 */