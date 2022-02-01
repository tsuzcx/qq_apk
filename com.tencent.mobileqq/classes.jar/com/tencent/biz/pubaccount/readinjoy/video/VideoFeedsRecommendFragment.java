package com.tencent.biz.pubaccount.readinjoy.video;

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
import anni;
import bggq;
import bglf;
import bhhb;
import bmqa;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import nyq;
import nyr;
import oat;
import ocd;
import oce;
import ocf;
import och;
import omz;
import oqh;
import oqi;
import org;
import org.json.JSONObject;
import orj;
import orl;
import orm;
import pha;
import pho;
import pvp;
import rur;
import rvt;
import rvx;
import rvz;
import rwy;
import rxl;
import rxn;
import rxo;
import rxq;
import rxv;
import rxy;
import ryd;
import ryi;
import ryr;
import ryx;
import rzp;
import rzt;
import sab;
import sar;
import sat;
import sau;
import sav;
import saw;
import sax;
import say;
import saz;
import sba;
import sbb;
import sbc;
import sbe;
import sbf;
import sbg;
import sbh;
import sbi;
import sbk;
import sbm;
import sbo;
import sbt;
import sbu;
import sbv;
import sby;
import sdq;
import sdu;
import see;
import sef;
import seo;
import sfb;
import sgc;
import sgp;
import shg;
import shi;
import skb;
import skc;
import uce;
import ucf;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements rvz, rxn, sbm, sbt, sef
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private nyq jdField_a_of_type_Nyq;
  private nyr jdField_a_of_type_Nyr;
  private ocd jdField_a_of_type_Ocd;
  private oce jdField_a_of_type_Oce;
  private ocf jdField_a_of_type_Ocf;
  private omz jdField_a_of_type_Omz;
  private org jdField_a_of_type_Org;
  private orj jdField_a_of_type_Orj;
  private orm jdField_a_of_type_Orm;
  private pvp jdField_a_of_type_Pvp;
  private rvx jdField_a_of_type_Rvx;
  private rwy jdField_a_of_type_Rwy;
  private rxy jdField_a_of_type_Rxy;
  private ryd jdField_a_of_type_Ryd;
  private ryi jdField_a_of_type_Ryi;
  private ryr jdField_a_of_type_Ryr;
  private rzp jdField_a_of_type_Rzp;
  private sab jdField_a_of_type_Sab;
  private sat jdField_a_of_type_Sat;
  private sbb jdField_a_of_type_Sbb;
  private sbc jdField_a_of_type_Sbc;
  private sbe jdField_a_of_type_Sbe;
  private sbg jdField_a_of_type_Sbg;
  private sbh jdField_a_of_type_Sbh;
  private sbk jdField_a_of_type_Sbk;
  private sbo jdField_a_of_type_Sbo;
  private sbu jdField_a_of_type_Sbu;
  private sbv jdField_a_of_type_Sbv;
  private sdq jdField_a_of_type_Sdq;
  private sdu jdField_a_of_type_Sdu;
  private see jdField_a_of_type_See;
  private seo jdField_a_of_type_Seo;
  private shg jdField_a_of_type_Shg;
  private uce jdField_a_of_type_Uce;
  private ucf jdField_a_of_type_Ucf;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
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
    if ((this.jdField_a_of_type_Seo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return ryx.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Seo.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoInfo.w))) {
      RIJRedPacketManager.a().a(paramVideoInfo.jdField_g_of_type_JavaLangString, paramVideoInfo.w, 4, new sav(this, paramVideoInfo, paramInt));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
  
  private void a(rxo paramrxo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Ryd.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramrxo instanceof rxl))
      {
        bool1 = bool2;
        if ((paramrxo instanceof rxq))
        {
          bool1 = bool2;
          if (!((rxq)paramrxo).jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(rxy paramrxy, boolean paramBoolean)
  {
    if ((paramrxy != null) && (paramrxy.jdField_a_of_type_Sar != null) && (paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        pho.b(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    pho.c(paramrxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Rxy, false);
      sgc.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Rwy != null) {
        this.jdField_a_of_type_Rwy.b(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString))) {
        this.jdField_a_of_type_Ocd.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(paramVideoInfo.j)) {
        a(paramVideoInfo);
      }
    }
  }
  
  private void j()
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
    this.jdField_f_of_type_Boolean = bmqa.e(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("FIRST_VIDEO_TOKEN", "");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label272:
    label295:
    label377:
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.j = bool1;
      if (this.j) {
        break label704;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label709;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = bmqa.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = pha.e();
      this.jdField_f_of_type_Int = och.a();
      if (bhhb.a() != 1) {
        break label714;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Pvp = new sba(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = bggq.a(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label719;
      }
    }
    label704:
    label709:
    label714:
    label719:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Sbg = new sbg(this, bool1);
      sbg.a(this.jdField_a_of_type_Sbg, localArrayList);
      if ((RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e()) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int >= 100))) {
        a(0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
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
      break label377;
    }
  }
  
  private void k()
  {
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380771));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new rzt(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Sat = new sbi(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Sat);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Sbo = new sbo(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Org = new org(getActivity().getApplicationContext());
    this.jdField_a_of_type_Org.a(new sau(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Rwy = new rwy(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_Sbo);
    this.jdField_a_of_type_Rwy.e(getUserVisibleHint());
    this.jdField_a_of_type_Rwy.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Rwy;
    int i1;
    if (this.jdField_f_of_type_Boolean)
    {
      i1 = 3;
      ((rwy)localObject).c(i1);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Org);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Rwy.a(this);
      this.jdField_a_of_type_Rwy.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_Rwy.b(this.k);
      this.jdField_a_of_type_Rwy.c(this.h);
      this.jdField_a_of_type_Rwy.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Rwy.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Rwy.a(this.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Sbh = new sbh(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Rwy);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Sbe);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Sbh);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Sbh);
      this.jdField_a_of_type_Ryi = new say(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364805));
      this.jdField_a_of_type_Ryd = new ryd(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Rwy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Ryd.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Ryd.a(this.jdField_a_of_type_Ryi);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Ryd.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Ryd);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_See = new see(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup, this, this.jdField_b_of_type_Boolean, i1, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_See);
      this.jdField_a_of_type_Rzp = new rzp(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Sat, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Rwy, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Sdq = new sdq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Rwy);
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Sdq);
      if (this.jdField_a_of_type_Omz == null) {
        this.jdField_a_of_type_Omz = new omz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Rwy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Omz);
      if (this.jdField_a_of_type_Sdu == null) {
        this.jdField_a_of_type_Sdu = new sdu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Sdu);
      this.jdField_a_of_type_Ryr = new ryr();
      this.jdField_a_of_type_Ryr.a(new sgp(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h));
      this.jdField_a_of_type_Ryr.a(new shi());
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Sbc = new sbc(this, null);
        this.jdField_a_of_type_Seo = new seo(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Sbc);
        this.jdField_a_of_type_Seo.a(false);
        this.jdField_a_of_type_Seo.a(this.jdField_a_of_type_Sbc);
        this.jdField_a_of_type_Seo.a(this.jdField_a_of_type_Sbc);
      }
      if (this.jdField_a_of_type_Sab == null)
      {
        this.jdField_a_of_type_Sab = new sab(getActivity(), 1);
        this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Sab);
      }
      sgc.a().a(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1172;
      }
      sgc.a().d(true);
    }
    for (;;)
    {
      sgc.a().a(sgc.a().a(true), "init view set mute itself FromMutiVideo", 2);
      rvt.a().a(true);
      rvt.a().a(2);
      return;
      i1 = 1;
      break;
      label1172:
      sgc.a().d(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Ocf = ((ocf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Ocf.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Sbk = new sbk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Rwy, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Sbk.a(this);
    this.jdField_a_of_type_Sbk.a(this.jdField_a_of_type_Rwy);
    this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Sbk);
    this.jdField_a_of_type_Sbo.a(this.jdField_a_of_type_Sbk);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Sbk);
    this.jdField_a_of_type_Ocd = ((ocd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Oce = new sbf(this, null);
    this.jdField_a_of_type_Uce = ((uce)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Ucf = new saz(this, null);
    this.jdField_a_of_type_Nyq = ((nyq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Nyr = new sax(this, null);
    this.jdField_a_of_type_Sbb = new sbb(this, null);
    s();
    m();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Sbg.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Rwy.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = bglf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Orj = new orj(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Orj.a(this.n);
    this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Orj);
    this.jdField_a_of_type_Sbo.a(this.jdField_a_of_type_Orj);
    this.jdField_a_of_type_Orm = new orm(this.jdField_a_of_type_Rwy, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Shg = new shg();
    this.jdField_a_of_type_Rvx = new rvx(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Rwy, this.jdField_a_of_type_Shg, this);
    this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Rvx);
  }
  
  private void m()
  {
    if (!this.jdField_f_of_type_Boolean) {
      p();
    }
  }
  
  private void n()
  {
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(anni.a(2131714896) + this.jdField_g_of_type_Boolean);
    } while (this.jdField_g_of_type_Boolean);
    p();
    this.jdField_a_of_type_Rwy.c(1);
    this.jdField_a_of_type_Rwy.a();
  }
  
  private void o()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Ocf != null) && (this.jdField_a_of_type_Sbk != null))
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
      this.jdField_a_of_type_Ocf.a(this.jdField_a_of_type_Sbk.a(), l1, this.jdField_a_of_type_Sbk.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Sbk.a());
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
    if (this.jdField_a_of_type_Ocf != null)
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
        this.jdField_a_of_type_Ocf.a(this.jdField_a_of_type_Sbg, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_c_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet), this.jdField_a_of_type_AndroidOsBundle);
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
    if (this.jdField_a_of_type_Ryr != null) {
      this.jdField_a_of_type_Ryr.a();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Ryr != null) {
      this.jdField_a_of_type_Ryr.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Sbb != null) {
      getActivity().addObserver(this.jdField_a_of_type_Sbb);
    }
    if (this.jdField_a_of_type_Sbg != null) {
      getActivity().addObserver(this.jdField_a_of_type_Sbg);
    }
    if (this.jdField_a_of_type_Oce != null) {
      getActivity().addObserver(this.jdField_a_of_type_Oce);
    }
    if (this.jdField_a_of_type_Nyr != null) {
      getActivity().addObserver(this.jdField_a_of_type_Nyr);
    }
    if (this.jdField_a_of_type_Ucf != null) {
      getActivity().addObserver(this.jdField_a_of_type_Ucf);
    }
  }
  
  private void t()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Sbb);
    getActivity().removeObserver(this.jdField_a_of_type_Sbg);
    getActivity().removeObserver(this.jdField_a_of_type_Oce);
    getActivity().removeObserver(this.jdField_a_of_type_Nyr);
    getActivity().removeObserver(this.jdField_a_of_type_Ucf);
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_See != null) && (this.jdField_a_of_type_See.a())) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Sbo != null) {
        this.jdField_a_of_type_Sbo.h();
      }
      sgc.a().a(true, "videoFeeds doOnResume");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
      }
      if ((this.jdField_a_of_type_Rzp != null) && (this.jdField_a_of_type_Rzp.a())) {
        this.jdField_a_of_type_Rzp.a();
      }
      if (this.jdField_a_of_type_Rwy != null) {
        this.jdField_a_of_type_Rwy.e();
      }
      if ((this.jdField_a_of_type_Org != null) && (this.jdField_a_of_type_Org.a()) && (this.jdField_a_of_type_Org.a() != null) && (this.jdField_a_of_type_Rwy != null)) {
        this.jdField_a_of_type_Rwy.a(this.jdField_a_of_type_Org.a());
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a();
      }
      if (this.jdField_a_of_type_Omz != null) {
        this.jdField_a_of_type_Omz.k();
      }
      if ((this.jdField_a_of_type_Rxy != null) && (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar != null)) {
        a(this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if (this.jdField_a_of_type_Seo != null) {
        this.jdField_a_of_type_Seo.c();
      }
      a(this.jdField_a_of_type_Rxy, true);
    } while (this.jdField_a_of_type_Orm == null);
    this.jdField_a_of_type_Orm.c();
  }
  
  public void D_()
  {
    if (QLog.isColorLevel()) {
      pha.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Rxy != null) {
      return this.jdField_a_of_type_Rxy.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoInfo a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      return (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public VideoInfo a(View paramView)
  {
    b(1);
    return b();
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Sbo.f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Rxy == null) {}
    long l1;
    label332:
    do
    {
      return;
      Object localObject = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_Sfb;
      VideoInfo localVideoInfo = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject != null) {}
      for (l1 = ((sfb)localObject).b();; l1 = 0L)
      {
        if (!this.jdField_d_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Rzp != null) {
            this.jdField_a_of_type_Rzp.a((int)(paramLong / 1000.0D));
          }
          if (this.jdField_a_of_type_Sdq != null) {
            this.jdField_a_of_type_Sdq.a(localVideoInfo, this.jdField_a_of_type_Rxy, (int)(paramLong / 1000.0D), (int)(l1 / 1000.0D));
          }
          if (this.jdField_a_of_type_Ryr != null) {
            this.jdField_a_of_type_Ryr.a(this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar, paramLong, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
          }
          this.jdField_a_of_type_Rvx.a(this.jdField_a_of_type_Rxy, paramLong, l1);
        }
        if (this.jdField_a_of_type_Omz != null) {
          this.jdField_a_of_type_Omz.a(this.jdField_a_of_type_Rxy, this.jdField_d_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Sdu != null) {
          this.jdField_a_of_type_Sdu.a(this.jdField_a_of_type_Rxy, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
        }
        if ((this.jdField_a_of_type_Sbk != null) && (localObject != null)) {
          this.jdField_a_of_type_Sbk.a(((sfb)localObject).a(false));
        }
        if ((!this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Orj == null) || (orl.a())) {
          break;
        }
        localObject = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
        if ((!oqi.e((VideoAdInfo)localObject)) || (!oqi.a((VideoAdInfo)localObject))) {
          break;
        }
        if (paramLong < l1 * 0.8D) {
          break label332;
        }
        oqh.a("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
        this.jdField_a_of_type_Orj.a((VideoAdInfo)localObject, this.jdField_a_of_type_Rxy.jdField_c_of_type_Int);
        return;
      }
    } while (paramLong < l1 * 0.5D);
    oqh.a("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
    this.jdField_a_of_type_Orj.b(this.jdField_a_of_type_Rxy.jdField_c_of_type_Int);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof rxo)) {
      a((rxo)paramViewHolder);
    }
    if ((paramViewHolder instanceof rxy))
    {
      if (this.jdField_a_of_type_Sdq != null) {
        this.jdField_a_of_type_Sdq.a(this.jdField_a_of_type_Rxy);
      }
      if (this.jdField_a_of_type_Omz != null) {
        this.jdField_a_of_type_Omz.a((rxy)paramViewHolder);
      }
      if (this.jdField_a_of_type_Sdu != null) {
        this.jdField_a_of_type_Sdu.a(this.jdField_a_of_type_Rxy, (rxy)paramViewHolder);
      }
      this.jdField_a_of_type_Org.a((rxy)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.a((rxy)paramViewHolder);
      a(this.jdField_a_of_type_Rxy, false);
      this.jdField_a_of_type_Rxy = ((rxy)paramViewHolder);
      a(this.jdField_a_of_type_Rxy, true);
      if ((this.jdField_a_of_type_Rzp != null) && ((this.jdField_a_of_type_Rxy instanceof rxv))) {
        this.jdField_a_of_type_Rzp.a((rxv)this.jdField_a_of_type_Rxy, sbh.a(this.jdField_a_of_type_Sbh));
      }
      if (((this.jdField_a_of_type_See == null) || (this.jdField_a_of_type_Rxy == null) || (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar == null)) || (this.jdField_a_of_type_Rxy.jdField_c_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_Ryr != null) {
          this.jdField_a_of_type_Ryr.b(false);
        }
        q();
      }
      if (this.jdField_a_of_type_Rxy.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Rxy.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rxy.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
        if (this.jdField_a_of_type_Sbv != null) {
          this.jdField_a_of_type_Sbv.a(localVideoInfo);
        }
      }
      this.jdField_a_of_type_Rvx.a(this.jdField_a_of_type_Rxy);
      this.jdField_a_of_type_Shg.a(this.jdField_a_of_type_Rxy);
    }
    if (this.jdField_a_of_type_Sbe != null)
    {
      boolean bool = paramViewHolder instanceof rxl;
      this.jdField_a_of_type_Sbe.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Ryr != null) {
      this.jdField_a_of_type_Ryr.a(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      q();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
      {
        paramViewHolder = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a();
        if (paramViewHolder != null)
        {
          if ((paramViewHolder.jdField_a_of_type_Int != 0) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label218;
          }
          str1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
          label69:
          str1 = new skc(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
          label139:
          oat.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Rxy instanceof rxq)) {
          this.jdField_a_of_type_Seo.a(this.jdField_a_of_type_Sbc.a(this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
        }
      }
    }
    label218:
    label223:
    do
    {
      return;
      paramViewHolder = null;
      break;
      str1 = null;
      break label69;
      paramViewHolder = "0";
      break label139;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
      }
    } while (this.jdField_a_of_type_Seo == null);
    paramBoolean = this.jdField_a_of_type_Seo.b();
    this.jdField_a_of_type_Seo.a();
    this.jdField_a_of_type_Seo.b();
    this.jdField_a_of_type_Sbc.a(paramBoolean);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uce != null) {
      this.jdField_a_of_type_Uce.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(rxy paramrxy) {}
  
  public void a(sbe paramsbe)
  {
    this.jdField_a_of_type_Sbe = paramsbe;
  }
  
  public void a(sbu paramsbu)
  {
    this.jdField_a_of_type_Sbu = paramsbu;
  }
  
  public void a(sbv paramsbv)
  {
    this.jdField_a_of_type_Sbv = paramsbv;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      u();
    }
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Ryd != null) && (this.jdField_a_of_type_Ryd.a()))
      {
        this.jdField_a_of_type_Ryd.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Rxy == null) || (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    skc localskc = new skc(localVideoInfo);
    localskc.h(localVideoInfo.jdField_g_of_type_JavaLangString).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Rxy.jdField_b_of_type_Int).l(this.jdField_a_of_type_Rxy.jdField_c_of_type_Int);
    localskc.o(1).h(localVideoInfo.jdField_g_of_type_JavaLangString);
    oat.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localskc.a().a(), false);
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
      return bool;
    }
    if ((this.jdField_a_of_type_Rxy != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        sgc.a().a(paramInt);
        if (this.jdField_a_of_type_Rxy == null) {
          break;
        }
        this.jdField_a_of_type_Rxy.jdField_a_of_type_Rur.a(sgc.a().a());
        return true;
      }
    }
    return false;
  }
  
  public VideoInfo b()
  {
    if ((this.jdField_a_of_type_Rxy != null) && (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar != null)) {
      return this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    o();
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    if (((this.jdField_a_of_type_Rxy instanceof rxv)) && (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar != null) && (this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_Rxy.jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      this.jdField_a_of_type_Rvx.a(localVideoInfo, (rxv)this.jdField_a_of_type_Rxy, 2);
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public boolean c()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.b();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    } while ((this.jdField_a_of_type_Ryd == null) || (!this.jdField_a_of_type_Ryd.a()));
    this.jdField_a_of_type_Ryd.h();
    return true;
  }
  
  public void d()
  {
    n();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Sbo.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Org != null) {
      this.jdField_a_of_type_Org.c();
    }
    a(this.jdField_a_of_type_Rxy, false);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Ryd != null) && (this.jdField_a_of_type_Ryd.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Org != null) {
      this.jdField_a_of_type_Org.d();
    }
    a(this.jdField_a_of_type_Rxy, true);
  }
  
  public void g()
  {
    b(1);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      a(this.jdField_a_of_type_Rxy);
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
            } while (this.jdField_a_of_type_Ryd == null);
            this.jdField_a_of_type_Ryd.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Rwy == null));
        paramIntent = this.jdField_a_of_type_Rwy.a(str);
      } while (paramIntent == null);
      paramIntent.jdField_f_of_type_Int += 1;
      this.jdField_a_of_type_Rwy.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131698481), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new saw(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)sby.a(2131560340, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)pha.a());
    j();
    k();
    l();
    if (this.jdField_a_of_type_Sbe != null) {
      this.jdField_a_of_type_Sbe.c();
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Rwy != null) {
      this.jdField_a_of_type_Rwy.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Org != null)
    {
      this.jdField_a_of_type_Org.a();
      this.jdField_a_of_type_Org = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Orj != null)
    {
      this.jdField_a_of_type_Orj.a();
      this.jdField_a_of_type_Orj = null;
    }
    if (this.jdField_a_of_type_Orm != null)
    {
      this.jdField_a_of_type_Orm.e();
      this.jdField_a_of_type_Orj = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Sbk != null)
    {
      this.jdField_a_of_type_Sbk.a();
      this.jdField_a_of_type_Sbk = null;
    }
    if (this.jdField_a_of_type_Rzp != null)
    {
      this.jdField_a_of_type_Rzp.b();
      this.jdField_a_of_type_Rzp = null;
    }
    if (this.jdField_a_of_type_Sdq != null)
    {
      this.jdField_a_of_type_Sdq.a();
      this.jdField_a_of_type_Sdq = null;
    }
    if (this.jdField_a_of_type_Omz != null)
    {
      this.jdField_a_of_type_Omz.a();
      this.jdField_a_of_type_Omz = null;
    }
    if (this.jdField_a_of_type_Sdu != null)
    {
      this.jdField_a_of_type_Sdu.a();
      this.jdField_a_of_type_Sdu = null;
    }
    if (this.jdField_a_of_type_Seo != null) {
      this.jdField_a_of_type_Seo.e();
    }
    if (this.jdField_a_of_type_Rvx != null) {
      this.jdField_a_of_type_Rvx.a();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      pho.a(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        while (((Iterator)localObject).hasNext()) {
          pho.a(((VideoInfo)((Iterator)localObject).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_Sab != null)
    {
      this.jdField_a_of_type_Sab.a();
      this.jdField_a_of_type_Sab = null;
    }
    this.jdField_a_of_type_Rxy = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Ryr != null) {
      this.jdField_a_of_type_Ryr.b();
    }
    t();
    rvt.a().a();
    sgc.a().b(getActivity());
    if (this.jdField_a_of_type_Sbo != null) {
      this.jdField_a_of_type_Sbo.c();
    }
    orl.b();
    orm.h();
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Sbo != null) {
      this.jdField_a_of_type_Sbo.g();
    }
    if (this.jdField_a_of_type_Org != null) {
      this.jdField_a_of_type_Org.b();
    }
    if (this.jdField_a_of_type_Seo != null) {
      this.jdField_a_of_type_Seo.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdVideoADVideoAppDownloadManager.b();
    }
    if (this.jdField_a_of_type_Orm != null) {
      this.jdField_a_of_type_Orm.d();
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
      if (this.jdField_a_of_type_Rwy != null) {
        this.jdField_a_of_type_Rwy.e(paramBoolean);
      }
      return;
      b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */