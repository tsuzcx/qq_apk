package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.playfeeds.GameAdComData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftGetListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.AdTagInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.KdTagItem;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGameAdComManager
  implements View.OnClickListener, GiftGetListener, IVideoFeedsGameAdComManager
{
  private static final String jdField_a_of_type_JavaLangString;
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ADBaseAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private GameAdComData jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
  private VideoFeedsGameAdComBarConfigure jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure;
  private VideoFeedsGameAdComManager.GameAdGiftInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo;
  private ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  private GiftPackageDialog jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.readinjoy.video.");
    localStringBuilder.append(VideoFeedsGameAdComManager.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public VideoFeedsGameAdComManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure = new VideoFeedsGameAdComBarConfigure(paramQQAppInterface);
    this.jdField_a_of_type_Int = DisplayUtil.a(paramActivity, 3.0F);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager = new ADBaseAppDownloadManager(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a(new VideoFeedsGameAdComManager.1(this));
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    if (paramAdvertisementInfo != null) {
      if (paramAdvertisementInfo.gameAdComData == null) {
        return localJSONObject1;
      }
    }
    for (Object localObject = paramAdvertisementInfo.gameAdComData;; localObject = "'1")
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(((GameAdComData)localObject).B)) {
          localJSONObject2.put("nfa_chainid", ((GameAdComData)localObject).B);
        }
        localJSONObject2.put("appid", ((GameAdComData)localObject).g);
        localObject = paramAdvertisementInfo.gameAdComData;
        String str = "2";
        if (localObject != null)
        {
          localObject = str;
          if (paramAdvertisementInfo.gameAdComData.D.equals("2")) {}
        }
        else
        {
          if (!paramAdvertisementInfo.isKolGame) {
            continue;
          }
          localObject = str;
        }
        localJSONObject2.put("obj_type", localObject);
        if (paramInt == 2) {
          localJSONObject2.put("type", 0);
        }
        localJSONObject1.put("game_gift_report", String.valueOf(localJSONObject2));
        return localJSONObject1;
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
      }
      return localJSONObject1;
    }
  }
  
  private void a(int paramInt, Integer paramInteger1, Integer paramInteger2, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject == null) {
      return;
    }
    localObject = ((AdvertisementInfo)localObject).mTitle;
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("游戏组件上报 type = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" adTitle = ");
    localStringBuilder.append((String)localObject);
    QLog.d(str, 1, localStringBuilder.toString());
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    a(paramHashMap);
    ((IRIJAdService)QRoute.api(IRIJAdService.class)).report(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(26).d(1).a(paramInteger1).b(paramInteger2).b(paramBoolean).d(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.d, paramHashMap)).e(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, paramInt)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
  }
  
  private void a(int paramInt, Integer paramInteger, HashMap<String, Object> paramHashMap)
  {
    a(paramInt, null, paramInteger, paramHashMap, false);
  }
  
  private void a(int paramInt, Integer paramInteger, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    a(paramInt, paramInteger, null, paramHashMap, paramBoolean);
  }
  
  private static void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private static void a(View paramView, Object paramObject)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTag(paramObject);
  }
  
  private void a(GameAdComData paramGameAdComData, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = paramVideoItemHolder;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramVideoItemHolder.t == null) && (((IVideoHolderHelper)QRoute.api(IVideoHolderHelper.class)).isShortVideoItemHolder(paramVideoItemHolder)) && (paramVideoItemHolder.p != null))
    {
      paramVideoItemHolder.t = ((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131380636)).inflate());
      paramVideoItemHolder.e = ((URLImageView)paramVideoItemHolder.t.findViewById(2131367448));
      paramVideoItemHolder.A = ((TextView)paramVideoItemHolder.t.findViewById(2131367451));
      paramVideoItemHolder.B = ((TextView)paramVideoItemHolder.t.findViewById(2131367450));
      paramVideoItemHolder.C = ((TextView)paramVideoItemHolder.t.findViewById(2131367449));
      paramVideoItemHolder.D = ((TextView)paramVideoItemHolder.t.findViewById(2131367447));
      paramVideoItemHolder.H = ((TextView)paramVideoItemHolder.t.findViewById(2131362274));
    }
    if (paramVideoItemHolder.t != null)
    {
      paramVideoItemHolder.t.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      localObject2 = URLDrawable.getDrawable(paramGameAdComData.j, (URLDrawable.URLDrawableOptions)localObject1);
      ((URLDrawable)localObject2).setTag(URLDrawableDecodeHandler.b(((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth, ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight, this.jdField_a_of_type_Int));
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.j);
      if (paramVideoItemHolder.e == null) {
        break label311;
      }
      paramVideoItemHolder.e.setImageDrawable((Drawable)localObject2);
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2;
      label263:
      break label263;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("后台下发的url格式有问题：");
      ((StringBuilder)localObject2).append(paramGameAdComData.j);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    label311:
    b(paramVideoItemHolder.A, paramGameAdComData.jdField_c_of_type_JavaLangString);
    if ((FastWeqAdUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (!TextUtils.isEmpty(paramGameAdComData.n))) {
      b(paramVideoItemHolder.B, paramGameAdComData.n);
    } else {
      b(paramVideoItemHolder.B, paramGameAdComData.i);
    }
    a(paramGameAdComData.C);
    if (ReadInJoyAdSwitchUtil.a()) {
      b(paramVideoItemHolder.B, Color.parseColor("#80000000"));
    }
    paramVideoItemHolder.t.setTag(paramVideoItemHolder);
    a(paramVideoItemHolder.C, paramVideoItemHolder);
    a(paramVideoItemHolder.D, paramVideoItemHolder);
    paramVideoItemHolder.t.setOnClickListener(this);
    if (paramVideoItemHolder.C != null) {
      paramVideoItemHolder.C.setOnClickListener(this);
    }
    if (paramVideoItemHolder.D != null) {
      paramVideoItemHolder.D.setOnClickListener(this);
    }
    paramVideoItemHolder.t.setTag(2131380884, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData);
    h();
    b(paramVideoItemHolder);
    ((IVideoFeedsHelper)QRoute.api(IVideoFeedsHelper.class)).performViewSlideUpAnim(paramVideoItemHolder.t, 200);
  }
  
  private void a(Long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (localObject != null) {
      ((AdvertisementInfo)localObject).setAdClickPos(AdClickPos.SoftAdComponent);
    }
    this.jdField_b_of_type_Boolean = false;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    Integer localInteger = FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.q, "");
    localObject = paramLong;
    if (paramLong == null)
    {
      localObject = Long.valueOf(3050107L);
      if (FastWeqAdUtils.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        localObject = Long.valueOf(3050107L);
      } else if (FastWeqAdUtils.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        localObject = Long.valueOf(3050205L);
      } else if (FastWeqAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        localObject = Long.valueOf(3050309L);
      } else if (FastWeqAdUtils.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        localObject = Long.valueOf(3050407L);
      } else if (FastWeqAdUtils.e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) {
        localObject = Long.valueOf(3050507L);
      }
    }
    paramLong = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    if (paramLong != null)
    {
      paramLong = GameComponentReport.a(paramLong, ((Long)localObject).longValue(), 9L, "", this.jdField_c_of_type_JavaLangString, "");
      localObject = ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 39, 119, localInteger);
      ((AdReportData)localObject).e(paramLong);
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).report((AdReportData)localObject);
    }
  }
  
  private void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localObject != null) && (((VideoItemHolder)localObject).H != null) && (!TextUtils.isEmpty(paramString)))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.H, 0);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setCornerRadius(AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
      ((GradientDrawable)localObject).setColor(Color.parseColor("#33000000"));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.H.setBackgroundDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.H.setText(paramString);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.H, 8);
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolGame)
        {
          str = "2";
          localJSONObject.put("obj_type", str);
          paramHashMap.put("article_ad_ext", localJSONObject.toString());
          return;
        }
      }
      catch (Exception paramHashMap)
      {
        paramHashMap.printStackTrace();
        return;
      }
      String str = "1";
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    Object localObject;
    if (PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d))
    {
      f();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject).jdField_b_of_type_Int = 1;
      if (((GameAdComData)localObject).s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(15), paramHashMap);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
      }
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      localObject = DownloadManagerV2.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      DownloadManagerV2.a().a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject).jdField_b_of_type_Int = 5;
      if (((GameAdComData)localObject).s.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(18), paramHashMap);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
      }
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      d();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject).jdField_b_of_type_Int = 5;
      if (((GameAdComData)localObject).s.equals("2"))
      {
        paramHashMap.put("download_state", "3");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(18), paramHashMap);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
        a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
      }
      return true;
    }
    return false;
  }
  
  private boolean a(VideoInfo paramVideoInfo)
  {
    if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    if (ReadInJoyAdUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure)) {
      return true;
    }
    return this.jdField_b_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString);
  }
  
  private String b()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("jump_page", 6);
      ((JSONObject)localObject).put("jump_bus_type", 5);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, localException.getMessage());
      }
    }
    return "";
  }
  
  private static void b(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setTextColor(paramInt);
  }
  
  private static void b(TextView paramTextView, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  private static void b(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (paramTextView == null) {
      return;
    }
    paramTextView.setText(paramCharSequence);
  }
  
  private void b(VideoItemHolder paramVideoItemHolder)
  {
    Object localObject1 = HardCodeUtil.a(2131716002);
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
    if (localObject2 == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(((GameAdComData)localObject2).s).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      label36:
      boolean bool;
      break label36;
    }
    bool = ReadInJoyAdSwitchUtil.a();
    if (i == 1)
    {
      if (b())
      {
        localObject2 = BaseApplicationImpl.getContext().getResources().getString(2131717919);
        b(paramVideoItemHolder.C, Color.parseColor("#262626"));
        localObject1 = localObject2;
        if (bool)
        {
          b(paramVideoItemHolder.C, Color.parseColor("#80000000"));
          localObject1 = localObject2;
        }
      }
      else
      {
        if (bool) {
          localObject1 = "预约";
        } else {
          localObject1 = HardCodeUtil.a(2131715935);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v)) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v;
        }
        b(paramVideoItemHolder.C, -1);
      }
      b(paramVideoItemHolder.C, null, null, null, null);
    }
    else if (i == 2)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.d))
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.d))
        {
          if (bool) {
            localObject1 = "打开";
          } else {
            localObject1 = HardCodeUtil.a(2131715965);
          }
          b(paramVideoItemHolder.C, -1);
          b(paramVideoItemHolder.C, null, null, null, null);
          b(paramVideoItemHolder.C, (CharSequence)localObject1);
          return;
        }
        if (bool) {
          localObject2 = "下载";
        } else {
          localObject2 = HardCodeUtil.a(2131715933);
        }
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v)) {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v;
        }
        b(paramVideoItemHolder.C, -1);
        if (!bool)
        {
          localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843003);
          b(paramVideoItemHolder.C, null, null, (Drawable)localObject1, null);
        }
        else
        {
          b(paramVideoItemHolder.C, null, null, null, null);
        }
        b(paramVideoItemHolder.C, (CharSequence)localObject2);
        localObject1 = localObject2;
        if (!this.jdField_b_of_type_Boolean)
        {
          localObject1 = localObject2;
          if (!this.jdField_c_of_type_Boolean)
          {
            this.jdField_c_of_type_Boolean = true;
            b();
          }
        }
      }
    }
    else
    {
      if (c())
      {
        localObject2 = HardCodeUtil.a(2131715932);
        b(paramVideoItemHolder.C, Color.parseColor("#262626"));
        localObject1 = localObject2;
        if (bool)
        {
          b(paramVideoItemHolder.C, Color.parseColor("#80000000"));
          localObject1 = localObject2;
        }
      }
      else
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v)) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.v;
        } else {
          localObject1 = HardCodeUtil.a(2131715907);
        }
        b(paramVideoItemHolder.C, -1);
      }
      b(paramVideoItemHolder.C, null, null, null, null);
    }
    b(paramVideoItemHolder.C, (CharSequence)localObject1);
  }
  
  private void c(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.t != null)) {
      paramVideoItemHolder.t.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    GameAdComData localGameAdComData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
    return (localGameAdComData != null) && (!TextUtils.isEmpty(localGameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.i));
  }
  
  private boolean e()
  {
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject != null) {
        try
        {
          localObject = ((ADVideoAppDownloadData)localObject).d;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = DownloadManagerV2.a().c((String)localObject);
            if ((ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData)) && (localObject != null) && (((DownloadInfo)localObject).a() == 4))
            {
              g();
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  private boolean f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
    HashMap localHashMap = new HashMap();
    boolean bool = PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject);
    int i = 5;
    if (bool)
    {
      f();
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject).jdField_b_of_type_Int = 1;
      if ("2".equals(((GameAdComData)localObject).s)) {
        localHashMap.put("download_state", "5");
      } else {
        i = 1;
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, Integer.valueOf(15), localHashMap);
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      localObject = DownloadManagerV2.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      DownloadManagerV2.a().a((DownloadInfo)localObject);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject).jdField_b_of_type_Int = 5;
      if ("2".equals(((GameAdComData)localObject).s)) {
        localHashMap.put("download_state", "3");
      } else {
        i = 1;
      }
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, Integer.valueOf(18), localHashMap);
      return true;
    }
    return false;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
      return;
    }
    boolean bool = this.jdField_b_of_type_Boolean;
    int j = 1;
    int i = 1;
    if (!bool)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int == 4)
      {
        a(4, d());
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int == 5)
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
        if (PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject1))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int = 1;
          a(1, d());
          return;
        }
        a(5, d());
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int == 3)
      {
        a(3, d());
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
        if (localObject1 != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
          if (localObject2 != null) {
            ((ADBaseAppDownloadManager)localObject2).a((ADVideoAppDownloadData)localObject1);
          }
        }
      }
      return;
    }
    Object localObject1 = new HashMap();
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      d();
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      ((GameAdComData)localObject2).jdField_b_of_type_Int = 5;
      if ("2".equals(((GameAdComData)localObject2).s))
      {
        ((HashMap)localObject1).put("download_state", "3");
        i = 5;
      }
      a(i, Integer.valueOf(18), (HashMap)localObject1);
      return;
    }
    c();
    Object localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("queryCallback and download: appId is ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" appName is ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.e);
    ((IRIJAdLogService)localObject2).d(str, localStringBuilder.toString());
    i = j;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s))
    {
      ((HashMap)localObject1).put("download_state", "1");
      i = 5;
    }
    a(i, Integer.valueOf(3), (HashMap)localObject1);
  }
  
  private void l()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 8);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 0);
    if (!ReadInJoyAdSwitchUtil.a())
    {
      localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715968));
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_c_of_type_Int);
      localStringBuilder.append("%");
      b(localTextView, localStringBuilder.toString());
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, Color.parseColor("#262626"));
      return;
    }
    TextView localTextView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_c_of_type_Int);
    localStringBuilder.append("%");
    b(localTextView, localStringBuilder.toString());
    b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, Color.parseColor("#80000000"));
  }
  
  private void m()
  {
    if (c())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D.setClickable(false);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
  }
  
  private void n()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo = new VideoFeedsGameAdComManager.GameAdGiftInfo(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.u));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private void o()
  {
    if (b())
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(false);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D.setClickable(false);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
  }
  
  private void p()
  {
    if (a())
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if ((localADVideoAppDownloadData != null) && (!TextUtils.isEmpty(localADVideoAppDownloadData.jdField_c_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(true);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(true);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D.setClickable(true);
        break label95;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.t.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D.setClickable(false);
    label95:
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
    i();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.a();
  }
  
  public VideoFeedsGameAdComBarConfigure a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidAppActivity = null;
    ADBaseAppDownloadManager localADBaseAppDownloadManager = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
    if (localADBaseAppDownloadManager != null) {
      localADBaseAppDownloadManager.a();
    }
  }
  
  protected void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s)))
    {
      localHashMap.put("download_state", "2");
      a(5, null, null, localHashMap, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 8)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              if (paramInt1 != 6) {
                return;
              }
              a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
              a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
              QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131715978), 0).a();
              return;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, HardCodeUtil.a(2131715919));
            if (ReadInJoyAdSwitchUtil.a()) {
              b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, "安装");
            }
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, -1);
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, null, null, null, null);
            a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
            a(paramInt1);
            return;
          }
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 8);
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 0);
          b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, HardCodeUtil.a(2131715988));
          b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, -1);
          if (ReadInJoyAdSwitchUtil.a())
          {
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, "继续");
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, Color.parseColor("#80000000"));
          }
        }
        else
        {
          l();
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 8);
          a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 0);
          b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, Color.parseColor("#262626"));
          if (ReadInJoyAdSwitchUtil.a()) {
            b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, Color.parseColor("#80000000"));
          }
        }
      }
      else {
        k();
      }
    }
    else
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, HardCodeUtil.a(2131715897));
      if (ReadInJoyAdSwitchUtil.a()) {
        b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, "打开");
      }
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, -1);
      b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, null, null, null, null);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
    }
  }
  
  public void a(long paramLong)
  {
    if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s))
    {
      VideoFeedsGameAdComManager.GameAdGiftInfo localGameAdGiftInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo;
      if ((localGameAdGiftInfo != null) && (localGameAdGiftInfo.a == paramLong)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C.post(new VideoFeedsGameAdComManager.2(this));
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2)
    {
      GiftPackageDialog localGiftPackageDialog = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
      if (localGiftPackageDialog != null)
      {
        localGiftPackageDialog.a(paramConfiguration);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog.dismiss();
      }
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.scene = "RIJAdRefreshSceneFloatVideo";
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData);
    }
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.d.getVisibility() == 0) {
      return;
    }
    if ((paramVideoItemHolder.t != null) && (paramVideoItemHolder.t.getVisibility() == 0)) {
      return;
    }
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))) {
      return;
    }
    if (paramVideoInfo != null)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
      if (localObject1 != null)
      {
        if ("3".equals(((GameAdComData)localObject1).s))
        {
          n();
          if (c())
          {
            this.jdField_b_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData, paramVideoItemHolder);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        localObject1 = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo.a.isEmpty()))
        {
          localObject2 = paramVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo$AdTagInfo.a.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            ((StringBuilder)localObject1).append(((VideoInfo.KdTagItem)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject1).append(",");
          }
        }
        localObject1 = ((StringBuilder)localObject1).toString();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
        Object localObject2 = "";
        if (bool) {
          localObject1 = "";
        } else {
          localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
        this.jdField_c_of_type_JavaLangString = ((String)localObject1);
        if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
          return;
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
        SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
        if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (!((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).isKolSoftAd())) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.a();
        }
        if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)) {
          SoftAdExpoStatManager.a().a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.T);
        }
        paramVideoItemHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        paramVideoInfo = (VideoInfo)localObject2;
        if (paramVideoItemHolder != null)
        {
          paramVideoInfo = (VideoInfo)localObject2;
          if (!TextUtils.isEmpty(paramVideoItemHolder.mAdViewId)) {
            paramVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
          }
        }
        paramVideoItemHolder = new HashMap();
        a(2, Integer.valueOf(2), paramVideoItemHolder, true);
        a(2, Integer.valueOf(1), paramVideoItemHolder, false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009376", "0X8009376", 0, 0, String.valueOf(26), String.valueOf(1), paramVideoInfo, b());
        return;
      }
    }
    if ((paramVideoItemHolder.t != null) && (paramVideoItemHolder.t.getVisibility() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
      }
      paramVideoItemHolder.t.setVisibility(8);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramVideoItemHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    ReadInJoyAdDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.d, new VideoFeedsGameAdComManager.5(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    VideoInfo localVideoInfo = paramVideoItemHolder.a.a;
    if ((localVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo).mSoftAdType == 1) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo).gameAdComData != null))
    {
      a(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(localVideoInfo));
      if (!paramBoolean) {
        a(localVideoInfo, paramVideoItemHolder);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.b();
  }
  
  protected void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject2 != null)
      {
        ((ADBaseAppDownloadManager)localObject1).a((ADVideoAppDownloadData)localObject2);
        localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
        localObject2 = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doQuery : appId is ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" appName is ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.e);
        ((IRIJAdLogService)localObject1).d((String)localObject2, localStringBuilder.toString());
        return;
      }
    }
    localObject1 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    Object localObject2 = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doQuery cancel, manager is ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager);
    localStringBuilder.append(" downloadData is ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    ((IRIJAdLogService)localObject1).d((String)localObject2, localStringBuilder.toString());
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s).intValue();
  }
  
  protected void c()
  {
    ADBaseAppDownloadManager localADBaseAppDownloadManager = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
    if (localADBaseAppDownloadManager != null)
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localADVideoAppDownloadData != null) {
        localADBaseAppDownloadManager.a(localADVideoAppDownloadData);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D != null) {
      l();
    }
  }
  
  protected boolean c()
  {
    VideoFeedsGameAdComManager.GameAdGiftInfo localGameAdGiftInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo;
    if (localGameAdGiftInfo == null) {
      return false;
    }
    return GiftPackageManager.a(null, localGameAdGiftInfo.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    ADVideoAppDownloadData localADVideoAppDownloadData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
    if (localADVideoAppDownloadData != null)
    {
      ADBaseAppDownloadManager localADBaseAppDownloadManager = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
      if (localADBaseAppDownloadManager != null) {
        localADBaseAppDownloadManager.d(localADVideoAppDownloadData);
      }
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.jdField_b_of_type_Int;
  }
  
  public void e()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void f()
  {
    if (a())
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
      if (localObject != null)
      {
        if ((((ADVideoAppDownloadData)localObject).jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d)))
        {
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launch(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
          return;
        }
        localObject = (IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class);
        Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
        AdvertisementInfo localAdvertisementInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        ((IRIJAdActionUtilService)localObject).openAppFromGdtApi(localActivity, localAdvertisementInfo, null, (int)localAdvertisementInfo.mChannelID, true);
      }
    }
  }
  
  protected void g()
  {
    GameAdComData localGameAdComData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData;
    localGameAdComData.jdField_b_of_type_Int = 5;
    localGameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void h()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if (localVideoItemHolder == null) {
      return;
    }
    a(localVideoItemHolder.D, 8);
    int i = c();
    if (i == 1)
    {
      o();
      return;
    }
    if (i == 2)
    {
      p();
      return;
    }
    m();
  }
  
  protected void i()
  {
    boolean bool1;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null) {
        bool1 = PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
      bool1 = false;
    }
    boolean bool2 = e();
    if ((!bool1) && (!bool2) && ((e() == 4) || (e() == 3)) && (d() >= 0) && (d() < 100))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 8);
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 0);
      a(e(), d());
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.C, 0);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.D, 8);
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (VideoItemHolder)paramView.getTag();
    Object localObject2 = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    int i = paramView.getId();
    localObject1 = "";
    if (i != 2131367447)
    {
      if (i != 2131367449)
      {
        if (i == 2131373735) {
          a(null);
        }
      }
      else
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
        if (paramView != null) {
          paramView.setAdClickPos(AdClickPos.SoftAdClickBtn);
        }
        try
        {
          i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s).intValue();
          if (i == 1) {
            break label394;
          }
          if (i == 3)
          {
            e();
          }
          else if (i == 6)
          {
            a(Long.valueOf(3050503L));
          }
          else
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
              return;
            }
            if (!a(1, (HashMap)localObject2, false))
            {
              this.jdField_b_of_type_Boolean = false;
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).addGdtWebClickReport(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
              localObject2 = FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.q, "");
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
              {
                paramView = GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3050103L, 9L, "", this.jdField_c_of_type_JavaLangString, "");
                localObject2 = ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 39, 119, (Integer)localObject2);
                ((AdReportData)localObject2).e(paramView);
                ((IRIJAdService)QRoute.api(IRIJAdService.class)).report((AdReportData)localObject2);
              }
            }
          }
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
        }
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
      if (paramView != null) {
        paramView.setAdClickPos(AdClickPos.SoftAdClickBtn);
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
          return;
        }
        if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.s).intValue() == 2)
        {
          boolean bool = a(1, (HashMap)localObject2, true);
          if (!bool)
          {
            this.jdField_b_of_type_Boolean = false;
            ReadInJoyAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
            a(1, FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedsGameAdComData.q, ""), (HashMap)localObject2);
          }
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
    label394:
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
    paramView = (View)localObject1;
    if (localObject2 != null)
    {
      paramView = (View)localObject1;
      if (!TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdViewId)) {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(26), String.valueOf(1), paramView, b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager
 * JD-Core Version:    0.7.0.1
 */