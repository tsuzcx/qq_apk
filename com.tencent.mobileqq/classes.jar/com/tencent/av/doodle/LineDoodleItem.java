package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LineDoodleItem
  extends PathDoodleItem
{
  private Paint l = new Paint();
  private Queue<LineDoodleItem.DistanceItem> m = new LinkedList();
  
  public LineDoodleItem()
  {
    this.l.setAntiAlias(true);
    this.l.setDither(true);
    this.l.setColor(-65536);
    this.l.setStyle(Paint.Style.STROKE);
    this.l.setStrokeJoin(Paint.Join.ROUND);
    this.l.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public void a()
  {
    this.m.offer(new LineDoodleItem.DistanceItem(this, this.k.getLength()));
  }
  
  public void a(long paramLong) {}
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.l.setColor(this.g);
    float f4 = this.e * 0.01111111F;
    this.l.setStrokeWidth(f4);
    this.l.setStyle(Paint.Style.STROKE);
    int i;
    if ((this.i != -1L) && (paramMySurfaceView.b - this.i > 1200L))
    {
      i = (int)(255L - (paramMySurfaceView.b - this.i - 1200L) * 255L / 800L);
      this.l.setAlpha(i);
    }
    else
    {
      this.l.setAlpha(255);
    }
    paramMySurfaceView = this.l;
    Object localObject1 = null;
    paramMySurfaceView.setMaskFilter(null);
    float f2 = this.k.getLength();
    float f1 = 0.0F;
    if (f2 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramCanvas.drawPath(this.j, this.l);
    } else {
      paramCanvas.drawPoint(this.h.x, this.h.y, this.l);
    }
    if ((paramBoolean) && (this.m.size() > 0))
    {
      long l1 = SystemClock.elapsedRealtime() - 500L;
      LineDoodleItem.DistanceItem localDistanceItem = (LineDoodleItem.DistanceItem)((LinkedList)this.m).getLast();
      Iterator localIterator = this.m.iterator();
      paramMySurfaceView = null;
      for (;;)
      {
        localObject2 = paramMySurfaceView;
        if (!localIterator.hasNext()) {
          break;
        }
        paramMySurfaceView = (LineDoodleItem.DistanceItem)localIterator.next();
        localObject2 = paramMySurfaceView;
        if (paramMySurfaceView.b - l1 >= 0L) {
          break;
        }
        localObject1 = paramMySurfaceView;
      }
      f2 = localDistanceItem.a;
      if (localObject2 != null) {
        if ((localObject1 != null) && (localObject1 != localObject2)) {
          f1 = (((LineDoodleItem.DistanceItem)localObject1).a * (float)(((LineDoodleItem.DistanceItem)localObject2).b - l1) + ((LineDoodleItem.DistanceItem)localObject2).a * (float)(l1 - ((LineDoodleItem.DistanceItem)localObject1).b)) / (float)(((LineDoodleItem.DistanceItem)localObject2).b - ((LineDoodleItem.DistanceItem)localObject1).b);
        } else {
          f1 = ((LineDoodleItem.DistanceItem)localObject2).a;
        }
      }
      float f3 = this.e * 0.01481482F * (float)(localDistanceItem.b - l1) / 500.0F;
      f4 /= 2.0F;
      localObject1 = new float[2];
      Object localObject2 = new float[2];
      paramMySurfaceView = new Path();
      this.l.setStyle(Paint.Style.FILL);
      this.l.setColor(-1);
      paramMySurfaceView.setFillType(Path.FillType.WINDING);
      float f5 = f2 - f1;
      float f6 = (f3 - f4) / f5;
      i = this.g;
      i = this.g;
      float f7 = this.e * 0.005555556F;
      paramMySurfaceView = localDistanceItem;
      while (f1 <= paramMySurfaceView.a)
      {
        this.k.getPosTan(f1, (float[])localObject1, (float[])localObject2);
        float f8 = f2 - f1;
        float f9 = f8 / f5;
        int j = DoodleUtils.a(new int[] { i, -1 }, 1.0F - f9);
        this.l.setColor(j);
        paramCanvas.drawCircle(localObject1[0], localObject1[1], f3 - f6 * f8, this.l);
        f1 += f7;
      }
      if (QLog.isColorLevel())
      {
        paramCanvas = this.a;
        paramMySurfaceView = new StringBuilder();
        paramMySurfaceView.append("doDrawDoodle, mScreenWidth[");
        paramMySurfaceView.append(this.e);
        paramMySurfaceView.append("], maxRadius[");
        paramMySurfaceView.append(f3);
        paramMySurfaceView.append("], minRadius[");
        paramMySurfaceView.append(f4);
        paramMySurfaceView.append("], mPoint[");
        paramMySurfaceView.append(this.h.x);
        paramMySurfaceView.append(", ");
        paramMySurfaceView.append(this.h.y);
        paramMySurfaceView.append("], startAnimationPathPointDistance[");
        paramMySurfaceView.append(f7);
        paramMySurfaceView.append("]");
        QLog.w(paramCanvas, 1, paramMySurfaceView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.LineDoodleItem
 * JD-Core Version:    0.7.0.1
 */