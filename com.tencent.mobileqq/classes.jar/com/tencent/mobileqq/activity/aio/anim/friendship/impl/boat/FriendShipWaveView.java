package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import aewu;
import aeww;
import aewx;
import aexc;
import aexd;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import bado;
import badq;
import badt;
import badu;
import badx;
import baem;
import baen;
import baeq;
import baes;
import baev;
import bdaq;
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
  public baem a;
  public baen a;
  public baes a;
  private baev jdField_a_of_type_Baev;
  public String a;
  private List<baes> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public baes b;
  private baev jdField_b_of_type_Baev;
  private List<baes> jdField_b_of_type_JavaUtilList = new LinkedList();
  public baes c;
  private baev jdField_c_of_type_Baev;
  private List<baes> jdField_c_of_type_JavaUtilList = new LinkedList();
  public baes d;
  private baev d;
  public baes e;
  private baev e;
  public baes f;
  private baev f;
  public baes g;
  private baev g;
  public baes h;
  private baev h;
  public baes i;
  private baev i;
  public baes j;
  private baev j;
  public baes k;
  private baev k;
  public baes l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    baes localbaes;
    while (m < 5)
    {
      localbaes = new baes();
      localbaes.a(this.jdField_a_of_type_Baev);
      localbaes.a(-localbaes.jdField_a_of_type_Float / 2.0F + (localbaes.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbaes.b / 4.0F);
      a(localbaes);
      this.jdField_a_of_type_JavaUtilList.add(localbaes);
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
      localbaes = new baes();
      localbaes.a(this.jdField_b_of_type_Baev);
      localbaes.a(-localbaes.jdField_a_of_type_Float / 2.0F + (localbaes.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbaes.b / 4.0F);
      a(localbaes);
      this.jdField_b_of_type_JavaUtilList.add(localbaes);
      m += 1;
    }
    while (n < 5)
    {
      localbaes = new baes();
      localbaes.a(this.jdField_c_of_type_Baev);
      localbaes.a(-localbaes.jdField_a_of_type_Float / 2.0F + (localbaes.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbaes.b / 4.0F);
      a(localbaes);
      this.jdField_c_of_type_JavaUtilList.add(localbaes);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, baen parambaen, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baen = parambaen;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Baev = new baev(this, paramBitmap9);
    this.jdField_b_of_type_Baev = new baev(this, paramBitmap10);
    this.jdField_c_of_type_Baev = new baev(this, paramBitmap11);
    this.jdField_d_of_type_Baev = new baev(this, paramBitmap1);
    this.j = new baev(this, paramBitmap2);
    this.i = new baev(this, paramBitmap3);
    this.e = new baev(this, paramBitmap5);
    this.f = new baev(this, paramBitmap6);
    this.g = new baev(this, paramBitmap7);
    this.jdField_h_of_type_Baev = new baev(this, paramBitmap8);
    this.k = new baev(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    baes localbaes;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbaes = (baes)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbaes.a(new bado[] { new badx(new bado[] { new badt(1000, n, i1), new badt(700, i1, i2), new badt(300, i2, i3), new badt(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbaes = (baes)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbaes.a(new bado[] { new badx(new bado[] { new badt(1000, n, i1), new badt(700, i1, i2), new badt(300, i2, i3), new badt(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbaes = (baes)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaes.b / 2.0F - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbaes.a(new bado[] { new badx(new bado[] { new badt(1000, n, i1), new badt(700, i1, i2), new badt(300, i2, i3), new badt(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    baes localbaes;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbaes = (baes)this.jdField_a_of_type_JavaUtilList.get(m);
      localbaes.c += bdaq.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbaes.c > this.jdField_a_of_type_Int + localbaes.jdField_a_of_type_Float / 2.0F))
      {
        localbaes.c = (((baes)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbaes.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbaes = (baes)this.jdField_b_of_type_JavaUtilList.get(m);
        localbaes.c += bdaq.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbaes.c <= this.jdField_a_of_type_Int + localbaes.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbaes.c = (((baes)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbaes.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbaes = (baes)this.jdField_c_of_type_JavaUtilList.get(m);
        localbaes.c += bdaq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbaes.c > this.jdField_a_of_type_Int + localbaes.jdField_a_of_type_Float / 2.0F))
        {
          localbaes.c = (((baes)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbaes.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Baes = new baes();
    this.jdField_a_of_type_Baes.a(this.jdField_d_of_type_Baev);
    this.jdField_a_of_type_Baes.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Baes.b / 2.0F);
    a(this.jdField_a_of_type_Baes);
    badq localbadq = new badq(1100);
    localbadq.a(new aewu(this));
    this.jdField_a_of_type_Baes.a(new bado[] { localbadq });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Baes = new baes();
    this.jdField_c_of_type_Baes.e = 0.0F;
    this.jdField_c_of_type_Baes.a(this.j);
    this.jdField_c_of_type_Baes.a(this.jdField_a_of_type_Int / 2, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Baes.b / 2.0F);
    this.jdField_b_of_type_Baes = new baes();
    this.jdField_b_of_type_Baes.e = 0.0F;
    this.jdField_b_of_type_Baes.a(this.k);
    this.jdField_b_of_type_Baes.a(this.jdField_a_of_type_Int / 2, bdaq.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Baes.b / 2.0F);
    badq localbadq = new badq(1200);
    localbadq.a(new aeww(this));
    a(this.jdField_c_of_type_Baes);
    a(this.jdField_b_of_type_Baes);
    this.jdField_c_of_type_Baes.a(new bado[] { localbadq });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Baes = new baes();
    this.jdField_d_of_type_Baes.a(this.e);
    this.jdField_d_of_type_Baes.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Baes.a(this.jdField_a_of_type_Int / 2 - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Baes.d + 20.0F);
    badq localbadq = new badq(1200);
    localbadq.a(new aewx(this));
    a(this.jdField_d_of_type_Baes);
    this.jdField_d_of_type_Baes.a(new bado[] { localbadq });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Baes = new baes();
    this.jdField_h_of_type_Baes.a(this.i);
    this.jdField_h_of_type_Baes.a(this.jdField_d_of_type_Baes.c - this.jdField_d_of_type_Baes.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Baes.d - this.jdField_d_of_type_Baes.b / 2.0F);
    this.jdField_h_of_type_Baes.jdField_a_of_type_Int = 0;
    badq localbadq = new badq(1700);
    localbadq.a(new aexc(this));
    a(this.jdField_h_of_type_Baes);
    this.jdField_h_of_type_Baes.a(new bado[] { localbadq });
  }
  
  public void h()
  {
    badq localbadq = new badq(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Baem = new baem(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Baem.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        baem localbaem = this.jdField_a_of_type_Baem;
        float f1 = this.jdField_a_of_type_Int - bdaq.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Baem.jdField_a_of_type_Float / 2.0F;
        float f3 = bdaq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Baem.b / 2.0F;
        localbaem.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Baem);
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
      localbadq.a(new aexd(this));
      this.jdField_a_of_type_Baem.a(new bado[] { localbadq });
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
      ((baeq)localList.get(m)).a(new bado[] { new badu(300, 255, 0) });
      m += 1;
    }
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */