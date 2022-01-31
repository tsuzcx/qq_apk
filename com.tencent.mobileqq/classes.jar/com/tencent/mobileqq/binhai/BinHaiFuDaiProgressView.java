package com.tencent.mobileqq.binhai;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.List;

public class BinHaiFuDaiProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private ShapeDrawable jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable;
  private Bitmap[] jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[0];
  private int b;
  private int c;
  private int d;
  
  public BinHaiFuDaiProgressView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BinHaiFuDaiProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BinHaiFuDaiProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = AIOUtils.a(18.0F, getResources());
    this.b = AIOUtils.a(8.0F, getResources());
    this.c = AIOUtils.a(8.0F, getResources());
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { this.b, this.b, 0.0F, 0.0F, 0.0F, 0.0F, this.b, this.b }, null, null));
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.getPaint().setColor(Color.parseColor("#ff6c41"));
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.d = 0;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18)) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Float = (1.0F * (float)paramLong1 / (float)paramLong2);
    postInvalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    Bitmap localBitmap;
    if (this.jdField_a_of_type_Float < 1.0F)
    {
      int j = getWidth();
      i = getHeight();
      k = this.c;
      m = j - this.c;
      n = (i - this.jdField_a_of_type_Int) / 2;
      i1 = (this.jdField_a_of_type_Int + i) / 2;
      i2 = (int)((m - k) * this.jdField_a_of_type_Float) + k;
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.setBounds(k, n, i2, i1);
      this.jdField_a_of_type_AndroidGraphicsDrawableShapeDrawable.draw(paramCanvas);
      j = this.d;
      i = j;
      if (j >= this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length) {
        i = j % this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap.length;
      }
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getWidth();
      i3 = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i].getHeight();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, j, i3);
      if (i2 - k < j) {
        break label219;
      }
      localBitmap = this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i];
      this.jdField_a_of_type_AndroidGraphicsRectF.set(i2 - j, n, i2, i1);
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
    }
    for (;;)
    {
      this.d += 1;
      return;
      label219:
      if (i2 > k)
      {
        localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i], 0, 0, i2 - k, i1 - n, null, false);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(k, n, i2, i1);
        if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 18))
        {
          paramCanvas.drawBitmap(ImageUtil.b(localBitmap, this.b, m - i2, i3), this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, null);
        }
        else
        {
          this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.b, this.b, Path.Direction.CW);
          paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath, Region.Op.INTERSECT);
          paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
  }
  
  public void setBitmap(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramList.size()];
      int i = 0;
      while (i < paramList.size())
      {
        this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[i] = ((Bitmap)paramList.get(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.binhai.BinHaiFuDaiProgressView
 * JD-Core Version:    0.7.0.1
 */