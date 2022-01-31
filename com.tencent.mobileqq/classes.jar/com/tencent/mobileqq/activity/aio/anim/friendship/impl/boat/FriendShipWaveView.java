package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import adap;
import adar;
import adas;
import adax;
import aday;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import aybi;
import aybk;
import aybn;
import aybo;
import aybr;
import aycg;
import aych;
import ayck;
import aycm;
import aycp;
import baxn;
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
  public aycg a;
  public aych a;
  public aycm a;
  private aycp jdField_a_of_type_Aycp;
  public String a;
  private List<aycm> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public aycm b;
  private aycp jdField_b_of_type_Aycp;
  private List<aycm> jdField_b_of_type_JavaUtilList = new LinkedList();
  public aycm c;
  private aycp jdField_c_of_type_Aycp;
  private List<aycm> jdField_c_of_type_JavaUtilList = new LinkedList();
  public aycm d;
  private aycp d;
  public aycm e;
  private aycp e;
  public aycm f;
  private aycp f;
  public aycm g;
  private aycp g;
  public aycm h;
  private aycp h;
  public aycm i;
  private aycp i;
  public aycm j;
  private aycp j;
  public aycm k;
  private aycp k;
  public aycm l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    aycm localaycm;
    while (m < 5)
    {
      localaycm = new aycm();
      localaycm.a(this.jdField_a_of_type_Aycp);
      localaycm.a(-localaycm.jdField_a_of_type_Float / 2.0F + (localaycm.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localaycm.b / 4.0F);
      a(localaycm);
      this.jdField_a_of_type_JavaUtilList.add(localaycm);
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
      localaycm = new aycm();
      localaycm.a(this.jdField_b_of_type_Aycp);
      localaycm.a(-localaycm.jdField_a_of_type_Float / 2.0F + (localaycm.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localaycm.b / 4.0F);
      a(localaycm);
      this.jdField_b_of_type_JavaUtilList.add(localaycm);
      m += 1;
    }
    while (n < 5)
    {
      localaycm = new aycm();
      localaycm.a(this.jdField_c_of_type_Aycp);
      localaycm.a(-localaycm.jdField_a_of_type_Float / 2.0F + (localaycm.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localaycm.b / 4.0F);
      a(localaycm);
      this.jdField_c_of_type_JavaUtilList.add(localaycm);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, aych paramaych, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aych = paramaych;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Aycp = new aycp(this, paramBitmap9);
    this.jdField_b_of_type_Aycp = new aycp(this, paramBitmap10);
    this.jdField_c_of_type_Aycp = new aycp(this, paramBitmap11);
    this.jdField_d_of_type_Aycp = new aycp(this, paramBitmap1);
    this.j = new aycp(this, paramBitmap2);
    this.i = new aycp(this, paramBitmap3);
    this.e = new aycp(this, paramBitmap5);
    this.f = new aycp(this, paramBitmap6);
    this.g = new aycp(this, paramBitmap7);
    this.jdField_h_of_type_Aycp = new aycp(this, paramBitmap8);
    this.k = new aycp(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    aycm localaycm;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaycm = (aycm)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localaycm.a(new aybi[] { new aybr(new aybi[] { new aybn(1000, n, i1), new aybn(700, i1, i2), new aybn(300, i2, i3), new aybn(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localaycm = (aycm)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localaycm.a(new aybi[] { new aybr(new aybi[] { new aybn(1000, n, i1), new aybn(700, i1, i2), new aybn(300, i2, i3), new aybn(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localaycm = (aycm)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localaycm.b / 2.0F - baxn.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localaycm.a(new aybi[] { new aybr(new aybi[] { new aybn(1000, n, i1), new aybn(700, i1, i2), new aybn(300, i2, i3), new aybn(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    aycm localaycm;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localaycm = (aycm)this.jdField_a_of_type_JavaUtilList.get(m);
      localaycm.c += baxn.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localaycm.c > this.jdField_a_of_type_Int + localaycm.jdField_a_of_type_Float / 2.0F))
      {
        localaycm.c = (((aycm)this.jdField_a_of_type_JavaUtilList.get(0)).c - localaycm.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localaycm = (aycm)this.jdField_b_of_type_JavaUtilList.get(m);
        localaycm.c += baxn.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localaycm.c <= this.jdField_a_of_type_Int + localaycm.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localaycm.c = (((aycm)this.jdField_b_of_type_JavaUtilList.get(0)).c - localaycm.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localaycm = (aycm)this.jdField_c_of_type_JavaUtilList.get(m);
        localaycm.c += baxn.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localaycm.c > this.jdField_a_of_type_Int + localaycm.jdField_a_of_type_Float / 2.0F))
        {
          localaycm.c = (((aycm)this.jdField_c_of_type_JavaUtilList.get(0)).c - localaycm.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Aycm = new aycm();
    this.jdField_a_of_type_Aycm.a(this.jdField_d_of_type_Aycp);
    this.jdField_a_of_type_Aycm.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Aycm.b / 2.0F);
    a(this.jdField_a_of_type_Aycm);
    aybk localaybk = new aybk(1100);
    localaybk.a(new adap(this));
    this.jdField_a_of_type_Aycm.a(new aybi[] { localaybk });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Aycm = new aycm();
    this.jdField_c_of_type_Aycm.e = 0.0F;
    this.jdField_c_of_type_Aycm.a(this.j);
    this.jdField_c_of_type_Aycm.a(this.jdField_a_of_type_Int / 2, baxn.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Aycm.b / 2.0F);
    this.jdField_b_of_type_Aycm = new aycm();
    this.jdField_b_of_type_Aycm.e = 0.0F;
    this.jdField_b_of_type_Aycm.a(this.k);
    this.jdField_b_of_type_Aycm.a(this.jdField_a_of_type_Int / 2, baxn.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Aycm.b / 2.0F);
    aybk localaybk = new aybk(1200);
    localaybk.a(new adar(this));
    a(this.jdField_c_of_type_Aycm);
    a(this.jdField_b_of_type_Aycm);
    this.jdField_c_of_type_Aycm.a(new aybi[] { localaybk });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Aycm = new aycm();
    this.jdField_d_of_type_Aycm.a(this.e);
    this.jdField_d_of_type_Aycm.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Aycm.a(this.jdField_a_of_type_Int / 2 - baxn.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Aycm.d + 20.0F);
    aybk localaybk = new aybk(1200);
    localaybk.a(new adas(this));
    a(this.jdField_d_of_type_Aycm);
    this.jdField_d_of_type_Aycm.a(new aybi[] { localaybk });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Aycm = new aycm();
    this.jdField_h_of_type_Aycm.a(this.i);
    this.jdField_h_of_type_Aycm.a(this.jdField_d_of_type_Aycm.c - this.jdField_d_of_type_Aycm.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Aycm.d - this.jdField_d_of_type_Aycm.b / 2.0F);
    this.jdField_h_of_type_Aycm.jdField_a_of_type_Int = 0;
    aybk localaybk = new aybk(1700);
    localaybk.a(new adax(this));
    a(this.jdField_h_of_type_Aycm);
    this.jdField_h_of_type_Aycm.a(new aybi[] { localaybk });
  }
  
  public void h()
  {
    aybk localaybk = new aybk(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Aycg = new aycg(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Aycg.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        aycg localaycg = this.jdField_a_of_type_Aycg;
        float f1 = this.jdField_a_of_type_Int - baxn.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Aycg.jdField_a_of_type_Float / 2.0F;
        float f3 = baxn.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Aycg.b / 2.0F;
        localaycg.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Aycg);
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
      localaybk.a(new aday(this));
      this.jdField_a_of_type_Aycg.a(new aybi[] { localaybk });
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
      ((ayck)localList.get(m)).a(new aybi[] { new aybo(300, 255, 0) });
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