package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.util.DisplayUtil;

public class ProgressPointer
  extends View
  implements Handler.Callback
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public ProgressPointer(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public ProgressPointer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public ProgressPointer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.d = DisplayUtil.a(getContext(), ScrollFrameSelectBar.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Float = 100.0F;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = l1;
      this.jdField_a_of_type_Float = ((float)(l1 - l2) * 100.0F / this.c + this.jdField_a_of_type_Float);
      if (this.jdField_a_of_type_Float > 100.0F) {
        this.jdField_a_of_type_Float = 100.0F;
      }
      invalidate();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 50L);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Float >= 0.0F)
    {
      float f1 = (this.b - this.jdField_a_of_type_Int) * this.jdField_a_of_type_Float / 100.0F + this.jdField_a_of_type_Int;
      paramCanvas.drawRect(f1 - 2.0F, 0.0F, 2.0F + f1, this.f, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.e = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setFrameSize(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2, int paramInt3)
  {
    SLog.a("Q.qqstory.frameWidget.ProgressPointer", "++++++++setRange++++++start=%s,end=%s,duration=%s,mProgress=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(this.jdField_a_of_type_Float));
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ProgressPointer
 * JD-Core Version:    0.7.0.1
 */