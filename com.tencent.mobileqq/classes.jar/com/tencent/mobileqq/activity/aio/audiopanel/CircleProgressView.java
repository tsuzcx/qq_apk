package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends ImageView
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private int c = -9013368;
  private int d = 6;
  private int e = ScreenUtil.dip2px(9.0F);
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int k = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localBitmap != null))
        {
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
          this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, j, k);
          j = this.jdField_a_of_type_Int * 360 / 100;
          Canvas localCanvas = new Canvas(localBitmap);
          localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
          localCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, j - 90, 360 - j, true, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.drawBitmap(localBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, null);
          localBitmap.recycle();
          paramCanvas.restoreToCount(i);
          if (!this.jdField_a_of_type_Boolean) {}
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        try
        {
          ((ListenPanel)getParent().getParent()).b(201);
          this.jdField_a_of_type_Boolean = false;
          super.onDraw(paramCanvas);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          Object localObject1 = null;
          continue;
          if (this.b > 0)
          {
            f = this.b;
            this.jdField_a_of_type_AndroidGraphicsRectF.set(this.e + f, this.e + f, j - f - this.e, k - f - this.e);
            this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
            this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
            this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
            j = this.jdField_a_of_type_Int * 360 / 100;
            paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 270.0F, j, false, this.jdField_a_of_type_AndroidGraphicsPaint);
            continue;
          }
          float f = 3.0F;
          continue;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOAudioPanel", 2, "CircleProgressView startPlayAnimByType error e=" + toString());
          }
          this.jdField_a_of_type_Boolean = false;
          continue;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public void setAnimFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setProgressBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setRingColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */