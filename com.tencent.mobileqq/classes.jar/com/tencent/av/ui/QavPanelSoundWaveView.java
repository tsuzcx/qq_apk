package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.av.utils.AudioHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QavPanelSoundWaveView
  extends View
{
  float a;
  float b;
  float c = 0.0F;
  List<QavPanelWave> d;
  boolean e = false;
  Handler f = new Handler(Looper.getMainLooper());
  boolean g = false;
  Runnable h = new QavPanelSoundWaveView.1(this);
  boolean i = false;
  
  public QavPanelSoundWaveView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QavPanelSoundWaveView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  void a()
  {
    this.d = new ArrayList();
    boolean bool = false;
    if (AudioHelper.a(0) == 1) {
      bool = true;
    }
    this.i = bool;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    List localList = this.d;
    if (localList != null)
    {
      if (localList.size() != 3) {
        return;
      }
      if (this.g)
      {
        if ((this.d.get(0) != null) && (((QavPanelWave)this.d.get(0)).c() != null)) {
          ((QavPanelWave)this.d.get(0)).c().setColor(Color.parseColor("#b3ffffff"));
        }
        if ((this.d.get(1) != null) && (((QavPanelWave)this.d.get(1)).c() != null)) {
          ((QavPanelWave)this.d.get(1)).c().setColor(Color.parseColor("#66ffffff"));
        }
        if ((this.d.get(2) != null) && (((QavPanelWave)this.d.get(2)).c() != null)) {
          ((QavPanelWave)this.d.get(2)).c().setColor(Color.parseColor("#26ffffff"));
        }
      }
      else
      {
        if ((this.d.get(0) != null) && (((QavPanelWave)this.d.get(0)).c() != null)) {
          ((QavPanelWave)this.d.get(0)).c().setColor(Color.parseColor("#b312b7f5"));
        }
        if ((this.d.get(1) != null) && (((QavPanelWave)this.d.get(1)).c() != null)) {
          ((QavPanelWave)this.d.get(1)).c().setColor(Color.parseColor("#6612b7f5"));
        }
        if ((this.d.get(2) != null) && (((QavPanelWave)this.d.get(2)).c() != null)) {
          ((QavPanelWave)this.d.get(2)).c().setColor(Color.parseColor("#2612b7f5"));
        }
      }
    }
  }
  
  void b()
  {
    this.a = getWidth();
    this.b = getHeight();
    this.d.clear();
    float f1;
    if (!this.e) {
      f1 = 1.5F;
    } else {
      f1 = 8.0F;
    }
    PointF localPointF = new PointF(0.0F, this.b / 2.0F);
    Paint localPaint = new Paint();
    if (this.g) {
      localPaint.setColor(Color.parseColor("#b3ffffff"));
    } else {
      localPaint.setColor(Color.parseColor("#b312b7f5"));
    }
    localPaint.setStrokeWidth(2.0F);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    this.d.add(new QavPanelWave(0, this.a, this.b, f1, localPaint, localPointF, this.e));
    localPaint = new Paint();
    if (this.g) {
      localPaint.setColor(Color.parseColor("#66ffffff"));
    } else {
      localPaint.setColor(Color.parseColor("#6612b7f5"));
    }
    localPaint.setStrokeWidth(2.0F);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    this.d.add(new QavPanelWave(1, this.a, this.b, f1, localPaint, localPointF, this.e));
    localPaint = new Paint();
    if (this.g) {
      localPaint.setColor(Color.parseColor("#26ffffff"));
    } else {
      localPaint.setColor(Color.parseColor("#2612b7f5"));
    }
    localPaint.setStrokeWidth(2.0F);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    this.d.add(new QavPanelWave(2, this.a, this.b, f1, localPaint, localPointF, this.e));
  }
  
  public void c()
  {
    e();
    this.f = null;
    this.h = null;
    List localList = this.d;
    if (localList != null)
    {
      localList.clear();
      this.d = null;
    }
  }
  
  void d()
  {
    this.f.postDelayed(this.h, 20L);
    invalidate();
  }
  
  void e()
  {
    this.f.removeCallbacks(this.h);
    this.c = 0.0F;
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((QavPanelWave)localIterator.next()).b();
    }
    invalidate();
  }
  
  public void f()
  {
    d();
  }
  
  public void g()
  {
    e();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.a != getWidth()) || (this.b != getHeight())) {
      b();
    }
    if (this.i)
    {
      localObject = new Paint();
      ((Paint)localObject).setColor(-268780356);
      paramCanvas.drawRect(0.0F, 0.0F, this.a, this.b, (Paint)localObject);
    }
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((QavPanelWave)((Iterator)localObject).next()).a(paramCanvas);
    }
  }
  
  public void setRoundStyle(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView
 * JD-Core Version:    0.7.0.1
 */