package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.OnClickCloseListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarDelegateBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJLiujinAdJumpService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.widget.AbsReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class VideoFeedsSoftAdBarDelegateForAd
  implements View.OnClickListener, VideoFeedsSoftAdBarDelegateBase
{
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoFeedsSoftAdBarDelegateForAd.3(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private OnClickCloseListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOnClickCloseListener;
  private VideoFeedsGameAdComBarConfigure jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure;
  private VideoFeedsSoftAdTest jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private HashMap<String, ADVideoAppDownloadData> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private Set<String> jdField_b_of_type_JavaUtilSet;
  public boolean b;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private Set<String> jdField_c_of_type_JavaUtilSet;
  private boolean jdField_c_of_type_Boolean = false;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean = false;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean = false;
  private TextView h;
  
  public VideoFeedsSoftAdBarDelegateForAd()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private Integer a()
  {
    AdvertisementInfo localAdvertisementInfo = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    Integer localInteger = Integer.valueOf(-1);
    if (localAdvertisementInfo == null)
    {
      QLog.e("VideoFeedsSoftAdBarDelegateForAd", 1, "videoSoftAd jump error, advertisementInfo is null");
      return localInteger;
    }
    if (((IRIJLiujinAdJumpService)QRoute.api(IRIJLiujinAdJumpService.class)).isFromLiuJin(localAdvertisementInfo)) {
      localInteger = ((IRIJLiujinAdJumpService)QRoute.api(IRIJLiujinAdJumpService.class)).doJumpAction(localAdvertisementInfo, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (localInteger.intValue() != -1) {
      return localInteger;
    }
    return ReadInJoyAdJumpUtils.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo), this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, AdClickPos paramAdClickPos, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, false, paramAdClickPos, paramBoolean);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) == null) {
        return;
      }
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).setClickPos(paramInt2);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).setAdClickPos(paramAdClickPos);
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null) {
        ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_d_of_type_Boolean = this.jdField_d_of_type_Boolean;
      }
      ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo), 35, paramInt1, 5, paramBoolean1, paramBoolean2);
    }
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, paramBoolean1, null, paramBoolean2);
  }
  
  private void a(TextView paramTextView)
  {
    String str = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.I;
    if (!TextUtils.isEmpty(str))
    {
      paramTextView.setVisibility(0);
      paramTextView.setText(str);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    boolean bool = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isVideoFeedsTiktokStyle();
    int j = 0;
    Object localObject;
    int i;
    if ((!bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.j != null))
    {
      localObject = paramVideoItemHolder.j;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((ViewGroup)localObject).setVisibility(i);
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.v != null))
    {
      localObject = paramVideoItemHolder.v;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((TextView)localObject).setVisibility(i);
    }
    if ((bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.C != null) && (paramVideoItemHolder.C.findViewById(2131368101) != null))
    {
      localObject = paramVideoItemHolder.C.findViewById(2131368101);
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      ((View)localObject).setVisibility(i);
    }
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.a != null))
    {
      localObject = paramVideoItemHolder.a;
      if (paramBoolean) {
        i = j;
      } else {
        i = 8;
      }
      ((AbsReadInJoyNickNameTextView)localObject).setVisibility(i);
    }
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).setFollowTextVisibility(paramVideoItemHolder, paramBoolean);
  }
  
  private void a(boolean paramBoolean)
  {
    ReportAction localReportAction = ReportAction.EXPOSE;
    Integer localInteger = Integer.valueOf(0);
    a(2, 0, localReportAction, localInteger, true, paramBoolean);
    a(2, 0, ReportAction.EXPOSE, localInteger, false, paramBoolean);
    if (!paramBoolean)
    {
      b(false);
      return;
    }
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null)
    {
      if (paramAdvertisementInfo.mAdvertisementSoftInfo == null) {
        return false;
      }
      if ((paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.H)) && (paramAdvertisementInfo.mAdvertisementSoftInfo.H.equals("1"))) {
        return true;
      }
      if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.D)) {
        return !TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.C);
      }
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d1 = paramLong / 1000L;
    Double.isNaN(d1);
    d1 = d1 * paramDouble / 100.0D;
    if (this.jdField_f_of_type_Boolean)
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.z))
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.z.equals("1")) {
          return paramDouble > Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.A).intValue();
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.z.equals("2"))
        {
          int i = Integer.valueOf(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.B).intValue();
          return (d1 != 0.0D) && (d1 > i);
        }
      }
      return false;
    }
    return paramDouble > this.jdField_a_of_type_Int;
  }
  
  private int b()
  {
    if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
      return VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
      return VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo)) {
      return AIOUtils.b(220.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    return AIOUtils.b(220.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  private CharSequence b()
  {
    boolean bool = TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l);
    Object localObject1 = "";
    if (bool)
    {
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k;
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k);
    String str1 = ((StringBuilder)localObject2).toString();
    if (!TextUtils.isEmpty(str1.trim()))
    {
      localObject2 = new SpannableStringBuilder(str1);
      bool = TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l);
      float f1 = 13.0F;
      int i;
      int j;
      if (!bool)
      {
        localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l;
        if (str1.contains((CharSequence)localObject1))
        {
          i = str1.indexOf((String)localObject1);
          j = ((String)localObject1).length() + i;
          ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(AIOUtils.b(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          ((SpannableStringBuilder)localObject2).setSpan(new VideoFeedsSoftAdBarDelegateForAd.MarginSpan(AIOUtils.b(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(str2))
      {
        localObject1 = localObject2;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          if (!b()) {
            ((SpannableStringBuilder)localObject2).setSpan(new StrikethroughSpan(), i, j, 33);
          } else {
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
          }
          ((SpannableStringBuilder)localObject2).setSpan(new StrikethroughSpan(), i, j, 33);
          if (!b()) {
            f1 = 11.0F;
          }
          ((SpannableStringBuilder)localObject2).setSpan(new AbsoluteSizeSpan(AIOUtils.b(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (paramBoolean)
      {
        NativeAdUtils.b(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.Z);
        return;
      }
      NativeAdUtils.b(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.Y);
    }
  }
  
  private int c()
  {
    if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
      return VideoFeedsSoftAdAms65.b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
      return VideoFeedsSoftAdAms184.b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo)) {
      return AIOUtils.b(178.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    return AIOUtils.b(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      this.jdField_a_of_type_Int = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_b_of_type_Int;
      this.jdField_f_of_type_Boolean = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.y.equals("1");
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_c_of_type_Boolean = this.jdField_f_of_type_Boolean;
      this.jdField_g_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest != null) {
      VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
  }
  
  private String d()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.F)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.F;
      }
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdCorporateLogo;
      }
      return a();
    }
    return null;
  }
  
  private String e()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.G)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.G;
      }
      return b();
    }
    return "";
  }
  
  private void g(VideoItemHolder paramVideoItemHolder)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo == null) {
        return;
      }
      if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
      {
        k(paramVideoItemHolder);
        return;
      }
      if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
      {
        l(paramVideoItemHolder);
        return;
      }
      if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo);
        return;
      }
      j(paramVideoItemHolder);
    }
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo == null) {
        return;
      }
      i();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362044));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362052));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362058));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362054));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362048));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362056));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362051));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362042));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362040));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362046);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362275));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362053));
      if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(this.jdField_a_of_type_AndroidViewView);
      }
      Object localObject;
      ViewGroup.LayoutParams localLayoutParams1;
      if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
      {
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362277));
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370791));
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        ((ViewGroup.LayoutParams)localObject).height = VideoFeedsSoftAdAms65.b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        localLayoutParams1 = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        localLayoutParams1.width = VideoFeedsSoftAdAms65.c(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        localLayoutParams1.height = VideoFeedsSoftAdAms65.d(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
      {
        this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362276));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370790));
        localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).width = VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        ((ViewGroup.LayoutParams)localObject).height = VideoFeedsSoftAdAms184.b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        localLayoutParams1 = this.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
        localLayoutParams1.width = VideoFeedsSoftAdAms184.c(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        localLayoutParams1.height = VideoFeedsSoftAdAms184.d(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        ViewGroup.LayoutParams localLayoutParams2 = this.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        localLayoutParams2.width = VideoFeedsSoftAdAms184.c(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams2);
        this.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(localLayoutParams1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362107));
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(19.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FF12B7F5"));
        this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      }
    }
  }
  
  private void h(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    String str1 = d();
    String str2 = e();
    paramVideoItemHolder.O.setText(str2);
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.i, str1, AIOUtils.b(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 22, 22, -1, this.jdField_a_of_type_AndroidAppActivity);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
    paramVideoItemHolder.w.setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setOnClickListener(this);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.z == null)
      {
        localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131380748);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.z = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.z;
      return;
    }
    if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.A == null)
      {
        localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131380747);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.A = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.A;
      return;
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.B == null)
      {
        localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131380751);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.B = ((ViewGroup)((ViewStub)localObject).inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.B;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_y_of_type_AndroidViewView == null)
    {
      localObject = (ViewStub)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131380749);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_y_of_type_AndroidViewView = ((ViewGroup)((ViewStub)localObject).inflate());
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_y_of_type_AndroidViewView;
  }
  
  private void i(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    String str = a();
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.h, str, AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 40, 40, -1, this.jdField_a_of_type_AndroidAppActivity);
    str = b();
    CharSequence localCharSequence = a();
    if ((paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null))
    {
      IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAdvertisementInfo: videoTitle = ");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.c);
      localIRIJAdLogService.d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setAdvertisementInfo(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo));
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setDownloadScene(AdDownloadScene.SoftButton);
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setActivity(new SoftReference(this.jdField_a_of_type_AndroidAppActivity));
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setProgressStyle(RoundProgressStyle.VideoSoftAd);
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setOnClickListener(this);
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).a(true);
    }
    paramVideoItemHolder.L.setText(str);
    paramVideoItemHolder.M.setText(localCharSequence);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
    paramVideoItemHolder.o.setTag(paramVideoItemHolder);
    paramVideoItemHolder.o.setOnClickListener(this);
    ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setOnClickListener(this);
  }
  
  @RequiresApi(api=16)
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return;
    }
    GradientDrawable localGradientDrawable;
    float f1;
    if (VideoFeedsSoftAdAms65.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
    {
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      localGradientDrawable = new GradientDrawable();
      if (VideoFeedsSoftAdAms65.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo) == 2)
      {
        localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      }
      else if (VideoFeedsSoftAdAms65.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo) == 0)
      {
        localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
      }
      f1 = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f1, f1, f1 });
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      if (this.jdField_d_of_type_AndroidWidgetRelativeLayout != null)
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
        localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      }
      return;
    }
    if (VideoFeedsSoftAdAms184.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))
    {
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      if (this.jdField_e_of_type_AndroidWidgetRelativeLayout != null)
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
        f1 = AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localGradientDrawable.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      }
      return;
    }
    if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a();
      return;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.C != null)) {}
    try
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.C.equals("white"))
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#FFFFFFFF"));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
      }
      else
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(AIOUtils.b(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable.setColor(Color.parseColor("#7F292A2F"));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
        if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
        }
      }
      int i = AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      f1 = i;
      localGradientDrawable.setCornerRadii(new float[] { 0.0F, 0.0F, f1, f1, 0.0F, 0.0F, f1, f1 });
      localGradientDrawable.setColor(Color.parseColor("#33000000"));
      this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label835:
      break label835;
    }
    QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "smallCardShowTime Format error");
  }
  
  private void j(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = a();
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, a(), AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 65, 65, -1, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(c());
    a(this.jdField_f_of_type_AndroidWidgetTextView);
    if ((paramVideoItemHolder.c != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null))
    {
      localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setAdvertisementInfo: videoTitle = ");
      localStringBuilder.append(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.c);
      ((IRIJAdLogService)localObject).d("AD_DOWNLOAD_TAG", localStringBuilder.toString());
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdBtnTxt = c();
      ((RIJDownloadView)paramVideoItemHolder.c).setAdvertisementInfo(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo));
      ((RIJDownloadView)paramVideoItemHolder.c).setDownloadScene(AdDownloadScene.SoftButton);
      ((RIJDownloadView)paramVideoItemHolder.c).setActivity(new SoftReference(this.jdField_a_of_type_AndroidAppActivity));
      ((RIJDownloadView)paramVideoItemHolder.c).setProgressStyle(HorizontalProgressStyle.VideoCardStyleTikTok);
      ((RIJDownloadView)paramVideoItemHolder.c).setOnClickListener(this);
      ((RIJDownloadView)paramVideoItemHolder.c).a(true);
      ((RIJDownloadView)paramVideoItemHolder.c).setTag(paramVideoItemHolder);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setTag(paramVideoItemHolder);
    if (a() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l)) && (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k)))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l)) && (TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k)))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramVideoItemHolder.c != null) {
        ((RIJDownloadView)paramVideoItemHolder.c).setVisibility(8);
      }
    }
    else if (a() == 2)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramVideoItemHolder.c != null) {
        ((RIJDownloadView)paramVideoItemHolder.c).setVisibility(8);
      }
    }
    else if (a() == 1)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      if (paramVideoItemHolder.c != null) {
        ((RIJDownloadView)paramVideoItemHolder.c).setVisibility(0);
      }
    }
  }
  
  private void k()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (localObject != null)
    {
      localObject = ((VideoInfo)localObject).a;
      if (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a);
        ((StringBuilder)localObject).append("_B");
        localObject = ((StringBuilder)localObject).toString();
      }
      Set localSet = this.jdField_c_of_type_JavaUtilSet;
      if ((localSet != null) && (!localSet.contains(localObject)))
      {
        this.jdField_c_of_type_JavaUtilSet.add(localObject);
        if (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(true);
          return;
        }
        a(true);
      }
    }
  }
  
  private void k(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdImg, AIOUtils.b(20.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), VideoFeedsSoftAdAms65.c(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity), VideoFeedsSoftAdAms65.d(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity), 0, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
    a(this.jdField_g_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
  }
  
  private void l(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdImg, AIOUtils.b(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), VideoFeedsSoftAdAms184.c(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity), VideoFeedsSoftAdAms184.d(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_AndroidAppActivity), -1, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
    a(this.h);
    CharSequence localCharSequence = a();
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localCharSequence);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
  }
  
  public int a()
  {
    if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdProductType != 12)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) {
        return 1;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int;
    }
    return 1;
  }
  
  public CharSequence a()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      Object localObject2;
      Object localObject1;
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int != 1) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdProductType != 12))
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
        {
          localObject2 = b();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = "不容错过的热门商品";
          }
          return localObject1;
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int == 2)
        {
          if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {
            localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
          } else {
            localObject1 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdDesc;
          }
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = "点击查看详情";
          }
          return localObject2;
        }
      }
      else
      {
        localObject2 = ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "不容错过的热门应用";
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdProductType == 12) {
          return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdCorporateLogo;
        }
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdImg;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public void a(double paramDouble)
  {
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_b_of_type_JavaUtilSet = new HashSet();
    this.jdField_c_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure = new VideoFeedsGameAdComBarConfigure(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest = new VideoFeedsSoftAdTest(paramActivity, this);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    c(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
    if (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null) {
      paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(2131380884, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo);
    }
    f(paramVideoItemHolder);
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.a))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.a);
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (!((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).isKolSoftAd())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.a();
      }
      SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)) {
        SoftAdExpoStatManager.a().a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.T);
      }
      a(false);
    }
  }
  
  @RequiresApi(api=16)
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    h();
    j();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.width = b();
    localLayoutParams.height = c();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    int i;
    int j;
    if ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.getVisibility() == 0))
    {
      this.jdField_b_of_type_Boolean = true;
      g(paramVideoItemHolder);
      localLayoutParams = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      i = paramVideoItemHolder.w.getWidth();
      localLayoutParams.width = i;
      localLayoutParams.height = 1;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(600L);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      j = b();
      int k = c();
      paramVideoItemHolder.e.setVisibility(8);
      a(paramVideoItemHolder, false);
      localValueAnimator.addUpdateListener(new VideoFeedsSoftAdBarDelegateForAd.1(this, j, i, localLayoutParams, k));
      localValueAnimator.addListener(new VideoFeedsSoftAdBarDelegateForAd.2(this, paramVideoItemHolder));
      localValueAnimator.start();
      i = 10;
    }
    try
    {
      j = Integer.parseInt(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.E);
      i = j;
    }
    catch (Exception paramVideoItemHolder)
    {
      label257:
      break label257;
    }
    QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "big_card_show_time Format error");
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i * 1000);
    k();
  }
  
  public boolean a()
  {
    boolean bool;
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mSoftAdType == 2)) {
      bool = true;
    } else {
      bool = false;
    }
    if ((bool) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int == 2))
    {
      String str1 = b();
      String str2 = a();
      return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {
      return true;
    }
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.a)) {
      return true;
    }
    if (ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure)) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.a) ^ true;
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.getVisibility() == 0) && (!this.jdField_g_of_type_Boolean) && (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo))))
    {
      if (QLog.isColorLevel())
      {
        paramVideoItemHolder = new StringBuilder();
        paramVideoItemHolder.append("进度判断 video_percent=");
        paramVideoItemHolder.append(paramDouble);
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, paramVideoItemHolder.toString());
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  public String b()
  {
    if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdProductType == 12) {
          return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdCorporateImageName;
        }
        if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
        {
          if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdDesc)) {
            return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdDesc;
          }
          return HardCodeUtil.a(2131715905);
        }
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdTxt;
      }
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
    }
    return "";
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.w.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      VideoFeedsSoftAdTest localVideoFeedsSoftAdTest = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest;
      if (localVideoFeedsSoftAdTest != null) {
        localVideoFeedsSoftAdTest.c();
      }
    }
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)))
    {
      paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131380594)).inflate()).findViewById(2131380746)).inflate());
      paramVideoItemHolder.w = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380600));
      paramVideoItemHolder.e = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380602));
      paramVideoItemHolder.i = ((URLImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368043));
      paramVideoItemHolder.O = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362059));
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131380603));
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoItemHolder.h = ((URLImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368146));
      paramVideoItemHolder.L = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362060));
      paramVideoItemHolder.M = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362057));
      paramVideoItemHolder.N = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362055));
      paramVideoItemHolder.o = ((ImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362045));
      paramVideoItemHolder.jdField_x_of_type_AndroidViewViewGroup = ((ViewGroup)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362050));
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362109));
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setVisibility(8);
    }
    d(paramVideoItemHolder);
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String c()
  {
    VideoInfo localVideoInfo = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    String str = "立即查看";
    if ((localVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.M)) {
        return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.M;
      }
    }
    else
    {
      if (a() == 0) {
        return "立刻购买";
      }
      if (a() == 2) {
        return "立即查看";
      }
      if (a() == 1) {
        str = "立即下载";
      }
    }
    return str;
  }
  
  public void c()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.c != null)) {
      ((RIJDownloadView)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c).a();
    }
    localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout != null)) {
      ((RIJDownloadView)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).a();
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null)
    {
      if (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)))
      {
        h(paramVideoItemHolder);
        return;
      }
      i(paramVideoItemHolder);
    }
  }
  
  public void d()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.c != null)) {
      ((RIJDownloadView)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.c).b();
    }
    localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout != null)) {
      ((RIJDownloadView)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).b();
    }
  }
  
  public void d(VideoItemHolder paramVideoItemHolder)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramVideoItemHolder.w.getLayoutParams();
    paramVideoItemHolder.w.setVisibility(0);
    if (a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)))
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
      paramVideoItemHolder.w.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.w.setLayoutParams(localLayoutParams);
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoItemHolder.e.setVisibility(0);
      localLayoutParams.height = AIOUtils.b(27.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = -2;
      return;
    }
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramVideoItemHolder.e.setVisibility(8);
    localLayoutParams.height = AIOUtils.b(48.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams.width = AIOUtils.b(250.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    e(paramVideoItemHolder);
  }
  
  public void e()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void e(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = (LinearLayout.LayoutParams)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.b(250.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localGradientDrawable);
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramVideoItemHolder.h.setVisibility(0);
    if (a() == 0)
    {
      if ((!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l)) && (!TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k)))
      {
        paramVideoItemHolder.N.setVisibility(8);
      }
      else if ((TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.l)) && (TextUtils.isEmpty(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.k)))
      {
        paramVideoItemHolder.N.setVisibility(8);
      }
      else
      {
        localObject = new GradientDrawable();
        ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
        paramVideoItemHolder.N.setVisibility(0);
        paramVideoItemHolder.N.setBackgroundDrawable((Drawable)localObject);
      }
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setVisibility(8);
      return;
    }
    if (a() == 2)
    {
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setVisibility(8);
      return;
    }
    if (a() == 1) {
      ((RIJDownloadView)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).setVisibility(0);
    }
  }
  
  public void f()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void f(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.w.setVisibility(0);
  }
  
  public void g()
  {
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, true);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.e.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramView.getTag();
    if (localVideoItemHolder == null) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    if (paramView.getId() != 2131362044) {
      b(true);
    }
    switch (paramView.getId())
    {
    default: 
    case 2131380600: 
      if ((this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null) && (VideoFeedsSoftAdTest.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo)))
      {
        a(localVideoItemHolder);
        a(1, 2, ReportAction.CLICK, Integer.valueOf(0), AdClickPos.SoftAdComponent, false);
        return;
      }
      paramView = a();
      a(1, 2, ReportAction.CLICK, paramView, AdClickPos.SoftAdComponent, false);
      return;
    case 2131362109: 
      if ((a() == 1) && (localVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
      {
        if (RIJAdDownloadUtil.a.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.o))
        {
          ((RIJDownloadView)localVideoItemHolder.jdField_d_of_type_AndroidWidgetFrameLayout).a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        paramView = a();
        a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, false);
        return;
      }
      break;
    case 2131362051: 
      paramView = a();
      a(1, 0, ReportAction.CLICK, paramView, AdClickPos.SoftAdComponent, true);
      return;
    case 2131362045: 
      this.jdField_a_of_type_Boolean = true;
      localVideoItemHolder.w.setVisibility(8);
      this.jdField_g_of_type_Boolean = true;
      a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, false);
      return;
    case 2131362044: 
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOnClickCloseListener;
      if (paramView != null) {
        paramView.a();
      }
      g();
      a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, true);
      return;
    case 2131362042: 
      paramView = a();
      a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, true);
    case 2131362107: 
      if ((a() == 1) && (localVideoItemHolder.c != null) && (this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo != null))
      {
        if (RIJAdDownloadUtil.a.a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).mAdvertisementSoftInfo.o))
        {
          ((RIJDownloadView)localVideoItemHolder.c).a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        paramView = a();
        a(1, 1, ReportAction.CLICK, paramView, AdClickPos.SoftAdClickBtn, true);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd
 * JD-Core Version:    0.7.0.1
 */