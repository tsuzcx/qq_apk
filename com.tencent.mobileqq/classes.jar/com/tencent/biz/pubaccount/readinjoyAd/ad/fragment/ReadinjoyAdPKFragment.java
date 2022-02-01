package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdJumpParams;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdPKImageData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadinjoyAdCache;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsResourceLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
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
  private Context a;
  private AdvertisementInfo b;
  private View c;
  private KandianUrlImageView d;
  private ReadInJoyHeadImageView e;
  private TextView f;
  private TextView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  private TextView j;
  private TextView k;
  private Handler l = new Handler(Looper.getMainLooper());
  private Bitmap m;
  private ImageButton n;
  private Runnable o = new ReadinjoyAdPKFragment.1(this);
  
  private void a()
  {
    AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)getArguments().getParcelable("param_ad_info");
    if (localAdvertisementInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyAdPKFragment", 2, "PARAM_AD_INFO: null");
      }
      getBaseActivity().finish();
      return;
    }
    localAdvertisementInfo.resetClickPos();
    this.b = localAdvertisementInfo;
  }
  
  private void a(int paramInt)
  {
    AdJumpParams localAdJumpParams = new AdJumpParams();
    localAdJumpParams.b = true;
    this.b.clickPos = paramInt;
    Object localObject1 = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
    Object localObject2 = this.a;
    AdvertisementInfo localAdvertisementInfo = this.b;
    localObject1 = (GdtHandler.Params)((IRIJAdActionUtilService)localObject1).getAdInfoParams((Context)localObject2, localAdvertisementInfo, null, (int)localAdvertisementInfo.mChannelID, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt), localAdJumpParams);
    localObject2 = ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).jumpToGdtAdPage(localObject1, getBaseActivity(), this.b);
    localObject1 = localObject2;
    if (((Integer)localObject2).intValue() == -1)
    {
      localObject1 = localObject2;
      if (this.b.mAdvertisementExtInfo != null)
      {
        localObject1 = localObject2;
        if (this.b.mAdvertisementExtInfo.o != 32)
        {
          this.b.isClickFromPkFragment = true;
          localObject1 = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
          localObject2 = (Activity)this.a;
          localAdvertisementInfo = this.b;
          localObject1 = ((IRIJAdActionUtilService)localObject1).doActionAndReport((Activity)localObject2, localAdvertisementInfo, null, (int)localAdvertisementInfo.mChannelID, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isClickBtn(paramInt), false, localAdJumpParams);
          this.b.isClickFromPkFragment = false;
        }
      }
    }
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("comp_stat_src", "12");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getBaseActivity()).a(1).b(32).b((Integer)localObject1).a(this.b).e((JSONObject)localObject2).c(paramInt).a(true));
  }
  
  public static void a(Activity paramActivity, Class<? extends ReadinjoyAdPKFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtras(paramBundle);
      PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
      paramActivity.overridePendingTransition(0, 0);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdPKFragment", 2, "error");
    }
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView, String paramString, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = getBaseActivity().getWindowManager().getDefaultDisplay().getWidth();
    localURLDrawableOptions.mRequestHeight = paramKandianUrlImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(0);
    try
    {
      paramString = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
      if (paramBoolean) {
        paramString.setDecodeHandler(URLDrawableDecodeHandler.b);
      }
      paramKandianUrlImageView.setImageDrawable(paramString);
      return;
    }
    catch (MalformedURLException paramKandianUrlImageView)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("loadImage ERROR e = ");
        paramString.append(paramKandianUrlImageView.getMessage());
        QLog.d("ReadinjoyAdPKFragment", 2, paramString.toString());
      }
    }
  }
  
  private void b()
  {
    this.d = ((KandianUrlImageView)this.c.findViewById(2131427754));
    this.e = ((ReadInJoyHeadImageView)this.c.findViewById(2131427712));
    this.f = ((TextView)this.c.findViewById(2131427714));
    this.g = ((TextView)this.c.findViewById(2131448814));
    this.h = ((KandianUrlImageView)this.c.findViewById(2131435453));
    this.i = ((KandianUrlImageView)this.c.findViewById(2131435471));
    this.j = ((TextView)this.c.findViewById(2131448556));
    this.k = ((TextView)this.c.findViewById(2131448715));
    this.n = ((ImageButton)this.c.findViewById(2131438109));
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.c.findViewById(2131438109).setOnClickListener(this);
    if (TextUtils.isEmpty(this.b.mFirstPagePicUrl))
    {
      localObject = this.b;
      ((AdvertisementInfo)localObject).mFirstPagePicUrl = ((AdvertisementInfo)localObject).mAdImg;
    }
    URL localURL = this.b.getVideoCoverUrlWithSmartCut(false);
    if (localURL != null) {
      localObject = localURL.getFile();
    } else {
      localObject = null;
    }
    if (localURL != null) {
      a(this.d, (String)localObject, false);
    } else {
      this.d.setVisibility(4);
    }
    ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).configImage(this.d, localURL, this.a, true);
    if (!TextUtils.isEmpty(this.b.mAdCorporateImageName)) {
      this.f.setText(this.b.mAdCorporateImageName);
    }
    a(this.e, this.b.mAdCorporateLogo, true);
    if (!TextUtils.isEmpty(this.b.mTitle)) {
      this.g.setText(this.b.mTitle);
    }
    if ((this.b.mAdvertisementExtInfo != null) && (this.b.mAdvertisementExtInfo.m.size() >= 2))
    {
      localObject = (AdPKImageData)this.b.mAdvertisementExtInfo.m.get(0);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((AdPKImageData)localObject).c)) {
          this.j.setText(((AdPKImageData)localObject).c);
        }
        if (!TextUtils.isEmpty(((AdPKImageData)localObject).d)) {
          a(this.h, ((AdPKImageData)localObject).d, false);
        }
      }
      localObject = (AdPKImageData)this.b.mAdvertisementExtInfo.m.get(1);
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(((AdPKImageData)localObject).c)) {
          this.k.setText(((AdPKImageData)localObject).c);
        }
        if (!TextUtils.isEmpty(((AdPKImageData)localObject).d)) {
          a(this.i, ((AdPKImageData)localObject).d, false);
        }
      }
    }
    Object localObject = ReadinjoyAdCache.b(1);
    if ((localObject instanceof Bitmap)) {
      this.m = ((Bitmap)localObject);
    }
    ThreadManager.getSubThreadHandler().post(this.o);
    c();
  }
  
  private void c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("comp_stat_src", "12");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getBaseActivity()).a(2).b(32).a(this.b).a(Integer.valueOf(2)).b(true).e(localJSONObject).a(true));
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(getBaseActivity()).a(2).b(32).a(this.b).a(Integer.valueOf(1)).b(false).e(localJSONObject).a(true));
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131438109)
    {
      if (i1 != 2131448556)
      {
        if (i1 != 2131448715) {
          return;
        }
        a(102);
        return;
      }
      a(101);
      return;
    }
    getBaseActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = ((IVideoFeedsResourceLoader)QRoute.api(IVideoFeedsResourceLoader.class)).inflate(2131626113, true, new ViewGroup.LayoutParams(-1, -1));
    this.a = paramViewGroup.getContext();
    b();
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getBaseActivity());
    getBaseActivity().getWindow().setFlags(1024, 1024);
    LiuHaiUtils.f(getBaseActivity());
    if (LiuHaiUtils.b()) {
      LiuHaiUtils.enableNotch(getBaseActivity());
    }
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.e(getBaseActivity());
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
      paramLayoutInflater.topMargin += i1;
      this.d.setLayoutParams(paramLayoutInflater);
      paramLayoutInflater = (RelativeLayout.LayoutParams)this.n.getLayoutParams();
      paramLayoutInflater.topMargin += i1;
      this.n.setLayoutParams(paramLayoutInflater);
    }
    return this.c;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.l.removeCallbacksAndMessages(null);
    if (this.o != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.o);
    }
    ReadinjoyAdCache.a(1);
    Bitmap localBitmap = this.m;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.m = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).hideBottomUIMenuImmersived(getBaseActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment
 * JD-Core Version:    0.7.0.1
 */