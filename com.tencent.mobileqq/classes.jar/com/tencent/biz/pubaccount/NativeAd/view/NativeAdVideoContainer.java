package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import bgxc;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import ohc;
import ohr;
import ois;
import oja;
import ojf;
import ufu;
import ufy;
import uks;
import uvp;

public class NativeAdVideoContainer
  extends RelativeLayout
  implements View.OnClickListener, ojf
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdRatingBar jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar;
  private ReadInJoyNativeAdAppVideoView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ohr jdField_a_of_type_Ohr;
  private oja jdField_a_of_type_Oja;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public NativeAdVideoContainer(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public NativeAdVideoContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    inflate(getContext(), 2131560105, this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView = ((ReadInJoyNativeAdAppVideoView)findViewById(2131362134));
    paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.getLayoutParams();
    paramContext.height = ((int)(getResources().getDisplayMetrics().widthPixels * 0.5626F));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setLayoutParams(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setOnVideoFullScreen(this);
    f();
    g();
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt, JumpMode paramJumpMode)
  {
    ois.a(new ufy().a(paramContext).a(1).b(17).a(paramJumpMode).a(paramAdvertisementInfo).d(paramInt).a());
  }
  
  private void a(View paramView, int paramInt)
  {
    int i = 4;
    paramView.getId();
    Object localObject = new ufu();
    ((ufu)localObject).b = true;
    localObject = uvp.a(uvp.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 4, true, (ufu)localObject), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    int j = paramView.getId();
    if ((j == 2131362123) || (j == 2131362084)) {
      i = 2;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, i, (JumpMode)localObject);
      return;
      if ((j == 2131362127) || (j == 2131362086)) {
        i = 3;
      } else if (j != 2131362090) {
        if ((j == 2131362125) || (j == 2131362063) || (j == 2131370600)) {
          i = 8;
        } else {
          i = paramInt;
        }
      }
    }
  }
  
  private void a(ReadInJoyHeadImageView paramReadInJoyHeadImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramReadInJoyHeadImageView.getWidth();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramReadInJoyHeadImageView.getHeight();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
    try
    {
      localObject = URLDrawable.getDrawable(new URL(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo), (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setDecodeHandler(bgxc.a);
      paramReadInJoyHeadImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    catch (MalformedURLException paramReadInJoyHeadImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("NativeAdVideoContainer", 2, "resetHeadImage() ERROR e = " + paramReadInJoyHeadImageView.getMessage());
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362091));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362123));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362127));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362125));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370600));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362126));
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.leftMargin = AIOUtils.dp2px(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar = ((AdRatingBar)findViewById(2131376098));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370613));
    this.f = ((TextView)findViewById(2131362089));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362093));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)findViewById(2131362084));
    this.c = ((TextView)findViewById(2131362086));
    this.d = ((TextView)findViewById(2131362090));
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)findViewById(2131368896));
    this.e = ((TextView)findViewById(2131362063));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo)) {
        break label191;
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName))
      {
        this.c.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt))
      {
        this.d.setVisibility(0);
        this.d.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt);
      }
      if ((!AdvertisementInfo.isAppAdvertisementInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdScoreNum < 8)) {
        break label212;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setStar(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdScoreNum / 2.0F);
    }
    for (;;)
    {
      String str = uks.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (TextUtils.isEmpty(str)) {
        break label224;
      }
      this.f.setText(str);
      this.f.setVisibility(0);
      return;
      label191:
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setVisibility(8);
      break;
      label212:
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(8);
    }
    label224:
    this.f.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.b();
    }
  }
  
  public void a(View paramView)
  {
    a(paramView, 9);
  }
  
  public void a(ohr paramohr, AdvertisementInfo paramAdvertisementInfo, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Ohr = paramohr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    ohc localohc = new ohc();
    localohc.a = false;
    localohc.b = true;
    localohc.c = true;
    localohc.d = false;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setAdSetting(localohc);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoData(paramohr, paramAdvertisementInfo, paramAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewAdRatingBar.setVisibility(8);
    h();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.b(getContext());
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a();
    }
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setisFullScreen(false, 8);
      if (this.jdField_a_of_type_Oja != null) {
        this.jdField_a_of_type_Oja.a();
      }
    }
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.a()))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setisFullScreen(true, 8);
      if (this.jdField_a_of_type_Oja != null) {
        this.jdField_a_of_type_Oja.b();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    a(paramView, 1000);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnVideoFullScreen(oja paramoja)
  {
    this.jdField_a_of_type_Oja = paramoja;
  }
  
  public void setVideoPlayPositon(long paramLong)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppVideoView.setVideoPlayPositon(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.NativeAdVideoContainer
 * JD-Core Version:    0.7.0.1
 */