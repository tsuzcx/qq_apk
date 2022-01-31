package com.tencent.biz.pubaccount.readinjoy.view.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RefreshEyeView
  extends ImageView
{
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private PaintFlagsDrawFilter jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter;
  private boolean jdField_a_of_type_Boolean;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[19];
  private double jdField_b_of_type_Double = 0.2000000029802322D;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private double c = 0.0D;
  
  public RefreshEyeView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public RefreshEyeView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private int a(Context paramContext, double paramDouble)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramDouble + 0.5D);
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    double d1 = this.c;
    int i = 0;
    while (i < paramInt1)
    {
      double d2 = (float)(15.0D * Math.sin(2.827433388230814D / paramInt1 * i + this.jdField_a_of_type_Double) + paramInt2 * ((1.0D - d1) * 2.5D - 0.2D));
      localCanvas.drawLine(i, paramInt2 * 4, i, (float)d2, this.jdField_a_of_type_AndroidGraphicsPaint);
      i += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    return localBitmap;
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
    setWillNotDraw(false);
    this.jdField_b_of_type_AndroidGraphicsBitmap = a(getResources().getDrawable(2130848964));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = a(getResources().getDrawable(2130848945));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[1] = a(getResources().getDrawable(2130848946));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[2] = a(getResources().getDrawable(2130848947));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[3] = a(getResources().getDrawable(2130848948));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[4] = a(getResources().getDrawable(2130848949));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[5] = a(getResources().getDrawable(2130848950));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[6] = a(getResources().getDrawable(2130848951));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[7] = a(getResources().getDrawable(2130848952));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[8] = a(getResources().getDrawable(2130848953));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[9] = a(getResources().getDrawable(2130848954));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[10] = a(getResources().getDrawable(2130848955));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[11] = a(getResources().getDrawable(2130848956));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[12] = a(getResources().getDrawable(2130848957));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[13] = a(getResources().getDrawable(2130848958));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[14] = a(getResources().getDrawable(2130848959));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[15] = a(getResources().getDrawable(2130848960));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[16] = a(getResources().getDrawable(2130848961));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[17] = a(getResources().getDrawable(2130848962));
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[18] = a(getResources().getDrawable(2130848963));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
    if (!this.jdField_a_of_type_Boolean)
    {
      paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsPaintFlagsDrawFilter);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        paramCanvas.drawBitmap(a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()), 0.0F, 0.0F, null);
      }
      if (this.jdField_a_of_type_Double > 999999999.0D) {
        this.jdField_a_of_type_Double = 0.0D;
      }
      this.jdField_a_of_type_Double += this.jdField_b_of_type_Double;
    }
    for (;;)
    {
      postDelayed(new RefreshEyeView.1(this), 10L);
      return;
      long l = System.currentTimeMillis();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      if (l >= this.jdField_a_of_type_Long + 55L)
      {
        this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % 19);
        paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.jdField_a_of_type_Int], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
        this.jdField_a_of_type_Long = l;
      }
      else
      {
        paramCanvas.drawBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[this.jdField_a_of_type_Int], a(getContext(), 11.0D), a(getContext(), 8.0D), null);
      }
    }
  }
  
  public void setImageDrawable(@Nullable Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(paramDrawable);
    super.setImageDrawable(paramDrawable);
  }
  
  public void setWaveHeightPercent(double paramDouble)
  {
    this.c = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshEyeView
 * JD-Core Version:    0.7.0.1
 */