package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ColorUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;

public class NativeButton
  extends ButtonBase
{
  private NativeButtonImp a;
  
  NativeButton(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp = new NativeButtonImp(paramVafContext.a());
  }
  
  private void a(Drawable paramDrawable, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
      return;
    case 1: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setCompoundDrawablesWithIntrinsicBounds(null, paramDrawable, null, null);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setCompoundDrawablesWithIntrinsicBounds(null, null, paramDrawable, null);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setCompoundDrawablesWithIntrinsicBounds(null, null, null, paramDrawable);
  }
  
  private void d(String paramString)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setText(Html.fromHtml(paramString));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setText(paramString);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.a();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp;
  }
  
  public void a()
  {
    int i = 1;
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setClickable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setIncludeFontPadding(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setPadding(this.o, this.q, this.p, this.r);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setTextSize(0, this.C);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setCompoundDrawablePadding(this.A);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setLineSpacing(0.0F, 1.0F);
    if ((this.D & 0x1) != 0) {
      i = 33;
    }
    int j = i;
    if ((this.D & 0x8) != 0) {
      j = i | 0x10;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setPaintFlags(j);
    if ((this.D & 0x2) != 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setTypeface(null, 3);
    }
    if (!TextUtils.isEmpty(this.e)) {
      d(this.e);
    }
    for (;;)
    {
      f();
      return;
      d("");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.b(paramInt1, paramInt2);
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.e))
    {
      this.e = paramString;
      d(this.e);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setSelected(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.b();
  }
  
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.getContext();
    localObject = DrawableUtil.a(DrawableUtil.a((Context)localObject, a(0).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(1).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a((Context)localObject, a(4).b, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setBackgroundDrawable((Drawable)localObject);
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setBackgroundDrawable(DrawableUtil.a(a(0).c, a(1).c, a(4).c));
  }
  
  public void c(int paramInt)
  {
    if (this.B != paramInt)
    {
      this.B = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setTextColor(this.B);
    }
  }
  
  protected void c(String paramString)
  {
    this.f = paramString;
    d();
  }
  
  protected void d()
  {
    Context localContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.getContext();
    if ((this.f != null) && (a(0).jdField_a_of_type_JavaLangString != this.f)) {
      a(0).jdField_a_of_type_JavaLangString = this.f;
    }
    a(DrawableUtil.a(DrawableUtil.a(localContext, a(0).jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a(localContext, a(1).jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable), DrawableUtil.a(localContext, a(4).jdField_a_of_type_JavaLangString, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)), a(this.z).jdField_a_of_type_Int);
  }
  
  protected void e()
  {
    ColorStateList localColorStateList = ColorUtil.a(a(0).d, a(1).d, a(4).d);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewViewButtonNativeButtonImp.setTextColor(localColorStateList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton
 * JD-Core Version:    0.7.0.1
 */