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
  public String a;
  public int b;
  public int c;
  public int d;
  public int e;
  public Paint f;
  public Paint g;
  private long h;
  private int i = 200;
  private boolean j = false;
  private boolean k;
  private Drawable l;
  
  public PokeEmoItemView(Context paramContext)
  {
    super(paramContext);
    this.c = AIOUtils.b(16.0F, paramContext.getResources());
    this.d = AIOUtils.b(80.0F, paramContext.getResources());
    this.b = AIOUtils.b(2.0F, paramContext.getResources());
    this.f = new Paint();
    this.f.setAntiAlias(true);
    this.f.setColor(Color.parseColor("#FFDC4F"));
    this.f.setTextSize(AIOUtils.b(24.0F, paramContext.getResources()));
    this.g = new Paint(this.f);
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setColor(Color.parseColor("#418DFF"));
    this.g.setStrokeWidth(AIOUtils.b(4.0F, paramContext.getResources()));
  }
  
  private float a(long paramLong)
  {
    long l1 = this.h;
    if (l1 == 0L) {
      return 0.0F;
    }
    double d1 = (paramLong - l1) % 400L;
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
    return this.j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    String str = this.a;
    int i1 = getMeasuredWidth();
    int m = this.e;
    int i2 = this.d;
    int i3 = this.c;
    int i4 = this.b;
    int n = paramCanvas.save();
    if (this.k) {
      paramCanvas.translate(i1 - i2 - (m - i3) - i4, 0.0F);
    }
    Object localObject = this.l;
    if (localObject != null) {
      ((Drawable)localObject).draw(paramCanvas);
    }
    long l1 = SystemClock.uptimeMillis();
    i1 = this.d - this.c;
    localObject = this.f.getFontMetricsInt();
    i2 = getMeasuredHeight() - ((Paint.FontMetricsInt)localObject).descent - 4;
    paramCanvas.rotate(a(l1), m / 2 + i1, ((Paint.FontMetricsInt)localObject).ascent / 2 + i2);
    float f1 = i1;
    float f2 = i2;
    paramCanvas.drawText(str, f1, f2, this.g);
    paramCanvas.drawText(str, f1, f2, this.f);
    paramCanvas.restoreToCount(n);
    if (this.h == 0L) {
      this.h = l1;
    }
    postDelayed(this, this.i);
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
      int m = this.d;
      paramDrawable.setBounds(0, 0, m, m);
    }
    this.l = paramDrawable;
    invalidate(getLeft(), getTop(), getRight(), getBottom());
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.e = ((int)this.f.measureText(paramString));
      invalidate(getLeft(), getTop(), getRight(), getBottom());
    }
    else
    {
      this.e = 0;
    }
    this.a = paramString;
  }
  
  public void setTypeFace(Typeface paramTypeface)
  {
    if (this.j) {
      return;
    }
    if (paramTypeface != null)
    {
      this.j = true;
      this.f.setTypeface(paramTypeface);
      this.g.setTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.PokeEmoItemView
 * JD-Core Version:    0.7.0.1
 */