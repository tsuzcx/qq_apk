package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import agng;
import agni;
import agnj;
import agno;
import agnp;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import bdxn;
import bdxp;
import bdxs;
import bdxt;
import bdxw;
import bdyl;
import bdym;
import bdyp;
import bdyr;
import bdyu;
import bhgr;
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
  public bdyl a;
  public bdym a;
  public bdyr a;
  private bdyu jdField_a_of_type_Bdyu;
  public String a;
  private List<bdyr> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public bdyr b;
  private bdyu jdField_b_of_type_Bdyu;
  private List<bdyr> jdField_b_of_type_JavaUtilList = new LinkedList();
  public bdyr c;
  private bdyu jdField_c_of_type_Bdyu;
  private List<bdyr> jdField_c_of_type_JavaUtilList = new LinkedList();
  public bdyr d;
  private bdyu d;
  public bdyr e;
  private bdyu e;
  public bdyr f;
  private bdyu f;
  public bdyr g;
  private bdyu g;
  public bdyr h;
  private bdyu h;
  public bdyr i;
  private bdyu i;
  public bdyr j;
  private bdyu j;
  public bdyr k;
  private bdyu k;
  public bdyr l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    bdyr localbdyr;
    while (m < 5)
    {
      localbdyr = new bdyr();
      localbdyr.a(this.jdField_a_of_type_Bdyu);
      localbdyr.a(-localbdyr.jdField_a_of_type_Float / 2.0F + (localbdyr.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdyr.b / 4.0F);
      a(localbdyr);
      this.jdField_a_of_type_JavaUtilList.add(localbdyr);
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
      localbdyr = new bdyr();
      localbdyr.a(this.jdField_b_of_type_Bdyu);
      localbdyr.a(-localbdyr.jdField_a_of_type_Float / 2.0F + (localbdyr.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdyr.b / 4.0F);
      a(localbdyr);
      this.jdField_b_of_type_JavaUtilList.add(localbdyr);
      m += 1;
    }
    while (n < 5)
    {
      localbdyr = new bdyr();
      localbdyr.a(this.jdField_c_of_type_Bdyu);
      localbdyr.a(-localbdyr.jdField_a_of_type_Float / 2.0F + (localbdyr.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbdyr.b / 4.0F);
      a(localbdyr);
      this.jdField_c_of_type_JavaUtilList.add(localbdyr);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, bdym parambdym, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdym = parambdym;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Bdyu = new bdyu(this, paramBitmap9);
    this.jdField_b_of_type_Bdyu = new bdyu(this, paramBitmap10);
    this.jdField_c_of_type_Bdyu = new bdyu(this, paramBitmap11);
    this.jdField_d_of_type_Bdyu = new bdyu(this, paramBitmap1);
    this.j = new bdyu(this, paramBitmap2);
    this.i = new bdyu(this, paramBitmap3);
    this.e = new bdyu(this, paramBitmap5);
    this.f = new bdyu(this, paramBitmap6);
    this.g = new bdyu(this, paramBitmap7);
    this.jdField_h_of_type_Bdyu = new bdyu(this, paramBitmap8);
    this.k = new bdyu(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    bdyr localbdyr;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdyr = (bdyr)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxs(1000, n, i1), new bdxs(700, i1, i2), new bdxs(300, i2, i3), new bdxs(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbdyr = (bdyr)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxs(1000, n, i1), new bdxs(700, i1, i2), new bdxs(300, i2, i3), new bdxs(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbdyr = (bdyr)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdyr.b / 2.0F - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbdyr.a(new bdxn[] { new bdxw(new bdxn[] { new bdxs(1000, n, i1), new bdxs(700, i1, i2), new bdxs(300, i2, i3), new bdxs(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    bdyr localbdyr;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdyr = (bdyr)this.jdField_a_of_type_JavaUtilList.get(m);
      localbdyr.c += bhgr.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbdyr.c > this.jdField_a_of_type_Int + localbdyr.jdField_a_of_type_Float / 2.0F))
      {
        localbdyr.c = (((bdyr)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbdyr.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbdyr = (bdyr)this.jdField_b_of_type_JavaUtilList.get(m);
        localbdyr.c += bhgr.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbdyr.c <= this.jdField_a_of_type_Int + localbdyr.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbdyr.c = (((bdyr)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbdyr.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbdyr = (bdyr)this.jdField_c_of_type_JavaUtilList.get(m);
        localbdyr.c += bhgr.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbdyr.c > this.jdField_a_of_type_Int + localbdyr.jdField_a_of_type_Float / 2.0F))
        {
          localbdyr.c = (((bdyr)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbdyr.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Bdyr = new bdyr();
    this.jdField_a_of_type_Bdyr.a(this.jdField_d_of_type_Bdyu);
    this.jdField_a_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Bdyr.b / 2.0F);
    a(this.jdField_a_of_type_Bdyr);
    bdxp localbdxp = new bdxp(1100);
    localbdxp.a(new agng(this));
    this.jdField_a_of_type_Bdyr.a(new bdxn[] { localbdxp });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Bdyr = new bdyr();
    this.jdField_c_of_type_Bdyr.e = 0.0F;
    this.jdField_c_of_type_Bdyr.a(this.j);
    this.jdField_c_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Bdyr.b / 2.0F);
    this.jdField_b_of_type_Bdyr = new bdyr();
    this.jdField_b_of_type_Bdyr.e = 0.0F;
    this.jdField_b_of_type_Bdyr.a(this.k);
    this.jdField_b_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2, bhgr.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Bdyr.b / 2.0F);
    bdxp localbdxp = new bdxp(1200);
    localbdxp.a(new agni(this));
    a(this.jdField_c_of_type_Bdyr);
    a(this.jdField_b_of_type_Bdyr);
    this.jdField_c_of_type_Bdyr.a(new bdxn[] { localbdxp });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Bdyr = new bdyr();
    this.jdField_d_of_type_Bdyr.a(this.e);
    this.jdField_d_of_type_Bdyr.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Bdyr.a(this.jdField_a_of_type_Int / 2 - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Bdyr.d + 20.0F);
    bdxp localbdxp = new bdxp(1200);
    localbdxp.a(new agnj(this));
    a(this.jdField_d_of_type_Bdyr);
    this.jdField_d_of_type_Bdyr.a(new bdxn[] { localbdxp });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Bdyr = new bdyr();
    this.jdField_h_of_type_Bdyr.a(this.i);
    this.jdField_h_of_type_Bdyr.a(this.jdField_d_of_type_Bdyr.c - this.jdField_d_of_type_Bdyr.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Bdyr.d - this.jdField_d_of_type_Bdyr.b / 2.0F);
    this.jdField_h_of_type_Bdyr.jdField_a_of_type_Int = 0;
    bdxp localbdxp = new bdxp(1700);
    localbdxp.a(new agno(this));
    a(this.jdField_h_of_type_Bdyr);
    this.jdField_h_of_type_Bdyr.a(new bdxn[] { localbdxp });
  }
  
  public void h()
  {
    bdxp localbdxp = new bdxp(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdyl = new bdyl(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Bdyl.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        bdyl localbdyl = this.jdField_a_of_type_Bdyl;
        float f1 = this.jdField_a_of_type_Int - bhgr.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Bdyl.jdField_a_of_type_Float / 2.0F;
        float f3 = bhgr.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Bdyl.b / 2.0F;
        localbdyl.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Bdyl);
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
      localbdxp.a(new agnp(this));
      this.jdField_a_of_type_Bdyl.a(new bdxn[] { localbdxp });
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
      ((bdyp)localList.get(m)).a(new bdxn[] { new bdxt(300, 255, 0) });
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