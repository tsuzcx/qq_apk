package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ViewBase
  implements IView
{
  protected float a;
  protected int a;
  protected Bitmap a;
  protected Matrix a;
  public Paint a;
  protected Rect a;
  protected IBean a;
  protected Layout.Params a;
  protected Layout a;
  public VafContext a;
  private ViewBase.OnClickListener a;
  protected String a;
  protected boolean a;
  public float b;
  protected int b;
  protected Paint b;
  protected View b;
  protected String b;
  public float c;
  protected int c;
  protected Paint c;
  protected String c;
  public int d;
  protected String d;
  public int e;
  public int f = -16777216;
  protected int g;
  public int h;
  public int i;
  public int j;
  public int k;
  protected int l;
  protected int m = 1;
  public int n = 0;
  public int o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  public int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  
  public ViewBase(VafContext paramVafContext)
  {
    this.jdField_a_of_type_Float = (0.0F / 0.0F);
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    this.jdField_d_of_type_Int = 0;
    this.s = 9;
    this.v = 0;
    this.o = 0;
    this.q = 0;
    this.p = 0;
    this.r = 0;
    this.w = 0;
    this.x = 0;
    this.l = -1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
    this.y = 0;
  }
  
  private boolean a(String paramString, Object paramObject)
  {
    return b(StringCommon.a(paramString), paramObject);
  }
  
  private boolean b(int paramInt, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return b(paramInt, (String)paramObject);
    }
    return a(paramInt, paramObject);
  }
  
  private boolean g()
  {
    View localView = a();
    if (localView != null)
    {
      switch (this.m)
      {
      default: 
        return true;
      case 0: 
        localView.setVisibility(4);
        return true;
      case 1: 
        localView.setVisibility(0);
        return true;
      }
      localView.setVisibility(8);
      return true;
    }
    if (a())
    {
      switch (this.m)
      {
      default: 
        return true;
      case 0: 
        this.jdField_b_of_type_AndroidViewView.setVisibility(4);
        return true;
      case 1: 
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        return true;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return this.t;
  }
  
  public View a()
  {
    return null;
  }
  
  public ViewBase a(String paramString)
  {
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramString)) {
      return this;
    }
    return null;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a() {}
  
  protected void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    View localView = a();
    if (localView != null)
    {
      localView.setBackgroundColor(paramInt);
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsPaint == null) {
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_d_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.invalidate(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    QLog.d("ViewBase", 2, "refresh holdView is null");
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
    b(paramCanvas);
    paramCanvas.restore();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(View paramView)
  {
    this.jdField_b_of_type_AndroidViewView = paramView;
    if (e()) {
      paramView.setLayerType(1, null);
    }
  }
  
  public void a(ViewBean paramViewBean)
  {
    if ((paramViewBean != null) && (paramViewBean.a != null) && (paramViewBean.a.b != null))
    {
      paramViewBean = paramViewBean.a.b.entrySet().iterator();
      while (paramViewBean.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramViewBean.next();
        a((String)localEntry.getKey(), localEntry.getValue());
      }
      a();
    }
  }
  
  public final void a(Layout.Params paramParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params = paramParams;
  }
  
  public void a(ViewBase.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase$OnClickListener = paramOnClickListener;
    b(true);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase$OnClickListener != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase$OnClickListener.a(this);
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return b(this.l);
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return a(this.l, paramBoolean);
  }
  
  public boolean a(int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 7: 
      paramInt = Utils.a(Double.valueOf(paramString).doubleValue());
      this.r = paramInt;
      this.q = paramInt;
      this.p = paramInt;
      this.o = paramInt;
      return true;
    case 8: 
      this.o = Utils.a(Double.valueOf(paramString).doubleValue());
      return true;
    case 9: 
      this.p = Utils.a(Double.valueOf(paramString).doubleValue());
      return true;
    case 13: 
      this.e = Utils.a(Double.valueOf(paramString).doubleValue());
      return true;
    case 14: 
      this.f = Utils.a(paramString);
      return true;
    case 15: 
      this.g = Utils.a(Double.valueOf(paramString).doubleValue());
      this.h = this.g;
      this.i = this.g;
      this.j = this.g;
      this.k = this.g;
      return true;
    case 34: 
      this.jdField_c_of_type_JavaLangString = paramString;
      b(true);
      return true;
    case 35: 
      if ("VISIBLE".equals(paramString))
      {
        b(1);
        return true;
      }
      b(2);
      return true;
    case 36: 
      this.jdField_d_of_type_JavaLangString = paramString;
      return true;
    }
    a(Utils.a(paramString));
    return true;
  }
  
  protected boolean a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (boolean bool1 = d(paramInt);; bool1 = a(paramInt))
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout != null) {
          bool2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout.a(paramInt, paramBoolean);
        }
      }
      return bool2;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int b()
  {
    return this.u;
  }
  
  public Layout.Params b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params;
  }
  
  public String b()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    if (this.m != paramInt)
    {
      this.m = paramInt;
      if (!g()) {
        f();
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.t = paramInt1;
    this.u = paramInt2;
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_Int = paramInt2;
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void b(Canvas paramCanvas)
  {
    if (a() == null)
    {
      if (this.jdField_d_of_type_Int == 0) {
        break label51;
      }
      VirtualViewUtils.b(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, this.t, this.u, this.e, this.h, this.i, this.j, this.k);
    }
    label51:
    while (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.t / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.u / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void b(ViewBean paramViewBean)
  {
    if ((paramViewBean != null) && (paramViewBean.a != null) && (paramViewBean.a.a != null))
    {
      paramViewBean = paramViewBean.a.a.entrySet();
      if (!paramViewBean.isEmpty())
      {
        paramViewBean = paramViewBean.iterator();
        while (paramViewBean.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramViewBean.next();
          a((String)localEntry.getKey(), localEntry.getValue());
        }
        a();
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.v |= 0x20;; this.v &= 0xFFFFFFDF)
    {
      if (a() != null) {
        a().setClickable(paramBoolean);
      }
      return;
    }
  }
  
  public final boolean b()
  {
    return (this.v & 0x20) != 0;
  }
  
  protected boolean b(int paramInt)
  {
    boolean bool2 = c(paramInt);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout != null) {
        bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout.b(paramInt);
      }
    }
    return bool1;
  }
  
  public final boolean b(int paramInt, String paramString)
  {
    boolean bool2 = a(paramInt, paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params != null) {
        bool1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.a(paramInt, paramString);
      }
    }
    return bool1;
  }
  
  public int c()
  {
    return this.m;
  }
  
  public String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    int i2 = paramInt2;
    if (this.n > 0) {
      switch (this.n)
      {
      default: 
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
    for (;;)
    {
      a(i1, i2);
      return;
      i1 = paramInt1;
      i2 = paramInt2;
      if (1073741824 == View.MeasureSpec.getMode(paramInt1))
      {
        i2 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt1) * this.jdField_c_of_type_Float / this.jdField_b_of_type_Float), 1073741824);
        i1 = paramInt1;
        continue;
        i1 = paramInt1;
        i2 = paramInt2;
        if (1073741824 == View.MeasureSpec.getMode(paramInt2))
        {
          i1 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize(paramInt2) * this.jdField_b_of_type_Float / this.jdField_c_of_type_Float), 1073741824);
          i2 = paramInt2;
        }
      }
    }
  }
  
  public final boolean c()
  {
    return false;
  }
  
  protected boolean c(int paramInt)
  {
    return b();
  }
  
  public final int d()
  {
    if ((this.jdField_b_of_type_Int == 0) && (a() != null)) {
      this.jdField_b_of_type_Int = a().getLeft();
    }
    return this.jdField_b_of_type_Int;
  }
  
  public boolean d()
  {
    return this.m == 2;
  }
  
  protected boolean d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIBean != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreIBean.a(paramInt, true);
    }
    return false;
  }
  
  public final int e()
  {
    if ((this.jdField_c_of_type_Int == 0) && (a() != null)) {
      this.jdField_c_of_type_Int = a().getTop();
    }
    return this.jdField_c_of_type_Int;
  }
  
  public boolean e()
  {
    return false;
  }
  
  public final int f()
  {
    return this.o;
  }
  
  public void f()
  {
    a(this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_b_of_type_Int + this.t, this.jdField_c_of_type_Int + this.u);
  }
  
  public boolean f()
  {
    return this.m == 1;
  }
  
  public final int g()
  {
    return this.q;
  }
  
  protected void g() {}
  
  public final int h()
  {
    return this.p;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public final int i()
  {
    return this.r;
  }
  
  public final int j()
  {
    return a() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.jdField_c_of_type_Int + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.jdField_d_of_type_Int;
  }
  
  public final int k()
  {
    return b() + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.e + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
 * JD-Core Version:    0.7.0.1
 */