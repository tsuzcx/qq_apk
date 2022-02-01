package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.URL;

public class ReadInjoyDoubleImageView
  extends ViewBase
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private View jdField_a_of_type_AndroidViewView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInjoyAdSuperBgDrawable jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView;
  private int c = -1;
  private int d = 0;
  private int e = 0;
  
  public ReadInjoyDoubleImageView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_Int - getComMeasuredHeight();
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560062, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369278));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369279));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    View localView = null;
    Object localObject = null;
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localObject;
      for (;;)
      {
        localView = paramView;
        if (!(localContext instanceof ContextWrapper)) {
          break;
        }
        if ((localContext instanceof Activity)) {
          paramView = (Activity)localContext;
        }
        localContext = ((ContextWrapper)localContext).getBaseContext();
      }
    }
    if ((localView != null) && (localView.getWindow() != null))
    {
      paramView = localView.getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.jdField_a_of_type_Int = paramView.getTop();
      }
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
    if ((paramView != null) && (paramView.a() != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a() != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a().getPaddingTop();
      this.c = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a().getTop();
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a().getBottom();
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("ReadInjoyDoubleImageView", 2, "initQQUIHeight cannot get listview's too and padding.");
    }
    this.d = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImagePlaceHolder(paramDrawable);
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 2))
    {
      paramDrawable.restartDownload();
      return;
    }
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("status=URLDrawable.SUCCESSED:");
        localStringBuilder.append(paramString);
        QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable = new ReadInjoyAdSuperBgDrawable(paramDrawable.getCurrDrawable(), this.d, this.jdField_a_of_type_Int - (this.jdField_b_of_type_Int + this.c));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable);
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
    if (paramDrawable != null) {
      paramDrawable.setURLDrawableListener(new ReadInjoyDoubleImageView.1(this, paramString));
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject != null) {
          localObject = ((URL)localObject).getFile();
        } else {
          localObject = null;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView, (String)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList))) {
        a(this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg.equals(this.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.getVisibility() == 0) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(8);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setAlpha(paramFloat);
    if (paramFloat > 0.0F)
    {
      this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (a() < 0) {
      return;
    }
    int i = paramInt2;
    if (paramInt2 < a())
    {
      i = paramInt2;
      if (paramInt3 == 2)
      {
        paramInt3 = this.e;
        i = paramInt2;
        if (paramInt3 + 1 != paramInt2)
        {
          i = paramInt2;
          if (paramInt3 != 0)
          {
            i = paramInt2;
            if (Math.abs(paramInt2 - paramInt3) > 3)
            {
              i = paramInt2;
              if (paramDouble <= 0.0D)
              {
                paramInt3 = this.e;
                i = paramInt2;
                if (paramInt2 <= paramInt3) {
                  i = paramInt3 + 1;
                }
              }
            }
          }
        }
      }
    }
    if (this.e != i) {
      this.e = i;
    }
    ReadInjoyAdSuperBgDrawable localReadInjoyAdSuperBgDrawable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable;
    if (localReadInjoyAdSuperBgDrawable != null)
    {
      if (localReadInjoyAdSuperBgDrawable.getCallback() == null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable);
      }
      paramInt2 = -(Math.abs(i) - Math.abs(this.jdField_b_of_type_Int));
      if (i <= 0) {
        paramInt2 = this.jdField_b_of_type_Int + Math.abs(i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localAdvertisementInfo == null) {
      return;
    }
    int i = localAdvertisementInfo.mInteractEffectType;
    if ((i != 2) && (i != 3)) {
      return;
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f1 = paramInt3;
      float f2 = paramInt1;
      f1 /= f2;
      if (paramBoolean) {
        f1 = 1.0F - paramInt4 * 1.0F / f2;
      }
      f2 = 0.0F;
      if (f1 < 0.0F) {
        f1 = f2;
      }
      f2 = f1;
      if (f1 > 1.0F) {
        f2 = 1.0F;
      }
      a(f2);
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadImage: path is ");
    localStringBuilder.append(paramString);
    QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
    if ((paramString != null) && (!paramString.equals("-1"))) {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount")))
      {
        paramString = ImageCommon.getDrawableResourceId(paramString);
        if (paramString == null) {
          break label135;
        }
        QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
      }
    }
    label135:
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      label107:
      break label107;
    }
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in resources dir, do nothing");
    return;
    if (paramDrawable != null) {
      paramNativeReadInjoyImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    paramNativeReadInjoyImageView.setImageSrc(paramString);
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isSuperBackgroundAdType(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      c();
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    b();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageSrc(null);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable = null;
    }
  }
  
  protected boolean setAttribute(int paramInt, Object paramObject)
  {
    if (paramInt != 1042) {
      return super.setAttribute(paramInt, paramObject);
    }
    if (paramObject != null) {
      try
      {
        if ((paramObject instanceof AdvertisementInfo))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
          return true;
        }
      }
      catch (Exception paramObject)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAttribute STR_ID_SET_AD_BANNER exception ");
        localStringBuilder.append(paramObject.toString());
        QLog.d("ReadInjoyDoubleImageView", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView
 * JD-Core Version:    0.7.0.1
 */