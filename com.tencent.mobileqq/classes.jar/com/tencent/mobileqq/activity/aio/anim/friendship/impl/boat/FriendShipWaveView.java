package com.tencent.mobileqq.activity.aio.anim.friendship.impl.boat;

import adas;
import adau;
import adav;
import adba;
import adbb;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import aybg;
import aybi;
import aybl;
import aybm;
import aybp;
import ayce;
import aycf;
import ayci;
import ayck;
import aycn;
import bawz;
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
  public ayce a;
  public aycf a;
  public ayck a;
  private aycn jdField_a_of_type_Aycn;
  public String a;
  private List<ayck> jdField_a_of_type_JavaUtilList = new LinkedList();
  public int b;
  public ayck b;
  private aycn jdField_b_of_type_Aycn;
  private List<ayck> jdField_b_of_type_JavaUtilList = new LinkedList();
  public ayck c;
  private aycn jdField_c_of_type_Aycn;
  private List<ayck> jdField_c_of_type_JavaUtilList = new LinkedList();
  public ayck d;
  private aycn d;
  public ayck e;
  private aycn e;
  public ayck f;
  private aycn f;
  public ayck g;
  private aycn g;
  public ayck h;
  private aycn h;
  public ayck i;
  private aycn i;
  public ayck j;
  private aycn j;
  public ayck k;
  private aycn k;
  public ayck l;
  
  public FriendShipWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaLangString = "FriendShipWaveView";
  }
  
  public void a()
  {
    int i1 = 0;
    int m = 0;
    ayck localayck;
    while (m < 5)
    {
      localayck = new ayck();
      localayck.a(this.jdField_a_of_type_Aycn);
      localayck.a(-localayck.jdField_a_of_type_Float / 2.0F + (localayck.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localayck.b / 4.0F);
      a(localayck);
      this.jdField_a_of_type_JavaUtilList.add(localayck);
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
      localayck = new ayck();
      localayck.a(this.jdField_b_of_type_Aycn);
      localayck.a(-localayck.jdField_a_of_type_Float / 2.0F + (localayck.jdField_a_of_type_Float - 1.0F) * m, this.jdField_b_of_type_Int + localayck.b / 4.0F);
      a(localayck);
      this.jdField_b_of_type_JavaUtilList.add(localayck);
      m += 1;
    }
    while (n < 5)
    {
      localayck = new ayck();
      localayck.a(this.jdField_c_of_type_Aycn);
      localayck.a(-localayck.jdField_a_of_type_Float / 2.0F + (localayck.jdField_a_of_type_Float - 1.0F) * n, this.jdField_b_of_type_Int + localayck.b / 4.0F);
      a(localayck);
      this.jdField_c_of_type_JavaUtilList.add(localayck);
      n += 1;
    }
    a(new FriendShipWaveView.1(this));
    b();
    e();
    f();
    g();
    h();
  }
  
  public void a(int paramInt1, int paramInt2, Context paramContext, aycf paramaycf, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, Bitmap paramBitmap8, Bitmap paramBitmap9, Bitmap paramBitmap10, Bitmap paramBitmap11, Bitmap paramBitmap12)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Aycf = paramaycf;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap4;
    this.jdField_a_of_type_Aycn = new aycn(this, paramBitmap9);
    this.jdField_b_of_type_Aycn = new aycn(this, paramBitmap10);
    this.jdField_c_of_type_Aycn = new aycn(this, paramBitmap11);
    this.jdField_d_of_type_Aycn = new aycn(this, paramBitmap1);
    this.j = new aycn(this, paramBitmap2);
    this.i = new aycn(this, paramBitmap3);
    this.e = new aycn(this, paramBitmap5);
    this.f = new aycn(this, paramBitmap6);
    this.g = new aycn(this, paramBitmap7);
    this.jdField_h_of_type_Aycn = new aycn(this, paramBitmap8);
    this.k = new aycn(this, paramBitmap12);
  }
  
  public void b()
  {
    int m = 0;
    ayck localayck;
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    while (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localayck = (ayck)this.jdField_a_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 85.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 250.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 220.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 230.0F));
      localayck.a(new aybg[] { new aybp(new aybg[] { new aybl(1000, n, i1), new aybl(700, i1, i2), new aybl(300, i2, i3), new aybl(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_b_of_type_JavaUtilList.size())
    {
      localayck = (ayck)this.jdField_b_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 70.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 235.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 205.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      localayck.a(new aybg[] { new aybp(new aybg[] { new aybl(1000, n, i1), new aybl(700, i1, i2), new aybl(300, i2, i3), new aybl(100, i3, i4) }) });
      m += 1;
    }
    m = 0;
    while (m < this.jdField_c_of_type_JavaUtilList.size())
    {
      localayck = (ayck)this.jdField_c_of_type_JavaUtilList.get(m);
      n = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F);
      i1 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 50.0F));
      i2 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 215.0F));
      i3 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 185.0F));
      i4 = (int)(this.jdField_b_of_type_Int + localayck.b / 2.0F - bawz.a(this.jdField_a_of_type_AndroidContentContext, 195.0F));
      localayck.a(new aybg[] { new aybp(new aybg[] { new aybl(1000, n, i1), new aybl(700, i1, i2), new aybl(300, i2, i3), new aybl(100, i3, i4) }) });
      m += 1;
    }
  }
  
  public void c()
  {
    int m = 0;
    ayck localayck;
    if (m < this.jdField_a_of_type_JavaUtilList.size())
    {
      localayck = (ayck)this.jdField_a_of_type_JavaUtilList.get(m);
      localayck.c += bawz.a(this.jdField_a_of_type_AndroidContentContext, 2.0F);
      if ((m == this.jdField_a_of_type_JavaUtilList.size() - 1) && (localayck.c > this.jdField_a_of_type_Int + localayck.jdField_a_of_type_Float / 2.0F))
      {
        localayck.c = (((ayck)this.jdField_a_of_type_JavaUtilList.get(0)).c - localayck.jdField_a_of_type_Float + 1.0F);
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_JavaUtilList.remove(m));
      }
    }
    else
    {
      m = 0;
      label131:
      if (m < this.jdField_b_of_type_JavaUtilList.size())
      {
        localayck = (ayck)this.jdField_b_of_type_JavaUtilList.get(m);
        localayck.c += bawz.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        if ((m != this.jdField_b_of_type_JavaUtilList.size() - 1) || (localayck.c <= this.jdField_a_of_type_Int + localayck.jdField_a_of_type_Float / 2.0F)) {
          break label397;
        }
        localayck.c = (((ayck)this.jdField_b_of_type_JavaUtilList.get(0)).c - localayck.jdField_a_of_type_Float + 1.0F);
        this.jdField_b_of_type_JavaUtilList.add(0, this.jdField_b_of_type_JavaUtilList.remove(m));
      }
      m = 0;
    }
    for (;;)
    {
      if (m < this.jdField_c_of_type_JavaUtilList.size())
      {
        localayck = (ayck)this.jdField_c_of_type_JavaUtilList.get(m);
        localayck.c += bawz.a(this.jdField_a_of_type_AndroidContentContext, 4.0F);
        if ((m == this.jdField_c_of_type_JavaUtilList.size() - 1) && (localayck.c > this.jdField_a_of_type_Int + localayck.jdField_a_of_type_Float / 2.0F))
        {
          localayck.c = (((ayck)this.jdField_c_of_type_JavaUtilList.get(0)).c - localayck.jdField_a_of_type_Float + 1.0F);
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
    this.jdField_a_of_type_Ayck = new ayck();
    this.jdField_a_of_type_Ayck.a(this.jdField_d_of_type_Aycn);
    this.jdField_a_of_type_Ayck.a(this.jdField_a_of_type_Int / 2, -this.jdField_a_of_type_Ayck.b / 2.0F);
    a(this.jdField_a_of_type_Ayck);
    aybi localaybi = new aybi(1100);
    localaybi.a(new adas(this));
    this.jdField_a_of_type_Ayck.a(new aybg[] { localaybi });
  }
  
  public void e()
  {
    this.jdField_c_of_type_Ayck = new ayck();
    this.jdField_c_of_type_Ayck.e = 0.0F;
    this.jdField_c_of_type_Ayck.a(this.j);
    this.jdField_c_of_type_Ayck.a(this.jdField_a_of_type_Int / 2, bawz.a(this.jdField_a_of_type_AndroidContentContext, 165.0F) + this.jdField_c_of_type_Ayck.b / 2.0F);
    this.jdField_b_of_type_Ayck = new ayck();
    this.jdField_b_of_type_Ayck.e = 0.0F;
    this.jdField_b_of_type_Ayck.a(this.k);
    this.jdField_b_of_type_Ayck.a(this.jdField_a_of_type_Int / 2, bawz.a(this.jdField_a_of_type_AndroidContentContext, 130.0F) + this.jdField_b_of_type_Ayck.b / 2.0F);
    aybi localaybi = new aybi(1200);
    localaybi.a(new adau(this));
    a(this.jdField_c_of_type_Ayck);
    a(this.jdField_b_of_type_Ayck);
    this.jdField_c_of_type_Ayck.a(new aybg[] { localaybi });
  }
  
  public void f()
  {
    this.jdField_d_of_type_Ayck = new ayck();
    this.jdField_d_of_type_Ayck.a(this.e);
    this.jdField_d_of_type_Ayck.jdField_a_of_type_Int = 0;
    this.jdField_d_of_type_Ayck.a(this.jdField_a_of_type_Int / 2 - bawz.a(this.jdField_a_of_type_AndroidContentContext, 110.0F), this.jdField_b_of_type_Ayck.d + 20.0F);
    aybi localaybi = new aybi(1200);
    localaybi.a(new adav(this));
    a(this.jdField_d_of_type_Ayck);
    this.jdField_d_of_type_Ayck.a(new aybg[] { localaybi });
  }
  
  public void g()
  {
    this.jdField_h_of_type_Ayck = new ayck();
    this.jdField_h_of_type_Ayck.a(this.i);
    this.jdField_h_of_type_Ayck.a(this.jdField_d_of_type_Ayck.c - this.jdField_d_of_type_Ayck.jdField_a_of_type_Float / 2.0F - 3.0F, this.jdField_d_of_type_Ayck.d - this.jdField_d_of_type_Ayck.b / 2.0F);
    this.jdField_h_of_type_Ayck.jdField_a_of_type_Int = 0;
    aybi localaybi = new aybi(1700);
    localaybi.a(new adba(this));
    a(this.jdField_h_of_type_Ayck);
    this.jdField_h_of_type_Ayck.a(new aybg[] { localaybi });
  }
  
  public void h()
  {
    aybi localaybi = new aybi(1000);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Ayce = new ayce(this, this.jdField_a_of_type_AndroidGraphicsBitmap, true);
        this.jdField_a_of_type_Ayce.jdField_a_of_type_Int = 0;
        if (Build.VERSION.SDK_INT < 19) {
          continue;
        }
        m = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        ayce localayce = this.jdField_a_of_type_Ayce;
        float f1 = this.jdField_a_of_type_Int - bawz.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
        float f2 = this.jdField_a_of_type_Ayce.jdField_a_of_type_Float / 2.0F;
        float f3 = bawz.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
        float f4 = this.jdField_a_of_type_Ayce.b / 2.0F;
        localayce.a(f1 - f2, m + (f3 + f4));
        a(this.jdField_a_of_type_Ayce);
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
      localaybi.a(new adbb(this));
      this.jdField_a_of_type_Ayce.a(new aybg[] { localaybi });
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
      ((ayci)localList.get(m)).a(new aybg[] { new aybm(300, 255, 0) });
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