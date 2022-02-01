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
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Queue<LineDoodleItem.DistanceItem> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public LineDoodleItem()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilQueue.offer(new LineDoodleItem.DistanceItem(this, this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength()));
  }
  
  public void a(long paramLong) {}
  
  public void b(Canvas paramCanvas, MySurfaceView paramMySurfaceView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    float f4 = this.c * 0.01111111F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f4);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    int i;
    if ((this.jdField_a_of_type_Long != -1L) && (paramMySurfaceView.jdField_a_of_type_Long - this.jdField_a_of_type_Long > 1200L))
    {
      i = (int)(255L - (paramMySurfaceView.jdField_a_of_type_Long - this.jdField_a_of_type_Long - 1200L) * 255L / 800L);
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    }
    paramMySurfaceView = this.jdField_a_of_type_AndroidGraphicsPaint;
    Object localObject1 = null;
    paramMySurfaceView.setMaskFilter(null);
    float f2 = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    float f1 = 0.0F;
    if (f2 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    } else {
      paramCanvas.drawPoint(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilQueue.size() > 0))
    {
      long l = SystemClock.elapsedRealtime() - 500L;
      LineDoodleItem.DistanceItem localDistanceItem = (LineDoodleItem.DistanceItem)((LinkedList)this.jdField_a_of_type_JavaUtilQueue).getLast();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      paramMySurfaceView = null;
      for (;;)
      {
        localObject2 = paramMySurfaceView;
        if (!localIterator.hasNext()) {
          break;
        }
        paramMySurfaceView = (LineDoodleItem.DistanceItem)localIterator.next();
        localObject2 = paramMySurfaceView;
        if (paramMySurfaceView.jdField_a_of_type_Long - l >= 0L) {
          break;
        }
        localObject1 = paramMySurfaceView;
      }
      f2 = localDistanceItem.jdField_a_of_type_Float;
      if (localObject2 != null) {
        if ((localObject1 != null) && (localObject1 != localObject2)) {
          f1 = (((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Float * (float)(((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Long - l) + ((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Float * (float)(l - ((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Long)) / (float)(((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Long - ((LineDoodleItem.DistanceItem)localObject1).jdField_a_of_type_Long);
        } else {
          f1 = ((LineDoodleItem.DistanceItem)localObject2).jdField_a_of_type_Float;
        }
      }
      float f3 = this.c * 0.01481482F * (float)(localDistanceItem.jdField_a_of_type_Long - l) / 500.0F;
      f4 /= 2.0F;
      localObject1 = new float[2];
      Object localObject2 = new float[2];
      paramMySurfaceView = new Path();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramMySurfaceView.setFillType(Path.FillType.WINDING);
      float f5 = f2 - f1;
      float f6 = (f3 - f4) / f5;
      i = this.e;
      i = this.e;
      float f7 = this.c * 0.005555556F;
      paramMySurfaceView = localDistanceItem;
      while (f1 <= paramMySurfaceView.jdField_a_of_type_Float)
      {
        this.jdField_a_of_type_AndroidGraphicsPathMeasure.getPosTan(f1, (float[])localObject1, (float[])localObject2);
        float f8 = f2 - f1;
        float f9 = f8 / f5;
        int j = DoodleUtils.a(new int[] { i, -1 }, 1.0F - f9);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(j);
        paramCanvas.drawCircle(localObject1[0], localObject1[1], f3 - f6 * f8, this.jdField_a_of_type_AndroidGraphicsPaint);
        f1 += f7;
      }
      if (QLog.isColorLevel())
      {
        paramCanvas = this.jdField_a_of_type_JavaLangString;
        paramMySurfaceView = new StringBuilder();
        paramMySurfaceView.append("doDrawDoodle, mScreenWidth[");
        paramMySurfaceView.append(this.c);
        paramMySurfaceView.append("], maxRadius[");
        paramMySurfaceView.append(f3);
        paramMySurfaceView.append("], minRadius[");
        paramMySurfaceView.append(f4);
        paramMySurfaceView.append("], mPoint[");
        paramMySurfaceView.append(this.jdField_a_of_type_AndroidGraphicsPointF.x);
        paramMySurfaceView.append(", ");
        paramMySurfaceView.append(this.jdField_a_of_type_AndroidGraphicsPointF.y);
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