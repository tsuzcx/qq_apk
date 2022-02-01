package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyAdVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.CircleCountdownView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoFeedsGuideManager
  implements Handler.Callback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ADVideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  private ArrayList<ADVideoFeedsGuideManager.ProgressStateListener> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public ADVideoFeedsGuideManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private int a(VideoInfo paramVideoInfo)
  {
    int i = 2;
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      if (VideoFeedsHardAdBarManager.a(paramVideoInfo.a)) {
        return 4;
      }
      if (paramVideoInfo.a.c != 12) {
        return 1;
      }
      try
      {
        paramVideoInfo = new JSONObject(paramVideoInfo.a.r);
        boolean bool = PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, paramVideoInfo.optString("pkg_name"));
        if (bool) {
          return 3;
        }
      }
      catch (JSONException paramVideoInfo) {}
    }
    return 2;
  }
  
  private boolean b(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    return (paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null);
  }
  
  private void g()
  {
    Resources localResources;
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f != null))
    {
      localResources = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.getResources();
      localObject1 = "";
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
        break label327;
      }
      localObject2 = localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a != null)
      {
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l)) {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.l;
        }
      }
      switch (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo))
      {
      default: 
        localObject1 = localObject2;
        i = 2130843297;
        if (localResources.getText(2131718252).toString().equals(localObject1)) {
          i = 2130843296;
        }
        break;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.setText((CharSequence)localObject1);
      int j = AIOUtils.a(12.0F, localResources);
      localObject1 = localResources.getDrawable(i);
      ((Drawable)localObject1).setBounds(0, 0, j, j);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.f.setCompoundDrawables((Drawable)localObject1, null, null, null);
      return;
      localObject1 = localResources.getText(2131718255).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718252).toString();
      break;
      localObject1 = localResources.getText(2131718253).toString();
      break;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject1 = localResources.getText(2131718304).toString();
      break;
      label327:
      localObject1 = localResources.getText(2131718304).toString();
      break;
      if (localResources.getText(2131718253).toString().equals(localObject1)) {
        i = 2130843299;
      }
    }
  }
  
  public ADVideoItemHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = null;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a("continue_pause", false);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = false;
    }
    if ((paramVideoItemHolder instanceof ADVideoItemHolder))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = ((ADVideoItemHolder)paramVideoItemHolder);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder = null;
  }
  
  public void a(ADVideoFeedsGuideManager.ProgressStateListener paramProgressStateListener)
  {
    if ((paramProgressStateListener != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramProgressStateListener))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramProgressStateListener);
    }
  }
  
  public boolean a()
  {
    if ((!this.b) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.getVisibility() == 0))
    {
      if (this.c)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a("continue_pause", false);
        this.c = false;
        return true;
      }
      g();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
    this.c = false;
    return false;
  }
  
  public boolean a(VideoFeedsPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    if ((paramVideoPlayParam == null) || (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (!this.jdField_a_of_type_Boolean) && (ReadInJoyAdSwitchUtil.b(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a)))) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder == null) || (this.jdField_a_of_type_Boolean) || (!ReadInJoyAdSwitchUtil.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a))) {
      return false;
    }
    ReadinjoyAdVideoReportData localReadinjoyAdVideoReportData;
    boolean bool;
    label163:
    AdvertisementInfo localAdvertisementInfo;
    int m;
    int n;
    int i;
    label243:
    int j;
    label253:
    int i1;
    if ((b(paramVideoPlayParam)) && (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper != null) && (!paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Boolean))
    {
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e() != 0L) {
        break label511;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.e = ((int)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.c(true));
      localReadinjoyAdVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int != 0) {
        break label529;
      }
      bool = true;
      localReadinjoyAdVideoReportData.b = bool;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.h = ((int)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.b());
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.c = true;
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Boolean = true;
      localReadinjoyAdVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData;
      localAdvertisementInfo = NativeAdUtils.a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a);
      m = localReadinjoyAdVideoReportData.jdField_d_of_type_Int;
      n = localReadinjoyAdVideoReportData.e;
      if (!localReadinjoyAdVideoReportData.b) {
        break label535;
      }
      i = 1;
      if (!localReadinjoyAdVideoReportData.c) {
        break label540;
      }
      j = 1;
      i1 = localReadinjoyAdVideoReportData.f;
      if (!localReadinjoyAdVideoReportData.jdField_a_of_type_Boolean) {
        break label545;
      }
    }
    label529:
    label535:
    label540:
    label545:
    for (int k = 1;; k = 2)
    {
      JSONObject localJSONObject = NativeAdUtils.a(m, n, i, j, i1, k, localReadinjoyAdVideoReportData.h, 2, 0, localReadinjoyAdVideoReportData.i, ReportConstants.VideoEndType.NORMAL_COMPLETE, true);
      NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidContentContext).a(6).b(localReadinjoyAdVideoReportData.g).a(localAdvertisementInfo).a(paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a).a(localJSONObject));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a();
      }
      g();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a("continue_pause", true);
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.e != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.e.setVisibility(8);
        }
        paramVideoPlayParam = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d, "alpha", new float[] { 0.0F, 1.0F });
        paramVideoPlayParam.setDuration(200L);
        paramVideoPlayParam.setInterpolator(new DecelerateInterpolator());
        paramVideoPlayParam.addListener(new ADVideoFeedsGuideManager.1(this));
        paramVideoPlayParam.start();
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
      return true;
      label511:
      paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyAdVideoReportData.jdField_d_of_type_Int = ((int)paramVideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper.e());
      break;
      bool = false;
      break label163;
      i = 0;
      break label243;
      j = 0;
      break label253;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.b = true;
    b();
  }
  
  public void d()
  {
    this.b = false;
    a();
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a("continue_pause", false);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentBizPubaccountVideoInfo) != 3)) {
      this.c = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView != null))
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCircleCountdownView.a(20)) {
        break label154;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.d.setVisibility(8);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsADVideoItemHolder.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$VideoPlayParam.a("continue_pause", false);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        paramMessage = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (paramMessage.hasNext()) {
          ((ADVideoFeedsGuideManager.ProgressStateListener)paramMessage.next()).a();
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return true;
      label154:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 20L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager
 * JD-Core Version:    0.7.0.1
 */