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
import anzj;
import bhgr;
import bhlg;
import bihq;
import bnrf;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
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
import oal;
import oam;
import ocd;
import odn;
import odo;
import odp;
import odr;
import org.json.JSONObject;
import ozs;
import pag;
import pob;
import ppo;
import rln;
import rmp;
import rmt;
import rmv;
import rnu;
import rog;
import roi;
import roj;
import rol;
import roq;
import ros;
import rot;
import roy;
import rpd;
import rpn;
import rpt;
import rqm;
import rqq;
import rqy;
import rrm;
import rro;
import rrp;
import rrq;
import rrr;
import rrs;
import rrt;
import rru;
import rrv;
import rrw;
import rrx;
import rry;
import rsa;
import rsb;
import rsc;
import rsd;
import rse;
import rsg;
import rsi;
import rsk;
import rsp;
import rsr;
import rul;
import rup;
import ruz;
import rvs;
import rwf;
import rxk;
import rxt;
import ryk;
import rym;
import sbf;
import sbg;
import tmk;
import tpx;
import tpz;
import tqy;
import trb;
import trd;
import tre;
import ucg;
import uch;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements rmv, roi, rsi, rsp
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private oal jdField_a_of_type_Oal;
  private oam jdField_a_of_type_Oam;
  private odn jdField_a_of_type_Odn;
  private odo jdField_a_of_type_Odo;
  private odp jdField_a_of_type_Odp;
  private pob jdField_a_of_type_Pob;
  private rmt jdField_a_of_type_Rmt;
  private rnu jdField_a_of_type_Rnu;
  private rot jdField_a_of_type_Rot;
  private roy jdField_a_of_type_Roy;
  private rpd jdField_a_of_type_Rpd;
  private rpn jdField_a_of_type_Rpn;
  private rqm jdField_a_of_type_Rqm;
  private rqy jdField_a_of_type_Rqy;
  private rro jdField_a_of_type_Rro;
  private rrx jdField_a_of_type_Rrx;
  private rry jdField_a_of_type_Rry;
  private rsa jdField_a_of_type_Rsa;
  private rsc jdField_a_of_type_Rsc;
  private rsd jdField_a_of_type_Rsd;
  private rsg jdField_a_of_type_Rsg;
  private rsk jdField_a_of_type_Rsk;
  private rul jdField_a_of_type_Rul;
  private rup jdField_a_of_type_Rup;
  private rvs jdField_a_of_type_Rvs;
  private ryk jdField_a_of_type_Ryk;
  private tmk jdField_a_of_type_Tmk;
  private tqy jdField_a_of_type_Tqy;
  private trb jdField_a_of_type_Trb;
  private tre jdField_a_of_type_Tre;
  private ucg jdField_a_of_type_Ucg;
  private uch jdField_a_of_type_Uch;
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
    if ((this.jdField_a_of_type_Rvs == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null)) {
      return null;
    }
    return rpt.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Rvs.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
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
    if ((this.jdField_a_of_type_Rot instanceof ros))
    {
      ros localros = (ros)this.jdField_a_of_type_Rot;
      ((ros)this.jdField_a_of_type_Rot).a.a(paramFloat, new rrr(this, localros));
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
    ppo.a(a(paramList), new rrs(this, paramList));
  }
  
  private void a(roj paramroj)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Roy.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramroj instanceof rog))
      {
        bool1 = bool2;
        if ((paramroj instanceof rol))
        {
          bool1 = bool2;
          if (!((rol)paramroj).jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(rot paramrot, boolean paramBoolean)
  {
    if ((paramrot != null) && (paramrot.jdField_a_of_type_Rrm != null) && (paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        pag.b(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    pag.c(paramrot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_g_of_type_JavaLangString);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Rot, false);
      rxk.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Rnu != null) {
        this.jdField_a_of_type_Rnu.b(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)))) {
      this.jdField_a_of_type_Odn.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
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
    this.jdField_f_of_type_Boolean = bnrf.e(this.jdField_d_of_type_Int);
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
        break label657;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label662;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = bnrf.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = ozs.e();
      this.jdField_f_of_type_Int = odr.a();
      if (bihq.a() != 1) {
        break label667;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_Pob = new rrw(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = bhgr.a(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label672;
      }
    }
    label657:
    label662:
    label667:
    label672:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Rsc = new rsc(this, bool1);
      rsc.a(this.jdField_a_of_type_Rsc, localArrayList);
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
  
  private void j()
  {
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380948));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new rqq(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Rro = new rse(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rro);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Rsk = new rsk(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Tqy = new tqy(getActivity().getApplicationContext());
    this.jdField_a_of_type_Tqy.a(new rrp(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Rnu = new rnu(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_Rsk);
    this.jdField_a_of_type_Rnu.e(getUserVisibleHint());
    this.jdField_a_of_type_Rnu.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Rnu;
    if (this.jdField_f_of_type_Boolean) {}
    for (int i1 = 3;; i1 = 1)
    {
      ((rnu)localObject).c(i1);
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Tqy);
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Rnu.a(this);
      this.jdField_a_of_type_Rnu.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_Rnu.b(this.k);
      this.jdField_a_of_type_Rnu.c(this.h);
      this.jdField_a_of_type_Rnu.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Rnu.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_Rnu.a(this.jdField_g_of_type_JavaLangString);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Rsd = new rsd(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Rnu);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rsa);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Rsd);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Rsd);
      this.jdField_a_of_type_Rpd = new rru(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364852));
      this.jdField_a_of_type_Roy = new roy(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Rnu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Roy.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Roy.a(this.jdField_a_of_type_Rpd);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Roy.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Roy);
      this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Rqm = new rqm(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Rro, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Rnu, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Rul = new rul(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Rnu);
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Rul);
      if (this.jdField_a_of_type_Tmk == null) {
        this.jdField_a_of_type_Tmk = new tmk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Rnu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Tmk);
      if (this.jdField_a_of_type_Rup == null)
      {
        this.jdField_a_of_type_Rup = new rup(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        this.jdField_a_of_type_Rup.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Rup);
      this.jdField_a_of_type_Rpn = new rpn();
      this.jdField_a_of_type_Rpn.a(new rxt(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h));
      this.jdField_a_of_type_Rpn.a(new rym());
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Rry = new rry(this, null);
        this.jdField_a_of_type_Rvs = new rvs(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Rry);
        this.jdField_a_of_type_Rvs.a(false);
        this.jdField_a_of_type_Rvs.a(this.jdField_a_of_type_Rry);
        this.jdField_a_of_type_Rvs.a(this.jdField_a_of_type_Rry);
      }
      if (this.jdField_a_of_type_Rqy == null)
      {
        this.jdField_a_of_type_Rqy = new rqy(getActivity(), 1);
        this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Rqy);
      }
      rxk.a().a(getActivity());
      rmp.a().a(true);
      rmp.a().a(2);
      return;
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Odp = ((odp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Odp.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Rsg = new rsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Rnu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rsg.a(this);
    this.jdField_a_of_type_Rsg.a(this.jdField_a_of_type_Rnu);
    this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Rsg);
    this.jdField_a_of_type_Rsk.a(this.jdField_a_of_type_Rsg);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rsg);
    this.jdField_a_of_type_Odn = ((odn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Odo = new rsb(this, null);
    this.jdField_a_of_type_Ucg = ((ucg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Uch = new rrv(this, null);
    this.jdField_a_of_type_Oal = ((oal)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Oam = new rrt(this, null);
    this.jdField_a_of_type_Rrx = new rrx(this, null);
    r();
    this.jdField_a_of_type_Tre = new tre(this.jdField_a_of_type_Rnu, this.jdField_a_of_type_JavaUtilArrayList);
    l();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Rsc.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Rnu.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = bhlg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Trb = new trb(this.jdField_a_of_type_Rnu, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Trb.a(this.n);
    this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Trb);
    this.jdField_a_of_type_Rsk.a(this.jdField_a_of_type_Trb);
    this.jdField_a_of_type_Ryk = new ryk(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Rmt = new rmt(getActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Rnu, this.jdField_a_of_type_Ryk, this);
    this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Rmt);
  }
  
  private void l()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      o();
      if ((this.jdField_a_of_type_Tre != null) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
        this.jdField_a_of_type_Tre.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      }
    }
  }
  
  private void m()
  {
    if (this.jdField_f_of_type_Boolean) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(anzj.a(2131715005) + this.jdField_g_of_type_Boolean);
    } while (this.jdField_g_of_type_Boolean);
    o();
    this.jdField_a_of_type_Rnu.c(1);
    this.jdField_a_of_type_Rnu.a();
  }
  
  private void n()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Odp != null) && (this.jdField_a_of_type_Rsg != null))
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
      this.jdField_a_of_type_Odp.a(this.jdField_a_of_type_Rsg.a(), l1, this.jdField_a_of_type_Rsg.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Rsg.a());
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
  
  private void o()
  {
    long l2;
    Object localObject;
    long l1;
    if (this.jdField_a_of_type_Odp != null)
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
        this.jdField_a_of_type_Odp.a(this.jdField_a_of_type_Rsc, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_c_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet), this.jdField_a_of_type_AndroidOsBundle);
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
  
  private void p()
  {
    if (this.jdField_a_of_type_Rpn != null) {
      this.jdField_a_of_type_Rpn.a();
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_Rpn != null) {
      this.jdField_a_of_type_Rpn.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Rrx != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rrx);
    }
    if (this.jdField_a_of_type_Rsc != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rsc);
    }
    if (this.jdField_a_of_type_Odo != null) {
      getActivity().addObserver(this.jdField_a_of_type_Odo);
    }
    if (this.jdField_a_of_type_Oam != null) {
      getActivity().addObserver(this.jdField_a_of_type_Oam);
    }
    if (this.jdField_a_of_type_Uch != null) {
      getActivity().addObserver(this.jdField_a_of_type_Uch);
    }
  }
  
  private void s()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Rrx);
    getActivity().removeObserver(this.jdField_a_of_type_Rsc);
    getActivity().removeObserver(this.jdField_a_of_type_Odo);
    getActivity().removeObserver(this.jdField_a_of_type_Oam);
    getActivity().removeObserver(this.jdField_a_of_type_Uch);
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Rsk != null) {
      this.jdField_a_of_type_Rsk.h();
    }
    rxk.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Rqm != null) && (this.jdField_a_of_type_Rqm.a())) {
      this.jdField_a_of_type_Rqm.a();
    }
    if (this.jdField_a_of_type_Rnu != null) {
      this.jdField_a_of_type_Rnu.e();
    }
    if ((this.jdField_a_of_type_Tqy != null) && (this.jdField_a_of_type_Tqy.a()) && (this.jdField_a_of_type_Tqy.a() != null) && (this.jdField_a_of_type_Rnu != null)) {
      this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_Tqy.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Tmk != null) {
      this.jdField_a_of_type_Tmk.k();
    }
    if ((this.jdField_a_of_type_Rot != null) && (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm != null)) {
      a(this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Rvs != null) {
      this.jdField_a_of_type_Rvs.c();
    }
    a(this.jdField_a_of_type_Rot, true);
    if (this.jdField_a_of_type_Tre != null) {
      this.jdField_a_of_type_Tre.c();
    }
  }
  
  public void D_()
  {
    if (QLog.isColorLevel()) {
      ozs.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    m();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Rot != null) {
      return this.jdField_a_of_type_Rot.jdField_c_of_type_Int;
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
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Rsk.f();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Rot == null) {}
    long l1;
    do
    {
      return;
      localObject = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_Rwf;
      VideoInfo localVideoInfo = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      if (localObject == null) {
        break label336;
      }
      l1 = ((rwf)localObject).b();
      if (!this.jdField_d_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Rqm != null) {
          this.jdField_a_of_type_Rqm.a((int)(paramLong / 1000.0D));
        }
        if (this.jdField_a_of_type_Rul != null) {
          this.jdField_a_of_type_Rul.a(localVideoInfo, this.jdField_a_of_type_Rot, (int)(paramLong / 1000.0D), (int)(l1 / 1000.0D));
        }
        if (this.jdField_a_of_type_Rpn != null) {
          this.jdField_a_of_type_Rpn.a(this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm, paramLong, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
        }
        this.jdField_a_of_type_Rmt.a(this.jdField_a_of_type_Rot, paramLong, l1);
      }
      if (this.jdField_a_of_type_Tmk != null) {
        this.jdField_a_of_type_Tmk.a(this.jdField_a_of_type_Rot, this.jdField_d_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Rup != null) {
        this.jdField_a_of_type_Rup.a(this.jdField_a_of_type_Rot, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
      }
      if ((this.jdField_a_of_type_Rsg != null) && (localObject != null)) {
        this.jdField_a_of_type_Rsg.a(((rwf)localObject).a(false));
      }
      if ((!this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Trb == null)) {
        break;
      }
    } while (trd.a());
    Object localObject = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
    if ((tpz.e((VideoAdInfo)localObject)) && (tpz.a((VideoAdInfo)localObject)))
    {
      if (paramLong < l1 * 0.8D) {
        break label341;
      }
      tpx.a("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
      this.jdField_a_of_type_Trb.a((VideoAdInfo)localObject, this.jdField_a_of_type_Rot.jdField_c_of_type_Int);
    }
    for (;;)
    {
      a((float)paramLong / (float)l1);
      return;
      label336:
      l1 = 0L;
      break;
      label341:
      if (paramLong >= l1 * 0.5D)
      {
        tpx.a("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
        this.jdField_a_of_type_Trb.b(this.jdField_a_of_type_Rot.jdField_c_of_type_Int);
      }
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof roj)) {
      a((roj)paramViewHolder);
    }
    if ((paramViewHolder instanceof rot))
    {
      if (this.jdField_a_of_type_Rul != null) {
        this.jdField_a_of_type_Rul.a(this.jdField_a_of_type_Rot);
      }
      if (this.jdField_a_of_type_Tmk != null) {
        this.jdField_a_of_type_Tmk.a((rot)paramViewHolder);
      }
      if (this.jdField_a_of_type_Rup != null) {
        this.jdField_a_of_type_Rup.a(this.jdField_a_of_type_Rot, (rot)paramViewHolder);
      }
      this.jdField_a_of_type_Tqy.a((rot)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.a((rot)paramViewHolder);
      a(this.jdField_a_of_type_Rot, false);
      this.jdField_a_of_type_Rot = ((rot)paramViewHolder);
      a(this.jdField_a_of_type_Rot, true);
      if ((this.jdField_a_of_type_Rqm != null) && ((this.jdField_a_of_type_Rot instanceof roq))) {
        this.jdField_a_of_type_Rqm.a((roq)this.jdField_a_of_type_Rot, rsd.a(this.jdField_a_of_type_Rsd));
      }
      if (this.jdField_a_of_type_Rot.jdField_c_of_type_Int > 0)
      {
        if (this.jdField_a_of_type_Rpn != null) {
          this.jdField_a_of_type_Rpn.b(false);
        }
        p();
      }
      if (this.jdField_a_of_type_Rot.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Rot.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rot.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
      this.jdField_a_of_type_Rmt.a(this.jdField_a_of_type_Rot);
      this.jdField_a_of_type_Ryk.a(this.jdField_a_of_type_Rot);
    }
    if (this.jdField_a_of_type_Rsa != null)
    {
      boolean bool = paramViewHolder instanceof rog;
      this.jdField_a_of_type_Rsa.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Rpn != null) {
      this.jdField_a_of_type_Rpn.a(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      p();
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
          str1 = new sbg(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
          label139:
          ocd.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Rot instanceof rol)) {
          this.jdField_a_of_type_Rvs.a(this.jdField_a_of_type_Rry.a(this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
    } while (this.jdField_a_of_type_Rvs == null);
    paramBoolean = this.jdField_a_of_type_Rvs.b();
    this.jdField_a_of_type_Rvs.a();
    this.jdField_a_of_type_Rvs.b();
    this.jdField_a_of_type_Rry.a(paramBoolean);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ucg != null) {
      this.jdField_a_of_type_Ucg.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(rot paramrot) {}
  
  public void a(rsa paramrsa)
  {
    this.jdField_a_of_type_Rsa = paramrsa;
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Roy != null) && (this.jdField_a_of_type_Roy.a()))
      {
        this.jdField_a_of_type_Roy.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Rot == null) || (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    sbg localsbg = new sbg(localVideoInfo);
    localsbg.i(localVideoInfo.jdField_g_of_type_JavaLangString).m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Rot.jdField_b_of_type_Int).l(this.jdField_a_of_type_Rot.jdField_c_of_type_Int);
    localsbg.p(1).i(localVideoInfo.jdField_g_of_type_JavaLangString);
    ocd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localsbg.a().a(), false);
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((this.jdField_a_of_type_Rot != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        rxk.a().a(paramInt);
        this.jdField_a_of_type_Rot.jdField_a_of_type_Rln.a(rxk.a().a());
        return true;
      }
    }
    return false;
  }
  
  public VideoInfo b()
  {
    if ((this.jdField_a_of_type_Rot != null) && (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm != null)) {
      return this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    n();
  }
  
  public boolean b()
  {
    if (((this.jdField_a_of_type_Rot instanceof roq)) && (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm != null) && (this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_Rot.jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
      this.jdField_a_of_type_Rmt.a(localVideoInfo, (roq)this.jdField_a_of_type_Rot, 2, this.jdField_d_of_type_Int);
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
    } while ((this.jdField_a_of_type_Roy == null) || (!this.jdField_a_of_type_Roy.a()));
    this.jdField_a_of_type_Roy.h();
    return true;
  }
  
  public void d()
  {
    m();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Rsk.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Tqy != null) {
      this.jdField_a_of_type_Tqy.c();
    }
    a(this.jdField_a_of_type_Rot, false);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Roy != null) && (this.jdField_a_of_type_Roy.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Tqy != null) {
      this.jdField_a_of_type_Tqy.d();
    }
    a(this.jdField_a_of_type_Rot, true);
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
      a(this.jdField_a_of_type_Rot);
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
            } while (this.jdField_a_of_type_Roy == null);
            this.jdField_a_of_type_Roy.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Rnu == null));
        paramIntent = this.jdField_a_of_type_Rnu.a(str);
      } while (paramIntent == null);
      paramIntent.jdField_f_of_type_Int += 1;
      this.jdField_a_of_type_Rnu.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131698588), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new rrq(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)rsr.a(2131560352, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ozs.a());
    i();
    j();
    k();
    if (this.jdField_a_of_type_Rsa != null) {
      this.jdField_a_of_type_Rsa.c();
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Rnu != null) {
      this.jdField_a_of_type_Rnu.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Tqy != null)
    {
      this.jdField_a_of_type_Tqy.a();
      this.jdField_a_of_type_Tqy = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Trb != null)
    {
      this.jdField_a_of_type_Trb.a();
      this.jdField_a_of_type_Trb = null;
    }
    if (this.jdField_a_of_type_Tre != null)
    {
      this.jdField_a_of_type_Tre.e();
      this.jdField_a_of_type_Trb = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Rsg != null)
    {
      this.jdField_a_of_type_Rsg.a();
      this.jdField_a_of_type_Rsg = null;
    }
    if (this.jdField_a_of_type_Rqm != null)
    {
      this.jdField_a_of_type_Rqm.b();
      this.jdField_a_of_type_Rqm = null;
    }
    if (this.jdField_a_of_type_Rul != null)
    {
      this.jdField_a_of_type_Rul.a();
      this.jdField_a_of_type_Rul = null;
    }
    if (this.jdField_a_of_type_Tmk != null)
    {
      this.jdField_a_of_type_Tmk.a();
      this.jdField_a_of_type_Tmk = null;
    }
    if (this.jdField_a_of_type_Rup != null)
    {
      this.jdField_a_of_type_Rup.a();
      this.jdField_a_of_type_Rup = null;
    }
    if (this.jdField_a_of_type_Rvs != null) {
      this.jdField_a_of_type_Rvs.e();
    }
    if (this.jdField_a_of_type_Rmt != null) {
      this.jdField_a_of_type_Rmt.a();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      pag.a(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList != null)
      {
        localObject = ((VideoInfo)localObject).jdField_c_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          pag.a(((VideoInfo)((Iterator)localObject).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_Rqy != null)
    {
      this.jdField_a_of_type_Rqy.a();
      this.jdField_a_of_type_Rqy = null;
    }
    this.jdField_a_of_type_Rot = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Rpn != null) {
      this.jdField_a_of_type_Rpn.b();
    }
    s();
    rmp.a().a();
    rxk.a().b(getActivity());
    if (this.jdField_a_of_type_Rsk != null) {
      this.jdField_a_of_type_Rsk.c();
    }
    trd.b();
    tre.h();
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Rsk != null) {
      this.jdField_a_of_type_Rsk.g();
    }
    if (this.jdField_a_of_type_Tqy != null) {
      this.jdField_a_of_type_Tqy.b();
    }
    if (this.jdField_a_of_type_Rvs != null) {
      this.jdField_a_of_type_Rvs.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdVideoADVideoAppDownloadManager.b();
    }
    if (this.jdField_a_of_type_Tre != null) {
      this.jdField_a_of_type_Tre.d();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      t();
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
      t();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Rnu != null) {
        this.jdField_a_of_type_Rnu.e(paramBoolean);
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