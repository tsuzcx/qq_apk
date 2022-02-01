package com.tencent.biz.pubaccount.readinjoy.video;

import amtj;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
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
import bgoa;
import bkwm;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
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
import nwz;
import obw;
import obx;
import odq;
import ofa;
import ofb;
import ofc;
import ofe;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import pay;
import pbm;
import pkm;
import pkp;
import ptj;
import puw;
import puy;
import pvo;
import qxs;
import qxz;
import qyb;
import qye;
import qyf;
import rsn;
import rtr;
import rtv;
import rtx;
import ruw;
import rvi;
import rvk;
import rvl;
import rvn;
import rvs;
import rvu;
import rvv;
import rwa;
import rwf;
import rwp;
import rwv;
import rxo;
import rxs;
import rya;
import ryo;
import ryq;
import ryr;
import rys;
import ryt;
import ryu;
import ryv;
import ryw;
import ryx;
import ryy;
import ryz;
import rza;
import rzc;
import rzd;
import rze;
import rzf;
import rzg;
import rzh;
import rzi;
import rzk;
import rzm;
import rzo;
import rzt;
import rzv;
import sbp;
import sbt;
import scd;
import scw;
import sdj;
import seo;
import sex;
import sfo;
import sfq;
import sid;
import sie;
import tsf;
import twp;
import twq;
import txm;
import txu;
import txw;
import txx;
import uiw;
import uix;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements qyf, rtx, rvk, rzm, rzt
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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<puy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private obw jdField_a_of_type_Obw;
  private obx jdField_a_of_type_Obx;
  private ofa jdField_a_of_type_Ofa;
  private ofb jdField_a_of_type_Ofb;
  private ofc jdField_a_of_type_Ofc;
  private ptj jdField_a_of_type_Ptj;
  private pvo jdField_a_of_type_Pvo;
  private qxz jdField_a_of_type_Qxz;
  private qyb jdField_a_of_type_Qyb;
  private qye jdField_a_of_type_Qye;
  private rtv jdField_a_of_type_Rtv;
  private ruw jdField_a_of_type_Ruw;
  private rvv jdField_a_of_type_Rvv;
  private rwa jdField_a_of_type_Rwa;
  private rwf jdField_a_of_type_Rwf;
  private rwp jdField_a_of_type_Rwp;
  private rxo jdField_a_of_type_Rxo;
  private rya jdField_a_of_type_Rya;
  private ryq jdField_a_of_type_Ryq;
  private ryz jdField_a_of_type_Ryz;
  private rza jdField_a_of_type_Rza;
  private rzc jdField_a_of_type_Rzc;
  private rzd jdField_a_of_type_Rzd;
  private rzf jdField_a_of_type_Rzf;
  private rzg jdField_a_of_type_Rzg;
  private rzh jdField_a_of_type_Rzh;
  private rzk jdField_a_of_type_Rzk;
  private rzo jdField_a_of_type_Rzo;
  private sbp jdField_a_of_type_Sbp;
  private sbt jdField_a_of_type_Sbt;
  private scw jdField_a_of_type_Scw;
  private sfo jdField_a_of_type_Sfo;
  private tsf jdField_a_of_type_Tsf;
  private txm jdField_a_of_type_Txm;
  private txu jdField_a_of_type_Txu;
  private txx jdField_a_of_type_Txx;
  private uiw jdField_a_of_type_Uiw;
  private uix jdField_a_of_type_Uix;
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
    if ((this.jdField_a_of_type_Scw == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return rwv.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Scw.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
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
    if ((this.jdField_a_of_type_Rvv instanceof rvu))
    {
      rvu localrvu = (rvu)this.jdField_a_of_type_Rvv;
      ((rvu)this.jdField_a_of_type_Rvv).a.a(paramFloat, new ryt(this, localrvu));
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
      this.jdField_a_of_type_Pvo.a(paramList);
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("VideoFeedsRecommendFragment", 1, "fetchLiveStatus error:" + paramList);
    }
  }
  
  private void a(rvl paramrvl)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Rwa.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramrvl instanceof rvi))
      {
        bool1 = bool2;
        if ((paramrvl instanceof rvn))
        {
          bool1 = bool2;
          if (!((rvn)paramrvl).jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(rvv paramrvv, boolean paramBoolean)
  {
    if ((paramrvv != null) && (paramrvv.jdField_a_of_type_Ryo != null) && (paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        pbm.b(paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    pbm.c(paramrvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Rvv, false);
      seo.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Ruw != null) {
        this.jdField_a_of_type_Ruw.b(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)))) {
      this.jdField_a_of_type_Ofa.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
    if ((qxs.a()) && (!paramVideoInfo.jdField_c_of_type_Boolean))
    {
      pkm.a().k(paramVideoInfo.jdField_g_of_type_JavaLangString);
      pkm.a().j(paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
  }
  
  private void b(List<VideoInfo> paramList)
  {
    ryy localryy = new ryy(paramList);
    this.jdField_a_of_type_JavaUtilList.add(localryy);
    puw.a(a(paramList), localryy);
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
    this.jdField_f_of_type_Boolean = bkwm.e(this.jdField_d_of_type_Int);
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
        break label702;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label707;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = bkwm.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = pay.e();
      this.jdField_f_of_type_Int = ofe.a();
      this.jdField_a_of_type_Pvo = pkm.a().a();
      this.jdField_a_of_type_Rzd = new rzd(this, null);
      if (this.jdField_a_of_type_Pvo != null) {
        this.jdField_a_of_type_Pvo.a(this.jdField_a_of_type_Rzd);
      }
      if (bgoa.a() != 1) {
        break label712;
      }
      bool1 = true;
      label418:
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Ptj = new ryx(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = DisplayUtil.dip2px(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label717;
      }
    }
    label702:
    label707:
    label712:
    label717:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Rzf = new rzf(this, bool1);
      rzf.a(this.jdField_a_of_type_Rzf, localArrayList);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131380674));
      VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new rxs(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_Ryq = new rzi(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Ryq);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
      this.jdField_a_of_type_Rzo = new rzo(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Txm = new txm(getActivity().getApplicationContext());
      this.jdField_a_of_type_Txm.a(new ryr(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
      this.jdField_a_of_type_Ruw = new ruw(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_Rzo);
      this.jdField_a_of_type_Ruw.e(getUserVisibleHint());
      this.jdField_a_of_type_Ruw.a(this.jdField_e_of_type_Boolean);
      Object localObject = this.jdField_a_of_type_Ruw;
      if (this.jdField_f_of_type_Boolean) {}
      for (int i1 = 3;; i1 = 1)
      {
        ((ruw)localObject).c(i1);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Txm);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager);
        this.jdField_a_of_type_Ruw.a(this);
        this.jdField_a_of_type_Ruw.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
        this.jdField_a_of_type_Ruw.b(this.k);
        this.jdField_a_of_type_Ruw.c(this.h);
        this.jdField_a_of_type_Ruw.d(this.jdField_c_of_type_Boolean);
        this.jdField_a_of_type_Ruw.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Long);
        this.jdField_a_of_type_Ruw.a(this.jdField_g_of_type_JavaLangString);
        if (this.jdField_a_of_type_AndroidOsBundle != null) {}
        this.jdField_a_of_type_Rzh = new rzh(this, null);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Ruw);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rzc);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Rzh);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Rzh);
        this.jdField_a_of_type_Rwf = new ryv(this, null);
        this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364880));
        this.jdField_a_of_type_Rwa = new rwa(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Ruw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_c_of_type_AndroidViewViewGroup);
        this.jdField_a_of_type_Rwa.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Rwa.a(this.jdField_a_of_type_Rwf);
        if (this.h)
        {
          localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
          this.jdField_a_of_type_Rwa.a((AnchorData)localObject);
        }
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Rwa);
        this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        this.jdField_a_of_type_Rxo = new rxo(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ryq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Ruw, this.jdField_b_of_type_Boolean);
        this.jdField_a_of_type_Sbp = new sbp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Ruw);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Sbp);
        this.jdField_a_of_type_Tsf = new tsf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Ruw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Tsf);
        this.jdField_a_of_type_Sbt = new sbt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_Sbt.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Sbt);
        this.jdField_a_of_type_Rwp = new rwp();
        this.jdField_a_of_type_Rwp.a(new sex(getActivity(), getActivity().getAppRuntime(), this.jdField_b_of_type_AndroidViewViewGroup, true, this.h));
        this.jdField_a_of_type_Rwp.a(new sfq());
        this.jdField_a_of_type_Qye = new qye(getActivity(), this);
        this.jdField_a_of_type_Qyb = new qyb(getActivity(), this.jdField_a_of_type_Qye);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Qye);
        k();
        if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof FrameLayout))
        {
          this.jdField_a_of_type_Rza = new rza(this, null);
          this.jdField_a_of_type_Scw = new scw(getActivity(), (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Rza);
          this.jdField_a_of_type_Scw.a(false);
          this.jdField_a_of_type_Scw.a(this.jdField_a_of_type_Rza);
          this.jdField_a_of_type_Scw.a(this.jdField_a_of_type_Rza);
        }
        this.jdField_a_of_type_Rya = new rya(getActivity(), 1);
        this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Rya);
        this.jdField_a_of_type_Qxz = new qxz();
        this.jdField_a_of_type_Qxz.a(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
        seo.a().a(getActivity());
        rtr.a().a(true);
        rtr.a().a(2);
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370719));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(getActivity());
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(this.jdField_a_of_type_AndroidViewViewGroup.getPaddingLeft(), i1 + this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377271));
    if ((!e()) && (getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370707));
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      b(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Ofc = ((ofc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(90));
    this.jdField_a_of_type_Ofc.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Rzk = new rzk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ruw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rzk.a(this);
    this.jdField_a_of_type_Rzk.a(this.jdField_a_of_type_Ruw);
    this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Rzk);
    this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Rzk);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rzk);
    this.jdField_a_of_type_Ofa = ((ofa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(99));
    this.jdField_a_of_type_Ofb = new rze(this, null);
    this.jdField_a_of_type_Uiw = ((uiw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(126));
    this.jdField_a_of_type_Uix = new ryw(this, null);
    this.jdField_a_of_type_Obw = ((obw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(93));
    this.jdField_a_of_type_Obx = new ryu(this, null);
    this.jdField_a_of_type_Ryz = new ryz(this, null);
    this.jdField_a_of_type_Rzg = new rzg(this, null);
    s();
    this.jdField_a_of_type_Txx = new txx(this.jdField_a_of_type_Ruw, this.jdField_a_of_type_JavaUtilArrayList);
    m();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Rzf.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Ruw.a(i1);
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
    this.jdField_a_of_type_Txu = new txu(this.jdField_a_of_type_Ruw, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Txu.a(this.n);
    this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Txu);
    this.jdField_a_of_type_Rzo.a(this.jdField_a_of_type_Txu);
    this.jdField_a_of_type_Sfo = new sfo(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Rtv = new rtv(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ruw, this.jdField_a_of_type_Sfo, this);
    this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Rtv);
  }
  
  private void m()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      p();
      if ((this.jdField_a_of_type_Txx != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
        this.jdField_a_of_type_Txx.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(amtj.a(2131715239) + this.jdField_g_of_type_Boolean);
    } while (this.jdField_g_of_type_Boolean);
    p();
    this.jdField_a_of_type_Ruw.c(1);
    this.jdField_a_of_type_Ruw.a();
  }
  
  private void o()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Ofc != null) && (this.jdField_a_of_type_Rzk != null))
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
      this.jdField_a_of_type_Ofc.a(this.jdField_a_of_type_Rzk.a(), l1, this.jdField_a_of_type_Rzk.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Rzk.a());
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
  
  private void p()
  {
    long l2;
    Object localObject;
    long l1;
    if (this.jdField_a_of_type_Ofc != null)
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int <= 0) {
          break label173;
        }
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_Int;
      }
      for (;;)
      {
        this.jdField_g_of_type_Boolean = true;
        this.jdField_a_of_type_Ofc.a(this.jdField_a_of_type_Rzf, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_c_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet), this.jdField_a_of_type_AndroidOsBundle);
        return;
        label173:
        i1 = i2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) {
          i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;
        }
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
  
  private void q()
  {
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.a();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Ryz != null) {
      getActivity().addObserver(this.jdField_a_of_type_Ryz);
    }
    if (this.jdField_a_of_type_Rzf != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rzf);
    }
    if (this.jdField_a_of_type_Ofb != null) {
      getActivity().addObserver(this.jdField_a_of_type_Ofb);
    }
    if (this.jdField_a_of_type_Obx != null) {
      getActivity().addObserver(this.jdField_a_of_type_Obx);
    }
    if (this.jdField_a_of_type_Uix != null) {
      getActivity().addObserver(this.jdField_a_of_type_Uix);
    }
    if (this.jdField_a_of_type_Rzg != null) {
      pkp.a().a(this.jdField_a_of_type_Rzg);
    }
  }
  
  private void t()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Ryz);
    getActivity().removeObserver(this.jdField_a_of_type_Rzf);
    getActivity().removeObserver(this.jdField_a_of_type_Ofb);
    getActivity().removeObserver(this.jdField_a_of_type_Obx);
    getActivity().removeObserver(this.jdField_a_of_type_Uix);
    pkp.a().b(this.jdField_a_of_type_Rzg);
    puw localpuw = pkm.a().a();
    if (localpuw != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        puy localpuy = (puy)localIterator.next();
        if (localpuy != null) {
          localpuw.b(localpuy);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Pvo != null) {
      this.jdField_a_of_type_Pvo.b(this.jdField_a_of_type_Rzd);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.a();
    }
    if (this.jdField_a_of_type_Rzo != null) {
      this.jdField_a_of_type_Rzo.h();
    }
    seo.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Rxo != null) && (this.jdField_a_of_type_Rxo.a())) {
      this.jdField_a_of_type_Rxo.a();
    }
    if (this.jdField_a_of_type_Ruw != null) {
      this.jdField_a_of_type_Ruw.e();
    }
    if ((this.jdField_a_of_type_Txm != null) && (this.jdField_a_of_type_Txm.a()) && (this.jdField_a_of_type_Txm.a() != null) && (this.jdField_a_of_type_Ruw != null)) {
      this.jdField_a_of_type_Ruw.a(this.jdField_a_of_type_Txm.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Tsf != null) {
      this.jdField_a_of_type_Tsf.k();
    }
    if ((this.jdField_a_of_type_Rvv != null) && (this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo != null)) {
      a(this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.c();
    }
    a(this.jdField_a_of_type_Rvv, true);
    if (this.jdField_a_of_type_Txx != null) {
      this.jdField_a_of_type_Txx.c();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Rvv != null) {
      return this.jdField_a_of_type_Rvv.jdField_c_of_type_Int;
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
    this.jdField_a_of_type_Rzo.f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Rvv == null) {}
    long l1;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_Sdj;
      VideoInfo localVideoInfo = this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label359;
      }
      l1 = ((sdj)localObject).b();
      if (!this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Rxo != null) {
          this.jdField_a_of_type_Rxo.a((int)(paramLong / 1000.0D));
        }
        if (this.jdField_a_of_type_Sbp != null) {
          this.jdField_a_of_type_Sbp.a(localVideoInfo, this.jdField_a_of_type_Rvv, (int)(paramLong / 1000.0D), (int)(l1 / 1000.0D));
        }
        if (this.jdField_a_of_type_Rwp != null) {
          this.jdField_a_of_type_Rwp.a(this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo, paramLong, this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        }
        this.jdField_a_of_type_Rtv.a(this.jdField_a_of_type_Rvv, paramLong, l1);
      }
      if (this.jdField_a_of_type_Tsf != null) {
        this.jdField_a_of_type_Tsf.a(this.jdField_a_of_type_Rvv, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Sbt != null) {
        this.jdField_a_of_type_Sbt.a(this.jdField_a_of_type_Rvv, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
      }
      if ((this.jdField_a_of_type_Rzk != null) && (localObject != null)) {
        this.jdField_a_of_type_Rzk.a(((sdj)localObject).a(false));
      }
      if (this.jdField_a_of_type_Qyb != null) {
        this.jdField_a_of_type_Qyb.a(paramLong, l1, this.jdField_a_of_type_Rwa.a());
      }
      if ((!this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Txu == null)) {
        break;
      }
    } while (txw.a());
    Object localObject = this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    if ((twq.e((VideoAdInfo)localObject)) && (twq.a((VideoAdInfo)localObject)))
    {
      if (paramLong < l1 * 0.8D) {
        break label364;
      }
      twp.a("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
      this.jdField_a_of_type_Txu.a((VideoAdInfo)localObject, this.jdField_a_of_type_Rvv.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a((float)paramLong / (float)l1);
      return;
      label359:
      l1 = 0L;
      break;
      label364:
      if (paramLong >= l1 * 0.5D)
      {
        twp.a("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
        this.jdField_a_of_type_Txu.b(this.jdField_a_of_type_Rvv.jdField_c_of_type_Int);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof rvl)) {
      a((rvl)paramViewHolder);
    }
    if ((paramViewHolder instanceof rvv))
    {
      if (this.jdField_a_of_type_Sbp != null) {
        this.jdField_a_of_type_Sbp.a(this.jdField_a_of_type_Rvv);
      }
      if (this.jdField_a_of_type_Tsf != null) {
        this.jdField_a_of_type_Tsf.a((rvv)paramViewHolder);
      }
      if (this.jdField_a_of_type_Sbt != null) {
        this.jdField_a_of_type_Sbt.a(this.jdField_a_of_type_Rvv, (rvv)paramViewHolder);
      }
      this.jdField_a_of_type_Txm.a((rvv)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a((rvv)paramViewHolder);
      a(this.jdField_a_of_type_Rvv, false);
      this.jdField_a_of_type_Rvv = ((rvv)paramViewHolder);
      a(this.jdField_a_of_type_Rvv, true);
      if ((this.jdField_a_of_type_Rxo != null) && ((this.jdField_a_of_type_Rvv instanceof rvs))) {
        this.jdField_a_of_type_Rxo.a((rvs)this.jdField_a_of_type_Rvv, rzh.a(this.jdField_a_of_type_Rzh));
      }
      if (this.jdField_a_of_type_Rvv.jdField_c_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_Rwp != null) {
          this.jdField_a_of_type_Rwp.b(false);
        }
        q();
      }
      if (this.jdField_a_of_type_Rvv.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Rvv.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo != null) && (this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rvv.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
      this.jdField_a_of_type_Rtv.a(this.jdField_a_of_type_Rvv);
      this.jdField_a_of_type_Sfo.a(this.jdField_a_of_type_Rvv);
      if ((this.jdField_a_of_type_Qyb != null) && ((this.jdField_a_of_type_Rvv instanceof rvs))) {
        this.jdField_a_of_type_Qyb.a((rvs)this.jdField_a_of_type_Rvv);
      }
    }
    if (this.jdField_a_of_type_Rzc != null)
    {
      boolean bool = paramViewHolder instanceof rvi;
      this.jdField_a_of_type_Rzc.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.a(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      q();
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
          str1 = new sie(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
            break label232;
          }
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
          label148:
          odq.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Rvv instanceof rvn)) {
          this.jdField_a_of_type_Scw.a(this.jdField_a_of_type_Rza.a(this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
      }
    } while (this.jdField_a_of_type_Scw == null);
    paramBoolean = this.jdField_a_of_type_Scw.b();
    this.jdField_a_of_type_Scw.a();
    this.jdField_a_of_type_Scw.b();
    this.jdField_a_of_type_Rza.a(paramBoolean);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uiw != null) {
      this.jdField_a_of_type_Uiw.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    if (getActivity() != null) {
      QQToast.a(getActivity(), paramString, 0).a();
    }
  }
  
  public void a(rvv paramrvv) {}
  
  public void a(rzc paramrzc)
  {
    this.jdField_a_of_type_Rzc = paramrzc;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(false);
    a(this.jdField_a_of_type_Rvv);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null)
      {
        paramString.o = true;
        this.jdField_a_of_type_Ruw.b(paramString);
        pkm.a().k(paramString.jdField_g_of_type_JavaLangString);
        this.jdField_a_of_type_Qyb.a(paramInt);
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
      if ((this.jdField_a_of_type_Qye != null) && (this.jdField_a_of_type_Qye.b())) {
        return true;
      }
      if ((this.jdField_a_of_type_Rwa != null) && (this.jdField_a_of_type_Rwa.a()))
      {
        this.jdField_a_of_type_Rwa.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Rvv == null) || (this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    sie localsie = new sie(localVideoInfo);
    localsie.i(localVideoInfo.jdField_g_of_type_JavaLangString).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Rvv.jdField_b_of_type_Int).l(this.jdField_a_of_type_Rvv.jdField_c_of_type_Int);
    localsie.p(1).i(localVideoInfo.jdField_g_of_type_JavaLangString);
    odq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localsie.a().a(), false);
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Rvv != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        seo.a().a(paramInt);
        this.jdField_a_of_type_Rvv.jdField_a_of_type_Rsn.a(seo.a().a());
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
    if ((this.jdField_a_of_type_Rvv != null) && (this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo != null)) {
      return this.jdField_a_of_type_Rvv.jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    o();
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
    return false;
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
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Qye != null) && (this.jdField_a_of_type_Qye.b())) {
        return true;
      }
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    } while ((this.jdField_a_of_type_Rwa == null) || (!this.jdField_a_of_type_Rwa.a()));
    this.jdField_a_of_type_Rwa.h();
    return true;
  }
  
  public void d()
  {
    n();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Rzo.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Txm != null) {
      this.jdField_a_of_type_Txm.c();
    }
    a(this.jdField_a_of_type_Rvv, false);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Rwa != null) && (this.jdField_a_of_type_Rwa.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Txm != null) {
      this.jdField_a_of_type_Txm.d();
    }
    a(this.jdField_a_of_type_Rvv, true);
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
      a(this.jdField_a_of_type_Rvv);
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
            } while (this.jdField_a_of_type_Rwa == null);
            this.jdField_a_of_type_Rwa.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Ruw == null));
        paramIntent = this.jdField_a_of_type_Ruw.a(str);
      } while (paramIntent == null);
      paramIntent.jdField_f_of_type_Int += 1;
      this.jdField_a_of_type_Ruw.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131698823), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new rys(this, paramConfiguration);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)rzv.a(2131560359, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pay.a());
    i();
    j();
    l();
    if (this.jdField_a_of_type_Rzc != null) {
      this.jdField_a_of_type_Rzc.c();
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Ruw != null) {
      this.jdField_a_of_type_Ruw.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Txm != null)
    {
      this.jdField_a_of_type_Txm.a();
      this.jdField_a_of_type_Txm = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Txu != null)
    {
      this.jdField_a_of_type_Txu.a();
      this.jdField_a_of_type_Txu = null;
    }
    if (this.jdField_a_of_type_Txx != null)
    {
      this.jdField_a_of_type_Txx.e();
      this.jdField_a_of_type_Txu = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Rzk != null)
    {
      this.jdField_a_of_type_Rzk.a();
      this.jdField_a_of_type_Rzk = null;
    }
    if (this.jdField_a_of_type_Rxo != null)
    {
      this.jdField_a_of_type_Rxo.b();
      this.jdField_a_of_type_Rxo = null;
    }
    if (this.jdField_a_of_type_Sbp != null)
    {
      this.jdField_a_of_type_Sbp.a();
      this.jdField_a_of_type_Sbp = null;
    }
    if (this.jdField_a_of_type_Tsf != null)
    {
      this.jdField_a_of_type_Tsf.a();
      this.jdField_a_of_type_Tsf = null;
    }
    if (this.jdField_a_of_type_Sbt != null)
    {
      this.jdField_a_of_type_Sbt.a();
      this.jdField_a_of_type_Sbt = null;
    }
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.e();
    }
    if (this.jdField_a_of_type_Rtv != null) {
      this.jdField_a_of_type_Rtv.a();
    }
    if (this.jdField_a_of_type_Qye != null) {
      this.jdField_a_of_type_Qye.c();
    }
    if (this.jdField_a_of_type_Qyb != null) {
      this.jdField_a_of_type_Qyb.a();
    }
    if (this.jdField_a_of_type_Rwa != null) {
      this.jdField_a_of_type_Rwa.i();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      pbm.a(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          pbm.a(((VideoInfo)((Iterator)localObject).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_Rya != null)
    {
      this.jdField_a_of_type_Rya.a();
      this.jdField_a_of_type_Rya = null;
    }
    this.jdField_a_of_type_Rvv = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.b();
    }
    t();
    rtr.a().a();
    seo.a().b(getActivity());
    if (this.jdField_a_of_type_Rzo != null) {
      this.jdField_a_of_type_Rzo.c();
    }
    txw.b();
    txx.h();
    nwz.a().a("RIJAdRefreshSceneFloatVideo");
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    if (this.jdField_a_of_type_Qxz != null) {
      this.jdField_a_of_type_Qxz.b();
    }
    b(1);
    if (this.jdField_a_of_type_Rzo != null) {
      this.jdField_a_of_type_Rzo.g();
    }
    if (this.jdField_a_of_type_Txm != null) {
      this.jdField_a_of_type_Txm.b();
    }
    if (this.jdField_a_of_type_Scw != null) {
      this.jdField_a_of_type_Scw.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.b();
    }
    if (this.jdField_a_of_type_Txx != null) {
      this.jdField_a_of_type_Txx.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      u();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnStop()");
    b(2);
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      u();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ruw != null) {
        this.jdField_a_of_type_Ruw.e(paramBoolean);
      }
      return;
      b(2);
    }
  }
  
  public void y_()
  {
    if (QLog.isColorLevel()) {
      pay.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */