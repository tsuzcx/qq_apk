package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class QavRecordButtonView
  extends View
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = null;
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = null;
  private QavRecordButtonView.ShowStateChangeListener jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView$ShowStateChangeListener;
  
  public QavRecordButtonView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QavRecordButtonView", 1, "decodeBitmap oom", localOutOfMemoryError);
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QavRecordButtonView", 1, "decodeBitmap Throwable", localThrowable);
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsBitmap = a(2130842406);
    super.setOnTouchListener(new QavRecordButtonView.1(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    switch (this.jdField_a_of_type_Int)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, i, j);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    float f1 = 0.08571429F * i;
    float f2 = Math.min(i, j) / 2 - f1 - 0.002857143F * i;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i / 2 - f2, j / 2 - f2, i / 2 + f2, j / 2 + f2);
    f1 = this.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-48606);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F - 360.0F * (1.0F - f1), false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public void setListener(QavRecordButtonView.ShowStateChangeListener paramShowStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView$ShowStateChangeListener = paramShowStateChangeListener;
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Float = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.jdField_a_of_type_Int == 3) {
      invalidate();
    }
  }
  
  public void setShowState(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordButtonView", 2, "setShowState, state=" + paramInt + ", talkBack=" + paramBoolean);
    }
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      invalidate();
      if (this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView$ShowStateChangeListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentAvUiFunchatRecordQavRecordButtonView$ShowStateChangeListener.e(this.jdField_a_of_type_Int);
      return;
      super.setAlpha(1.0F);
      if (paramBoolean)
      {
        super.setContentDescription("");
        continue;
        if (paramBoolean)
        {
          super.setContentDescription(getResources().getString(2131695764));
          continue;
          if (paramBoolean) {
            super.setContentDescription(getResources().getString(2131695765));
          }
          this.jdField_a_of_type_Float = 0.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordButtonView
 * JD-Core Version:    0.7.0.1
 */