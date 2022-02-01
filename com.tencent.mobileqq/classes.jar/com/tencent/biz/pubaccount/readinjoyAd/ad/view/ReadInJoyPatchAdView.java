package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyPatchAdView
  extends FrameLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdvertisementInfo a;
  public ReadInJoyPatchAdView.PatchAdListener a;
  private KanDianUrlRoundCornerImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    f();
    g();
  }
  
  private int a()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam == null) {
      return 0;
    }
    return localVideoPlayParam.a.patchStatus.a.get();
  }
  
  private int b()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
    if (localVideoPlayParam == null) {
      return 0;
    }
    return localVideoPlayParam.a.patchStatus.b.get();
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if ((localObject1 != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener != null)) {
      try
      {
        localObject1 = new JSONObject(((AdvertisementInfo)localObject1).mAdExtInfo);
        if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAdDisplaySeconds((JSONObject)localObject1) == paramInt)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1203, 1000L);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("秒");
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    if (paramInt >= 1)
    {
      localObject2 = new Message();
      ((Message)localObject2).what = 1201;
      ((Message)localObject2).obj = Integer.valueOf(paramInt - 1);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject2, 1000L);
    }
    if (paramInt < 1) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1202);
    }
  }
  
  private void e()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131560065, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)localView.findViewById(2131368499));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377508));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131362124));
    this.b = ((TextView)localView.findViewById(2131362282));
    this.c = ((TextView)localView.findViewById(2131362169));
    this.d = ((TextView)localView.findViewById(2131372361));
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidOsHandler = new ReadInJoyPatchAdView.1(this, Looper.getMainLooper());
  }
  
  private void h()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setText("0秒");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener != null)
    {
      a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeMessages(1201);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1202);
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener;
    if (localPatchAdListener != null)
    {
      localPatchAdListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, 1);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam = paramVideoPlayParam;
    this.c.setText(paramAdvertisementInfo.mTitle);
    this.b.setText(paramAdvertisementInfo.mAdTxt);
    this.d.setText(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getPatchAdButtonText(getContext(), paramAdvertisementInfo));
    try
    {
      paramVideoPlayParam = new URL(paramAdvertisementInfo.mAdImg);
      URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
      ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).configImage(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, paramVideoPlayParam, getContext(), false);
      ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).configImage(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView, localURL, getContext(), false);
    }
    catch (Exception paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKanDianUrlRoundCornerImageView.setCorner(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(2.0F, getContext().getResources()));
    try
    {
      paramVideoPlayParam = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramInt = ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAdDisplaySeconds(paramVideoPlayParam);
      if (paramInt < 0)
      {
        a();
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        paramVideoPlayParam = new Message();
        paramVideoPlayParam.what = 1201;
        paramVideoPlayParam.obj = Integer.valueOf(paramInt);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramVideoPlayParam);
        return;
      }
    }
    catch (JSONException paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
    }
  }
  
  public boolean a()
  {
    int i = a();
    boolean bool = true;
    if (i != 1)
    {
      if (b() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener;
    if (localPatchAdListener != null) {
      localPatchAdListener.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener;
    if (localPatchAdListener != null) {
      localPatchAdListener.d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int);
    }
  }
  
  public void d()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener;
    if (localPatchAdListener != null) {
      localPatchAdListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, 0);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = paramView.getId();
    int i = 5;
    if (j == 2131362124) {
      i = 2;
    } else if (j == 2131362169) {
      i = 3;
    } else if ((j != 2131368499) && (j == 2131372361)) {
      i = 8;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener != null)
    {
      a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoFeedsEntityVideoPlayParam, this.jdField_a_of_type_Int, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnPatchAdListener(ReadInJoyPatchAdView.PatchAdListener paramPatchAdListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewReadInJoyPatchAdView$PatchAdListener = paramPatchAdListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */