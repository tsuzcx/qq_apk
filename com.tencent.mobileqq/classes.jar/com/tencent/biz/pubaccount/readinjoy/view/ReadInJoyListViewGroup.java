package com.tencent.biz.pubaccount.readinjoy.view;

import actn;
import ajxl;
import ajyc;
import akja;
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
import aria;
import arii;
import baxk;
import bbev;
import bbfd;
import bbjn;
import bcpw;
import bfob;
import bfpc;
import bfpd;
import bfwv;
import bhvh;
import bhvo;
import bkur;
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
import nlx;
import nmf;
import noo;
import npx;
import nsy;
import ntb;
import ntg;
import ntk;
import ntu;
import nun;
import nut;
import nyg;
import nzj;
import oes;
import ohi;
import olg;
import olm;
import olr;
import omk;
import omu;
import omw;
import ong;
import onk;
import onu;
import oot;
import oox;
import opw;
import org.json.JSONException;
import org.json.JSONObject;
import osb;
import osj;
import osm;
import oso;
import osp;
import ota;
import oto;
import otp;
import oxt;
import oxx;
import oxz;
import oya;
import oyc;
import oyf;
import oyg;
import oyo;
import oyy;
import ozj;
import ozy;
import pab;
import pai;
import pju;
import poy;
import pqm;
import pqt;
import pyp;
import pyq;
import pzc;
import qah;
import qar;
import qbq;
import qbr;
import qbu;
import qbv;
import qbx;
import qcc;
import qcd;
import qcl;
import qdc;
import qdd;
import qdf;
import qdh;
import qdj;
import qku;
import qkw;
import qol;
import qtu;
import qty;
import qup;
import qvi;
import qvn;
import qzd;
import qze;
import rao;
import rap;
import rbr;
import rbs;
import rbt;
import rbu;
import rca;
import rcy;
import rdb;
import rdc;
import rdd;
import rde;
import rdf;
import rdg;
import rdi;
import rdj;
import rdk;
import rdm;
import rdn;
import rdo;
import rdp;
import rdq;
import rdr;
import rds;
import rdt;
import rdu;
import rdv;
import rdw;
import rdx;
import rdz;
import rea;
import reb;
import rec;
import red;
import ree;
import rgq;
import rgs;
import rgu;
import rmc;
import rnx;
import rny;
import rom;
import rqq;
import rqs;
import rwa;
import sgj;
import sgx;
import shh;
import sht;
import shx;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import xlu;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, bfpc, bfpd, qvi, rbr, rbs, rbt, rbu, rca
{
  private long jdField_a_of_type_Long;
  private ajxl jdField_a_of_type_Ajxl = new rec(this);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<oya> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected baxk a;
  private bfob jdField_a_of_type_Bfob = new rcy(this);
  private bfwv jdField_a_of_type_Bfwv = new rdx(this);
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  Runnable jdField_a_of_type_JavaLangRunnable;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private nlx jdField_a_of_type_Nlx;
  private nun jdField_a_of_type_Nun;
  oes jdField_a_of_type_Oes;
  private osb jdField_a_of_type_Osb = new rea(this);
  private osp jdField_a_of_type_Osp;
  private qku jdField_a_of_type_Qku;
  private rao jdField_a_of_type_Rao;
  ree jdField_a_of_type_Ree;
  private rgu jdField_a_of_type_Rgu;
  private rqs jdField_a_of_type_Rqs;
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
  private List<rny> jdField_c_of_type_JavaUtilList = new ArrayList();
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
  private boolean k;
  
  public ReadInJoyListViewGroup(ntg paramntg, int paramInt1, int paramInt2, int paramInt3, omw paramomw)
  {
    this(paramntg, paramInt1, paramInt2, paramInt3, paramomw, 2131560023);
  }
  
  public ReadInJoyListViewGroup(ntg paramntg, int paramInt1, int paramInt2, int paramInt3, omw paramomw, int paramInt4)
  {
    super(paramntg, paramInt1, paramomw);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_e_of_type_Long = paramInt3;
    this.jdField_e_of_type_Boolean = qol.b();
    setId(2131374810);
    this.jdField_a_of_type_AndroidUtilSparseArray = oyf.a(this);
    b(paramInt1);
    E();
    if (paramInt1 != 41695) {
      C();
    }
    this.jdField_a_of_type_Omw.jdField_c_of_type_Long = bhvh.a((QQAppInterface)onk.a());
    a(new rdj(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(ntg paramntg, int paramInt1, int paramInt2, omw paramomw)
  {
    this(paramntg, paramInt1, paramInt2, -1, paramomw);
  }
  
  public ReadInJoyListViewGroup(ntg paramntg, int paramInt, omw paramomw)
  {
    this(paramntg, paramInt, -1, paramomw);
  }
  
  private void A()
  {
    this.jdField_a_of_type_Qku = qku.a();
    this.jdField_a_of_type_Qku.a(this.jdField_e_of_type_Long);
    if (this.jdField_a_of_type_Int == 56)
    {
      this.jdField_d_of_type_Long = a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      npx.jdField_a_of_type_Int = npx.a(a().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Ntg.a() != null)
    {
      this.jdField_a_of_type_Rao.a(this.jdField_a_of_type_Ntg.a(), this.jdField_a_of_type_Qku);
      return;
    }
    this.jdField_a_of_type_Rao.b();
  }
  
  private void B()
  {
    boolean bool = a().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Rao.a();
    int m;
    if ((bool) && ((a() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.jdField_e_of_type_Boolean) {
        break label220;
      }
      m = rap.c(localArticleInfo);
      if ((m != 6) && (m != 71)) {
        break label177;
      }
      this.jdField_e_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.jdField_d_of_type_Int = a().getIntent().getIntExtra("view_translation_animation_top", 0);
      omk.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int, this.jdField_e_of_type_Int, this.jdField_d_of_type_Int);
      c(this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nlx = new nlx(a(), true, this, this.jdField_a_of_type_Rao);
      this.jdField_a_of_type_Rao.a(this.jdField_a_of_type_Nlx);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.7(this));
      return;
      label177:
      if (m == 28)
      {
        m = bhvh.e(onk.a());
        omk.a(a(), localArticleInfo, a(), this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int, 0, m);
        c(m);
        continue;
        label220:
        this.jdField_a_of_type_Rao.i();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnTouchListener(new nsy(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView));
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_Int == 0) {
      if (!bhvh.k()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((rny)localIterator.next()).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jdField_c_of_type_JavaUtilList.add(new rom(getContext()));
      continue;
      if (this.jdField_a_of_type_Int == 56)
      {
        if (bhvh.A(onk.a()) != 2)
        {
          this.jdField_a_of_type_Oes = new oes(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          a(this.jdField_a_of_type_Oes.a());
        }
      }
      else if (this.jdField_a_of_type_Int == 70)
      {
        this.jdField_c_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(a()));
      }
      else if ((this.jdField_a_of_type_Int == 41523) && (bhvh.B(onk.a()) != 1))
      {
        this.jdField_a_of_type_Oes = new oes(a(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Oes.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Oes.a());
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
    if (bhvh.a(b())) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
    if (this.jdField_a_of_type_Int == 56) {
      osj.a().a(56);
    }
  }
  
  private void I()
  {
    boolean bool = this.jdField_a_of_type_Ntg.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((b()) && (!bool) && ((!bhvh.i()) || ((this.jdField_a_of_type_Ntg.a() instanceof ReadInJoyNewFeedsActivity))))
    {
      o();
      M();
    }
    if (((!bhvh.i()) || ((this.jdField_a_of_type_Ntg.a() instanceof ReadInJoyNewFeedsActivity))) && (this.jdField_a_of_type_Int == 56)) {
      npx.jdField_a_of_type_Int = npx.a(a().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_Int == 56)
    {
      this.k = false;
      this.j = false;
      this.jdField_a_of_type_Ntg.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Ntg.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Ntg.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Ntg.a().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void K()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((bhvh.j()) && ((this.jdField_a_of_type_Ntg.a() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        oso localoso = (oso)onk.a().getManager(163);
        localoso.a().a(this.jdField_a_of_type_Int, localParcelable);
        localoso.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
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
      Parcelable localParcelable = ((oso)onk.a().getManager(163)).a().a(this.jdField_a_of_type_Int);
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
      if (this.jdField_a_of_type_Ntg.a().getIntent().getIntExtra("channel_from", 0) != 1004) {
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
      long l = this.jdField_a_of_type_Ntg.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int m = this.jdField_a_of_type_Ntg.a().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Rao.a();
      if ((m == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label714;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = osj.a().a(Integer.valueOf(56));
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
          localObject2 = osj.a().b(Integer.valueOf(56));
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
            osj.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
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
          osj.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Rao.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rao);
          if (this.jdField_a_of_type_Oes == null) {}
          for (m = 0;; m = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(m, 0);
            this.jdField_a_of_type_Rao.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, rap.jdField_b_of_type_Int);
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
    int n = this.jdField_a_of_type_Rao.getCount();
    if (n > 0)
    {
      int m = 0;
      while (m < n)
      {
        Object localObject = this.jdField_a_of_type_Rao.getItem(m);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        m += 1;
      }
    }
  }
  
  private void P()
  {
    Object localObject = this.jdField_a_of_type_Rao.getItem(0);
    if ((this.jdField_a_of_type_Int == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localObject);
        localObject = sgj.b((QQAppInterface)onk.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        String str = sgj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        sgj.a(((BaseActivity)this.jdField_a_of_type_Ntg.a()).app, str, String.valueOf(this.jdField_a_of_type_Long), (String)localObject, true);
      }
    }
  }
  
  private void Q()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    View localView = findViewById(2131372592);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    R();
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_Int == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131374843));
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
      if (this.jdField_a_of_type_Rgu != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Rgu.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Rgu = null;
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
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372596));
    if (oox.c(this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372595));
      return;
    }
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131372594));
  }
  
  private void U()
  {
    if ((pqm.a().a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.jdField_h_of_type_Boolean))
    {
      a(true, 0, false);
      this.jdField_h_of_type_Boolean = true;
      return;
    }
    pqm.a().a();
  }
  
  private void V()
  {
    this.i = false;
    Activity localActivity = a();
    if (localActivity != null)
    {
      Intent localIntent = localActivity.getIntent();
      if ((localIntent != null) && (localIntent.hasExtra("arg_channel_rowkey")) && (localIntent.hasExtra("arg_channel_article_url")))
      {
        String str1 = localIntent.getStringExtra("arg_channel_rowkey");
        String str2 = localIntent.getStringExtra("arg_channel_article_url");
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          this.i = true;
          Bundle localBundle = new Bundle();
          localBundle.putString("floating_window_rowkey", str1);
          localBundle.putString("float_layer_article_url", str2);
          bhvo.a(localActivity, 5, 1, localBundle);
          QLog.i("ReadInJoyListViewGroup", 1, "[handleDailyJumpToRecommendChannel], open floating window, rowKey = " + str1 + ", articleURL = " + str2);
        }
        localIntent.removeExtra("arg_channel_rowkey");
        localIntent.removeExtra("arg_channel_article_url");
      }
    }
    if (oxx.a(a()))
    {
      a(true);
      QLog.i("ReadInJoyListViewGroup", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + a());
    }
  }
  
  private long a()
  {
    if ((i()) && (a().getIntent().getIntExtra("channel_from", -1) == 4))
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
    int n = 0;
    int m = 0;
    int i1 = -1;
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
      for (m = 0;; m = 1)
      {
        return new Pair(Integer.valueOf(m), Long.valueOf(l1));
        l1 = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)getContext()).b();
        break;
      }
    }
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if ((getContext() instanceof SplashActivity))
    {
      localReadinjoyTabFrame = onk.a(getContext());
      if (localReadinjoyTabFrame == null) {
        break label185;
      }
      if (localReadinjoyTabFrame.jdField_b_of_type_Int == 0) {}
    }
    label134:
    for (long l1 = localReadinjoyTabFrame.a();; l1 = 0L)
    {
      break;
      m = 1;
      break label134;
      m = i1;
      l1 = l2;
      if (!oox.c(this.jdField_a_of_type_Int)) {
        break;
      }
      if (olm.b() != 0) {}
      for (m = n;; m = 1)
      {
        l1 = l2;
        break;
      }
      label185:
      m = -1;
    }
  }
  
  private LinearLayout a()
  {
    if (oox.c(this.jdField_a_of_type_Int)) {
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
    qbr localqbr = (qbr)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    localArticleInfo.mStrategyId = localqbr.jdField_a_of_type_Int;
    localArticleInfo.mAlgorithmID = localqbr.jdField_b_of_type_Long;
    localArticleInfo.mTitle = localqbr.jdField_a_of_type_JavaLangString;
    localArticleInfo.mFirstPagePicUrl = localqbr.jdField_c_of_type_JavaLangString;
    localArticleInfo.mArticleContentUrl = localqbr.jdField_d_of_type_JavaLangString;
    localArticleInfo.mArticleID = localqbr.jdField_a_of_type_Long;
    localArticleInfo.mSubscribeID = localqbr.jdField_e_of_type_JavaLangString;
    localArticleInfo.mSubscribeName = localqbr.jdField_f_of_type_JavaLangString;
    localArticleInfo.innerUniqueID = localqbr.jdField_g_of_type_JavaLangString;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
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
    localIntent.putExtra("channel_name", ajyc.a(2131713065));
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!rap.q(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = rap.c(paramArticleInfo);
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
      npx.jdField_a_of_type_JavaUtilHashMap.put(ReadInJoyChannelActivity.class, npx.b());
      qvn.a().a(false, "jumpFromKandianFeed", 1);
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
      if (bhvh.i()) {
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
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131364591);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131166331));
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
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131166331));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      onk.a(a(), paramArticleInfo, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Rao.a(this.jdField_a_of_type_Rao.a(), paramArticleInfo.mArticleID)) {}
      onk.b(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", onk.f(0));
        onk.a(getContext(), str, localBundle);
        olg.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Rao);
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
    if (onk.s(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    qty localqty = new qty();
    localqty.jdField_c_of_type_Long = paramArticleInfo.mArticleID;
    localqty.jdField_e_of_type_Long = paramArticleInfo.mXGFileSize;
    localqty.jdField_h_of_type_JavaLangString = paramArticleInfo.thirdUin;
    localqty.jdField_i_of_type_JavaLangString = paramArticleInfo.thirdUinName;
    localqty.jdField_k_of_type_JavaLangString = paramArticleInfo.mSubscribeID;
    localqty.jdField_g_of_type_Int = paramArticleInfo.mStrategyId;
    localqty.jdField_g_of_type_Long = paramArticleInfo.mAlgorithmID;
    qbx localqbx = new qbx();
    localqbx.jdField_a_of_type_JavaLangLong = Long.valueOf(paramArticleInfo.mArticleID);
    localqbx.jdField_a_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!rap.a(paramArticleInfo)) && (!rap.i(paramArticleInfo)) && (!rap.j(paramArticleInfo)) && (!rap.k(paramArticleInfo))) || ((!rap.q(paramArticleInfo)) || ((onk.l(paramArticleInfo)) && (!rap.q(paramArticleInfo)))))
    {
      localqty.jdField_f_of_type_Int = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_f_of_type_Int;
      localqty.jdField_c_of_type_Int = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_a_of_type_Int;
      localqty.jdField_d_of_type_Int = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_b_of_type_Int;
      localqbx.jdField_a_of_type_Int = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_f_of_type_Int;
      localqty.jdField_b_of_type_Int = ((int)(((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_a_of_type_Long / 1000L));
      localqty.jdField_b_of_type_JavaLangString = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_d_of_type_JavaLangString;
      localqty.jdField_j_of_type_JavaLangString = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_g_of_type_JavaLangString;
      localqty.jdField_c_of_type_JavaLangString = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_i_of_type_JavaLangString;
      if ((onk.i(paramArticleInfo)) && (onk.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localqty.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localqbx.jdField_b_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localqty.a = localqbx;
        localqty.jdField_d_of_type_JavaLangString = paramArticleInfo.thirdIcon;
        localqty.jdField_e_of_type_JavaLangString = paramArticleInfo.thirdName;
        localqty.jdField_f_of_type_JavaLangString = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localqty.jdField_h_of_type_Int = localObject[0];
          localqty.jdField_i_of_type_Int = localObject[1];
          localqty.jdField_j_of_type_Int = paramView.getWidth();
          localqty.jdField_k_of_type_Int = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
          {
            localObject = omu.a(3, this.jdField_a_of_type_Int);
            int m = localqty.jdField_h_of_type_Int;
            localqty.jdField_h_of_type_Int = ((localqty.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + m);
            localqty.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
          }
        }
        localObject = new qcd();
        ((qcd)localObject).jdField_a_of_type_Int = 409409;
        if ((!rmc.a().b()) || (this.jdField_a_of_type_Int != 56)) {
          break label834;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0) {
        npx.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, (qcd)localObject);
      }
      osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Rao.notifyDataSetChanged();
      return;
      localqty.jdField_b_of_type_JavaLangString = ((qdf)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.b.get(0)).jdField_d_of_type_JavaLangString;
      break label403;
      if ((onk.i(paramArticleInfo)) && (onk.a(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localqty.jdField_b_of_type_JavaLangString = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localqty.jdField_c_of_type_JavaLangString = paramArticleInfo.mVideoVid;
        localqty.jdField_f_of_type_Int = paramArticleInfo.busiType;
        localqty.jdField_c_of_type_Int = paramArticleInfo.mVideoJsonWidth;
        localqty.jdField_d_of_type_Int = paramArticleInfo.mVideoJsonHeight;
        localqbx.jdField_a_of_type_Int = paramArticleInfo.busiType;
        localqty.jdField_b_of_type_Int = paramArticleInfo.mVideoDuration;
        localqty.jdField_j_of_type_JavaLangString = paramArticleInfo.innerUniqueID;
        localqty.jdField_g_of_type_JavaLangString = paramArticleInfo.mThirdVideoURL;
        localqty.jdField_f_of_type_Long = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localqty.jdField_b_of_type_JavaLangString = ((String)localObject);
        break;
      }
      label834:
      this.jdField_a_of_type_Rao.a(localqty, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.jdField_a_of_type_Int == 0) && (qol.b(a(), paramArticleInfo)))
    {
      a(paramArticleInfo);
      return;
    }
    if ((this.jdField_a_of_type_Int != 0) || (onk.i(paramArticleInfo)) || (onk.m(paramArticleInfo)) || (onk.n(paramArticleInfo)))
    {
      if (onk.n(paramArticleInfo)) {
        a(paramArticleInfo, (qbr)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(paramInt3), paramView);
      }
      for (;;)
      {
        osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Rao.notifyDataSetChanged();
        }
        if (!onk.l(paramArticleInfo)) {
          break;
        }
        paramView = shx.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, shx.a(paramArticleInfo), paramArticleInfo.videoReportInfo);
        noo.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.jdField_b_of_type_Long), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        onk.a(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Rao, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        a(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new qcd();
        paramView.jdField_a_of_type_Int = paramInt1;
        npx.a(paramArticleInfo, this.jdField_a_of_type_Int, 24, -1L, paramView);
      }
      if ((rap.c(paramArticleInfo) == 6) || (rap.c(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Rao.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      nut.b(a(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (bhvh.d(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Rao, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
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
  
  private void a(ArticleInfo paramArticleInfo, qbr paramqbr, View paramView)
  {
    qty localqty = new qty();
    if (paramqbr.jdField_a_of_type_Qbu == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localqty.jdField_c_of_type_Long = paramqbr.jdField_a_of_type_Long;
      localqty.jdField_h_of_type_JavaLangString = (paramqbr.jdField_a_of_type_Qbu.jdField_b_of_type_Long + "");
      localqty.jdField_i_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_d_of_type_JavaLangString;
      localqty.jdField_k_of_type_JavaLangString = paramqbr.jdField_e_of_type_JavaLangString;
      localqty.jdField_g_of_type_Int = paramqbr.jdField_a_of_type_Int;
      localqty.jdField_g_of_type_Long = paramqbr.jdField_b_of_type_Long;
      Object localObject = new qbx();
      ((qbx)localObject).jdField_a_of_type_JavaLangLong = Long.valueOf(paramqbr.jdField_a_of_type_Long);
      ((qbx)localObject).jdField_a_of_type_JavaLangString = paramqbr.jdField_g_of_type_JavaLangString;
      ((qbx)localObject).jdField_a_of_type_Int = paramqbr.jdField_a_of_type_Qbu.jdField_a_of_type_Int;
      ((qbx)localObject).jdField_b_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString;
      localqty.a = ((qbx)localObject);
      localqty.jdField_b_of_type_JavaLangString = paramqbr.jdField_c_of_type_JavaLangString;
      localqty.jdField_c_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_a_of_type_JavaLangString;
      localqty.jdField_f_of_type_Int = paramqbr.jdField_a_of_type_Qbu.jdField_a_of_type_Int;
      localqty.jdField_c_of_type_Int = paramqbr.jdField_a_of_type_Qbu.jdField_b_of_type_Int;
      localqty.jdField_d_of_type_Int = paramqbr.jdField_a_of_type_Qbu.jdField_c_of_type_Int;
      localqty.jdField_b_of_type_Int = paramqbr.jdField_a_of_type_Qbu.jdField_d_of_type_Int;
      localqty.jdField_e_of_type_Long = paramqbr.jdField_a_of_type_Qbu.jdField_a_of_type_Long;
      localqty.jdField_j_of_type_JavaLangString = paramqbr.jdField_g_of_type_JavaLangString;
      localqty.jdField_g_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_b_of_type_JavaLangString;
      localqty.jdField_d_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_f_of_type_JavaLangString;
      localqty.jdField_e_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_e_of_type_JavaLangString;
      localqty.jdField_f_of_type_JavaLangString = paramqbr.jdField_a_of_type_Qbu.jdField_g_of_type_JavaLangString;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localqty.jdField_h_of_type_Int = localObject[0];
        localqty.jdField_i_of_type_Int = localObject[1];
        localqty.jdField_j_of_type_Int = paramView.getWidth();
        localqty.jdField_k_of_type_Int = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).jdField_a_of_type_Boolean))
        {
          localObject = omu.a(3, this.jdField_a_of_type_Int);
          int m = localqty.jdField_h_of_type_Int;
          localqty.jdField_h_of_type_Int = ((localqty.jdField_j_of_type_Int - ((Integer)((Pair)localObject).first).intValue()) / 2 + m);
          localqty.jdField_j_of_type_Int = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new qcd();
      ((qcd)localObject).jdField_a_of_type_Int = 409409;
      this.jdField_a_of_type_Rao.a(localqty, paramArticleInfo);
      if (this.jdField_a_of_type_Int == 0) {
        npx.a(paramqbr.jdField_a_of_type_Long, paramqbr.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Int, (int)paramqbr.jdField_b_of_type_Long, paramqbr.jdField_a_of_type_Int, 24, -1L, (qcd)localObject, -1, paramqbr.jdField_k_of_type_JavaLangString);
      }
      osj.a().a(paramqbr.jdField_a_of_type_Long, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Rao.notifyDataSetChanged();
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Rgu == null)
    {
      if (onk.k() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Rgu = new rgs(a(), LayoutInflater.from(getContext()).inflate(2131560021, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Rgu.a(new reb(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Rgu.a());
      this.jdField_a_of_type_Rgu.a(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Rgu.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (onk.k() == 2) {
        this.jdField_a_of_type_Rgu = new rgq(a());
      }
    }
  }
  
  private void a(String paramString)
  {
    a(paramString, null);
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    findViewById(2131372592).setVisibility(8);
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131370728)).inflate();
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374766));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131374765));
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
    for (((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = actn.a(20.0F, getResources());; ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = actn.a(10.0F, getResources()))
    {
      R();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839020));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166740));
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (oox.c(this.jdField_a_of_type_Int)) {}
    for (int m = 2;; m = 1)
    {
      shh.a(localContext, m, new ReadInJoyListViewGroup.39(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = olr.a(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (qah.a(str)) {
        onk.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        qol.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int == 56) && (!this.jdField_a_of_type_Rao.b())) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    boolean bool3;
    boolean bool6;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Rao.getCount() == 0)
    {
      bool3 = true;
      bool6 = ntk.a(this.jdField_a_of_type_Int);
      if (!i()) {
        break label829;
      }
      localObject2 = ((BaseActivity)a()).app;
      localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
      if ((this.jdField_a_of_type_Int != 70) && (!oox.c(this.jdField_a_of_type_Int))) {
        break label662;
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
      int n;
      int m;
      label288:
      boolean bool1;
      if (this.jdField_a_of_type_Int == 70)
      {
        l1 = ((Integer)bhvh.a("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
        if (oox.a(this.jdField_a_of_type_Int)) {
          l1 = b();
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Omw.jdField_d_of_type_Long <= l1) {
          break label739;
        }
        bool4 = true;
        bool7 = j();
        if ((!b()) || (this.k)) {
          break label745;
        }
        bool2 = true;
        if ((!bhvh.j()) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L) || (!((KandianMergeManager)localObject1).g())) {
          break label751;
        }
        bool5 = true;
        n = 0;
        localObject1 = a();
        m = n;
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getIntent();
          m = n;
          if (localObject1 != null)
          {
            if (((Intent)localObject1).getIntExtra("launch_from", 0) != 15) {
              break label757;
            }
            m = 1;
          }
        }
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (m == 0)) {
          break label762;
        }
        bool1 = true;
        label324:
        QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
        if (!a()) {
          break label774;
        }
        bool4 = ntk.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!bool6)) {
          break label768;
        }
        bool1 = true;
        label471:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool6) }));
        paramBoolean = bool1;
      }
      for (;;)
      {
        QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
        if ((!paramBoolean) && (!oxx.a(this.jdField_a_of_type_Int))) {
          break label1384;
        }
        m = 1;
        label600:
        if (m == 0) {
          break label1398;
        }
        if ((this.jdField_a_of_type_Int == 0) || (oox.c(this.jdField_a_of_type_Int))) {
          ota.a().a.jdField_a_of_type_Boolean = true;
        }
        if ((!oox.c(this.jdField_a_of_type_Int)) || (oox.a())) {
          break label1389;
        }
        a(true, 1, false);
        label654:
        return true;
        bool3 = false;
        break;
        label662:
        if (this.jdField_a_of_type_Int == 40677)
        {
          localObject2 = (otp)((QQAppInterface)localObject2).getManager(274);
          if ((((otp)localObject2).a() != null) && (((otp)localObject2).a().size() > 0)) {}
          for (paramBoolean = true;; paramBoolean = false) {
            break;
          }
        }
        if (this.jdField_a_of_type_Int != 40830) {
          break label1453;
        }
        paramBoolean = true;
        break label113;
        l1 = 300000L;
        break label147;
        label739:
        bool4 = false;
        break label183;
        label745:
        bool2 = false;
        break label206;
        label751:
        bool5 = false;
        break label243;
        label757:
        m = 0;
        break label288;
        label762:
        bool1 = false;
        break label324;
        label768:
        bool1 = false;
        break label471;
        label774:
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
              if (!oox.c(this.jdField_a_of_type_Int)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
      label829:
      localObject1 = ((BaseActivity)a()).app;
      localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
      label869:
      boolean bool8;
      if (bhvh.a((QQAppInterface)localObject1))
      {
        bool1 = ((KandianMergeManager)localObject2).b();
        bool8 = a() instanceof ReadInJoyNewFeedsActivity;
        if (!bool8) {
          break label1182;
        }
        l1 = bhvh.h((AppRuntime)localObject1);
        label890:
        if (System.currentTimeMillis() - this.jdField_a_of_type_Omw.jdField_c_of_type_Long <= l1) {
          break label1192;
        }
        m = 1;
        label909:
        localObject1 = a().getIntent();
        bool7 = ((Intent)localObject1).getBooleanExtra("from_search", false);
        if ((!d()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
          break label1197;
        }
        bool4 = true;
        label951:
        if (d()) {
          ((Intent)localObject1).removeExtra("force_refresh");
        }
        if (a().getIntent().getIntExtra("launch_from", -1) != 8) {
          break label1203;
        }
        n = 1;
        label987:
        if (!a()) {
          break label1214;
        }
        bool5 = ntk.c(this.jdField_a_of_type_Int);
        if ((!bool3) && (!bool1) && (!bool7) && (!bool5) && (n == 0) && (!bool4) && (!bool6)) {
          break label1208;
        }
        bool2 = true;
        label1040:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool6) }));
        if (!bool3) {
          break label1350;
        }
        m = 1;
      }
      for (;;)
      {
        paramBoolean = bool2;
        if (!bool2) {
          break;
        }
        onk.b(m);
        paramBoolean = bool2;
        break;
        localObject2 = b();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          bool1 = true;
          break label869;
        }
        bool1 = false;
        break label869;
        label1182:
        l1 = bhvh.g((AppRuntime)localObject1);
        break label890;
        label1192:
        m = 0;
        break label909;
        label1197:
        bool4 = false;
        break label951;
        label1203:
        n = 0;
        break label987;
        label1208:
        bool2 = false;
        break label1040;
        label1214:
        if ((bool3) || (bool1) || (bool7) || ((m != 0) && (paramBoolean)) || (n != 0) || (bool4))
        {
          bool2 = true;
          label1249:
          if ((m == 0) || (!paramBoolean)) {
            break label1344;
          }
        }
        label1344:
        for (bool5 = true;; bool5 = false)
        {
          QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4) }));
          break;
          bool2 = false;
          break label1249;
        }
        label1350:
        if (bool1)
        {
          m = 1;
        }
        else if (bool7)
        {
          m = 1;
        }
        else
        {
          if ((m != 0) && (paramBoolean))
          {
            m = 6;
            continue;
            label1384:
            m = 0;
            break label600;
            label1389:
            a(true, 2);
            break label654;
            label1398:
            localObject1 = this.jdField_a_of_type_Omw;
            if (this.jdField_a_of_type_Omw.jdField_a_of_type_Long == 0L) {}
            for (l1 = l2;; l1 = this.jdField_a_of_type_Omw.jdField_a_of_type_Long)
            {
              ((omw)localObject1).jdField_a_of_type_Long = l1;
              if (this.jdField_a_of_type_Int == 0) {}
              return false;
            }
          }
          m = 1;
        }
      }
      label1453:
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
      int m = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int n = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(m), ", refreshInterval = ", Integer.valueOf(n) });
      l1 = l2;
      if (m == 1) {
        l1 = n * 60 * 1000;
      }
    }
    QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private List<Long> b()
  {
    Intent localIntent = this.jdField_a_of_type_Ntg.a().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int m = localIntent.getIntExtra("channel_id", 0);
    if (this.jdField_a_of_type_Int == m) {
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131376712));
    if (paramInt == 41695) {
      D();
    }
    if (oox.c(this.jdField_a_of_type_Int)) {
      onu.a().a();
    }
    this.jdField_a_of_type_Baxk = new baxk(a(), ((BaseActivity)a()).app);
    this.jdField_a_of_type_Rao = new rao(a(), a().getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Baxk, this.jdField_a_of_type_AndroidUtilSparseArray);
    a(new rdr(this, "onListViewGroupInit"));
    T();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Ntg + a());
    }
    y();
    x();
    A();
    z();
    Q();
    F();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_Ajxl);
    ((KandianMergeManager)onk.a().getManager(162)).a(this.jdField_a_of_type_Osb);
    B();
    w();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559828, this, false));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559829, this, false));
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void b(ArticleInfo paramArticleInfo)
  {
    onk.a(a(), paramArticleInfo, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
    osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Rao.notifyDataSetChanged();
    onk.a(a(), paramArticleInfo);
  }
  
  private void b(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      onk.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((rap.d(paramArticleInfo)) && (rap.c(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    onk.a(getContext(), paramArticleInfo, 3);
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList == null) || (paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (qbr)paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0), paramView);
  }
  
  private void b(List<Long> paramList)
  {
    Object localObject = onk.a();
    if ((!bhvh.z((AppRuntime)localObject)) || (!bhvh.A((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int m = 5;; m = paramList.size())
    {
      localObject = new ArrayList();
      int n = 0;
      while (n < m)
      {
        long l = ((Long)paramList.get(n)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Rao.a(this.jdField_a_of_type_Int, l);
        if ((localBaseArticleInfo != null) && (!onk.a(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        n += 1;
      }
    }
    osj.a().a().a((List)localObject);
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 0.0F);; localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.864F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new rdg(this));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
      return;
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
        str = getResources().getString(2131718464);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(true, str);
      N();
      if (!bhvh.i()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.30(this), 1500L);
      return;
      str = getResources().getString(2131718463);
      continue;
      if (this.jdField_a_of_type_Int == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718327), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131718326);
        }
      }
      else if (this.jdField_a_of_type_Int == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718327), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131718325);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131718327), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131718326);
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!oot.b()) {
      osm.a().n();
    }
    this.jdField_a_of_type_Omw.jdField_a_of_type_Long = System.currentTimeMillis();
    bhvh.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Omw.jdField_a_of_type_Long, (QQAppInterface)onk.a());
    osj localosj = null;
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
    int i1 = 0;
    int m = -1;
    QQAppInterface localQQAppInterface = ((BaseActivity)a()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == pab.a()))
    {
      if (!this.jdField_a_of_type_Omw.jdField_a_of_type_Boolean) {
        break label2165;
      }
      localObject1 = b();
      bool2 = h();
      this.jdField_a_of_type_Omw.jdField_a_of_type_Boolean = false;
      if (a().getIntent().getIntExtra("launch_from", -1) == 8) {
        bool1 = true;
      }
    }
    for (localObject4 = (LebaKDCellInfo)a().getIntent().getSerializableExtra("param_leba_cell_articleinfo");; localObject4 = localBundle)
    {
      int n;
      if (localObject1 == null)
      {
        localObject2 = localKandianMergeManager.a();
        if ((localObject2 != null) && (((List)localObject2).size() > 2))
        {
          l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
          l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
          localObject2 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
          localObject1 = localKandianMergeManager.a();
          n = 1;
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
                m = ((List)localObject5).size() - 1;
                for (;;)
                {
                  if (m >= 0)
                  {
                    ((List)localObject2).add(0, (Long)((List)localObject5).get(m));
                    m -= 1;
                    continue;
                    bool1 = false;
                    break;
                  }
                }
                m = 1;
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
        if (m != 0)
        {
          m = 32;
          onk.a(false);
        }
        for (;;)
        {
          long l3 = l1;
          i1 = n;
          localObject7 = localObject4;
          bool3 = bool1;
          n = m;
          l1 = l2;
          l2 = l3;
          bool1 = bool2;
          localObject4 = localObject5;
          m = i1;
          if (this.jdField_a_of_type_Int == 40830)
          {
            localObject8 = a().getIntent();
            localObject6 = localObject1;
            i1 = m;
            localObject5 = localObject2;
            if (localObject8 != null)
            {
              localObject9 = (ReadInJoyChannelActivity.SerializableMap)((Intent)localObject8).getSerializableExtra("channel_map_data");
              localObject6 = localObject1;
              i1 = m;
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
                i1 = 9;
                localObject6 = (String)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().get("pushContext");
                localObject5 = localObject2;
              }
            }
            localObject2 = localObject6;
            localObject1 = localObject5;
            m = i1;
            label656:
            if (this.jdField_a_of_type_Rao != null) {
              this.jdField_a_of_type_Rao.a(paramBoolean1);
            }
            localObject8 = new ArrayList();
            i1 = n;
            if (d())
            {
              ((List)localObject8).addAll(localKandianMergeManager.b());
              i1 = n | 0x80;
            }
            n = i1;
            if (pqm.a().a()) {
              n = i1 | 0x1000;
            }
            localObject9 = new ArrayList();
            if (this.jdField_a_of_type_Int == 56)
            {
              localObject5 = new poy();
              ((poy)localObject5).jdField_a_of_type_JavaLangString = "com.tencent.weishi";
              ((poy)localObject5).jdField_a_of_type_Boolean = bbfd.a(getContext(), ((poy)localObject5).jdField_a_of_type_JavaLangString);
              ((List)localObject9).add(localObject5);
            }
            if (localObject4 != null) {
              break label1877;
            }
            localObject5 = null;
            label803:
            if (localObject4 != null) {
              break label1887;
            }
            localObject4 = null;
            label811:
            if (this.jdField_a_of_type_Int != 70) {
              break label1900;
            }
            osj.a().a(true, (String)localObject2);
            oyy.a().a(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 1;
            this.jdField_c_of_type_Int += 1;
            shx.a(paramInt, this.jdField_a_of_type_Int, a(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
            return;
            if ((b()) && (!this.k))
            {
              l3 = this.jdField_a_of_type_Ntg.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
              bool1 = this.jdField_a_of_type_Ntg.a().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
              this.k = true;
              this.j = true;
              if (bool1)
              {
                localObject2 = (ArticleInfo)this.jdField_a_of_type_Ntg.a().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
                if (localObject2 == null) {
                  break label2096;
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
              ((JSONObject)localObject4).put("ArticleId", onk.a(((ArticleInfo)localObject2).mArticleID));
              ((JSONObject)localObject4).put("FeedsId", onk.a(((ArticleInfo)localObject2).mFeedId));
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
              m = 5;
              bool1 = false;
              localObject5 = localObject4;
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject5;
              n = i1;
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
              n = i1;
              break;
            }
            long l4;
            if ((this.jdField_a_of_type_Int == 56) && (this.jdField_e_of_type_Long == 1001L))
            {
              i1 = 2;
              localObject5 = localKandianMergeManager.b();
              n = m;
              localObject1 = localObject10;
              localObject3 = localosj;
              l4 = l2;
              l3 = l1;
              if (localObject5 != null)
              {
                if (!((KandianRedDotInfo)localObject5).hasArticleID()) {
                  break label1476;
                }
                localObject3 = ((KandianRedDotInfo)localObject5).articleIDList;
                localObject1 = ((KandianRedDotInfo)localObject5).cookie;
                l1 = ((KandianRedDotInfo)localObject5).algorithmID;
                l2 = ((KandianRedDotInfo)localObject5).strategyID;
                m = 1;
                i1 = 10;
              }
              for (;;)
              {
                localKandianMergeManager.m();
                l3 = l1;
                l4 = l2;
                n = m;
                bool1 = false;
                localObject4 = null;
                m = n;
                l2 = l4;
                l1 = l3;
                n = i1;
                break;
                label1476:
                i1 = 6;
                localObject1 = localObject9;
                localObject3 = localObject4;
              }
            }
            if (this.jdField_a_of_type_Int == 40677)
            {
              localObject6 = (otp)localQQAppInterface.getManager(274);
              n = m;
              localObject1 = localObject5;
              localObject3 = localObject8;
              if (((otp)localObject6).a() != null)
              {
                n = m;
                localObject1 = localObject5;
                localObject3 = localObject8;
                if (((otp)localObject6).a().size() > 0)
                {
                  localObject4 = new ArrayList(((otp)localObject6).a());
                  m = 8;
                  n = m;
                  localObject1 = localObject5;
                  localObject3 = localObject4;
                  if (!TextUtils.isEmpty(((otp)localObject6).a()))
                  {
                    localObject1 = ((otp)localObject6).a();
                    localObject3 = localObject4;
                    n = m;
                  }
                }
              }
              ((otp)localObject6).a(a());
              bool1 = false;
              localObject4 = null;
              m = n;
              n = i1;
              break;
              if (oox.c(this.jdField_a_of_type_Int))
              {
                localObject8 = (KandianRedDotInfo)a().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
                localObject6 = localObject1;
                i1 = m;
                l4 = l2;
                l3 = l1;
                localObject5 = localObject3;
                if (localObject8 != null)
                {
                  localObject6 = localObject1;
                  i1 = m;
                  l4 = l2;
                  l3 = l1;
                  localObject5 = localObject3;
                  if (!((KandianRedDotInfo)localObject8).shouldRemoveFloatingRedPntArticleId())
                  {
                    l3 = ((KandianRedDotInfo)localObject8).algorithmID;
                    l4 = ((KandianRedDotInfo)localObject8).strategyID;
                    localObject5 = ((KandianRedDotInfo)localObject8).articleIDList;
                    i1 = 1;
                    localObject6 = ((KandianRedDotInfo)localObject8).cookie;
                    a().getIntent().removeExtra("kandian_feeds_red_pnt_info");
                  }
                }
                localObject3 = localObject6;
                l2 = l4;
                l1 = l3;
                localObject1 = localObject5;
                m = i1;
                break label656;
              }
              l3 = a();
              if (this.jdField_a_of_type_Rao != null)
              {
                localObject5 = (ArticleInfo)this.jdField_a_of_type_Rao.b(0);
                if ((l3 != -1L) && (localObject5 != null) && (l3 != ((ArticleInfo)localObject5).mArticleID))
                {
                  localObject5 = new ArrayList();
                  ((List)localObject5).add(Long.valueOf(l3));
                  m = 6;
                  localObject3 = localObject1;
                  localObject1 = localObject5;
                  break label656;
                  label1877:
                  localObject5 = ((Pair)localObject4).first;
                  break label803;
                  label1887:
                  localObject4 = (String)((Pair)localObject4).second;
                  break label811;
                  label1900:
                  if ((this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 7)) {
                    n |= 0x800;
                  }
                  for (;;)
                  {
                    localBundle = new Bundle();
                    localBundle.putInt("FeedsRefreshType", this.jdField_b_of_type_Int);
                    localosj = osj.a();
                    i1 = this.jdField_a_of_type_Int;
                    int i2 = this.jdField_c_of_type_Int;
                    if ((localObject5 instanceof String))
                    {
                      localObject6 = (String)localObject5;
                      label1979:
                      if (!(localObject5 instanceof Long)) {
                        break label2051;
                      }
                    }
                    label2051:
                    for (l3 = ((Long)localObject5).longValue();; l3 = -1L)
                    {
                      localosj.a(i1, (List)localObject1, m, true, bool1, i2, (String)localObject6, l3, (String)localObject4, b(), l1, l2, (String)localObject3, paramInt, bool3, localObject7, n, (List)localObject8, (List)localObject9, localBundle);
                      break;
                      localObject6 = null;
                      break label1979;
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
            n = i1;
            break;
            label2096:
            localObject1 = null;
            localObject3 = localObject6;
          }
          m = 0;
        }
        m = 1;
        break label424;
        m = 0;
        break label424;
        localObject1 = null;
        l1 = 0L;
        l2 = 0L;
        n = -1;
        break;
        n = -1;
        localObject5 = null;
        l1 = 0L;
        l2 = 0L;
        Object localObject3 = localObject1;
        m = 0;
        localObject1 = localObject5;
      }
      label2165:
      localObject1 = null;
    }
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (qah.a(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = ong.a().a(paramArticleInfo, null, null);
      str = ong.a().a();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Rao.notifyDataSetChanged();
    onk.a(a(), paramArticleInfo, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
    onk.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private void c(int paramInt)
  {
    a().setLayerType(2, null);
    this.jdField_b_of_type_AndroidWidgetTextView.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetTextView, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new rdb(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(a(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new rdc(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private void c(ArticleInfo paramArticleInfo)
  {
    rnx.b("fast_web_show_light_house_1");
    pai localpai = osj.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (onk.s(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.jdField_a_of_type_Boolean) {
        localArticleInfo = a(paramArticleInfo);
      }
    }
    if (localpai != null) {
      this.jdField_g_of_type_Int = localpai.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    b(localArticleInfo);
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (onk.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      c(paramArticleInfo);
    }
    for (;;)
    {
      shx.a(paramArticleInfo);
      return;
      onk.a(a(), paramArticleInfo, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
    }
  }
  
  private void e(Map<Long, qar> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (qar)paramMap.next();
      if (!((qar)localObject2).jdField_b_of_type_Boolean)
      {
        ((qar)localObject2).jdField_b_of_type_Boolean = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = onk.a();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((qar)localObject2).jdField_a_of_type_JavaLangLong.longValue();
        localReportInfo.mChannelId = this.jdField_a_of_type_Int;
        localReportInfo.mAlgorithmId = ((int)((qar)localObject2).jdField_a_of_type_Long);
        localReportInfo.mStrategyId = ((qar)localObject2).jdField_b_of_type_Int;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((qar)localObject2).jdField_a_of_type_ArrayOfByte;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((qar)localObject2).jdField_e_of_type_JavaLangString;
        if (((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        Object localObject1;
        if (this.jdField_a_of_type_Int == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new qcd();
          if (this.jdField_d_of_type_Long != 0L) {
            break label606;
          }
        }
        label606:
        for (int m = 1;; m = 0)
        {
          ((qcd)localObject1).jdField_c_of_type_Int = m;
          localObject1 = ((qcd)localObject1).toString();
          localReportInfo.mInnerId = ((qar)localObject2).jdField_e_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo == null) || (((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new qcc();
          ((qcc)localObject1).jdField_a_of_type_Long = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
            ((qcc)localObject1).jdField_b_of_type_Long = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
          }
          ((qcc)localObject1).jdField_a_of_type_Int = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          ((qcc)localObject1).jdField_b_of_type_Int = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
          localObject2 = ((qar)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((qcc)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            qcl localqcl = (qcl)((Iterator)localObject2).next();
            if (localqcl != null) {
              ((qcc)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqcl.jdField_a_of_type_Long));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((qcc)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      osj.a().a(localArrayList);
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
    List localList = (List)this.jdField_a_of_type_Ntg.a().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l = ((Long)localList.get(0)).longValue(); Long.valueOf(l).longValue() != 0L; l = -1L) {
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
    if (!onk.p())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838514);
      int m = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(m);
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_Bfwv);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Bfob);
    if ((this.jdField_a_of_type_Int == 0) || (oox.c(this.jdField_a_of_type_Int))) {
      pyq.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
  }
  
  private void y()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    View localView2;
    int m;
    if ((this.jdField_a_of_type_Ntg instanceof ntb))
    {
      localActivity = a();
      if (localActivity.findViewById(2131361943) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361943);
        localView1 = localActivity.findViewById(2131376467);
        localView2 = findViewById(2131366608);
        if (oot.a())
        {
          m = 2131298586;
          m = getResources().getDimensionPixelOffset(m);
          m = actn.a(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + m;
          n = actn.a(50.0F, getResources());
          i1 = ImmersiveUtils.getStatusBarHeight(getContext());
          i2 = getResources().getDimensionPixelOffset(2131298585);
          localView2.setPadding(0, m, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, m, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + m);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyListViewGroup.5(this, localView1, m, n + i1 + i2, localView2));
        }
      }
      while (localActivity.findViewById(2131361944) == null) {
        for (;;)
        {
          int n;
          int i1;
          int i2;
          return;
          m = 2131298585;
        }
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131361944);
      localView1 = localActivity.findViewById(2131377375);
      m = actn.a(50.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label450;
      }
      m += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    label450:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, m, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + m);
      }
      localView2 = findViewById(2131366608);
      localView2.setPadding(0, m, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.6(this, localView1, m, localView2));
      return;
      if (!(this.jdField_a_of_type_Ntg instanceof ntu)) {
        break;
      }
      ((ntu)this.jdField_a_of_type_Ntg).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Rao);
      return;
    }
  }
  
  private void z()
  {
    this.jdField_a_of_type_Rao.b(b());
    this.jdField_a_of_type_Rao.a(this.jdField_e_of_type_Long);
    this.jdField_a_of_type_Rao.a(this);
    this.jdField_a_of_type_Rao.a(this);
    this.jdField_a_of_type_Rao.a(this);
    this.jdField_a_of_type_Rao.a(this);
    this.jdField_a_of_type_Rao.a(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Rao);
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public Object a(oyg paramoyg)
  {
    if (paramoyg == null) {
      return null;
    }
    int m = -1;
    int n = 0;
    Object localObject = null;
    long l1;
    if (n < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramoyg.a((oya)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n));
      if (paramoyg.a == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = paramoyg.a;
        m = ((oya)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n)).a();
        paramoyg.a = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(n)), ", jobName : ", paramoyg.a(), ", cost : ", Long.valueOf(l2 - l1) });
      n += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + m + ", now : " + ((oya)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(n)).a());
      return localObject;
    }
  }
  
  public List<rny> a()
  {
    return this.jdField_c_of_type_JavaUtilList;
  }
  
  public oya a()
  {
    return a(2);
  }
  
  public oya a(int paramInt)
  {
    return (oya)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public rao a()
  {
    return this.jdField_a_of_type_Rao;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    a(new rdm(this, "onResume"));
    V();
    if (a()) {
      j();
    }
    H();
    if (System.currentTimeMillis() - this.jdField_f_of_type_Long > 10000L)
    {
      this.jdField_f_of_type_Long = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.23(this));
    }
    if (this.jdField_a_of_type_Rao != null) {
      this.jdField_a_of_type_Rao.j();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rny)localIterator.next()).c();
    }
    r();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.jdField_a_of_type_Int == 0) || (oox.c(this.jdField_a_of_type_Int))) {
      pyq.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    }
    I();
    G();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    ((KandianMergeManager)onk.a().getManager(162)).a(this.jdField_a_of_type_Osb);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.24(this), 50L);
    qah.a(a());
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.jdField_a_of_type_Int);
    }
    if ((paramInt == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_Rao != null)) {
      a(true, 1001, true);
    }
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 2495	rdl
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 2497
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 2500	rdl:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 208	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Loyg;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 2503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 2503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 2504	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:c	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +36 -> 102
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne -40 -> 31
    //   74: aload_3
    //   75: ifnull -44 -> 31
    //   78: invokestatic 188	onk:a	()Lmqq/app/AppRuntime;
    //   81: checkcast 190	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 138	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 138	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   92: invokevirtual 2507	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 2512	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: return
    //   102: iload_1
    //   103: iconst_2
    //   104: if_icmpne +10 -> 114
    //   107: aload_0
    //   108: iconst_2
    //   109: aload_3
    //   110: invokevirtual 2503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
    //   113: return
    //   114: iload_1
    //   115: iconst_1
    //   116: if_icmpne +10 -> 126
    //   119: aload_0
    //   120: iconst_1
    //   121: aload_3
    //   122: invokevirtual 2503	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(ILandroid/content/Intent;)V
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
    //   145: invokevirtual 2516	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   148: ldc_w 2518
    //   151: invokevirtual 2521	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   154: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   157: astore_3
    //   158: aload_3
    //   159: ifnull -128 -> 31
    //   162: aload_0
    //   163: invokevirtual 138	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   166: aload_3
    //   167: aload_0
    //   168: getfield 275	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rao	Lrao;
    //   171: aload_0
    //   172: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   175: invokestatic 2143	onk:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lrap;I)V
    //   178: return
    //   179: iload_1
    //   180: bipush 117
    //   182: if_icmpne +19 -> 201
    //   185: aload_0
    //   186: invokevirtual 138	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/app/Activity;
    //   189: checkcast 740	com/tencent/mobileqq/app/BaseActivity
    //   192: getfield 744	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   195: aload_3
    //   196: iload_2
    //   197: invokestatic 2526	ohi:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   200: return
    //   201: iload_1
    //   202: sipush 20001
    //   205: if_icmpne +35 -> 240
    //   208: invokestatic 188	onk:a	()Lmqq/app/AppRuntime;
    //   211: astore_3
    //   212: aload_3
    //   213: ifnull -182 -> 31
    //   216: aload_3
    //   217: sipush 162
    //   220: invokevirtual 517	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 1617	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   226: invokevirtual 2528	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:q	()V
    //   229: ldc_w 533
    //   232: iconst_1
    //   233: ldc_w 2530
    //   236: invokestatic 540	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: return
    //   240: iload_1
    //   241: sipush 1032
    //   244: if_icmpne +176 -> 420
    //   247: aload_3
    //   248: ldc_w 2532
    //   251: invokevirtual 845	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore_3
    //   255: aload_3
    //   256: ifnull -225 -> 31
    //   259: new 1971	org/json/JSONObject
    //   262: dup
    //   263: aload_3
    //   264: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore_3
    //   268: new 1971	org/json/JSONObject
    //   271: dup
    //   272: invokespecial 1972	org/json/JSONObject:<init>	()V
    //   275: astore 4
    //   277: aload 4
    //   279: ldc_w 1016
    //   282: aload_0
    //   283: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   286: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 4
    //   292: ldc_w 2535
    //   295: aload_3
    //   296: ldc_w 2535
    //   299: invokevirtual 2538	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   302: invokevirtual 1980	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   305: pop
    //   306: aload 4
    //   308: ldc_w 2540
    //   311: ldc_w 1408
    //   314: invokevirtual 1980	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aconst_null
    //   319: ldc_w 1406
    //   322: ldc_w 1408
    //   325: ldc_w 1408
    //   328: ldc_w 2542
    //   331: ldc_w 2542
    //   334: iconst_0
    //   335: iconst_0
    //   336: new 577	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   343: aload_3
    //   344: ldc_w 2544
    //   347: invokevirtual 2538	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc_w 1408
    //   356: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: ldc_w 2546
    //   365: ldc_w 1408
    //   368: aload 4
    //   370: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   373: iconst_0
    //   374: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   377: return
    //   378: astore_3
    //   379: ldc_w 533
    //   382: iconst_1
    //   383: new 577	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 2548
    //   393: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_3
    //   397: invokevirtual 2549	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: return
    //   410: astore 5
    //   412: aload 5
    //   414: invokevirtual 531	java/lang/Exception:printStackTrace	()V
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
    //   437: ldc_w 2551
    //   440: invokevirtual 1969	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   443: astore_3
    //   444: aload_3
    //   445: instanceof 2553
    //   448: ifeq -417 -> 31
    //   451: aload_0
    //   452: getfield 275	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rao	Lrao;
    //   455: aload_3
    //   456: checkcast 2553	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   459: invokevirtual 2556	rao:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
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
    this.jdField_a_of_type_Rao.a(paramInt, paramIntent);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.jdField_a_of_type_Int == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        ohi.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        ohi.a(paramArticleInfo, paramString1);
        bcpw.a(a(), 0, a().getString(2131718370), 0).a();
        QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult failed " + paramInt);
    bcpw.a(a(), 1, paramString2, 0).a();
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    sgx.a(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rao == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setAdapterData(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = onk.a();
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
        localObject2 = osj.a().a(this.jdField_a_of_type_Int, ((Long)localObject1).longValue());
        localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label348;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = onk.c((String)localObject1);
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
      localObject1 = osj.a().a();
      if (localObject1 != null) {
        a(((ozy)localObject1).a(this.jdField_a_of_type_Int));
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 70)))
    {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = osj.a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
      localObject1 = (QQAppInterface)onk.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (localObject1 != null))
      {
        if (this.jdField_a_of_type_Int != 0) {
          break label863;
        }
        localObject1 = sgj.b((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        localObject2 = sgj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        sgj.a(((BaseActivity)this.jdField_a_of_type_Ntg.a()).app, (String)localObject2, String.valueOf(this.jdField_a_of_type_Long), (String)localObject1, false);
      }
    }
    this.jdField_a_of_type_Omw.jdField_b_of_type_Long = 0L;
    if (!this.jdField_f_of_type_Boolean)
    {
      bool = true;
      label578:
      this.jdField_d_of_type_Boolean = a(bool);
      if (a().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label934;
      }
    }
    for (int m = 1;; m = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)onk.a().getManager(162)).f();
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
          bool = onk.b(((ReadInJoyNewFeedsActivity)a()).b());
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
      if (m == 0) {
        break label951;
      }
      bool = true;
      if ((!this.jdField_d_of_type_Boolean) && (bool))
      {
        if ((m == 0) && (paramInt != 0)) {
          break label975;
        }
        L();
      }
      if (!this.jdField_d_of_type_Boolean) {
        opw.a(this.jdField_a_of_type_Rao.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = true;
      }
      if ((this.jdField_a_of_type_Int == 40677) && (paramList != null) && (!paramList.isEmpty()))
      {
        l = NetConnInfoCenter.getServerTime();
        localObject1 = (QQAppInterface)onk.a();
        if (localObject1 != null)
        {
          paramList = ((oso)((QQAppInterface)localObject1).getManager(163)).a().a(this.jdField_a_of_type_Int, ((Long)paramList.get(0)).longValue());
          if (paramList != null)
          {
            localObject2 = (otp)((QQAppInterface)localObject1).getManager(274);
            if (localObject2 != null) {
              ((otp)localObject2).a(sgj.a((QQAppInterface)localObject1, paramList), l);
            }
          }
        }
      }
      M();
      if ((this.jdField_a_of_type_Int == 0) && (pqm.a().b())) {
        U();
      }
      sgx.a("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      sgx.a("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      sgx.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      if (this.jdField_a_of_type_Int == 70)
      {
        ((KandianSubscribeManager)((QQAppInterface)localObject1).getManager(280)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Long);
        break;
      }
      if (!oox.c(this.jdField_a_of_type_Int)) {
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
      if (Boolean.valueOf(bhvh.s(onk.a())).booleanValue()) {
        rwa.a(paramContext, "", "http://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        osj.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Rao.notifyDataSetChanged();
        shx.a(paramArticleInfo);
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
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.jdField_h_of_type_Int) || ((!bkur.e()) && (!bkur.d()))) {
      return;
    }
    this.jdField_h_of_type_Int = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.42(this));
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
            onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
            a(new rdw(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (qol.a(paramArticleInfo, getContext()));
          paramInt = rap.c(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = rap.c(paramArticleInfo);
          if ((pyp.b(paramInt)) || (rap.i(paramArticleInfo)) || (rap.a(paramArticleInfo)) || (rap.j(paramArticleInfo)) || (rap.k(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (rap.a(paramArticleInfo) == 23) || (rap.b(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              onk.a(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdc.jdField_a_of_type_JavaLangString);
            }
            for (;;)
            {
              P();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                pju.a(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!rap.a(paramArticleInfo)) && (!rap.h(paramArticleInfo)) && (!onk.b(paramArticleInfo)) && (!onk.c(paramArticleInfo)) && (!onk.e(paramArticleInfo)) && (!onk.f(paramArticleInfo)));
        if (onk.a(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          pju.a(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      pju.a(getContext(), paramArticleInfo);
      return;
    }
    b(paramArticleInfo, 2);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    int i2 = this.jdField_a_of_type_Int;
    Object localObject1 = onk.c(paramArticleInfo);
    int m;
    int n;
    label36:
    int i1;
    label49:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      m = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label765;
      }
      n = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label770;
      }
      i1 = paramArticleInfo.videoJumpChannelID;
      noo.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.b(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), this.jdField_a_of_type_Int, m), false);
      noo.a("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.b(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), this.jdField_a_of_type_Int, m));
      localObject2 = shx.b(i2);
      if ((!rap.i(paramArticleInfo)) && (!rap.a(paramArticleInfo)) && (!rap.j(paramArticleInfo)) && (!rap.k(paramArticleInfo))) {
        break label777;
      }
      localObject3 = new qze(onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), i2, m, n, bbev.h(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), i1, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((qze)localObject3).i(i1).c((String)npx.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(onk.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      noo.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdd.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((qze)localObject3).a().a(), false);
    }
    for (;;)
    {
      noo.a((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), i2, m, n, bbev.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), i1, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = onk.a();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.jdField_a_of_type_Int;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!qah.a(paramArticleInfo)) && (!ong.a().a()) && (onk.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label932;
      }
      localObject3 = new qcc();
      ((qcc)localObject3).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl != null) {
        ((qcc)localObject3).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcl.jdField_a_of_type_Long;
      }
      ((qcc)localObject3).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((qcc)localObject3).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label925;
      }
      ((qcc)localObject3).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        qcl localqcl = (qcl)((Iterator)localObject4).next();
        if (localqcl != null) {
          ((qcc)localObject3).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localqcl.jdField_a_of_type_Long));
        }
      }
      m = 0;
      break;
      label765:
      n = 1;
      break label36;
      label770:
      i1 = 56;
      break label49;
      label777:
      localObject3 = new qze(onk.a(paramArticleInfo.mAlgorithmID, onk.a(paramArticleInfo), i2, m, n, bbev.h(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, onk.e(paramArticleInfo), i1, paramArticleInfo));
      if (this.jdField_a_of_type_Int == 0) {
        ((qze)localObject3).i(i1).c((String)npx.jdField_a_of_type_JavaUtilHashMap.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(onk.w(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      noo.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((qze)localObject3).a().a(), false);
    }
    label925:
    ((ReportInfo)localObject2).mFeedsReportData = ((qcc)localObject3);
    label932:
    ((List)localObject1).add(localObject2);
    osj.a().a((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!sht.a((AdvertisementInfo)paramArticleInfo, i2)) {
        break label1010;
      }
      m = nmf.R;
    }
    for (;;)
    {
      nmf.a(new nyg().a(BaseApplicationImpl.getContext()).a(nmf.jdField_a_of_type_Int).b(m).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1010:
      if (onk.a(paramArticleInfo)) {
        m = nmf.Q;
      } else {
        m = nmf.L;
      }
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (onk.s(localArticleInfo)) {
      if ((onk.m(localArticleInfo)) || (onk.c(localArticleInfo)))
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
        if (oox.c(this.jdField_a_of_type_Int)) {
          olm.a(paramInt);
        }
        P();
      }
      do
      {
        return;
        if (onk.e(localArticleInfo))
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
        paramBaseArticleInfo = onk.a(getContext());
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Rao, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    a(new rdt(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int m;
    if (paramInt != 0)
    {
      bool1 = true;
      if (oox.c(this.jdField_a_of_type_Int))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label219;
        }
        olm.a(1);
      }
      if ((onk.a()) && (!i()) && (!bool1)) {
        break label231;
      }
      m = 1;
      label79:
      if (m == 0) {
        break label236;
      }
      m = 3;
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
      onk.b(3);
    }
    for (;;)
    {
      a(true, m, bool1);
      if ((this.jdField_a_of_type_Int == 0) && (paramInt != 2)) {
        osm.a().f(2);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.33(this));
      paramReadInJoyBaseListView = this.jdField_c_of_type_JavaUtilList.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        rny localrny = (rny)paramReadInJoyBaseListView.next();
        if ((localrny instanceof ReadInJoyDiandianHeaderController)) {
          localrny.e();
        }
      }
      bool1 = false;
      break;
      label219:
      if (paramInt == 2) {
        break label59;
      }
      olm.a(1);
      break label59;
      label231:
      m = 0;
      break label79;
      label236:
      m = 1001;
      break label85;
      label243:
      if (!(getContext() instanceof SplashActivity)) {
        break label125;
      }
      osm.a().a(2, null);
      paramReadInJoyBaseListView = onk.a(getContext());
      boolean bool2 = onk.b(this.jdField_a_of_type_Int, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.a(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      shx.a(1);
      break label125;
      label305:
      if ((getContext() instanceof SplashActivity)) {
        osm.a().a(2, null);
      }
      m = 1;
    }
    if (this.jdField_a_of_type_Int == 0) {
      shx.d();
    }
    oxt.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof pqt)) {
      ((pqt)localObject).b();
    }
    localObject = (ArticleInfo)paramBaseArticleInfo;
    int m;
    int i2;
    int i1;
    int n;
    label197:
    int i3;
    if (localObject != null)
    {
      a(new rdu(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      if (oox.c(this.jdField_a_of_type_Int))
      {
        paramBaseArticleInfo.mJumpType = 1;
        bhvh.a(paramBaseArticleInfo);
      }
      onk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = (ArticleInfo)localObject;
      if (onk.l((BaseArticleInfo)localObject))
      {
        a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        m = 4;
        i4 = m;
        if (!((ArticleInfo)localObject).hasSearchWordInfo()) {
          if (rap.c((ArticleInfo)localObject) != 3)
          {
            i4 = m;
            if (rap.c((ArticleInfo)localObject) != 1) {}
          }
          else
          {
            i4 = m;
            if (((ArticleInfo)localObject).mIsShowSearchord == 1)
            {
              paramAdapterView = Aladdin.getConfig(201);
              if (paramAdapterView == null) {
                break label2200;
              }
              i2 = paramAdapterView.getIntegerFromString("feeds_searchterm", 0);
              i1 = paramAdapterView.getIntegerFromString("feeds_searchterm_max", 1000);
              n = paramAdapterView.getIntegerFromString("feeds_pos_range_each_max", 3);
              if (!DateUtils.isToday(bbjn.b("search_word_prefix_last_request_time")))
              {
                bbjn.a("search_word_prefix_last_request_time", System.currentTimeMillis());
                bbjn.a("search_word_prefix_show_times", 0L);
              }
              if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(((ArticleInfo)localObject).mRefreshTime)) {
                break label2163;
              }
              i3 = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(((ArticleInfo)localObject).mRefreshTime)).intValue();
              label260:
              i4 = m;
              if (i3 < n)
              {
                i4 = m;
                if (bbjn.b("search_word_prefix_show_times") < i1)
                {
                  i4 = m;
                  if (i2 == 1) {
                    ((akja)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(111)).a(ByteStringMicro.copyFromUtf8(((ArticleInfo)localObject).innerUniqueID), new rdv(this, (ArticleInfo)localObject, i3, paramInt));
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int i4 = m;; i4 = 0)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
        ((ReadInJoyNewFeedsActivity)getContext()).g(i4);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if (oox.c(this.jdField_a_of_type_Int)) {
              olm.a(i4);
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
                paramAdapterView = new aria();
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
                paramView = (arii)paramView.getManager(306);
                paramBaseArticleInfo.putString("roomid", ((ArticleInfo)localObject).mArticleContentUrl);
                paramBaseArticleInfo.putString("fromid", paramAdapterView.jdField_b_of_type_JavaLangString);
                paramView.a(paramBaseArticleInfo);
                onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
                m = 0;
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
            onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
            m = 0;
            break;
          }
          if ((((ArticleInfo)localObject).mFeedType == 22) || (((ArticleInfo)localObject).mFeedType == 21) || (onk.n((ArticleInfo)localObject)))
          {
            onk.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            m = 0;
            break;
          }
          if (rap.b((ArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView)) {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
            }
            for (;;)
            {
              paramBaseArticleInfo.click_area = 7;
              onk.b(getContext(), (ArticleInfo)localObject, (int)paramBaseArticleInfo.mChannelID);
              m = 0;
              break;
              pju.a(getContext(), (ArticleInfo)localObject);
            }
          }
          if ((rap.a((ArticleInfo)localObject)) && (rap.c((ArticleInfo)localObject)))
          {
            c((ArticleInfo)localObject, paramView);
            m = 0;
            break;
          }
          if (rap.a((ArticleInfo)localObject))
          {
            onk.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            m = 0;
            break;
          }
          if (rap.c((ArticleInfo)localObject) == 71)
          {
            if ((paramView instanceof ProteusItemView)) {
              a((ProteusItemView)paramView);
            }
            for (;;)
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              m = 4;
              break;
              if ((paramView instanceof LinearLayout)) {
                a((LinearLayout)paramView);
              }
            }
          }
          if ((rap.a((BaseArticleInfo)localObject)) || (rap.j((ArticleInfo)localObject)))
          {
            onk.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            rap.a((ArticleInfo)localObject, this.jdField_a_of_type_Rao.a());
            m = 0;
            break;
          }
          if ((onk.b((ArticleInfo)localObject)) || (onk.c((ArticleInfo)localObject)))
          {
            onk.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            rap.a((ArticleInfo)localObject, this.jdField_a_of_type_Rao.a());
            onk.a((ArticleInfo)localObject, this.jdField_a_of_type_Rao.a());
            m = 0;
            break;
          }
          if (onk.a((ArticleInfo)localObject))
          {
            b((ArticleInfo)localObject, 1);
            olg.a(getContext(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao);
            m = 2;
            break;
          }
          if ((rap.i((ArticleInfo)localObject)) || (rap.k((ArticleInfo)localObject)))
          {
            onk.a(getContext(), (ArticleInfo)localObject, 0, false, 1, false);
            rap.a((ArticleInfo)localObject, this.jdField_a_of_type_Rao.a());
            m = 0;
            break;
          }
          if (rap.h((ArticleInfo)localObject))
          {
            if (rap.c((ArticleInfo)localObject))
            {
              c((ArticleInfo)localObject, paramView);
              m = 0;
              break;
            }
            onk.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            m = 0;
            break;
          }
          if (onk.a((BaseArticleInfo)localObject))
          {
            if (((ArticleInfo)localObject).isTwoItemVideoFeed())
            {
              QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle);
              return;
            }
            if (rap.c((ArticleInfo)localObject) == 6)
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
              osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rao.notifyDataSetChanged();
              onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle + " article.mSummary:" + ((ArticleInfo)localObject).mSummary + "mJsonVideoList:" + ((ArticleInfo)localObject).mJsonVideoList + " videoJumpChannelID=" + ((ArticleInfo)localObject).videoJumpChannelID + " videoJumpChannelName=" + ((ArticleInfo)localObject).videoJumpChannelName + " videoJumpChannelType=" + ((ArticleInfo)localObject).videoJumpChannelType);
              }
              m = 4;
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
          if (onk.d((BaseArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
              label1549:
              osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              if (this.jdField_a_of_type_Rao == null) {
                break label2214;
              }
            }
            try
            {
              if (!TextUtils.isEmpty(rwa.b(((ArticleInfo)localObject).mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
              {
                if (this.jdField_a_of_type_AndroidOsHandler == null) {
                  this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
                }
                this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReadInJoyListViewGroup.36(this), 2000L);
              }
              for (;;)
              {
                m = 0;
                break;
                a((ArticleInfo)localObject, paramInt - 1);
                break label1549;
                this.jdField_a_of_type_Rao.notifyDataSetChanged();
              }
            }
            catch (Exception paramAdapterView)
            {
              this.jdField_a_of_type_Rao.notifyDataSetChanged();
              m = 0;
            }
          }
        }
        if ((onk.a(((ArticleInfo)localObject).mArticleContentUrl, ((ArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) || (((ArticleInfo)localObject).isAccountShown))
        {
          if (paramBaseArticleInfo.isAccountShown) {
            paramBaseArticleInfo.click_area = 7;
          }
          if (a((ArticleInfo)localObject, paramView))
          {
            QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug normal feeds");
            osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
            this.jdField_a_of_type_Rao.notifyDataSetChanged();
            onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
          }
          for (;;)
          {
            m = 2;
            break;
            if (b((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
            }
            else if ((!qah.a((BaseArticleInfo)localObject)) && (!ong.a().a()) && (onk.a(paramView.getContext(), (BaseArticleInfo)localObject)))
            {
              onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
              osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rao.notifyDataSetChanged();
              onk.a(paramView.getContext(), (BaseArticleInfo)localObject, onk.i(((ArticleInfo)localObject).getInnerUniqueID()));
            }
            else if (oxz.a(paramView.getContext(), ((ArticleInfo)localObject).mArticleContentUrl))
            {
              onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
              osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Rao.notifyDataSetChanged();
            }
            else
            {
              c((ArticleInfo)localObject);
            }
          }
        }
        if (((ArticleInfo)localObject).mFeedType == 26)
        {
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdh == null) || (TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdh.jdField_k_of_type_JavaLangString))) {
            break label2214;
          }
          onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
          onk.c(getContext(), ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Qdh.jdField_k_of_type_JavaLangString);
          osj.a().a(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
          m = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 23)
        {
          onk.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
          m = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 34)
        {
          onk.a(getContext(), ((ArticleInfo)localObject).mArticleContentUrl, null);
          rap.a((ArticleInfo)localObject, this.jdField_a_of_type_Rao.a());
          m = 0;
          break;
        }
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (this.jdField_a_of_type_Rao != null)) {
          onk.a(a(), (ArticleInfo)localObject, this.jdField_a_of_type_Rao, this.jdField_a_of_type_Int);
        }
        m = 2;
        break;
        label2163:
        i3 = 0;
        break label260;
        if ((getContext() instanceof SplashActivity))
        {
          paramAdapterView = onk.a(getContext());
          if (paramAdapterView != null) {
            paramAdapterView.a(i4);
          }
        }
      }
      label2200:
      i2 = 0;
      i1 = 1000;
      n = 3;
      break label197;
      label2214:
      m = 0;
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
      int n = this.jdField_a_of_type_Rao.a();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int m = 0;
        while (m < 5)
        {
          long l = ((Long)paramList.get(m)).longValue();
          Object localObject = this.jdField_a_of_type_Rao.a(n, l);
          if ((localObject != null) && (!onk.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!onk.a((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Rao.a(n, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (xlu.a((String)localObject)) {
              PreloadManager.a().a((String)localObject);
            }
          }
          m += 1;
        }
      }
    }
  }
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, qar> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "detachFromViewGroup()");
    }
    a(new rdf(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = shx.a(this.jdField_a_of_type_Int);
    String str = onk.e(this.jdField_a_of_type_Int);
    ThreadManager.post(new ReadInJoyListViewGroup.15(this, a(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (i())
    {
      if (this.jdField_a_of_type_Int != 56) {
        break label156;
      }
      bhvh.a((QQAppInterface)onk.a(), System.currentTimeMillis(), a());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(false);
      }
      a().getIntent().putExtra("from_search", false);
      return;
      label156:
      bhvh.a((QQAppInterface)onk.a(), System.currentTimeMillis(), this.jdField_a_of_type_Int);
    }
  }
  
  /* Error */
  public void a(Map<Long, qar> paramMap, boolean paramBoolean, Map<Long, sic> paramMap1, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: invokeinterface 3183 1 0
    //   10: ifne +7 -> 17
    //   13: iload_2
    //   14: ifne +31 -> 45
    //   17: ldc_w 533
    //   20: iconst_2
    //   21: ldc_w 3185
    //   24: invokestatic 540	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_3
    //   28: ifnull +16 -> 44
    //   31: aload_3
    //   32: invokeinterface 3183 1 0
    //   37: ifne +7 -> 44
    //   40: aload_3
    //   41: invokestatic 3187	shx:a	(Ljava/util/Map;)V
    //   44: return
    //   45: aload_0
    //   46: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   49: bipush 56
    //   51: if_icmpne +87 -> 138
    //   54: aload_0
    //   55: getfield 268	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ntg	Lntg;
    //   58: invokevirtual 3190	ntg:a	()Lqup;
    //   61: astore 14
    //   63: aload 14
    //   65: ifnull +73 -> 138
    //   68: aload_1
    //   69: invokeinterface 2148 1 0
    //   74: invokeinterface 2151 1 0
    //   79: astore 15
    //   81: aload 15
    //   83: invokeinterface 391 1 0
    //   88: ifeq +50 -> 138
    //   91: aload 15
    //   93: invokeinterface 395 1 0
    //   98: checkcast 2153	qar
    //   101: astore 16
    //   103: aload 16
    //   105: aload 14
    //   107: invokevirtual 3193	qup:a	()I
    //   110: putfield 3194	qar:jdField_h_of_type_Int	I
    //   113: aload 14
    //   115: aload 16
    //   117: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   120: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   123: invokevirtual 3196	qup:a	(J)Z
    //   126: ifeq -45 -> 81
    //   129: aload 16
    //   131: iconst_1
    //   132: putfield 3197	qar:jdField_f_of_type_Boolean	Z
    //   135: goto -54 -> 81
    //   138: new 106	java/util/HashMap
    //   141: dup
    //   142: invokespecial 107	java/util/HashMap:<init>	()V
    //   145: astore 18
    //   147: aload_1
    //   148: invokeinterface 2148 1 0
    //   153: invokeinterface 2151 1 0
    //   158: astore 19
    //   160: aload 19
    //   162: invokeinterface 391 1 0
    //   167: ifeq +4215 -> 4382
    //   170: aload 19
    //   172: invokeinterface 395 1 0
    //   177: checkcast 2153	qar
    //   180: astore 20
    //   182: aload 20
    //   184: getfield 3198	qar:jdField_a_of_type_Boolean	Z
    //   187: ifne -27 -> 160
    //   190: aload 20
    //   192: iconst_1
    //   193: putfield 3198	qar:jdField_a_of_type_Boolean	Z
    //   196: aload_0
    //   197: invokespecial 3199	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/util/Pair;
    //   200: astore 14
    //   202: aload 14
    //   204: getfield 2048	android/util/Pair:second	Ljava/lang/Object;
    //   207: checkcast 570	java/lang/Long
    //   210: invokevirtual 661	java/lang/Long:longValue	()J
    //   213: lstore 8
    //   215: aload 14
    //   217: getfield 1325	android/util/Pair:first	Ljava/lang/Object;
    //   220: checkcast 554	java/lang/Integer
    //   223: invokevirtual 911	java/lang/Integer:intValue	()I
    //   226: istore 7
    //   228: aconst_null
    //   229: ldc_w 1406
    //   232: ldc_w 1408
    //   235: ldc_w 1408
    //   238: ldc_w 3201
    //   241: ldc_w 3201
    //   244: iconst_0
    //   245: iconst_0
    //   246: ldc_w 1408
    //   249: aload 20
    //   251: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   254: invokevirtual 661	java/lang/Long:longValue	()J
    //   257: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   260: aload 20
    //   262: getfield 2176	qar:jdField_b_of_type_Int	I
    //   265: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   268: aload 20
    //   270: getfield 2172	qar:jdField_a_of_type_Long	J
    //   273: aload 20
    //   275: getfield 3202	qar:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   282: aload 20
    //   284: getfield 3203	qar:jdField_d_of_type_Int	I
    //   287: invokestatic 3205	onk:a	(JIII)Ljava/lang/String;
    //   290: iconst_0
    //   291: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   294: ldc_w 3201
    //   297: ldc_w 1408
    //   300: ldc_w 1408
    //   303: aload 20
    //   305: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   308: invokevirtual 661	java/lang/Long:longValue	()J
    //   311: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   314: aload 20
    //   316: getfield 2176	qar:jdField_b_of_type_Int	I
    //   319: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   322: aload 20
    //   324: getfield 2172	qar:jdField_a_of_type_Long	J
    //   327: aload 20
    //   329: getfield 3202	qar:jdField_c_of_type_Int	I
    //   332: aload_0
    //   333: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   336: aload 20
    //   338: getfield 3203	qar:jdField_d_of_type_Int	I
    //   341: invokestatic 3205	onk:a	(JIII)Ljava/lang/String;
    //   344: invokestatic 2781	noo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload 20
    //   349: getfield 2172	qar:jdField_a_of_type_Long	J
    //   352: aload 20
    //   354: getfield 3202	qar:jdField_c_of_type_Int	I
    //   357: aload_0
    //   358: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   361: aload 20
    //   363: getfield 3203	qar:jdField_d_of_type_Int	I
    //   366: aload 20
    //   368: getfield 3206	qar:jdField_e_of_type_Int	I
    //   371: aload_0
    //   372: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   375: invokestatic 2790	bbev:h	(Landroid/content/Context;)Z
    //   378: aload 20
    //   380: getfield 3207	qar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: aload 20
    //   385: getfield 3208	qar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   388: aload 20
    //   390: getfield 2190	qar:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   393: aload 20
    //   395: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   398: invokestatic 2795	onk:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   401: aload 20
    //   403: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   406: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   409: lload 8
    //   411: iload 7
    //   413: aload 20
    //   415: getfield 3209	qar:jdField_f_of_type_Int	I
    //   418: aload 20
    //   420: getfield 3210	qar:jdField_g_of_type_Int	I
    //   423: aload 20
    //   425: getfield 3194	qar:jdField_h_of_type_Int	I
    //   428: aload 20
    //   430: getfield 3197	qar:jdField_f_of_type_Boolean	Z
    //   433: aload 20
    //   435: getfield 3211	qar:jdField_j_of_type_Int	I
    //   438: aload 20
    //   440: getfield 3212	qar:jdField_i_of_type_Int	I
    //   443: aload 20
    //   445: getfield 3214	qar:m	I
    //   448: invokestatic 3217	onk:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   451: astore 16
    //   453: aload 20
    //   455: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   458: ifnull -298 -> 160
    //   461: aload_0
    //   462: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   465: bipush 56
    //   467: if_icmpne +459 -> 926
    //   470: aload 16
    //   472: aload_0
    //   473: getfield 268	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ntg	Lntg;
    //   476: invokevirtual 273	ntg:a	()Lqtu;
    //   479: invokevirtual 3220	qtu:a	()Ljava/lang/String;
    //   482: getstatic 252	npx:jdField_a_of_type_Int	I
    //   485: invokestatic 3223	onk:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   488: astore 14
    //   490: aload 20
    //   492: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   495: ifnull +3951 -> 4446
    //   498: aload 20
    //   500: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   503: getfield 2200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   506: ifnull +3940 -> 4446
    //   509: new 2785	qze
    //   512: dup
    //   513: aload 14
    //   515: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   518: aload 20
    //   520: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   523: invokevirtual 3226	qze:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   526: aload 20
    //   528: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   531: invokevirtual 3228	qze:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   534: aload 20
    //   536: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   539: getfield 3229	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   542: invokevirtual 2813	qze:a	(Ljava/lang/String;)Lqze;
    //   545: invokevirtual 2820	qze:a	()Lqzd;
    //   548: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   551: astore 14
    //   553: aload_0
    //   554: getfield 275	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rao	Lrao;
    //   557: astore 15
    //   559: aload 20
    //   561: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   564: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   567: invokestatic 3230	rao:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   570: bipush 46
    //   572: if_icmpeq +14 -> 586
    //   575: aload 20
    //   577: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   580: getfield 3233	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   583: ifeq +121 -> 704
    //   586: aload 20
    //   588: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   591: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   594: ifnull +110 -> 704
    //   597: aload 20
    //   599: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   602: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   605: getfield 3243	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   608: ifnull +96 -> 704
    //   611: aload 20
    //   613: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   616: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   619: getfield 3243	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   622: getfield 3248	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   625: invokestatic 3251	onk:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   628: ifeq +76 -> 704
    //   631: aload 20
    //   633: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   636: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   639: getfield 3243	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   642: getfield 3254	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   645: invokestatic 3251	onk:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   648: ifeq +56 -> 704
    //   651: new 577	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   658: aload 20
    //   660: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   663: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   666: getfield 3243	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   669: getfield 3248	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   672: invokestatic 3257	onk:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   675: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 20
    //   680: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   683: getfield 3237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   686: getfield 3243	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   689: getfield 3254	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   692: invokestatic 3257	onk:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   695: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 3258	qol:a	(Ljava/lang/String;)V
    //   704: aload 14
    //   706: astore 15
    //   708: new 1971	org/json/JSONObject
    //   711: dup
    //   712: aload 15
    //   714: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   717: astore 14
    //   719: aload 14
    //   721: ldc_w 3260
    //   724: aload 4
    //   726: invokevirtual 1980	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   729: pop
    //   730: aload 14
    //   732: ldc_w 3262
    //   735: invokestatic 188	onk:a	()Lmqq/app/AppRuntime;
    //   738: aload_0
    //   739: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   742: invokestatic 3267	oos:a	(Lmqq/app/AppRuntime;I)I
    //   745: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   748: pop
    //   749: aload 20
    //   751: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   754: ifnonnull +651 -> 1405
    //   757: aload 14
    //   759: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   762: astore 14
    //   764: aload_0
    //   765: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   768: i2l
    //   769: invokestatic 3268	shx:a	(J)Z
    //   772: ifeq +751 -> 1523
    //   775: ldc_w 3270
    //   778: astore 15
    //   780: aload_0
    //   781: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   784: invokestatic 1625	oox:a	(I)Z
    //   787: ifne +14 -> 801
    //   790: aload_0
    //   791: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   794: i2l
    //   795: invokestatic 3271	bhvh:a	(J)Z
    //   798: ifeq +3645 -> 4443
    //   801: ldc_w 3273
    //   804: astore 15
    //   806: aload 20
    //   808: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   811: invokestatic 3274	rap:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   814: ifeq +717 -> 1531
    //   817: iconst_0
    //   818: istore 5
    //   820: iload 5
    //   822: aload 20
    //   824: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   827: getfield 3278	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lqdt;
    //   830: getfield 3282	qdt:a	Ljava/util/ArrayList;
    //   833: invokevirtual 3283	java/util/ArrayList:size	()I
    //   836: if_icmpge +889 -> 1725
    //   839: aconst_null
    //   840: aload 20
    //   842: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   845: aload 15
    //   847: aload 15
    //   849: iconst_0
    //   850: iconst_0
    //   851: aload 20
    //   853: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   856: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   859: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   862: new 577	java/lang/StringBuilder
    //   865: dup
    //   866: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   869: aload 20
    //   871: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   874: getfield 3278	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lqdt;
    //   877: getfield 3282	qdt:a	Ljava/util/ArrayList;
    //   880: iload 5
    //   882: invokevirtual 1242	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   885: checkcast 3287	qdv
    //   888: getfield 3288	qdv:jdField_a_of_type_Int	I
    //   891: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   894: ldc_w 1408
    //   897: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   903: aload 20
    //   905: getfield 2176	qar:jdField_b_of_type_Int	I
    //   908: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   911: aload 14
    //   913: iconst_0
    //   914: invokestatic 3291	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   917: iload 5
    //   919: iconst_1
    //   920: iadd
    //   921: istore 5
    //   923: goto -103 -> 820
    //   926: aload 16
    //   928: astore 15
    //   930: aload_0
    //   931: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   934: ifne -226 -> 708
    //   937: aload_0
    //   938: getfield 275	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Rao	Lrao;
    //   941: astore 14
    //   943: aload 20
    //   945: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   948: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   951: invokestatic 3230	rao:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
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
    //   1007: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1010: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   1013: invokestatic 3292	npx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   1016: aload 16
    //   1018: invokestatic 3295	npx:a	(ILjava/lang/String;)Ljava/lang/String;
    //   1021: astore 14
    //   1023: aload 14
    //   1025: astore 15
    //   1027: iload 5
    //   1029: bipush 6
    //   1031: if_icmpne -323 -> 708
    //   1034: new 2785	qze
    //   1037: dup
    //   1038: aload 14
    //   1040: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   1043: astore 14
    //   1045: aload 14
    //   1047: invokestatic 3296	qol:b	()I
    //   1050: invokevirtual 3299	qze:ad	(I)Lqze;
    //   1053: pop
    //   1054: aload 14
    //   1056: invokevirtual 2820	qze:a	()Lqzd;
    //   1059: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   1062: astore 15
    //   1064: goto -356 -> 708
    //   1067: iload 5
    //   1069: bipush 46
    //   1071: if_icmpeq +14 -> 1085
    //   1074: aload 20
    //   1076: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1079: getfield 3233	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   1082: ifeq +104 -> 1186
    //   1085: new 2785	qze
    //   1088: dup
    //   1089: aload 16
    //   1091: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   1094: astore 14
    //   1096: aload 14
    //   1098: aload 20
    //   1100: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1103: getfield 3300	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoVid	Ljava/lang/String;
    //   1106: invokevirtual 3302	qze:e	(Ljava/lang/String;)Lqze;
    //   1109: pop
    //   1110: aload 14
    //   1112: aload 20
    //   1114: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1117: invokestatic 2775	onk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1120: invokevirtual 3305	qze:X	(I)Lqze;
    //   1123: pop
    //   1124: aload 14
    //   1126: aload 20
    //   1128: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1131: getfield 3229	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1134: invokevirtual 2813	qze:a	(Ljava/lang/String;)Lqze;
    //   1137: pop
    //   1138: iload 5
    //   1140: bipush 46
    //   1142: if_icmpne +34 -> 1176
    //   1145: aload 14
    //   1147: iconst_0
    //   1148: invokevirtual 3307	qze:y	(I)Lqze;
    //   1151: pop
    //   1152: aload 14
    //   1154: aload 20
    //   1156: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1159: invokevirtual 3309	qze:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   1162: pop
    //   1163: aload 14
    //   1165: invokevirtual 2820	qze:a	()Lqzd;
    //   1168: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   1171: astore 14
    //   1173: goto -150 -> 1023
    //   1176: aload 14
    //   1178: iconst_1
    //   1179: invokevirtual 3307	qze:y	(I)Lqze;
    //   1182: pop
    //   1183: goto -31 -> 1152
    //   1186: iload 5
    //   1188: bipush 118
    //   1190: if_icmpne +103 -> 1293
    //   1193: new 2785	qze
    //   1196: dup
    //   1197: aload 16
    //   1199: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   1202: astore 14
    //   1204: aload 20
    //   1206: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1209: getfield 2200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1212: ifnull +54 -> 1266
    //   1215: aload 14
    //   1217: aload 20
    //   1219: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1222: getfield 2200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1225: getfield 2203	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Int	I
    //   1228: invokevirtual 3312	qze:ab	(I)Lqze;
    //   1231: pop
    //   1232: aload 20
    //   1234: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1237: getfield 2200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1240: getfield 3315	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1243: ifnull +23 -> 1266
    //   1246: aload 14
    //   1248: aload 20
    //   1250: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1253: getfield 2200	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1256: getfield 3315	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1259: getfield 3318	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1262: invokevirtual 3320	qze:r	(Ljava/lang/String;)Lqze;
    //   1265: pop
    //   1266: aload 14
    //   1268: aload 20
    //   1270: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1273: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1276: invokevirtual 3323	qze:h	(Ljava/lang/String;)Lqze;
    //   1279: pop
    //   1280: aload 14
    //   1282: invokevirtual 2820	qze:a	()Lqzd;
    //   1285: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   1288: astore 14
    //   1290: goto -267 -> 1023
    //   1293: aload 16
    //   1295: astore 14
    //   1297: iload 5
    //   1299: sipush 128
    //   1302: if_icmpne -279 -> 1023
    //   1305: new 2785	qze
    //   1308: dup
    //   1309: aload 16
    //   1311: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   1314: astore 14
    //   1316: aload 20
    //   1318: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1321: getfield 3326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1324: ifnull +54 -> 1378
    //   1327: aload 14
    //   1329: aload 20
    //   1331: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1334: getfield 3326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1337: getfield 2203	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:jdField_a_of_type_Int	I
    //   1340: invokevirtual 3312	qze:ab	(I)Lqze;
    //   1343: pop
    //   1344: aload 20
    //   1346: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1349: getfield 3326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1352: getfield 3328	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:b	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1355: ifnull +23 -> 1378
    //   1358: aload 14
    //   1360: aload 20
    //   1362: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1365: getfield 3326	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1368: getfield 3328	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:b	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1371: getfield 3318	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1374: invokevirtual 3320	qze:r	(Ljava/lang/String;)Lqze;
    //   1377: pop
    //   1378: aload 14
    //   1380: aload 20
    //   1382: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1385: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1388: invokevirtual 3323	qze:h	(Ljava/lang/String;)Lqze;
    //   1391: pop
    //   1392: aload 14
    //   1394: invokevirtual 2820	qze:a	()Lqzd;
    //   1397: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   1400: astore 14
    //   1402: goto -379 -> 1023
    //   1405: aload 20
    //   1407: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1410: invokevirtual 3329	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isPGCShortContent	()Z
    //   1413: istore_2
    //   1414: aload 20
    //   1416: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1419: getfield 3332	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1422: invokestatic 850	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1425: ifne +92 -> 1517
    //   1428: aload 20
    //   1430: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1433: getfield 3332	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1436: ldc_w 3334
    //   1439: invokevirtual 3336	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1442: ifeq +75 -> 1517
    //   1445: iconst_1
    //   1446: istore 5
    //   1448: goto +3001 -> 4449
    //   1451: aload_3
    //   1452: aload 20
    //   1454: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1457: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1460: invokestatic 573	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1463: invokeinterface 906 2 0
    //   1468: checkcast 3338	sic
    //   1471: astore 16
    //   1473: aload 16
    //   1475: ifnull -718 -> 757
    //   1478: aload 16
    //   1480: getfield 3339	sic:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1483: aload 20
    //   1485: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1488: if_acmpne -731 -> 757
    //   1491: aload 14
    //   1493: ldc_w 3341
    //   1496: aload 16
    //   1498: getfield 3342	sic:jdField_a_of_type_Long	J
    //   1501: invokevirtual 2017	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1504: pop
    //   1505: goto -748 -> 757
    //   1508: astore 14
    //   1510: aload 15
    //   1512: astore 14
    //   1514: goto -750 -> 764
    //   1517: iconst_0
    //   1518: istore 5
    //   1520: goto +2929 -> 4449
    //   1523: ldc_w 3344
    //   1526: astore 15
    //   1528: goto -748 -> 780
    //   1531: aload 20
    //   1533: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1536: invokestatic 1227	onk:l	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1539: ifeq +1041 -> 2580
    //   1542: aload 20
    //   1544: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1547: invokestatic 3346	onk:j	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1550: ifeq +846 -> 2396
    //   1553: aload 20
    //   1555: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1558: getfield 3349	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mGroupSubArticleList	Ljava/util/List;
    //   1561: iconst_0
    //   1562: invokeinterface 605 2 0
    //   1567: checkcast 655	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   1570: astore 14
    //   1572: aload_0
    //   1573: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1576: aload 14
    //   1578: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1581: aload 14
    //   1583: getfield 3350	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1586: bipush 54
    //   1588: aload_0
    //   1589: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1592: aload 14
    //   1594: invokevirtual 3351	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   1597: aload 14
    //   1599: invokevirtual 3354	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoVid	()Ljava/lang/String;
    //   1602: aload 14
    //   1604: invokestatic 1398	shx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1607: aload 14
    //   1609: getfield 3229	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1612: invokestatic 3357	shx:a	(Landroid/content/Context;JJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   1615: astore 15
    //   1617: aload 15
    //   1619: astore 14
    //   1621: aload 20
    //   1623: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1626: ifnull +42 -> 1668
    //   1629: new 1971	org/json/JSONObject
    //   1632: dup
    //   1633: aload 15
    //   1635: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1638: astore 14
    //   1640: aload 20
    //   1642: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1645: getfield 3360	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isShowGif	Z
    //   1648: ifeq +693 -> 2341
    //   1651: aload 14
    //   1653: ldc_w 3362
    //   1656: iconst_1
    //   1657: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1660: pop
    //   1661: aload 14
    //   1663: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1666: astore 14
    //   1668: aload 14
    //   1670: astore 15
    //   1672: aload 20
    //   1674: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1677: ifnull +38 -> 1715
    //   1680: new 1971	org/json/JSONObject
    //   1683: dup
    //   1684: aload 14
    //   1686: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1689: astore 15
    //   1691: aload 15
    //   1693: ldc_w 3364
    //   1696: aload 20
    //   1698: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1701: invokestatic 3366	onk:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1704: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1707: pop
    //   1708: aload 15
    //   1710: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1713: astore 15
    //   1715: aload 20
    //   1717: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1720: aload 15
    //   1722: invokestatic 3369	onk:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Ljava/lang/String;)V
    //   1725: aload 20
    //   1727: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1730: bipush 48
    //   1732: if_icmpeq +116 -> 1848
    //   1735: aload 20
    //   1737: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1740: bipush 49
    //   1742: if_icmpeq +106 -> 1848
    //   1745: aload 20
    //   1747: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1750: bipush 50
    //   1752: if_icmpeq +96 -> 1848
    //   1755: aload 20
    //   1757: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1760: bipush 51
    //   1762: if_icmpeq +86 -> 1848
    //   1765: aload 20
    //   1767: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1770: bipush 52
    //   1772: if_icmpeq +76 -> 1848
    //   1775: aload 20
    //   1777: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1780: bipush 53
    //   1782: if_icmpeq +66 -> 1848
    //   1785: aload 20
    //   1787: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1790: bipush 78
    //   1792: if_icmpeq +56 -> 1848
    //   1795: aload 20
    //   1797: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1800: bipush 79
    //   1802: if_icmpeq +46 -> 1848
    //   1805: aload 20
    //   1807: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1810: bipush 80
    //   1812: if_icmpeq +36 -> 1848
    //   1815: aload 20
    //   1817: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1820: sipush 1005
    //   1823: if_icmpeq +25 -> 1848
    //   1826: aload 20
    //   1828: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1831: sipush 1006
    //   1834: if_icmpeq +14 -> 1848
    //   1837: aload 20
    //   1839: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1842: sipush 1007
    //   1845: if_icmpne +214 -> 2059
    //   1848: aload 20
    //   1850: getfield 3370	qar:jdField_b_of_type_Long	J
    //   1853: lstore 12
    //   1855: aload 20
    //   1857: getfield 3371	qar:jdField_k_of_type_Int	I
    //   1860: istore 5
    //   1862: aload_0
    //   1863: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1866: aload 20
    //   1868: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1871: invokestatic 3374	olg:a	(II)I
    //   1874: istore 6
    //   1876: aload 20
    //   1878: getfield 3202	qar:jdField_c_of_type_Int	I
    //   1881: invokestatic 3375	olg:a	(I)I
    //   1884: istore 7
    //   1886: lconst_0
    //   1887: lstore 8
    //   1889: aconst_null
    //   1890: astore 14
    //   1892: aconst_null
    //   1893: astore 15
    //   1895: aload 20
    //   1897: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1900: ifnull +2531 -> 4431
    //   1903: aload 20
    //   1905: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1908: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1911: lstore 8
    //   1913: aload 20
    //   1915: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1918: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1921: astore 14
    //   1923: aload 20
    //   1925: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1928: getfield 3378	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:galleryReprotExdData	Ljava/lang/String;
    //   1931: astore 15
    //   1933: aload 20
    //   1935: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1938: getfield 3350	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1941: lstore 10
    //   1943: aload_0
    //   1944: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1947: invokestatic 2158	onk:a	()J
    //   1950: iload 6
    //   1952: lload 8
    //   1954: lload 12
    //   1956: iload 5
    //   1958: aload 14
    //   1960: aload 15
    //   1962: iload 7
    //   1964: aload_0
    //   1965: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   1968: invokestatic 3381	olg:a	(Landroid/content/Context;JIJJILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1971: astore 16
    //   1973: aconst_null
    //   1974: aload 20
    //   1976: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1979: ldc_w 3383
    //   1982: ldc_w 3383
    //   1985: iconst_0
    //   1986: iconst_0
    //   1987: ldc_w 1408
    //   1990: new 577	java/lang/StringBuilder
    //   1993: dup
    //   1994: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   1997: lload 8
    //   1999: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2002: ldc_w 1408
    //   2005: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2011: new 577	java/lang/StringBuilder
    //   2014: dup
    //   2015: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2018: lload 10
    //   2020: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2023: ldc_w 1408
    //   2026: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2029: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: aload 16
    //   2034: iconst_0
    //   2035: invokestatic 3291	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2038: bipush 7
    //   2040: invokestatic 2158	onk:a	()J
    //   2043: lload 10
    //   2045: l2i
    //   2046: iload 6
    //   2048: lload 12
    //   2050: iload 5
    //   2052: aload 14
    //   2054: aload 15
    //   2056: invokestatic 3386	olg:a	(IJIIJILjava/lang/String;Ljava/lang/String;)V
    //   2059: aload 20
    //   2061: getfield 3388	qar:jdField_c_of_type_Boolean	Z
    //   2064: ifeq +97 -> 2161
    //   2067: aload 20
    //   2069: getfield 3389	qar:jdField_d_of_type_Boolean	Z
    //   2072: ifeq +89 -> 2161
    //   2075: invokestatic 3392	onk:a	()Lorg/json/JSONObject;
    //   2078: astore 15
    //   2080: aload 15
    //   2082: ldc_w 3394
    //   2085: aload 20
    //   2087: getfield 3207	qar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2090: invokevirtual 1980	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2093: pop
    //   2094: aload 15
    //   2096: ldc_w 3396
    //   2099: invokestatic 3398	onk:e	()I
    //   2102: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2105: pop
    //   2106: aload_0
    //   2107: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2110: i2l
    //   2111: invokestatic 3268	shx:a	(J)Z
    //   2114: ifeq +2250 -> 4364
    //   2117: ldc_w 3400
    //   2120: astore 14
    //   2122: aconst_null
    //   2123: ldc_w 1406
    //   2126: ldc_w 1408
    //   2129: ldc_w 1408
    //   2132: aload 14
    //   2134: aload 14
    //   2136: iconst_0
    //   2137: iconst_0
    //   2138: aload 20
    //   2140: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2143: invokestatic 3402	onk:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   2146: ldc_w 1408
    //   2149: ldc_w 1408
    //   2152: aload 15
    //   2154: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2157: iconst_0
    //   2158: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2161: aload 20
    //   2163: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2166: invokestatic 3404	onk:k	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2169: ifeq +29 -> 2198
    //   2172: aconst_null
    //   2173: aconst_null
    //   2174: ldc_w 3406
    //   2177: ldc_w 3406
    //   2180: iconst_0
    //   2181: iconst_0
    //   2182: ldc_w 1408
    //   2185: ldc_w 1408
    //   2188: ldc_w 1408
    //   2191: ldc_w 1408
    //   2194: iconst_0
    //   2195: invokestatic 3291	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2198: aload 20
    //   2200: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2203: ifnull +47 -> 2250
    //   2206: aload 20
    //   2208: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2211: getfield 2237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2214: ifnull +36 -> 2250
    //   2217: aload 20
    //   2219: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2222: getfield 2237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2225: getfield 3409	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Nuc	Lnuc;
    //   2228: ifnull +22 -> 2250
    //   2231: aload 20
    //   2233: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2236: getfield 2237	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2239: getfield 3409	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:jdField_a_of_type_Nuc	Lnuc;
    //   2242: aload 20
    //   2244: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2247: invokestatic 3412	onk:a	(Lnuc;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   2250: invokestatic 1335	rmc:a	()Lrmc;
    //   2253: invokevirtual 1336	rmc:b	()Z
    //   2256: ifeq -2096 -> 160
    //   2259: aload 20
    //   2261: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2264: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2267: ifnull -2107 -> 160
    //   2270: aload 20
    //   2272: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2275: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2278: getfield 3419	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_c_of_type_Boolean	Z
    //   2281: ifeq -2121 -> 160
    //   2284: aload 20
    //   2286: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2289: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2292: getfield 3420	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_d_of_type_Boolean	Z
    //   2295: ifne -2135 -> 160
    //   2298: invokestatic 1335	rmc:a	()Lrmc;
    //   2301: aload 20
    //   2303: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2306: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2309: bipush 56
    //   2311: iconst_2
    //   2312: iconst_4
    //   2313: invokevirtual 3423	rmc:a	(Ljava/lang/String;III)V
    //   2316: aload 20
    //   2318: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2321: getfield 3416	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:fusionBiuInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo;
    //   2324: iconst_1
    //   2325: putfield 3420	com/tencent/biz/pubaccount/readinjoy/struct/FusionBiuInfo:jdField_d_of_type_Boolean	Z
    //   2328: goto -2168 -> 160
    //   2331: astore 14
    //   2333: aload 14
    //   2335: invokevirtual 3424	java/lang/NullPointerException:printStackTrace	()V
    //   2338: goto -2178 -> 160
    //   2341: aload 14
    //   2343: ldc_w 3362
    //   2346: iconst_0
    //   2347: invokevirtual 1987	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2350: pop
    //   2351: goto -690 -> 1661
    //   2354: astore 14
    //   2356: ldc_w 533
    //   2359: iconst_2
    //   2360: aload 14
    //   2362: invokevirtual 3425	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2365: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2368: aload 15
    //   2370: astore 14
    //   2372: goto -704 -> 1668
    //   2375: astore 15
    //   2377: ldc_w 533
    //   2380: iconst_2
    //   2381: aload 15
    //   2383: invokevirtual 3425	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2386: invokestatic 1178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2389: aload 14
    //   2391: astore 15
    //   2393: goto -678 -> 1715
    //   2396: aload_0
    //   2397: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2400: aload 20
    //   2402: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2405: getfield 3426	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoAdsSource	I
    //   2408: aload 20
    //   2410: getfield 3371	qar:jdField_k_of_type_Int	I
    //   2413: aload 20
    //   2415: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2418: invokevirtual 3351	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2421: bipush 54
    //   2423: aload 20
    //   2425: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2428: invokestatic 1398	shx:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2431: aload 20
    //   2433: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2436: getfield 3229	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   2439: invokestatic 1404	shx:a	(Landroid/content/Context;IILjava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   2442: astore 14
    //   2444: aconst_null
    //   2445: ldc_w 1406
    //   2448: ldc_w 1408
    //   2451: aload 20
    //   2453: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2456: ldc_w 3428
    //   2459: ldc_w 3428
    //   2462: iconst_0
    //   2463: iconst_0
    //   2464: aload 20
    //   2466: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2469: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2472: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2475: aload 20
    //   2477: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2480: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2483: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2486: aload 20
    //   2488: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2491: getfield 3429	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2494: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2497: aload 14
    //   2499: iconst_0
    //   2500: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2503: aconst_null
    //   2504: aconst_null
    //   2505: ldc_w 3344
    //   2508: ldc_w 3344
    //   2511: iconst_0
    //   2512: iconst_0
    //   2513: ldc_w 1408
    //   2516: ldc_w 1408
    //   2519: ldc_w 1408
    //   2522: new 2785	qze
    //   2525: dup
    //   2526: aconst_null
    //   2527: aconst_null
    //   2528: aconst_null
    //   2529: aconst_null
    //   2530: invokespecial 3432	qze:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2533: bipush 54
    //   2535: invokevirtual 3305	qze:X	(I)Lqze;
    //   2538: aload 20
    //   2540: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2543: invokevirtual 3351	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2546: invokevirtual 3323	qze:h	(Ljava/lang/String;)Lqze;
    //   2549: aload 20
    //   2551: getfield 3371	qar:jdField_k_of_type_Int	I
    //   2554: iconst_1
    //   2555: iadd
    //   2556: invokevirtual 3307	qze:y	(I)Lqze;
    //   2559: aload 20
    //   2561: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2564: invokevirtual 3434	qze:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   2567: invokevirtual 2820	qze:a	()Lqzd;
    //   2570: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   2573: iconst_0
    //   2574: invokestatic 3291	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2577: goto -852 -> 1725
    //   2580: aload 20
    //   2582: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2585: invokestatic 3437	onk:t	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2588: ifeq +15 -> 2603
    //   2591: aload 20
    //   2593: aload 14
    //   2595: aload 15
    //   2597: invokestatic 3440	onk:a	(Lqar;Ljava/lang/String;Ljava/lang/String;)V
    //   2600: goto -875 -> 1725
    //   2603: aload 20
    //   2605: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2608: invokestatic 1184	onk:s	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2611: ifeq +433 -> 3044
    //   2614: aload 20
    //   2616: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2619: getfield 3441	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mNewPolymericInfo	Lqbq;
    //   2622: getfield 2124	qbq:jdField_a_of_type_Boolean	Z
    //   2625: ifne +380 -> 3005
    //   2628: invokestatic 3444	rap:a	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2631: astore 16
    //   2633: ldc_w 3446
    //   2636: astore 14
    //   2638: aload 16
    //   2640: ifnull +10 -> 2650
    //   2643: aload 16
    //   2645: invokevirtual 3448	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2648: astore 14
    //   2650: aload 20
    //   2652: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2655: getfield 3350	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2658: aload 20
    //   2660: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2663: invokestatic 2775	onk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2666: aload_0
    //   2667: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2670: iconst_0
    //   2671: iconst_0
    //   2672: aload_0
    //   2673: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2676: invokestatic 2790	bbev:h	(Landroid/content/Context;)Z
    //   2679: aload 20
    //   2681: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2684: getfield 3449	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2687: aconst_null
    //   2688: aload 20
    //   2690: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2693: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2696: aconst_null
    //   2697: aload 20
    //   2699: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2702: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2705: invokestatic 3452	onk:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Ljava/lang/String;
    //   2708: astore 17
    //   2710: aconst_null
    //   2711: ldc_w 1406
    //   2714: ldc_w 1408
    //   2717: aload 14
    //   2719: aload 15
    //   2721: aload 15
    //   2723: iconst_0
    //   2724: iconst_0
    //   2725: new 577	java/lang/StringBuilder
    //   2728: dup
    //   2729: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2732: aload 20
    //   2734: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2737: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2740: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2743: ldc_w 1408
    //   2746: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2749: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2752: new 577	java/lang/StringBuilder
    //   2755: dup
    //   2756: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2759: aload 20
    //   2761: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2764: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2767: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2770: ldc_w 1408
    //   2773: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2776: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2779: new 577	java/lang/StringBuilder
    //   2782: dup
    //   2783: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2786: aload 20
    //   2788: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2791: getfield 3429	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2794: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2797: ldc_w 1408
    //   2800: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2803: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2806: aload 17
    //   2808: iconst_0
    //   2809: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2812: aload_0
    //   2813: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2816: i2l
    //   2817: invokestatic 3454	shx:a	(J)Ljava/lang/String;
    //   2820: astore 15
    //   2822: aload 16
    //   2824: ifnull +1616 -> 4440
    //   2827: aload 16
    //   2829: invokevirtual 3448	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   2832: astore 14
    //   2834: aload 20
    //   2836: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2839: getfield 3350	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2842: aload 20
    //   2844: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2847: invokestatic 2775	onk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2850: aload_0
    //   2851: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   2854: aload_0
    //   2855: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2858: invokestatic 2790	bbev:h	(Landroid/content/Context;)Z
    //   2861: aload 20
    //   2863: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2866: getfield 3449	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2869: aload 20
    //   2871: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2874: getfield 3321	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2877: aconst_null
    //   2878: iconst_0
    //   2879: aload 20
    //   2881: getfield 3209	qar:jdField_f_of_type_Int	I
    //   2884: aload 20
    //   2886: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2889: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2892: invokestatic 3457	onk:a	(JIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lorg/json/JSONObject;
    //   2895: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2898: astore 16
    //   2900: aconst_null
    //   2901: ldc_w 1406
    //   2904: ldc_w 1408
    //   2907: aload 14
    //   2909: aload 15
    //   2911: aload 15
    //   2913: iconst_0
    //   2914: iconst_0
    //   2915: new 577	java/lang/StringBuilder
    //   2918: dup
    //   2919: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2922: aload 20
    //   2924: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2927: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2930: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2933: ldc_w 1408
    //   2936: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2942: new 577	java/lang/StringBuilder
    //   2945: dup
    //   2946: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2949: aload 20
    //   2951: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2954: getfield 3142	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2957: invokevirtual 677	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2960: ldc_w 1408
    //   2963: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2966: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2969: new 577	java/lang/StringBuilder
    //   2972: dup
    //   2973: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   2976: aload 20
    //   2978: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2981: getfield 3429	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2984: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2987: ldc_w 1408
    //   2990: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2993: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2996: aload 16
    //   2998: iconst_0
    //   2999: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3002: goto -1277 -> 1725
    //   3005: aload 20
    //   3007: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3010: invokestatic 1384	onk:n	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3013: ifeq -1288 -> 1725
    //   3016: aconst_null
    //   3017: aconst_null
    //   3018: ldc_w 3344
    //   3021: ldc_w 3344
    //   3024: iconst_0
    //   3025: iconst_0
    //   3026: ldc_w 1408
    //   3029: ldc_w 1408
    //   3032: ldc_w 1408
    //   3035: aload 14
    //   3037: iconst_0
    //   3038: invokestatic 3291	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3041: goto -1316 -> 1725
    //   3044: aload 20
    //   3046: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3049: invokestatic 3460	onk:u	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3052: ifeq +92 -> 3144
    //   3055: aload 20
    //   3057: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3060: getfield 3464	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lqca;
    //   3063: getfield 3467	qca:jdField_a_of_type_Int	I
    //   3066: ifne +18 -> 3084
    //   3069: aload 20
    //   3071: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3074: aload_0
    //   3075: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3078: invokestatic 3470	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommend:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3081: goto -1356 -> 1725
    //   3084: aload 20
    //   3086: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3089: getfield 3464	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lqca;
    //   3092: getfield 3467	qca:jdField_a_of_type_Int	I
    //   3095: iconst_1
    //   3096: if_icmpne +18 -> 3114
    //   3099: aload 20
    //   3101: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3104: aload_0
    //   3105: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3108: invokestatic 3473	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowList:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3111: goto -1386 -> 1725
    //   3114: aload 20
    //   3116: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3119: getfield 3464	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lqca;
    //   3122: getfield 3467	qca:jdField_a_of_type_Int	I
    //   3125: iconst_2
    //   3126: if_icmpne -1401 -> 1725
    //   3129: aload 20
    //   3131: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3134: aload_0
    //   3135: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3138: invokestatic 3476	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowGroup:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3141: goto -1416 -> 1725
    //   3144: aload 20
    //   3146: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3149: getfield 3477	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedType	I
    //   3152: bipush 33
    //   3154: if_icmpne +37 -> 3191
    //   3157: aload 20
    //   3159: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3162: invokevirtual 3480	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getProteusItemData	()Lorg/json/JSONObject;
    //   3165: astore 14
    //   3167: aload 14
    //   3169: ifnull -3125 -> 44
    //   3172: iconst_0
    //   3173: aload 14
    //   3175: aload 20
    //   3177: invokestatic 3483	onk:a	(ZLorg/json/JSONObject;Lqar;)V
    //   3180: iconst_1
    //   3181: aload 14
    //   3183: aload 20
    //   3185: invokestatic 3483	onk:a	(ZLorg/json/JSONObject;Lqar;)V
    //   3188: goto -1463 -> 1725
    //   3191: aload 20
    //   3193: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3196: invokestatic 3485	onk:q	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3199: ifeq +16 -> 3215
    //   3202: aload 20
    //   3204: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3207: aload 20
    //   3209: invokestatic 3488	onk:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Lqar;)V
    //   3212: goto -1487 -> 1725
    //   3215: aload 20
    //   3217: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3220: invokestatic 1265	onk:i	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3223: ifeq +135 -> 3358
    //   3226: aload 20
    //   3228: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3231: astore 16
    //   3233: aload 16
    //   3235: getfield 3489	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lqbv;
    //   3238: invokestatic 3492	onk:a	(Lqbv;)Lorg/json/JSONObject;
    //   3241: astore 17
    //   3243: aconst_null
    //   3244: ldc_w 1406
    //   3247: ldc_w 1408
    //   3250: aload 20
    //   3252: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3255: ldc_w 3494
    //   3258: ldc_w 3494
    //   3261: iconst_0
    //   3262: iconst_0
    //   3263: new 577	java/lang/StringBuilder
    //   3266: dup
    //   3267: invokespecial 578	java/lang/StringBuilder:<init>	()V
    //   3270: aload 20
    //   3272: getfield 3371	qar:jdField_k_of_type_Int	I
    //   3275: invokevirtual 587	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3278: ldc_w 1408
    //   3281: invokevirtual 584	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3284: invokevirtual 591	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3287: aload 20
    //   3289: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3292: invokevirtual 661	java/lang/Long:longValue	()J
    //   3295: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3298: aload 16
    //   3300: getfield 3489	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lqbv;
    //   3303: getfield 3495	qbv:jdField_d_of_type_Long	J
    //   3306: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3309: aload 17
    //   3311: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3314: iconst_0
    //   3315: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3318: aload 18
    //   3320: aload 16
    //   3322: getfield 3489	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lqbv;
    //   3325: getfield 3496	qbv:jdField_c_of_type_Long	J
    //   3328: invokestatic 573	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3331: invokevirtual 2980	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   3334: ifne -3174 -> 160
    //   3337: aload 18
    //   3339: aload 16
    //   3341: getfield 3489	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lqbv;
    //   3344: getfield 3496	qbv:jdField_c_of_type_Long	J
    //   3347: invokestatic 573	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3350: iconst_1
    //   3351: invokestatic 640	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3354: invokevirtual 1059	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3357: pop
    //   3358: new 2785	qze
    //   3361: dup
    //   3362: aload 14
    //   3364: invokespecial 2799	qze:<init>	(Ljava/lang/String;)V
    //   3367: astore 16
    //   3369: aload 16
    //   3371: aload 20
    //   3373: getfield 3498	qar:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3376: invokestatic 2808	onk:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3379: invokestatic 640	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3382: invokevirtual 2811	qze:a	(Ljava/lang/Boolean;)Lqze;
    //   3385: aload 20
    //   3387: getfield 3498	qar:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3390: getfield 3229	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   3393: invokevirtual 2813	qze:a	(Ljava/lang/String;)Lqze;
    //   3396: aload 20
    //   3398: getfield 3498	qar:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3401: invokevirtual 3500	qze:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   3404: pop
    //   3405: aload_0
    //   3406: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3409: ldc_w 1659
    //   3412: if_icmpne +224 -> 3636
    //   3415: aload 16
    //   3417: aload 20
    //   3419: getfield 3211	qar:jdField_j_of_type_Int	I
    //   3422: invokevirtual 3502	qze:b	(I)Lqze;
    //   3425: pop
    //   3426: aconst_null
    //   3427: ldc_w 1406
    //   3430: ldc_w 1408
    //   3433: aload 20
    //   3435: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3438: ldc_w 3504
    //   3441: ldc_w 3504
    //   3444: iconst_0
    //   3445: iconst_0
    //   3446: aload 20
    //   3448: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3451: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3454: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3457: aload 20
    //   3459: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3462: invokevirtual 661	java/lang/Long:longValue	()J
    //   3465: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3468: aload 20
    //   3470: getfield 2176	qar:jdField_b_of_type_Int	I
    //   3473: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3476: aload 16
    //   3478: invokevirtual 2820	qze:a	()Lqzd;
    //   3481: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   3484: iconst_0
    //   3485: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3488: ldc_w 3504
    //   3491: aload 20
    //   3493: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3496: aload 20
    //   3498: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3501: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3504: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3507: aload 20
    //   3509: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3512: invokevirtual 661	java/lang/Long:longValue	()J
    //   3515: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3518: aload 20
    //   3520: getfield 2176	qar:jdField_b_of_type_Int	I
    //   3523: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3526: aload 20
    //   3528: getfield 2172	qar:jdField_a_of_type_Long	J
    //   3531: aload 20
    //   3533: getfield 3202	qar:jdField_c_of_type_Int	I
    //   3536: aload_0
    //   3537: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   3540: aload 20
    //   3542: getfield 3203	qar:jdField_d_of_type_Int	I
    //   3545: aload 20
    //   3547: getfield 3206	qar:jdField_e_of_type_Int	I
    //   3550: aload_0
    //   3551: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   3554: invokestatic 2790	bbev:h	(Landroid/content/Context;)Z
    //   3557: aload 20
    //   3559: getfield 3207	qar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3562: aload 20
    //   3564: getfield 3208	qar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3567: aload 20
    //   3569: getfield 2190	qar:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   3572: aload 20
    //   3574: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3577: invokestatic 2795	onk:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   3580: aload 20
    //   3582: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3585: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   3588: lload 8
    //   3590: iload 7
    //   3592: aload 20
    //   3594: getfield 3209	qar:jdField_f_of_type_Int	I
    //   3597: aload 20
    //   3599: getfield 3210	qar:jdField_g_of_type_Int	I
    //   3602: aload 20
    //   3604: getfield 3194	qar:jdField_h_of_type_Int	I
    //   3607: aload 20
    //   3609: getfield 3197	qar:jdField_f_of_type_Boolean	Z
    //   3612: aload 20
    //   3614: getfield 3211	qar:jdField_j_of_type_Int	I
    //   3617: aload 20
    //   3619: getfield 3212	qar:jdField_i_of_type_Int	I
    //   3622: aload 20
    //   3624: getfield 3214	qar:m	I
    //   3627: invokestatic 3217	onk:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   3630: invokestatic 2781	noo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3633: goto -1908 -> 1725
    //   3636: aload_0
    //   3637: getfield 93	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_f_of_type_Int	I
    //   3640: iconst_3
    //   3641: if_icmpne +51 -> 3692
    //   3644: iconst_m1
    //   3645: istore 6
    //   3647: iload 6
    //   3649: istore 5
    //   3651: aload_0
    //   3652: getfield 268	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ntg	Lntg;
    //   3655: ifnull +29 -> 3684
    //   3658: iload 6
    //   3660: istore 5
    //   3662: aload_0
    //   3663: getfield 268	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ntg	Lntg;
    //   3666: instanceof 3506
    //   3669: ifeq +15 -> 3684
    //   3672: aload_0
    //   3673: getfield 268	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ntg	Lntg;
    //   3676: checkcast 3506	nth
    //   3679: invokevirtual 3507	nth:a	()I
    //   3682: istore 5
    //   3684: aload 16
    //   3686: iload 5
    //   3688: invokevirtual 3509	qze:P	(I)Lqze;
    //   3691: pop
    //   3692: aload 16
    //   3694: aload 20
    //   3696: getfield 3498	qar:jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3699: invokevirtual 3511	qze:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lqze;
    //   3702: pop
    //   3703: aload 20
    //   3705: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3708: ifnull +113 -> 3821
    //   3711: aload 20
    //   3713: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3716: getfield 3515	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3719: ifnull +102 -> 3821
    //   3722: aload 20
    //   3724: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3727: getfield 3515	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3730: aconst_null
    //   3731: invokevirtual 3521	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3734: astore 17
    //   3736: aload 17
    //   3738: ifnull +83 -> 3821
    //   3741: aload 17
    //   3743: invokeinterface 3525 1 0
    //   3748: ifnull +73 -> 3821
    //   3751: aload 17
    //   3753: invokeinterface 3525 1 0
    //   3758: invokeinterface 3528 1 0
    //   3763: astore 17
    //   3765: aload 17
    //   3767: ifnull +54 -> 3821
    //   3770: aload 17
    //   3772: invokeinterface 391 1 0
    //   3777: ifeq +44 -> 3821
    //   3780: aload 17
    //   3782: invokeinterface 395 1 0
    //   3787: checkcast 3530	java/util/Map$Entry
    //   3790: astore 21
    //   3792: aload 16
    //   3794: aload 21
    //   3796: invokeinterface 3533 1 0
    //   3801: checkcast 746	java/lang/String
    //   3804: aload 21
    //   3806: invokeinterface 3536 1 0
    //   3811: invokevirtual 3537	java/lang/Object:toString	()Ljava/lang/String;
    //   3814: invokevirtual 3540	qze:a	(Ljava/lang/String;Ljava/lang/Object;)Lqze;
    //   3817: pop
    //   3818: goto -53 -> 3765
    //   3821: aload 15
    //   3823: aload 20
    //   3825: aload 16
    //   3827: invokestatic 3543	onk:a	(Ljava/lang/String;Lqar;Lqze;)V
    //   3830: aconst_null
    //   3831: ldc_w 1406
    //   3834: ldc_w 1408
    //   3837: aload 20
    //   3839: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   3842: aload 15
    //   3844: aload 15
    //   3846: iconst_0
    //   3847: iconst_0
    //   3848: aload 20
    //   3850: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3853: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3856: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3859: aload 20
    //   3861: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   3864: invokevirtual 661	java/lang/Long:longValue	()J
    //   3867: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3870: aload 20
    //   3872: getfield 2176	qar:jdField_b_of_type_Int	I
    //   3875: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3878: aload 16
    //   3880: invokevirtual 2820	qze:a	()Lqzd;
    //   3883: invokevirtual 2823	qzd:a	()Ljava/lang/String;
    //   3886: iconst_0
    //   3887: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3890: aload 20
    //   3892: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3895: getfield 3515	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3898: invokestatic 3548	sfc:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
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
    //   3942: checkcast 746	java/lang/String
    //   3945: astore 17
    //   3947: new 1971	org/json/JSONObject
    //   3950: dup
    //   3951: aload 14
    //   3953: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3956: astore 16
    //   3958: aload 20
    //   3960: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3963: getfield 3515	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3966: aload 17
    //   3968: invokevirtual 3521	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3971: astore 17
    //   3973: aload 17
    //   3975: ifnull +462 -> 4437
    //   3978: aload 16
    //   3980: aload 17
    //   3982: invokestatic 3551	sfc:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   3985: aload 16
    //   3987: invokevirtual 2018	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3990: astore 16
    //   3992: aload 16
    //   3994: astore 14
    //   3996: aconst_null
    //   3997: ldc_w 1406
    //   4000: ldc_w 1408
    //   4003: aload 20
    //   4005: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4008: aload 15
    //   4010: aload 15
    //   4012: iconst_0
    //   4013: iconst_0
    //   4014: aload 20
    //   4016: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4019: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4022: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4025: aload 20
    //   4027: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4030: invokevirtual 661	java/lang/Long:longValue	()J
    //   4033: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4036: aload 20
    //   4038: getfield 2176	qar:jdField_b_of_type_Int	I
    //   4041: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4044: aload 14
    //   4046: iconst_0
    //   4047: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4050: goto -129 -> 3921
    //   4053: astore 17
    //   4055: aload 14
    //   4057: astore 16
    //   4059: aload 17
    //   4061: astore 14
    //   4063: ldc_w 533
    //   4066: iconst_1
    //   4067: ldc_w 3553
    //   4070: aload 14
    //   4072: invokestatic 3556	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4075: aload 16
    //   4077: astore 14
    //   4079: goto -158 -> 3921
    //   4082: aload 15
    //   4084: aload 20
    //   4086: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4089: aload 20
    //   4091: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4094: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4097: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4100: aload 20
    //   4102: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4105: invokevirtual 661	java/lang/Long:longValue	()J
    //   4108: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4111: aload 20
    //   4113: getfield 2176	qar:jdField_b_of_type_Int	I
    //   4116: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4119: aload 20
    //   4121: getfield 2172	qar:jdField_a_of_type_Long	J
    //   4124: aload 20
    //   4126: getfield 3202	qar:jdField_c_of_type_Int	I
    //   4129: aload_0
    //   4130: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4133: aload 20
    //   4135: getfield 3203	qar:jdField_d_of_type_Int	I
    //   4138: aload 20
    //   4140: getfield 3206	qar:jdField_e_of_type_Int	I
    //   4143: aload_0
    //   4144: invokevirtual 406	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   4147: invokestatic 2790	bbev:h	(Landroid/content/Context;)Z
    //   4150: aload 20
    //   4152: getfield 3207	qar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   4155: aload 20
    //   4157: getfield 3208	qar:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   4160: aload 20
    //   4162: getfield 2190	qar:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   4165: aload 20
    //   4167: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4170: invokestatic 2795	onk:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   4173: aload 20
    //   4175: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4178: checkcast 595	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   4181: lload 8
    //   4183: iload 7
    //   4185: aload 20
    //   4187: getfield 3209	qar:jdField_f_of_type_Int	I
    //   4190: aload 20
    //   4192: getfield 3210	qar:jdField_g_of_type_Int	I
    //   4195: aload 20
    //   4197: getfield 3194	qar:jdField_h_of_type_Int	I
    //   4200: aload 20
    //   4202: getfield 3197	qar:jdField_f_of_type_Boolean	Z
    //   4205: aload 20
    //   4207: getfield 3211	qar:jdField_j_of_type_Int	I
    //   4210: aload 20
    //   4212: getfield 3212	qar:jdField_i_of_type_Int	I
    //   4215: aload 20
    //   4217: getfield 3214	qar:m	I
    //   4220: invokestatic 3217	onk:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   4223: invokestatic 2781	noo:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4226: sipush 250
    //   4229: invokestatic 3558	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   4232: ldc_w 3560
    //   4235: iconst_0
    //   4236: invokevirtual 1706	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   4239: iconst_1
    //   4240: if_icmpne -2515 -> 1725
    //   4243: aload_0
    //   4244: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4247: invokestatic 804	oox:c	(I)Z
    //   4250: ifne -2525 -> 1725
    //   4253: new 3562	onr
    //   4256: dup
    //   4257: new 1971	org/json/JSONObject
    //   4260: dup
    //   4261: aload 16
    //   4263: invokespecial 2533	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4266: invokespecial 3565	onr:<init>	(Lorg/json/JSONObject;)V
    //   4269: astore 14
    //   4271: invokestatic 3566	shx:b	()I
    //   4274: ifle +84 -> 4358
    //   4277: iconst_0
    //   4278: istore 5
    //   4280: aload 14
    //   4282: ldc_w 3568
    //   4285: iload 5
    //   4287: invokevirtual 3571	onr:b	(Ljava/lang/String;I)Lonr;
    //   4290: pop
    //   4291: aconst_null
    //   4292: ldc_w 1406
    //   4295: ldc_w 1408
    //   4298: aload 20
    //   4300: getfield 3284	qar:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   4303: ldc_w 3573
    //   4306: ldc_w 3573
    //   4309: iconst_0
    //   4310: iconst_0
    //   4311: aload 20
    //   4313: getfield 2196	qar:jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4316: getfield 3285	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4319: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4322: aload 20
    //   4324: getfield 2165	qar:jdField_a_of_type_JavaLangLong	Ljava/lang/Long;
    //   4327: invokevirtual 661	java/lang/Long:longValue	()J
    //   4330: invokestatic 1422	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4333: aload 20
    //   4335: getfield 2176	qar:jdField_b_of_type_Int	I
    //   4338: invokestatic 1424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4341: aload 14
    //   4343: invokevirtual 3574	onr:a	()Ljava/lang/String;
    //   4346: iconst_0
    //   4347: invokestatic 1429	noo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4350: goto -2625 -> 1725
    //   4353: astore 14
    //   4355: goto -2630 -> 1725
    //   4358: iconst_1
    //   4359: istore 5
    //   4361: goto -81 -> 4280
    //   4364: ldc_w 3576
    //   4367: astore 14
    //   4369: goto -2247 -> 2122
    //   4372: astore 14
    //   4374: aload 14
    //   4376: invokevirtual 2019	org/json/JSONException:printStackTrace	()V
    //   4379: goto -2218 -> 2161
    //   4382: aload_0
    //   4383: getfield 226	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Int	I
    //   4386: ldc_w 1659
    //   4389: if_icmpeq +8 -> 4397
    //   4392: aload_0
    //   4393: aload_1
    //   4394: invokespecial 3578	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:e	(Ljava/util/Map;)V
    //   4397: aload_3
    //   4398: invokestatic 3187	shx:a	(Ljava/util/Map;)V
    //   4401: aload_0
    //   4402: invokespecial 3199	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	()Landroid/util/Pair;
    //   4405: getfield 1325	android/util/Pair:first	Ljava/lang/Object;
    //   4408: checkcast 554	java/lang/Integer
    //   4411: invokevirtual 911	java/lang/Integer:intValue	()I
    //   4414: invokestatic 3579	rgq:a	(I)V
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
    //   0	4461	1	paramMap	Map<Long, qar>
    //   0	4461	2	paramBoolean	boolean
    //   0	4461	3	paramMap1	Map<Long, sic>
    //   0	4461	4	paramString	String
    //   818	3636	5	m	int
    //   1874	1785	6	n	int
    //   226	3958	7	i1	int
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
    //   180	4154	20	localqar	qar
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
  
  public void a(Set<Long> paramSet, Map<Long, qar> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "attachToViewGroup()");
    }
    a(new rde(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Rao != null) {
      this.jdField_a_of_type_Rao.a(paramSet, paramMap);
    }
    this.jdField_a_of_type_Omw.jdField_b_of_type_Long = System.currentTimeMillis();
    if (i()) {
      if (this.jdField_a_of_type_Int != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Omw.jdField_d_of_type_Long = bhvh.a((QQAppInterface)onk.a(), a());; this.jdField_a_of_type_Omw.jdField_d_of_type_Long = bhvh.a((QQAppInterface)onk.a(), this.jdField_a_of_type_Int))
    {
      r();
      sgx.a(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!a()) {
        break;
      }
      return;
    }
    j();
  }
  
  public void a(oyg paramoyg)
  {
    if (paramoyg == null) {}
    for (;;)
    {
      return;
      int m = 0;
      while (m < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramoyg.a((oya)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(m));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(m)), ", jobName : ", paramoyg.a(), ", cost : ", Long.valueOf(l2 - l1) });
        m += 1;
      }
    }
  }
  
  public void a(qty paramqty1, qty paramqty2)
  {
    this.jdField_g_of_type_Boolean = false;
    ((oyc)a(2)).j();
    if (this.jdField_e_of_type_Long == 1002L) {
      setPadding(0, actn.a(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131298585), 0, 0);
    }
  }
  
  public void a(rqs paramrqs)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramrqs);
      this.jdField_a_of_type_Rqs = paramrqs;
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
    a(new rdi(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.19(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(paramInt);
    }
    for (;;)
    {
      o();
      oxt.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      a(2, null);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int i1 = 0;
    int m;
    int n;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      m = 0;
      for (paramInt = -1; m < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(); paramInt = n)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(m);
        n = paramInt;
        if (localObject != null)
        {
          n = paramInt;
          if (((View)localObject).getTag() != null)
          {
            n = paramInt;
            if ((((View)localObject).getTag() instanceof oyo))
            {
              localObject = (oyo)((View)localObject).getTag();
              n = paramInt;
              if (paramLong == ((oyo)localObject).jdField_a_of_type_Qty.jdField_c_of_type_Long) {
                n = ((oyo)localObject).jdField_a_of_type_Int;
              }
            }
          }
        }
        m += 1;
      }
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - n;
      if (m >= 0) {
        break label354;
      }
      m = i1;
    }
    label354:
    for (;;)
    {
      i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() - n;
      if ((paramInt + 1 >= m) && (paramInt + 1 <= i1))
      {
        this.jdField_a_of_type_Rao.a(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Rao.c(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Ntg.a();
        if (paramList != null) {
          paramList.a(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + m + ", lastVisblePosi=" + i1 + "， headerCount=" + n);
        }
        return;
        this.jdField_a_of_type_Rao.a(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
        this.jdField_a_of_type_Rao.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rao == null)) {
      return;
    }
    a(new rdq(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Rao.getCount() == 0) {}
    int m = osj.a().a(Integer.valueOf(paramInt));
    if (this.jdField_h_of_type_Boolean)
    {
      if ((paramList != null) && (m == 1)) {
        this.jdField_a_of_type_Rao.c(0);
      }
      this.jdField_h_of_type_Boolean = false;
    }
    pqm.a().a();
    if (paramBoolean1) {
      if ((paramList != null) && (m > 0) && (paramList.size() > 0))
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
        if (!this.jdField_a_of_type_Rao.i) {
          this.jdField_a_of_type_Rao.jdField_h_of_type_Boolean = false;
        }
        this.jdField_a_of_type_Rao.i = true;
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Rao.i + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Rao.jdField_h_of_type_Boolean);
        }
        qkw.a().c(true);
        setAdapterData(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Rao.a(0);
        if ((paramInt == 56) || (paramInt == 0))
        {
          localObject = onk.a();
          if (localObject != null) {
            ((nzj)((AppRuntime)localObject).getManager(307)).a(getContext(), paramInt);
          }
        }
        if (paramInt == 70) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
        }
        if ((paramInt == 0) || (oox.c(this.jdField_a_of_type_Int))) {
          ota.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        }
        b(paramBoolean1, m);
        if (this.jdField_a_of_type_Int == 70) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int = 0;
        }
        if ((this.jdField_a_of_type_Int == 56) && (this.j)) {
          if (this.jdField_a_of_type_Oes != null) {
            break label660;
          }
        }
      }
    }
    label660:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
      this.j = false;
      if ((oox.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).g();
      }
      a(paramList);
      b(paramList);
      AbstractGifImage.resumeAll();
      oxx.a(this.jdField_a_of_type_Rao.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Rao);
      opw.a(this.jdField_a_of_type_Rao.b(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Rao.isEmpty()) {
        break;
      }
      if (this.jdField_a_of_type_Int == 70)
      {
        a(getResources().getString(2131718461), getResources().getDrawable(2130848408));
        break;
      }
      a(getResources().getString(2131718536));
      break;
      if (!this.jdField_a_of_type_Rao.isEmpty()) {
        break;
      }
      a(getResources().getString(2131718503));
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
    if (this.jdField_a_of_type_Ree != null) {
      this.jdField_a_of_type_Ree.a(this.jdField_b_of_type_Int);
    }
    if (this.jdField_a_of_type_Rao != null) {
      this.jdField_a_of_type_Rao.a(2, null);
    }
    a(new rdz(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Rao != null) {
      oxt.a(this.jdField_a_of_type_Rao.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rao == null) || (paramList == null)) {}
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
        qkw.a().c(true);
        setAdapterData(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 1);
        this.jdField_a_of_type_Rao.a(0);
        return;
      }
    } while (!this.jdField_a_of_type_Rao.isEmpty());
    a(getResources().getString(2131718536));
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int m = 0;
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.jdField_c_of_type_Boolean = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.jdField_a_of_type_Int + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.jdField_c_of_type_Int);
      }
      paramReadInJoyBaseListView = onk.a();
      if ((paramReadInJoyBaseListView == null) || (this.jdField_a_of_type_Int != 56) || (this.jdField_e_of_type_Long != 1001L)) {
        break label205;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(162)).g()) {
        m = 4;
      }
      m |= 0x2;
    }
    for (;;)
    {
      int n;
      if ((this.jdField_a_of_type_Int == 40830) || (oox.c(this.jdField_a_of_type_Int)))
      {
        n = this.jdField_c_of_type_Int;
        this.jdField_c_of_type_Int = (n + 1);
      }
      for (;;)
      {
        osj.a().a(this.jdField_a_of_type_Int, b(), paramInt, m, n);
        ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.34(this));
        return;
        bool = false;
        break;
        n = 1;
      }
      label205:
      m = 0;
    }
  }
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_Rao == null))
    {
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    a(new rds(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList), 2);
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
        paramList = getResources().getString(2131718326);
        bcpw.a(getContext().getApplicationContext(), paramList, 0).a();
      }
      if ((oox.a(this.jdField_a_of_type_Int)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
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
    return (this.jdField_a_of_type_Int == 56) && (this.jdField_a_of_type_Ntg.a().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
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
    if ((paramInt != this.jdField_a_of_type_Int) || (paramList == null) || (this.jdField_a_of_type_Rao == null)) {
      return;
    }
    this.jdField_a_of_type_Rao.b(osj.a().a(Integer.valueOf(this.jdField_a_of_type_Int), paramList));
    this.jdField_a_of_type_Rao.notifyDataSetChanged();
  }
  
  public void c(Map<Integer, qar> paramMap)
  {
    a(new rdd(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Nun != null) {
      this.jdField_a_of_type_Nun.a(paramMap);
    }
  }
  
  public boolean c()
  {
    int m = a().getIntent().getIntExtra("launch_from", -1);
    return (m == 9) || (m == 6);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onPause()");
    }
    a(new rdn(this, "onPause"));
    if (this.jdField_a_of_type_Rao != null) {
      this.jdField_a_of_type_Rao.k();
    }
    Iterator localIterator = this.jdField_c_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((rny)localIterator.next()).d();
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
    oxt.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void d(Map<Integer, qar> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        qar localqar = (qar)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localqar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int n = oes.jdField_b_of_type_Int;
        if ((localqar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localqar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localqar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int m = localqar.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; m = 0)
        {
          oes.a("0X8009495", localTabChannelCoverInfo, n, m, -1);
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
    opw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.jdField_a_of_type_Int, 2, "onStart()");
    }
    a(new rdo(this, "onStart"));
    pqm.a().b();
    if ((this.jdField_a_of_type_Int == 0) && (!this.jdField_h_of_type_Boolean)) {
      a(1500, new ReadInJoyListViewGroup.27(this));
    }
  }
  
  public boolean e()
  {
    Boolean localBoolean = (Boolean)a(new red(this, "onBackPressed"));
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
    a(new rdp(this, "onStop"));
    if ((i()) && (j()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Rao.b(0);
      if (localArticleInfo != null) {
        osj.a().a(this.jdField_a_of_type_Int, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    pqm.a().c();
  }
  
  public boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "[isOpenFloatingWindow], res = " + this.i);
    }
    return this.i;
  }
  
  public void g()
  {
    a(new rdk(this, "onDestroy"));
    bhvh.a(System.currentTimeMillis(), (QQAppInterface)onk.a());
    Object localObject = ((oso)onk.a().getManager(163)).a().a();
    if (localObject != null) {
      ((pai)localObject).b(this.jdField_g_of_type_Int);
    }
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_Ajxl);
    this.jdField_c_of_type_Int = 1;
    this.jdField_a_of_type_Rao.d();
    this.jdField_a_of_type_Rao.a();
    this.jdField_a_of_type_Rao.a(null);
    this.jdField_a_of_type_Rao = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      opw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c();
    }
    if (this.jdField_a_of_type_Baxk != null)
    {
      this.jdField_a_of_type_Baxk.d();
      this.jdField_a_of_type_Baxk = null;
    }
    if (this.jdField_a_of_type_Osp != null) {
      osm.a().b(this.jdField_a_of_type_Osp);
    }
    bhvh.b(((BaseActivity)a()).app);
    if (this.jdField_a_of_type_Oes != null)
    {
      this.jdField_a_of_type_Oes.a();
      this.jdField_a_of_type_Oes = null;
    }
    if (this.jdField_a_of_type_Rgu != null)
    {
      this.jdField_a_of_type_Rgu.b();
      this.jdField_a_of_type_Rgu = null;
    }
    localObject = this.jdField_c_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((rny)((Iterator)localObject).next()).b();
    }
    ((KandianMergeManager)onk.a().getManager(162)).b(this.jdField_a_of_type_Osb);
    this.jdField_a_of_type_Osb = null;
    sht.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.b();
    }
    oxt.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (oox.c(a())) {
      onu.a().b();
    }
    qah.b(a());
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.d();
    ((KandianMergeManager)onk.a().getManager(162)).b(this.jdField_a_of_type_Osb);
  }
  
  public void l()
  {
    this.jdField_g_of_type_Boolean = true;
    ((oyc)a(2)).i();
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
    qtu localqtu = this.jdField_a_of_type_Ntg.a();
    if ((localqtu != null) && (localqtu.a() != null)) {
      localqtu.b(11);
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
    onk.b(3);
    a(true, 3, false);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_Rao.getItem((int)paramLong);
    ArticleInfo localArticleInfo = null;
    if ((localObject instanceof ArticleInfo))
    {
      localArticleInfo = (ArticleInfo)localObject;
      if (!onk.r(localArticleInfo)) {}
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
    if (this.jdField_a_of_type_Rao != null) {
      this.jdField_a_of_type_Rao.notifyDataSetChanged();
    }
  }
  
  public void r()
  {
    if (onk.k() == 0) {}
    while (this.jdField_a_of_type_Int != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.43(this));
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Rqs);
    }
  }
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Rao.a().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((BaseArticleInfo)localIterator.next());
    }
    paramList = ozj.a().a(this.jdField_a_of_type_Int, paramList, localArrayList, paramInt);
    if ((this.jdField_a_of_type_Int == 0) || (oox.b(oox.b()))) {
      this.jdField_a_of_type_Rao.a(true);
    }
    this.jdField_a_of_type_Rao.a(paramList);
    this.jdField_a_of_type_Rao.notifyDataSetChanged();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void setNotifyEndRefresh(ree paramree)
  {
    this.jdField_a_of_type_Ree = paramree;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!pzc.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
    rqq localrqq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    s();
    localrqq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!pzc.jdField_b_of_type_Boolean) && ((a() instanceof SplashActivity))) {}
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
      localrqq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      s();
      localrqq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a());
    rqq localrqq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    s();
    localrqq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(ajyc.a(2131712948));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */