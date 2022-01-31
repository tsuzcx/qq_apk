package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Rect;
import android.view.View.MeasureSpec;

public class ViewBase$VirtualViewImp
  implements IView
{
  public int a()
  {
    return 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = View.MeasureSpec.getMode(paramInt2);
    if (this.a.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.a.g();
    }
    if (-2 == this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.a) {
      if (this.a.jdField_a_of_type_AndroidGraphicsRect != null) {
        this.a.t = (this.a.jdField_a_of_type_AndroidGraphicsRect.width() + this.a.o + this.a.p);
      }
    }
    while (-2 == this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.b) {
      if (this.a.jdField_a_of_type_AndroidGraphicsRect != null)
      {
        this.a.u = (this.a.jdField_a_of_type_AndroidGraphicsRect.height() + this.a.q + this.a.r);
        return;
        this.a.t = this.a.w;
        continue;
        if (-1 == this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.a)
        {
          if (1073741824 == paramInt1) {
            this.a.t = i;
          } else {
            this.a.t = 0;
          }
        }
        else if (1073741824 == paramInt1) {
          this.a.t = i;
        } else {
          this.a.t = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.a;
        }
      }
      else
      {
        this.a.u = this.a.x;
        return;
      }
    }
    if (-1 == this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.b)
    {
      if (1073741824 == paramInt2)
      {
        this.a.u = j;
        return;
      }
      this.a.u = 0;
      return;
    }
    if (1073741824 == paramInt2)
    {
      this.a.u = j;
      return;
    }
    this.a.u = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreLayout$Params.b;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public int b()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.VirtualViewImp
 * JD-Core Version:    0.7.0.1
 */