package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyAdCommonBlurImageView
  extends ViewBase
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private Handler jdField_a_of_type_AndroidOsHandler = new ReadInJoyAdCommonBlurImageView.1(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private ReadInJoyAdCommonBlurImageView.BlurDataModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel;
  
  public ReadInJoyAdCommonBlurImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel != null) {}
    try
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel.a, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560169, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369591));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel == null)) {}
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = CommonImageCacheHelper.a(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel.b));
    } while (localBitmap == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageBitmap(localBitmap);
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    QLog.d("ReadInJoyAdCommonBlurImageView", 2, "loadImage: path is " + paramString);
    if ((paramString == null) || (paramString.equals("-1")) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView == null)) {
      return;
    }
    paramNativeReadInjoyImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel.b;
    if (CommonImageCacheHelper.a(paramNativeReadInjoyImageView) == null)
    {
      ThreadManagerV2.excute(new ReadInJoyAdCommonBlurImageView.2(this, paramString, paramNativeReadInjoyImageView), 128, null, false);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    a();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
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
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof ReadInJoyAdCommonBlurImageView.BlurDataModel))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel = ((ReadInJoyAdCommonBlurImageView.BlurDataModel)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel = null;
          QLog.d("ReadInJoyAdCommonBlurImageView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView
 * JD-Core Version:    0.7.0.1
 */