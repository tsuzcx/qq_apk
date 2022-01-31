package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import aesf;
import aesh;
import aesi;
import aesn;
import aeso;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import azzf;
import azzh;
import azzk;
import azzl;
import azzo;
import baad;
import baae;
import baah;
import baaj;
import baam;
import bcwh;
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
  public baad a;
  public baae a;
  public baaj a;
  private baam jdField_a_of_type_Baam;
  public String a;
  private List<baaj> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public baaj b;
  private baam jdField_b_of_type_Baam;
  private List<baaj> jdField_b_of_type_JavaUtilList = new LinkedList();
  public baaj c;
  private baam jdField_c_of_type_Baam;
  private List<baaj> jdField_c_of_type_JavaUtilList = new LinkedList();
  public baaj d;
  private baam d;
  public baaj e;
  private baam e;
  public baaj f;
  private baam f;
  public baaj g;
  private baam g;
  public baaj h;
  private baam h;
  public baaj i;
  private baam i;
  public baaj j;
  private baam j;
  public baaj k;
  private baam k;
  public baaj l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    baaj localbaaj;
    while (m < 5)
    {
      localbaaj = new baaj();
      localbaaj.a(this.jdField_a_of_type_Baam);
      localbaaj.a(-localbaaj.jdField_a_of_type_Float / 2.0F + (localbaaj.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbaaj.b / 4.0F);
      a(localbaaj);
      this.jdField_a_of_type_JavaUtilList.add(localbaaj);
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
      localbaaj = new baaj();
      localbaaj.a(this.jdField_b_of_type_Baam);
      localbaaj.a(-localbaaj.jdField_a_of_type_Float / 2.0F + (localbaaj.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbaaj.b / 4.0F);
      a(localbaaj);
      this.jdField_b_of_type_JavaUtilList.add(localbaaj);
      m += 1;
    }
    while (n < 5)
    {
      localbaaj = new baaj();
      localbaaj.a(this.jdField_c_of_type_Baam);
      localbaaj.a(-localbaaj.jdField_a_of_type_Float / 2.0F + (localbaaj.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbaaj.b / 4.0F);
      a(localbaaj);
      this.jdField_c_of_type_JavaUtilList.add(localbaaj);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, baae parambaae, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Baae = parambaae;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Baam = new baam(this, paramBitmap9);
    this.jdField_b_of_type_Baam = new baam(this, paramBitmap10);
    this.jdField_c_of_type_Baam = new baam(this, paramBitmap11);
    this.jdField_d_of_type_Baam = new baam(this, paramBitmap1);
    this.j = new baam(this, paramBitmap2);
    this.i = new baam(this, paramBitmap3);
    this.e = new baam(this, paramBitmap5);
    this.f = new baam(this, paramBitmap6);
    this.g = new baam(this, paramBitmap7);
    this.jdField_h_of_type_Baam = new baam(this, paramBitmap8);
    this.k = new baam(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    baaj localbaaj;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbaaj = (baaj)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbaaj.a(new azzf[] { new azzo(new azzf[] { new azzk(1000, n, i1), new azzk(700, i1, i2), new azzk(300, i2, i3), new azzk(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbaaj = (baaj)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbaaj.a(new azzf[] { new azzo(new azzf[] { new azzk(1000, n, i1), new azzk(700, i1, i2), new azzk(300, i2, i3), new azzk(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbaaj = (baaj)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbaaj.b / 2.0F - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbaaj.a(new azzf[] { new azzo(new azzf[] { new azzk(1000, n, i1), new azzk(700, i1, i2), new azzk(300, i2, i3), new azzk(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    baaj localbaaj;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbaaj = (baaj)this.jdField_a_of_type_JavaUtilList.get(m);
      localbaaj.c += bcwh.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbaaj.c > this.jdField_a_of_type_Int + localbaaj.jdField_a_of_type_Float / 2.0F))
      {
        localbaaj.c = (((baaj)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbaaj.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbaaj = (baaj)this.jdField_b_of_type_JavaUtilList.get(m);
        localbaaj.c += bcwh.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbaaj.c <= this.jdField_a_of_type_Int + localbaaj.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbaaj.c = (((baaj)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbaaj.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbaaj = (baaj)this.jdField_c_of_type_JavaUtilList.get(m);
        localbaaj.c += bcwh.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbaaj.c > this.jdField_a_of_type_Int + localbaaj.jdField_a_of_type_Float / 2.0F))
        {
          localbaaj.c = (((baaj)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbaaj.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Baaj = new baaj();
    this.jdField_a_of_type_Baaj.a(this.jdField_d_of_type_Baam);
    this.jdField_a_of_type_Baaj.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Baaj.b / 2.0F);
    a(this.jdField_a_of_type_Baaj);
    azzh localazzh = new azzh(1100);
    localazzh.a(new aesf(this));
    this.jdField_a_of_type_Baaj.a(new azzf[] { localazzh });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Baaj = new baaj();
    this.jdField_c_of_type_Baaj.e = 0.0F;
    this.jdField_c_of_type_Baaj.a(this.j);
    this.jdField_c_of_type_Baaj.a(this.jdField_a_of_type_Int / 2, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Baaj.b / 2.0F);
    this.jdField_b_of_type_Baaj = new baaj();
    this.jdField_b_of_type_Baaj.e = 0.0F;
    this.jdField_b_of_type_Baaj.a(this.k);
    this.jdField_b_of_type_Baaj.a(this.jdField_a_of_type_Int / 2, bcwh.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Baaj.b / 2.0F);
    azzh localazzh = new azzh(1200);
    localazzh.a(new aesh(this));
    a(this.jdField_c_of_type_Baaj);
    a(this.jdField_b_of_type_Baaj);
    this.jdField_c_of_type_Baaj.a(new azzf[] { localazzh });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Baaj = new baaj();
    this.jdField_d_of_type_Baaj.a(this.e);
    this.jdField_d_of_type_Baaj.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Baaj.a(this.jdField_a_of_type_Int / 2 - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Baaj.d + 20.0F);
    azzh localazzh = new azzh(1200);
    localazzh.a(new aesi(this));
    a(this.jdField_d_of_type_Baaj);
    this.jdField_d_of_type_Baaj.a(new azzf[] { localazzh });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Baaj = new baaj();
    this.jdField_h_of_type_Baaj.a(this.i);
    this.jdField_h_of_type_Baaj.a(this.jdField_d_of_type_Baaj.c - this.jdField_d_of_type_Baaj.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Baaj.d - this.jdField_d_of_type_Baaj.b / 2.0F);
    this.jdField_h_of_type_Baaj.jdField_a_of_type_Int = 0;
    azzh localazzh = new azzh(1700);
    localazzh.a(new aesn(this));
    a(this.jdField_h_of_type_Baaj);
    this.jdField_h_of_type_Baaj.a(new azzf[] { localazzh });
  }
  
  public void h()
  {
    azzh localazzh = new azzh(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Baad = new baad(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Baad.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        baad localbaad = this.jdField_a_of_type_Baad;
        float f1 = this.jdField_a_of_type_Int - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Baad.jdField_a_of_type_Float / 2.0F;
        float f3 = bcwh.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Baad.b / 2.0F;
        localbaad.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Baad);
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
      localazzh.a(new aeso(this));
      this.jdField_a_of_type_Baad.a(new azzf[] { localazzh });
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
      ((baah)localList.get(m)).a(new azzf[] { new azzl(300, 255, 0) });
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