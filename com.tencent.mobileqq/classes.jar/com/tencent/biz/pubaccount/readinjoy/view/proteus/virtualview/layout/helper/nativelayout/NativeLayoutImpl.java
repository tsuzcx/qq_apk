package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IContainer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;
import java.util.Iterator;
import java.util.List;

public class NativeLayoutImpl
  extends ViewGroup
  implements IContainer, IView
{
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  protected ViewBase a;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = -16777216;
  
  public NativeLayoutImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.a();
    }
    return 0;
  }
  
  public View a()
  {
    return this;
  }
  
  public ViewBase a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
      setMeasuredDimension(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.b());
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
      layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void a(ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    View localView;
    do
    {
      for (;;)
      {
        return;
        if (!(paramViewBase instanceof Layout)) {
          break;
        }
        if (paramViewBase.a() != null)
        {
          localView = paramViewBase.a();
          if (localView != null) {
            addView(localView, new ViewGroup.LayoutParams(paramViewBase.b().jdField_a_of_type_Int, paramViewBase.b().jdField_b_of_type_Int));
          }
        }
        else
        {
          paramViewBase = ((Layout)paramViewBase).a();
          if (paramViewBase != null)
          {
            paramViewBase = paramViewBase.iterator();
            while (paramViewBase.hasNext()) {
              a((ViewBase)paramViewBase.next());
            }
          }
        }
      }
      localView = paramViewBase.a();
    } while (localView == null);
    addView(localView, new ViewGroup.LayoutParams(paramViewBase.b().jdField_a_of_type_Int, paramViewBase.b().jdField_b_of_type_Int));
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.b();
    }
    return 0;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase != null) {
      setMeasuredDimension(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.b());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      VirtualViewUtils.b(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
    super.onDraw(paramCanvas);
    if (this.f > 0)
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
      VirtualViewUtils.a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2) {}
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setBorderBottomLeftRadius(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBorderBottomRightRadius(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setBorderTopLeftRadius(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setBorderTopRightRadius(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setVirtualView(ViewBase paramViewBase)
  {
    if (paramViewBase != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramViewBase;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.a(this);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.f()) {
        setWillNotDraw(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl
 * JD-Core Version:    0.7.0.1
 */