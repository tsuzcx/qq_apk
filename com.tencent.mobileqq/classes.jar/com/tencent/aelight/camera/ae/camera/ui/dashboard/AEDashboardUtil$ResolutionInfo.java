package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;
import java.util.Arrays;
import java.util.List;

public class AEDashboardUtil$ResolutionInfo
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public int j;
  public int k;
  public int l;
  public int m;
  public int n;
  
  private void a()
  {
    int i1 = this.f;
    double d1 = i1;
    Double.isNaN(d1);
    int i2 = this.e;
    double d2 = i2;
    Double.isNaN(d2);
    double d4 = d1 * 1.0D / d2;
    d1 = this.jdField_b_of_type_Int;
    Double.isNaN(d1);
    d2 = this.jdField_a_of_type_Int;
    Double.isNaN(d2);
    double d5 = d1 * 1.0D / d2;
    d1 = i2;
    double d3 = i1;
    if (d4 > d5)
    {
      Double.isNaN(d1);
      d2 = d5 * d1;
    }
    else
    {
      d2 = d3;
      if (d4 < d5)
      {
        d1 = 1.0D / d5;
        Double.isNaN(d3);
        d1 *= d3;
        d2 = d3;
      }
    }
    this.k = ((int)d1);
    this.l = ((int)d2);
  }
  
  private String h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return i();
    }
    return e();
  }
  
  private String i()
  {
    if ((this.j != 0) && (this.i != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.j);
      localStringBuilder.append("*");
      localStringBuilder.append(this.i);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Int != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("*");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public List<String> a()
  {
    a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("取景框大小: ");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject1).append("*");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("设置的预览分辨率: ");
    ((StringBuilder)localObject2).append(this.d);
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(this.c);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("设置的照片分辨率: ");
    ((StringBuilder)localObject3).append(this.f);
    ((StringBuilder)localObject3).append("*");
    ((StringBuilder)localObject3).append(this.e);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("普通渲染 & 截帧分辨率: ");
    ((StringBuilder)localObject4).append(this.h);
    ((StringBuilder)localObject4).append("*");
    ((StringBuilder)localObject4).append(this.g);
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("高清渲染 & 截帧分辨率: ");
    ((StringBuilder)localObject5).append(this.j);
    ((StringBuilder)localObject5).append("*");
    ((StringBuilder)localObject5).append(this.i);
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("大图拍照分辨率: ");
    ((StringBuilder)localObject6).append(this.l);
    ((StringBuilder)localObject6).append("*");
    ((StringBuilder)localObject6).append(this.k);
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("视频分辨率: ");
    localStringBuilder.append(this.n);
    localStringBuilder.append("*");
    localStringBuilder.append(this.m);
    return Arrays.asList(new String[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localStringBuilder.toString(), "预览帧率: TODO" });
  }
  
  public String b()
  {
    if ((this.d != 0) && (this.c != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d);
      localStringBuilder.append("*");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public String c()
  {
    if ((this.f != 0) && (this.e != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.f);
      localStringBuilder.append("*");
      localStringBuilder.append(this.e);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public String d()
  {
    if (this.jdField_b_of_type_Boolean) {
      return h();
    }
    return f();
  }
  
  public String e()
  {
    if ((this.h != 0) && (this.g != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.h);
      localStringBuilder.append("*");
      localStringBuilder.append(this.g);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public String f()
  {
    a();
    if ((this.l != 0) && (this.k != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.l);
      localStringBuilder.append("*");
      localStringBuilder.append(this.k);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  public String g()
  {
    if ((this.n != 0) && (this.m != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.n);
      localStringBuilder.append("*");
      localStringBuilder.append(this.m);
      return localStringBuilder.toString();
    }
    return "none";
  }
  
  @NonNull
  public String toString()
  {
    List localList = a();
    int i2 = localList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append((String)localList.get(i1));
      if (i1 < i2 - 1) {
        localStringBuilder.append("\n");
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEDashboardUtil.ResolutionInfo
 * JD-Core Version:    0.7.0.1
 */