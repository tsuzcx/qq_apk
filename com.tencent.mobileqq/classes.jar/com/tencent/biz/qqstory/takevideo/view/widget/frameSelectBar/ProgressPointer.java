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
  private float a = -1.0F;
  private int b;
  private int c;
  private int d;
  private boolean e = false;
  private Paint f;
  private int g;
  private int h;
  private Handler i = new Handler(Looper.getMainLooper(), this);
  private int j;
  private int k;
  private long l;
  
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
    this.f = new Paint();
    this.f.setColor(-1);
    this.f.setStyle(Paint.Style.FILL);
    this.g = DisplayUtil.a(getContext(), ScrollFrameSelectBar.a);
  }
  
  public void a()
  {
    this.l = System.currentTimeMillis();
    this.a = 0.0F;
    this.i.removeMessages(1);
    this.i.sendEmptyMessage(1);
  }
  
  public void b()
  {
    this.l = System.currentTimeMillis();
    this.a = 100.0F;
    this.i.removeMessages(1);
    this.i.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.l;
      this.l = l1;
      float f1 = (float)(l1 - l2) * 100.0F / this.d;
      this.a += f1;
      if (this.a > 100.0F) {
        this.a = 100.0F;
      }
      invalidate();
      this.i.sendEmptyMessageDelayed(1, 50L);
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.i.removeCallbacksAndMessages(null);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f1 = this.a;
    if (f1 >= 0.0F)
    {
      int m = this.c;
      int n = this.b;
      f1 = (m - n) * f1 / 100.0F + n;
      paramCanvas.drawRect(f1 - 2.0F, 0.0F, f1 + 2.0F, this.j, this.f);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.h = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setFrameSize(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
  }
  
  public void setRange(int paramInt1, int paramInt2, int paramInt3)
  {
    SLog.a("Q.qqstory.frameWidget.ProgressPointer", "++++++++setRange++++++start=%s,end=%s,duration=%s,mProgress=%s", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Float.valueOf(this.a));
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ProgressPointer
 * JD-Core Version:    0.7.0.1
 */