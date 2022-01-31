package com.tencent.biz.pubaccount.readinjoy.view;

import aciy;
import ajjh;
import ajjy;
import ajuq;
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
import android.text.SpannableString;
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
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqnv;
import aqod;
import azwg;
import badq;
import bady;
import baig;
import bbmy;
import begh;
import behi;
import behj;
import bepb;
import bgmq;
import bjeh;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
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
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
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
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import naw;
import nbe;
import ndn;
import new;
import nho;
import nhr;
import nhw;
import nia;
import nik;
import njc;
import nji;
import nmv;
import nny;
import nti;
import nvx;
import nzv;
import oab;
import oag;
import oaz;
import obj;
import obl;
import obv;
import obz;
import ocj;
import odi;
import odm;
import oel;
import ogq;
import ogy;
import ohb;
import ohd;
import ohe;
import ohp;
import oid;
import oie;
import omf;
import omj;
import oml;
import omn;
import omq;
import omr;
import omz;
import onj;
import onu;
import oox;
import opa;
import oph;
import org.json.JSONException;
import org.json.JSONObject;
import oyc;
import pdg;
import pes;
import pez;
import pmu;
import pmv;
import pnh;
import pol;
import pov;
import ppu;
import ppv;
import ppy;
import ppz;
import pqb;
import pqg;
import pqh;
import pqo;
import prd;
import pre;
import prg;
import pri;
import prk;
import pyu;
import pyw;
import qcn;
import qhp;
import qht;
import qik;
import qjd;
import qji;
import qmu;
import qmv;
import qod;
import qoe;
import qpg;
import qph;
import qpi;
import qpj;
import qpp;
import qqm;
import qqp;
import qqq;
import qqr;
import qqs;
import qqt;
import qqu;
import qqw;
import qqx;
import qqy;
import qra;
import qrb;
import qrc;
import qrd;
import qre;
import qrf;
import qrg;
import qrh;
import qri;
import qrj;
import qrk;
import qrl;
import qrn;
import qro;
import qrp;
import qrq;
import qrr;
import qrs;
import que;
import qug;
import qui;
import qzk;
import rbf;
import rbg;
import rbu;
import rec;
import ree;
import rjb;
import rtr;
import ruf;
import rup;
import rvb;
import rvf;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import xcu;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, behi, behj, qjd, qpg, qph, qpi, qpj, qpp
{
  private long jdField_a_of_type_Long;
  private ajjh jdField_a_of_type_Ajjh = new qrq(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<oml> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected azwg a;
  private begh jdField_a_of_type_Begh = new qqm(this);
  private bepb jdField_a_of_type_Bepb = new qrl(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private naw jdField_a_of_type_Naw;
  private njc jdField_a_of_type_Njc;
  nti jdField_a_of_type_Nti;
  private ogq jdField_a_of_type_Ogq = new qro(this);
  private ohe jdField_a_of_type_Ohe;
  private pyu jdField_a_of_type_Pyu;
  private qod jdField_a_of_type_Qod;
  qrs jdField_a_of_type_Qrs;
  private qui jdField_a_of_type_Qui;
  private ree jdField_a_of_type_Ree;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ChannelTopPositionView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  List<KandianProgressView> jdField_b_of_type_JavaUtilList = new ArrayList();
  Map<String, KandianProgressView> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 1;
  private long jdField_c_of_type_Long = -1L;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private List<rbg> jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long = -1L;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = -1;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  
  public ReadInJoyListViewGroup(nhw paramnhw, int paramInt1, int paramInt2, int paramInt3, obl paramobl)
  {
    this(paramnhw, paramInt1, paramInt2, paramInt3, paramobl, 2131494457);
  }
  
  public ReadInJoyListViewGroup(nhw paramnhw, int paramInt1, int paramInt2, int paramInt3, obl paramobl, int paramInt4)
  {
    super(paramnhw, paramInt1, paramobl);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_e_of_type_Boolean = qcn.a();
    setId(2131309068);
    this.jdField_a_of_type_AndroidUtilSparseArray = omq.a(this);
    b(paramInt1);
    E();
    if (paramInt1 != 41695) {
      C();
    }
    this.jdField_a_of_type_Obl.jdField_c_of_type_Long = bgmq.a((QQAppInterface)obz.a());
    a(new qqx(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(nhw paramnhw, int paramInt1, int paramInt2, obl paramobl)
  {
    this(paramnhw, paramInt1, paramInt2, -1, paramobl);
  }
  
  public ReadInJoyListViewGroup(nhw paramnhw, int paramInt, obl paramobl)
  {
    this(paramnhw, paramInt, -1, paramobl);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Pyu = pyu.a();
    this.jdField_a_of_type_Pyu.a(this.jdField_e_of_type_Long);
    if (this.jdField_a_of_type_Int == 56)
    {
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      new.jdField_a_of_type_Int = new.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Nhw.a() != null)
    {
      this.jdField_a_of_type_Qod.a(this.jdField_a_of_type_Nhw.a(), this.jdField_a_of_type_Pyu);
      return;
    }
    this.jdField_a_of_type_Qod.b();
  }
  
  private void B()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qod.a();
    int k;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label220;
      }
      k = qoe.c(localArticleInfo);
      if ((k != 6) && (k != 71)) {
        break label177;
      }
      this.jdField_e_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      oaz.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
      c(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Naw = new naw(a(), true, this, this.jdField_a_of_type_Qod);
      this.jdField_a_of_type_Qod.a(this.jdField_a_of_type_Naw);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.7(this));
      return;
      label177:
      if (k == 28)
      {
        k = bgmq.e(obz.a());
        oaz.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int, 0, k);
        c(k);
        continue;
        label220:
        this.jdField_a_of_type_Qod.i();
      }
    }
  }
  
  private void C()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.9(this), 3000L);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnTouchListener(new nho(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView));
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!bgmq.k()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rbg)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jdField_c_of_type_JavaUtilList.add(new rbu(getContext()));
      continue;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (bgmq.A(obz.a()) != 2)
        {
          this.jdField_a_of_type_Nti = new nti(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_Nti.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_c_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(a()));
      }
      else if ((this.jdField_a_of_type_Int == 41523) && (bgmq.B(obz.a()) != 1))
      {
        this.jdField_a_of_type_Nti = new nti(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Nti.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Nti.a());
      }
    }
  }
  
  private void G()
  {
    if (ReadinjoyJumpActivity.a(a().getIntent())) {
      ReadinjoyJumpActivity.a(a(), a().getIntent(), 500L);
    }
  }
  
  private void H()
  {
    if (bgmq.a(b())) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_Int == 56) {
      ogy.a().a(56);
    }
  }
  
  private void I()
  {
    boolean bool = this.jdField_a_of_type_Nhw.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((b()) && (!bool) && ((!bgmq.i()) || ((this.jdField_a_of_type_Nhw.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      o();
      M();
    }
    if (((!bgmq.i()) || ((this.jdField_a_of_type_Nhw.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      new.jdField_a_of_type_Int = new.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      this.j = false;
      this.i = false;
      this.jdField_a_of_type_Nhw.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Nhw.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Nhw.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Nhw.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((bgmq.j()) && ((this.jdField_a_of_type_Nhw.a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        ohd localohd = (ohd)obz.a().getManager(163);
        localohd.a().a(this.jdField_a_of_type_Int, localParcelable);
        localohd.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
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
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      Parcelable localParcelable = ((ohd)obz.a().getManager(163)).a().a(this.jdField_a_of_type_Int);
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
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
  }
  
  private void M()
  {
    if (b())
    {
      if (this.jdField_a_of_type_Nhw.a().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label66;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label66:
    label707:
    label714:
    for (;;)
    {
      return;
      long l = this.jdField_a_of_type_Nhw.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int k = this.jdField_a_of_type_Nhw.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Qod.a();
      if ((k == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label714;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = ogy.a().a(Integer.valueOf(56));
        List localList = a().a();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = ogy.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label707;
          }
          Iterator localIterator = ((List)localObject2).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)localIterator.next();
          } while (((ArticleInfo)localObject2).mArticleID != l);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            ogy.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l = Long.valueOf(((BaseArticleInfo)localList.get(0)).mRecommendSeq).longValue();
          localArticleInfo.mRecommendSeq = (1L + l);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          ogy.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Qod.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Qod);
          if (this.jdField_a_of_type_Nti == null) {}
          for (k = 0;; k = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(k, 0);
            this.jdField_a_of_type_Qod.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, qoe.jdField_b_of_type_Int);
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
    int m = this.jdField_a_of_type_Qod.getCount();
    if (m > 0)
    {
      int k = 0;
      while (k < m)
      {
        Object localObject = this.jdField_a_of_type_Qod.getItem(k);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        k += 1;
      }
    }
  }
  
  private void P()
  {
    Object localObject = this.jdField_a_of_type_Qod.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = rtr.b((QQAppInterface)obz.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = rtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        rtr.a(((BaseActivity)this.jdField_a_of_type_Nhw.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131306882);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    R();
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_Int == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131309101));
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(0);
      }
    }
  }
  
  private void S()
  {
    try
    {
      if (this.jdField_a_of_type_Qui != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Qui.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Qui = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void T()
  {
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131306886));
    if (odm.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131306885));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131306884));
  }
  
  private void U()
  {
    if ((pes.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.jdField_h_of_type_Boolean))
    {
      a(true, 0, false);
      this.jdField_h_of_type_Boolean = true;
      return;
    }
    pes.a().a();
  }
  
  private long a()
  {
    if ((h()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)a().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l;
        }
      }
    }
    return -1L;
  }
  
  private Pair<Integer, Long> a()
  {
    long l2 = 0L;
    int m = 0;
    int k = 0;
    int n = -1;
    if ((getContext() instanceof ReadInJoyNewFeedsActivity))
    {
      if (((ReadInJoyNewFeedsActivity)getContext()).a() > 0L)
      {
        l1 = ((ReadInJoyNewFeedsActivity)getContext()).a();
        if (!((ReadInJoyNewFeedsActivity)getContext()).a()) {
          break label97;
        }
      }
      label97:
      for (k = 0;; k = 1)
      {
        return new Pair(Integer.valueOf(k), Long.valueOf(l1));
        l1 = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)getContext()).b();
        break;
      }
    }
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if ((getContext() instanceof SplashActivity))
    {
      localReadinjoyTabFrame = obz.a(getContext());
      if (localReadinjoyTabFrame == null) {
        break label185;
      }
      if (localReadinjoyTabFrame.jdField_b_of_type_Int == 0) {}
    }
    label134:
    for (long l1 = localReadinjoyTabFrame.a();; l1 = 0L)
    {
      break;
      k = 1;
      break label134;
      k = n;
      l1 = l2;
      if (!odm.c(this.jdField_a_of_type_Int)) {
        break;
      }
      if (oab.b() != 0) {}
      for (k = m;; k = 1)
      {
        l1 = l2;
        break;
      }
      label185:
      k = -1;
    }
  }
  
  private LinearLayout a()
  {
    if (odm.c(this.jdField_a_of_type_Int)) {
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
    ppv localppv = (ppv)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localppv.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localppv.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localppv.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localppv.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localppv.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localppv.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localppv.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localppv.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localppv.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  private void a(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.47(this, paramRunnable), paramInt);
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
    localIntent.putExtra("channel_name", ajjy.a(2131647277));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!qoe.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = qoe.c(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label260;
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
      new.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, new.b());
      qji.a().a(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label260:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(View paramView)
  {
    if ((a() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)a()).b(paramView);
    }
    for (;;)
    {
      return;
      if (bgmq.i()) {
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
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131299031);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131100738));
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
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131100738));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      obz.a(a(), paramArticleInfo, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Qod.a(this.jdField_a_of_type_Qod.a(), paramArticleInfo.mArticleID)) {}
      obz.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", obz.f(0));
        obz.a(getContext(), str, localBundle);
        nzv.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Qod);
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
    if (obz.s(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    qht localqht = new qht();
    localqht.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localqht.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localqht.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localqht.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localqht.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localqht.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localqht.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    pqb localpqb = new pqb();
    localpqb.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localpqb.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!qoe.a(paramArticleInfo)) && (!qoe.i(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) || ((!qoe.q(paramArticleInfo)) || ((obz.l(paramArticleInfo)) && (!qoe.q(paramArticleInfo)))))
    {
      localqht.jdField_f_of_type_Int = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_f_of_type_Int;
      localqht.jdField_c_of_type_Int = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_a_of_type_Int;
      localqht.jdField_d_of_type_Int = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_b_of_type_Int;
      localpqb.jdField_a_of_type_Int = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_f_of_type_Int;
      localqht.jdField_b_of_type_Int = ((int)(((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_a_of_type_Long / 1000L));
      localqht.jdField_b_of_type_JavaLangString = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_d_of_type_JavaLangString;
      localqht.jdField_j_of_type_JavaLangString = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_g_of_type_JavaLangString;
      localqht.jdField_c_of_type_JavaLangString = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((obz.i(paramArticleInfo)) && (obz.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localqht.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localpqb.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localqht.a = localpqb;
        localqht.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localqht.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localqht.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localqht.jdField_h_of_type_Int = localObject[0];
          localqht.jdField_i_of_type_Int = localObject[1];
          localqht.jdField_j_of_type_Int = paramView.getWidth();
          localqht.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = obj.a(3, this.jdField_a_of_type_Int);
            int k = localqht.jdField_h_of_type_Int;
            localqht.jdField_h_of_type_Int = ((localqht.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + k);
            localqht.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
        }
        localObject = new pqh();
        ((pqh)localObject).jdField_a_of_type_Int = 409409;
        if ((!qzk.a().b()) || (this.jdField_a_of_type_Int != 56)) {
          break label834;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        new.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, (pqh)localObject);
      }
      ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Qod.notifyDataSetChanged();
      return;
      localqht.jdField_b_of_type_JavaLangString = ((prg)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.b.get(0)).jdField_d_of_type_JavaLangString;
      break label403;
      if ((obz.i(paramArticleInfo)) && (obz.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localqht.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localqht.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localqht.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localqht.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localqht.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localpqb.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localqht.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localqht.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localqht.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localqht.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localqht.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label834:
      this.jdField_a_of_type_Qod.a(localqht, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (qcn.b(a(), paramArticleInfo)))
    {
      a(paramArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) || (obz.i(paramArticleInfo)) || (obz.m(paramArticleInfo)) || (obz.n(paramArticleInfo)))
    {
      if (obz.n(paramArticleInfo)) {
        a(paramArticleInfo, (ppv)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView);
      }
      for (;;)
      {
        ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Qod.notifyDataSetChanged();
        }
        if (!obz.l(paramArticleInfo)) {
          break;
        }
        paramView = rvf.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, rvf.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        ndn.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        obz.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Qod, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        a(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new pqh();
        paramView.jdField_a_of_type_Int = paramInt1;
        new.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((qoe.c(paramArticleInfo) == 6) || (qoe.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Qod.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      nji.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (bgmq.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Qod, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
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
  
  private void a(ArticleInfo paramArticleInfo, ppv paramppv, View paramView)
  {
    qht localqht = new qht();
    if (paramppv.jdField_a_of_type_Ppy == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localqht.jdField_c_of_type_Long = paramppv.jdField_a_of_type_Long;
      localqht.jdField_h_of_type_JavaLangString = (paramppv.jdField_a_of_type_Ppy.jdField_b_of_type_Long + "");
      localqht.jdField_i_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_d_of_type_JavaLangString;
      localqht.jdField_k_of_type_JavaLangString = paramppv.jdField_e_of_type_JavaLangString;
      localqht.jdField_g_of_type_Int = paramppv.jdField_a_of_type_Int;
      localqht.jdField_g_of_type_Long = paramppv.jdField_b_of_type_Long;
      Object localObject = new pqb();
      ((pqb)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramppv.jdField_a_of_type_Long);
      ((pqb)localObject).jdField_a_of_type_JavaLangString = paramppv.jdField_g_of_type_JavaLangString;
      ((pqb)localObject).jdField_a_of_type_Int = paramppv.jdField_a_of_type_Ppy.jdField_a_of_type_Int;
      ((pqb)localObject).jdField_b_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_a_of_type_JavaLangString;
      localqht.a = ((pqb)localObject);
      localqht.jdField_b_of_type_JavaLangString = paramppv.jdField_c_of_type_JavaLangString;
      localqht.jdField_c_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_a_of_type_JavaLangString;
      localqht.jdField_f_of_type_Int = paramppv.jdField_a_of_type_Ppy.jdField_a_of_type_Int;
      localqht.jdField_c_of_type_Int = paramppv.jdField_a_of_type_Ppy.jdField_b_of_type_Int;
      localqht.jdField_d_of_type_Int = paramppv.jdField_a_of_type_Ppy.jdField_c_of_type_Int;
      localqht.jdField_b_of_type_Int = paramppv.jdField_a_of_type_Ppy.jdField_d_of_type_Int;
      localqht.jdField_e_of_type_Long = paramppv.jdField_a_of_type_Ppy.jdField_a_of_type_Long;
      localqht.jdField_j_of_type_JavaLangString = paramppv.jdField_g_of_type_JavaLangString;
      localqht.jdField_g_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_b_of_type_JavaLangString;
      localqht.jdField_d_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_f_of_type_JavaLangString;
      localqht.jdField_e_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_e_of_type_JavaLangString;
      localqht.jdField_f_of_type_JavaLangString = paramppv.jdField_a_of_type_Ppy.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localqht.jdField_h_of_type_Int = localObject[0];
        localqht.jdField_i_of_type_Int = localObject[1];
        localqht.jdField_j_of_type_Int = paramView.getWidth();
        localqht.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = obj.a(3, this.jdField_a_of_type_Int);
          int k = localqht.jdField_h_of_type_Int;
          localqht.jdField_h_of_type_Int = ((localqht.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + k);
          localqht.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new pqh();
      ((pqh)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_Qod.a(localqht, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        new.a(paramppv.jdField_a_of_type_Long, paramppv.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Int, (int)paramppv.jdField_b_of_type_Long, paramppv.jdField_a_of_type_Int, 24, -1L, (pqh)localObject, -1, paramppv.jdField_k_of_type_JavaLangString);
      }
      ogy.a().a(paramppv.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Qod.notifyDataSetChanged();
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Qui == null)
    {
      if (obz.k() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Qui = new qug(a(), LayoutInflater.from(getContext()).inflate(2131494455, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Qui.a(new qrp(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Qui.a());
      this.jdField_a_of_type_Qui.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Qui.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (obz.k() == 2) {
        this.jdField_a_of_type_Qui = new que(a());
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131306882).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131305061)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131309025));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131309024));
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
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aciy.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = aciy.a(10.0F, getResources()))
    {
      R();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130838992));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101146));
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (odm.c(this.jdField_a_of_type_Int)) {}
    for (int k = 2;; k = 1)
    {
      rup.a(localContext, k, new ReadInJoyListViewGroup.38(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = oag.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (pol.a(str)) {
        obz.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        qcn.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_Qod.b())) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    boolean bool3;
    boolean bool6;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Qod.getCount() == 0)
    {
      bool3 = true;
      bool6 = nia.a(this.jdField_a_of_type_Int);
      if (!h()) {
        break label775;
      }
      localObject2 = ((BaseActivity)a()).app;
      localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
      if ((this.jdField_a_of_type_Int != 70) && (!odm.c(this.jdField_a_of_type_Int))) {
        break label613;
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
        l1 = ((Integer)bgmq.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
        if (odm.a(this.jdField_a_of_type_Int)) {
          l1 = b();
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Obl.jdField_d_of_type_Long <= l1) {
          break label690;
        }
        bool4 = true;
        bool7 = i();
        if ((!b()) || (this.j)) {
          break label696;
        }
        bool2 = true;
        if ((!bgmq.j()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L) || (!((KandianMergeManager)localObject1).g())) {
          break label702;
        }
        bool5 = true;
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5)) {
          break label708;
        }
        bool1 = true;
        label275:
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
        if (!a()) {
          break label720;
        }
        bool4 = nia.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!bool6)) {
          break label714;
        }
        bool1 = true;
        label422:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool6) }));
        paramBoolean = bool1;
      }
      int k;
      for (;;)
      {
        QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
        if ((!paramBoolean) && (!omj.a(this.jdField_a_of_type_Int))) {
          break label1327;
        }
        k = 1;
        label551:
        if (k == 0) {
          break label1341;
        }
        if ((this.jdField_a_of_type_Int == 0) || (odm.c(this.jdField_a_of_type_Int))) {
          ohp.a().a.jdField_a_of_type_Boolean = true;
        }
        if ((!odm.c(this.jdField_a_of_type_Int)) || (odm.a())) {
          break label1332;
        }
        a(true, 1, false);
        label605:
        return true;
        bool3 = false;
        break;
        label613:
        if (this.jdField_a_of_type_Int == 40677)
        {
          localObject2 = (oie)((QQAppInterface)localObject2).getManager(274);
          if ((((oie)localObject2).a() != null) && (((oie)localObject2).a().size() > 0)) {}
          for (paramBoolean = true;; paramBoolean = false) {
            break;
          }
        }
        if (this.jdField_a_of_type_Int != 40830) {
          break label1396;
        }
        paramBoolean = true;
        break label113;
        l1 = 300000L;
        break label147;
        label690:
        bool4 = false;
        break label183;
        label696:
        bool2 = false;
        break label206;
        label702:
        bool5 = false;
        break label243;
        label708:
        bool1 = false;
        break label275;
        label714:
        bool1 = false;
        break label422;
        label720:
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
              if (!odm.c(this.jdField_a_of_type_Int)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
      label775:
      localObject1 = ((BaseActivity)a()).app;
      localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
      label815:
      boolean bool8;
      label836:
      label855:
      int m;
      if (bgmq.a((QQAppInterface)localObject1))
      {
        bool1 = ((KandianMergeManager)localObject2).b();
        bool8 = a() instanceof ReadInJoyNewFeedsActivity;
        if (!bool8) {
          break label1125;
        }
        l1 = bgmq.h((AppRuntime)localObject1);
        if (System.currentTimeMillis() - this.jdField_a_of_type_Obl.jdField_c_of_type_Long <= l1) {
          break label1135;
        }
        k = 1;
        localObject1 = a().getIntent();
        bool7 = ((Intent)localObject1).getBooleanExtra("from_search", false);
        if ((!d()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
          break label1140;
        }
        bool4 = true;
        label897:
        if (d()) {
          ((Intent)localObject1).removeExtra("force_refresh");
        }
        if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
          break label1146;
        }
        m = 1;
        label933:
        if (!a()) {
          break label1157;
        }
        bool5 = nia.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool1) && (!bool7) && (!bool5) && (m == 0) && (!bool4) && (!bool6)) {
          break label1151;
        }
        bool2 = true;
        label986:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool6) }));
        if (!bool3) {
          break label1293;
        }
        k = 1;
      }
      for (;;)
      {
        if (bool2) {
          obz.b(k);
        }
        paramBoolean = bool2;
        break;
        localObject2 = b();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          bool1 = true;
          break label815;
        }
        bool1 = false;
        break label815;
        label1125:
        l1 = bgmq.g((AppRuntime)localObject1);
        break label836;
        label1135:
        k = 0;
        break label855;
        label1140:
        bool4 = false;
        break label897;
        label1146:
        m = 0;
        break label933;
        label1151:
        bool2 = false;
        break label986;
        label1157:
        if ((bool3) || (bool1) || (bool7) || ((k != 0) && (paramBoolean)) || (m != 0) || (bool4))
        {
          bool2 = true;
          label1192:
          if ((k == 0) || (!paramBoolean)) {
            break label1287;
          }
        }
        label1287:
        for (bool5 = true;; bool5 = false)
        {
          QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4) }));
          break;
          bool2 = false;
          break label1192;
        }
        label1293:
        if (bool1)
        {
          k = 1;
        }
        else if (bool7)
        {
          k = 1;
        }
        else
        {
          if ((k != 0) && (paramBoolean))
          {
            k = 6;
            continue;
            label1327:
            k = 0;
            break label551;
            label1332:
            a(true, 2);
            break label605;
            label1341:
            localObject1 = this.jdField_a_of_type_Obl;
            if (this.jdField_a_of_type_Obl.jdField_a_of_type_Long == 0L) {}
            for (l1 = l2;; l1 = this.jdField_a_of_type_Obl.jdField_a_of_type_Long)
            {
              ((obl)localObject1).jdField_a_of_type_Long = l1;
              if (this.jdField_a_of_type_Int == 0) {}
              return false;
            }
          }
          k = 1;
        }
      }
      label1396:
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
      int k = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int m = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(k), ", refreshInterval = ", Integer.valueOf(m) });
      l1 = l2;
      if (k == 1) {
        l1 = m * 60 * 1000;
      }
    }
    QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private List<Long> b()
  {
    Intent localIntent = this.jdField_a_of_type_Nhw.a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int k = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Int == k) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131310904));
    if (paramInt == 41695) {
      D();
    }
    if (odm.c(this.jdField_a_of_type_Int)) {
      ocj.a().a();
    }
    this.jdField_a_of_type_Azwg = new azwg(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Qod = new qod(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Azwg, this.jdField_a_of_type_AndroidUtilSparseArray);
    a(new qrf(this, "onListViewGroupInit"));
    T();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Nhw + a());
    }
    y();
    x();
    A();
    z();
    Q();
    F();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Ajjh);
    ((KandianMergeManager)obz.a().getManager(162)).a(this.jdField_a_of_type_Ogq);
    B();
    w();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131494257, this, false));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131494258, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    obz.a(a(), paramArticleInfo, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
    ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Qod.notifyDataSetChanged();
    obz.a(a(), paramArticleInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      obz.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((qoe.d(paramArticleInfo)) && (qoe.c(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    obz.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (ppv)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView);
  }
  
  private void b(List<Long> paramList)
  {
    Object localObject = obz.a();
    if ((!bgmq.y((AppRuntime)localObject)) || (!bgmq.z((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int k = 5;; k = paramList.size())
    {
      localObject = new ArrayList();
      int m = 0;
      while (m < k)
      {
        long l = ((Long)paramList.get(m)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Qod.a(this.jdField_a_of_type_Int, l);
        if ((localBaseArticleInfo != null) && (!obz.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        m += 1;
      }
    }
    ogy.a().a().a((List)localObject);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qqu(this));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void b(boolean paramBoolean, int paramInt)
  {
    if (f())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.h();
      return;
    }
    String str;
    if (this.jdField_a_of_type_Int == 70) {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131652645);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      N();
      if (!bgmq.i()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.29(this), 1500L);
      return;
      str = getResources().getString(2131652644);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131652508), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131652507);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131652508), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131652506);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131652508), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131652507);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!odi.b()) {
      ohb.a().n();
    }
    this.jdField_a_of_type_Obl.jdField_a_of_type_Long = System.currentTimeMillis();
    bgmq.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Obl.jdField_a_of_type_Long, (QQAppInterface)obz.a());
    Object localObject1 = null;
    Object localObject8 = null;
    Object localObject4 = null;
    long l3 = 0L;
    long l4 = 0L;
    Object localObject2 = null;
    ogy localogy = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    Object localObject7 = null;
    Bundle localBundle = null;
    int k = -1;
    QQAppInterface localQQAppInterface = ((BaseActivity)a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == opa.a()))
    {
      if (!this.jdField_a_of_type_Obl.jdField_a_of_type_Boolean) {
        break label2245;
      }
      localObject1 = b();
      bool3 = g();
      this.jdField_a_of_type_Obl.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) == 8)
      {
        bool1 = true;
        localObject5 = (LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo");
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (;;)
    {
      long l1;
      long l2;
      int m;
      if (localObject1 == null)
      {
        localObject2 = localKandianMergeManager.a();
        if ((localObject2 != null) && (((List)localObject2).size() > 2))
        {
          l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
          l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
          localObject2 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
          localObject1 = localKandianMergeManager.a();
          k = 1;
          localObject4 = localObject1;
          localObject6 = localObject2;
          if (c())
          {
            localObject8 = localKandianMergeManager.a();
            localObject4 = localObject1;
            localObject6 = localObject2;
            if (localObject8 != null)
            {
              localObject7 = ((KandianRedDotInfo)localObject8).articleIDList;
              localObject4 = localObject1;
              localObject6 = localObject2;
              if (localObject7 != null)
              {
                localObject4 = localObject1;
                localObject6 = localObject2;
                if (((List)localObject7).size() > 0)
                {
                  localObject6 = new ArrayList();
                  localObject4 = ((KandianRedDotInfo)localObject8).cookie;
                  m = ((List)localObject7).size() - 1;
                  for (;;)
                  {
                    if (m >= 0)
                    {
                      ((List)localObject6).add(0, (Long)((List)localObject7).get(m));
                      m -= 1;
                      continue;
                      bool1 = false;
                      break;
                    }
                  }
                }
              }
            }
          }
          localKandianMergeManager.f();
          localKandianMergeManager.e();
          localObject1 = localObject6;
          localObject2 = localObject4;
        }
      }
      for (;;)
      {
        localObject4 = localKandianMergeManager.a();
        localKandianMergeManager.k();
        if (obz.f())
        {
          obz.a(false);
          localObject6 = localObject2;
          l3 = l2;
          m = 32;
          localObject7 = localObject5;
          l2 = l1;
          l1 = l3;
          localObject2 = localObject1;
          localObject1 = localObject6;
        }
        for (;;)
        {
          int n;
          if (this.jdField_a_of_type_Int == 40830)
          {
            localObject8 = a().getIntent();
            localObject6 = localObject1;
            n = k;
            localObject5 = localObject2;
            if (localObject8 != null)
            {
              localObject9 = (ReadInJoyChannelActivity.SerializableMap)((Intent)localObject8).getSerializableExtra("channel_map_data");
              localObject6 = localObject1;
              n = k;
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
                n = 9;
                localObject6 = (String)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().get("pushContext");
                localObject5 = localObject2;
              }
            }
            localObject2 = localObject6;
            l3 = l2;
            localObject1 = localObject5;
            l2 = l1;
            l1 = l3;
            k = n;
            label699:
            if (this.jdField_a_of_type_Qod != null) {
              this.jdField_a_of_type_Qod.a(paramBoolean1);
            }
            localObject8 = new ArrayList();
            n = m;
            if (d())
            {
              ((List)localObject8).addAll(localKandianMergeManager.b());
              n = m | 0x80;
            }
            m = n;
            if (pes.a().a()) {
              m = n | 0x1000;
            }
            localObject9 = new ArrayList();
            if (this.jdField_a_of_type_Int == 56)
            {
              localObject5 = new pdg();
              ((pdg)localObject5).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
              ((pdg)localObject5).jdField_a_of_type_Boolean = bady.a(getContext(), ((pdg)localObject5).jdField_a_of_type_JavaLangString);
              ((List)localObject9).add(localObject5);
            }
            if (localObject4 != null) {
              break label1935;
            }
            localObject5 = null;
            label846:
            if (localObject4 != null) {
              break label1945;
            }
            localObject4 = null;
            label854:
            if (this.jdField_a_of_type_Int != 70) {
              break label1958;
            }
            ogy.a().a(true, (String)localObject2);
            onj.a().a(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
            this.jdField_c_of_type_Int += 1;
            rvf.a(paramInt, this.jdField_a_of_type_Int, a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
            return;
            if ((b()) && (!this.j))
            {
              l1 = this.jdField_a_of_type_Nhw.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
              bool1 = this.jdField_a_of_type_Nhw.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
              this.j = true;
              this.i = true;
              if (bool1)
              {
                localObject2 = (ArticleInfo)this.jdField_a_of_type_Nhw.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
                if (localObject2 == null) {
                  break label2171;
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
              ((JSONObject)localObject4).put("ArticleId", obz.a(((ArticleInfo)localObject2).mArticleID));
              ((JSONObject)localObject4).put("FeedsId", obz.a(((ArticleInfo)localObject2).mFeedId));
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
              k = 5;
              bool1 = false;
              l2 = 0L;
              l1 = 0L;
              localObject5 = localObject1;
              localObject6 = localObject4;
              localObject1 = localObject2;
              m = 0;
              localObject4 = localObject5;
              localObject2 = localObject6;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              localObject3 = null;
              continue;
            }
            localObject4 = new ArrayList();
            ((List)localObject4).add(Long.valueOf(l1));
            localObject1 = null;
            continue;
            if (this.jdField_a_of_type_Int == 70)
            {
              localObject3 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
              localObject1 = localogy;
              if (localObject3 != null)
              {
                localObject1 = ((KandianRedDotInfo)localObject3).cookie;
                a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
              }
              m = 0;
              l2 = 0L;
              l1 = 0L;
              localObject4 = null;
              localObject3 = null;
              bool1 = false;
              break;
            }
            if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1001L))
            {
              n = 2;
              localObject5 = localKandianMergeManager.b();
              m = k;
              localObject3 = localObject10;
              l1 = l4;
              l2 = l3;
              if (localObject5 != null)
              {
                if (!((KandianRedDotInfo)localObject5).hasArticleID()) {
                  break label1533;
                }
                localObject1 = ((KandianRedDotInfo)localObject5).articleIDList;
                localObject3 = ((KandianRedDotInfo)localObject5).cookie;
                l2 = ((KandianRedDotInfo)localObject5).algorithmID;
                l1 = ((KandianRedDotInfo)localObject5).strategyID;
                k = 1;
                n = 10;
              }
              for (;;)
              {
                localKandianMergeManager.m();
                m = k;
                localObject4 = localObject3;
                localObject5 = null;
                localObject3 = localObject1;
                bool1 = false;
                localObject1 = localObject4;
                k = m;
                m = n;
                localObject4 = localObject5;
                break;
                label1533:
                n = 6;
                localObject3 = localObject9;
                localObject1 = localObject4;
                l1 = l4;
                l2 = l3;
              }
            }
            if (this.jdField_a_of_type_Int == 40677)
            {
              localObject6 = (oie)localQQAppInterface.getManager(274);
              m = k;
              localObject3 = localObject5;
              localObject1 = localObject8;
              if (((oie)localObject6).a() != null)
              {
                m = k;
                localObject3 = localObject5;
                localObject1 = localObject8;
                if (((oie)localObject6).a().size() > 0)
                {
                  localObject4 = new ArrayList(((oie)localObject6).a());
                  k = 8;
                  m = k;
                  localObject3 = localObject5;
                  localObject1 = localObject4;
                  if (!TextUtils.isEmpty(((oie)localObject6).a()))
                  {
                    localObject3 = ((oie)localObject6).a();
                    localObject1 = localObject4;
                    m = k;
                  }
                }
              }
              ((oie)localObject6).a(a());
              localObject4 = localObject3;
              n = 0;
              l2 = 0L;
              l1 = 0L;
              localObject5 = null;
              localObject3 = localObject1;
              bool1 = false;
              localObject1 = localObject4;
              k = m;
              m = n;
              localObject4 = localObject5;
              break;
              if (odm.c(this.jdField_a_of_type_Int))
              {
                localObject5 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
                if (localObject5 != null)
                {
                  l2 = ((KandianRedDotInfo)localObject5).algorithmID;
                  l1 = ((KandianRedDotInfo)localObject5).strategyID;
                  localObject3 = ((KandianRedDotInfo)localObject5).articleIDList;
                  k = 1;
                  localObject1 = ((KandianRedDotInfo)localObject5).cookie;
                  a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
                }
                localObject5 = localObject1;
                l3 = l1;
                l1 = l2;
                localObject1 = localObject3;
                l2 = l3;
                localObject3 = localObject5;
                break label699;
              }
              l3 = a();
              if (this.jdField_a_of_type_Qod != null)
              {
                localObject5 = (ArticleInfo)this.jdField_a_of_type_Qod.b(0);
                if ((l3 != -1L) && (localObject5 != null) && (l3 != ((ArticleInfo)localObject5).mArticleID))
                {
                  localObject5 = new ArrayList();
                  ((List)localObject5).add(Long.valueOf(l3));
                  k = 6;
                  localObject3 = localObject1;
                  l3 = l1;
                  l1 = l2;
                  localObject1 = localObject5;
                  l2 = l3;
                  break label699;
                  label1935:
                  localObject5 = ((Pair)localObject4).first;
                  break label846;
                  label1945:
                  localObject4 = (String)((Pair)localObject4).second;
                  break label854;
                  label1958:
                  if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7)) {
                    m |= 0x800;
                  }
                  for (;;)
                  {
                    localBundle = new Bundle();
                    localBundle.putInt("FeedsRefreshType", this.jdField_b_of_type_Int);
                    localogy = ogy.a();
                    n = this.jdField_a_of_type_Int;
                    int i1 = this.jdField_c_of_type_Int;
                    if ((localObject5 instanceof String))
                    {
                      localObject6 = (String)localObject5;
                      label2037:
                      if (!(localObject5 instanceof Long)) {
                        break label2109;
                      }
                    }
                    label2109:
                    for (l3 = ((Long)localObject5).longValue();; l3 = -1L)
                    {
                      localogy.a(n, (List)localObject1, k, true, bool1, i1, (String)localObject6, l3, (String)localObject4, b(), l1, l2, (String)localObject3, paramInt, bool2, (LebaKDCellInfo)localObject7, m, (List)localObject8, (List)localObject9, localBundle);
                      break;
                      localObject6 = null;
                      break label2037;
                    }
                  }
                }
              }
              localObject5 = localObject1;
              l3 = l1;
              l1 = l2;
              localObject1 = localObject3;
              l2 = l3;
              localObject3 = localObject5;
              break label699;
            }
            localObject1 = null;
            m = 0;
            l2 = 0L;
            l1 = 0L;
            localObject4 = null;
            localObject3 = null;
            bool1 = false;
            break;
            label2171:
            localObject1 = null;
            localObject3 = localObject6;
          }
          m = 0;
          l3 = l1;
          localObject6 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject6;
          l1 = l2;
          l2 = l3;
          localObject7 = localObject5;
        }
        localObject1 = null;
        l2 = 0L;
        l1 = 0L;
        k = -1;
        break;
        k = -1;
        Object localObject3 = null;
        l2 = 0L;
        l1 = 0L;
      }
      label2245:
      localObject1 = null;
      bool2 = bool3;
      localObject5 = localBundle;
    }
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (pol.a(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = obv.a().a(paramArticleInfo, null, null);
      str = obv.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Qod.notifyDataSetChanged();
    obz.a(a(), paramArticleInfo, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
    obz.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private void c(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new qqp(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new qqq(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    rbf.b("fast_web_show_light_house_1");
    oph localoph = ogy.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (obz.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localoph != null) {
      this.jdField_g_of_type_Int = localoph.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    b(localArticleInfo);
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (obz.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo.mFeedType, paramArticleInfo)) {
      c(paramArticleInfo);
    }
    for (;;)
    {
      rvf.a(paramArticleInfo);
      return;
      obz.a(a(), paramArticleInfo, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
    }
  }
  
  private void e(Map<Long, pov> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (pov)paramMap.next();
      if (!((pov)localObject2).jdField_b_of_type_Boolean)
      {
        ((pov)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = obz.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((pov)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((pov)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((pov)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((pov)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((pov)localObject2).jdField_e_of_type_JavaLangString;
        if (((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new pqh();
          if (this.jdField_d_of_type_Long != 0L) {
            break label606;
          }
        }
        label606:
        for (int k = 1;; k = 0)
        {
          ((pqh)localObject1).jdField_c_of_type_Int = k;
          localObject1 = ((pqh)localObject1).toString();
          localReportInfo.mInnerId = ((pov)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new pqg();
          ((pqg)localObject1).jdField_a_of_type_Long = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
            ((pqg)localObject1).jdField_b_of_type_Long = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
          }
          ((pqg)localObject1).jdField_a_of_type_Int = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((pqg)localObject1).jdField_b_of_type_Int = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((pov)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((pqg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            pqo localpqo = (pqo)((Iterator)localObject2).next();
            if (localpqo != null) {
              ((pqg)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((pqg)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      ogy.a().a(localArrayList);
    }
  }
  
  private boolean f()
  {
    boolean bool = a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private boolean g()
  {
    List localList = (List)this.jdField_a_of_type_Nhw.a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
      return true;
    }
    return false;
  }
  
  private boolean h()
  {
    return this.jdField_a_of_type_Int != 0;
  }
  
  private boolean i()
  {
    if ((h()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
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
    if (!obz.q())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838503);
      int k = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(k);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bepb);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Begh);
    if ((this.jdField_a_of_type_Int == 0) || (odm.c(this.jdField_a_of_type_Int))) {
      pmv.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void y()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    View localView2;
    int k;
    if ((this.jdField_a_of_type_Nhw instanceof nhr))
    {
      localActivity = a();
      if (localActivity.findViewById(2131296407) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131296407);
        localView1 = localActivity.findViewById(2131310674);
        localView2 = findViewById(2131300997);
        if (odi.a())
        {
          k = 2131167493;
          k = getResources().getDimensionPixelOffset(k);
          k = aciy.a(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + k;
          m = aciy.a(50.0F, getResources());
          n = ImmersiveUtils.getStatusBarHeight(getContext());
          i1 = getResources().getDimensionPixelOffset(2131167492);
          localView2.setPadding(0, k, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, k, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + k);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyListViewGroup.5(this, localView1, k, m + n + i1, localView2));
        }
      }
      while (localActivity.findViewById(2131296408) == null) {
        for (;;)
        {
          int m;
          int n;
          int i1;
          return;
          k = 2131167492;
        }
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131296408);
      localView1 = localActivity.findViewById(2131311559);
      k = aciy.a(50.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label450;
      }
      k += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    label450:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, k, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + k);
      }
      localView2 = findViewById(2131300997);
      localView2.setPadding(0, k, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.6(this, localView1, k, localView2));
      return;
      if (!(this.jdField_a_of_type_Nhw instanceof nik)) {
        break;
      }
      ((nik)this.jdField_a_of_type_Nhw).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Qod);
      return;
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_Qod.b(b());
    this.jdField_a_of_type_Qod.a(this.jdField_e_of_type_Long);
    this.jdField_a_of_type_Qod.a(this);
    this.jdField_a_of_type_Qod.a(this);
    this.jdField_a_of_type_Qod.a(this);
    this.jdField_a_of_type_Qod.a(this);
    this.jdField_a_of_type_Qod.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Qod);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public Object a(omr paramomr)
  {
    if (paramomr == null) {
      return null;
    }
    int k = -1;
    int m = 0;
    Object localObject = null;
    long l1;
    if (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramomr.a((oml)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m));
      if (paramomr.a == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = paramomr.a;
        k = ((oml)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m)).a();
        paramomr.a = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(m)), ", jobName : ", paramomr.a(), ", cost : ", Long.valueOf(l2 - l1) });
      m += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + k + ", now : " + ((oml)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m)).a());
      return localObject;
    }
  }
  
  public List<rbg> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public oml a()
  {
    return a(2);
  }
  
  public oml a(int paramInt)
  {
    return (oml)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public qod a()
  {
    return this.jdField_a_of_type_Qod;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    a(new qra(this, "onResume"));
    if (a()) {
      j();
    }
    H();
    if (System.currentTimeMillis() - this.jdField_f_of_type_Long > 10000L)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.23(this));
    }
    if (this.jdField_a_of_type_Qod != null) {
      this.jdField_a_of_type_Qod.j();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rbg)localIterator.next()).c();
    }
    r();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    pmv.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    I();
    G();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    ((KandianMergeManager)obz.a().getManager(162)).a(this.jdField_a_of_type_Ogq);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
    omf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    pol.a(a());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Qod != null)) {
      a(true, 1001, true);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 2464	qqz
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 2466
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 2469	qqz:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 207	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lomr;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 2472	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 2472	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 2473	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:c	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +36 -> 102
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne -40 -> 31
    //   74: aload_3
    //   75: ifnull -44 -> 31
    //   78: invokestatic 187	obz:a	()Lmqq/app/AppRuntime;
    //   81: checkcast 189	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 137	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 137	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   92: invokevirtual 2476	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 2481	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: return
    //   102: iload_1
    //   103: iconst_2
    //   104: if_icmpne +10 -> 114
    //   107: aload_0
    //   108: iconst_2
    //   109: aload_3
    //   110: invokevirtual 2472	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   113: return
    //   114: iload_1
    //   115: iconst_1
    //   116: if_icmpne +10 -> 126
    //   119: aload_0
    //   120: iconst_1
    //   121: aload_3
    //   122: invokevirtual 2472	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
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
    //   145: invokevirtual 2485	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   148: ldc_w 2487
    //   151: invokevirtual 2490	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull -128 -> 31
    //   162: aload_0
    //   163: invokevirtual 137	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   166: aload_3
    //   167: aload_0
    //   168: getfield 274	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Qod	Lqod;
    //   171: aload_0
    //   172: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   175: invokestatic 2114	obz:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lqoe;I)V
    //   178: return
    //   179: iload_1
    //   180: bipush 117
    //   182: if_icmpne +19 -> 201
    //   185: aload_0
    //   186: invokevirtual 137	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   189: checkcast 741	com/tencent/mobileqq/app/BaseActivity
    //   192: getfield 745	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   195: aload_3
    //   196: iload_2
    //   197: invokestatic 2495	nvx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   200: return
    //   201: iload_1
    //   202: sipush 20001
    //   205: if_icmpne +35 -> 240
    //   208: invokestatic 187	obz:a	()Lmqq/app/AppRuntime;
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull -182 -> 31
    //   216: aload_3
    //   217: sipush 162
    //   220: invokevirtual 518	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 1578	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   226: invokevirtual 2497	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:q	()V
    //   229: ldc_w 534
    //   232: iconst_1
    //   233: ldc_w 2499
    //   236: invokestatic 541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: iload_1
    //   241: sipush 1032
    //   244: if_icmpne +176 -> 420
    //   247: aload_3
    //   248: ldc_w 2501
    //   251: invokevirtual 2505	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore_3
    //   255: aload_3
    //   256: ifnull -225 -> 31
    //   259: new 1945	org/json/JSONObject
    //   262: dup
    //   263: aload_3
    //   264: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore_3
    //   268: new 1945	org/json/JSONObject
    //   271: dup
    //   272: invokespecial 1946	org/json/JSONObject:<init>	()V
    //   275: astore 4
    //   277: aload 4
    //   279: ldc_w 961
    //   282: aload_0
    //   283: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   286: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 4
    //   292: ldc_w 2508
    //   295: aload_3
    //   296: ldc_w 2508
    //   299: invokevirtual 2511	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   302: invokevirtual 1954	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 4
    //   308: ldc_w 2513
    //   311: ldc_w 1366
    //   314: invokevirtual 1954	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aconst_null
    //   319: ldc_w 1364
    //   322: ldc_w 1366
    //   325: ldc_w 1366
    //   328: ldc_w 2515
    //   331: ldc_w 2515
    //   334: iconst_0
    //   335: iconst_0
    //   336: new 578	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   343: aload_3
    //   344: ldc_w 2517
    //   347: invokevirtual 2511	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 1366
    //   356: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: ldc_w 2519
    //   365: ldc_w 1366
    //   368: aload 4
    //   370: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   373: iconst_0
    //   374: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   377: return
    //   378: astore_3
    //   379: ldc_w 534
    //   382: iconst_1
    //   383: new 578	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 2521
    //   393: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_3
    //   397: invokevirtual 2522	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: return
    //   410: astore 5
    //   412: aload 5
    //   414: invokevirtual 532	java/lang/Exception:printStackTrace	()V
    //   417: goto -99 -> 318
    //   420: iload_1
    //   421: sipush 9999
    //   424: if_icmpne -393 -> 31
    //   427: iload_2
    //   428: iconst_m1
    //   429: if_icmpne -398 -> 31
    //   432: aload_3
    //   433: ifnull -402 -> 31
    //   436: aload_3
    //   437: ldc_w 2524
    //   440: invokevirtual 1943	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   443: astore_3
    //   444: aload_3
    //   445: instanceof 2526
    //   448: ifeq -417 -> 31
    //   451: aload_0
    //   452: getfield 274	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Qod	Lqod;
    //   455: aload_3
    //   456: checkcast 2526	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   459: invokevirtual 2529	qod:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   462: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	ReadInJoyListViewGroup
    //   0	463	1	paramInt1	int
    //   0	463	2	paramInt2	int
    //   0	463	3	paramIntent	Intent
    //   275	94	4	localJSONObject	JSONObject
    //   410	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   259	277	378	java/lang/Exception
    //   318	377	378	java/lang/Exception
    //   412	417	378	java/lang/Exception
    //   277	318	410	java/lang/Exception
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Qod.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Int == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        nvx.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        nvx.a(paramArticleInfo, paramString1);
        bbmy.a(a(), 0, a().getString(2131652551), 0).a();
        QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult failed " + paramInt);
    bbmy.a(a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    ruf.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Qod == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setAdapterData(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = obz.a();
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
        localObject2 = ogy.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label348;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = obz.c((String)localObject1);
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
      localObject1 = ogy.a().a();
      if (localObject1 != null) {
        a(((oox)localObject1).a(this.jdField_a_of_type_Int));
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 70)))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ogy.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      localObject1 = (QQAppInterface)obz.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (localObject1 != null))
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label863;
        }
        localObject1 = rtr.b((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localObject2 = rtr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        rtr.a(((BaseActivity)this.jdField_a_of_type_Nhw.a()).app, (String)localObject2, String.valueOf(this.jdField_a_of_type_Long), (String)localObject1, false);
      }
    }
    this.jdField_a_of_type_Obl.jdField_b_of_type_Long = 0L;
    if (!this.jdField_f_of_type_Boolean)
    {
      bool = true;
      label578:
      this.jdField_d_of_type_Boolean = a(bool);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label934;
      }
    }
    for (int k = 1;; k = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)obz.a().getManager(162)).f();
        if (paramInt <= 0) {
          break label989;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l;
          label863:
          localException.printStackTrace();
          label934:
          paramInt = 0;
          continue;
          bool = obz.b(((ReadInJoyNewFeedsActivity)a()).b());
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
        break label969;
      }
      if (k == 0) {
        break label951;
      }
      bool = true;
      if ((!this.jdField_d_of_type_Boolean) && (bool))
      {
        if ((k == 0) && (paramInt != 0)) {
          break label975;
        }
        L();
      }
      if (!this.jdField_d_of_type_Boolean) {
        oel.a(this.jdField_a_of_type_Qod.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
      {
        l = NetConnInfoCenter.getServerTime();
        localObject1 = (QQAppInterface)obz.a();
        if (localObject1 != null)
        {
          paramList = ((ohd)((QQAppInterface)localObject1).getManager(163)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
          if (paramList != null)
          {
            localObject2 = (oie)((QQAppInterface)localObject1).getManager(274);
            if (localObject2 != null) {
              ((oie)localObject2).a(rtr.a((QQAppInterface)localObject1, paramList), l);
            }
          }
        }
      }
      M();
      if ((this.jdField_a_of_type_Int == 0) && (pes.a().b())) {
        U();
      }
      ruf.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      ruf.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      ruf.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      if (this.jdField_a_of_type_Int == 70)
      {
        ((KandianSubscribeManager)((QQAppInterface)localObject1).getManager(280)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Long);
        break;
      }
      if (!odm.c(this.jdField_a_of_type_Int)) {
        break;
      }
      ((KandianDailyManager)((QQAppInterface)localObject1).getManager(296)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      break;
      bool = false;
      break label578;
    }
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(bgmq.r(obz.a())).booleanValue()) {
        rjb.a(paramContext, "", "http://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        ogy.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Qod.notifyDataSetChanged();
        rvf.a(paramArticleInfo);
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
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_h_of_type_Int) || ((!bjeh.e()) && (!bjeh.d()))) {
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
            obz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
            a(new qrk(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (qcn.a(paramArticleInfo, getContext()));
          paramInt = qoe.c(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = qoe.c(paramArticleInfo);
          if ((pmu.b(paramInt)) || (qoe.i(paramArticleInfo)) || (qoe.a(paramArticleInfo)) || (qoe.j(paramArticleInfo)) || (qoe.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (qoe.a(paramArticleInfo) == 23) || (qoe.b(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              obz.a(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prd.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              P();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                oyc.a(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!qoe.a(paramArticleInfo)) && (!qoe.h(paramArticleInfo)) && (!obz.b(paramArticleInfo)) && (!obz.c(paramArticleInfo)) && (!obz.e(paramArticleInfo)) && (!obz.f(paramArticleInfo)));
        if (obz.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          oyc.a(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      oyc.a(getContext(), paramArticleInfo);
      return;
    }
    b(paramArticleInfo, 2);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i1 = this.jdField_a_of_type_Int;
    Object localObject1 = obz.c(paramArticleInfo);
    int k;
    int m;
    label36:
    int n;
    label49:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      k = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label765;
      }
      m = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label770;
      }
      n = paramArticleInfo.videoJumpChannelID;
      ndn.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.b(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), this.jdField_a_of_type_Int, k), false);
      ndn.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.b(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), this.jdField_a_of_type_Int, k));
      localObject2 = rvf.b(i1);
      if ((!qoe.i(paramArticleInfo)) && (!qoe.a(paramArticleInfo)) && (!qoe.j(paramArticleInfo)) && (!qoe.k(paramArticleInfo))) {
        break label777;
      }
      localObject3 = new qmv(obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), i1, k, m, badq.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), n, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((qmv)localObject3).h(n).c((String)new.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(obz.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ndn.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pre.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((qmv)localObject3).a().a(), false);
    }
    for (;;)
    {
      ndn.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), i1, k, m, badq.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), n, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = obz.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!pol.a(paramArticleInfo)) && (!obv.a().a()) && (obz.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label932;
      }
      localObject3 = new pqg();
      ((pqg)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
        ((pqg)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
      }
      ((pqg)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((pqg)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label925;
      }
      ((pqg)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        pqo localpqo = (pqo)((Iterator)localObject4).next();
        if (localpqo != null) {
          ((pqg)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localpqo.jdField_a_of_type_Long));
        }
      }
      k = 0;
      break;
      label765:
      m = 1;
      break label36;
      label770:
      n = 56;
      break label49;
      label777:
      localObject3 = new qmv(obz.a(paramArticleInfo.mAlgorithmID, obz.a(paramArticleInfo), i1, k, m, badq.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, obz.e(paramArticleInfo), n, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((qmv)localObject3).h(n).c((String)new.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(obz.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      ndn.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((qmv)localObject3).a().a(), false);
    }
    label925:
    ((ReportInfo)localObject2).mFeedsReportData = ((pqg)localObject3);
    label932:
    ((List)localObject1).add(localObject2);
    ogy.a().a((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!rvb.a((AdvertisementInfo)paramArticleInfo, i1)) {
        break label1010;
      }
      k = nbe.R;
    }
    for (;;)
    {
      nbe.a(new nmv().a(BaseApplicationImpl.getContext()).a(nbe.jdField_a_of_type_Int).b(k).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1010:
      if (obz.a(paramArticleInfo)) {
        k = nbe.Q;
      } else {
        k = nbe.L;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (obz.s(localArticleInfo)) {
      if ((obz.m(localArticleInfo)) || (obz.c(localArticleInfo)))
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
        if (odm.c(this.jdField_a_of_type_Int)) {
          oab.a(paramInt);
        }
        P();
      }
      do
      {
        return;
        if (obz.e(localArticleInfo))
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
        paramBaseArticleInfo = obz.a(getContext());
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Qod, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    a(new qrh(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int k;
    if (paramInt != 0)
    {
      bool1 = true;
      if (odm.c(this.jdField_a_of_type_Int))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label219;
        }
        oab.a(1);
      }
      if ((obz.a()) && (!h()) && (!bool1)) {
        break label231;
      }
      k = 1;
      label79:
      if (k == 0) {
        break label236;
      }
      k = 3;
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
      obz.b(3);
    }
    for (;;)
    {
      a(true, k, bool1);
      if ((this.jdField_a_of_type_Int == 0) && (paramInt != 2)) {
        ohb.a().f(2);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.32(this));
      paramReadInJoyBaseListView = this.jdField_c_of_type_JavaUtilList.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        rbg localrbg = (rbg)paramReadInJoyBaseListView.next();
        if ((localrbg instanceof ReadInJoyDiandianHeaderController)) {
          localrbg.e();
        }
      }
      bool1 = false;
      break;
      label219:
      if (paramInt == 2) {
        break label59;
      }
      oab.a(1);
      break label59;
      label231:
      k = 0;
      break label79;
      label236:
      k = 1001;
      break label85;
      label243:
      if (!(getContext() instanceof SplashActivity)) {
        break label125;
      }
      ohb.a().a(2, null);
      paramReadInJoyBaseListView = obz.a(getContext());
      boolean bool2 = obz.b(this.jdField_a_of_type_Int, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.a(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      rvf.a(1);
      break label125;
      label305:
      if ((getContext() instanceof SplashActivity)) {
        ohb.a().a(2, null);
      }
      k = 1;
    }
    if (this.jdField_a_of_type_Int == 0) {
      rvf.d();
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof pez)) {
      ((pez)localObject).b();
    }
    localObject = (ArticleInfo)paramBaseArticleInfo;
    int k;
    int i1;
    int n;
    int m;
    label197:
    int i2;
    if (localObject != null)
    {
      a(new qri(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      if (odm.c(this.jdField_a_of_type_Int))
      {
        paramBaseArticleInfo.mJumpType = 1;
        bgmq.a(paramBaseArticleInfo);
      }
      obz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = (ArticleInfo)localObject;
      if (obz.l((BaseArticleInfo)localObject))
      {
        a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        k = 4;
        i3 = k;
        if (!((ArticleInfo)localObject).hasSearchWordInfo()) {
          if (qoe.c((ArticleInfo)localObject) != 3)
          {
            i3 = k;
            if (qoe.c((ArticleInfo)localObject) != 1) {}
          }
          else
          {
            i3 = k;
            if (((ArticleInfo)localObject).mIsShowSearchord == 1)
            {
              paramAdapterView = Aladdin.getConfig(201);
              if (paramAdapterView == null) {
                break label2149;
              }
              i1 = paramAdapterView.getIntegerFromString("feeds_searchterm", 0);
              n = paramAdapterView.getIntegerFromString("feeds_searchterm_max", 1000);
              m = paramAdapterView.getIntegerFromString("feeds_pos_range_each_max", 3);
              if (!DateUtils.isToday(baig.b("search_word_prefix_last_request_time")))
              {
                baig.a("search_word_prefix_last_request_time", System.currentTimeMillis());
                baig.a("search_word_prefix_show_times", 0L);
              }
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((ArticleInfo)localObject).mRefreshTime)) {
                break label2112;
              }
              i2 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(((ArticleInfo)localObject).mRefreshTime)).intValue();
              label260:
              i3 = k;
              if (i2 < m)
              {
                i3 = k;
                if (baig.b("search_word_prefix_show_times") < n)
                {
                  i3 = k;
                  if (i1 == 1) {
                    ((ajuq)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a(ByteStringMicro.copyFromUtf8(((ArticleInfo)localObject).innerUniqueID), new qrj(this, (ArticleInfo)localObject, i2, paramInt));
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int i3 = k;; i3 = 0)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
        ((ReadInJoyNewFeedsActivity)getContext()).g(i3);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if (odm.c(this.jdField_a_of_type_Int)) {
              oab.a(i3);
            }
            P();
            return;
            if (((ArticleInfo)localObject).mFeedType == 3)
            {
              paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
              label445:
              boolean bool;
              if ((paramAdapterView instanceof QQAppInterface))
              {
                paramView = (QQAppInterface)paramAdapterView;
                paramAdapterView = new aqnv();
                if (this.jdField_a_of_type_Int != 56) {
                  break label536;
                }
                paramAdapterView.jdField_b_of_type_JavaLangString = "kandian_video";
                paramAdapterView.jdField_a_of_type_JavaLangString = "kandian_video";
                paramBaseArticleInfo = new Bundle();
                if (((ArticleInfo)localObject).mCommentIconType != 1) {
                  break label553;
                }
                bool = true;
                paramBaseArticleInfo.putBoolean("jump_now_switch", bool);
              }
              try
              {
                paramView = (aqod)paramView.getManager(306);
                paramBaseArticleInfo.putString("roomid", ((ArticleInfo)localObject).mArticleContentUrl);
                paramBaseArticleInfo.putString("fromid", paramAdapterView.jdField_b_of_type_JavaLangString);
                paramView.a(paramBaseArticleInfo);
                obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
                k = 0;
                break;
                label536:
                paramAdapterView.jdField_b_of_type_JavaLangString = "kandian_shouye";
                paramAdapterView.jdField_a_of_type_JavaLangString = "kandian_shouye";
                break label445;
                label553:
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
            obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
            k = 0;
            break;
          }
          if ((((ArticleInfo)localObject).mFeedType == 22) || (((ArticleInfo)localObject).mFeedType == 21) || (obz.n((ArticleInfo)localObject)))
          {
            obz.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            k = 0;
            break;
          }
          if (qoe.b((ArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView)) {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
            }
            for (;;)
            {
              paramBaseArticleInfo.click_area = 7;
              obz.b(getContext(), (ArticleInfo)localObject, (int)paramBaseArticleInfo.mChannelID);
              k = 0;
              break;
              oyc.a(getContext(), (ArticleInfo)localObject);
            }
          }
          if ((qoe.a((ArticleInfo)localObject)) && (qoe.c((ArticleInfo)localObject)))
          {
            c((ArticleInfo)localObject, paramView);
            k = 0;
            break;
          }
          if (qoe.a((ArticleInfo)localObject))
          {
            obz.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            k = 0;
            break;
          }
          if (qoe.c((ArticleInfo)localObject) == 71)
          {
            if ((paramView instanceof ProteusItemView)) {
              a((ProteusItemView)paramView);
            }
            for (;;)
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              k = 4;
              break;
              if ((paramView instanceof LinearLayout)) {
                a((LinearLayout)paramView);
              }
            }
          }
          if ((qoe.a((BaseArticleInfo)localObject)) || (qoe.j((ArticleInfo)localObject)))
          {
            obz.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            qoe.a((ArticleInfo)localObject, this.jdField_a_of_type_Qod.a());
            k = 0;
            break;
          }
          if ((obz.b((ArticleInfo)localObject)) || (obz.c((ArticleInfo)localObject)))
          {
            obz.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            qoe.a((ArticleInfo)localObject, this.jdField_a_of_type_Qod.a());
            obz.a((ArticleInfo)localObject, this.jdField_a_of_type_Qod.a());
            k = 0;
            break;
          }
          if (obz.a((ArticleInfo)localObject))
          {
            b((ArticleInfo)localObject, 1);
            nzv.a(getContext(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod);
            k = 2;
            break;
          }
          if ((qoe.i((ArticleInfo)localObject)) || (qoe.k((ArticleInfo)localObject)))
          {
            obz.a(getContext(), (ArticleInfo)localObject, 0, false, 1, false);
            qoe.a((ArticleInfo)localObject, this.jdField_a_of_type_Qod.a());
            k = 0;
            break;
          }
          if (qoe.h((ArticleInfo)localObject))
          {
            if (qoe.c((ArticleInfo)localObject))
            {
              c((ArticleInfo)localObject, paramView);
              k = 0;
              break;
            }
            obz.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            k = 0;
            break;
          }
          if (obz.a((BaseArticleInfo)localObject))
          {
            if (((ArticleInfo)localObject).isTwoItemVideoFeed())
            {
              QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle);
              return;
            }
            if (qoe.c((ArticleInfo)localObject) == 6)
            {
              if ((paramView instanceof ProteusItemView)) {
                a((ProteusItemView)paramView);
              }
            }
            else
            {
              label1235:
              if (!a((ArticleInfo)localObject, paramView)) {
                break label1438;
              }
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug video feeds");
              ogy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Qod.notifyDataSetChanged();
              obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle + " article.mSummary:" + ((ArticleInfo)localObject).mSummary + "mJsonVideoList:" + ((ArticleInfo)localObject).mJsonVideoList + " videoJumpChannelID=" + ((ArticleInfo)localObject).videoJumpChannelID + " videoJumpChannelName=" + ((ArticleInfo)localObject).videoJumpChannelName + " videoJumpChannelType=" + ((ArticleInfo)localObject).videoJumpChannelType);
              }
              k = 4;
              break;
              if (!(paramView instanceof LinearLayout)) {
                break label1235;
              }
              a((LinearLayout)paramView);
              break label1235;
              label1438:
              if (b((ArticleInfo)localObject, paramView))
              {
                QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt video feeds");
              }
              else if (paramBaseArticleInfo.isAccountShown)
              {
                paramBaseArticleInfo.click_area = 7;
                c((ArticleInfo)localObject);
              }
              else
              {
                a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              }
            }
          }
          if (obz.d((BaseArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
              label1549:
              ogy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              if (this.jdField_a_of_type_Qod == null) {
                break label2163;
              }
            }
            try
            {
              if (!TextUtils.isEmpty(rjb.b(((ArticleInfo)localObject).mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
              {
                if (this.jdField_a_of_type_AndroidOsHandler == null) {
                  this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
                }
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyListViewGroup.35(this), 2000L);
              }
              for (;;)
              {
                k = 0;
                break;
                a((ArticleInfo)localObject, paramInt - 1);
                break label1549;
                this.jdField_a_of_type_Qod.notifyDataSetChanged();
              }
            }
            catch (Exception paramAdapterView)
            {
              this.jdField_a_of_type_Qod.notifyDataSetChanged();
              k = 0;
            }
          }
        }
        if ((obz.a(((ArticleInfo)localObject).mArticleContentUrl, ((ArticleInfo)localObject).mChannelID, ((ArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) || (((ArticleInfo)localObject).isAccountShown))
        {
          if (paramBaseArticleInfo.isAccountShown) {
            paramBaseArticleInfo.click_area = 7;
          }
          if (a((ArticleInfo)localObject, paramView))
          {
            QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug normal feeds");
            ogy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
            this.jdField_a_of_type_Qod.notifyDataSetChanged();
            obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            k = 2;
            break;
            if (b((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
            }
            else if ((!pol.a((BaseArticleInfo)localObject)) && (!obv.a().a()) && (obz.a(paramView.getContext(), (BaseArticleInfo)localObject)))
            {
              obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
              ogy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Qod.notifyDataSetChanged();
              obz.a(paramView.getContext(), (BaseArticleInfo)localObject, obz.i(((ArticleInfo)localObject).getInnerUniqueID()));
            }
            else
            {
              c((ArticleInfo)localObject);
            }
          }
        }
        if (((ArticleInfo)localObject).mFeedType == 26)
        {
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pri == null) || (TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pri.jdField_k_of_type_JavaLangString))) {
            break label2163;
          }
          obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
          obz.c(getContext(), ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Pri.jdField_k_of_type_JavaLangString);
          ogy.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
          k = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 23)
        {
          obz.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
          k = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 34)
        {
          obz.a(getContext(), ((ArticleInfo)localObject).mArticleContentUrl, null);
          qoe.a((ArticleInfo)localObject, this.jdField_a_of_type_Qod.a());
          k = 0;
          break;
        }
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (this.jdField_a_of_type_Qod != null)) {
          obz.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Qod, this.jdField_a_of_type_Int);
        }
        k = 2;
        break;
        label2112:
        i2 = 0;
        break label260;
        if ((getContext() instanceof SplashActivity))
        {
          paramAdapterView = obz.a(getContext());
          if (paramAdapterView != null) {
            paramAdapterView.a(i3);
          }
        }
      }
      label2149:
      i1 = 0;
      n = 1000;
      m = 3;
      break label197;
      label2163:
      k = 0;
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
      int m = this.jdField_a_of_type_Qod.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int k = 0;
        while (k < 5)
        {
          long l = ((Long)paramList.get(k)).longValue();
          Object localObject = this.jdField_a_of_type_Qod.a(m, l);
          if ((localObject != null) && (!obz.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, ((BaseArticleInfo)localObject).mFeedType, (ArticleInfo)localObject)) && (!obz.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Qod.a(m, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xcu.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          k += 1;
        }
      }
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, pov> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    a(new qqt(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = rvf.a(this.jdField_a_of_type_Int);
    String str = obz.e(this.jdField_a_of_type_Int);
    ThreadManager.post(new ReadInJoyListViewGroup.15(this, a(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (h())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
      bgmq.a((QQAppInterface)obz.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      label156:
      bgmq.a((QQAppInterface)obz.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  /* Error */
  public void a(Map<Long, pov> paramMap, boolean paramBoolean, Map<Long, rvk> paramMap1, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: invokeinterface 3150 1 0
    //   10: ifne +7 -> 17
    //   13: iload_2
    //   14: ifne +31 -> 45
    //   17: ldc_w 534
    //   20: iconst_2
    //   21: ldc_w 3152
    //   24: invokestatic 541	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_3
    //   28: ifnull +16 -> 44
    //   31: aload_3
    //   32: invokeinterface 3150 1 0
    //   37: ifne +7 -> 44
    //   40: aload_3
    //   41: invokestatic 3154	rvf:a	(Ljava/util/Map;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   49: bipush 56
    //   51: if_icmpne +87 -> 138
    //   54: aload_0
    //   55: getfield 267	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Nhw	Lnhw;
    //   58: invokevirtual 3157	nhw:a	()Lqik;
    //   61: astore 14
    //   63: aload 14
    //   65: ifnull +73 -> 138
    //   68: aload_1
    //   69: invokeinterface 2119 1 0
    //   74: invokeinterface 2122 1 0
    //   79: astore 15
    //   81: aload 15
    //   83: invokeinterface 391 1 0
    //   88: ifeq +50 -> 138
    //   91: aload 15
    //   93: invokeinterface 395 1 0
    //   98: checkcast 2124	pov
    //   101: astore 16
    //   103: aload 16
    //   105: aload 14
    //   107: invokevirtual 3160	qik:a	()I
    //   110: putfield 3161	pov:jdField_h_of_type_Int	I
    //   113: aload 14
    //   115: aload 16
    //   117: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   120: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   123: invokevirtual 3163	qik:a	(J)Z
    //   126: ifeq -45 -> 81
    //   129: aload 16
    //   131: iconst_1
    //   132: putfield 3164	pov:jdField_f_of_type_Boolean	Z
    //   135: goto -54 -> 81
    //   138: new 105	java/util/HashMap
    //   141: dup
    //   142: invokespecial 106	java/util/HashMap:<init>	()V
    //   145: astore 18
    //   147: aload_1
    //   148: invokeinterface 2119 1 0
    //   153: invokeinterface 2122 1 0
    //   158: astore 19
    //   160: aload 19
    //   162: invokeinterface 391 1 0
    //   167: ifeq +4215 -> 4382
    //   170: aload 19
    //   172: invokeinterface 395 1 0
    //   177: checkcast 2124	pov
    //   180: astore 20
    //   182: aload 20
    //   184: getfield 3165	pov:jdField_a_of_type_Boolean	Z
    //   187: ifne -27 -> 160
    //   190: aload 20
    //   192: iconst_1
    //   193: putfield 3165	pov:jdField_a_of_type_Boolean	Z
    //   196: aload_0
    //   197: invokespecial 3166	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/util/Pair;
    //   200: astore 14
    //   202: aload 14
    //   204: getfield 2019	android/util/Pair:second	Ljava/lang/Object;
    //   207: checkcast 571	java/lang/Long
    //   210: invokevirtual 662	java/lang/Long:longValue	()J
    //   213: lstore 8
    //   215: aload 14
    //   217: getfield 1283	android/util/Pair:first	Ljava/lang/Object;
    //   220: checkcast 555	java/lang/Integer
    //   223: invokevirtual 856	java/lang/Integer:intValue	()I
    //   226: istore 7
    //   228: aconst_null
    //   229: ldc_w 1364
    //   232: ldc_w 1366
    //   235: ldc_w 1366
    //   238: ldc_w 3168
    //   241: ldc_w 3168
    //   244: iconst_0
    //   245: iconst_0
    //   246: ldc_w 1366
    //   249: aload 20
    //   251: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   254: invokevirtual 662	java/lang/Long:longValue	()J
    //   257: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   260: aload 20
    //   262: getfield 2147	pov:jdField_b_of_type_Int	I
    //   265: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   268: aload 20
    //   270: getfield 2143	pov:jdField_a_of_type_Long	J
    //   273: aload 20
    //   275: getfield 3169	pov:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   282: aload 20
    //   284: getfield 3170	pov:jdField_d_of_type_Int	I
    //   287: invokestatic 3172	obz:a	(JIII)Ljava/lang/String;
    //   290: iconst_0
    //   291: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   294: ldc_w 3168
    //   297: ldc_w 1366
    //   300: ldc_w 1366
    //   303: aload 20
    //   305: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   308: invokevirtual 662	java/lang/Long:longValue	()J
    //   311: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   314: aload 20
    //   316: getfield 2147	pov:jdField_b_of_type_Int	I
    //   319: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   322: aload 20
    //   324: getfield 2143	pov:jdField_a_of_type_Long	J
    //   327: aload 20
    //   329: getfield 3169	pov:jdField_c_of_type_Int	I
    //   332: aload_0
    //   333: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   336: aload 20
    //   338: getfield 3170	pov:jdField_d_of_type_Int	I
    //   341: invokestatic 3172	obz:a	(JIII)Ljava/lang/String;
    //   344: invokestatic 2754	ndn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload 20
    //   349: getfield 2143	pov:jdField_a_of_type_Long	J
    //   352: aload 20
    //   354: getfield 3169	pov:jdField_c_of_type_Int	I
    //   357: aload_0
    //   358: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   361: aload 20
    //   363: getfield 3170	pov:jdField_d_of_type_Int	I
    //   366: aload 20
    //   368: getfield 3173	pov:jdField_e_of_type_Int	I
    //   371: aload_0
    //   372: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   375: invokestatic 2763	badq:h	(Landroid/content/Context;)Z
    //   378: aload 20
    //   380: getfield 3174	pov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: aload 20
    //   385: getfield 3175	pov:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   388: aload 20
    //   390: getfield 2161	pov:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   393: aload 20
    //   395: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   398: invokestatic 2768	obz:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   401: aload 20
    //   403: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   406: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   409: lload 8
    //   411: iload 7
    //   413: aload 20
    //   415: getfield 3176	pov:jdField_f_of_type_Int	I
    //   418: aload 20
    //   420: getfield 3177	pov:jdField_g_of_type_Int	I
    //   423: aload 20
    //   425: getfield 3161	pov:jdField_h_of_type_Int	I
    //   428: aload 20
    //   430: getfield 3164	pov:jdField_f_of_type_Boolean	Z
    //   433: aload 20
    //   435: getfield 3178	pov:jdField_j_of_type_Int	I
    //   438: aload 20
    //   440: getfield 3179	pov:jdField_i_of_type_Int	I
    //   443: aload 20
    //   445: getfield 3181	pov:m	I
    //   448: invokestatic 3184	obz:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   451: astore 16
    //   453: aload 20
    //   455: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   458: ifnull -298 -> 160
    //   461: aload_0
    //   462: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   465: bipush 56
    //   467: if_icmpne +459 -> 926
    //   470: aload 16
    //   472: aload_0
    //   473: getfield 267	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Nhw	Lnhw;
    //   476: invokevirtual 272	nhw:a	()Lqhp;
    //   479: invokevirtual 3187	qhp:a	()Ljava/lang/String;
    //   482: getstatic 251	new:jdField_a_of_type_Int	I
    //   485: invokestatic 3190	obz:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   488: astore 14
    //   490: aload 20
    //   492: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   495: ifnull +3951 -> 4446
    //   498: aload 20
    //   500: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   503: getfield 2171	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   506: ifnull +3940 -> 4446
    //   509: new 2758	qmv
    //   512: dup
    //   513: aload 14
    //   515: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   518: aload 20
    //   520: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   523: invokevirtual 3193	qmv:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   526: aload 20
    //   528: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   531: invokevirtual 3195	qmv:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   534: aload 20
    //   536: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   539: getfield 3196	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   542: invokevirtual 2786	qmv:a	(Ljava/lang/String;)Lqmv;
    //   545: invokevirtual 2793	qmv:a	()Lqmu;
    //   548: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   551: astore 14
    //   553: aload_0
    //   554: getfield 274	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Qod	Lqod;
    //   557: astore 15
    //   559: aload 20
    //   561: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   564: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   567: invokestatic 3197	qod:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   570: bipush 46
    //   572: if_icmpeq +14 -> 586
    //   575: aload 20
    //   577: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   580: getfield 3200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   583: ifeq +121 -> 704
    //   586: aload 20
    //   588: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   591: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   594: ifnull +110 -> 704
    //   597: aload 20
    //   599: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   602: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   605: getfield 3210	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   608: ifnull +96 -> 704
    //   611: aload 20
    //   613: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   616: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   619: getfield 3210	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   622: getfield 3215	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   625: invokestatic 3218	obz:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   628: ifeq +76 -> 704
    //   631: aload 20
    //   633: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   636: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   639: getfield 3210	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   642: getfield 3221	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   645: invokestatic 3218	obz:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   648: ifeq +56 -> 704
    //   651: new 578	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   658: aload 20
    //   660: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   663: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   666: getfield 3210	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   669: getfield 3215	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   672: invokestatic 3224	obz:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   675: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 20
    //   680: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   683: getfield 3204	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   686: getfield 3210	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   689: getfield 3221	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   692: invokestatic 3224	obz:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   695: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 3225	qcn:a	(Ljava/lang/String;)V
    //   704: aload 14
    //   706: astore 15
    //   708: new 1945	org/json/JSONObject
    //   711: dup
    //   712: aload 15
    //   714: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   717: astore 14
    //   719: aload 14
    //   721: ldc_w 3227
    //   724: aload 4
    //   726: invokevirtual 1954	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   729: pop
    //   730: aload 14
    //   732: ldc_w 3229
    //   735: invokestatic 187	obz:a	()Lmqq/app/AppRuntime;
    //   738: aload_0
    //   739: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   742: invokestatic 3234	odh:a	(Lmqq/app/AppRuntime;I)I
    //   745: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   748: pop
    //   749: aload 20
    //   751: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   754: ifnonnull +651 -> 1405
    //   757: aload 14
    //   759: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   762: astore 14
    //   764: aload_0
    //   765: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   768: i2l
    //   769: invokestatic 3235	rvf:a	(J)Z
    //   772: ifeq +751 -> 1523
    //   775: ldc_w 3237
    //   778: astore 15
    //   780: aload_0
    //   781: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   784: invokestatic 1589	odm:a	(I)Z
    //   787: ifne +14 -> 801
    //   790: aload_0
    //   791: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   794: i2l
    //   795: invokestatic 3238	bgmq:a	(J)Z
    //   798: ifeq +3645 -> 4443
    //   801: ldc_w 3240
    //   804: astore 15
    //   806: aload 20
    //   808: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   811: invokestatic 3241	qoe:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   814: ifeq +717 -> 1531
    //   817: iconst_0
    //   818: istore 5
    //   820: iload 5
    //   822: aload 20
    //   824: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   827: getfield 3245	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lprv;
    //   830: getfield 3249	prv:a	Ljava/util/ArrayList;
    //   833: invokevirtual 3250	java/util/ArrayList:size	()I
    //   836: if_icmpge +889 -> 1725
    //   839: aconst_null
    //   840: aload 20
    //   842: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   845: aload 15
    //   847: aload 15
    //   849: iconst_0
    //   850: iconst_0
    //   851: aload 20
    //   853: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   856: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   859: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   862: new 578	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   869: aload 20
    //   871: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   874: getfield 3245	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lprv;
    //   877: getfield 3249	prv:a	Ljava/util/ArrayList;
    //   880: iload 5
    //   882: invokevirtual 1200	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   885: checkcast 3254	prx
    //   888: getfield 3255	prx:jdField_a_of_type_Int	I
    //   891: invokevirtual 588	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   894: ldc_w 1366
    //   897: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: aload 20
    //   905: getfield 2147	pov:jdField_b_of_type_Int	I
    //   908: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   911: aload 14
    //   913: iconst_0
    //   914: invokestatic 3258	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   917: iload 5
    //   919: iconst_1
    //   920: iadd
    //   921: istore 5
    //   923: goto -103 -> 820
    //   926: aload 16
    //   928: astore 15
    //   930: aload_0
    //   931: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   934: ifne -226 -> 708
    //   937: aload_0
    //   938: getfield 274	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Qod	Lqod;
    //   941: astore 14
    //   943: aload 20
    //   945: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   948: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   951: invokestatic 3197	qod:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   954: istore 5
    //   956: iload 5
    //   958: bipush 6
    //   960: if_icmpeq +45 -> 1005
    //   963: iload 5
    //   965: bipush 66
    //   967: if_icmpeq +38 -> 1005
    //   970: iload 5
    //   972: bipush 115
    //   974: if_icmpeq +31 -> 1005
    //   977: iload 5
    //   979: bipush 28
    //   981: if_icmpeq +24 -> 1005
    //   984: iload 5
    //   986: bipush 11
    //   988: if_icmpeq +17 -> 1005
    //   991: iload 5
    //   993: bipush 26
    //   995: if_icmpeq +10 -> 1005
    //   998: iload 5
    //   1000: bipush 19
    //   1002: if_icmpne +65 -> 1067
    //   1005: aload 20
    //   1007: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1010: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   1013: invokestatic 3259	new:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   1016: aload 16
    //   1018: invokestatic 3262	new:a	(ILjava/lang/String;)Ljava/lang/String;
    //   1021: astore 14
    //   1023: aload 14
    //   1025: astore 15
    //   1027: iload 5
    //   1029: bipush 6
    //   1031: if_icmpne -323 -> 708
    //   1034: new 2758	qmv
    //   1037: dup
    //   1038: aload 14
    //   1040: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   1043: astore 14
    //   1045: aload 14
    //   1047: invokestatic 3263	qcn:b	()I
    //   1050: invokevirtual 3266	qmv:ac	(I)Lqmv;
    //   1053: pop
    //   1054: aload 14
    //   1056: invokevirtual 2793	qmv:a	()Lqmu;
    //   1059: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   1062: astore 15
    //   1064: goto -356 -> 708
    //   1067: iload 5
    //   1069: bipush 46
    //   1071: if_icmpeq +14 -> 1085
    //   1074: aload 20
    //   1076: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1079: getfield 3200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   1082: ifeq +104 -> 1186
    //   1085: new 2758	qmv
    //   1088: dup
    //   1089: aload 16
    //   1091: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   1094: astore 14
    //   1096: aload 14
    //   1098: aload 20
    //   1100: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1103: getfield 3267	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoVid	Ljava/lang/String;
    //   1106: invokevirtual 3269	qmv:e	(Ljava/lang/String;)Lqmv;
    //   1109: pop
    //   1110: aload 14
    //   1112: aload 20
    //   1114: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1117: invokestatic 2748	obz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1120: invokevirtual 3272	qmv:W	(I)Lqmv;
    //   1123: pop
    //   1124: aload 14
    //   1126: aload 20
    //   1128: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1131: getfield 3196	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1134: invokevirtual 2786	qmv:a	(Ljava/lang/String;)Lqmv;
    //   1137: pop
    //   1138: iload 5
    //   1140: bipush 46
    //   1142: if_icmpne +34 -> 1176
    //   1145: aload 14
    //   1147: iconst_0
    //   1148: invokevirtual 3274	qmv:x	(I)Lqmv;
    //   1151: pop
    //   1152: aload 14
    //   1154: aload 20
    //   1156: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1159: invokevirtual 3276	qmv:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   1162: pop
    //   1163: aload 14
    //   1165: invokevirtual 2793	qmv:a	()Lqmu;
    //   1168: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   1171: astore 14
    //   1173: goto -150 -> 1023
    //   1176: aload 14
    //   1178: iconst_1
    //   1179: invokevirtual 3274	qmv:x	(I)Lqmv;
    //   1182: pop
    //   1183: goto -31 -> 1152
    //   1186: iload 5
    //   1188: bipush 118
    //   1190: if_icmpne +103 -> 1293
    //   1193: new 2758	qmv
    //   1196: dup
    //   1197: aload 16
    //   1199: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   1202: astore 14
    //   1204: aload 20
    //   1206: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1209: getfield 2171	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1212: ifnull +54 -> 1266
    //   1215: aload 14
    //   1217: aload 20
    //   1219: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1222: getfield 2171	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1225: getfield 2174	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Int	I
    //   1228: invokevirtual 3279	qmv:aa	(I)Lqmv;
    //   1231: pop
    //   1232: aload 20
    //   1234: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1237: getfield 2171	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1240: getfield 3282	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1243: ifnull +23 -> 1266
    //   1246: aload 14
    //   1248: aload 20
    //   1250: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1253: getfield 2171	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1256: getfield 3282	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1259: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1262: invokevirtual 3287	qmv:r	(Ljava/lang/String;)Lqmv;
    //   1265: pop
    //   1266: aload 14
    //   1268: aload 20
    //   1270: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1273: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1276: invokevirtual 3290	qmv:h	(Ljava/lang/String;)Lqmv;
    //   1279: pop
    //   1280: aload 14
    //   1282: invokevirtual 2793	qmv:a	()Lqmu;
    //   1285: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   1288: astore 14
    //   1290: goto -267 -> 1023
    //   1293: aload 16
    //   1295: astore 14
    //   1297: iload 5
    //   1299: sipush 128
    //   1302: if_icmpne -279 -> 1023
    //   1305: new 2758	qmv
    //   1308: dup
    //   1309: aload 16
    //   1311: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   1314: astore 14
    //   1316: aload 20
    //   1318: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1321: getfield 3293	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1324: ifnull +54 -> 1378
    //   1327: aload 14
    //   1329: aload 20
    //   1331: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1334: getfield 3293	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1337: getfield 2174	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Int	I
    //   1340: invokevirtual 3279	qmv:aa	(I)Lqmv;
    //   1343: pop
    //   1344: aload 20
    //   1346: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1349: getfield 3293	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1352: getfield 3295	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:b	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1355: ifnull +23 -> 1378
    //   1358: aload 14
    //   1360: aload 20
    //   1362: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1365: getfield 3293	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1368: getfield 3295	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:b	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1371: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1374: invokevirtual 3287	qmv:r	(Ljava/lang/String;)Lqmv;
    //   1377: pop
    //   1378: aload 14
    //   1380: aload 20
    //   1382: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1385: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1388: invokevirtual 3290	qmv:h	(Ljava/lang/String;)Lqmv;
    //   1391: pop
    //   1392: aload 14
    //   1394: invokevirtual 2793	qmv:a	()Lqmu;
    //   1397: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   1400: astore 14
    //   1402: goto -379 -> 1023
    //   1405: aload 20
    //   1407: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1410: invokevirtual 3296	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isPGCShortContent	()Z
    //   1413: istore_2
    //   1414: aload 20
    //   1416: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1419: getfield 3299	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1422: invokestatic 1079	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1425: ifne +92 -> 1517
    //   1428: aload 20
    //   1430: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1433: getfield 3299	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1436: ldc_w 3301
    //   1439: invokevirtual 3303	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1442: ifeq +75 -> 1517
    //   1445: iconst_1
    //   1446: istore 5
    //   1448: goto +3001 -> 4449
    //   1451: aload_3
    //   1452: aload 20
    //   1454: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1457: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1460: invokestatic 574	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1463: invokeinterface 851 2 0
    //   1468: checkcast 3305	rvk
    //   1471: astore 16
    //   1473: aload 16
    //   1475: ifnull -718 -> 757
    //   1478: aload 16
    //   1480: getfield 3306	rvk:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1483: aload 20
    //   1485: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1488: if_acmpne -731 -> 757
    //   1491: aload 14
    //   1493: ldc_w 3308
    //   1496: aload 16
    //   1498: getfield 3309	rvk:jdField_a_of_type_Long	J
    //   1501: invokevirtual 1991	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1504: pop
    //   1505: goto -748 -> 757
    //   1508: astore 14
    //   1510: aload 15
    //   1512: astore 14
    //   1514: goto -750 -> 764
    //   1517: iconst_0
    //   1518: istore 5
    //   1520: goto +2929 -> 4449
    //   1523: ldc_w 3311
    //   1526: astore 15
    //   1528: goto -748 -> 780
    //   1531: aload 20
    //   1533: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1536: invokestatic 1185	obz:l	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1539: ifeq +1041 -> 2580
    //   1542: aload 20
    //   1544: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1547: invokestatic 3313	obz:j	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1550: ifeq +846 -> 2396
    //   1553: aload 20
    //   1555: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1558: getfield 3316	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mGroupSubArticleList	Ljava/util/List;
    //   1561: iconst_0
    //   1562: invokeinterface 606 2 0
    //   1567: checkcast 656	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   1570: astore 14
    //   1572: aload_0
    //   1573: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1576: aload 14
    //   1578: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1581: aload 14
    //   1583: getfield 3317	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1586: bipush 54
    //   1588: aload_0
    //   1589: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1592: aload 14
    //   1594: invokevirtual 3318	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   1597: aload 14
    //   1599: invokevirtual 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoVid	()Ljava/lang/String;
    //   1602: aload 14
    //   1604: invokestatic 1356	rvf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1607: aload 14
    //   1609: getfield 3196	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1612: invokestatic 3324	rvf:a	(Landroid/content/Context;JJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   1615: astore 15
    //   1617: aload 15
    //   1619: astore 14
    //   1621: aload 20
    //   1623: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1626: ifnull +42 -> 1668
    //   1629: new 1945	org/json/JSONObject
    //   1632: dup
    //   1633: aload 15
    //   1635: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1638: astore 14
    //   1640: aload 20
    //   1642: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1645: getfield 3327	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isShowGif	Z
    //   1648: ifeq +693 -> 2341
    //   1651: aload 14
    //   1653: ldc_w 3329
    //   1656: iconst_1
    //   1657: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1660: pop
    //   1661: aload 14
    //   1663: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1666: astore 14
    //   1668: aload 14
    //   1670: astore 15
    //   1672: aload 20
    //   1674: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1677: ifnull +38 -> 1715
    //   1680: new 1945	org/json/JSONObject
    //   1683: dup
    //   1684: aload 14
    //   1686: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1689: astore 15
    //   1691: aload 15
    //   1693: ldc_w 3331
    //   1696: aload 20
    //   1698: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1701: invokestatic 3333	obz:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1704: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1707: pop
    //   1708: aload 15
    //   1710: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1713: astore 15
    //   1715: aload 20
    //   1717: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1720: aload 15
    //   1722: invokestatic 3336	obz:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Ljava/lang/String;)V
    //   1725: aload 20
    //   1727: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1730: bipush 48
    //   1732: if_icmpeq +116 -> 1848
    //   1735: aload 20
    //   1737: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1740: bipush 49
    //   1742: if_icmpeq +106 -> 1848
    //   1745: aload 20
    //   1747: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1750: bipush 50
    //   1752: if_icmpeq +96 -> 1848
    //   1755: aload 20
    //   1757: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1760: bipush 51
    //   1762: if_icmpeq +86 -> 1848
    //   1765: aload 20
    //   1767: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1770: bipush 52
    //   1772: if_icmpeq +76 -> 1848
    //   1775: aload 20
    //   1777: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1780: bipush 53
    //   1782: if_icmpeq +66 -> 1848
    //   1785: aload 20
    //   1787: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1790: bipush 78
    //   1792: if_icmpeq +56 -> 1848
    //   1795: aload 20
    //   1797: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1800: bipush 79
    //   1802: if_icmpeq +46 -> 1848
    //   1805: aload 20
    //   1807: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1810: bipush 80
    //   1812: if_icmpeq +36 -> 1848
    //   1815: aload 20
    //   1817: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1820: sipush 1005
    //   1823: if_icmpeq +25 -> 1848
    //   1826: aload 20
    //   1828: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1831: sipush 1006
    //   1834: if_icmpeq +14 -> 1848
    //   1837: aload 20
    //   1839: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1842: sipush 1007
    //   1845: if_icmpne +214 -> 2059
    //   1848: aload 20
    //   1850: getfield 3337	pov:jdField_b_of_type_Long	J
    //   1853: lstore 12
    //   1855: aload 20
    //   1857: getfield 3338	pov:jdField_k_of_type_Int	I
    //   1860: istore 5
    //   1862: aload_0
    //   1863: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1866: aload 20
    //   1868: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1871: invokestatic 3341	nzv:a	(II)I
    //   1874: istore 6
    //   1876: aload 20
    //   1878: getfield 3169	pov:jdField_c_of_type_Int	I
    //   1881: invokestatic 3342	nzv:a	(I)I
    //   1884: istore 7
    //   1886: lconst_0
    //   1887: lstore 8
    //   1889: aconst_null
    //   1890: astore 14
    //   1892: aconst_null
    //   1893: astore 15
    //   1895: aload 20
    //   1897: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1900: ifnull +2531 -> 4431
    //   1903: aload 20
    //   1905: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1908: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1911: lstore 8
    //   1913: aload 20
    //   1915: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1918: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1921: astore 14
    //   1923: aload 20
    //   1925: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1928: getfield 3345	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:galleryReprotExdData	Ljava/lang/String;
    //   1931: astore 15
    //   1933: aload 20
    //   1935: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1938: getfield 3317	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1941: lstore 10
    //   1943: aload_0
    //   1944: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1947: invokestatic 2129	obz:a	()J
    //   1950: iload 6
    //   1952: lload 8
    //   1954: lload 12
    //   1956: iload 5
    //   1958: aload 14
    //   1960: aload 15
    //   1962: iload 7
    //   1964: aload_0
    //   1965: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1968: invokestatic 3348	nzv:a	(Landroid/content/Context;JIJJILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1971: astore 16
    //   1973: aconst_null
    //   1974: aload 20
    //   1976: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1979: ldc_w 3350
    //   1982: ldc_w 3350
    //   1985: iconst_0
    //   1986: iconst_0
    //   1987: ldc_w 1366
    //   1990: new 578	java/lang/StringBuilder
    //   1993: dup
    //   1994: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   1997: lload 8
    //   1999: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2002: ldc_w 1366
    //   2005: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2011: new 578	java/lang/StringBuilder
    //   2014: dup
    //   2015: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2018: lload 10
    //   2020: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2023: ldc_w 1366
    //   2026: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: aload 16
    //   2034: iconst_0
    //   2035: invokestatic 3258	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2038: bipush 7
    //   2040: invokestatic 2129	obz:a	()J
    //   2043: lload 10
    //   2045: l2i
    //   2046: iload 6
    //   2048: lload 12
    //   2050: iload 5
    //   2052: aload 14
    //   2054: aload 15
    //   2056: invokestatic 3353	nzv:a	(IJIIJILjava/lang/String;Ljava/lang/String;)V
    //   2059: aload 20
    //   2061: getfield 3355	pov:jdField_c_of_type_Boolean	Z
    //   2064: ifeq +97 -> 2161
    //   2067: aload 20
    //   2069: getfield 3356	pov:jdField_d_of_type_Boolean	Z
    //   2072: ifeq +89 -> 2161
    //   2075: invokestatic 3359	obz:a	()Lorg/json/JSONObject;
    //   2078: astore 15
    //   2080: aload 15
    //   2082: ldc_w 3361
    //   2085: aload 20
    //   2087: getfield 3174	pov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2090: invokevirtual 1954	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2093: pop
    //   2094: aload 15
    //   2096: ldc_w 3363
    //   2099: invokestatic 3365	obz:e	()I
    //   2102: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2105: pop
    //   2106: aload_0
    //   2107: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2110: i2l
    //   2111: invokestatic 3235	rvf:a	(J)Z
    //   2114: ifeq +2250 -> 4364
    //   2117: ldc_w 3367
    //   2120: astore 14
    //   2122: aconst_null
    //   2123: ldc_w 1364
    //   2126: ldc_w 1366
    //   2129: ldc_w 1366
    //   2132: aload 14
    //   2134: aload 14
    //   2136: iconst_0
    //   2137: iconst_0
    //   2138: aload 20
    //   2140: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2143: invokestatic 3369	obz:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   2146: ldc_w 1366
    //   2149: ldc_w 1366
    //   2152: aload 15
    //   2154: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2157: iconst_0
    //   2158: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2161: aload 20
    //   2163: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2166: invokestatic 3371	obz:k	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2169: ifeq +29 -> 2198
    //   2172: aconst_null
    //   2173: aconst_null
    //   2174: ldc_w 3373
    //   2177: ldc_w 3373
    //   2180: iconst_0
    //   2181: iconst_0
    //   2182: ldc_w 1366
    //   2185: ldc_w 1366
    //   2188: ldc_w 1366
    //   2191: ldc_w 1366
    //   2194: iconst_0
    //   2195: invokestatic 3258	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2198: aload 20
    //   2200: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2203: ifnull +47 -> 2250
    //   2206: aload 20
    //   2208: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2211: getfield 2208	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2214: ifnull +36 -> 2250
    //   2217: aload 20
    //   2219: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2222: getfield 2208	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2225: getfield 3376	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Nis	Lnis;
    //   2228: ifnull +22 -> 2250
    //   2231: aload 20
    //   2233: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2236: getfield 2208	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2239: getfield 3376	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Nis	Lnis;
    //   2242: aload 20
    //   2244: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2247: invokestatic 3379	obz:a	(Lnis;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   2250: invokestatic 1293	qzk:a	()Lqzk;
    //   2253: invokevirtual 1294	qzk:b	()Z
    //   2256: ifeq -2096 -> 160
    //   2259: aload 20
    //   2261: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2264: getfield 3383	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2267: ifnull -2107 -> 160
    //   2270: aload 20
    //   2272: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2275: getfield 3383	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2278: getfield 3386	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_c_of_type_Boolean	Z
    //   2281: ifeq -2121 -> 160
    //   2284: aload 20
    //   2286: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2289: getfield 3383	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2292: getfield 3387	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_d_of_type_Boolean	Z
    //   2295: ifne -2135 -> 160
    //   2298: invokestatic 1293	qzk:a	()Lqzk;
    //   2301: aload 20
    //   2303: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2306: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2309: bipush 56
    //   2311: iconst_2
    //   2312: iconst_4
    //   2313: invokevirtual 3390	qzk:a	(Ljava/lang/String;III)V
    //   2316: aload 20
    //   2318: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2321: getfield 3383	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2324: iconst_1
    //   2325: putfield 3387	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_d_of_type_Boolean	Z
    //   2328: goto -2168 -> 160
    //   2331: astore 14
    //   2333: aload 14
    //   2335: invokevirtual 3391	java/lang/NullPointerException:printStackTrace	()V
    //   2338: goto -2178 -> 160
    //   2341: aload 14
    //   2343: ldc_w 3329
    //   2346: iconst_0
    //   2347: invokevirtual 1961	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2350: pop
    //   2351: goto -690 -> 1661
    //   2354: astore 14
    //   2356: ldc_w 534
    //   2359: iconst_2
    //   2360: aload 14
    //   2362: invokevirtual 3392	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2365: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2368: aload 15
    //   2370: astore 14
    //   2372: goto -704 -> 1668
    //   2375: astore 15
    //   2377: ldc_w 534
    //   2380: iconst_2
    //   2381: aload 15
    //   2383: invokevirtual 3392	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2386: invokestatic 1136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2389: aload 14
    //   2391: astore 15
    //   2393: goto -678 -> 1715
    //   2396: aload_0
    //   2397: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2400: aload 20
    //   2402: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2405: getfield 3393	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoAdsSource	I
    //   2408: aload 20
    //   2410: getfield 3338	pov:jdField_k_of_type_Int	I
    //   2413: aload 20
    //   2415: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2418: invokevirtual 3318	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2421: bipush 54
    //   2423: aload 20
    //   2425: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2428: invokestatic 1356	rvf:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2431: aload 20
    //   2433: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2436: getfield 3196	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   2439: invokestatic 1362	rvf:a	(Landroid/content/Context;IILjava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   2442: astore 14
    //   2444: aconst_null
    //   2445: ldc_w 1364
    //   2448: ldc_w 1366
    //   2451: aload 20
    //   2453: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2456: ldc_w 3395
    //   2459: ldc_w 3395
    //   2462: iconst_0
    //   2463: iconst_0
    //   2464: aload 20
    //   2466: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2469: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2472: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2475: aload 20
    //   2477: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2480: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2483: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2486: aload 20
    //   2488: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2491: getfield 3396	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2494: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2497: aload 14
    //   2499: iconst_0
    //   2500: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2503: aconst_null
    //   2504: aconst_null
    //   2505: ldc_w 3311
    //   2508: ldc_w 3311
    //   2511: iconst_0
    //   2512: iconst_0
    //   2513: ldc_w 1366
    //   2516: ldc_w 1366
    //   2519: ldc_w 1366
    //   2522: new 2758	qmv
    //   2525: dup
    //   2526: aconst_null
    //   2527: aconst_null
    //   2528: aconst_null
    //   2529: aconst_null
    //   2530: invokespecial 3399	qmv:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2533: bipush 54
    //   2535: invokevirtual 3272	qmv:W	(I)Lqmv;
    //   2538: aload 20
    //   2540: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2543: invokevirtual 3318	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2546: invokevirtual 3290	qmv:h	(Ljava/lang/String;)Lqmv;
    //   2549: aload 20
    //   2551: getfield 3338	pov:jdField_k_of_type_Int	I
    //   2554: iconst_1
    //   2555: iadd
    //   2556: invokevirtual 3274	qmv:x	(I)Lqmv;
    //   2559: aload 20
    //   2561: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2564: invokevirtual 3401	qmv:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   2567: invokevirtual 2793	qmv:a	()Lqmu;
    //   2570: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   2573: iconst_0
    //   2574: invokestatic 3258	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2577: goto -852 -> 1725
    //   2580: aload 20
    //   2582: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2585: invokestatic 3404	obz:t	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2588: ifeq +15 -> 2603
    //   2591: aload 20
    //   2593: aload 14
    //   2595: aload 15
    //   2597: invokestatic 3407	obz:a	(Lpov;Ljava/lang/String;Ljava/lang/String;)V
    //   2600: goto -875 -> 1725
    //   2603: aload 20
    //   2605: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2608: invokestatic 1142	obz:s	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2611: ifeq +433 -> 3044
    //   2614: aload 20
    //   2616: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2619: getfield 3408	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mNewPolymericInfo	Lppu;
    //   2622: getfield 2095	ppu:jdField_a_of_type_Boolean	Z
    //   2625: ifne +380 -> 3005
    //   2628: invokestatic 3411	qoe:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2631: astore 16
    //   2633: ldc_w 3413
    //   2636: astore 14
    //   2638: aload 16
    //   2640: ifnull +10 -> 2650
    //   2643: aload 16
    //   2645: invokevirtual 3415	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2648: astore 14
    //   2650: aload 20
    //   2652: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2655: getfield 3317	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2658: aload 20
    //   2660: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2663: invokestatic 2748	obz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2666: aload_0
    //   2667: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2670: iconst_0
    //   2671: iconst_0
    //   2672: aload_0
    //   2673: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2676: invokestatic 2763	badq:h	(Landroid/content/Context;)Z
    //   2679: aload 20
    //   2681: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2684: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2687: aconst_null
    //   2688: aload 20
    //   2690: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2693: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2696: aconst_null
    //   2697: aload 20
    //   2699: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2702: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2705: invokestatic 3419	obz:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Ljava/lang/String;
    //   2708: astore 17
    //   2710: aconst_null
    //   2711: ldc_w 1364
    //   2714: ldc_w 1366
    //   2717: aload 14
    //   2719: aload 15
    //   2721: aload 15
    //   2723: iconst_0
    //   2724: iconst_0
    //   2725: new 578	java/lang/StringBuilder
    //   2728: dup
    //   2729: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2732: aload 20
    //   2734: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2737: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2740: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2743: ldc_w 1366
    //   2746: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2752: new 578	java/lang/StringBuilder
    //   2755: dup
    //   2756: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2759: aload 20
    //   2761: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2764: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2767: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2770: ldc_w 1366
    //   2773: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2779: new 578	java/lang/StringBuilder
    //   2782: dup
    //   2783: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2786: aload 20
    //   2788: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2791: getfield 3396	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2794: invokevirtual 588	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2797: ldc_w 1366
    //   2800: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2806: aload 17
    //   2808: iconst_0
    //   2809: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2812: aload_0
    //   2813: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2816: i2l
    //   2817: invokestatic 3421	rvf:a	(J)Ljava/lang/String;
    //   2820: astore 15
    //   2822: aload 16
    //   2824: ifnull +1616 -> 4440
    //   2827: aload 16
    //   2829: invokevirtual 3415	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2832: astore 14
    //   2834: aload 20
    //   2836: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2839: getfield 3317	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2842: aload 20
    //   2844: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2847: invokestatic 2748	obz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2850: aload_0
    //   2851: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2854: aload_0
    //   2855: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2858: invokestatic 2763	badq:h	(Landroid/content/Context;)Z
    //   2861: aload 20
    //   2863: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2866: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2869: aload 20
    //   2871: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2874: getfield 3288	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2877: aconst_null
    //   2878: iconst_0
    //   2879: aload 20
    //   2881: getfield 3176	pov:jdField_f_of_type_Int	I
    //   2884: aload 20
    //   2886: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2889: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2892: invokestatic 3424	obz:a	(JIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lorg/json/JSONObject;
    //   2895: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2898: astore 16
    //   2900: aconst_null
    //   2901: ldc_w 1364
    //   2904: ldc_w 1366
    //   2907: aload 14
    //   2909: aload 15
    //   2911: aload 15
    //   2913: iconst_0
    //   2914: iconst_0
    //   2915: new 578	java/lang/StringBuilder
    //   2918: dup
    //   2919: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2922: aload 20
    //   2924: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2927: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2930: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2933: ldc_w 1366
    //   2936: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2942: new 578	java/lang/StringBuilder
    //   2945: dup
    //   2946: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2949: aload 20
    //   2951: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2954: getfield 3109	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2957: invokevirtual 678	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2960: ldc_w 1366
    //   2963: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2966: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2969: new 578	java/lang/StringBuilder
    //   2972: dup
    //   2973: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   2976: aload 20
    //   2978: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2981: getfield 3396	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2984: invokevirtual 588	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2987: ldc_w 1366
    //   2990: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2993: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2996: aload 16
    //   2998: iconst_0
    //   2999: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3002: goto -1277 -> 1725
    //   3005: aload 20
    //   3007: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3010: invokestatic 1342	obz:n	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3013: ifeq -1288 -> 1725
    //   3016: aconst_null
    //   3017: aconst_null
    //   3018: ldc_w 3311
    //   3021: ldc_w 3311
    //   3024: iconst_0
    //   3025: iconst_0
    //   3026: ldc_w 1366
    //   3029: ldc_w 1366
    //   3032: ldc_w 1366
    //   3035: aload 14
    //   3037: iconst_0
    //   3038: invokestatic 3258	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3041: goto -1316 -> 1725
    //   3044: aload 20
    //   3046: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3049: invokestatic 3427	obz:u	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3052: ifeq +92 -> 3144
    //   3055: aload 20
    //   3057: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3060: getfield 3431	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lpqe;
    //   3063: getfield 3434	pqe:jdField_a_of_type_Int	I
    //   3066: ifne +18 -> 3084
    //   3069: aload 20
    //   3071: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3074: aload_0
    //   3075: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3078: invokestatic 3437	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommend:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3081: goto -1356 -> 1725
    //   3084: aload 20
    //   3086: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3089: getfield 3431	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lpqe;
    //   3092: getfield 3434	pqe:jdField_a_of_type_Int	I
    //   3095: iconst_1
    //   3096: if_icmpne +18 -> 3114
    //   3099: aload 20
    //   3101: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3104: aload_0
    //   3105: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3108: invokestatic 3440	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowList:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3111: goto -1386 -> 1725
    //   3114: aload 20
    //   3116: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3119: getfield 3431	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lpqe;
    //   3122: getfield 3434	pqe:jdField_a_of_type_Int	I
    //   3125: iconst_2
    //   3126: if_icmpne -1401 -> 1725
    //   3129: aload 20
    //   3131: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3134: aload_0
    //   3135: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3138: invokestatic 3443	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowGroup:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3141: goto -1416 -> 1725
    //   3144: aload 20
    //   3146: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3149: getfield 3108	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedType	I
    //   3152: bipush 33
    //   3154: if_icmpne +37 -> 3191
    //   3157: aload 20
    //   3159: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3162: invokevirtual 3446	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getProteusItemData	()Lorg/json/JSONObject;
    //   3165: astore 14
    //   3167: aload 14
    //   3169: ifnull -3125 -> 44
    //   3172: iconst_0
    //   3173: aload 14
    //   3175: aload 20
    //   3177: invokestatic 3449	obz:a	(ZLorg/json/JSONObject;Lpov;)V
    //   3180: iconst_1
    //   3181: aload 14
    //   3183: aload 20
    //   3185: invokestatic 3449	obz:a	(ZLorg/json/JSONObject;Lpov;)V
    //   3188: goto -1463 -> 1725
    //   3191: aload 20
    //   3193: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3196: invokestatic 3451	obz:q	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3199: ifeq +16 -> 3215
    //   3202: aload 20
    //   3204: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3207: aload 20
    //   3209: invokestatic 3454	obz:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Lpov;)V
    //   3212: goto -1487 -> 1725
    //   3215: aload 20
    //   3217: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3220: invokestatic 1223	obz:i	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3223: ifeq +135 -> 3358
    //   3226: aload 20
    //   3228: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3231: astore 16
    //   3233: aload 16
    //   3235: getfield 3455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lppz;
    //   3238: invokestatic 3458	obz:a	(Lppz;)Lorg/json/JSONObject;
    //   3241: astore 17
    //   3243: aconst_null
    //   3244: ldc_w 1364
    //   3247: ldc_w 1366
    //   3250: aload 20
    //   3252: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3255: ldc_w 3460
    //   3258: ldc_w 3460
    //   3261: iconst_0
    //   3262: iconst_0
    //   3263: new 578	java/lang/StringBuilder
    //   3266: dup
    //   3267: invokespecial 579	java/lang/StringBuilder:<init>	()V
    //   3270: aload 20
    //   3272: getfield 3338	pov:jdField_k_of_type_Int	I
    //   3275: invokevirtual 588	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3278: ldc_w 1366
    //   3281: invokevirtual 585	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: invokevirtual 592	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3287: aload 20
    //   3289: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3292: invokevirtual 662	java/lang/Long:longValue	()J
    //   3295: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3298: aload 16
    //   3300: getfield 3455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lppz;
    //   3303: getfield 3461	ppz:jdField_d_of_type_Long	J
    //   3306: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3309: aload 17
    //   3311: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3314: iconst_0
    //   3315: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3318: aload 18
    //   3320: aload 16
    //   3322: getfield 3455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lppz;
    //   3325: getfield 3462	ppz:jdField_c_of_type_Long	J
    //   3328: invokestatic 574	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3331: invokevirtual 2949	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   3334: ifne -3174 -> 160
    //   3337: aload 18
    //   3339: aload 16
    //   3341: getfield 3455	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lppz;
    //   3344: getfield 3462	ppz:jdField_c_of_type_Long	J
    //   3347: invokestatic 574	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3350: iconst_1
    //   3351: invokestatic 641	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3354: invokevirtual 1004	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3357: pop
    //   3358: new 2758	qmv
    //   3361: dup
    //   3362: aload 14
    //   3364: invokespecial 2772	qmv:<init>	(Ljava/lang/String;)V
    //   3367: astore 16
    //   3369: aload 16
    //   3371: aload 20
    //   3373: getfield 3464	pov:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3376: invokestatic 2781	obz:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3379: invokestatic 641	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3382: invokevirtual 2784	qmv:a	(Ljava/lang/Boolean;)Lqmv;
    //   3385: aload 20
    //   3387: getfield 3464	pov:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3390: getfield 3196	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   3393: invokevirtual 2786	qmv:a	(Ljava/lang/String;)Lqmv;
    //   3396: aload 20
    //   3398: getfield 3464	pov:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3401: invokevirtual 3466	qmv:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   3404: pop
    //   3405: aload_0
    //   3406: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3409: ldc_w 1626
    //   3412: if_icmpne +224 -> 3636
    //   3415: aload 16
    //   3417: aload 20
    //   3419: getfield 3178	pov:jdField_j_of_type_Int	I
    //   3422: invokevirtual 3468	qmv:b	(I)Lqmv;
    //   3425: pop
    //   3426: aconst_null
    //   3427: ldc_w 1364
    //   3430: ldc_w 1366
    //   3433: aload 20
    //   3435: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3438: ldc_w 3470
    //   3441: ldc_w 3470
    //   3444: iconst_0
    //   3445: iconst_0
    //   3446: aload 20
    //   3448: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3451: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3454: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3457: aload 20
    //   3459: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3462: invokevirtual 662	java/lang/Long:longValue	()J
    //   3465: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3468: aload 20
    //   3470: getfield 2147	pov:jdField_b_of_type_Int	I
    //   3473: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3476: aload 16
    //   3478: invokevirtual 2793	qmv:a	()Lqmu;
    //   3481: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   3484: iconst_0
    //   3485: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3488: ldc_w 3470
    //   3491: aload 20
    //   3493: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3496: aload 20
    //   3498: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3501: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3504: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3507: aload 20
    //   3509: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3512: invokevirtual 662	java/lang/Long:longValue	()J
    //   3515: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3518: aload 20
    //   3520: getfield 2147	pov:jdField_b_of_type_Int	I
    //   3523: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3526: aload 20
    //   3528: getfield 2143	pov:jdField_a_of_type_Long	J
    //   3531: aload 20
    //   3533: getfield 3169	pov:jdField_c_of_type_Int	I
    //   3536: aload_0
    //   3537: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3540: aload 20
    //   3542: getfield 3170	pov:jdField_d_of_type_Int	I
    //   3545: aload 20
    //   3547: getfield 3173	pov:jdField_e_of_type_Int	I
    //   3550: aload_0
    //   3551: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   3554: invokestatic 2763	badq:h	(Landroid/content/Context;)Z
    //   3557: aload 20
    //   3559: getfield 3174	pov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3562: aload 20
    //   3564: getfield 3175	pov:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3567: aload 20
    //   3569: getfield 2161	pov:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3572: aload 20
    //   3574: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3577: invokestatic 2768	obz:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   3580: aload 20
    //   3582: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3585: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   3588: lload 8
    //   3590: iload 7
    //   3592: aload 20
    //   3594: getfield 3176	pov:jdField_f_of_type_Int	I
    //   3597: aload 20
    //   3599: getfield 3177	pov:jdField_g_of_type_Int	I
    //   3602: aload 20
    //   3604: getfield 3161	pov:jdField_h_of_type_Int	I
    //   3607: aload 20
    //   3609: getfield 3164	pov:jdField_f_of_type_Boolean	Z
    //   3612: aload 20
    //   3614: getfield 3178	pov:jdField_j_of_type_Int	I
    //   3617: aload 20
    //   3619: getfield 3179	pov:jdField_i_of_type_Int	I
    //   3622: aload 20
    //   3624: getfield 3181	pov:m	I
    //   3627: invokestatic 3184	obz:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   3630: invokestatic 2754	ndn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3633: goto -1908 -> 1725
    //   3636: aload_0
    //   3637: getfield 92	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_f_of_type_Int	I
    //   3640: iconst_3
    //   3641: if_icmpne +51 -> 3692
    //   3644: iconst_m1
    //   3645: istore 6
    //   3647: iload 6
    //   3649: istore 5
    //   3651: aload_0
    //   3652: getfield 267	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Nhw	Lnhw;
    //   3655: ifnull +29 -> 3684
    //   3658: iload 6
    //   3660: istore 5
    //   3662: aload_0
    //   3663: getfield 267	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Nhw	Lnhw;
    //   3666: instanceof 3472
    //   3669: ifeq +15 -> 3684
    //   3672: aload_0
    //   3673: getfield 267	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Nhw	Lnhw;
    //   3676: checkcast 3472	nhx
    //   3679: invokevirtual 3473	nhx:a	()I
    //   3682: istore 5
    //   3684: aload 16
    //   3686: iload 5
    //   3688: invokevirtual 3475	qmv:O	(I)Lqmv;
    //   3691: pop
    //   3692: aload 16
    //   3694: aload 20
    //   3696: getfield 3464	pov:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3699: invokevirtual 3477	qmv:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqmv;
    //   3702: pop
    //   3703: aload 20
    //   3705: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3708: ifnull +113 -> 3821
    //   3711: aload 20
    //   3713: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3716: getfield 3481	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3719: ifnull +102 -> 3821
    //   3722: aload 20
    //   3724: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3727: getfield 3481	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3730: aconst_null
    //   3731: invokevirtual 3487	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3734: astore 17
    //   3736: aload 17
    //   3738: ifnull +83 -> 3821
    //   3741: aload 17
    //   3743: invokeinterface 3491 1 0
    //   3748: ifnull +73 -> 3821
    //   3751: aload 17
    //   3753: invokeinterface 3491 1 0
    //   3758: invokeinterface 3494 1 0
    //   3763: astore 17
    //   3765: aload 17
    //   3767: ifnull +54 -> 3821
    //   3770: aload 17
    //   3772: invokeinterface 391 1 0
    //   3777: ifeq +44 -> 3821
    //   3780: aload 17
    //   3782: invokeinterface 395 1 0
    //   3787: checkcast 3496	java/util/Map$Entry
    //   3790: astore 21
    //   3792: aload 16
    //   3794: aload 21
    //   3796: invokeinterface 3499 1 0
    //   3801: checkcast 747	java/lang/String
    //   3804: aload 21
    //   3806: invokeinterface 3502 1 0
    //   3811: invokevirtual 3503	java/lang/Object:toString	()Ljava/lang/String;
    //   3814: invokevirtual 3506	qmv:a	(Ljava/lang/String;Ljava/lang/Object;)Lqmv;
    //   3817: pop
    //   3818: goto -53 -> 3765
    //   3821: aload 15
    //   3823: aload 20
    //   3825: aload 16
    //   3827: invokestatic 3509	obz:a	(Ljava/lang/String;Lpov;Lqmv;)V
    //   3830: aconst_null
    //   3831: ldc_w 1364
    //   3834: ldc_w 1366
    //   3837: aload 20
    //   3839: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3842: aload 15
    //   3844: aload 15
    //   3846: iconst_0
    //   3847: iconst_0
    //   3848: aload 20
    //   3850: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3853: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3856: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3859: aload 20
    //   3861: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3864: invokevirtual 662	java/lang/Long:longValue	()J
    //   3867: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3870: aload 20
    //   3872: getfield 2147	pov:jdField_b_of_type_Int	I
    //   3875: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3878: aload 16
    //   3880: invokevirtual 2793	qmv:a	()Lqmu;
    //   3883: invokevirtual 2796	qmu:a	()Ljava/lang/String;
    //   3886: iconst_0
    //   3887: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3890: aload 20
    //   3892: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3895: getfield 3481	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3898: invokestatic 3514	rsk:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
    //   3901: astore 17
    //   3903: aload 14
    //   3905: astore 16
    //   3907: aload 17
    //   3909: ifnull +173 -> 4082
    //   3912: aload 17
    //   3914: invokeinterface 386 1 0
    //   3919: astore 21
    //   3921: aload 14
    //   3923: astore 16
    //   3925: aload 21
    //   3927: invokeinterface 391 1 0
    //   3932: ifeq +150 -> 4082
    //   3935: aload 21
    //   3937: invokeinterface 395 1 0
    //   3942: checkcast 747	java/lang/String
    //   3945: astore 17
    //   3947: new 1945	org/json/JSONObject
    //   3950: dup
    //   3951: aload 14
    //   3953: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3956: astore 16
    //   3958: aload 20
    //   3960: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3963: getfield 3481	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3966: aload 17
    //   3968: invokevirtual 3487	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3971: astore 17
    //   3973: aload 17
    //   3975: ifnull +462 -> 4437
    //   3978: aload 16
    //   3980: aload 17
    //   3982: invokestatic 3517	rsk:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   3985: aload 16
    //   3987: invokevirtual 1992	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3990: astore 16
    //   3992: aload 16
    //   3994: astore 14
    //   3996: aconst_null
    //   3997: ldc_w 1364
    //   4000: ldc_w 1366
    //   4003: aload 20
    //   4005: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4008: aload 15
    //   4010: aload 15
    //   4012: iconst_0
    //   4013: iconst_0
    //   4014: aload 20
    //   4016: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4019: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4022: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4025: aload 20
    //   4027: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4030: invokevirtual 662	java/lang/Long:longValue	()J
    //   4033: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4036: aload 20
    //   4038: getfield 2147	pov:jdField_b_of_type_Int	I
    //   4041: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4044: aload 14
    //   4046: iconst_0
    //   4047: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4050: goto -129 -> 3921
    //   4053: astore 17
    //   4055: aload 14
    //   4057: astore 16
    //   4059: aload 17
    //   4061: astore 14
    //   4063: ldc_w 534
    //   4066: iconst_1
    //   4067: ldc_w 3519
    //   4070: aload 14
    //   4072: invokestatic 3522	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4075: aload 16
    //   4077: astore 14
    //   4079: goto -158 -> 3921
    //   4082: aload 15
    //   4084: aload 20
    //   4086: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4089: aload 20
    //   4091: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4094: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4097: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4100: aload 20
    //   4102: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4105: invokevirtual 662	java/lang/Long:longValue	()J
    //   4108: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4111: aload 20
    //   4113: getfield 2147	pov:jdField_b_of_type_Int	I
    //   4116: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4119: aload 20
    //   4121: getfield 2143	pov:jdField_a_of_type_Long	J
    //   4124: aload 20
    //   4126: getfield 3169	pov:jdField_c_of_type_Int	I
    //   4129: aload_0
    //   4130: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4133: aload 20
    //   4135: getfield 3170	pov:jdField_d_of_type_Int	I
    //   4138: aload 20
    //   4140: getfield 3173	pov:jdField_e_of_type_Int	I
    //   4143: aload_0
    //   4144: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   4147: invokestatic 2763	badq:h	(Landroid/content/Context;)Z
    //   4150: aload 20
    //   4152: getfield 3174	pov:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4155: aload 20
    //   4157: getfield 3175	pov:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4160: aload 20
    //   4162: getfield 2161	pov:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4165: aload 20
    //   4167: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4170: invokestatic 2768	obz:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   4173: aload 20
    //   4175: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4178: checkcast 596	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   4181: lload 8
    //   4183: iload 7
    //   4185: aload 20
    //   4187: getfield 3176	pov:jdField_f_of_type_Int	I
    //   4190: aload 20
    //   4192: getfield 3177	pov:jdField_g_of_type_Int	I
    //   4195: aload 20
    //   4197: getfield 3161	pov:jdField_h_of_type_Int	I
    //   4200: aload 20
    //   4202: getfield 3164	pov:jdField_f_of_type_Boolean	Z
    //   4205: aload 20
    //   4207: getfield 3178	pov:jdField_j_of_type_Int	I
    //   4210: aload 20
    //   4212: getfield 3179	pov:jdField_i_of_type_Int	I
    //   4215: aload 20
    //   4217: getfield 3181	pov:m	I
    //   4220: invokestatic 3184	obz:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   4223: invokestatic 2754	ndn:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4226: sipush 250
    //   4229: invokestatic 3524	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   4232: ldc_w 3526
    //   4235: iconst_0
    //   4236: invokevirtual 1678	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   4239: iconst_1
    //   4240: if_icmpne -2515 -> 1725
    //   4243: aload_0
    //   4244: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4247: invokestatic 805	odm:c	(I)Z
    //   4250: ifne -2525 -> 1725
    //   4253: new 3528	ocg
    //   4256: dup
    //   4257: new 1945	org/json/JSONObject
    //   4260: dup
    //   4261: aload 16
    //   4263: invokespecial 2506	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4266: invokespecial 3531	ocg:<init>	(Lorg/json/JSONObject;)V
    //   4269: astore 14
    //   4271: invokestatic 3532	rvf:b	()I
    //   4274: ifle +84 -> 4358
    //   4277: iconst_0
    //   4278: istore 5
    //   4280: aload 14
    //   4282: ldc_w 3534
    //   4285: iload 5
    //   4287: invokevirtual 3537	ocg:b	(Ljava/lang/String;I)Locg;
    //   4290: pop
    //   4291: aconst_null
    //   4292: ldc_w 1364
    //   4295: ldc_w 1366
    //   4298: aload 20
    //   4300: getfield 3251	pov:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4303: ldc_w 3539
    //   4306: ldc_w 3539
    //   4309: iconst_0
    //   4310: iconst_0
    //   4311: aload 20
    //   4313: getfield 2167	pov:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4316: getfield 3252	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4319: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4322: aload 20
    //   4324: getfield 2136	pov:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4327: invokevirtual 662	java/lang/Long:longValue	()J
    //   4330: invokestatic 1380	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4333: aload 20
    //   4335: getfield 2147	pov:jdField_b_of_type_Int	I
    //   4338: invokestatic 1382	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4341: aload 14
    //   4343: invokevirtual 3540	ocg:a	()Ljava/lang/String;
    //   4346: iconst_0
    //   4347: invokestatic 1387	ndn:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4350: goto -2625 -> 1725
    //   4353: astore 14
    //   4355: goto -2630 -> 1725
    //   4358: iconst_1
    //   4359: istore 5
    //   4361: goto -81 -> 4280
    //   4364: ldc_w 3542
    //   4367: astore 14
    //   4369: goto -2247 -> 2122
    //   4372: astore 14
    //   4374: aload 14
    //   4376: invokevirtual 1993	org/json/JSONException:printStackTrace	()V
    //   4379: goto -2218 -> 2161
    //   4382: aload_0
    //   4383: getfield 225	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4386: ldc_w 1626
    //   4389: if_icmpeq +8 -> 4397
    //   4392: aload_0
    //   4393: aload_1
    //   4394: invokespecial 3544	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:e	(Ljava/util/Map;)V
    //   4397: aload_3
    //   4398: invokestatic 3154	rvf:a	(Ljava/util/Map;)V
    //   4401: aload_0
    //   4402: invokespecial 3166	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/util/Pair;
    //   4405: getfield 1283	android/util/Pair:first	Ljava/lang/Object;
    //   4408: checkcast 555	java/lang/Integer
    //   4411: invokevirtual 856	java/lang/Integer:intValue	()I
    //   4414: invokestatic 3545	que:a	(I)V
    //   4417: return
    //   4418: astore 17
    //   4420: aload 14
    //   4422: astore 16
    //   4424: aload 17
    //   4426: astore 14
    //   4428: goto -365 -> 4063
    //   4431: lconst_0
    //   4432: lstore 10
    //   4434: goto -2491 -> 1943
    //   4437: goto -387 -> 4050
    //   4440: goto -1606 -> 2834
    //   4443: goto -3637 -> 806
    //   4446: goto -3893 -> 553
    //   4449: iload_2
    //   4450: ifne -2999 -> 1451
    //   4453: iload 5
    //   4455: ifeq -3698 -> 757
    //   4458: goto -3007 -> 1451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4461	0	this	ReadInJoyListViewGroup
    //   0	4461	1	paramMap	Map<Long, pov>
    //   0	4461	2	paramBoolean	boolean
    //   0	4461	3	paramMap1	Map<Long, rvk>
    //   0	4461	4	paramString	String
    //   818	3636	5	k	int
    //   1874	1785	6	m	int
    //   226	3958	7	n	int
    //   213	3969	8	l1	long
    //   1941	2492	10	l2	long
    //   1853	196	12	l3	long
    //   61	1431	14	localObject1	Object
    //   1508	1	14	localException1	Exception
    //   1512	623	14	localObject2	Object
    //   2331	11	14	localNullPointerException	java.lang.NullPointerException
    //   2354	7	14	localJSONException1	JSONException
    //   2370	1972	14	localObject3	Object
    //   4353	1	14	localException2	Exception
    //   4367	1	14	str	String
    //   4372	49	14	localJSONException2	JSONException
    //   4426	1	14	localObject4	Object
    //   79	2290	15	localObject5	Object
    //   2375	7	15	localJSONException3	JSONException
    //   2391	1692	15	localObject6	Object
    //   101	4322	16	localObject7	Object
    //   2708	1273	17	localObject8	Object
    //   4053	7	17	localJSONException4	JSONException
    //   4418	7	17	localJSONException5	JSONException
    //   145	3193	18	localHashMap	HashMap
    //   158	13	19	localIterator	Iterator
    //   180	4154	20	localpov	pov
    //   3790	146	21	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   708	757	1508	java/lang/Exception
    //   757	764	1508	java/lang/Exception
    //   1405	1445	1508	java/lang/Exception
    //   1451	1473	1508	java/lang/Exception
    //   1478	1505	1508	java/lang/Exception
    //   2250	2328	2331	java/lang/NullPointerException
    //   1629	1661	2354	org/json/JSONException
    //   1661	1668	2354	org/json/JSONException
    //   2341	2351	2354	org/json/JSONException
    //   1680	1715	2375	org/json/JSONException
    //   3947	3973	4053	org/json/JSONException
    //   3978	3992	4053	org/json/JSONException
    //   4226	4277	4353	java/lang/Exception
    //   4280	4350	4353	java/lang/Exception
    //   2067	2117	4372	org/json/JSONException
    //   2122	2161	4372	org/json/JSONException
    //   3996	4050	4418	org/json/JSONException
  }
  
  public void a(Set<Long> paramSet, Map<Long, pov> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    a(new qqs(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Qod != null) {
      this.jdField_a_of_type_Qod.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Obl.jdField_b_of_type_Long = System.currentTimeMillis();
    if (h()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Obl.jdField_d_of_type_Long = bgmq.a((QQAppInterface)obz.a(), a());; this.jdField_a_of_type_Obl.jdField_d_of_type_Long = bgmq.a((QQAppInterface)obz.a(), this.jdField_a_of_type_Int))
    {
      r();
      ruf.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!a()) {
        break;
      }
      return;
    }
    j();
  }
  
  public void a(omr paramomr)
  {
    if (paramomr == null) {}
    for (;;)
    {
      return;
      int k = 0;
      while (k < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramomr.a((oml)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(k));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(k)), ", jobName : ", paramomr.a(), ", cost : ", Long.valueOf(l2 - l1) });
        k += 1;
      }
    }
  }
  
  public void a(qht paramqht1, qht paramqht2)
  {
    this.jdField_g_of_type_Boolean = false;
    ((omn)a(2)).j();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, aciy.a(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131167492), 0, 0);
    }
  }
  
  public void a(ree paramree)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramree);
      this.jdField_a_of_type_Ree = paramree;
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
      U();
    } while (!this.jdField_h_of_type_Boolean);
    a(new qqw(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.19(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      o();
      omf.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int n = 0;
    int k;
    int m;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      k = 0;
      for (paramInt = -1; k < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(); paramInt = m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(k);
        m = paramInt;
        if (localObject != null)
        {
          m = paramInt;
          if (((View)localObject).getTag() != null)
          {
            m = paramInt;
            if ((((View)localObject).getTag() instanceof omz))
            {
              localObject = (omz)((View)localObject).getTag();
              m = paramInt;
              if (paramLong == ((omz)localObject).jdField_a_of_type_Qht.jdField_c_of_type_Long) {
                m = ((omz)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        k += 1;
      }
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      k = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - m;
      if (k >= 0) {
        break label354;
      }
      k = n;
    }
    label354:
    for (;;)
    {
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() - m;
      if ((paramInt + 1 >= k) && (paramInt + 1 <= n))
      {
        this.jdField_a_of_type_Qod.a(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Qod.c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Nhw.a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + k + ", lastVisblePosi=" + n + "， headerCount=" + m);
        }
        return;
        this.jdField_a_of_type_Qod.a(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Qod.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Qod == null)) {
      return;
    }
    a(new qre(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Qod.getCount() == 0) {}
    int k = ogy.a().a(Integer.valueOf(paramInt));
    if (this.jdField_h_of_type_Boolean)
    {
      if ((paramList != null) && (k == 1)) {
        this.jdField_a_of_type_Qod.c(0);
      }
      this.jdField_h_of_type_Boolean = false;
    }
    pes.a().a();
    if (paramBoolean1) {
      if ((paramList != null) && (k > 0) && (paramList.size() > 0))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder("onChannelRefreshed ");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, ((StringBuilder)localObject).toString());
        }
        if (!this.jdField_a_of_type_Qod.i) {
          this.jdField_a_of_type_Qod.jdField_h_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Qod.i = true;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Qod.i + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Qod.jdField_h_of_type_Boolean);
        }
        pyw.a().c(true);
        setAdapterData(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Qod.a(0);
        if ((paramInt == 56) || (paramInt == 0))
        {
          localObject = obz.a();
          if (localObject != null) {
            ((nny)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
          }
        }
        if (paramInt == 70) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
        }
        if ((paramInt == 0) || (odm.c(this.jdField_a_of_type_Int))) {
          ohp.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
        b(paramBoolean1, k);
        if (this.jdField_a_of_type_Int == 70) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_Int == 56) && (this.i)) {
          if (this.jdField_a_of_type_Nti != null) {
            break label660;
          }
        }
      }
    }
    label660:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
      this.i = false;
      if ((odm.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      a(paramList);
      b(paramList);
      AbstractGifImage.resumeAll();
      omj.a(this.jdField_a_of_type_Qod.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Qod);
      oel.a(this.jdField_a_of_type_Qod.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Qod.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131652642), getResources().getDrawable(2130848176));
        break;
      }
      a(getResources().getString(2131652712));
      break;
      if (!this.jdField_a_of_type_Qod.isEmpty()) {
        break;
      }
      a(getResources().getString(2131652680));
      break;
    }
  }
  
  public void a(boolean paramBoolean1, SpannableString paramSpannableString, boolean paramBoolean2, int paramInt, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.17(this, paramBoolean2, paramInt, paramSpannableString, paramBoolean1, paramArticleInfo));
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qrs != null) {
      this.jdField_a_of_type_Qrs.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Qod != null) {
      this.jdField_a_of_type_Qod.a(2, null);
    }
    a(new qrn(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Qod != null) {
      omf.a(this.jdField_a_of_type_Qod.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Qod == null) || (paramList == null)) {}
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
        pyw.a().c(true);
        setAdapterData(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Qod.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Qod.isEmpty());
    a(getResources().getString(2131652712));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int k = 0;
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = obz.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L)) {
        break label205;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(162)).g()) {
        k = 4;
      }
      k |= 0x2;
    }
    for (;;)
    {
      int m;
      if ((this.jdField_a_of_type_Int == 40830) || (odm.c(this.jdField_a_of_type_Int)))
      {
        m = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (m + 1);
      }
      for (;;)
      {
        ogy.a().a(this.jdField_a_of_type_Int, b(), paramInt, k, m);
        ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.33(this));
        return;
        bool = false;
        break;
        m = 1;
      }
      label205:
      k = 0;
    }
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Qod == null))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    a(new qrg(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
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
        QLog.d("ReadInJoyListViewGroup", 2, "autoLoad:" + this.jdField_c_of_type_Boolean + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(getContext()));
      }
      if ((!this.jdField_c_of_type_Boolean) && (bool1) && (GesturePWDUtils.isAppOnForeground(getContext())) && (this.jdField_a_of_type_Int != 70))
      {
        paramList = getResources().getString(2131652507);
        bbmy.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      if ((odm.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      this.jdField_c_of_type_Boolean = false;
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label104;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Nhw.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Qod == null)) {
      return;
    }
    this.jdField_a_of_type_Qod.b(ogy.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Qod.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, pov> paramMap)
  {
    a(new qqr(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Njc != null) {
      this.jdField_a_of_type_Njc.a(paramMap);
    }
  }
  
  public boolean c()
  {
    int k = a().getIntent().getIntExtra("launch_from", -1);
    return (k == 9) || (k == 6);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    a(new qrb(this, "onPause"));
    if (this.jdField_a_of_type_Qod != null) {
      this.jdField_a_of_type_Qod.k();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rbg)localIterator.next()).d();
    }
    J();
    long l = System.currentTimeMillis();
    K();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.e();
    }
    omf.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void d(Map<Integer, pov> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        pov localpov = (pov)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int m = nti.jdField_b_of_type_Int;
        if ((localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int k = localpov.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; k = 0)
        {
          nti.a("0X8009495", localTabChannelCoverInfo, m, k, -1);
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
    oel.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    a(new qrc(this, "onStart"));
    pes.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_h_of_type_Boolean)) {
      a(1500, new ReadInJoyListViewGroup.26(this));
    }
  }
  
  public boolean e()
  {
    Boolean localBoolean = (Boolean)a(new qrr(this, "onBackPressed"));
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
    a(new qrd(this, "onStop"));
    if ((h()) && (i()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Qod.b(0);
      if (localArticleInfo != null) {
        ogy.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    pes.a().c();
  }
  
  public void g()
  {
    a(new qqy(this, "onDestroy"));
    bgmq.a(System.currentTimeMillis(), (QQAppInterface)obz.a());
    Object localObject = ((ohd)obz.a().getManager(163)).a().a();
    if (localObject != null) {
      ((oph)localObject).b(this.jdField_g_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Ajjh);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Qod.d();
    this.jdField_a_of_type_Qod.a();
    this.jdField_a_of_type_Qod.a(null);
    this.jdField_a_of_type_Qod = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      oel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
    }
    if (this.jdField_a_of_type_Ohe != null) {
      ohb.a().b(this.jdField_a_of_type_Ohe);
    }
    bgmq.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Nti != null)
    {
      this.jdField_a_of_type_Nti.a();
      this.jdField_a_of_type_Nti = null;
    }
    if (this.jdField_a_of_type_Qui != null)
    {
      this.jdField_a_of_type_Qui.b();
      this.jdField_a_of_type_Qui = null;
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((rbg)((Iterator)localObject).next()).b();
    }
    ((KandianMergeManager)obz.a().getManager(162)).b(this.jdField_a_of_type_Ogq);
    this.jdField_a_of_type_Ogq = null;
    rvb.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
    if (this.jdField_a_of_type_Naw != null) {
      this.jdField_a_of_type_Naw.b();
    }
    omf.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (odm.c(a())) {
      ocj.a().b();
    }
    pol.b(a());
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
    ((KandianMergeManager)obz.a().getManager(162)).b(this.jdField_a_of_type_Ogq);
  }
  
  public void l()
  {
    this.jdField_g_of_type_Boolean = true;
    ((omn)a(2)).i();
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
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  public void o()
  {
    qhp localqhp = this.jdField_a_of_type_Nhw.a();
    if ((localqhp != null) && (localqhp.a() != null)) {
      localqhp.b(11);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    Q();
    obz.b(3);
    a(true, 3, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_Qod.getItem((int)paramLong);
    ArticleInfo localArticleInfo = null;
    if ((localObject instanceof ArticleInfo))
    {
      localArticleInfo = (ArticleInfo)localObject;
      if (!obz.r(localArticleInfo)) {}
    }
    do
    {
      do
      {
        return;
      } while (localArticleInfo.mFeedType == 20);
      a(paramAdapterView, localArticleInfo, paramView, paramInt, paramLong);
    } while (localArticleInfo == null);
    localArticleInfo.invalidateProteusTemplateBean();
  }
  
  public void p()
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Qod != null) {
      this.jdField_a_of_type_Qod.notifyDataSetChanged();
    }
  }
  
  public void r()
  {
    if (obz.k() == 0) {}
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.42(this));
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Ree);
    }
  }
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Qod.a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((BaseArticleInfo)localIterator.next());
    }
    paramList = onu.a().a(this.jdField_a_of_type_Int, paramList, localArrayList, paramInt);
    if ((this.jdField_a_of_type_Int == 0) || (odm.b(odm.b()))) {
      this.jdField_a_of_type_Qod.a(true);
    }
    this.jdField_a_of_type_Qod.a(paramList);
    this.jdField_a_of_type_Qod.notifyDataSetChanged();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setNotifyEndRefresh(qrs paramqrs)
  {
    this.jdField_a_of_type_Qrs = paramqrs;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!pnh.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
    rec localrec = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    s();
    localrec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!pnh.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
      localrec = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      s();
      localrec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    rec localrec = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    s();
    localrec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.g();
    }
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.j();
    }
  }
  
  public void v()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(ajjy.a(2131647160));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */