package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import Override;
import aasr;
import akeu;
import android.annotation.TargetApi;
import android.content.ClipboardManager;
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
import androidx.annotation.VisibleForTesting;
import aqnr;
import aqru;
import beaz;
import bheg;
import bjxa;
import bkyp;
import blbm;
import bmhv;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
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
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAvatarView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
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
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.SavedState;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView.DrawFinishedListener;
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
import odz;
import oil;
import olh;
import oqt;
import org.json.JSONException;
import org.json.JSONObject;
import orn;
import orp;
import osg;
import owx;
import pau;
import pbn;
import pbp;
import pbq;
import pbt;
import pbu;
import pdv;
import pjc;
import pkh;
import pkn;
import plm;
import ppe;
import pqb;
import pqf;
import pqw;
import prm;
import prp;
import pti;
import pvj;
import pvm;
import pvp;
import pvq;
import qfg;
import qfk;
import qfq;
import qfs;
import qgo;
import qgq;
import qhl;
import rjv;
import rjy;
import rqf;
import rqw;
import rqy;
import rsh;
import rsj;
import sge;
import teo;
import tep;
import ter;
import tes;
import tet;
import teu;
import tev;
import tew;
import tex;
import tey;
import tez;
import tfa;
import tfb;
import tfc;
import tfd;
import tff;
import tfg;
import tfh;
import tfi;
import tfj;
import tfk;
import tfl;
import tfm;
import tfn;
import tfo;
import tfp;
import tfq;
import tfr;
import tfs;
import tft;
import tfu;
import tfv;
import tfw;
import tfx;
import tfz;
import tgb;
import tge;
import tgk;
import tgl;
import tgn;
import tgr;
import tiv;
import tix;
import tjc;
import tjf;
import tjg;
import tji;
import tjl;
import tjt;
import tjy;
import tke;
import tkf;
import tkj;
import tkm;
import tko;
import tmk;
import ued;
import ueh;
import uen;
import uer;
import uet;
import ukq;
import ulm;
import umi;
import uuw;
import uuz;
import uvs;
import uwl;
import znl;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, MiniMsgUser.IMiniMsgActionCallback, FaceDecoder.DecodeTaskCompletionListener, orp, pbp, pbt, umi, uuz
{
  public static boolean a;
  public static boolean b;
  private boolean A;
  private boolean B = true;
  private boolean C = true;
  private boolean D;
  private float jdField_a_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private aasr jdField_a_of_type_Aasr;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqnr jdField_a_of_type_Aqnr;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private NativeAvatarView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView;
  public ArticleInfo a;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  private AuthorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  private CommonAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar;
  public MiniMsgUser a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  public INetInfoHandler a;
  private IScrollReader jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader;
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new tfb(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new tfg(this);
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private owx jdField_a_of_type_Owx;
  private pau jdField_a_of_type_Pau;
  private pkn jdField_a_of_type_Pkn = new pkn();
  private pvq jdField_a_of_type_Pvq = new tfc(this);
  private qfk jdField_a_of_type_Qfk = new tfi(this);
  qfs jdField_a_of_type_Qfs = new tfo(this);
  private qgo jdField_a_of_type_Qgo;
  private qgq jdField_a_of_type_Qgq = new tft(this);
  private qhl jdField_a_of_type_Qhl = new teo(this);
  private rjv jdField_a_of_type_Rjv = new rjv();
  private tfu jdField_a_of_type_Tfu = new tfu(this, null);
  private tfw jdField_a_of_type_Tfw;
  private tfx jdField_a_of_type_Tfx;
  tfz jdField_a_of_type_Tfz = new tfl(this);
  private tgb jdField_a_of_type_Tgb;
  private tgk jdField_a_of_type_Tgk;
  private tgl jdField_a_of_type_Tgl;
  private tiv jdField_a_of_type_Tiv = new tiv(this);
  private tix jdField_a_of_type_Tix;
  private tjt jdField_a_of_type_Tjt = new tjt();
  private tkm jdField_a_of_type_Tkm;
  private uuw jdField_a_of_type_Uuw;
  private float jdField_b_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  public long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new tfk(this);
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = System.currentTimeMillis() + "";
  private pvq jdField_b_of_type_Pvq = new tfd(this);
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = "";
  boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  public boolean d;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  public boolean e;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
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
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int = 1;
  private boolean jdField_u_of_type_Boolean = true;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean;
  private int jdField_x_of_type_Int = -1;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean = true;
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean;
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new tfj(this);
  }
  
  private void A()
  {
    String str = null;
    this.jdField_a_of_type_Pau = new pau(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Pau.a(new tep(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Pau.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Pau.a(new ter(this));
      this.jdField_a_of_type_Tfx.a(this.jdField_a_of_type_Pau);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new tes(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new tet(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131377235, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void B()
  {
    qfg localqfg = pvj.a().a();
    if (localqfg == null)
    {
      if (!this.jdField_m_of_type_Boolean) {
        C();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localqfg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Qfk);
  }
  
  private void C()
  {
    QLog.d("FastWebActivity", 1, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_n_of_type_Boolean = true;
    pvm.a().a(this.jdField_b_of_type_Pvq);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new teu(this));
    olh.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new tev(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void E()
  {
    View localView = findViewById(2131373860);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void F()
  {
    ((ClipboardManager)getSystemService("clipboard")).setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    znl.a(2, 2131691266);
    if (this.jdField_r_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      tjt.a(this, str, 9, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 3, false);
      return;
    }
  }
  
  private void G()
  {
    this.jdField_a_of_type_Uuw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 6, -1, false);
  }
  
  private void H()
  {
    this.jdField_a_of_type_Uuw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 7, -1, false);
  }
  
  private void I()
  {
    a(17, -1, false);
    tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 0, -1, false);
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setFavoriteArticle(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
    }
    if (this.jdField_r_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      tjt.a(this, str, 8, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 4, false);
      return;
    }
  }
  
  private void K()
  {
    ThreadManager.executeOnSubThread(new FastWebActivity.19(this));
    if (this.jdField_r_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      tjt.a(this, str, 10, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 5, false);
      return;
    }
  }
  
  private void L()
  {
    this.jdField_a_of_type_Uuw.c();
    if (this.jdField_r_of_type_Boolean) {}
    for (String str = "0X8008994";; str = "0X800898D")
    {
      tjt.a(this, str, 7, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 0, false);
      return;
    }
  }
  
  private void M()
  {
    this.jdField_a_of_type_Uuw.a(this, true);
    tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 1, false, false, pjc.a(null, "function_type", Integer.valueOf(7)));
  }
  
  private void N()
  {
    this.jdField_a_of_type_Uuw.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    tkj.a(this, getAppInterface(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, -1, 2, false);
  }
  
  private void O()
  {
    beaz.a(1, 2);
    beaz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle);
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_Aqnr != null)
    {
      if (!this.jdField_a_of_type_Aqnr.b()) {
        break label71;
      }
      QLog.d("FastWebActivity", 2, "mColorNoteController ：add colorNote");
      this.jdField_a_of_type_Aqnr.e();
      if (!this.jdField_a_of_type_Tiv.a()) {
        QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690871), 5000).a();
      }
    }
    return;
    label71:
    this.jdField_a_of_type_Aqnr.i();
  }
  
  private void Q()
  {
    if ((this.jdField_a_of_type_Aqnr != null) && (this.jdField_a_of_type_Aqnr.c()))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2, BaseApplicationImpl.getContext().getResources().getString(2131690875), 5000).a();
      this.jdField_a_of_type_Aqnr.f();
      QLog.d("FastWebActivity", 2, "mColorNoteController ： delete colorNote");
    }
  }
  
  private void R()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView = ((NativeAvatarView)findViewById(2131363086));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363087));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367085));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
  }
  
  private void T()
  {
    U();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void U()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void V()
  {
    if (b()) {
      return;
    }
    int i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
    c(i3);
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    int i1 = 0;
    boolean bool = false;
    label34:
    if (i2 <= i3)
    {
      i1 = a(i2);
      if ((i2 >= this.jdField_a_of_type_JavaUtilList.size()) || (!((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2)).jdField_d_of_type_Boolean)) {
        break label211;
      }
      this.jdField_p_of_type_Boolean = true;
      if (this.jdField_b_of_type_Int == 0) {
        this.jdField_b_of_type_Int = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int);
      }
      bool = true;
    }
    label133:
    label162:
    label188:
    label193:
    label211:
    for (;;)
    {
      i2 += 1;
      break label34;
      f(bool);
      int[] arrayOfInt = tkj.jdField_a_of_type_ArrayOfInt;
      int i4 = arrayOfInt.length;
      i2 = 0;
      Integer localInteger;
      if (i2 < i4)
      {
        localInteger = Integer.valueOf(arrayOfInt[i2]);
        if ((1 << localInteger.intValue() & i1) == 0) {
          break label188;
        }
        i3 = 1;
        if (i3 == 0) {
          break label193;
        }
        pkn.b(tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
      }
      for (;;)
      {
        i2 += 1;
        break label133;
        break;
        i3 = 0;
        break label162;
        pkn.c(tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
      }
    }
  }
  
  private void W()
  {
    this.jdField_x_of_type_Boolean = true;
    this.jdField_a_of_type_Aqnr.d();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void X()
  {
    this.jdField_x_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void Y()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        qfg localqfg = ((pvp)this.app.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a().a();
        if (localqfg != null) {
          localqfg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void Z()
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
          localArrayList.add(new tgn(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new tey(this, i1, localBaseData));
        }
        else if (tkj.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new tez(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_Tgl == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_g_of_type_Int <= 0) {
      V();
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
  
  private int a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
    {
      float f1 = BaseData.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
      if (f1 <= tkj.jdField_a_of_type_ArrayOfFloat[0]) {
        return 1;
      }
      if (f1 <= tkj.jdField_a_of_type_ArrayOfFloat[1]) {
        return 2;
      }
      if (f1 <= tkj.jdField_a_of_type_ArrayOfFloat[2]) {
        return 4;
      }
    }
    else
    {
      return 8;
    }
    return 0;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Tgl == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Tgl.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Tgl.a(i1);
      i1 += 1;
    }
    return i2 - paramInt2;
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
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle1 = getIntent().getExtras();
    Bundle localBundle2 = localBundle1;
    if (localBundle1 == null) {
      if (paramBundle == null) {
        break label52;
      }
    }
    label52:
    for (paramBundle = paramBundle.getBundle("bundle_key_save_instancestate");; paramBundle = localBundle1)
    {
      if (paramBundle != null) {
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
      localBundle2 = paramBundle;
      return localBundle2;
    }
  }
  
  private ArticleInfo a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return null;
    }
    ArticleInfo localArticleInfo = new ArticleInfo();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.size() > 0)) {
      localArticleInfo.businessId = ((tge)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw = new rqw();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private void a(int paramInt)
  {
    pvj.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, paramInt, this.jdField_a_of_type_Tfu);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getParcelableExtra("key_ad_info");
      if (((paramIntent instanceof AdData)) && (this.jdField_a_of_type_JavaUtilList != null))
      {
        paramIntent = ((AdData)paramIntent).m;
        if (!TextUtils.isEmpty(paramIntent))
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
          while (localIterator.hasNext())
          {
            BaseData localBaseData = (BaseData)localIterator.next();
            if (((localBaseData instanceof AdData)) && (paramIntent.equals(((AdData)localBaseData).m)))
            {
              a(localBaseData);
              QQToast.a(this, -1, getString(2131699167), 0).b(getTitleBarHeight());
            }
          }
        }
      }
    }
  }
  
  private void a(int paramInt, AuthorData paramAuthorData)
  {
    boolean bool = tjg.a(paramInt, this.jdField_a_of_type_JavaUtilList);
    paramInt = 4;
    if (bool) {
      paramInt = 0;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setVisibility(paramInt);
    b(paramInt, paramAuthorData);
  }
  
  private void a(long paramLong)
  {
    try
    {
      QLog.d("FastWebActivity", 1, "start to fetch live status");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Long.valueOf(paramLong));
      if (this.jdField_a_of_type_Qgo == null) {
        x();
      }
      if (this.jdField_a_of_type_Qgo != null) {
        this.jdField_a_of_type_Qgo.a(localArrayList);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("FastWebActivity", 1, "fetchLiveStatus error:" + localException);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Object localObject = getSupportFragmentManager();
    if ((paramBundle != null) && (localObject != null))
    {
      paramBundle = ((FragmentManager)localObject).getFragments();
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        localObject = ((FragmentManager)localObject).beginTransaction();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext()) {
          ((FragmentTransaction)localObject).remove((Fragment)paramBundle.next());
        }
        ((FragmentTransaction)localObject).commit();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo)
  {
    QLog.d("FastWebActivity", 1, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.A)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (ppe.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!ppe.l(paramArticleInfo)) {
        localObject1 = ((rsj)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rsh.a.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      ai();
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
        if (NetworkUtil.isWifiConnected(null)) {
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
      localObject = pqf.a(this, paramArticleInfo, i1, (String)localObject);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        if (!this.jdField_v_of_type_Boolean) {
          continue;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.A) && (this.jdField_x_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_x_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      tkj.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      localObject = "1";
      break;
      i1 = 0;
    }
  }
  
  private void a(AuthorData paramAuthorData)
  {
    if (paramAuthorData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setUin(Long.parseLong(paramAuthorData.jdField_c_of_type_JavaLangString));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramAuthorData.jdField_b_of_type_JavaLangString);
    e(paramAuthorData.jdField_a_of_type_Boolean);
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
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    this.jdField_c_of_type_JavaLangString = paramActionSheetItem.uin;
    this.jdField_y_of_type_Int = paramActionSheetItem.uinType;
    this.jdField_d_of_type_JavaLangString = paramActionSheetItem.label;
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (((!this.jdField_j_of_type_Boolean) && (!paramBoolean)) || ((this.jdField_i_of_type_Boolean) && (!paramBoolean)) || (this.jdField_k_of_type_Boolean)) {}
    Object localObject2;
    int i1;
    label179:
    int i2;
    label320:
    label325:
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
      } while ((!(localObject2 instanceof ProteusBannerBigPicItemData)) && (!(localObject2 instanceof ProteusBannerVideoItemData)));
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
          break label320;
        }
      }
      for (paramInt = localLayoutParams.width;; paramInt = -1)
      {
        ((View)localObject1).measure(ViewGroup.getChildMeasureSpec(paramAbsListView.getMeasuredWidthAndState(), paramAbsListView.getPaddingLeft() + paramAbsListView.getPaddingRight(), paramInt), 0);
        paramInt = ((View)localObject1).getMeasuredHeight();
        if ((!paramBoolean) || (i2 >= paramInt / 2)) {
          break label325;
        }
        this.jdField_k_of_type_Boolean = true;
        return;
        paramInt += 1;
        break;
        localObject1 = ((ListAdapter)localObject1).getView(paramInt, (View)localObject2, paramAbsListView);
        break label179;
      }
    } while (((i1 <= i2) || (i1 >= paramInt / 2 + i2)) && ((!paramBoolean) || (i2 <= paramInt / 2)));
    this.jdField_i_of_type_Boolean = true;
    Object localObject1 = new FastWebActivity.SmoothScrollTask(this, (View)localObject2, paramAbsListView, i1, paramInt, paramBoolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramAbsListView.postOnAnimation((Runnable)localObject1);
      return;
    }
    paramAbsListView.post((Runnable)localObject1);
    return;
    this.jdField_k_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if (!(paramObject instanceof Boolean)) {}
    do
    {
      do
      {
        return;
      } while (((Boolean)paramObject).booleanValue());
      e(true);
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(true);
  }
  
  private void a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      BaseData localBaseData = (BaseData)paramList.next();
      if ((localBaseData instanceof ProteusBannerVideoItemData)) {
        ((ProteusBannerVideoItemData)localBaseData).jdField_f_of_type_Boolean = false;
      }
    }
  }
  
  private void a(tix paramtix)
  {
    ak();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramtix.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Tix = paramtix;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Tix.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_o_of_type_Boolean = paramtix.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Tgk = paramtix.jdField_a_of_type_Tgk;
    r();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    ukq.a("REPORT_LINK", "requestAdData onGetRecommendsResult");
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
      tke.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      tke.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = pvj.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      Z();
      tke.a(this.jdField_a_of_type_JavaUtilList);
      z();
      ueh.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramList2);
      QLog.d("FastWebActivity", 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = pvj.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      tko.a("HtmlChangeUtil.parse");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = tjf.a();
      }
      this.jdField_a_of_type_JavaUtilList = tjy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      ah();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        throw new RuntimeException("parse data is empty!");
      }
      this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      Object localObject = tjf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
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
      tko.a("HtmlChangeUtil.parse");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
    {
      this.jdField_a_of_type_JavaUtilList.set(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.set(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      if ((this.jdField_l_of_type_Int != 1001) && (this.jdField_a_of_type_Tix == null)) {
        tke.d(this.jdField_a_of_type_JavaUtilList);
      }
      tke.e(this.jdField_a_of_type_JavaUtilList);
      return true;
      AIOUtils.catchedExceptionInReleaseV2("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
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
  
  private void aa()
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new tfa(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void ab()
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
            tkj.a(this.app, (AdData)localBaseData);
            if (localBaseData.b == null) {
              break;
            }
            ukq.a("REPORT_LINK", "invalidADExposurePos report " + localBaseData.b.mTitle);
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
  
  private void ac()
  {
    int i1 = b();
    tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_o_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_x_of_type_Int);
    if (this.jdField_a_of_type_Tgb != null) {
      this.jdField_a_of_type_Tgb.e();
    }
  }
  
  private void ad()
  {
    long l1 = tko.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_m_of_type_Boolean) {
      bool = false;
    }
    long l2 = tko.c("fast_web_show_light_house_2");
    long l3 = tko.c("fast_web_show_light_house_3");
    long l4 = tko.c("fast_web_show_light_house_draw_finish");
    long l5 = tko.c("fast_web_show_light_house_step4_2");
    long l6 = tko.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", pkh.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void ae()
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
      this.jdField_u_of_type_Boolean = true;
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
        this.jdField_u_of_type_Boolean = false;
        this.jdField_h_of_type_Boolean = true;
        QLog.d("FastWebActivity", 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
        return;
      }
    } while ((bool1) || (!bool2));
    this.jdField_u_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_q_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
    QLog.d("FastWebActivity", 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
    d();
  }
  
  private void af()
  {
    try
    {
      tjf.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FastWebActivity", 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void ag()
  {
    if (!this.jdField_n_of_type_Boolean) {}
    while (this.jdField_a_of_type_Tix != null) {
      return;
    }
    finish();
  }
  
  private void ah()
  {
    tjg.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void ai()
  {
    Object localObject = findViewById(2131373860);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131376196);
    String str = getString(2131717816);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void aj()
  {
    if (this.jdField_a_of_type_Tiv.a()) {}
    tix localtix;
    do
    {
      return;
      this.jdField_t_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      ac();
      VideoReport.pageLogicDestroy(this);
      this.jdField_t_of_type_Boolean = false;
      localtix = this.jdField_a_of_type_Tiv.a();
    } while (localtix == null);
    a(localtix);
    this.jdField_t_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    h();
    this.jdField_t_of_type_Boolean = false;
  }
  
  private void ak()
  {
    this.jdField_a_of_type_Tix = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Tgl = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    qfg localqfg = pvj.a().a();
    if (localqfg != null)
    {
      localqfg.a(this.jdField_a_of_type_Tfu);
      localqfg.a(this.jdField_a_of_type_Qfk);
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void al()
  {
    pqw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Tiv.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("FastWebActivity", 2, bool);
      this.jdField_a_of_type_Tiv.a(new tfh(this));
      return;
    }
  }
  
  private void am()
  {
    z();
  }
  
  private void an()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    this.A = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.A)
    {
      this.B = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.C = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_x_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d("FastWebActivity", 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.A + "  isSuctionTop=" + this.B);
  }
  
  private void ao()
  {
    int i1 = (int)(pnk.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private void ap()
  {
    if (this.jdField_a_of_type_Owx != null) {
      this.jdField_a_of_type_Owx.a();
    }
    this.jdField_a_of_type_Owx = new owx();
    this.jdField_a_of_type_Owx.a(new tfm(this));
  }
  
  private void aq()
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
  
  private int b()
  {
    int i3;
    if (this.jdField_a_of_type_Tgl == null)
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
      if (tjg.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Tgl.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      pkh.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
    }
  }
  
  private void b(int paramInt, AuthorData paramAuthorData)
  {
    if (paramAuthorData != null) {
      e(paramAuthorData.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      int i1 = this.jdField_b_of_type_AndroidWidgetImageView.getVisibility();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
      if ((i1 != paramInt) && (paramInt == 0)) {
        uvs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, uvs.jdField_d_of_type_Int, true);
      }
      return;
      paramInt = 4;
    }
  }
  
  private void b(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.32(this), paramLong);
  }
  
  private void b(Intent paramIntent)
  {
    int i1 = 2;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i1 = 1;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Owx, 1, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pau.b(), i1);
    QLog.d("FastWebActivity", 1, "back from biuAndComment");
  }
  
  private void b(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d("FastWebActivity", 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
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
        if (paramBaseData.jdField_r_of_type_Int == 6)
        {
          tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
          if ((paramBaseData instanceof ProteusRecommendItemData))
          {
            JSONObject localJSONObject1 = ((ProteusRecommendItemData)paramBaseData).c;
            if ((localJSONObject1 != null) && (localJSONObject1.opt("id_recommend_category_txt") != null) && (localJSONObject1.opt("kd_ug_download_url") != null) && (localJSONObject1.optString("kd_ug_rsp_info") != null))
            {
              String str = "";
              localObject = str;
              if (localJSONObject1.opt("card_info") != null)
              {
                JSONObject localJSONObject2 = localJSONObject1.getJSONObject("card_info");
                localObject = str;
                if (localJSONObject2.opt("rowKey") != null) {
                  localObject = localJSONObject2.getString("rowKey");
                }
              }
              oqt.a(oqt.a(new tjl(localJSONObject1.optString("kd_ug_rsp_info")).jdField_a_of_type_JavaLangString, (String)localObject, "2"));
            }
          }
          this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
          return;
        }
      }
      catch (Exception paramBaseData)
      {
        QLog.d("FastWebActivity", 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      if (paramBaseData.jdField_r_of_type_Int == 26)
      {
        localObject = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)localObject).jdField_v_of_type_Int == 2)
        {
          tjc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          tjc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          tjc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          tji.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, ((ProteusItemData)localObject).a);
        }
      }
      else
      {
        tkj.a(paramBaseData);
        if (paramBaseData.b != null) {
          ukq.a("REPORT_LINK", "doExposure baseData=" + paramBaseData.b.mTitle);
        }
      }
    }
  }
  
  private void b(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      bjxa.a(this, 6, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSummary, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl, paramActionSheetItem.uin, paramActionSheetItem.uinType, false);
    }
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_Tgl == null) || ((this.jdField_a_of_type_Tgb != null) && (this.jdField_a_of_type_Tgb.getCount() != this.jdField_a_of_type_Tgl.a())))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
      return true;
    }
    return false;
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    int i2;
    if (this.jdField_a_of_type_Tfx != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Tfx.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Tfx.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Tfx.a().get(i1);
        if (((localBaseAdapter instanceof pau)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
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
    if (paramInt > this.jdField_g_of_type_Int) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (this.jdField_a_of_type_Tgl != null)
      {
        int i2 = paramInt;
        if (this.jdField_g_of_type_Int > paramInt) {
          i2 = this.jdField_g_of_type_Int;
        }
        this.jdField_g_of_type_Int = i2;
        paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        paramInt = this.jdField_g_of_type_Int - paramInt;
        if ((paramInt < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_g_of_type_Int < this.jdField_a_of_type_Tgl.a()))
        {
          View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt);
          paramInt = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i2 = localView.getTop();
          this.jdField_i_of_type_Int = (this.jdField_a_of_type_Tgl.a(this.jdField_g_of_type_Int) - (paramInt - i2));
          if (i1 == 0) {
            break;
          }
          this.jdField_h_of_type_Int = this.jdField_i_of_type_Int;
          if (this.jdField_h_of_type_Int < 0) {
            this.jdField_h_of_type_Int = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_g_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_h_of_type_Int);
        }
      }
      return;
    }
    if (this.jdField_i_of_type_Int < this.jdField_h_of_type_Int) {}
    for (paramInt = this.jdField_i_of_type_Int;; paramInt = this.jdField_h_of_type_Int)
    {
      this.jdField_h_of_type_Int = paramInt;
      break;
    }
  }
  
  private void c(Intent paramIntent)
  {
    paramIntent = paramIntent.getSerializableExtra("backToImageData");
    if ((paramIntent instanceof List))
    {
      paramIntent = (List)paramIntent;
      if (!paramIntent.isEmpty())
      {
        ThreadManager.getUIHandler().post(new FastWebActivity.28(this, paramIntent));
        QLog.d("FastWebActivity", 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_z_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_z_of_type_Boolean = true;
      int i2 = this.jdField_a_of_type_Tiv.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController ：finishOneByOne  size:" + i2);
      int i1 = 0;
      while (i1 < i2)
      {
        finish();
        i1 += 1;
      }
      finish();
    } while ((!this.A) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout == null) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.d();
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_m_of_type_Boolean);
  }
  
  private boolean c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return tjg.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    int i1;
    AppInterface localAppInterface;
    ArticleInfo localArticleInfo;
    if (this.jdField_f_of_type_Int == 72)
    {
      i1 = 13;
      localAppInterface = getAppInterface();
      localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      if (paramInt != -1) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      tkj.a(this, localAppInterface, localArticleInfo, 1, i1, false, bool, false);
      return;
      i1 = -1;
      break;
    }
  }
  
  private void d(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("arg_result_json");
    int i1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
    paramIntent = pdv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    boolean bool;
    if (paramIntent == null)
    {
      paramIntent = new StringBuilder().append("commentDataManage is null, src : ").append(i1).append(", hasInit : ");
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        bool = true;
        AIOUtils.catchedExceptionInReleaseV2("FastWebActivity", bool, new NullPointerException());
      }
    }
    do
    {
      do
      {
        return;
        bool = false;
        break;
      } while (this.jdField_a_of_type_Pau == null);
      if (i1 == 2)
      {
        paramIntent.d(str, this.jdField_a_of_type_Pau.b());
        return;
      }
    } while (i1 != 3);
    paramIntent.c(str, this.jdField_a_of_type_Pau.b());
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
  
  private boolean d()
  {
    return (this.jdField_l_of_type_Int == 1001) && (!plm.c(this.jdField_e_of_type_Int));
  }
  
  private void e(int paramInt)
  {
    if ((paramInt == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
    {
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
      ((FastWebArticleInfo)localObject).jdField_c_of_type_Long += 1L;
      ThreadManager.getUIHandler().post(new FastWebActivity.27(this));
    }
    Object localObject = getAppInterface();
    ArticleInfo localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      tkj.a(this, (AppInterface)localObject, localArticleInfo, 0, -1, false, bool, false);
      return;
    }
  }
  
  private void e(Intent paramIntent)
  {
    ak();
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null)
    {
      QLog.e("Q.readinjoy.fast_web", 1, " refrashFromIntent data == null ");
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)paramIntent.get("fast_web_article_info"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
    this.jdField_f_of_type_Boolean = true;
    this.jdField_o_of_type_Boolean = paramIntent.getBoolean("fast_web_from_article_recommend", false);
    r();
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 2130842940;
      ((ImageView)localObject).setImageResource(i1);
      this.jdField_b_of_type_AndroidWidgetImageView.setTag(Boolean.valueOf(paramBoolean));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        if (!paramBoolean) {
          break label62;
        }
      }
    }
    label62:
    for (int i1 = BaseArticleInfo.TYPE_FOLLOWED_BUTTON;; i1 = BaseArticleInfo.TYPE_UNFOLLOW_BUTTON)
    {
      ((ArticleInfo)localObject).showFollowButtonType = i1;
      return;
      i1 = 2130843100;
      break;
    }
  }
  
  private void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.A))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.c();
    }
  }
  
  private void f(boolean paramBoolean)
  {
    uer localuer;
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a() != null))
    {
      localuer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      bool2 = localuer.jdField_a_of_type_Boolean;
      if (ueh.a(localuer)) {
        if (!(localuer instanceof uen)) {
          break label177;
        }
      }
    }
    label177:
    for (boolean bool1 = ((uen)localuer).a();; bool1 = false)
    {
      if ((localuer.jdField_a_of_type_Int == 2) && (ueh.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight(), this.jdField_b_of_type_Int, bool1, paramBoolean, bool2)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
        localuer.d();
        return;
      }
      if ((localuer.jdField_a_of_type_Int == 1) && (ueh.a(paramBoolean, this.jdField_p_of_type_Boolean, bool2)) && (localuer.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (localuer.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_p_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
        localuer.d();
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    VideoReport.setPageId(this, "1");
    VideoReport.setPageParams(this, new pti().e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).a("ref_channel", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).b(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.dtReportContentType)).a());
  }
  
  private void i()
  {
    if ((this.A) && (this.jdField_y_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void j()
  {
    if ((this.A) && (this.jdField_y_of_type_Boolean))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.B);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.C);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new tex(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new tff(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131376762, 2131363741);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841738));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d("FastWebActivity", 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Aqnr = new aqnr(this, true, false, true, true, 0);
      this.jdField_a_of_type_Aqnr.a(this);
      this.jdField_a_of_type_Aqnr.a(new tfn(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d("FastWebActivity", 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Aqnr.a(new tfp(this));
      this.jdField_a_of_type_Aqnr.a(new tfq(this));
      this.jdField_a_of_type_Aqnr.a(new tfr(this));
    } while (this.jdField_y_of_type_Boolean);
    this.jdField_a_of_type_Aqnr.j();
  }
  
  private void l()
  {
    jdField_a_of_type_Boolean = false;
    uwl.a(4);
  }
  
  private void m()
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void n()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376866);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(pkh.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131376211)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369278));
      findViewById(2131369231).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363741));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131381631));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131167296));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131167296));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      o();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, (QQAppInterface)pkh.a());
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379845));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131370792);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      R();
      p();
      q();
      findViewById(2131376688).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366720));
      this.jdField_a_of_type_Tfw = new tfw(this);
      E();
      r();
      an();
      aq();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131377878));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376916));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371343));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371344));
    Drawable localDrawable = bheg.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130841073), -16777216);
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
      B();
      return;
    }
    localHashMap = new HashMap();
    try
    {
      y();
      tko.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_Qfs);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      bool = a();
      tjf.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      tke.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      u();
      tko.b("fast_web_show_light_house_step4_2");
      this.jdField_a_of_type_Tfx = new tfx();
      this.jdField_a_of_type_Tgl = new tgl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Tfx);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Tgl);
      this.jdField_a_of_type_Tgb = new tgb(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
      this.jdField_a_of_type_Tfx.a(this.jdField_a_of_type_Tgb);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b()) {
        A();
      }
      t();
      v();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Tfx);
      this.jdField_a_of_type_Tfx.a(this.jdField_a_of_type_Tfz);
      this.jdField_c_of_type_AndroidViewView = findViewById(2131377235);
      ao();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
      localqfg = pvj.a().a();
      if (this.jdField_a_of_type_Tix == null) {
        break label749;
      }
      localObject1 = this.jdField_a_of_type_Tix.jdField_a_of_type_AndroidOsParcelable;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        qfg localqfg;
        Object localObject1;
        label366:
        QLog.e("FastWebActivity", 1, "has parse error, use webview open url! e=" + localException);
        localHashMap.put("param_error", localException.toString());
        s();
        boolean bool = false;
        continue;
        d(true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
        pvm.a().a(this.jdField_b_of_type_Pvq);
        pvm.a().a(this.jdField_a_of_type_Pvq);
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_c_of_type_Boolean = false;
          continue;
          Object localObject2 = null;
          continue;
          if (bool) {}
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = (AbsListView.SavedState)localObject1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
      a(((AbsListView.SavedState)localObject1).position, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      if ((this.jdField_l_of_type_Int == 1001) || (this.jdField_a_of_type_Tix != null)) {
        break label912;
      }
      a(this.jdField_a_of_type_JavaUtilList);
      if (localqfg != null) {
        localqfg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Tfu, true);
      }
      if ((!bool) && (localqfg != null)) {
        localqfg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaUtilList);
      }
      bool = true;
      localHashMap.put("param_uin", pkh.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      if (bool) {
        break label849;
      }
      d(false);
      C();
      orn.a().a(5555, this);
      orn.a().a(6666, this);
      d();
      new tmk().a("native_article");
      ap();
      QLog.d("FastWebActivity", 1, "initData,isParseSuccess=" + bool);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long == 0L)) {
        break;
      }
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long, this.jdField_a_of_type_Qhl, true);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
      return;
      label749:
      if (localqfg == null) {
        break label907;
      }
      localObject1 = localqfg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      break label366;
      a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
  }
  
  private void s() {}
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
    }
  }
  
  private void u()
  {
    this.jdField_v_of_type_Int = 0;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData != null) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.jdField_v_of_type_Int == 1) && ((localProteusItemData.jdField_u_of_type_Int == 1) || (localProteusItemData.jdField_u_of_type_Int == 2)) && (localBaseData.jdField_r_of_type_Int != 0)) {
          this.jdField_v_of_type_Int += 1;
        }
      }
    }
  }
  
  private void v()
  {
    this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader = new tfs(this);
    VideoReport.markAsPageBodyView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader);
    VideoReport.setPageBodyContentRange(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private void w()
  {
    ArticleInfo localArticleInfo;
    int i1;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a("https://pub.idqqimg.com/pc/misc/files/20200611/2a67e74aa4ed4a71a8e877deac8e41cf.png");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b("https://pub.idqqimg.com/pc/misc/files/20200611/558a344321d34d25b847cf32ff9403f8.png");
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        localArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())) {
          break label105;
        }
        localObject = "2";
      }
    }
    for (;;)
    {
      localObject = pqf.a(this, localArticleInfo, i1, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("live_circle_from_page", 1);
        tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B17D", ((JSONObject)localObject).toString());
        z();
        return;
        label105:
        localObject = "1";
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("FastWebActivity", 2, "live status error:" + localJSONException.getMessage());
        }
      }
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Qgo == null)
    {
      this.jdField_a_of_type_Qgo = pvj.a().a();
      if (this.jdField_a_of_type_Qgo != null) {
        this.jdField_a_of_type_Qgo.a(this.jdField_a_of_type_Qgq);
      }
    }
  }
  
  private void y()
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
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s;
      QLog.d("FastWebActivity", 1, "initArticleInfo, update url,url=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Tfx == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_Tfx.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  public oil a()
  {
    return null;
  }
  
  public ued a(String paramString)
  {
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
    float f1 = paramFloat;
    if (paramFloat > 5.0F) {
      f1 = 1.0F;
    }
    bmhv.a("readinjoy_font_size_ratio_sp", Float.valueOf(f1));
    TKDCommentDispatcher.INSTANCE.getEvent().onFontScaleChange(f1);
    tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B257", pjc.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    z();
    QLog.d("FastWebActivity", 1, "onFontSizeChange,index=" + paramInt + " ,textSizeRatio=" + f1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131370792).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772012);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_g_of_type_Boolean = false;
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
  
  @VisibleForTesting
  public void a(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramInt == 72) {
      a(paramActionSheetItem);
    }
    if (paramInt == 1)
    {
      F();
      return;
    }
    if (paramInt == 5)
    {
      G();
      return;
    }
    if (paramInt == 4)
    {
      H();
      return;
    }
    if (paramInt == 13)
    {
      I();
      return;
    }
    if (paramInt == 6)
    {
      J();
      return;
    }
    if (paramInt == 11)
    {
      K();
      return;
    }
    if (paramInt == 21)
    {
      L();
      return;
    }
    if (paramInt == 7)
    {
      M();
      return;
    }
    if (paramInt == 26)
    {
      N();
      return;
    }
    if (paramInt == 68)
    {
      O();
      return;
    }
    if (paramInt == 70)
    {
      P();
      return;
    }
    if (paramInt == 82)
    {
      Q();
      return;
    }
    if (paramInt == 19)
    {
      b(paramActionSheetItem);
      return;
    }
    a(paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_t_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    VideoReport.pageLogicDestroy(this);
    if (this.jdField_a_of_type_Tgb != null) {
      this.jdField_a_of_type_Tgb.d();
    }
    this.jdField_t_of_type_Boolean = false;
    tix localtix = new tix();
    localtix.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localtix.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localtix.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localtix.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localtix.jdField_a_of_type_Boolean = this.jdField_o_of_type_Boolean;
    localtix.jdField_a_of_type_Tgk = this.jdField_a_of_type_Tgk;
    this.jdField_a_of_type_Tiv.a(localtix);
    this.jdField_b_of_type_JavaLangString = (pkh.a() + System.currentTimeMillis());
    e(paramIntent);
    this.jdField_t_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_t_of_type_Boolean = false;
    h();
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
      this.jdField_j_of_type_Boolean = bool;
      if (paramInt != 0) {
        break label32;
      }
      a(paramAbsListView, this.jdField_c_of_type_Int, true);
    }
    label32:
    while (this.jdField_j_of_type_Boolean)
    {
      return;
      bool = false;
      break;
    }
    this.jdField_i_of_type_Boolean = false;
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
    pkn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_r_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        tkj.a(localArticleInfo1, "0X800898C", pqf.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Uuw == null) {
          this.jdField_a_of_type_Uuw = new uuw(this, this.app, new tfv(this));
        }
        this.jdField_a_of_type_Uuw.a().setActionSheetTitle("biu出去让更多好友看到");
        this.jdField_a_of_type_Uuw.a().setOnDismissListener(new tew(this));
        this.jdField_a_of_type_Uuw.a(a(), 1);
        return;
      }
    }
    this.jdField_r_of_type_Boolean = true;
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (String str = "2";; str = "1")
    {
      tkj.a(localArticleInfo1, "0X8008993", pqf.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772338, 2130772337);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.jdField_y_of_type_Boolean) && (this.jdField_a_of_type_Aqnr != null)) {
        this.jdField_a_of_type_Aqnr.j();
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
      this.jdField_g_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      this.jdField_a_of_type_Pkn.b();
      this.jdField_a_of_type_Int = 2;
      f(8);
      return;
    }
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_a_of_type_Aqnr != null)) {
      this.jdField_a_of_type_Aqnr.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Pkn.a();
    if (!isFinishing())
    {
      paramString1 = getSupportFragmentManager().beginTransaction();
      paramString1.setCustomAnimations(paramInt1, paramInt2);
      paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      paramString1.commitAllowingStateLoss();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    z();
    this.jdField_a_of_type_Int = 1;
    f(0);
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = bkyp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    if (((Map)localObject).containsKey("_wv")) {}
    for (;;)
    {
      try
      {
        int i1 = Integer.valueOf((String)((Map)localObject).get("_wv")).intValue();
        if (!((Map)localObject).containsKey("_wwv")) {
          break label585;
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
          if ((i1 & 0x10) == 0L) {
            ((List)localObject).add(Integer.valueOf(19));
          }
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
          if (((i2 & 0x4000) == 0L) && (beaz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
          {
            i2 = localArrayList.indexOf(Integer.valueOf(6));
            i1 = i2;
            if (i2 < 0) {
              i1 = localArrayList.indexOf(Integer.valueOf(1));
            }
            if (i1 >= 0)
            {
              if (i1 >= localArrayList.size() - 1) {
                break label590;
              }
              localArrayList.add(i1 + 1, Integer.valueOf(68));
              beaz.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Aqnr != null) && (this.jdField_a_of_type_Aqnr.a()) && (this.jdField_y_of_type_Boolean))
          {
            if (!this.jdField_a_of_type_Aqnr.c()) {
              break label606;
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
      label585:
      int i2 = 0;
      continue;
      label590:
      localNumberFormatException2.add(Integer.valueOf(68));
      continue;
      label606:
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
      localObject1 = new rqf();
      localReportInfo.mUin = pkh.a();
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
        ((rqf)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Rqy != null) {
          ((rqf)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Rqy.jdField_a_of_type_Long;
        }
        ((rqf)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((rqf)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((rqf)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (rqy)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((rqf)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((rqy)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((rqf)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    pvj.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      tke.b(this.jdField_a_of_type_JavaUtilList);
      z();
      return;
    }
    tke.c(this.jdField_a_of_type_JavaUtilList);
    z();
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
    Object localObject = new pbu(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    int i1;
    if (this.jdField_u_of_type_Boolean)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      if (this.jdField_s_of_type_Int == 0)
      {
        olh.a((QQAppInterface)getAppInterface(), pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_u_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_s_of_type_Int, this.jdField_t_of_type_Int);
      this.jdField_u_of_type_Boolean = false;
      this.jdField_h_of_type_Boolean = true;
      ((pbu)localObject).d(1);
      this.jdField_a_of_type_Pkn.a();
      localObject = ((pbu)localObject).a();
      olh.a((QQAppInterface)getAppInterface(), pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      i1 = this.jdField_s_of_type_Int;
    }
    for (;;)
    {
      QLog.d("FastWebActivity", 1, "scrollToLastReadPos | done");
      a(i1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      return;
      QLog.d("FastWebActivity", 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int);
      i1 = this.jdField_q_of_type_Int;
      this.jdField_u_of_type_Boolean = true;
      ((pbu)localObject).d(2);
      localObject = ((pbu)localObject).a();
      olh.a((QQAppInterface)getAppInterface(), pbq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Pkn.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Tgb != null) {}
    for (int i1 = this.jdField_a_of_type_Tgb.getCount();; i1 = 0)
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    ulm.a.a(ReportConstants.VideoEndType.EXIT_SCENE);
    if ((this.jdField_a_of_type_Uuw != null) && (this.jdField_a_of_type_Uuw.a())) {}
    do
    {
      return;
      this.jdField_q_of_type_Boolean = true;
    } while (onBackEvent());
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VideoReport.addToDetectionWhitelist(this);
    PTSDeviceUtil.init(this);
    getWindow().setFlags(16777216, 16777216);
    Bundle localBundle = a(paramBundle);
    if (localBundle == null)
    {
      AIOUtils.catchedExceptionInReleaseV2("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
      finish();
      return true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
    this.jdField_d_of_type_Int = localBundle.getInt("fast_web_from_channel_id");
    this.jdField_v_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
    QLog.d("FastWebActivity", 1, "is from colorNote : " + this.jdField_v_of_type_Boolean);
    this.jdField_y_of_type_Boolean = aqru.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      localBundle = localBundle.getBundle("banner_webview_extra");
      if ((localBundle != null) && (localBundle.get("fast_web_article_info") != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
        this.jdField_e_of_type_Int = localBundle.getInt("fast_web_banner_from_channel_id");
        this.jdField_l_of_type_Int = 1001;
        this.jdField_o_of_type_Boolean = localBundle.getBoolean("fast_web_from_article_recommend", false);
      }
    }
    else
    {
      this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      this.jdField_b_of_type_JavaLangString = (pkh.a() + System.currentTimeMillis());
      h();
      a(paramBundle);
      olh.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
    }
    try
    {
      setContentView(2131560223);
      n();
      if (this.jdField_a_of_type_Tgb != null) {
        this.jdField_a_of_type_Tgb.a();
      }
      j();
      k();
      ulm.a.a();
      this.jdField_a_of_type_AndroidUtilSparseArray = tjf.a();
      x();
      return true;
      setResult(-10069, getIntent());
      finish();
      return true;
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        BaseApplicationImpl.sImageCache.evict(0);
        try
        {
          setContentView(2131560223);
          n();
        }
        catch (Throwable paramBundle)
        {
          finish();
        }
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
    {
      pkn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Pau != null) && (this.jdField_a_of_type_Pau.a() != null))
      {
        localObject = this.jdField_a_of_type_Pau.a();
        ((pbn)localObject).a(this.jdField_a_of_type_Pkn.b(), this.jdField_u_of_type_Int);
        ((pbn)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Tgb.getCount());
      }
    }
    pvm.a().b(this.jdField_b_of_type_Pvq);
    pvm.a().b(this.jdField_a_of_type_Pvq);
    if (this.jdField_a_of_type_Tgb != null) {
      this.jdField_a_of_type_Tgb.d();
    }
    if (this.jdField_a_of_type_Tfx != null) {
      this.jdField_a_of_type_Tfx.a();
    }
    if (this.jdField_a_of_type_Pau != null) {
      this.jdField_a_of_type_Pau.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
    }
    ac();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aasr != null) {
      this.jdField_a_of_type_Aasr.c();
    }
    this.jdField_a_of_type_Aasr = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Tkm != null) {
      this.jdField_a_of_type_Tkm.a();
    }
    if (this.jdField_a_of_type_Uuw != null) {
      this.jdField_a_of_type_Uuw.b();
    }
    tkf.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    sge.a().jdField_b_of_type_Boolean = false;
    Object localObject = pvj.a().a();
    if (localObject != null) {
      ((qfg)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    U();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_e_of_type_Boolean) {
        akeu.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Tjt.a();
    this.jdField_a_of_type_Tjt = null;
    orn.a().b(5555, this);
    orn.a().b(6666, this);
    if (this.jdField_a_of_type_Aqnr != null)
    {
      this.jdField_a_of_type_Aqnr.c();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Owx != null) {
      this.jdField_a_of_type_Owx.a();
    }
    localObject = pvj.a().a();
    if (localObject != null) {
      ((qfq)localObject).b(this.jdField_a_of_type_Qfs);
    }
    odz.a().a("RIJAdRefreshSceneNativeArticle");
    ulm.a.d();
    uet.a.a();
    if (this.jdField_a_of_type_Qgo != null) {
      this.jdField_a_of_type_Qgo.b(this.jdField_a_of_type_Qgq);
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
          if (this.jdField_a_of_type_Tkm == null) {
            this.jdField_a_of_type_Tkm = new tkm(this);
          }
          this.jdField_a_of_type_Tkm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Tkm.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    if (!this.jdField_t_of_type_Boolean) {
      super.doOnPause();
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_n_of_type_Boolean)) {}
    for (;;)
    {
      return;
      AbstractGifImage.pauseAll();
      Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      Object localObject1;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
      {
        localObject1 = "2";
        localObject1 = pqf.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + tkj.a(this.jdField_o_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_b_of_type_JavaLangString);
        tkj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_t_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", prp.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.4.10".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!uvs.a(this.jdField_b_of_type_Long)) {
            break label722;
          }
          localObject1 = "0X8009359";
          olh.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), (String)localObject2, false);
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
        ((ReportInfo)localObject2).mUin = pkh.a();
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
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.20(this, (List)localObject1));
        if (this.jdField_a_of_type_Tgb != null) {
          this.jdField_a_of_type_Tgb.c();
        }
        if (jdField_b_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_d_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Aqnr != null)
        {
          this.jdField_a_of_type_Aqnr.b();
          QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
        }
        ulm.a.c();
        if ((d()) || (ReadinjoyTabFrame.d_()))
        {
          this.jdField_a_of_type_Rjv.b();
          this.jdField_a_of_type_Rjv.a();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar == null) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
        if (localObject1 == null) {
          continue;
        }
        ((uer)localObject1).f();
        return;
        localObject1 = "1";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label722:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    if (!this.jdField_t_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_t_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    tko.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    z();
    if (this.jdField_a_of_type_Tgb != null) {
      this.jdField_a_of_type_Tgb.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pkn.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pvj.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (jdField_b_of_type_Boolean)
    {
      if (jdField_a_of_type_Boolean) {
        pqb.a(4, this.jdField_c_of_type_Long);
      }
      m();
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_d_of_type_Boolean = false;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_Aqnr != null)
    {
      this.jdField_a_of_type_Aqnr.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_Qfs);
    }
    this.jdField_z_of_type_Int = 0;
    if (((d()) || (rjv.b())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      this.jdField_a_of_type_Rjv.a(this);
      this.jdField_a_of_type_Rjv.b();
      this.jdField_a_of_type_Rjv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, rjy.c());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null)
    {
      uer localuer = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      if (localuer != null) {
        localuer.e();
      }
    }
    ulm.a.b();
  }
  
  public void doOnStart()
  {
    if (!this.jdField_t_of_type_Boolean) {
      super.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    if (!this.jdField_t_of_type_Boolean) {
      super.doOnStop();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if ((!mAppForground) || (this.jdField_t_of_type_Boolean))
    {
      pkn.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Pkn.b();
    }
    if ((isFinishing()) || (this.jdField_t_of_type_Boolean))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      pdv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      i();
    }
  }
  
  public void e()
  {
    tke.b(this.jdField_a_of_type_JavaUtilList);
    z();
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
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      b(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
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
    if ((this.jdField_w_of_type_Boolean) && (!this.jdField_x_of_type_Boolean))
    {
      W();
      return;
    }
    if (this.jdField_a_of_type_Tiv.a())
    {
      if (this.jdField_a_of_type_Aqnr == null) {
        e(this);
      }
      if ((this.A) && (this.jdField_y_of_type_Boolean) && (this.C) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_x_of_type_Boolean))
      {
        X();
        return;
      }
      if ((this.jdField_a_of_type_Aqnr != null) && (!this.jdField_x_of_type_Boolean))
      {
        W();
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
        tkj.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_m_of_type_Boolean = true;
    ab();
    ad();
    Y();
    pvm.a().b(this.jdField_b_of_type_Pvq);
    pvm.a().b(this.jdField_a_of_type_Pvq);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label222:
      if (!this.jdField_q_of_type_Boolean) {
        break label353;
      }
    }
    label271:
    label353:
    for (String str2 = "1";; str2 = "2")
    {
      olh.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      aj();
      QLog.d("FastWebActivity", 2, "mFloating ：finish over");
      return;
      if (this.jdField_e_of_type_Int == 0)
      {
        osg.a(this.app, this, 11, 0);
        break;
      }
      if (plm.c(this.jdField_e_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bmhv.l()) {
        break;
      }
      osg.a(this, 11);
      break;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label222;
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a();
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
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371344));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10922) {
      b(paramInt2, paramIntent);
    }
    do
    {
      return;
      if (paramInt1 == 10923)
      {
        ag();
        return;
      }
      if ((paramInt1 == 117) && (paramIntent != null) && (paramInt2 == -1))
      {
        d(paramIntent);
        return;
      }
      if ((paramInt1 == 1001) && (paramIntent != null))
      {
        c(paramIntent);
        return;
      }
      if (paramInt1 == 2002)
      {
        e(paramInt2);
        return;
      }
      if (paramInt1 == 1)
      {
        d(paramInt2);
        return;
      }
      if (paramInt1 == 9999)
      {
        a(paramInt2, paramIntent);
        return;
      }
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    b(paramIntent);
  }
  
  public boolean onBackEvent()
  {
    boolean bool = false;
    if (this.jdField_g_of_type_Boolean)
    {
      a(false, null, null);
      g();
      bool = true;
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131369231) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363086: 
      case 2131363087: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          tjg.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true);
        }
        break;
      case 2131369231: 
        this.jdField_q_of_type_Boolean = true;
        ulm.a.a(ReportConstants.VideoEndType.EXIT_SCENE);
        finish();
        break;
      case 2131367085: 
        a(paramView.getTag());
        break;
      case 2131376688: 
        a(true);
        break;
      case 2131369278: 
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
        break;
      case 2131370792: 
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
        tgr localtgr = (tgr)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localtgr != null) {
          localtgr.a(paramString, paramBitmap);
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
    this.jdField_e_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.37(this));
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
        this.jdField_d_of_type_Boolean = true;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = prm.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_d_of_type_Int, this.jdField_o_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          tkj.a(localArticleInfo1, "0X800A09C", pqf.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label227;
          }
          localObject = "2";
          tkj.a(localArticleInfo1, "0X800A09D", pqf.a(this, localArticleInfo2, i1, (String)localObject).toString());
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
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    b(paramBundle);
    QLog.e("FastWebActivity", 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */