package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import afgf;
import afgh;
import afgi;
import afgn;
import afgo;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import bcre;
import bcrg;
import bcrj;
import bcrk;
import bcrn;
import bcsc;
import bcsd;
import bcsg;
import bcsi;
import bcsl;
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
  public bcsc a;
  public bcsd a;
  public bcsi a;
  private bcsl jdField_a_of_type_Bcsl;
  public String a;
  private List<bcsi> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public bcsi b;
  private bcsl jdField_b_of_type_Bcsl;
  private List<bcsi> jdField_b_of_type_JavaUtilList = new LinkedList();
  public bcsi c;
  private bcsl jdField_c_of_type_Bcsl;
  private List<bcsi> jdField_c_of_type_JavaUtilList = new LinkedList();
  public bcsi d;
  private bcsl d;
  public bcsi e;
  private bcsl e;
  public bcsi f;
  private bcsl f;
  public bcsi g;
  private bcsl g;
  public bcsi h;
  private bcsl h;
  public bcsi i;
  private bcsl i;
  public bcsi j;
  private bcsl j;
  public bcsi k;
  private bcsl k;
  public bcsi l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    bcsi localbcsi;
    while (m < 5)
    {
      localbcsi = new bcsi();
      localbcsi.a(this.jdField_a_of_type_Bcsl);
      localbcsi.a(-localbcsi.jdField_a_of_type_Float / 2.0F + (localbcsi.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbcsi.b / 4.0F);
      a(localbcsi);
      this.jdField_a_of_type_JavaUtilList.add(localbcsi);
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
      localbcsi = new bcsi();
      localbcsi.a(this.jdField_b_of_type_Bcsl);
      localbcsi.a(-localbcsi.jdField_a_of_type_Float / 2.0F + (localbcsi.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localbcsi.b / 4.0F);
      a(localbcsi);
      this.jdField_b_of_type_JavaUtilList.add(localbcsi);
      m += 1;
    }
    while (n < 5)
    {
      localbcsi = new bcsi();
      localbcsi.a(this.jdField_c_of_type_Bcsl);
      localbcsi.a(-localbcsi.jdField_a_of_type_Float / 2.0F + (localbcsi.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localbcsi.b / 4.0F);
      a(localbcsi);
      this.jdField_c_of_type_JavaUtilList.add(localbcsi);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, bcsd parambcsd, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Bcsd = parambcsd;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Bcsl = new bcsl(this, paramBitmap9);
    this.jdField_b_of_type_Bcsl = new bcsl(this, paramBitmap10);
    this.jdField_c_of_type_Bcsl = new bcsl(this, paramBitmap11);
    this.jdField_d_of_type_Bcsl = new bcsl(this, paramBitmap1);
    this.j = new bcsl(this, paramBitmap2);
    this.i = new bcsl(this, paramBitmap3);
    this.e = new bcsl(this, paramBitmap5);
    this.f = new bcsl(this, paramBitmap6);
    this.g = new bcsl(this, paramBitmap7);
    this.jdField_h_of_type_Bcsl = new bcsl(this, paramBitmap8);
    this.k = new bcsl(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    bcsi localbcsi;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbcsi = (bcsi)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localbcsi.a(new bcre[] { new bcrn(new bcre[] { new bcrj(1000, n, i1), new bcrj(700, i1, i2), new bcrj(300, i2, i3), new bcrj(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localbcsi = (bcsi)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localbcsi.a(new bcre[] { new bcrn(new bcre[] { new bcrj(1000, n, i1), new bcrj(700, i1, i2), new bcrj(300, i2, i3), new bcrj(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localbcsi = (bcsi)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localbcsi.b / 2.0F - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localbcsi.a(new bcre[] { new bcrn(new bcre[] { new bcrj(1000, n, i1), new bcrj(700, i1, i2), new bcrj(300, i2, i3), new bcrj(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    bcsi localbcsi;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localbcsi = (bcsi)this.jdField_a_of_type_JavaUtilList.get(m);
      localbcsi.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localbcsi.c > this.jdField_a_of_type_Int + localbcsi.jdField_a_of_type_Float / 2.0F))
      {
        localbcsi.c = (((bcsi)this.jdField_a_of_type_JavaUtilList.get(0)).c - localbcsi.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localbcsi = (bcsi)this.jdField_b_of_type_JavaUtilList.get(m);
        localbcsi.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localbcsi.c <= this.jdField_a_of_type_Int + localbcsi.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localbcsi.c = (((bcsi)this.jdField_b_of_type_JavaUtilList.get(0)).c - localbcsi.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localbcsi = (bcsi)this.jdField_c_of_type_JavaUtilList.get(m);
        localbcsi.c += DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localbcsi.c > this.jdField_a_of_type_Int + localbcsi.jdField_a_of_type_Float / 2.0F))
        {
          localbcsi.c = (((bcsi)this.jdField_c_of_type_JavaUtilList.get(0)).c - localbcsi.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Bcsi = new bcsi();
    this.jdField_a_of_type_Bcsi.a(this.jdField_d_of_type_Bcsl);
    this.jdField_a_of_type_Bcsi.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Bcsi.b / 2.0F);
    a(this.jdField_a_of_type_Bcsi);
    bcrg localbcrg = new bcrg(1100);
    localbcrg.a(new afgf(this));
    this.jdField_a_of_type_Bcsi.a(new bcre[] { localbcrg });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Bcsi = new bcsi();
    this.jdField_c_of_type_Bcsi.e = 0.0F;
    this.jdField_c_of_type_Bcsi.a(this.j);
    this.jdField_c_of_type_Bcsi.a(this.jdField_a_of_type_Int / 2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Bcsi.b / 2.0F);
    this.jdField_b_of_type_Bcsi = new bcsi();
    this.jdField_b_of_type_Bcsi.e = 0.0F;
    this.jdField_b_of_type_Bcsi.a(this.k);
    this.jdField_b_of_type_Bcsi.a(this.jdField_a_of_type_Int / 2, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Bcsi.b / 2.0F);
    bcrg localbcrg = new bcrg(1200);
    localbcrg.a(new afgh(this));
    a(this.jdField_c_of_type_Bcsi);
    a(this.jdField_b_of_type_Bcsi);
    this.jdField_c_of_type_Bcsi.a(new bcre[] { localbcrg });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Bcsi = new bcsi();
    this.jdField_d_of_type_Bcsi.a(this.e);
    this.jdField_d_of_type_Bcsi.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Bcsi.a(this.jdField_a_of_type_Int / 2 - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Bcsi.d + 20.0F);
    bcrg localbcrg = new bcrg(1200);
    localbcrg.a(new afgi(this));
    a(this.jdField_d_of_type_Bcsi);
    this.jdField_d_of_type_Bcsi.a(new bcre[] { localbcrg });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Bcsi = new bcsi();
    this.jdField_h_of_type_Bcsi.a(this.i);
    this.jdField_h_of_type_Bcsi.a(this.jdField_d_of_type_Bcsi.c - this.jdField_d_of_type_Bcsi.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Bcsi.d - this.jdField_d_of_type_Bcsi.b / 2.0F);
    this.jdField_h_of_type_Bcsi.jdField_a_of_type_Int = 0;
    bcrg localbcrg = new bcrg(1700);
    localbcrg.a(new afgn(this));
    a(this.jdField_h_of_type_Bcsi);
    this.jdField_h_of_type_Bcsi.a(new bcre[] { localbcrg });
  }
  
  public void h()
  {
    bcrg localbcrg = new bcrg(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Bcsc = new bcsc(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Bcsc.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        bcsc localbcsc = this.jdField_a_of_type_Bcsc;
        float f1 = this.jdField_a_of_type_Int - DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Bcsc.jdField_a_of_type_Float / 2.0F;
        float f3 = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Bcsc.b / 2.0F;
        localbcsc.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Bcsc);
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
      localbcrg.a(new afgo(this));
      this.jdField_a_of_type_Bcsc.a(new bcre[] { localbcrg });
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
      ((bcsg)localList.get(m)).a(new bcre[] { new bcrk(300, 255, 0) });
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