package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import afxk;
import afxm;
import afxn;
import afxs;
import afxt;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import bdyd;
import bdyf;
import bdyi;
import bdyj;
import bdym;
import bdzb;
import bdzc;
import bdzf;
import bdzh;
import bdzk;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.util.DisplayUtil;
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
  public bdzb a;
  public bdzc a;
  public bdzh a;
  private bdzk jdField_a_of_type_Bdzk;
  public String a;
  private List<bdzh> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public bdzh b;
  private bdzk jdField_b_of_type_Bdzk;
  private List<bdzh> jdField_b_of_type_JavaUtilList = new LinkedList();
  public bdzh c;
  private bdzk jdField_c_of_type_Bdzk;
  private List<bdzh> jdField_c_of_type_JavaUtilList = new LinkedList();
  public bdzh d;
  private bdzk d;
  public bdzh e;
  private bdzk e;
  public bdzh f;
  private bdzk f;
  public bdzh g;
  private bdzk g;
  public bdzh h;
  private bdzk h;
  public bdzh i;
  private bdzk i;
  public bdzh j;
  private bdzk j;
  public bdzh k;
  private bdzk k;
  public bdzh l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    bdzh localbdzh;
    while (m < 5)
    {
      localbdzh = new bdzh();
      localbdzh.a(this.jdField_a_of_type_Bdzk);
      localbdzh.a(-localbdzh.jdField_a_of_type_Float / 2.0F + (localbdzh.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdzh.b / 4.0F);
      a(localbdzh);
      this.jdField_a_of_type_JavaUtilList.add(localbdzh);
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
      localbdzh = new bdzh();
      localbdzh.a(this.jdField_b_of_type_Bdzk);
      localbdzh.a(-localbdzh.jdField_a_of_type_Float / 2.0F + (localbdzh.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbdzh.b / 4.0F);
      a(localbdzh);
      this.jdField_b_of_type_JavaUtilList.add(localbdzh);
      m += 1;
    }
    while (n < 5)
    {
      localbdzh = new bdzh();
      localbdzh.a(this.jdField_c_of_type_Bdzk);
      localbdzh.a(-localbdzh.jdField_a_of_type_Float / 2.0F + (localbdzh.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbdzh.b / 4.0F);
      a(localbdzh);
      this.jdField_c_of_type_JavaUtilList.add(localbdzh);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, bdzc parambdzc, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bdzc = parambdzc;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Bdzk = new bdzk(this, paramBitmap9);
    this.jdField_b_of_type_Bdzk = new bdzk(this, paramBitmap10);
    this.jdField_c_of_type_Bdzk = new bdzk(this, paramBitmap11);
    this.jdField_d_of_type_Bdzk = new bdzk(this, paramBitmap1);
    this.j = new bdzk(this, paramBitmap2);
    this.i = new bdzk(this, paramBitmap3);
    this.e = new bdzk(this, paramBitmap5);
    this.f = new bdzk(this, paramBitmap6);
    this.g = new bdzk(this, paramBitmap7);
    this.jdField_h_of_type_Bdzk = new bdzk(this, paramBitmap8);
    this.k = new bdzk(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    bdzh localbdzh;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdzh = (bdzh)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyi(1000, n, i1), new bdyi(700, i1, i2), new bdyi(300, i2, i3), new bdyi(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbdzh = (bdzh)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyi(1000, n, i1), new bdyi(700, i1, i2), new bdyi(300, i2, i3), new bdyi(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbdzh = (bdzh)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbdzh.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbdzh.a(new bdyd[] { new bdym(new bdyd[] { new bdyi(1000, n, i1), new bdyi(700, i1, i2), new bdyi(300, i2, i3), new bdyi(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    bdzh localbdzh;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbdzh = (bdzh)this.jdField_a_of_type_JavaUtilList.get(m);
      localbdzh.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbdzh.c > this.jdField_a_of_type_Int + localbdzh.jdField_a_of_type_Float / 2.0F))
      {
        localbdzh.c = (((bdzh)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbdzh.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbdzh = (bdzh)this.jdField_b_of_type_JavaUtilList.get(m);
        localbdzh.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbdzh.c <= this.jdField_a_of_type_Int + localbdzh.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbdzh.c = (((bdzh)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbdzh.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbdzh = (bdzh)this.jdField_c_of_type_JavaUtilList.get(m);
        localbdzh.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbdzh.c > this.jdField_a_of_type_Int + localbdzh.jdField_a_of_type_Float / 2.0F))
        {
          localbdzh.c = (((bdzh)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbdzh.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Bdzh = new bdzh();
    this.jdField_a_of_type_Bdzh.a(this.jdField_d_of_type_Bdzk);
    this.jdField_a_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Bdzh.b / 2.0F);
    a(this.jdField_a_of_type_Bdzh);
    bdyf localbdyf = new bdyf(1100);
    localbdyf.a(new afxk(this));
    this.jdField_a_of_type_Bdzh.a(new bdyd[] { localbdyf });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Bdzh = new bdzh();
    this.jdField_c_of_type_Bdzh.e = 0.0F;
    this.jdField_c_of_type_Bdzh.a(this.j);
    this.jdField_c_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Bdzh.b / 2.0F);
    this.jdField_b_of_type_Bdzh = new bdzh();
    this.jdField_b_of_type_Bdzh.e = 0.0F;
    this.jdField_b_of_type_Bdzh.a(this.k);
    this.jdField_b_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Bdzh.b / 2.0F);
    bdyf localbdyf = new bdyf(1200);
    localbdyf.a(new afxm(this));
    a(this.jdField_c_of_type_Bdzh);
    a(this.jdField_b_of_type_Bdzh);
    this.jdField_c_of_type_Bdzh.a(new bdyd[] { localbdyf });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Bdzh = new bdzh();
    this.jdField_d_of_type_Bdzh.a(this.e);
    this.jdField_d_of_type_Bdzh.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Bdzh.a(this.jdField_a_of_type_Int / 2 - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Bdzh.d + 20.0F);
    bdyf localbdyf = new bdyf(1200);
    localbdyf.a(new afxn(this));
    a(this.jdField_d_of_type_Bdzh);
    this.jdField_d_of_type_Bdzh.a(new bdyd[] { localbdyf });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Bdzh = new bdzh();
    this.jdField_h_of_type_Bdzh.a(this.i);
    this.jdField_h_of_type_Bdzh.a(this.jdField_d_of_type_Bdzh.c - this.jdField_d_of_type_Bdzh.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Bdzh.d - this.jdField_d_of_type_Bdzh.b / 2.0F);
    this.jdField_h_of_type_Bdzh.jdField_a_of_type_Int = 0;
    bdyf localbdyf = new bdyf(1700);
    localbdyf.a(new afxs(this));
    a(this.jdField_h_of_type_Bdzh);
    this.jdField_h_of_type_Bdzh.a(new bdyd[] { localbdyf });
  }
  
  public void h()
  {
    bdyf localbdyf = new bdyf(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bdzb = new bdzb(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Bdzb.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        bdzb localbdzb = this.jdField_a_of_type_Bdzb;
        float f1 = this.jdField_a_of_type_Int - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Bdzb.jdField_a_of_type_Float / 2.0F;
        float f3 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Bdzb.b / 2.0F;
        localbdzb.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Bdzb);
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
      localbdyf.a(new afxt(this));
      this.jdField_a_of_type_Bdzb.a(new bdyd[] { localbdyf });
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
      ((bdzf)localList.get(m)).a(new bdyd[] { new bdyj(300, 255, 0) });
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