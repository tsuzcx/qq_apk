package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.SoftAdExpoStatManager;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.AdTagInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.VideoInfo.KdTagItem;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ShortVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdDialogUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.GiftPackageDialog.GiftGetListener;
import com.tencent.biz.pubaccount.util.ReadinJoyActionUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFeedsGameAdComManager
  implements View.OnClickListener, GiftPackageDialog.GiftGetListener
{
  private static final String jdField_a_of_type_JavaLangString = "Q.readinjoy.video." + VideoFeedsGameAdComManager.class.getSimpleName();
  private final int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ADBaseAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager;
  private VideoInfo.GameAdComData jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter;
  private VideoItemHolder jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder;
  private VideoFeedsGameAdComBarConfigure jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure;
  private VideoFeedsGameAdComManager.GameAdGiftInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo;
  private ADVideoAppDownloadData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData;
  private GiftPackageDialog jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private Set<String> jdField_b_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_b_of_type_Boolean = false;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  
  public VideoFeedsGameAdComManager(QQAppInterface paramQQAppInterface, Activity paramActivity, VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure = new VideoFeedsGameAdComBarConfigure(paramQQAppInterface);
    this.jdField_a_of_type_Int = DisplayUtil.a(paramActivity, 3.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager = new ADBaseAppDownloadManager(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a(new VideoFeedsGameAdComManager.1(this));
  }
  
  private void a(int paramInt, Integer paramInteger1, Integer paramInteger2, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mTitle;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "游戏组件上报 type = " + paramInt + " adTitle = " + str);
    paramHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
    NativeAdUtils.a(new AdReportData().a(this.jdField_a_of_type_AndroidAppActivity).a(paramInt).b(26).d(1).a(paramInteger1).b(paramInteger2).b(paramBoolean).d(NativeAdUtils.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mRowKey, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, paramHashMap)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo));
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
  
  private void a(VideoInfo.GameAdComData paramGameAdComData, VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder = paramVideoItemHolder;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if ((paramVideoItemHolder.t == null) && ((paramVideoItemHolder instanceof ShortVideoItemHolder)) && (paramVideoItemHolder.p != null))
    {
      paramVideoItemHolder.t = ((ViewGroup)((ViewStub)paramVideoItemHolder.p.findViewById(2131381379)).inflate());
      paramVideoItemHolder.e = ((URLImageView)paramVideoItemHolder.t.findViewById(2131367695));
      paramVideoItemHolder.A = ((TextView)paramVideoItemHolder.t.findViewById(2131367698));
      paramVideoItemHolder.B = ((TextView)paramVideoItemHolder.t.findViewById(2131367697));
      paramVideoItemHolder.C = ((TextView)paramVideoItemHolder.t.findViewById(2131367696));
      paramVideoItemHolder.D = ((TextView)paramVideoItemHolder.t.findViewById(2131367694));
    }
    if (paramVideoItemHolder.t != null)
    {
      paramVideoItemHolder.t.setVisibility(0);
      if (TextUtils.isEmpty(paramGameAdComData.j)) {}
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(paramGameAdComData.j, localURLDrawableOptions);
      localURLDrawable.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, this.jdField_a_of_type_Int));
      localURLDrawable.setDecodeHandler(URLDrawableDecodeHandler.k);
      if (paramVideoItemHolder.e != null) {
        paramVideoItemHolder.e.setImageDrawable(localURLDrawable);
      }
      b(paramVideoItemHolder.A, paramGameAdComData.jdField_c_of_type_JavaLangString);
      b(paramVideoItemHolder.B, paramGameAdComData.i);
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
      paramVideoItemHolder.t.setTag(2131381651, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
      h();
      b(paramVideoItemHolder);
      VideoFeedsHelper.a(paramVideoItemHolder.t, 200);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "后台下发的url格式有问题：" + paramGameAdComData.j);
        }
      }
    }
  }
  
  private boolean a(int paramInt, HashMap<String, Object> paramHashMap, boolean paramBoolean)
  {
    int i = 5;
    if (PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d))
    {
      f();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2"))
      {
        paramHashMap.put("download_state", "5");
        paramInt = 5;
      }
      a(paramInt, Integer.valueOf(15), paramHashMap);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      }
      return true;
    }
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      DownloadInfo localDownloadInfo = DownloadManagerV2.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      DownloadManagerV2.a().a(localDownloadInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
        break label316;
      }
      paramHashMap.put("download_state", "3");
    }
    for (;;)
    {
      a(i, Integer.valueOf(18), paramHashMap);
      if (paramBoolean)
      {
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      }
      return true;
      if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
      {
        d();
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s.equals("2")) {
          break label310;
        }
        paramHashMap.put("download_state", "3");
      }
      for (;;)
      {
        a(i, Integer.valueOf(18), paramHashMap);
        if (paramBoolean)
        {
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
        }
        return true;
        return false;
        label310:
        i = paramInt;
      }
      label316:
      i = paramInt;
    }
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
    Object localObject1 = "";
    Object localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("jump_page", 6);
      ((JSONObject)localObject2).put("jump_bus_type", 5);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(jdField_a_of_type_JavaLangString, 2, localException.getMessage());
    }
    return localObject1;
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
    Object localObject = HardCodeUtil.a(2131716079);
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData == null) {
      return;
    }
    int i = 0;
    try
    {
      int j = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool;
        String str;
      }
    }
    bool = ReadInJoyAdSwitchUtil.a();
    if (i == 1) {
      if (b())
      {
        str = BaseApplicationImpl.getContext().getResources().getString(2131718254);
        b(paramVideoItemHolder.C, Color.parseColor("#262626"));
        localObject = str;
        if (bool)
        {
          b(paramVideoItemHolder.C, Color.parseColor("#80000000"));
          localObject = str;
        }
        b(paramVideoItemHolder.C, null, null, null, null);
      }
    }
    for (;;)
    {
      b(paramVideoItemHolder.C, (CharSequence)localObject);
      return;
      if (bool) {}
      for (localObject = "预约";; localObject = HardCodeUtil.a(2131716012))
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
        }
        b(paramVideoItemHolder.C, -1);
        break;
      }
      if (i == 2)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d)) {
          break label518;
        }
        if (NativeAdUtils.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d))
        {
          if (bool) {}
          for (localObject = "打开";; localObject = HardCodeUtil.a(2131716042))
          {
            b(paramVideoItemHolder.C, -1);
            b(paramVideoItemHolder.C, null, null, null, null);
            b(paramVideoItemHolder.C, (CharSequence)localObject);
            return;
          }
        }
        if (bool)
        {
          str = "下载";
          label273:
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {
            str = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;
          }
          b(paramVideoItemHolder.C, -1);
          if (bool) {
            break label387;
          }
          localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130843097);
          b(paramVideoItemHolder.C, null, null, (Drawable)localObject, null);
        }
        for (;;)
        {
          b(paramVideoItemHolder.C, str);
          localObject = str;
          if (this.jdField_b_of_type_Boolean) {
            break;
          }
          localObject = str;
          if (this.jdField_c_of_type_Boolean) {
            break;
          }
          this.jdField_c_of_type_Boolean = true;
          b();
          return;
          str = HardCodeUtil.a(2131716010);
          break label273;
          label387:
          b(paramVideoItemHolder.C, null, null, null, null);
        }
      }
      if (!c()) {
        break label469;
      }
      str = HardCodeUtil.a(2131716009);
      b(paramVideoItemHolder.C, Color.parseColor("#262626"));
      localObject = str;
      if (bool)
      {
        b(paramVideoItemHolder.C, Color.parseColor("#80000000"));
        localObject = str;
      }
      b(paramVideoItemHolder.C, null, null, null, null);
    }
    label469:
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v)) {}
    for (localObject = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.v;; localObject = HardCodeUtil.a(2131715984))
    {
      b(paramVideoItemHolder.C, -1);
      break;
    }
  }
  
  private void c(VideoItemHolder paramVideoItemHolder)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.t != null)) {
      paramVideoItemHolder.t.setVisibility(8);
    }
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.j)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.i));
  }
  
  private boolean e()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)) {
      try
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
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
    return false;
  }
  
  private boolean f()
  {
    int i = 5;
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
    HashMap localHashMap = new HashMap();
    if (PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject))
    {
      f();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
      if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        break label193;
      }
      localHashMap.put("download_state", "5");
    }
    for (;;)
    {
      localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
      a(i, Integer.valueOf(15), localHashMap);
      return true;
      if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
      {
        localObject = DownloadManagerV2.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
        DownloadManagerV2.a().a((DownloadInfo)localObject);
        this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
        if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
          break label188;
        }
        localHashMap.put("download_state", "3");
      }
      for (;;)
      {
        localHashMap.put("vid", this.jdField_b_of_type_JavaLangString);
        a(i, Integer.valueOf(18), localHashMap);
        return true;
        return false;
        label188:
        i = 1;
      }
      label193:
      i = 1;
    }
  }
  
  private void k()
  {
    int i = 5;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 4)
        {
          a(4, d());
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int == 5)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d;
          if (PackageUtil.a(BaseApplicationImpl.getContext(), (String)localObject))
          {
            this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 1;
            a(1, d());
            return;
          }
          a(5, d());
          return;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int != 3);
      a(3, d());
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager == null));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    return;
    Object localObject = new HashMap();
    if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData))
    {
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
      if (!"2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        break label310;
      }
      ((HashMap)localObject).put("download_state", "3");
    }
    for (;;)
    {
      a(i, Integer.valueOf(18), (HashMap)localObject);
      return;
      c();
      ReadInJoyAdLog.a(jdField_a_of_type_JavaLangString, "queryCallback and download: appId is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.e);
      if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
        ((HashMap)localObject).put("download_state", "1");
      }
      for (;;)
      {
        a(i, Integer.valueOf(3), (HashMap)localObject);
        return;
        i = 1;
      }
      label310:
      i = 1;
    }
  }
  
  private void l()
  {
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 8);
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 0);
    if (!ReadInJoyAdSwitchUtil.a())
    {
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, HardCodeUtil.a(2131716045) + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, Color.parseColor("#262626"));
      return;
    }
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int + "%");
    b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, Color.parseColor("#80000000"));
  }
  
  private void m()
  {
    if (c())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D.setClickable(false);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(true);
    }
  }
  
  private void n()
  {
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo = new VideoFeedsGameAdComManager.GameAdGiftInfo(this, new JSONObject(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.u));
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(false);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D.setClickable(false);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(true);
    }
  }
  
  private void p()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_c_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D.setClickable(true);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      i();
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.t.setClickable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D.setClickable(false);
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a();
    }
  }
  
  protected void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if ((paramInt == 5) && ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)))
    {
      localHashMap.put("download_state", "2");
      a(5, null, null, localHashMap, false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2: 
    case 7: 
    default: 
    case 3: 
    case 5: 
    case 1: 
    case 4: 
      do
      {
        do
        {
          return;
          l();
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 8);
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 0);
          b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, Color.parseColor("#262626"));
        } while (!ReadInJoyAdSwitchUtil.a());
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, Color.parseColor("#80000000"));
        return;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, HardCodeUtil.a(2131715996));
        if (ReadInJoyAdSwitchUtil.a()) {
          b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, "安装");
        }
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, -1);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, null, null, null, null);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
        a(paramInt1);
        return;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, HardCodeUtil.a(2131715974));
        if (ReadInJoyAdSwitchUtil.a()) {
          b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, "打开");
        }
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, -1);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, null, null, null, null);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
        return;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 8);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 0);
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, HardCodeUtil.a(2131716065));
        b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, -1);
      } while (!ReadInJoyAdSwitchUtil.a());
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, "继续");
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, Color.parseColor("#80000000"));
      return;
    case 6: 
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131716055), 0).a();
      return;
    }
    k();
  }
  
  public void a(long paramLong)
  {
    if (("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo.a == paramLong)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C.post(new VideoFeedsGameAdComManager.2(this));
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration.orientation == 2) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog.a(paramConfiguration);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdViewGiftPackageDialog.dismiss();
    }
    this.jdField_b_of_type_Int = paramConfiguration.orientation;
  }
  
  public void a(VideoInfo paramVideoInfo, VideoItemHolder paramVideoItemHolder)
  {
    if (paramVideoItemHolder.d.getVisibility() == 0) {}
    do
    {
      do
      {
        return;
      } while (((paramVideoItemHolder.t != null) && (paramVideoItemHolder.t.getVisibility() == 0)) || ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) && (!d()) && (a(paramVideoInfo))));
      if ((paramVideoInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null))
      {
        if ("3".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s))
        {
          n();
          if (c())
          {
            this.jdField_b_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
            return;
          }
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData, paramVideoItemHolder);
        this.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_a_of_type_JavaLangString;
        Object localObject = new StringBuilder();
        if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.isEmpty()))
        {
          Iterator localIterator = paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo.a.iterator();
          while (localIterator.hasNext()) {
            ((StringBuilder)localObject).append(((VideoInfo.KdTagItem)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
          }
        }
        localObject = ((StringBuilder)localObject).toString();
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (localObject = "";; localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1))
        {
          this.jdField_c_of_type_JavaLangString = ((String)localObject);
          if (this.jdField_a_of_type_JavaUtilSet.contains(paramVideoInfo.jdField_a_of_type_JavaLangString)) {
            break;
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramVideoInfo.jdField_a_of_type_JavaLangString);
          SoftAdExpoStatManager.a().a(paramVideoItemHolder.getAdapterPosition());
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (!paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.isKolSoftAd())) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComBarConfigure.a();
          }
          if ((paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo != null)) {
            SoftAdExpoStatManager.a().a(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementSoftInfo.S);
          }
          paramVideoItemHolder = "";
          paramVideoInfo = paramVideoItemHolder;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            paramVideoInfo = paramVideoItemHolder;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
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
    } while ((paramVideoItemHolder.t == null) || (paramVideoItemHolder.t.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "默认不显示引流条");
    }
    paramVideoItemHolder.t.setVisibility(8);
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData = paramAdvertisementInfo.gameAdComData;
    if ("2".equals(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData = ADVideoAppDownloadData.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData);
    }
  }
  
  public void a(VideoItemHolder paramVideoItemHolder)
  {
    this.jdField_a_of_type_Boolean = false;
    c(paramVideoItemHolder);
  }
  
  public void a(boolean paramBoolean)
  {
    ReadInJoyAdDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.d, new VideoFeedsGameAdComManager.5(this, paramBoolean));
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public boolean a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if ((paramVideoItemHolder.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (paramVideoItemHolder.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mSoftAdType == 1) && (paramVideoItemHolder.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.gameAdComData != null))
    {
      a(paramVideoItemHolder.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
      if (!paramBoolean) {
        a(paramVideoItemHolder.a.a, paramVideoItemHolder);
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
      ReadInJoyAdLog.a(jdField_a_of_type_JavaLangString, "doQuery : appId is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_JavaLangString + " appName is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.e);
      return;
    }
    ReadInJoyAdLog.a(jdField_a_of_type_JavaLangString, "doQuery cancel, manager is " + this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager + " downloadData is " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected int c()
  {
    return Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D != null) {
      l();
    }
  }
  
  protected boolean c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo == null) {
      return false;
    }
    return GiftPackageManager.a(null, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdGame_componentVideoFeedsGameAdComManager$GameAdGiftInfo.a);
  }
  
  protected int d()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int;
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdUtilADBaseAppDownloadManager.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData);
    }
  }
  
  protected int e()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int;
  }
  
  public void e()
  {
    ThreadManager.executeOnNetWorkThread(new VideoFeedsGameAdComManager.3(this));
  }
  
  protected void f()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null))
    {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d))) {
        ReadInJoyAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
      }
    }
    else {
      return;
    }
    ReadinJoyActionUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mChannelID, true);
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_b_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.jdField_c_of_type_Int = 100;
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder == null) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
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
    try
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)
      {
        bool1 = PackageUtil.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData.d);
        boolean bool2 = e();
        if ((bool1) || (bool2) || ((e() != 4) && (e() != 3)) || (d() < 0) || (d() >= 100)) {
          break label118;
        }
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 8);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 0);
        a(e(), d());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        boolean bool1 = false;
      }
      label118:
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.C, 0);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideofeedsVideoItemHolder.D, 8);
    }
  }
  
  public void j()
  {
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData != null)) {
      b();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1 = (VideoItemHolder)paramView.getTag();
    localObject1 = new HashMap();
    this.jdField_b_of_type_Boolean = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      Object localObject2 = "";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
        }
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X8009377", "0X8009377", 0, 0, String.valueOf(26), String.valueOf(1), (String)localObject1, b());
      label141:
      label207:
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
          }
          try
          {
            int i = Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue();
            if (i == 1) {
              break;
            }
            if (i != 3) {
              break label207;
            }
            e();
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
          }
        }
        break;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null);
      if (!a(1, localException1, false))
      {
        this.jdField_b_of_type_Boolean = false;
        ReadInJoyAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        a(1, FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, ""), localException1);
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdClickBtn);
        }
        try
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadData == null) {
            break label141;
          }
          if (Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.s).intValue() != 2) {
            continue;
          }
          boolean bool = a(1, localException1, true);
          if (bool) {
            continue;
          }
          this.jdField_b_of_type_Boolean = false;
          ReadInJoyAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
          a(1, FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, ""), localException1);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        continue;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.setAdClickPos(AdClickPos.SoftAdComponent);
        }
        this.jdField_b_of_type_Boolean = false;
        ReadInJoyAdUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
        localObject2 = FastWeqAdUtils.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.p, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData.q, "");
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
        {
          JSONObject localJSONObject = GameComponentReport.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 3050107L, 9L, "", "");
          localObject2 = ReadInJoyAdReportUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 39, 119, (Integer)localObject2);
          ((AdReportData)localObject2).e(localJSONObject);
          NativeAdUtils.a((AdReportData)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager
 * JD-Core Version:    0.7.0.1
 */