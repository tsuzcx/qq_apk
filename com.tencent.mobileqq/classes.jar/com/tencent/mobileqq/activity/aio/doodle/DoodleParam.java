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
  public static final MyParcelable.Creator<DoodleParam> a = new DoodleParam.1();
  private Rect b = new Rect();
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private int g = 0;
  
  public DoodleParam()
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    DisplayMetrics localDisplayMetrics = localBaseApplication.getResources().getDisplayMetrics();
    this.g = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    float f1 = this.g / 750.0F;
    this.c = (12.0F * f1);
    this.d = (f1 * 6.0F);
    this.e = (Utils.b(50.0F, localBaseApplication.getResources()) / 1000.0F);
    this.f = (Utils.b(0.4F, localBaseApplication.getResources()) / 1000.0F);
  }
  
  public DoodleParam(MyParcel paramMyParcel)
  {
    paramMyParcel.b();
    this.b = paramMyParcel.c();
    this.c = paramMyParcel.d();
    this.d = paramMyParcel.d();
    this.e = paramMyParcel.d();
    this.f = paramMyParcel.d();
  }
  
  public float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = (float)paramLong / 1000.0F;
    paramFloat1 = paramFloat3 - paramFloat1;
    paramFloat2 = paramFloat4 - paramFloat2;
    paramFloat1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
    if (paramFloat1 <= 0.0F) {
      return b();
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    paramFloat1 = f1 / paramFloat1;
    int i;
    if (this.b.width() > 0) {
      i = this.b.width();
    } else {
      i = this.g;
    }
    paramFloat1 *= Utils.a(i, localBaseApplication.getResources());
    paramFloat2 = d();
    paramFloat3 = e();
    paramFloat4 = c();
    f1 = b();
    if (paramFloat1 > paramFloat2) {
      return f1;
    }
    if (paramFloat1 < paramFloat3) {
      return paramFloat4;
    }
    return paramFloat4 + (paramFloat1 - paramFloat3) * (b() - paramFloat4) / (paramFloat2 - paramFloat3);
  }
  
  public Rect a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.set(0, 0, paramInt1, paramInt2);
  }
  
  public void a(DoodleParam paramDoodleParam)
  {
    this.e = paramDoodleParam.d();
    this.f = paramDoodleParam.e();
    this.c = paramDoodleParam.b();
    this.d = paramDoodleParam.c();
    this.b.set(paramDoodleParam.a());
  }
  
  public void a(MyParcel paramMyParcel, int paramInt)
  {
    paramMyParcel.a(1);
    paramMyParcel.a(this.b);
    paramMyParcel.a(this.c);
    paramMyParcel.a(this.d);
    paramMyParcel.a(this.e);
    paramMyParcel.a(this.f);
  }
  
  public void a(PathData paramPathData)
  {
    if (paramPathData == null) {
      return;
    }
    ArrayList localArrayList = paramPathData.e();
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      int i = 1;
      if (j == 1)
      {
        ((PathData.PointData)localArrayList.get(0)).c(b());
        return;
      }
      if (j > 1)
      {
        ((PathData.PointData)localArrayList.get(0)).c(b());
        PathData.PointData localPointData;
        for (paramPathData = (PathData.PointData)localArrayList.get(0); i < j; paramPathData = localPointData)
        {
          localPointData = (PathData.PointData)localArrayList.get(i);
          localPointData.c(a(localPointData.d() - paramPathData.d(), paramPathData.a(), paramPathData.b(), localPointData.a(), localPointData.b()));
          i += 1;
        }
      }
    }
  }
  
  public float b()
  {
    return this.c;
  }
  
  public void b(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public float c()
  {
    return this.d;
  }
  
  public void c(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public float d()
  {
    return this.e;
  }
  
  public void d(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public float e()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleParam
 * JD-Core Version:    0.7.0.1
 */