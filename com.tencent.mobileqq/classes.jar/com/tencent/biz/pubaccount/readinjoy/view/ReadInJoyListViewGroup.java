package com.tencent.biz.pubaccount.readinjoy.view;

import aepi;
import altm;
import alud;
import amfe;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import atcz;
import atdh;
import babd;
import bdbb;
import bdin;
import bdiv;
import bdne;
import bhtv;
import bhuw;
import bhux;
import bicq;
import bkbq;
import bnle;
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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
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
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import noq;
import noy;
import nrt;
import ntd;
import nwc;
import nwi;
import nwj;
import nwm;
import nww;
import nxo;
import nxu;
import obk;
import ocq;
import oek;
import ohs;
import oik;
import ojb;
import olt;
import opn;
import opt;
import opy;
import oqs;
import orc;
import ore;
import org.json.JSONException;
import org.json.JSONObject;
import oro;
import ors;
import orz;
import osc;
import ota;
import otb;
import otf;
import ouk;
import owq;
import owy;
import oxb;
import oxd;
import oxe;
import oxp;
import oyd;
import oye;
import pcv;
import pcz;
import pdb;
import pdc;
import pde;
import pdh;
import pdi;
import pdq;
import ped;
import peo;
import pfd;
import pfg;
import pfo;
import pqd;
import pvd;
import pwz;
import pxe;
import pxl;
import qfg;
import qhl;
import qiu;
import qjz;
import qkk;
import qlj;
import qlk;
import qln;
import qlo;
import qlq;
import qlt;
import qlv;
import qlw;
import qme;
import qmv;
import qmw;
import qmy;
import qna;
import qnc;
import qnm;
import qno;
import qzy;
import raa;
import rdm;
import rjg;
import rjk;
import rkb;
import rkw;
import rlb;
import rom;
import ron;
import rqi;
import rqj;
import rrl;
import rrm;
import rrn;
import rro;
import rru;
import rss;
import rsv;
import rsw;
import rsx;
import rsy;
import rsz;
import rta;
import rtc;
import rtd;
import rte;
import rtf;
import rtg;
import rth;
import rti;
import rtj;
import rtk;
import rtl;
import rtm;
import rtn;
import rto;
import rtq;
import rtr;
import rts;
import rtt;
import rtu;
import rtv;
import rtw;
import rtx;
import rwj;
import rwl;
import rwn;
import sds;
import sdu;
import sei;
import sgm;
import sgo;
import smk;
import swt;
import syb;
import syp;
import syz;
import szl;
import szp;
import szu;
import tencent.im.oidb.articlesummary.articlesummary.VideoDownloadBarInfo;
import tencent.im.oidb.articlesummary.articlesummary.WeishiUGInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import zez;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bhuw, bhux, rkw, rrl, rrm, rrn, rro, rru
{
  private long jdField_a_of_type_Long;
  private altm jdField_a_of_type_Altm = new rtt(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<pdc> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected bdbb a;
  private bhtv jdField_a_of_type_Bhtv = new rss(this);
  private bicq jdField_a_of_type_Bicq = new rto(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private noq jdField_a_of_type_Noq;
  private nxo jdField_a_of_type_Nxo;
  private oik jdField_a_of_type_Oik;
  ojb jdField_a_of_type_Ojb;
  private owq jdField_a_of_type_Owq = new rtr(this);
  private oxe jdField_a_of_type_Oxe;
  private qzy jdField_a_of_type_Qzy;
  private rqi jdField_a_of_type_Rqi;
  rtx jdField_a_of_type_Rtx;
  private rwn jdField_a_of_type_Rwn;
  private sgo jdField_a_of_type_Sgo;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChannelTopPositionView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  private List<sdu> jdField_c_of_type_JavaUtilList = new ArrayList();
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
  
  public ReadInJoyListViewGroup(nwi paramnwi, int paramInt1, int paramInt2, int paramInt3, ore paramore)
  {
    this(paramnwi, paramInt1, paramInt2, paramInt3, paramore, 2131560123);
  }
  
  public ReadInJoyListViewGroup(nwi paramnwi, int paramInt1, int paramInt2, int paramInt3, ore paramore, int paramInt4)
  {
    super(paramnwi, paramInt1, paramore);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_f_of_type_Boolean = rdm.b();
    setId(2131375326);
    this.jdField_a_of_type_AndroidUtilSparseArray = pdh.a(this);
    b(paramInt1);
    if (paramInt1 != 41695) {
      B();
    }
    this.jdField_a_of_type_Ore.jdField_c_of_type_Long = bkbq.a((QQAppInterface)ors.a());
    a(new rtd(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(nwi paramnwi, int paramInt1, int paramInt2, ore paramore)
  {
    this(paramnwi, paramInt1, paramInt2, -1, paramore);
  }
  
  public ReadInJoyListViewGroup(nwi paramnwi, int paramInt, ore paramore)
  {
    this(paramnwi, paramInt, -1, paramore);
  }
  
  private void A()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Rqi.a();
    int n;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.jdField_f_of_type_Boolean) {
        break label217;
      }
      n = rqj.c(localArticleInfo);
      if ((n != 6) && (n != 71)) {
        break label174;
      }
      this.jdField_e_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      oqs.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
      c(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Noq = new noq(a(), true, this, this.jdField_a_of_type_Rqi);
      this.jdField_a_of_type_Rqi.a(this.jdField_a_of_type_Noq);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.6(this));
      return;
      label174:
      if (n == 28)
      {
        n = bkbq.e(ors.a());
        oqs.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int, 0, n);
        c(n);
        continue;
        label217:
        this.jdField_a_of_type_Rqi.i();
      }
    }
  }
  
  private void B()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.8(this), 3000L);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = new ChannelTopPositionView(a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView, 2);
    }
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!bkbq.k()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((sdu)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jdField_c_of_type_JavaUtilList.add(new sei(getContext()));
      continue;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (bkbq.A(ors.a()) != 2)
        {
          this.jdField_a_of_type_Ojb = new ojb(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_Ojb.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_c_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(a()));
      }
      else if ((this.jdField_a_of_type_Int == 41523) && (bkbq.B(ors.a()) != 1))
      {
        this.jdField_a_of_type_Ojb = new ojb(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Ojb.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Ojb.a());
      }
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (ohs.a().a())
      {
        a(false);
        QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.22(this), 500L);
      return;
    }
    ohs.a().c();
    QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void F()
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
      } while ((!ReadinjoyJumpActivity.c(a().getIntent())) || (bkbq.k()));
      localIntent = a().getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.a(a(), localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void G()
  {
    if (bkbq.a(b())) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_Int == 56) {
      owy.a().a(56);
    }
  }
  
  private void H()
  {
    boolean bool = this.jdField_a_of_type_Nwi.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((b()) && (!bool) && ((!bkbq.i()) || ((this.jdField_a_of_type_Nwi.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      n();
      L();
    }
    if (((!bkbq.i()) || ((this.jdField_a_of_type_Nwi.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      ntd.jdField_a_of_type_Int = ntd.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      this.l = false;
      this.k = false;
      this.jdField_a_of_type_Nwi.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Nwi.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Nwi.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Nwi.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((bkbq.j()) && ((this.jdField_a_of_type_Nwi.a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        oxd localoxd = (oxd)ors.a().getManager(163);
        localoxd.a().a(this.jdField_a_of_type_Int, localParcelable);
        localoxd.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  private void K()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      Parcelable localParcelable = ((oxd)ors.a().getManager(163)).a().a(this.jdField_a_of_type_Int);
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
  
  private void L()
  {
    if (b())
    {
      if (this.jdField_a_of_type_Nwi.a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label67;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label67:
    label709:
    label716:
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_Nwi.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int n = this.jdField_a_of_type_Nwi.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Rqi.a();
      if ((n == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label716;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = owy.a().a(Integer.valueOf(56));
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
          localObject2 = owy.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label709;
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
            owy.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l1 = Long.valueOf(((BaseArticleInfo)localList.get(0)).mRecommendSeq).longValue();
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
          owy.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Rqi.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rqi);
          if (this.jdField_a_of_type_Ojb == null) {}
          for (n = 0;; n = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(n, 0);
            this.jdField_a_of_type_Rqi.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, rqj.jdField_b_of_type_Int);
            return;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  private void M()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  private void N()
  {
    int i1 = this.jdField_a_of_type_Rqi.getCount();
    if (i1 > 0)
    {
      int n = 0;
      while (n < i1)
      {
        Object localObject = this.jdField_a_of_type_Rqi.getItem(n);
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
  
  private void O()
  {
    Object localObject = this.jdField_a_of_type_Rqi.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = syb.b((QQAppInterface)ors.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = syb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        syb.a(((BaseActivity)this.jdField_a_of_type_Nwi.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void P()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131372977);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    Q();
  }
  
  private void Q()
  {
    if (this.jdField_a_of_type_Int == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131375361));
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(0);
      }
    }
  }
  
  private void R()
  {
    try
    {
      if (this.jdField_a_of_type_Rwn != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Rwn.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Rwn = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void S()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372981));
    if (otf.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372980));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131372979));
  }
  
  private void T()
  {
    if ((pxe.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.i))
    {
      a(true, 0, false);
      this.i = true;
      return;
    }
    pxe.a().a();
  }
  
  private void U()
  {
    new Handler(Looper.getMainLooper()).post(new ReadInJoyListViewGroup.47(this));
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
      localReadinjoyTabFrame = ors.a(getContext());
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
      if (!otf.c(this.jdField_a_of_type_Int)) {
        break;
      }
      if (opt.b() != 0) {}
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
    if (otf.c(this.jdField_a_of_type_Int)) {
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
    qlk localqlk = (qlk)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localqlk.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localqlk.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localqlk.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localqlk.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localqlk.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localqlk.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localqlk.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localqlk.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localqlk.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.46(this, paramRunnable), paramInt);
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
    localIntent.putExtra("channel_name", alud.a(2131713460));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!rqj.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = rqj.c(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label257;
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
      ntd.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, ntd.b());
      rlb.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label257:
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
    ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_articleid");
    if (localArticleInfo != null)
    {
      if (this.jdField_a_of_type_Oik != null) {
        this.jdField_a_of_type_Oik.a();
      }
      this.jdField_a_of_type_Oik = new oik();
      this.jdField_a_of_type_Oik.a(new rtv(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Oik, 7, true, localArticleInfo, 1, n);
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
      if (bkbq.i()) {
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
  
  private void a(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131364669);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131166380));
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
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131166380));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      ors.a(a(), paramArticleInfo, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Rqi.a(this.jdField_a_of_type_Rqi.a(), paramArticleInfo.mArticleID)) {}
      ors.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", ors.f(0));
        ors.a(getContext(), str, localBundle);
        opn.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Rqi);
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
    if (ors.s(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    rjk localrjk = new rjk();
    localrjk.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localrjk.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localrjk.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localrjk.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localrjk.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localrjk.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localrjk.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    qlq localqlq = new qlq();
    localqlq.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localqlq.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!rqj.b(paramArticleInfo)) && (!rqj.i(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) || ((!rqj.q(paramArticleInfo)) || ((ors.l(paramArticleInfo)) && (!rqj.q(paramArticleInfo)))))
    {
      localrjk.jdField_f_of_type_Int = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_f_of_type_Int;
      localrjk.jdField_c_of_type_Int = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_a_of_type_Int;
      localrjk.jdField_d_of_type_Int = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_b_of_type_Int;
      localqlq.jdField_a_of_type_Int = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_f_of_type_Int;
      localrjk.jdField_b_of_type_Int = ((int)(((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_a_of_type_Long / 1000L));
      localrjk.jdField_b_of_type_JavaLangString = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_d_of_type_JavaLangString;
      localrjk.jdField_j_of_type_JavaLangString = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_g_of_type_JavaLangString;
      localrjk.jdField_c_of_type_JavaLangString = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((ors.i(paramArticleInfo)) && (ors.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localrjk.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localqlq.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localrjk.a = localqlq;
        localrjk.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localrjk.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localrjk.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localrjk.jdField_h_of_type_Int = localObject[0];
          localrjk.jdField_i_of_type_Int = localObject[1];
          localrjk.jdField_j_of_type_Int = paramView.getWidth();
          localrjk.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = orc.a(3, this.jdField_a_of_type_Int);
            int n = localrjk.jdField_h_of_type_Int;
            localrjk.jdField_h_of_type_Int = ((localrjk.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
            localrjk.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
          rdm.a(localrjk, paramView);
        }
        localObject = new qlw();
        ((qlw)localObject).jdField_a_of_type_Int = 409409;
        if (this.jdField_a_of_type_Int != 56) {
          break label831;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        ntd.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, (qlw)localObject);
      }
      owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Rqi.notifyDataSetChanged();
      return;
      localrjk.jdField_b_of_type_JavaLangString = ((qmy)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.b.get(0)).jdField_d_of_type_JavaLangString;
      break label403;
      if ((ors.i(paramArticleInfo)) && (ors.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localrjk.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localrjk.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localrjk.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localrjk.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localrjk.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localqlq.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localrjk.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localrjk.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localrjk.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localrjk.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localrjk.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label831:
      this.jdField_a_of_type_Rqi.a(localrjk, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (rdm.b(a(), paramArticleInfo)))
    {
      a(paramArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) || (ors.i(paramArticleInfo)) || (ors.m(paramArticleInfo)) || (ors.n(paramArticleInfo)))
    {
      if (ors.n(paramArticleInfo)) {
        a(paramArticleInfo, (qlk)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView);
      }
      for (;;)
      {
        owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Rqi.notifyDataSetChanged();
        }
        if (!ors.l(paramArticleInfo)) {
          break;
        }
        paramView = szp.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, szp.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        nrt.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        ors.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Rqi, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        a(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new qlw();
        paramView.jdField_a_of_type_Int = paramInt1;
        ntd.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((rqj.c(paramArticleInfo) == 6) || (rqj.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Rqi.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      nxu.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (bkbq.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Rqi, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
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
  
  private void a(ArticleInfo paramArticleInfo, qlk paramqlk, View paramView)
  {
    rjk localrjk = new rjk();
    if (paramqlk.jdField_a_of_type_Qln == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localrjk.jdField_c_of_type_Long = paramqlk.jdField_a_of_type_Long;
      localrjk.jdField_h_of_type_JavaLangString = (paramqlk.jdField_a_of_type_Qln.jdField_b_of_type_Long + "");
      localrjk.jdField_i_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_d_of_type_JavaLangString;
      localrjk.jdField_k_of_type_JavaLangString = paramqlk.jdField_e_of_type_JavaLangString;
      localrjk.jdField_g_of_type_Int = paramqlk.jdField_a_of_type_Int;
      localrjk.jdField_g_of_type_Long = paramqlk.jdField_b_of_type_Long;
      Object localObject = new qlq();
      ((qlq)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramqlk.jdField_a_of_type_Long);
      ((qlq)localObject).jdField_a_of_type_JavaLangString = paramqlk.jdField_g_of_type_JavaLangString;
      ((qlq)localObject).jdField_a_of_type_Int = paramqlk.jdField_a_of_type_Qln.jdField_a_of_type_Int;
      ((qlq)localObject).jdField_b_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_a_of_type_JavaLangString;
      localrjk.a = ((qlq)localObject);
      localrjk.jdField_b_of_type_JavaLangString = paramqlk.jdField_c_of_type_JavaLangString;
      localrjk.jdField_c_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_a_of_type_JavaLangString;
      localrjk.jdField_f_of_type_Int = paramqlk.jdField_a_of_type_Qln.jdField_a_of_type_Int;
      localrjk.jdField_c_of_type_Int = paramqlk.jdField_a_of_type_Qln.jdField_b_of_type_Int;
      localrjk.jdField_d_of_type_Int = paramqlk.jdField_a_of_type_Qln.jdField_c_of_type_Int;
      localrjk.jdField_b_of_type_Int = paramqlk.jdField_a_of_type_Qln.jdField_d_of_type_Int;
      localrjk.jdField_e_of_type_Long = paramqlk.jdField_a_of_type_Qln.jdField_a_of_type_Long;
      localrjk.jdField_j_of_type_JavaLangString = paramqlk.jdField_g_of_type_JavaLangString;
      localrjk.jdField_g_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_b_of_type_JavaLangString;
      localrjk.jdField_d_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_f_of_type_JavaLangString;
      localrjk.jdField_e_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_e_of_type_JavaLangString;
      localrjk.jdField_f_of_type_JavaLangString = paramqlk.jdField_a_of_type_Qln.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localrjk.jdField_h_of_type_Int = localObject[0];
        localrjk.jdField_i_of_type_Int = localObject[1];
        localrjk.jdField_j_of_type_Int = paramView.getWidth();
        localrjk.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = orc.a(3, this.jdField_a_of_type_Int);
          int n = localrjk.jdField_h_of_type_Int;
          localrjk.jdField_h_of_type_Int = ((localrjk.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + n);
          localrjk.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new qlw();
      ((qlw)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_Rqi.a(localrjk, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        ntd.a(paramqlk.jdField_a_of_type_Long, paramqlk.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Int, (int)paramqlk.jdField_b_of_type_Long, paramqlk.jdField_a_of_type_Int, 24, -1L, (qlw)localObject, -1, paramqlk.jdField_k_of_type_JavaLangString);
      }
      owy.a().a(paramqlk.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Rqi.notifyDataSetChanged();
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Rwn == null)
    {
      if (ors.k() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Rwn = new rwl(a(), LayoutInflater.from(getContext()).inflate(2131560121, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Rwn.a(new rts(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Rwn.a());
      this.jdField_a_of_type_Rwn.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Rwn.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (ors.k() == 2) {
        this.jdField_a_of_type_Rwn = new rwj(a());
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131372977).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131371058)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375282));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131375281));
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
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aepi.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aepi.a(10.0F, getResources()))
    {
      Q();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839102));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166789));
    }
  }
  
  private void a(ron paramron)
  {
    if ((paramron != null) && ((this.jdField_a_of_type_Nwi instanceof nww))) {
      if (!this.jdField_b_of_type_Boolean) {
        break label36;
      }
    }
    label36:
    for (int n = 1;; n = 0)
    {
      paramron.a("from_aio", Integer.valueOf(n));
      return;
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (otf.c(this.jdField_a_of_type_Int)) {}
    for (int n = 2;; n = 1)
    {
      syz.a(localContext, n, new ReadInJoyListViewGroup.37(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = opy.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (qjz.a(str)) {
        ors.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        rdm.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_Rqi.b())) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    boolean bool3;
    boolean bool6;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Rqi.getCount() == 0)
    {
      bool3 = true;
      bool6 = nwm.a(this.jdField_a_of_type_Int);
      if (!i()) {
        break label834;
      }
      localObject2 = ((BaseActivity)a()).app;
      localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
      if ((this.jdField_a_of_type_Int != 70) && (!otf.c(this.jdField_a_of_type_Int))) {
        break label666;
      }
      paramBoolean = a().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    for (;;)
    {
      label113:
      long l1;
      label147:
      boolean bool4;
      label183:
      boolean bool7;
      boolean bool2;
      label206:
      boolean bool5;
      label243:
      boolean bool1;
      if (this.jdField_a_of_type_Int == 70)
      {
        l1 = ((Integer)bkbq.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
        if (otf.a(this.jdField_a_of_type_Int)) {
          l1 = b();
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Ore.jdField_d_of_type_Long <= l1) {
          break label743;
        }
        bool4 = true;
        bool7 = j();
        if ((!b()) || (this.l)) {
          break label749;
        }
        bool2 = true;
        if ((!bkbq.j()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L) || (!((KandianMergeManager)localObject1).g())) {
          break label755;
        }
        bool5 = true;
        localObject1 = a();
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getIntent();
          if (localObject1 != null)
          {
            if (((Intent)localObject1).getIntExtra("launch_from", 0) != 15) {
              break label761;
            }
            bool1 = true;
            label283:
            this.jdField_b_of_type_Boolean = bool1;
          }
        }
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!this.jdField_b_of_type_Boolean)) {
          break label767;
        }
        bool1 = true;
        label328:
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
        if (!a()) {
          break label779;
        }
        bool4 = nwm.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!bool6)) {
          break label773;
        }
        bool1 = true;
        label475:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool6) }));
        paramBoolean = bool1;
      }
      int n;
      for (;;)
      {
        QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
        if ((!paramBoolean) && (!pcz.a(this.jdField_a_of_type_Int))) {
          break label1389;
        }
        n = 1;
        label604:
        if (n == 0) {
          break label1403;
        }
        if ((this.jdField_a_of_type_Int == 0) || (otf.c(this.jdField_a_of_type_Int))) {
          oxp.a().a.jdField_a_of_type_Boolean = true;
        }
        if ((!otf.c(this.jdField_a_of_type_Int)) || (otf.a())) {
          break label1394;
        }
        a(true, 1, false);
        label658:
        return true;
        bool3 = false;
        break;
        label666:
        if (this.jdField_a_of_type_Int == 40677)
        {
          localObject2 = (oye)((QQAppInterface)localObject2).getManager(274);
          if ((((oye)localObject2).a() != null) && (((oye)localObject2).a().size() > 0)) {}
          for (paramBoolean = true;; paramBoolean = false) {
            break;
          }
        }
        if (this.jdField_a_of_type_Int != 40830) {
          break label1458;
        }
        paramBoolean = true;
        break label113;
        l1 = 300000L;
        break label147;
        label743:
        bool4 = false;
        break label183;
        label749:
        bool2 = false;
        break label206;
        label755:
        bool5 = false;
        break label243;
        label761:
        bool1 = false;
        break label283;
        label767:
        bool1 = false;
        break label328;
        label773:
        bool1 = false;
        break label475;
        label779:
        paramBoolean = bool1;
        if (this.jdField_a_of_type_Int != 70)
        {
          paramBoolean = bool1;
          if (this.jdField_a_of_type_Int != 56)
          {
            paramBoolean = bool1;
            if (this.jdField_a_of_type_Int != 40677)
            {
              paramBoolean = bool1;
              if (!otf.c(this.jdField_a_of_type_Int)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
      label834:
      localObject1 = ((BaseActivity)a()).app;
      localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
      label874:
      boolean bool8;
      label895:
      int i1;
      if (bkbq.a((QQAppInterface)localObject1))
      {
        bool1 = ((KandianMergeManager)localObject2).b();
        bool8 = a() instanceof ReadInJoyNewFeedsActivity;
        if (!bool8) {
          break label1187;
        }
        l1 = bkbq.h((AppRuntime)localObject1);
        if (System.currentTimeMillis() - this.jdField_a_of_type_Ore.jdField_c_of_type_Long <= l1) {
          break label1197;
        }
        n = 1;
        label914:
        localObject1 = a().getIntent();
        bool7 = ((Intent)localObject1).getBooleanExtra("from_search", false);
        if ((!d()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
          break label1202;
        }
        bool4 = true;
        label956:
        if (d()) {
          ((Intent)localObject1).removeExtra("force_refresh");
        }
        if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
          break label1208;
        }
        i1 = 1;
        label992:
        if (!a()) {
          break label1219;
        }
        bool5 = nwm.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool1) && (!bool7) && (!bool5) && (i1 == 0) && (!bool4) && (!bool6)) {
          break label1213;
        }
        bool2 = true;
        label1045:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool6) }));
        if (!bool3) {
          break label1355;
        }
        n = 1;
      }
      for (;;)
      {
        paramBoolean = bool2;
        if (!bool2) {
          break;
        }
        ors.b(n);
        paramBoolean = bool2;
        break;
        localObject2 = b();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          bool1 = true;
          break label874;
        }
        bool1 = false;
        break label874;
        label1187:
        l1 = bkbq.g((AppRuntime)localObject1);
        break label895;
        label1197:
        n = 0;
        break label914;
        label1202:
        bool4 = false;
        break label956;
        label1208:
        i1 = 0;
        break label992;
        label1213:
        bool2 = false;
        break label1045;
        label1219:
        if ((bool3) || (bool1) || (bool7) || ((n != 0) && (paramBoolean)) || (i1 != 0) || (bool4))
        {
          bool2 = true;
          label1254:
          if ((n == 0) || (!paramBoolean)) {
            break label1349;
          }
        }
        label1349:
        for (bool5 = true;; bool5 = false)
        {
          QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4) }));
          break;
          bool2 = false;
          break label1254;
        }
        label1355:
        if (bool1)
        {
          n = 1;
        }
        else if (bool7)
        {
          n = 1;
        }
        else
        {
          if ((n != 0) && (paramBoolean))
          {
            n = 6;
            continue;
            label1389:
            n = 0;
            break label604;
            label1394:
            a(true, 2);
            break label658;
            label1403:
            localObject1 = this.jdField_a_of_type_Ore;
            if (this.jdField_a_of_type_Ore.jdField_a_of_type_Long == 0L) {}
            for (l1 = l2;; l1 = this.jdField_a_of_type_Ore.jdField_a_of_type_Long)
            {
              ((ore)localObject1).jdField_a_of_type_Long = l1;
              if (this.jdField_a_of_type_Int == 0) {}
              return false;
            }
          }
          n = 1;
        }
      }
      label1458:
      paramBoolean = false;
    }
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
  
  private List<Long> b()
  {
    Intent localIntent = this.jdField_a_of_type_Nwi.a().getIntent();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131377278));
    if (paramInt == 41695) {
      C();
    }
    if (otf.c(this.jdField_a_of_type_Int)) {
      osc.a().a();
    }
    this.jdField_a_of_type_Bdbb = new bdbb(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Rqi = new rqi(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Bdbb, this.jdField_a_of_type_AndroidUtilSparseArray);
    a(new rtj(this, "onListViewGroupInit"));
    S();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Nwi + a());
    }
    x();
    w();
    z();
    y();
    P();
    D();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Altm);
    ((KandianMergeManager)ors.a().getManager(162)).a(this.jdField_a_of_type_Owq);
    A();
    v();
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    ors.a(a(), paramArticleInfo, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
    owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Rqi.notifyDataSetChanged();
    ors.a(a(), paramArticleInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      ors.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((rqj.d(paramArticleInfo)) && (rqj.c(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    ors.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (qlk)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView);
  }
  
  private void b(List<Long> paramList)
  {
    Object localObject = ors.a();
    if ((!bkbq.A((AppRuntime)localObject)) || (!bkbq.B((AppRuntime)localObject))) {}
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
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Rqi.a(this.jdField_a_of_type_Int, l1);
        if ((localBaseArticleInfo != null) && (!ors.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        i1 += 1;
      }
    }
    owy.a().a().a((List)localObject);
  }
  
  private void b(boolean paramBoolean)
  {
    int n = 2131298612;
    boolean bool2 = false;
    label406:
    for (;;)
    {
      try
      {
        boolean bool3 = babd.a();
        if ((bool3 == this.m) && (!paramBoolean)) {
          return;
        }
        Activity localActivity = a();
        if (localActivity == null) {
          break;
        }
        this.m = bool3;
        if (otf.c(this.jdField_a_of_type_Int))
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
          ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361944);
          View localView1 = localActivity.findViewById(2131377023);
          View localView2 = findViewById(2131366732);
          if (bool1) {
            n = 2131298608;
          }
          n = getResources().getDimensionPixelOffset(n);
          if (!bool1) {
            break label376;
          }
          n = ImmersiveUtils.getStatusBarHeight(getContext()) + n;
          i1 = aepi.a(50.0F, getResources());
          i2 = ImmersiveUtils.getStatusBarHeight(getContext());
          int i3 = getResources().getDimensionPixelOffset(2131298612);
          localView2.setPadding(0, n, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, n, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + n);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyListViewGroup.49(this, localView1, n, i1 + i2 + i3, localView2));
          if (!bool3) {
            break;
          }
          a(true, 3, false);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyListViewGroup", 2, "iupdateListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = this.m;
      continue;
      label376:
      int i1 = aepi.a(50.0F, getResources());
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
        str = getResources().getString(2131718916);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      M();
      if (!bkbq.i()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.28(this), 1500L);
      return;
      str = getResources().getString(2131718915);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718733), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131718732);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718733), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131718731);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131718733), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131718732);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!otb.b()) {
      oxb.a().m();
    }
    this.jdField_a_of_type_Ore.jdField_a_of_type_Long = System.currentTimeMillis();
    bkbq.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ore.jdField_a_of_type_Long, (QQAppInterface)ors.a());
    owy localowy = null;
    Object localObject8 = null;
    Object localObject4 = null;
    long l1 = 0L;
    long l2 = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject7 = null;
    Bundle localBundle = null;
    int i2 = 0;
    int n = -1;
    QQAppInterface localQQAppInterface = ((BaseActivity)a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == pfg.a()))
    {
      if (!this.jdField_a_of_type_Ore.jdField_a_of_type_Boolean) {
        break label2166;
      }
      localObject1 = b();
      bool2 = h();
      this.jdField_a_of_type_Ore.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) == 8) {
        bool1 = true;
      }
    }
    for (localObject4 = (LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo");; localObject4 = localBundle)
    {
      int i1;
      if (localObject1 == null)
      {
        localObject2 = localKandianMergeManager.a();
        if ((localObject2 != null) && (((List)localObject2).size() > 2))
        {
          l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
          l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
          localObject2 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
          localObject1 = localKandianMergeManager.a();
          i1 = 1;
          if (c())
          {
            localObject6 = localKandianMergeManager.a();
            if (localObject6 != null)
            {
              localObject5 = ((KandianRedDotInfo)localObject6).articleIDList;
              if ((localObject5 != null) && (((List)localObject5).size() > 0))
              {
                localObject2 = new ArrayList();
                localObject1 = ((KandianRedDotInfo)localObject6).cookie;
                n = ((List)localObject5).size() - 1;
                for (;;)
                {
                  if (n >= 0)
                  {
                    ((List)localObject2).add(0, (Long)((List)localObject5).get(n));
                    n -= 1;
                    continue;
                    bool1 = false;
                    break;
                  }
                }
                n = 1;
                label424:
                localKandianMergeManager.f();
                localKandianMergeManager.e();
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject5 = localKandianMergeManager.a();
        localKandianMergeManager.k();
        if (n != 0)
        {
          n = 32;
          ors.a(false);
        }
        for (;;)
        {
          long l3 = l1;
          i2 = i1;
          localObject7 = localObject4;
          bool3 = bool1;
          i1 = n;
          l1 = l2;
          l2 = l3;
          bool1 = bool2;
          localObject4 = localObject5;
          n = i2;
          if (this.jdField_a_of_type_Int == 40830)
          {
            localObject8 = a().getIntent();
            localObject6 = localObject1;
            i2 = n;
            localObject5 = localObject2;
            if (localObject8 != null)
            {
              localObject9 = (ReadInJoyChannelActivity.SerializableMap)((Intent)localObject8).getSerializableExtra("channel_map_data");
              localObject6 = localObject1;
              i2 = n;
              localObject5 = localObject2;
              if (localObject9 != null)
              {
                localObject1 = (Long)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().remove("articleID");
                if (localObject1 != null)
                {
                  localObject2 = new ArrayList();
                  ((List)localObject2).add(localObject1);
                  ((Intent)localObject8).putExtra("channel_map_data", (Serializable)localObject9);
                }
                i2 = 9;
                localObject6 = (String)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().get("pushContext");
                localObject5 = localObject2;
              }
            }
            localObject2 = localObject6;
            localObject1 = localObject5;
            n = i2;
            label656:
            if (this.jdField_a_of_type_Rqi != null) {
              this.jdField_a_of_type_Rqi.a(paramBoolean1);
            }
            localObject8 = new ArrayList();
            i2 = i1;
            if (d())
            {
              ((List)localObject8).addAll(localKandianMergeManager.b());
              i2 = i1 | 0x80;
            }
            i1 = i2;
            if (pxe.a().a()) {
              i1 = i2 | 0x1000;
            }
            localObject9 = new ArrayList();
            if (this.jdField_a_of_type_Int == 56)
            {
              localObject5 = new pvd();
              ((pvd)localObject5).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
              ((pvd)localObject5).jdField_a_of_type_Boolean = bdiv.a(getContext(), ((pvd)localObject5).jdField_a_of_type_JavaLangString);
              ((List)localObject9).add(localObject5);
            }
            if (localObject4 != null) {
              break label1878;
            }
            localObject5 = null;
            label803:
            if (localObject4 != null) {
              break label1888;
            }
            localObject4 = null;
            label811:
            if (this.jdField_a_of_type_Int != 70) {
              break label1901;
            }
            owy.a().a(true, (String)localObject2);
            ped.a().a(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
            this.jdField_c_of_type_Int += 1;
            szp.a(paramInt, this.jdField_a_of_type_Int, a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
            return;
            if ((b()) && (!this.l))
            {
              l3 = this.jdField_a_of_type_Nwi.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
              bool1 = this.jdField_a_of_type_Nwi.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
              this.l = true;
              this.k = true;
              if (bool1)
              {
                localObject2 = (ArticleInfo)this.jdField_a_of_type_Nwi.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
                if (localObject2 == null) {
                  break label2097;
                }
                localObject1 = new Pair(((ArticleInfo)localObject2).getInnerUniqueID(), ((ArticleInfo)localObject2).mTitle);
                localObject4 = new JSONObject();
              }
            }
          }
          for (;;)
          {
            try
            {
              ((JSONObject)localObject4).put("ArticleId", ors.a(((ArticleInfo)localObject2).mArticleID));
              ((JSONObject)localObject4).put("FeedsId", ors.a(((ArticleInfo)localObject2).mFeedId));
              ((JSONObject)localObject4).put("algorithmIds", 0);
              ((JSONObject)localObject4).put("biuUin", 0);
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("socialFeedsType", 1);
              ((JSONObject)localObject4).put("extension", localObject2);
              ((JSONObject)localObject4).put("feedsType", 1);
              ((JSONObject)localObject4).put("id", 0);
              ((JSONObject)localObject4).put("network_type", 1);
              ((JSONObject)localObject4).put("orange", "");
              ((JSONObject)localObject4).put("pushMessage", "");
              ((JSONObject)localObject4).put("push_type", 0);
              ((JSONObject)localObject4).put("strategyIds", 0);
              ((JSONObject)localObject4).put("title", "");
              ((JSONObject)localObject4).put("uin", localQQAppInterface.getLongAccountUin());
              localObject2 = ((JSONObject)localObject4).toString();
              localObject4 = null;
              n = 5;
              bool1 = false;
              localObject5 = localObject4;
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject5;
              i1 = i2;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              localObject3 = null;
              continue;
            }
            localObject4 = new ArrayList();
            ((List)localObject4).add(Long.valueOf(l3));
            localObject1 = null;
            continue;
            if (this.jdField_a_of_type_Int == 70)
            {
              localObject3 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
              if (localObject3 != null)
              {
                localObject1 = ((KandianRedDotInfo)localObject3).cookie;
                a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
              }
              localObject3 = null;
              bool1 = false;
              localObject4 = null;
              i1 = i2;
              break;
            }
            long l4;
            if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1001L))
            {
              i2 = 2;
              localObject5 = localKandianMergeManager.c();
              i1 = n;
              localObject1 = localObject10;
              localObject3 = localowy;
              l4 = l2;
              l3 = l1;
              if (localObject5 != null)
              {
                if (!((KandianRedDotInfo)localObject5).hasArticleID()) {
                  break label1477;
                }
                localObject3 = ((KandianRedDotInfo)localObject5).articleIDList;
                localObject1 = ((KandianRedDotInfo)localObject5).cookie;
                l1 = ((KandianRedDotInfo)localObject5).algorithmID;
                l2 = ((KandianRedDotInfo)localObject5).strategyID;
                n = 1;
                i2 = 10;
              }
              for (;;)
              {
                localKandianMergeManager.m();
                l3 = l1;
                l4 = l2;
                i1 = n;
                bool1 = false;
                localObject4 = null;
                n = i1;
                l2 = l4;
                l1 = l3;
                i1 = i2;
                break;
                label1477:
                i2 = 6;
                localObject1 = localObject9;
                localObject3 = localObject4;
              }
            }
            if (this.jdField_a_of_type_Int == 40677)
            {
              localObject6 = (oye)localQQAppInterface.getManager(274);
              i1 = n;
              localObject1 = localObject5;
              localObject3 = localObject8;
              if (((oye)localObject6).a() != null)
              {
                i1 = n;
                localObject1 = localObject5;
                localObject3 = localObject8;
                if (((oye)localObject6).a().size() > 0)
                {
                  localObject4 = new ArrayList(((oye)localObject6).a());
                  n = 8;
                  i1 = n;
                  localObject1 = localObject5;
                  localObject3 = localObject4;
                  if (!TextUtils.isEmpty(((oye)localObject6).a()))
                  {
                    localObject1 = ((oye)localObject6).a();
                    localObject3 = localObject4;
                    i1 = n;
                  }
                }
              }
              ((oye)localObject6).a(a());
              bool1 = false;
              localObject4 = null;
              n = i1;
              i1 = i2;
              break;
              if (otf.c(this.jdField_a_of_type_Int))
              {
                localObject8 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
                localObject6 = localObject1;
                i2 = n;
                l4 = l2;
                l3 = l1;
                localObject5 = localObject3;
                if (localObject8 != null)
                {
                  localObject6 = localObject1;
                  i2 = n;
                  l4 = l2;
                  l3 = l1;
                  localObject5 = localObject3;
                  if (!((KandianRedDotInfo)localObject8).shouldRemoveFloatingRedPntArticleId())
                  {
                    l3 = ((KandianRedDotInfo)localObject8).algorithmID;
                    l4 = ((KandianRedDotInfo)localObject8).strategyID;
                    localObject5 = ((KandianRedDotInfo)localObject8).articleIDList;
                    i2 = 1;
                    localObject6 = ((KandianRedDotInfo)localObject8).cookie;
                    a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
                  }
                }
                localObject3 = localObject6;
                l2 = l4;
                l1 = l3;
                localObject1 = localObject5;
                n = i2;
                break label656;
              }
              l3 = a();
              if (this.jdField_a_of_type_Rqi != null)
              {
                localObject5 = (ArticleInfo)this.jdField_a_of_type_Rqi.b(0);
                if ((l3 != -1L) && (localObject5 != null) && (l3 != ((ArticleInfo)localObject5).mArticleID))
                {
                  localObject5 = new ArrayList();
                  ((List)localObject5).add(Long.valueOf(l3));
                  n = 6;
                  localObject3 = localObject1;
                  localObject1 = localObject5;
                  break label656;
                  label1878:
                  localObject5 = ((Pair)localObject4).first;
                  break label803;
                  label1888:
                  localObject4 = (String)((Pair)localObject4).second;
                  break label811;
                  label1901:
                  if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7)) {
                    i1 |= 0x800;
                  }
                  for (;;)
                  {
                    localBundle = new Bundle();
                    localBundle.putInt("FeedsRefreshType", this.jdField_b_of_type_Int);
                    localowy = owy.a();
                    i2 = this.jdField_a_of_type_Int;
                    int i3 = this.jdField_c_of_type_Int;
                    if ((localObject5 instanceof String))
                    {
                      localObject6 = (String)localObject5;
                      label1980:
                      if (!(localObject5 instanceof Long)) {
                        break label2052;
                      }
                    }
                    label2052:
                    for (l3 = ((Long)localObject5).longValue();; l3 = -1L)
                    {
                      localowy.a(i2, (List)localObject1, n, true, bool1, i3, (String)localObject6, l3, (String)localObject4, b(), l1, l2, (String)localObject3, paramInt, bool3, localObject7, i1, (List)localObject8, (List)localObject9, localBundle);
                      break;
                      localObject6 = null;
                      break label1980;
                    }
                  }
                }
              }
              localObject5 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject5;
              break label656;
            }
            localObject3 = null;
            bool1 = false;
            localObject4 = null;
            localObject1 = null;
            i1 = i2;
            break;
            label2097:
            localObject1 = null;
            localObject3 = localObject6;
          }
          n = 0;
        }
        n = 1;
        break label424;
        n = 0;
        break label424;
        localObject1 = null;
        l1 = 0L;
        l2 = 0L;
        i1 = -1;
        break;
        i1 = -1;
        localObject5 = null;
        l1 = 0L;
        l2 = 0L;
        Object localObject3 = localObject1;
        n = 0;
        localObject1 = localObject5;
      }
      label2166:
      localObject1 = null;
    }
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (qjz.a(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = oro.a().a(paramArticleInfo, null, null);
      str = oro.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Rqi.notifyDataSetChanged();
    ors.a(a(), paramArticleInfo, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
    ors.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private void c(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new rtw(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new rsv(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    sds.b("fast_web_show_light_house_1");
    pfo localpfo = owy.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (ors.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localpfo != null) {
      this.jdField_g_of_type_Int = localpfo.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    b(localArticleInfo);
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (ors.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      c(paramArticleInfo);
    }
    for (;;)
    {
      szp.a(paramArticleInfo);
      return;
      ors.a(a(), paramArticleInfo, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
    }
  }
  
  private void e(Map<Long, qkk> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (qkk)paramMap.next();
      if (!((qkk)localObject2).jdField_b_of_type_Boolean)
      {
        ((qkk)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ors.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((qkk)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((qkk)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((qkk)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((qkk)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((qkk)localObject2).jdField_e_of_type_JavaLangString;
        if (((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new qlw();
          if (this.jdField_d_of_type_Long != 0L) {
            break label606;
          }
        }
        label606:
        for (int n = 1;; n = 0)
        {
          ((qlw)localObject1).jdField_c_of_type_Int = n;
          localObject1 = ((qlw)localObject1).toString();
          localReportInfo.mInnerId = ((qkk)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new qlv();
          ((qlv)localObject1).jdField_a_of_type_Long = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
            ((qlv)localObject1).jdField_b_of_type_Long = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
          }
          ((qlv)localObject1).jdField_a_of_type_Int = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((qlv)localObject1).jdField_b_of_type_Int = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((qkk)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((qlv)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            qme localqme = (qme)((Iterator)localObject2).next();
            if (localqme != null) {
              ((qlv)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqme.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((qlv)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      owy.a().a(localArrayList);
    }
  }
  
  private boolean g()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private boolean h()
  {
    List localList = (List)this.jdField_a_of_type_Nwi.a().getIntent().getSerializableExtra("subscription_all_article_id");
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
  
  private void v()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.4(this));
  }
  
  private void w()
  {
    if (!ors.p())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838592);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bicq);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bhtv);
    if ((this.jdField_a_of_type_Int == 0) || (otf.c(this.jdField_a_of_type_Int))) {
      qhl.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void x()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    int n;
    if ((this.jdField_a_of_type_Nwi instanceof nwc))
    {
      localActivity = a();
      if (localActivity.findViewById(2131361944) != null) {
        b(true);
      }
      while (localActivity.findViewById(2131361945) == null) {
        return;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361945);
      localView1 = localActivity.findViewById(2131377964);
      n = aepi.a(50.0F, getResources());
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
      View localView2 = findViewById(2131366732);
      localView2.setPadding(0, n, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.5(this, localView1, n, localView2));
      return;
      if (!(this.jdField_a_of_type_Nwi instanceof nww)) {
        break;
      }
      ((nww)this.jdField_a_of_type_Nwi).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Rqi);
      return;
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_Rqi.b(b());
    this.jdField_a_of_type_Rqi.a(this.jdField_e_of_type_Long);
    this.jdField_a_of_type_Rqi.a(this);
    this.jdField_a_of_type_Rqi.a(this);
    this.jdField_a_of_type_Rqi.a(this);
    this.jdField_a_of_type_Rqi.a(this);
    this.jdField_a_of_type_Rqi.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rqi);
  }
  
  private void z()
  {
    this.jdField_a_of_type_Qzy = qzy.a();
    this.jdField_a_of_type_Qzy.a(this.jdField_e_of_type_Long);
    if (this.jdField_a_of_type_Int == 56)
    {
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      ntd.jdField_a_of_type_Int = ntd.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Nwi.a() != null)
    {
      this.jdField_a_of_type_Rqi.a(this.jdField_a_of_type_Nwi.a(), this.jdField_a_of_type_Qzy);
      return;
    }
    this.jdField_a_of_type_Rqi.b();
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public Object a(pdi parampdi)
  {
    if (parampdi == null) {
      return null;
    }
    int n = -1;
    int i1 = 0;
    Object localObject = null;
    long l1;
    if (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      parampdi.a((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1));
      if (parampdi.a == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = parampdi.a;
        n = ((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a();
        parampdi.a = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i1)), ", jobName : ", parampdi.a(), ", cost : ", Long.valueOf(l2 - l1) });
      i1 += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + n + ", now : " + ((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i1)).a());
      return localObject;
    }
  }
  
  public List<sdu> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public pdc a()
  {
    return a(2);
  }
  
  public pdc a(int paramInt)
  {
    return (pdc)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public rqi a()
  {
    return this.jdField_a_of_type_Rqi;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    E();
    a(new rtc(this, "onResume"));
    U();
    if (a()) {
      j();
    }
    G();
    if (System.currentTimeMillis() - this.jdField_f_of_type_Long > 10000L)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.20(this));
    }
    if (this.jdField_a_of_type_Rqi != null) {
      this.jdField_a_of_type_Rqi.j();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sdu)localIterator.next()).c();
    }
    q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (otf.c(this.jdField_a_of_type_Int))) {
      qhl.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    H();
    F();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    ((KandianMergeManager)ors.a().getManager(162)).a(this.jdField_a_of_type_Owq);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.21(this), 50L);
    qjz.a(a());
    b(false);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Rqi != null)) {
      a(true, 1001, true);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 2511	rtb
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 2513
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 2516	rtb:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 209	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lpdi;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 2519	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 2519	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 2520	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:c	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +36 -> 102
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne -40 -> 31
    //   74: aload_3
    //   75: ifnull -44 -> 31
    //   78: invokestatic 189	ors:a	()Lmqq/app/AppRuntime;
    //   81: checkcast 191	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 142	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 142	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   92: invokevirtual 2523	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 2528	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: return
    //   102: iload_1
    //   103: iconst_2
    //   104: if_icmpne +10 -> 114
    //   107: aload_0
    //   108: iconst_2
    //   109: aload_3
    //   110: invokevirtual 2519	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   113: return
    //   114: iload_1
    //   115: iconst_1
    //   116: if_icmpne +10 -> 126
    //   119: aload_0
    //   120: iconst_1
    //   121: aload_3
    //   122: invokevirtual 2519	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   125: return
    //   126: iload_1
    //   127: sipush 10922
    //   130: if_icmpne +49 -> 179
    //   133: iload_2
    //   134: sipush -10069
    //   137: if_icmpne -106 -> 31
    //   140: aload_3
    //   141: ifnull -110 -> 31
    //   144: aload_3
    //   145: invokevirtual 2532	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   148: ldc_w 2534
    //   151: invokevirtual 2537	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: checkcast 597	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull -128 -> 31
    //   162: aload_0
    //   163: invokevirtual 142	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   166: aload_3
    //   167: aload_0
    //   168: getfield 229	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rqi	Lrqi;
    //   171: aload_0
    //   172: getfield 258	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   175: invokestatic 2173	ors:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lrqj;I)V
    //   178: return
    //   179: iload_1
    //   180: bipush 117
    //   182: if_icmpne +65 -> 247
    //   185: aload_3
    //   186: ldc_w 1042
    //   189: invokevirtual 1046	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   192: checkcast 597	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   195: astore 4
    //   197: invokestatic 2540	oij:a	()Z
    //   200: ifeq +31 -> 231
    //   203: iload_2
    //   204: sipush 1699
    //   207: if_icmpne +24 -> 231
    //   210: aload 4
    //   212: invokestatic 2542	ohs:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   215: ifeq +16 -> 231
    //   218: aload_0
    //   219: invokevirtual 1835	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()I
    //   222: ifne +9 -> 231
    //   225: aload_0
    //   226: aload_3
    //   227: invokespecial 2544	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Landroid/content/Intent;)V
    //   230: return
    //   231: aload_0
    //   232: invokevirtual 142	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   235: checkcast 742	com/tencent/mobileqq/app/BaseActivity
    //   238: getfield 746	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   241: aload_3
    //   242: iload_2
    //   243: invokestatic 2549	olt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   246: return
    //   247: iload_1
    //   248: sipush 20001
    //   251: if_icmpne +35 -> 286
    //   254: invokestatic 189	ors:a	()Lmqq/app/AppRuntime;
    //   257: astore_3
    //   258: aload_3
    //   259: ifnull -228 -> 31
    //   262: aload_3
    //   263: sipush 162
    //   266: invokevirtual 522	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   269: checkcast 1626	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   272: invokevirtual 2550	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:q	()V
    //   275: ldc_w 392
    //   278: iconst_1
    //   279: ldc_w 2552
    //   282: invokestatic 399	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: return
    //   286: iload_1
    //   287: sipush 1032
    //   290: if_icmpne +176 -> 466
    //   293: aload_3
    //   294: ldc_w 2554
    //   297: invokevirtual 2558	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   300: astore_3
    //   301: aload_3
    //   302: ifnull -271 -> 31
    //   305: new 2001	org/json/JSONObject
    //   308: dup
    //   309: aload_3
    //   310: invokespecial 2559	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   313: astore_3
    //   314: new 2001	org/json/JSONObject
    //   317: dup
    //   318: invokespecial 2002	org/json/JSONObject:<init>	()V
    //   321: astore 4
    //   323: aload 4
    //   325: ldc_w 980
    //   328: aload_0
    //   329: getfield 258	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   332: invokevirtual 2017	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   335: pop
    //   336: aload 4
    //   338: ldc_w 2561
    //   341: aload_3
    //   342: ldc_w 2561
    //   345: invokevirtual 2564	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 2010	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload 4
    //   354: ldc_w 2566
    //   357: ldc_w 1408
    //   360: invokevirtual 2010	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   363: pop
    //   364: aconst_null
    //   365: ldc_w 1406
    //   368: ldc_w 1408
    //   371: ldc_w 1408
    //   374: ldc_w 2568
    //   377: ldc_w 2568
    //   380: iconst_0
    //   381: iconst_0
    //   382: new 575	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 576	java/lang/StringBuilder:<init>	()V
    //   389: aload_3
    //   390: ldc_w 2570
    //   393: invokevirtual 2564	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   396: invokevirtual 582	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: ldc_w 1408
    //   402: invokevirtual 582	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 589	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: ldc_w 2572
    //   411: ldc_w 1408
    //   414: aload 4
    //   416: invokevirtual 2048	org/json/JSONObject:toString	()Ljava/lang/String;
    //   419: iconst_0
    //   420: invokestatic 1429	nrt:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   423: return
    //   424: astore_3
    //   425: ldc_w 392
    //   428: iconst_1
    //   429: new 575	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 576	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 2574
    //   439: invokevirtual 582	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_3
    //   443: invokevirtual 2575	java/lang/Exception:toString	()Ljava/lang/String;
    //   446: invokevirtual 582	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 589	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 1067	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: return
    //   456: astore 5
    //   458: aload 5
    //   460: invokevirtual 536	java/lang/Exception:printStackTrace	()V
    //   463: goto -99 -> 364
    //   466: iload_1
    //   467: sipush 9999
    //   470: if_icmpne -439 -> 31
    //   473: iload_2
    //   474: iconst_m1
    //   475: if_icmpne -444 -> 31
    //   478: aload_3
    //   479: ifnull -448 -> 31
    //   482: aload_3
    //   483: ldc_w 2577
    //   486: invokevirtual 1046	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   489: astore_3
    //   490: aload_3
    //   491: instanceof 2579
    //   494: ifeq -463 -> 31
    //   497: aload_0
    //   498: getfield 229	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rqi	Lrqi;
    //   501: aload_3
    //   502: checkcast 2579	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   505: invokevirtual 2582	rqi:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   508: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	ReadInJoyListViewGroup
    //   0	509	1	paramInt1	int
    //   0	509	2	paramInt2	int
    //   0	509	3	paramIntent	Intent
    //   195	220	4	localObject	Object
    //   456	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   305	323	424	java/lang/Exception
    //   364	423	424	java/lang/Exception
    //   458	463	424	java/lang/Exception
    //   323	364	456	java/lang/Exception
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Rqi.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Int == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        olt.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        olt.a(paramArticleInfo, paramString1);
        QQToast.a(a(), 0, a().getString(2131718801), 0).a();
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
    syp.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rqi == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setAdapterData(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = ors.a();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(162)).a();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(true);
          }
        }
      }
      Object localObject3;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = owy.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label348;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = ors.c((String)localObject1);
        localObject3 = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label356;
        }
      }
      label348:
      label356:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label396;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject3 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject1).toString());
      label396:
      localObject1 = owy.a().a();
      if (localObject1 != null) {
        a(((pfd)localObject1).a(this.jdField_a_of_type_Int));
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 70) || (otf.c(this.jdField_a_of_type_Int))))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = owy.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      localObject1 = (QQAppInterface)ors.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (localObject1 != null))
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label889;
        }
        localObject1 = syb.b((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localObject2 = syb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        syb.a(((BaseActivity)this.jdField_a_of_type_Nwi.a()).app, (String)localObject2, String.valueOf(this.jdField_a_of_type_Long), (String)localObject1, false);
      }
    }
    this.jdField_a_of_type_Ore.jdField_b_of_type_Long = 0L;
    if (!this.jdField_g_of_type_Boolean)
    {
      bool = true;
      label588:
      bool = a(bool);
      this.jdField_e_of_type_Boolean = bool;
      oek.a().a(this.jdField_a_of_type_Int, bool);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label960;
      }
    }
    for (int n = 1;; n = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)ors.a().getManager(162)).f();
        if (paramInt <= 0) {
          break label1015;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1;
          label889:
          localException.printStackTrace();
          label960:
          paramInt = 0;
          continue;
          bool = ors.b(((ReadInJoyNewFeedsActivity)a()).b());
          continue;
          bool = true;
          continue;
          if (this.jdField_a_of_type_Int != 0)
          {
            K();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(a() instanceof ReadInJoyNewFeedsActivity)) {
        break label995;
      }
      if (n == 0) {
        break label977;
      }
      bool = true;
      if ((!this.jdField_e_of_type_Boolean) && (bool))
      {
        if ((n == 0) && (paramInt != 0)) {
          break label1001;
        }
        K();
      }
      if (!this.jdField_e_of_type_Boolean) {
        ouk.a(this.jdField_a_of_type_Rqi.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
      {
        l1 = NetConnInfoCenter.getServerTime();
        localObject1 = (QQAppInterface)ors.a();
        if (localObject1 != null)
        {
          paramList = ((oxd)((QQAppInterface)localObject1).getManager(163)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
          if (paramList != null)
          {
            localObject2 = (oye)((QQAppInterface)localObject1).getManager(274);
            if (localObject2 != null) {
              ((oye)localObject2).a(syb.a((QQAppInterface)localObject1, paramList), l1);
            }
          }
        }
      }
      L();
      if ((this.jdField_a_of_type_Int == 0) && (pxe.a().b())) {
        T();
      }
      syp.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      syp.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      syp.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      if (this.jdField_a_of_type_Int == 70)
      {
        ((KandianSubscribeManager)((QQAppInterface)localObject1).getManager(280)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Long);
        break;
      }
      if (!otf.c(this.jdField_a_of_type_Int)) {
        break;
      }
      ((KandianDailyManager)((QQAppInterface)localObject1).getManager(296)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
      bool = false;
      break label588;
    }
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(bkbq.t(ors.a())).booleanValue()) {
        smk.a(paramContext, "", "http://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        owy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Rqi.notifyDataSetChanged();
        szp.a(paramArticleInfo);
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
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_h_of_type_Int) || ((!bnle.e()) && (!bnle.d()))) {
      return;
    }
    this.jdField_h_of_type_Int = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.40(this));
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
            ors.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
            a(new rtn(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (rdm.a(paramArticleInfo, getContext()));
          paramInt = rqj.c(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = rqj.c(paramArticleInfo);
          if ((qfg.b(paramInt)) || (rqj.i(paramArticleInfo)) || (rqj.b(paramArticleInfo)) || (rqj.j(paramArticleInfo)) || (rqj.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (rqj.a(paramArticleInfo) == 23) || (rqj.b(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              ors.a(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmv.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              O();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                pqd.a(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!rqj.a(paramArticleInfo)) && (!rqj.h(paramArticleInfo)) && (!ors.b(paramArticleInfo)) && (!ors.c(paramArticleInfo)) && (!ors.e(paramArticleInfo)) && (!ors.f(paramArticleInfo)));
        if (ors.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          pqd.a(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      pqd.a(getContext(), paramArticleInfo);
      return;
    }
    b(paramArticleInfo, 2);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i3 = this.jdField_a_of_type_Int;
    Object localObject1 = ors.d(paramArticleInfo);
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
        break label764;
      }
      i1 = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label769;
      }
      i2 = paramArticleInfo.videoJumpChannelID;
      nrt.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ors.b(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), this.jdField_a_of_type_Int, n), false);
      nrt.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ors.b(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), this.jdField_a_of_type_Int, n));
      localObject2 = szp.b(i3);
      if ((!rqj.i(paramArticleInfo)) && (!rqj.b(paramArticleInfo)) && (!rqj.j(paramArticleInfo)) && (!rqj.k(paramArticleInfo))) {
        break label776;
      }
      localObject3 = new ron(ors.a(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), i3, n, i1, bdin.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((ron)localObject3).h(i2).c((String)ntd.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(ors.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      nrt.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmw.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((ron)localObject3).a().a(), false);
    }
    for (;;)
    {
      nrt.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ors.a(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), i3, n, i1, bdin.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), i2, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = ors.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!qjz.a(paramArticleInfo)) && (!oro.a().a()) && (ors.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label930;
      }
      localObject3 = new qlv();
      ((qlv)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
        ((qlv)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
      }
      ((qlv)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qlv)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label923;
      }
      ((qlv)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        qme localqme = (qme)((Iterator)localObject4).next();
        if (localqme != null) {
          ((qlv)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqme.jdField_a_of_type_Long));
        }
      }
      n = 0;
      break;
      label764:
      i1 = 1;
      break label36;
      label769:
      i2 = 56;
      break label49;
      label776:
      localObject3 = new ron(ors.a(paramArticleInfo.mAlgorithmID, ors.a(paramArticleInfo), i3, n, i1, bdin.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, ors.f(paramArticleInfo), i2, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((ron)localObject3).h(i2).c((String)ntd.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(ors.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      nrt.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((ron)localObject3).a().a(), false);
    }
    label923:
    ((ReportInfo)localObject2).mFeedsReportData = ((qlv)localObject3);
    label930:
    ((List)localObject1).add(localObject2);
    owy.a().a((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!szl.a((AdvertisementInfo)paramArticleInfo, i3)) {
        break label1008;
      }
      n = noy.R;
    }
    for (;;)
    {
      noy.a(new obk().a(BaseApplicationImpl.getContext()).a(noy.jdField_a_of_type_Int).b(n).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1008:
      if (ors.a(paramArticleInfo)) {
        n = noy.Q;
      } else {
        n = noy.L;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (ors.s(localArticleInfo)) {
      if ((ors.m(localArticleInfo)) || (ors.c(localArticleInfo)))
      {
        a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramInt = 4;
      }
    }
    for (;;)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity))
      {
        ((ReadInJoyNewFeedsActivity)getContext()).g(paramInt);
        label70:
        if (otf.c(this.jdField_a_of_type_Int)) {
          opt.a(paramInt);
        }
        O();
      }
      do
      {
        return;
        if (ors.e(localArticleInfo))
        {
          if (!QLog.isColorLevel()) {
            break label178;
          }
          QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
          paramInt = 0;
          break;
        }
        c(localArticleInfo);
        paramInt = 2;
        break;
        if (!(getContext() instanceof SplashActivity)) {
          break label70;
        }
        paramBaseArticleInfo = ors.a(getContext());
        if (paramBaseArticleInfo == null) {
          break label70;
        }
        paramBaseArticleInfo.a(paramInt);
        break label70;
        a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
      } while (paramBaseArticleInfo == null);
      paramBaseArticleInfo.invalidateProteusTemplateBean();
      return;
      label178:
      paramInt = 0;
    }
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Rqi, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    a(new rtk(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int n;
    if (paramInt != 0)
    {
      bool1 = true;
      if (otf.c(this.jdField_a_of_type_Int))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label219;
        }
        opt.a(1);
      }
      if ((ors.a()) && (!i()) && (!bool1)) {
        break label231;
      }
      n = 1;
      label79:
      if (n == 0) {
        break label236;
      }
      n = 3;
      label85:
      if (paramInt == 2) {
        break label305;
      }
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label243;
      }
      paramReadInJoyBaseListView = (ReadInJoyNewFeedsActivity)getContext();
      paramReadInJoyBaseListView.g(1);
      if (this.jdField_a_of_type_Int == 0) {
        paramReadInJoyBaseListView.c(false);
      }
      label125:
      ors.b(3);
    }
    for (;;)
    {
      a(true, n, bool1);
      if ((this.jdField_a_of_type_Int == 0) && (paramInt != 2)) {
        oxb.a().f(2);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.31(this));
      paramReadInJoyBaseListView = this.jdField_c_of_type_JavaUtilList.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        sdu localsdu = (sdu)paramReadInJoyBaseListView.next();
        if ((localsdu instanceof ReadInJoyDiandianHeaderController)) {
          localsdu.e();
        }
      }
      bool1 = false;
      break;
      label219:
      if (paramInt == 2) {
        break label59;
      }
      opt.a(1);
      break label59;
      label231:
      n = 0;
      break label79;
      label236:
      n = 1001;
      break label85;
      label243:
      if (!(getContext() instanceof SplashActivity)) {
        break label125;
      }
      oxb.a().a(2, null);
      paramReadInJoyBaseListView = ors.a(getContext());
      boolean bool2 = ors.b(this.jdField_a_of_type_Int, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.a(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      szp.a(1);
      break label125;
      label305:
      if ((getContext() instanceof SplashActivity)) {
        oxb.a().a(2, null);
      }
      n = 1;
    }
    if (this.jdField_a_of_type_Int == 0) {
      szp.d();
    }
    pcv.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof pxl)) {
      ((pxl)localObject).b();
    }
    localObject = (ArticleInfo)paramBaseArticleInfo;
    int n;
    int i3;
    int i2;
    int i1;
    label247:
    int i4;
    if (localObject != null)
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramBaseArticleInfo.innerUniqueID);
      a(new rtl(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      if (otf.c(this.jdField_a_of_type_Int))
      {
        paramBaseArticleInfo.mJumpType = 1;
        bkbq.a(paramBaseArticleInfo);
      }
      ors.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = (ArticleInfo)localObject;
      if (rqj.a((BaseArticleInfo)localObject))
      {
        ors.c(a(), (ArticleInfo)localObject, 6);
        ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, a());
        n = 0;
        i5 = n;
        if (!babd.a())
        {
          i5 = n;
          if (!((ArticleInfo)localObject).hasSearchWordInfo()) {
            if (rqj.c((ArticleInfo)localObject) != 3)
            {
              i5 = n;
              if (rqj.c((ArticleInfo)localObject) != 1) {}
            }
            else
            {
              i5 = n;
              if (((ArticleInfo)localObject).mIsShowSearchord == 1)
              {
                paramAdapterView = Aladdin.getConfig(201);
                if (paramAdapterView == null) {
                  break label2406;
                }
                i3 = paramAdapterView.getIntegerFromString("feeds_searchterm", 0);
                i2 = paramAdapterView.getIntegerFromString("feeds_searchterm_max", 1000);
                i1 = paramAdapterView.getIntegerFromString("feeds_pos_range_each_max", 3);
                if (!DateUtils.isToday(bdne.b("search_word_prefix_last_request_time")))
                {
                  bdne.a("search_word_prefix_last_request_time", System.currentTimeMillis());
                  bdne.a("search_word_prefix_show_times", 0L);
                }
                if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((ArticleInfo)localObject).mRefreshTime)) {
                  break label2369;
                }
                i4 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(((ArticleInfo)localObject).mRefreshTime)).intValue();
                label310:
                i5 = n;
                if (i4 < i1)
                {
                  i5 = n;
                  if (bdne.b("search_word_prefix_show_times") < i2)
                  {
                    i5 = n;
                    if (i3 == 1) {
                      ((amfe)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a(ByteStringMicro.copyFromUtf8(((ArticleInfo)localObject).innerUniqueID), new rtm(this, (ArticleInfo)localObject, i4, paramInt));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int i5 = n;; i5 = 0)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
        ((ReadInJoyNewFeedsActivity)getContext()).g(i5);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if (otf.c(this.jdField_a_of_type_Int)) {
              opt.a(i5);
            }
            O();
            return;
            if (ors.l((BaseArticleInfo)localObject))
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              n = 4;
              break;
            }
            if (((ArticleInfo)localObject).mFeedType == 3)
            {
              paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
              label527:
              boolean bool;
              if ((paramAdapterView instanceof QQAppInterface))
              {
                paramView = (QQAppInterface)paramAdapterView;
                paramAdapterView = new atcz();
                if (this.jdField_a_of_type_Int != 56) {
                  break label618;
                }
                paramAdapterView.jdField_b_of_type_JavaLangString = "kandian_video";
                paramAdapterView.jdField_a_of_type_JavaLangString = "kandian_video";
                paramBaseArticleInfo = new Bundle();
                if (((ArticleInfo)localObject).mCommentIconType != 1) {
                  break label635;
                }
                bool = true;
                paramBaseArticleInfo.putBoolean("jump_now_switch", bool);
              }
              try
              {
                paramView = (atdh)paramView.getManager(306);
                paramBaseArticleInfo.putString("roomid", ((ArticleInfo)localObject).mArticleContentUrl);
                paramBaseArticleInfo.putString("fromid", paramAdapterView.jdField_b_of_type_JavaLangString);
                paramView.a(paramBaseArticleInfo);
                ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
                n = 0;
                break;
                label618:
                paramAdapterView.jdField_b_of_type_JavaLangString = "kandian_shouye";
                paramAdapterView.jdField_a_of_type_JavaLangString = "kandian_shouye";
                break label527;
                label635:
                bool = false;
              }
              catch (NumberFormatException paramAdapterView)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyListViewGroup", 2, "subscribeId to roomId error, " + paramAdapterView.getMessage());
                  }
                }
              }
            }
          }
          if (((ArticleInfo)localObject).mFeedType == 13)
          {
            paramAdapterView = ((ArticleInfo)localObject).mArticleContentUrl;
            if (!TextUtils.isEmpty(paramAdapterView))
            {
              paramBaseArticleInfo = new Intent(getContext(), QQBrowserActivity.class);
              paramBaseArticleInfo.putExtra("url", paramAdapterView);
              getContext().startActivity(paramBaseArticleInfo);
            }
            ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
            n = 0;
            break;
          }
          if ((((ArticleInfo)localObject).mFeedType == 22) || (((ArticleInfo)localObject).mFeedType == 21) || (ors.n((ArticleInfo)localObject)))
          {
            ors.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            n = 0;
            break;
          }
          if (rqj.b((ArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
              QLog.d("ReadInJoyListViewGroup", 1, "tryJumpToUgUrl: true");
              ((ArticleInfo)localObject).click_jump_target = pqd.a(opy.a((BaseArticleInfo)localObject), "-1");
            }
            for (;;)
            {
              paramBaseArticleInfo.click_area = 7;
              ors.b(getContext(), (ArticleInfo)localObject, (int)paramBaseArticleInfo.mChannelID);
              n = 0;
              break;
              QLog.d("ReadInJoyListViewGroup", 1, "short content redirectToOtherPage");
              pqd.a(getContext(), (ArticleInfo)localObject);
            }
          }
          if ((rqj.a((ArticleInfo)localObject)) && (rqj.c((ArticleInfo)localObject)))
          {
            c((ArticleInfo)localObject, paramView);
            n = 0;
            break;
          }
          if (rqj.a((ArticleInfo)localObject))
          {
            ors.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            n = 0;
            break;
          }
          if (rqj.c((ArticleInfo)localObject) == 71)
          {
            if ((paramView instanceof ProteusItemView)) {
              a((ProteusItemView)paramView);
            }
            for (;;)
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              n = 4;
              break;
              if ((paramView instanceof LinearLayout)) {
                a((LinearLayout)paramView);
              }
            }
          }
          if ((rqj.b((BaseArticleInfo)localObject)) || (rqj.j((ArticleInfo)localObject)))
          {
            ors.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            rqj.a((ArticleInfo)localObject, this.jdField_a_of_type_Rqi.a());
            n = 0;
            break;
          }
          if ((ors.b((ArticleInfo)localObject)) || (ors.c((ArticleInfo)localObject)))
          {
            ors.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            rqj.a((ArticleInfo)localObject, this.jdField_a_of_type_Rqi.a());
            ors.a((ArticleInfo)localObject, this.jdField_a_of_type_Rqi.a());
            n = 0;
            break;
          }
          if (ors.a((ArticleInfo)localObject))
          {
            b((ArticleInfo)localObject, 1);
            opn.a(getContext(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi);
            n = 2;
            break;
          }
          if ((rqj.i((ArticleInfo)localObject)) || (rqj.k((ArticleInfo)localObject)))
          {
            ors.a(getContext(), (ArticleInfo)localObject, 0, false, 1, false);
            rqj.a((ArticleInfo)localObject, this.jdField_a_of_type_Rqi.a());
            n = 0;
            break;
          }
          if (rqj.h((ArticleInfo)localObject))
          {
            if (rqj.c((ArticleInfo)localObject))
            {
              c((ArticleInfo)localObject, paramView);
              n = 0;
              break;
            }
            ors.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            n = 0;
            break;
          }
          if (ors.a((BaseArticleInfo)localObject))
          {
            if ((((ArticleInfo)localObject).isTwoItemVideoFeed()) && (((ArticleInfo)localObject).mFeedType != 36))
            {
              QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle);
              return;
            }
            if (rqj.c((ArticleInfo)localObject) == 6)
            {
              if ((paramView instanceof ProteusItemView)) {
                a((ProteusItemView)paramView);
              }
            }
            else
            {
              label1363:
              if (!a((ArticleInfo)localObject, paramView)) {
                break label1566;
              }
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug video feeds");
              owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rqi.notifyDataSetChanged();
              ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle + " article.mSummary:" + ((ArticleInfo)localObject).mSummary + "mJsonVideoList:" + ((ArticleInfo)localObject).mJsonVideoList + " videoJumpChannelID=" + ((ArticleInfo)localObject).videoJumpChannelID + " videoJumpChannelName=" + ((ArticleInfo)localObject).videoJumpChannelName + " videoJumpChannelType=" + ((ArticleInfo)localObject).videoJumpChannelType);
              }
              n = 4;
              break;
              if (!(paramView instanceof LinearLayout)) {
                break label1363;
              }
              a((LinearLayout)paramView);
              break label1363;
              label1566:
              if (b((ArticleInfo)localObject, paramView))
              {
                QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt video feeds");
              }
              else if (paramBaseArticleInfo.isAccountShown)
              {
                paramBaseArticleInfo.click_area = 7;
                paramBaseArticleInfo.click_jump_target = pqd.a("", "3");
                c((ArticleInfo)localObject);
              }
              else
              {
                a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              }
            }
          }
          if (ors.d((BaseArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
              label1690:
              owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              if (this.jdField_a_of_type_Rqi == null) {
                break label2420;
              }
            }
            try
            {
              if (!TextUtils.isEmpty(smk.b(((ArticleInfo)localObject).mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
              {
                if (this.jdField_a_of_type_AndroidOsHandler == null) {
                  this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
                }
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyListViewGroup.34(this), 2000L);
              }
              for (;;)
              {
                n = 0;
                break;
                a((ArticleInfo)localObject, paramInt - 1);
                break label1690;
                this.jdField_a_of_type_Rqi.notifyDataSetChanged();
              }
            }
            catch (Exception paramAdapterView)
            {
              this.jdField_a_of_type_Rqi.notifyDataSetChanged();
              n = 0;
            }
          }
        }
        if ((ors.a(((ArticleInfo)localObject).mArticleContentUrl, ((ArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) || (((ArticleInfo)localObject).isAccountShown))
        {
          if (paramBaseArticleInfo.isAccountShown) {
            paramBaseArticleInfo.click_area = 7;
          }
          if (a((ArticleInfo)localObject, paramView))
          {
            QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug normal feeds");
            owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
            this.jdField_a_of_type_Rqi.notifyDataSetChanged();
            paramBaseArticleInfo.click_jump_target = pqd.a(opy.a((BaseArticleInfo)localObject), "-1");
            ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            n = 2;
            break;
            if (b((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
              paramBaseArticleInfo.click_jump_target = pqd.a(oro.a().a(), "-1");
            }
            else if ((!qjz.a((BaseArticleInfo)localObject)) && (!oro.a().a()) && (ors.a(paramView.getContext(), (BaseArticleInfo)localObject)))
            {
              ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
              owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rqi.notifyDataSetChanged();
              paramAdapterView = ors.i(((ArticleInfo)localObject).getInnerUniqueID());
              paramBaseArticleInfo.click_jump_target = pqd.a(paramAdapterView, "-1");
              ors.a(paramView.getContext(), (BaseArticleInfo)localObject, paramAdapterView);
            }
            else if (pdb.a(paramView.getContext(), ((ArticleInfo)localObject).mArticleContentUrl))
            {
              ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
              owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rqi.notifyDataSetChanged();
            }
            else
            {
              paramBaseArticleInfo.click_jump_target = pqd.a("", "3");
              c((ArticleInfo)localObject);
            }
          }
        }
        if (((ArticleInfo)localObject).mFeedType == 26)
        {
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qna == null) || (TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qna.jdField_k_of_type_JavaLangString))) {
            break label2420;
          }
          ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
          ors.c(getContext(), ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qna.jdField_k_of_type_JavaLangString);
          owy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
          n = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 23)
        {
          ors.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
          n = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 34)
        {
          ors.a(getContext(), ((ArticleInfo)localObject).mArticleContentUrl, null);
          rqj.a((ArticleInfo)localObject, this.jdField_a_of_type_Rqi.a());
          n = 0;
          break;
        }
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (this.jdField_a_of_type_Rqi != null) && (!rqj.a((BaseArticleInfo)localObject))) {
          ors.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rqi, this.jdField_a_of_type_Int);
        }
        n = 2;
        break;
        label2369:
        i4 = 0;
        break label310;
        if ((getContext() instanceof SplashActivity))
        {
          paramAdapterView = ors.a(getContext());
          if (paramAdapterView != null) {
            paramAdapterView.a(i5);
          }
        }
      }
      label2406:
      i3 = 0;
      i2 = 1000;
      i1 = 3;
      break label247;
      label2420:
      n = 0;
      break;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (!PreloadManager.a().a()) {}
    for (;;)
    {
      return;
      PreloadManager.a().e();
      int i1 = this.jdField_a_of_type_Rqi.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int n = 0;
        while (n < 5)
        {
          long l1 = ((Long)paramList.get(n)).longValue();
          Object localObject = this.jdField_a_of_type_Rqi.a(i1, l1);
          if ((localObject != null) && (!ors.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!ors.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Rqi.a(i1, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (zez.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          n += 1;
        }
      }
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, qkk> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    a(new rsy(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = szp.a(this.jdField_a_of_type_Int);
    String str = ors.e(this.jdField_a_of_type_Int);
    ThreadManager.post(new ReadInJoyListViewGroup.14(this, a(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (i())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
      bkbq.a((QQAppInterface)ors.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      label156:
      bkbq.a((QQAppInterface)ors.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Map<Long, qkk> paramMap, boolean paramBoolean, Map<Long, szu> paramMap1, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty()) || (!paramBoolean))
    {
      QLog.d("ReadInJoyListViewGroup", 2, "report data is null ");
      if ((paramMap1 != null) && (!paramMap1.isEmpty())) {
        szp.a(paramMap1, this.jdField_b_of_type_Boolean);
      }
      return;
    }
    Object localObject1;
    Object localObject5;
    Object localObject7;
    if (this.jdField_a_of_type_Int == 56)
    {
      localObject1 = this.jdField_a_of_type_Nwi.a();
      if (localObject1 != null)
      {
        localObject5 = paramMap.values().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject7 = (qkk)((Iterator)localObject5).next();
          ((qkk)localObject7).jdField_h_of_type_Int = ((rkb)localObject1).a();
          if (((rkb)localObject1).a(((qkk)localObject7).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID)) {
            ((qkk)localObject7).jdField_f_of_type_Boolean = true;
          }
        }
      }
    }
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.values().iterator();
    label164:
    qkk localqkk;
    long l1;
    int i2;
    label557:
    label761:
    int n;
    while (localIterator.hasNext())
    {
      localqkk = (qkk)localIterator.next();
      if (!localqkk.jdField_a_of_type_Boolean)
      {
        localqkk.jdField_a_of_type_Boolean = true;
        localObject1 = a();
        l1 = ((Long)((Pair)localObject1).second).longValue();
        i2 = ((Integer)((Pair)localObject1).first).intValue();
        nrt.a(null, "CliOper", "", "", "0X80066FC", "0X80066FC", 0, 0, "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqkk.jdField_d_of_type_Int), false);
        nrt.a("0X80066FC", "", "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqkk.jdField_d_of_type_Int));
        localObject7 = ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(getContext()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, i2, localqkk.jdField_f_of_type_Int, localqkk.jdField_g_of_type_Int, localqkk.jdField_h_of_type_Int, localqkk.jdField_f_of_type_Boolean, localqkk.jdField_j_of_type_Int, localqkk.jdField_i_of_type_Int, localqkk.m);
        if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null)
        {
          if (this.jdField_a_of_type_Int == 56)
          {
            localObject1 = ors.a((String)localObject7, this.jdField_a_of_type_Nwi.a().a(), ntd.jdField_a_of_type_Int);
            if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo == null)) {
              break label4430;
            }
            localObject1 = new ron((String)localObject1).c(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).d(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).a().a();
            localObject5 = this.jdField_a_of_type_Rqi;
            if (((rqi.c((ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo) == 46) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem)) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo != null) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo != null) && (ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url)) && (ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail))) {
              rdm.a(ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_report_base_url) + ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoDownloadBarInfo.weishiUGInfo.bytes_exposure_report_tail));
            }
            localObject5 = localObject1;
          }
          for (;;)
          {
            try
            {
              localObject1 = new JSONObject((String)localObject5);
              ((JSONObject)localObject1).put("folder_status", paramString);
              ((JSONObject)localObject1).put("is_change", ota.a(ors.a(), this.jdField_a_of_type_Int));
              if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) {
                continue;
              }
              localObject1 = ((JSONObject)localObject1).toString();
            }
            catch (Exception localException1)
            {
              label784:
              label810:
              localObject2 = localObject5;
              continue;
              n = 0;
            }
            if (szp.a(this.jdField_a_of_type_Int))
            {
              localObject5 = "0X8009354";
              if ((!otf.a(this.jdField_a_of_type_Int)) && (!bkbq.a(this.jdField_a_of_type_Int))) {
                break label4427;
              }
              localObject5 = "0X8009CC8";
              if (!rqj.d(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
                break label1535;
              }
              n = 0;
              if (n >= localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.size()) {
                break label1729;
              }
              nrt.a(null, localqkk.jdField_d_of_type_JavaLangString, (String)localObject5, (String)localObject5, 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), ((qno)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(n)).jdField_a_of_type_Int + "", Integer.toString(localqkk.jdField_b_of_type_Int), (String)localObject1, false);
              n += 1;
              continue;
              localObject5 = localObject7;
              if (this.jdField_a_of_type_Int != 0) {
                continue;
              }
              localObject1 = this.jdField_a_of_type_Rqi;
              n = rqi.c((ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
              if ((n == 6) || (n == 66) || (n == 115) || (n == 28) || (n == 11) || (n == 26) || (n == 19)) {
                localObject1 = ntd.a(ntd.a((ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (String)localObject7);
              }
              for (;;)
              {
                localObject5 = localObject1;
                if (n != 6) {
                  break;
                }
                localObject1 = new ron((String)localObject1);
                ((ron)localObject1).ac(rdm.b());
                localObject5 = ((ron)localObject1).a().a();
                break;
                if ((n == 46) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isTwoItem))
                {
                  localObject1 = new ron((String)localObject7);
                  ((ron)localObject1).e(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoVid);
                  ((ron)localObject1).W(ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
                  ((ron)localObject1).a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
                  if (n == 46) {
                    ((ron)localObject1).x(0);
                  }
                  for (;;)
                  {
                    ((ron)localObject1).e(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
                    localObject1 = ((ron)localObject1).a().a();
                    break;
                    ((ron)localObject1).x(1);
                  }
                }
                if (n == 118)
                {
                  localObject1 = new ron((String)localObject7);
                  if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null)
                  {
                    ((ron)localObject1).aa(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int);
                    if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo != null) {
                      ((ron)localObject1).r(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_e_of_type_JavaLangString);
                    }
                  }
                  ((ron)localObject1).h(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
                  localObject1 = ((ron)localObject1).a().a();
                }
                else
                {
                  localObject1 = localObject7;
                  if (n == 128)
                  {
                    localObject1 = new ron((String)localObject7);
                    if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo != null)
                    {
                      ((ron)localObject1).aa(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.jdField_a_of_type_Int);
                      if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b != null) {
                        ((ron)localObject1).r(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSimpleVideoColumnInfo.b.jdField_e_of_type_JavaLangString);
                      }
                    }
                    ((ron)localObject1).h(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID);
                    localObject1 = ((ron)localObject1).a().a();
                  }
                }
              }
              paramBoolean = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isPGCShortContent();
              if ((!TextUtils.isEmpty(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData)) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.proteusItemsData.contains("article_main_body_text")))
              {
                n = 1;
                break label4433;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject7 = (szu)paramMap1.get(Long.valueOf(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID));
      if ((localObject7 == null) || (((szu)localObject7).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        break label761;
      }
      ((JSONObject)localObject1).put("main_text_read_time", ((szu)localObject7).jdField_a_of_type_Long);
      break label761;
      Object localObject2;
      localObject5 = "0X8007626";
      break label784;
      label1535:
      if (ors.l(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        if (ors.j(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          localObject2 = (BaseArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mGroupSubArticleList.get(0);
          localObject5 = szp.a(getContext(), ((BaseArticleInfo)localObject2).mArticleID, ((BaseArticleInfo)localObject2).mAlgorithmID, 54, this.jdField_a_of_type_Int, ((BaseArticleInfo)localObject2).getInnerUniqueID(), ((BaseArticleInfo)localObject2).getVideoVid(), szp.a((BaseArticleInfo)localObject2), ((BaseArticleInfo)localObject2).videoReportInfo);
          localObject2 = localObject5;
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
        }
      }
      label1729:
      int i1;
      long l2;
      for (;;)
      {
        try
        {
          localObject2 = new JSONObject((String)localObject5);
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.isShowGif)
          {
            ((JSONObject)localObject2).put("short_content_gif", 1);
            localObject2 = ((JSONObject)localObject2).toString();
            localObject5 = localObject2;
            if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {}
          }
        }
        catch (JSONException localJSONException1)
        {
          try
          {
            localObject5 = new JSONObject((String)localObject2);
            ((JSONObject)localObject5).put("account_expose_card", ors.c(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo));
            localObject5 = ((JSONObject)localObject5).toString();
            ors.b(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, (String)localObject5);
            if ((localqkk.jdField_c_of_type_Int == 48) || (localqkk.jdField_c_of_type_Int == 49) || (localqkk.jdField_c_of_type_Int == 50) || (localqkk.jdField_c_of_type_Int == 51) || (localqkk.jdField_c_of_type_Int == 52) || (localqkk.jdField_c_of_type_Int == 53) || (localqkk.jdField_c_of_type_Int == 78) || (localqkk.jdField_c_of_type_Int == 79) || (localqkk.jdField_c_of_type_Int == 80) || (localqkk.jdField_c_of_type_Int == 1005) || (localqkk.jdField_c_of_type_Int == 1006) || (localqkk.jdField_c_of_type_Int == 1007))
            {
              long l3 = localqkk.jdField_b_of_type_Long;
              n = localqkk.jdField_k_of_type_Int;
              i1 = opn.a(this.jdField_a_of_type_Int, localqkk.jdField_c_of_type_Int);
              i2 = opn.a(localqkk.jdField_c_of_type_Int);
              l1 = 0L;
              localObject2 = null;
              localObject5 = null;
              if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) {
                break label4415;
              }
              l1 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID;
              localObject2 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID;
              localObject5 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.galleryReprotExdData;
              l2 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID;
              label1947:
              localObject7 = opn.a(getContext(), ors.a(), i1, l1, l3, n, (String)localObject2, (String)localObject5, i2, this.jdField_a_of_type_Int);
              nrt.a(null, localqkk.jdField_d_of_type_JavaLangString, "0X8008E2E", "0X8008E2E", 0, 0, "", l1 + "", l2 + "", (String)localObject7, false);
              opn.a(7, ors.a(), (int)l2, i1, l3, n, (String)localObject2, (String)localObject5);
            }
            if (localqkk.jdField_c_of_type_Boolean) {}
            try
            {
              if (localqkk.jdField_d_of_type_Boolean)
              {
                localObject5 = ors.a();
                ((JSONObject)localObject5).put("feeds_source", localqkk.jdField_a_of_type_JavaLangString);
                ((JSONObject)localObject5).put("kandian_mode", ors.e());
                if (!szp.a(this.jdField_a_of_type_Int)) {
                  break label4344;
                }
                localObject2 = "0X8009358";
                label2126:
                nrt.a(null, "CliOper", "", "", (String)localObject2, (String)localObject2, 0, 0, ors.e(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), "", "", ((JSONObject)localObject5).toString(), false);
              }
            }
            catch (JSONException localJSONException2)
            {
              Object localObject3;
              Object localObject6;
              String str2;
              localJSONException2.printStackTrace();
              continue;
            }
            if (ors.k(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
              nrt.a(null, null, "0X80097D6", "0X80097D6", 0, 0, "", "", "", "", false);
            }
            if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null) || (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Nxe == null)) {
              break;
            }
            ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Nxe, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
            break;
            ((JSONObject)localObject2).put("short_content_gif", 0);
            continue;
            localJSONException1 = localJSONException1;
            QLog.e("ReadInJoyListViewGroup", 2, localJSONException1.getMessage());
            localObject3 = localObject5;
          }
          catch (JSONException localJSONException3)
          {
            QLog.e("ReadInJoyListViewGroup", 2, localJSONException3.getMessage());
            localObject6 = localObject3;
            continue;
          }
        }
        localObject3 = szp.a(getContext(), localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoAdsSource, localqkk.jdField_k_of_type_Int, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), 54, szp.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo);
        nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, "0X80091A8", "0X80091A8", 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID), Integer.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId), (String)localObject3, false);
        nrt.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", new ron(null, null, null, null).W(54).h(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()).x(localqkk.jdField_k_of_type_Int + 1).f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo).a().a(), false);
        continue;
        if (!ors.t(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
          break label2519;
        }
        ors.a(localqkk, (String)localObject3, (String)localObject6);
      }
      label2519:
      if (ors.s(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
        if (!localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean)
        {
          localObject7 = rqj.a();
          localObject3 = "0";
          if (localObject7 != null) {
            localObject3 = ((QQAppInterface)localObject7).c();
          }
          str2 = ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, 0, 0, bdin.h(getContext()), localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, null, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
          nrt.a(null, "CliOper", "", (String)localObject3, (String)localObject6, (String)localObject6, 0, 0, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", str2, false);
          localObject6 = szp.a(this.jdField_a_of_type_Int);
          if (localObject7 == null) {
            break label4424;
          }
          localObject3 = ((QQAppInterface)localObject7).c();
        }
      }
      label3901:
      label4415:
      label4421:
      label4424:
      for (;;)
      {
        localObject7 = ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mAlgorithmID, ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), this.jdField_a_of_type_Int, bdin.h(getContext()), localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSubscribeID, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.innerUniqueID, null, 0, localqkk.jdField_f_of_type_Int, (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        for (;;)
        {
          try
          {
            if (!this.jdField_b_of_type_Boolean) {
              continue;
            }
            n = 1;
            ((JSONObject)localObject7).put("from_aio", n);
          }
          catch (JSONException localJSONException4)
          {
            QLog.e("ReadInJoyListViewGroup", 2, localJSONException4.getMessage());
            continue;
          }
          localObject7 = ((JSONObject)localObject7).toString();
          nrt.a(null, "CliOper", "", (String)localObject3, (String)localObject6, (String)localObject6, 0, 0, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId + "", localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mArticleID + "", localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mStrategyId + "", (String)localObject7, false);
          break;
          n = 0;
        }
        if (!ors.n(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo)) {
          break label1729;
        }
        nrt.a(null, null, "0X8007626", "0X8007626", 0, 0, "", "", "", (String)localObject3, false);
        break label1729;
        if (ors.u(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 0)
          {
            ComponentContentRecommend.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
            break label1729;
          }
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int == 1)
          {
            ComponentContentRecommendFollowList.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
            break label1729;
          }
          if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendFollowInfos.jdField_a_of_type_Int != 2) {
            break label1729;
          }
          ComponentContentRecommendFollowGroup.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, this.jdField_a_of_type_Int);
          break label1729;
        }
        if (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedType == 33)
        {
          localObject3 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getProteusItemData();
          if (localObject3 == null) {
            break;
          }
          ors.a(false, (JSONObject)localObject3, localqkk);
          ors.a(true, (JSONObject)localObject3, localqkk);
          break label1729;
        }
        if (ors.q(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          ors.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, localqkk);
          break label1729;
        }
        if (ors.i(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))
        {
          localObject7 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
          localObject8 = ors.a(((BaseArticleInfo)localObject7).mPolymericInfo);
          nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, "0X8008F57", "0X8008F57", 0, 0, localqkk.jdField_k_of_type_Int + "", Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Long.toString(((BaseArticleInfo)localObject7).mPolymericInfo.jdField_d_of_type_Long), ((JSONObject)localObject8).toString(), false);
          if (localHashMap.containsKey(Long.valueOf(((BaseArticleInfo)localObject7).mPolymericInfo.jdField_c_of_type_Long))) {
            break label164;
          }
          localHashMap.put(Long.valueOf(((BaseArticleInfo)localObject7).mPolymericInfo.jdField_c_of_type_Long), Boolean.valueOf(true));
        }
        localObject7 = new ron((String)localObject3);
        ((ron)localObject7).a(Boolean.valueOf(ors.w(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo))).a(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.videoReportInfo).b(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        if (this.jdField_a_of_type_Int == 40677)
        {
          ((ron)localObject7).b(localqkk.jdField_j_of_type_Int);
          nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, "0X8009292", "0X8009292", 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ((ron)localObject7).a().a(), false);
          nrt.a("0X8009292", localqkk.jdField_d_of_type_JavaLangString, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(getContext()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, i2, localqkk.jdField_f_of_type_Int, localqkk.jdField_g_of_type_Int, localqkk.jdField_h_of_type_Int, localqkk.jdField_f_of_type_Boolean, localqkk.jdField_j_of_type_Int, localqkk.jdField_i_of_type_Int, localqkk.m));
          break label1729;
        }
        if (this.jdField_f_of_type_Int == 3)
        {
          i1 = -1;
          n = i1;
          if (this.jdField_a_of_type_Nwi != null)
          {
            n = i1;
            if ((this.jdField_a_of_type_Nwi instanceof nwj)) {
              n = ((nwj)this.jdField_a_of_type_Nwi).a();
            }
          }
          ((ron)localObject7).O(n);
        }
        ((ron)localObject7).a(localqkk.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        Object localObject9;
        if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean != null))
        {
          localObject8 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute(null);
          if ((localObject8 != null) && (((Map)localObject8).entrySet() != null))
          {
            localObject8 = ((Map)localObject8).entrySet().iterator();
            while ((localObject8 != null) && (((Iterator)localObject8).hasNext()))
            {
              localObject9 = (Map.Entry)((Iterator)localObject8).next();
              ((ron)localObject7).a((String)((Map.Entry)localObject9).getKey(), ((Map.Entry)localObject9).getValue().toString());
            }
          }
        }
        pwz.a((ron)localObject7, localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
        ors.a((String)localObject6, localqkk, (ron)localObject7);
        a((ron)localObject7);
        nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, (String)localObject6, (String)localObject6, 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ((ron)localObject7).a().a(), false);
        Object localObject8 = swt.a(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean);
        localObject7 = localObject3;
        if (localObject8 != null)
        {
          localObject9 = ((List)localObject8).iterator();
          localObject7 = localObject3;
          if (((Iterator)localObject9).hasNext()) {
            localObject8 = (String)((Iterator)localObject9).next();
          }
        }
        for (;;)
        {
          try
          {
            localObject7 = new JSONObject((String)localObject3);
            localObject8 = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mProteusTemplateBean.getDataAttribute((String)localObject8);
            if (localObject8 == null) {
              break label4421;
            }
            swt.a((JSONObject)localObject7, (Map)localObject8);
            localObject7 = ((JSONObject)localObject7).toString();
            localObject3 = localObject7;
          }
          catch (JSONException localJSONException5)
          {
            try
            {
              nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, (String)localObject6, (String)localObject6, 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), (String)localObject3, false);
            }
            catch (JSONException localJSONException6)
            {
              for (;;)
              {
                String str1;
                localObject7 = localJSONException2;
                Object localObject4 = localJSONException6;
              }
            }
            localJSONException5 = localJSONException5;
            localObject7 = localObject3;
            localObject3 = localJSONException5;
          }
          QLog.d("ReadInJoyListViewGroup", 1, "extra_expose", (Throwable)localObject3);
          localObject3 = localObject7;
          break label3901;
          nrt.a((String)localObject6, localqkk.jdField_d_of_type_JavaLangString, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ors.a(localqkk.jdField_a_of_type_Long, localqkk.jdField_c_of_type_Int, this.jdField_a_of_type_Int, localqkk.jdField_d_of_type_Int, localqkk.jdField_e_of_type_Int, bdin.h(getContext()), localqkk.jdField_a_of_type_JavaLangString, localqkk.jdField_c_of_type_JavaLangString, localqkk.jdField_e_of_type_JavaLangString, ors.f(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo), (ArticleInfo)localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo, l1, i2, localqkk.jdField_f_of_type_Int, localqkk.jdField_g_of_type_Int, localqkk.jdField_h_of_type_Int, localqkk.jdField_f_of_type_Boolean, localqkk.jdField_j_of_type_Int, localqkk.jdField_i_of_type_Int, localqkk.m));
          for (;;)
          {
            try
            {
              if ((Aladdin.get(250).getIntegerFromString("pj_enable", 0) != 1) || (otf.c(this.jdField_a_of_type_Int))) {
                break;
              }
              localObject3 = new orz(new JSONObject((String)localObject7));
              if (szp.b() <= 0) {
                break label4338;
              }
              n = 0;
              ((orz)localObject3).b("behavior_type", n);
              nrt.a(null, "CliOper", "", localqkk.jdField_d_of_type_JavaLangString, "0X800A9AF", "0X800A9AF", 0, 0, Long.toString(localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mFeedId), Long.toString(localqkk.jdField_a_of_type_JavaLangLong.longValue()), Integer.toString(localqkk.jdField_b_of_type_Int), ((orz)localObject3).a(), false);
            }
            catch (Exception localException2) {}
            break;
            label4338:
            n = 1;
          }
          label4344:
          str1 = "0X800744E";
          break label2126;
          if (this.jdField_a_of_type_Int != 40677) {
            e(paramMap);
          }
          szp.a(paramMap1, this.jdField_b_of_type_Boolean);
          rwj.a(((Integer)a().first).intValue());
          return;
          l2 = 0L;
          break label1947;
        }
      }
      label4427:
      break label810;
      label4430:
      break label557;
      label4433:
      if (!paramBoolean) {
        if (n == 0) {
          break label761;
        }
      }
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, qkk> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    a(new rsx(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Rqi != null) {
      this.jdField_a_of_type_Rqi.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Ore.jdField_b_of_type_Long = System.currentTimeMillis();
    if (i()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Ore.jdField_d_of_type_Long = bkbq.a((QQAppInterface)ors.a(), a());; this.jdField_a_of_type_Ore.jdField_d_of_type_Long = bkbq.a((QQAppInterface)ors.a(), this.jdField_a_of_type_Int))
    {
      q();
      syp.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!a()) {
        break;
      }
      return;
    }
    j();
  }
  
  public void a(pdi parampdi)
  {
    if (parampdi == null) {}
    for (;;)
    {
      return;
      int n = 0;
      while (n < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        parampdi.a((pdc)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(n)), ", jobName : ", parampdi.a(), ", cost : ", Long.valueOf(l2 - l1) });
        n += 1;
      }
    }
  }
  
  public void a(rjk paramrjk1, rjk paramrjk2)
  {
    this.jdField_h_of_type_Boolean = false;
    ((pde)a(2)).j();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, aepi.a(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131298612), 0, 0);
    }
  }
  
  public void a(sgo paramsgo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramsgo);
      this.jdField_a_of_type_Sgo = paramsgo;
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
      T();
    } while (!this.i);
    a(new rsz(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.16(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      n();
      pcv.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
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
            if ((((View)localObject).getTag() instanceof pdq))
            {
              localObject = (pdq)((View)localObject).getTag();
              i1 = paramInt;
              if (paramLong == ((pdq)localObject).jdField_a_of_type_Rjk.jdField_c_of_type_Long) {
                i1 = ((pdq)localObject).jdField_a_of_type_Int;
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
        this.jdField_a_of_type_Rqi.a(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Rqi.c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Nwi.a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + n + ", lastVisblePosi=" + i2 + "， headerCount=" + i1);
        }
        return;
        this.jdField_a_of_type_Rqi.a(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Rqi.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rqi == null)) {
      return;
    }
    a(new rth(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Rqi.getCount() == 0) {}
    int i1 = owy.a().a(Integer.valueOf(paramInt));
    if (this.i)
    {
      if ((paramList != null) && (i1 == 1)) {
        this.jdField_a_of_type_Rqi.c(0);
      }
      this.i = false;
    }
    pxe.a().a();
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
    if (!this.jdField_a_of_type_Rqi.i) {
      this.jdField_a_of_type_Rqi.jdField_h_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Rqi.i = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Rqi.i + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Rqi.jdField_h_of_type_Boolean);
    }
    raa.a().c(true);
    setAdapterData(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
    this.jdField_a_of_type_Rqi.a(0);
    if ((paramInt == 56) || (paramInt == 0))
    {
      localObject = ors.a();
      if (localObject != null) {
        ((ocq)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    if ((paramInt == 0) || (otf.c(this.jdField_a_of_type_Int))) {
      oxp.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
    b(paramBoolean1, i1);
    if (this.jdField_a_of_type_Int == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_Int == 56) && (this.k)) {
      if (this.jdField_a_of_type_Ojb != null) {
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
      if ((otf.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      a(paramList);
      b(paramList);
      AbstractGifImage.resumeAll();
      pcz.a(this.jdField_a_of_type_Rqi.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Rqi);
      ouk.a(this.jdField_a_of_type_Rqi.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Rqi.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131718913), getResources().getDrawable(2130848900));
        break;
      }
      a(getResources().getString(2131719007));
      break;
      if (!this.jdField_a_of_type_Rqi.isEmpty()) {
        break;
      }
      a(getResources().getString(2131718962));
      break;
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Rtx != null) {
      this.jdField_a_of_type_Rtx.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Rqi != null) {
      this.jdField_a_of_type_Rqi.a(2, null);
    }
    a(new rtq(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Rqi != null) {
      pcv.a(this.jdField_a_of_type_Rqi.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rqi == null) || (paramList == null)) {}
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
        raa.a().c(true);
        setAdapterData(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Rqi.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Rqi.isEmpty());
    a(getResources().getString(2131719007));
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
      paramReadInJoyBaseListView = ors.a();
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
      if ((this.jdField_a_of_type_Int == 40830) || (otf.c(this.jdField_a_of_type_Int)))
      {
        i1 = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (i1 + 1);
      }
      for (;;)
      {
        owy.a().a(this.jdField_a_of_type_Int, b(), paramInt, n, i1);
        ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.32(this));
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
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rqi == null))
    {
      this.jdField_d_of_type_Boolean = false;
      return;
    }
    a(new rti(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
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
        paramList = getResources().getString(2131718732);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      if ((otf.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
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
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Nwi.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Rqi == null)) {
      return;
    }
    this.jdField_a_of_type_Rqi.b(owy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Rqi.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, qkk> paramMap)
  {
    a(new rsw(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Nxo != null) {
      this.jdField_a_of_type_Nxo.a(paramMap);
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
    a(new rte(this, "onPause"));
    if (this.jdField_a_of_type_Rqi != null) {
      this.jdField_a_of_type_Rqi.k();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sdu)localIterator.next()).d();
    }
    I();
    long l1 = System.currentTimeMillis();
    J();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.e();
    }
    pcv.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void d(Map<Integer, qkk> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        qkk localqkk = (qkk)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int i1 = ojb.jdField_b_of_type_Int;
        if ((localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int n = localqkk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; n = 0)
        {
          ojb.a("0X8009495", localTabChannelCoverInfo, i1, n, -1);
          break;
        }
      }
    }
  }
  
  public boolean d()
  {
    return a().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    ouk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    a(new rtf(this, "onStart"));
    pxe.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.i)) {
      a(1500, new ReadInJoyListViewGroup.25(this));
    }
  }
  
  public boolean e()
  {
    Boolean localBoolean = (Boolean)a(new rtu(this, "onBackPressed"));
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
    a(new rtg(this, "onStop"));
    if ((i()) && (j()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rqi.b(0);
      if (localArticleInfo != null) {
        owy.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    pxe.a().c();
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
    a(new rta(this, "onDestroy"));
    bkbq.a(System.currentTimeMillis(), (QQAppInterface)ors.a());
    Object localObject = ((oxd)ors.a().getManager(163)).a().a();
    if (localObject != null) {
      ((pfo)localObject).b(this.jdField_g_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Altm);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Rqi.d();
    this.jdField_a_of_type_Rqi.a();
    this.jdField_a_of_type_Rqi.a(null);
    this.jdField_a_of_type_Rqi = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      ouk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.d();
      this.jdField_a_of_type_Bdbb = null;
    }
    if (this.jdField_a_of_type_Oxe != null) {
      oxb.a().b(this.jdField_a_of_type_Oxe);
    }
    bkbq.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Ojb != null)
    {
      this.jdField_a_of_type_Ojb.a();
      this.jdField_a_of_type_Ojb = null;
    }
    if (this.jdField_a_of_type_Rwn != null)
    {
      this.jdField_a_of_type_Rwn.b();
      this.jdField_a_of_type_Rwn = null;
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((sdu)((Iterator)localObject).next()).b();
    }
    ((KandianMergeManager)ors.a().getManager(162)).b(this.jdField_a_of_type_Owq);
    this.jdField_a_of_type_Owq = null;
    szl.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
    if (this.jdField_a_of_type_Noq != null) {
      this.jdField_a_of_type_Noq.b();
    }
    pcv.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (otf.c(a())) {
      osc.a().b();
    }
    qjz.b(a());
    if (this.jdField_a_of_type_Oik != null) {
      this.jdField_a_of_type_Oik.a();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
    ((KandianMergeManager)ors.a().getManager(162)).b(this.jdField_a_of_type_Owq);
  }
  
  public void l()
  {
    this.jdField_h_of_type_Boolean = true;
    ((pde)a(2)).i();
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
    rjg localrjg = this.jdField_a_of_type_Nwi.a();
    if ((localrjg != null) && (localrjg.a() != null)) {
      localrjg.b(11);
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
    default: 
      return;
    }
    P();
    ors.b(3);
    a(true, 3, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_Rqi.getItem((int)paramLong);
    ArticleInfo localArticleInfo = null;
    if ((localObject instanceof ArticleInfo))
    {
      localArticleInfo = (ArticleInfo)localObject;
      if (!ors.r(localArticleInfo)) {}
    }
    do
    {
      do
      {
        return;
      } while (localArticleInfo.mFeedType == 20);
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick pos : " + paramInt + ", id : " + paramLong + ", data : " + localArticleInfo);
      a(paramAdapterView, localArticleInfo, paramView, paramInt, paramLong);
    } while (localArticleInfo == null);
    localArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Rqi != null) {
      this.jdField_a_of_type_Rqi.notifyDataSetChanged();
    }
  }
  
  public void q()
  {
    if (ors.k() == 0) {}
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.41(this));
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Sgo);
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
    Object localObject2 = this.jdField_a_of_type_Rqi.a().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = peo.a().a(this.jdField_a_of_type_Int, paramList, (List)localObject1, paramInt);
    if ((this.jdField_a_of_type_Int == 0) || (otf.b(otf.b()))) {
      this.jdField_a_of_type_Rqi.a(true);
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
    this.jdField_a_of_type_Rqi.a(paramList);
    this.jdField_a_of_type_Rqi.notifyDataSetChanged();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setNotifyEndRefresh(rtx paramrtx)
  {
    this.jdField_a_of_type_Rtx = paramrtx;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!qiu.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
    sgm localsgm = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localsgm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!qiu.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
      localsgm = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      r();
      localsgm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    sgm localsgm = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    r();
    localsgm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(alud.a(2131713343));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */