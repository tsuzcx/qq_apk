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
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
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
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInjoyAdSuperBgDrawable jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = -1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#00000000"));
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
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
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560175, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369567));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369568));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
  }
  
  private void a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.jdField_a_of_type_Int = paramView.getTop();
      }
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a() != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a().getPaddingTop();
      this.c = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a().getTop();
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a().a().getBottom();
      }
    }
    for (;;)
    {
      this.d = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyDoubleImageView", 2, "initQQUIHeight cannot get listview's too and padding.");
      }
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImagePlaceHolder(paramDrawable);
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 2)) {
      paramDrawable.restartDownload();
    }
    do
    {
      return;
      if ((paramDrawable != null) && (paramDrawable.getStatus() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyDoubleImageView", 2, "status=URLDrawable.SUCCESSED:" + paramString);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable = new ReadInjoyAdSuperBgDrawable(paramDrawable.getCurrDrawable(), this.d, this.jdField_a_of_type_Int - (this.jdField_b_of_type_Int + this.c));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable);
        this.jdField_a_of_type_JavaLangString = paramString;
        return;
      }
    } while (paramDrawable == null);
    paramDrawable.setURLDrawableListener(new ReadInjoyDoubleImageView.1(this, paramString));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      if (!ReadInJoyAdUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label92;
        }
      }
    }
    label92:
    for (Object localObject = ((URL)localObject).getFile();; localObject = null)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)localObject, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractType == 2) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList))) {
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractImageList, this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
      return;
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg)) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg.equals(this.jdField_a_of_type_JavaLangString))) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mImaxImg, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getVisibility() == 0) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setAlpha(paramFloat);
    if (paramFloat > 0.0F)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (a() < 0) {}
    int i;
    do
    {
      return;
      i = paramInt2;
      if (paramInt2 < a())
      {
        i = paramInt2;
        if (paramInt3 == 2)
        {
          i = paramInt2;
          if (this.e + 1 != paramInt2)
          {
            i = paramInt2;
            if (this.e != 0)
            {
              i = paramInt2;
              if (Math.abs(paramInt2 - this.e) > 3)
              {
                i = paramInt2;
                if (paramDouble <= 0.0D)
                {
                  i = paramInt2;
                  if (paramInt2 <= this.e) {
                    i = this.e + 1;
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
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable == null);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable.getCallback() == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable);
    }
    paramInt2 = -(Math.abs(i) - Math.abs(this.jdField_b_of_type_Int));
    if (i <= 0) {
      paramInt2 = this.jdField_b_of_type_Int + Math.abs(i);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable.a(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f3 = 0.0F;
    float f2 = 1.0F;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {}
    do
    {
      return;
      switch (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mInteractEffectType)
      {
      default: 
        return;
      }
    } while ((paramInt1 <= 0) || (paramInt2 <= 0));
    float f1 = paramInt3 / paramInt1;
    if (paramBoolean) {
      f1 = 1.0F - paramInt4 * 1.0F / paramInt1;
    }
    if (f1 < 0.0F) {
      f1 = f3;
    }
    for (;;)
    {
      if (f1 > 1.0F) {
        f1 = f2;
      }
      for (;;)
      {
        a(f1);
        return;
      }
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (ReadInJoyAdUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))) {
      c();
    }
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label79;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label79:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in resources dir, do nothing");
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    b();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInjoyAdSuperBgDrawable = null;
    }
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
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("ReadInjoyDoubleImageView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView
 * JD-Core Version:    0.7.0.1
 */