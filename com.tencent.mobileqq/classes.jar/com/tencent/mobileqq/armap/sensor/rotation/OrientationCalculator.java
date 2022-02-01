package com.tencent.mobileqq.armap.sensor.rotation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrientationCalculator
{
  private ArrayList<Vector3> a = new ArrayList(793);
  private Vector3 b = new Vector3();
  private Vector3 c = new Vector3();
  private Vector3 d = new Vector3();
  private Vector3 e = new Vector3();
  private Vector3 f = new Vector3();
  private Vector3 g = new Vector3();
  private Vector3 h = new Vector3();
  private Vector3 i = new Vector3();
  private Vector3 j = new Vector3();
  private Vector3 k = new Vector3();
  private Vector3 l = new Vector3();
  private Matrix4 m = new Matrix4();
  private Matrix4 n = new Matrix4();
  private List<Vector3> o = new ArrayList();
  private Vector4 p = new Vector4();
  private ArrayList<Vector3> q = null;
  
  public OrientationCalculator()
  {
    this.m.setToOrtho2D(0.0F, 0.0F, 1.0F, -1.0F);
    int i1 = 0;
    while (i1 < 792)
    {
      this.a.add(new Vector3());
      i1 += 1;
    }
    this.o.addAll(this.a);
    this.o.add(this.f);
    this.o.add(this.g);
    this.o.add(this.h);
  }
  
  private void a()
  {
    this.f.set(0.0F, 0.0F, 1.0F);
    this.g.set(0.0F, 0.0F, -1.0F);
    Object localObject = this.q;
    int i1 = 0;
    if (localObject == null)
    {
      this.q = new ArrayList(793);
      i1 = 0;
      while (i1 < 11)
      {
        i2 = (i1 - 5) * 15;
        float f1 = (float)Math.cos(i2 * 0.01745329F);
        float f2 = (float)Math.cos((90 - i2) * 0.01745329F);
        i2 = 0;
        while (i2 < 72)
        {
          double d1 = i2 * 5 * 0.01745329F;
          localObject = new Vector3((float)Math.sin(d1) * f1 * 1.0F, -(float)Math.cos(d1) * f1 * 1.0F, f2 * 1.0F);
          this.q.add(localObject);
          ((Vector3)this.a.get(i1 * 72 + i2)).set((Vector3)localObject);
          i2 += 1;
        }
        i1 += 1;
      }
    }
    int i2 = this.a.size();
    while (i1 < i2)
    {
      ((Vector3)this.a.get(i1)).set((Vector3)this.q.get(i1));
      i1 += 1;
    }
    this.h.set((Vector3)this.a.get(360));
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt)
  {
    a();
    this.n.idt().mul(this.m).mul(paramMatrix4);
    Vector3 localVector3;
    if ((paramInt != 0) && (paramInt != 1)) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        paramMatrix4 = this.o.iterator();
        while (paramMatrix4.hasNext())
        {
          localVector3 = (Vector3)paramMatrix4.next();
          this.p.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
          this.p.a(this.n);
          localVector3.x = (-this.p.a * 500.0F + 500.0F);
          localVector3.y = (-this.p.b * 500.0F + 500.0F + 0.0F);
          localVector3.z = (this.p.c * 500.0F);
        }
      }
    }
    paramMatrix4 = this.o.iterator();
    while (paramMatrix4.hasNext())
    {
      localVector3 = (Vector3)paramMatrix4.next();
      this.p.a(localVector3.x, -localVector3.y, -localVector3.z, 0.0F);
      this.p.a(this.n);
      localVector3.x = (this.p.a * 500.0F + 500.0F);
      localVector3.y = (this.p.b * 500.0F + 500.0F + 0.0F);
      localVector3.z = (this.p.c * 500.0F);
    }
  }
  
  public void a(Matrix4 paramMatrix4, int paramInt, float[] paramArrayOfFloat)
  {
    a(paramMatrix4, paramInt);
    Vector3 localVector3 = this.g;
    this.e.set(500.0F, 500.0F, -1000.0F);
    this.d.set(500.0F, 500.0F, 0.0F);
    float f2 = Util.a(this.e, this.g);
    float f3 = Util.a(this.e, this.f);
    float f5 = Util.a(this.d, this.g);
    float f4 = Util.a(this.d, this.e);
    float f1 = Util.a(this.g, this.e);
    f1 = Util.a(f1, Util.a(f5, f4, f1)) * 57.29578F - 90.0F;
    if (f2 > f3) {
      f1 = -f1;
    }
    f3 = f1;
    if (Float.isNaN(f1)) {
      f3 = 0.0F;
    }
    this.e.set(500.0F, 500.0F, -1000.0F);
    float f6;
    label341:
    double d1;
    if (Math.abs(f3) < 75.0F)
    {
      paramInt = 0;
      int i1 = 0;
      for (f1 = 3.4028235E+38F; paramInt < 792; f1 = f2)
      {
        paramMatrix4 = (Vector3)this.a.get(paramInt);
        i2 = i1;
        f2 = f1;
        if (paramMatrix4.z < 0.0F)
        {
          f6 = Util.a(this.e, paramMatrix4);
          i2 = i1;
          f2 = f1;
          if (f6 < f1)
          {
            f2 = f6;
            i2 = paramInt;
          }
        }
        paramInt += 1;
        i1 = i2;
      }
      int i3 = i1 % 72;
      if (i3 == 0) {
        paramInt = i1 + 1;
      }
      for (int i2 = i1 + 72;; i2 = i1 - 72)
      {
        i2 -= 1;
        break label341;
        paramInt = i1 + 1;
        if (paramInt % 72 != 0) {
          break;
        }
        paramInt = i1 - 1;
      }
      i2 = i1 - 1;
      if ((paramInt >= 0) && (i2 >= 0) && (paramInt < 792) && (i2 < 792))
      {
        f2 = Util.a(this.e, (Vector3)this.a.get(paramInt));
        f4 = Util.a(this.e, (Vector3)this.a.get(i2));
        if (f2 >= f4)
        {
          paramInt = i2;
          f2 = f4;
        }
        if (paramInt < i1 ? ((i1 + 1) % 72 != 0) && (paramInt != i2) : (i3 == 0) && (paramInt == i2))
        {
          i2 = paramInt;
          f4 = f1;
          f1 = f2;
          f2 = f4;
        }
        else
        {
          i2 = i1;
        }
      }
      else
      {
        f1 = f5;
        f2 = f4;
        i2 = 0;
        paramInt = 0;
      }
      paramMatrix4 = localVector3;
      if (paramInt <= 791)
      {
        paramMatrix4 = localVector3;
        if (paramInt >= 0) {
          paramMatrix4 = (Vector3)this.a.get(paramInt);
        }
      }
      f4 = i2 % 72;
      f5 = Util.a((Vector3)this.a.get(i1), paramMatrix4);
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
      this.i.set(500.0F, 200.0F, 0.0F);
      this.j.set(500.0F, 800.0F, 0.0F);
      this.k.set(200.0F, 500.0F, 0.0F);
      this.l.set(800.0F, 500.0F, 0.0F);
      f1 = Util.a(this.h, this.i);
      f6 = Util.a(this.h, this.j);
      f4 = Util.a(this.h, this.k);
      f5 = Util.a(this.h, this.l);
      f2 = Util.a(this.d, this.h);
      float f7 = Util.a(this.d, this.i);
      float f8 = Util.a(this.h, this.i);
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
      this.b.set(500.0F, 200.0F, 0.0F);
      this.c.set(500.0F, 800.0F, 0.0F);
      if (f3 < 0.0F)
      {
        paramMatrix4 = this.c;
        localVector3 = this.f;
        paramInt = 0;
      }
      else
      {
        paramMatrix4 = this.b;
        localVector3 = this.g;
        paramInt = 1;
      }
      f1 = (float)Math.sqrt((paramMatrix4.x - this.d.x) * (paramMatrix4.x - this.d.x) + (paramMatrix4.y - this.d.y) * (paramMatrix4.y - this.d.y));
      f4 = (float)Math.sqrt((paramMatrix4.x - localVector3.x) * (paramMatrix4.x - localVector3.x) + (paramMatrix4.y - localVector3.y) * (paramMatrix4.y - localVector3.y));
      f5 = (float)Math.sqrt((this.d.x - localVector3.x) * (this.d.x - localVector3.x) + (this.d.y - localVector3.y) * (this.d.y - localVector3.y));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.armap.sensor.rotation.OrientationCalculator
 * JD-Core Version:    0.7.0.1
 */