package com.tencent.biz.pubaccount.readinjoy.video;

import ajya;
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
import baxn;
import bbcz;
import bbwq;
import bcql;
import bfnz;
import bhvy;
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
import nmx;
import nmy;
import nol;
import npq;
import npr;
import nps;
import npu;
import oaq;
import onh;
import onz;
import osj;
import ozf;
import qjf;
import qjo;
import qkp;
import qkt;
import qlp;
import qma;
import qmc;
import qmd;
import qmf;
import qmo;
import qmp;
import qmu;
import qmy;
import qnl;
import qnv;
import qoi;
import qpi;
import qpm;
import qpv;
import qql;
import qqn;
import qqo;
import qqp;
import qqq;
import qqr;
import qqs;
import qqt;
import qqu;
import qqv;
import qqw;
import qqx;
import qqz;
import qra;
import qrb;
import qrc;
import qrd;
import qrf;
import qrh;
import qrj;
import qrn;
import qro;
import qsq;
import qsu;
import qte;
import qtf;
import qtl;
import qty;
import qvk;
import qvx;
import qza;
import qzb;
import siu;
import siv;

public class VideoFeedsRecommendFragment
  extends Fragment
  implements qmc, qrh, qrn, qtf
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
  private nmx jdField_a_of_type_Nmx;
  private nmy jdField_a_of_type_Nmy;
  private npq jdField_a_of_type_Npq;
  private npr jdField_a_of_type_Npr;
  private nps jdField_a_of_type_Nps;
  private ozf jdField_a_of_type_Ozf;
  private qjf jdField_a_of_type_Qjf;
  private qkp jdField_a_of_type_Qkp;
  private qlp jdField_a_of_type_Qlp;
  private qmp jdField_a_of_type_Qmp;
  private qmu jdField_a_of_type_Qmu;
  private qmy jdField_a_of_type_Qmy;
  private qnv jdField_a_of_type_Qnv;
  private qpi jdField_a_of_type_Qpi;
  private qpv jdField_a_of_type_Qpv;
  private qqn jdField_a_of_type_Qqn;
  private qqv jdField_a_of_type_Qqv;
  private qqw jdField_a_of_type_Qqw;
  private qqx jdField_a_of_type_Qqx;
  private qqz jdField_a_of_type_Qqz;
  private qrb jdField_a_of_type_Qrb;
  private qrc jdField_a_of_type_Qrc;
  private qrf jdField_a_of_type_Qrf;
  private qrj jdField_a_of_type_Qrj;
  private qsq jdField_a_of_type_Qsq;
  private qsu jdField_a_of_type_Qsu;
  private qte jdField_a_of_type_Qte;
  private qtl jdField_a_of_type_Qtl;
  private qvx jdField_a_of_type_Qvx;
  private siu jdField_a_of_type_Siu;
  private siv jdField_a_of_type_Siv;
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
  
  private void a(qmd paramqmd)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Qmu.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramqmd instanceof qma))
      {
        bool1 = bool2;
        if ((paramqmd instanceof qmf))
        {
          bool1 = bool2;
          if (!((qmf)paramqmd).jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(qmp paramqmp, boolean paramBoolean)
  {
    if ((paramqmp != null) && (paramqmp.jdField_a_of_type_Qql != null) && (paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        onz.b(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
    }
    else {
      return;
    }
    onz.c(paramqmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Qmp, false);
      qvk.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Qlp != null) {
        this.jdField_a_of_type_Qlp.c(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.g))) {
        this.jdField_a_of_type_Npq.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
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
    this.f = bhvy.e(this.jdField_c_of_type_Int);
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
      this.jdField_d_of_type_Int = onh.e();
      this.jdField_e_of_type_Int = npu.a();
      if (bbwq.a() != 1) {
        break label664;
      }
      bool1 = true;
      label326:
      this.jdField_c_of_type_Boolean = bool1;
      this.o = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_is_from_floating_window");
      this.jdField_a_of_type_Ozf = new qqu(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver = new KandianFavoriteBroadcastReceiver(this.jdField_a_of_type_Ozf);
      localObject = new IntentFilter();
      ((IntentFilter)localObject).addAction("com.tencent.process.fav");
      getActivity().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicKandianFavoriteBroadcastReceiver, (IntentFilter)localObject);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = baxn.a(getActivity(), 120.0F);
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
      this.jdField_a_of_type_Qrb = new qrb(this, bool1);
      qrb.a(this.jdField_a_of_type_Qrb, (List)localObject);
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
    if (bfnz.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379077));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new qpm(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Qqn = new qrd(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qqn);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Qrj = new qrj(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Qjf = new qjf(getActivity().getApplicationContext());
    this.jdField_a_of_type_Qjf.a(new qqo(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Qlp = new qlp(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_c_of_type_Int, this.jdField_a_of_type_Qrj);
    this.jdField_a_of_type_Qlp.e(getUserVisibleHint());
    this.jdField_a_of_type_Qlp.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Qlp;
    int i1;
    if (this.f)
    {
      i1 = 3;
      ((qlp)localObject).d(i1);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qjf);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Qlp.a(this);
      this.jdField_a_of_type_Qlp.a(this.jdField_d_of_type_Int, this.jdField_e_of_type_Int);
      this.jdField_a_of_type_Qlp.b(this.k);
      this.jdField_a_of_type_Qlp.c(this.h);
      this.jdField_a_of_type_Qlp.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Qlp.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Qrc = new qrc(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Qqz);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Qrc);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Qrc);
      this.jdField_a_of_type_Qmy = new qqs(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364512));
      this.jdField_a_of_type_Qmu = new qmu(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Qlp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Qmu.b();
      this.jdField_a_of_type_Qmu.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Qmu.a(this.jdField_a_of_type_Qmy);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Qmu.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qmu);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Qte = new qte(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup, this, this.jdField_b_of_type_Boolean, i1, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qte);
      this.jdField_a_of_type_Qpi = new qpi(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Qqn, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Qlp, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Qsq = new qsq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Qlp);
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qsq);
      if (this.jdField_a_of_type_Qnv == null) {
        this.jdField_a_of_type_Qnv = new qnv(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Qlp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qnv);
      if (this.jdField_a_of_type_Qsu == null) {
        this.jdField_a_of_type_Qsu = new qsu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qsu);
      this.jdField_a_of_type_Qvx = new qvx(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h);
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Qqx = new qqx(this, null);
        this.jdField_a_of_type_Qtl = new qtl(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Qqx);
        this.jdField_a_of_type_Qtl.a(false);
        this.jdField_a_of_type_Qtl.a(this.jdField_a_of_type_Qqx);
        this.jdField_a_of_type_Qtl.a(this.jdField_a_of_type_Qqx);
      }
      if (this.jdField_a_of_type_Qpv == null)
      {
        this.jdField_a_of_type_Qpv = new qpv(getActivity(), 1);
        this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qpv);
      }
      qvk.a().a(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1128;
      }
      qvk.a().e(true);
    }
    for (;;)
    {
      qvk.a().a(qvk.a().a(true), "init view set mute itself FromMutiVideo", 2);
      qkt.a().a(true);
      qkt.a().a(2);
      return;
      i1 = 1;
      break;
      label1128:
      qvk.a().e(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Nps = ((nps)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Qrf = new qrf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Qlp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Qrf.a(this);
    this.jdField_a_of_type_Qrf.a(this.jdField_a_of_type_Qlp);
    this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qrf);
    this.jdField_a_of_type_Qrj.a(this.jdField_a_of_type_Qrf);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Qrf);
    this.jdField_a_of_type_Npq = ((npq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Npr = new qra(this, null);
    this.jdField_a_of_type_Siu = ((siu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Siv = new qqt(this, null);
    this.jdField_a_of_type_Nmx = ((nmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Nmy = new qqr(this, null);
    this.jdField_a_of_type_Qqw = new qqw(this, null);
    t();
    n();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Qrb.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Qlp.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = bbcz.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Qkp = new qkp(this.jdField_a_of_type_Qlp, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qkp.a(this.n);
    this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qkp);
    this.jdField_a_of_type_Qrj.a(this.jdField_a_of_type_Qkp);
  }
  
  private void m()
  {
    this.n = bhvy.d(this.jdField_c_of_type_Int);
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
      VideoFeedsPlayActivity.a(ajya.a(2131716235) + this.g);
    } while (this.g);
    q();
    this.jdField_a_of_type_Qlp.d(1);
    this.jdField_a_of_type_Qlp.a();
  }
  
  private void p()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Nps != null) && (this.jdField_a_of_type_Qrf != null))
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
      this.jdField_a_of_type_Nps.a(this.jdField_a_of_type_Qrf.a(), l1, this.jdField_a_of_type_Qrf.a(), this.jdField_c_of_type_Int, this.jdField_a_of_type_Qrf.a());
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
    if (this.jdField_a_of_type_Nps != null)
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
      if ((this.jdField_a_of_type_Qtl != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        localObject = this.jdField_a_of_type_Qtl.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break label198;
        }
      }
      label198:
      for (int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i1 = 0)
      {
        this.g = true;
        this.jdField_a_of_type_Nps.a(this.jdField_a_of_type_Qrb, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_c_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_b_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet));
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
    if (this.jdField_a_of_type_Qvx != null) {
      this.jdField_a_of_type_Qvx.a();
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Qvx != null) {
      this.jdField_a_of_type_Qvx.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Qqw != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qqw);
    }
    if (this.jdField_a_of_type_Qrb != null) {
      getActivity().addObserver(this.jdField_a_of_type_Qrb);
    }
    if (this.jdField_a_of_type_Npr != null) {
      getActivity().addObserver(this.jdField_a_of_type_Npr);
    }
    if (this.jdField_a_of_type_Nmy != null) {
      getActivity().addObserver(this.jdField_a_of_type_Nmy);
    }
    if (this.jdField_a_of_type_Siv != null) {
      getActivity().addObserver(this.jdField_a_of_type_Siv);
    }
  }
  
  private void u()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Qqw);
    getActivity().removeObserver(this.jdField_a_of_type_Qrb);
    getActivity().removeObserver(this.jdField_a_of_type_Npr);
    getActivity().removeObserver(this.jdField_a_of_type_Nmy);
    getActivity().removeObserver(this.jdField_a_of_type_Siv);
    if (this.jdField_a_of_type_Qqv != null) {
      osj.a().b(this.jdField_a_of_type_Qqv);
    }
  }
  
  private void v()
  {
    if ((this.jdField_a_of_type_Qte != null) && (this.jdField_a_of_type_Qte.a())) {
      return;
    }
    qvk.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Qpi != null) && (this.jdField_a_of_type_Qpi.a())) {
      this.jdField_a_of_type_Qpi.a();
    }
    if (this.jdField_a_of_type_Qlp != null) {
      this.jdField_a_of_type_Qlp.e();
    }
    if ((this.jdField_a_of_type_Qjf != null) && (this.jdField_a_of_type_Qjf.a()) && (this.jdField_a_of_type_Qjf.a() != null) && (this.jdField_a_of_type_Qlp != null)) {
      this.jdField_a_of_type_Qlp.a(this.jdField_a_of_type_Qjf.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Qnv != null) {
      this.jdField_a_of_type_Qnv.k();
    }
    if ((this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null)) {
      a(this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Qtl != null) {
      this.jdField_a_of_type_Qtl.c();
    }
    a(this.jdField_a_of_type_Qmp, true);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Qmp != null) {
      return this.jdField_a_of_type_Qmp.jdField_c_of_type_Int;
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
      onh.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    o();
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Qpi != null) {
      this.jdField_a_of_type_Qpi.a((int)(paramLong / 1000.0D));
    }
    Object localObject;
    if ((this.jdField_a_of_type_Qsq != null) && ((this.jdField_a_of_type_Qmp instanceof qmp)))
    {
      localObject = this.jdField_a_of_type_Qmp;
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Qsq.a(((qmp)localObject).jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, (qmp)localObject, (int)(paramLong / 1000.0D), (int)(((qmp)localObject).jdField_a_of_type_Qql.jdField_a_of_type_Qty.b() / 1000.0D));
      }
    }
    if ((this.jdField_a_of_type_Qnv != null) && (this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qmp;
      this.jdField_a_of_type_Qnv.a((qmp)localObject, this.jdField_d_of_type_Boolean);
    }
    long l1;
    if ((this.jdField_a_of_type_Qsu != null) && (this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Qmp;
      l1 = this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_Qty.b();
      this.jdField_a_of_type_Qsu.a((qmp)localObject, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
    }
    if ((this.jdField_a_of_type_Qrf != null) && (this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_Qty != null))
    {
      localObject = this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_Qty;
      this.jdField_a_of_type_Qrf.a(((qty)localObject).a(false));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qkp != null))
    {
      localObject = this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      if ((oaq.e((VideoAdInfo)localObject)) && (oaq.a((VideoAdInfo)localObject)))
      {
        if (paramLong < l1 * 0.8D) {
          break label420;
        }
        this.jdField_a_of_type_Qkp.a((VideoAdInfo)localObject, this.jdField_a_of_type_Qmp.jdField_c_of_type_Int);
      }
    }
    label420:
    while (paramLong < l1 * 0.5D) {
      return;
    }
    this.jdField_a_of_type_Qkp.b(this.jdField_a_of_type_Qmp.jdField_c_of_type_Int);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof qmd)) {
      a((qmd)paramViewHolder);
    }
    if ((paramViewHolder instanceof qmp))
    {
      if (this.jdField_a_of_type_Qsq != null) {
        this.jdField_a_of_type_Qsq.a(this.jdField_a_of_type_Qmp);
      }
      if (this.jdField_a_of_type_Qnv != null) {
        this.jdField_a_of_type_Qnv.a((qmp)paramViewHolder);
      }
      if (this.jdField_a_of_type_Qsu != null) {
        this.jdField_a_of_type_Qsu.a(this.jdField_a_of_type_Qmp, (qmp)paramViewHolder);
      }
      this.jdField_a_of_type_Qjf.a((qmp)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a((qmp)paramViewHolder);
      a(this.jdField_a_of_type_Qmp, false);
      this.jdField_a_of_type_Qmp = ((qmp)paramViewHolder);
      a(this.jdField_a_of_type_Qmp, true);
      if ((this.jdField_a_of_type_Qpi != null) && ((this.jdField_a_of_type_Qmp instanceof qmo))) {
        this.jdField_a_of_type_Qpi.a((qmo)this.jdField_a_of_type_Qmp, qrc.a(this.jdField_a_of_type_Qrc));
      }
      if (((this.jdField_a_of_type_Qte == null) || (this.jdField_a_of_type_Qmp == null) || (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql == null)) || (this.jdField_a_of_type_Qmp.jdField_c_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_Qvx != null) {
          this.jdField_a_of_type_Qvx.b(false);
        }
        r();
      }
      if ((this.jdField_a_of_type_Qmp.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Qmp.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Qmp.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Qmp.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
      }
    }
    if (this.jdField_a_of_type_Qqz != null)
    {
      boolean bool = paramViewHolder instanceof qma;
      this.jdField_a_of_type_Qqz.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Qvx != null) {
      this.jdField_a_of_type_Qvx.a(paramBoolean);
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
          str1 = new qzb(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.g)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.g;
          label139:
          nol.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Qmp instanceof qmf)) {
          this.jdField_a_of_type_Qtl.a(this.jdField_a_of_type_Qqx.a(this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
    } while (this.jdField_a_of_type_Qtl == null);
    paramBoolean = this.jdField_a_of_type_Qtl.b();
    this.jdField_a_of_type_Qtl.a();
    this.jdField_a_of_type_Qtl.b();
    this.jdField_a_of_type_Qqx.a(paramBoolean);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Qmp == null) {}
    List localList;
    do
    {
      return;
      this.jdField_a_of_type_Qmp.l.setVisibility(8);
      this.jdField_a_of_type_Qmp.o.setVisibility(8);
      this.jdField_a_of_type_Qmp.k.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      }
      localList = qoi.a(this.jdField_a_of_type_JavaUtilArrayList, a());
      localObject = qoi.a(localList);
    } while (localObject == null);
    Object localObject = qnl.a(((VideoInfo)localObject).jdField_b_of_type_Int, ((VideoInfo)localObject).jdField_c_of_type_Int);
    qoi.a(this.jdField_a_of_type_Qmp.itemView, paramViewGroup, (int[])localObject, new qqq(this, localList));
    if (this.jdField_a_of_type_Qqv == null) {
      this.jdField_a_of_type_Qqv = new qqv(this, null);
    }
    osj.a().a(this.jdField_a_of_type_Qqv);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Siu != null) {
      this.jdField_a_of_type_Siu.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(qmp paramqmp) {}
  
  public void a(qqz paramqqz)
  {
    this.jdField_a_of_type_Qqz = paramqqz;
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
      if ((this.jdField_a_of_type_Qmu != null) && (this.jdField_a_of_type_Qmu.a()))
      {
        this.jdField_a_of_type_Qmu.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Qmp == null) || (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    qzb localqzb = new qzb(localVideoInfo);
    localqzb.h(localVideoInfo.g).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).n(this.jdField_a_of_type_Qmp.jdField_b_of_type_Int).m(this.jdField_a_of_type_Qmp.jdField_c_of_type_Int);
    localqzb.p(1).h(localVideoInfo.g);
    nol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localqzb.a().a(), false);
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
    if ((this.jdField_a_of_type_Qmp != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        qvk.a().a(paramInt);
        if (this.jdField_a_of_type_Qmp == null) {
          break;
        }
        this.jdField_a_of_type_Qmp.jdField_a_of_type_Qjo.a(qvk.a().a());
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Qmp != null) {
      return this.jdField_a_of_type_Qmp.jdField_c_of_type_Int;
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
    if ((this.jdField_a_of_type_Qmp != null) && (this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql != null)) {
      return this.jdField_a_of_type_Qmp.jdField_a_of_type_Qql.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
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
    } while ((this.jdField_a_of_type_Qmu == null) || (!this.jdField_a_of_type_Qmu.a()));
    this.jdField_a_of_type_Qmu.h();
    return true;
  }
  
  public void d()
  {
    o();
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Qmu != null) && (this.jdField_a_of_type_Qmu.a());
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Qjf != null) {
      this.jdField_a_of_type_Qjf.c();
    }
    a(this.jdField_a_of_type_Qmp, false);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Qjf != null) {
      this.jdField_a_of_type_Qjf.d();
    }
    a(this.jdField_a_of_type_Qmp, true);
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
      a(this.jdField_a_of_type_Qmp);
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
            } while (this.jdField_a_of_type_Qmu == null);
            this.jdField_a_of_type_Qmu.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Qlp == null));
        paramIntent = this.jdField_a_of_type_Qlp.a(str);
      } while (paramIntent == null);
      paramIntent.f += 1;
      this.jdField_a_of_type_Qlp.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    bcql.a(getActivity(), -1, getString(2131699675), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new qqp(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)qro.a(2131560086, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)onh.a());
    j();
    k();
    l();
    if (this.jdField_a_of_type_Qqz != null) {
      this.jdField_a_of_type_Qqz.c();
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Qlp != null) {
      this.jdField_a_of_type_Qlp.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Qjf != null)
    {
      this.jdField_a_of_type_Qjf.a();
      this.jdField_a_of_type_Qjf = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Qkp != null)
    {
      this.jdField_a_of_type_Qkp.a();
      this.jdField_a_of_type_Qkp = null;
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
    if (this.jdField_a_of_type_Qrf != null)
    {
      this.jdField_a_of_type_Qrf.a();
      this.jdField_a_of_type_Qrf = null;
    }
    if (this.jdField_a_of_type_Qpi != null)
    {
      this.jdField_a_of_type_Qpi.b();
      this.jdField_a_of_type_Qpi = null;
    }
    if (this.jdField_a_of_type_Qsq != null)
    {
      this.jdField_a_of_type_Qsq.a();
      this.jdField_a_of_type_Qsq = null;
    }
    if (this.jdField_a_of_type_Qnv != null)
    {
      this.jdField_a_of_type_Qnv.a();
      this.jdField_a_of_type_Qnv = null;
    }
    if (this.jdField_a_of_type_Qsu != null)
    {
      this.jdField_a_of_type_Qsu.a();
      this.jdField_a_of_type_Qsu = null;
    }
    if (this.jdField_a_of_type_Qtl != null) {
      this.jdField_a_of_type_Qtl.e();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      onz.a(((VideoInfo)localObject).g);
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        while (((Iterator)localObject).hasNext()) {
          onz.a(((VideoInfo)((Iterator)localObject).next()).g);
        }
      }
    }
    if (this.jdField_a_of_type_Qpv != null)
    {
      this.jdField_a_of_type_Qpv.a();
      this.jdField_a_of_type_Qpv = null;
    }
    this.jdField_a_of_type_Qmp = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Qvx != null) {
      this.jdField_a_of_type_Qvx.b();
    }
    u();
    qkt.a().a();
    qvk.a().b(getActivity());
    if (this.jdField_a_of_type_Qrj != null) {
      this.jdField_a_of_type_Qrj.c();
    }
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Qjf != null) {
      this.jdField_a_of_type_Qjf.b();
    }
    if (this.jdField_a_of_type_Qtl != null) {
      this.jdField_a_of_type_Qtl.d();
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
      if (this.jdField_a_of_type_Qlp != null) {
        this.jdField_a_of_type_Qlp.e(paramBoolean);
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