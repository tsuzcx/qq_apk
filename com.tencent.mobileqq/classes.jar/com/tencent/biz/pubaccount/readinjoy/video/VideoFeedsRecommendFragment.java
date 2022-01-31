package com.tencent.biz.pubaccount.readinjoy.video;

import ajyc;
import android.content.Intent;
import android.content.IntentFilter;
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
import bawz;
import bbcl;
import bbwc;
import bcpw;
import bfni;
import bhvh;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.logic.KandianFavoriteBroadcastReceiver;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import nna;
import nnb;
import noo;
import npt;
import npu;
import npv;
import npx;
import oat;
import onk;
import ooc;
import osm;
import ozi;
import qji;
import qjr;
import qks;
import qkw;
import qls;
import qmd;
import qmf;
import qmg;
import qmi;
import qmr;
import qms;
import qmx;
import qnb;
import qno;
import qny;
import qol;
import qpl;
import qpp;
import qpy;
import qqo;
import qqq;
import qqr;
import qqs;
import qqt;
import qqu;
import qqv;
import qqw;
import qqx;
import qqy;
import qqz;
import qra;
import qrc;
import qrd;
import qre;
import qrf;
import qrg;
import qri;
import qrk;
import qrm;
import qrq;
import qrr;
import qst;
import qsx;
import qth;
import qti;
import qto;
import qub;
import qvn;
import qwa;
import qzd;
import qze;
import six;
import siy;

public class VideoFeedsRecommendFragment
  extends Fragment
  implements qmf, qrk, qrq, qti
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private KandianFavoriteBroadcastReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private nna jdField_a_of_type_Nna;
  private nnb jdField_a_of_type_Nnb;
  private npt jdField_a_of_type_Npt;
  private npu jdField_a_of_type_Npu;
  private npv jdField_a_of_type_Npv;
  private ozi jdField_a_of_type_Ozi;
  private qji jdField_a_of_type_Qji;
  private qks jdField_a_of_type_Qks;
  private qls jdField_a_of_type_Qls;
  private qms jdField_a_of_type_Qms;
  private qmx jdField_a_of_type_Qmx;
  private qnb jdField_a_of_type_Qnb;
  private qny jdField_a_of_type_Qny;
  private qpl jdField_a_of_type_Qpl;
  private qpy jdField_a_of_type_Qpy;
  private qqq jdField_a_of_type_Qqq;
  private qqy jdField_a_of_type_Qqy;
  private qqz jdField_a_of_type_Qqz;
  private qra jdField_a_of_type_Qra;
  private qrc jdField_a_of_type_Qrc;
  private qre jdField_a_of_type_Qre;
  private qrf jdField_a_of_type_Qrf;
  private qri jdField_a_of_type_Qri;
  private qrm jdField_a_of_type_Qrm;
  private qst jdField_a_of_type_Qst;
  private qsx jdField_a_of_type_Qsx;
  private qth jdField_a_of_type_Qth;
  private qto jdField_a_of_type_Qto;
  private qwa jdField_a_of_type_Qwa;
  private six jdField_a_of_type_Six;
  private siy jdField_a_of_type_Siy;
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
  private int jdField_d_of_type_Int = 5;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k = true;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString2);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
  
  private void a(qmg paramqmg)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Qmx.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramqmg instanceof qmd))
      {
        bool1 = bool2;
        if ((paramqmg instanceof qmi))
        {
          bool1 = bool2;
          if (!((qmi)paramqmg).jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(qms paramqms, boolean paramBoolean)
  {
    if ((paramqms != null) && (paramqms.jdField_a_of_type_Qqo != null) && (paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        ooc.b(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
    }
    else {
      return;
    }
    ooc.c(paramqms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Qms, false);
      qvn.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Qls != null) {
        this.jdField_a_of_type_Qls.c(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.g))) {
        this.jdField_a_of_type_Npt.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
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
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.f = bhvh.e(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label228:
    label251:
    Object localObject;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.j = bool1;
      if (this.j) {
        break label654;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label659;
      }
      bool1 = true;
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      m();
      this.jdField_d_of_type_Int = onk.e();
      this.jdField_e_of_type_Int = npx.a();
      if (bbwc.a() != 1) {
        break label664;
      }
      bool1 = true;
      label326:
      this.jdField_c_of_type_Boolean = bool1;
      this.o = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_is_from_floating_window");
      this.jdField_a_of_type_Ozi = new qqx(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Ozi);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = bawz.a(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localObject = new ArrayList();
      ((List)localObject).add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label669;
      }
    }
    label654:
    label659:
    label664:
    label669:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Qre = new qre(this, bool1);
      qre.a(this.jdField_a_of_type_Qre, (List)localObject);
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVid  eoFromType = " + this.jdField_c_of_type_Int);
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoDataList[0] = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() needReloadTitle = " + this.jdField_e_of_type_Boolean + ", showSingleVideo = " + this.f + ", mFirstVideoStartPosition = " + this.jdField_a_of_type_Long);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label228;
      bool1 = false;
      break label251;
      bool1 = false;
      break label326;
    }
  }
  
  private void k()
  {
    if (bfni.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379072));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new qpp(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Qqq = new qrg(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qqq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Qrm = new qrm(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Qji = new qji(getActivity().getApplicationContext());
    this.jdField_a_of_type_Qji.a(new qqr(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Qls = new qls(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_Qrm);
    this.jdField_a_of_type_Qls.e(getUserVisibleHint());
    this.jdField_a_of_type_Qls.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Qls;
    int i1;
    if (this.f)
    {
      i1 = 3;
      ((qls)localObject).d(i1);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qji);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Qls.a(this);
      this.jdField_a_of_type_Qls.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Qls.b(this.k);
      this.jdField_a_of_type_Qls.c(this.h);
      this.jdField_a_of_type_Qls.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Qls.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Qrf = new qrf(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qrc);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Qrf);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Qrf);
      this.jdField_a_of_type_Qnb = new qqv(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364513));
      this.jdField_a_of_type_Qmx = new qmx(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qls, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Qmx.b();
      this.jdField_a_of_type_Qmx.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Qmx.a(this.jdField_a_of_type_Qnb);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Qmx.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qmx);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Qth = new qth(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup, this, this.jdField_b_of_type_Boolean, i1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qth);
      this.jdField_a_of_type_Qpl = new qpl(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qqq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Qls, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Qst = new qst(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Qls);
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qst);
      if (this.jdField_a_of_type_Qny == null) {
        this.jdField_a_of_type_Qny = new qny(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Qls, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qny);
      if (this.jdField_a_of_type_Qsx == null) {
        this.jdField_a_of_type_Qsx = new qsx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qsx);
      this.jdField_a_of_type_Qwa = new qwa(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h);
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Qra = new qra(this, null);
        this.jdField_a_of_type_Qto = new qto(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Qra);
        this.jdField_a_of_type_Qto.a(false);
        this.jdField_a_of_type_Qto.a(this.jdField_a_of_type_Qra);
        this.jdField_a_of_type_Qto.a(this.jdField_a_of_type_Qra);
      }
      if (this.jdField_a_of_type_Qpy == null)
      {
        this.jdField_a_of_type_Qpy = new qpy(getActivity(), 1);
        this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qpy);
      }
      qvn.a().a(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1128;
      }
      qvn.a().e(true);
    }
    for (;;)
    {
      qvn.a().a(qvn.a().a(true), "init view set mute itself FromMutiVideo", 2);
      qkw.a().a(true);
      qkw.a().a(2);
      return;
      i1 = 1;
      break;
      label1128:
      qvn.a().e(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Npv = ((npv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Qri = new qri(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Qls, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qri.a(this);
    this.jdField_a_of_type_Qri.a(this.jdField_a_of_type_Qls);
    this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qri);
    this.jdField_a_of_type_Qrm.a(this.jdField_a_of_type_Qri);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qri);
    this.jdField_a_of_type_Npt = ((npt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Npu = new qrd(this, null);
    this.jdField_a_of_type_Six = ((six)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Siy = new qqw(this, null);
    this.jdField_a_of_type_Nna = ((nna)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Nnb = new qqu(this, null);
    this.jdField_a_of_type_Qqz = new qqz(this, null);
    t();
    n();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Qre.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Qls.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = bbcl.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Qks = new qks(this.jdField_a_of_type_Qls, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qks.a(this.n);
    this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qks);
    this.jdField_a_of_type_Qrm.a(this.jdField_a_of_type_Qks);
  }
  
  private void m()
  {
    this.n = bhvh.d(this.jdField_c_of_type_Int);
  }
  
  private void n()
  {
    if (!this.f) {
      q();
    }
  }
  
  private void o()
  {
    if (this.f) {}
    do
    {
      return;
      VideoFeedsPlayActivity.a(ajyc.a(2131716224) + this.g);
    } while (this.g);
    q();
    this.jdField_a_of_type_Qls.d(1);
    this.jdField_a_of_type_Qls.a();
  }
  
  private void p()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Npv != null) && (this.jdField_a_of_type_Qri != null))
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
      this.jdField_a_of_type_Npv.a(this.jdField_a_of_type_Qri.a(), l1, this.jdField_a_of_type_Qri.a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Qri.a());
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
    if (this.jdField_a_of_type_Npv != null)
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
      if ((this.jdField_a_of_type_Qto != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        localObject = this.jdField_a_of_type_Qto.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break label198;
        }
      }
      label198:
      for (int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i1 = 0)
      {
        this.g = true;
        this.jdField_a_of_type_Npv.a(this.jdField_a_of_type_Qre, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_b_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet));
        return;
        localObject = null;
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
    if (this.jdField_a_of_type_Qwa != null) {
      this.jdField_a_of_type_Qwa.a();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Qwa != null) {
      this.jdField_a_of_type_Qwa.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Qqz != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qqz);
    }
    if (this.jdField_a_of_type_Qre != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qre);
    }
    if (this.jdField_a_of_type_Npu != null) {
      getActivity().addObserver(this.jdField_a_of_type_Npu);
    }
    if (this.jdField_a_of_type_Nnb != null) {
      getActivity().addObserver(this.jdField_a_of_type_Nnb);
    }
    if (this.jdField_a_of_type_Siy != null) {
      getActivity().addObserver(this.jdField_a_of_type_Siy);
    }
  }
  
  private void u()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Qqz);
    getActivity().removeObserver(this.jdField_a_of_type_Qre);
    getActivity().removeObserver(this.jdField_a_of_type_Npu);
    getActivity().removeObserver(this.jdField_a_of_type_Nnb);
    getActivity().removeObserver(this.jdField_a_of_type_Siy);
    if (this.jdField_a_of_type_Qqy != null) {
      osm.a().b(this.jdField_a_of_type_Qqy);
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_Qth != null) && (this.jdField_a_of_type_Qth.a())) {
      return;
    }
    qvn.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Qpl != null) && (this.jdField_a_of_type_Qpl.a())) {
      this.jdField_a_of_type_Qpl.a();
    }
    if (this.jdField_a_of_type_Qls != null) {
      this.jdField_a_of_type_Qls.e();
    }
    if ((this.jdField_a_of_type_Qji != null) && (this.jdField_a_of_type_Qji.a()) && (this.jdField_a_of_type_Qji.a() != null) && (this.jdField_a_of_type_Qls != null)) {
      this.jdField_a_of_type_Qls.a(this.jdField_a_of_type_Qji.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Qny != null) {
      this.jdField_a_of_type_Qny.k();
    }
    if ((this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null)) {
      a(this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Qto != null) {
      this.jdField_a_of_type_Qto.c();
    }
    a(this.jdField_a_of_type_Qms, true);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Qms != null) {
      return this.jdField_a_of_type_Qms.jdField_c_of_type_Int;
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
  
  public VideoInfo a(View paramView)
  {
    b(1);
    return c();
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public ArrayList<VideoInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      onk.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    o();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Qpl != null) {
      this.jdField_a_of_type_Qpl.a((int)(paramLong / 1000.0D));
    }
    Object localObject;
    if ((this.jdField_a_of_type_Qst != null) && ((this.jdField_a_of_type_Qms instanceof qms)))
    {
      localObject = this.jdField_a_of_type_Qms;
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Qst.a(((qms)localObject).jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, (qms)localObject, (int)(paramLong / 1000.0D), (int)(((qms)localObject).jdField_a_of_type_Qqo.jdField_a_of_type_Qub.b() / 1000.0D));
      }
    }
    if ((this.jdField_a_of_type_Qny != null) && (this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qms;
      this.jdField_a_of_type_Qny.a((qms)localObject, this.jdField_d_of_type_Boolean);
    }
    long l1;
    if ((this.jdField_a_of_type_Qsx != null) && (this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qms;
      l1 = this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_Qub.b();
      this.jdField_a_of_type_Qsx.a((qms)localObject, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
    }
    if ((this.jdField_a_of_type_Qri != null) && (this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_Qub != null))
    {
      localObject = this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_Qub;
      this.jdField_a_of_type_Qri.a(((qub)localObject).a(false));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qks != null))
    {
      localObject = this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      if ((oat.e((VideoAdInfo)localObject)) && (oat.a((VideoAdInfo)localObject)))
      {
        if (paramLong < l1 * 0.8D) {
          break label420;
        }
        this.jdField_a_of_type_Qks.a((VideoAdInfo)localObject, this.jdField_a_of_type_Qms.jdField_c_of_type_Int);
      }
    }
    label420:
    while (paramLong < l1 * 0.5D) {
      return;
    }
    this.jdField_a_of_type_Qks.b(this.jdField_a_of_type_Qms.jdField_c_of_type_Int);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof qmg)) {
      a((qmg)paramViewHolder);
    }
    if ((paramViewHolder instanceof qms))
    {
      if (this.jdField_a_of_type_Qst != null) {
        this.jdField_a_of_type_Qst.a(this.jdField_a_of_type_Qms);
      }
      if (this.jdField_a_of_type_Qny != null) {
        this.jdField_a_of_type_Qny.a((qms)paramViewHolder);
      }
      if (this.jdField_a_of_type_Qsx != null) {
        this.jdField_a_of_type_Qsx.a(this.jdField_a_of_type_Qms, (qms)paramViewHolder);
      }
      this.jdField_a_of_type_Qji.a((qms)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a((qms)paramViewHolder);
      a(this.jdField_a_of_type_Qms, false);
      this.jdField_a_of_type_Qms = ((qms)paramViewHolder);
      a(this.jdField_a_of_type_Qms, true);
      if ((this.jdField_a_of_type_Qpl != null) && ((this.jdField_a_of_type_Qms instanceof qmr))) {
        this.jdField_a_of_type_Qpl.a((qmr)this.jdField_a_of_type_Qms, qrf.a(this.jdField_a_of_type_Qrf));
      }
      if (((this.jdField_a_of_type_Qth == null) || (this.jdField_a_of_type_Qms == null) || (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo == null)) || (this.jdField_a_of_type_Qms.jdField_c_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_Qwa != null) {
          this.jdField_a_of_type_Qwa.b(false);
        }
        r();
      }
      if ((this.jdField_a_of_type_Qms.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Qms.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Qms.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qms.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
    }
    if (this.jdField_a_of_type_Qrc != null)
    {
      boolean bool = paramViewHolder instanceof qmd;
      this.jdField_a_of_type_Qrc.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Qwa != null) {
      this.jdField_a_of_type_Qwa.a(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      r();
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
          str1 = new qze(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.g)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.g;
          label139:
          noo.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Qms instanceof qmi)) {
          this.jdField_a_of_type_Qto.a(this.jdField_a_of_type_Qra.a(this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
    } while (this.jdField_a_of_type_Qto == null);
    paramBoolean = this.jdField_a_of_type_Qto.b();
    this.jdField_a_of_type_Qto.a();
    this.jdField_a_of_type_Qto.b();
    this.jdField_a_of_type_Qra.a(paramBoolean);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Qms == null) {}
    List localList;
    do
    {
      return;
      this.jdField_a_of_type_Qms.l.setVisibility(8);
      this.jdField_a_of_type_Qms.o.setVisibility(8);
      this.jdField_a_of_type_Qms.k.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      }
      localList = qol.a(this.jdField_a_of_type_JavaUtilArrayList, a());
      localObject = qol.a(localList);
    } while (localObject == null);
    Object localObject = qno.a(((VideoInfo)localObject).jdField_b_of_type_Int, ((VideoInfo)localObject).jdField_c_of_type_Int);
    qol.a(this.jdField_a_of_type_Qms.itemView, paramViewGroup, (int[])localObject, new qqt(this, localList));
    if (this.jdField_a_of_type_Qqy == null) {
      this.jdField_a_of_type_Qqy = new qqy(this, null);
    }
    osm.a().a(this.jdField_a_of_type_Qqy);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Six != null) {
      this.jdField_a_of_type_Six.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(qms paramqms) {}
  
  public void a(qrc paramqrc)
  {
    this.jdField_a_of_type_Qrc = paramqrc;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      v();
    }
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Qmx != null) && (this.jdField_a_of_type_Qmx.a()))
      {
        this.jdField_a_of_type_Qmx.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Qms == null) || (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    qze localqze = new qze(localVideoInfo);
    localqze.h(localVideoInfo.g).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).n(this.jdField_a_of_type_Qms.jdField_b_of_type_Int).m(this.jdField_a_of_type_Qms.jdField_c_of_type_Int);
    localqze.p(1).h(localVideoInfo.g);
    noo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localqze.a().a(), false);
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
    if ((this.jdField_a_of_type_Qms != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qvn.a().a(paramInt);
        if (this.jdField_a_of_type_Qms == null) {
          break;
        }
        this.jdField_a_of_type_Qms.jdField_a_of_type_Qjr.a(qvn.a().a());
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Qms != null) {
      return this.jdField_a_of_type_Qms.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public VideoInfo b()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
      if ((i1 >= 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())) {}
      for (VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i1); localVideoInfo.d == null; localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)) {
        return localVideoInfo;
      }
      return (VideoInfo)localVideoInfo.d.get(localVideoInfo.p);
    }
    return null;
  }
  
  public void b()
  {
    p();
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public VideoInfo c()
  {
    if ((this.jdField_a_of_type_Qms != null) && (this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo != null)) {
      return this.jdField_a_of_type_Qms.jdField_a_of_type_Qqo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    }
    return null;
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
    } while ((this.jdField_a_of_type_Qmx == null) || (!this.jdField_a_of_type_Qmx.a()));
    this.jdField_a_of_type_Qmx.h();
    return true;
  }
  
  public void d()
  {
    o();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Qmx != null) && (this.jdField_a_of_type_Qmx.a());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Qji != null) {
      this.jdField_a_of_type_Qji.c();
    }
    a(this.jdField_a_of_type_Qms, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Qji != null) {
      this.jdField_a_of_type_Qji.d();
    }
    a(this.jdField_a_of_type_Qms, true);
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
      a(this.jdField_a_of_type_Qms);
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
            } while (this.jdField_a_of_type_Qmx == null);
            this.jdField_a_of_type_Qmx.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Qls == null));
        paramIntent = this.jdField_a_of_type_Qls.a(str);
      } while (paramIntent == null);
      paramIntent.f += 1;
      this.jdField_a_of_type_Qls.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    bcpw.a(getActivity(), -1, getString(2131699664), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new qqs(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)qrr.a(2131560086, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onk.a());
    j();
    k();
    l();
    if (this.jdField_a_of_type_Qrc != null) {
      this.jdField_a_of_type_Qrc.c();
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Qls != null) {
      this.jdField_a_of_type_Qls.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Qji != null)
    {
      this.jdField_a_of_type_Qji.a();
      this.jdField_a_of_type_Qji = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Qks != null)
    {
      this.jdField_a_of_type_Qks.a();
      this.jdField_a_of_type_Qks = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver != null) {
      getActivity().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver);
    }
    if (this.jdField_a_of_type_Qri != null)
    {
      this.jdField_a_of_type_Qri.a();
      this.jdField_a_of_type_Qri = null;
    }
    if (this.jdField_a_of_type_Qpl != null)
    {
      this.jdField_a_of_type_Qpl.b();
      this.jdField_a_of_type_Qpl = null;
    }
    if (this.jdField_a_of_type_Qst != null)
    {
      this.jdField_a_of_type_Qst.a();
      this.jdField_a_of_type_Qst = null;
    }
    if (this.jdField_a_of_type_Qny != null)
    {
      this.jdField_a_of_type_Qny.a();
      this.jdField_a_of_type_Qny = null;
    }
    if (this.jdField_a_of_type_Qsx != null)
    {
      this.jdField_a_of_type_Qsx.a();
      this.jdField_a_of_type_Qsx = null;
    }
    if (this.jdField_a_of_type_Qto != null) {
      this.jdField_a_of_type_Qto.e();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      ooc.a(((VideoInfo)localObject).g);
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        while (((Iterator)localObject).hasNext()) {
          ooc.a(((VideoInfo)((Iterator)localObject).next()).g);
        }
      }
    }
    if (this.jdField_a_of_type_Qpy != null)
    {
      this.jdField_a_of_type_Qpy.a();
      this.jdField_a_of_type_Qpy = null;
    }
    this.jdField_a_of_type_Qms = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Qwa != null) {
      this.jdField_a_of_type_Qwa.b();
    }
    u();
    qkw.a().a();
    qvn.a().b(getActivity());
    if (this.jdField_a_of_type_Qrm != null) {
      this.jdField_a_of_type_Qrm.c();
    }
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Qji != null) {
      this.jdField_a_of_type_Qji.b();
    }
    if (this.jdField_a_of_type_Qto != null) {
      this.jdField_a_of_type_Qto.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.b();
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
    b(2);
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
      if (this.jdField_a_of_type_Qls != null) {
        this.jdField_a_of_type_Qls.e(paramBoolean);
      }
      return;
      b(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */