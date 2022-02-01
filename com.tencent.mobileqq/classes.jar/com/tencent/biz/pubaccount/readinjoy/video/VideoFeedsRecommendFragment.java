package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import anvx;
import bhyk;
import bmhv;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import odz;
import ojn;
import ojo;
import olh;
import omt;
import omu;
import omv;
import omx;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import pkh;
import pkn;
import pqu;
import pvj;
import pvm;
import qeg;
import qfq;
import qfs;
import qgo;
import rjy;
import rkf;
import rkh;
import rkk;
import rkl;
import sfc;
import sgg;
import sgk;
import sgm;
import shl;
import shw;
import sib;
import sih;
import sir;
import six;
import sjq;
import sju;
import skc;
import skq;
import sks;
import skt;
import sku;
import skv;
import skw;
import skx;
import sky;
import skz;
import sla;
import slb;
import slc;
import sld;
import slf;
import slg;
import slh;
import sli;
import slj;
import slk;
import sll;
import sln;
import slp;
import slr;
import slx;
import sma;
import snv;
import snz;
import soh;
import spa;
import spn;
import sqt;
import src;
import srt;
import srv;
import sut;
import suu;
import swi;
import swj;
import swm;
import swr;
import swt;
import swu;
import uet;
import ugq;
import ukg;
import ukq;
import ukr;
import uli;
import ulq;
import uls;
import ult;
import ulv;
import uwt;
import uwu;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements rkl, sgm, shw, slp, slx
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  private TKDCommentDispatcher.HippyCommentEvent jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent = new skw(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<qfs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private ojn jdField_a_of_type_Ojn;
  private ojo jdField_a_of_type_Ojo;
  private omt jdField_a_of_type_Omt;
  private omu jdField_a_of_type_Omu;
  private omv jdField_a_of_type_Omv;
  private qeg jdField_a_of_type_Qeg;
  private qgo jdField_a_of_type_Qgo;
  private rkf jdField_a_of_type_Rkf;
  private rkh jdField_a_of_type_Rkh;
  private rkk jdField_a_of_type_Rkk;
  private sgk jdField_a_of_type_Sgk;
  private shl jdField_a_of_type_Shl;
  private sib jdField_a_of_type_Sib;
  private sih jdField_a_of_type_Sih;
  private sir jdField_a_of_type_Sir;
  private sjq jdField_a_of_type_Sjq;
  private skc jdField_a_of_type_Skc;
  private sks jdField_a_of_type_Sks;
  private slc jdField_a_of_type_Slc;
  private sld jdField_a_of_type_Sld;
  private slf jdField_a_of_type_Slf;
  private slg jdField_a_of_type_Slg;
  private sli jdField_a_of_type_Sli;
  private slj jdField_a_of_type_Slj;
  private slk jdField_a_of_type_Slk;
  private sln jdField_a_of_type_Sln;
  private slr jdField_a_of_type_Slr;
  private snv jdField_a_of_type_Snv;
  private snz jdField_a_of_type_Snz;
  private spa jdField_a_of_type_Spa;
  private srt jdField_a_of_type_Srt;
  private swu jdField_a_of_type_Swu;
  private ugq jdField_a_of_type_Ugq;
  private uli jdField_a_of_type_Uli;
  private ulq jdField_a_of_type_Ulq;
  private ult jdField_a_of_type_Ult;
  private ulv jdField_a_of_type_Ulv;
  private uwt jdField_a_of_type_Uwt;
  private uwu jdField_a_of_type_Uwu;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 5;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString3);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putString("ARGS_PAGE_SESSION_ID", paramString2);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_Spa == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return six.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Spa.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
  }
  
  private List<Long> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((VideoInfo)paramList.next()).j;
      try
      {
        localArrayList.add(Long.valueOf(Long.parseLong(str)));
      }
      catch (Throwable localThrowable)
      {
        QLog.e("VideoFeedsRecommendFragment", 1, "convert2LongList pass uin:" + str + " for e:" + localThrowable);
      }
    }
    return localArrayList;
  }
  
  private void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_Swu instanceof swt))
    {
      swt localswt = (swt)this.jdField_a_of_type_Swu;
      ((swt)this.jdField_a_of_type_Swu).a.a(paramFloat, new skv(this, localswt));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
  
  private void a(List<VideoInfo> paramList)
  {
    try
    {
      paramList = a(paramList);
      this.jdField_a_of_type_Qgo.a(paramList);
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("VideoFeedsRecommendFragment", 1, "fetchLiveStatus error:" + paramList);
    }
  }
  
  private void a(swj paramswj)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Sib.b()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramswj instanceof swi))
      {
        bool1 = bool2;
        if ((paramswj instanceof swm))
        {
          bool1 = bool2;
          if (!((swm)paramswj).jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(swu paramswu, boolean paramBoolean)
  {
    if ((paramswu != null) && (paramswu.jdField_a_of_type_Skq != null) && (paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        pkn.b(paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    pkn.c(paramswu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getScrollState() != 0) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (LinearLayoutManager)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager();
      int i1 = ((LinearLayoutManager)localObject1).findFirstVisibleItemPosition();
      int i2 = ((LinearLayoutManager)localObject1).findLastVisibleItemPosition();
      localObject1 = null;
      if (i1 < i2)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getLayoutManager().findViewByPosition(i1);
        if (localObject2 == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.getChildViewHolder((View)localObject2);
          if (i1 == paramInt) {
            localObject1 = localObject2;
          }
          if (localObject2 != null) {
            if ((localObject2 instanceof swj))
            {
              localObject2 = ((swj)localObject2).a;
              if (localObject2 != null) {
                ((VideoFeedsAlphaMaskView)localObject2).setAlpha(0.0F);
              }
            }
          }
        }
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d()) || (localObject1 == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a((RecyclerView.ViewHolder)localObject1);
    ukg.a(getActivity(), this.jdField_a_of_type_Swu);
    ukg.b(getActivity(), this.jdField_a_of_type_Swu);
    this.jdField_a_of_type_Shl.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)))) {
      this.jdField_a_of_type_Omt.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
    if ((rjy.a()) && (!paramVideoInfo.jdField_c_of_type_Boolean))
    {
      pvj.a().k(paramVideoInfo.jdField_g_of_type_JavaLangString);
      pvj.a().j(paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
  }
  
  private void b(List<VideoInfo> paramList)
  {
    if (this.o)
    {
      QLog.w("VideoFeedsRecommendFragment", 1, "fetchFollowStatus cancel for activity is destroyed.");
      return;
    }
    slb localslb = new slb(paramList);
    this.jdField_a_of_type_JavaUtilList.add(localslb);
    qfq.a(a(paramList), localslb);
  }
  
  private void c(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Swu, false);
      sqt.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Shl != null) {
        this.jdField_a_of_type_Shl.b(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
  }
  
  private void i()
  {
    boolean bool2 = true;
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_SESSION_ID");
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.jdField_f_of_type_Boolean = bmhv.e(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("FIRST_VIDEO_TOKEN", "");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label272:
    label295:
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.j = bool1;
      if (this.j) {
        break label712;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label717;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = bmhv.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = pqu.a();
      this.jdField_f_of_type_Int = omx.a();
      this.jdField_a_of_type_Qgo = pvj.a().a();
      this.jdField_a_of_type_Slg = new slg(this, null);
      if (this.jdField_a_of_type_Qgo != null) {
        this.jdField_a_of_type_Qgo.a(this.jdField_a_of_type_Slg);
      }
      if (bhyk.a() != 1) {
        break label722;
      }
      bool1 = true;
      label418:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Qeg = new sla(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = DisplayUtil.dip2px(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label727;
      }
    }
    label712:
    label717:
    label722:
    label727:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Sli = new sli(this, bool1);
      sli.a(this.jdField_a_of_type_Sli, localArrayList);
      TKDCommentDispatcher.INSTANCE.addEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoFromType = " + this.jdField_d_of_type_Int);
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoDataList[0] = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() needReloadTitle = " + this.jdField_e_of_type_Boolean + ", showSingleVideo = " + this.jdField_f_of_type_Boolean + ", mFirstVideoStartPosition = " + this.jdField_a_of_type_Long + ", mFirstVideoToken:" + this.jdField_g_of_type_JavaLangString);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label272;
      bool1 = false;
      break label295;
      bool1 = false;
      break label418;
    }
  }
  
  private void j()
  {
    try
    {
      if (VersionUtils.isIceScreamSandwich()) {
        getActivity().getWindow().setFlags(16777216, 16777216);
      }
      label22:
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131381023));
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new sju(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_Sks = new sll(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Sks);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(this.n);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.h);
      this.jdField_a_of_type_Slr = new slr(getActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Uli = new uli(getActivity().getApplicationContext());
      this.jdField_a_of_type_Uli.a(new skt(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
      this.jdField_a_of_type_Shl = new shl(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_Slr);
      this.jdField_a_of_type_Shl.e(getUserVisibleHint());
      this.jdField_a_of_type_Shl.a(this.jdField_e_of_type_Boolean);
      Object localObject = this.jdField_a_of_type_Shl;
      if (this.jdField_f_of_type_Boolean) {}
      for (int i1 = 3;; i1 = 1)
      {
        ((shl)localObject).c(i1);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Uli);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager);
        this.jdField_a_of_type_Shl.a(this);
        this.jdField_a_of_type_Shl.b(this.k);
        this.jdField_a_of_type_Shl.c(this.h);
        this.jdField_a_of_type_Shl.d(this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_Shl.b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Shl.a(this.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_Slk = new slk(this, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Shl);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Slf);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Slk);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Slk);
        this.jdField_a_of_type_Sih = new sky(this, null);
        this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364968));
        this.jdField_a_of_type_Sib = new sib(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Shl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_c_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_Sib.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Sib.a(this.jdField_a_of_type_Sih);
        if (this.h)
        {
          localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
          this.jdField_a_of_type_Sib.a((AnchorData)localObject);
        }
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Sib);
        this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        this.jdField_a_of_type_Sjq = new sjq(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sks, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Shl, this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_Snv = new snv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Shl);
        this.jdField_a_of_type_Ugq = new ugq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Shl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_Snz = new snz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_Snz.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Sir = new sir();
        this.jdField_a_of_type_Sir.a(new src(getActivity(), getActivity().getAppRuntime(), this.jdField_b_of_type_AndroidViewViewGroup, true, this.h));
        this.jdField_a_of_type_Sir.a(new srv());
        this.jdField_a_of_type_Rkk = new rkk(getActivity(), this);
        this.jdField_a_of_type_Rkh = new rkh(getActivity(), this.jdField_a_of_type_Rkk);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Rkk);
        k();
        if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof FrameLayout))
        {
          this.jdField_a_of_type_Sld = new sld(this, null);
          this.jdField_a_of_type_Spa = new spa(getActivity(), (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Sld);
          this.jdField_a_of_type_Spa.a(false);
          this.jdField_a_of_type_Spa.a(this.jdField_a_of_type_Sld);
          this.jdField_a_of_type_Spa.a(this.jdField_a_of_type_Sld);
        }
        this.jdField_a_of_type_Skc = new skc(getActivity(), 1);
        this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Skc);
        this.jdField_a_of_type_Rkf = new rkf();
        this.jdField_a_of_type_Rkf.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        sqt.a().a(getActivity());
        sgg.a().a(true);
        sgg.a().a(2);
        return;
      }
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370904));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(getActivity());
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i1 + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377544));
    if ((!d()) && (getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370892));
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      b(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Omv = ((omv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.jdField_a_of_type_Omv.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Sln = new sln(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Shl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Sln.a(this);
    this.jdField_a_of_type_Sln.a(this.jdField_a_of_type_Shl);
    this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Sln);
    this.jdField_a_of_type_Slr.a(this.jdField_a_of_type_Sln);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Sln);
    this.jdField_a_of_type_Omt = ((omt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYCOUNT_HANDLER));
    this.jdField_a_of_type_Omu = new slh(this, null);
    this.jdField_a_of_type_Uwt = ((uwt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN));
    this.jdField_a_of_type_Uwu = new skz(this, null);
    this.jdField_a_of_type_Ojn = ((ojn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.jdField_a_of_type_Ojo = new skx(this, null);
    this.jdField_a_of_type_Slc = new slc(this, null);
    this.jdField_a_of_type_Slj = new slj(this, null);
    t();
    this.jdField_a_of_type_Ult = new ult(this.jdField_a_of_type_Shl, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Ulv = new ulv(this.jdField_a_of_type_Shl, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ult);
    m();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Sli.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Shl.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = ContactUtils.getBuddyName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoInfo);
    a(localArrayList);
    this.jdField_a_of_type_Ulq = new ulq(this.jdField_a_of_type_Shl, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ulq.a(this.n);
    this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Ulq);
    this.jdField_a_of_type_Slr.a(this.jdField_a_of_type_Ulq);
    this.jdField_a_of_type_Srt = new srt(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Sgk = new sgk(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Shl, this.jdField_a_of_type_Srt, this);
    this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Sgk);
  }
  
  private void m()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      q();
      if ((this.jdField_a_of_type_Ult != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
        this.jdField_a_of_type_Ult.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
    }
  }
  
  private void n()
  {
    if ((this.n) && (this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo != null) && (this.jdField_a_of_type_Ulq != null)) {
      if ((ukr.e(this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!this.jdField_a_of_type_Ulq.a(this.jdField_a_of_type_Swu.jdField_c_of_type_Int)))
      {
        localVideoInfo = this.jdField_a_of_type_Ulq.a(this.jdField_a_of_type_Swu.jdField_c_of_type_Int);
        if (localVideoInfo != null)
        {
          i1 = this.jdField_a_of_type_Swu.getAdapterPosition() - 1;
          i2 = this.jdField_a_of_type_Swu.jdField_c_of_type_Int;
          this.jdField_a_of_type_Ulq.a(i1, i2, localVideoInfo);
          ukg.a(getActivity(), 50, true);
        }
      }
    }
    while ((this.jdField_a_of_type_Sks == null) || (this.jdField_a_of_type_Swu == null))
    {
      VideoInfo localVideoInfo;
      int i1;
      int i2;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsRecommendFragment.2(this, i1 + 1), 0L);
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.c();
      return;
    }
    this.jdField_a_of_type_Sks.b(this.jdField_a_of_type_Swu.jdField_a_of_type_Skq);
  }
  
  private void o()
  {
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(anvx.a(2131715587) + this.jdField_g_of_type_Boolean);
    } while (this.jdField_g_of_type_Boolean);
    q();
    this.jdField_a_of_type_Shl.c(1);
    this.jdField_a_of_type_Shl.a();
  }
  
  private void p()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Omv != null) && (this.jdField_a_of_type_Sln != null))
    {
      l2 = this.jdField_c_of_type_Long;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_Omv.a(this.jdField_a_of_type_Sln.a(), l1, this.jdField_a_of_type_Sln.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Sln.a());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void q()
  {
    long l2;
    Object localObject;
    long l1;
    if (this.jdField_a_of_type_Omv != null)
    {
      l2 = this.jdField_c_of_type_Long;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localObject == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
      localObject = a();
      int i2 = 0;
      int i1 = i2;
      omv localomv;
      sli localsli;
      VideoInfo localVideoInfo;
      int i3;
      ArrayList localArrayList1;
      String str1;
      String str2;
      String str3;
      int i4;
      byte[] arrayOfByte;
      ArrayList localArrayList2;
      Bundle localBundle;
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int > 0) {
          i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int;
        }
      }
      else
      {
        this.jdField_g_of_type_Boolean = true;
        localomv = this.jdField_a_of_type_Omv;
        localsli = this.jdField_a_of_type_Sli;
        localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        i3 = this.jdField_d_of_type_Int;
        localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
        str1 = ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i;
        l2 = this.jdField_b_of_type_Long;
        str2 = this.jdField_b_of_type_JavaLangString;
        str3 = this.jdField_c_of_type_JavaLangString;
        i4 = this.jdField_c_of_type_Int;
        arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilHashSet);
        localBundle = this.jdField_a_of_type_AndroidOsBundle;
        if (this.jdField_a_of_type_Swu != null) {
          break label263;
        }
      }
      label263:
      for (i2 = 0;; i2 = this.jdField_a_of_type_Swu.jdField_c_of_type_Int)
      {
        localomv.a(localsli, l1, localVideoInfo, i3, localArrayList1, str1, l2, true, i1, str2, str3, null, i4, (String)localObject, arrayOfByte, 0, localArrayList2, localBundle, i2);
        return;
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
          break;
        }
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        break;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Sir != null) {
      this.jdField_a_of_type_Sir.a();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Sir != null) {
      this.jdField_a_of_type_Sir.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Slc != null) {
      getActivity().addObserver(this.jdField_a_of_type_Slc);
    }
    if (this.jdField_a_of_type_Sli != null) {
      getActivity().addObserver(this.jdField_a_of_type_Sli);
    }
    if (this.jdField_a_of_type_Omu != null) {
      getActivity().addObserver(this.jdField_a_of_type_Omu);
    }
    if (this.jdField_a_of_type_Ojo != null) {
      getActivity().addObserver(this.jdField_a_of_type_Ojo);
    }
    if (this.jdField_a_of_type_Uwu != null) {
      getActivity().addObserver(this.jdField_a_of_type_Uwu);
    }
    if (this.jdField_a_of_type_Slj != null) {
      pvm.a().a(this.jdField_a_of_type_Slj);
    }
  }
  
  private void u()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Slc);
    getActivity().removeObserver(this.jdField_a_of_type_Sli);
    getActivity().removeObserver(this.jdField_a_of_type_Omu);
    getActivity().removeObserver(this.jdField_a_of_type_Ojo);
    getActivity().removeObserver(this.jdField_a_of_type_Uwu);
    pvm.a().b(this.jdField_a_of_type_Slj);
    qfq localqfq = pvj.a().a();
    if (localqfq != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        qfs localqfs = (qfs)localIterator.next();
        if (localqfs != null) {
          localqfq.b(localqfs);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Qgo != null) {
      this.jdField_a_of_type_Qgo.b(this.jdField_a_of_type_Slg);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.a();
    }
    if (this.jdField_a_of_type_Slr != null) {
      this.jdField_a_of_type_Slr.h();
    }
    sqt.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d();
    }
    if ((this.jdField_a_of_type_Sjq != null) && (this.jdField_a_of_type_Sjq.a())) {
      this.jdField_a_of_type_Sjq.a();
    }
    if (this.jdField_a_of_type_Shl != null) {
      this.jdField_a_of_type_Shl.e();
    }
    if ((this.jdField_a_of_type_Uli != null) && (this.jdField_a_of_type_Uli.a()) && (this.jdField_a_of_type_Uli.a() != null) && (this.jdField_a_of_type_Shl != null)) {
      this.jdField_a_of_type_Shl.a(this.jdField_a_of_type_Uli.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Ugq != null) {
      this.jdField_a_of_type_Ugq.k();
    }
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq != null)) {
      a(this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.c();
    }
    a(this.jdField_a_of_type_Swu, true);
    if (this.jdField_a_of_type_Ult != null) {
      this.jdField_a_of_type_Ult.c();
    }
    if (this.jdField_a_of_type_Ulv != null) {
      this.jdField_a_of_type_Ulv.a();
    }
    if (this.jdField_a_of_type_Snz != null) {
      this.jdField_a_of_type_Snz.a();
    }
    if ((this.jdField_a_of_type_Swu instanceof swi))
    {
      if (((swi)this.jdField_a_of_type_Swu).a != null) {
        ((swi)this.jdField_a_of_type_Swu).a.a();
      }
      if (((swi)this.jdField_a_of_type_Swu).b != null) {
        ((swi)this.jdField_a_of_type_Swu).b.a();
      }
    }
  }
  
  public void A_()
  {
    if (QLog.isColorLevel()) {
      pqu.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    o();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Swu != null) {
      return this.jdField_a_of_type_Swu.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Slr.f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Swu == null) {}
    long l1;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_Spn;
      VideoInfo localVideoInfo = this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label365;
      }
      l1 = ((spn)localObject).b();
      if (!this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Sjq != null) {
          this.jdField_a_of_type_Sjq.a((int)(paramLong / 1000.0D));
        }
        if (this.jdField_a_of_type_Snv != null) {
          this.jdField_a_of_type_Snv.a(localVideoInfo, this.jdField_a_of_type_Swu, (int)(paramLong / 1000.0D), (int)(l1 / 1000.0D));
        }
        if (this.jdField_a_of_type_Sir != null) {
          this.jdField_a_of_type_Sir.a(this.jdField_a_of_type_Swu.jdField_a_of_type_Skq, paramLong, this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        }
        this.jdField_a_of_type_Sgk.a(this.jdField_a_of_type_Swu, paramLong, l1);
      }
      if (this.jdField_a_of_type_Ugq != null) {
        this.jdField_a_of_type_Ugq.a(this.jdField_a_of_type_Swu, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Snz != null) {
        this.jdField_a_of_type_Snz.a(this.jdField_a_of_type_Swu, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
      }
      if ((this.jdField_a_of_type_Sln != null) && (localObject != null)) {
        this.jdField_a_of_type_Sln.a(((spn)localObject).a(false));
      }
      if (this.jdField_a_of_type_Rkh != null) {
        this.jdField_a_of_type_Rkh.a(paramLong, l1, this.jdField_a_of_type_Sib.b());
      }
      if ((!this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Ulq == null)) {
        break;
      }
    } while ((uls.a()) && (uls.b()));
    Object localObject = this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    if ((ukr.e((VideoAdInfo)localObject)) && (ukr.a((VideoAdInfo)localObject)))
    {
      if (paramLong < l1 * 0.8D) {
        break label370;
      }
      ukq.a("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
      this.jdField_a_of_type_Ulq.a((VideoAdInfo)localObject, this.jdField_a_of_type_Swu.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a((float)paramLong / (float)l1);
      return;
      label365:
      l1 = 0L;
      break;
      label370:
      if (paramLong >= l1 * 0.5D)
      {
        ukq.a("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
        this.jdField_a_of_type_Ulq.b(this.jdField_a_of_type_Swu.jdField_c_of_type_Int);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof swj)) {
      a((swj)paramViewHolder);
    }
    if ((paramViewHolder instanceof swu))
    {
      if (this.jdField_a_of_type_Snv != null) {
        this.jdField_a_of_type_Snv.a(this.jdField_a_of_type_Swu);
      }
      if (this.jdField_a_of_type_Ugq != null) {
        this.jdField_a_of_type_Ugq.a((swu)paramViewHolder);
      }
      if (this.jdField_a_of_type_Snz != null) {
        this.jdField_a_of_type_Snz.a(this.jdField_a_of_type_Swu, (swu)paramViewHolder);
      }
      this.jdField_a_of_type_Uli.a((swu)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a((swu)paramViewHolder);
      if ((paramViewHolder instanceof swi))
      {
        if (((swi)paramViewHolder).a != null) {
          ((swi)paramViewHolder).a.a();
        }
        if (((swi)paramViewHolder).b != null) {
          ((swi)paramViewHolder).b.a();
        }
      }
      a(this.jdField_a_of_type_Swu, false);
      this.jdField_a_of_type_Swu = ((swu)paramViewHolder);
      a(this.jdField_a_of_type_Swu, true);
      if ((this.jdField_a_of_type_Sjq != null) && ((this.jdField_a_of_type_Swu instanceof swr))) {
        this.jdField_a_of_type_Sjq.a((swr)this.jdField_a_of_type_Swu, slk.a(this.jdField_a_of_type_Slk));
      }
      if (this.jdField_a_of_type_Swu.jdField_c_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_Sir != null) {
          this.jdField_a_of_type_Sir.b(false);
        }
        r();
      }
      if (this.jdField_a_of_type_Swu.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Swu.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Swu.jdField_a_of_type_Skq != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Swu.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
      this.jdField_a_of_type_Sgk.a(this.jdField_a_of_type_Swu);
      this.jdField_a_of_type_Srt.a(this.jdField_a_of_type_Swu);
      if ((this.jdField_a_of_type_Rkh != null) && ((this.jdField_a_of_type_Swu instanceof swr))) {
        this.jdField_a_of_type_Rkh.a((swr)this.jdField_a_of_type_Swu);
      }
    }
    if (this.jdField_a_of_type_Slf != null)
    {
      boolean bool = paramViewHolder instanceof swi;
      this.jdField_a_of_type_Slf.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Sir != null) {
      this.jdField_a_of_type_Sir.a(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      r();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
      {
        paramViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
        if (paramViewHolder != null)
        {
          if ((paramViewHolder.jdField_a_of_type_Int != 0) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label227;
          }
          str1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
          label78:
          str1 = new suu(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
            break label232;
          }
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
          label148:
          olh.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(false);
        }
        if ((this.jdField_a_of_type_Swu instanceof swm)) {
          this.jdField_a_of_type_Spa.a(this.jdField_a_of_type_Sld.a(this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
        }
      }
    }
    label227:
    label232:
    do
    {
      return;
      paramViewHolder = null;
      break;
      str1 = null;
      break label78;
      paramViewHolder = "0";
      break label148;
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f(this.n);
      }
    } while (this.jdField_a_of_type_Spa == null);
    paramBoolean = this.jdField_a_of_type_Spa.b();
    this.jdField_a_of_type_Spa.a();
    this.jdField_a_of_type_Spa.b();
    this.jdField_a_of_type_Sld.a(paramBoolean);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uwt != null) {
      this.jdField_a_of_type_Uwt.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    if (getActivity() != null) {
      QQToast.a(getActivity(), paramString, 0).a();
    }
  }
  
  public void a(slf paramslf)
  {
    this.jdField_a_of_type_Slf = paramslf;
  }
  
  public void a(swu paramswu) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
    a(this.jdField_a_of_type_Swu);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null)
      {
        paramString.o = true;
        this.jdField_a_of_type_Shl.a(paramString);
        pvj.a().k(paramString.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_Rkh.a(paramInt);
      }
    }
    while (getActivity() == null) {
      return;
    }
    QQToast.a(getActivity(), paramString, 0).a();
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Rkk != null) && (this.jdField_a_of_type_Rkk.b())) {
        return true;
      }
      if ((this.jdField_a_of_type_Sib != null) && (this.jdField_a_of_type_Sib.b()))
      {
        this.jdField_a_of_type_Sib.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Swu == null) || (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    suu localsuu = new suu(localVideoInfo);
    localsuu.i(localVideoInfo.jdField_g_of_type_JavaLangString).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Swu.jdField_b_of_type_Int).l(this.jdField_a_of_type_Swu.jdField_c_of_type_Int);
    localsuu.p(1).i(localVideoInfo.jdField_g_of_type_JavaLangString);
    olh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localsuu.a().a(), false);
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Swu != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        sqt.a().a(paramInt);
        this.jdField_a_of_type_Swu.jdField_a_of_type_Sfc.a(sqt.a().a());
        return true;
      }
    }
    return false;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
    }
    return 0L;
  }
  
  public VideoInfo b()
  {
    if ((this.jdField_a_of_type_Swu != null) && (this.jdField_a_of_type_Swu.jdField_a_of_type_Skq != null)) {
      return this.jdField_a_of_type_Swu.jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    p();
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    while (this.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean b()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Rkk != null) && (this.jdField_a_of_type_Rkk.b())) {
        return true;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    } while ((this.jdField_a_of_type_Sib == null) || (!this.jdField_a_of_type_Sib.b()));
    this.jdField_a_of_type_Sib.h();
    return true;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void c() {}
  
  public void c(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Slr.a();
  }
  
  public void d()
  {
    o();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Sib != null) && (this.jdField_a_of_type_Sib.b());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Uli != null) {
      this.jdField_a_of_type_Uli.c();
    }
    a(this.jdField_a_of_type_Swu, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Uli != null) {
      this.jdField_a_of_type_Uli.d();
    }
    a(this.jdField_a_of_type_Swu, true);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      a(this.jdField_a_of_type_Swu);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_Sib == null);
            this.jdField_a_of_type_Sib.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Shl == null));
        paramIntent = this.jdField_a_of_type_Shl.a(str);
      } while (paramIntent == null);
      paramIntent.jdField_f_of_type_Int += 1;
      this.jdField_a_of_type_Shl.a(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131699167), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new sku(this, paramConfiguration);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)sma.a(2131560409, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pkh.a());
    i();
    j();
    l();
    if (this.jdField_a_of_type_Slf != null) {
      this.jdField_a_of_type_Slf.c();
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    this.o = true;
    if (this.jdField_a_of_type_Shl != null) {
      this.jdField_a_of_type_Shl.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Uli != null)
    {
      this.jdField_a_of_type_Uli.a();
      this.jdField_a_of_type_Uli = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Ulq != null)
    {
      this.jdField_a_of_type_Ulq.a();
      this.jdField_a_of_type_Ulq = null;
    }
    if (this.jdField_a_of_type_Ult != null)
    {
      this.jdField_a_of_type_Ult.e();
      this.jdField_a_of_type_Ulq = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Sln != null)
    {
      this.jdField_a_of_type_Sln.a();
      this.jdField_a_of_type_Sln = null;
    }
    if (this.jdField_a_of_type_Sjq != null)
    {
      this.jdField_a_of_type_Sjq.b();
      this.jdField_a_of_type_Sjq = null;
    }
    if (this.jdField_a_of_type_Snv != null)
    {
      this.jdField_a_of_type_Snv.a();
      this.jdField_a_of_type_Snv = null;
    }
    if (this.jdField_a_of_type_Ugq != null)
    {
      this.jdField_a_of_type_Ugq.a();
      this.jdField_a_of_type_Ugq = null;
    }
    if (this.jdField_a_of_type_Snz != null)
    {
      this.jdField_a_of_type_Snz.c();
      this.jdField_a_of_type_Snz = null;
    }
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.e();
    }
    if (this.jdField_a_of_type_Sgk != null) {
      this.jdField_a_of_type_Sgk.a();
    }
    if (this.jdField_a_of_type_Rkk != null) {
      this.jdField_a_of_type_Rkk.c();
    }
    if (this.jdField_a_of_type_Rkh != null) {
      this.jdField_a_of_type_Rkh.a();
    }
    if (this.jdField_a_of_type_Sib != null) {
      this.jdField_a_of_type_Sib.i();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      pkn.a(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          pkn.a(((VideoInfo)((Iterator)localObject).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_Skc != null)
    {
      this.jdField_a_of_type_Skc.a();
      this.jdField_a_of_type_Skc = null;
    }
    this.jdField_a_of_type_Swu = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Sir != null) {
      this.jdField_a_of_type_Sir.b();
    }
    u();
    sgg.a().a();
    sqt.a().b(getActivity());
    if (this.jdField_a_of_type_Slr != null) {
      this.jdField_a_of_type_Slr.c();
    }
    uls.b();
    ult.h();
    if (this.jdField_a_of_type_Ulv != null) {
      this.jdField_a_of_type_Ulv.d();
    }
    odz.a().a("RIJAdRefreshSceneFloatVideo");
    uet.a.a();
    TKDCommentDispatcher.INSTANCE.removeEventListener(this.jdField_a_of_type_ComTencentHippyQqUtilsTkdTKDCommentDispatcher$HippyCommentEvent);
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    if (this.jdField_a_of_type_Rkf != null) {
      this.jdField_a_of_type_Rkf.b();
    }
    c(1);
    if (this.jdField_a_of_type_Slr != null) {
      this.jdField_a_of_type_Slr.g();
    }
    if (this.jdField_a_of_type_Uli != null) {
      this.jdField_a_of_type_Uli.b();
    }
    if (this.jdField_a_of_type_Spa != null) {
      this.jdField_a_of_type_Spa.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.b();
    }
    if (this.jdField_a_of_type_Ult != null) {
      this.jdField_a_of_type_Ult.d();
    }
    if (this.jdField_a_of_type_Ulv != null) {
      this.jdField_a_of_type_Ulv.c();
    }
    if (this.jdField_a_of_type_Snz != null) {
      this.jdField_a_of_type_Snz.b();
    }
    if ((this.jdField_a_of_type_Swu instanceof swi))
    {
      if (((swi)this.jdField_a_of_type_Swu).a != null) {
        ((swi)this.jdField_a_of_type_Swu).a.b();
      }
      if (((swi)this.jdField_a_of_type_Swu).b != null) {
        ((swi)this.jdField_a_of_type_Swu).b.b();
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      v();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnStop()");
    c(2);
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      v();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Shl != null) {
        this.jdField_a_of_type_Shl.e(paramBoolean);
      }
      return;
      c(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */