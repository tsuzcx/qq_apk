package com.tencent.biz.pubaccount.readinjoy.view;

import abbs;
import afur;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anmu;
import anni;
import anxu;
import aobu;
import avjm;
import avju;
import bdch;
import bgnt;
import bgnw;
import bgsg;
import bkhe;
import bkij;
import bkik;
import bkqc;
import bmqa;
import bqcd;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nxp;
import nxw;
import oat;
import och;
import ofx;
import ogd;
import ogh;
import ogr;
import ohj;
import ohp;
import omp;
import ooi;
import oqj;
import oqr;
import org.json.JSONException;
import org.json.JSONObject;
import ouj;
import ovb;
import ovs;
import paa;
import pfe;
import pfk;
import pfr;
import pga;
import pgk;
import pgm;
import pgw;
import pha;
import phl;
import php;
import pig;
import pih;
import pil;
import pjr;
import plz;
import pmb;
import pmh;
import pmk;
import pmm;
import pmn;
import pmy;
import pnn;
import pnp;
import ptq;
import ptu;
import ptw;
import ptx;
import ptz;
import pud;
import pue;
import pum;
import pvf;
import pvq;
import pwi;
import pwl;
import pwt;
import pxt;
import qib;
import qnh;
import qqm;
import qqt;
import qyo;
import rat;
import rcx;
import rec;
import rev;
import rfv;
import rfw;
import rfz;
import rga;
import rgc;
import rgf;
import rgh;
import rgi;
import rha;
import rhr;
import rhs;
import rhu;
import rhw;
import rhy;
import rii;
import rik;
import roq;
import rvr;
import rvt;
import ryx;
import seu;
import sey;
import sfn;
import sfx;
import sgc;
import skb;
import skc;
import sng;
import snh;
import soy;
import soz;
import spa;
import spb;
import spj;
import sqh;
import sqk;
import sql;
import sqm;
import sqn;
import sqo;
import sqp;
import sqr;
import sqs;
import sqt;
import squ;
import sqv;
import sqw;
import sqx;
import sqy;
import sqz;
import sra;
import srb;
import src;
import srd;
import sre;
import srg;
import srh;
import sri;
import srj;
import srk;
import srl;
import srm;
import srn;
import sro;
import srp;
import srq;
import srr;
import srs;
import srt;
import sud;
import suf;
import suh;
import tch;
import tcj;
import tcx;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tfd;
import tff;
import tlg;
import tzo;
import uac;
import uad;
import uaq;
import ubb;
import ube;
import ubj;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bkij, bkik, sfx, soy, soz, spa, spb, spj
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<ptx> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anmu jdField_a_of_type_Anmu = new srk(this);
  protected aobu a;
  private bkhe jdField_a_of_type_Bkhe = new sqh(this);
  private bkqc jdField_a_of_type_Bkqc = new sre(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new srp(this);
  private nxp jdField_a_of_type_Nxp;
  private ohj jdField_a_of_type_Ohj;
  private ovb jdField_a_of_type_Ovb;
  ovs jdField_a_of_type_Ovs;
  private plz jdField_a_of_type_Plz = new sri(this);
  private pmb jdField_a_of_type_Pmb = new srh(this);
  private pmn jdField_a_of_type_Pmn = new srn(this);
  private roq jdField_a_of_type_Roq = new sro(this);
  private rvr jdField_a_of_type_Rvr;
  private sng jdField_a_of_type_Sng;
  srt jdField_a_of_type_Srt;
  private suh jdField_a_of_type_Suh;
  private tff jdField_a_of_type_Tff;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChannelTopPositionView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new srq(this);
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  private List<tcj> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long = -1L;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  
  public ReadInJoyListViewGroup(ogd paramogd, int paramInt1, int paramInt2, int paramInt3, pgm parampgm)
  {
    this(paramogd, paramInt1, paramInt2, paramInt3, parampgm, 2131560266);
  }
  
  public ReadInJoyListViewGroup(ogd paramogd, int paramInt1, int paramInt2, int paramInt3, pgm parampgm, int paramInt4)
  {
    super(paramogd, paramInt1, parampgm);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_f_of_type_Boolean = ryx.b();
    setId(2131376050);
    this.jdField_a_of_type_AndroidUtilSparseArray = pud.a(this);
    b(paramInt1);
    if (paramInt1 != 41695) {
      C();
    }
    this.jdField_a_of_type_Pgm.jdField_c_of_type_Long = bmqa.a((QQAppInterface)pha.a());
    a(new sqs(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(ogd paramogd, int paramInt1, int paramInt2, pgm parampgm)
  {
    this(paramogd, paramInt1, paramInt2, -1, parampgm);
  }
  
  public ReadInJoyListViewGroup(ogd paramogd, int paramInt, pgm parampgm)
  {
    this(paramogd, paramInt, -1, parampgm);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Rvr = rvr.a();
    this.jdField_a_of_type_Rvr.a(this.jdField_e_of_type_Long);
    if (this.jdField_a_of_type_Int == 56)
    {
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      och.jdField_a_of_type_Int = och.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Ogd.a() != null)
    {
      this.jdField_a_of_type_Sng.a(this.jdField_a_of_type_Ogd.a(), this.jdField_a_of_type_Rvr);
      return;
    }
    this.jdField_a_of_type_Sng.b();
  }
  
  private void B()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Sng.a();
    int n;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label214;
      }
      n = snh.c(localArticleInfo);
      if ((n != 6) && (n != 71)) {
        break label171;
      }
      this.jdField_e_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      pga.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
      c(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nxp = new nxp(a());
      this.jdField_a_of_type_Sng.a(this.jdField_a_of_type_Nxp);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.6(this));
      return;
      label171:
      if (n == 28)
      {
        n = bmqa.e(pha.a());
        pga.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int, 0, n);
        c(n);
        continue;
        label214:
        this.jdField_a_of_type_Sng.i();
      }
    }
  }
  
  private void C()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.8(this), 3000L);
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = new ChannelTopPositionView(a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView, 2);
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!bmqa.j()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((tcj)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jdField_c_of_type_JavaUtilList.add(new tcx(getContext()));
      continue;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (bmqa.A(pha.a()) != 2)
        {
          this.jdField_a_of_type_Ovs = new ovs(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_Ovs.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_c_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(a()));
      }
      else if ((this.jdField_a_of_type_Int == 41523) && (bmqa.B(pha.a()) != 1))
      {
        this.jdField_a_of_type_Ovs = new ovs(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Ovs.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Ovs.a());
      }
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (ouj.a().a())
      {
        a(false);
        QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.22(this), 500L);
      return;
    }
    ouj.a().c();
    QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void G()
  {
    if (ReadinjoyJumpActivity.a(a().getIntent())) {
      ReadinjoyJumpActivity.a(a(), a().getIntent(), 500L);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (ReadinjoyJumpActivity.b(a().getIntent()))
        {
          localIntent = a().getIntent();
          ReadInJoyLockScreenJumpDelegate.a(a(), localIntent);
          localIntent.removeExtra("daily_lock_screen_flag");
          return;
        }
      } while ((!ReadinjoyJumpActivity.c(a().getIntent())) || (bmqa.j()));
      localIntent = a().getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(a(), localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void H()
  {
    if (bmqa.a(b())) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_Int == 56) {
      pmh.a().a(56);
    }
  }
  
  private void I()
  {
    boolean bool = this.jdField_a_of_type_Ogd.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((b()) && (!bool) && ((!bmqa.h()) || ((this.jdField_a_of_type_Ogd.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      n();
      M();
    }
    if (((!bmqa.h()) || ((this.jdField_a_of_type_Ogd.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      och.jdField_a_of_type_Int = och.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      this.l = false;
      this.k = false;
      this.jdField_a_of_type_Ogd.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Ogd.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Ogd.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Ogd.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((bmqa.i()) && ((this.jdField_a_of_type_Ogd.a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        pmm localpmm = (pmm)pha.a().getManager(163);
        localpmm.a().a(this.jdField_a_of_type_Int, localParcelable);
        localpmm.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  private void L()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      Parcelable localParcelable = ((pmm)pha.a().getManager(163)).a().a(this.jdField_a_of_type_Int);
      if (localParcelable != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onRestoreInstanceState(localParcelable);
        QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "channelID: ", Integer.valueOf(this.jdField_a_of_type_Int), " restoreToHistoryPos." });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
  }
  
  private void M()
  {
    if (b())
    {
      if (this.jdField_a_of_type_Ogd.a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label67;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label67:
    label710:
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_Ogd.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int n = this.jdField_a_of_type_Ogd.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Sng.a();
      if ((n == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label710;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = pmh.a().a(Integer.valueOf(56));
        List localList = a().a();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = pmh.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label703;
          }
          Iterator localIterator = ((List)localObject2).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)localIterator.next();
          } while (((ArticleInfo)localObject2).mArticleID != l1);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            pmh.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l1 = ((BaseArticleInfo)localList.get(0)).mRecommendSeq;
          localArticleInfo.mRecommendSeq = (1L + l1);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l1 + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          pmh.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Sng.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Sng);
          if (this.jdField_a_of_type_Ovs == null) {}
          for (n = 0;; n = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(n, 0);
            this.jdField_a_of_type_Sng.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, snh.jdField_b_of_type_Int);
            return;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  private void N()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  private void O()
  {
    int i1 = this.jdField_a_of_type_Sng.getCount();
    if (i1 > 0)
    {
      int n = 0;
      while (n < i1)
      {
        Object localObject = this.jdField_a_of_type_Sng.getItem(n);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        n += 1;
      }
    }
  }
  
  private void P()
  {
    Object localObject = this.jdField_a_of_type_Sng.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = tzo.b((QQAppInterface)pha.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = tzo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        tzo.a(((BaseActivity)this.jdField_a_of_type_Ogd.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373602);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    R();
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_Int == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131376085));
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(0);
      }
    }
  }
  
  private void S()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)pha.a().getManager(162)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      T();
      return;
    }
    a(localKandianMsgBoxRedPntInfo);
  }
  
  private void T()
  {
    try
    {
      if (this.jdField_a_of_type_Suh != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Suh.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Suh = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void U()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373606));
    if (pil.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373605));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131373604));
  }
  
  private void V()
  {
    if ((qqm.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.i))
    {
      a(true, 0, false);
      this.i = true;
      return;
    }
    qqm.a().a();
  }
  
  private void W()
  {
    new Handler(Looper.getMainLooper()).post(new ReadInJoyListViewGroup.49(this));
  }
  
  private long a()
  {
    if ((i()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l1 = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l1;
        }
      }
    }
    return -1L;
  }
  
  private Pair<Integer, Long> a()
  {
    long l2 = 0L;
    int i1 = 0;
    int n = 0;
    int i2 = -1;
    if ((getContext() instanceof ReadInJoyNewFeedsActivity))
    {
      if (((ReadInJoyNewFeedsActivity)getContext()).a() > 0L)
      {
        l1 = ((ReadInJoyNewFeedsActivity)getContext()).a();
        if (!((ReadInJoyNewFeedsActivity)getContext()).b()) {
          break label97;
        }
      }
      label97:
      for (n = 0;; n = 1)
      {
        return new Pair(Integer.valueOf(n), Long.valueOf(l1));
        l1 = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)getContext()).b();
        break;
      }
    }
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if ((getContext() instanceof SplashActivity))
    {
      localReadinjoyTabFrame = pha.a(getContext());
      if (localReadinjoyTabFrame == null) {
        break label185;
      }
      if (localReadinjoyTabFrame.jdField_b_of_type_Int == 0) {}
    }
    label134:
    for (long l1 = localReadinjoyTabFrame.a();; l1 = 0L)
    {
      break;
      n = 1;
      break label134;
      n = i2;
      l1 = l2;
      if (!pil.c(this.jdField_a_of_type_Int)) {
        break;
      }
      if (pfk.b() != 0) {}
      for (n = i1;; n = 1)
      {
        l1 = l2;
        break;
      }
      label185:
      n = -1;
    }
  }
  
  private LinearLayout a()
  {
    if (pil.c(this.jdField_a_of_type_Int)) {
      return this.jdField_a_of_type_AndroidWidgetLinearLayout;
    }
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public static ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    rfw localrfw = (rfw)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localrfw.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localrfw.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localrfw.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localrfw.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localrfw.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localrfw.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localrfw.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localrfw.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localrfw.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  private String a(Map<Long, ubj> paramMap, String paramString1, rev paramrev, String paramString2)
  {
    for (;;)
    {
      boolean bool;
      int n;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", pig.a(pha.a(), this.jdField_a_of_type_Int));
        if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
          return localJSONObject.toString();
        }
        bool = paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) || (!paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
          continue;
        }
        n = 1;
      }
      catch (Exception paramMap)
      {
        JSONObject localJSONObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReadInJoyListViewGroup", 2, QLog.getStackTraceString(paramMap));
        return paramString2;
        n = 0;
        break label178;
        return paramString2;
      }
      paramMap = (ubj)paramMap.get(Long.valueOf(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        localJSONObject.put("main_text_read_time", paramMap.jdField_a_of_type_Long);
        continue;
        label178:
        if (!bool) {
          if (n == 0) {}
        }
      }
    }
  }
  
  private String a(rev paramrev, String paramString)
  {
    int n = snh.c((ArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if ((n == 6) || (n == 66) || (n == 115) || (n == 28) || (n == 11) || (n == 26) || (n == 19)) {
      paramrev = och.a(och.a((ArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramString);
    }
    for (;;)
    {
      paramString = paramrev;
      if (n == 6)
      {
        paramrev = new skc(paramrev);
        paramrev.aa(ryx.f());
        paramString = paramrev.a().a();
      }
      return paramString;
      if ((n == 46) || (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
      {
        paramString = new skc(paramString);
        paramString.e(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
        paramString.W(pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramString.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        if (n == 46) {
          paramString.x(0);
        }
        for (;;)
        {
          paramString.e(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          paramrev = paramString.a().a();
          break;
          paramString.x(1);
        }
      }
      if (n == 118)
      {
        paramString = new skc(paramString);
        if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
        {
          paramString.Y(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
            paramString.o(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.h(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrev = paramString.a().a();
      }
      else if (n == 128)
      {
        paramString = new skc(paramString);
        if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
        {
          paramString.Y(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
          if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
            paramString.o(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.h(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramrev = paramString.a().a();
      }
      else
      {
        paramrev = paramString;
      }
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i3 = 0;
    AladdinConfig localAladdinConfig;
    int i2;
    int i1;
    if ((!bdch.a()) && (!paramArticleInfo.hasSearchWordInfo()) && ((snh.c(paramArticleInfo) == 3) || (snh.c(paramArticleInfo) == 1)) && (paramArticleInfo.mIsShowSearchord == 1))
    {
      localAladdinConfig = Aladdin.getConfig(201);
      if (localAladdinConfig == null) {
        break label213;
      }
      i2 = localAladdinConfig.getIntegerFromString("feeds_searchterm", 0);
      i1 = localAladdinConfig.getIntegerFromString("feeds_searchterm_max", 1000);
    }
    for (int n = localAladdinConfig.getIntegerFromString("feeds_pos_range_each_max", 3);; n = 3)
    {
      if (!DateUtils.isToday(bgsg.b("search_word_prefix_last_request_time")))
      {
        bgsg.a("search_word_prefix_last_request_time", System.currentTimeMillis());
        bgsg.a("search_word_prefix_show_times", 0L);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramArticleInfo.mRefreshTime)) {
        i3 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramArticleInfo.mRefreshTime)).intValue();
      }
      if ((i3 < n) && (bgsg.b("search_word_prefix_show_times") < i1) && (i2 == 1)) {
        ((anxu)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID), new src(this, paramArticleInfo, i3, paramInt));
      }
      return;
      label213:
      i1 = 1000;
      i2 = 0;
    }
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.48(this, paramRunnable), paramInt);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, false, 0, 0, false, paramInt);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, true, paramInt1, paramInt2, paramBoolean, 1);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", anni.a(2131711839));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!snh.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = snh.c(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label262;
      }
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean2)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      och.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, och.b());
      sgc.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label262:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    int n = 2;
    QLog.d("ReadInJoyListViewGroup", 1, "back from readInJoyList");
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      n = 1;
    }
    ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
    if (localArticleInfo != null)
    {
      if (this.jdField_a_of_type_Ovb != null) {
        this.jdField_a_of_type_Ovb.a();
      }
      this.jdField_a_of_type_Ovb = new ovb();
      this.jdField_a_of_type_Ovb.a(new srm(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Ovb, 7, true, localArticleInfo, 1, n);
      return;
    }
    QLog.e("ReadInJoyListViewGroup", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void a(View paramView)
  {
    if ((a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)a()).b(paramView);
    }
    for (;;)
    {
      return;
      if (bmqa.h()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)a()).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.a(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("ReadInJoyListViewGroup", 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  private void a(View paramView, int paramInt, ArticleInfo paramArticleInfo)
  {
    if (a(paramArticleInfo, paramView))
    {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
    }
    for (;;)
    {
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (this.jdField_a_of_type_Sng != null) {}
      try
      {
        if (!TextUtils.isEmpty(tlg.b(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
          }
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyListViewGroup.36(this), 2000L);
          return;
          a(paramArticleInfo, paramInt - 1);
        }
        else
        {
          this.jdField_a_of_type_Sng.notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramView)
      {
        this.jdField_a_of_type_Sng.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, ArticleInfo paramArticleInfo)
  {
    if (snh.c(paramArticleInfo))
    {
      c(paramArticleInfo, paramView);
      return;
    }
    pha.a(getContext(), paramArticleInfo, 1, false, 4, false);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131364884);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131166454));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().getVirtualView().findViewBaseByName("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131166454));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Sng.a(this.jdField_a_of_type_Sng.a(), paramArticleInfo.mArticleID)) {}
      pha.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", pha.f(0));
        pha.a(getContext(), str, localBundle);
        pfe.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Sng);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      Bundle localBundle;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery failed: url is null");
      return;
    }
    QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView)
  {
    if (pha.s(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    sey localsey = new sey();
    localsey.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localsey.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localsey.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localsey.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localsey.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localsey.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localsey.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    rgc localrgc = new rgc();
    localrgc.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localrgc.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!snh.g(paramArticleInfo)) && (!snh.i(paramArticleInfo)) && (!snh.j(paramArticleInfo)) && (!snh.k(paramArticleInfo))) || ((!snh.q(paramArticleInfo)) || ((pha.l(paramArticleInfo)) && (!snh.q(paramArticleInfo)))))
    {
      localsey.jdField_f_of_type_Int = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_f_of_type_Int;
      localsey.jdField_c_of_type_Int = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_a_of_type_Int;
      localsey.jdField_d_of_type_Int = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_b_of_type_Int;
      localrgc.jdField_a_of_type_Int = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_f_of_type_Int;
      localsey.jdField_b_of_type_Int = ((int)(((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_a_of_type_Long / 1000L));
      localsey.jdField_b_of_type_JavaLangString = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_d_of_type_JavaLangString;
      localsey.jdField_j_of_type_JavaLangString = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_g_of_type_JavaLangString;
      localsey.jdField_c_of_type_JavaLangString = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((pha.i(paramArticleInfo)) && (pha.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localsey.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localrgc.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localsey.a = localrgc;
        localsey.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localsey.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localsey.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localsey.jdField_h_of_type_Int = localObject[0];
          localsey.jdField_i_of_type_Int = localObject[1];
          localsey.jdField_j_of_type_Int = paramView.getWidth();
          localsey.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = pgk.a(3, this.jdField_a_of_type_Int);
            int n = localsey.jdField_h_of_type_Int;
            localsey.jdField_h_of_type_Int = ((localsey.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
            localsey.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          ryx.a(localsey, paramView);
        }
        localObject = new rgi();
        ((rgi)localObject).jdField_a_of_type_Int = 409409;
        if (this.jdField_a_of_type_Int != 56) {
          break label831;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        och.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, (rgi)localObject);
      }
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      return;
      localsey.jdField_b_of_type_JavaLangString = ((rhu)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.b.get(0)).jdField_d_of_type_JavaLangString;
      break label403;
      if ((pha.i(paramArticleInfo)) && (pha.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localsey.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localsey.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localsey.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localsey.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localsey.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localrgc.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localsey.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localsey.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localsey.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localsey.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localsey.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label831:
      this.jdField_a_of_type_Sng.a(localsey, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (ryx.b(a(), paramArticleInfo)))
    {
      a(paramArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) || (pha.i(paramArticleInfo)) || (pha.m(paramArticleInfo)) || (pha.n(paramArticleInfo)))
    {
      if (pha.n(paramArticleInfo)) {
        a(paramArticleInfo, (rfw)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView);
      }
      for (;;)
      {
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Sng.notifyDataSetChanged();
        }
        if (!pha.l(paramArticleInfo)) {
          break;
        }
        paramView = ube.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, ube.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        oat.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        pha.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Sng, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        a(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new rgi();
        paramView.jdField_a_of_type_Int = paramInt1;
        och.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((snh.c(paramArticleInfo) == 6) || (snh.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      ohp.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (bmqa.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Sng, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        a(paramArticleInfo);
        paramInt1 = 56;
      }
      else
      {
        a(paramArticleInfo, paramView);
        paramInt1 = paramInt3;
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, rfw paramrfw, View paramView)
  {
    sey localsey = new sey();
    if (paramrfw.jdField_a_of_type_Rfz == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localsey.jdField_c_of_type_Long = paramrfw.jdField_a_of_type_Long;
      localsey.jdField_h_of_type_JavaLangString = (paramrfw.jdField_a_of_type_Rfz.jdField_b_of_type_Long + "");
      localsey.jdField_i_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_d_of_type_JavaLangString;
      localsey.jdField_k_of_type_JavaLangString = paramrfw.jdField_e_of_type_JavaLangString;
      localsey.jdField_g_of_type_Int = paramrfw.jdField_a_of_type_Int;
      localsey.jdField_g_of_type_Long = paramrfw.jdField_b_of_type_Long;
      Object localObject = new rgc();
      ((rgc)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramrfw.jdField_a_of_type_Long);
      ((rgc)localObject).jdField_a_of_type_JavaLangString = paramrfw.jdField_g_of_type_JavaLangString;
      ((rgc)localObject).jdField_a_of_type_Int = paramrfw.jdField_a_of_type_Rfz.jdField_a_of_type_Int;
      ((rgc)localObject).jdField_b_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_a_of_type_JavaLangString;
      localsey.a = ((rgc)localObject);
      localsey.jdField_b_of_type_JavaLangString = paramrfw.jdField_c_of_type_JavaLangString;
      localsey.jdField_c_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_a_of_type_JavaLangString;
      localsey.jdField_f_of_type_Int = paramrfw.jdField_a_of_type_Rfz.jdField_a_of_type_Int;
      localsey.jdField_c_of_type_Int = paramrfw.jdField_a_of_type_Rfz.jdField_b_of_type_Int;
      localsey.jdField_d_of_type_Int = paramrfw.jdField_a_of_type_Rfz.jdField_c_of_type_Int;
      localsey.jdField_b_of_type_Int = paramrfw.jdField_a_of_type_Rfz.jdField_d_of_type_Int;
      localsey.jdField_e_of_type_Long = paramrfw.jdField_a_of_type_Rfz.jdField_a_of_type_Long;
      localsey.jdField_j_of_type_JavaLangString = paramrfw.jdField_g_of_type_JavaLangString;
      localsey.jdField_g_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_b_of_type_JavaLangString;
      localsey.jdField_d_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_f_of_type_JavaLangString;
      localsey.jdField_e_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_e_of_type_JavaLangString;
      localsey.jdField_f_of_type_JavaLangString = paramrfw.jdField_a_of_type_Rfz.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localsey.jdField_h_of_type_Int = localObject[0];
        localsey.jdField_i_of_type_Int = localObject[1];
        localsey.jdField_j_of_type_Int = paramView.getWidth();
        localsey.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = pgk.a(3, this.jdField_a_of_type_Int);
          int n = localsey.jdField_h_of_type_Int;
          localsey.jdField_h_of_type_Int = ((localsey.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
          localsey.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new rgi();
      ((rgi)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_Sng.a(localsey, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        och.a(paramrfw.jdField_a_of_type_Long, paramrfw.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Int, (int)paramrfw.jdField_b_of_type_Long, paramrfw.jdField_a_of_type_Int, 24, -1L, (rgi)localObject, -1, paramrfw.jdField_k_of_type_JavaLangString);
      }
      pmh.a().a(paramrfw.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Sng.notifyDataSetChanged();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (pil.c(this.jdField_a_of_type_Int))
    {
      paramBaseArticleInfo.mJumpType = 1;
      bmqa.a(paramBaseArticleInfo);
    }
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo)
  {
    if (paramBaseArticleInfo.isAccountShown) {
      paramBaseArticleInfo.clickArea = 7;
    }
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug normal feeds");
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      paramBaseArticleInfo.clickJumpTarget = qib.a(pfr.a(paramArticleInfo), "-1");
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      return;
    }
    if (b(paramArticleInfo, paramView))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
      paramBaseArticleInfo.clickJumpTarget = qib.a(pgw.a().a(), "-1");
      return;
    }
    if ((!rec.c(paramArticleInfo)) && (!pgw.a().a()) && (pha.a(paramView.getContext(), paramArticleInfo)))
    {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      String str = pha.i(paramArticleInfo.getInnerUniqueID());
      paramBaseArticleInfo.clickJumpTarget = qib.a(str, "-1");
      pha.a(paramView.getContext(), paramArticleInfo, str);
      return;
    }
    if (ptw.a(paramView.getContext(), paramArticleInfo.mArticleContentUrl))
    {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      return;
    }
    paramBaseArticleInfo.clickJumpTarget = qib.a("", "3");
    g(paramArticleInfo);
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Suh == null)
    {
      if (pha.k() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Suh = new suf(a(), LayoutInflater.from(getContext()).inflate(2131560264, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Suh.a(new srj(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Suh.a());
      this.jdField_a_of_type_Suh.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Suh.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (pha.k() == 2) {
        this.jdField_a_of_type_Suh = new sud(a());
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131373602).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371619)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376012));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376011));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramDrawable);
      if (this.jdField_a_of_type_Int == 70) {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-4473925);
      }
    }
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = afur.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = afur.a(10.0F, getResources()))
    {
      R();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839277));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166869));
    }
  }
  
  private void a(rev paramrev)
  {
    if (pha.k(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      oat.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  /* Error */
  private void a(rev paramrev, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 1090	skc
    //   3: dup
    //   4: aload 5
    //   6: invokespecial 1091	skc:<init>	(Ljava/lang/String;)V
    //   9: astore 9
    //   11: aload 9
    //   13: aload_1
    //   14: getfield 1937	rev:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   17: invokestatic 1940	pha:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   20: invokestatic 698	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: invokevirtual 1943	skc:a	(Ljava/lang/Boolean;)Lskc;
    //   26: aload_1
    //   27: getfield 1937	rev:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: getfield 1121	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   33: invokevirtual 1123	skc:a	(Ljava/lang/String;)Lskc;
    //   36: aload_1
    //   37: getfield 1937	rev:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   40: invokevirtual 1945	skc:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lskc;
    //   43: pop
    //   44: aload_0
    //   45: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   48: ldc_w 1946
    //   51: if_icmpne +196 -> 247
    //   54: aload 9
    //   56: aload_1
    //   57: getfield 1947	rev:jdField_j_of_type_Int	I
    //   60: invokevirtual 1949	skc:b	(I)Lskc;
    //   63: pop
    //   64: aconst_null
    //   65: ldc_w 1698
    //   68: ldc_w 1700
    //   71: aload_1
    //   72: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: ldc_w 1952
    //   78: ldc_w 1952
    //   81: iconst_0
    //   82: iconst_0
    //   83: aload_1
    //   84: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   87: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   90: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   93: aload_1
    //   94: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   97: invokevirtual 937	java/lang/Long:longValue	()J
    //   100: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   103: aload_1
    //   104: getfield 1955	rev:jdField_b_of_type_Int	I
    //   107: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   110: aload 9
    //   112: invokevirtual 1100	skc:a	()Lskb;
    //   115: invokevirtual 1104	skb:a	()Ljava/lang/String;
    //   118: iconst_0
    //   119: invokestatic 1721	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   122: ldc_w 1952
    //   125: aload_1
    //   126: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   129: aload_1
    //   130: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   133: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   136: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   139: aload_1
    //   140: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   143: invokevirtual 937	java/lang/Long:longValue	()J
    //   146: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   149: aload_1
    //   150: getfield 1955	rev:jdField_b_of_type_Int	I
    //   153: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   156: aload_1
    //   157: getfield 1956	rev:jdField_a_of_type_Long	J
    //   160: aload_1
    //   161: getfield 1957	rev:jdField_c_of_type_Int	I
    //   164: aload_0
    //   165: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   168: aload_1
    //   169: getfield 1958	rev:jdField_d_of_type_Int	I
    //   172: aload_1
    //   173: getfield 1959	rev:jdField_e_of_type_Int	I
    //   176: aload_0
    //   177: invokevirtual 425	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   180: invokestatic 1964	bgnt:h	(Landroid/content/Context;)Z
    //   183: aload_1
    //   184: getfield 1965	rev:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_1
    //   188: getfield 1966	rev:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload_1
    //   192: getfield 1967	rev:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   195: aload_1
    //   196: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   199: invokestatic 1969	pha:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   202: aload_1
    //   203: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   206: checkcast 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   209: lload_2
    //   210: iload 4
    //   212: aload_1
    //   213: getfield 1970	rev:jdField_f_of_type_Int	I
    //   216: aload_1
    //   217: getfield 1971	rev:jdField_g_of_type_Int	I
    //   220: aload_1
    //   221: getfield 1972	rev:jdField_h_of_type_Int	I
    //   224: aload_1
    //   225: getfield 1973	rev:jdField_f_of_type_Boolean	Z
    //   228: aload_1
    //   229: getfield 1947	rev:jdField_j_of_type_Int	I
    //   232: aload_1
    //   233: getfield 1974	rev:jdField_i_of_type_Int	I
    //   236: aload_1
    //   237: getfield 1976	rev:m	I
    //   240: invokestatic 1979	pha:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   243: invokestatic 1982	oat:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   246: return
    //   247: aload_0
    //   248: getfield 99	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_f_of_type_Int	I
    //   251: iconst_3
    //   252: if_icmpne +51 -> 303
    //   255: iconst_m1
    //   256: istore 8
    //   258: iload 8
    //   260: istore 7
    //   262: aload_0
    //   263: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ogd	Logd;
    //   266: ifnull +29 -> 295
    //   269: iload 8
    //   271: istore 7
    //   273: aload_0
    //   274: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ogd	Logd;
    //   277: instanceof 1984
    //   280: ifeq +15 -> 295
    //   283: aload_0
    //   284: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ogd	Logd;
    //   287: checkcast 1984	oge
    //   290: invokevirtual 1985	oge:a	()I
    //   293: istore 7
    //   295: aload 9
    //   297: iload 7
    //   299: invokevirtual 1987	skc:O	(I)Lskc;
    //   302: pop
    //   303: aload 9
    //   305: aload_1
    //   306: getfield 1937	rev:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   309: invokevirtual 1989	skc:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lskc;
    //   312: pop
    //   313: aload_1
    //   314: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   317: ifnull +111 -> 428
    //   320: aload_1
    //   321: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   324: getfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   327: ifnull +101 -> 428
    //   330: aload_1
    //   331: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   334: getfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   337: aconst_null
    //   338: invokevirtual 1999	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   341: astore 10
    //   343: aload 10
    //   345: ifnull +83 -> 428
    //   348: aload 10
    //   350: invokeinterface 2003 1 0
    //   355: ifnull +73 -> 428
    //   358: aload 10
    //   360: invokeinterface 2003 1 0
    //   365: invokeinterface 2006 1 0
    //   370: astore 10
    //   372: aload 10
    //   374: ifnull +54 -> 428
    //   377: aload 10
    //   379: invokeinterface 410 1 0
    //   384: ifeq +44 -> 428
    //   387: aload 10
    //   389: invokeinterface 414 1 0
    //   394: checkcast 2008	java/util/Map$Entry
    //   397: astore 11
    //   399: aload 9
    //   401: aload 11
    //   403: invokeinterface 2011 1 0
    //   408: checkcast 801	java/lang/String
    //   411: aload 11
    //   413: invokeinterface 2014 1 0
    //   418: invokevirtual 2015	java/lang/Object:toString	()Ljava/lang/String;
    //   421: invokevirtual 2018	skc:a	(Ljava/lang/String;Ljava/lang/Object;)Lskc;
    //   424: pop
    //   425: goto -53 -> 372
    //   428: aload 9
    //   430: aload_1
    //   431: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   434: invokestatic 2023	qpm:a	(Lskc;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   437: aload 6
    //   439: aload_1
    //   440: aload 9
    //   442: invokestatic 2026	pha:a	(Ljava/lang/String;Lrev;Lskc;)V
    //   445: aload_0
    //   446: aload 9
    //   448: invokespecial 2029	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lskc;)V
    //   451: aconst_null
    //   452: ldc_w 1698
    //   455: ldc_w 1700
    //   458: aload_1
    //   459: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   462: aload 6
    //   464: aload 6
    //   466: iconst_0
    //   467: iconst_0
    //   468: aload_1
    //   469: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   472: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   475: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   478: aload_1
    //   479: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   482: invokevirtual 937	java/lang/Long:longValue	()J
    //   485: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   488: aload_1
    //   489: getfield 1955	rev:jdField_b_of_type_Int	I
    //   492: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   495: aload 9
    //   497: invokevirtual 1100	skc:a	()Lskb;
    //   500: invokevirtual 1104	skb:a	()Ljava/lang/String;
    //   503: iconst_0
    //   504: invokestatic 1721	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   507: aload_1
    //   508: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   511: getfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   514: invokestatic 2034	tyb:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
    //   517: astore 10
    //   519: aload 5
    //   521: astore 9
    //   523: aload 10
    //   525: ifnull +168 -> 693
    //   528: aload 10
    //   530: invokeinterface 405 1 0
    //   535: astore 11
    //   537: aload 5
    //   539: astore 9
    //   541: aload 11
    //   543: invokeinterface 410 1 0
    //   548: ifeq +145 -> 693
    //   551: aload 11
    //   553: invokeinterface 414 1 0
    //   558: checkcast 801	java/lang/String
    //   561: astore 10
    //   563: new 1028	org/json/JSONObject
    //   566: dup
    //   567: aload 5
    //   569: invokespecial 1030	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   572: astore 9
    //   574: aload_1
    //   575: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   578: getfield 1993	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   581: aload 10
    //   583: invokevirtual 1999	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   586: astore 10
    //   588: aload 10
    //   590: ifnull +385 -> 975
    //   593: aload 9
    //   595: aload 10
    //   597: invokestatic 2037	tyb:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   600: aload 9
    //   602: invokevirtual 1052	org/json/JSONObject:toString	()Ljava/lang/String;
    //   605: astore 9
    //   607: aload 9
    //   609: astore 5
    //   611: aconst_null
    //   612: ldc_w 1698
    //   615: ldc_w 1700
    //   618: aload_1
    //   619: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   622: aload 6
    //   624: aload 6
    //   626: iconst_0
    //   627: iconst_0
    //   628: aload_1
    //   629: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   632: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   635: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   638: aload_1
    //   639: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   642: invokevirtual 937	java/lang/Long:longValue	()J
    //   645: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   648: aload_1
    //   649: getfield 1955	rev:jdField_b_of_type_Int	I
    //   652: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   655: aload 5
    //   657: iconst_0
    //   658: invokestatic 1721	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   661: goto -124 -> 537
    //   664: astore 10
    //   666: aload 5
    //   668: astore 9
    //   670: aload 10
    //   672: astore 5
    //   674: ldc_w 467
    //   677: iconst_1
    //   678: ldc_w 2039
    //   681: aload 5
    //   683: invokestatic 2042	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload 9
    //   688: astore 5
    //   690: goto -153 -> 537
    //   693: aload 6
    //   695: aload_1
    //   696: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   699: aload_1
    //   700: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   703: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   706: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   709: aload_1
    //   710: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   713: invokevirtual 937	java/lang/Long:longValue	()J
    //   716: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   719: aload_1
    //   720: getfield 1955	rev:jdField_b_of_type_Int	I
    //   723: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   726: aload_1
    //   727: getfield 1956	rev:jdField_a_of_type_Long	J
    //   730: aload_1
    //   731: getfield 1957	rev:jdField_c_of_type_Int	I
    //   734: aload_0
    //   735: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   738: aload_1
    //   739: getfield 1958	rev:jdField_d_of_type_Int	I
    //   742: aload_1
    //   743: getfield 1959	rev:jdField_e_of_type_Int	I
    //   746: aload_0
    //   747: invokevirtual 425	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   750: invokestatic 1964	bgnt:h	(Landroid/content/Context;)Z
    //   753: aload_1
    //   754: getfield 1965	rev:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   757: aload_1
    //   758: getfield 1966	rev:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   761: aload_1
    //   762: getfield 1967	rev:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   765: aload_1
    //   766: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   769: invokestatic 1969	pha:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   772: aload_1
    //   773: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   776: checkcast 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   779: lload_2
    //   780: iload 4
    //   782: aload_1
    //   783: getfield 1970	rev:jdField_f_of_type_Int	I
    //   786: aload_1
    //   787: getfield 1971	rev:jdField_g_of_type_Int	I
    //   790: aload_1
    //   791: getfield 1972	rev:jdField_h_of_type_Int	I
    //   794: aload_1
    //   795: getfield 1973	rev:jdField_f_of_type_Boolean	Z
    //   798: aload_1
    //   799: getfield 1947	rev:jdField_j_of_type_Int	I
    //   802: aload_1
    //   803: getfield 1974	rev:jdField_i_of_type_Int	I
    //   806: aload_1
    //   807: getfield 1976	rev:m	I
    //   810: invokestatic 1979	pha:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   813: invokestatic 1982	oat:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: sipush 250
    //   819: invokestatic 2044	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   822: ldc_w 2046
    //   825: iconst_0
    //   826: invokevirtual 1185	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   829: iconst_1
    //   830: if_icmpne -584 -> 246
    //   833: aload_0
    //   834: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   837: invokestatic 870	pil:c	(I)Z
    //   840: ifne -594 -> 246
    //   843: new 2048	phi
    //   846: dup
    //   847: new 1028	org/json/JSONObject
    //   850: dup
    //   851: aload 9
    //   853: invokespecial 1030	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   856: invokespecial 2051	phi:<init>	(Lorg/json/JSONObject;)V
    //   859: astore 5
    //   861: invokestatic 2052	ube:b	()I
    //   864: ifle +92 -> 956
    //   867: iconst_0
    //   868: istore 4
    //   870: aload 5
    //   872: ldc_w 2054
    //   875: iload 4
    //   877: invokevirtual 2057	phi:b	(Ljava/lang/String;I)Lphi;
    //   880: pop
    //   881: aconst_null
    //   882: ldc_w 1698
    //   885: ldc_w 1700
    //   888: aload_1
    //   889: getfield 1950	rev:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   892: ldc_w 2059
    //   895: ldc_w 2059
    //   898: iconst_0
    //   899: iconst_0
    //   900: aload_1
    //   901: getfield 1051	rev:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   904: getfield 1953	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   907: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   910: aload_1
    //   911: getfield 1954	rev:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   914: invokevirtual 937	java/lang/Long:longValue	()J
    //   917: invokestatic 1714	java/lang/Long:toString	(J)Ljava/lang/String;
    //   920: aload_1
    //   921: getfield 1955	rev:jdField_b_of_type_Int	I
    //   924: invokestatic 1716	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   927: aload 5
    //   929: invokevirtual 2060	phi:a	()Ljava/lang/String;
    //   932: iconst_0
    //   933: invokestatic 1721	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   936: return
    //   937: astore_1
    //   938: invokestatic 624	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   941: ifeq -695 -> 246
    //   944: ldc_w 467
    //   947: iconst_2
    //   948: aload_1
    //   949: invokestatic 1081	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   952: invokestatic 474	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   955: return
    //   956: iconst_1
    //   957: istore 4
    //   959: goto -89 -> 870
    //   962: astore 10
    //   964: aload 5
    //   966: astore 9
    //   968: aload 10
    //   970: astore 5
    //   972: goto -298 -> 674
    //   975: goto -314 -> 661
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	ReadInJoyListViewGroup
    //   0	978	1	paramrev	rev
    //   0	978	2	paramLong	long
    //   0	978	4	paramInt	int
    //   0	978	5	paramString1	String
    //   0	978	6	paramString2	String
    //   260	38	7	n	int
    //   256	14	8	i1	int
    //   9	958	9	localObject1	Object
    //   341	255	10	localObject2	Object
    //   664	7	10	localJSONException1	JSONException
    //   962	7	10	localJSONException2	JSONException
    //   397	155	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   563	588	664	org/json/JSONException
    //   593	607	664	org/json/JSONException
    //   816	867	937	java/lang/Exception
    //   870	936	937	java/lang/Exception
    //   611	661	962	org/json/JSONException
  }
  
  private void a(rev paramrev, String paramString1, String paramString2)
  {
    int n = 0;
    while (n < paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
    {
      oat.a(null, paramrev.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((rik)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(n)).jdField_a_of_type_Int + "", Integer.toString(paramrev.jdField_b_of_type_Int), paramString1, false);
      n += 1;
    }
  }
  
  private void a(skc paramskc)
  {
    if ((paramskc != null) && ((this.jdField_a_of_type_Ogd instanceof ogr))) {
      if (!this.jdField_b_of_type_Boolean) {
        break label36;
      }
    }
    label36:
    for (int n = 1;; n = 0)
    {
      paramskc.a("from_aio", Integer.valueOf(n));
      return;
    }
  }
  
  private void a(srs paramsrs)
  {
    Intent localIntent = a().getIntent();
    if (localIntent != null)
    {
      ReadInJoyChannelActivity.SerializableMap localSerializableMap = (ReadInJoyChannelActivity.SerializableMap)localIntent.getSerializableExtra("channel_map_data");
      if (localSerializableMap != null)
      {
        Long localLong = (Long)localSerializableMap.getMap().remove("articleID");
        if (localLong != null)
        {
          paramsrs.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramsrs.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        paramsrs.jdField_b_of_type_Int = 9;
        paramsrs.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void a(srs paramsrs, KandianMergeManager paramKandianMergeManager)
  {
    paramsrs.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (!localKandianRedDotInfo.hasArticleID()) {
        break label79;
      }
      paramsrs.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      paramsrs.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      paramsrs.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      paramsrs.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      paramsrs.jdField_b_of_type_Int = 1;
    }
    label79:
    for (paramsrs.jdField_a_of_type_Int |= 0x8;; paramsrs.jdField_a_of_type_Int |= 0x4)
    {
      paramKandianMergeManager.n();
      return;
    }
  }
  
  private void a(srs paramsrs, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (pnp)paramQQAppInterface.getManager(274);
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().size() > 0))
    {
      paramsrs.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface.a());
      paramsrs.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(paramQQAppInterface.a())) {
        paramsrs.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      }
    }
    paramQQAppInterface.a(a());
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (pil.c(this.jdField_a_of_type_Int)) {}
    for (int n = 2;; n = 1)
    {
      uaq.a(localContext, n, new ReadInJoyListViewGroup.38(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!pil.c(paramInt));
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = pfr.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (rec.a(str)) {
        pha.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        ryx.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.isTwoItemVideoFeed()) && (paramArticleInfo.mFeedType != 36))
    {
      QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle);
      return true;
    }
    if (snh.c(paramArticleInfo) == 6)
    {
      if ((paramView instanceof ProteusItemView)) {
        a((ProteusItemView)paramView);
      }
    }
    else
    {
      if (!a(paramArticleInfo, paramView)) {
        break label289;
      }
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug video feeds");
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + paramArticleInfo.mArticleID + " article.mTitle:" + paramArticleInfo.mTitle + " article.mSummary:" + paramArticleInfo.mSummary + "mJsonVideoList:" + paramArticleInfo.mJsonVideoList + " videoJumpChannelID=" + paramArticleInfo.videoJumpChannelID + " videoJumpChannelName=" + paramArticleInfo.videoJumpChannelName + " videoJumpChannelType=" + paramArticleInfo.videoJumpChannelType);
      }
      return false;
      if (!(paramView instanceof LinearLayout)) {
        break;
      }
      a((LinearLayout)paramView);
      break;
      label289:
      if (b(paramArticleInfo, paramView))
      {
        QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt video feeds");
      }
      else if (paramBaseArticleInfo.isAccountShown)
      {
        paramBaseArticleInfo.clickArea = 7;
        paramBaseArticleInfo.clickJumpTarget = qib.a("", "3");
        g(paramArticleInfo);
      }
      else
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
      }
    }
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, php<Integer> paramphp, ArticleInfo paramArticleInfo)
  {
    if (snh.a(paramArticleInfo))
    {
      pha.c(a(), paramArticleInfo, 6);
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, a());
    }
    for (;;)
    {
      return false;
      if (pha.l(paramArticleInfo))
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramphp.a(Integer.valueOf(4));
      }
      else if (paramArticleInfo.mFeedType == 3)
      {
        e(paramArticleInfo);
      }
      else if (paramArticleInfo.mFeedType == 13)
      {
        d(paramArticleInfo);
      }
      else if ((paramArticleInfo.mFeedType == 22) || (paramArticleInfo.mFeedType == 21) || (pha.n(paramArticleInfo)))
      {
        pha.a(getContext(), paramArticleInfo, 4, false, 3, false);
      }
      else if (snh.b(paramArticleInfo))
      {
        b(paramBaseArticleInfo, paramView, paramArticleInfo);
      }
      else if ((snh.a(paramArticleInfo)) && (snh.c(paramArticleInfo)))
      {
        c(paramArticleInfo, paramView);
      }
      else if (snh.a(paramArticleInfo))
      {
        pha.a(getContext(), paramArticleInfo, 1, false, 4, false);
      }
      else if (snh.c(paramArticleInfo) == 71)
      {
        b(paramView, paramInt, paramArticleInfo);
        paramphp.a(Integer.valueOf(4));
      }
      else if ((snh.g(paramArticleInfo)) || (snh.j(paramArticleInfo)))
      {
        pha.a(getContext(), paramArticleInfo, 4, false, 3, false);
        snh.a(paramArticleInfo, this.jdField_a_of_type_Sng.a());
      }
      else if ((pha.b(paramArticleInfo)) || (pha.c(paramArticleInfo)))
      {
        pha.a(getContext(), paramArticleInfo, 1, false, 4, false);
        snh.a(paramArticleInfo, this.jdField_a_of_type_Sng.a());
        pha.a(paramArticleInfo, this.jdField_a_of_type_Sng.a());
      }
      else
      {
        if (!pha.a(paramArticleInfo)) {
          break;
        }
        b(paramArticleInfo, 1);
        pfe.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Sng);
        paramphp.a(Integer.valueOf(2));
      }
    }
    return b(paramBaseArticleInfo, paramView, paramInt, paramphp, paramArticleInfo);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_Sng.b())) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    boolean bool;
    int n;
    if (this.jdField_a_of_type_Sng.getCount() == 0)
    {
      bool = true;
      paramBoolean = a(paramBoolean, bool, ogh.a(this.jdField_a_of_type_Int));
      QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
      if ((!paramBoolean) && (!ptu.a(this.jdField_a_of_type_Int))) {
        break label156;
      }
      n = 1;
      label95:
      if (n == 0) {
        break label170;
      }
      if ((this.jdField_a_of_type_Int == 0) || (pil.c(this.jdField_a_of_type_Int))) {
        pmy.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((!pil.c(this.jdField_a_of_type_Int)) || (pil.a())) {
        break label161;
      }
      a(true, 1, false);
    }
    for (;;)
    {
      return true;
      bool = false;
      break;
      label156:
      n = 0;
      break label95;
      label161:
      a(true, 2);
    }
    label170:
    pgm localpgm = this.jdField_a_of_type_Pgm;
    if (this.jdField_a_of_type_Pgm.jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      localpgm.jdField_a_of_type_Long = l1;
      return false;
      l1 = this.jdField_a_of_type_Pgm.jdField_a_of_type_Long;
    }
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool5 = b(this.jdField_a_of_type_Int);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)((BaseActivity)a()).app.getManager(162);
    long l1;
    label101:
    boolean bool6;
    boolean bool1;
    label123:
    boolean bool3;
    label160:
    boolean bool4;
    if (this.jdField_a_of_type_Int == 70)
    {
      l1 = ((Integer)bmqa.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
      if (pil.a(this.jdField_a_of_type_Int)) {
        l1 = b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pgm.jdField_d_of_type_Long <= l1) {
        break label446;
      }
      bool2 = true;
      bool6 = j();
      if ((!b()) || (this.l)) {
        break label452;
      }
      bool1 = true;
      if ((!bmqa.i()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L) || (!localKandianMergeManager.g())) {
        break label457;
      }
      bool3 = true;
      this.jdField_b_of_type_Boolean = b(this.jdField_b_of_type_Boolean);
      if ((!paramBoolean1) && (!bool2) && (!bool6) && (!bool5) && (!bool1) && (!bool3) && (!this.jdField_b_of_type_Boolean)) {
        break label463;
      }
      bool4 = true;
      label210:
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool2), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
      if (!a()) {
        break label475;
      }
      bool4 = ogh.c(this.jdField_a_of_type_Int);
      if ((!paramBoolean1) && (!bool4) && (!bool6) && (!bool5) && (!bool1) && (!bool3) && (!paramBoolean2)) {
        break label469;
      }
    }
    label446:
    label452:
    label457:
    label463:
    label469:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool4), Boolean.valueOf(bool6), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean2) }));
      return bool2;
      l1 = 300000L;
      break;
      bool2 = false;
      break label101;
      bool1 = false;
      break label123;
      bool3 = false;
      break label160;
      bool4 = false;
      break label210;
    }
    label475:
    if (a(this.jdField_a_of_type_Int)) {
      return true;
    }
    return bool4;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (i()) {
      return a(paramBoolean2, paramBoolean3);
    }
    return b(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  private int b()
  {
    if (this.jdField_f_of_type_Int != -1) {
      return this.jdField_f_of_type_Int;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private long b()
  {
    long l2 = 9223372036854775807L;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(161);
    long l1 = l2;
    if (localAladdinConfig != null)
    {
      int n = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int i1 = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(n), ", refreshInterval = ", Integer.valueOf(i1) });
      l1 = l2;
      if (n == 1) {
        l1 = i1 * 60 * 1000;
      }
    }
    QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private String b(rev paramrev, String paramString)
  {
    paramString = pha.a(paramString, this.jdField_a_of_type_Ogd.a().b(), och.jdField_a_of_type_Int);
    if ((paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      paramString = new skc(paramString).c(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
    }
    for (;;)
    {
      if (((snh.c((ArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
        ryx.a(pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      }
      return paramString;
    }
  }
  
  private List<Long> b()
  {
    Intent localIntent = this.jdField_a_of_type_Ogd.a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int n = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Int == n) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378089));
    if (paramInt == 41695) {
      D();
    }
    if (pil.c(this.jdField_a_of_type_Int)) {
      phl.a().a();
    }
    this.jdField_a_of_type_Aobu = new aobu(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Sng = new sng(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Aobu, this.jdField_a_of_type_AndroidUtilSparseArray);
    a(new sqy(this, "onListViewGroupInit"));
    U();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Ogd + a());
    }
    y();
    x();
    A();
    z();
    Q();
    E();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Anmu);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)pha.a().getManager(162);
    localKandianMergeManager.a(this.jdField_a_of_type_Plz);
    localKandianMergeManager.a(this.jdField_a_of_type_Pmb);
    B();
    w();
    pmk.a().a(this.jdField_a_of_type_Pmn);
    pmk.a().a(this.jdField_a_of_type_Roq);
  }
  
  private void b(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof qqt)) {
      ((qqt)paramView).b();
    }
  }
  
  private void b(View paramView, int paramInt, ArticleInfo paramArticleInfo)
  {
    if ((paramView instanceof ProteusItemView)) {
      a((ProteusItemView)paramView);
    }
    for (;;)
    {
      a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
      return;
      if ((paramView instanceof LinearLayout)) {
        a((LinearLayout)paramView);
      }
    }
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (this.jdField_a_of_type_Sng != null) && (!snh.a(paramArticleInfo))) {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      pha.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((snh.d(paramArticleInfo)) && (snh.c(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    pha.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (rfw)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo)
  {
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
      QLog.d("ReadInJoyListViewGroup", 1, "tryJumpToUgUrl: true");
      paramArticleInfo.clickJumpTarget = qib.a(pfr.a(paramArticleInfo), "-1");
    }
    for (;;)
    {
      paramBaseArticleInfo.clickArea = 7;
      pha.b(getContext(), paramArticleInfo, (int)paramBaseArticleInfo.mChannelID);
      return;
      QLog.d("ReadInJoyListViewGroup", 1, "short content redirectToOtherPage");
      qib.a(getContext(), paramArticleInfo);
    }
  }
  
  private void b(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l1 = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)pha.a();
      if (localQQAppInterface != null)
      {
        paramList = ((pmm)localQQAppInterface.getManager(163)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
        if (paramList != null)
        {
          pnp localpnp = (pnp)localQQAppInterface.getManager(274);
          if (localpnp != null) {
            localpnp.a(tzo.a(localQQAppInterface, paramList), l1);
          }
        }
      }
    }
  }
  
  private void b(rev paramrev)
  {
    if ((paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Ogz != null)) {
      pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Ogz, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
  }
  
  private void b(rev paramrev, String paramString1, String paramString2)
  {
    Object localObject;
    if (!paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      localObject = snh.a();
      if (localObject == null) {
        break label440;
      }
    }
    label440:
    for (paramString1 = ((QQAppInterface)localObject).c();; paramString1 = "0")
    {
      String str = pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, 0, 0, bgnt.h(getContext()), paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      oat.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str, false);
      paramString2 = ube.a(this.jdField_a_of_type_Int);
      if (localObject != null) {
        paramString1 = ((QQAppInterface)localObject).c();
      }
      localObject = pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, pha.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, bgnt.h(getContext()), paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, paramrev.jdField_f_of_type_Int, (ArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      try
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label382;
        }
        n = 1;
        ((JSONObject)localObject).put("from_aio", n);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          int n;
          label382:
          QLog.e("ReadInJoyListViewGroup", 2, localJSONException.getMessage());
        }
      }
      localObject = ((JSONObject)localObject).toString();
      oat.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", (String)localObject, false);
      while (!pha.n(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        return;
        n = 0;
        break;
      }
      oat.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      return;
    }
  }
  
  private void b(srs paramsrs)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      paramsrs.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(srs paramsrs, KandianMergeManager paramKandianMergeManager)
  {
    int i2 = 1;
    if (this.jdField_a_of_type_Pgm.jdField_a_of_type_Boolean)
    {
      paramsrs.jdField_a_of_type_JavaUtilList = b();
      paramsrs.jdField_a_of_type_Boolean = h();
      this.jdField_a_of_type_Pgm.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      paramsrs.jdField_b_of_type_Boolean = bool;
      paramsrs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = ((LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
      if (paramsrs.jdField_a_of_type_JavaUtilList != null) {
        break label386;
      }
      paramsrs.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((paramsrs.jdField_a_of_type_JavaUtilList != null) && (paramsrs.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        paramsrs.jdField_a_of_type_Long = ((Long)paramsrs.jdField_a_of_type_JavaUtilList.get(paramsrs.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        paramsrs.jdField_b_of_type_Long = ((Long)paramsrs.jdField_a_of_type_JavaUtilList.get(paramsrs.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        paramsrs.jdField_a_of_type_JavaUtilList = paramsrs.jdField_a_of_type_JavaUtilList.subList(0, paramsrs.jdField_a_of_type_JavaUtilList.size() - 2);
        paramsrs.jdField_b_of_type_Int = 1;
        paramsrs.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
      }
      if (!c()) {
        break;
      }
      Object localObject = paramKandianMergeManager.a();
      if (localObject == null) {
        break;
      }
      ArrayList localArrayList = ((KandianRedDotInfo)localObject).articleIDList;
      n = i2;
      if (localArrayList == null) {
        break label346;
      }
      n = i2;
      if (localArrayList.size() <= 0) {
        break label346;
      }
      paramsrs.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramsrs.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
      int i1 = localArrayList.size() - 1;
      for (;;)
      {
        n = i2;
        if (i1 < 0) {
          break;
        }
        localObject = (Long)localArrayList.get(i1);
        paramsrs.jdField_a_of_type_JavaUtilList.add(0, localObject);
        i1 -= 1;
      }
    }
    int n = 0;
    label346:
    paramKandianMergeManager.g();
    paramKandianMergeManager.f();
    for (;;)
    {
      paramsrs.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
      paramKandianMergeManager.l();
      if (n != 0)
      {
        paramsrs.jdField_a_of_type_Int |= 0x20;
        pha.a(false);
      }
      return;
      label386:
      n = 0;
    }
  }
  
  private void b(srs paramsrs, QQAppInterface paramQQAppInterface)
  {
    long l1 = this.jdField_a_of_type_Ogd.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_Ogd.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.l = true;
    this.k = true;
    Object localObject;
    JSONObject localJSONObject;
    if (bool)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Ogd.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        paramsrs.jdField_a_of_type_AndroidUtilPair = new Pair(((ArticleInfo)localObject).getInnerUniqueID(), ((ArticleInfo)localObject).mTitle);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ArticleId", pha.a(((ArticleInfo)localObject).mArticleID));
        localJSONObject.put("FeedsId", pha.a(((ArticleInfo)localObject).mFeedId));
        localJSONObject.put("algorithmIds", 0);
        localJSONObject.put("biuUin", 0);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("socialFeedsType", 1);
        localJSONObject.put("extension", localObject);
        localJSONObject.put("feedsType", 1);
        localJSONObject.put("id", 0);
        localJSONObject.put("network_type", 1);
        localJSONObject.put("orange", "");
        localJSONObject.put("pushMessage", "");
        localJSONObject.put("push_type", 0);
        localJSONObject.put("strategyIds", 0);
        localJSONObject.put("title", "");
        localJSONObject.put("uin", paramQQAppInterface.getLongAccountUin());
        paramsrs.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        paramsrs.jdField_b_of_type_Int = 5;
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramsrs.jdField_a_of_type_JavaLangString = null;
        continue;
      }
      paramsrs.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramsrs.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int n = 2131298694;
    boolean bool2 = false;
    label406:
    for (;;)
    {
      try
      {
        boolean bool3 = bdch.a();
        if ((bool3 == this.m) && (!paramBoolean)) {
          return;
        }
        Activity localActivity = a();
        if (localActivity == null) {
          break;
        }
        this.m = bool3;
        if (pil.c(this.jdField_a_of_type_Int))
        {
          if (!paramBoolean) {
            break;
          }
          bool1 = false;
          if (a() == 0) {
            break label406;
          }
          if (!paramBoolean) {
            break;
          }
          bool1 = bool2;
          QLog.d("ReadInJoyListViewGroup", 1, "updateListViewPadding,update2StudyMode=" + bool1 + " ,isOnCreate=" + paramBoolean);
          ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362001);
          View localView1 = localActivity.findViewById(2131377827);
          View localView2 = findViewById(2131366993);
          if (bool1) {
            n = 2131298690;
          }
          n = getResources().getDimensionPixelOffset(n);
          if (!bool1) {
            break label376;
          }
          n = ImmersiveUtils.getStatusBarHeight(getContext()) + n;
          i1 = afur.a(50.0F, getResources());
          i2 = ImmersiveUtils.getStatusBarHeight(getContext());
          int i3 = getResources().getDimensionPixelOffset(2131298694);
          localView2.setPadding(0, n, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, n, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + n);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyListViewGroup.51(this, localView1, n, i1 + i2 + i3, localView2));
          if (!bool3) {
            break;
          }
          a(true, 3, false);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyListViewGroup", 2, "update ListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = this.m;
      continue;
      label376:
      int i1 = afur.a(50.0F, getResources());
      int i2 = ImmersiveUtils.getStatusBarHeight(getContext());
      n = i1 + i2 + n;
    }
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (g())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
      return;
    }
    String str;
    if (this.jdField_a_of_type_Int == 70) {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131717042);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      N();
      if (!bmqa.h()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.29(this), 1500L);
      return;
      str = getResources().getString(2131717041);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131716884), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131716883);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131716884), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131716882);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131716884), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131716883);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!pih.b()) {
      pmk.a().l();
    }
    this.jdField_a_of_type_Pgm.jdField_a_of_type_Long = System.currentTimeMillis();
    bmqa.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Pgm.jdField_a_of_type_Long, (QQAppInterface)pha.a());
    srs localsrs = new srs(null);
    Object localObject2 = ((BaseActivity)a()).app;
    Object localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
    label118:
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == pwl.a()))
    {
      b(localsrs, (KandianMergeManager)localObject1);
      if (this.jdField_a_of_type_Int != 40830) {
        break label454;
      }
      a(localsrs);
      if (this.jdField_a_of_type_Sng != null) {
        this.jdField_a_of_type_Sng.a(paramBoolean1);
      }
      localArrayList1 = new ArrayList();
      if (d())
      {
        localArrayList1.addAll(((KandianMergeManager)localObject1).b());
        localsrs.jdField_a_of_type_Int |= 0x80;
      }
      if (qqm.a().a()) {
        localsrs.jdField_a_of_type_Int |= 0x1000;
      }
      localArrayList2 = new ArrayList();
      if (this.jdField_a_of_type_Int == 56)
      {
        localObject1 = new qnh();
        ((qnh)localObject1).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
        ((qnh)localObject1).jdField_a_of_type_Boolean = bgnw.a(getContext(), ((qnh)localObject1).jdField_a_of_type_JavaLangString);
        localArrayList2.add(localObject1);
      }
      if (localsrs.jdField_a_of_type_AndroidUtilPair != null) {
        break label646;
      }
      localObject1 = null;
      label272:
      if (localsrs.jdField_a_of_type_AndroidUtilPair != null) {
        break label659;
      }
    }
    label646:
    label659:
    for (localObject2 = null;; localObject2 = (String)localsrs.jdField_a_of_type_AndroidUtilPair.second)
    {
      if (this.jdField_a_of_type_Int != 70) {
        break label675;
      }
      pmh.a().a(true, localsrs.jdField_a_of_type_JavaLangString);
      pvf.a().a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
      this.jdField_c_of_type_Int += 1;
      ube.a(paramInt, this.jdField_a_of_type_Int, a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
      return;
      if ((b()) && (!this.l))
      {
        b(localsrs, (QQAppInterface)localObject2);
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        b(localsrs);
        break;
      }
      if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1001L))
      {
        a(localsrs, (KandianMergeManager)localObject1);
        break;
      }
      if (this.jdField_a_of_type_Int != 40677) {
        break;
      }
      a(localsrs, (QQAppInterface)localObject2);
      break;
      label454:
      if (pil.c(this.jdField_a_of_type_Int))
      {
        localObject2 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
        if ((localObject2 == null) || (((KandianRedDotInfo)localObject2).shouldRemoveFloatingRedPntArticleId())) {
          break label118;
        }
        localsrs.jdField_a_of_type_Long = ((KandianRedDotInfo)localObject2).algorithmID;
        localsrs.jdField_b_of_type_Long = ((KandianRedDotInfo)localObject2).strategyID;
        localsrs.jdField_a_of_type_JavaUtilList = ((KandianRedDotInfo)localObject2).articleIDList;
        localsrs.jdField_b_of_type_Int = 1;
        localsrs.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject2).cookie;
        a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
        break label118;
      }
      l1 = a();
      if (this.jdField_a_of_type_Sng == null) {
        break label118;
      }
      localObject2 = (ArticleInfo)this.jdField_a_of_type_Sng.b(0);
      if ((l1 == -1L) || (localObject2 == null) || (l1 == ((ArticleInfo)localObject2).mArticleID)) {
        break label118;
      }
      localsrs.jdField_a_of_type_JavaUtilList = new ArrayList();
      localsrs.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
      localsrs.jdField_b_of_type_Int = 6;
      break label118;
      localObject1 = localsrs.jdField_a_of_type_AndroidUtilPair.first;
      break label272;
    }
    label675:
    if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7)) {
      localsrs.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_b_of_type_Int);
    pmh localpmh = pmh.a();
    int n = this.jdField_a_of_type_Int;
    List localList = localsrs.jdField_a_of_type_JavaUtilList;
    int i1 = localsrs.jdField_b_of_type_Int;
    paramBoolean1 = localsrs.jdField_a_of_type_Boolean;
    int i2 = this.jdField_c_of_type_Int;
    String str;
    if ((localObject1 instanceof String))
    {
      str = (String)localObject1;
      label780:
      if (!(localObject1 instanceof Long)) {
        break label869;
      }
    }
    label869:
    for (long l1 = ((Long)localObject1).longValue();; l1 = -1L)
    {
      localpmh.a(n, localList, i1, true, paramBoolean1, i2, str, l1, (String)localObject2, b(), localsrs.jdField_a_of_type_Long, localsrs.jdField_b_of_type_Long, localsrs.jdField_a_of_type_JavaLangString, paramInt, localsrs.jdField_b_of_type_Boolean, localsrs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo, localsrs.jdField_a_of_type_Int, localArrayList1, localArrayList2, localBundle);
      break;
      str = null;
      break label780;
    }
  }
  
  private boolean b(int paramInt)
  {
    Object localObject = ((BaseActivity)a()).app;
    if ((paramInt == 70) || (pil.c(paramInt))) {
      return a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    if (paramInt == 40677)
    {
      localObject = (pnp)((QQAppInterface)localObject).getManager(274);
      return (((pnp)localObject).a() != null) && (((pnp)localObject).a().size() > 0);
    }
    return paramInt == 40830;
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (rec.c(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = pgw.a().a(paramArticleInfo, null, null);
      str = pgw.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Sng.notifyDataSetChanged();
    pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
    pha.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, php<Integer> paramphp, ArticleInfo paramArticleInfo)
  {
    if ((snh.i(paramArticleInfo)) || (snh.k(paramArticleInfo)))
    {
      pha.a(getContext(), paramArticleInfo, 0, false, 1, false);
      snh.a(paramArticleInfo, this.jdField_a_of_type_Sng.a());
    }
    for (;;)
    {
      return false;
      if (snh.h(paramArticleInfo))
      {
        a(paramView, paramArticleInfo);
      }
      else if (pha.a(paramArticleInfo))
      {
        if (a(paramBaseArticleInfo, paramView, paramInt, paramArticleInfo)) {
          return true;
        }
        paramphp.a(Integer.valueOf(4));
      }
      else if (pha.d(paramArticleInfo))
      {
        a(paramView, paramInt, paramArticleInfo);
      }
      else if ((pha.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) || (paramArticleInfo.isAccountShown))
      {
        a(paramBaseArticleInfo, paramView, paramArticleInfo);
        paramphp.a(Integer.valueOf(2));
      }
      else if (paramArticleInfo.mFeedType == 26)
      {
        c(paramArticleInfo);
      }
      else if (paramArticleInfo.mFeedType == 23)
      {
        pha.a(getContext(), paramArticleInfo, 1, false, 4, false);
      }
      else if (paramArticleInfo.mFeedType == 34)
      {
        pha.a(getContext(), paramArticleInfo.mArticleContentUrl, null);
        snh.a(paramArticleInfo, this.jdField_a_of_type_Sng.a());
      }
      else if (paramArticleInfo.mFeedType == 39)
      {
        oqj.a(paramArticleInfo, getContext(), paramInt);
      }
      else
      {
        paramphp.a(Integer.valueOf(2));
        b(paramArticleInfo);
      }
    }
  }
  
  private boolean b(boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null)
      {
        paramBoolean = bool;
        if (((Intent)localObject).getIntExtra("launch_from", 0) == 15) {
          paramBoolean = true;
        }
        return paramBoolean;
      }
    }
    return paramBoolean;
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1 = ((BaseActivity)a()).app;
    Object localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
    boolean bool1;
    boolean bool4;
    long l1;
    label61:
    int n;
    label81:
    boolean bool5;
    boolean bool3;
    label123:
    int i1;
    label160:
    boolean bool6;
    if (bmqa.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).b();
      bool4 = a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool4) {
        break label365;
      }
      l1 = bmqa.h((AppRuntime)localObject1);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Pgm.jdField_c_of_type_Long <= l1) {
        break label375;
      }
      n = 1;
      localObject1 = a().getIntent();
      bool5 = ((Intent)localObject1).getBooleanExtra("from_search", false);
      if ((!d()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
        break label381;
      }
      bool3 = true;
      if (d()) {
        ((Intent)localObject1).removeExtra("force_refresh");
      }
      if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label387;
      }
      i1 = 1;
      if (!a()) {
        break label399;
      }
      bool6 = ogh.c(this.jdField_a_of_type_Int);
      if ((!paramBoolean2) && (!bool1) && (!bool5) && (!bool6) && (i1 == 0) && (!bool3) && (!paramBoolean3)) {
        break label393;
      }
    }
    label387:
    label393:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool6), Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(paramBoolean3) }));
      paramBoolean3 = bool2;
      int i2 = 1;
      i1 = i2;
      if (n != 0)
      {
        i1 = i2;
        if (paramBoolean1) {
          i1 = 6;
        }
      }
      if (paramBoolean3) {
        pha.b(i1);
      }
      return paramBoolean3;
      localObject2 = b();
      if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      label365:
      l1 = bmqa.g((AppRuntime)localObject1);
      break label61;
      label375:
      n = 0;
      break label81;
      label381:
      bool3 = false;
      break label123;
      i1 = 0;
      break label160;
    }
    label399:
    if ((paramBoolean2) || (bool1) || (bool5) || ((n != 0) && (paramBoolean1)) || (i1 != 0) || (bool3))
    {
      paramBoolean3 = true;
      label434:
      if ((n == 0) || (!paramBoolean1)) {
        break label527;
      }
    }
    label527:
    for (bool2 = true;; bool2 = false)
    {
      QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool1), Boolean.valueOf(bool5), Boolean.valueOf(bool2), Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
      break;
      paramBoolean3 = false;
      break label434;
    }
  }
  
  private void c(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new srr(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new sqk(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.jdField_k_of_type_JavaLangString)))
    {
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
      pha.c(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhw.jdField_k_of_type_JavaLangString);
      pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (pha.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      g(paramArticleInfo);
    }
    for (;;)
    {
      ube.a(paramArticleInfo);
      return;
      pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
    }
  }
  
  private void c(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 70) || (pil.c(this.jdField_a_of_type_Int))))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = pmh.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      paramList = (QQAppInterface)pha.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label142;
        }
        paramList = tzo.b(paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = tzo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        tzo.a(((BaseActivity)this.jdField_a_of_type_Ogd.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), paramList, false);
      }
    }
    label142:
    do
    {
      return;
      if (this.jdField_a_of_type_Int == 70)
      {
        ((KandianSubscribeManager)paramList.getManager(280)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Long);
        return;
      }
    } while (!pil.c(this.jdField_a_of_type_Int));
    ((KandianDailyManager)paramList.getManager(296)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  private void c(rev paramrev)
  {
    if (pha.j(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      Object localObject1 = (BaseArticleInfo)paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
      Object localObject3 = ube.a(getContext(), ((BaseArticleInfo)localObject1).mArticleID, ((BaseArticleInfo)localObject1).mAlgorithmID, 54, this.jdField_a_of_type_Int, ((BaseArticleInfo)localObject1).getInnerUniqueID(), ((BaseArticleInfo)localObject1).getVideoVid(), ube.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).videoReportInfo);
      localObject1 = localObject3;
      if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {}
      try
      {
        localObject1 = new JSONObject((String)localObject3);
        if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
        {
          ((JSONObject)localObject1).put("short_content_gif", 1);
          localObject1 = ((JSONObject)localObject1).toString();
          localObject3 = localObject1;
          if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            localObject3 = new JSONObject((String)localObject1);
            ((JSONObject)localObject3).put("account_expose_card", pha.c(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
            localObject3 = ((JSONObject)localObject3).toString();
            pha.c(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject3);
            return;
            ((JSONObject)localObject1).put("short_content_gif", 0);
          }
          localJSONException1 = localJSONException1;
          QLog.e("ReadInJoyListViewGroup", 2, localJSONException1.getMessage());
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.e("ReadInJoyListViewGroup", 2, localJSONException2.getMessage());
            Object localObject4 = localObject2;
          }
        }
      }
    }
    Object localObject2 = ube.a(getContext(), paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, paramrev.jdField_k_of_type_Int, paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, ube.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
    oat.a(null, "CliOper", "", paramrev.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), (String)localObject2, false);
    oat.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new skc(null, null, null, null).W(54).h(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).x(paramrev.jdField_k_of_type_Int + 1).f(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a(), false);
  }
  
  private void d(int paramInt)
  {
    if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)getContext()).g(paramInt);
    }
    for (;;)
    {
      if (pil.c(this.jdField_a_of_type_Int)) {
        pfk.a(paramInt);
      }
      P();
      return;
      if ((getContext() instanceof SplashActivity))
      {
        ReadinjoyTabFrame localReadinjoyTabFrame = pha.a(getContext());
        if (localReadinjoyTabFrame != null) {
          localReadinjoyTabFrame.a(paramInt);
        }
      }
    }
  }
  
  private void d(int paramInt, List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setAdapterData(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = pha.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(162)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(true);
          }
        }
      }
      Object localObject2;
      StringBuilder localStringBuilder;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = pmh.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label307;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = pha.d((String)localObject1);
        localStringBuilder = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label314;
        }
      }
      label307:
      label314:
      for (Object localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label352;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject2 = (Long)paramList.next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject2 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject1).toString());
      label352:
      paramList = pmh.a().a();
      if (paramList != null) {
        a(paramList.a(this.jdField_a_of_type_Int));
      }
    }
  }
  
  private void d(ArticleInfo paramArticleInfo)
  {
    String str = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", str);
      getContext().startActivity(localIntent);
    }
    pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
  }
  
  private void d(List<Long> paramList)
  {
    Object localObject = pha.a();
    if ((!bmqa.B((AppRuntime)localObject)) || (!bmqa.C((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int n = 5;; n = paramList.size())
    {
      localObject = new ArrayList();
      int i1 = 0;
      while (i1 < n)
      {
        long l1 = ((Long)paramList.get(i1)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Sng.a(this.jdField_a_of_type_Int, l1);
        if ((localBaseArticleInfo != null) && (!pha.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        i1 += 1;
      }
    }
    pmh.a().a().a((List)localObject);
  }
  
  private void d(rev paramrev)
  {
    if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0) {
      ComponentContentRecommend.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
      {
        ComponentContentRecommendFollowList.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
        return;
      }
    } while (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2);
    ComponentContentRecommendFollowGroup.a(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
  }
  
  private void e(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = new avjm();
      if (this.jdField_a_of_type_Int != 56) {
        break label140;
      }
      ((avjm)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
      ((avjm)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (paramArticleInfo.mCommentIconType == 1) {
        localBundle.putBoolean("jump_now_switch", bool);
      }
      try
      {
        localObject2 = (avju)((QQAppInterface)localObject2).getManager(306);
        localBundle.putString("roomid", paramArticleInfo.mArticleContentUrl);
        localBundle.putString("fromid", ((avjm)localObject1).jdField_b_of_type_JavaLangString);
        ((avju)localObject2).a(localBundle);
        pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
        return;
        label140:
        ((avjm)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((avjm)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
        continue;
        bool = false;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "subscribeId to roomId error, " + localNumberFormatException.getMessage());
          }
        }
      }
    }
  }
  
  private void e(Map<Long, rev> paramMap)
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      sfn localsfn = this.jdField_a_of_type_Ogd.a();
      if (localsfn != null)
      {
        paramMap = paramMap.values().iterator();
        while (paramMap.hasNext())
        {
          rev localrev = (rev)paramMap.next();
          localrev.jdField_h_of_type_Int = localsfn.a();
          if (localsfn.a(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
            localrev.jdField_f_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  private void e(rev paramrev)
  {
    if (paramrev.jdField_c_of_type_Boolean) {
      try
      {
        if (paramrev.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = pha.a();
          localJSONObject.put("feeds_source", paramrev.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", pha.e());
          if (ube.a(this.jdField_a_of_type_Int)) {}
          for (String str = "0X8009358";; str = "0X800744E")
          {
            oat.a(null, "CliOper", "", "", str, str, 0, 0, pha.e(paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", localJSONObject.toString(), false);
            return;
          }
        }
        return;
      }
      catch (JSONException paramrev)
      {
        paramrev.printStackTrace();
      }
    }
  }
  
  private void f(ArticleInfo paramArticleInfo)
  {
    pha.a(a(), paramArticleInfo, this.jdField_a_of_type_Sng, this.jdField_a_of_type_Int);
    pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Sng.notifyDataSetChanged();
    pha.a(a(), paramArticleInfo);
  }
  
  private void f(Map<Long, rev> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (rev)paramMap.next();
      if (!((rev)localObject2).jdField_b_of_type_Boolean)
      {
        ((rev)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = pha.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((rev)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((rev)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((rev)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((rev)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((rev)localObject2).jdField_e_of_type_JavaLangString;
        if (((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new rgi();
          if (this.jdField_d_of_type_Long != 0L) {
            break label606;
          }
        }
        label606:
        for (int n = 1;; n = 0)
        {
          ((rgi)localObject1).jdField_c_of_type_Int = n;
          localObject1 = ((rgi)localObject1).toString();
          localReportInfo.mInnerId = ((rev)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new rgh();
          ((rgh)localObject1).jdField_a_of_type_Long = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null) {
            ((rgh)localObject1).jdField_b_of_type_Long = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long;
          }
          ((rgh)localObject1).jdField_a_of_type_Int = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((rgh)localObject1).jdField_b_of_type_Int = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((rev)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((rgh)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            rha localrha = (rha)((Iterator)localObject2).next();
            if (localrha != null) {
              ((rgh)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrha.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((rgh)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      pmh.a().a(localArrayList);
    }
  }
  
  private void f(rev paramrev)
  {
    long l3;
    int n;
    int i1;
    int i2;
    long l1;
    String str1;
    String str2;
    if ((paramrev.jdField_c_of_type_Int == 48) || (paramrev.jdField_c_of_type_Int == 49) || (paramrev.jdField_c_of_type_Int == 50) || (paramrev.jdField_c_of_type_Int == 51) || (paramrev.jdField_c_of_type_Int == 52) || (paramrev.jdField_c_of_type_Int == 53) || (paramrev.jdField_c_of_type_Int == 78) || (paramrev.jdField_c_of_type_Int == 79) || (paramrev.jdField_c_of_type_Int == 80) || (paramrev.jdField_c_of_type_Int == 1005) || (paramrev.jdField_c_of_type_Int == 1006) || (paramrev.jdField_c_of_type_Int == 1007))
    {
      l3 = paramrev.jdField_b_of_type_Long;
      n = paramrev.jdField_k_of_type_Int;
      i1 = pfe.a(this.jdField_a_of_type_Int, paramrev.jdField_c_of_type_Int);
      i2 = pfe.a(paramrev.jdField_c_of_type_Int);
      l1 = 0L;
      str1 = null;
      str2 = null;
      if (paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break label307;
      }
      l1 = paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      str1 = paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      str2 = paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
    }
    label307:
    for (long l2 = paramrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str3 = pfe.a(getContext(), pha.a(), i1, l1, l3, n, str1, str2, i2, this.jdField_a_of_type_Int);
      oat.a(null, paramrev.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str3, false);
      pfe.a(7, pha.a(), (int)l2, i1, l3, n, str1, str2);
      return;
    }
  }
  
  private void g(ArticleInfo paramArticleInfo)
  {
    tch.b("fast_web_show_light_house_1");
    pwt localpwt = pmh.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pha.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localpwt != null) {
      this.jdField_g_of_type_Int = localpwt.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    f(localArticleInfo);
  }
  
  private boolean g()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private boolean h()
  {
    List localList = (List)this.jdField_a_of_type_Ogd.a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l1 = ((Long)localList.get(0)).longValue(); Long.valueOf(l1).longValue() != 0L; l1 = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean i()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  private boolean j()
  {
    if ((i()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void w()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.4(this));
  }
  
  private void x()
  {
    if (!pha.r())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838758);
      int n = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(n);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bkqc);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bkhe);
    if ((this.jdField_a_of_type_Int == 0) || (pil.c(this.jdField_a_of_type_Int))) {
      rat.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void y()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    int n;
    if ((this.jdField_a_of_type_Ogd instanceof ofx))
    {
      localActivity = a();
      if (localActivity.findViewById(2131362001) != null) {
        b(true);
      }
      while (localActivity.findViewById(2131362002) == null) {
        return;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362002);
      localView1 = localActivity.findViewById(2131378804);
      n = afur.a(50.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
      n += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    label225:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, n, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + n);
      }
      View localView2 = findViewById(2131366993);
      localView2.setPadding(0, n, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.5(this, localView1, n, localView2));
      return;
      if (!(this.jdField_a_of_type_Ogd instanceof ogr)) {
        break;
      }
      ((ogr)this.jdField_a_of_type_Ogd).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Sng);
      return;
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_Sng.b(b());
    this.jdField_a_of_type_Sng.a(this.jdField_e_of_type_Long);
    this.jdField_a_of_type_Sng.a(this);
    this.jdField_a_of_type_Sng.a(this);
    this.jdField_a_of_type_Sng.a(this);
    this.jdField_a_of_type_Sng.a(this);
    this.jdField_a_of_type_Sng.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Sng);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public Object a(pue parampue)
  {
    if (parampue == null) {
      return null;
    }
    int n = -1;
    int i1 = 0;
    Object localObject = null;
    long l1;
    if (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampue.a((ptx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1));
      if (parampue.a == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = parampue.a;
        n = ((ptx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a();
        parampue.a = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1)), ", jobName : ", parampue.a(), ", cost : ", Long.valueOf(l2 - l1) });
      i1 += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + n + ", now : " + ((ptx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a());
      return localObject;
    }
  }
  
  public List<tcj> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public ptx a()
  {
    return a(2);
  }
  
  public ptx a(int paramInt)
  {
    return (ptx)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public sng a()
  {
    return this.jdField_a_of_type_Sng;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    F();
    a(new sqr(this, "onResume"));
    W();
    if (a()) {
      j();
    }
    H();
    if (System.currentTimeMillis() - this.jdField_f_of_type_Long > 10000L)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.20(this));
    }
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.j();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tcj)localIterator.next()).c();
    }
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (pil.c(this.jdField_a_of_type_Int))) {
      rat.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    I();
    G();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    ((KandianMergeManager)pha.a().getManager(162)).a(this.jdField_a_of_type_Plz);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.21(this), 50L);
    rec.a(a());
    b(false);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Sng != null)) {
      a(true, 1001, true);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 3321	sqq
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 3323
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 3326	sqq:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 238	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lpue;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 3330	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:c	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +60 -> 126
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne +30 -> 101
    //   74: aload_3
    //   75: ifnull +26 -> 101
    //   78: invokestatic 218	pha:a	()Lmqq/app/AppRuntime;
    //   81: checkcast 220	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   92: invokevirtual 3333	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 3338	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: getstatic 3343	uam:a	Luam;
    //   104: astore_3
    //   105: iconst_m1
    //   106: iload_2
    //   107: if_icmpne +13 -> 120
    //   110: iconst_1
    //   111: istore 4
    //   113: aload_3
    //   114: iload 4
    //   116: invokevirtual 3344	uam:a	(Z)V
    //   119: return
    //   120: iconst_0
    //   121: istore 4
    //   123: goto -10 -> 113
    //   126: iload_1
    //   127: sipush 19202
    //   130: if_icmpeq +9 -> 139
    //   133: iload_1
    //   134: bipush 125
    //   136: if_icmpne +28 -> 164
    //   139: getstatic 3343	uam:a	Luam;
    //   142: astore_3
    //   143: iconst_m1
    //   144: iload_2
    //   145: if_icmpne +13 -> 158
    //   148: iconst_1
    //   149: istore 4
    //   151: aload_3
    //   152: iload 4
    //   154: invokevirtual 3344	uam:a	(Z)V
    //   157: return
    //   158: iconst_0
    //   159: istore 4
    //   161: goto -10 -> 151
    //   164: iload_1
    //   165: iconst_2
    //   166: if_icmpne +10 -> 176
    //   169: aload_0
    //   170: iconst_2
    //   171: aload_3
    //   172: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   175: return
    //   176: iload_1
    //   177: iconst_1
    //   178: if_icmpne +10 -> 188
    //   181: aload_0
    //   182: iconst_1
    //   183: aload_3
    //   184: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   187: return
    //   188: iload_1
    //   189: sipush 10922
    //   192: if_icmpne +49 -> 241
    //   195: iload_2
    //   196: sipush -10069
    //   199: if_icmpne -168 -> 31
    //   202: aload_3
    //   203: ifnull -172 -> 31
    //   206: aload_3
    //   207: invokevirtual 3348	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   210: ldc_w 3350
    //   213: invokevirtual 3353	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   216: checkcast 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   219: astore_3
    //   220: aload_3
    //   221: ifnull -190 -> 31
    //   224: aload_0
    //   225: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 305	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Sng	Lsng;
    //   233: aload_0
    //   234: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   237: invokestatic 2419	pha:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lsnh;I)V
    //   240: return
    //   241: iload_1
    //   242: bipush 117
    //   244: if_icmpne +65 -> 309
    //   247: aload_3
    //   248: ldc_w 1319
    //   251: invokevirtual 1323	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   254: checkcast 653	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   257: astore 5
    //   259: invokestatic 3356	ova:a	()Z
    //   262: ifeq +31 -> 293
    //   265: iload_2
    //   266: sipush 1699
    //   269: if_icmpne +24 -> 293
    //   272: aload 5
    //   274: invokestatic 3357	ouj:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   277: ifeq +16 -> 293
    //   280: aload_0
    //   281: invokevirtual 2192	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()I
    //   284: ifne +9 -> 293
    //   287: aload_0
    //   288: aload_3
    //   289: invokespecial 3359	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Landroid/content/Intent;)V
    //   292: return
    //   293: aload_0
    //   294: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   297: checkcast 795	com/tencent/mobileqq/app/BaseActivity
    //   300: getfield 799	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: aload_3
    //   304: iload_2
    //   305: invokestatic 3364	paa:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   308: return
    //   309: iload_1
    //   310: sipush 20001
    //   313: if_icmpne +35 -> 348
    //   316: invokestatic 218	pha:a	()Lmqq/app/AppRuntime;
    //   319: astore_3
    //   320: aload_3
    //   321: ifnull -290 -> 31
    //   324: aload_3
    //   325: sipush 162
    //   328: invokevirtual 582	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   331: checkcast 837	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   334: invokevirtual 3366	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:r	()V
    //   337: ldc_w 467
    //   340: iconst_1
    //   341: ldc_w 3368
    //   344: invokestatic 474	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: return
    //   348: iload_1
    //   349: sipush 1032
    //   352: if_icmpne +176 -> 528
    //   355: aload_3
    //   356: ldc_w 3370
    //   359: invokevirtual 3373	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_3
    //   363: aload_3
    //   364: ifnull -333 -> 31
    //   367: new 1028	org/json/JSONObject
    //   370: dup
    //   371: aload_3
    //   372: invokespecial 1030	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore_3
    //   376: new 1028	org/json/JSONObject
    //   379: dup
    //   380: invokespecial 2524	org/json/JSONObject:<init>	()V
    //   383: astore 5
    //   385: aload 5
    //   387: ldc_w 1258
    //   390: aload_0
    //   391: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   394: invokevirtual 1046	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload 5
    //   400: ldc_w 3375
    //   403: aload_3
    //   404: ldc_w 3375
    //   407: invokevirtual 3378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 1036	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload 5
    //   416: ldc_w 3380
    //   419: ldc_w 1700
    //   422: invokevirtual 1036	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   425: pop
    //   426: aconst_null
    //   427: ldc_w 1698
    //   430: ldc_w 1700
    //   433: ldc_w 1700
    //   436: ldc_w 3382
    //   439: ldc_w 3382
    //   442: iconst_0
    //   443: iconst_0
    //   444: new 635	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 636	java/lang/StringBuilder:<init>	()V
    //   451: aload_3
    //   452: ldc_w 3384
    //   455: invokevirtual 3378	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokevirtual 642	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc_w 1700
    //   464: invokevirtual 642	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 649	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: ldc_w 3386
    //   473: ldc_w 1700
    //   476: aload 5
    //   478: invokevirtual 1052	org/json/JSONObject:toString	()Ljava/lang/String;
    //   481: iconst_0
    //   482: invokestatic 1721	oat:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   485: return
    //   486: astore_3
    //   487: ldc_w 467
    //   490: iconst_1
    //   491: new 635	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 636	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 3388
    //   501: invokevirtual 642	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_3
    //   505: invokevirtual 3389	java/lang/Exception:toString	()Ljava/lang/String;
    //   508: invokevirtual 642	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 649	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 1344	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: return
    //   518: astore 6
    //   520: aload 6
    //   522: invokevirtual 596	java/lang/Exception:printStackTrace	()V
    //   525: goto -99 -> 426
    //   528: iload_1
    //   529: sipush 9999
    //   532: if_icmpne +39 -> 571
    //   535: iload_2
    //   536: iconst_m1
    //   537: if_icmpne -506 -> 31
    //   540: aload_3
    //   541: ifnull -510 -> 31
    //   544: aload_3
    //   545: ldc_w 3391
    //   548: invokevirtual 1323	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   551: astore_3
    //   552: aload_3
    //   553: instanceof 2413
    //   556: ifeq -525 -> 31
    //   559: aload_0
    //   560: getfield 305	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Sng	Lsng;
    //   563: aload_3
    //   564: checkcast 2413	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   567: invokevirtual 3394	sng:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   570: return
    //   571: iload_1
    //   572: bipush 102
    //   574: if_icmpne +28 -> 602
    //   577: getstatic 3343	uam:a	Luam;
    //   580: astore_3
    //   581: iload_2
    //   582: iconst_m1
    //   583: if_icmpne +13 -> 596
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_3
    //   590: iload 4
    //   592: invokevirtual 3344	uam:a	(Z)V
    //   595: return
    //   596: iconst_0
    //   597: istore 4
    //   599: goto -10 -> 589
    //   602: iload_1
    //   603: ldc_w 3395
    //   606: if_icmpne -575 -> 31
    //   609: getstatic 3343	uam:a	Luam;
    //   612: astore_3
    //   613: iload_2
    //   614: iconst_m1
    //   615: if_icmpne +13 -> 628
    //   618: iconst_1
    //   619: istore 4
    //   621: aload_3
    //   622: iload 4
    //   624: invokevirtual 3344	uam:a	(Z)V
    //   627: return
    //   628: iconst_0
    //   629: istore 4
    //   631: goto -10 -> 621
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	634	0	this	ReadInJoyListViewGroup
    //   0	634	1	paramInt1	int
    //   0	634	2	paramInt2	int
    //   0	634	3	paramIntent	Intent
    //   111	519	4	bool	boolean
    //   257	220	5	localObject	Object
    //   518	3	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   367	385	486	java/lang/Exception
    //   426	485	486	java/lang/Exception
    //   520	525	486	java/lang/Exception
    //   385	426	518	java/lang/Exception
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Sng.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Int == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        paa.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        paa.a(paramArticleInfo, paramString1);
        QQToast.a(a(), 0, a().getString(2131716941), 0).a();
        QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult failed " + paramInt);
    QQToast.a(a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    uac.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sng == null)) {
      return;
    }
    a(new sqw(this, "onChannelArticleLoaded", paramInt, paramList));
    d(paramInt, paramList);
    c(paramList);
    this.jdField_a_of_type_Pgm.jdField_b_of_type_Long = 0L;
    if (!this.jdField_g_of_type_Boolean)
    {
      bool = true;
      bool = a(bool);
      this.jdField_e_of_type_Boolean = bool;
      oqr.a().a(this.jdField_a_of_type_Int, bool);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label270;
      }
    }
    for (int n = 1;; n = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)pha.a().getManager(162)).f();
        if (paramInt <= 0) {
          break label325;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label270:
          localException.printStackTrace();
          paramInt = 0;
          continue;
          bool = pha.b(((ReadInJoyNewFeedsActivity)a()).b());
          continue;
          bool = true;
          continue;
          if (this.jdField_a_of_type_Int != 0)
          {
            L();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(a() instanceof ReadInJoyNewFeedsActivity)) {
        break label305;
      }
      if (n == 0) {
        break label287;
      }
      bool = true;
      if ((!this.jdField_e_of_type_Boolean) && (bool))
      {
        if ((n == 0) && (paramInt != 0)) {
          break label311;
        }
        L();
      }
      if (!this.jdField_e_of_type_Boolean) {
        pjr.a(this.jdField_a_of_type_Sng.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = true;
      }
      b(paramList);
      M();
      if ((this.jdField_a_of_type_Int == 0) && (qqm.a().b())) {
        V();
      }
      uac.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      uac.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      uac.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      bool = false;
      break;
    }
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(bmqa.u(pha.a())).booleanValue()) {
        tlg.a(paramContext, "", "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        pmh.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Sng.notifyDataSetChanged();
        ube.a(paramArticleInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery failed: isShowViolaPage is false");
        }
      }
    }
    QLog.e("ReadInJoyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(Configuration paramConfiguration)
  {
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_h_of_type_Int) || ((!bqcd.e()) && (!bqcd.d()))) {
      return;
    }
    this.jdField_h_of_type_Int = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.41(this));
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            pha.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
            a(new srd(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (ryx.a(paramArticleInfo, getContext()));
          paramInt = snh.c(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = snh.c(paramArticleInfo);
          if ((qyo.b(paramInt)) || (snh.i(paramArticleInfo)) || (snh.g(paramArticleInfo)) || (snh.j(paramArticleInfo)) || (snh.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (snh.a(paramArticleInfo) == 23) || (snh.b(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              pha.a(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhr.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              P();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                qib.a(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!snh.a(paramArticleInfo)) && (!snh.h(paramArticleInfo)) && (!pha.b(paramArticleInfo)) && (!pha.c(paramArticleInfo)) && (!pha.e(paramArticleInfo)) && (!pha.f(paramArticleInfo)));
        if (pha.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          qib.a(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      qib.a(getContext(), paramArticleInfo);
      return;
    }
    b(paramArticleInfo, 2);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i3 = this.jdField_a_of_type_Int;
    Object localObject1 = pha.d(paramArticleInfo);
    int n;
    int i1;
    label36:
    int i2;
    label49:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      n = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label765;
      }
      i1 = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label770;
      }
      i2 = paramArticleInfo.videoJumpChannelID;
      oat.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.b(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), this.jdField_a_of_type_Int, n), false);
      oat.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.b(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), this.jdField_a_of_type_Int, n));
      localObject2 = ube.b(i3);
      if ((!snh.i(paramArticleInfo)) && (!snh.g(paramArticleInfo)) && (!snh.j(paramArticleInfo)) && (!snh.k(paramArticleInfo))) {
        break label777;
      }
      localObject3 = new skc(pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), i3, n, i1, bgnt.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((skc)localObject3).h(i2).c((String)och.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pha.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      oat.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rhs.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((skc)localObject3).a().a(), false);
    }
    for (;;)
    {
      oat.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), i3, n, i1, bgnt.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), i2, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = pha.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!rec.c(paramArticleInfo)) && (!pgw.a().a()) && (pha.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label932;
      }
      localObject3 = new rgh();
      ((rgh)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha != null) {
        ((rgh)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rha.jdField_a_of_type_Long;
      }
      ((rgh)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((rgh)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label925;
      }
      ((rgh)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        rha localrha = (rha)((Iterator)localObject4).next();
        if (localrha != null) {
          ((rgh)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localrha.jdField_a_of_type_Long));
        }
      }
      n = 0;
      break;
      label765:
      i1 = 1;
      break label36;
      label770:
      i2 = 56;
      break label49;
      label777:
      localObject3 = new skc(pha.a(paramArticleInfo.mAlgorithmID, pha.a(paramArticleInfo), i3, n, i1, bgnt.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, pha.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((skc)localObject3).h(i2).c((String)och.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(pha.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      oat.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((skc)localObject3).a().a(), false);
    }
    label925:
    ((ReportInfo)localObject2).mFeedsReportData = ((rgh)localObject3);
    label932:
    ((List)localObject1).add(localObject2);
    pmh.a().a((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!ubb.a((AdvertisementInfo)paramArticleInfo, i3)) {
        break label1010;
      }
      n = nxw.T;
    }
    for (;;)
    {
      nxw.a(new omp().a(BaseApplicationImpl.getContext()).a(nxw.jdField_a_of_type_Int).b(n).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1010:
      if (pha.a(paramArticleInfo)) {
        n = nxw.S;
      } else {
        n = nxw.N;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    int n = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (pha.s(localArticleInfo)) {
      if ((pha.m(localArticleInfo)) || (pha.c(localArticleInfo)))
      {
        a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramInt = 4;
        d(paramInt);
      }
    }
    do
    {
      return;
      if (pha.e(localArticleInfo))
      {
        paramInt = n;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
        paramInt = n;
        break;
      }
      g(localArticleInfo);
      paramInt = 2;
      break;
      a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
    } while (paramBaseArticleInfo == null);
    paramBaseArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    if ((paramTopBannerInfo == null) || (paramTopBannerInfo.mChannelId != this.jdField_a_of_type_Int)) {}
    while (this.jdField_a_of_type_Int == 41695) {
      return;
    }
    if (paramTopBannerInfo.isEmpty())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = new ChannelTopBanner(a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner, 2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Sng, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    a(new sra(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int n;
    if (paramInt != 0)
    {
      bool1 = true;
      if (pil.c(this.jdField_a_of_type_Int))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label227;
        }
        pfk.a(1);
      }
      if ((pha.a()) && (!i()) && (!bool1)) {
        break label239;
      }
      n = 1;
      label79:
      if (n == 0) {
        break label244;
      }
      n = 3;
      label85:
      if (paramInt == 2) {
        break label313;
      }
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label251;
      }
      paramReadInJoyBaseListView = (ReadInJoyNewFeedsActivity)getContext();
      paramReadInJoyBaseListView.g(1);
      if (this.jdField_a_of_type_Int == 0) {
        paramReadInJoyBaseListView.c(false);
      }
      label125:
      pha.b(3);
      label129:
      a(true, n, bool1);
      if ((this.jdField_a_of_type_Int == 0) && (paramInt != 2))
      {
        if (!bmqa.s()) {
          break label336;
        }
        pmh.a().a().a();
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.32(this));
      paramReadInJoyBaseListView = this.jdField_c_of_type_JavaUtilList.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        tcj localtcj = (tcj)paramReadInJoyBaseListView.next();
        if ((localtcj instanceof ReadInJoyDiandianHeaderController)) {
          localtcj.e();
        }
      }
      bool1 = false;
      break;
      label227:
      if (paramInt == 2) {
        break label59;
      }
      pfk.a(1);
      break label59;
      label239:
      n = 0;
      break label79;
      label244:
      n = 1001;
      break label85;
      label251:
      if (!(getContext() instanceof SplashActivity)) {
        break label125;
      }
      pmk.a().a(2, null);
      paramReadInJoyBaseListView = pha.a(getContext());
      boolean bool2 = pha.b(this.jdField_a_of_type_Int, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.a(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      ube.a(1);
      break label125;
      label313:
      if ((getContext() instanceof SplashActivity)) {
        pmk.a().a(2, null);
      }
      n = 1;
      break label129;
      label336:
      pmk.a().g(2);
    }
    if (this.jdField_a_of_type_Int == 0) {
      ube.d();
    }
    ptq.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    php localphp = new php(Integer.valueOf(0));
    b(paramView);
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (localArticleInfo != null)
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramBaseArticleInfo.innerUniqueID);
      a(new srb(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      a(paramBaseArticleInfo);
      pha.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      if (a(paramBaseArticleInfo, paramView, paramInt, localphp, localArticleInfo)) {
        return;
      }
      a(paramInt, localArticleInfo);
    }
    d(((Integer)localphp.a()).intValue());
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i1 = this.jdField_a_of_type_Sng.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int n = 0;
        while (n < 5)
        {
          long l1 = ((Long)paramList.get(n)).longValue();
          Object localObject = this.jdField_a_of_type_Sng.a(i1, l1);
          if ((localObject != null) && (!pha.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!pha.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Sng.a(i1, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (abbs.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          n += 1;
        }
      }
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, rev> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    a(new sqn(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = ube.a(this.jdField_a_of_type_Int);
    String str = pha.e(this.jdField_a_of_type_Int);
    ThreadManager.post(new ReadInJoyListViewGroup.14(this, a(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (i())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
      bmqa.a((QQAppInterface)pha.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      label156:
      bmqa.a((QQAppInterface)pha.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Map<Long, rev> paramMap, boolean paramBoolean, Map<Long, ubj> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        ube.a(paramMap1, this.jdField_b_of_type_Boolean);
      }
      return;
    }
    e(paramMap);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label76:
    rev localrev;
    Object localObject;
    long l1;
    int n;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localrev = (rev)localIterator.next();
        if (!localrev.jdField_a_of_type_Boolean)
        {
          localrev.jdField_a_of_type_Boolean = true;
          localObject = a();
          l1 = ((Long)((Pair)localObject).second).longValue();
          n = ((Integer)((Pair)localObject).first).intValue();
          oat.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localrev.jdField_d_of_type_Int), false);
          oat.a("0X80066FC", "", "", Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localrev.jdField_b_of_type_Int), pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localrev.jdField_d_of_type_Int));
          str = pha.a(localrev.jdField_a_of_type_Long, localrev.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localrev.jdField_d_of_type_Int, localrev.jdField_e_of_type_Int, bgnt.h(getContext()), localrev.jdField_a_of_type_JavaLangString, localrev.jdField_c_of_type_JavaLangString, localrev.jdField_e_of_type_JavaLangString, pha.f(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, n, localrev.jdField_f_of_type_Int, localrev.jdField_g_of_type_Int, localrev.jdField_h_of_type_Int, localrev.jdField_f_of_type_Boolean, localrev.jdField_j_of_type_Int, localrev.jdField_i_of_type_Int, localrev.m);
          if (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
            if (this.jdField_a_of_type_Int == 56)
            {
              localObject = b(localrev, str);
              label396:
              str = a(paramMap1, paramString, localrev, (String)localObject);
              if (!ube.a(this.jdField_a_of_type_Int)) {
                break label523;
              }
              localObject = "0X8009354";
              label425:
              if ((!pil.a(this.jdField_a_of_type_Int)) && (!bmqa.a(this.jdField_a_of_type_Int))) {
                break label889;
              }
              localObject = "0X8009CC8";
            }
          }
        }
      }
    }
    label523:
    label889:
    for (;;)
    {
      if (snh.i(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        a(localrev, str, (String)localObject);
      }
      for (;;)
      {
        f(localrev);
        e(localrev);
        a(localrev);
        b(localrev);
        break label76;
        localObject = str;
        if (this.jdField_a_of_type_Int != 0) {
          break label396;
        }
        localObject = a(localrev, str);
        break label396;
        localObject = "0X8007626";
        break label425;
        if (pha.l(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          c(localrev);
        }
        else if (pha.t(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          pha.a(localrev, str, (String)localObject);
        }
        else if (pha.s(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          b(localrev, str, (String)localObject);
        }
        else if (pha.u(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          d(localrev);
        }
        else
        {
          if (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
          {
            localObject = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
            if (localObject == null) {
              break;
            }
            pha.a(false, (JSONObject)localObject, localrev);
            pha.a(true, (JSONObject)localObject, localrev);
            continue;
          }
          if (pha.q(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            pha.a(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localrev);
          }
          else
          {
            if (pha.i(localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
            {
              BaseArticleInfo localBaseArticleInfo = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              JSONObject localJSONObject = pha.a(localBaseArticleInfo.mPolymericInfo);
              oat.a(null, "CliOper", "", localrev.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localrev.jdField_k_of_type_Int + "", Long.toString(localrev.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(localBaseArticleInfo.mPolymericInfo.jdField_d_of_type_Long), localJSONObject.toString(), false);
              if (localHashMap.containsKey(Long.valueOf(localBaseArticleInfo.mPolymericInfo.jdField_c_of_type_Long))) {
                break label76;
              }
              localHashMap.put(Long.valueOf(localBaseArticleInfo.mPolymericInfo.jdField_c_of_type_Long), Boolean.valueOf(true));
            }
            a(localrev, l1, n, str, (String)localObject);
          }
        }
      }
      if (this.jdField_a_of_type_Int != 40677) {
        f(paramMap);
      }
      ube.a(paramMap1, this.jdField_b_of_type_Boolean);
      sud.a(((Integer)a().first).intValue());
      return;
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, rev> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    a(new sqm(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Pgm.jdField_b_of_type_Long = System.currentTimeMillis();
    if (i()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Pgm.jdField_d_of_type_Long = bmqa.a((QQAppInterface)pha.a(), a());; this.jdField_a_of_type_Pgm.jdField_d_of_type_Long = bmqa.a((QQAppInterface)pha.a(), this.jdField_a_of_type_Int))
    {
      q();
      uac.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!a()) {
        break;
      }
      return;
    }
    j();
  }
  
  public void a(pue parampue)
  {
    if (parampue == null) {}
    for (;;)
    {
      return;
      int n = 0;
      while (n < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampue.a((ptx)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(n)), ", jobName : ", parampue.a(), ", cost : ", Long.valueOf(l2 - l1) });
        n += 1;
      }
    }
  }
  
  public void a(sey paramsey1, sey paramsey2)
  {
    this.jdField_h_of_type_Boolean = false;
    ((ptz)a(2)).l();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, afur.a(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131298694), 0, 0);
    }
  }
  
  public void a(tff paramtff)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramtff);
      this.jdField_a_of_type_Tff = paramtff;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt != 8) {
        break;
      }
      V();
    } while (!this.i);
    a(new sqo(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.16(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      n();
      ptq.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int i2 = 0;
    int n;
    int i1;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      n = 0;
      for (paramInt = -1; n < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(); paramInt = i1)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(n);
        i1 = paramInt;
        if (localObject != null)
        {
          i1 = paramInt;
          if (((View)localObject).getTag() != null)
          {
            i1 = paramInt;
            if ((((View)localObject).getTag() instanceof pum))
            {
              localObject = (pum)((View)localObject).getTag();
              i1 = paramInt;
              if (paramLong == ((pum)localObject).jdField_a_of_type_Sey.jdField_c_of_type_Long) {
                i1 = ((pum)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        n += 1;
      }
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - i1;
      if (n >= 0) {
        break label354;
      }
      n = i2;
    }
    label354:
    for (;;)
    {
      i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() - i1;
      if ((paramInt + 1 >= n) && (paramInt + 1 <= i2))
      {
        this.jdField_a_of_type_Sng.a(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Sng.c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Ogd.a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + n + ", lastVisblePosi=" + i2 + "， headerCount=" + i1);
        }
        return;
        this.jdField_a_of_type_Sng.a(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Sng.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sng == null)) {
      return;
    }
    a(new sqx(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Sng.getCount() == 0) {}
    int i1 = pmh.a().a(Integer.valueOf(paramInt));
    if (this.i)
    {
      if ((paramList != null) && (i1 == 1)) {
        this.jdField_a_of_type_Sng.c(0);
      }
      this.i = false;
    }
    qqm.a().a();
    Object localObject = new StringBuilder().append("onChannelRefreshed, success = ").append(paramBoolean1).append(", refreshedArticleSize = ").append(i1).append(", articleSeqList size = ");
    if (paramList != null) {}
    for (int n = paramList.size();; n = 0)
    {
      QLog.d("ReadInJoyListViewGroup", 1, n);
      if (!paramBoolean1) {
        break label704;
      }
      if ((paramList == null) || (i1 <= 0) || (paramList.size() <= 0)) {
        break label641;
      }
      if (!QLog.isColorLevel()) {
        break label303;
      }
      localObject = new StringBuilder("onChannelRefreshed ");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
      }
    }
    QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject).toString());
    label303:
    if (!this.jdField_a_of_type_Sng.i) {
      this.jdField_a_of_type_Sng.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Sng.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Sng.i + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Sng.jdField_h_of_type_Boolean);
    }
    rvt.a().c(true);
    setAdapterData(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
    this.jdField_a_of_type_Sng.a(0);
    if ((paramInt == 56) || (paramInt == 0))
    {
      localObject = pha.a();
      if (localObject != null) {
        ((ooi)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    if ((paramInt == 0) || (pil.c(this.jdField_a_of_type_Int))) {
      pmy.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
    b(paramBoolean1, i1);
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.k)) {
      if (this.jdField_a_of_type_Ovs != null) {
        break label731;
      }
    }
    label641:
    label704:
    label731:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
      this.k = false;
      if ((pil.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      a(paramList);
      d(paramList);
      AbstractGifImage.resumeAll();
      ptu.a(this.jdField_a_of_type_Sng.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Sng);
      pjr.a(this.jdField_a_of_type_Sng.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Sng.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131717039), getResources().getDrawable(2130849387));
        break;
      }
      a(getResources().getString(2131717128));
      break;
      if (!this.jdField_a_of_type_Sng.isEmpty()) {
        break;
      }
      a(getResources().getString(2131717087));
      break;
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Srt != null) {
      this.jdField_a_of_type_Srt.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.a(2, null);
    }
    a(new srg(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Sng != null) {
      ptq.a(this.jdField_a_of_type_Sng.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sng == null) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, localStringBuilder.toString());
        }
        rvt.a().c(true);
        setAdapterData(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Sng.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Sng.isEmpty());
    a(getResources().getString(2131717128));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int n = 0;
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.jdField_d_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = pha.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L)) {
        break label205;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(162)).g()) {
        n = 4;
      }
      n |= 0x2;
    }
    for (;;)
    {
      int i1;
      if ((this.jdField_a_of_type_Int == 40830) || (pil.c(this.jdField_a_of_type_Int)))
      {
        i1 = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i1 + 1);
      }
      for (;;)
      {
        pmh.a().a(this.jdField_a_of_type_Int, b(), paramInt, n, i1);
        ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.33(this));
        return;
        bool = false;
        break;
        i1 = 1;
      }
      label205:
      n = 0;
    }
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sng == null))
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    a(new sqz(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
    }
    boolean bool1;
    label104:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.jdField_a_of_type_Int == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label317;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_b_of_type_Boolean = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (bool1) {
        break label322;
      }
    }
    label317:
    label322:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.a(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "autoLoad:" + this.jdField_d_of_type_Boolean + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(getContext()));
      }
      if ((!this.jdField_d_of_type_Boolean) && (bool1) && (GesturePWDUtils.isAppOnForeground(getContext())) && (this.jdField_a_of_type_Int != 70))
      {
        paramList = getResources().getString(2131716883);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      if ((pil.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      this.jdField_d_of_type_Boolean = false;
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label104;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Ogd.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Sng == null)) {
      return;
    }
    this.jdField_a_of_type_Sng.b(pmh.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Sng.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, rev> paramMap)
  {
    a(new sql(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Ohj != null) {
      this.jdField_a_of_type_Ohj.a(paramMap);
    }
  }
  
  public boolean c()
  {
    int n = a().getIntent().getIntExtra("launch_from", -1);
    return (n == 9) || (n == 6);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    a(new sqt(this, "onPause"));
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.k();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((tcj)localIterator.next()).d();
    }
    J();
    long l1 = System.currentTimeMillis();
    K();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.e();
    }
    ptq.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void d(Map<Integer, rev> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        rev localrev = (rev)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int i1 = ovs.jdField_b_of_type_Int;
        if ((localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int n = localrev.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; n = 0)
        {
          ovs.a("0X8009495", localTabChannelCoverInfo, i1, n, -1);
          break;
        }
      }
    }
  }
  
  public boolean d()
  {
    return a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      uad.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    pjr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      uad.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    a(new squ(this, "onStart"));
    qqm.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.i)) {
      a(1500, new ReadInJoyListViewGroup.25(this));
    }
  }
  
  public boolean e()
  {
    Boolean localBoolean = (Boolean)a(new srl(this, "onBackPressed"));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.c());
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStop()");
    }
    a(new sqv(this, "onStop"));
    if ((i()) && (j()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Sng.b(0);
      if (localArticleInfo != null) {
        pmh.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    qqm.a().c();
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "[isOpenFloatingWindow], res = " + this.j);
    }
    return this.j;
  }
  
  public void g()
  {
    a(new sqp(this, "onDestroy"));
    bmqa.a(System.currentTimeMillis(), (QQAppInterface)pha.a());
    Object localObject = ((pmm)pha.a().getManager(163)).a().a();
    if (localObject != null) {
      ((pwt)localObject).b(this.jdField_g_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Anmu);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Sng.d();
    this.jdField_a_of_type_Sng.a();
    this.jdField_a_of_type_Sng.a(null);
    this.jdField_a_of_type_Sng = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      pjr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_Aobu != null)
    {
      this.jdField_a_of_type_Aobu.d();
      this.jdField_a_of_type_Aobu = null;
    }
    bmqa.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Ovs != null)
    {
      this.jdField_a_of_type_Ovs.a();
      this.jdField_a_of_type_Ovs = null;
    }
    if (this.jdField_a_of_type_Suh != null)
    {
      this.jdField_a_of_type_Suh.b();
      this.jdField_a_of_type_Suh = null;
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((tcj)((Iterator)localObject).next()).b();
    }
    localObject = (KandianMergeManager)pha.a().getManager(162);
    ((KandianMergeManager)localObject).b(this.jdField_a_of_type_Plz);
    this.jdField_a_of_type_Plz = null;
    ((KandianMergeManager)localObject).b(this.jdField_a_of_type_Pmb);
    ubb.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
    if (this.jdField_a_of_type_Nxp != null) {
      this.jdField_a_of_type_Nxp.a();
    }
    ptq.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (pil.c(a())) {
      phl.a().b();
    }
    rec.b(a());
    if (this.jdField_a_of_type_Ovb != null) {
      this.jdField_a_of_type_Ovb.a();
    }
    pmk.a().b(this.jdField_a_of_type_Pmn);
    pmk.a().b(this.jdField_a_of_type_Roq);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
    ((KandianMergeManager)pha.a().getManager(162)).b(this.jdField_a_of_type_Plz);
  }
  
  public void l()
  {
    this.jdField_h_of_type_Boolean = true;
    ((ptz)a(2)).k();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, 0, 0, 0);
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.e();
  }
  
  public void n()
  {
    seu localseu = this.jdField_a_of_type_Ogd.a();
    if ((localseu != null) && (localseu.a() != null)) {
      localseu.b(11);
    }
  }
  
  public void o()
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Q();
      pha.b(3);
      a(true, 3, false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EventCollector.getInstance().onViewClicked(paramView);
    int n;
    if ((paramAdapterView instanceof ReadInJoyXListView))
    {
      n = ((ReadInJoyXListView)paramAdapterView).getHeaderViewsCount();
      if (paramInt - n >= 0) {
        n = paramInt - n;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_Sng.getItem(n);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!pha.r(localArticleInfo)) {}
      }
      do
      {
        do
        {
          return;
          n = paramInt;
          break;
        } while (localArticleInfo.mFeedType == 20);
        QLog.d("ReadInJoyListViewGroup", 1, "onItemClick pos : " + paramInt + ", id : " + paramLong + ", data : " + localArticleInfo);
        a(paramAdapterView, localArticleInfo, paramView, paramInt, paramLong);
      } while (localArticleInfo == null);
      localArticleInfo.invalidateProteusTemplateBean();
      return;
      n = paramInt;
    }
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.notifyDataSetChanged();
    }
  }
  
  public void q()
  {
    if (pha.k() == 0) {}
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      S();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ReadInJoyListViewGroup.42(this));
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Tff);
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.g();
    }
  }
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_Sng.a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = pvq.a().a(this.jdField_a_of_type_Int, paramList, (List)localObject1, paramInt);
    if ((this.jdField_a_of_type_Int == 0) || (pil.b(pil.b()))) {
      this.jdField_a_of_type_Sng.a(true);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("setAdapterData: srcData size ");
      if (paramList != null) {}
      for (paramInt = paramList.size();; paramInt = 0)
      {
        QLog.d("ReadInJoyListViewGroup", 2, paramInt);
        if (paramList == null) {
          break;
        }
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseArticleInfo)((Iterator)localObject1).next();
          if (localObject2 != null) {
            QLog.d("ReadInJoyListViewGroup", 2, "setAdapterData: " + ((BaseArticleInfo)localObject2).mTitle + " type: " + ((BaseArticleInfo)localObject2).mFeedType);
          }
        }
      }
    }
    this.jdField_a_of_type_Sng.a(paramList);
    this.jdField_a_of_type_Sng.notifyDataSetChanged();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setNotifyEndRefresh(srt paramsrt)
  {
    this.jdField_a_of_type_Srt = paramsrt;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!rcx.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
        if (this.jdField_a_of_type_Int != 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
          return;
        }
      } while (paramInt == -1);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    tfd localtfd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localtfd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!rcx.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
    label94:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
        if (this.jdField_a_of_type_Int != 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
          return;
        }
        if (paramInt != 0) {
          break label94;
        }
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
      localtfd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      r();
      localtfd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    tfd localtfd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localtfd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.j();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(anni.a(2131711722));
    }
  }
  
  public void v()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    if (this.jdField_a_of_type_Sng != null) {
      this.jdField_a_of_type_Sng.p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */