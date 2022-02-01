package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import bhyk;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.util.NetworkState;
import java.lang.ref.WeakReference;
import ohr;
import ois;
import six;
import uec;
import ufu;
import ufy;
import ugj;
import uhs;
import ukc;
import uki;
import ukq;
import ukr;
import ukt;
import ulm;
import ulp;
import uno;
import unp;
import usq;
import uvp;

public class ReadInJoyArticleBottomVideoView
  extends ViewBase
  implements View.OnClickListener
{
  public static String a;
  public static boolean a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private ProteusBannerVideoItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData;
  private ReadInJoyAdVideoGuide jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private ohr jdField_a_of_type_Ohr;
  private ulp jdField_a_of_type_Ulp = new uno(this);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean = true;
  private boolean d;
  
  public ReadInJoyArticleBottomVideoView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramVafContext.getContext());
    a(paramVafContext.getContext());
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isCommentAd())) {
      return 38;
    }
    return 1;
  }
  
  private Context a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private void a(Context paramContext)
  {
    ukq.a("VideoPlayerWrapper_AD", "bottomView create:" + hashCode());
    if (paramContext == null) {
      return;
    }
    this.jdField_c_of_type_AndroidViewView = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131560115, null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext.getApplicationContext());
    d();
  }
  
  private void a(View paramView, boolean paramBoolean, int paramInt)
  {
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)
    {
      localObject2 = ukt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.g)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        }
      }
      if (localObject1 != null) {
        ((AdvertisementInfo)localObject1).clickPos = paramInt;
      }
      localObject2 = uvp.a(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData, (AdvertisementInfo)localObject1);
      if (localObject2 == JumpMode.FAIL) {
        break label82;
      }
    }
    label82:
    do
    {
      return;
      if (ugj.a((BaseArticleInfo)localObject1)) {
        localObject2 = TKDAdJumpData.NormalAdJumpData.obtainJumpData(localObject1).doJumpAction((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get());
      }
      if (localObject2 != JumpMode.FAIL)
      {
        uec.a(ReportAction.CLICK, (JumpMode)localObject2, (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (AdvertisementInfo)localObject1, 1, 1, 3);
        return;
      }
      boolean bool = a();
      localObject2 = uvp.a(paramView.getContext(), (AdvertisementInfo)localObject1, null, 2, paramBoolean, new ufu(bool));
    } while (localObject2 == null);
    ((GdtHandler.Params)localObject2).jdField_f_of_type_Boolean = ukr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
    ((GdtHandler.Params)localObject2).jdField_a_of_type_Long = ulm.a.a();
    if (localObject1 != null) {
      ((AdvertisementInfo)localObject1).setClickPos(paramInt);
    }
    paramView = uvp.a((GdtHandler.Params)localObject2, paramView.getContext(), (AdvertisementInfo)localObject1);
    if (localObject1 != null) {
      ((AdvertisementInfo)localObject1).setClickPos(paramInt);
    }
    uhs.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = (GdtHandler.Params)localObject2;
    if (uhs.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params != null) {}
    for (long l = SystemClock.elapsedRealtime();; l = -2147483648L)
    {
      uhs.jdField_a_of_type_Long = l;
      if ((localObject1 != null) && (!((AdvertisementInfo)localObject1).isCommentAd())) {
        ois.a(new ufy().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(BaseApplication.getContext()).a(1).b(8).a(paramView).a((AdvertisementInfo)localObject1).d(ois.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData)).d(paramInt).a());
      }
      a(true);
      return;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131380785));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362828));
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131362829));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131362832);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131362834));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewView.findViewById(2131380852));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide = ((ReadInJoyAdVideoGuide)this.jdField_c_of_type_AndroidViewView.findViewById(2131362070));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAdGuideClickListener(new unp(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewView.findViewById(2131380786));
    this.jdField_b_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131380984);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131381623));
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    b(false);
  }
  
  private void e()
  {
    if (this.d)
    {
      ukq.a("VideoPlayerWrapper_AD", "onVideoStartUI  with hasShowCompleteGuide");
      return;
    }
    ukq.a("VideoPlayerWrapper_AD", "onVideoStartUI");
    ukc.b(this.jdField_a_of_type_AndroidViewViewGroup);
    ukc.b(this.jdField_a_of_type_AndroidWidgetImageView);
    ukc.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    ukc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
    ukc.b(this.jdField_a_of_type_AndroidWidgetTextView);
    ukc.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    ukc.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  private void f()
  {
    if (this.d)
    {
      ukq.a("VideoPlayerWrapper_AD", "onVideoPauseUI  with hasShowCompleteGuide");
      return;
    }
    ukq.a("VideoPlayerWrapper_AD", "onVideoPauseUI");
    ukc.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (NetworkState.isWifiConn())
    {
      ukc.b(this.jdField_a_of_type_AndroidViewViewGroup);
      ukc.a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (ulm.a.a() != 7) {
        break label108;
      }
      ukc.a(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
    for (;;)
    {
      ukc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
      ukc.b(this.jdField_a_of_type_AndroidWidgetTextView);
      ukc.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      return;
      ukc.a(this.jdField_a_of_type_AndroidViewViewGroup);
      ukc.b(this.jdField_a_of_type_AndroidWidgetImageView);
      break;
      label108:
      ukc.b(this.jdField_a_of_type_ComTencentImageURLImageView);
    }
  }
  
  private void g()
  {
    ukq.a("VideoPlayerWrapper_AD", "onVideoCompleteUI");
    this.d = true;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Boolean = true;
    }
    ukc.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    ukc.b(this.jdField_a_of_type_AndroidViewViewGroup);
    ukc.b(this.jdField_a_of_type_AndroidWidgetImageView);
    ukc.b(this.jdField_a_of_type_AndroidWidgetTextView);
    ukc.b(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    ukc.a(this.jdField_a_of_type_ComTencentImageURLImageView);
    ukc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide);
  }
  
  private void h()
  {
    ukq.a("VideoPlayerWrapper_AD", "onVideoErrorUI");
    f();
    ukc.a(this.jdField_a_of_type_ComTencentImageURLImageView);
  }
  
  private void i()
  {
    ukq.a("VideoPlayerWrapper_AD", "initCoverView");
    if (this.jdField_a_of_type_ComTencentImageURLImageView == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((this.jdField_a_of_type_Ohr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ohr.e)))
        {
          jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Ohr.e;
          Object localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(-16777216);
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "fast_web";
          localObject = URLDrawable.getDrawable(usq.a(jdField_a_of_type_JavaLangString, 4), (URLDrawable.URLDrawableOptions)localObject);
          if ((localObject != null) && (((URLDrawable)localObject).getStatus() == 2)) {
            ((URLDrawable)localObject).restartDownload();
          }
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyAdVideoGuide.setAppInfo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.B, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.h, uki.g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
  }
  
  private void k()
  {
    String str2;
    String str1;
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      str2 = anvx.a(2131712509);
      if (bhyk.a() != 1) {
        break label37;
      }
      str1 = anvx.a(2131712242);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str1);
      return;
      label37:
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Long > 0L) {
          str1 = six.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Long) + anvx.a(2131712266);
        }
      }
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData.jdField_f_of_type_Boolean = false;
    this.d = false;
    this.jdField_c_of_type_Boolean = true;
    ulm.a.a(true);
    ulm.a.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_Ohr, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData);
  }
  
  public void a() {}
  
  public void a(ohr paramohr, AdvertisementInfo paramAdvertisementInfo, ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if (ulm.a.a(paramProteusBannerVideoItemData1)) {
      return;
    }
    this.jdField_a_of_type_Ohr = paramohr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataProteusBannerVideoItemData = paramProteusBannerVideoItemData1;
    i();
    j();
    k();
    ukq.a("VideoPlayerWrapper_AD", "view videoContainer is " + this.jdField_a_of_type_AndroidWidgetRelativeLayout.hashCode());
    ulm.a.a(paramProteusBannerVideoItemData1.o, this.jdField_a_of_type_Ulp);
    ulm.a.a(false);
    ulm.a.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramohr, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramProteusBannerVideoItemData1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ulm.a.a(ReportConstants.VideoEndType.AD_AREA_CLICK);
    }
    for (;;)
    {
      ulm.a.g();
      return;
      ulm.a.a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
  }
  
  public boolean a()
  {
    return ulm.a.a();
  }
  
  public void b()
  {
    ulm.a.f();
  }
  
  public void c() {}
  
  public int getComMeasuredHeight()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.getMeasuredHeight();
    }
    return 0;
  }
  
  public int getComMeasuredWidth()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return this.jdField_c_of_type_AndroidViewView.getMeasuredWidth();
    }
    return 0;
  }
  
  public View getNativeView()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void onClick(View paramView)
  {
    int i = 5;
    if (a()) {
      i = 6;
    }
    a(paramView, false, i);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.measure(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView
 * JD-Core Version:    0.7.0.1
 */