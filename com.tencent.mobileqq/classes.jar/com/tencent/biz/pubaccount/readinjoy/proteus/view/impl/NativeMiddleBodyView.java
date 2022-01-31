package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;

public class NativeMiddleBodyView
  extends RelativeLayout
  implements IView
{
  private static String e = "NativeMiddleBodyView";
  View jdField_a_of_type_AndroidViewView = null;
  NativeMiddleBodyView.RadiusView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView = null;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String b;
  String c;
  String d;
  
  public NativeMiddleBodyView(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (paramLayoutParams != null) {
      super.addView(paramView, paramLayoutParams);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView == null)
        {
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          if (paramLayoutParams != null) {
            localLayoutParams.setMargins(paramLayoutParams.leftMargin, paramLayoutParams.topMargin, paramLayoutParams.rightMargin, paramLayoutParams.bottomMargin);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView = new NativeMiddleBodyView.RadiusView(getContext());
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView.setLeftTopRadius(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView.setRightTopRadius(this.b);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView.setBottomRightRadius(this.c);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView.setBottomLeftRadius(this.d);
          addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView, localLayoutParams);
        }
        paramView.addOnLayoutChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView$RadiusView.a());
      }
      return;
      super.addView(paramView);
    }
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    onComLayout(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void setRadius(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView
 * JD-Core Version:    0.7.0.1
 */