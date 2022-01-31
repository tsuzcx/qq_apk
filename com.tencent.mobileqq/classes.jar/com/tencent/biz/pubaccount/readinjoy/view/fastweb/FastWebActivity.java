package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import aepi;
import aijf;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aobw;
import aoft;
import azri;
import bagk;
import bdbb;
import bdbc;
import bdep;
import bdgk;
import bdhj;
import bdin;
import bdiv;
import bhsz;
import bhtv;
import bhwp;
import bicq;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.ad.soft_ad.ReadInJoyCommonSoftAdBar;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoySecondCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
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
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import nor;
import nrt;
import nwh;
import nxa;
import nxc;
import nxu;
import odp;
import ofg;
import oik;
import ola;
import olq;
import ols;
import olt;
import olv;
import olw;
import omz;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import orz;
import osk;
import otf;
import owy;
import oxb;
import oxd;
import oxe;
import pfo;
import pfq;
import pfr;
import qlv;
import qmc;
import qme;
import qnm;
import qno;
import qzy;
import rqj;
import ryb;
import ryd;
import rye;
import ryg;
import ryh;
import ryi;
import ryj;
import ryk;
import ryl;
import rym;
import ryn;
import ryo;
import ryp;
import ryq;
import rys;
import ryt;
import ryv;
import ryw;
import rza;
import rzb;
import rzc;
import rzd;
import rze;
import rzf;
import rzg;
import rzh;
import rzi;
import rzj;
import rzk;
import rzl;
import rzm;
import rzn;
import rzo;
import rzp;
import rzq;
import rzr;
import rzt;
import rzv;
import rzy;
import sac;
import sad;
import saf;
import sah;
import scb;
import scd;
import sci;
import scl;
import scm;
import scn;
import scx;
import sdc;
import sdi;
import sdj;
import sdn;
import sdq;
import sds;
import sft;
import syq;
import syu;
import szp;
import tah;
import zfy;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, bdbc, MiniMsgUser.IMiniMsgActionCallback, nxc, ofg, ols, olv, syu
{
  public static int a;
  private boolean A = true;
  private boolean B;
  private boolean C;
  private boolean D;
  private boolean E;
  private float jdField_a_of_type_Float = bdgk.d() * 500 / 160.0F;
  protected long a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aobw jdField_a_of_type_Aobw;
  private bdbb jdField_a_of_type_Bdbb;
  bhtv jdField_a_of_type_Bhtv = new ryp(this);
  private bicq jdField_a_of_type_Bicq = new rza(this);
  private ProteusInnerData jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData;
  private ReadInJoyCommonSoftAdBar jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar;
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
  private RIJRedPacketPopupView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  private RIJRedPacketProgressView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  private ReadInJoyFastWebBottomSocialViewNew jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew;
  private AuthorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData;
  private TitleData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData;
  private ItemShowDispatcher jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = new ItemShowDispatcher();
  private FastWebArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
  private CommonSuspensionGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout;
  public MiniMsgUser a;
  public INetInfoHandler a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nor jdField_a_of_type_Nor;
  private oik jdField_a_of_type_Oik;
  private ola jdField_a_of_type_Ola;
  private osk jdField_a_of_type_Osk = new osk();
  oxe jdField_a_of_type_Oxe = new rzf(this);
  private pfq jdField_a_of_type_Pfq = new rzd(this);
  private pfr jdField_a_of_type_Pfr = new rzc(this);
  private rzq jdField_a_of_type_Rzq;
  private rzr jdField_a_of_type_Rzr;
  rzt jdField_a_of_type_Rzt = new rzi(this);
  private rzv jdField_a_of_type_Rzv;
  private sac jdField_a_of_type_Sac;
  private sad jdField_a_of_type_Sad;
  private scb jdField_a_of_type_Scb = new scb(this);
  private scd jdField_a_of_type_Scd;
  private scx jdField_a_of_type_Scx = new scx();
  private sdq jdField_a_of_type_Sdq;
  private syq jdField_a_of_type_Syq;
  private zfy jdField_a_of_type_Zfy;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = bdgk.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = 1;
  public long b;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new rzh(this);
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RIJRedPacketPopupView jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView;
  private String jdField_b_of_type_JavaLangString = "FastWebActivity";
  private oxe jdField_b_of_type_Oxe = new ryq(this);
  public boolean b;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = System.currentTimeMillis() + "";
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private long jdField_f_of_type_Long;
  private String jdField_f_of_type_JavaLangString = "";
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
  private int jdField_k_of_type_Int = 1000;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
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
  private int jdField_s_of_type_Int = 1;
  private boolean jdField_s_of_type_Boolean = true;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean;
  private int jdField_v_of_type_Int = -1;
  private boolean jdField_v_of_type_Boolean;
  private int jdField_w_of_type_Int;
  private boolean jdField_w_of_type_Boolean = true;
  private int jdField_x_of_type_Int;
  private boolean jdField_x_of_type_Boolean;
  private int jdField_y_of_type_Int;
  private boolean jdField_y_of_type_Boolean;
  private boolean z = true;
  
  static
  {
    jdField_a_of_type_Int = 33;
  }
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rzg(this);
  }
  
  private void A()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_Sad == null) || ((this.jdField_a_of_type_Rzv != null) && (this.jdField_a_of_type_Rzv.getCount() != this.jdField_a_of_type_Sad.a())))
    {
      QLog.e("Q.readinjoy.fast_web", 2, "refreshMaxReadHeight itemsHeight == null ");
      return;
    }
    int i4 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
    int i1;
    label62:
    int i2;
    label83:
    Object localObject;
    int i3;
    label264:
    float f1;
    if (i4 > this.jdField_f_of_type_Int)
    {
      i1 = 1;
      if (this.jdField_a_of_type_Sad != null)
      {
        if (this.jdField_f_of_type_Int <= i4) {
          break label382;
        }
        i2 = this.jdField_f_of_type_Int;
        this.jdField_f_of_type_Int = i2;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        i2 = this.jdField_f_of_type_Int - i2;
        if ((i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_f_of_type_Int < this.jdField_a_of_type_Sad.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(i2);
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i3 = ((View)localObject).getTop();
          this.jdField_h_of_type_Int = (this.jdField_a_of_type_Sad.a(this.jdField_f_of_type_Int) - (i2 - i3));
          if (i1 == 0) {
            break label388;
          }
          this.jdField_g_of_type_Int = this.jdField_h_of_type_Int;
          if (this.jdField_g_of_type_Int < 0) {
            this.jdField_g_of_type_Int = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_f_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_g_of_type_Int);
        }
      }
      i3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
      int i5 = this.jdField_a_of_type_JavaUtilList.size();
      i2 = 0;
      i1 = 0;
      if (i3 > i4) {
        break label462;
      }
      if (i3 >= i5) {
        break label454;
      }
      f1 = BaseData.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i3));
      if (f1 > sdn.jdField_a_of_type_ArrayOfFloat[0]) {
        break label420;
      }
      i1 |= 0x1;
    }
    label310:
    label454:
    label462:
    label599:
    label605:
    label626:
    for (;;)
    {
      if ((i3 < this.jdField_a_of_type_JavaUtilList.size()) && ((this.jdField_a_of_type_JavaUtilList.get(i3) instanceof ProteusInnerData)) && (((ProteusInnerData)this.jdField_a_of_type_JavaUtilList.get(i3)).e()))
      {
        this.jdField_n_of_type_Boolean = true;
        i2 = 1;
      }
      for (;;)
      {
        i3 += 1;
        break label264;
        i1 = 0;
        break label62;
        label382:
        i2 = i4;
        break label83;
        if (this.jdField_h_of_type_Int < this.jdField_g_of_type_Int) {}
        for (i1 = this.jdField_h_of_type_Int;; i1 = this.jdField_g_of_type_Int)
        {
          this.jdField_g_of_type_Int = i1;
          break;
        }
        if (f1 <= sdn.jdField_a_of_type_ArrayOfFloat[1])
        {
          i1 |= 0x2;
          break label310;
        }
        if (f1 > sdn.jdField_a_of_type_ArrayOfFloat[2]) {
          break label626;
        }
        i1 |= 0x4;
        break label310;
        i1 |= 0x8;
        break label310;
        if ((i2 == 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.getVisibility() == 8) && (this.jdField_n_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.setVisibility(0);
        }
        if ((i2 != 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.getVisibility() == 0)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.setVisibility(8);
        }
        localObject = sdn.jdField_a_of_type_ArrayOfInt;
        i4 = localObject.length;
        i2 = 0;
        Integer localInteger;
        if (i2 < i4)
        {
          localInteger = Integer.valueOf(localObject[i2]);
          if ((1 << localInteger.intValue() & i1) == 0) {
            break label599;
          }
          i3 = 1;
          if (i3 == 0) {
            break label605;
          }
          osk.b(sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
        for (;;)
        {
          i2 += 1;
          break label542;
          break;
          i3 = 0;
          break label572;
          osk.c(sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
      }
    }
  }
  
  private void C()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_Aobw.d();
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：exitAnimation");
  }
  
  private void D()
  {
    this.jdField_v_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        pfo localpfo = ((oxd)this.app.getManager(163)).a().a();
        if (localpfo != null) {
          localpfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void F()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (localBaseData.jdField_s_of_type_Int == 6) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new saf(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new rym(this, i1, localBaseData));
        }
        else if (sdn.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new ryn(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void G()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null)) {}
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (a(localBaseData.jdField_s_of_type_Int)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new ryo(this, localBaseData));
        }
        i1 += 1;
      }
    }
  }
  
  private void H()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher == null) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.size() <= 0)) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.iterator();
    label202:
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      int i1 = 0;
      for (;;)
      {
        if (i1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label202;
        }
        if (localInteger.intValue() == i1)
        {
          BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(localInteger.intValue());
          if (AdData.a(localBaseData))
          {
            sdn.b(this.app, (AdData)localBaseData);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "invalidADExposurePos report " + localInteger);
            break;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 1, "invalidADExposurePos report invalid key" + localInteger);
          break;
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a.clear();
  }
  
  private void I()
  {
    int i1 = b();
    sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_v_of_type_Int);
    if (this.jdField_a_of_type_Rzv != null) {
      this.jdField_a_of_type_Rzv.e();
    }
  }
  
  private void J()
  {
    long l1 = sds.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_k_of_type_Boolean) {
      bool = false;
    }
    long l2 = sds.c("fast_web_show_light_house_2");
    long l3 = sds.c("fast_web_show_light_house_3");
    long l4 = sds.c("fast_web_show_light_house_draw_finish");
    long l5 = sds.c("fast_web_show_light_house_step4_2");
    long l6 = sds.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", ors.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    azri.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void K()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "resume timing:  task time has gone: " + this.jdField_w_of_type_Int);
    this.jdField_a_of_type_JavaLangRunnable = new FastWebActivity.23(this);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void L()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.c();
    QLog.i(this.jdField_b_of_type_JavaLangString, 1, "report timinggggggg");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  private void M()
  {
    this.jdField_l_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0);
    int i1;
    boolean bool1;
    boolean bool2;
    if (localView == null)
    {
      i1 = 0;
      this.jdField_m_of_type_Int = i1;
      this.jdField_n_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
      bool1 = b(this.jdField_l_of_type_Int);
      bool2 = b(this.jdField_n_of_type_Int);
      if ((bool1) || (bool2)) {
        break label101;
      }
      this.jdField_o_of_type_Int = this.jdField_l_of_type_Int;
      this.jdField_p_of_type_Int = this.jdField_m_of_type_Int;
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
        this.jdField_q_of_type_Int = this.jdField_l_of_type_Int;
        this.jdField_r_of_type_Int = this.jdField_m_of_type_Int;
        this.jdField_s_of_type_Boolean = false;
        this.jdField_f_of_type_Boolean = true;
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.jdField_q_of_type_Int);
        return;
      }
    } while ((bool1) || (!bool2));
    this.jdField_s_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_q_of_type_Int);
    d();
  }
  
  private void N()
  {
    try
    {
      scl.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void O()
  {
    scm.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void P()
  {
    Object localObject = findViewById(2131372977);
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = (TextView)findViewById(2131375318);
    String str = getString(2131718970);
    if ((localObject != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(str);
    }
  }
  
  private void Q()
  {
    if (this.jdField_a_of_type_Scb.a()) {}
    scd localscd;
    do
    {
      return;
      this.jdField_r_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      I();
      this.jdField_r_of_type_Boolean = false;
      localscd = this.jdField_a_of_type_Scb.a();
    } while (localscd == null);
    a(localscd);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_r_of_type_Boolean = false;
  }
  
  private void R()
  {
    this.jdField_a_of_type_Scd = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_Sad = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_Bhtv);
    pfo localpfo = owy.a().a();
    if (localpfo != null)
    {
      localpfo.a(this.jdField_a_of_type_Pfq);
      localpfo.a(this.jdField_a_of_type_Pfr);
    }
    this.jdField_i_of_type_Int = 0;
  }
  
  private void S()
  {
    if ((this.jdField_f_of_type_JavaLangString == null) || (!this.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))
    {
      j();
      if ((this.jdField_k_of_type_Int != 1001) || (otf.c(this.jdField_e_of_type_Int))) {
        break label149;
      }
    }
    label149:
    for (int i1 = 1;; i1 = 0)
    {
      if (((ReadinjoyTabFrame.c_()) || (i1 != 0)) && (RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e())) {
        RIJRedPacketManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, new ryw(this));
      }
      if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (RIJRedPacketManager.a().e())) {
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(new FastWebActivity.33(this), 500L);
      }
      this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
      return;
    }
  }
  
  private void T()
  {
    ors.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Scb.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str, 2, bool);
      this.jdField_a_of_type_Scb.a(new rzb(this));
      return;
    }
  }
  
  private void U()
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.42(this));
  }
  
  private void V()
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
      this.jdField_v_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.jdField_y_of_type_Boolean + "  isSuctionTop=" + this.z);
  }
  
  private void W()
  {
    int i1 = (int)(ors.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private void X()
  {
    if (this.jdField_a_of_type_Oik != null) {
      this.jdField_a_of_type_Oik.a();
    }
    this.jdField_a_of_type_Oik = new oik();
    this.jdField_a_of_type_Oik.a(new rzj(this));
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_Sad == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_f_of_type_Int <= 0) {
      B();
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
    return a(this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Sad == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Sad.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Sad.a(i1);
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
      this.jdField_i_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_h_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_i_of_type_Int;
      if (this.jdField_i_of_type_Int == 0) {
        this.jdField_i_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_h_of_type_Int);
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
      localArticleInfo.businessId = ((rzy)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc = new qmc();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qmc.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return Uri.parse(paramString).getQueryParameter("redpackid");
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) && (!this.E))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.36(this), paramLong);
  }
  
  private void a(Bundle paramBundle)
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "onSaveInstanceState data != null");
      paramBundle.putBundle("bundle_key_save_instancestate", localBundle);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView == null) || ((paramBoolean) && (paramView.getVisibility() == 0)) || ((!paramBoolean) && (paramView.getVisibility() != 0))) {
      return;
    }
    if (paramBoolean) {}
    for (AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);; localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F))
    {
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setFillAfter(true);
      localAlphaAnimation.setAnimationListener(new ryt(this, paramBoolean, paramView));
      paramView.startAnimation(localAlphaAnimation);
      return;
    }
  }
  
  private void a(RIJRedPacketPopupView paramRIJRedPacketPopupView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, CharSequence paramCharSequence, int paramInt3)
  {
    ViewGroup.LayoutParams localLayoutParams = paramRIJRedPacketPopupView.getLayoutParams();
    if ((localLayoutParams instanceof FrameLayout.LayoutParams))
    {
      ((FrameLayout.LayoutParams)localLayoutParams).leftMargin = paramInt1;
      ((FrameLayout.LayoutParams)localLayoutParams).topMargin = paramInt2;
    }
    for (;;)
    {
      paramRIJRedPacketPopupView.setLayoutParams(localLayoutParams);
      paramRIJRedPacketPopupView.setText(paramCharSequence);
      paramRIJRedPacketPopupView.a(paramBoolean2);
      if (paramBoolean2) {
        paramRIJRedPacketPopupView.setOnCloseIconClickListener(new rys(this, paramRIJRedPacketPopupView));
      }
      paramRIJRedPacketPopupView.b(paramBoolean1);
      a(paramRIJRedPacketPopupView, true);
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new FastWebActivity.27(this, paramRIJRedPacketPopupView), paramInt3);
      return;
      if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
      {
        ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = paramInt1;
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = paramInt2;
      }
    }
  }
  
  private void a(@NotNull ArticleInfo paramArticleInfo)
  {
    int i2 = 0;
    orz localorz = new orz();
    paramArticleInfo = localorz.a("uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin())).a("rowkey", paramArticleInfo.innerUniqueID).a("os", Integer.valueOf(1)).a("imsi", bdgk.b()).a("imei", ors.f());
    if (bdin.h(BaseApplicationImpl.getContext()))
    {
      i1 = 2;
      paramArticleInfo = paramArticleInfo.a("network_type", Integer.valueOf(i1));
      if (!this.C) {
        break label180;
      }
    }
    label180:
    for (int i1 = 1;; i1 = 0)
    {
      paramArticleInfo = paramArticleInfo.a("is_redpack", Integer.valueOf(i1)).a("redpack_style", Integer.valueOf(this.jdField_y_of_type_Int));
      i1 = i2;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        i1 = 1;
      }
      paramArticleInfo.a("is_tips", Integer.valueOf(i1)).a("page_type", Integer.valueOf(1));
      nrt.a("0X800AD2F", localorz.a());
      return;
      i1 = 1;
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
      localObject = ors.a(this, paramArticleInfo, i1, (String)localObject);
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
        if ((this.jdField_y_of_type_Boolean) && (this.jdField_v_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_v_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      sdn.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      localObject = "1";
      break;
      i1 = 0;
    }
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
  
  private void a(scd paramscd)
  {
    R();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramscd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Scd = paramscd;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Scd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_m_of_type_Boolean = paramscd.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Sac = paramscd.jdField_a_of_type_Sac;
    s();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o.equals(paramString)))
    {
      paramString = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      if (paramList2 != null)
      {
        paramList2 = paramList2.iterator();
        int i1 = 0;
        if (paramList2.hasNext())
        {
          BaseData localBaseData = (BaseData)paramList2.next();
          int i2;
          if (localBaseData.jdField_e_of_type_Boolean) {
            if (((localBaseData instanceof ProteusInnerData)) && (((ProteusInnerData)localBaseData).d()))
            {
              i2 = i1;
              if (i1 != 0) {
                break label207;
              }
              paramString.add(localBaseData);
              i1 = 1;
              i2 = i1;
              if (!((ProteusInnerData)localBaseData).e()) {
                break label207;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData = ((ProteusInnerData)localBaseData);
              i2 = i1;
              if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar == null) {
                break label207;
              }
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.setUI(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdDataProteusInnerData);
              i1 = 1;
            }
          }
          for (;;)
          {
            break;
            paramString.add(localBaseData);
            continue;
            localArrayList.add(localBaseData);
            i2 = i1;
            label207:
            i1 = i2;
          }
        }
      }
      sdi.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      sdi.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = owy.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      F();
      sdi.a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Rzr != null) {
        this.jdField_a_of_type_Rzr.notifyDataSetChanged();
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_q_of_type_Int);
      d();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 0);
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_k_of_type_Boolean);
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init color bytes error");
    }
    return arrayOfByte1;
  }
  
  private int b()
  {
    int i3;
    if (this.jdField_a_of_type_Sad == null)
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
      if (scm.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Sad.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(Intent paramIntent)
  {
    R();
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
  
  private void b(ArticleInfo paramArticleInfo)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.jdField_y_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (rqj.c(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!rqj.g(paramArticleInfo)) {
        localObject1 = ((qno)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qnm.a.get(0)).jdField_b_of_type_JavaLangString;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      P();
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, " url is null!");
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
        if (bdin.h(null)) {
          if (!((String)localObject2).contains("?")) {
            break label457;
          }
        }
      }
    }
    label457:
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
        if (paramBaseData.jdField_s_of_type_Int != 6) {
          break label215;
        }
        sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
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
            if (bdiv.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0")) {
              break label199;
            }
            nwh.a(nwh.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
          }
        }
        this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
        return;
      }
      catch (Exception paramBaseData)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      label199:
      nwh.a(nwh.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject, "2"));
      continue;
      label215:
      if (paramBaseData.jdField_s_of_type_Int == 26)
      {
        localObject = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)localObject).jdField_w_of_type_Int == 2)
        {
          sci.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          sci.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          sci.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          scn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, ((ProteusItemData)localObject).a);
        }
      }
      else
      {
        sdn.a(paramBaseData);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    int i2;
    if (this.jdField_a_of_type_Rzr != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Rzr.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Rzr.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Rzr.a().get(i1);
        if (((localBaseAdapter instanceof ola)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
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
      int i2 = this.jdField_a_of_type_Scb.a();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：finishOneByOne  size:" + i2);
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
      return scm.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
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
    if (!bkbq.o()) {
      return;
    }
    bkbq.e();
    this.jdField_a_of_type_AndroidWidgetImageView.postDelayed(new FastWebActivity.2(this), 200L);
  }
  
  private void i()
  {
    if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.3(this), 500L);
    }
  }
  
  private void j()
  {
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      this.jdField_e_of_type_JavaLangString = "";
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.clearAnimation();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
    }
    this.B = false;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.clearAnimation();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848990);
  }
  
  private void k()
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new rze(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new rzk(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131375865, 2131363422);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841376));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Aobw = new aobw(this, true, false, true, true, 0);
      this.jdField_a_of_type_Aobw.a(this);
      this.jdField_a_of_type_Aobw.a(new rzl(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Aobw.a(new rzm(this));
      this.jdField_a_of_type_Aobw.a(new rzn(this));
      this.jdField_a_of_type_Aobw.a(new rzo(this));
    } while (this.jdField_w_of_type_Boolean);
    this.jdField_a_of_type_Aobw.j();
  }
  
  private void m()
  {
    ors.jdField_f_of_type_Boolean = false;
    tah.a(4);
  }
  
  private void n()
  {
    ors.jdField_f_of_type_Boolean = false;
    ors.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void o()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131375961);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(ors.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131375335)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
      findViewById(2131368624).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363422));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131380357));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131167140));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131167140));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      p();
      this.jdField_a_of_type_Nor = new nor(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar);
      this.jdField_a_of_type_Bdbb = new bdbb(this, (QQAppInterface)ors.a());
      this.jdField_a_of_type_Bdbb.a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378714));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_d_of_type_AndroidViewView = findViewById(2131370093);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      q();
      r();
      findViewById(2131375805).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366279));
      this.jdField_a_of_type_Rzq = new rzq(this);
      y();
      s();
      V();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar = ((ReadInJoyCommonSoftAdBar)findViewById(2131376873));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar.bringToFront();
    odp.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar, this.jdField_a_of_type_Nor);
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376012));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370574));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370575));
    Drawable localDrawable = bdhj.a(this.jdField_b_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840799), -16777216);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
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
      v();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    try
    {
      t();
      sds.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a();
      this.jdField_a_of_type_JavaUtilList = owy.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        sds.a("HtmlChangeUtil.parse");
        if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
          this.jdField_a_of_type_AndroidUtilSparseArray = scl.a();
        }
        this.jdField_a_of_type_JavaUtilList = sdc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
        O();
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          throw new RuntimeException("parse data is empty!");
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "has parse error, use webview open url! e=" + localException);
      localHashMap.put("param_error", localException.toString());
      bool = false;
    }
    for (;;)
    {
      localHashMap.put("param_uin", ors.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      azri.a(BaseApplication.getContext()).a(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      Object localObject2;
      int i1;
      Object localObject3;
      if (!bool)
      {
        d(false);
        w();
        oxb.a().a(this.jdField_a_of_type_Oxe);
        nxa.a().a(5555, this);
        nxa.a().a(6666, this);
        d();
        new sft().a("native_article");
        X();
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initData,isParseSuccess=" + bool);
        return;
        this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData);
        this.jdField_a_of_type_JavaUtilList.add(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_JavaUtilList);
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          ((BaseData)localObject2).b = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          ((BaseData)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
        }
        sds.a("HtmlChangeUtil.parse");
        i1 = 0;
        sdi.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        this.jdField_t_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof ProteusItemData)))
          {
            localObject3 = (ProteusItemData)localObject2;
            if ((((ProteusItemData)localObject3).jdField_w_of_type_Int == 1) && ((((ProteusItemData)localObject3).jdField_v_of_type_Int == 1) || (((ProteusItemData)localObject3).jdField_v_of_type_Int == 2)) && (((BaseData)localObject2).jdField_s_of_type_Int != 0))
            {
              this.jdField_t_of_type_Int += 1;
              continue;
              if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = ((TitleData)this.jdField_a_of_type_JavaUtilList.get(0));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = ((AuthorData)this.jdField_a_of_type_JavaUtilList.get(1));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(false);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.c();
              }
              for (;;)
              {
                if ((this.jdField_k_of_type_Int != 1001) && (this.jdField_a_of_type_Scd == null)) {
                  sdi.d(this.jdField_a_of_type_JavaUtilList);
                }
                sdi.e(this.jdField_a_of_type_JavaUtilList);
                i1 = 1;
                break;
                aepi.a("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
              }
            }
          }
        }
        sds.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Rzr = new rzr();
        this.jdField_a_of_type_Sad = new sad(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Rzr);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Sad);
        this.jdField_a_of_type_Rzv = new rzv(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Bdbb);
        this.jdField_a_of_type_Rzv.registerDataSetObserver(new ryd(this));
        this.jdField_a_of_type_Rzr.a(this.jdField_a_of_type_Rzv);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
          u();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_Bicq);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bhtv);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Rzr);
        this.jdField_a_of_type_Rzr.a(this.jdField_a_of_type_Rzt);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131376295);
        W();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = owy.a().a();
        if (this.jdField_a_of_type_Scd != null)
        {
          localObject1 = this.jdField_a_of_type_Scd.jdField_a_of_type_AndroidOsParcelable;
          label1211:
          if (localObject1 == null) {
            break label1364;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          a(((AbsListView.SavedState)localObject1).jdField_b_of_type_Int);
          label1236:
          if ((this.jdField_k_of_type_Int == 1001) || (this.jdField_a_of_type_Scd != null)) {
            break label1425;
          }
        }
      }
      label1364:
      while (i1 == 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (BaseData)((Iterator)localObject1).next();
          if ((localObject3 instanceof ProteusBannerVideoItemData)) {
            ((ProteusBannerVideoItemData)localObject3).jdField_a_of_type_Boolean = false;
          }
        }
        if (localObject2 == null) {
          break label1432;
        }
        ((pfo)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pfq, true);
        break label1432;
        if (localObject2 != null)
        {
          localObject1 = ((pfo)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
          break label1211;
          a(0);
          break label1236;
          d(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          oxb.a().a(this.jdField_b_of_type_Oxe);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_a_of_type_Boolean = false;
          break;
        }
        localObject1 = null;
        break label1211;
      }
      label1425:
      label1432:
      bool = true;
    }
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_e_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_e_of_type_JavaLangString;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.s;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initArticleInfo, update url,url=" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    }
  }
  
  private void u()
  {
    String str = null;
    this.jdField_a_of_type_Ola = new ola(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Ola.a(new rye(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Ola.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Ola.a(new ryg(this));
      this.jdField_a_of_type_Rzr.a(this.jdField_a_of_type_Ola);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new ryh(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new ryi(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131376295, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void v()
  {
    pfo localpfo = owy.a().a();
    if (localpfo == null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        w();
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "fastWebModule == null");
      return;
    }
    localpfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Pfr);
  }
  
  private void w()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_l_of_type_Boolean = true;
    oxb.a().a(this.jdField_b_of_type_Oxe);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new ryj(this));
    nrt.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_j_of_type_Int), "", false);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new ryk(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void y()
  {
    View localView = findViewById(2131372977);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void z()
  {
    A();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public ReadInJoyCommonSoftAdBar a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdSoft_adReadInJoyCommonSoftAdBar;
  }
  
  public nor a()
  {
    return this.jdField_a_of_type_Nor;
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
    scm.a(this.jdField_a_of_type_JavaUtilList, paramFloat);
    this.jdField_a_of_type_Rzr.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131370093).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772011);
      localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_e_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 1;
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
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "generateBiuArticleInfo fail !");
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    if (this.jdField_a_of_type_Rzv != null) {
      this.jdField_a_of_type_Rzv.d();
    }
    this.jdField_r_of_type_Boolean = false;
    scd localscd = new scd();
    localscd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localscd.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localscd.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localscd.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localscd.jdField_a_of_type_Boolean = this.jdField_m_of_type_Boolean;
    localscd.jdField_a_of_type_Sac = this.jdField_a_of_type_Sac;
    this.jdField_a_of_type_Scb.a(localscd);
    this.jdField_c_of_type_JavaLangString = (ors.a() + System.currentTimeMillis());
    b(paramIntent);
    this.jdField_r_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_r_of_type_Boolean = false;
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.35(this, paramBaseData));
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
    osk.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_p_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        sdn.a(localArticleInfo1, "0X800898C", ors.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Syq == null) {
          this.jdField_a_of_type_Syq = new syq(this, this.app, null, new rzp(this));
        }
        this.jdField_a_of_type_Syq.a.setActionSheetTitle("biu出去让更多好友看到");
        this.jdField_a_of_type_Syq.a.setOnDismissListener(new ryl(this));
        if ((!this.B) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))) {
          break;
        }
        this.jdField_a_of_type_Syq.a(a(), true);
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
      sdn.a(localArticleInfo1, "0X8008993", ors.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
    this.jdField_a_of_type_Syq.a(a());
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772330, 2130772329);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null)) {
        this.jdField_a_of_type_Aobw.j();
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, 1);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      this.jdField_a_of_type_Osk.b();
      c(8);
      return;
    }
    if ((this.jdField_w_of_type_Boolean) && (this.jdField_a_of_type_Aobw != null)) {
      this.jdField_a_of_type_Aobw.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Osk.a();
    paramString1 = getSupportFragmentManager().beginTransaction();
    paramString1.setCustomAnimations(paramInt1, paramInt2);
    paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    paramString1.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_Rzr.notifyDataSetChanged();
    c(0);
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = bhsz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
    if (((Map)localObject).containsKey("_wv")) {}
    for (;;)
    {
      try
      {
        int i1 = Integer.valueOf((String)((Map)localObject).get("_wv")).intValue();
        if (!((Map)localObject).containsKey("_wwv")) {
          break label563;
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
          ((List)localObject).add(Integer.valueOf(1));
          if ((i1 & 0x8) == 0L) {
            ((List)localObject).add(Integer.valueOf(2));
          }
          if ((i1 & 0x10) == 0L) {
            ((List)localObject).add(Integer.valueOf(3));
          }
          if ((i1 & 0x4000) == 0L) {
            ((List)localObject).add(Integer.valueOf(4));
          }
          if ((i1 & 0x8000) == 0L) {
            ((List)localObject).add(Integer.valueOf(5));
          }
          ((List)localObject).add(Integer.valueOf(6));
          ((List)localObject).add(Integer.valueOf(7));
          if ((i1 & 0x100) == 0L) {
            ((List)localObject).add(Integer.valueOf(8));
          }
          localArrayList = new ArrayList();
          if ((!TextUtils.isEmpty(localAppRuntime.getAccount())) && ((i1 & 0x2000) == 0L)) {
            localArrayList.add(Integer.valueOf(12));
          }
          localArrayList.add(Integer.valueOf(9));
          localArrayList.add(Integer.valueOf(10));
          localArrayList.add(Integer.valueOf(13));
          if ((i1 & 0x20) == 0L) {
            localArrayList.add(Integer.valueOf(14));
          }
          localArrayList.add(Integer.valueOf(20));
          Collections.sort(localArrayList);
          if (((i2 & 0x4000) == 0L) && (bagk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
          {
            i2 = localArrayList.indexOf(Integer.valueOf(12));
            i1 = i2;
            if (i2 < 0) {
              i1 = localArrayList.indexOf(Integer.valueOf(14));
            }
            if (i1 >= 0)
            {
              if (i1 >= localArrayList.size() - 1) {
                break label568;
              }
              localArrayList.add(i1 + 1, Integer.valueOf(28));
              bagk.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Aobw != null) && (this.jdField_a_of_type_Aobw.a()) && (this.jdField_w_of_type_Boolean))
          {
            if (!this.jdField_a_of_type_Aobw.c()) {
              break label584;
            }
            localArrayList.add(0, Integer.valueOf(33));
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ： open sheet delete colorNote");
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
      label563:
      int i2 = 0;
      continue;
      label568:
      localNumberFormatException2.add(Integer.valueOf(28));
      continue;
      label584:
      localNumberFormatException2.add(0, Integer.valueOf(32));
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ： open sheet add colorNote");
    }
  }
  
  protected void b()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (localObject2 != null)
    {
      Object localObject3 = ((ArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new qlv();
      localReportInfo.mUin = ors.a();
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
        ((qlv)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qme != null) {
          ((qlv)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qme.jdField_a_of_type_Long;
        }
        ((qlv)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((qlv)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((qlv)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (qme)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((qlv)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qme)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((qlv)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    owy.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      sdi.b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Rzr.notifyDataSetChanged();
      return;
    }
    sdi.c(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rzr.notifyDataSetChanged();
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
    Object localObject = new olw(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | begin");
    if (this.jdField_s_of_type_Boolean)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2CommentArea");
      if (this.jdField_q_of_type_Int == 0)
      {
        nrt.a((QQAppInterface)getAppInterface(), olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_s_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int);
      this.jdField_s_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      ((olw)localObject).d(1);
      this.jdField_a_of_type_Osk.a();
      localObject = ((olw)localObject).a();
      nrt.a((QQAppInterface)getAppInterface(), olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
    }
    for (;;)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | done");
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_o_of_type_Int, this.jdField_p_of_type_Int);
      this.jdField_s_of_type_Boolean = true;
      ((olw)localObject).d(2);
      localObject = ((olw)localObject).a();
      nrt.a((QQAppInterface)getAppInterface(), olt.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Osk.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Rzv != null) {}
    for (int i1 = this.jdField_a_of_type_Rzv.getCount();; i1 = 0)
    {
      this.jdField_q_of_type_Int = i1;
      this.jdField_r_of_type_Int = 0;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_q_of_type_Int);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Syq != null) && (this.jdField_a_of_type_Syq.a())) {}
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
    if (Build.VERSION.SDK_INT >= 11) {
      getWindow().setFlags(16777216, 16777216);
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null) {
      if (paramBundle != null)
      {
        localBundle = paramBundle.getBundle("bundle_key_save_instancestate");
        if (localBundle == null)
        {
          aepi.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
          finish();
          return true;
        }
        azri.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)localBundle.get("fast_web_article_info"));
      this.jdField_d_of_type_Int = localBundle.getInt("fast_web_from_channel_id");
      this.jdField_t_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "is from colorNote : " + this.jdField_t_of_type_Boolean);
      this.jdField_w_of_type_Boolean = aoft.a();
      Object localObject;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        localObject = localBundle.getBundle("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
          this.jdField_e_of_type_Int = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
          this.jdField_k_of_type_Int = 1001;
          this.jdField_m_of_type_Boolean = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
        }
      }
      else
      {
        this.jdField_j_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
        this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        this.jdField_c_of_type_JavaLangString = (ors.a() + System.currentTimeMillis());
        localObject = getSupportFragmentManager();
        if ((paramBundle == null) || (localObject == null)) {
          break label435;
        }
        paramBundle = ((FragmentManager)localObject).getFragments();
        if ((paramBundle == null) || (paramBundle.size() <= 0)) {
          break label435;
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
      label435:
      nrt.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_j_of_type_Int), "", false);
      try
      {
        setContentView(2131560011);
        o();
        if (this.jdField_a_of_type_Rzv != null) {
          this.jdField_a_of_type_Rzv.a();
        }
        k();
        l();
        this.jdField_a_of_type_AndroidUtilSparseArray = scl.a();
        this.jdField_e_of_type_JavaLangString = a(localBundle.getString("float_layer_article_url"));
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, " redpackId: " + this.jdField_e_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView = ((RIJRedPacketProgressView)findViewById(2131375560));
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView = ((RIJRedPacketPopupView)findViewById(2131375562));
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView = new RIJRedPacketPopupView(this);
        paramBundle = getWindow().getDecorView();
        if ((paramBundle instanceof ViewGroup))
        {
          ((ViewGroup)paramBundle).addView(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView);
          if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams() != null)
          {
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams().height = -2;
            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getLayoutParams().width = -2;
          }
        }
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setVisibility(4);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131375805));
        return true;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          BaseApplicationImpl.sImageCache.evict(0);
          try
          {
            setContentView(2131560011);
            o();
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
      osk.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Ola != null) && (this.jdField_a_of_type_Ola.a() != null))
      {
        localObject = this.jdField_a_of_type_Ola.a();
        ((olq)localObject).a(this.jdField_a_of_type_Osk.b(), this.jdField_s_of_type_Int);
        ((olq)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Rzv.getCount());
      }
    }
    oxb.a().b(this.jdField_b_of_type_Oxe);
    oxb.a().b(this.jdField_a_of_type_Oxe);
    if (this.jdField_a_of_type_Rzv != null) {
      this.jdField_a_of_type_Rzv.d();
    }
    if (this.jdField_a_of_type_Rzr != null) {
      this.jdField_a_of_type_Rzr.a();
    }
    if (this.jdField_a_of_type_Ola != null) {
      this.jdField_a_of_type_Ola.d();
    }
    I();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Zfy != null) {
      this.jdField_a_of_type_Zfy.c();
    }
    this.jdField_a_of_type_Zfy = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Sdq != null) {
      this.jdField_a_of_type_Sdq.a();
    }
    if (this.jdField_a_of_type_Syq != null) {
      this.jdField_a_of_type_Syq.b();
    }
    sdj.a();
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.a(null);
      this.jdField_a_of_type_Bdbb = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    qzy.a().jdField_b_of_type_Boolean = false;
    Object localObject = owy.a().a();
    if (localObject != null) {
      ((pfo)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_Nor != null) {
      this.jdField_a_of_type_Nor.b();
    }
    A();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_c_of_type_Boolean) {
        aijf.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Scx.a();
    this.jdField_a_of_type_Scx = null;
    nxa.a().b(5555, this);
    nxa.a().b(6666, this);
    if (this.jdField_a_of_type_Aobw != null)
    {
      this.jdField_a_of_type_Aobw.c();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Oik != null) {
      this.jdField_a_of_type_Oik.a();
    }
    a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
          if (this.jdField_a_of_type_Sdq == null) {
            this.jdField_a_of_type_Sdq = new sdq(this);
          }
          this.jdField_a_of_type_Sdq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Sdq.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
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
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null) || (this.jdField_l_of_type_Boolean)) {
      return;
    }
    AbstractGifImage.pauseAll();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      localObject1 = "2";
    }
    for (;;)
    {
      localObject1 = ors.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + sdn.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_c_of_type_JavaLangString);
        sdn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_r_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", ors.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.3.5".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!szp.a(this.jdField_b_of_type_Long)) {
            break label724;
          }
          localObject1 = "0X8009359";
          nrt.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_j_of_type_Int), (String)localObject2, false);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            QLog.e("Q.readinjoy.fast_web", 2, localJSONException, new Object[] { "0X80066FB!" });
            continue;
            int i1 = 0;
          }
        }
        localObject1 = new ArrayList();
        localObject2 = new ReportInfo();
        ((ReportInfo)localObject2).mUin = ors.a();
        ((ReportInfo)localObject2).mSource = 0;
        ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_Long;
        ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_b_of_type_Long);
        ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_f_of_type_Long);
        ((ReportInfo)localObject2).mStrategyId = this.jdField_j_of_type_Int;
        ((ReportInfo)localObject2).mOperation = 9;
        ((ReportInfo)localObject2).mOpSource = 12;
        ((ReportInfo)localObject2).mReadTimeLength = ((int)(l1 / 1000L));
        ((ReportInfo)localObject2).mInnerId = this.jdField_a_of_type_JavaLangString;
        i1 = b();
        ((ReportInfo)localObject2).mArticleLength = i1;
        ((ReportInfo)localObject2).mReadArticleLength = ((int)(i1 * a()));
        ((List)localObject1).add(localObject2);
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.18(this, (List)localObject1));
        if (this.jdField_a_of_type_Rzv != null) {
          this.jdField_a_of_type_Rzv.c();
        }
        if (ors.jdField_g_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Aobw != null)
        {
          this.jdField_a_of_type_Aobw.b();
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onPause");
        }
        if ((this.jdField_k_of_type_Int == 1001) && (!otf.c(this.jdField_e_of_type_Int)))
        {
          i1 = 1;
          if (((ReadinjoyTabFrame.c_()) || (i1 != 0)) && (RIJRedPacketManager.a().c()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.getVisibility() == 0)) {
            L();
          }
          this.jdField_w_of_type_Int = 0;
          return;
          localObject1 = "1";
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label724:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    int i2 = 0;
    if (!this.jdField_r_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_r_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    sds.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Rzr != null) {
      this.jdField_a_of_type_Rzr.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Rzv != null) {
      this.jdField_a_of_type_Rzv.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      osk.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      owy.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (ors.jdField_g_of_type_Boolean)
    {
      if (ors.jdField_f_of_type_Boolean) {
        ors.a(4, this.jdField_c_of_type_Long);
      }
      n();
    }
    m();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_Aobw != null)
    {
      this.jdField_a_of_type_Aobw.a();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.c();
    }
    this.jdField_w_of_type_Int = 0;
    this.jdField_x_of_type_Int = 0;
    int i1 = i2;
    if (this.jdField_k_of_type_Int == 1001)
    {
      i1 = i2;
      if (!otf.c(this.jdField_e_of_type_Int)) {
        i1 = 1;
      }
    }
    if (((ReadinjoyTabFrame.c_()) || (i1 != 0)) && (RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e()))
    {
      RIJRedPacketManager.a().a(1, new ryb(this));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketProgressView.setVisibility(8);
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
      osk.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Osk.b();
    }
    if ((isFinishing()) || (this.jdField_r_of_type_Boolean))
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "fastwebActivity doOnStop | removeCommentDataManager");
      omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
    sdi.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rzr.notifyDataSetChanged();
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
      if ((!bdep.b()) && (!bdep.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
    {
      b(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!bdep.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void finish()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mFloating ：finish");
    if ((this.jdField_u_of_type_Boolean) && (!this.jdField_v_of_type_Boolean))
    {
      C();
      return;
    }
    if (this.jdField_a_of_type_Scb.a())
    {
      if (this.jdField_a_of_type_Aobw == null) {
        d(this);
      }
      if ((this.jdField_y_of_type_Boolean) && (this.jdField_w_of_type_Boolean) && (this.A) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_v_of_type_Boolean))
      {
        D();
        return;
      }
      if ((this.jdField_a_of_type_Aobw != null) && (!this.jdField_v_of_type_Boolean))
      {
        C();
        return;
      }
      if (this.jdField_k_of_type_Int == 1001)
      {
        if (this.jdField_e_of_type_Int != 70) {
          break label263;
        }
        KandianSubscribeManager.a(this, 2);
      }
      if (this.jdField_g_of_type_Long != 0L) {
        sdn.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_k_of_type_Boolean = true;
    H();
    J();
    E();
    oxb.a().b(this.jdField_b_of_type_Oxe);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label213:
      if (!this.jdField_o_of_type_Boolean) {
        break label345;
      }
    }
    label263:
    label345:
    for (String str2 = "1";; str2 = "2")
    {
      nrt.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      Q();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mFloating ：finish over");
      return;
      if (this.jdField_e_of_type_Int == 0)
      {
        nxu.a(this.app, this, 11, 0);
        break;
      }
      if (otf.c(this.jdField_e_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bkbq.i()) {
        break;
      }
      nxu.b(this, 11);
      break;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label213;
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
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370575));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 10922)
    {
      if ((paramInt2 == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        ors.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
      }
      return;
      break label631;
    }
    label631:
    do
    {
      Object localObject1;
      do
      {
        do
        {
          do
          {
            do
            {
              boolean bool;
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      while (paramInt1 == 10923) {
                        if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Scd == null))
                        {
                          finish();
                          return;
                        }
                      }
                      if ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != -1)) {
                        break;
                      }
                      localObject1 = paramIntent.getStringExtra("arg_result_json");
                      paramInt1 = paramIntent.getIntExtra("click_comment_edit_src", -1);
                      paramIntent = omz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = this.jdField_b_of_type_JavaLangString;
                        localObject1 = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.jdField_a_of_type_JavaUtilList != null) {}
                        for (bool = true;; bool = false)
                        {
                          aepi.a(paramIntent, bool, new NullPointerException());
                          return;
                        }
                      }
                    } while (this.jdField_a_of_type_Ola == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.d((String)localObject1, this.jdField_a_of_type_Ola.b());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.c((String)localObject1, this.jdField_a_of_type_Ola.b());
                  return;
                  if ((paramInt1 != 1001) || (paramIntent == null)) {
                    break;
                  }
                  paramIntent = paramIntent.getSerializableExtra("backToImageData");
                } while (!(paramIntent instanceof List));
                paramIntent = (List)paramIntent;
              } while (paramIntent.isEmpty());
              ThreadManager.getUIHandler().post(new FastWebActivity.29(this, paramIntent));
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
              return;
              if (paramInt1 == 2002)
              {
                if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
                {
                  paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
                  paramIntent.jdField_c_of_type_Long += 1L;
                  ThreadManager.getUIHandler().post(new FastWebActivity.30(this));
                }
                paramIntent = getAppInterface();
                localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  sdn.a(this, paramIntent, (ArticleInfo)localObject1, 0, -1, false, bool, this.C);
                  return;
                }
              }
              if (paramInt1 == 1)
              {
                if (RIJRedPacketManager.a().e())
                {
                  localObject2 = "";
                  localObject1 = localObject2;
                  if (paramIntent != null)
                  {
                    localObject1 = localObject2;
                    if (paramIntent.getExtras() != null) {
                      localObject1 = a(paramIntent.getExtras().getString("detail_url"));
                    }
                  }
                  QLog.i(this.jdField_b_of_type_JavaLangString, 1, "resultCode: " + paramInt2 + "\nafter share article content, packetId: " + (String)localObject1);
                  if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                    RIJRedPacketManager.a().a(new ryv(this));
                  }
                }
                paramIntent = getAppInterface();
                localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  sdn.a(this, paramIntent, (ArticleInfo)localObject1, 1, -1, false, bool, this.C);
                  return;
                }
              }
              if (paramInt1 != 9999) {
                break;
              }
            } while ((paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getParcelableExtra("key_ad_info");
          } while ((!(paramIntent instanceof AdData)) || (this.jdField_a_of_type_JavaUtilList == null));
          paramIntent = ((AdData)paramIntent).u;
        } while (TextUtils.isEmpty(paramIntent));
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!((Iterator)localObject1).hasNext());
      Object localObject2 = (BaseData)((Iterator)localObject1).next();
      if ((!(localObject2 instanceof AdData)) || (!paramIntent.equals(((AdData)localObject2).u))) {
        break;
      }
      a((BaseData)localObject2);
      QQToast.a(this, -1, getString(2131700055), 0).b(getTitleBarHeight());
      return;
    } while ((paramInt1 != 117) || (paramIntent == null) || (paramInt2 != 1699));
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Oik, 1, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Ola.b(), paramInt1);
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "back from biuAndComment");
      return;
    }
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
    if ((paramView.getId() != 2131368624) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368624: 
      this.jdField_o_of_type_Boolean = true;
      finish();
      return;
    case 2131375805: 
      a(true);
      return;
    case 2131368670: 
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
      return;
    }
    a(false, null, null);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount())
      {
        sah localsah = (sah)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localsah != null) {
          localsah.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onGoToConversation..");
    }
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.44(this));
  }
  
  public void onOpenMiniAIOCallback()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onOpenMiniAIOCallback..");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null))
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 2, "onOpenMiniAIOCallback mMiniMsgUser == null || mArticleInfo == null || mFastWebInfo == null");
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_b_of_type_Boolean = true;
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam();
        ((MiniMsgUserParam)localObject).backConversationIntent = ors.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_d_of_type_Int, this.jdField_m_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          sdn.a(localArticleInfo1, "0X800A09C", ors.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label230;
          }
          localObject = "2";
          sdn.a(localArticleInfo1, "0X800A09D", ors.a(this, localArticleInfo2, i1, (String)localObject).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "onOpenMiniAIOCallback Exception = " + localException);
        return;
      }
      String str = "1";
      continue;
      label230:
      str = "1";
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    a(paramBundle);
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "onSaveInstanceState(Bundle outState)");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onSaveInstanceState(Bundle paramBundle, PersistableBundle paramPersistableBundle)
  {
    a(paramBundle);
    QLog.e(this.jdField_b_of_type_JavaLangString, 2, "onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)");
    super.onSaveInstanceState(paramBundle, paramPersistableBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */