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
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController.OnClickCloseListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController.VideoFeedsSoftAdBarDelegateBase;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.AdDownloadScene;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComBarConfigure;
import com.tencent.biz.pubaccount.readinjoyAd.ad.jump.liujin.LiujinAdJump;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MainService;

public class VideoFeedsSoftAdBarDelegateForAd
  implements View.OnClickListener, VideoFeedsSoftAdBarController.VideoFeedsSoftAdBarDelegateBase
{
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler = new VideoFeedsSoftAdBarDelegateForAd.3(this, Looper.getMainLooper());
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsSoftAdBarController.OnClickCloseListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$OnClickCloseListener;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  private VideoFeedsGameAdComBarConfigure jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure;
  private VideoFeedsSoftAdTest jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private HashMap<String, ADVideoAppDownloadData> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Set<String> jdField_a_of_type_JavaUtilSet;
  public boolean a;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VideoInfo jdField_b_of_type_ComTencentBizPubaccountVideoInfo;
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
    Object localObject = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject == null)
    {
      QLog.e("VideoFeedsSoftAdBarDelegateForAd", 1, "videoSoftAd jump error, advertisementInfo is null");
      localObject = Integer.valueOf(-1);
    }
    Integer localInteger;
    do
    {
      return localObject;
      localInteger = Integer.valueOf(-1);
      if (LiujinAdJump.isFromLiuJin((AdvertisementInfo)localObject)) {
        localInteger = LiujinAdJump.doJumpAction((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidAppActivity);
      }
      localObject = localInteger;
    } while (localInteger.intValue() != -1);
    return ReadInJoyAdJumpUtils.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_AndroidAppActivity);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, AdClickPos paramAdClickPos, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, false, paramAdClickPos, paramBoolean);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setClickPos(paramInt2);
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(paramAdClickPos);
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_Boolean = this.jdField_d_of_type_Boolean;
    }
    ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 35, paramInt1, 5, paramBoolean1, paramBoolean2);
  }
  
  private void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramInt2, paramReportAction, paramInteger, paramBoolean1, null, paramBoolean2);
  }
  
  private void a(TextView paramTextView)
  {
    String str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.I;
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
    int j = 0;
    boolean bool = ReadInJoyHelper.d();
    Object localObject;
    if ((!bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.j != null))
    {
      localObject = paramVideoItemHolder.j;
      if (paramBoolean)
      {
        i = 0;
        ((ViewGroup)localObject).setVisibility(i);
      }
    }
    else
    {
      if ((paramVideoItemHolder != null) && (paramVideoItemHolder.v != null))
      {
        localObject = paramVideoItemHolder.v;
        if (!paramBoolean) {
          break label233;
        }
        i = 0;
        label65:
        ((TextView)localObject).setVisibility(i);
      }
      if ((bool) && (paramVideoItemHolder != null) && (paramVideoItemHolder.C != null) && (paramVideoItemHolder.C.findViewById(2131368350) != null))
      {
        localObject = paramVideoItemHolder.C.findViewById(2131368350);
        if (!paramBoolean) {
          break label239;
        }
        i = 0;
        label116:
        ((View)localObject).setVisibility(i);
      }
      if ((paramVideoItemHolder != null) && (paramVideoItemHolder.a != null))
      {
        localObject = paramVideoItemHolder.a;
        if (!paramBoolean) {
          break label245;
        }
        i = 0;
        label145:
        ((ReadInJoyNickNameTextView)localObject).setVisibility(i);
      }
      if (((paramVideoItemHolder == null) || (!(paramVideoItemHolder instanceof ShortVideoItemHolder)) || (((ShortVideoItemHolder)paramVideoItemHolder).jdField_e_of_type_AndroidWidgetTextView == null)) || ((paramVideoItemHolder != null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder))))
      {
        paramVideoItemHolder = (ShortVideoItemHolder)paramVideoItemHolder;
        if ((paramVideoItemHolder.a != null) && (paramVideoItemHolder.a.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.q == true))
        {
          paramVideoItemHolder = paramVideoItemHolder.jdField_d_of_type_AndroidWidgetTextView;
          if (!paramBoolean) {
            break label251;
          }
        }
      }
    }
    label233:
    label239:
    label245:
    label251:
    for (int i = j;; i = 8)
    {
      paramVideoItemHolder.setVisibility(i);
      return;
      i = 8;
      break;
      i = 8;
      break label65;
      i = 8;
      break label116;
      i = 8;
      break label145;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), true, paramBoolean);
    a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), false, paramBoolean);
    if (!paramBoolean) {
      b(false);
    }
  }
  
  private boolean a(VideoInfo paramVideoInfo, double paramDouble, long paramLong)
  {
    double d1 = paramLong / 1000L * paramDouble / 100.0D;
    if (this.jdField_f_of_type_Boolean)
    {
      if (TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z)) {
        break label149;
      }
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z.equals("1")) {
        if (paramDouble <= Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.A).intValue()) {}
      }
    }
    while (paramDouble > this.jdField_a_of_type_Int)
    {
      int i;
      do
      {
        return true;
        return false;
        if (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.z.equals("2")) {
          break;
        }
        i = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.B).intValue();
      } while ((d1 != 0.0D) && (d1 > i));
      return false;
    }
    return false;
    label149:
    return false;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if ((paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.H))) {
          break;
        }
        bool1 = bool2;
      } while (paramAdvertisementInfo.mAdvertisementSoftInfo.H.equals("1"));
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.D)) {
        break;
      }
      bool1 = bool2;
    } while (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.C));
    return false;
  }
  
  private int b()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 65)) {
      return AIOUtils.a(175.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 184)) {
      return AIOUtils.a(215.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo)) {
      return AIOUtils.a(220.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    return AIOUtils.a(220.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  private CharSequence b()
  {
    float f1 = 13.0F;
    if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
    {
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k = "";
    }
    String str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l + " " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
    if (!TextUtils.isEmpty(str1.trim()))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1);
      int i;
      int j;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l))
      {
        str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l;
        if (str1.contains(str2))
        {
          i = str1.indexOf(str2);
          j = str2.length() + i;
          localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4060")), i, j, 33);
          localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(AIOUtils.a(13.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
          localSpannableStringBuilder.setSpan(new VideoFeedsSoftAdBarDelegateForAd.MarginSpan(AIOUtils.a(4.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())), j, j + 1, 33);
        }
      }
      String str2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k;
      if ((!TextUtils.isEmpty(str2)) && (str1.contains(str2)))
      {
        i = str1.indexOf(str2);
        j = str2.length() + i;
        if (b()) {
          break label404;
        }
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        localSpannableStringBuilder.setSpan(new StrikethroughSpan(), i, j, 33);
        if (!b()) {
          break label429;
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan(AIOUtils.a(f1, this.jdField_a_of_type_AndroidAppActivity.getResources())), i, j, 33);
        return localSpannableStringBuilder;
        label404:
        localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#777777")), i, j, 33);
        break;
        label429:
        f1 = 11.0F;
      }
    }
    return "";
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (paramBoolean) {
        NativeAdUtils.b(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.Y);
      }
    }
    else {
      return;
    }
    NativeAdUtils.b(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.X);
  }
  
  private int c()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 65)) {
      return AIOUtils.a(120.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 184)) {
      return AIOUtils.a(106.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo)) {
      return AIOUtils.a(178.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    }
    return AIOUtils.a(123.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  private void c(VideoInfo paramVideoInfo)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      this.jdField_a_of_type_Int = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_Int;
      this.jdField_f_of_type_Boolean = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.y.equals("1");
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Boolean = this.jdField_f_of_type_Boolean;
      this.jdField_g_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest != null)
    {
      paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest;
      VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo);
    }
  }
  
  private String d()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.F)) {
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.F;
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) {
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo;
      }
      return a();
    }
    return null;
  }
  
  private String e()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.G)) {
          break label66;
        }
        str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.G;
      }
    }
    return str1;
    label66:
    return b();
  }
  
  private void g(VideoItemHolder paramVideoItemHolder)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null)) {
      return;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 65))
    {
      k(paramVideoItemHolder);
      return;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 184))
    {
      l(paramVideoItemHolder);
      return;
    }
    if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
      return;
    }
    j(paramVideoItemHolder);
  }
  
  private void h()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    do
    {
      return;
      i();
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362029));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362037));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362043));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362039));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362033));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362041));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362036));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362027));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362025));
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362031);
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362250));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362038));
      if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(this.jdField_a_of_type_AndroidViewView);
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 65))
      {
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362252));
        this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371167));
        return;
      }
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 184))
      {
        this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362251));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131371166));
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c = ((RIJDownloadView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362079));
    } while (this.jdField_e_of_type_AndroidWidgetTextView == null);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.a(19.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#FF12B7F5"));
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
  }
  
  private void h(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    String str1 = d();
    String str2 = e();
    paramVideoItemHolder.N.setText(str2);
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.i, str1, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 22, 22, -1, this.jdField_a_of_type_AndroidAppActivity);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
    paramVideoItemHolder.w.setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setOnClickListener(this);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    ViewStub localViewStub;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 65))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.z == null)
      {
        localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131381497);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.z = ((ViewGroup)localViewStub.inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.z;
      return;
    }
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId == 184))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.A == null)
      {
        localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131381496);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.A = ((ViewGroup)localViewStub.inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.A;
      return;
    }
    if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.B == null)
      {
        localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131381500);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.B = ((ViewGroup)localViewStub.inflate());
      }
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.B;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_y_of_type_AndroidViewView == null)
    {
      localViewStub = (ViewStub)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_x_of_type_AndroidViewView.findViewById(2131381498);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_y_of_type_AndroidViewView = ((ViewGroup)localViewStub.inflate());
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_y_of_type_AndroidViewView;
  }
  
  private void i(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setVisibility(0);
    String str = a();
    VideoFeedsSoftAdBarController.a(paramVideoItemHolder.h, str, AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 40, 40, -1, this.jdField_a_of_type_AndroidAppActivity);
    str = b();
    CharSequence localCharSequence = a();
    if ((paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "setAdvertisementInfo: videoTitle = " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.c);
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setAdvertisementInfo(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setDownloadScene(AdDownloadScene.SoftButton);
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setActivity(new SoftReference(this.jdField_a_of_type_AndroidAppActivity));
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setProgressStyle(RoundProgressStyle.VideoSoftAd);
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setOnClickListener(this);
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(true);
    }
    paramVideoItemHolder.K.setText(str);
    paramVideoItemHolder.L.setText(localCharSequence);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(paramVideoItemHolder);
    paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setOnClickListener(this);
    paramVideoItemHolder.o.setTag(paramVideoItemHolder);
    paramVideoItemHolder.o.setOnClickListener(this);
    paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setTag(paramVideoItemHolder);
    paramVideoItemHolder.w.setOnClickListener(this);
  }
  
  @RequiresApi(api=16)
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    GradientDrawable localGradientDrawable1;
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId != 65)) {
            break;
          }
          localGradientDrawable1 = new GradientDrawable();
          localGradientDrawable1.setCornerRadius(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          localGradientDrawable1.setColor(Color.parseColor("#7F292A2F"));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
        } while (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null);
        localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
        f1 = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
        localGradientDrawable1.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
        return;
        if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdMaterialId != 184)) {
          break;
        }
        localGradientDrawable1 = new GradientDrawable();
        localGradientDrawable1.setCornerRadius(AIOUtils.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
        localGradientDrawable1.setColor(Color.parseColor("#E6FFFFFF"));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
      } while (this.jdField_e_of_type_AndroidWidgetRelativeLayout == null);
      localGradientDrawable1 = new GradientDrawable();
      localGradientDrawable1.setColors(new int[] { Color.argb(102, 0, 0, 0), Color.argb(0, 0, 0, 0) });
      float f1 = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localGradientDrawable1.setCornerRadii(new float[] { f1, f1, f1, f1, 0.0F, 0.0F, 0.0F, 0.0F });
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
      return;
      if (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a();
        return;
      }
    } while ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo == null) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C == null));
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.C.equals("white"))
        {
          localGradientDrawable1 = new GradientDrawable();
          localGradientDrawable1.setCornerRadius(AIOUtils.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          localGradientDrawable1.setColor(Color.parseColor("#FFFFFFFF"));
          this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
          int i = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
          localGradientDrawable1 = new GradientDrawable();
          localGradientDrawable1.setShape(0);
          localGradientDrawable1.setCornerRadii(new float[] { 0.0F, 0.0F, i, i, 0.0F, 0.0F, i, i });
          localGradientDrawable1.setColor(Color.parseColor("#33000000"));
          this.jdField_f_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable1);
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "smallCardShowTime Format error");
        return;
      }
      GradientDrawable localGradientDrawable2 = new GradientDrawable();
      localGradientDrawable2.setCornerRadius(AIOUtils.a(10.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable2.setColor(Color.parseColor("#7F292A2F"));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable2);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      }
    }
  }
  
  private void j(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = a();
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, a(), AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 65, 65, -1, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
    this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(c());
    a(this.jdField_f_of_type_AndroidWidgetTextView);
    if ((paramVideoItemHolder.c != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null))
    {
      ReadInJoyAdLog.a("AD_DOWNLOAD_TAG", "setAdvertisementInfo: videoTitle = " + this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.c);
      this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdBtnTxt = c();
      paramVideoItemHolder.c.setAdvertisementInfo(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      paramVideoItemHolder.c.setDownloadScene(AdDownloadScene.SoftButton);
      paramVideoItemHolder.c.setActivity(new SoftReference(this.jdField_a_of_type_AndroidAppActivity));
      paramVideoItemHolder.c.setProgressStyle(HorizontalProgressStyle.VideoCardStyleTikTok);
      paramVideoItemHolder.c.setOnClickListener(this);
      paramVideoItemHolder.c.a(true);
      paramVideoItemHolder.c.setTag(paramVideoItemHolder);
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
      if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k))) {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k)))
        {
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          if (paramVideoItemHolder.c != null) {
            paramVideoItemHolder.c.setVisibility(8);
          }
        }
      }
    }
    label538:
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
          break;
          if (a() != 2) {
            break label538;
          }
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        } while (paramVideoItemHolder.c == null);
        paramVideoItemHolder.c.setVisibility(8);
        return;
      } while (a() != 1);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    } while (paramVideoItemHolder.c == null);
    paramVideoItemHolder.c.setVisibility(0);
  }
  
  private void k()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      String str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString != null) {
        str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString + "_B";
      }
      if ((this.jdField_c_of_type_JavaUtilSet != null) && (!this.jdField_c_of_type_JavaUtilSet.contains(str)))
      {
        this.jdField_c_of_type_JavaUtilSet.add(str);
        if (!VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo)) {
          break label108;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.a(true);
      }
    }
    return;
    label108:
    a(true);
  }
  
  private void k(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 175, 98, 0, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b());
    a(this.jdField_g_of_type_AndroidWidgetTextView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramVideoItemHolder);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setTag(paramVideoItemHolder);
  }
  
  private void l(VideoItemHolder paramVideoItemHolder)
  {
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg, AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 120, 90, -1, this.jdField_a_of_type_AndroidAppActivity);
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
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1)) {
      return 1;
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int;
  }
  
  public CharSequence a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      Object localObject2;
      Object localObject1;
      if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 1) || (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12))
      {
        localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "不容错过的热门应用";
        }
      }
      do
      {
        return localObject1;
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int != 0) {
          break;
        }
        localObject2 = b();
        localObject1 = localObject2;
      } while (!TextUtils.isEmpty((CharSequence)localObject2));
      return "不容错过的热门商品";
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {}
        for (localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_JavaLangString;; localObject2 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break;
          }
          return "点击查看详情";
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null))
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int == 0)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType == 12) {
          return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateLogo;
        }
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdImg;
      }
      return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_b_of_type_JavaLangString;
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
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    c(paramVideoInfo);
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
    if (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null) {
      paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.setTag(2131381651, this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo);
    }
    f(paramVideoItemHolder);
    if (!this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.a();
      }
      SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
      if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
        SoftAdExpoStatManager.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.S);
      }
      a(false);
    }
  }
  
  @RequiresApi(api=16)
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      h();
      j();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.width = b();
      localLayoutParams.height = c();
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    } while ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup == null) || (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.getVisibility() != 0));
    this.jdField_b_of_type_Boolean = true;
    g(paramVideoItemHolder);
    ViewGroup.LayoutParams localLayoutParams = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i = paramVideoItemHolder.w.getWidth();
    localLayoutParams.width = i;
    localLayoutParams.height = 1;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(600L);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    int j = b();
    int k = c();
    paramVideoItemHolder.e.setVisibility(8);
    a(paramVideoItemHolder, false);
    localValueAnimator.addUpdateListener(new VideoFeedsSoftAdBarDelegateForAd.1(this, j, i, localLayoutParams, k));
    localValueAnimator.addListener(new VideoFeedsSoftAdBarDelegateForAd.2(this, paramVideoItemHolder));
    localValueAnimator.start();
    i = 10;
    try
    {
      j = Integer.parseInt(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.E);
      i = j;
    }
    catch (Exception paramVideoItemHolder)
    {
      for (;;)
      {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "big_card_show_time Format error");
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, i * 1000);
    k();
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
  
  public boolean a()
  {
    boolean bool;
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 2)) {
      bool = true;
    }
    while ((bool) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 2))
    {
      String str1 = b();
      String str2 = a();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public boolean a(VideoInfo paramVideoInfo)
  {
    if (MainService.isDebugVersion) {}
    do
    {
      do
      {
        return true;
      } while (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
      if (ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure)) {
        return false;
      }
    } while (!this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public boolean a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder, double paramDouble, long paramLong)
  {
    if ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null) && (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.getVisibility() == 0) && (!this.jdField_g_of_type_Boolean) && (a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsSoftAdBarDelegateForAd", 2, "进度判断 video_percent=" + paramDouble);
      }
      return a(paramVideoInfo, paramDouble, paramLong);
    }
    return false;
  }
  
  public String b()
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
    {
      str1 = str2;
      if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_c_of_type_Int != 0) {
          break label136;
        }
        if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType != 12) {
          break label75;
        }
        str1 = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdCorporateImageName;
      }
    }
    return str1;
    label75:
    if (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_e_of_type_Int == 0)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc)) {
        return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdDesc;
      }
      return HardCodeUtil.a(2131715982);
    }
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTxt;
    label136:
    return this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.w.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdTest.c();
  }
  
  public void b(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public void b(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)))
    {
      paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewStub)((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131381337)).inflate()).findViewById(2131381495)).inflate());
      paramVideoItemHolder.w = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131381343));
      paramVideoItemHolder.e = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131381345));
      paramVideoItemHolder.i = ((URLImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368291));
      paramVideoItemHolder.N = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362044));
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#E6FFFFFF"));
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131381346));
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      paramVideoItemHolder.h = ((URLImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131368395));
      paramVideoItemHolder.K = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362045));
      paramVideoItemHolder.L = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362042));
      paramVideoItemHolder.M = ((TextView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362040));
      paramVideoItemHolder.o = ((ImageView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362030));
      paramVideoItemHolder.jdField_x_of_type_AndroidViewViewGroup = ((ViewGroup)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362035));
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView = ((RIJDownloadView)paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup.findViewById(2131362081));
      paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setVisibility(8);
    }
    d(paramVideoItemHolder);
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public String c()
  {
    String str = "立即查看";
    if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.L)) {
        str = this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.L;
      }
    }
    do
    {
      return str;
      if (a() == 0) {
        return "立刻购买";
      }
      if (a() == 2) {
        return "立即查看";
      }
    } while (a() != 1);
    return "立即下载";
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c.a();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a();
    }
  }
  
  public void c(VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.jdField_y_of_type_AndroidViewViewGroup != null)
    {
      if (a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        h(paramVideoItemHolder);
      }
    }
    else {
      return;
    }
    i(paramVideoItemHolder);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.c.b();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.b();
    }
  }
  
  public void d(VideoItemHolder paramVideoItemHolder)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramVideoItemHolder.w.getLayoutParams();
    paramVideoItemHolder.w.setVisibility(0);
    if (a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
      paramVideoItemHolder.w.setBackgroundDrawable(localGradientDrawable);
      paramVideoItemHolder.w.setLayoutParams(localLayoutParams);
      paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      paramVideoItemHolder.e.setVisibility(0);
      localLayoutParams.height = AIOUtils.a(27.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
      localLayoutParams.width = -2;
      return;
    }
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    paramVideoItemHolder.e.setVisibility(8);
    localLayoutParams.height = AIOUtils.a(48.5F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    localLayoutParams.width = AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    e(paramVideoItemHolder);
  }
  
  public void e()
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void e(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject = (LinearLayout.LayoutParams)paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.a(6.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#80292A2F"));
    ((LinearLayout.LayoutParams)localObject).width = AIOUtils.a(250.0F, this.jdField_a_of_type_AndroidAppActivity.getResources());
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(localGradientDrawable);
    paramVideoItemHolder.jdField_d_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramVideoItemHolder.h.setVisibility(0);
    if (a() == 0) {
      if ((TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k))) {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.l)) || (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.k)))
        {
          localObject = new GradientDrawable();
          ((GradientDrawable)localObject).setCornerRadius(AIOUtils.a(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
          ((GradientDrawable)localObject).setColor(Color.parseColor("#FFFF4060"));
          paramVideoItemHolder.M.setVisibility(0);
          paramVideoItemHolder.M.setBackgroundDrawable((Drawable)localObject);
          paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setVisibility(8);
        }
      }
    }
    do
    {
      return;
      paramVideoItemHolder.M.setVisibility(8);
      break;
      paramVideoItemHolder.M.setVisibility(8);
      break;
      if (a() == 2)
      {
        paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setVisibility(8);
        return;
      }
    } while (a() != 1);
    paramVideoItemHolder.jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.setVisibility(0);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
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
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder, true);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.e.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (VideoItemHolder)paramView.getTag();
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_c_of_type_Boolean = true;
      if (paramView.getId() != 2131362029) {
        b(true);
      }
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131362027: 
        Integer localInteger = a();
        a(1, 1, ReportAction.CLICK, localInteger, AdClickPos.SoftAdClickBtn, true);
      case 2131362079: 
        if ((a() == 1) && (((VideoItemHolder)localObject).c != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
          if (RIJAdDownloadUtil.a.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o)) {
            ((VideoItemHolder)localObject).c.a(AdClickPos.SoftAdClickBtn, 8);
          }
        }
        break;
      case 2131362029: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$OnClickCloseListener != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsSoftAdBarController$OnClickCloseListener.a();
        }
        g();
        a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, true);
        break;
      case 2131362036: 
        localObject = a();
        a(1, 0, ReportAction.CLICK, (Integer)localObject, AdClickPos.SoftAdComponent, true);
        continue;
        localObject = a();
        a(1, 1, ReportAction.CLICK, (Integer)localObject, AdClickPos.SoftAdClickBtn, true);
        break;
      case 2131381343: 
        if ((this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null) && (VideoFeedsSoftAdTest.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo)))
        {
          a((VideoItemHolder)localObject);
          a(1, 2, ReportAction.CLICK, Integer.valueOf(0), AdClickPos.SoftAdComponent, false);
        }
        else
        {
          localObject = a();
          a(1, 2, ReportAction.CLICK, (Integer)localObject, AdClickPos.SoftAdComponent, false);
        }
        break;
      case 2131362030: 
        this.jdField_a_of_type_Boolean = true;
        ((VideoItemHolder)localObject).w.setVisibility(8);
        this.jdField_g_of_type_Boolean = true;
        a(1, 3, ReportAction.CLOSE, Integer.valueOf(0), AdClickPos.SoftAdClose, false);
        break;
      case 2131362081: 
        if ((a() == 1) && (((VideoItemHolder)localObject).jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
          if (RIJAdDownloadUtil.a.a(this.jdField_b_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.o))
          {
            ((VideoItemHolder)localObject).jdField_d_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.a(AdClickPos.SoftAdClickBtn, 8);
          }
          else
          {
            localObject = a();
            a(1, 1, ReportAction.CLICK, (Integer)localObject, AdClickPos.SoftAdClickBtn, false);
          }
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdBarDelegateForAd
 * JD-Core Version:    0.7.0.1
 */