package com.tencent.mobileqq.armap.sensor.rotation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrientationCalculator
{
  private Matrix4 jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
  private Vector3 jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3 = new Vector3();
  private Vector4 jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4 = new Vector4();
  private ArrayList<Vector3> jdField_a_of_type_JavaUtilArrayList = new ArrayList(793);
  private List<Vector3> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Matrix4 jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4 = new Matrix4();
  private Vector3 jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3 = new Vector3();
  private ArrayList<Vector3> jdField_b_of_type_JavaUtilArrayList = null;
  private Vector3 c = new Vector3();
  private Vector3 d = new Vector3();
  private Vector3 e = new Vector3();
  private Vector3 f = new Vector3();
  private Vector3 g = new Vector3();
  private Vector3 h = new Vector3();
  private Vector3 i = new Vector3();
  private Vector3 j = new Vector3();
  private Vector3 k = new Vector3();
  
  public OrientationCalculator()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.setToOrtho2D(0.0F, 0.0F, 1.0F, -1.0F);
    int m = 0;
    while (m < 792)
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(new Vector3());
      m += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_JavaUtilList.add(this.e);
    this.jdField_a_of_type_JavaUtilList.add(this.f);
    this.jdField_a_of_type_JavaUtilList.add(this.g);
  }
  
  private void a()
  {
    this.e.set(0.0F, 0.0F, 1.0F);
    this.f.set(0.0F, 0.0F, -1.0F);
    Object localObject = this.jdField_b_of_type_JavaUtilArrayList;
    int m = 0;
    if (localObject == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(793);
      m = 0;
      while (m < 11)
      {
        n = (m - 5) * 15;
        float f1 = (float)Math.cos(n * 0.01745329F);
        float f2 = (float)Math.cos((90 - n) * 0.01745329F);
        n = 0;
        while (n < 72)
        {
          double d1 = n * 5 * 0.01745329F;
          localObject = new Vector3((float)Math.sin(d1) * f1 * 1.0F, -(float)Math.cos(d1) * f1 * 1.0F, f2 * 1.0F);
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          ((Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(m * 72 + n)).set((Vector3)localObject);
          n += 1;
        }
        m += 1;
      }
    }
    int n = this.jdField_a_of_type_JavaUtilArrayList.size();
    while (m < n)
    {
      ((Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(m)).set((Vector3)this.jdField_b_of_type_JavaUtilArrayList.get(m));
      m += 1;
    }
    this.g.set((Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(360));
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt)
  {
    a();
    this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4.idt().mul(this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationMatrix4).mul(paramMatrix4);
    Vector3 localVector3;
    if ((paramInt != 0) && (paramInt != 1)) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        paramMatrix4 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramMatrix4.hasNext())
        {
          localVector3 = (Vector3)paramMatrix4.next();
          this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
          this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a(this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4);
          localVector3.x = (-this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a * 500.0F + 500.0F);
          localVector3.y = (-this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.b * 500.0F + 500.0F + 0.0F);
          localVector3.z = (this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.c * 500.0F);
        }
      }
    }
    paramMatrix4 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramMatrix4.hasNext())
    {
      localVector3 = (Vector3)paramMatrix4.next();
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a(this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationMatrix4);
      localVector3.x = (this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.a * 500.0F + 500.0F);
      localVector3.y = (this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.b * 500.0F + 500.0F + 0.0F);
      localVector3.z = (this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector4.c * 500.0F);
    }
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt, float[] paramArrayOfFloat)
  {
    a(paramMatrix4, paramInt);
    Vector3 localVector3 = this.f;
    this.d.set(500.0F, 500.0F, -1000.0F);
    this.c.set(500.0F, 500.0F, 0.0F);
    float f2 = Util.a(this.d, this.f);
    float f3 = Util.a(this.d, this.e);
    float f5 = Util.a(this.c, this.f);
    float f4 = Util.a(this.c, this.d);
    float f1 = Util.a(this.f, this.d);
    f1 = Util.a(f1, Util.a(f5, f4, f1)) * 57.29578F - 90.0F;
    if (f2 > f3) {
      f1 = -f1;
    }
    f3 = f1;
    if (Float.isNaN(f1)) {
      f3 = 0.0F;
    }
    this.d.set(500.0F, 500.0F, -1000.0F);
    float f6;
    label341:
    double d1;
    if (Math.abs(f3) < 75.0F)
    {
      paramInt = 0;
      int m = 0;
      for (f1 = 3.4028235E+38F; paramInt < 792; f1 = f2)
      {
        paramMatrix4 = (Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        n = m;
        f2 = f1;
        if (paramMatrix4.z < 0.0F)
        {
          f6 = Util.a(this.d, paramMatrix4);
          n = m;
          f2 = f1;
          if (f6 < f1)
          {
            f2 = f6;
            n = paramInt;
          }
        }
        paramInt += 1;
        m = n;
      }
      int i1 = m % 72;
      if (i1 == 0) {
        paramInt = m + 1;
      }
      for (int n = m + 72;; n = m - 72)
      {
        n -= 1;
        break label341;
        paramInt = m + 1;
        if (paramInt % 72 != 0) {
          break;
        }
        paramInt = m - 1;
      }
      n = m - 1;
      if ((paramInt >= 0) && (n >= 0) && (paramInt < 792) && (n < 792))
      {
        f2 = Util.a(this.d, (Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
        f4 = Util.a(this.d, (Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(n));
        if (f2 >= f4)
        {
          paramInt = n;
          f2 = f4;
        }
        if (paramInt < m ? ((m + 1) % 72 != 0) && (paramInt != n) : (i1 == 0) && (paramInt == n))
        {
          n = paramInt;
          f4 = f1;
          f1 = f2;
          f2 = f4;
        }
        else
        {
          n = m;
        }
      }
      else
      {
        f1 = f5;
        f2 = f4;
        n = 0;
        paramInt = 0;
      }
      paramMatrix4 = localVector3;
      if (paramInt <= 791)
      {
        paramMatrix4 = localVector3;
        if (paramInt >= 0) {
          paramMatrix4 = (Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
        }
      }
      f4 = n % 72;
      f5 = Util.a((Vector3)this.jdField_a_of_type_JavaUtilArrayList.get(m), paramMatrix4);
      d1 = f4 * 5.0F;
      double d2 = 5.0F;
      double d3 = Math.cos(Util.b(f2, Util.a(f1, f2, f5)));
      double d4 = f1;
      Double.isNaN(d4);
      double d5 = f5;
      Double.isNaN(d5);
      d3 = d3 * d4 / d5;
      Double.isNaN(d2);
      Double.isNaN(d1);
      f1 = Util.a(d1 + d2 * d3 - 180.0D);
    }
    else
    {
      this.h.set(500.0F, 200.0F, 0.0F);
      this.i.set(500.0F, 800.0F, 0.0F);
      this.j.set(200.0F, 500.0F, 0.0F);
      this.k.set(800.0F, 500.0F, 0.0F);
      f1 = Util.a(this.g, this.h);
      f6 = Util.a(this.g, this.i);
      f4 = Util.a(this.g, this.j);
      f5 = Util.a(this.g, this.k);
      f2 = Util.a(this.c, this.g);
      float f7 = Util.a(this.c, this.h);
      float f8 = Util.a(this.g, this.h);
      f2 = -Util.a(f8, Util.a(f2, f7, f8)) * 57.29578F;
      if (f1 < f6)
      {
        f1 = f2;
        if (f4 < f5) {
          f1 = 360.0F - f2;
        }
      }
      else if (f4 < f5)
      {
        f1 = f2 + 180.0F;
      }
      else
      {
        f1 = 180.0F - f2;
      }
      f2 = f1;
      if (f3 > 0.0F) {
        f2 = 180.0F - f1;
      }
      f1 = Util.a(f2);
    }
    f2 = f1;
    if (Float.isNaN(f1)) {
      f2 = 0.0F;
    }
    if (Math.abs(f3) < 75.0F)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3.set(500.0F, 200.0F, 0.0F);
      this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3.set(500.0F, 800.0F, 0.0F);
      if (f3 < 0.0F)
      {
        paramMatrix4 = this.jdField_b_of_type_ComTencentMobileqqArmapSensorRotationVector3;
        localVector3 = this.e;
        paramInt = 0;
      }
      else
      {
        paramMatrix4 = this.jdField_a_of_type_ComTencentMobileqqArmapSensorRotationVector3;
        localVector3 = this.f;
        paramInt = 1;
      }
      f1 = (float)Math.sqrt((paramMatrix4.x - this.c.x) * (paramMatrix4.x - this.c.x) + (paramMatrix4.y - this.c.y) * (paramMatrix4.y - this.c.y));
      f4 = (float)Math.sqrt((paramMatrix4.x - localVector3.x) * (paramMatrix4.x - localVector3.x) + (paramMatrix4.y - localVector3.y) * (paramMatrix4.y - localVector3.y));
      f5 = (float)Math.sqrt((this.c.x - localVector3.x) * (this.c.x - localVector3.x) + (this.c.y - localVector3.y) * (this.c.y - localVector3.y));
      f1 = (f1 * f1 + f5 * f5 - f4 * f4) / (f1 * 2.0F * f5);
      if (f1 < 1.0F)
      {
        f4 = (float)Math.acos(f1) * 57.29578F;
        if (paramInt != 0)
        {
          f1 = f4;
          if (paramMatrix4.x - localVector3.x >= 0.0F) {
            break label1248;
          }
        }
        else
        {
          f1 = f4;
          if (paramMatrix4.x - localVector3.x <= 0.0F) {
            break label1248;
          }
        }
        f1 = -f4;
        label1248:
        f1 = Util.a(f1);
        if ((f1 > 3.0F) && (f1 < 357.0F))
        {
          d1 = f1;
          Double.isNaN(d1);
          f1 = (float)Math.round(d1 / 0.5D) * 0.5F;
          break label1307;
        }
      }
    }
    f1 = 0.0F;
    label1307:
    f4 = f1;
    if (Float.isNaN(f1)) {
      f4 = 0.0F;
    }
    paramArrayOfFloat[0] = f2;
    paramArrayOfFloat[1] = f3;
    paramArrayOfFloat[2] = f4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.OrientationCalculator
 * JD-Core Version:    0.7.0.1
 */