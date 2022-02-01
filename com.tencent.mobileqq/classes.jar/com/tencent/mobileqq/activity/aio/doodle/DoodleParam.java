package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class DoodleParam
  implements MyParcelable
{
  public static final MyParcelable.Creator<DoodleParam> a;
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityAioDoodleMyParcelable$Creator = new DoodleParam.1();
  }
  
  public DoodleParam()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    float f = this.jdField_a_of_type_Int / 750.0F;
    this.jdField_a_of_type_Float = (12.0F * f);
    this.b = (f * 6.0F);
    this.c = (Utils.a(50.0F, localBaseApplication.getResources()) / 1000.0F);
    this.d = (Utils.a(0.4F, localBaseApplication.getResources()) / 1000.0F);
  }
  
  public DoodleParam(MyParcel paramMyParcel)
  {
    paramMyParcel.a();
    this.jdField_a_of_type_AndroidGraphicsRect = paramMyParcel.a();
    this.jdField_a_of_type_Float = paramMyParcel.a();
    this.b = paramMyParcel.a();
    this.c = paramMyParcel.a();
    this.d = paramMyParcel.a();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = (float)paramLong / 1000.0F;
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    if (paramFloat1 <= 0.0F) {
      return a();
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    paramFloat1 = f / paramFloat1;
    int i;
    if (this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) {
      i = this.jdField_a_of_type_AndroidGraphicsRect.width();
    } else {
      i = this.jdField_a_of_type_Int;
    }
    paramFloat1 *= Utils.a(i, localBaseApplication.getResources());
    paramFloat2 = c();
    paramFloat3 = d();
    paramFloat4 = b();
    f = a();
    if (paramFloat1 > paramFloat2) {
      return f;
    }
    if (paramFloat1 < paramFloat3) {
      return paramFloat4;
    }
    return paramFloat4 + (paramFloat1 - paramFloat3) * (a() - paramFloat4) / (paramFloat2 - paramFloat3);
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramInt1, paramInt2);
  }
  
  public void a(DoodleParam paramDoodleParam)
  {
    this.c = paramDoodleParam.c();
    this.d = paramDoodleParam.d();
    this.jdField_a_of_type_Float = paramDoodleParam.a();
    this.b = paramDoodleParam.b();
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramDoodleParam.a());
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.jdField_a_of_type_AndroidGraphicsRect);
    paramMyParcel.a(this.jdField_a_of_type_Float);
    paramMyParcel.a(this.b);
    paramMyParcel.a(this.c);
    paramMyParcel.a(this.d);
  }
  
  public void a(PathData paramPathData)
  {
    if (paramPathData == null) {
      return;
    }
    ArrayList localArrayList = paramPathData.a();
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 1;
      if (j == 1)
      {
        ((PathData.PointData)localArrayList.get(0)).c(a());
        return;
      }
      if (j > 1)
      {
        ((PathData.PointData)localArrayList.get(0)).c(a());
        PathData.PointData localPointData;
        for (paramPathData = (PathData.PointData)localArrayList.get(0); i < j; paramPathData = localPointData)
        {
          localPointData = (PathData.PointData)localArrayList.get(i);
          localPointData.c(a(localPointData.a() - paramPathData.a(), paramPathData.a(), paramPathData.b(), localPointData.a(), localPointData.b()));
          i += 1;
        }
      }
    }
  }
  
  public float b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public float c()
  {
    return this.c;
  }
  
  public void c(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public float d()
  {
    return this.d;
  }
  
  public void d(float paramFloat)
  {
    this.d = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleParam
 * JD-Core Version:    0.7.0.1
 */