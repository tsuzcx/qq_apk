package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import acpz;
import acqb;
import acqc;
import acqh;
import acqi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import axbe;
import axbg;
import axbj;
import axbk;
import axbn;
import axcc;
import axcd;
import axcg;
import axci;
import axcl;
import azvv;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedList;
import java.util.List;

public class FriendShipWaveView
  extends SpriteGLView
{
  public int a;
  public Context a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public axcc a;
  public axcd a;
  public axci a;
  private axcl jdField_a_of_type_Axcl;
  public String a;
  private List<axci> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public axci b;
  private axcl jdField_b_of_type_Axcl;
  private List<axci> jdField_b_of_type_JavaUtilList = new LinkedList();
  public axci c;
  private axcl jdField_c_of_type_Axcl;
  private List<axci> jdField_c_of_type_JavaUtilList = new LinkedList();
  public axci d;
  private axcl d;
  public axci e;
  private axcl e;
  public axci f;
  private axcl f;
  public axci g;
  private axcl g;
  public axci h;
  private axcl h;
  public axci i;
  private axcl i;
  public axci j;
  private axcl j;
  public axci k;
  private axcl k;
  public axci l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    axci localaxci;
    while (m < 5)
    {
      localaxci = new axci();
      localaxci.a(this.jdField_a_of_type_Axcl);
      localaxci.a(-localaxci.jdField_a_of_type_Float / 2.0F + (localaxci.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localaxci.b / 4.0F);
      a(localaxci);
      this.jdField_a_of_type_JavaUtilList.add(localaxci);
      m += 1;
    }
    d();
    m = 0;
    int n;
    for (;;)
    {
      n = i1;
      if (m >= 5) {
        break;
      }
      localaxci = new axci();
      localaxci.a(this.jdField_b_of_type_Axcl);
      localaxci.a(-localaxci.jdField_a_of_type_Float / 2.0F + (localaxci.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localaxci.b / 4.0F);
      a(localaxci);
      this.jdField_b_of_type_JavaUtilList.add(localaxci);
      m += 1;
    }
    while (n < 5)
    {
      localaxci = new axci();
      localaxci.a(this.jdField_c_of_type_Axcl);
      localaxci.a(-localaxci.jdField_a_of_type_Float / 2.0F + (localaxci.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localaxci.b / 4.0F);
      a(localaxci);
      this.jdField_c_of_type_JavaUtilList.add(localaxci);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, axcd paramaxcd, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Axcd = paramaxcd;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Axcl = new axcl(this, paramBitmap9);
    this.jdField_b_of_type_Axcl = new axcl(this, paramBitmap10);
    this.jdField_c_of_type_Axcl = new axcl(this, paramBitmap11);
    this.jdField_d_of_type_Axcl = new axcl(this, paramBitmap1);
    this.j = new axcl(this, paramBitmap2);
    this.i = new axcl(this, paramBitmap3);
    this.e = new axcl(this, paramBitmap5);
    this.f = new axcl(this, paramBitmap6);
    this.g = new axcl(this, paramBitmap7);
    this.jdField_h_of_type_Axcl = new axcl(this, paramBitmap8);
    this.k = new axcl(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    axci localaxci;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaxci = (axci)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localaxci.a(new axbe[] { new axbn(new axbe[] { new axbj(1000, n, i1), new axbj(700, i1, i2), new axbj(300, i2, i3), new axbj(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localaxci = (axci)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localaxci.a(new axbe[] { new axbn(new axbe[] { new axbj(1000, n, i1), new axbj(700, i1, i2), new axbj(300, i2, i3), new axbj(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localaxci = (axci)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaxci.b / 2.0F - azvv.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localaxci.a(new axbe[] { new axbn(new axbe[] { new axbj(1000, n, i1), new axbj(700, i1, i2), new axbj(300, i2, i3), new axbj(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    axci localaxci;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaxci = (axci)this.jdField_a_of_type_JavaUtilList.get(m);
      localaxci.c += azvv.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localaxci.c > this.jdField_a_of_type_Int + localaxci.jdField_a_of_type_Float / 2.0F))
      {
        localaxci.c = (((axci)this.jdField_a_of_type_JavaUtilList.get(0)).c - localaxci.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localaxci = (axci)this.jdField_b_of_type_JavaUtilList.get(m);
        localaxci.c += azvv.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localaxci.c <= this.jdField_a_of_type_Int + localaxci.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localaxci.c = (((axci)this.jdField_b_of_type_JavaUtilList.get(0)).c - localaxci.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localaxci = (axci)this.jdField_c_of_type_JavaUtilList.get(m);
        localaxci.c += azvv.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localaxci.c > this.jdField_a_of_type_Int + localaxci.jdField_a_of_type_Float / 2.0F))
        {
          localaxci.c = (((axci)this.jdField_c_of_type_JavaUtilList.get(0)).c - localaxci.jdField_a_of_type_Float + 1.0F);
          this.jdField_c_of_type_JavaUtilList.add(0, this.jdField_c_of_type_JavaUtilList.remove(m));
        }
      }
      else
      {
        return;
        m += 1;
        break;
        label397:
        m += 1;
        break label131;
      }
      m += 1;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Axci = new axci();
    this.jdField_a_of_type_Axci.a(this.jdField_d_of_type_Axcl);
    this.jdField_a_of_type_Axci.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Axci.b / 2.0F);
    a(this.jdField_a_of_type_Axci);
    axbg localaxbg = new axbg(1100);
    localaxbg.a(new acpz(this));
    this.jdField_a_of_type_Axci.a(new axbe[] { localaxbg });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Axci = new axci();
    this.jdField_c_of_type_Axci.e = 0.0F;
    this.jdField_c_of_type_Axci.a(this.j);
    this.jdField_c_of_type_Axci.a(this.jdField_a_of_type_Int / 2, azvv.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Axci.b / 2.0F);
    this.jdField_b_of_type_Axci = new axci();
    this.jdField_b_of_type_Axci.e = 0.0F;
    this.jdField_b_of_type_Axci.a(this.k);
    this.jdField_b_of_type_Axci.a(this.jdField_a_of_type_Int / 2, azvv.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Axci.b / 2.0F);
    axbg localaxbg = new axbg(1200);
    localaxbg.a(new acqb(this));
    a(this.jdField_c_of_type_Axci);
    a(this.jdField_b_of_type_Axci);
    this.jdField_c_of_type_Axci.a(new axbe[] { localaxbg });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Axci = new axci();
    this.jdField_d_of_type_Axci.a(this.e);
    this.jdField_d_of_type_Axci.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Axci.a(this.jdField_a_of_type_Int / 2 - azvv.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Axci.d + 20.0F);
    axbg localaxbg = new axbg(1200);
    localaxbg.a(new acqc(this));
    a(this.jdField_d_of_type_Axci);
    this.jdField_d_of_type_Axci.a(new axbe[] { localaxbg });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Axci = new axci();
    this.jdField_h_of_type_Axci.a(this.i);
    this.jdField_h_of_type_Axci.a(this.jdField_d_of_type_Axci.c - this.jdField_d_of_type_Axci.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Axci.d - this.jdField_d_of_type_Axci.b / 2.0F);
    this.jdField_h_of_type_Axci.jdField_a_of_type_Int = 0;
    axbg localaxbg = new axbg(1700);
    localaxbg.a(new acqh(this));
    a(this.jdField_h_of_type_Axci);
    this.jdField_h_of_type_Axci.a(new axbe[] { localaxbg });
  }
  
  public void h()
  {
    axbg localaxbg = new axbg(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Axcc = new axcc(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Axcc.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        axcc localaxcc = this.jdField_a_of_type_Axcc;
        float f1 = this.jdField_a_of_type_Int - azvv.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Axcc.jdField_a_of_type_Float / 2.0F;
        float f3 = azvv.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Axcc.b / 2.0F;
        localaxcc.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Axcc);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "decode init mCloseButton failed");
        continue;
      }
      localaxbg.a(new acqi(this));
      this.jdField_a_of_type_Axcc.a(new axbe[] { localaxbg });
      return;
      m = 0;
    }
  }
  
  public void i()
  {
    List localList = a();
    int m = 0;
    while (m < localList.size())
    {
      ((axcg)localList.get(m)).a(new axbe[] { new axbk(300, 255, 0) });
      m += 1;
    }
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */