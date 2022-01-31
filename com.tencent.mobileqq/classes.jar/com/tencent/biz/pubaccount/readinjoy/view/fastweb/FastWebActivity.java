package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import actn;
import aggn;
import amgo;
import amkn;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
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
import android.text.SpannableString;
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
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import axrl;
import ayec;
import baxk;
import baxl;
import bbay;
import bbct;
import bbdr;
import bbev;
import bbjc;
import bcpw;
import bfng;
import bfob;
import bfqv;
import bfwv;
import bhvh;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
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
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFastWebBottomSocialViewNew;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
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
import nly;
import noo;
import nty;
import nua;
import nut;
import obr;
import ogq;
import ohf;
import ohh;
import ohi;
import ohk;
import ohl;
import oio;
import onk;
import ooc;
import oox;
import org.json.JSONException;
import org.json.JSONObject;
import osj;
import osm;
import oso;
import osp;
import pai;
import pak;
import pal;
import qcc;
import qcj;
import qcl;
import qdt;
import qdv;
import qku;
import rap;
import ril;
import rim;
import rin;
import rio;
import rip;
import riq;
import rir;
import ris;
import rit;
import riu;
import riv;
import riw;
import rix;
import riy;
import rja;
import rjb;
import rjc;
import rjd;
import rje;
import rjf;
import rjg;
import rjh;
import rji;
import rjj;
import rjk;
import rjl;
import rjm;
import rjn;
import rjo;
import rjq;
import rjr;
import rjs;
import rju;
import rjw;
import rjz;
import rke;
import rkf;
import rkh;
import rkj;
import rmc;
import rmi;
import rmk;
import rmn;
import rmq;
import rmr;
import rms;
import rnb;
import rng;
import rnm;
import rnn;
import rnr;
import rnu;
import rnx;
import rpx;
import sgy;
import shc;
import shx;
import sip;
import vpp;
import xmt;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, baxl, MiniMsgUser.IMiniMsgActionCallback, nua, obr, ohh, ohk, shc
{
  private boolean A = true;
  private float jdField_a_of_type_Float = bbct.d() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private amgo jdField_a_of_type_Amgo;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private baxk jdField_a_of_type_Baxk;
  bfob jdField_a_of_type_Bfob = new rix(this);
  private bfwv jdField_a_of_type_Bfwv = new rja(this);
  private ReadInJoyCommentListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView;
  private ReadInJoyCommentTopGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout;
  private ReadInJoySecondCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment;
  private AnchorData jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData;
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
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  Set<BaseData> jdField_a_of_type_JavaUtilSet = new HashSet();
  private nly jdField_a_of_type_Nly;
  private ogq jdField_a_of_type_Ogq;
  private ooc jdField_a_of_type_Ooc = new ooc();
  osp jdField_a_of_type_Osp = new rjf(this);
  private pak jdField_a_of_type_Pak = new rje(this);
  private pal jdField_a_of_type_Pal = new rjd(this);
  private rjr jdField_a_of_type_Rjr;
  private rjs jdField_a_of_type_Rjs;
  rju jdField_a_of_type_Rju = new rji(this);
  private rjw jdField_a_of_type_Rjw;
  private rke jdField_a_of_type_Rke;
  private rkf jdField_a_of_type_Rkf;
  private rmi jdField_a_of_type_Rmi = new rmi(this);
  private rmk jdField_a_of_type_Rmk;
  private rnb jdField_a_of_type_Rnb = new rnb();
  private rnu jdField_a_of_type_Rnu;
  private sgy jdField_a_of_type_Sgy;
  private xmt jdField_a_of_type_Xmt;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = bbct.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new rjh(this);
  private SpannableString jdField_b_of_type_AndroidTextSpannableString;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "FastWebActivity";
  private osp jdField_b_of_type_Osp = new riy(this);
  public boolean b;
  private float jdField_c_of_type_Float = 1.5F;
  private int jdField_c_of_type_Int;
  long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString = System.currentTimeMillis() + "";
  public boolean c;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
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
  private int jdField_j_of_type_Int = 1000;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
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
  private int jdField_r_of_type_Int = 1;
  private boolean jdField_r_of_type_Boolean = true;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean;
  private int jdField_u_of_type_Int = -1;
  private boolean jdField_u_of_type_Boolean;
  private boolean v = true;
  private boolean w;
  private boolean x;
  private boolean y;
  private boolean z = true;
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new rjg(this);
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
    if ((this.jdField_a_of_type_Rkf == null) || ((this.jdField_a_of_type_Rjw != null) && (this.jdField_a_of_type_Rjw.getCount() != this.jdField_a_of_type_Rkf.a())))
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
    label261:
    float f1;
    if (i3 > this.jdField_e_of_type_Int)
    {
      i1 = 1;
      if (this.jdField_a_of_type_Rkf != null)
      {
        if (this.jdField_e_of_type_Int <= i3) {
          break label316;
        }
        i2 = this.jdField_e_of_type_Int;
        this.jdField_e_of_type_Int = i2;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        i2 = this.jdField_e_of_type_Int - i2;
        if ((i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_e_of_type_Int < this.jdField_a_of_type_Rkf.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(i2);
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i4 = ((View)localObject).getTop();
          this.jdField_g_of_type_Int = (this.jdField_a_of_type_Rkf.a(this.jdField_e_of_type_Int) - (i2 - i4));
          if (i1 == 0) {
            break label322;
          }
          this.jdField_f_of_type_Int = this.jdField_g_of_type_Int;
          if (this.jdField_f_of_type_Int < 0) {
            this.jdField_f_of_type_Int = 0;
          }
          QLog.d("Q.readinjoy.fast_web", 2, "  mMaxLastPosition  " + this.jdField_e_of_type_Int + "  mMaxLastItemInvisibleHeight " + this.jdField_f_of_type_Int);
        }
      }
      i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
      i4 = this.jdField_a_of_type_JavaUtilList.size();
      i1 = 0;
      if (i2 > i3) {
        break label396;
      }
      if (i2 >= i4) {
        break label388;
      }
      f1 = BaseData.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2));
      if (f1 > rnr.jdField_a_of_type_ArrayOfFloat[0]) {
        break label354;
      }
      i1 |= 0x1;
    }
    label316:
    label322:
    label465:
    label471:
    for (;;)
    {
      i2 += 1;
      break label261;
      i1 = 0;
      break label62;
      i2 = i3;
      break label83;
      if (this.jdField_g_of_type_Int < this.jdField_f_of_type_Int) {}
      for (i1 = this.jdField_g_of_type_Int;; i1 = this.jdField_f_of_type_Int)
      {
        this.jdField_f_of_type_Int = i1;
        break;
      }
      label354:
      if (f1 <= rnr.jdField_a_of_type_ArrayOfFloat[1])
      {
        i1 |= 0x2;
      }
      else if (f1 <= rnr.jdField_a_of_type_ArrayOfFloat[2])
      {
        i1 |= 0x4;
        continue;
        i1 |= 0x8;
        continue;
        localObject = rnr.jdField_a_of_type_ArrayOfInt;
        i4 = localObject.length;
        i2 = 0;
        Integer localInteger;
        if (i2 < i4)
        {
          localInteger = Integer.valueOf(localObject[i2]);
          if ((1 << localInteger.intValue() & i1) == 0) {
            break label465;
          }
          i3 = 1;
          if (i3 == 0) {
            break label471;
          }
          ooc.b(rnr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
        for (;;)
        {
          i2 += 1;
          break label408;
          break;
          i3 = 0;
          break label438;
          ooc.c(rnr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
      }
    }
  }
  
  private void D()
  {
    this.jdField_u_of_type_Boolean = true;
    this.jdField_a_of_type_Amgo.d();
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：exitAnimation");
  }
  
  private void E()
  {
    this.jdField_u_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(0, 4);
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mFloating doClostAnimTopToBottom ");
  }
  
  private void F()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        pai localpai = ((oso)this.app.getManager(163)).a().a();
        if (localpai != null) {
          localpai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
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
      if (localBaseData.jdField_p_of_type_Int == 6) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (AdData.a(localBaseData))
        {
          localArrayList.add(new rkh(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new riu(this, i1, localBaseData));
        }
        else if (rnr.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new riv(this, localBaseData));
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
        if (a(localBaseData.jdField_p_of_type_Int)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new riw(this, localBaseData));
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
            rnr.b(this.app, (AdData)localBaseData);
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
  
  private void J()
  {
    int i1 = b();
    rnr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_u_of_type_Int);
    if (this.jdField_a_of_type_Rjw != null) {
      this.jdField_a_of_type_Rjw.e();
    }
  }
  
  private void K()
  {
    long l1 = rnx.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_k_of_type_Boolean) {
      bool = false;
    }
    long l2 = rnx.c("fast_web_show_light_house_2");
    long l3 = rnx.c("fast_web_show_light_house_3");
    long l4 = rnx.c("fast_web_show_light_house_draw_finish");
    long l5 = rnx.c("fast_web_show_light_house_step4_2");
    long l6 = rnx.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", onk.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    axrl.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void L()
  {
    this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(0);
    int i1;
    boolean bool1;
    boolean bool2;
    if (localView == null)
    {
      i1 = 0;
      this.jdField_l_of_type_Int = i1;
      this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition();
      bool1 = b(this.jdField_k_of_type_Int);
      bool2 = b(this.jdField_m_of_type_Int);
      if ((bool1) || (bool2)) {
        break label101;
      }
      this.jdField_n_of_type_Int = this.jdField_k_of_type_Int;
      this.jdField_o_of_type_Int = this.jdField_l_of_type_Int;
      this.jdField_r_of_type_Boolean = true;
    }
    label101:
    do
    {
      return;
      i1 = localView.getTop();
      break;
      if ((bool1) && (bool2))
      {
        this.jdField_p_of_type_Int = this.jdField_k_of_type_Int;
        this.jdField_q_of_type_Int = this.jdField_l_of_type_Int;
        this.jdField_r_of_type_Boolean = false;
        this.jdField_f_of_type_Boolean = true;
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "upCmtHisPos mCommentAreaLastFirstVisItemPos = " + this.jdField_p_of_type_Int);
        return;
      }
    } while ((bool1) || (!bool2));
    this.jdField_r_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_n_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "2area show together initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_p_of_type_Int);
    d();
  }
  
  private void M()
  {
    try
    {
      rmq.b(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      rmq.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void N()
  {
    rmr.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void O()
  {
    if (this.jdField_a_of_type_Rmi.a()) {}
    rmk localrmk;
    do
    {
      return;
      this.jdField_q_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      J();
      this.jdField_q_of_type_Boolean = false;
      localrmk = this.jdField_a_of_type_Rmi.a();
    } while (localrmk == null);
    a(localrmk);
    this.jdField_q_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_q_of_type_Boolean = false;
  }
  
  private void P()
  {
    this.jdField_a_of_type_Rmk = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_Rkf = null;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = null;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = (System.currentTimeMillis() + "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_Bfob);
    pai localpai = osj.a().a();
    if (localpai != null)
    {
      localpai.a(this.jdField_a_of_type_Pak);
      localpai.a(this.jdField_a_of_type_Pal);
    }
    this.jdField_h_of_type_Int = 0;
  }
  
  private void Q()
  {
    onk.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Rmi.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str, 2, bool);
      this.jdField_a_of_type_Rmi.a(new rjc(this));
      return;
    }
  }
  
  private void R()
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.36(this));
  }
  
  private void S()
  {
    Object localObject = getIntent();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((Intent)localObject).getExtras();
    } while (localObject == null);
    this.y = ((Bundle)localObject).getBoolean("launch_from_floating_window", false);
    if (this.y)
    {
      this.z = ((Bundle)localObject).getBoolean("scroll_to_top", true);
      this.A = ((Bundle)localObject).getBoolean("up_animation", true);
      this.jdField_u_of_type_Int = ((Bundle)localObject).getInt("floating_window_scene", -1);
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "mFloating initFloatingWindow,isFromFloatingLayer=" + this.y + "  isSuctionTop=" + this.z);
  }
  
  private void T()
  {
    int i1 = (int)(onk.a(this)[0] / 16.0F * 9.0F);
    if ((i1 > 0) && (this.jdField_c_of_type_AndroidViewView != null) && ((this.jdField_c_of_type_AndroidViewView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      ((RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).topMargin = i1;
    }
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_Rkf == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_e_of_type_Int <= 0) {
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
    return a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Rkf == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Rkf.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Rkf.a(i1);
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
      this.jdField_h_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_g_of_type_Int);
    }
    for (;;)
    {
      return this.jdField_h_of_type_Int;
      if (this.jdField_h_of_type_Int == 0) {
        this.jdField_h_of_type_Int = a(paramAbsListView.getLastVisiblePosition(), this.jdField_g_of_type_Int);
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
      localArticleInfo.businessId = ((rjz)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj = new qcj();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcj.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private void a(int paramInt)
  {
    rmc.a().a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_a_of_type_Long, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.30(this), paramLong);
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
  
  private void a(ArticleInfo paramArticleInfo)
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, " url: " + paramArticleInfo.mArticleContentUrl);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.y)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a();
    }
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (rap.b(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!rap.f(paramArticleInfo)) {
        localObject1 = ((qdv)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qdt.a.get(0)).jdField_b_of_type_JavaLangString;
      }
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
        if (bbev.h(null)) {
          if (!((String)localObject2).contains("?")) {
            break label434;
          }
        }
      }
    }
    label434:
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
      localObject = onk.a(this, paramArticleInfo, i1, (String)localObject);
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("comment", paramFastWebArticleInfo.jdField_b_of_type_Long);
        if (!this.jdField_s_of_type_Boolean) {
          continue;
        }
        i1 = 1;
        ((JSONObject)localObject).put("click_src", i1);
        if ((this.y) && (this.jdField_u_of_type_Int != -1)) {
          ((JSONObject)localObject).put("source_extratype", this.jdField_u_of_type_Int);
        }
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      rnr.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
      b();
      return;
      localObject = "1";
      break;
      i1 = 0;
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt, boolean paramBoolean)
  {
    this.jdField_b_of_type_Int = paramInt;
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
        } while (((!paramBoolean) && ((f1 < this.jdField_a_of_type_Float) || (f1 > this.jdField_b_of_type_Float))) || (this.jdField_b_of_type_Int > paramInt) || (paramInt >= paramAbsListView.getCount() - 1));
        this.jdField_b_of_type_Int = paramInt;
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
  
  private void a(rmk paramrmk)
  {
    P();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramrmk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Rmk = paramrmk;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Rmk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_m_of_type_Boolean = paramrmk.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Rke = paramrmk.jdField_a_of_type_Rke;
    s();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.o.equals(paramString)))
    {
      paramString = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext())
      {
        BaseData localBaseData = (BaseData)paramList2.next();
        if (localBaseData.jdField_e_of_type_Boolean) {
          paramString.add(localBaseData);
        } else {
          localArrayList.add(localBaseData);
        }
      }
      rnm.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      rnm.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = osj.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      G();
      rnm.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Rjs.notifyDataSetChanged();
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "adback initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_p_of_type_Int);
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
    if (this.jdField_a_of_type_Rkf == null)
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
      if (rmr.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Rkf.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(Intent paramIntent)
  {
    P();
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
  
  private void b(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (this.jdField_a_of_type_JavaUtilSet.contains(paramBaseData)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramBaseData.jdField_p_of_type_Int == 6)
        {
          rnr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramBaseData);
          this.jdField_a_of_type_JavaUtilSet.add(paramBaseData);
          return;
        }
      }
      catch (Exception paramBaseData)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doExposure error! msg=" + paramBaseData);
        return;
      }
      if (paramBaseData.jdField_p_of_type_Int == 26)
      {
        ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
        if (localProteusItemData.jdField_t_of_type_Int == 2)
        {
          rmn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80099DA");
          rmn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X80100DB");
          rmn.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X8009A5A");
        }
        else
        {
          rms.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, localProteusItemData.a);
        }
      }
      else
      {
        rnr.a(paramBaseData);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    int i2;
    if (this.jdField_a_of_type_Rjs != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Rjs.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Rjs.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Rjs.a().get(i1);
        if (((localBaseAdapter instanceof ogq)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
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
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_b_of_type_JavaLangString);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("");
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(8);
  }
  
  private boolean c(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return rmr.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
  }
  
  private void d(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (this.y))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setVisibility(paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.b();
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.894F, 1, 1.0F);; localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.894F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new riq(this, paramBoolean));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void h()
  {
    if ((this.y) && (this.v)) {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.1(this), 500L);
    }
  }
  
  private void i()
  {
    if ((this.y) && (this.v))
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
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setContentScrollListener(new rit(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setViolaGestureListener(new rjb(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a(this, 2131375329, 2131363384);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.setMaskBackGroundDrawable(getResources().getDrawable(2130841260));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setBackgroundColor(-1);
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Amgo = new amgo(this, true, false, true, true, 0);
      this.jdField_a_of_type_Amgo.a(this);
      this.jdField_a_of_type_Amgo.a(new rjj(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Amgo.a(new rjk(this));
      this.jdField_a_of_type_Amgo.a(new rjl(this));
      this.jdField_a_of_type_Amgo.a(new rjm(this));
    } while (this.v);
    this.jdField_a_of_type_Amgo.j();
  }
  
  private void k()
  {
    if (this.w) {}
    do
    {
      return;
      this.w = true;
      int i2 = this.jdField_a_of_type_Rmi.a();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：finishOneByOne  size:" + i2);
      int i1 = 0;
      while (i1 < i2)
      {
        finish();
        i1 += 1;
      }
      finish();
    } while ((!this.y) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout == null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.c();
  }
  
  private void l()
  {
    onk.jdField_f_of_type_Boolean = false;
    sip.a(4);
  }
  
  private void m()
  {
    onk.jdField_f_of_type_Boolean = false;
    onk.jdField_g_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void n()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131375421);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(onk.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131374819)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368472));
      findViewById(2131368429).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131363384));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131379551));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131167087));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131167087));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      this.jdField_a_of_type_Nly = new nly(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_Baxk = new baxk(this, (QQAppInterface)onk.a());
      this.jdField_a_of_type_Baxk.a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378101));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365912));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363288));
      this.jdField_d_of_type_AndroidViewView = findViewById(2131369811);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      p();
      o();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      q();
      r();
      findViewById(2131375270).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366189));
      this.jdField_a_of_type_Rjr = new rjr(this);
      y();
      s();
      S();
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
    this.jdField_a_of_type_AndroidTextSpannableString = rmc.a().a(this);
  }
  
  private void p()
  {
    this.jdField_b_of_type_AndroidTextSpannableString = rmc.a().b(this);
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375469));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370259));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370260));
    Drawable localDrawable = bbdr.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840691), -16777216);
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
      v();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    try
    {
      t();
      rnx.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a();
      this.jdField_a_of_type_JavaUtilList = osj.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        rnx.a("HtmlChangeUtil.parse");
        if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
          this.jdField_a_of_type_AndroidUtilSparseArray = rmq.a();
        }
        this.jdField_a_of_type_JavaUtilList = rng.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
        N();
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          throw new RuntimeException("parse data is empty!");
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "has parse error, use webview open url!" });
      localHashMap.put("param_error", localException.toString());
      bool = false;
    }
    for (;;)
    {
      localHashMap.put("param_uin", onk.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      axrl.a(BaseApplication.getContext()).a(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      Object localObject2;
      int i1;
      if (!bool)
      {
        c(false);
        w();
        osm.a().a(this.jdField_a_of_type_Osp);
        nty.a().a(5555, this);
        nty.a().a(6666, this);
        d();
        new rpx().a("native_article");
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
        rnx.a("HtmlChangeUtil.parse");
        i1 = 0;
        rnm.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        this.jdField_s_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof ProteusItemData)))
          {
            localObject2 = (ProteusItemData)localObject2;
            if ((((ProteusItemData)localObject2).jdField_t_of_type_Int == 1) && ((((ProteusItemData)localObject2).jdField_s_of_type_Int == 1) || (((ProteusItemData)localObject2).jdField_s_of_type_Int == 2)))
            {
              this.jdField_s_of_type_Int += 1;
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
                if ((this.jdField_j_of_type_Int != 1001) && (this.jdField_a_of_type_Rmk == null)) {
                  rnm.d(this.jdField_a_of_type_JavaUtilList);
                }
                rnm.e(this.jdField_a_of_type_JavaUtilList);
                i1 = 1;
                break;
                actn.a("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
              }
            }
          }
        }
        rnx.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Rjs = new rjs();
        this.jdField_a_of_type_Rkf = new rkf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Rjs);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Rkf);
        this.jdField_a_of_type_Rjw = new rjw(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Baxk);
        this.jdField_a_of_type_Rjw.registerDataSetObserver(new rjn(this));
        this.jdField_a_of_type_Rjs.a(this.jdField_a_of_type_Rjw);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
          u();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_Bfwv);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Bfob);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Rjs);
        this.jdField_a_of_type_Rjs.a(this.jdField_a_of_type_Rju);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131375744);
        T();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = osj.a().a();
        if (this.jdField_a_of_type_Rmk != null)
        {
          localObject1 = this.jdField_a_of_type_Rmk.jdField_a_of_type_AndroidOsParcelable;
          label1161:
          if (localObject1 == null) {
            break label1314;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          c(((AbsListView.SavedState)localObject1).jdField_b_of_type_Int);
          label1186:
          if ((this.jdField_j_of_type_Int == 1001) || (this.jdField_a_of_type_Rmk != null)) {
            break label1375;
          }
        }
      }
      label1314:
      label1375:
      while (i1 == 0)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          BaseData localBaseData = (BaseData)((Iterator)localObject1).next();
          if ((localBaseData instanceof ProteusBannerVideoItemData)) {
            ((ProteusBannerVideoItemData)localBaseData).jdField_a_of_type_Boolean = false;
          }
        }
        if (localObject2 == null) {
          break label1382;
        }
        ((pai)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Pak, true);
        break label1382;
        if (localObject2 != null)
        {
          localObject1 = ((pai)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
          break label1161;
          c(0);
          break label1186;
          c(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          osm.a().a(this.jdField_b_of_type_Osp);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_a_of_type_Boolean = false;
          break;
        }
        localObject1 = null;
        break label1161;
      }
      label1382:
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.k)) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.k;
    }
  }
  
  private void u()
  {
    String str = null;
    this.jdField_a_of_type_Ogq = new ogq(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Ogq.a(new rjo(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Ogq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Ogq.a(new ril(this));
      this.jdField_a_of_type_Rjs.a(this.jdField_a_of_type_Ogq);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new rim(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new rin(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131375744, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void v()
  {
    pai localpai = osj.a().a();
    if (localpai == null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        w();
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "fastWebModule == null");
      return;
    }
    localpai.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Pal);
  }
  
  private void w()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_l_of_type_Boolean = true;
    osm.a().a(this.jdField_b_of_type_Osp);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new rio(this));
    noo.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), "", false);
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new rip(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void y()
  {
    View localView = findViewById(2131372592);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void z()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.x = false;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public nly a()
  {
    return this.jdField_a_of_type_Nly;
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
    rmr.a(this.jdField_a_of_type_JavaUtilList, paramFloat);
    this.jdField_a_of_type_Rjs.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131369811).setVisibility(8);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(2130771981, 2130772011);
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
    this.jdField_q_of_type_Boolean = true;
    doOnPause();
    doOnStop();
    if (this.jdField_a_of_type_Rjw != null) {
      this.jdField_a_of_type_Rjw.d();
    }
    this.jdField_q_of_type_Boolean = false;
    rmk localrmk = new rmk();
    localrmk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localrmk.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localrmk.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localrmk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localrmk.jdField_a_of_type_Boolean = this.jdField_m_of_type_Boolean;
    localrmk.jdField_a_of_type_Rke = this.jdField_a_of_type_Rke;
    this.jdField_a_of_type_Rmi.a(localrmk);
    this.jdField_c_of_type_JavaLangString = (onk.a() + System.currentTimeMillis());
    b(paramIntent);
    this.jdField_q_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_q_of_type_Boolean = false;
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.29(this, paramBaseData));
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
      a(paramAbsListView, this.jdField_b_of_type_Int, true);
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
    ooc.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_o_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        rnr.a(localArticleInfo1, "0X800898C", onk.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Sgy == null) {
          this.jdField_a_of_type_Sgy = new sgy(this, this.app, null, new rjq(this));
        }
        this.jdField_a_of_type_Sgy.a.a("biu出去让更多好友看到");
        this.jdField_a_of_type_Sgy.a.a(new ris(this));
        this.jdField_a_of_type_Sgy.a(a());
        return;
      }
    }
    this.jdField_o_of_type_Boolean = true;
    ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (String str = "2";; str = "1")
    {
      rnr.a(localArticleInfo1, "0X8008993", onk.a(this, localArticleInfo2, i1, str).toString());
      break;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.x)
    {
      this.x = false;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    if (paramBoolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_AndroidTextSpannableString);
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(this.jdField_e_of_type_AndroidWidgetTextView.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingRight(), vpp.b(this, 7.0F));
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.rightMargin = ((int)paramLong);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new rir(this, paramBoolean));
      d(true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FastWebActivity.17(this), 5000L);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(this.jdField_e_of_type_AndroidWidgetTextView.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingRight(), vpp.b(this, 4.0F));
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772313, 2130772312);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if ((this.v) && (this.jdField_a_of_type_Amgo != null)) {
        this.jdField_a_of_type_Amgo.j();
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
      this.jdField_a_of_type_Ooc.b();
      d(8);
      return;
    }
    if ((this.v) && (this.jdField_a_of_type_Amgo != null)) {
      this.jdField_a_of_type_Amgo.k();
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Ooc.a();
    paramString1 = getSupportFragmentManager().beginTransaction();
    paramString1.setCustomAnimations(paramInt1, paramInt2);
    paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    paramString1.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_Rjs.notifyDataSetChanged();
    d(0);
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = bfng.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
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
          if (((i2 & 0x4000) == 0L) && (ayec.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
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
              ayec.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Amgo != null) && (this.jdField_a_of_type_Amgo.a()) && (this.v))
          {
            if (!this.jdField_a_of_type_Amgo.c()) {
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
      localObject1 = new qcc();
      localReportInfo.mUin = onk.a();
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
        ((qcc)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qcl != null) {
          ((qcc)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Qcl.jdField_a_of_type_Long;
        }
        ((qcc)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((qcc)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((qcc)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (qcl)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((qcc)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((qcl)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((qcc)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    osj.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      rnm.b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Rjs.notifyDataSetChanged();
      return;
    }
    rnm.c(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rjs.notifyDataSetChanged();
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
    Object localObject = new ohl(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | begin");
    if (this.jdField_r_of_type_Boolean)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2CommentArea");
      if (this.jdField_p_of_type_Int == 0)
      {
        noo.a((QQAppInterface)getAppInterface(), ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_r_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_r_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      ((ohl)localObject).d(1);
      this.jdField_a_of_type_Ooc.a();
      localObject = ((ohl)localObject).a();
      noo.a((QQAppInterface)getAppInterface(), ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
    }
    for (;;)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | done");
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
      this.jdField_r_of_type_Boolean = true;
      ((ohl)localObject).d(2);
      localObject = ((ohl)localObject).a();
      noo.a((QQAppInterface)getAppInterface(), ohi.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Ooc.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Rjw != null) {}
    for (int i1 = this.jdField_a_of_type_Rjw.getCount();; i1 = 0)
    {
      this.jdField_p_of_type_Int = i1;
      this.jdField_q_of_type_Int = 0;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_p_of_type_Int);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Sgy != null) && (this.jdField_a_of_type_Sgy.a())) {}
    do
    {
      return;
      this.jdField_n_of_type_Boolean = true;
    } while (onBackEvent());
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
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
          actn.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
          finish();
          return true;
        }
        axrl.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
      this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("fast_web_from_channel_id");
      this.jdField_s_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "is from colorNote : " + this.jdField_s_of_type_Boolean);
      this.v = amkn.a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        localObject = ((Bundle)localObject).getBundle("banner_webview_extra");
        if ((localObject != null) && (((Bundle)localObject).get("fast_web_article_info") != null))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
          this.jdField_d_of_type_Int = ((Bundle)localObject).getInt("fast_web_banner_from_channel_id");
          this.jdField_j_of_type_Int = 1001;
          this.jdField_m_of_type_Boolean = ((Bundle)localObject).getBoolean("fast_web_from_article_recommend", false);
        }
      }
      else
      {
        this.jdField_i_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId;
        this.jdField_f_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mAlgorithmID;
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID;
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        this.jdField_c_of_type_JavaLangString = (onk.a() + System.currentTimeMillis());
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
      noo.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), "", false);
      try
      {
        setContentView(2131559912);
        n();
        if (this.jdField_a_of_type_Rjw != null) {
          this.jdField_a_of_type_Rjw.a();
        }
        i();
        j();
        this.jdField_a_of_type_AndroidUtilSparseArray = rmq.a();
        return true;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          BaseApplicationImpl.sImageCache.evict(0);
          try
          {
            setContentView(2131559912);
            n();
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
      ooc.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Ogq != null) && (this.jdField_a_of_type_Ogq.a() != null))
      {
        localObject = this.jdField_a_of_type_Ogq.a();
        ((ohf)localObject).a(this.jdField_a_of_type_Ooc.b(), this.jdField_r_of_type_Int);
        ((ohf)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Rjw.getCount());
      }
    }
    osm.a().b(this.jdField_b_of_type_Osp);
    osm.a().b(this.jdField_a_of_type_Osp);
    if (this.jdField_a_of_type_Rjw != null) {
      this.jdField_a_of_type_Rjw.d();
    }
    if (this.jdField_a_of_type_Rjs != null) {
      this.jdField_a_of_type_Rjs.a();
    }
    if (this.jdField_a_of_type_Ogq != null) {
      this.jdField_a_of_type_Ogq.d();
    }
    J();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Xmt != null) {
      this.jdField_a_of_type_Xmt.c();
    }
    this.jdField_a_of_type_Xmt = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Rnu != null) {
      this.jdField_a_of_type_Rnu.a();
    }
    if (this.jdField_a_of_type_Sgy != null) {
      this.jdField_a_of_type_Sgy.b();
    }
    rnn.a();
    if (this.jdField_a_of_type_Baxk != null)
    {
      this.jdField_a_of_type_Baxk.a(null);
      this.jdField_a_of_type_Baxk = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    qku.a().jdField_b_of_type_Boolean = false;
    Object localObject = osj.a().a();
    if (localObject != null) {
      ((pai)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_Nly != null) {
      this.jdField_a_of_type_Nly.b();
    }
    B();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_c_of_type_Boolean) {
        aggn.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Rnb.a();
    this.jdField_a_of_type_Rnb = null;
    nty.a().b(5555, this);
    nty.a().b(6666, this);
    if (this.jdField_a_of_type_Amgo != null)
    {
      this.jdField_a_of_type_Amgo.c();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onDestroy");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
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
          if (this.jdField_a_of_type_Rnu == null) {
            this.jdField_a_of_type_Rnu = new rnu(this);
          }
          this.jdField_a_of_type_Rnu.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Rnu.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
        }
      }
      return;
    }
  }
  
  public void doOnPause()
  {
    if (!this.jdField_q_of_type_Boolean) {
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
        localObject1 = onk.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + rnr.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_c_of_type_JavaLangString);
        rnr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_q_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", onk.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.2.8".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!shx.a(this.jdField_b_of_type_Long)) {
            break label664;
          }
          localObject1 = "0X8009359";
          noo.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), (String)localObject2, false);
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
        ((ReportInfo)localObject2).mUin = onk.a();
        ((ReportInfo)localObject2).mSource = 0;
        ((ReportInfo)localObject2).mSourceArticleId = this.jdField_a_of_type_Long;
        ((ReportInfo)localObject2).mChannelId = ((int)this.jdField_b_of_type_Long);
        ((ReportInfo)localObject2).mAlgorithmId = ((int)this.jdField_f_of_type_Long);
        ((ReportInfo)localObject2).mStrategyId = this.jdField_i_of_type_Int;
        ((ReportInfo)localObject2).mOperation = 9;
        ((ReportInfo)localObject2).mOpSource = 12;
        ((ReportInfo)localObject2).mReadTimeLength = ((int)(l1 / 1000L));
        ((ReportInfo)localObject2).mInnerId = this.jdField_a_of_type_JavaLangString;
        i1 = b();
        ((ReportInfo)localObject2).mArticleLength = i1;
        ((ReportInfo)localObject2).mReadArticleLength = ((int)(i1 * a()));
        ((List)localObject1).add(localObject2);
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.19(this, (List)localObject1));
        if (this.jdField_a_of_type_Rjw != null) {
          this.jdField_a_of_type_Rjw.c();
        }
        if (onk.jdField_g_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Amgo == null) {
          continue;
        }
        this.jdField_a_of_type_Amgo.b();
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onPause");
        return;
        localObject1 = "1";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Q.readinjoy.fast_web", 2, localException, new Object[] { "doOnPause" });
          continue;
          label664:
          localObject1 = "0X80066FB";
        }
      }
    }
  }
  
  public void doOnResume()
  {
    if (!this.jdField_q_of_type_Boolean) {
      super.doOnResume();
    }
    if (!this.jdField_q_of_type_Boolean) {
      this.jdField_e_of_type_Long = System.currentTimeMillis();
    }
    rnx.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Rjs != null) {
      this.jdField_a_of_type_Rjs.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Rjw != null) {
      this.jdField_a_of_type_Rjw.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ooc.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      osj.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (onk.jdField_g_of_type_Boolean)
    {
      if (onk.jdField_f_of_type_Boolean) {
        onk.a(4, this.jdField_c_of_type_Long);
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
    if (this.jdField_a_of_type_Amgo != null)
    {
      this.jdField_a_of_type_Amgo.a();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.c();
    }
  }
  
  public void doOnStart()
  {
    if (!this.jdField_q_of_type_Boolean) {
      super.doOnStart();
    }
  }
  
  public void doOnStop()
  {
    if (!this.jdField_q_of_type_Boolean) {
      super.doOnStop();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if ((!mAppForground) || (this.jdField_q_of_type_Boolean))
    {
      ooc.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Ooc.b();
    }
    if ((isFinishing()) || (this.jdField_q_of_type_Boolean))
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "fastwebActivity doOnStop | removeCommentDataManager");
      oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
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
    rnm.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Rjs.notifyDataSetChanged();
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
      if ((!bbay.b()) && (!bbay.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!bbay.b()) && (!bbay.d()))
    {
      b(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!bbay.d())
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
    if ((this.jdField_t_of_type_Boolean) && (!this.jdField_u_of_type_Boolean))
    {
      D();
      return;
    }
    if (this.jdField_a_of_type_Rmi.a())
    {
      if (this.jdField_a_of_type_Amgo == null) {
        d(this);
      }
      if ((this.y) && (this.v) && (this.A) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout.a()) && (!this.jdField_u_of_type_Boolean))
      {
        E();
        return;
      }
      if ((this.jdField_a_of_type_Amgo != null) && (!this.jdField_u_of_type_Boolean))
      {
        D();
        return;
      }
      if (this.jdField_j_of_type_Int == 1001)
      {
        if (this.jdField_d_of_type_Int != 70) {
          break label263;
        }
        KandianSubscribeManager.a(this, 2);
      }
      if (this.jdField_g_of_type_Long != 0L) {
        rnr.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_k_of_type_Boolean = true;
    I();
    K();
    F();
    osm.a().b(this.jdField_b_of_type_Osp);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label213:
      if (!this.jdField_n_of_type_Boolean) {
        break label345;
      }
    }
    label263:
    label345:
    for (String str2 = "1";; str2 = "2")
    {
      noo.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      O();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mFloating ：finish over");
      return;
      if (this.jdField_d_of_type_Int == 0)
      {
        nut.a(this.app, this, 11, 0);
        break;
      }
      if (oox.c(this.jdField_d_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bhvh.i()) {
        break;
      }
      nut.b(this, 11);
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
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370260));
    localMiniMsgUserParam.filterMsgType = 1;
    return localMiniMsgUserParam;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    if (paramInt1 == 10922) {
      if ((paramInt2 == -10069) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        onk.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
      }
    }
    BaseData localBaseData;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
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
                        if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Rmk == null))
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
                      paramIntent = oio.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = this.jdField_b_of_type_JavaLangString;
                        localObject = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.jdField_a_of_type_JavaUtilList != null) {}
                        for (;;)
                        {
                          actn.a(paramIntent, bool, new NullPointerException());
                          return;
                          bool = false;
                        }
                      }
                    } while (this.jdField_a_of_type_Ogq == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.d((String)localObject, this.jdField_a_of_type_Ogq.b());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.c((String)localObject, this.jdField_a_of_type_Ogq.b());
                  return;
                  if ((paramInt1 != 1001) || (paramIntent == null)) {
                    break;
                  }
                  paramIntent = paramIntent.getSerializableExtra("backToImageData");
                } while (!(paramIntent instanceof List));
                paramIntent = (List)paramIntent;
              } while (paramIntent.isEmpty());
              ThreadManager.getUIHandler().post(new FastWebActivity.26(this, paramIntent));
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
              return;
              if (paramInt1 == 2002)
              {
                if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
                {
                  paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
                  paramIntent.jdField_c_of_type_Long += 1L;
                  ThreadManager.getUIHandler().post(new FastWebActivity.27(this));
                }
                paramIntent = getAppInterface();
                localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  rnr.a(this, paramIntent, (ArticleInfo)localObject, 0, -1, false, bool);
                  return;
                }
              }
              if (paramInt1 == 1)
              {
                paramIntent = getAppInterface();
                localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  rnr.a(this, paramIntent, (ArticleInfo)localObject, 1, -1, false, bool);
                  return;
                }
              }
            } while ((paramInt1 != 9999) || (paramInt2 != -1) || (paramIntent == null));
            paramIntent = paramIntent.getParcelableExtra("key_ad_info");
          } while ((!(paramIntent instanceof AdData)) || (this.jdField_a_of_type_JavaUtilList == null));
          paramIntent = ((AdData)paramIntent).u;
        } while (TextUtils.isEmpty(paramIntent));
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localBaseData = (BaseData)((Iterator)localObject).next();
    } while ((!(localBaseData instanceof AdData)) || (!paramIntent.equals(((AdData)localBaseData).u)));
    a(localBaseData);
    bcpw.a(this, -1, getString(2131699664), 0).b(getTitleBarHeight());
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
    if ((paramView.getId() != 2131368429) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131368429: 
      this.jdField_n_of_type_Boolean = true;
      finish();
      return;
    case 2131375270: 
      a(true);
      return;
    case 2131368472: 
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
        rkj localrkj = (rkj)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localrkj != null) {
          localrkj.a(paramString, paramBitmap);
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
    ThreadManager.getUIHandler().post(new FastWebActivity.38(this));
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
        ((MiniMsgUserParam)localObject).backConversationIntent = onk.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_c_of_type_Int, this.jdField_m_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          rnr.a(localArticleInfo1, "0X800A09C", onk.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label230;
          }
          localObject = "2";
          rnr.a(localArticleInfo1, "0X800A09D", onk.a(this, localArticleInfo2, i1, (String)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity
 * JD-Core Version:    0.7.0.1
 */