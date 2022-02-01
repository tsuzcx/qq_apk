package com.tencent.biz.pubaccount.readinjoy.view;

import abfv;
import agej;
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
import anyu;
import anzj;
import aokg;
import aoof;
import awbu;
import awcc;
import bduy;
import bhnv;
import bhny;
import bhsi;
import blih;
import bljm;
import bljn;
import blrf;
import bnrf;
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
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
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
import nzj;
import nzq;
import ocd;
import odr;
import ohf;
import ohl;
import ohp;
import ohz;
import oir;
import oix;
import omw;
import ono;
import oof;
import org.json.JSONException;
import org.json.JSONObject;
import osp;
import oxw;
import oyc;
import oyj;
import oys;
import ozc;
import oze;
import ozo;
import ozs;
import pad;
import pah;
import pay;
import paz;
import pbd;
import pcj;
import pes;
import peu;
import pfa;
import pfd;
import pfg;
import pfh;
import pfs;
import pgh;
import pgj;
import pgk;
import pgo;
import pmd;
import pmh;
import pmj;
import pmk;
import pmm;
import pmq;
import pmr;
import pmz;
import pns;
import poc;
import pou;
import pox;
import ppe;
import pqd;
import qam;
import qfs;
import qja;
import qjh;
import qrc;
import qrn;
import qtq;
import quv;
import qvp;
import qwo;
import qwp;
import qws;
import qwt;
import qwv;
import qwy;
import qxa;
import qxb;
import qxt;
import qyk;
import qyl;
import qyn;
import qyp;
import qyr;
import qzb;
import qzd;
import rfm;
import rmn;
import rmp;
import rpt;
import rvy;
import rwc;
import rwr;
import rxb;
import rxg;
import sbf;
import sbg;
import sek;
import sel;
import sgc;
import sgd;
import sge;
import sgf;
import sgn;
import shl;
import sho;
import shp;
import shq;
import shr;
import shs;
import sht;
import shv;
import shw;
import shx;
import shy;
import shz;
import sia;
import sib;
import sic;
import sid;
import sie;
import sif;
import sig;
import sih;
import sii;
import sik;
import sil;
import sim;
import sin;
import sio;
import sip;
import siq;
import sir;
import sis;
import sit;
import siu;
import siv;
import siw;
import six;
import slh;
import slj;
import sll;
import std;
import stf;
import stp;
import svv;
import svx;
import tbz;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import tlx;
import tnt;
import tqa;
import tqi;
import tzq;
import uae;
import uaf;
import uas;
import ubd;
import ubg;
import ubl;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bljm, bljn, rxb, sgc, sgd, sge, sgf, sgn
{
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<pmk> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private anyu jdField_a_of_type_Anyu = new sio(this);
  protected aoof a;
  private blih jdField_a_of_type_Blih = new shl(this);
  private blrf jdField_a_of_type_Blrf = new sii(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new sit(this);
  private nzj jdField_a_of_type_Nzj;
  private oir jdField_a_of_type_Oir;
  private ono jdField_a_of_type_Ono;
  oof jdField_a_of_type_Oof;
  private pes jdField_a_of_type_Pes = new sim(this);
  private peu jdField_a_of_type_Peu = new sil(this);
  private pfh jdField_a_of_type_Pfh = new sir(this);
  private rfm jdField_a_of_type_Rfm = new sis(this);
  private rmn jdField_a_of_type_Rmn;
  private sek jdField_a_of_type_Sek;
  six jdField_a_of_type_Six;
  private sll jdField_a_of_type_Sll;
  private svx jdField_a_of_type_Svx;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChannelTopPositionView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new siu(this);
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  private List<stf> jdField_c_of_type_JavaUtilList = new ArrayList();
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
  
  public ReadInJoyListViewGroup(ohl paramohl, int paramInt1, int paramInt2, int paramInt3, oze paramoze)
  {
    this(paramohl, paramInt1, paramInt2, paramInt3, paramoze, 2131560278);
  }
  
  public ReadInJoyListViewGroup(ohl paramohl, int paramInt1, int paramInt2, int paramInt3, oze paramoze, int paramInt4)
  {
    super(paramohl, paramInt1, paramoze);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_f_of_type_Boolean = rpt.c();
    setId(2131376191);
    this.jdField_a_of_type_AndroidUtilSparseArray = pmq.a(this);
    b(paramInt1);
    if (paramInt1 != 41695) {
      C();
    }
    this.jdField_a_of_type_Oze.jdField_c_of_type_Long = bnrf.a((QQAppInterface)ozs.a());
    a(new shw(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(ohl paramohl, int paramInt1, int paramInt2, oze paramoze)
  {
    this(paramohl, paramInt1, paramInt2, -1, paramoze);
  }
  
  public ReadInJoyListViewGroup(ohl paramohl, int paramInt, oze paramoze)
  {
    this(paramohl, paramInt, -1, paramoze);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Rmn = rmn.a();
    this.jdField_a_of_type_Rmn.a(this.jdField_e_of_type_Long);
    if (this.jdField_a_of_type_Int == 56)
    {
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      odr.jdField_a_of_type_Int = odr.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Ohl.a() != null)
    {
      this.jdField_a_of_type_Sek.a(this.jdField_a_of_type_Ohl.a(), this.jdField_a_of_type_Rmn);
      return;
    }
    this.jdField_a_of_type_Sek.b();
  }
  
  private void B()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Sek.a();
    int n;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label214;
      }
      n = sel.c(localArticleInfo);
      if ((n != 6) && (n != 71)) {
        break label171;
      }
      this.jdField_e_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      oys.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
      c(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nzj = new nzj(a());
      this.jdField_a_of_type_Sek.a(this.jdField_a_of_type_Nzj);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.6(this));
      return;
      label171:
      if (n == 28)
      {
        n = bnrf.e(ozs.a());
        oys.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int, 0, n);
        c(n);
        continue;
        label214:
        this.jdField_a_of_type_Sek.i();
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
      if (!bnrf.j()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((stf)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jdField_c_of_type_JavaUtilList.add(new stp(getContext()));
      continue;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (bnrf.y(ozs.a()) != 2)
        {
          this.jdField_a_of_type_Oof = new oof(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_Oof.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_c_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(a()));
      }
      else if ((this.jdField_a_of_type_Int == 41523) && (bnrf.z(ozs.a()) != 1))
      {
        this.jdField_a_of_type_Oof = new oof(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Oof.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Oof.a());
      }
    }
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (omw.a().a())
      {
        a(false);
        QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.22(this), 500L);
      return;
    }
    omw.a().c();
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
      } while ((!ReadinjoyJumpActivity.c(a().getIntent())) || (bnrf.j()));
      localIntent = a().getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(a(), localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void H()
  {
    if (bnrf.a(b())) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_Int == 56) {
      pfa.a().a(56);
    }
  }
  
  private void I()
  {
    boolean bool = this.jdField_a_of_type_Ohl.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((b()) && (!bool) && ((!bnrf.h()) || ((this.jdField_a_of_type_Ohl.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      n();
      M();
    }
    if (((!bnrf.h()) || ((this.jdField_a_of_type_Ohl.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      odr.jdField_a_of_type_Int = odr.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      this.l = false;
      this.k = false;
      this.jdField_a_of_type_Ohl.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Ohl.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Ohl.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Ohl.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((bnrf.i()) && ((this.jdField_a_of_type_Ohl.a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        pfg localpfg = (pfg)ozs.a().getManager(163);
        localpfg.a().a(this.jdField_a_of_type_Int, localParcelable);
        localpfg.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
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
      Parcelable localParcelable = ((pfg)ozs.a().getManager(163)).a().a(this.jdField_a_of_type_Int);
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
      if (this.jdField_a_of_type_Ohl.a().getIntent().getIntExtra("channel_from", 0) != 1004) {
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
      long l1 = this.jdField_a_of_type_Ohl.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int n = this.jdField_a_of_type_Ohl.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Sek.a();
      if ((n == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label710;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = pfa.a().a(Integer.valueOf(56));
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
          localObject2 = pfa.a().b(Integer.valueOf(56));
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
            pfa.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
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
          pfa.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Sek.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Sek);
          if (this.jdField_a_of_type_Oof == null) {}
          for (n = 0;; n = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(n, 0);
            this.jdField_a_of_type_Sek.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, sel.jdField_b_of_type_Int);
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
    int i1 = this.jdField_a_of_type_Sek.getCount();
    if (i1 > 0)
    {
      int n = 0;
      while (n < i1)
      {
        Object localObject = this.jdField_a_of_type_Sek.getItem(n);
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
    Object localObject = this.jdField_a_of_type_Sek.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = tzq.b((QQAppInterface)ozs.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = tzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        tzq.a(((BaseActivity)this.jdField_a_of_type_Ohl.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131373721);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    R();
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_Int == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131376225));
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(0);
      }
    }
  }
  
  private void S()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)ozs.a().getManager(162)).a();
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
      if (this.jdField_a_of_type_Sll != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Sll.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Sll = null;
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
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373725));
    if (pbd.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131373724));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131373723));
  }
  
  private void V()
  {
    if ((qja.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.i))
    {
      a(true, 0, false);
      this.i = true;
      return;
    }
    qja.a().a();
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
      localReadinjoyTabFrame = ozs.a(getContext());
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
      if (!pbd.c(this.jdField_a_of_type_Int)) {
        break;
      }
      if (oyc.b() != 0) {}
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
    if (pbd.c(this.jdField_a_of_type_Int)) {
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
    qwp localqwp = (qwp)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localqwp.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localqwp.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localqwp.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localqwp.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localqwp.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localqwp.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localqwp.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localqwp.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localqwp.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  private String a(Map<Long, ubl> paramMap, String paramString1, qvp paramqvp, String paramString2)
  {
    for (;;)
    {
      boolean bool;
      int n;
      try
      {
        localJSONObject = new JSONObject(paramString2);
        localJSONObject.put("folder_status", paramString1);
        localJSONObject.put("is_change", pay.a(ozs.a(), this.jdField_a_of_type_Int));
        if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
          return localJSONObject.toString();
        }
        bool = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
        if ((TextUtils.isEmpty(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) || (!paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text"))) {
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
      paramMap = (ubl)paramMap.get(Long.valueOf(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((paramMap != null) && (paramMap.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
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
  
  private String a(qvp paramqvp, String paramString)
  {
    int n = sel.c((ArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    if ((n == 6) || (n == 66) || (n == 115) || (n == 28) || (n == 11) || (n == 26) || (n == 19)) {
      paramqvp = odr.a(odr.a((ArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramString);
    }
    for (;;)
    {
      paramString = paramqvp;
      if (n == 6)
      {
        paramqvp = new sbg(paramqvp);
        paramqvp.Z(rpt.f());
        paramString = paramqvp.a().a();
      }
      return paramString;
      if ((n == 46) || (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
      {
        paramString = new sbg(paramString);
        paramString.e(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
        paramString.V(ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
        paramString.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        if (n == 46) {
          paramString.w(0);
        }
        for (;;)
        {
          paramString.e(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          paramqvp = paramString.a().a();
          break;
          paramString.w(1);
        }
      }
      if (n == 118)
      {
        paramString = new sbg(paramString);
        if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
        {
          paramString.X(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
          if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
            paramString.p(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramqvp = paramString.a().a();
      }
      else if (n == 128)
      {
        paramString = new sbg(paramString);
        if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
        {
          paramString.X(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
          if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
            paramString.p(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
          }
        }
        paramString.i(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
        paramqvp = paramString.a().a();
      }
      else
      {
        paramqvp = paramString;
      }
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i3 = 0;
    AladdinConfig localAladdinConfig;
    int i2;
    int i1;
    if ((!bduy.a()) && (!paramArticleInfo.hasSearchWordInfo()) && ((sel.c(paramArticleInfo) == 3) || (sel.c(paramArticleInfo) == 1)) && (paramArticleInfo.mIsShowSearchord == 1))
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
      if (!DateUtils.isToday(bhsi.b("search_word_prefix_last_request_time")))
      {
        bhsi.a("search_word_prefix_last_request_time", System.currentTimeMillis());
        bhsi.a("search_word_prefix_show_times", 0L);
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramArticleInfo.mRefreshTime)) {
        i3 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramArticleInfo.mRefreshTime)).intValue();
      }
      if ((i3 < n) && (bhsi.b("search_word_prefix_show_times") < i1) && (i2 == 1)) {
        ((aokg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID), new sig(this, paramArticleInfo, i3, paramInt));
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
    localIntent.putExtra("channel_name", anzj.a(2131711948));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!sel.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = sel.c(paramArticleInfo);
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
      odr.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, odr.b());
      rxg.a().a(false, "jumpFromKandianFeed", 1);
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
      if (this.jdField_a_of_type_Ono != null) {
        this.jdField_a_of_type_Ono.a();
      }
      this.jdField_a_of_type_Ono = new ono();
      this.jdField_a_of_type_Ono.a(new siq(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Ono, 7, true, localArticleInfo, 1, n);
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
      if (bnrf.h()) {
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
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
    }
    for (;;)
    {
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if (this.jdField_a_of_type_Sek != null) {}
      try
      {
        if (!TextUtils.isEmpty(tbz.b(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
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
          this.jdField_a_of_type_Sek.notifyDataSetChanged();
          return;
        }
      }
      catch (Exception paramView)
      {
        this.jdField_a_of_type_Sek.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView, ArticleInfo paramArticleInfo)
  {
    if (sel.c(paramArticleInfo))
    {
      c(paramArticleInfo, paramView);
      return;
    }
    ozs.a(getContext(), paramArticleInfo, 1, false, 4, false);
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131364931);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131166458));
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
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131166458));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Sek.a(this.jdField_a_of_type_Sek.a(), paramArticleInfo.mArticleID)) {}
      ozs.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", ozs.f(0));
        ozs.a(getContext(), str, localBundle);
        oxw.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Sek);
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
    if (ozs.s(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    rwc localrwc = new rwc();
    localrwc.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localrwc.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localrwc.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localrwc.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localrwc.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localrwc.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localrwc.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    qwv localqwv = new qwv();
    localqwv.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localqwv.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!sel.g(paramArticleInfo)) && (!sel.i(paramArticleInfo)) && (!sel.j(paramArticleInfo)) && (!sel.k(paramArticleInfo))) || ((!sel.q(paramArticleInfo)) || ((ozs.l(paramArticleInfo)) && (!sel.q(paramArticleInfo)))))
    {
      localrwc.jdField_f_of_type_Int = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_f_of_type_Int;
      localrwc.jdField_c_of_type_Int = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_a_of_type_Int;
      localrwc.jdField_d_of_type_Int = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_b_of_type_Int;
      localqwv.jdField_a_of_type_Int = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_f_of_type_Int;
      localrwc.jdField_b_of_type_Int = ((int)(((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_a_of_type_Long / 1000L));
      localrwc.jdField_b_of_type_JavaLangString = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_d_of_type_JavaLangString;
      localrwc.jdField_j_of_type_JavaLangString = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_g_of_type_JavaLangString;
      localrwc.jdField_c_of_type_JavaLangString = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((ozs.i(paramArticleInfo)) && (ozs.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localrwc.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localqwv.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localrwc.a = localqwv;
        localrwc.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localrwc.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localrwc.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localrwc.jdField_h_of_type_Int = localObject[0];
          localrwc.jdField_i_of_type_Int = localObject[1];
          localrwc.jdField_j_of_type_Int = paramView.getWidth();
          localrwc.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = ozc.a(3, this.jdField_a_of_type_Int);
            int n = localrwc.jdField_h_of_type_Int;
            localrwc.jdField_h_of_type_Int = ((localrwc.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
            localrwc.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          rpt.a(localrwc, paramView);
        }
        localObject = new qxb();
        ((qxb)localObject).jdField_a_of_type_Int = 409409;
        if (this.jdField_a_of_type_Int != 56) {
          break label831;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        odr.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, (qxb)localObject);
      }
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      return;
      localrwc.jdField_b_of_type_JavaLangString = ((qyn)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.b.get(0)).jdField_d_of_type_JavaLangString;
      break label403;
      if ((ozs.i(paramArticleInfo)) && (ozs.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localrwc.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localrwc.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localrwc.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localrwc.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localrwc.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localqwv.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localrwc.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localrwc.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localrwc.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localrwc.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localrwc.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label831:
      this.jdField_a_of_type_Sek.a(localrwc, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (rpt.b(a(), paramArticleInfo)))
    {
      a(paramArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) || (ozs.i(paramArticleInfo)) || (ozs.m(paramArticleInfo)) || (ozs.n(paramArticleInfo)))
    {
      if (ozs.n(paramArticleInfo)) {
        a(paramArticleInfo, (qwp)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView);
      }
      for (;;)
      {
        pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Sek.notifyDataSetChanged();
        }
        if (!ozs.l(paramArticleInfo)) {
          break;
        }
        paramView = ubg.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, ubg.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        ocd.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        ozs.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Sek, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        a(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new qxb();
        paramView.jdField_a_of_type_Int = paramInt1;
        odr.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((sel.c(paramArticleInfo) == 6) || (sel.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      oix.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (bnrf.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Sek, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
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
  
  private void a(ArticleInfo paramArticleInfo, qwp paramqwp, View paramView)
  {
    rwc localrwc = new rwc();
    if (paramqwp.jdField_a_of_type_Qws == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localrwc.jdField_c_of_type_Long = paramqwp.jdField_a_of_type_Long;
      localrwc.jdField_h_of_type_JavaLangString = (paramqwp.jdField_a_of_type_Qws.jdField_b_of_type_Long + "");
      localrwc.jdField_i_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_d_of_type_JavaLangString;
      localrwc.jdField_k_of_type_JavaLangString = paramqwp.jdField_e_of_type_JavaLangString;
      localrwc.jdField_g_of_type_Int = paramqwp.jdField_a_of_type_Int;
      localrwc.jdField_g_of_type_Long = paramqwp.jdField_b_of_type_Long;
      Object localObject = new qwv();
      ((qwv)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramqwp.jdField_a_of_type_Long);
      ((qwv)localObject).jdField_a_of_type_JavaLangString = paramqwp.jdField_g_of_type_JavaLangString;
      ((qwv)localObject).jdField_a_of_type_Int = paramqwp.jdField_a_of_type_Qws.jdField_a_of_type_Int;
      ((qwv)localObject).jdField_b_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_a_of_type_JavaLangString;
      localrwc.a = ((qwv)localObject);
      localrwc.jdField_b_of_type_JavaLangString = paramqwp.jdField_c_of_type_JavaLangString;
      localrwc.jdField_c_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_a_of_type_JavaLangString;
      localrwc.jdField_f_of_type_Int = paramqwp.jdField_a_of_type_Qws.jdField_a_of_type_Int;
      localrwc.jdField_c_of_type_Int = paramqwp.jdField_a_of_type_Qws.jdField_b_of_type_Int;
      localrwc.jdField_d_of_type_Int = paramqwp.jdField_a_of_type_Qws.jdField_c_of_type_Int;
      localrwc.jdField_b_of_type_Int = paramqwp.jdField_a_of_type_Qws.jdField_d_of_type_Int;
      localrwc.jdField_e_of_type_Long = paramqwp.jdField_a_of_type_Qws.jdField_a_of_type_Long;
      localrwc.jdField_j_of_type_JavaLangString = paramqwp.jdField_g_of_type_JavaLangString;
      localrwc.jdField_g_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_b_of_type_JavaLangString;
      localrwc.jdField_d_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_f_of_type_JavaLangString;
      localrwc.jdField_e_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_e_of_type_JavaLangString;
      localrwc.jdField_f_of_type_JavaLangString = paramqwp.jdField_a_of_type_Qws.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localrwc.jdField_h_of_type_Int = localObject[0];
        localrwc.jdField_i_of_type_Int = localObject[1];
        localrwc.jdField_j_of_type_Int = paramView.getWidth();
        localrwc.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = ozc.a(3, this.jdField_a_of_type_Int);
          int n = localrwc.jdField_h_of_type_Int;
          localrwc.jdField_h_of_type_Int = ((localrwc.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
          localrwc.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new qxb();
      ((qxb)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_Sek.a(localrwc, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        odr.a(paramqwp.jdField_a_of_type_Long, paramqwp.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Int, (int)paramqwp.jdField_b_of_type_Long, paramqwp.jdField_a_of_type_Int, 24, -1L, (qxb)localObject, -1, paramqwp.jdField_k_of_type_JavaLangString);
      }
      pfa.a().a(paramqwp.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Sek.notifyDataSetChanged();
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (pbd.c(this.jdField_a_of_type_Int))
    {
      paramBaseArticleInfo.mJumpType = 1;
      bnrf.a(paramBaseArticleInfo);
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
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      paramBaseArticleInfo.clickJumpTarget = qam.a(oyj.a(paramArticleInfo), "-1");
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      return;
    }
    if (b(paramArticleInfo, paramView))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
      paramBaseArticleInfo.clickJumpTarget = qam.a(ozo.a().a(), "-1");
      return;
    }
    if ((!quv.c(paramArticleInfo)) && (!ozo.a().a()) && (ozs.a(paramView.getContext(), paramArticleInfo)))
    {
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      String str = ozs.i(paramArticleInfo.getInnerUniqueID());
      paramBaseArticleInfo.clickJumpTarget = qam.a(str, "-1");
      ozs.a(paramView.getContext(), paramArticleInfo, str);
      return;
    }
    if (pmj.a(paramView.getContext(), paramArticleInfo.mArticleContentUrl))
    {
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      return;
    }
    paramBaseArticleInfo.clickJumpTarget = qam.a("", "3");
    g(paramArticleInfo);
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Sll == null)
    {
      if (ozs.k() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Sll = new slj(a(), LayoutInflater.from(getContext()).inflate(2131560276, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Sll.a(new sin(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Sll.a());
      this.jdField_a_of_type_Sll.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Sll.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (ozs.k() == 2) {
        this.jdField_a_of_type_Sll = new slh(a());
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131373721).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371727)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376152));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131376151));
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
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = agej.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = agej.a(10.0F, getResources()))
    {
      R();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839285));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166873));
    }
  }
  
  private void a(qvp paramqvp)
  {
    if (ozs.k(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
      ocd.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
    }
  }
  
  /* Error */
  private void a(qvp paramqvp, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 1093	sbg
    //   3: dup
    //   4: aload 5
    //   6: invokespecial 1094	sbg:<init>	(Ljava/lang/String;)V
    //   9: astore 9
    //   11: aload 9
    //   13: aload_1
    //   14: getfield 1939	qvp:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   17: invokestatic 1941	ozs:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   20: invokestatic 701	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   23: invokevirtual 1944	sbg:a	(Ljava/lang/Boolean;)Lsbg;
    //   26: aload_1
    //   27: getfield 1939	qvp:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   30: getfield 1123	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   33: invokevirtual 1125	sbg:a	(Ljava/lang/String;)Lsbg;
    //   36: aload_1
    //   37: getfield 1939	qvp:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   40: invokevirtual 1946	sbg:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsbg;
    //   43: pop
    //   44: aload_0
    //   45: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   48: ldc_w 1947
    //   51: if_icmpne +196 -> 247
    //   54: aload 9
    //   56: aload_1
    //   57: getfield 1948	qvp:jdField_j_of_type_Int	I
    //   60: invokevirtual 1950	sbg:b	(I)Lsbg;
    //   63: pop
    //   64: aconst_null
    //   65: ldc_w 1700
    //   68: ldc_w 1702
    //   71: aload_1
    //   72: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   75: ldc_w 1953
    //   78: ldc_w 1953
    //   81: iconst_0
    //   82: iconst_0
    //   83: aload_1
    //   84: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   87: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   90: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   93: aload_1
    //   94: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   97: invokevirtual 940	java/lang/Long:longValue	()J
    //   100: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   103: aload_1
    //   104: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   107: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   110: aload 9
    //   112: invokevirtual 1102	sbg:a	()Lsbf;
    //   115: invokevirtual 1106	sbf:a	()Ljava/lang/String;
    //   118: iconst_0
    //   119: invokestatic 1723	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   122: ldc_w 1953
    //   125: aload_1
    //   126: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   129: aload_1
    //   130: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   133: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   136: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   139: aload_1
    //   140: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   143: invokevirtual 940	java/lang/Long:longValue	()J
    //   146: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   149: aload_1
    //   150: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   153: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   156: aload_1
    //   157: getfield 1957	qvp:jdField_a_of_type_Long	J
    //   160: aload_1
    //   161: getfield 1958	qvp:jdField_c_of_type_Int	I
    //   164: aload_0
    //   165: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   168: aload_1
    //   169: getfield 1959	qvp:jdField_d_of_type_Int	I
    //   172: aload_1
    //   173: getfield 1960	qvp:jdField_e_of_type_Int	I
    //   176: aload_0
    //   177: invokevirtual 425	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   180: invokestatic 1965	bhnv:h	(Landroid/content/Context;)Z
    //   183: aload_1
    //   184: getfield 1966	qvp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: aload_1
    //   188: getfield 1967	qvp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   191: aload_1
    //   192: getfield 1968	qvp:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   195: aload_1
    //   196: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   199: invokestatic 1970	ozs:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   202: aload_1
    //   203: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   206: checkcast 656	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   209: lload_2
    //   210: iload 4
    //   212: aload_1
    //   213: getfield 1971	qvp:jdField_f_of_type_Int	I
    //   216: aload_1
    //   217: getfield 1972	qvp:jdField_g_of_type_Int	I
    //   220: aload_1
    //   221: getfield 1973	qvp:jdField_h_of_type_Int	I
    //   224: aload_1
    //   225: getfield 1974	qvp:jdField_f_of_type_Boolean	Z
    //   228: aload_1
    //   229: getfield 1948	qvp:jdField_j_of_type_Int	I
    //   232: aload_1
    //   233: getfield 1975	qvp:jdField_i_of_type_Int	I
    //   236: aload_1
    //   237: getfield 1977	qvp:m	I
    //   240: invokestatic 1980	ozs:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   243: invokestatic 1983	ocd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
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
    //   263: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ohl	Lohl;
    //   266: ifnull +29 -> 295
    //   269: iload 8
    //   271: istore 7
    //   273: aload_0
    //   274: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ohl	Lohl;
    //   277: instanceof 1985
    //   280: ifeq +15 -> 295
    //   283: aload_0
    //   284: getfield 298	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ohl	Lohl;
    //   287: checkcast 1985	ohm
    //   290: invokevirtual 1986	ohm:a	()I
    //   293: istore 7
    //   295: aload 9
    //   297: iload 7
    //   299: invokevirtual 1988	sbg:N	(I)Lsbg;
    //   302: pop
    //   303: aload 9
    //   305: aload_1
    //   306: getfield 1939	qvp:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   309: invokevirtual 1990	sbg:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lsbg;
    //   312: pop
    //   313: aload_1
    //   314: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   317: ifnull +111 -> 428
    //   320: aload_1
    //   321: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   324: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   327: ifnull +101 -> 428
    //   330: aload_1
    //   331: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   334: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   337: aconst_null
    //   338: invokevirtual 2000	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   341: astore 10
    //   343: aload 10
    //   345: ifnull +83 -> 428
    //   348: aload 10
    //   350: invokeinterface 2004 1 0
    //   355: ifnull +73 -> 428
    //   358: aload 10
    //   360: invokeinterface 2004 1 0
    //   365: invokeinterface 2007 1 0
    //   370: astore 10
    //   372: aload 10
    //   374: ifnull +54 -> 428
    //   377: aload 10
    //   379: invokeinterface 410 1 0
    //   384: ifeq +44 -> 428
    //   387: aload 10
    //   389: invokeinterface 414 1 0
    //   394: checkcast 2009	java/util/Map$Entry
    //   397: astore 11
    //   399: aload 9
    //   401: aload 11
    //   403: invokeinterface 2012 1 0
    //   408: checkcast 804	java/lang/String
    //   411: aload 11
    //   413: invokeinterface 2015 1 0
    //   418: invokevirtual 2016	java/lang/Object:toString	()Ljava/lang/String;
    //   421: invokevirtual 2019	sbg:a	(Ljava/lang/String;Ljava/lang/Object;)Lsbg;
    //   424: pop
    //   425: goto -53 -> 372
    //   428: aload 9
    //   430: aload_1
    //   431: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   434: invokestatic 2024	qia:a	(Lsbg;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   437: aload 6
    //   439: aload_1
    //   440: aload 9
    //   442: invokestatic 2027	ozs:a	(Ljava/lang/String;Lqvp;Lsbg;)V
    //   445: aload_0
    //   446: aload 9
    //   448: invokespecial 2030	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lsbg;)V
    //   451: aconst_null
    //   452: ldc_w 1700
    //   455: ldc_w 1702
    //   458: aload_1
    //   459: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   462: aload 6
    //   464: aload 6
    //   466: iconst_0
    //   467: iconst_0
    //   468: aload_1
    //   469: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   472: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   475: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   478: aload_1
    //   479: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   482: invokevirtual 940	java/lang/Long:longValue	()J
    //   485: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   488: aload_1
    //   489: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   492: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   495: aload 9
    //   497: invokevirtual 1102	sbg:a	()Lsbf;
    //   500: invokevirtual 1106	sbf:a	()Ljava/lang/String;
    //   503: iconst_0
    //   504: invokestatic 1723	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   507: aload_1
    //   508: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   511: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   514: invokestatic 2035	tyd:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
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
    //   558: checkcast 804	java/lang/String
    //   561: astore 10
    //   563: new 1031	org/json/JSONObject
    //   566: dup
    //   567: aload 5
    //   569: invokespecial 1033	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   572: astore 9
    //   574: aload_1
    //   575: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   578: getfield 1994	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   581: aload 10
    //   583: invokevirtual 2000	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   586: astore 10
    //   588: aload 10
    //   590: ifnull +385 -> 975
    //   593: aload 9
    //   595: aload 10
    //   597: invokestatic 2038	tyd:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   600: aload 9
    //   602: invokevirtual 1055	org/json/JSONObject:toString	()Ljava/lang/String;
    //   605: astore 9
    //   607: aload 9
    //   609: astore 5
    //   611: aconst_null
    //   612: ldc_w 1700
    //   615: ldc_w 1702
    //   618: aload_1
    //   619: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   622: aload 6
    //   624: aload 6
    //   626: iconst_0
    //   627: iconst_0
    //   628: aload_1
    //   629: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   632: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   635: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   638: aload_1
    //   639: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   642: invokevirtual 940	java/lang/Long:longValue	()J
    //   645: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   648: aload_1
    //   649: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   652: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   655: aload 5
    //   657: iconst_0
    //   658: invokestatic 1723	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   661: goto -124 -> 537
    //   664: astore 10
    //   666: aload 5
    //   668: astore 9
    //   670: aload 10
    //   672: astore 5
    //   674: ldc_w 469
    //   677: iconst_1
    //   678: ldc_w 2040
    //   681: aload 5
    //   683: invokestatic 2043	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload 9
    //   688: astore 5
    //   690: goto -153 -> 537
    //   693: aload 6
    //   695: aload_1
    //   696: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   699: aload_1
    //   700: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   703: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   706: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   709: aload_1
    //   710: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   713: invokevirtual 940	java/lang/Long:longValue	()J
    //   716: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   719: aload_1
    //   720: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   723: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   726: aload_1
    //   727: getfield 1957	qvp:jdField_a_of_type_Long	J
    //   730: aload_1
    //   731: getfield 1958	qvp:jdField_c_of_type_Int	I
    //   734: aload_0
    //   735: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   738: aload_1
    //   739: getfield 1959	qvp:jdField_d_of_type_Int	I
    //   742: aload_1
    //   743: getfield 1960	qvp:jdField_e_of_type_Int	I
    //   746: aload_0
    //   747: invokevirtual 425	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   750: invokestatic 1965	bhnv:h	(Landroid/content/Context;)Z
    //   753: aload_1
    //   754: getfield 1966	qvp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   757: aload_1
    //   758: getfield 1967	qvp:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   761: aload_1
    //   762: getfield 1968	qvp:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   765: aload_1
    //   766: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   769: invokestatic 1970	ozs:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   772: aload_1
    //   773: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   776: checkcast 656	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   779: lload_2
    //   780: iload 4
    //   782: aload_1
    //   783: getfield 1971	qvp:jdField_f_of_type_Int	I
    //   786: aload_1
    //   787: getfield 1972	qvp:jdField_g_of_type_Int	I
    //   790: aload_1
    //   791: getfield 1973	qvp:jdField_h_of_type_Int	I
    //   794: aload_1
    //   795: getfield 1974	qvp:jdField_f_of_type_Boolean	Z
    //   798: aload_1
    //   799: getfield 1948	qvp:jdField_j_of_type_Int	I
    //   802: aload_1
    //   803: getfield 1975	qvp:jdField_i_of_type_Int	I
    //   806: aload_1
    //   807: getfield 1977	qvp:m	I
    //   810: invokestatic 1980	ozs:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   813: invokestatic 1983	ocd:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   816: sipush 250
    //   819: invokestatic 2045	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   822: ldc_w 2047
    //   825: iconst_0
    //   826: invokevirtual 1187	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   829: iconst_1
    //   830: if_icmpne -584 -> 246
    //   833: aload_0
    //   834: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   837: invokestatic 873	pbd:c	(I)Z
    //   840: ifne -594 -> 246
    //   843: new 2049	paa
    //   846: dup
    //   847: new 1031	org/json/JSONObject
    //   850: dup
    //   851: aload 9
    //   853: invokespecial 1033	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   856: invokespecial 2052	paa:<init>	(Lorg/json/JSONObject;)V
    //   859: astore 5
    //   861: invokestatic 2053	ubg:b	()I
    //   864: ifle +92 -> 956
    //   867: iconst_0
    //   868: istore 4
    //   870: aload 5
    //   872: ldc_w 2055
    //   875: iload 4
    //   877: invokevirtual 2058	paa:b	(Ljava/lang/String;I)Lpaa;
    //   880: pop
    //   881: aconst_null
    //   882: ldc_w 1700
    //   885: ldc_w 1702
    //   888: aload_1
    //   889: getfield 1951	qvp:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   892: ldc_w 2060
    //   895: ldc_w 2060
    //   898: iconst_0
    //   899: iconst_0
    //   900: aload_1
    //   901: getfield 1054	qvp:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   904: getfield 1954	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   907: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   910: aload_1
    //   911: getfield 1955	qvp:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   914: invokevirtual 940	java/lang/Long:longValue	()J
    //   917: invokestatic 1716	java/lang/Long:toString	(J)Ljava/lang/String;
    //   920: aload_1
    //   921: getfield 1956	qvp:jdField_b_of_type_Int	I
    //   924: invokestatic 1718	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   927: aload 5
    //   929: invokevirtual 2061	paa:a	()Ljava/lang/String;
    //   932: iconst_0
    //   933: invokestatic 1723	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   936: return
    //   937: astore_1
    //   938: invokestatic 627	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   941: ifeq -695 -> 246
    //   944: ldc_w 469
    //   947: iconst_2
    //   948: aload_1
    //   949: invokestatic 1084	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   952: invokestatic 476	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	978	1	paramqvp	qvp
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
  
  private void a(qvp paramqvp, String paramString1, String paramString2)
  {
    int n = 0;
    while (n < paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size())
    {
      ocd.a(null, paramqvp.jdField_d_of_type_JavaLangString, paramString2, paramString2, 0, 0, Long.toString(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((qzd)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(n)).jdField_a_of_type_Int + "", Integer.toString(paramqvp.jdField_b_of_type_Int), paramString1, false);
      n += 1;
    }
  }
  
  private void a(sbg paramsbg)
  {
    if ((paramsbg != null) && ((this.jdField_a_of_type_Ohl instanceof ohz))) {
      if (!this.jdField_b_of_type_Boolean) {
        break label36;
      }
    }
    label36:
    for (int n = 1;; n = 0)
    {
      paramsbg.a("from_aio", Integer.valueOf(n));
      return;
    }
  }
  
  private void a(siw paramsiw)
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
          paramsiw.jdField_a_of_type_JavaUtilList = new ArrayList();
          paramsiw.jdField_a_of_type_JavaUtilList.add(localLong);
          localIntent.putExtra("channel_map_data", localSerializableMap);
        }
        paramsiw.jdField_b_of_type_Int = 9;
        paramsiw.jdField_a_of_type_JavaLangString = ((String)localSerializableMap.getMap().get("pushContext"));
      }
    }
  }
  
  private void a(siw paramsiw, KandianMergeManager paramKandianMergeManager)
  {
    paramsiw.jdField_a_of_type_Int |= 0x2;
    KandianRedDotInfo localKandianRedDotInfo = paramKandianMergeManager.c();
    if (localKandianRedDotInfo != null)
    {
      if (!localKandianRedDotInfo.hasArticleID()) {
        break label79;
      }
      paramsiw.jdField_a_of_type_JavaUtilList = localKandianRedDotInfo.articleIDList;
      paramsiw.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      paramsiw.jdField_a_of_type_Long = localKandianRedDotInfo.algorithmID;
      paramsiw.jdField_b_of_type_Long = localKandianRedDotInfo.strategyID;
      paramsiw.jdField_b_of_type_Int = 1;
    }
    label79:
    for (paramsiw.jdField_a_of_type_Int |= 0x8;; paramsiw.jdField_a_of_type_Int |= 0x4)
    {
      paramKandianMergeManager.n();
      return;
    }
  }
  
  private void a(siw paramsiw, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (pgj)paramQQAppInterface.getManager(274);
    if ((paramQQAppInterface.a() != null) && (paramQQAppInterface.a().size() > 0))
    {
      paramsiw.jdField_a_of_type_JavaUtilList = new ArrayList(paramQQAppInterface.a());
      paramsiw.jdField_b_of_type_Int = 8;
      if (!TextUtils.isEmpty(paramQQAppInterface.a())) {
        paramsiw.jdField_a_of_type_JavaLangString = paramQQAppInterface.a();
      }
    }
    paramQQAppInterface.a(a());
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (pbd.c(this.jdField_a_of_type_Int)) {}
    for (int n = 2;; n = 1)
    {
      uas.a(localContext, n, new ReadInJoyListViewGroup.38(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 70) && (paramInt != 56) && (paramInt != 40677) && (!pbd.c(paramInt));
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = oyj.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (quv.a(str)) {
        ozs.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        rpt.a(BaseApplicationImpl.getApplication(), str);
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
    if (sel.c(paramArticleInfo) == 6)
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
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
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
        paramBaseArticleInfo.clickJumpTarget = qam.a("", "3");
        g(paramArticleInfo);
      }
      else
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
      }
    }
  }
  
  private boolean a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pah<Integer> parampah, ArticleInfo paramArticleInfo)
  {
    if (sel.a(paramArticleInfo))
    {
      ozs.c(a(), paramArticleInfo, 6);
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, a());
    }
    for (;;)
    {
      return false;
      if (ozs.l(paramArticleInfo))
      {
        a(paramArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        parampah.a(Integer.valueOf(4));
      }
      else if (paramArticleInfo.mFeedType == 3)
      {
        e(paramArticleInfo);
      }
      else if (paramArticleInfo.mFeedType == 13)
      {
        d(paramArticleInfo);
      }
      else if ((paramArticleInfo.mFeedType == 22) || (paramArticleInfo.mFeedType == 21) || (ozs.n(paramArticleInfo)))
      {
        ozs.a(getContext(), paramArticleInfo, 4, false, 3, false);
      }
      else if (sel.b(paramArticleInfo))
      {
        b(paramBaseArticleInfo, paramView, paramArticleInfo);
      }
      else if ((sel.a(paramArticleInfo)) && (sel.c(paramArticleInfo)))
      {
        c(paramArticleInfo, paramView);
      }
      else if (sel.a(paramArticleInfo))
      {
        ozs.a(getContext(), paramArticleInfo, 1, false, 4, false);
      }
      else if (sel.c(paramArticleInfo) == 71)
      {
        b(paramView, paramInt, paramArticleInfo);
        parampah.a(Integer.valueOf(4));
      }
      else if ((sel.g(paramArticleInfo)) || (sel.j(paramArticleInfo)))
      {
        ozs.a(getContext(), paramArticleInfo, 4, false, 3, false);
        sel.a(paramArticleInfo, this.jdField_a_of_type_Sek.a());
      }
      else if ((ozs.b(paramArticleInfo)) || (ozs.c(paramArticleInfo)))
      {
        ozs.a(getContext(), paramArticleInfo, 1, false, 4, false);
        sel.a(paramArticleInfo, this.jdField_a_of_type_Sek.a());
        ozs.a(paramArticleInfo, this.jdField_a_of_type_Sek.a());
      }
      else
      {
        if (!ozs.a(paramArticleInfo)) {
          break;
        }
        b(paramArticleInfo, 1);
        oxw.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Sek);
        parampah.a(Integer.valueOf(2));
      }
    }
    return b(paramBaseArticleInfo, paramView, paramInt, parampah, paramArticleInfo);
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_Sek.b())) {
      return false;
    }
    long l1 = System.currentTimeMillis();
    boolean bool;
    int n;
    if (this.jdField_a_of_type_Sek.getCount() == 0)
    {
      bool = true;
      paramBoolean = a(paramBoolean, bool, ohp.a(this.jdField_a_of_type_Int));
      QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
      if ((!paramBoolean) && (!pmh.a(this.jdField_a_of_type_Int))) {
        break label156;
      }
      n = 1;
      label95:
      if (n == 0) {
        break label170;
      }
      if ((this.jdField_a_of_type_Int == 0) || (pbd.c(this.jdField_a_of_type_Int))) {
        pfs.a().a.jdField_a_of_type_Boolean = true;
      }
      if ((!pbd.c(this.jdField_a_of_type_Int)) || (pbd.a())) {
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
    oze localoze = this.jdField_a_of_type_Oze;
    if (this.jdField_a_of_type_Oze.jdField_a_of_type_Long == 0L) {}
    for (;;)
    {
      localoze.jdField_a_of_type_Long = l1;
      return false;
      l1 = this.jdField_a_of_type_Oze.jdField_a_of_type_Long;
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
      l1 = ((Integer)bnrf.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
      if (pbd.a(this.jdField_a_of_type_Int)) {
        l1 = b();
      }
      if (System.currentTimeMillis() - this.jdField_a_of_type_Oze.jdField_d_of_type_Long <= l1) {
        break label446;
      }
      bool2 = true;
      bool6 = j();
      if ((!b()) || (this.l)) {
        break label452;
      }
      bool1 = true;
      if ((!bnrf.i()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L) || (!localKandianMergeManager.g())) {
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
      bool4 = ohp.c(this.jdField_a_of_type_Int);
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
  
  private String b(qvp paramqvp, String paramString)
  {
    paramString = ozs.a(paramString, this.jdField_a_of_type_Ohl.a().b(), odr.jdField_a_of_type_Int);
    if ((paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)) {
      paramString = new sbg(paramString).c(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
    }
    for (;;)
    {
      if (((sel.c((ArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
        rpt.a(ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
      }
      return paramString;
    }
  }
  
  private List<Long> b()
  {
    Intent localIntent = this.jdField_a_of_type_Ohl.a().getIntent();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378246));
    if (paramInt == 41695) {
      D();
    }
    if (pbd.c(this.jdField_a_of_type_Int)) {
      pad.a().a();
    }
    this.jdField_a_of_type_Aoof = new aoof(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Sek = new sek(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Aoof, this.jdField_a_of_type_AndroidUtilSparseArray);
    a(new sic(this, "onListViewGroupInit"));
    U();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Ohl + a());
    }
    y();
    x();
    A();
    z();
    Q();
    E();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Anyu);
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ozs.a().getManager(162);
    localKandianMergeManager.a(this.jdField_a_of_type_Pes);
    localKandianMergeManager.a(this.jdField_a_of_type_Peu);
    B();
    w();
    pfd.a().a(this.jdField_a_of_type_Pfh);
    pfd.a().a(this.jdField_a_of_type_Rfm);
  }
  
  private void b(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView instanceof qjh)) {
      ((qjh)paramView).b();
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
    if ((!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) && (this.jdField_a_of_type_Sek != null) && (!sel.a(paramArticleInfo))) {
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
    }
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      ozs.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((sel.d(paramArticleInfo)) && (sel.c(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    ozs.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (qwp)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, View paramView, ArticleInfo paramArticleInfo)
  {
    if (a(paramArticleInfo, paramView))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
      QLog.d("ReadInJoyListViewGroup", 1, "tryJumpToUgUrl: true");
      paramArticleInfo.clickJumpTarget = qam.a(oyj.a(paramArticleInfo), "-1");
    }
    for (;;)
    {
      paramBaseArticleInfo.clickArea = 7;
      ozs.b(getContext(), paramArticleInfo, (int)paramBaseArticleInfo.mChannelID);
      return;
      QLog.d("ReadInJoyListViewGroup", 1, "short content redirectToOtherPage");
      qam.a(getContext(), paramArticleInfo);
    }
  }
  
  private void b(List<Long> paramList)
  {
    if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
    {
      long l1 = NetConnInfoCenter.getServerTime();
      QQAppInterface localQQAppInterface = (QQAppInterface)ozs.a();
      if (localQQAppInterface != null)
      {
        paramList = ((pfg)localQQAppInterface.getManager(163)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
        if (paramList != null)
        {
          pgj localpgj = (pgj)localQQAppInterface.getManager(274);
          if (localpgj != null) {
            localpgj.a(tzq.a(localQQAppInterface, paramList), l1);
          }
        }
      }
    }
  }
  
  private void b(qvp paramqvp)
  {
    if ((paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo != null) && (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Oih != null)) {
      ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Oih, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
    }
  }
  
  private void b(qvp paramqvp, String paramString1, String paramString2)
  {
    Object localObject;
    if (!paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
    {
      localObject = sel.a();
      if (localObject == null) {
        break label440;
      }
    }
    label440:
    for (paramString1 = ((QQAppInterface)localObject).c();; paramString1 = "0")
    {
      String str = ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, 0, 0, bhnv.h(getContext()), paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      ocd.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str, false);
      paramString2 = ubg.a(this.jdField_a_of_type_Int);
      if (localObject != null) {
        paramString1 = ((QQAppInterface)localObject).c();
      }
      localObject = ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, ozs.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, bhnv.h(getContext()), paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, paramqvp.jdField_f_of_type_Int, (ArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
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
      ocd.a(null, "CliOper", "", paramString1, paramString2, paramString2, 0, 0, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", (String)localObject, false);
      while (!ozs.n(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
      {
        return;
        n = 0;
        break;
      }
      ocd.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", paramString1, false);
      return;
    }
  }
  
  private void b(siw paramsiw)
  {
    KandianRedDotInfo localKandianRedDotInfo = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
    if (localKandianRedDotInfo != null)
    {
      paramsiw.jdField_a_of_type_JavaLangString = localKandianRedDotInfo.cookie;
      a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
    }
  }
  
  private void b(siw paramsiw, KandianMergeManager paramKandianMergeManager)
  {
    int i2 = 1;
    if (this.jdField_a_of_type_Oze.jdField_a_of_type_Boolean)
    {
      paramsiw.jdField_a_of_type_JavaUtilList = b();
      paramsiw.jdField_a_of_type_Boolean = h();
      this.jdField_a_of_type_Oze.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
        break label338;
      }
    }
    label338:
    for (boolean bool = true;; bool = false)
    {
      paramsiw.jdField_b_of_type_Boolean = bool;
      paramsiw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = ((LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo"));
      if (paramsiw.jdField_a_of_type_JavaUtilList != null) {
        break label386;
      }
      paramsiw.jdField_a_of_type_JavaUtilList = paramKandianMergeManager.a();
      if ((paramsiw.jdField_a_of_type_JavaUtilList != null) && (paramsiw.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        paramsiw.jdField_a_of_type_Long = ((Long)paramsiw.jdField_a_of_type_JavaUtilList.get(paramsiw.jdField_a_of_type_JavaUtilList.size() - 2)).longValue();
        paramsiw.jdField_b_of_type_Long = ((Long)paramsiw.jdField_a_of_type_JavaUtilList.get(paramsiw.jdField_a_of_type_JavaUtilList.size() - 1)).longValue();
        paramsiw.jdField_a_of_type_JavaUtilList = paramsiw.jdField_a_of_type_JavaUtilList.subList(0, paramsiw.jdField_a_of_type_JavaUtilList.size() - 2);
        paramsiw.jdField_b_of_type_Int = 1;
        paramsiw.jdField_a_of_type_JavaLangString = paramKandianMergeManager.a();
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
      paramsiw.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramsiw.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject).cookie;
      int i1 = localArrayList.size() - 1;
      for (;;)
      {
        n = i2;
        if (i1 < 0) {
          break;
        }
        localObject = (Long)localArrayList.get(i1);
        paramsiw.jdField_a_of_type_JavaUtilList.add(0, localObject);
        i1 -= 1;
      }
    }
    int n = 0;
    label346:
    paramKandianMergeManager.g();
    paramKandianMergeManager.f();
    for (;;)
    {
      paramsiw.jdField_a_of_type_AndroidUtilPair = paramKandianMergeManager.a();
      paramKandianMergeManager.l();
      if (n != 0)
      {
        paramsiw.jdField_a_of_type_Int |= 0x20;
        ozs.a(false);
      }
      return;
      label386:
      n = 0;
    }
  }
  
  private void b(siw paramsiw, QQAppInterface paramQQAppInterface)
  {
    long l1 = this.jdField_a_of_type_Ohl.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
    boolean bool = this.jdField_a_of_type_Ohl.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
    this.l = true;
    this.k = true;
    Object localObject;
    JSONObject localJSONObject;
    if (bool)
    {
      localObject = (ArticleInfo)this.jdField_a_of_type_Ohl.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
      if (localObject != null)
      {
        paramsiw.jdField_a_of_type_AndroidUtilPair = new Pair(((ArticleInfo)localObject).getInnerUniqueID(), ((ArticleInfo)localObject).mTitle);
        localJSONObject = new JSONObject();
      }
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("ArticleId", ozs.a(((ArticleInfo)localObject).mArticleID));
        localJSONObject.put("FeedsId", ozs.a(((ArticleInfo)localObject).mFeedId));
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
        paramsiw.jdField_a_of_type_JavaLangString = localJSONObject.toString();
        paramsiw.jdField_b_of_type_Int = 5;
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        paramsiw.jdField_a_of_type_JavaLangString = null;
        continue;
      }
      paramsiw.jdField_a_of_type_JavaUtilList = new ArrayList();
      paramsiw.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
    }
  }
  
  private void b(boolean paramBoolean)
  {
    int n = 2131298707;
    boolean bool2 = false;
    label406:
    for (;;)
    {
      try
      {
        boolean bool3 = bduy.a();
        if ((bool3 == this.m) && (!paramBoolean)) {
          return;
        }
        Activity localActivity = a();
        if (localActivity == null) {
          break;
        }
        this.m = bool3;
        if (pbd.c(this.jdField_a_of_type_Int))
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
          View localView1 = localActivity.findViewById(2131377980);
          View localView2 = findViewById(2131367044);
          if (bool1) {
            n = 2131298703;
          }
          n = getResources().getDimensionPixelOffset(n);
          if (!bool1) {
            break label376;
          }
          n = ImmersiveUtils.getStatusBarHeight(getContext()) + n;
          i1 = agej.a(50.0F, getResources());
          i2 = ImmersiveUtils.getStatusBarHeight(getContext());
          int i3 = getResources().getDimensionPixelOffset(2131298707);
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
      int i1 = agej.a(50.0F, getResources());
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
        str = getResources().getString(2131717159);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      N();
      if (!bnrf.h()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.29(this), 1500L);
      return;
      str = getResources().getString(2131717158);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717000), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131716999);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131717000), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131716998);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131717000), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131716999);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!paz.b()) {
      pfd.a().l();
    }
    this.jdField_a_of_type_Oze.jdField_a_of_type_Long = System.currentTimeMillis();
    bnrf.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Oze.jdField_a_of_type_Long, (QQAppInterface)ozs.a());
    siw localsiw = new siw(null);
    Object localObject2 = ((BaseActivity)a()).app;
    Object localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
    label118:
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == pox.a()))
    {
      b(localsiw, (KandianMergeManager)localObject1);
      if (this.jdField_a_of_type_Int != 40830) {
        break label454;
      }
      a(localsiw);
      if (this.jdField_a_of_type_Sek != null) {
        this.jdField_a_of_type_Sek.a(paramBoolean1);
      }
      localArrayList1 = new ArrayList();
      if (d())
      {
        localArrayList1.addAll(((KandianMergeManager)localObject1).b());
        localsiw.jdField_a_of_type_Int |= 0x80;
      }
      if (qja.a().a()) {
        localsiw.jdField_a_of_type_Int |= 0x1000;
      }
      localArrayList2 = new ArrayList();
      if (this.jdField_a_of_type_Int == 56)
      {
        localObject1 = new qfs();
        ((qfs)localObject1).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
        ((qfs)localObject1).jdField_a_of_type_Boolean = bhny.a(getContext(), ((qfs)localObject1).jdField_a_of_type_JavaLangString);
        localArrayList2.add(localObject1);
      }
      if (localsiw.jdField_a_of_type_AndroidUtilPair != null) {
        break label646;
      }
      localObject1 = null;
      label272:
      if (localsiw.jdField_a_of_type_AndroidUtilPair != null) {
        break label659;
      }
    }
    label646:
    label659:
    for (localObject2 = null;; localObject2 = (String)localsiw.jdField_a_of_type_AndroidUtilPair.second)
    {
      if (this.jdField_a_of_type_Int != 70) {
        break label675;
      }
      pfa.a().a(true, localsiw.jdField_a_of_type_JavaLangString);
      pns.a().a(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
      this.jdField_c_of_type_Int += 1;
      ubg.a(paramInt, this.jdField_a_of_type_Int, a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
      return;
      if ((b()) && (!this.l))
      {
        b(localsiw, (QQAppInterface)localObject2);
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        b(localsiw);
        break;
      }
      if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1001L))
      {
        a(localsiw, (KandianMergeManager)localObject1);
        break;
      }
      if (this.jdField_a_of_type_Int != 40677) {
        break;
      }
      a(localsiw, (QQAppInterface)localObject2);
      break;
      label454:
      if (pbd.c(this.jdField_a_of_type_Int))
      {
        localObject2 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
        if ((localObject2 == null) || (((KandianRedDotInfo)localObject2).shouldRemoveFloatingRedPntArticleId())) {
          break label118;
        }
        localsiw.jdField_a_of_type_Long = ((KandianRedDotInfo)localObject2).algorithmID;
        localsiw.jdField_b_of_type_Long = ((KandianRedDotInfo)localObject2).strategyID;
        localsiw.jdField_a_of_type_JavaUtilList = ((KandianRedDotInfo)localObject2).articleIDList;
        localsiw.jdField_b_of_type_Int = 1;
        localsiw.jdField_a_of_type_JavaLangString = ((KandianRedDotInfo)localObject2).cookie;
        a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
        break label118;
      }
      l1 = a();
      if (this.jdField_a_of_type_Sek == null) {
        break label118;
      }
      localObject2 = (ArticleInfo)this.jdField_a_of_type_Sek.b(0);
      if ((l1 == -1L) || (localObject2 == null) || (l1 == ((ArticleInfo)localObject2).mArticleID)) {
        break label118;
      }
      localsiw.jdField_a_of_type_JavaUtilList = new ArrayList();
      localsiw.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l1));
      localsiw.jdField_b_of_type_Int = 6;
      break label118;
      localObject1 = localsiw.jdField_a_of_type_AndroidUtilPair.first;
      break label272;
    }
    label675:
    if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7)) {
      localsiw.jdField_a_of_type_Int |= 0x800;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("FeedsRefreshType", this.jdField_b_of_type_Int);
    pfa localpfa = pfa.a();
    int n = this.jdField_a_of_type_Int;
    List localList = localsiw.jdField_a_of_type_JavaUtilList;
    int i1 = localsiw.jdField_b_of_type_Int;
    paramBoolean1 = localsiw.jdField_a_of_type_Boolean;
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
      localpfa.a(n, localList, i1, true, paramBoolean1, i2, str, l1, (String)localObject2, b(), localsiw.jdField_a_of_type_Long, localsiw.jdField_b_of_type_Long, localsiw.jdField_a_of_type_JavaLangString, paramInt, localsiw.jdField_b_of_type_Boolean, localsiw.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo, localsiw.jdField_a_of_type_Int, localArrayList1, localArrayList2, localBundle);
      break;
      str = null;
      break label780;
    }
  }
  
  private boolean b(int paramInt)
  {
    Object localObject = ((BaseActivity)a()).app;
    if ((paramInt == 70) || (pbd.c(paramInt))) {
      return a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    if (paramInt == 40677)
    {
      localObject = (pgj)((QQAppInterface)localObject).getManager(274);
      return (((pgj)localObject).a() != null) && (((pgj)localObject).a().size() > 0);
    }
    return paramInt == 40830;
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (quv.c(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = ozo.a().a(paramArticleInfo, null, null);
      str = ozo.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Sek.notifyDataSetChanged();
    ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
    ozs.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private boolean b(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, pah<Integer> parampah, ArticleInfo paramArticleInfo)
  {
    if ((sel.i(paramArticleInfo)) || (sel.k(paramArticleInfo)))
    {
      ozs.a(getContext(), paramArticleInfo, 0, false, 1, false);
      sel.a(paramArticleInfo, this.jdField_a_of_type_Sek.a());
    }
    for (;;)
    {
      return false;
      if (sel.h(paramArticleInfo))
      {
        a(paramView, paramArticleInfo);
      }
      else if (ozs.a(paramArticleInfo))
      {
        if (a(paramBaseArticleInfo, paramView, paramInt, paramArticleInfo)) {
          return true;
        }
        parampah.a(Integer.valueOf(4));
      }
      else if (ozs.d(paramArticleInfo))
      {
        a(paramView, paramInt, paramArticleInfo);
      }
      else if ((ozs.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) || (paramArticleInfo.isAccountShown))
      {
        a(paramBaseArticleInfo, paramView, paramArticleInfo);
        parampah.a(Integer.valueOf(2));
      }
      else if (paramArticleInfo.mFeedType == 26)
      {
        c(paramArticleInfo);
      }
      else if (paramArticleInfo.mFeedType == 23)
      {
        ozs.a(getContext(), paramArticleInfo, 1, false, 4, false);
      }
      else if (paramArticleInfo.mFeedType == 34)
      {
        ozs.a(getContext(), paramArticleInfo.mArticleContentUrl, null);
        sel.a(paramArticleInfo, this.jdField_a_of_type_Sek.a());
      }
      else if (paramArticleInfo.mFeedType == 39)
      {
        tqa.a(paramArticleInfo, getContext(), paramInt);
      }
      else
      {
        parampah.a(Integer.valueOf(2));
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
    if (bnrf.a((QQAppInterface)localObject1))
    {
      bool1 = ((KandianMergeManager)localObject2).b();
      bool4 = a() instanceof ReadInJoyNewFeedsActivity;
      if (!bool4) {
        break label365;
      }
      l1 = bnrf.h((AppRuntime)localObject1);
      if (System.currentTimeMillis() - this.jdField_a_of_type_Oze.jdField_c_of_type_Long <= l1) {
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
      bool6 = ohp.c(this.jdField_a_of_type_Int);
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
        ozs.b(i1);
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
      l1 = bnrf.g((AppRuntime)localObject1);
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
    localObjectAnimator1.addListener(new siv(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new sho(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp != null) && (!TextUtils.isEmpty(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.jdField_k_of_type_JavaLangString)))
    {
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
      ozs.c(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyp.jdField_k_of_type_JavaLangString);
      pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (ozs.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      g(paramArticleInfo);
    }
    for (;;)
    {
      ubg.a(paramArticleInfo);
      return;
      ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
    }
  }
  
  private void c(List<Long> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 70) || (pbd.c(this.jdField_a_of_type_Int))))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = pfa.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      paramList = (QQAppInterface)ozs.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (paramList != null))
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label142;
        }
        paramList = tzq.b(paramList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = tzq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        tzq.a(((BaseActivity)this.jdField_a_of_type_Ohl.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), paramList, false);
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
    } while (!pbd.c(this.jdField_a_of_type_Int));
    ((KandianDailyManager)paramList.getManager(296)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
  }
  
  private void c(qvp paramqvp)
  {
    if (ozs.j(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
    {
      Object localObject1 = (BaseArticleInfo)paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
      Object localObject3 = ubg.a(getContext(), ((BaseArticleInfo)localObject1).mArticleID, ((BaseArticleInfo)localObject1).mAlgorithmID, 54, this.jdField_a_of_type_Int, ((BaseArticleInfo)localObject1).getInnerUniqueID(), ((BaseArticleInfo)localObject1).getVideoVid(), ubg.a((BaseArticleInfo)localObject1), ((BaseArticleInfo)localObject1).videoReportInfo);
      localObject1 = localObject3;
      if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {}
      try
      {
        localObject1 = new JSONObject((String)localObject3);
        if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
        {
          ((JSONObject)localObject1).put("short_content_gif", 1);
          localObject1 = ((JSONObject)localObject1).toString();
          localObject3 = localObject1;
          if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          for (;;)
          {
            localObject3 = new JSONObject((String)localObject1);
            ((JSONObject)localObject3).put("account_expose_card", ozs.c(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
            localObject3 = ((JSONObject)localObject3).toString();
            ozs.c(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject3);
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
    Object localObject2 = ubg.a(getContext(), paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, paramqvp.jdField_k_of_type_Int, paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, ubg.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
    ocd.a(null, "CliOper", "", paramqvp.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), (String)localObject2, false);
    ocd.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new sbg(null, null, null, null).V(54).i(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).w(paramqvp.jdField_k_of_type_Int + 1).f(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a(), false);
  }
  
  private void d(int paramInt)
  {
    if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)getContext()).g(paramInt);
    }
    for (;;)
    {
      if (pbd.c(this.jdField_a_of_type_Int)) {
        oyc.a(paramInt);
      }
      P();
      return;
      if ((getContext() instanceof SplashActivity))
      {
        ReadinjoyTabFrame localReadinjoyTabFrame = ozs.a(getContext());
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
      setAdapterData(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = ozs.a();
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
        localObject2 = pfa.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localStringBuilder = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label307;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = ozs.d((String)localObject1);
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
      paramList = pfa.a().a();
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
    ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
  }
  
  private void d(List<Long> paramList)
  {
    Object localObject = ozs.a();
    if ((!bnrf.B((AppRuntime)localObject)) || (!bnrf.C((AppRuntime)localObject))) {}
    do
    {
      do
      {
        return;
      } while ((paramList == null) || (paramList.isEmpty()));
      if (paramList.size() > 5) {}
      for (int n = 5;; n = paramList.size())
      {
        localObject = new ArrayList();
        int i1 = 0;
        while (i1 < n)
        {
          long l1 = ((Long)paramList.get(i1)).longValue();
          BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Sek.a(this.jdField_a_of_type_Int, l1);
          if ((localBaseArticleInfo != null) && (!ozs.a(localBaseArticleInfo))) {
            ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
          }
          i1 += 1;
        }
      }
      paramList = pfa.a().a();
    } while (paramList == null);
    paramList.a((List)localObject);
  }
  
  private void d(qvp paramqvp)
  {
    if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0) {
      ComponentContentRecommend.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
    }
    do
    {
      return;
      if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
      {
        ComponentContentRecommendFollowList.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
        return;
      }
    } while (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2);
    ComponentContentRecommendFollowGroup.a(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
  }
  
  private void e(ArticleInfo paramArticleInfo)
  {
    boolean bool = true;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2;
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject2 = (QQAppInterface)localObject1;
      localObject1 = new awbu();
      if (this.jdField_a_of_type_Int != 56) {
        break label140;
      }
      ((awbu)localObject1).jdField_b_of_type_JavaLangString = "kandian_video";
      ((awbu)localObject1).jdField_a_of_type_JavaLangString = "kandian_video";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (paramArticleInfo.mCommentIconType == 1) {
        localBundle.putBoolean("jump_now_switch", bool);
      }
      try
      {
        localObject2 = (awcc)((QQAppInterface)localObject2).getManager(306);
        localBundle.putString("roomid", paramArticleInfo.mArticleContentUrl);
        localBundle.putString("fromid", ((awbu)localObject1).jdField_b_of_type_JavaLangString);
        ((awcc)localObject2).a(localBundle);
        ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
        return;
        label140:
        ((awbu)localObject1).jdField_b_of_type_JavaLangString = "kandian_shouye";
        ((awbu)localObject1).jdField_a_of_type_JavaLangString = "kandian_shouye";
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
  
  private void e(Map<Long, qvp> paramMap)
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      rwr localrwr = this.jdField_a_of_type_Ohl.a();
      if (localrwr != null)
      {
        paramMap = paramMap.values().iterator();
        while (paramMap.hasNext())
        {
          qvp localqvp = (qvp)paramMap.next();
          localqvp.jdField_h_of_type_Int = localrwr.a();
          if (localrwr.a(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
            localqvp.jdField_f_of_type_Boolean = true;
          }
        }
      }
    }
  }
  
  private void e(qvp paramqvp)
  {
    if (paramqvp.jdField_c_of_type_Boolean) {
      try
      {
        if (paramqvp.jdField_d_of_type_Boolean)
        {
          JSONObject localJSONObject = ozs.a();
          localJSONObject.put("feeds_source", paramqvp.jdField_a_of_type_JavaLangString);
          localJSONObject.put("kandian_mode", ozs.e());
          if (ubg.a(this.jdField_a_of_type_Int)) {}
          for (String str = "0X8009358";; str = "0X800744E")
          {
            ocd.a(null, "CliOper", "", "", str, str, 0, 0, ozs.e(paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", localJSONObject.toString(), false);
            return;
          }
        }
        return;
      }
      catch (JSONException paramqvp)
      {
        paramqvp.printStackTrace();
      }
    }
  }
  
  private void f(ArticleInfo paramArticleInfo)
  {
    ozs.a(a(), paramArticleInfo, this.jdField_a_of_type_Sek, this.jdField_a_of_type_Int);
    pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Sek.notifyDataSetChanged();
    ozs.a(a(), paramArticleInfo);
  }
  
  private void f(Map<Long, qvp> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (qvp)paramMap.next();
      if (!((qvp)localObject2).jdField_b_of_type_Boolean)
      {
        ((qvp)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ozs.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((qvp)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((qvp)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((qvp)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((qvp)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((qvp)localObject2).jdField_e_of_type_JavaLangString;
        if (((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new qxb();
          if (this.jdField_d_of_type_Long != 0L) {
            break label606;
          }
        }
        label606:
        for (int n = 1;; n = 0)
        {
          ((qxb)localObject1).jdField_c_of_type_Int = n;
          localObject1 = ((qxb)localObject1).toString();
          localReportInfo.mInnerId = ((qvp)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new qxa();
          ((qxa)localObject1).jdField_a_of_type_Long = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
            ((qxa)localObject1).jdField_b_of_type_Long = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
          }
          ((qxa)localObject1).jdField_a_of_type_Int = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((qxa)localObject1).jdField_b_of_type_Int = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((qvp)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((qxa)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            qxt localqxt = (qxt)((Iterator)localObject2).next();
            if (localqxt != null) {
              ((qxa)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqxt.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((qxa)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      pfa.a().a(localArrayList);
    }
  }
  
  private void f(qvp paramqvp)
  {
    long l3;
    int n;
    int i1;
    int i2;
    long l1;
    String str1;
    String str2;
    if ((paramqvp.jdField_c_of_type_Int == 48) || (paramqvp.jdField_c_of_type_Int == 49) || (paramqvp.jdField_c_of_type_Int == 50) || (paramqvp.jdField_c_of_type_Int == 51) || (paramqvp.jdField_c_of_type_Int == 52) || (paramqvp.jdField_c_of_type_Int == 53) || (paramqvp.jdField_c_of_type_Int == 78) || (paramqvp.jdField_c_of_type_Int == 79) || (paramqvp.jdField_c_of_type_Int == 80) || (paramqvp.jdField_c_of_type_Int == 1005) || (paramqvp.jdField_c_of_type_Int == 1006) || (paramqvp.jdField_c_of_type_Int == 1007))
    {
      l3 = paramqvp.jdField_b_of_type_Long;
      n = paramqvp.jdField_k_of_type_Int;
      i1 = oxw.a(this.jdField_a_of_type_Int, paramqvp.jdField_c_of_type_Int);
      i2 = oxw.a(paramqvp.jdField_c_of_type_Int);
      l1 = 0L;
      str1 = null;
      str2 = null;
      if (paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
        break label307;
      }
      l1 = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
      str1 = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
      str2 = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
    }
    label307:
    for (long l2 = paramqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;; l2 = 0L)
    {
      String str3 = oxw.a(getContext(), ozs.a(), i1, l1, l3, n, str1, str2, i2, this.jdField_a_of_type_Int);
      ocd.a(null, paramqvp.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", str3, false);
      oxw.a(7, ozs.a(), (int)l2, i1, l3, n, str1, str2);
      return;
    }
  }
  
  private void g(ArticleInfo paramArticleInfo)
  {
    std.b("fast_web_show_light_house_1");
    ppe localppe = pfa.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (ozs.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localppe != null) {
      this.jdField_g_of_type_Int = localppe.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
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
    List localList = (List)this.jdField_a_of_type_Ohl.a().getIntent().getSerializableExtra("subscription_all_article_id");
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
    if (!ozs.r())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838778);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Blrf);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Blih);
    if ((this.jdField_a_of_type_Int == 0) || (pbd.c(this.jdField_a_of_type_Int))) {
      qrn.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void y()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    int n;
    if ((this.jdField_a_of_type_Ohl instanceof ohf))
    {
      localActivity = a();
      if (localActivity.findViewById(2131362001) != null) {
        b(true);
      }
      while (localActivity.findViewById(2131362002) == null) {
        return;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362002);
      localView1 = localActivity.findViewById(2131378964);
      n = agej.a(50.0F, getResources());
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
      View localView2 = findViewById(2131367044);
      localView2.setPadding(0, n, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.5(this, localView1, n, localView2));
      return;
      if (!(this.jdField_a_of_type_Ohl instanceof ohz)) {
        break;
      }
      ((ohz)this.jdField_a_of_type_Ohl).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Sek);
      return;
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_Sek.b(b());
    this.jdField_a_of_type_Sek.a(this.jdField_e_of_type_Long);
    this.jdField_a_of_type_Sek.a(this);
    this.jdField_a_of_type_Sek.a(this);
    this.jdField_a_of_type_Sek.a(this);
    this.jdField_a_of_type_Sek.a(this);
    this.jdField_a_of_type_Sek.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Sek);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public Object a(pmr parampmr)
  {
    if (parampmr == null) {
      return null;
    }
    int n = -1;
    int i1 = 0;
    Object localObject = null;
    long l1;
    if (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampmr.a((pmk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1));
      if (parampmr.a == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = parampmr.a;
        n = ((pmk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a();
        parampmr.a = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1)), ", jobName : ", parampmr.a(), ", cost : ", Long.valueOf(l2 - l1) });
      i1 += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + n + ", now : " + ((pmk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a());
      return localObject;
    }
  }
  
  public List<stf> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public pmk a()
  {
    return a(2);
  }
  
  public pmk a(int paramInt)
  {
    return (pmk)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public sek a()
  {
    return this.jdField_a_of_type_Sek;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    F();
    a(new shv(this, "onResume"));
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
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.j();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((stf)localIterator.next()).c();
    }
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (pbd.c(this.jdField_a_of_type_Int))) {
      qrn.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    I();
    G();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    ((KandianMergeManager)ozs.a().getManager(162)).a(this.jdField_a_of_type_Pes);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.21(this), 50L);
    quv.a(a());
    b(false);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Sek != null)) {
      a(true, 1001, true);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 3320	shu
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 3322
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 3325	shu:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 238	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lpmr;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 3328	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 3328	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:c	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +60 -> 126
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne +30 -> 101
    //   74: aload_3
    //   75: ifnull +26 -> 101
    //   78: invokestatic 218	ozs:a	()Lmqq/app/AppRuntime;
    //   81: checkcast 220	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   92: invokevirtual 3332	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 3337	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: getstatic 3342	uao:a	Luao;
    //   104: astore_3
    //   105: iconst_m1
    //   106: iload_2
    //   107: if_icmpne +13 -> 120
    //   110: iconst_1
    //   111: istore 4
    //   113: aload_3
    //   114: iload 4
    //   116: invokevirtual 3343	uao:a	(Z)V
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
    //   139: getstatic 3342	uao:a	Luao;
    //   142: astore_3
    //   143: iconst_m1
    //   144: iload_2
    //   145: if_icmpne +13 -> 158
    //   148: iconst_1
    //   149: istore 4
    //   151: aload_3
    //   152: iload 4
    //   154: invokevirtual 3343	uao:a	(Z)V
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
    //   172: invokevirtual 3328	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   175: return
    //   176: iload_1
    //   177: iconst_1
    //   178: if_icmpne +10 -> 188
    //   181: aload_0
    //   182: iconst_1
    //   183: aload_3
    //   184: invokevirtual 3328	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
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
    //   207: invokevirtual 3347	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   210: ldc_w 3349
    //   213: invokevirtual 3352	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   216: checkcast 656	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   219: astore_3
    //   220: aload_3
    //   221: ifnull -190 -> 31
    //   224: aload_0
    //   225: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 305	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Sek	Lsek;
    //   233: aload_0
    //   234: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   237: invokestatic 2419	ozs:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lsel;I)V
    //   240: return
    //   241: iload_1
    //   242: bipush 117
    //   244: if_icmpne +65 -> 309
    //   247: aload_3
    //   248: ldc_w 1321
    //   251: invokevirtual 1325	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   254: checkcast 656	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   257: astore 5
    //   259: invokestatic 3355	onn:a	()Z
    //   262: ifeq +31 -> 293
    //   265: iload_2
    //   266: sipush 1699
    //   269: if_icmpne +24 -> 293
    //   272: aload 5
    //   274: invokestatic 3356	omw:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   277: ifeq +16 -> 293
    //   280: aload_0
    //   281: invokevirtual 2193	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()I
    //   284: ifne +9 -> 293
    //   287: aload_0
    //   288: aload_3
    //   289: invokespecial 3358	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Landroid/content/Intent;)V
    //   292: return
    //   293: aload_0
    //   294: invokevirtual 171	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   297: checkcast 798	com/tencent/mobileqq/app/BaseActivity
    //   300: getfield 802	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: aload_3
    //   304: iload_2
    //   305: invokestatic 3363	osp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   308: return
    //   309: iload_1
    //   310: sipush 20001
    //   313: if_icmpne +35 -> 348
    //   316: invokestatic 218	ozs:a	()Lmqq/app/AppRuntime;
    //   319: astore_3
    //   320: aload_3
    //   321: ifnull -290 -> 31
    //   324: aload_3
    //   325: sipush 162
    //   328: invokevirtual 585	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   331: checkcast 840	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   334: invokevirtual 3365	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:r	()V
    //   337: ldc_w 469
    //   340: iconst_1
    //   341: ldc_w 3367
    //   344: invokestatic 476	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: return
    //   348: iload_1
    //   349: sipush 1032
    //   352: if_icmpne +176 -> 528
    //   355: aload_3
    //   356: ldc_w 3369
    //   359: invokevirtual 3372	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_3
    //   363: aload_3
    //   364: ifnull -333 -> 31
    //   367: new 1031	org/json/JSONObject
    //   370: dup
    //   371: aload_3
    //   372: invokespecial 1033	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore_3
    //   376: new 1031	org/json/JSONObject
    //   379: dup
    //   380: invokespecial 2523	org/json/JSONObject:<init>	()V
    //   383: astore 5
    //   385: aload 5
    //   387: ldc_w 1260
    //   390: aload_0
    //   391: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   394: invokevirtual 1049	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload 5
    //   400: ldc_w 3374
    //   403: aload_3
    //   404: ldc_w 3374
    //   407: invokevirtual 3377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 1039	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload 5
    //   416: ldc_w 3379
    //   419: ldc_w 1702
    //   422: invokevirtual 1039	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   425: pop
    //   426: aconst_null
    //   427: ldc_w 1700
    //   430: ldc_w 1702
    //   433: ldc_w 1702
    //   436: ldc_w 3381
    //   439: ldc_w 3381
    //   442: iconst_0
    //   443: iconst_0
    //   444: new 638	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 639	java/lang/StringBuilder:<init>	()V
    //   451: aload_3
    //   452: ldc_w 3383
    //   455: invokevirtual 3377	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc_w 1702
    //   464: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 652	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: ldc_w 3385
    //   473: ldc_w 1702
    //   476: aload 5
    //   478: invokevirtual 1055	org/json/JSONObject:toString	()Ljava/lang/String;
    //   481: iconst_0
    //   482: invokestatic 1723	ocd:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   485: return
    //   486: astore_3
    //   487: ldc_w 469
    //   490: iconst_1
    //   491: new 638	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 639	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 3387
    //   501: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_3
    //   505: invokevirtual 3388	java/lang/Exception:toString	()Ljava/lang/String;
    //   508: invokevirtual 645	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 652	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 1346	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: return
    //   518: astore 6
    //   520: aload 6
    //   522: invokevirtual 599	java/lang/Exception:printStackTrace	()V
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
    //   545: ldc_w 3390
    //   548: invokevirtual 1325	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   551: astore_3
    //   552: aload_3
    //   553: instanceof 2413
    //   556: ifeq -525 -> 31
    //   559: aload_0
    //   560: getfield 305	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Sek	Lsek;
    //   563: aload_3
    //   564: checkcast 2413	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   567: invokevirtual 3393	sek:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   570: return
    //   571: iload_1
    //   572: bipush 102
    //   574: if_icmpne +28 -> 602
    //   577: getstatic 3342	uao:a	Luao;
    //   580: astore_3
    //   581: iload_2
    //   582: iconst_m1
    //   583: if_icmpne +13 -> 596
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_3
    //   590: iload 4
    //   592: invokevirtual 3343	uao:a	(Z)V
    //   595: return
    //   596: iconst_0
    //   597: istore 4
    //   599: goto -10 -> 589
    //   602: iload_1
    //   603: ldc_w 3394
    //   606: if_icmpne -575 -> 31
    //   609: getstatic 3342	uao:a	Luao;
    //   612: astore_3
    //   613: iload_2
    //   614: iconst_m1
    //   615: if_icmpne +13 -> 628
    //   618: iconst_1
    //   619: istore 4
    //   621: aload_3
    //   622: iload 4
    //   624: invokevirtual 3343	uao:a	(Z)V
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
    this.jdField_a_of_type_Sek.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Int == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        osp.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        osp.a(paramArticleInfo, paramString1);
        QQToast.a(a(), 0, a().getString(2131717057), 0).a();
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
    uae.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sek == null)) {
      return;
    }
    a(new sia(this, "onChannelArticleLoaded", paramInt, paramList));
    d(paramInt, paramList);
    c(paramList);
    this.jdField_a_of_type_Oze.jdField_b_of_type_Long = 0L;
    if (!this.jdField_g_of_type_Boolean)
    {
      bool = true;
      bool = a(bool);
      this.jdField_e_of_type_Boolean = bool;
      tqi.a().a(this.jdField_a_of_type_Int, bool);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label270;
      }
    }
    for (int n = 1;; n = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)ozs.a().getManager(162)).f();
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
          bool = ozs.b(((ReadInJoyNewFeedsActivity)a()).b());
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
        pcj.a(this.jdField_a_of_type_Sek.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = true;
      }
      b(paramList);
      M();
      if ((this.jdField_a_of_type_Int == 0) && (qja.a().b())) {
        V();
      }
      uae.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      uae.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      uae.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      bool = false;
      break;
    }
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(bnrf.u(ozs.a())).booleanValue()) {
        tbz.a(paramContext, "", "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        pfa.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Sek.notifyDataSetChanged();
        ubg.a(paramArticleInfo);
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
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_h_of_type_Int) || ((!LiuHaiUtils.e()) && (!LiuHaiUtils.d()))) {
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
            ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
            a(new sih(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (rpt.a(paramArticleInfo, getContext()));
          paramInt = sel.c(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = sel.c(paramArticleInfo);
          if ((qrc.b(paramInt)) || (sel.i(paramArticleInfo)) || (sel.g(paramArticleInfo)) || (sel.j(paramArticleInfo)) || (sel.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (sel.a(paramArticleInfo) == 23) || (sel.b(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              ozs.a(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyk.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              P();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                qam.a(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!sel.a(paramArticleInfo)) && (!sel.h(paramArticleInfo)) && (!ozs.b(paramArticleInfo)) && (!ozs.c(paramArticleInfo)) && (!ozs.e(paramArticleInfo)) && (!ozs.f(paramArticleInfo)));
        if (ozs.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          qam.a(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      qam.a(getContext(), paramArticleInfo);
      return;
    }
    b(paramArticleInfo, 2);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i3 = this.jdField_a_of_type_Int;
    Object localObject1 = ozs.d(paramArticleInfo);
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
      ocd.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ozs.b(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), this.jdField_a_of_type_Int, n), false);
      ocd.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ozs.b(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), this.jdField_a_of_type_Int, n));
      localObject2 = ubg.b(i3);
      if ((!sel.i(paramArticleInfo)) && (!sel.g(paramArticleInfo)) && (!sel.j(paramArticleInfo)) && (!sel.k(paramArticleInfo))) {
        break label777;
      }
      localObject3 = new sbg(ozs.a(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), i3, n, i1, bhnv.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ozs.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((sbg)localObject3).h(i2).c((String)odr.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(ozs.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ocd.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qyl.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((sbg)localObject3).a().a(), false);
    }
    for (;;)
    {
      ocd.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ozs.a(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), i3, n, i1, bhnv.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ozs.f(paramArticleInfo), i2, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = ozs.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!quv.c(paramArticleInfo)) && (!ozo.a().a()) && (ozs.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label932;
      }
      localObject3 = new qxa();
      ((qxa)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
        ((qxa)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
      }
      ((qxa)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qxa)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label925;
      }
      ((qxa)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        qxt localqxt = (qxt)((Iterator)localObject4).next();
        if (localqxt != null) {
          ((qxa)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqxt.jdField_a_of_type_Long));
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
      localObject3 = new sbg(ozs.a(paramArticleInfo.mAlgorithmID, ozs.a(paramArticleInfo), i3, n, i1, bhnv.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ozs.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((sbg)localObject3).h(i2).c((String)odr.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(ozs.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ocd.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((sbg)localObject3).a().a(), false);
    }
    label925:
    ((ReportInfo)localObject2).mFeedsReportData = ((qxa)localObject3);
    label932:
    ((List)localObject1).add(localObject2);
    pfa.a().a((List)localObject1);
    pgo.a.b(i3, paramArticleInfo);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!ubd.a((AdvertisementInfo)paramArticleInfo, i3)) {
        break label1020;
      }
      n = nzq.T;
    }
    for (;;)
    {
      nzq.a(new tlx().a(BaseApplicationImpl.getContext()).a(nzq.jdField_a_of_type_Int).b(n).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1020:
      if (ozs.a(paramArticleInfo)) {
        n = nzq.S;
      } else {
        n = nzq.N;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    int n = 0;
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (ozs.s(localArticleInfo)) {
      if ((ozs.m(localArticleInfo)) || (ozs.c(localArticleInfo)))
      {
        a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramInt = 4;
        d(paramInt);
      }
    }
    do
    {
      return;
      if (ozs.e(localArticleInfo))
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Sek, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    a(new sie(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int n;
    if (paramInt != 0)
    {
      bool1 = true;
      if (pbd.c(this.jdField_a_of_type_Int))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label227;
        }
        oyc.a(1);
      }
      if ((ozs.a()) && (!i()) && (!bool1)) {
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
      ozs.b(3);
      label129:
      a(true, n, bool1);
      if ((this.jdField_a_of_type_Int == 0) && (paramInt != 2))
      {
        if (!bnrf.s()) {
          break label336;
        }
        pfa.a().a().a();
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.32(this));
      paramReadInJoyBaseListView = this.jdField_c_of_type_JavaUtilList.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        stf localstf = (stf)paramReadInJoyBaseListView.next();
        if ((localstf instanceof ReadInJoyDiandianHeaderController)) {
          localstf.e();
        }
      }
      bool1 = false;
      break;
      label227:
      if (paramInt == 2) {
        break label59;
      }
      oyc.a(1);
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
      pfd.a().a(2, null);
      paramReadInJoyBaseListView = ozs.a(getContext());
      boolean bool2 = ozs.b(this.jdField_a_of_type_Int, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.a(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      ubg.a(1);
      break label125;
      label313:
      if ((getContext() instanceof SplashActivity)) {
        pfd.a().a(2, null);
      }
      n = 1;
      break label129;
      label336:
      pfd.a().g(2);
    }
    if (this.jdField_a_of_type_Int == 0) {
      ubg.d();
    }
    pmd.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    RecommendFeedsDiandianEntranceManager.a().a();
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    pah localpah = new pah(Integer.valueOf(0));
    b(paramView);
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (localArticleInfo != null)
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramBaseArticleInfo.innerUniqueID);
      a(new sif(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      a(paramBaseArticleInfo);
      ozs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
      if (a(paramBaseArticleInfo, paramView, paramInt, localpah, localArticleInfo)) {
        return;
      }
      a(paramInt, localArticleInfo);
    }
    d(((Integer)localpah.a()).intValue());
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i1 = this.jdField_a_of_type_Sek.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int n = 0;
        while (n < 5)
        {
          long l1 = ((Long)paramList.get(n)).longValue();
          Object localObject = this.jdField_a_of_type_Sek.a(i1, l1);
          if ((localObject != null) && (!ozs.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!ozs.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Sek.a(i1, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (abfv.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          n += 1;
        }
      }
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, qvp> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    a(new shr(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = ubg.a(this.jdField_a_of_type_Int);
    String str = ozs.e(this.jdField_a_of_type_Int);
    ThreadManager.post(new ReadInJoyListViewGroup.14(this, a(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (i())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
      bnrf.a((QQAppInterface)ozs.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      label156:
      bnrf.a((QQAppInterface)ozs.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Map<Long, qvp> paramMap, boolean paramBoolean, Map<Long, ubl> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        ubg.a(paramMap1, this.jdField_b_of_type_Boolean);
      }
      return;
    }
    e(paramMap);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label76:
    qvp localqvp;
    Object localObject;
    long l1;
    int n;
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localqvp = (qvp)localIterator.next();
        if (!localqvp.jdField_a_of_type_Boolean)
        {
          localqvp.jdField_a_of_type_Boolean = true;
          localObject = a();
          l1 = ((Long)((Pair)localObject).second).longValue();
          n = ((Integer)((Pair)localObject).first).intValue();
          ocd.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localqvp.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqvp.jdField_b_of_type_Int), ozs.a(localqvp.jdField_a_of_type_Long, localqvp.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqvp.jdField_d_of_type_Int), false);
          ocd.a("0X80066FC", "", "", Long.toString(localqvp.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqvp.jdField_b_of_type_Int), ozs.a(localqvp.jdField_a_of_type_Long, localqvp.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqvp.jdField_d_of_type_Int));
          str = ozs.a(localqvp.jdField_a_of_type_Long, localqvp.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqvp.jdField_d_of_type_Int, localqvp.jdField_e_of_type_Int, bhnv.h(getContext()), localqvp.jdField_a_of_type_JavaLangString, localqvp.jdField_c_of_type_JavaLangString, localqvp.jdField_e_of_type_JavaLangString, ozs.f(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, n, localqvp.jdField_f_of_type_Int, localqvp.jdField_g_of_type_Int, localqvp.jdField_h_of_type_Int, localqvp.jdField_f_of_type_Boolean, localqvp.jdField_j_of_type_Int, localqvp.jdField_i_of_type_Int, localqvp.m);
          if (localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
            if (this.jdField_a_of_type_Int == 56)
            {
              localObject = b(localqvp, str);
              label396:
              str = a(paramMap1, paramString, localqvp, (String)localObject);
              if (!ubg.a(this.jdField_a_of_type_Int)) {
                break label523;
              }
              localObject = "0X8009354";
              label425:
              if ((!pbd.a(this.jdField_a_of_type_Int)) && (!bnrf.a(this.jdField_a_of_type_Int))) {
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
      if (sel.i(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        a(localqvp, str, (String)localObject);
      }
      for (;;)
      {
        f(localqvp);
        e(localqvp);
        a(localqvp);
        b(localqvp);
        break label76;
        localObject = str;
        if (this.jdField_a_of_type_Int != 0) {
          break label396;
        }
        localObject = a(localqvp, str);
        break label396;
        localObject = "0X8007626";
        break label425;
        if (ozs.l(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          c(localqvp);
        }
        else if (ozs.t(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          ozs.a(localqvp, str, (String)localObject);
        }
        else if (ozs.s(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          b(localqvp, str, (String)localObject);
        }
        else if (ozs.u(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          d(localqvp);
        }
        else
        {
          if (localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
          {
            localObject = localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
            if (localObject == null) {
              break;
            }
            ozs.a(false, (JSONObject)localObject, localqvp);
            ozs.a(true, (JSONObject)localObject, localqvp);
            continue;
          }
          if (ozs.q(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
          {
            ozs.a(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localqvp);
          }
          else
          {
            if (ozs.i(localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
            {
              BaseArticleInfo localBaseArticleInfo = localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
              JSONObject localJSONObject = ozs.a(localBaseArticleInfo.mPolymericInfo);
              ocd.a(null, "CliOper", "", localqvp.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localqvp.jdField_k_of_type_Int + "", Long.toString(localqvp.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(localBaseArticleInfo.mPolymericInfo.jdField_d_of_type_Long), localJSONObject.toString(), false);
              if (localHashMap.containsKey(Long.valueOf(localBaseArticleInfo.mPolymericInfo.jdField_c_of_type_Long))) {
                break label76;
              }
              localHashMap.put(Long.valueOf(localBaseArticleInfo.mPolymericInfo.jdField_c_of_type_Long), Boolean.valueOf(true));
            }
            a(localqvp, l1, n, str, (String)localObject);
          }
        }
      }
      if (this.jdField_a_of_type_Int != 40677) {
        f(paramMap);
      }
      ubg.a(paramMap1, this.jdField_b_of_type_Boolean);
      slh.a(((Integer)a().first).intValue());
      return;
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, qvp> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    a(new shq(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Oze.jdField_b_of_type_Long = System.currentTimeMillis();
    if (i()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Oze.jdField_d_of_type_Long = bnrf.a((QQAppInterface)ozs.a(), a());; this.jdField_a_of_type_Oze.jdField_d_of_type_Long = bnrf.a((QQAppInterface)ozs.a(), this.jdField_a_of_type_Int))
    {
      q();
      uae.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!a()) {
        break;
      }
      return;
    }
    j();
  }
  
  public void a(pmr parampmr)
  {
    if (parampmr == null) {}
    for (;;)
    {
      return;
      int n = 0;
      while (n < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampmr.a((pmk)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(n)), ", jobName : ", parampmr.a(), ", cost : ", Long.valueOf(l2 - l1) });
        n += 1;
      }
    }
  }
  
  public void a(rwc paramrwc1, rwc paramrwc2)
  {
    this.jdField_h_of_type_Boolean = false;
    ((pmm)a(2)).l();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, agej.a(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131298707), 0, 0);
    }
  }
  
  public void a(svx paramsvx)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramsvx);
      this.jdField_a_of_type_Svx = paramsvx;
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
    a(new shs(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.16(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      n();
      pmd.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
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
            if ((((View)localObject).getTag() instanceof pmz))
            {
              localObject = (pmz)((View)localObject).getTag();
              i1 = paramInt;
              if (paramLong == ((pmz)localObject).jdField_a_of_type_Rwc.jdField_c_of_type_Long) {
                i1 = ((pmz)localObject).jdField_a_of_type_Int;
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
        this.jdField_a_of_type_Sek.a(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Sek.c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Ohl.a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + n + ", lastVisblePosi=" + i2 + "， headerCount=" + i1);
        }
        return;
        this.jdField_a_of_type_Sek.a(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Sek.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sek == null)) {
      return;
    }
    a(new sib(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Sek.getCount() == 0) {}
    int i1 = pfa.a().a(Integer.valueOf(paramInt));
    if (this.i)
    {
      if ((paramList != null) && (i1 == 1)) {
        this.jdField_a_of_type_Sek.c(0);
      }
      this.i = false;
    }
    qja.a().a();
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
    if (!this.jdField_a_of_type_Sek.i) {
      this.jdField_a_of_type_Sek.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Sek.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Sek.i + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Sek.jdField_h_of_type_Boolean);
    }
    rmp.a().c(true);
    setAdapterData(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
    this.jdField_a_of_type_Sek.a(0);
    if ((paramInt == 56) || (paramInt == 0))
    {
      localObject = ozs.a();
      if (localObject != null) {
        ((tnt)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    if ((paramInt == 0) || (pbd.c(this.jdField_a_of_type_Int))) {
      pfs.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
    b(paramBoolean1, i1);
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.k)) {
      if (this.jdField_a_of_type_Oof != null) {
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
      if ((pbd.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      a(paramList);
      d(paramList);
      AbstractGifImage.resumeAll();
      pmh.a(this.jdField_a_of_type_Sek.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Sek);
      pcj.a(this.jdField_a_of_type_Sek.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Sek.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131717156), getResources().getDrawable(2130849406));
        break;
      }
      a(getResources().getString(2131717245));
      break;
      if (!this.jdField_a_of_type_Sek.isEmpty()) {
        break;
      }
      a(getResources().getString(2131717204));
      break;
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Six != null) {
      this.jdField_a_of_type_Six.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.a(2, null);
    }
    a(new sik(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Sek != null) {
      pmd.a(this.jdField_a_of_type_Sek.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sek == null) || (paramList == null)) {}
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
        rmp.a().c(true);
        setAdapterData(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Sek.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Sek.isEmpty());
    a(getResources().getString(2131717245));
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
      paramReadInJoyBaseListView = ozs.a();
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
      if ((this.jdField_a_of_type_Int == 40830) || (pbd.c(this.jdField_a_of_type_Int)))
      {
        i1 = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i1 + 1);
      }
      for (;;)
      {
        pfa.a().a(this.jdField_a_of_type_Int, b(), paramInt, n, i1);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Sek == null))
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    a(new sid(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
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
        paramList = getResources().getString(2131716999);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      if ((pbd.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
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
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Ohl.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Sek == null)) {
      return;
    }
    this.jdField_a_of_type_Sek.b(pfa.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Sek.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, qvp> paramMap)
  {
    a(new shp(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Oir != null) {
      this.jdField_a_of_type_Oir.a(paramMap);
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
    a(new shx(this, "onPause"));
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.k();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((stf)localIterator.next()).d();
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
    pmd.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void d(Map<Integer, qvp> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        qvp localqvp = (qvp)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int i1 = oof.jdField_b_of_type_Int;
        if ((localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int n = localqvp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; n = 0)
        {
          oof.a("0X8009495", localTabChannelCoverInfo, i1, n, -1);
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
      uaf.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    pcj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      uaf.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    a(new shy(this, "onStart"));
    qja.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.i)) {
      a(1500, new ReadInJoyListViewGroup.25(this));
    }
  }
  
  public boolean e()
  {
    Boolean localBoolean = (Boolean)a(new sip(this, "onBackPressed"));
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
    a(new shz(this, "onStop"));
    if ((i()) && (j()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Sek.b(0);
      if (localArticleInfo != null) {
        pfa.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    qja.a().c();
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
    a(new sht(this, "onDestroy"));
    bnrf.a(System.currentTimeMillis(), (QQAppInterface)ozs.a());
    Object localObject = ((pfg)ozs.a().getManager(163)).a().a();
    if (localObject != null) {
      ((ppe)localObject).b(this.jdField_g_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Sek.d();
    this.jdField_a_of_type_Sek.a();
    this.jdField_a_of_type_Sek.a(null);
    this.jdField_a_of_type_Sek = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      pcj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.d();
      this.jdField_a_of_type_Aoof = null;
    }
    bnrf.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Oof != null)
    {
      this.jdField_a_of_type_Oof.a();
      this.jdField_a_of_type_Oof = null;
    }
    if (this.jdField_a_of_type_Sll != null)
    {
      this.jdField_a_of_type_Sll.b();
      this.jdField_a_of_type_Sll = null;
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((stf)((Iterator)localObject).next()).b();
    }
    localObject = (KandianMergeManager)ozs.a().getManager(162);
    ((KandianMergeManager)localObject).b(this.jdField_a_of_type_Pes);
    this.jdField_a_of_type_Pes = null;
    ((KandianMergeManager)localObject).b(this.jdField_a_of_type_Peu);
    ubd.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
    if (this.jdField_a_of_type_Nzj != null) {
      this.jdField_a_of_type_Nzj.a();
    }
    pmd.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (pbd.c(a())) {
      pad.a().b();
    }
    quv.b(a());
    if (this.jdField_a_of_type_Ono != null) {
      this.jdField_a_of_type_Ono.a();
    }
    pfd.a().b(this.jdField_a_of_type_Pfh);
    pfd.a().b(this.jdField_a_of_type_Rfm);
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
    ((KandianMergeManager)ozs.a().getManager(162)).b(this.jdField_a_of_type_Pes);
  }
  
  public void l()
  {
    this.jdField_h_of_type_Boolean = true;
    ((pmm)a(2)).k();
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
    rvy localrvy = this.jdField_a_of_type_Ohl.a();
    if ((localrvy != null) && (localrvy.a() != null)) {
      localrvy.b(11);
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
      ozs.b(3);
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
      Object localObject = this.jdField_a_of_type_Sek.getItem(n);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!ozs.r(localArticleInfo)) {}
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
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
    }
  }
  
  public void q()
  {
    if (ozs.k() == 0) {}
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Svx);
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
    Object localObject2 = this.jdField_a_of_type_Sek.a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = poc.a().a(this.jdField_a_of_type_Int, paramList, (List)localObject1, paramInt);
    if (paramList != null) {
      paramList = pgk.a.a(this.jdField_a_of_type_Sek, paramList);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Int == 0) || (pbd.b(pbd.b()))) {
        this.jdField_a_of_type_Sek.a(true);
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
      this.jdField_a_of_type_Sek.a(paramList);
      this.jdField_a_of_type_Sek.notifyDataSetChanged();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
      }
      return;
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setNotifyEndRefresh(six paramsix)
  {
    this.jdField_a_of_type_Six = paramsix;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!qtq.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
    svv localsvv = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localsvv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!qtq.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
      localsvv = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      r();
      localsvv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    svv localsvv = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localsvv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(anzj.a(2131711831));
    }
  }
  
  public void v()
  {
    QLog.d("ReadInJoyListViewGroup", 1, "invalidAllArticles");
    if (this.jdField_a_of_type_Sek != null) {
      this.jdField_a_of_type_Sek.p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */