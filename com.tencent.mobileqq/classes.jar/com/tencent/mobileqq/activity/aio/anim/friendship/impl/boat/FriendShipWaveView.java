package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import agdg;
import agdi;
import agdj;
import agdo;
import agdp;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import bdes;
import bdeu;
import bdex;
import bdey;
import bdfb;
import bdfq;
import bdfr;
import bdfu;
import bdfw;
import bdfz;
import bggq;
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
  public bdfq a;
  public bdfr a;
  public bdfw a;
  private bdfz jdField_a_of_type_Bdfz;
  public String a;
  private List<bdfw> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public bdfw b;
  private bdfz jdField_b_of_type_Bdfz;
  private List<bdfw> jdField_b_of_type_JavaUtilList = new LinkedList();
  public bdfw c;
  private bdfz jdField_c_of_type_Bdfz;
  private List<bdfw> jdField_c_of_type_JavaUtilList = new LinkedList();
  public bdfw d;
  private bdfz d;
  public bdfw e;
  private bdfz e;
  public bdfw f;
  private bdfz f;
  public bdfw g;
  private bdfz g;
  public bdfw h;
  private bdfz h;
  public bdfw i;
  private bdfz i;
  public bdfw j;
  private bdfz j;
  public bdfw k;
  private bdfz k;
  public bdfw l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    bdfw localbdfw;
    while (m < 5)
    {
      localbdfw = new bdfw();
      localbdfw.a(this.jdField_a_of_type_Bdfz);
      localbdfw.a(-localbdfw.jdField_a_of_type_Float / 2.0F + (localbdfw.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdfw.b / 4.0F);
      a(localbdfw);
      this.jdField_a_of_type_JavaUtilList.add(localbdfw);
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
      localbdfw = new bdfw();
      localbdfw.a(this.jdField_b_of_type_Bdfz);
      localbdfw.a(-localbdfw.jdField_a_of_type_Float / 2.0F + (localbdfw.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdfw.b / 4.0F);
      a(localbdfw);
      this.jdField_b_of_type_JavaUtilList.add(localbdfw);
      m += 1;
    }
    while (n < 5)
    {
      localbdfw = new bdfw();
      localbdfw.a(this.jdField_c_of_type_Bdfz);
      localbdfw.a(-localbdfw.jdField_a_of_type_Float / 2.0F + (localbdfw.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbdfw.b / 4.0F);
      a(localbdfw);
      this.jdField_c_of_type_JavaUtilList.add(localbdfw);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, bdfr parambdfr, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdfr = parambdfr;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Bdfz = new bdfz(this, paramBitmap9);
    this.jdField_b_of_type_Bdfz = new bdfz(this, paramBitmap10);
    this.jdField_c_of_type_Bdfz = new bdfz(this, paramBitmap11);
    this.jdField_d_of_type_Bdfz = new bdfz(this, paramBitmap1);
    this.j = new bdfz(this, paramBitmap2);
    this.i = new bdfz(this, paramBitmap3);
    this.e = new bdfz(this, paramBitmap5);
    this.f = new bdfz(this, paramBitmap6);
    this.g = new bdfz(this, paramBitmap7);
    this.jdField_h_of_type_Bdfz = new bdfz(this, paramBitmap8);
    this.k = new bdfz(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    bdfw localbdfw;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdfw = (bdfw)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbdfw.a(new bdes[] { new bdfb(new bdes[] { new bdex(1000, n, i1), new bdex(700, i1, i2), new bdex(300, i2, i3), new bdex(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbdfw = (bdfw)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbdfw.a(new bdes[] { new bdfb(new bdes[] { new bdex(1000, n, i1), new bdex(700, i1, i2), new bdex(300, i2, i3), new bdex(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbdfw = (bdfw)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdfw.b / 2.0F - bggq.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbdfw.a(new bdes[] { new bdfb(new bdes[] { new bdex(1000, n, i1), new bdex(700, i1, i2), new bdex(300, i2, i3), new bdex(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    bdfw localbdfw;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdfw = (bdfw)this.jdField_a_of_type_JavaUtilList.get(m);
      localbdfw.c += bggq.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbdfw.c > this.jdField_a_of_type_Int + localbdfw.jdField_a_of_type_Float / 2.0F))
      {
        localbdfw.c = (((bdfw)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbdfw.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbdfw = (bdfw)this.jdField_b_of_type_JavaUtilList.get(m);
        localbdfw.c += bggq.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbdfw.c <= this.jdField_a_of_type_Int + localbdfw.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbdfw.c = (((bdfw)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbdfw.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbdfw = (bdfw)this.jdField_c_of_type_JavaUtilList.get(m);
        localbdfw.c += bggq.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbdfw.c > this.jdField_a_of_type_Int + localbdfw.jdField_a_of_type_Float / 2.0F))
        {
          localbdfw.c = (((bdfw)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbdfw.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Bdfw = new bdfw();
    this.jdField_a_of_type_Bdfw.a(this.jdField_d_of_type_Bdfz);
    this.jdField_a_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Bdfw.b / 2.0F);
    a(this.jdField_a_of_type_Bdfw);
    bdeu localbdeu = new bdeu(1100);
    localbdeu.a(new agdg(this));
    this.jdField_a_of_type_Bdfw.a(new bdes[] { localbdeu });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Bdfw = new bdfw();
    this.jdField_c_of_type_Bdfw.e = 0.0F;
    this.jdField_c_of_type_Bdfw.a(this.j);
    this.jdField_c_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2, bggq.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Bdfw.b / 2.0F);
    this.jdField_b_of_type_Bdfw = new bdfw();
    this.jdField_b_of_type_Bdfw.e = 0.0F;
    this.jdField_b_of_type_Bdfw.a(this.k);
    this.jdField_b_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2, bggq.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Bdfw.b / 2.0F);
    bdeu localbdeu = new bdeu(1200);
    localbdeu.a(new agdi(this));
    a(this.jdField_c_of_type_Bdfw);
    a(this.jdField_b_of_type_Bdfw);
    this.jdField_c_of_type_Bdfw.a(new bdes[] { localbdeu });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Bdfw = new bdfw();
    this.jdField_d_of_type_Bdfw.a(this.e);
    this.jdField_d_of_type_Bdfw.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Bdfw.a(this.jdField_a_of_type_Int / 2 - bggq.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Bdfw.d + 20.0F);
    bdeu localbdeu = new bdeu(1200);
    localbdeu.a(new agdj(this));
    a(this.jdField_d_of_type_Bdfw);
    this.jdField_d_of_type_Bdfw.a(new bdes[] { localbdeu });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Bdfw = new bdfw();
    this.jdField_h_of_type_Bdfw.a(this.i);
    this.jdField_h_of_type_Bdfw.a(this.jdField_d_of_type_Bdfw.c - this.jdField_d_of_type_Bdfw.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Bdfw.d - this.jdField_d_of_type_Bdfw.b / 2.0F);
    this.jdField_h_of_type_Bdfw.jdField_a_of_type_Int = 0;
    bdeu localbdeu = new bdeu(1700);
    localbdeu.a(new agdo(this));
    a(this.jdField_h_of_type_Bdfw);
    this.jdField_h_of_type_Bdfw.a(new bdes[] { localbdeu });
  }
  
  public void h()
  {
    bdeu localbdeu = new bdeu(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdfq = new bdfq(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Bdfq.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        bdfq localbdfq = this.jdField_a_of_type_Bdfq;
        float f1 = this.jdField_a_of_type_Int - bggq.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Bdfq.jdField_a_of_type_Float / 2.0F;
        float f3 = bggq.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Bdfq.b / 2.0F;
        localbdfq.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Bdfq);
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
      localbdeu.a(new agdp(this));
      this.jdField_a_of_type_Bdfq.a(new bdes[] { localbdeu });
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
      ((bdfu)localList.get(m)).a(new bdes[] { new bdey(300, 255, 0) });
      m += 1;
    }
  }
  
  public void j()
  {
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat.FriendShipWaveView
 * JD-Core Version:    0.7.0.1
 */