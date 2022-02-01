package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.graphics.Color;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public class ReadInJoyMiddleBodyView
  extends ViewBase
{
  private int jdField_a_of_type_Int = -1;
  private NativeMiddleBodyView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  
  public ReadInJoyMiddleBodyView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView = new NativeMiddleBodyView(paramVafContext.getContext());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(RelativeLayout.LayoutParams paramLayoutParams)
  {
    if (a()) {
      paramLayoutParams.setMargins(0, 0, 0, 0);
    }
  }
  
  public boolean a()
  {
    return (this.mPaddingLeft > 0) || (this.mPaddingRight > 0);
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof JSONArray));
      paramObject = (JSONArray)paramObject;
      bool1 = bool2;
    } while (paramObject.length() < 4);
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeMiddleBodyView.setRadius(paramObject.getString(0), paramObject.getString(1), paramObject.getString(2), paramObject.getString(3));
      return true;
    }
    catch (JSONException paramObject)
    {
      QLog.d("ReadInJoyMiddleBodyView", 2, "", paramObject);
    }
    return true;
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramString);
    case 1192: 
      try
      {
        this.b = Color.parseColor(String.valueOf(paramString));
        QLog.d("ReadInJoyMiddleBodyView", 1, "setEmotionFontColor: " + this.b);
        return true;
      }
      catch (Exception paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    case 1191: 
      try
      {
        this.jdField_a_of_type_Int = Utils.dp2px(Integer.valueOf(String.valueOf(paramString)).intValue());
        QLog.d("ReadInJoyMiddleBodyView", 1, "setEmotionFontSize: " + this.jdField_a_of_type_Int);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    case 1193: 
      try
      {
        this.c = Utils.rp2px(Float.valueOf(String.valueOf(paramString)).floatValue());
        QLog.d("ReadInJoyMiddleBodyView", 1, "setEmotionlineSpace: " + this.c);
        return true;
      }
      catch (NumberFormatException paramString)
      {
        QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
        return false;
      }
    }
    try
    {
      this.d = Color.parseColor(String.valueOf(paramString));
      QLog.d("ReadInJoyMiddleBodyView", 1, "setLinkTextColor: " + this.d);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ReadInJoyMiddleBodyView", 1, paramString, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyMiddleBodyView
 * JD-Core Version:    0.7.0.1
 */