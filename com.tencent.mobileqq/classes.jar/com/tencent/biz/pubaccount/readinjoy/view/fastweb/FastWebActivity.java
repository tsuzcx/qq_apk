package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import Override;
import aadf;
import ajjg;
import android.annotation.TargetApi;
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
import apkn;
import apoq;
import bcua;
import bfvo;
import bjnd;
import bjqa;
import bkwm;
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
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.app.QQAppInterface;
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
import nwz;
import oau;
import odq;
import oix;
import ojq;
import ojs;
import okj;
import ooz;
import org.json.JSONException;
import org.json.JSONObject;
import osu;
import otl;
import otn;
import oto;
import otq;
import otr;
import ouu;
import ozw;
import pay;
import pbm;
import pcl;
import pgb;
import pil;
import pkm;
import pkp;
import pks;
import pkt;
import pum;
import puq;
import puw;
import puy;
import pwf;
import qxp;
import qxs;
import rdy;
import rep;
import rer;
import rga;
import rgc;
import rtp;
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
import sru;
import srv;
import srw;
import srx;
import sry;
import srz;
import ssa;
import ssb;
import ssc;
import ssd;
import sse;
import ssf;
import ssg;
import ssh;
import ssi;
import ssj;
import ssk;
import ssl;
import ssm;
import sso;
import ssq;
import sst;
import ssz;
import sta;
import stc;
import stg;
import svj;
import svl;
import svr;
import svu;
import svv;
import svx;
import swa;
import swi;
import swn;
import swt;
import swu;
import swy;
import sxb;
import sxd;
import szc;
import tql;
import tqp;
import tqv;
import trd;
import twp;
import txh;
import txq;
import tyk;
import ugz;
import uhc;
import uhv;
import uio;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, MiniMsgUser.IMiniMsgActionCallback, FaceDecoder.DecodeTaskCompletionListener, ojs, otn, otq, tyk, uhc
{
  private boolean A = true;
  private boolean B;
  private float jdField_a_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private aadf jdField_a_of_type_Aadf;
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private apkn jdField_a_of_type_Apkn;
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
  AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new srq(this);
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new srv(this);
  protected String a;
  private ArrayList<tql> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private oau jdField_a_of_type_Oau;
  private ooz jdField_a_of_type_Ooz;
  private osu jdField_a_of_type_Osu;
  private pbm jdField_a_of_type_Pbm = new pbm();
  private pkt jdField_a_of_type_Pkt = new srr(this);
  private puq jdField_a_of_type_Puq = new srx(this);
  puy jdField_a_of_type_Puy = new ssd(this);
  private pwf jdField_a_of_type_Pwf = new srd(this);
  private qxp jdField_a_of_type_Qxp = new qxp();
  private ssj jdField_a_of_type_Ssj = new ssj(this, null);
  private ssl jdField_a_of_type_Ssl;
  private ssm jdField_a_of_type_Ssm;
  sso jdField_a_of_type_Sso = new ssa(this);
  private ssq jdField_a_of_type_Ssq;
  private ssz jdField_a_of_type_Ssz;
  private sta jdField_a_of_type_Sta;
  private svj jdField_a_of_type_Svj = new svj(this);
  private svl jdField_a_of_type_Svl;
  private swi jdField_a_of_type_Swi = new swi();
  private sxb jdField_a_of_type_Sxb;
  private ugz jdField_a_of_type_Ugz;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = DeviceInfoUtil.getDispalyDpi() * 1000 / 160.0F;
  private int jdField_b_of_type_Int;
  public long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new srz(this);
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = System.currentTimeMillis() + "";
  private pkt jdField_b_of_type_Pkt = new srs(this);
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
  private TextView jdField_e_of_type_AndroidWidgetTextView;
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
  private int jdField_z_of_type_Int;
  private boolean jdField_z_of_type_Boolean = true;
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new sry(this);
  }
  
  private void A()
  {
    View localView = findViewById(2131373643);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void B()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView = ((NativeAvatarView)findViewById(2131363069));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363070));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366967));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAvatarView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
  }
  
  private void D()
  {
    E();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void E()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void F()
  {
    if ((this.jdField_a_of_type_Sta == null) || ((this.jdField_a_of_type_Ssq != null) && (this.jdField_a_of_type_Ssq.getCount() != this.jdField_a_of_type_Sta.a())))
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
      if (this.jdField_a_of_type_Sta != null)
      {
        if (this.jdField_g_of_type_Int <= i3) {
          break label394;
        }
        i2 = this.jdField_g_of_type_Int;
        this.jdField_g_of_type_Int = i2;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        i2 = this.jdField_g_of_type_Int - i2;
        if ((i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_g_of_type_Int < this.jdField_a_of_type_Sta.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(i2);
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i4 = ((View)localObject).getTop();
          this.jdField_i_of_type_Int = (this.jdField_a_of_type_Sta.a(this.jdField_g_of_type_Int) - (i2 - i4));
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
      if (f1 > swy.jdField_a_of_type_ArrayOfFloat[0]) {
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
      if (f1 <= swy.jdField_a_of_type_ArrayOfFloat[1]) {
        i1 |= 0x2;
      } else {
        label466:
        label474:
        label730:
        if (f1 <= swy.jdField_a_of_type_ArrayOfFloat[2])
        {
          i1 |= 0x4;
          continue;
          i1 |= 0x8;
          continue;
          boolean bool3;
          if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a() != null))
          {
            localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
            bool3 = ((trd)localObject).jdField_a_of_type_Boolean;
            if (tqp.a((trd)localObject)) {
              if (!(localObject instanceof tqv)) {
                break label754;
              }
            }
          }
          label602:
          label736:
          label754:
          for (bool2 = ((tqv)localObject).a();; bool2 = false)
          {
            Integer localInteger;
            if ((((trd)localObject).jdField_a_of_type_Int == 2) && (tqp.a(a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_w_of_type_Int), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight(), this.jdField_b_of_type_Int, bool2, bool1, bool3)))
            {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
              ((trd)localObject).d();
              localObject = swy.jdField_a_of_type_ArrayOfInt;
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
                pbm.b(swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
              }
            }
            for (;;)
            {
              i2 += 1;
              break label602;
              break;
              if ((((trd)localObject).jdField_a_of_type_Int == 1) && (tqp.a(bool1, this.jdField_n_of_type_Boolean, bool3)) && (((trd)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) && (((trd)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.jdField_p_of_type_Int == 1))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(0);
                ((trd)localObject).d();
                break label590;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.setVisibility(8);
              break label590;
              i3 = 0;
              break label632;
              pbm.c(swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
            }
          }
        }
      }
    }
  }
  
  private void G()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_Apkn.d();
    QLog.d("FastWebActivity", 2, "mColorNoteController ：exitAnimation");
  }
  
  private void H()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d("FastWebActivity", 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void I()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        pum localpum = ((pks)this.app.getManager(163)).a().a();
        if (localpum != null) {
          localpum.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void J()
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
          localArrayList.add(new stc(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new srn(this, i1, localBaseData));
        }
        else if (swy.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new sro(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void K()
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
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new srp(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void L()
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
            swy.b(this.app, (AdData)localBaseData);
            if (localBaseData.b == null) {
              break;
            }
            twp.a("REPORT_LINK", "invalidADExposurePos report " + localBaseData.b.mTitle);
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
  
  private void M()
  {
    int i1 = b();
    swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_x_of_type_Int);
    if (this.jdField_a_of_type_Ssq != null) {
      this.jdField_a_of_type_Ssq.e();
    }
  }
  
  private void N()
  {
    long l1 = sxd.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_k_of_type_Boolean) {
      bool = false;
    }
    long l2 = sxd.c("fast_web_show_light_house_2");
    long l3 = sxd.c("fast_web_show_light_house_3");
    long l4 = sxd.c("fast_web_show_light_house_draw_finish");
    long l5 = sxd.c("fast_web_show_light_house_step4_2");
    long l6 = sxd.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", pay.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void O()
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
  
  private void P()
  {
    try
    {
      svu.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("FastWebActivity", 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void Q()
  {
    svv.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void R()
  {
    Object localObject = findViewById(2131373643);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131375949);
    String str = getString(2131717450);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_Svj.a()) {}
    svl localsvl;
    do
    {
      return;
      this.jdField_r_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      M();
      VideoReport.pageLogicDestroy(this);
      this.jdField_r_of_type_Boolean = false;
      localsvl = this.jdField_a_of_type_Svj.a();
    } while (localsvl == null);
    a(localsvl);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    h();
    this.jdField_r_of_type_Boolean = false;
  }
  
  private void T()
  {
    this.jdField_a_of_type_Svl = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_Sta = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    pum localpum = pkm.a().a();
    if (localpum != null)
    {
      localpum.a(this.jdField_a_of_type_Ssj);
      localpum.a(this.jdField_a_of_type_Puq);
    }
    this.jdField_j_of_type_Int = 0;
  }
  
  private void U()
  {
    pay.f(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Svj.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("FastWebActivity", 2, bool);
      this.jdField_a_of_type_Svj.a(new srw(this));
      return;
    }
  }
  
  private void V()
  {
    v();
  }
  
  private void W()
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
      this.jdField_z_of_type_Boolean = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.A = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_x_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d("FastWebActivity", 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.jdField_y_of_type_Boolean + "  isSuctionTop=" + this.jdField_z_of_type_Boolean);
  }
  
  private void X()
  {
    int i1 = (int)(pay.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private void Y()
  {
    if (this.jdField_a_of_type_Ooz != null) {
      this.jdField_a_of_type_Ooz.a();
    }
    this.jdField_a_of_type_Ooz = new ooz();
    this.jdField_a_of_type_Ooz.a(new ssb(this));
  }
  
  private void Z()
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
    if (this.jdField_a_of_type_Sta == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_g_of_type_Int <= 0) {
      F();
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
    if (this.jdField_a_of_type_Sta == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Sta.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Sta.a(i1);
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
      localArticleInfo.businessId = ((sst)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep = new rep();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rep.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.jdField_y_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.c();
    }
  }
  
  private void a(int paramInt, AuthorData paramAuthorData)
  {
    boolean bool = svv.a(paramInt, this.jdField_a_of_type_JavaUtilList);
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
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.32(this), paramLong);
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.jdField_y_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (pgb.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!pgb.l(paramArticleInfo)) {
        localObject1 = ((rgc)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rga.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      R();
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
      localObject = pay.a(this, paramArticleInfo, i1, (String)localObject);
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
      swy.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
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
  
  private void a(svl paramsvl)
  {
    T();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramsvl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Svl = paramsvl;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Svl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_m_of_type_Boolean = paramsvl.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Ssz = paramsvl.jdField_a_of_type_Ssz;
    s();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    twp.a("REPORT_LINK", "requestAdData onGetRecommendsResult");
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
      swt.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      swt.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = pkm.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      J();
      swt.a(this.jdField_a_of_type_JavaUtilList);
      v();
      tqp.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Oau, paramList2);
      tqp.a(this, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Oau, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar, paramList2);
      QLog.d("FastWebActivity", 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_s_of_type_Int);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = pkm.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      sxd.a("HtmlChangeUtil.parse");
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = svu.a();
      }
      this.jdField_a_of_type_JavaUtilList = swn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
      Q();
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
        throw new RuntimeException("parse data is empty!");
      }
      this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
      Object localObject = svu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
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
      sxd.a("HtmlChangeUtil.parse");
      return false;
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
    {
      this.jdField_a_of_type_JavaUtilList.set(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
      this.jdField_a_of_type_JavaUtilList.set(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
    }
    for (;;)
    {
      if ((this.jdField_l_of_type_Int != 1001) && (this.jdField_a_of_type_Svl == null)) {
        swt.d(this.jdField_a_of_type_JavaUtilList);
      }
      swt.e(this.jdField_a_of_type_JavaUtilList);
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
  
  private int b()
  {
    int i3;
    if (this.jdField_a_of_type_Sta == null)
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
      if (svv.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Sta.a(i2);
      }
      i2 += 1;
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
        uhv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, uhv.jdField_d_of_type_Int, true);
      }
      return;
      paramInt = 4;
    }
  }
  
  private void b(Intent paramIntent)
  {
    T();
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
    s();
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
          swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
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
              oix.a(oix.a(new swa(localJSONObject1.optString("kd_ug_rsp_info")).jdField_a_of_type_JavaLangString, (String)localObject, "2"));
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
          svr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          svr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          svr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          svx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, ((ProteusItemData)localObject).a);
        }
      }
      else
      {
        swy.a(paramBaseData);
        if (paramBaseData.b != null) {
          twp.a("REPORT_LINK", "doExposure baseData=" + paramBaseData.b.mTitle);
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
    if (this.jdField_a_of_type_Ssm != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Ssm.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Ssm.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Ssm.a().get(i1);
        if (((localBaseAdapter instanceof osu)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
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
  
  private void c(boolean paramBoolean)
  {
    if (this.jdField_x_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_x_of_type_Boolean = true;
      int i2 = this.jdField_a_of_type_Svj.a();
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
  
  private boolean c()
  {
    return (this.jdField_l_of_type_Int == 1001) && (!pcl.c(this.jdField_e_of_type_Int));
  }
  
  private boolean c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return svv.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
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
  
  private void e(boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (paramBoolean)
    {
      i1 = 2130842908;
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
      i1 = 2130843065;
      break;
    }
  }
  
  private void h()
  {
    VideoReport.setPageId(this, "1");
    VideoReport.setPageParams(this, new pil().e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID).a(Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).a("ref_channel", Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID)).b(Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.dtReportContentType)).a());
  }
  
  private void i()
  {
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void j()
  {
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean))
    {
      Intent localIntent = getIntent();
      Bundle localBundle = null;
      if (localIntent != null) {
        localBundle = localIntent.getExtras();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout = new CommonSuspensionGestureLayout(this, localBundle);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsAutoSuctionTop(this.jdField_z_of_type_Boolean);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsNeedPopAnim(this.A);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setIsStatusImmersive(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new srm(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new sru(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131376503, 2131363672);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841728));
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
      this.jdField_a_of_type_Apkn = new apkn(this, true, false, true, true, 0);
      this.jdField_a_of_type_Apkn.a(this);
      this.jdField_a_of_type_Apkn.a(new ssc(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d("FastWebActivity", 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Apkn.a(new sse(this));
      this.jdField_a_of_type_Apkn.a(new ssf(this));
      this.jdField_a_of_type_Apkn.a(new ssg(this));
    } while (this.jdField_w_of_type_Boolean);
    this.jdField_a_of_type_Apkn.j();
  }
  
  private void l()
  {
    pay.jdField_f_of_type_Boolean = false;
    uio.a(4);
  }
  
  private void m()
  {
    pay.jdField_f_of_type_Boolean = false;
    pay.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void n()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131376605);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(pay.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131375964)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369115));
      findViewById(2131369068).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363672));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131381268));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131167276));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131167276));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      o();
      p();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, (QQAppInterface)pay.a());
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379534));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131370609);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      B();
      q();
      r();
      findViewById(2131376433).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366609));
      this.jdField_a_of_type_Ssl = new ssl(this);
      A();
      s();
      W();
      Z();
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar = ((CommonAdBar)findViewById(2131377604));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.bringToFront();
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_Oau == null) {
      this.jdField_a_of_type_Oau = new oau(this);
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376654));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371151));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371152));
    Drawable localDrawable = bfvo.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130841061), -16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      x();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    Object localObject2;
    Object localObject3;
    try
    {
      u();
      sxd.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_Puy);
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      bool = a();
      svu.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      swt.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
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
            localHashMap.put("param_uin", pay.a());
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
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      if (!bool)
      {
        d(false);
        y();
        ojq.a().a(5555, this);
        ojq.a().a(6666, this);
        d();
        new szc().a("native_article");
        Y();
        QLog.d("FastWebActivity", 1, "initData,isParseSuccess=" + bool);
        return;
        sxd.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Ssm = new ssm();
        this.jdField_a_of_type_Sta = new sta(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Ssm);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Sta);
        this.jdField_a_of_type_Ssq = new ssq(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
        this.jdField_a_of_type_Ssq.registerDataSetObserver(new ssh(this));
        this.jdField_a_of_type_Ssm.a(this.jdField_a_of_type_Ssq);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
          w();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
        }
        t();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Ssm);
        this.jdField_a_of_type_Ssm.a(this.jdField_a_of_type_Sso);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131376963);
        X();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = pkm.a().a();
        if (this.jdField_a_of_type_Svl != null)
        {
          localObject1 = this.jdField_a_of_type_Svl.jdField_a_of_type_AndroidOsParcelable;
          label771:
          if (localObject1 == null) {
            break label958;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          a(((AbsListView.SavedState)localObject1).position, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
          label800:
          a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
          if ((this.jdField_l_of_type_Int == 1001) || (this.jdField_a_of_type_Svl != null)) {
            break label1033;
          }
        }
      }
      label1033:
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
          ((pum)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ssj, true);
        }
        label958:
        do
        {
          if ((bool) || (localObject2 == null)) {
            break label1040;
          }
          ((pum)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaUtilList);
          break label1040;
          if (localObject2 != null)
          {
            localObject1 = ((pum)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
            break label771;
            a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
            break label800;
            d(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
            pkp.a().a(this.jdField_b_of_type_Pkt);
            pkp.a().a(this.jdField_a_of_type_Pkt);
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
      label1040:
      bool = true;
    }
  }
  
  private void t()
  {
    this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader = new ssi(this);
    VideoReport.markAsPageBodyView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_ComTencentQqliveModuleVideoreportPageIScrollReader);
    VideoReport.setPageBodyContentRange(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0, this.jdField_a_of_type_JavaUtilList.size());
  }
  
  private void u()
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
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long, this.jdField_a_of_type_Pwf, true);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s;
      QLog.d("FastWebActivity", 1, "initArticleInfo, update url,url=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Ssm == null) {
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.jdField_a_of_type_Ssm.notifyDataSetChanged();
      return;
    }
    runOnUiThread(new FastWebActivity.11(this));
  }
  
  private void w()
  {
    String str = null;
    this.jdField_a_of_type_Osu = new osu(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Osu.a(new sre(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Osu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Osu.a(new srg(this));
      this.jdField_a_of_type_Ssm.a(this.jdField_a_of_type_Osu);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new srh(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new sri(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376963, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void x()
  {
    pum localpum = pkm.a().a();
    if (localpum == null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        y();
      }
      QLog.d("FastWebActivity", 2, "fastWebModule == null");
      return;
    }
    localpum.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Puq);
  }
  
  private void y()
  {
    QLog.d("FastWebActivity", 1, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_l_of_type_Boolean = true;
    pkp.a().a(this.jdField_b_of_type_Pkt);
    pkp.a().a(this.jdField_a_of_type_Pkt);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new srj(this));
    odq.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new srk(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public oau a()
  {
    return this.jdField_a_of_type_Oau;
  }
  
  public tql a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      tql localtql = (tql)localIterator.next();
      if ((localtql != null) && (localtql.a != null) && (localtql.a.jdField_d_of_type_JavaLangString != null) && (localtql.a.jdField_d_of_type_JavaLangString.equals(paramString))) {
        return localtql;
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
    float f1 = paramFloat;
    if (paramFloat > 5.0F) {
      f1 = 1.0F;
    }
    bkwm.a("readinjoy_font_size_ratio_sp", Float.valueOf(f1));
    swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B257", ozw.a(null, "font_size", Integer.valueOf(paramInt + 1)));
    v();
    QLog.d("FastWebActivity", 1, "onFontSizeChange,index=" + paramInt + " ,textSizeRatio=" + f1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131370609).setVisibility(8);
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
    VideoReport.pageLogicDestroy(this);
    if (this.jdField_a_of_type_Ssq != null) {
      this.jdField_a_of_type_Ssq.d();
    }
    this.jdField_r_of_type_Boolean = false;
    svl localsvl = new svl();
    localsvl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localsvl.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localsvl.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localsvl.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localsvl.jdField_a_of_type_Boolean = this.jdField_m_of_type_Boolean;
    localsvl.jdField_a_of_type_Ssz = this.jdField_a_of_type_Ssz;
    this.jdField_a_of_type_Svj.a(localsvl);
    this.jdField_b_of_type_JavaLangString = (pay.a() + System.currentTimeMillis());
    b(paramIntent);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_r_of_type_Boolean = false;
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
    pbm.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_p_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        swy.a(localArticleInfo1, "0X800898C", pay.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Ugz == null) {
          this.jdField_a_of_type_Ugz = new ugz(this, this.app, new ssk(this));
        }
        this.jdField_a_of_type_Ugz.a().setActionSheetTitle("biu出去让更多好友看到");
        this.jdField_a_of_type_Ugz.a().setOnDismissListener(new srl(this));
        this.jdField_a_of_type_Ugz.a(a(), 1);
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
      swy.a(localArticleInfo1, "0X8008993", pay.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772339, 2130772338);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Apkn != null)) {
        this.jdField_a_of_type_Apkn.j();
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
      this.jdField_a_of_type_Pbm.b();
      this.jdField_a_of_type_Int = 2;
      a(8);
      return;
    }
    if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Apkn != null)) {
      this.jdField_a_of_type_Apkn.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Pbm.a();
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
    v();
    this.jdField_a_of_type_Int = 1;
    a(0);
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = bjnd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
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
          if (((i2 & 0x4000) == 0L) && (bcua.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
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
              bcua.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Apkn != null) && (this.jdField_a_of_type_Apkn.a()) && (this.jdField_w_of_type_Boolean))
          {
            if (!this.jdField_a_of_type_Apkn.c()) {
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
      localObject1 = new rdy();
      localReportInfo.mUin = pay.a();
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
        ((rdy)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Rer != null) {
          ((rdy)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Rer.jdField_a_of_type_Long;
        }
        ((rdy)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((rdy)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((rdy)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (rer)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((rdy)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((rer)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((rdy)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    pkm.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      swt.b(this.jdField_a_of_type_JavaUtilList);
      v();
      return;
    }
    swt.c(this.jdField_a_of_type_JavaUtilList);
    v();
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
    Object localObject = new otr(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d("FastWebActivity", 1, "scrollToLastReadPos | begin");
    int i1;
    if (this.jdField_s_of_type_Boolean)
    {
      QLog.d("FastWebActivity", 1, "Scroll2CommentArea");
      if (this.jdField_s_of_type_Int == 0)
      {
        odq.a((QQAppInterface)getAppInterface(), oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d("FastWebActivity", 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_u_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_s_of_type_Int, this.jdField_t_of_type_Int);
      this.jdField_s_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      ((otr)localObject).d(1);
      this.jdField_a_of_type_Pbm.a();
      localObject = ((otr)localObject).a();
      odq.a((QQAppInterface)getAppInterface(), oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
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
      this.jdField_s_of_type_Boolean = true;
      ((otr)localObject).d(2);
      localObject = ((otr)localObject).a();
      odq.a((QQAppInterface)getAppInterface(), oto.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Pbm.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ssq != null) {}
    for (int i1 = this.jdField_a_of_type_Ssq.getCount();; i1 = 0)
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
    if ((this.jdField_a_of_type_Ugz != null) && (this.jdField_a_of_type_Ugz.a())) {}
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
    this.jdField_t_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
    QLog.d("FastWebActivity", 1, "is from colorNote : " + this.jdField_t_of_type_Boolean);
    this.jdField_w_of_type_Boolean = apoq.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      localBundle = localBundle.getBundle("banner_webview_extra");
      if ((localBundle != null) && (localBundle.get("fast_web_article_info") != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
        this.jdField_e_of_type_Int = localBundle.getInt("fast_web_banner_from_channel_id");
        this.jdField_l_of_type_Int = 1001;
        this.jdField_m_of_type_Boolean = localBundle.getBoolean("fast_web_from_article_recommend", false);
      }
    }
    else
    {
      this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
      this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      this.jdField_b_of_type_JavaLangString = (pay.a() + System.currentTimeMillis());
      h();
      a(paramBundle);
      odq.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), "", false);
    }
    try
    {
      setContentView(2131560177);
      n();
      if (this.jdField_a_of_type_Ssq != null) {
        this.jdField_a_of_type_Ssq.a();
      }
      j();
      k();
      txq.a.a();
      this.jdField_a_of_type_AndroidUtilSparseArray = svu.a();
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
          setContentView(2131560177);
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
      pbm.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Osu != null) && (this.jdField_a_of_type_Osu.a() != null))
      {
        localObject = this.jdField_a_of_type_Osu.a();
        ((otl)localObject).a(this.jdField_a_of_type_Pbm.b(), this.jdField_u_of_type_Int);
        ((otl)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Ssq.getCount());
      }
    }
    pkp.a().b(this.jdField_b_of_type_Pkt);
    pkp.a().b(this.jdField_a_of_type_Pkt);
    if (this.jdField_a_of_type_Ssq != null) {
      this.jdField_a_of_type_Ssq.d();
    }
    if (this.jdField_a_of_type_Ssm != null) {
      this.jdField_a_of_type_Ssm.a();
    }
    if (this.jdField_a_of_type_Osu != null) {
      this.jdField_a_of_type_Osu.d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.onDestroy();
    }
    M();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aadf != null) {
      this.jdField_a_of_type_Aadf.c();
    }
    this.jdField_a_of_type_Aadf = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Sxb != null) {
      this.jdField_a_of_type_Sxb.a();
    }
    if (this.jdField_a_of_type_Ugz != null) {
      this.jdField_a_of_type_Ugz.b();
    }
    swu.a();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    rtp.a().jdField_b_of_type_Boolean = false;
    Object localObject = pkm.a().a();
    if (localObject != null) {
      ((pum)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_Oau != null) {
      this.jdField_a_of_type_Oau.a();
    }
    localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((tql)((Iterator)localObject).next()).i();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    E();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_c_of_type_Boolean) {
        ajjg.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Swi.a();
    this.jdField_a_of_type_Swi = null;
    ojq.a().b(5555, this);
    ojq.a().b(6666, this);
    if (this.jdField_a_of_type_Apkn != null)
    {
      this.jdField_a_of_type_Apkn.c();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Ooz != null) {
      this.jdField_a_of_type_Ooz.a();
    }
    localObject = pkm.a().a();
    if (localObject != null) {
      ((puw)localObject).b(this.jdField_a_of_type_Puy);
    }
    nwz.a().a("RIJAdRefreshSceneNativeArticle");
    txq.a.d();
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
          if (this.jdField_a_of_type_Sxb == null) {
            this.jdField_a_of_type_Sxb = new sxb(this);
          }
          this.jdField_a_of_type_Sxb.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Sxb.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
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
        localObject1 = pay.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + swy.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_b_of_type_JavaLangString);
        swy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_r_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", pay.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.4.8".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!uhv.a(this.jdField_b_of_type_Long)) {
            break label696;
          }
          localObject1 = "0X8009359";
          odq.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_k_of_type_Int), (String)localObject2, false);
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
        ((ReportInfo)localObject2).mUin = pay.a();
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
        if (this.jdField_a_of_type_Ssq != null) {
          this.jdField_a_of_type_Ssq.c();
        }
        if (pay.jdField_g_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Apkn != null)
        {
          this.jdField_a_of_type_Apkn.b();
          QLog.d("FastWebActivity", 2, "mColorNoteController.onPause");
        }
        txq.a.c();
        if ((!c()) && (!ReadinjoyTabFrame.d_())) {
          continue;
        }
        this.jdField_a_of_type_Qxp.b();
        this.jdField_a_of_type_Qxp.a();
        return;
        localObject1 = "1";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label696:
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
    sxd.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    v();
    if (this.jdField_a_of_type_Ssq != null) {
      this.jdField_a_of_type_Ssq.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pbm.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      pkm.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (pay.jdField_g_of_type_Boolean)
    {
      if (pay.jdField_f_of_type_Boolean) {
        pay.a(4, this.jdField_c_of_type_Long);
      }
      m();
    }
    l();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_Apkn != null)
    {
      this.jdField_a_of_type_Apkn.a();
      QLog.d("FastWebActivity", 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_Puy);
    }
    this.jdField_z_of_type_Int = 0;
    if (((c()) || (qxp.b())) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      this.jdField_a_of_type_Qxp.a(this);
      this.jdField_a_of_type_Qxp.b();
      this.jdField_a_of_type_Qxp.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, qxs.c());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar != null)
    {
      trd localtrd = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_barCommonAdBar.a();
      if (localtrd != null) {
        localtrd.e();
      }
    }
    txq.a.b();
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
      pbm.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Pbm.b();
    }
    if ((isFinishing()) || (this.jdField_r_of_type_Boolean))
    {
      QLog.d("FastWebActivity", 1, "fastwebActivity doOnStop | removeCommentDataManager");
      ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
    swt.b(this.jdField_a_of_type_JavaUtilList);
    v();
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
    if ((this.jdField_u_of_type_Boolean) && (!this.jdField_v_of_type_Boolean))
    {
      G();
      return;
    }
    if (this.jdField_a_of_type_Svj.a())
    {
      if (this.jdField_a_of_type_Apkn == null) {
        d(this);
      }
      if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean) && (this.A) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_v_of_type_Boolean))
      {
        H();
        return;
      }
      if ((this.jdField_a_of_type_Apkn != null) && (!this.jdField_v_of_type_Boolean))
      {
        G();
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
        swy.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_k_of_type_Boolean = true;
    L();
    N();
    I();
    pkp.a().b(this.jdField_b_of_type_Pkt);
    pkp.a().b(this.jdField_a_of_type_Pkt);
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
      odq.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      S();
      QLog.d("FastWebActivity", 2, "mFloating ：finish over");
      return;
      if (this.jdField_e_of_type_Int == 0)
      {
        okj.a(this.app, this, 11, 0);
        break;
      }
      if (pcl.c(this.jdField_e_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bkwm.i()) {
        break;
      }
      okj.a(this, 11);
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
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371152));
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
        pay.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
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
                        if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Svl == null))
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
                      paramIntent = ouu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.jdField_a_of_type_JavaUtilList != null) {}
                        for (;;)
                        {
                          AIOUtils.catchedExceptionInReleaseV2("FastWebActivity", bool, new NullPointerException());
                          return;
                          bool = false;
                        }
                      }
                    } while (this.jdField_a_of_type_Osu == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.d((String)localObject, this.jdField_a_of_type_Osu.b());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.c((String)localObject, this.jdField_a_of_type_Osu.b());
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
                  swy.a(this, paramIntent, (ArticleInfo)localObject, 0, -1, false, bool, false);
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
                  swy.a(this, paramIntent, (ArticleInfo)localObject, 1, paramInt1, false, bool, false);
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
      QQToast.a(this, -1, getString(2131698823), 0).b(getTitleBarHeight());
      return;
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    label530:
    paramInt1 = i1;
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      paramInt1 = 1;
    }
    ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Ooz, 1, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Osu.b(), paramInt1);
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
    if ((paramView.getId() != 2131369068) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363069: 
      case 2131363070: 
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          svv.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.getSubscribeUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true);
        }
        break;
      case 2131369068: 
        this.jdField_o_of_type_Boolean = true;
        finish();
        break;
      case 2131366967: 
        a(paramView.getTag());
        break;
      case 2131376433: 
        a(true);
        break;
      case 2131369115: 
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
        break;
      case 2131370609: 
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
        stg localstg = (stg)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localstg != null) {
          localstg.a(paramString, paramBitmap);
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
        this.jdField_b_of_type_Boolean = true;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = pay.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_d_of_type_Int, this.jdField_m_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          swy.a(localArticleInfo1, "0X800A09C", pay.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label227;
          }
          localObject = "2";
          swy.a(localArticleInfo1, "0X800A09D", pay.a(this, localArticleInfo2, i1, (String)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */