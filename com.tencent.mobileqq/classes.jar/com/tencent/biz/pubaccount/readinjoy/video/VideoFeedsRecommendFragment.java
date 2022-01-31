package com.tencent.biz.pubaccount.readinjoy.video;

import ajjy;
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
import azvv;
import babh;
import bati;
import bbmy;
import befo;
import bgmq;
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
import nbz;
import nca;
import ndn;
import nes;
import net;
import neu;
import new;
import npi;
import obz;
import ocr;
import ohb;
import ont;
import pxk;
import pxs;
import pys;
import pyw;
import pzs;
import qab;
import qad;
import qae;
import qag;
import qap;
import qaq;
import qaz;
import qbd;
import qbq;
import qca;
import qcn;
import qdn;
import qdr;
import qea;
import qeq;
import qes;
import qet;
import qeu;
import qev;
import qew;
import qex;
import qey;
import qez;
import qfa;
import qfb;
import qfc;
import qfe;
import qff;
import qfg;
import qfh;
import qfi;
import qfk;
import qfm;
import qfo;
import qfs;
import qft;
import qgv;
import qgw;
import qhc;
import qhd;
import qhj;
import qhw;
import qji;
import qjv;
import qmu;
import qmv;
import rwe;
import rwf;

public class VideoFeedsRecommendFragment
  extends Fragment
  implements qad, qfm, qfs, qhd
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
  private nbz jdField_a_of_type_Nbz;
  private nca jdField_a_of_type_Nca;
  private nes jdField_a_of_type_Nes;
  private net jdField_a_of_type_Net;
  private neu jdField_a_of_type_Neu;
  private ont jdField_a_of_type_Ont;
  private pxk jdField_a_of_type_Pxk;
  private pys jdField_a_of_type_Pys;
  private pzs jdField_a_of_type_Pzs;
  private qaq jdField_a_of_type_Qaq;
  private qaz jdField_a_of_type_Qaz;
  private qbd jdField_a_of_type_Qbd;
  private qca jdField_a_of_type_Qca;
  private qdn jdField_a_of_type_Qdn;
  private qea jdField_a_of_type_Qea;
  private qes jdField_a_of_type_Qes;
  private qfa jdField_a_of_type_Qfa;
  private qfb jdField_a_of_type_Qfb;
  private qfc jdField_a_of_type_Qfc;
  private qfe jdField_a_of_type_Qfe;
  private qfg jdField_a_of_type_Qfg;
  private qfh jdField_a_of_type_Qfh;
  private qfk jdField_a_of_type_Qfk;
  private qfo jdField_a_of_type_Qfo;
  private qgv jdField_a_of_type_Qgv;
  private qgw jdField_a_of_type_Qgw;
  private qhc jdField_a_of_type_Qhc;
  private qhj jdField_a_of_type_Qhj;
  private qjv jdField_a_of_type_Qjv;
  private rwe jdField_a_of_type_Rwe;
  private rwf jdField_a_of_type_Rwf;
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
  
  private void a(qae paramqae)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Qaz.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramqae instanceof qab))
      {
        bool1 = bool2;
        if ((paramqae instanceof qag))
        {
          bool1 = bool2;
          if (!((qag)paramqae).jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(qaq paramqaq, boolean paramBoolean)
  {
    if ((paramqaq != null) && (paramqaq.jdField_a_of_type_Qeq != null) && (paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        ocr.b(paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
    }
    else {
      return;
    }
    ocr.c(paramqaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Qaq, false);
      qji.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Pzs != null) {
        this.jdField_a_of_type_Pzs.c(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.g))) {
        this.jdField_a_of_type_Nes.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
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
    this.f = bgmq.e(this.jdField_c_of_type_Int);
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
      this.jdField_d_of_type_Int = obz.e();
      this.jdField_e_of_type_Int = new.a();
      if (bati.a() != 1) {
        break label664;
      }
      bool1 = true;
      label326:
      this.jdField_c_of_type_Boolean = bool1;
      this.o = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_is_from_floating_window");
      this.jdField_a_of_type_Ont = new qez(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Ont);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = azvv.a(getActivity(), 120.0F);
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
      this.jdField_a_of_type_Qfg = new qfg(this, bool1);
      qfg.a(this.jdField_a_of_type_Qfg, (List)localObject);
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
    if (befo.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131313236));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new qdr(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Qes = new qfi(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qes);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Qfo = new qfo(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Pxk = new pxk(getActivity().getApplicationContext());
    this.jdField_a_of_type_Pxk.a(new qet(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Pzs = new pzs(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_Qfo);
    this.jdField_a_of_type_Pzs.e(getUserVisibleHint());
    this.jdField_a_of_type_Pzs.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Pzs;
    int i1;
    if (this.f)
    {
      i1 = 3;
      ((pzs)localObject).d(i1);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Pxk);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Pzs.a(this);
      this.jdField_a_of_type_Pzs.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Pzs.b(this.k);
      this.jdField_a_of_type_Pzs.c(this.h);
      this.jdField_a_of_type_Pzs.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Pzs.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Qfh = new qfh(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Pzs);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qfe);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Qfh);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Qfh);
      this.jdField_a_of_type_Qbd = new qex(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298953));
      this.jdField_a_of_type_Qaz = new qaz(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Pzs, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Qaz.b();
      this.jdField_a_of_type_Qaz.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Qaz.a(this.jdField_a_of_type_Qbd);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Qaz.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qaz);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Qhc = new qhc(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup, this, this.jdField_b_of_type_Boolean, i1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qhc);
      this.jdField_a_of_type_Qdn = new qdn(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qes, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Pzs, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Qgv = new qgv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Pzs, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qgv);
      if (this.jdField_a_of_type_Qca == null) {
        this.jdField_a_of_type_Qca = new qca(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Pzs, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qca);
      if (this.jdField_a_of_type_Qgw == null) {
        this.jdField_a_of_type_Qgw = new qgw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qgw);
      this.jdField_a_of_type_Qjv = new qjv(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h);
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Qfc = new qfc(this, null);
        this.jdField_a_of_type_Qhj = new qhj(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Qfc);
        this.jdField_a_of_type_Qhj.a(false);
        this.jdField_a_of_type_Qhj.a(this.jdField_a_of_type_Qfc);
        this.jdField_a_of_type_Qhj.a(this.jdField_a_of_type_Qfc);
      }
      if (this.jdField_a_of_type_Qea == null)
      {
        this.jdField_a_of_type_Qea = new qea(getActivity(), 1);
        this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qea);
      }
      qji.a().a(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1132;
      }
      qji.a().e(true);
    }
    for (;;)
    {
      qji.a().a(qji.a().a(true), "init view set mute itself FromMutiVideo", 2);
      pyw.a().a(true);
      pyw.a().a(2);
      return;
      i1 = 1;
      break;
      label1132:
      qji.a().e(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Neu = ((neu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Qfk = new qfk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Pzs, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qfk.a(this);
    this.jdField_a_of_type_Qfk.a(this.jdField_a_of_type_Pzs);
    this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Qfk);
    this.jdField_a_of_type_Qfo.a(this.jdField_a_of_type_Qfk);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qfk);
    this.jdField_a_of_type_Nes = ((nes)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Net = new qff(this, null);
    this.jdField_a_of_type_Rwe = ((rwe)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Rwf = new qey(this, null);
    this.jdField_a_of_type_Nbz = ((nbz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Nca = new qew(this, null);
    this.jdField_a_of_type_Qfb = new qfb(this, null);
    t();
    n();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Qfg.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Pzs.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = babh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Pys = new pys(this.jdField_a_of_type_Pzs, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pys.a(this.n);
    this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Pys);
    this.jdField_a_of_type_Qfo.a(this.jdField_a_of_type_Pys);
  }
  
  private void m()
  {
    this.n = bgmq.d(this.jdField_c_of_type_Int);
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
      VideoFeedsPlayActivity.a(ajjy.a(2131650433) + this.g);
    } while (this.g);
    q();
    this.jdField_a_of_type_Pzs.d(1);
    this.jdField_a_of_type_Pzs.a();
  }
  
  private void p()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Neu != null) && (this.jdField_a_of_type_Qfk != null))
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
      this.jdField_a_of_type_Neu.a(this.jdField_a_of_type_Qfk.a(), l1, this.jdField_a_of_type_Qfk.a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Qfk.a());
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
    if (this.jdField_a_of_type_Neu != null)
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
      if ((this.jdField_a_of_type_Qhj != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        localObject = this.jdField_a_of_type_Qhj.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break label198;
        }
      }
      label198:
      for (int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i1 = 0)
      {
        this.g = true;
        this.jdField_a_of_type_Neu.a(this.jdField_a_of_type_Qfg, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_b_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet));
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
    if (this.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qjv.a();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qjv.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Qfb != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qfb);
    }
    if (this.jdField_a_of_type_Qfg != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qfg);
    }
    if (this.jdField_a_of_type_Net != null) {
      getActivity().addObserver(this.jdField_a_of_type_Net);
    }
    if (this.jdField_a_of_type_Nca != null) {
      getActivity().addObserver(this.jdField_a_of_type_Nca);
    }
    if (this.jdField_a_of_type_Rwf != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rwf);
    }
  }
  
  private void u()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Qfb);
    getActivity().removeObserver(this.jdField_a_of_type_Qfg);
    getActivity().removeObserver(this.jdField_a_of_type_Net);
    getActivity().removeObserver(this.jdField_a_of_type_Nca);
    getActivity().removeObserver(this.jdField_a_of_type_Rwf);
    if (this.jdField_a_of_type_Qfa != null) {
      ohb.a().b(this.jdField_a_of_type_Qfa);
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_Qhc != null) && (this.jdField_a_of_type_Qhc.a())) {
      return;
    }
    qji.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Qdn != null) && (this.jdField_a_of_type_Qdn.a())) {
      this.jdField_a_of_type_Qdn.a();
    }
    if (this.jdField_a_of_type_Pzs != null) {
      this.jdField_a_of_type_Pzs.e();
    }
    if ((this.jdField_a_of_type_Pxk != null) && (this.jdField_a_of_type_Pxk.a()) && (this.jdField_a_of_type_Pxk.a() != null) && (this.jdField_a_of_type_Pzs != null)) {
      this.jdField_a_of_type_Pzs.a(this.jdField_a_of_type_Pxk.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Qca != null) {
      this.jdField_a_of_type_Qca.k();
    }
    if ((this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null)) {
      a(this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Qhj != null) {
      this.jdField_a_of_type_Qhj.c();
    }
    a(this.jdField_a_of_type_Qaq, true);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Qaq != null) {
      return this.jdField_a_of_type_Qaq.jdField_c_of_type_Int;
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
      obz.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    o();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Qdn != null) {
      this.jdField_a_of_type_Qdn.a((int)(paramLong / 1000.0D));
    }
    Object localObject;
    if ((this.jdField_a_of_type_Qgv != null) && ((this.jdField_a_of_type_Qaq instanceof qaq)))
    {
      localObject = this.jdField_a_of_type_Qaq;
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Qgv.a(((qaq)localObject).jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, (qaq)localObject, (int)(paramLong / 1000.0D), (int)(((qaq)localObject).jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.b() / 1000.0D));
      }
    }
    if ((this.jdField_a_of_type_Qca != null) && (this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qaq;
      this.jdField_a_of_type_Qca.a((qaq)localObject, this.jdField_d_of_type_Boolean);
    }
    long l1;
    if ((this.jdField_a_of_type_Qgw != null) && (this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qaq;
      l1 = this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw.b();
      this.jdField_a_of_type_Qgw.a((qaq)localObject, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1);
    }
    if ((this.jdField_a_of_type_Qfk != null) && (this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw != null))
    {
      localObject = this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_Qhw;
      this.jdField_a_of_type_Qfk.a(((qhw)localObject).a(false));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Pys != null))
    {
      localObject = this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      if ((npi.e((VideoAdInfo)localObject)) && (npi.a((VideoAdInfo)localObject)))
      {
        if (paramLong < l1 * 0.8D) {
          break label419;
        }
        this.jdField_a_of_type_Pys.a((VideoAdInfo)localObject, this.jdField_a_of_type_Qaq.jdField_c_of_type_Int);
      }
    }
    label419:
    while (paramLong < l1 * 0.5D) {
      return;
    }
    this.jdField_a_of_type_Pys.b(this.jdField_a_of_type_Qaq.jdField_c_of_type_Int);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof qae)) {
      a((qae)paramViewHolder);
    }
    if ((paramViewHolder instanceof qaq))
    {
      if (this.jdField_a_of_type_Qgv != null) {
        this.jdField_a_of_type_Qgv.a(this.jdField_a_of_type_Qaq);
      }
      if (this.jdField_a_of_type_Qca != null) {
        this.jdField_a_of_type_Qca.a((qaq)paramViewHolder);
      }
      if (this.jdField_a_of_type_Qgw != null) {
        this.jdField_a_of_type_Qgw.a(this.jdField_a_of_type_Qaq, (qaq)paramViewHolder);
      }
      this.jdField_a_of_type_Pxk.a((qaq)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a((qaq)paramViewHolder);
      a(this.jdField_a_of_type_Qaq, false);
      this.jdField_a_of_type_Qaq = ((qaq)paramViewHolder);
      a(this.jdField_a_of_type_Qaq, true);
      if ((this.jdField_a_of_type_Qdn != null) && ((this.jdField_a_of_type_Qaq instanceof qap))) {
        this.jdField_a_of_type_Qdn.a((qap)this.jdField_a_of_type_Qaq, qfh.a(this.jdField_a_of_type_Qfh));
      }
      if (((this.jdField_a_of_type_Qhc == null) || (this.jdField_a_of_type_Qaq == null) || (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq == null)) || (this.jdField_a_of_type_Qaq.jdField_c_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_Qjv != null) {
          this.jdField_a_of_type_Qjv.b(false);
        }
        r();
      }
      if ((this.jdField_a_of_type_Qaq.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Qaq.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Qaq.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qaq.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
    }
    if (this.jdField_a_of_type_Qfe != null)
    {
      boolean bool = paramViewHolder instanceof qab;
      this.jdField_a_of_type_Qfe.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qjv.a(paramBoolean);
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
          str1 = new qmv(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.g)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.g;
          label139:
          ndn.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Qaq instanceof qag)) {
          this.jdField_a_of_type_Qhj.a(this.jdField_a_of_type_Qfc.a(this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
    } while (this.jdField_a_of_type_Qhj == null);
    paramBoolean = this.jdField_a_of_type_Qhj.b();
    this.jdField_a_of_type_Qhj.a();
    this.jdField_a_of_type_Qhj.b();
    this.jdField_a_of_type_Qfc.a(paramBoolean);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Qaq == null) {}
    List localList;
    do
    {
      return;
      this.jdField_a_of_type_Qaq.o.setVisibility(8);
      this.jdField_a_of_type_Qaq.q.setVisibility(8);
      this.jdField_a_of_type_Qaq.m.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      }
      localList = qcn.a(this.jdField_a_of_type_JavaUtilArrayList, a());
      localObject = qcn.a(localList);
    } while (localObject == null);
    Object localObject = qbq.a(((VideoInfo)localObject).jdField_b_of_type_Int, ((VideoInfo)localObject).jdField_c_of_type_Int);
    qcn.a(this.jdField_a_of_type_Qaq.itemView, paramViewGroup, (int[])localObject, new qev(this, localList));
    if (this.jdField_a_of_type_Qfa == null) {
      this.jdField_a_of_type_Qfa = new qfa(this, null);
    }
    ohb.a().a(this.jdField_a_of_type_Qfa);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Rwe != null) {
      this.jdField_a_of_type_Rwe.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(qaq paramqaq) {}
  
  public void a(qfe paramqfe)
  {
    this.jdField_a_of_type_Qfe = paramqfe;
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
      if ((this.jdField_a_of_type_Qaz != null) && (this.jdField_a_of_type_Qaz.a()))
      {
        this.jdField_a_of_type_Qaz.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Qaq == null) || (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    qmv localqmv = new qmv(localVideoInfo);
    localqmv.h(localVideoInfo.g).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Qaq.jdField_b_of_type_Int).l(this.jdField_a_of_type_Qaq.jdField_c_of_type_Int);
    localqmv.o(1).h(localVideoInfo.g);
    ndn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localqmv.a().a(), false);
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
    if ((this.jdField_a_of_type_Qaq != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qji.a().a(paramInt);
        if (this.jdField_a_of_type_Qaq == null) {
          break;
        }
        this.jdField_a_of_type_Qaq.jdField_a_of_type_Pxs.a(qji.a().a());
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Qaq != null) {
      return this.jdField_a_of_type_Qaq.jdField_c_of_type_Int;
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
    if ((this.jdField_a_of_type_Qaq != null) && (this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq != null)) {
      return this.jdField_a_of_type_Qaq.jdField_a_of_type_Qeq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
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
    } while ((this.jdField_a_of_type_Qaz == null) || (!this.jdField_a_of_type_Qaz.a()));
    this.jdField_a_of_type_Qaz.h();
    return true;
  }
  
  public void d()
  {
    o();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Qaz != null) && (this.jdField_a_of_type_Qaz.a());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pxk != null) {
      this.jdField_a_of_type_Pxk.c();
    }
    a(this.jdField_a_of_type_Qaq, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Pxk != null) {
      this.jdField_a_of_type_Pxk.d();
    }
    a(this.jdField_a_of_type_Qaq, true);
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
      a(this.jdField_a_of_type_Qaq);
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
            } while (this.jdField_a_of_type_Qaz == null);
            this.jdField_a_of_type_Qaz.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Pzs == null));
        paramIntent = this.jdField_a_of_type_Pzs.a(str);
      } while (paramIntent == null);
      paramIntent.f += 1;
      this.jdField_a_of_type_Pzs.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    bbmy.a(getActivity(), -1, getString(2131633876), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new qeu(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)qft.a(2131494514, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    j();
    k();
    l();
    if (this.jdField_a_of_type_Qfe != null) {
      this.jdField_a_of_type_Qfe.c();
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Pzs != null) {
      this.jdField_a_of_type_Pzs.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Pxk != null)
    {
      this.jdField_a_of_type_Pxk.a();
      this.jdField_a_of_type_Pxk = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Pys != null)
    {
      this.jdField_a_of_type_Pys.a();
      this.jdField_a_of_type_Pys = null;
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
    if (this.jdField_a_of_type_Qfk != null)
    {
      this.jdField_a_of_type_Qfk.a();
      this.jdField_a_of_type_Qfk = null;
    }
    if (this.jdField_a_of_type_Qdn != null)
    {
      this.jdField_a_of_type_Qdn.b();
      this.jdField_a_of_type_Qdn = null;
    }
    if (this.jdField_a_of_type_Qgv != null)
    {
      this.jdField_a_of_type_Qgv.a();
      this.jdField_a_of_type_Qgv = null;
    }
    if (this.jdField_a_of_type_Qca != null)
    {
      this.jdField_a_of_type_Qca.a();
      this.jdField_a_of_type_Qca = null;
    }
    if (this.jdField_a_of_type_Qgw != null)
    {
      this.jdField_a_of_type_Qgw.a();
      this.jdField_a_of_type_Qgw = null;
    }
    if (this.jdField_a_of_type_Qhj != null) {
      this.jdField_a_of_type_Qhj.e();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      ocr.a(((VideoInfo)localObject).g);
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        while (((Iterator)localObject).hasNext()) {
          ocr.a(((VideoInfo)((Iterator)localObject).next()).g);
        }
      }
    }
    if (this.jdField_a_of_type_Qea != null)
    {
      this.jdField_a_of_type_Qea.a();
      this.jdField_a_of_type_Qea = null;
    }
    this.jdField_a_of_type_Qaq = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Qjv != null) {
      this.jdField_a_of_type_Qjv.b();
    }
    u();
    pyw.a().a();
    qji.a().b(getActivity());
    if (this.jdField_a_of_type_Qfo != null) {
      this.jdField_a_of_type_Qfo.c();
    }
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Pxk != null) {
      this.jdField_a_of_type_Pxk.b();
    }
    if (this.jdField_a_of_type_Qhj != null) {
      this.jdField_a_of_type_Qhj.d();
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
      if (this.jdField_a_of_type_Pzs != null) {
        this.jdField_a_of_type_Pzs.e(paramBoolean);
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