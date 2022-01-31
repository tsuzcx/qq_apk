package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import aciy;
import afun;
import alrv;
import alux;
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
import awrn;
import axea;
import azwg;
import azwh;
import azzu;
import babp;
import bacm;
import badq;
import bahv;
import bbmy;
import befm;
import begh;
import bejb;
import bepb;
import bgmq;
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
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nax;
import ndn;
import nio;
import niq;
import nji;
import nqg;
import nvf;
import nvu;
import nvw;
import nvx;
import nvz;
import nwa;
import nxd;
import obz;
import ocr;
import odm;
import ogy;
import ohb;
import ohd;
import ohe;
import oph;
import opj;
import opk;
import org.json.JSONException;
import org.json.JSONObject;
import pqg;
import pqm;
import pqo;
import prv;
import prx;
import pyu;
import qoe;
import qvy;
import qvz;
import qwa;
import qwb;
import qwc;
import qwd;
import qwe;
import qwf;
import qwg;
import qwh;
import qwi;
import qwj;
import qwk;
import qwl;
import qwm;
import qwn;
import qwo;
import qwp;
import qwq;
import qwr;
import qws;
import qwt;
import qwu;
import qww;
import qwx;
import qwy;
import qwz;
import qxa;
import qxb;
import qxe;
import qxh;
import qxm;
import qxn;
import qxp;
import qxr;
import qzk;
import qzq;
import qzs;
import qzy;
import qzz;
import raj;
import rao;
import rau;
import rav;
import raz;
import rbc;
import rbf;
import rdj;
import rug;
import ruk;
import rvf;
import rvw;
import vct;
import xdt;

