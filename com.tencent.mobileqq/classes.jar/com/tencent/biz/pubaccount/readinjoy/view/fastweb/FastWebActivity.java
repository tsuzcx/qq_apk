package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import Override;
import abgu;
import agej;
import aklh;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.MQLruCache;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoof;
import aoog;
import aqre;
import aqvh;
import bdmc;
import beaj;
import bhjr;
import bhlo;
import bhmq;
import bhnv;
import bhny;
import blhn;
import blih;
import blle;
import blrf;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TitleData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nzj;
import ocd;
import ohk;
import oid;
import oif;
import oix;
import ono;
import org.json.JSONException;
import org.json.JSONObject;
import orv;
import osm;
import oso;
import osp;
import osr;
import oss;
import otv;
import oyq;
import ozs;
import pag;
import pbd;
import pda;
import pfa;
import pfd;
import pfg;
import pfh;
import ppe;
import pph;
import ppi;
import ppo;
import ppq;
import pql;
import qxa;
import qxr;
import qxt;
import qzb;
import qzd;
import rmn;
import sel;
import snc;
import snd;
import snf;
import sng;
import snh;
import sni;
import snj;
import snk;
import snl;
import snm;
import snn;
import sno;
import snp;
import snq;
import snr;
import snt;
import snu;
import snv;
import snw;
import snx;
import sny;
import snz;
import soa;
import sob;
import soc;
import sod;
import soe;
import sof;
import sog;
import soh;
import soi;
import soj;
import sok;
import sol;
import son;
import sop;
import sos;
import spb;
import spc;
import spe;
import spi;
import srl;
import srn;
import srt;
import srw;
import srx;
import sry;
import ssi;
import ssn;
import sst;
import ssu;
import ssy;
import stb;
import std;
import svc;
import tkv;
import tkz;
import tlf;
import tln;
import tpx;
import tqt;
import trr;
import uak;
import uan;
import ubg;
import uby;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, aoog, MiniMsgUser.IMiniMsgActionCallback, oif, oso, osr, trr, uan
{
  private boolean A = true;
  private boolean B;
  private float jdField_a_of_type_Float = bhlo.d() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private abgu jdField_a_of_type_Abgu;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoof jdField_a_of_type_Aoof;
  private aqre jdField_a_of_type_Aqre;
  blih jdField_a_of_type_Blih = new snp(this);
  private blrf jdField_a_of_type_Blrf = new snu(this);
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  public ArticleInfo a;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  private AuthorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private CommonAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
  public MiniMsgUser a;
  public INetInfoHandler a;
  private IScrollReader jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  protected String a;
  private ArrayList<tkv> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nzj jdField_a_of_type_Nzj;
  private ono jdField_a_of_type_Ono;
  private orv jdField_a_of_type_Orv;
  private pag jdField_a_of_type_Pag = new pag();
  private pfh jdField_a_of_type_Pfh = new snq(this);
  private pph jdField_a_of_type_Pph = new snx(this);
  private ppi jdField_a_of_type_Ppi = new snw(this);
  ppq jdField_a_of_type_Ppq = new sod(this);
  private pql jdField_a_of_type_Pql = new snc(this);
  private sok jdField_a_of_type_Sok;
  private sol jdField_a_of_type_Sol;
  son jdField_a_of_type_Son = new soa(this);
  private sop jdField_a_of_type_Sop;
  private spb jdField_a_of_type_Spb;
  private spc jdField_a_of_type_Spc;
  private srl jdField_a_of_type_Srl = new srl(this);
  private srn jdField_a_of_type_Srn;
  private ssi jdField_a_of_type_Ssi = new ssi();
  private stb jdField_a_of_type_Stb;
  private uak jdField_a_of_type_Uak;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = bhlo.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  public long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new snz(this);
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = System.currentTimeMillis() + "";
  private pfh jdField_b_of_type_Pfh = new snr(this);
  public boolean b;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = 1000;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int = 2;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean = true;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int = 1;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean = true;
  private int jdField_x_of_type_Int = -1;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean;
  private boolean z = true;
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new sny(this);
  }
  
  private void A()
  {
    B();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void B()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void C()
  {
    if ((this.jdField_a_of_type_Spc == null) || ((this.jdField_a_of_type_Sop != null) && (this.jdField_a_of_type_Sop.getCount() != this.jdField_a_of_type_Spc.a())))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
    int i1;
    label62:
    int i2;
    label83:
    Object localObject;
    int i4;
    boolean bool1;
    label264:
    float f1;
    if (i3 > this.jdField_g_of_type_Int)
    {
      i1 = 1;
      if (this.jdField_a_of_type_Spc != null)
      {
        if (this.jdField_g_of_type_Int <= i3) {
          break label394;
        }
        i2 = this.jdField_g_of_type_Int;
        this.jdField_g_of_type_Int = i2;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        i2 = this.jdField_g_of_type_Int - i2;
        if ((i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_g_of_type_Int < this.jdField_a_of_type_Spc.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(i2);
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i4 = ((View)localObject).getTop();
          this.jdField_i_of_type_Int = (this.jdField_a_of_type_Spc.a(this.jdField_g_of_type_Int) - (i2 - i4));
          if (i1 == 0) {
            break label400;
          }
          this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
          if (this.jdField_h_of_type_Int < 0) {
            this.jdField_h_of_type_Int = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_g_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_h_of_type_Int);
        }
      }
      i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
      i4 = this.jdField_a_of_type_JavaUtilList.size();
      bool1 = false;
      i1 = 0;
      if (i2 > i3) {
        break label474;
      }
      if (i2 >= i4) {
        break label466;
      }
      f1 = BaseData.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2));
      if (f1 > ssy.jdField_a_of_type_ArrayOfFloat[0]) {
        break label432;
      }
      i1 |= 0x1;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (i2 < this.jdField_a_of_type_JavaUtilList.size())
      {
        bool2 = bool1;
        if (((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2)).jdField_d_of_type_Boolean)
        {
          this.jdField_n_of_type_Boolean = true;
          if (this.jdField_b_of_type_Int == 0) {
            this.jdField_b_of_type_Int = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int);
          }
          bool2 = true;
        }
      }
      i2 += 1;
      bool1 = bool2;
      break label264;
      i1 = 0;
      break label62;
      label394:
      i2 = i3;
      break label83;
      label400:
      if (this.jdField_i_of_type_Int < this.jdField_h_of_type_Int) {}
      for (i1 = this.jdField_i_of_type_Int;; i1 = this.jdField_h_of_type_Int)
      {
        this.jdField_h_of_type_Int = i1;
        break;
      }
      label432:
      label590:
      if (f1 <= ssy.jdField_a_of_type_ArrayOfFloat[1]) {
        i1 |= 0x2;
      } else {
        label466:
        label474:
        label730:
        if (f1 <= ssy.jdField_a_of_type_ArrayOfFloat[2])
        {
          i1 |= 0x4;
          continue;
          i1 |= 0x8;
          continue;
          boolean bool3;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a() != null))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
            bool3 = ((tln)localObject).jdField_a_of_type_Boolean;
            if (tkz.a((tln)localObject)) {
              if (!(localObject instanceof tlf)) {
                break label754;
              }
            }
          }
          label602:
          label736:
          label754:
          for (bool2 = ((tlf)localObject).a();; bool2 = false)
          {
            Integer localInteger;
            if ((((tln)localObject).jdField_a_of_type_Int == 2) && (tkz.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight(), this.jdField_b_of_type_Int, bool2, bool1, bool3)))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
              ((tln)localObject).d();
              localObject = ssy.jdField_a_of_type_ArrayOfInt;
              i4 = localObject.length;
              i2 = 0;
              if (i2 < i4)
              {
                localInteger = Integer.valueOf(localObject[i2]);
                if ((1 << localInteger.intValue() & i1) == 0) {
                  break label730;
                }
                i3 = 1;
                label632:
                if (i3 == 0) {
                  break label736;
                }
                pag.b(ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
              }
            }
            for (;;)
            {
              i2 += 1;
              break label602;
              break;
              if ((((tln)localObject).jdField_a_of_type_Int == 1) && (tkz.a(bool1, this.jdField_n_of_type_Boolean, bool3)) && (((tln)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (((tln)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_p_of_type_Int == 1))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
                ((tln)localObject).d();
                break label590;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(8);
              break label590;
              i3 = 0;
              break label632;
              pag.c(ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
            }
          }
        }
      }
    }
  }
  
  private void D()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_Aqre.d();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void E()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        ppe localppe = ((pfg)this.app.getManager(163)).a().a();
        if (localppe != null) {
          localppe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void G()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (localBaseData.jdField_r_of_type_Int == 6) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new spe(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new snm(this, i1, localBaseData));
        }
        else if (ssy.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new snn(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void H()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (a(localBaseData.jdField_r_of_type_Int)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new sno(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void I()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.iterator();
    label208:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label208;
        }
        if (localInteger.intValue() == i1)
        {
          BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(localInteger.intValue());
          if (AdData.a(localBaseData))
          {
            ssy.b(this.app, (AdData)localBaseData);
            if (localBaseData.b == null) {
              break;
            }
            tpx.a("REPORT_LINK", "invalidADExposurePos report " + localBaseData.b.mTitle);
            break;
          }
          QLog.d("FastWebActivity", 1, "invalidADExposurePos report invalid key" + localInteger);
          break;
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.clear();
  }
  
  private void J()
  {
    int i1 = b();
    ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_x_of_type_Int);
    if (this.jdField_a_of_type_Sop != null) {
      this.jdField_a_of_type_Sop.e();
    }
  }
  
  private void K()
  {
    long l1 = std.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_k_of_type_Boolean) {
      bool = false;
    }
    long l2 = std.c("fast_web_show_light_house_2");
    long l3 = std.c("fast_web_show_light_house_3");
    long l4 = std.c("fast_web_show_light_house_draw_finish");
    long l5 = std.c("fast_web_show_light_house_step4_2");
    long l6 = std.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", ozs.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    bdmc.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void L()
  {
    this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0);
    int i1;
    boolean bool1;
    boolean bool2;
    if (localView == null)
    {
      i1 = 0;
      this.jdField_o_of_type_Int = i1;
      this.jdField_p_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
      bool1 = b(this.jdField_n_of_type_Int);
      bool2 = b(this.jdField_p_of_type_Int);
      if ((bool1) || (bool2)) {
        break label101;
      }
      this.jdField_q_of_type_Int = this.jdField_n_of_type_Int;
      this.jdField_r_of_type_Int = this.jdField_o_of_type_Int;
      this.jdField_s_of_type_Boolean = true;
    }
    label101:
    do
    {
      return;
      i1 = localView.getTop();
      break;
      if ((bool1) && (bool2))
      {
        this.jdField_s_of_type_Int = this.jdField_n_of_type_Int;
        this.jdField_t_of_type_Int = this.jdField_o_of_type_Int;
        this.jdField_s_of_type_Boolean = false;
        this.jdField_f_of_type_Boolean = true;
        QLog.d("FastWebActivity", 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
        return;
      }
    } while ((bool1) || (!bool2));
    this.jdField_s_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    QLog.d("FastWebActivity", 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
    d();
  }
  
  private void M()
  {
    try
    {
      srw.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FastWebActivity", 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void N()
  {
    srx.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void O()
  {
    Object localObject = findViewById(2131373721);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131376185);
    String str = getString(2131717217);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_Srl.a()) {}
    srn localsrn;
    do
    {
      return;
      this.jdField_r_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      J();
      this.jdField_r_of_type_Boolean = false;
      localsrn = this.jdField_a_of_type_Srl.a();
    } while (localsrn == null);
    a(localsrn);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_r_of_type_Boolean = false;
  }
  
  private void Q()
  {
    this.jdField_a_of_type_Srn = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_Spc = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_Blih);
    ppe localppe = pfa.a().a();
    if (localppe != null)
    {
      localppe.a(this.jdField_a_of_type_Pph);
      localppe.a(this.jdField_a_of_type_Ppi);
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void R()
  {
    ozs.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Srl.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("FastWebActivity", 2, bool);
      this.jdField_a_of_type_Srl.a(new snv(this));
      return;
    }
  }
  
  private void S()
  {
    u();
  }
  
  private void T()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    this.jdField_y_of_type_Boolean = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.jdField_y_of_type_Boolean)
    {
      this.z = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.A = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_x_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d("FastWebActivity", 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.jdField_y_of_type_Boolean + "  isSuctionTop=" + this.z);
  }
  
  private void U()
  {
    int i1 = (int)(ozs.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private void V()
  {
    if (this.jdField_a_of_type_Ono != null) {
      this.jdField_a_of_type_Ono.a();
    }
    this.jdField_a_of_type_Ono = new ono();
    this.jdField_a_of_type_Ono.a(new soc(this));
  }
  
  private void W()
  {
    Intent localIntent = getIntent();
    if ((localIntent == null) || (localIntent.getExtras() == null)) {
      return;
    }
    switch (localIntent.getExtras().getInt("native_article_launch_from", 1000))
    {
    case 1001: 
    default: 
      return;
    case 1000: 
      this.jdField_m_of_type_Int = c();
      return;
    case 1004: 
      this.jdField_m_of_type_Int = 32;
      return;
    case 1003: 
      this.jdField_m_of_type_Int = 64;
      return;
    }
    this.jdField_m_of_type_Int = 16;
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_Spc == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_g_of_type_Int <= 0) {
      C();
    }
    int i1 = a();
    int i2 = b();
    if ((i1 >= i2) || (i2 <= 0)) {
      return 1.0F;
    }
    return i1 / i2;
  }
  
  private int a()
  {
    return a(this.jdField_g_of_type_Int, this.jdField_h_of_type_Int);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Spc == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Spc.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Spc.a(i1);
      i1 += 1;
    }
    return i2 - paramInt2;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private int a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_j_of_type_Int;
      if (this.jdField_j_of_type_Int == 0) {
        this.jdField_j_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_i_of_type_Int);
      }
    }
  }
  
  private ArticleInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    ArticleInfo localArticleInfo = new ArticleInfo();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localArticleInfo.businessId = ((sos)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
    }
    localArticleInfo.innerUniqueID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
    localArticleInfo.mRecommendSeq = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq;
    localArticleInfo.mAlgorithmID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
    localArticleInfo.mChannelID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    localArticleInfo.mStrategyId = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
    localArticleInfo.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle;
    localArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName;
    localArticleInfo.mFirstPagePicUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl;
    localArticleInfo.mArticleID = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
    localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr = new qxr();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) && (!this.B))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.32(this), paramLong);
  }
  
  private void a(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d("FastWebActivity", 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    QLog.d("FastWebActivity", 1, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.jdField_y_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (sel.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!sel.l(paramArticleInfo)) {
        localObject1 = ((qzd)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qzb.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      O();
      QLog.d("FastWebActivity", 1, " url is null!");
      return;
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo))
    {
      if (((String)localObject1).contains("?"))
      {
        localObject1 = (String)localObject1 + "&";
        localObject2 = (String)localObject1 + "from=0";
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AdvertisementInfo.isAppAdvertisementInfo(paramArticleInfo))
      {
        localObject1 = localObject2;
        if (bhnv.h(null)) {
          if (!((String)localObject2).contains("?")) {
            break label455;
          }
        }
      }
    }
    label455:
    for (localObject1 = (String)localObject2 + "&";; localObject1 = (String)localObject2 + "?")
    {
      localObject1 = (String)localObject1 + "acttype=42";
      localObject2 = new Intent(this, ReadInJoyArticleDetailActivity.class);
      localBundle.putString("url", (String)localObject1);
      localBundle.putBoolean("hide_operation_bar", true);
      localBundle.putBoolean("from_native", true);
      localBundle.putString("from", String.valueOf(53));
      localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
      localBundle.putLong("articleid", paramArticleInfo.mArticleID);
      localBundle.putString("row_key", paramArticleInfo.innerUniqueID);
      localBundle.putInt("channelid", i1);
      localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
      localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
      localBundle.putInt("articalChannelId", 9);
      ((Intent)localObject2).putExtras(localBundle);
      startActivityForResult((Intent)localObject2, 10923);
      return;
      localObject1 = (String)localObject1 + "?";
      break;
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    int i1 = (int)paramArticleInfo.mChannelID;
    Object localObject;
    if (paramFastWebArticleInfo.c())
    {
      localObject = "2";
      localObject = ozs.a(this, paramArticleInfo, i1, (String)localObject);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        if (!this.jdField_t_of_type_Boolean) {
          continue;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.jdField_y_of_type_Boolean) && (this.jdField_x_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_x_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      ssy.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      localObject = "1";
      break;
      i1 = 0;
    }
  }
  
  private void a(AuthorData paramAuthorData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramAuthorData == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    paramAuthorData.c(paramFastWebArticleInfo.q);
    paramAuthorData.a();
  }
  
  private void a(TitleData paramTitleData, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramTitleData == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    paramTitleData.a();
    paramTitleData.c(paramFastWebArticleInfo.q);
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (((!this.jdField_h_of_type_Boolean) && (!paramBoolean)) || ((this.jdField_g_of_type_Boolean) && (!paramBoolean)) || (this.jdField_i_of_type_Boolean)) {}
    Object localObject2;
    int i1;
    label187:
    int i2;
    label328:
    label333:
    do
    {
      do
      {
        float f1;
        do
        {
          return;
          f1 = paramAbsListView.getFlingVelocityY();
        } while (((!paramBoolean) && ((f1 < this.jdField_a_of_type_Float) || (f1 > this.jdField_b_of_type_Float))) || (this.jdField_c_of_type_Int > paramInt) || (paramInt >= paramAbsListView.getCount() - 1));
        this.jdField_c_of_type_Int = paramInt;
        localObject1 = (ListAdapter)paramAbsListView.getAdapter();
        if (!paramBoolean) {
          break;
        }
        localObject2 = ((ListAdapter)localObject1).getItem(paramInt);
      } while ((!(localObject2 instanceof ProteusBannerBigPicItemData)) && (!(localObject2 instanceof ProteusBannerTriplePicItemData)) && (!(localObject2 instanceof ProteusBannerVideoItemData)));
      i1 = ((ListAdapter)localObject1).getItemViewType(paramInt);
      localObject2 = (View)this.jdField_b_of_type_AndroidUtilSparseArray.get(i1);
      ViewGroup.LayoutParams localLayoutParams;
      if (localObject2 == null)
      {
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, null, paramAbsListView);
        this.jdField_b_of_type_AndroidUtilSparseArray.put(i1, localObject1);
        localObject2 = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
        if ((localObject2 == null) || (localObject1 == null)) {
          break;
        }
        i1 = paramAbsListView.getRemainFlingDisY();
        i2 = ((View)localObject2).getBottom() + paramAbsListView.getTop() - paramAbsListView.getBottom() - paramAbsListView.getPaddingBottom();
        localLayoutParams = ((View)localObject1).getLayoutParams();
        if (localLayoutParams == null) {
          break label328;
        }
      }
      for (paramInt = localLayoutParams.width;; paramInt = -1)
      {
        ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), paramInt), 0);
        paramInt = ((View)localObject1).getMeasuredHeight();
        if ((!paramBoolean) || (i2 >= paramInt / 2)) {
          break label333;
        }
        this.jdField_i_of_type_Boolean = true;
        return;
        paramInt += 1;
        break;
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, (View)localObject2, paramAbsListView);
        break label187;
      }
    } while (((i1 <= i2) || (i1 >= paramInt / 2 + i2)) && ((!paramBoolean) || (i2 <= paramInt / 2)));
    this.jdField_g_of_type_Boolean = true;
    Object localObject1 = new FastWebActivity.24(this, (View)localObject2, paramAbsListView, i1, paramInt, paramBoolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramAbsListView.postOnAnimation((Runnable)localObject1);
      return;
    }
    paramAbsListView.post((Runnable)localObject1);
    return;
    this.jdField_i_of_type_Boolean = true;
  }
  
  private void a(srn paramsrn)
  {
    Q();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramsrn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Srn = paramsrn;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Srn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_m_of_type_Boolean = paramsrn.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Spb = paramsrn.jdField_a_of_type_Spb;
    r();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    tpx.a("REPORT_LINK", "requestAdData onGetRecommendsResult");
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o.equals(paramString)))
    {
      paramString = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.jdField_d_of_type_Boolean) {
          paramString.add(localBaseData);
        } else {
          localArrayList.add(localBaseData);
        }
      }
      sst.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      sst.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = pfa.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      G();
      sst.a(this.jdField_a_of_type_JavaUtilList);
      u();
      tkz.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Nzj, paramList2);
      tkz.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Nzj, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramList2);
      QLog.d("FastWebActivity", 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = pfa.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      std.a("HtmlChangeUtil.parse");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = srw.a();
      }
      this.jdField_a_of_type_JavaUtilList = ssn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      N();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        throw new RuntimeException("parse data is empty!");
      }
      this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      Object localObject = srw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      if (localObject != null) {
        this.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_JavaUtilList);
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseData localBaseData = (BaseData)((Iterator)localObject).next();
        localBaseData.b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        localBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      }
      std.a("HtmlChangeUtil.parse");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
    {
      this.jdField_a_of_type_JavaUtilList.set(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.set(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      if ((this.jdField_l_of_type_Int != 1001) && (this.jdField_a_of_type_Srn == null)) {
        sst.d(this.jdField_a_of_type_JavaUtilList);
      }
      sst.e(this.jdField_a_of_type_JavaUtilList);
      return true;
      agej.a("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
    }
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private byte[] a()
  {
    byte[] arrayOfByte2 = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    byte[] arrayOfByte1 = arrayOfByte2;
    try
    {
      Parcel localParcel = Parcel.obtain();
      arrayOfByte1 = arrayOfByte2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.writeToParcel(localParcel, 0);
      arrayOfByte1 = arrayOfByte2;
      localParcel.setDataPosition(0);
      arrayOfByte1 = arrayOfByte2;
      arrayOfByte2 = localParcel.marshall();
      arrayOfByte1 = arrayOfByte2;
      localParcel.recycle();
      return arrayOfByte2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("FastWebActivity", 2, "init color bytes error");
    }
    return arrayOfByte1;
  }
  
  private int b()
  {
    int i3;
    if (this.jdField_a_of_type_Spc == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      i3 = -1;
      return i3;
    }
    int i2 = 0;
    for (int i1 = 0;; i1 = i3)
    {
      i3 = i1;
      if (i2 >= this.jdField_a_of_type_JavaUtilList.size()) {
        break;
      }
      i3 = i1;
      if (srx.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Spc.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(Intent paramIntent)
  {
    Q();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramIntent.get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_m_of_type_Boolean = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    r();
  }
  
  private void b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (this.jdField_a_of_type_JavaUtilSet.contains(paramBaseData)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        if (paramBaseData.jdField_r_of_type_Int != 6) {
          break label214;
        }
        ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
        if ((paramBaseData instanceof ProteusRecommendItemData))
        {
          JSONObject localJSONObject = ((ProteusRecommendItemData)paramBaseData).c;
          if ((localJSONObject != null) && (localJSONObject.opt("id_recommend_category_txt") != null) && (localJSONObject.opt("kd_ug_download_url") != null))
          {
            String str = "";
            localObject = str;
            if (localJSONObject.opt("card_info") != null)
            {
              localJSONObject = localJSONObject.getJSONObject("card_info");
              localObject = str;
              if (localJSONObject.opt("rowKey") != null) {
                localObject = localJSONObject.getString("rowKey");
              }
            }
            if (bhny.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
              break label198;
            }
            ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
          }
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
        return;
      }
      catch (Exception paramBaseData)
      {
        QLog.d("FastWebActivity", 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      label198:
      ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
      continue;
      label214:
      if (paramBaseData.jdField_r_of_type_Int == 26)
      {
        localObject = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)localObject).jdField_v_of_type_Int == 2)
        {
          srt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          srt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          srt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          sry.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, ((ProteusItemData)localObject).a);
        }
      }
      else
      {
        ssy.a(paramBaseData);
        if (paramBaseData.b != null) {
          tpx.a("REPORT_LINK", "doExposure baseData=" + paramBaseData.b.mTitle);
        }
      }
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_k_of_type_Boolean);
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    int i2;
    if (this.jdField_a_of_type_Sol != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Sol.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Sol.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Sol.a().get(i1);
        if (((localBaseAdapter instanceof orv)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i2 += localBaseAdapter.getCount();
      i1 += 1;
    }
  }
  
  private int c()
  {
    if (this.jdField_b_of_type_Long == 0L) {
      return 2;
    }
    if (this.jdField_b_of_type_Long == 70L) {
      return 4;
    }
    return 8;
  }
  
  private void c(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.jdField_y_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.c();
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_x_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_x_of_type_Boolean = true;
      int i2 = this.jdField_a_of_type_Srl.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController ：finishOneByOne  size:" + i2);
      int i1 = 0;
      while (i1 < i2)
      {
        finish();
        i1 += 1;
      }
      finish();
    } while ((!this.jdField_y_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout == null) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.d();
  }
  
  private boolean c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return srx.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(8);
  }
  
  private void h()
  {
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void i()
  {
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.z);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.A);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new snl(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new snt(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131376733, 2131363640);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841688));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d("FastWebActivity", 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Aqre = new aqre(this, true, false, true, true, 0);
      this.jdField_a_of_type_Aqre.a(this);
      this.jdField_a_of_type_Aqre.a(new sob(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d("FastWebActivity", 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Aqre.a(new soe(this));
      this.jdField_a_of_type_Aqre.a(new sof(this));
      this.jdField_a_of_type_Aqre.a(new sog(this));
    } while (this.jdField_w_of_type_Boolean);
    this.jdField_a_of_type_Aqre.j();
  }
  
  private void k()
  {
    ozs.jdField_f_of_type_Boolean = false;
    uby.a(4);
  }
  
  private void l()
  {
    ozs.jdField_f_of_type_Boolean = false;
    ozs.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void m()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376841);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(ozs.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131376200)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369088));
      findViewById(2131369042).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363640));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131381551));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131167247));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131167247));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      n();
      o();
      this.jdField_a_of_type_Aoof = new aoof(this, (QQAppInterface)ozs.a());
      this.jdField_a_of_type_Aoof.a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379751));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131370641);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      p();
      q();
      findViewById(2131376667).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366582));
      this.jdField_a_of_type_Sok = new sok(this);
      z();
      r();
      T();
      W();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131377834));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void o()
  {
    this.jdField_a_of_type_Nzj = new nzj(this);
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376900));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371182));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371183));
    Drawable localDrawable = bhmq.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130841025), -16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      w();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    Object localObject2;
    Object localObject3;
    try
    {
      t();
      std.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_Ppq);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      bool = a();
      srw.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      sst.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_v_of_type_Int = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (BaseData)localIterator.next();
        if ((localObject2 != null) && ((localObject2 instanceof ProteusItemData)))
        {
          localObject3 = (ProteusItemData)localObject2;
          if ((((ProteusItemData)localObject3).jdField_v_of_type_Int == 1) && ((((ProteusItemData)localObject3).jdField_u_of_type_Int == 1) || (((ProteusItemData)localObject3).jdField_u_of_type_Int == 2)) && (((BaseData)localObject2).jdField_r_of_type_Int != 0))
          {
            this.jdField_v_of_type_Int += 1;
            continue;
            localHashMap.put("param_uin", ozs.a());
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("FastWebActivity", 1, "has parse error, use webview open url! e=" + localException);
      localHashMap.put("param_error", localException.toString());
      bool = false;
    }
    for (;;)
    {
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      bdmc.a(BaseApplication.getContext()).a(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      if (!bool)
      {
        d(false);
        x();
        oid.a().a(5555, this);
        oid.a().a(6666, this);
        d();
        new svc().a("native_article");
        V();
        QLog.d("FastWebActivity", 1, "initData,isParseSuccess=" + bool);
        return;
        std.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Sol = new sol();
        this.jdField_a_of_type_Spc = new spc(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Sol);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Spc);
        this.jdField_a_of_type_Sop = new sop(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Aoof);
        this.jdField_a_of_type_Sop.registerDataSetObserver(new soh(this));
        this.jdField_a_of_type_Sol.a(this.jdField_a_of_type_Sop);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
          v();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
        }
        s();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_Blrf);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Blih);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Sol);
        this.jdField_a_of_type_Sol.a(this.jdField_a_of_type_Son);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131377214);
        U();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = pfa.a().a();
        if (this.jdField_a_of_type_Srn != null)
        {
          localObject1 = this.jdField_a_of_type_Srn.jdField_a_of_type_AndroidOsParcelable;
          label771:
          if (localObject1 == null) {
            break label946;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          a(((AbsListView.SavedState)localObject1).jdField_b_of_type_Int);
          label796:
          if ((this.jdField_l_of_type_Int == 1001) || (this.jdField_a_of_type_Srn != null)) {
            break label1017;
          }
        }
      }
      for (;;)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (BaseData)((Iterator)localObject1).next();
          if ((localObject3 instanceof ProteusBannerVideoItemData)) {
            ((ProteusBannerVideoItemData)localObject3).jdField_f_of_type_Boolean = false;
          }
        }
        if (localObject2 != null) {
          ((ppe)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pph, true);
        }
        label946:
        label1017:
        do
        {
          if ((bool) || (localObject2 == null)) {
            break label1024;
          }
          ((ppe)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaUtilList);
          break label1024;
          if (localObject2 != null)
          {
            localObject1 = ((ppe)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
            break label771;
            a(0);
            break label796;
            d(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            pfd.a().a(this.jdField_b_of_type_Pfh);
            pfd.a().a(this.jdField_a_of_type_Pfh);
            if (!this.jdField_a_of_type_Boolean) {
              break;
            }
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
            this.jdField_a_of_type_Boolean = false;
            break;
          }
          localObject1 = null;
          break label771;
        } while (bool);
      }
      label1024:
      bool = true;
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader = new soi(this);
    VideoReport.markAsPageBodyView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader);
    VideoReport.setPageBodyContentRange(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private void t()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o).longValue();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.r != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.r;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long, this.jdField_a_of_type_Pql, true);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s;
      QLog.d("FastWebActivity", 1, "initArticleInfo, update url,url=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Sol == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_Sol.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  private void v()
  {
    String str = null;
    this.jdField_a_of_type_Orv = new orv(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Orv.a(new snd(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Orv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Orv.a(new snf(this));
      this.jdField_a_of_type_Sol.a(this.jdField_a_of_type_Orv);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new sng(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new snh(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131377214, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void w()
  {
    ppe localppe = pfa.a().a();
    if (localppe == null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        x();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localppe.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Ppi);
  }
  
  private void x()
  {
    QLog.d("FastWebActivity", 1, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_l_of_type_Boolean = true;
    pfd.a().a(this.jdField_b_of_type_Pfh);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new sni(this));
    ocd.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new snj(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void z()
  {
    View localView = findViewById(2131373721);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  public nzj a()
  {
    return this.jdField_a_of_type_Nzj;
  }
  
  public tkv a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      tkv localtkv = (tkv)localIterator.next();
      if ((localtkv != null) && (localtkv.a != null) && (localtkv.a.jdField_d_of_type_JavaLangString != null) && (localtkv.a.jdField_d_of_type_JavaLangString.equals(paramString))) {
        return localtkv;
      }
    }
    return null;
  }
  
  public void a()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("arg_article_info", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    localIntent.putExtra("readinjoy_open_comment_from_image", true);
    PublicFragmentActivity.a(this, localIntent, ReadInJoyCommentListFragment.class, 1001);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B257", oyq.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    u();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131370641).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772012);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramBoolean, true, false, 0L);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    ArticleInfo localArticleInfo = a();
    if (localArticleInfo == null)
    {
      QLog.d("FastWebActivity", 1, "generateBiuArticleInfo fail !");
      return;
    }
    Intent localIntent = new Intent(this, ReadInJoyDeliverBiuActivity.class);
    localIntent.putExtra("arg_article_info", localArticleInfo);
    localIntent.putExtra("biu_src", 4);
    localIntent.putExtra("arg_from_type", paramInt1);
    localIntent.putExtra("arg_biu_state", paramInt2);
    localIntent.putExtra("feedsType", 1);
    localIntent.putExtra("fast_biu_type", paramBoolean1);
    localIntent.putExtra("should_show_dialog", paramBoolean2);
    localIntent.putExtra("is_modified_biu", paramBoolean3);
    localIntent.putExtra("modified_feeds_id", paramLong);
    startActivityForResult(localIntent, 2002);
    overridePendingTransition(0, 0);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_r_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    if (this.jdField_a_of_type_Sop != null) {
      this.jdField_a_of_type_Sop.d();
    }
    this.jdField_r_of_type_Boolean = false;
    srn localsrn = new srn();
    localsrn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localsrn.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localsrn.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localsrn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localsrn.jdField_a_of_type_Boolean = this.jdField_m_of_type_Boolean;
    localsrn.jdField_a_of_type_Spb = this.jdField_a_of_type_Spb;
    this.jdField_a_of_type_Srl.a(localsrn);
    this.jdField_b_of_type_JavaLangString = (ozs.a() + System.currentTimeMillis());
    b(paramIntent);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_r_of_type_Boolean = false;
    ThreadManager.getUIHandler().post(new FastWebActivity.29(this));
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.31(this, paramBaseData));
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool;
    if (paramInt == 2)
    {
      bool = true;
      this.jdField_h_of_type_Boolean = bool;
      if (paramInt != 0) {
        break label32;
      }
      a(paramAbsListView, this.jdField_c_of_type_Int, true);
    }
    label32:
    while (this.jdField_h_of_type_Boolean)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_g_of_type_Boolean = false;
    paramAbsListView.setInterpolator(null);
  }
  
  public void a(BubblePopupWindow paramBubblePopupWindow)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = paramBubblePopupWindow;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean)
  {
    pag.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_p_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        ssy.a(localArticleInfo1, "0X800898C", ozs.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Uak == null) {
          this.jdField_a_of_type_Uak = new uak(this, this.app, new soj(this));
        }
        this.jdField_a_of_type_Uak.a().setActionSheetTitle("biu出去让更多好友看到");
        this.jdField_a_of_type_Uak.a().setOnDismissListener(new snk(this));
        this.jdField_a_of_type_Uak.a(a(), 1);
        return;
      }
    }
    this.jdField_p_of_type_Boolean = true;
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (String str = "2";; str = "1")
    {
      ssy.a(localArticleInfo1, "0X8008993", ozs.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772341, 2130772340);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Aqre != null)) {
        this.jdField_a_of_type_Aqre.j();
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, 1);
      if (!isFinishing())
      {
        paramString1 = getSupportFragmentManager().beginTransaction();
        paramString1.setCustomAnimations(paramInt1, paramInt2);
        paramString1.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
        paramString1.commitAllowingStateLoss();
      }
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      this.jdField_a_of_type_Pag.b();
      this.jdField_a_of_type_Int = 2;
      c(8);
      return;
    }
    if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Aqre != null)) {
      this.jdField_a_of_type_Aqre.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Pag.a();
    if (!isFinishing())
    {
      paramString1 = getSupportFragmentManager().beginTransaction();
      paramString1.setCustomAnimations(paramInt1, paramInt2);
      paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramString1.commitAllowingStateLoss();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    u();
    this.jdField_a_of_type_Int = 1;
    c(0);
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = blhn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    if (((Map)localObject).containsKey("_wv")) {}
    for (;;)
    {
      try
      {
        int i1 = Integer.valueOf((String)((Map)localObject).get("_wv")).intValue();
        if (!((Map)localObject).containsKey("_wwv")) {
          break label561;
        }
        ArrayList localArrayList;
        i1 = 0;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          i2 = Integer.valueOf((String)((Map)localObject).get("_wwv")).intValue();
          localObject = new ArrayList();
          ((List)localObject).add(Integer.valueOf(13));
          if ((i1 & 0x8) == 0L) {
            ((List)localObject).add(Integer.valueOf(2));
          }
          if ((i1 & 0x10) == 0L) {
            ((List)localObject).add(Integer.valueOf(3));
          }
          if ((i1 & 0x4000) == 0L) {
            ((List)localObject).add(Integer.valueOf(9));
          }
          if ((i1 & 0x8000) == 0L) {
            ((List)localObject).add(Integer.valueOf(10));
          }
          ((List)localObject).add(Integer.valueOf(12));
          ((List)localObject).add(Integer.valueOf(26));
          ((List)localObject).add(Integer.valueOf(5));
          if ((i1 & 0x100) == 0L) {
            ((List)localObject).add(Integer.valueOf(4));
          }
          localArrayList = new ArrayList();
          if ((!TextUtils.isEmpty(localAppRuntime.getAccount())) && ((i1 & 0x2000) == 0L)) {
            localArrayList.add(Integer.valueOf(6));
          }
          localArrayList.add(Integer.valueOf(21));
          localArrayList.add(Integer.valueOf(7));
          if ((i1 & 0x20) == 0L) {
            localArrayList.add(Integer.valueOf(1));
          }
          localArrayList.add(Integer.valueOf(11));
          Collections.sort(localArrayList);
          if (((i2 & 0x4000) == 0L) && (beaj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
          {
            i2 = localArrayList.indexOf(Integer.valueOf(6));
            i1 = i2;
            if (i2 < 0) {
              i1 = localArrayList.indexOf(Integer.valueOf(1));
            }
            if (i1 >= 0)
            {
              if (i1 >= localArrayList.size() - 1) {
                break label566;
              }
              localArrayList.add(i1 + 1, Integer.valueOf(68));
              beaj.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Aqre != null) && (this.jdField_a_of_type_Aqre.a()) && (this.jdField_w_of_type_Boolean))
          {
            if (!this.jdField_a_of_type_Aqre.c()) {
              break label582;
            }
            localArrayList.add(0, Integer.valueOf(82));
            QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet delete colorNote");
          }
          return new List[] { localObject, localArrayList };
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
        localNumberFormatException2 = localNumberFormatException2;
        localNumberFormatException2.printStackTrace();
      }
      continue;
      label561:
      int i2 = 0;
      continue;
      label566:
      localNumberFormatException2.add(Integer.valueOf(68));
      continue;
      label582:
      localNumberFormatException2.add(0, Integer.valueOf(70));
      QLog.d("FastWebActivity", 2, "mColorNoteController ： open sheet add colorNote");
    }
  }
  
  protected void b()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new qxa();
      localReportInfo.mUin = ozs.a();
      localReportInfo.mSource = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mSourceArticleId = ((ArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((ArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((ArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((ArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((ArticleInfo)localObject2).mServerContext;
      localReportInfo.mInnerId = ((ArticleInfo)localObject2).innerUniqueID;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((qxa)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qxt != null) {
          ((qxa)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qxt.jdField_a_of_type_Long;
        }
        ((qxa)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((qxa)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((qxa)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (qxt)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((qxa)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qxt)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((qxa)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    pfa.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      sst.b(this.jdField_a_of_type_JavaUtilList);
      u();
      return;
    }
    sst.c(this.jdField_a_of_type_JavaUtilList);
    u();
  }
  
  @TargetApi(23)
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  public void c()
  {
    Object localObject = new oss(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    if (this.jdField_s_of_type_Boolean)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      if (this.jdField_s_of_type_Int == 0)
      {
        ocd.a((QQAppInterface)getAppInterface(), osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_u_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_s_of_type_Int, this.jdField_t_of_type_Int);
      this.jdField_s_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      ((oss)localObject).d(1);
      this.jdField_a_of_type_Pag.a();
      localObject = ((oss)localObject).a();
      ocd.a((QQAppInterface)getAppInterface(), osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
    }
    for (;;)
    {
      QLog.d("FastWebActivity", 1, "scrollToLastReadPos | done");
      return;
      QLog.d("FastWebActivity", 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int);
      this.jdField_s_of_type_Boolean = true;
      ((oss)localObject).d(2);
      localObject = ((oss)localObject).a();
      ocd.a((QQAppInterface)getAppInterface(), osp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Pag.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Sop != null) {}
    for (int i1 = this.jdField_a_of_type_Sop.getCount();; i1 = 0)
    {
      this.jdField_s_of_type_Int = i1;
      this.jdField_t_of_type_Int = 0;
      QLog.d("FastWebActivity", 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      return;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Uak != null) && (this.jdField_a_of_type_Uak.a())) {}
    do
    {
      return;
      this.jdField_o_of_type_Boolean = true;
    } while (onBackEvent());
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoReport.addToDetectionWhitelist(this);
    PTSDeviceUtil.init(this);
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    Object localObject = getIntent().getExtras();
    if (localObject == null) {
      if (paramBundle != null)
      {
        localObject = paramBundle.getBundle("bundle_key_save_instancestate");
        if (localObject == null)
        {
          agej.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
          finish();
          return true;
        }
        bdmc.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
      this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("fast_web_from_channel_id");
      this.jdField_t_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
      QLog.d("FastWebActivity", 1, "is from colorNote : " + this.jdField_t_of_type_Boolean);
      this.jdField_w_of_type_Boolean = aqvh.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        localObject = ((Bundle)localObject).getBundle("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
          this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
          this.jdField_l_of_type_Int = 1001;
          this.jdField_m_of_type_Boolean = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
        }
      }
      else
      {
        this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
        this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        this.jdField_b_of_type_JavaLangString = (ozs.a() + System.currentTimeMillis());
        VideoReport.setPageId(this, "8001");
        VideoReport.setPageParams(this, new pda().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID).a());
        localObject = getSupportFragmentManager();
        if ((paramBundle == null) || (localObject == null)) {
          break label483;
        }
        paramBundle = ((FragmentManager)localObject).getFragments();
        if ((paramBundle == null) || (paramBundle.size() <= 0)) {
          break label483;
        }
        localObject = ((FragmentManager)localObject).beginTransaction();
        paramBundle = paramBundle.iterator();
      }
      while (paramBundle.hasNext())
      {
        ((FragmentTransaction)localObject).remove((Fragment)paramBundle.next());
        continue;
        setResult(-10069, getIntent());
        finish();
        return true;
      }
      ((FragmentTransaction)localObject).commit();
      label483:
      ocd.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
      try
      {
        setContentView(2131560170);
        m();
        if (this.jdField_a_of_type_Sop != null) {
          this.jdField_a_of_type_Sop.a();
        }
        i();
        j();
        this.jdField_a_of_type_AndroidUtilSparseArray = srw.a();
        return true;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          BaseApplicationImpl.sImageCache.evict(0);
          try
          {
            setContentView(2131560170);
            m();
          }
          catch (Throwable paramBundle)
          {
            finish();
          }
        }
      }
      break;
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      pag.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Orv != null) && (this.jdField_a_of_type_Orv.a() != null))
      {
        localObject = this.jdField_a_of_type_Orv.a();
        ((osm)localObject).a(this.jdField_a_of_type_Pag.b(), this.jdField_u_of_type_Int);
        ((osm)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Sop.getCount());
      }
    }
    pfd.a().b(this.jdField_b_of_type_Pfh);
    pfd.a().b(this.jdField_a_of_type_Pfh);
    if (this.jdField_a_of_type_Sop != null) {
      this.jdField_a_of_type_Sop.d();
    }
    if (this.jdField_a_of_type_Sol != null) {
      this.jdField_a_of_type_Sol.a();
    }
    if (this.jdField_a_of_type_Orv != null) {
      this.jdField_a_of_type_Orv.d();
    }
    J();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Abgu != null) {
      this.jdField_a_of_type_Abgu.c();
    }
    this.jdField_a_of_type_Abgu = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Stb != null) {
      this.jdField_a_of_type_Stb.a();
    }
    if (this.jdField_a_of_type_Uak != null) {
      this.jdField_a_of_type_Uak.b();
    }
    ssu.a();
    if (this.jdField_a_of_type_Aoof != null)
    {
      this.jdField_a_of_type_Aoof.a(null);
      this.jdField_a_of_type_Aoof = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    rmn.a().jdField_b_of_type_Boolean = false;
    Object localObject = pfa.a().a();
    if (localObject != null) {
      ((ppe)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_Nzj != null) {
      this.jdField_a_of_type_Nzj.a();
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((tkv)((Iterator)localObject).next()).i();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    B();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_c_of_type_Boolean) {
        aklh.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Ssi.a();
    this.jdField_a_of_type_Ssi = null;
    oid.a().b(5555, this);
    oid.a().b(6666, this);
    if (this.jdField_a_of_type_Aqre != null)
    {
      this.jdField_a_of_type_Aqre.c();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Ono != null) {
      this.jdField_a_of_type_Ono.a();
    }
    localObject = pfa.a().a();
    if (localObject != null) {
      ((ppo)localObject).b(this.jdField_a_of_type_Ppq);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    if (paramIntent != null) {}
    for (boolean bool = paramIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);; bool = false)
    {
      if ((paramIntent != null) && (!bool)) {
        a(paramIntent);
      }
      super.doOnNewIntent(paramIntent);
      if ((paramIntent != null) && (bool))
      {
        paramIntent.removeExtra("PhotoConst.SEND_FLAG");
        Object localObject = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((localObject != null) && (((ArrayList)localObject).size() > 0))
        {
          localObject = (String)((ArrayList)localObject).get(0);
          if (this.jdField_a_of_type_Stb == null) {
            this.jdField_a_of_type_Stb = new stb(this);
          }
          this.jdField_a_of_type_Stb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Stb.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    if (!this.jdField_r_of_type_Boolean) {
      super.doOnPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_l_of_type_Boolean)) {}
    for (;;)
    {
      return;
      AbstractGifImage.pauseAll();
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
      {
        localObject1 = "2";
        localObject1 = ozs.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + ssy.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_b_of_type_JavaLangString);
        ssy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_r_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", ozs.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.4.5".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!ubg.a(this.jdField_b_of_type_Long)) {
            break label663;
          }
          localObject1 = "0X8009359";
          ocd.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), (String)localObject2, false);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            int i1;
            QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
          }
        }
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ozs.a();
        ((ReportInfo)localObject2).mSource = 0;
        ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_Long;
        ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_b_of_type_Long);
        ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_f_of_type_Long);
        ((ReportInfo)localObject2).mStrategyId = this.jdField_k_of_type_Int;
        ((ReportInfo)localObject2).mOperation = 9;
        ((ReportInfo)localObject2).mOpSource = 12;
        ((ReportInfo)localObject2).mReadTimeLength = ((int)(l1 / 1000L));
        ((ReportInfo)localObject2).mInnerId = this.jdField_a_of_type_JavaLangString;
        i1 = b();
        ((ReportInfo)localObject2).mArticleLength = i1;
        ((ReportInfo)localObject2).mReadArticleLength = ((int)(i1 * a()));
        ((List)localObject1).add(localObject2);
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.19(this, (List)localObject1));
        if (this.jdField_a_of_type_Sop != null) {
          this.jdField_a_of_type_Sop.c();
        }
        if (ozs.jdField_g_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Aqre == null) {
          continue;
        }
        this.jdField_a_of_type_Aqre.b();
        QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
        return;
        localObject1 = "1";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label663:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    if (!this.jdField_r_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_r_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    std.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    u();
    if (this.jdField_a_of_type_Sop != null) {
      this.jdField_a_of_type_Sop.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pag.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pfa.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (ozs.jdField_g_of_type_Boolean)
    {
      if (ozs.jdField_f_of_type_Boolean) {
        ozs.a(4, this.jdField_c_of_type_Long);
      }
      l();
    }
    k();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_Aqre != null)
    {
      this.jdField_a_of_type_Aqre.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_Ppq);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null)
    {
      tln localtln = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      if (localtln != null) {
        localtln.e();
      }
    }
  }
  
  public void doOnStart()
  {
    if (!this.jdField_r_of_type_Boolean) {
      super.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    if (!this.jdField_r_of_type_Boolean) {
      super.doOnStop();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if ((!mAppForground) || (this.jdField_r_of_type_Boolean))
    {
      pag.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Pag.b();
    }
    if ((isFinishing()) || (this.jdField_r_of_type_Boolean))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  public void e()
  {
    sst.b(this.jdField_a_of_type_JavaUtilList);
    u();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.b();
  }
  
  public void f()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label115;
      }
      if ((!bhjr.b()) && (!bhjr.d())) {
        this.mSystemBarComp.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-7829368);
    this.mSystemBarComp.setStatusBarDarkMode(true);
    return;
    label115:
    if ((Build.VERSION.SDK_INT >= 23) && (!bhjr.b()) && (!bhjr.d()))
    {
      b(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!bhjr.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void finish()
  {
    QLog.d("FastWebActivity", 2, "mFloating ：finish");
    if ((this.jdField_u_of_type_Boolean) && (!this.jdField_v_of_type_Boolean))
    {
      D();
      return;
    }
    if (this.jdField_a_of_type_Srl.a())
    {
      if (this.jdField_a_of_type_Aqre == null) {
        d(this);
      }
      if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean) && (this.A) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_v_of_type_Boolean))
      {
        E();
        return;
      }
      if ((this.jdField_a_of_type_Aqre != null) && (!this.jdField_v_of_type_Boolean))
      {
        D();
        return;
      }
      if (this.jdField_l_of_type_Int == 1001)
      {
        if (this.jdField_e_of_type_Int != 70) {
          break label271;
        }
        KandianSubscribeManager.a(this, 2);
      }
      if (this.jdField_g_of_type_Long != 0L) {
        ssy.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_k_of_type_Boolean = true;
    I();
    K();
    F();
    pfd.a().b(this.jdField_b_of_type_Pfh);
    pfd.a().b(this.jdField_a_of_type_Pfh);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label222:
      if (!this.jdField_o_of_type_Boolean) {
        break label353;
      }
    }
    label271:
    label353:
    for (String str2 = "1";; str2 = "2")
    {
      ocd.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      P();
      QLog.d("FastWebActivity", 2, "mFloating ：finish over");
      return;
      if (this.jdField_e_of_type_Int == 0)
      {
        oix.a(this.app, this, 11, 0);
        break;
      }
      if (pbd.c(this.jdField_e_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bnrf.h()) {
        break;
      }
      oix.a(this, 11);
      break;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label222;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
    }
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 3;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.actionCallback = this;
    localMiniMsgUserParam.entryView = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371183));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i1 = 2;
    boolean bool = true;
    if (paramInt1 == 10922)
    {
      if ((paramInt2 == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        ozs.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
      }
      return;
      break label530;
    }
    label460:
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      while (paramInt1 == 10923) {
                        if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Srn == null))
                        {
                          finish();
                          return;
                        }
                      }
                      if ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != -1)) {
                        break;
                      }
                      localObject = paramIntent.getStringExtra("arg_result_json");
                      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
                      paramIntent = otv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.jdField_a_of_type_JavaUtilList != null) {}
                        for (;;)
                        {
                          agej.a("FastWebActivity", bool, new NullPointerException());
                          return;
                          bool = false;
                        }
                      }
                    } while (this.jdField_a_of_type_Orv == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.d((String)localObject, this.jdField_a_of_type_Orv.b());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.c((String)localObject, this.jdField_a_of_type_Orv.b());
                  return;
                  if ((paramInt1 != 1001) || (paramIntent == null)) {
                    break;
                  }
                  paramIntent = paramIntent.getSerializableExtra("backToImageData");
                } while (!(paramIntent instanceof List));
                paramIntent = (List)paramIntent;
              } while (paramIntent.isEmpty());
              ThreadManager.getUIHandler().post(new FastWebActivity.27(this, paramIntent));
              QLog.d("FastWebActivity", 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
              return;
              if (paramInt1 == 2002)
              {
                if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
                {
                  paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
                  paramIntent.jdField_c_of_type_Long += 1L;
                  ThreadManager.getUIHandler().post(new FastWebActivity.28(this));
                }
                paramIntent = getAppInterface();
                localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  ssy.a(this, paramIntent, (ArticleInfo)localObject, 0, -1, false, bool, false);
                  return;
                }
              }
              if (paramInt1 == 1)
              {
                if (this.jdField_f_of_type_Int == 72)
                {
                  paramInt1 = 13;
                  paramIntent = getAppInterface();
                  localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                  if (paramInt2 != -1) {
                    break label460;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ssy.a(this, paramIntent, (ArticleInfo)localObject, 1, paramInt1, false, bool, false);
                  return;
                  paramInt1 = -1;
                  break;
                }
              }
              if (paramInt1 != 9999) {
                break;
              }
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getParcelableExtra("key_ad_info");
          } while ((!(paramIntent instanceof AdData)) || (this.jdField_a_of_type_JavaUtilList == null));
          paramIntent = ((AdData)paramIntent).m;
        } while (TextUtils.isEmpty(paramIntent));
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject).hasNext());
      BaseData localBaseData = (BaseData)((Iterator)localObject).next();
      if ((!(localBaseData instanceof AdData)) || (!paramIntent.equals(((AdData)localBaseData).m))) {
        break;
      }
      a(localBaseData);
      QQToast.a(this, -1, getString(2131698588), 0).b(getTitleBarHeight());
      return;
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    label530:
    paramInt1 = i1;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Ono, 1, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Orv.b(), paramInt1);
    QLog.d("FastWebActivity", 1, "back from biuAndComment");
  }
  
  public boolean onBackEvent()
  {
    boolean bool = false;
    if (this.jdField_e_of_type_Boolean)
    {
      a(false, null, null);
      g();
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131369042) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131369042: 
        this.jdField_o_of_type_Boolean = true;
        finish();
        break;
      case 2131376667: 
        a(true);
        break;
      case 2131369088: 
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
        break;
      case 2131370641: 
        a(false, null, null);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount())
      {
        spi localspi = (spi)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localspi != null) {
          localspi.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onGoToConversation..");
    }
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.38(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FastWebActivity", 2, "onOpenMiniAIOCallback..");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null))
    {
      QLog.e("FastWebActivity", 2, "onOpenMiniAIOCallback mMiniMsgUser == null || mArticleInfo == null || mFastWebInfo == null");
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = ozs.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_d_of_type_Int, this.jdField_m_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          ssy.a(localArticleInfo1, "0X800A09C", ozs.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label227;
          }
          localObject = "2";
          ssy.a(localArticleInfo1, "0X800A09D", ozs.a(this, localArticleInfo2, i1, (String)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("FastWebActivity", 2, "onOpenMiniAIOCallback Exception = " + localException);
        return;
      }
      String str = "1";
      continue;
      label227:
      str = "1";
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    a(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    a(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */