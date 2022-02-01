package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsResourceLoader;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadinjoyAdCache;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.LiuHaiUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyAdPKFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ReadinjoyAdPKFragment.1(this);
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView d;
  
  private void a()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)getArguments().getParcelable("param_ad_info");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "PARAM_AD_INFO: null");
      }
      getActivity().finish();
      return;
    }
    localAdvertisementInfo.resetClickPos();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = localAdvertisementInfo;
  }
  
  private void a(int paramInt)
  {
    AdJumpParams localAdJumpParams = new AdJumpParams();
    localAdJumpParams.b = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = paramInt;
    Object localObject2 = ReadinJoyActionUtil.a(ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, NativeAdUtils.a(paramInt), localAdJumpParams), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    Object localObject1 = localObject2;
    if (((Integer)localObject2).intValue() == -1)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.j != 32)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = true;
          localObject1 = ReadinJoyActionUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, NativeAdUtils.a(paramInt), false, localAdJumpParams);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isClickFromPkFragment = false;
        }
      }
    }
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("comp_stat_src", "12");
      NativeAdUtils.a(new AdReportData().a(getActivity()).a(1).b(32).b((Integer)localObject1).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).e((JSONObject)localObject2).c(paramInt).a(true));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends ReadinjoyAdPKFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "error");
      }
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtras(paramBundle);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, String paramString, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = getActivity().getWindowManager().getDefaultDisplay().getWidth();
    localURLDrawableOptions.mRequestHeight = paramKandianUrlImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      if (paramBoolean) {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.a);
      }
      paramKandianUrlImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramKandianUrlImageView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ReadinjoyAdPKFragment", 2, "loadImage ERROR e = " + paramKandianUrlImageView.getMessage());
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362144));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362105));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362107));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380651));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368820));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368836));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380437));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380574));
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131371175));
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371175).setOnClickListener(this);
    URL localURL = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.getVideoCoverUrlWithSmartCut(false);
    Object localObject;
    if (localURL != null)
    {
      localObject = localURL.getFile();
      if (localURL == null) {
        break label504;
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, (String)localObject, false);
    }
    for (;;)
    {
      ReadInJoyDisplayUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, localURL, this.jdField_a_of_type_AndroidContentContext, true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName);
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo, true);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.size() >= 2))
      {
        localObject = (AdPKImageData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.get(0);
        if (localObject != null)
        {
          if (!TextUtils.isEmpty(((AdPKImageData)localObject).c)) {
            this.jdField_c_of_type_AndroidWidgetTextView.setText(((AdPKImageData)localObject).c);
          }
          if (!TextUtils.isEmpty(((AdPKImageData)localObject).d)) {
            a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((AdPKImageData)localObject).d, false);
          }
        }
        localObject = (AdPKImageData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.a.get(1);
        if (localObject != null)
        {
          if (!TextUtils.isEmpty(((AdPKImageData)localObject).c)) {
            this.d.setText(((AdPKImageData)localObject).c);
          }
          if (!TextUtils.isEmpty(((AdPKImageData)localObject).d)) {
            a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, ((AdPKImageData)localObject).d, false);
          }
        }
      }
      localObject = ReadinjoyAdCache.a(1);
      if ((localObject instanceof Bitmap)) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
      ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      c();
      return;
      localObject = null;
      break;
      label504:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(4);
    }
  }
  
  private void c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comp_stat_src", "12");
      NativeAdUtils.a(new AdReportData().a(getActivity()).a(2).b(32).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(Integer.valueOf(2)).b(true).e(localJSONObject).a(true));
      NativeAdUtils.a(new AdReportData().a(getActivity()).a(2).b(32).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo).a(Integer.valueOf(1)).b(false).e(localJSONObject).a(true));
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      a(101);
      continue;
      a(102);
      continue;
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewView = VideoFeedsResourceLoader.a(2131560179, true, new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidContentContext = paramViewGroup.getContext();
    b();
    VideoFeedsHelper.b(getActivity());
    getActivity().getWindow().setFlags(1024, 1024);
    LiuHaiUtils.a(getActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getActivity());
    }
    if (LiuHaiUtils.b())
    {
      int i = LiuHaiUtils.b(getActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
      paramLayoutInflater.topMargin += i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageButton.getLayoutParams();
      paramLayoutInflater.topMargin = (i + paramLayoutInflater.topMargin);
      this.jdField_a_of_type_AndroidWidgetImageButton.setLayoutParams(paramLayoutInflater);
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    ReadinjoyAdCache.a(1);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    VideoFeedsHelper.b(getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment
 * JD-Core Version:    0.7.0.1
 */