public class FastWebActivity
  extends FragmentActivity
  implements View.OnClickListener, azwh, MiniMsgUser.IMiniMsgActionCallback, niq, nqg, nvw, nvz, ruk
{
  private float jdField_a_of_type_Float = babp.d() * 500 / 160.0F;
  private int jdField_a_of_type_Int = 1;
  protected long a;
  private alrv jdField_a_of_type_Alrv;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler;
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  public SparseArray<Float> a;
  private View jdField_a_of_type_AndroidViewView;
  private DecelerateInterpolator jdField_a_of_type_AndroidViewAnimationDecelerateInterpolator = new DecelerateInterpolator(this.jdField_c_of_type_Float);
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private azwg jdField_a_of_type_Azwg;
  begh jdField_a_of_type_Begh = new qwi(this);
  private bepb jdField_a_of_type_Bepb = new qwk(this);
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
  public MiniMsgUser a;
  public INetInfoHandler a;
  private BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  protected String a;
  private HashMap<String, ArrayList<String>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<BaseData> jdField_a_of_type_JavaUtilList;
  private nax jdField_a_of_type_Nax;
  private nvf jdField_a_of_type_Nvf;
  private ocr jdField_a_of_type_Ocr = new ocr();
  ohe jdField_a_of_type_Ohe = new qwp(this);
  private opj jdField_a_of_type_Opj = new qwo(this);
  private opk jdField_a_of_type_Opk = new qwm(this);
  private qxa jdField_a_of_type_Qxa;
  private qxb jdField_a_of_type_Qxb;
  private qxe jdField_a_of_type_Qxe;
  private qxm jdField_a_of_type_Qxm;
  private qxn jdField_a_of_type_Qxn;
  private qzq jdField_a_of_type_Qzq = new qzq(this);
  private qzs jdField_a_of_type_Qzs;
  private raj jdField_a_of_type_Raj = new raj();
  private rbc jdField_a_of_type_Rbc;
  private rug jdField_a_of_type_Rug;
  private xdt jdField_a_of_type_Xdt;
  boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = babp.d() * 1000 / 160.0F;
  private int jdField_b_of_type_Int = -1;
  public long b;
  private MessageQueue.IdleHandler jdField_b_of_type_AndroidOsMessageQueue$IdleHandler = new qwr(this);
  private SpannableString jdField_b_of_type_AndroidTextSpannableString;
  private SparseArray<View> jdField_b_of_type_AndroidUtilSparseArray = new SparseArray(1);
  private View jdField_b_of_type_AndroidViewView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString = "FastWebActivity";
  private ohe jdField_b_of_type_Ohe = new qwj(this);
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
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w = true;
  private boolean x;
  
  public FastWebActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new qwq(this);
  }
  
  private void A()
  {
    getMainLooper();
    Looper.myQueue().removeIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void B()
  {
    if ((this.jdField_a_of_type_Qxn == null) || ((this.jdField_a_of_type_Qxe != null) && (this.jdField_a_of_type_Qxe.getCount() != this.jdField_a_of_type_Qxn.a())))
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
      if (this.jdField_a_of_type_Qxn != null)
      {
        if (this.jdField_e_of_type_Int <= i3) {
          break label316;
        }
        i2 = this.jdField_e_of_type_Int;
        this.jdField_e_of_type_Int = i2;
        i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFirstVisiblePosition();
        i2 = this.jdField_e_of_type_Int - i2;
        if ((i2 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount()) && (this.jdField_e_of_type_Int < this.jdField_a_of_type_Qxn.a()))
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(i2);
          i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getHeight();
          i4 = ((View)localObject).getTop();
          this.jdField_g_of_type_Int = (this.jdField_a_of_type_Qxn.a(this.jdField_e_of_type_Int) - (i2 - i4));
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
      if (f1 > raz.jdField_a_of_type_ArrayOfFloat[0]) {
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
      if (f1 <= raz.jdField_a_of_type_ArrayOfFloat[1])
      {
        i1 |= 0x2;
      }
      else if (f1 <= raz.jdField_a_of_type_ArrayOfFloat[2])
      {
        i1 |= 0x4;
        continue;
        i1 |= 0x8;
        continue;
        localObject = raz.jdField_a_of_type_ArrayOfInt;
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
          ocr.b(raz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
        for (;;)
        {
          i2 += 1;
          break label408;
          break;
          i3 = 0;
          break label438;
          ocr.c(raz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, localInteger.intValue()));
        }
      }
    }
  }
  
  private void C()
  {
    this.u = true;
    overridePendingTransition(0, 0);
    this.jdField_a_of_type_Alrv.d();
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：exitAnimation");
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null)
      {
        oph localoph = ((ohd)this.app.getManager(163)).a().a();
        if (localoph != null) {
          localoph.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "", localParcelable);
        }
      }
    }
  }
  
  private void E()
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
          localArrayList.add(new qxp(i1, Long.valueOf(0L), localBaseData));
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(i1, new qwe(this, i1, localBaseData));
        }
        else if (raz.a(localBaseData))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new qwf(this, localBaseData));
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(localArrayList);
  }
  
  private void F()
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
            raz.b(this.app, (AdData)localBaseData);
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
  
  private void G()
  {
    int i1 = b();
    raz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, a(), i1, this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Qxe != null) {
      this.jdField_a_of_type_Qxe.e();
    }
  }
  
  private void H()
  {
    long l1 = rbf.c("fast_web_show_light_house_1");
    boolean bool = true;
    if (l1 < 0L) {
      return;
    }
    if (this.jdField_k_of_type_Boolean) {
      bool = false;
    }
    long l2 = rbf.c("fast_web_show_light_house_2");
    long l3 = rbf.c("fast_web_show_light_house_3");
    long l4 = rbf.c("fast_web_show_light_house_draw_finish");
    long l5 = rbf.c("fast_web_show_light_house_step4_2");
    long l6 = rbf.c("fast_web_show_light_house_step4_1");
    HashMap localHashMap = new HashMap();
    localHashMap.put("which", "1");
    localHashMap.put("step1", String.valueOf(l2 - l1));
    localHashMap.put("step2", String.valueOf(l3 - l2));
    localHashMap.put("step3", String.valueOf(l4 - l3));
    localHashMap.put("step4", String.valueOf(l5 - l6));
    localHashMap.put("param_uin", obz.a());
    QLog.d("Q.readinjoy.fast_web", 2, "reportSpentTime, params = " + localHashMap.toString() + "  all cost : " + (l4 - l1));
    awrn.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool, l4 - l1, 0L, localHashMap, null);
  }
  
  private void I()
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
      bool1 = a(this.jdField_k_of_type_Int);
      bool2 = a(this.jdField_m_of_type_Int);
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
  
  private void J()
  {
    try
    {
      qzy.b(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      qzy.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher, this.jdField_a_of_type_AndroidUtilSparseArray);
      d(26);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.setData(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "updateConfigInfo error ! msg=" + localException);
    }
  }
  
  private void K()
  {
    qzz.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_Qzq.a()) {}
    qzs localqzs;
    do
    {
      return;
      this.jdField_q_of_type_Boolean = true;
      doOnPause();
      doOnStop();
      G();
      this.jdField_q_of_type_Boolean = false;
      localqzs = this.jdField_a_of_type_Qzq.a();
    } while (localqzs == null);
    a(localqzs);
    this.jdField_q_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_q_of_type_Boolean = false;
  }
  
  private void M()
  {
    this.jdField_a_of_type_Qzs = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = null;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_a_of_type_Qxn = null;
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a(this.jdField_a_of_type_Begh);
    oph localoph = ogy.a().a();
    if (localoph != null)
    {
      localoph.a(this.jdField_a_of_type_Opj);
      localoph.a(this.jdField_a_of_type_Opk);
    }
    this.jdField_h_of_type_Int = 0;
  }
  
  private void N()
  {
    obz.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.jdField_b_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("preGotoConversation mActivityStack size = ").append(this.jdField_a_of_type_Qzq.a()).append("ismain = ");
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label91;
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str, 2, bool);
      this.jdField_a_of_type_Qzq.a(new qwl(this));
      return;
    }
  }
  
  private void O()
  {
    ThreadManager.getUIHandler().post(new FastWebActivity.33(this));
  }
  
  private float a()
  {
    if (this.jdField_a_of_type_Qxn == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0.0F;
    }
    if (this.jdField_e_of_type_Int <= 0) {
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
    return a(this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_Qxn == null)
    {
      QLog.e("Q.readinjoy.fast_web", 2, "getRatio itemsHeight == null ");
      return 0;
    }
    int i2 = 0;
    while ((i1 < this.jdField_a_of_type_Qxn.a()) && (i1 <= paramInt1))
    {
      i2 += this.jdField_a_of_type_Qxn.a(i1);
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
      localArticleInfo.businessId = ((qxh)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_Long;
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
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm = new pqm();
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b = Long.valueOf(1L);
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.jdField_a_of_type_JavaUtilList = new ArrayList();
    return localArticleInfo;
  }
  
  private void a(int paramInt)
  {
    qzk.a().a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.fusionBiuInfo.jdField_a_of_type_Long, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new FastWebActivity.27(this), paramLong);
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
    int i1 = (int)paramArticleInfo.mChannelID;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (qoe.b(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!qoe.f(paramArticleInfo)) {
        localObject1 = ((prx)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Prv.a.get(0)).jdField_b_of_type_JavaLangString;
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
        if (badq.h(null)) {
          if (!((String)localObject2).contains("?")) {
            break label417;
          }
        }
      }
    }
    label417:
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
      finish();
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
      localObject = obz.a(this, paramArticleInfo, i1, (String)localObject);
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
      }
      catch (JSONException paramFastWebArticleInfo)
      {
        paramFastWebArticleInfo.printStackTrace();
        continue;
      }
      raz.a(paramArticleInfo, "0X8008989", ((JSONObject)localObject).toString());
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
    Object localObject1 = new FastWebActivity.21(this, (View)localObject2, paramAbsListView, i1, paramInt, paramBoolean);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramAbsListView.postOnAnimation((Runnable)localObject1);
      return;
    }
    paramAbsListView.post((Runnable)localObject1);
    return;
    this.jdField_i_of_type_Boolean = true;
  }
  
  private void a(qzs paramqzs)
  {
    M();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramqzs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    this.jdField_a_of_type_Qzs = paramqzs;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_Qzs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    this.jdField_m_of_type_Boolean = paramqzs.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Qxm = paramqzs.jdField_a_of_type_Qxm;
    q();
  }
  
  private void a(boolean paramBoolean, String paramString, List<BaseData> paramList1, List<BaseData> paramList2)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.n.equals(paramString)))
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
      rau.a(this.jdField_a_of_type_JavaUtilList, paramList1, paramString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, true, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      rau.a(this.jdField_a_of_type_JavaUtilList, paramList1, localArrayList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false, this.jdField_a_of_type_AndroidUtilSparseArray, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher);
      paramString = ogy.a().a();
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j, this.jdField_a_of_type_JavaUtilList);
      }
      if ((paramList1 != null) && (!paramList1.isEmpty())) {
        d(6);
      }
      E();
      rau.a(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Qxb.notifyDataSetChanged();
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i1;
    int i2;
    if (this.jdField_a_of_type_Qxb != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Qxb.a().size() > 0)
      {
        i1 = 0;
        i2 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      BaseAdapter localBaseAdapter;
      if (i1 < this.jdField_a_of_type_Qxb.a().size())
      {
        localBaseAdapter = (BaseAdapter)this.jdField_a_of_type_Qxb.a().get(i1);
        if (((localBaseAdapter instanceof nvf)) && (paramInt >= i2) && (paramInt < localBaseAdapter.getCount() + i2)) {
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
    if (this.jdField_a_of_type_Qxn == null)
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
      if (qzz.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(i2))) {
        i3 = i1 + this.jdField_a_of_type_Qxn.a(i2);
      }
      i2 += 1;
    }
  }
  
  private void b(Intent paramIntent)
  {
    M();
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
    q();
  }
  
  private boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (paramInt > 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return qzz.a((BaseData)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    return false;
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
  
  private void d(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_JavaUtilList.size())
    {
      BaseData localBaseData = (BaseData)this.jdField_a_of_type_JavaUtilList.get(i1);
      if (paramInt == localBaseData.jdField_p_of_type_Int) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.b(i1, new qwg(this, paramInt, localBaseData));
      }
      i1 += 1;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.894F, 1, 1.0F);; localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.894F, 1, 1.0F))
    {
      localScaleAnimation.setDuration(350L);
      localScaleAnimation.setAnimationListener(new qwb(this, paramBoolean));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(localScaleAnimation);
      return;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "init color error mArticleInfo is null");
    }
    do
    {
      return;
      this.jdField_a_of_type_Alrv = new alrv(this, true, false, true, true, 0);
      this.jdField_a_of_type_Alrv.a(this);
      this.jdField_a_of_type_Alrv.a(new qvy(this));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ： mOutterRowKey : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "mTitle : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName + "mSubscribeName : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName);
      }
      this.jdField_a_of_type_Alrv.a(new qwh(this));
      this.jdField_a_of_type_Alrv.a(new qwn(this));
      this.jdField_a_of_type_Alrv.a(new qws(this));
      this.w = alux.a();
    } while (this.w);
    this.jdField_a_of_type_Alrv.j();
  }
  
  private void i()
  {
    if (this.v) {
      return;
    }
    this.v = true;
    int i2 = this.jdField_a_of_type_Qzq.a();
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController ：finishByColorNote  size:" + i2);
    int i1 = 0;
    while (i1 < i2)
    {
      finish();
      i1 += 1;
    }
    finish();
  }
  
  private void j()
  {
    obz.jdField_d_of_type_Boolean = false;
    rvw.a(4);
  }
  
  private void k()
  {
    obz.jdField_d_of_type_Boolean = false;
    obz.jdField_e_of_type_Boolean = false;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void l()
  {
    try
    {
      this.jdField_b_of_type_AndroidViewView = findViewById(2131309667);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(true);
        this.jdField_b_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (ThemeUtil.isInNightMode(obz.a()))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          this.jdField_a_of_type_AndroidViewView = ((ViewStub)findViewById(2131309077)).inflate();
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
      findViewById(2131302804).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew = ((ReadInJoyFastWebBottomSocialViewNew)findViewById(2131297838));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView = ((ReadInJoyCommentListView)findViewById(2131313716));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEdgeEffectEnabled(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowTop.a(getResources().getDrawable(2131101491));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.mEdgeGlowBottom.a(getResources().getDrawable(2131101491));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOverScrollFlingMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDescendantFocusability(262144);
      this.jdField_a_of_type_Nax = new nax(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
      this.jdField_a_of_type_Azwg = new azwg(this, (QQAppInterface)obz.a());
      this.jdField_a_of_type_Azwg.a(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312281));
      if (this.jdField_b_of_type_AndroidWidgetTextView.getPaint() != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.getPaint().setFakeBoldText(true);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131300312));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131297738));
      n();
      m();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      o();
      p();
      findViewById(2131309522).setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300587));
      this.jdField_a_of_type_Qxa = new qxa(this);
      w();
      q();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      setResult(-10069, getIntent());
      finish();
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidTextSpannableString = qzk.a().a(this);
  }
  
  private void n()
  {
    this.jdField_b_of_type_AndroidTextSpannableString = qzk.a().b(this);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131309714));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131304578));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304579));
    Drawable localDrawable = bacm.a(this.jdField_a_of_type_AndroidWidgetImageView.getResources().getDrawable(2130840655), -16777216);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(getActivity(), getMiniMsgUserParam());
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)
    {
      t();
      return;
    }
    HashMap localHashMap = new HashMap();
    boolean bool;
    try
    {
      r();
      rbf.b("fast_web_show_light_house_step4_1");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p);
      this.jdField_a_of_type_JavaUtilList = ogy.a().a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.j);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        rbf.a("HtmlChangeUtil.parse");
        if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
          this.jdField_a_of_type_AndroidUtilSparseArray = qzy.a();
        }
        this.jdField_a_of_type_JavaUtilList = rao.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, this.jdField_a_of_type_AndroidUtilSparseArray);
        K();
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
      localHashMap.put("param_uin", obz.a());
      localHashMap.put("param_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
      localHashMap.put("param_articleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
      localHashMap.put("param_rowkey", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID + "");
      localHashMap.put("param_channelID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID + "");
      awrn.a(BaseApplication.getContext()).a(null, "actNativeWebParser", bool, 100L, 0L, localHashMap, "", true);
      Object localObject1;
      Object localObject2;
      int i1;
      if (!bool)
      {
        c(false);
        u();
        ohb.a().a(this.jdField_a_of_type_Ohe);
        nio.a().a(5555, this);
        nio.a().a(6666, this);
        d();
        new rdj().a("native_article");
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
        rbf.a("HtmlChangeUtil.parse");
        i1 = 0;
        rau.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo);
        this.jdField_s_of_type_Int = 0;
        localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseData)((Iterator)localObject1).next();
          if ((localObject2 != null) && ((localObject2 instanceof ProteusItemData)))
          {
            localObject2 = (ProteusItemData)localObject2;
            if ((((ProteusItemData)localObject2).t == 1) && ((((ProteusItemData)localObject2).jdField_s_of_type_Int == 1) || (((ProteusItemData)localObject2).jdField_s_of_type_Int == 2)))
            {
              this.jdField_s_of_type_Int += 1;
              continue;
              if ((this.jdField_a_of_type_JavaUtilList.size() >= 2) && ((this.jdField_a_of_type_JavaUtilList.get(0) instanceof TitleData)) && ((this.jdField_a_of_type_JavaUtilList.get(1) instanceof AuthorData)))
              {
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData = ((TitleData)this.jdField_a_of_type_JavaUtilList.get(0));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataTitleData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData = ((AuthorData)this.jdField_a_of_type_JavaUtilList.get(1));
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.b(false);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAuthorData.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.p);
              }
              for (;;)
              {
                if ((this.jdField_j_of_type_Int != 1001) && (this.jdField_a_of_type_Qzs == null)) {
                  rau.d(this.jdField_a_of_type_JavaUtilList);
                }
                rau.e(this.jdField_a_of_type_JavaUtilList);
                i1 = 1;
                break;
                aciy.a("Q.readinjoy.fast_web", "  " + this.jdField_a_of_type_JavaUtilList.size() + "  :  " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, new IllegalArgumentException());
              }
            }
          }
        }
        rbf.b("fast_web_show_light_house_step4_2");
        this.jdField_a_of_type_Qxb = new qxb();
        this.jdField_a_of_type_Qxn = new qxn(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Qxb);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a(this.jdField_a_of_type_Qxn);
        this.jdField_a_of_type_Qxe = new qxe(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Azwg);
        this.jdField_a_of_type_Qxe.registerDataSetObserver(new qwt(this));
        this.jdField_a_of_type_Qxb.a(this.jdField_a_of_type_Qxe);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.b())) {
          s();
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getFooterViewsCount() == 0) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.a();
        }
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setDrawFinishedListener(this.jdField_a_of_type_Bepb);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setOnScrollListener(this.jdField_a_of_type_Begh);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setAdapter(this.jdField_a_of_type_Qxb);
        this.jdField_c_of_type_AndroidViewView = findViewById(2131309983);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setFirstLevelCommentContainer(this, false);
        localObject2 = ogy.a().a();
        if (this.jdField_a_of_type_Qzs != null)
        {
          localObject1 = this.jdField_a_of_type_Qzs.jdField_a_of_type_AndroidOsParcelable;
          label1139:
          if (localObject1 == null) {
            break label1292;
          }
          localObject1 = (AbsListView.SavedState)localObject1;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onRestoreInstanceState((Parcelable)localObject1);
          c(((AbsListView.SavedState)localObject1).jdField_b_of_type_Int);
          label1164:
          if ((this.jdField_j_of_type_Int == 1001) || (this.jdField_a_of_type_Qzs != null)) {
            break label1353;
          }
        }
      }
      label1292:
      label1353:
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
          break label1360;
        }
        ((oph)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Opj, true);
        break label1360;
        if (localObject2 != null)
        {
          localObject1 = ((oph)localObject2).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID + "");
          break label1139;
          c(0);
          break label1164;
          c(true);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
          ohb.a().a(this.jdField_b_of_type_Ohe);
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.b();
          this.jdField_a_of_type_Boolean = false;
          break;
        }
        localObject1 = null;
        break label1139;
      }
      label1360:
      bool = true;
    }
  }
  
  private void r()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.n)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID = Long.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.n).longValue();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_c_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFirstPagePicUrl = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.q;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.e;
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long != 0L) && (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID = ("" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.jdField_d_of_type_Long);
    }
  }
  
  private void s()
  {
    String str = null;
    this.jdField_a_of_type_Nvf = new nvf(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView, 1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData = ((AnchorData)getIntent().getExtras().get("intent_key_anchor_data"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData != null) {
      str = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_a_of_type_JavaLangString;
    }
    for (Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData.jdField_b_of_type_JavaLangString;; localObject = null)
    {
      if (!TextUtils.isEmpty(str))
      {
        QLog.d("Q.readinjoy.fast_web", 1, " mainComment : " + str + "  subComment : " + (String)localObject);
        this.jdField_a_of_type_Nvf.a(new qwu(this, str, (String)localObject));
      }
      this.jdField_a_of_type_Nvf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataAnchorData, 1);
      this.jdField_a_of_type_Nvf.a(new qww(this));
      this.jdField_a_of_type_Qxb.a(this.jdField_a_of_type_Nvf);
      localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment = new ReadInJoySecondCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this, (Bundle)localObject, new qwx(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(new qwy(this));
      localObject = getSupportFragmentManager().beginTransaction();
      ((FragmentTransaction)localObject).add(2131309983, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
      return;
    }
  }
  
  private void t()
  {
    oph localoph = ogy.a().a();
    if (localoph == null)
    {
      if (!this.jdField_k_of_type_Boolean) {
        u();
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "fastWebModule == null");
      return;
    }
    localoph.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID, 1, this.jdField_a_of_type_Opk);
  }
  
  private void u()
  {
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "openWeb  mArticleInfo: " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    this.jdField_l_of_type_Boolean = true;
    ohb.a().a(this.jdField_b_of_type_Ohe);
    getMainLooper();
    Looper.myQueue().addIdleHandler(new qvz(this));
    ndn.a(null, "CliOper", "", "", "0X8009C50", "0X8009C50", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), "", false);
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new qwa(this);
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  private void w()
  {
    View localView = findViewById(2131306882);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  private void x()
  {
    findViewById(2131306882).setVisibility(8);
  }
  
  private void y()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.x = false;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  private void z()
  {
    A();
    getMainLooper();
    Looper.myQueue().addIdleHandler(this.jdField_b_of_type_AndroidOsMessageQueue$IdleHandler);
  }
  
  public nax a()
  {
    return this.jdField_a_of_type_Nax;
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
    qzz.a(this.jdField_a_of_type_JavaUtilList, paramFloat);
    this.jdField_a_of_type_Qxb.notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
    {
      findViewById(2131304138).setVisibility(8);
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
    if (this.jdField_a_of_type_Qxe != null) {
      this.jdField_a_of_type_Qxe.d();
    }
    this.jdField_q_of_type_Boolean = false;
    qzs localqzs = new qzs();
    localqzs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    localqzs.jdField_a_of_type_AndroidOsParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.onSaveInstanceState();
    localqzs.jdField_a_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localqzs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher;
    localqzs.jdField_a_of_type_Boolean = this.jdField_m_of_type_Boolean;
    localqzs.jdField_a_of_type_Qxm = this.jdField_a_of_type_Qxm;
    this.jdField_a_of_type_Qzq.a(localqzs);
    this.jdField_c_of_type_JavaLangString = (obz.a() + System.currentTimeMillis());
    b(paramIntent);
    this.jdField_q_of_type_Boolean = true;
    doOnStart();
    doOnResume();
    this.jdField_q_of_type_Boolean = false;
  }
  
  public void a(BaseData paramBaseData)
  {
    runOnUiThread(new FastWebActivity.26(this, paramBaseData));
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
    ocr.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    if (paramBoolean)
    {
      this.jdField_o_of_type_Boolean = false;
      localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
      for (str = "2";; str = "1")
      {
        raz.a(localArticleInfo1, "0X800898C", obz.a(this, localArticleInfo2, i1, str).toString());
        if (this.jdField_a_of_type_Rug == null) {
          this.jdField_a_of_type_Rug = new rug(this, this.app, null, new qwz(this));
        }
        this.jdField_a_of_type_Rug.a.a("biu出去让更多好友看到");
        this.jdField_a_of_type_Rug.a.a(new qwd(this));
        this.jdField_a_of_type_Rug.a(a());
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
      raz.a(localArticleInfo1, "0X8008993", obz.a(this, localArticleInfo2, i1, str).toString());
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
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(this.jdField_e_of_type_AndroidWidgetTextView.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingRight(), vct.a(this, 7.0F));
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      localLayoutParams.rightMargin = ((int)paramLong);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_e_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new qwc(this, paramBoolean));
      d(true);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new FastWebActivity.14(this), 5000L);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
      this.jdField_e_of_type_AndroidWidgetTextView.setPadding(this.jdField_e_of_type_AndroidWidgetTextView.getPaddingLeft(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingTop(), this.jdField_e_of_type_AndroidWidgetTextView.getPaddingRight(), vct.a(this, 4.0F));
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    a(paramBoolean, paramString1, paramString2, 2130772312, 2130772311);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout = ((ReadInJoyCommentTopGestureLayout)this.jdField_b_of_type_AndroidViewView);
    }
    if (paramBoolean)
    {
      if (this.w) {
        this.jdField_a_of_type_Alrv.j();
      }
      findViewById(2131304138).setVisibility(0);
      new Bundle().putBoolean("arg_comment_list_biu_btn", false);
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.setCustomAnimations(paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramString1, paramString2, 1);
      localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_c_of_type_AndroidViewView, false);
      this.jdField_a_of_type_Ocr.b();
      return;
    }
    if (this.w) {
      this.jdField_a_of_type_Alrv.k();
    }
    findViewById(2131304138).setVisibility(8);
    this.jdField_a_of_type_Ocr.a();
    paramString1 = getSupportFragmentManager().beginTransaction();
    paramString1.setCustomAnimations(paramInt1, paramInt2);
    paramString1.hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment);
    paramString1.commitAllowingStateLoss();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoySecondCommentListFragment.d();
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setCommentListView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentTopGestureLayout.setRootView(this.jdField_b_of_type_AndroidViewView, true);
    this.jdField_a_of_type_Qxb.notifyDataSetChanged();
  }
  
  public List<Integer>[] a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    Object localObject = befm.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
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
          if (((i2 & 0x4000) == 0L) && (axea.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl)))
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
              axea.a(0, 2);
            }
          }
          if ((this.jdField_a_of_type_Alrv != null) && (this.jdField_a_of_type_Alrv.a()) && (this.w))
          {
            if (!this.jdField_a_of_type_Alrv.c()) {
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
      localObject1 = new pqg();
      localReportInfo.mUin = obz.a();
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
        ((pqg)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_Pqo != null) {
          ((pqg)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        }
        ((pqg)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((pqg)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_d_of_type_Int;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((pqg)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (pqo)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((pqg)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((pqo)localObject3).jdField_a_of_type_Long));
            }
          }
        }
      }
      localReportInfo.mOperation = 29;
      localReportInfo.mOpSource = 12;
      localReportInfo.mFeedsReportData = ((pqg)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ogy.a().a((List)localObject1);
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      rau.b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_Qxb.notifyDataSetChanged();
      return;
    }
    rau.c(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Qxb.notifyDataSetChanged();
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
    Object localObject = new nwa(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, null).a(1);
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | begin");
    if (this.jdField_r_of_type_Boolean)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2CommentArea");
      if (this.jdField_p_of_type_Int == 0)
      {
        ndn.a((QQAppInterface)getAppInterface(), nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009C69", "0X8009C69", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, "", false);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "mCommentAreaLastFirstVisItemPos == 0 return");
        return;
      }
      this.jdField_r_of_type_Int = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int);
      this.jdField_r_of_type_Boolean = false;
      this.jdField_f_of_type_Boolean = true;
      ((nwa)localObject).d(1);
      this.jdField_a_of_type_Ocr.a();
      localObject = ((nwa)localObject).a();
      ndn.a((QQAppInterface)getAppInterface(), nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
    }
    for (;;)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "scrollToLastReadPos | done");
      return;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "Scroll2ArticleArea");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setSelectionFromTop(this.jdField_n_of_type_Int, this.jdField_o_of_type_Int);
      this.jdField_r_of_type_Boolean = true;
      ((nwa)localObject).d(2);
      localObject = ((nwa)localObject).a();
      ndn.a((QQAppInterface)getAppInterface(), nvx.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo), "0X8009749", "0X8009749", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID), String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mStrategyId), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID, (String)localObject, false);
      this.jdField_a_of_type_Ocr.b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Qxe != null) {}
    for (int i1 = this.jdField_a_of_type_Qxe.getCount();; i1 = 0)
    {
      this.jdField_p_of_type_Int = i1;
      this.jdField_q_of_type_Int = 0;
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "initCommentAreaAnchor mCommentAreaLastFirstVisItemPos = " + this.jdField_p_of_type_Int);
      return;
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_Rug != null) && (this.jdField_a_of_type_Rug.a())) {}
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
          aciy.a("Q.readinjoy.fast_web", "  " + paramBundle, new IllegalArgumentException());
          finish();
          return true;
        }
        awrn.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebdoOnCreateSucc", true, 0L, 0L, null, null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = ((ArticleInfo)((Bundle)localObject).get("fast_web_article_info"));
      this.jdField_c_of_type_Int = ((Bundle)localObject).getInt("fast_web_from_channel_id");
      this.jdField_s_of_type_Boolean = getIntent().getBooleanExtra("from_color_note", false);
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "is from colorNote : " + this.jdField_s_of_type_Boolean);
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
        this.jdField_c_of_type_JavaLangString = (obz.a() + System.currentTimeMillis());
        localObject = getSupportFragmentManager();
        if ((paramBundle == null) || (localObject == null)) {
          break label428;
        }
        paramBundle = ((FragmentManager)localObject).getFragments();
        if ((paramBundle == null) || (paramBundle.size() <= 0)) {
          break label428;
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
      label428:
      ndn.a(null, "CliOper", "", "", "0X8009C4F", "0X8009C4F", 0, 0, "", Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), "", false);
      try
      {
        setContentView(2131494342);
        l();
        if (this.jdField_a_of_type_Qxe != null) {
          this.jdField_a_of_type_Qxe.a();
        }
        h();
        this.jdField_a_of_type_AndroidUtilSparseArray = qzy.a();
        return true;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          BaseApplicationImpl.sImageCache.evict(0);
          try
          {
            setContentView(2131494342);
            l();
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
      ocr.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      if ((this.jdField_a_of_type_Nvf != null) && (this.jdField_a_of_type_Nvf.a() != null))
      {
        localObject = this.jdField_a_of_type_Nvf.a();
        ((nvu)localObject).a(this.jdField_a_of_type_Ocr.b(), this.jdField_r_of_type_Int);
        ((nvu)localObject).a(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getLastVisiblePosition() - this.jdField_a_of_type_Qxe.getCount());
      }
    }
    ohb.a().b(this.jdField_b_of_type_Ohe);
    ohb.a().b(this.jdField_a_of_type_Ohe);
    if (this.jdField_a_of_type_Qxe != null) {
      this.jdField_a_of_type_Qxe.d();
    }
    if (this.jdField_a_of_type_Qxb != null) {
      this.jdField_a_of_type_Qxb.a();
    }
    if (this.jdField_a_of_type_Nvf != null) {
      this.jdField_a_of_type_Nvf.d();
    }
    G();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Xdt != null) {
      this.jdField_a_of_type_Xdt.c();
    }
    this.jdField_a_of_type_Xdt = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebEventItemShowDispatcher.a();
    }
    if (this.jdField_a_of_type_Rbc != null) {
      this.jdField_a_of_type_Rbc.a();
    }
    if (this.jdField_a_of_type_Rug != null) {
      this.jdField_a_of_type_Rug.b();
    }
    rav.a();
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.a(null);
      this.jdField_a_of_type_Azwg = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyFastWebBottomSocialViewNew.a();
    }
    pyu.a().jdField_b_of_type_Boolean = false;
    Object localObject = ogy.a().a();
    if (localObject != null) {
      ((oph)localObject).a();
    }
    if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null)
    {
      getMainLooper();
      Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    }
    if (this.jdField_a_of_type_Nax != null) {
      this.jdField_a_of_type_Nax.b();
    }
    A();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
      if (!this.jdField_c_of_type_Boolean) {
        afun.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      }
    }
    this.jdField_a_of_type_Raj.a();
    this.jdField_a_of_type_Raj = null;
    nio.a().b(5555, this);
    nio.a().b(6666, this);
    if (this.jdField_a_of_type_Alrv != null)
    {
      this.jdField_a_of_type_Alrv.c();
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
          if (this.jdField_a_of_type_Rbc == null) {
            this.jdField_a_of_type_Rbc = new rbc(this);
          }
          this.jdField_a_of_type_Rbc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleContentUrl);
          this.jdField_a_of_type_Rbc.a((String)localObject, paramIntent.getStringExtra("image_path"), paramIntent.getIntExtra("EditPicType", 0));
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
        localObject1 = obz.a(this, (ArticleInfo)localObject2, 0, (String)localObject1);
      }
      try
      {
        float f1 = (float)(System.currentTimeMillis() - this.jdField_d_of_type_Long) / 1000.0F;
        float f2 = a();
        ((JSONObject)localObject1).put("read_time", f1);
        ((JSONObject)localObject1).put("read_ratio", f2);
        ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
        ((JSONObject)localObject1).put("channel_id", "" + raz.a(this.jdField_m_of_type_Boolean, this.jdField_b_of_type_Long));
        QLog.d("Q.readinjoy.fast_web", 2, "  time " + f1 + "  ratio : " + f2 + " session : " + this.jdField_c_of_type_JavaLangString);
        raz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898E", ((JSONObject)localObject1).toString());
        long l1 = System.currentTimeMillis() - this.jdField_e_of_type_Long;
        if (!this.jdField_q_of_type_Boolean) {}
        try
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("folder_status", obz.jdField_d_of_type_Int);
          ((JSONObject)localObject1).put("algorithm_id", this.jdField_f_of_type_Long);
          ((JSONObject)localObject1).put("feeds_friends_interaction", 0);
          ((JSONObject)localObject1).put("session_id", this.jdField_c_of_type_JavaLangString);
          ((JSONObject)localObject1).put("os", "1");
          ((JSONObject)localObject1).put("version", "8.2.6".replace(".", ""));
          ((JSONObject)localObject1).put("rowkey", this.jdField_a_of_type_JavaLangString);
          localObject2 = ((JSONObject)localObject1).toString();
          if (!rvf.a(this.jdField_b_of_type_Long)) {
            break label664;
          }
          localObject1 = "0X8009359";
          ndn.a(null, "CliOper", "", "", (String)localObject1, (String)localObject1, 0, 0, Long.toString(l1 / 1000L), Long.toString(this.jdField_a_of_type_Long), Integer.toString(this.jdField_i_of_type_Int), (String)localObject2, false);
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
        ((ReportInfo)localObject2).mUin = obz.a();
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
        ThreadManager.getSubThreadHandler().post(new FastWebActivity.16(this, (List)localObject1));
        if (this.jdField_a_of_type_Qxe != null) {
          this.jdField_a_of_type_Qxe.c();
        }
        if (obz.jdField_e_of_type_Boolean) {
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null) && (!this.jdField_b_of_type_Boolean)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onBackground();
        }
        if (this.jdField_a_of_type_Alrv == null) {
          continue;
        }
        this.jdField_a_of_type_Alrv.b();
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
    rbf.b("fast_web_show_light_house_3");
    f();
    AbstractGifImage.resumeAll();
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Qxb != null) {
      this.jdField_a_of_type_Qxb.notifyDataSetChanged();
    }
    if (this.jdField_a_of_type_Qxe != null) {
      this.jdField_a_of_type_Qxe.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ocr.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
      ogy.a().d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(this, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (obz.jdField_e_of_type_Boolean)
    {
      if (obz.jdField_d_of_type_Boolean) {
        obz.a(4, this.jdField_c_of_type_Long);
      }
      k();
    }
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser != null)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.onForeground();
    }
    if (this.jdField_a_of_type_Alrv != null)
    {
      this.jdField_a_of_type_Alrv.a();
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mColorNoteController.onResume");
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
      ocr.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
      this.jdField_a_of_type_Ocr.b();
    }
    if ((isFinishing()) || (this.jdField_q_of_type_Boolean))
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "fastwebActivity doOnStop | removeCommentDataManager");
      nxd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    }
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void e()
  {
    rau.b(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Qxb.notifyDataSetChanged();
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
      if ((!azzu.b()) && (!azzu.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      b(true);
      this.mSystemBarComp.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
    {
      this.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    this.mSystemBarComp.setStatusBarColor(-1);
    this.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  public void finish()
  {
    if ((this.t) && (!this.u))
    {
      C();
      return;
    }
    if (this.jdField_a_of_type_Qzq.a())
    {
      if (this.jdField_a_of_type_Alrv == null) {
        c(this);
      }
      if ((this.jdField_a_of_type_Alrv != null) && (!this.u))
      {
        C();
        return;
      }
      if (this.jdField_j_of_type_Int == 1001)
      {
        if (this.jdField_d_of_type_Int != 70) {
          break label191;
        }
        KandianSubscribeManager.a(this, 2);
      }
      if (this.jdField_g_of_type_Long != 0L) {
        raz.a(NetConnInfoCenter.getServerTime() - this.jdField_g_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, getApplicationContext());
      }
    }
    this.jdField_k_of_type_Boolean = true;
    F();
    H();
    D();
    ohb.a().b(this.jdField_b_of_type_Ohe);
    String str1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      str1 = "";
      label152:
      if (!this.jdField_n_of_type_Boolean) {
        break label273;
      }
    }
    label273:
    for (String str2 = "1";; str2 = "2")
    {
      ndn.a(null, "CliOper", "", str1, "0X8008995", "0X8008995", 0, 0, str2, null, null, null, false);
      L();
      return;
      label191:
      if (this.jdField_d_of_type_Int == 0)
      {
        nji.a(this.app, this, 11, 0);
        break;
      }
      if (odm.c(this.jdField_d_of_type_Int))
      {
        KandianDailyManager.a(this);
        break;
      }
      if (!bgmq.i()) {
        break;
      }
      nji.b(this, 11);
      break;
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSubscribeID + "";
      break label152;
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
    localMiniMsgUserParam.unreadView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131304579));
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
        obz.a(this, ((ArticleInfo)paramIntent.getExtras().get("fast_web_article_info")).mArticleContentUrl);
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
                        if ((this.jdField_l_of_type_Boolean) && (this.jdField_a_of_type_Qzs == null))
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
                      paramIntent = nxd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
                      if (paramIntent == null)
                      {
                        paramIntent = this.jdField_b_of_type_JavaLangString;
                        localObject = new StringBuilder().append("commentDataManage is null, src : ").append(paramInt1).append(", hasInit : ");
                        if (this.jdField_a_of_type_JavaUtilList != null) {}
                        for (;;)
                        {
                          aciy.a(paramIntent, bool, new NullPointerException());
                          return;
                          bool = false;
                        }
                      }
                    } while (this.jdField_a_of_type_Nvf == null);
                    if (paramInt1 == 2)
                    {
                      paramIntent.d((String)localObject, this.jdField_a_of_type_Nvf.b());
                      return;
                    }
                  } while (paramInt1 != 3);
                  paramIntent.c((String)localObject, this.jdField_a_of_type_Nvf.b());
                  return;
                  if ((paramInt1 != 1001) || (paramIntent == null)) {
                    break;
                  }
                  paramIntent = paramIntent.getSerializableExtra("backToImageData");
                } while (!(paramIntent instanceof List));
                paramIntent = (List)paramIntent;
              } while (paramIntent.isEmpty());
              ThreadManager.getUIHandler().post(new FastWebActivity.23(this, paramIntent));
              QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update comments info from commentlist activity ! size : " + paramIntent.size());
              return;
              if (paramInt1 == 2002)
              {
                if ((paramInt2 == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null))
                {
                  paramIntent = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
                  paramIntent.jdField_c_of_type_Long += 1L;
                  ThreadManager.getUIHandler().post(new FastWebActivity.24(this));
                }
                paramIntent = getAppInterface();
                localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
                if (paramInt2 == -1) {}
                for (bool = true;; bool = false)
                {
                  raz.a(this, paramIntent, (ArticleInfo)localObject, 0, -1, false, bool);
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
                  raz.a(this, paramIntent, (ArticleInfo)localObject, 1, -1, false, bool);
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
    bbmy.a(this, -1, getString(2131633876), 0).b(getTitleBarHeight());
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
    if ((paramView.getId() != 2131302804) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo == null)) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302804: 
      this.jdField_n_of_type_Boolean = true;
      finish();
      return;
    case 2131309522: 
      a(true);
      return;
    }
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.isStackFromBottom()) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.setStackFromBottom(false);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView != null)
    {
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildCount())
      {
        qxr localqxr = (qxr)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListView.getChildAt(paramInt1).getTag();
        if (localqxr != null) {
          localqxr.a(paramString, paramBitmap);
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onGoToConversation()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onGoToConversation..");
    }
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.getUIHandler().post(new FastWebActivity.35(this));
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
        ((MiniMsgUserParam)localObject).backConversationIntent = obz.a(this, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_c_of_type_Int, this.jdField_m_of_type_Boolean);
        ((MiniMsgUserParam)localObject).isNeedBackConversation = true;
        ArticleInfo localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        ArticleInfo localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
        int i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())
        {
          localObject = "2";
          raz.a(localArticleInfo1, "0X800A09C", obz.a(this, localArticleInfo2, i1, (String)localObject).toString());
          localArticleInfo1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          localArticleInfo2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
          i1 = (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID;
          if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
            break label230;
          }
          localObject = "2";
          raz.a(localArticleInfo1, "0X800A09D", obz.a(this, localArticleInfo2, i1, (String)localObject).toString());
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