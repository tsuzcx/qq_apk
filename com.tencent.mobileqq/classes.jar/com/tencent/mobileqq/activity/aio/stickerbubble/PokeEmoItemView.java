package com.tencent.mobileqq.activity.aio.stickerbubble;

import aekt;
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
import com.tencent.qphone.base.util.QLog;

public class PokeEmoItemView
  extends View
  implements Runnable
{
  public int a;
  private long jdField_a_of_type_Long;
  public Paint a;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public String a;
  private boolean jdField_a_of_type_Boolean;
  public int b;
  public Paint b;
  private boolean b;
  public int c;
  public int d;
  private int e = 200;
  
  public PokeEmoItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Int = aekt.a(16.0F, paramContext.getResources());
    this.c = aekt.a(80.0F, paramContext.getResources());
    this.jdField_a_of_type_Int = aekt.a(2.0F, paramContext.getResources());
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#FFDC4F"));
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(aekt.a(24.0F, paramContext.getResources()));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#418DFF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(aekt.a(4.0F, paramContext.getResources()));
  }
  
  private float a(long paramLong)
  {
    if (this.jdField_a_of_type_Long == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - this.jdField_a_of_type_Long) % 400L / 400.0D * 20.0D;
    if (d1 < 10.0D) {}
    for (d1 -= 5.0D;; d1 = 10.0D - (d1 - 10.0D) - 5.0D) {
      return (float)d1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    int i = getMeasuredWidth();
    int j = this.d;
    int m = this.c;
    int n = this.d;
    int i1 = this.jdField_b_of_type_Int;
    int i2 = this.jdField_a_of_type_Int;
    int k = paramCanvas.save();
    if (this.jdField_b_of_type_Boolean) {
      paramCanvas.translate(i - m - (n - i1) - i2, 0.0F);
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
    long l = SystemClock.uptimeMillis();
    m = this.c - this.jdField_b_of_type_Int;
    Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    n = getMeasuredHeight() - localFontMetricsInt.descent - 4;
    paramCanvas.rotate(a(l), j / 2 + m, localFontMetricsInt.ascent / 2 + n);
    paramCanvas.drawText(str, m, n, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawText(str, m, n, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (QLog.isDevelopLevel()) {
      QLog.d("PokeEmoItemView", 4, String.format("mImgWidth:%d,measureW:%d,mTextWidth:%d,mTextOffset:%d,left:%d,mText:%s", new Object[] { Integer.valueOf(this.c), Integer.valueOf(i), Integer.valueOf(this.d), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(m), this.jdField_a_of_type_JavaLangString }));
    }
    paramCanvas.restoreToCount(k);
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
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, this.c, this.c);
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
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
      this.d = 0;
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
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView
 * JD-Core Version:    0.7.0.1
 */