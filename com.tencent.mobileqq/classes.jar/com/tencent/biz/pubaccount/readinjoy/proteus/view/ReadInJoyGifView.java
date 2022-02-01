package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeGifView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyGifView
  extends ViewBase
{
  private int jdField_a_of_type_Int;
  private NativeGifView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public ReadInJoyGifView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView = new NativeGifView(paramVafContext.getContext());
  }
  
  private boolean a()
  {
    return this.mParams.mLayoutHeight * this.mParams.mLayoutWidth > 2000000;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    if ((this.jdField_a_of_type_Int > 0) && (this.b > 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setGifHeight(this.b);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setGifWidth(this.jdField_a_of_type_Int);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setGifUrl(this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setIsBigImg(a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setBackgroundColor(this.mBackground);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.displayGif(this.mParams.mLayoutWidth, this.mParams.mLayoutHeight);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.invalidate();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    Layout.Params localParams;
    switch (paramInt)
    {
    default: 
      return super.setAttribute(paramInt, paramObject);
    case 59: 
      try
      {
        localParams = this.mParams;
        paramInt = ((Integer)paramObject).intValue();
        localParams.mLayoutWidth = paramInt;
        this.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.requestLayout();
        return true;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
        }
      }
    }
    try
    {
      localParams = this.mParams;
      paramInt = ((Integer)paramObject).intValue();
      localParams.mLayoutHeight = paramInt;
      this.b = paramInt;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.requestLayout();
      return true;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        QLog.d("ReadInJoyGifView", 2, paramObject.getMessage());
      }
    }
  }
  
  public boolean setAttribute(int paramInt, String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramString);
    case 1154: 
    case 1163: 
    case 51: 
      for (;;)
      {
        return bool1;
        this.jdField_a_of_type_JavaLangString = paramString;
        return true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setCoverUrl(paramString);
        return true;
        try
        {
          paramString = Utils.toInteger(paramString);
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView != null)
          {
            bool1 = bool2;
            if (paramString != null)
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setScaleType(paramString.intValue());
              return true;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.d("ReadInJoyGifView", 2, paramString.getMessage());
          return true;
        }
      }
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeGifView.setNeedGifUrl("yes".equals(paramString.toLowerCase()));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyGifView
 * JD-Core Version:    0.7.0.1
 */