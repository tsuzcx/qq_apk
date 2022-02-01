package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PathDrawer
  implements MyParcelable
{
  public static final MyParcelable.Creator<PathDrawer> a;
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private PathAlgorithm jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = null;
  private PathData.PointData jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData = null;
  private ArrayList<PathDrawer.PathSegment> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<PathData.PointData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = -1;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator = new PathDrawer.1();
  }
  
  public PathDrawer(MyParcel paramMyParcel)
  {
    this.jdField_a_of_type_Int = -1;
    paramMyParcel.a();
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      paramMyParcel.a(localList, PathData.PointData.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator);
    }
    paramMyParcel.a(this.jdField_a_of_type_JavaUtilArrayList, PathDrawer.PathSegment.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator);
    int i = paramMyParcel.a();
    a(paramMyParcel.a(), i);
    this.jdField_a_of_type_AndroidGraphicsRect = paramMyParcel.a();
    this.jdField_b_of_type_AndroidGraphicsRect = paramMyParcel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData = ((PathData.PointData)paramMyParcel.a(PathData.PointData.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator));
    this.jdField_a_of_type_Int = paramMyParcel.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = new HalfAlgorithm();
    paramMyParcel = this.jdField_a_of_type_JavaUtilList;
    if (paramMyParcel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm.a(paramMyParcel, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_JavaUtilList = null;
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = null;
    if ((!this.jdField_b_of_type_AndroidGraphicsRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)) && (this.jdField_b_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsRect != null))
    {
      float f = a();
      paramMyParcel = new StringBuilder();
      paramMyParcel.append("scale:");
      paramMyParcel.append(f);
      QLog.d("PathDrawer", 2, paramMyParcel.toString());
      a(f, false);
      return;
    }
    QLog.d("PathDrawer", 2, "data area equal draw area, no scale.");
  }
  
  public PathDrawer(PathData paramPathData, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramPathData.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
    this.jdField_a_of_type_JavaUtilList.addAll(paramPathData.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = new HalfAlgorithm();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm.a(paramInt5, paramInt6, paramFloat);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm.a(paramPathData.a(), this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList, 1000);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("after transPath, segments count:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    QLog.d("PathDrawer", 2, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = null;
    if (paramPathData.c() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData = new PathData.PointData(paramPathData.a());
    }
    a(paramPathData.b(), paramPathData.a());
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      a(0, 0, paramInt3, paramInt4);
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
  }
  
  private float a()
  {
    float f1 = this.jdField_b_of_type_AndroidGraphicsRect.width() * 1.0F / this.jdField_a_of_type_AndroidGraphicsRect.width();
    float f2 = this.jdField_b_of_type_AndroidGraphicsRect.height() * 1.0F / this.jdField_a_of_type_AndroidGraphicsRect.height();
    if (f1 < f2) {
      return f1;
    }
    return f2;
  }
  
  private int a(long paramLong, boolean paramBoolean)
  {
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (k == 0) {
      return -1;
    }
    int j = 0;
    long l;
    if (k == 1)
    {
      l = ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(0)).a();
      if (paramBoolean)
      {
        if (l >= paramLong) {
          return 0;
        }
        return -1;
      }
      if (l > paramLong) {
        return 0;
      }
      return -1;
    }
    int i = k;
    if (((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(k - 1)).a() < paramLong) {
      return -1;
    }
    while (i > j)
    {
      k = (i + j) / 2;
      l = ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
      if (l == paramLong)
      {
        if (paramBoolean) {
          return k - ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
        }
        i = k + 1;
        while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (l >= ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a())) {
          i += 1;
        }
        if (i == this.jdField_a_of_type_JavaUtilArrayList.size()) {
          return -1;
        }
        return i;
      }
      if (l < paramLong) {
        j = k + 1;
      } else if (l > paramLong) {
        i = k - ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
      }
    }
    return i - ((PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    a(paramInt1);
    b(paramInt2);
  }
  
  private void a(Canvas paramCanvas, PathData.PointData paramPointData)
  {
    if ((paramCanvas != null) && (paramPointData != null))
    {
      Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (localPaint != null)
      {
        localPaint.setStrokeWidth(paramPointData.c() / 2.0F);
        paramCanvas.drawCircle(paramPointData.a(), paramPointData.b(), paramPointData.c() / 4.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  private void a(Canvas paramCanvas, PathDrawer.PathSegment paramPathSegment)
  {
    if (paramCanvas != null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramPathSegment.a());
      paramCanvas.drawPath(paramPathSegment.a(), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return ((PathDrawer.PathSegment)localArrayList.get(localArrayList.size() - 1)).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData != null) {}
    return 0L;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData = null;
    this.jdField_b_of_type_Int = -1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData = new PathData.PointData(paramFloat1, paramFloat2, paramFloat3, paramLong);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = new HalfAlgorithm();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm.a(paramFloat1, paramFloat2, paramFloat3, 0L, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())
    {
      localObject1 = new Matrix();
      ((Matrix)localObject1).postScale(paramFloat, paramFloat);
      localObject2 = new Path();
      ((Path)localObject2).addPath(this.jdField_a_of_type_AndroidGraphicsPath, (Matrix)localObject1);
      this.jdField_a_of_type_AndroidGraphicsPath = ((Path)localObject2);
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PathDrawer.PathSegment)((Iterator)localObject1).next();
        ((PathDrawer.PathSegment)localObject2).c(paramFloat);
        if (paramBoolean) {
          ((PathDrawer.PathSegment)localObject2).a(((PathDrawer.PathSegment)localObject2).a() * paramFloat);
        }
      }
    }
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
      if (localObject1 != null) {
        ((PathData.PointData)localObject1).d(paramFloat);
      }
    }
  }
  
  public void a(int paramInt)
  {
    b(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 - paramInt1;
    if (i != 0)
    {
      int j = paramInt4 - paramInt2;
      if (j == 0) {
        return;
      }
      Object localObject = this.jdField_b_of_type_AndroidGraphicsRect;
      if (localObject == null) {
        return;
      }
      if ((((Rect)localObject).width() == i) && (this.jdField_b_of_type_AndroidGraphicsRect.height() == j))
      {
        QLog.d("PathDrawer", 2, "draw area not change.");
        return;
      }
      if ((!this.jdField_b_of_type_AndroidGraphicsRect.isEmpty()) && (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty()) && (!this.jdField_b_of_type_AndroidGraphicsRect.equals(this.jdField_a_of_type_AndroidGraphicsRect))) {
        f1 = a();
      } else {
        f1 = 1.0F;
      }
      this.jdField_b_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setArea:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsRect);
      QLog.d("PathDrawer", 2, ((StringBuilder)localObject).toString());
      float f2 = a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scale:");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append("  Old:");
      ((StringBuilder)localObject).append(f1);
      QLog.d("PathDrawer", 2, ((StringBuilder)localObject).toString());
      float f1 = f2 / f1;
      double d = f1 - 1.0F;
      if ((d < 1.0E-006D) && (d > -1.0E-006D)) {
        QLog.d("PathDrawer", 2, "scale no change, return:");
      }
      a(f1, true);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
      if (localObject != null) {
        a(paramCanvas, (PathData.PointData)localObject);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      a(paramCanvas, (PathDrawer.PathSegment)((Iterator)localObject).next());
    }
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.jdField_a_of_type_JavaUtilList);
    paramMyParcel.a(this.jdField_a_of_type_JavaUtilArrayList);
    paramMyParcel.a(this.jdField_b_of_type_Int);
    paramMyParcel.a(this.jdField_a_of_type_AndroidGraphicsPaint.getColor());
    paramMyParcel.a(this.jdField_a_of_type_AndroidGraphicsRect);
    paramMyParcel.a(this.jdField_b_of_type_AndroidGraphicsRect);
    paramMyParcel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData);
    paramMyParcel.a(this.jdField_a_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    PathAlgorithm localPathAlgorithm = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm;
    if (localPathAlgorithm != null)
    {
      if (!paramBoolean)
      {
        localPathAlgorithm.a(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
        return;
      }
      localPathAlgorithm.a(this.jdField_a_of_type_JavaUtilArrayList, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm = null;
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (!this.jdField_a_of_type_AndroidGraphicsPath.isEmpty())) || ((this.jdField_a_of_type_JavaUtilArrayList.size() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData != null));
  }
  
  public boolean a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      return false;
    }
    if (paramInt1 > paramInt2) {
      return false;
    }
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    PathData.PointData localPointData;
    if ((paramInt2 == 0) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      localPointData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
      if (localPointData != null) {
        a(paramCanvas, localPointData);
      }
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (i == 0)
      {
        localPointData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
        if (localPointData != null) {
          a(paramCanvas, localPointData);
        }
      }
      return false;
    }
    int j = i;
    paramInt1 = paramInt2;
    if (paramInt2 > this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramInt1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      j = i;
    }
    while (j < paramInt1)
    {
      a(paramCanvas, (PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(j));
      j += 1;
    }
    return paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public boolean a(Canvas paramCanvas, long paramLong1, long paramLong2)
  {
    if (paramLong2 < 0L) {
      return false;
    }
    if (paramLong1 > paramLong2) {
      return false;
    }
    long l = paramLong1;
    if (paramLong1 < 0L) {
      l = 0L;
    }
    PathData.PointData localPointData;
    if ((paramLong2 == 0L) && (this.jdField_a_of_type_JavaUtilArrayList.size() == 0))
    {
      localPointData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
      if (localPointData != null) {
        a(paramCanvas, localPointData);
      }
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
    {
      if (l == 0L)
      {
        localPointData = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData;
        if (localPointData != null) {
          a(paramCanvas, localPointData);
        }
      }
      return false;
    }
    if ((paramLong2 == 0L) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
      return true;
    }
    int k = a(l, true);
    int m = a(paramLong2, false);
    if (k < 0) {
      return true;
    }
    int j;
    int i;
    if (m < 0)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = k;
    }
    else
    {
      i = k;
      j = m;
      if (m == k)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= m) {
          return true;
        }
        a(paramCanvas, (PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(k));
        return false;
      }
    }
    while (i < j)
    {
      a(paramCanvas, (PathDrawer.PathSegment)this.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    return j < this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathData$PointData != null) {
      return 1;
    }
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    PathAlgorithm localPathAlgorithm = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodlePathAlgorithm;
    if (localPathAlgorithm != null) {
      localPathAlgorithm.b(paramFloat1, paramFloat2, paramFloat3, paramLong, this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
      Object localObject = DoodleResHelper.a().a(0, paramInt);
      if (localObject != null)
      {
        localObject = new BitmapShader((Bitmap)localObject, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader((Shader)localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
    }
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.PathDrawer
 * JD-Core Version:    0.7.0.1
 */