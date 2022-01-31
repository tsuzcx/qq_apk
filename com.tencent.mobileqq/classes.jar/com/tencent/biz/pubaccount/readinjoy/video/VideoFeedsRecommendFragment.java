package com.tencent.biz.pubaccount.readinjoy.video;

import alud;
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
import bdaq;
import bdgc;
import beaa;
import bhtb;
import bkbq;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import npt;
import npu;
import nrt;
import nsz;
import nta;
import ntb;
import ntd;
import oed;
import ors;
import osk;
import oxb;
import pen;
import qym;
import qyv;
import qzw;
import raa;
import raw;
import rbi;
import rbk;
import rbl;
import rbn;
import rbs;
import rbt;
import rby;
import rcc;
import rcp;
import rcz;
import rdm;
import rem;
import req;
import rez;
import rfs;
import rfu;
import rfv;
import rfw;
import rfx;
import rfy;
import rfz;
import rga;
import rgb;
import rgc;
import rgd;
import rge;
import rgf;
import rgh;
import rgi;
import rgj;
import rgk;
import rgl;
import rgn;
import rgp;
import rgr;
import rgv;
import rgw;
import rgx;
import rha;
import ric;
import rig;
import riq;
import rir;
import rja;
import rjn;
import rlb;
import rlo;
import rom;
import ron;
import tap;
import taq;

public class VideoFeedsRecommendFragment
  extends Fragment
  implements rbk, rgp, rgv, rir
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private npt jdField_a_of_type_Npt;
  private npu jdField_a_of_type_Npu;
  private nsz jdField_a_of_type_Nsz;
  private nta jdField_a_of_type_Nta;
  private ntb jdField_a_of_type_Ntb;
  private pen jdField_a_of_type_Pen;
  private qym jdField_a_of_type_Qym;
  private qzw jdField_a_of_type_Qzw;
  private raw jdField_a_of_type_Raw;
  private rbt jdField_a_of_type_Rbt;
  private rby jdField_a_of_type_Rby;
  private rcc jdField_a_of_type_Rcc;
  private rcz jdField_a_of_type_Rcz;
  private rem jdField_a_of_type_Rem;
  private rez jdField_a_of_type_Rez;
  private rfu jdField_a_of_type_Rfu;
  private rgd jdField_a_of_type_Rgd;
  private rge jdField_a_of_type_Rge;
  private rgf jdField_a_of_type_Rgf;
  private rgh jdField_a_of_type_Rgh;
  private rgj jdField_a_of_type_Rgj;
  private rgk jdField_a_of_type_Rgk;
  private rgn jdField_a_of_type_Rgn;
  private rgr jdField_a_of_type_Rgr;
  private rgw jdField_a_of_type_Rgw;
  private rgx jdField_a_of_type_Rgx;
  private ric jdField_a_of_type_Ric;
  private rig jdField_a_of_type_Rig;
  private riq jdField_a_of_type_Riq;
  private rja jdField_a_of_type_Rja;
  private rlo jdField_a_of_type_Rlo;
  private tap jdField_a_of_type_Tap;
  private taq jdField_a_of_type_Taq;
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
  private boolean jdField_f_of_type_Boolean;
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
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.g)) && (!TextUtils.isEmpty(paramVideoInfo.u))) {
      RIJRedPacketManager.a().a(paramVideoInfo.g, paramVideoInfo.u, 4, new rfw(this, paramVideoInfo, paramInt));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.j)) || (paramVideoInfo.jdField_b_of_type_Boolean)) {
      return;
    }
    ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
  }
  
  private void a(rbl paramrbl)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Rby.a()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(paramrbl instanceof rbi))
      {
        bool1 = bool2;
        if ((paramrbl instanceof rbn))
        {
          bool1 = bool2;
          if (!((rbn)paramrbl).jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(rbt paramrbt, boolean paramBoolean)
  {
    if ((paramrbt != null) && (paramrbt.jdField_a_of_type_Rfs != null) && (paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramBoolean) {
        osk.b(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
      }
    }
    else {
      return;
    }
    osk.c(paramrbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
  }
  
  private void b(int paramInt)
  {
    if ((this.m) && (paramInt == 1)) {
      this.m = false;
    }
    do
    {
      return;
      a(this.jdField_a_of_type_Rbt, false);
      rlb.a().a(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Raw != null) {
        this.jdField_a_of_type_Raw.c(paramInt);
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.f();
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.jdField_a_of_type_Int != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.g))) {
        this.jdField_a_of_type_Nsz.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g);
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
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.jdField_f_of_type_Boolean = bkbq.e(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label242:
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.j = bool1;
      if (this.j) {
        break label675;
      }
      bool1 = true;
      this.k = bool1;
      if ((this.jdField_a_of_type_Long <= 0L) || (!this.j)) {
        break label680;
      }
      bool1 = true;
      label265:
      this.l = bool1;
      this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.n = bkbq.d(this.jdField_d_of_type_Int);
      this.jdField_e_of_type_Int = ors.e();
      this.jdField_f_of_type_Int = ntd.a();
      if (beaa.a() != 1) {
        break label685;
      }
      bool1 = true;
      label347:
      this.jdField_c_of_type_Boolean = bool1;
      this.o = this.jdField_a_of_type_AndroidOsBundle.getBoolean("key_is_from_floating_window");
      this.jdField_a_of_type_Pen = new rgc(this, null);
      if (jdField_a_of_type_Int <= 0) {
        jdField_a_of_type_Int = bdaq.a(getActivity(), 120.0F);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 1) {
        break label690;
      }
    }
    label675:
    label680:
    label685:
    label690:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Rgj = new rgj(this, bool1);
      rgj.a(this.jdField_a_of_type_Rgj, localArrayList);
      if ((RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e()) && ((this.jdField_d_of_type_Int == 0) || (this.jdField_d_of_type_Int >= 100))) {
        a(0, this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVid  eoFromType = " + this.jdField_d_of_type_Int);
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mBundle = " + this.jdField_a_of_type_AndroidOsBundle.toString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoDataList[0] = " + this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.b());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() needReloadTitle = " + this.jdField_e_of_type_Boolean + ", showSingleVideo = " + this.jdField_f_of_type_Boolean + ", mFirstVideoStartPosition = " + this.jdField_a_of_type_Long);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label242;
      bool1 = false;
      break label265;
      bool1 = false;
      break label347;
    }
  }
  
  private void k()
  {
    if (bhtb.d()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379813));
    VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new req(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Rfu = new rgl(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rfu);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.d(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(this.n);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.h(this.h);
    this.jdField_a_of_type_Rgr = new rgr(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.l, this.n, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Qym = new qym(getActivity().getApplicationContext());
    this.jdField_a_of_type_Qym.a(new rfv(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Raw = new raw(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_Rgr);
    this.jdField_a_of_type_Raw.e(getUserVisibleHint());
    this.jdField_a_of_type_Raw.a(this.jdField_e_of_type_Boolean);
    Object localObject = this.jdField_a_of_type_Raw;
    int i1;
    if (this.jdField_f_of_type_Boolean)
    {
      i1 = 3;
      ((raw)localObject).d(i1);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Qym);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Raw.a(this);
      this.jdField_a_of_type_Raw.a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_Raw.b(this.k);
      this.jdField_a_of_type_Raw.c(this.h);
      this.jdField_a_of_type_Raw.d(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_Raw.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Long);
      if (this.jdField_a_of_type_AndroidOsBundle != null) {}
      this.jdField_a_of_type_Rgk = new rgk(this, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_Rgh);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_Rgk);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_Rgk);
      this.jdField_a_of_type_Rcc = new rga(this, null);
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364588));
      this.jdField_a_of_type_Rby = new rby(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Raw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Rby.b();
      this.jdField_a_of_type_Rby.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_Rby.a(this.jdField_a_of_type_Rcc);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Rby.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Rby);
      i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Riq = new riq(getActivity(), this.jdField_a_of_type_AndroidViewViewGroup, this, this.jdField_b_of_type_Boolean, i1, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Riq);
      this.jdField_a_of_type_Rem = new rem(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Rfu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Raw, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_Ric = new ric(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Raw);
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Ric);
      if (this.jdField_a_of_type_Rcz == null) {
        this.jdField_a_of_type_Rcz = new rcz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_Raw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Rcz);
      if (this.jdField_a_of_type_Rig == null) {
        this.jdField_a_of_type_Rig = new rig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Rig);
      this.jdField_a_of_type_Rlo = new rlo(getActivity(), getActivity().getAppRuntime(), this.jdField_a_of_type_AndroidViewViewGroup, true, this.h);
      if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_Rgf = new rgf(this, null);
        this.jdField_a_of_type_Rja = new rja(getActivity(), (FrameLayout)this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_Rgf);
        this.jdField_a_of_type_Rja.a(false);
        this.jdField_a_of_type_Rja.a(this.jdField_a_of_type_Rgf);
        this.jdField_a_of_type_Rja.a(this.jdField_a_of_type_Rgf);
      }
      if (this.jdField_a_of_type_Rez == null)
      {
        this.jdField_a_of_type_Rez = new rez(getActivity(), 1);
        this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Rez);
      }
      rlb.a().a(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1128;
      }
      rlb.a().e(true);
    }
    for (;;)
    {
      rlb.a().a(rlb.a().a(true), "init view set mute itself FromMutiVideo", 2);
      raa.a().a(true);
      raa.a().a(2);
      return;
      i1 = 1;
      break;
      label1128:
      rlb.a().e(false);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_Ntb = ((ntb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(90));
    this.jdField_a_of_type_Ntb.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Rgn = new rgn(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Raw, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Rgn.a(this);
    this.jdField_a_of_type_Rgn.a(this.jdField_a_of_type_Raw);
    this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Rgn);
    this.jdField_a_of_type_Rgr.a(this.jdField_a_of_type_Rgn);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Rgn);
    this.jdField_a_of_type_Nsz = ((nsz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(99));
    this.jdField_a_of_type_Nta = new rgi(this, null);
    this.jdField_a_of_type_Tap = ((tap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(126));
    this.jdField_a_of_type_Taq = new rgb(this, null);
    this.jdField_a_of_type_Npt = ((npt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(93));
    this.jdField_a_of_type_Npu = new rfz(this, null);
    this.jdField_a_of_type_Rge = new rge(this, null);
    s();
    m();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_Rgj.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Raw.a(i1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    this.jdField_a_of_type_Qzw = new qzw(this.jdField_a_of_type_Raw, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qzw.a(this.n);
    this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Qzw);
    this.jdField_a_of_type_Rgr.a(this.jdField_a_of_type_Qzw);
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
      VideoFeedsPlayActivity.a(alud.a(2131716619) + this.g);
    } while (this.g);
    p();
    this.jdField_a_of_type_Raw.d(1);
    this.jdField_a_of_type_Raw.a();
  }
  
  private void o()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_Ntb != null) && (this.jdField_a_of_type_Rgn != null))
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
      this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Rgn.a(), l1, this.jdField_a_of_type_Rgn.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_Rgn.a());
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
    if (this.jdField_a_of_type_Ntb != null)
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
      if ((this.jdField_a_of_type_Rja != null) && (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        localObject = this.jdField_a_of_type_Rja.a(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null)) {
          break label198;
        }
      }
      label198:
      for (int i1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int;; i1 = 0)
      {
        this.g = true;
        this.jdField_a_of_type_Ntb.a(this.jdField_a_of_type_Rgj, l1, (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, ((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0)).i, this.jdField_b_of_type_Long, true, i1, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, this.jdField_c_of_type_Int, (String)localObject, this.jdField_a_of_type_ArrayOfByte, 0, new ArrayList(this.jdField_a_of_type_JavaUtilHashSet));
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
  
  private void q()
  {
    if (this.jdField_a_of_type_Rlo != null) {
      this.jdField_a_of_type_Rlo.a();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Rlo != null) {
      this.jdField_a_of_type_Rlo.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Rge != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rge);
    }
    if (this.jdField_a_of_type_Rgj != null) {
      getActivity().addObserver(this.jdField_a_of_type_Rgj);
    }
    if (this.jdField_a_of_type_Nta != null) {
      getActivity().addObserver(this.jdField_a_of_type_Nta);
    }
    if (this.jdField_a_of_type_Npu != null) {
      getActivity().addObserver(this.jdField_a_of_type_Npu);
    }
    if (this.jdField_a_of_type_Taq != null) {
      getActivity().addObserver(this.jdField_a_of_type_Taq);
    }
  }
  
  private void t()
  {
    getActivity().removeObserver(this.jdField_a_of_type_Rge);
    getActivity().removeObserver(this.jdField_a_of_type_Rgj);
    getActivity().removeObserver(this.jdField_a_of_type_Nta);
    getActivity().removeObserver(this.jdField_a_of_type_Npu);
    getActivity().removeObserver(this.jdField_a_of_type_Taq);
    if (this.jdField_a_of_type_Rgd != null) {
      oxb.a().b(this.jdField_a_of_type_Rgd);
    }
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_Riq != null) && (this.jdField_a_of_type_Riq.a())) {
      return;
    }
    rlb.a().a(true, "videoFeeds doOnResume");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
    }
    if ((this.jdField_a_of_type_Rem != null) && (this.jdField_a_of_type_Rem.a())) {
      this.jdField_a_of_type_Rem.a();
    }
    if (this.jdField_a_of_type_Raw != null) {
      this.jdField_a_of_type_Raw.e();
    }
    if ((this.jdField_a_of_type_Qym != null) && (this.jdField_a_of_type_Qym.a()) && (this.jdField_a_of_type_Qym.a() != null) && (this.jdField_a_of_type_Raw != null)) {
      this.jdField_a_of_type_Raw.a(this.jdField_a_of_type_Qym.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a();
    }
    if (this.jdField_a_of_type_Rcz != null) {
      this.jdField_a_of_type_Rcz.k();
    }
    if ((this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null)) {
      a(this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    }
    if (this.jdField_a_of_type_Rja != null) {
      this.jdField_a_of_type_Rja.c();
    }
    a(this.jdField_a_of_type_Rbt, true);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Rbt != null) {
      return this.jdField_a_of_type_Rbt.jdField_c_of_type_Int;
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
      ors.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    n();
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Rem != null) {
      this.jdField_a_of_type_Rem.a((int)(paramLong / 1000.0D));
    }
    Object localObject;
    if ((this.jdField_a_of_type_Ric != null) && ((this.jdField_a_of_type_Rbt instanceof rbt)))
    {
      localObject = this.jdField_a_of_type_Rbt;
      if (!this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_Ric.a(((rbt)localObject).jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo, (rbt)localObject, (int)(paramLong / 1000.0D), (int)(((rbt)localObject).jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.b() / 1000.0D));
      }
    }
    if ((this.jdField_a_of_type_Rcz != null) && (this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Rbt;
      this.jdField_a_of_type_Rcz.a((rbt)localObject, this.jdField_d_of_type_Boolean);
    }
    long l1;
    if ((this.jdField_a_of_type_Rig != null) && (this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      localObject = this.jdField_a_of_type_Rbt;
      l1 = this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn.b();
      this.jdField_a_of_type_Rig.a((rbt)localObject, this.jdField_d_of_type_Boolean, paramLong * 100.0D / l1, l1);
    }
    if ((this.jdField_a_of_type_Rgn != null) && (this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn != null))
    {
      localObject = this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_Rjn;
      this.jdField_a_of_type_Rgn.a(((rjn)localObject).a(false));
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Qzw != null))
    {
      localObject = this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo;
      l1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.b();
      if ((oed.e((VideoAdInfo)localObject)) && (oed.a((VideoAdInfo)localObject)))
      {
        if (paramLong < l1 * 0.8D) {
          break label420;
        }
        this.jdField_a_of_type_Qzw.a((VideoAdInfo)localObject, this.jdField_a_of_type_Rbt.jdField_c_of_type_Int);
      }
    }
    label420:
    while (paramLong < l1 * 0.5D) {
      return;
    }
    this.jdField_a_of_type_Qzw.b(this.jdField_a_of_type_Rbt.jdField_c_of_type_Int);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder instanceof rbl)) {
      a((rbl)paramViewHolder);
    }
    if ((paramViewHolder instanceof rbt))
    {
      if (this.jdField_a_of_type_Ric != null) {
        this.jdField_a_of_type_Ric.a(this.jdField_a_of_type_Rbt);
      }
      if (this.jdField_a_of_type_Rcz != null) {
        this.jdField_a_of_type_Rcz.a((rbt)paramViewHolder);
      }
      if (this.jdField_a_of_type_Rig != null) {
        this.jdField_a_of_type_Rig.a(this.jdField_a_of_type_Rbt, (rbt)paramViewHolder);
      }
      this.jdField_a_of_type_Qym.a((rbt)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.a((rbt)paramViewHolder);
      a(this.jdField_a_of_type_Rbt, false);
      this.jdField_a_of_type_Rbt = ((rbt)paramViewHolder);
      a(this.jdField_a_of_type_Rbt, true);
      if ((this.jdField_a_of_type_Rem != null) && ((this.jdField_a_of_type_Rbt instanceof rbs))) {
        this.jdField_a_of_type_Rem.a((rbs)this.jdField_a_of_type_Rbt, rgk.a(this.jdField_a_of_type_Rgk));
      }
      if (((this.jdField_a_of_type_Riq == null) || (this.jdField_a_of_type_Rbt == null) || (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs == null)) || (this.jdField_a_of_type_Rbt.jdField_c_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_Rlo != null) {
          this.jdField_a_of_type_Rlo.b(false);
        }
        q();
      }
      if ((this.jdField_a_of_type_Rbt.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Rbt.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Rbt.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
        VideoFeedsAccessibilityHelper.a(this.jdField_a_of_type_Rbt.jdField_a_of_type_AndroidViewViewGroup, localVideoInfo.a() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localVideoInfo);
        if (this.jdField_a_of_type_Rgx != null) {
          this.jdField_a_of_type_Rgx.a(localVideoInfo);
        }
      }
    }
    if (this.jdField_a_of_type_Rgh != null)
    {
      boolean bool = paramViewHolder instanceof rbi;
      this.jdField_a_of_type_Rgh.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_Rlo != null) {
      this.jdField_a_of_type_Rlo.a(paramBoolean);
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
          str1 = new ron(str1, paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.g, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(), paramViewHolder.a() * 1000L).a(409409).a().a();
          String str2 = paramViewHolder.j;
          if (TextUtils.isEmpty(paramViewHolder.g)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.g;
          label139:
          nrt.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g(false);
        }
        if ((this.jdField_a_of_type_Rbt instanceof rbn)) {
          this.jdField_a_of_type_Rja.a(this.jdField_a_of_type_Rgf.a(this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo), 0);
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
    } while (this.jdField_a_of_type_Rja == null);
    paramBoolean = this.jdField_a_of_type_Rja.b();
    this.jdField_a_of_type_Rja.a();
    this.jdField_a_of_type_Rja.b();
    this.jdField_a_of_type_Rgf.a(paramBoolean);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Rbt == null) {}
    List localList;
    do
    {
      return;
      this.jdField_a_of_type_Rbt.m.setVisibility(8);
      this.jdField_a_of_type_Rbt.p.setVisibility(8);
      this.jdField_a_of_type_Rbt.l.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
      }
      localList = rdm.a(this.jdField_a_of_type_JavaUtilArrayList, a());
      localObject = rdm.a(localList);
    } while (localObject == null);
    Object localObject = rcp.a(((VideoInfo)localObject).jdField_b_of_type_Int, ((VideoInfo)localObject).jdField_c_of_type_Int);
    rdm.a(this.jdField_a_of_type_Rbt.itemView, paramViewGroup, (int[])localObject, new rfy(this, localList));
    if (this.jdField_a_of_type_Rgd == null) {
      this.jdField_a_of_type_Rgd = new rgd(this, null);
    }
    oxb.a().a(this.jdField_a_of_type_Rgd);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tap != null) {
      this.jdField_a_of_type_Tap.a(paramVideoInfo, paramBoolean);
    }
  }
  
  public void a(rbt paramrbt) {}
  
  public void a(rgh paramrgh)
  {
    this.jdField_a_of_type_Rgh = paramrgh;
  }
  
  public void a(rgw paramrgw)
  {
    this.jdField_a_of_type_Rgw = paramrgw;
  }
  
  public void a(rgx paramrgx)
  {
    this.jdField_a_of_type_Rgx = paramrgx;
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
      if ((this.jdField_a_of_type_Rby != null) && (this.jdField_a_of_type_Rby.a()))
      {
        this.jdField_a_of_type_Rby.h();
        return true;
      }
    } while ((this.jdField_a_of_type_Rbt == null) || (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs == null));
    VideoInfo localVideoInfo = this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
    ron localron = new ron(localVideoInfo);
    localron.h(localVideoInfo.g).l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_Rbt.jdField_b_of_type_Int).l(this.jdField_a_of_type_Rbt.jdField_c_of_type_Int);
    localron.o(1).h(localVideoInfo.g);
    nrt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, "0X8009953", "0X8009953", 0, 0, "", "", "", localron.a().a(), false);
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
    if ((this.jdField_a_of_type_Rbt != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        rlb.a().a(paramInt);
        if (this.jdField_a_of_type_Rbt == null) {
          break;
        }
        this.jdField_a_of_type_Rbt.jdField_a_of_type_Qyv.a(rlb.a().a());
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Rbt != null) {
      return this.jdField_a_of_type_Rbt.jdField_c_of_type_Int;
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
      return (VideoInfo)localVideoInfo.d.get(localVideoInfo.l);
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
    return false;
  }
  
  public VideoInfo c()
  {
    if ((this.jdField_a_of_type_Rbt != null) && (this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs != null)) {
      return this.jdField_a_of_type_Rbt.jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
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
    } while ((this.jdField_a_of_type_Rby == null) || (!this.jdField_a_of_type_Rby.a()));
    this.jdField_a_of_type_Rby.h();
    return true;
  }
  
  public void d()
  {
    n();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Rgr.a();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Qym != null) {
      this.jdField_a_of_type_Qym.c();
    }
    a(this.jdField_a_of_type_Rbt, false);
  }
  
  public boolean e()
  {
    return (this.jdField_a_of_type_Rby != null) && (this.jdField_a_of_type_Rby.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Qym != null) {
      this.jdField_a_of_type_Qym.d();
    }
    a(this.jdField_a_of_type_Rbt, true);
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
      a(this.jdField_a_of_type_Rbt);
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
            } while (this.jdField_a_of_type_Rby == null);
            this.jdField_a_of_type_Rby.a(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Raw == null));
        paramIntent = this.jdField_a_of_type_Raw.a(str);
      } while (paramIntent == null);
      paramIntent.jdField_f_of_type_Int += 1;
      this.jdField_a_of_type_Raw.b(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131700055), 0).b(getActivity().getTitleBarHeight());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new rfx(this, paramConfiguration);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)rha.a(2131560187, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    j();
    k();
    l();
    if (this.jdField_a_of_type_Rgh != null) {
      this.jdField_a_of_type_Rgh.c();
    }
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Raw != null) {
      this.jdField_a_of_type_Raw.f();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_a_of_type_Qym != null)
    {
      this.jdField_a_of_type_Qym.a();
      this.jdField_a_of_type_Qym = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.c();
    }
    if (this.jdField_a_of_type_Qzw != null)
    {
      this.jdField_a_of_type_Qzw.a();
      this.jdField_a_of_type_Qzw = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.d();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    if (this.jdField_a_of_type_Rgn != null)
    {
      this.jdField_a_of_type_Rgn.a();
      this.jdField_a_of_type_Rgn = null;
    }
    if (this.jdField_a_of_type_Rem != null)
    {
      this.jdField_a_of_type_Rem.b();
      this.jdField_a_of_type_Rem = null;
    }
    if (this.jdField_a_of_type_Ric != null)
    {
      this.jdField_a_of_type_Ric.a();
      this.jdField_a_of_type_Ric = null;
    }
    if (this.jdField_a_of_type_Rcz != null)
    {
      this.jdField_a_of_type_Rcz.a();
      this.jdField_a_of_type_Rcz = null;
    }
    if (this.jdField_a_of_type_Rig != null)
    {
      this.jdField_a_of_type_Rig.a();
      this.jdField_a_of_type_Rig = null;
    }
    if (this.jdField_a_of_type_Rja != null) {
      this.jdField_a_of_type_Rja.e();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      osk.a(((VideoInfo)localObject).g);
      if (((VideoInfo)localObject).d != null)
      {
        localObject = ((VideoInfo)localObject).d.iterator();
        while (((Iterator)localObject).hasNext()) {
          osk.a(((VideoInfo)((Iterator)localObject).next()).g);
        }
      }
    }
    if (this.jdField_a_of_type_Rez != null)
    {
      this.jdField_a_of_type_Rez.a();
      this.jdField_a_of_type_Rez = null;
    }
    this.jdField_a_of_type_Rbt = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_Rlo != null) {
      this.jdField_a_of_type_Rlo.b();
    }
    t();
    raa.a().a();
    rlb.a().b(getActivity());
    if (this.jdField_a_of_type_Rgr != null) {
      this.jdField_a_of_type_Rgr.c();
    }
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    b(1);
    if (this.jdField_a_of_type_Qym != null) {
      this.jdField_a_of_type_Qym.b();
    }
    if (this.jdField_a_of_type_Rja != null) {
      this.jdField_a_of_type_Rja.d();
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
      if (this.jdField_a_of_type_Raw != null) {
        this.jdField_a_of_type_Raw.e(paramBoolean);
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