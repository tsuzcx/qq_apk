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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyAdCommonBlurImageView
  extends ViewBase
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private Handler jdField_a_of_type_AndroidOsHandler = new ReadInJoyAdCommonBlurImageView.1(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyAdCommonBlurImageView.BlurDataModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  
  public ReadInJoyAdCommonBlurImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a()
  {
    ReadInJoyAdCommonBlurImageView.BlurDataModel localBlurDataModel = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel;
    if (localBlurDataModel != null) {
      try
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView, localBlurDataModel.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560055, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369301));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel;
      if (localObject == null) {
        return;
      }
      localObject = CommonImageCacheHelper.a(String.valueOf(((ReadInJoyAdCommonBlurImageView.BlurDataModel)localObject).b));
      if (localObject == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageBitmap((Bitmap)localObject);
      int i = 0;
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        i = AIOUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext.getResources());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setCorner(i, i, i, i);
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    paramNativeReadInjoyImageView = new StringBuilder();
    paramNativeReadInjoyImageView.append("loadImage: path is ");
    paramNativeReadInjoyImageView.append(paramString);
    QLog.d("ReadInJoyAdCommonBlurImageView", 2, paramNativeReadInjoyImageView.toString());
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      paramNativeReadInjoyImageView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdCommonBlurImageView$BlurDataModel;
      if (paramNativeReadInjoyImageView != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView == null) {
          return;
        }
        paramNativeReadInjoyImageView = paramNativeReadInjoyImageView.b;
        if (CommonImageCacheHelper.a(paramNativeReadInjoyImageView) == null)
        {
          ThreadManagerV2.excute(new ReadInJoyAdCommonBlurImageView.2(this, paramString, paramNativeReadInjoyImageView), 128, null, false);
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageSrc(null);
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInJoyAdCommonBlurImageView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView
 * JD-Core Version:    0.7.0.1
 */