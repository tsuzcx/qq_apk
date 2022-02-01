package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;

public class ReadInJoyAdExpandCardPic
  extends ViewBase
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private URLImageView b;
  private URLImageView c;
  
  public ReadInJoyAdExpandCardPic(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = ViewUtils.a(paramInt1);
    localURLDrawableOptions.mRequestHeight = ViewUtils.a(paramInt2);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    if (paramInt3 != 0)
    {
      paramString.setTag(new int[] { 0, 0, paramInt3, 0 });
      paramString.setDecodeHandler(URLDrawableDecodeHandler.j);
    }
    return paramString;
  }
  
  private void a()
  {
    if ((this.b != null) && (this.jdField_a_of_type_ComTencentImageURLImageView != null))
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if ((localObject1 != null) && (((AdvertisementInfo)localObject1).mSinglePicture != null))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSinglePicture.getPath() == null) {
          return;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSinglePicture.getPath();
        localObject1 = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j, 351, 60, 16);
        localObject2 = a((String)localObject2, 351, 351, 0);
        this.b.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        this.c.setImageDrawable(a("https://img.nfa.qq.com/gmaster_prod/16104096/gmaster_b5gbv9fgqyg_adtagclose.png", 45, 20, 0));
      }
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = (LayoutInflater)paramContext.getSystemService("layout_inflater");
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidViewView = paramContext.inflate(2131560060, null);
    }
    paramContext = this.jdField_a_of_type_AndroidViewView;
    if (paramContext != null)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramContext.findViewById(2131366353));
      this.b = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366356));
      this.c = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362082));
      this.c.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
      this.b.setOnClickListener(this);
    }
  }
  
  private void a(View paramView1, View paramView2, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) && (paramView1 != null))
    {
      if (paramView2 == null) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(1000L);
      localAlphaAnimation.setDuration(1000L);
      paramView1.startAnimation((Animation)localObject);
      paramView2.startAnimation(localAlphaAnimation);
      paramView1.setAlpha(1.0F);
      paramView2.setAlpha(1.0F);
      paramView1.setVisibility(0);
      paramView2.setVisibility(0);
      localObject = ValueAnimator.ofFloat(new float[] { paramInt1, paramInt2 });
      ((ValueAnimator)localObject).setDuration(paramLong);
      ((ValueAnimator)localObject).addListener(new ReadInJoyAdExpandCardPic.1(this, paramView1, paramView2));
      ((ValueAnimator)localObject).addUpdateListener(new ReadInJoyAdExpandCardPic.2(this));
      ((ValueAnimator)localObject).start();
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLImageView != null) && (this.b != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetViewisClose:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickClose);
      ((StringBuilder)localObject).append("isSmallCard");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", ((StringBuilder)localObject).toString());
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if ((localObject != null) && (!((AdvertisementInfo)localObject).isClickClose))
      {
        this.b.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(1.0F);
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard)
        {
          this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
          this.b.setVisibility(8);
          ReadInJoyAdUtils.a(this.jdField_a_of_type_AndroidViewView, ViewUtils.a(351.0F));
          ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentImageURLImageView, ViewUtils.a(351.0F));
          return;
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
        this.b.setVisibility(0);
        ReadInJoyAdUtils.a(this.jdField_a_of_type_AndroidViewView, ViewUtils.a(60.0F));
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("click close");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard);
    ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard)
    {
      a(this.jdField_a_of_type_ComTencentImageURLImageView, this.b, 1000L, ViewUtils.a(351.0F), ViewUtils.a(60.0F));
      RIJAdReportManager.a(new AdReportData().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a()).a(1).b(3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).c(40));
    }
    else
    {
      RIJAdReportManager.a(new AdReportData().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a()).a(1).b(3).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).c(39));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickClose = true;
      setVisibility(8);
      try
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a());
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a(0, (ArrayList)localObject, new ArrayList(), null, false, true);
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("click close error");
        localStringBuilder.append(localException.getMessage());
        ReadInJoyAdLog.b("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard = true;
  }
  
  public void a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isSmallCard) && (this.b != null))
    {
      if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {
        return;
      }
      paramInt = ViewUtils.a(351.0F) - paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("alphaCard");
      localStringBuilder.append(paramInt);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      if (paramInt <= 0) {
        return;
      }
      float f = paramInt / ViewUtils.a(351.0F);
      this.b.setVisibility(0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("alphaCard showPer  ");
      localStringBuilder.append(f);
      ReadInJoyAdLog.a("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
      if (f < 1.0F) {
        this.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(f);
      }
      this.b.setAlpha(1.0F - f);
      if (f < 0.25D)
      {
        this.jdField_a_of_type_ComTencentImageURLImageView.setAlpha(0.0F);
        this.b.setAlpha(1.0F);
      }
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramIReadInJoyModel.a());
      a();
      b();
      return;
    }
    catch (Exception paramIReadInJoyModel)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setModel error");
      localStringBuilder.append(paramIReadInJoyModel.getMessage());
      ReadInJoyAdLog.b("ReadInJoyAdExpandCardPic", localStringBuilder.toString());
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
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362082)
    {
      c();
      return;
    }
    if (i == 2131366353)
    {
      ReadinJoyActionUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), 0, 5);
      return;
    }
    if (i == 2131366356) {
      ReadinJoyActionUtil.a(null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), 0, 1000);
    }
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
        QLog.d("ReadInJoyAdExpandCardPic", 1, localStringBuilder.toString());
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic
 * JD-Core Version:    0.7.0.1
 */