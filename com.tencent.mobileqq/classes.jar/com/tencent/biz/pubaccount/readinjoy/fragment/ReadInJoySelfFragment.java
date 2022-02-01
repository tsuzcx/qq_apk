package com.tencent.biz.pubaccount.readinjoy.fragment;

import afur;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anni;
import bgey;
import bgku;
import bgln;
import bkjh;
import bmqa;
import bmqc;
import bmqd;
import bqcd;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyDraftboxActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MySelfNormalItemRedPointInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyMenuIconView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import oat;
import ogz;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pgc;
import pgn;
import pha;
import phi;
import pmb;
import pmh;
import pmk;
import pmn;
import pqf;
import pqg;
import pqh;
import pqi;
import pqj;
import pqk;
import pql;
import pqm;
import pqn;
import pqo;
import pqp;
import pqq;
import pqr;
import pqs;
import pqt;
import pqu;
import pqv;
import pqw;
import pqx;
import pqy;
import pqz;
import pra;
import prb;
import prc;
import prd;
import pre;
import prf;
import prg;
import prh;
import pri;
import prj;
import prk;
import prl;
import prm;
import pro;
import prp;
import prq;
import prr;
import prs;
import prt;
import pru;
import prv;
import prw;
import prx;
import pwr;
import pyk;
import rjh;
import rvd;
import sti;
import stj;
import tlg;
import zby;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, pmb
{
  public float a;
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
  public View a;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyHeadImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView;
  private ReadInJoyNickNameTextView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView;
  private ReadInjoyMenuIconView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  public URLImageView a;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private PressEffectLinearLayout jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  Map<Integer, prw> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected pmn a;
  @Nullable
  private pwr jdField_a_of_type_Pwr;
  private stj jdField_a_of_type_Stj;
  protected boolean a;
  public float b;
  int jdField_b_of_type_Int;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private View jdField_b_of_type_AndroidViewView;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianMergeManager jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private ReadInjoyMenuIconView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private HashMap<Integer, prx> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  public float c;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ReadInjoyMenuIconView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  public float d;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ReadInjoyMenuIconView jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private int jdField_e_of_type_Int;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  public ReadInJoySelfFragment()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Pmn = new prp(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371361), new prt(this));
  }
  
  private void B()
  {
    pru localpru = new pru(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379630), localpru);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370359), localpru);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370472), localpru);
  }
  
  private void C()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131377315), new prv(this));
  }
  
  private void D()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131377630), new pqg(this));
  }
  
  private void E()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366521), new pqh(this));
  }
  
  private void F()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365264), new pqi(this));
  }
  
  private void G()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366896), new pqj(this));
  }
  
  private void H()
  {
    pqk localpqk = new pqk(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370354), localpqk);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366245), localpqk);
  }
  
  private void I()
  {
    pql localpql = new pql(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370643), localpql);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131367981), localpql);
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379044), new pqm(this));
  }
  
  private void K()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364625), new pqn(this));
  }
  
  private void L()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365712), new pqo(this));
  }
  
  private void M()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131380963), new pqp(this));
  }
  
  private void N()
  {
    pqq localpqq = new pqq(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369045), localpqq);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370349), localpqq);
  }
  
  private void O()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370636), new pqr(this));
  }
  
  private void P()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370648), new pqs(this));
  }
  
  private void Q()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370637), new pqt(this));
  }
  
  private void R()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369825), new pqu(this));
  }
  
  private void S()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368138), new pqv(this));
  }
  
  private void T()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365747), new pqw(this));
  }
  
  private void U()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364770), new pqx(this));
  }
  
  private void V()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371830), new pqy(this));
  }
  
  private void W()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370568), new pqz(this));
  }
  
  private void X()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131372969), new prb(this));
  }
  
  private void Y()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369408), new prc(this));
  }
  
  private void Z()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131381085), new prd(this));
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, afur.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new prj(this));
    localValueAnimator.setDuration(300L);
    return localValueAnimator;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt1);
    } while (localView == null);
    if (paramInt4 == 0)
    {
      ((TextView)localView.findViewById(paramInt2)).setText(paramString);
      localView.setVisibility(0);
      a(paramInt3, localView, paramString, null, true);
    }
    for (;;)
    {
      localView.setOnClickListener(this);
      return;
      localView.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramView == null) {
      return;
    }
    paramView = new prx((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramView);
    d(paramInt1);
  }
  
  public static void a(Activity paramActivity) {}
  
  private void a(Context paramContext)
  {
    String str1 = String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
    String str2 = Aladdin.getConfig(302).getString("url", null);
    if (TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      pha.a(paramContext, str1);
      return;
      str1 = URLDecoder.decode(str2);
    }
  }
  
  private void a(bmqc parambmqc)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371361);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      if (parambmqc.jdField_b_of_type_Int == 0)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371362)).setText(parambmqc.jdField_a_of_type_JavaLangString);
        localView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(bmqc parambmqc, List<bmqd> paramList)
  {
    if (paramList != null) {
      a(2131367981, 2131367982, parambmqc.jdField_a_of_type_JavaLangString, 2, parambmqc.jdField_b_of_type_Int);
    }
    for (;;)
    {
      a(parambmqc.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131367989, 2131367990, 2131367991, 2131367992);
      return;
      a(2131367981, 2131367982, parambmqc.jdField_a_of_type_JavaLangString, 3, parambmqc.jdField_b_of_type_Int);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 1;
    phi localphi1 = new phi();
    boolean bool1 = rjh.g();
    boolean bool2 = rjh.c();
    phi localphi2;
    if (bool1)
    {
      j = 1;
      localphi2 = localphi1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localphi2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localphi1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      oat.a(paramString, localphi1.a());
      return;
      j = 0;
      break;
    }
  }
  
  private void a(List<bmqd> paramList)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371361);
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    a(2131367981, 2131367982, anni.a(2131711737), 2, 0);
    a(13, this.jdField_a_of_type_AndroidViewView, 2131367989, 2131367990, 2131367991, 2131367992);
    a(2131364625, 2131364626, anni.a(2131711481), 2, 0);
    a(12, this.jdField_a_of_type_AndroidViewView, 2131364629, 2131364630, 2131364631, 2131364632);
    if (paramList != null)
    {
      a(2131379044, 2131379045, anni.a(2131711833), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131379061, 2131379062, 2131379063, 2131379064);
      a(2131377630, 2131377631, anni.a(2131711789), 2, 0);
      a(14, this.jdField_a_of_type_AndroidViewView, 2131377632, 2131377633, 2131377634, 2131377635);
      if (!pgc.jdField_a_of_type_Boolean) {
        break label275;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131377315, 2131377316, anni.a(2131711480), this.jdField_f_of_type_Int, 0);
    }
    for (;;)
    {
      a(15, this.jdField_a_of_type_AndroidViewView, 2131377326, 2131377327, 2131377328, 2131377329);
      a(2131365712, 2131365713, anni.a(2131711661), 2, 0);
      return;
      a(2131379044, 2131379045, anni.a(2131711762), 3, 0);
      break;
      label275:
      this.jdField_f_of_type_Int = 3;
      a(2131377315, 2131377316, anni.a(2131711767), this.jdField_f_of_type_Int, 0);
    }
  }
  
  private void a(List<bmqc> paramList, List<bmqd> paramList1)
  {
    int j;
    if ((paramList != null) && (paramList.size() > 0)) {
      j = 0;
    }
    while (j < paramList.size())
    {
      a(paramList, paramList1, j);
      j += 1;
      continue;
      a(paramList1);
    }
  }
  
  private void a(List<bmqc> paramList, List<bmqd> paramList1, int paramInt)
  {
    paramList = (bmqc)paramList.get(paramInt);
    if (paramList.jdField_a_of_type_Int == 10) {
      a(paramList);
    }
    do
    {
      return;
      if (paramList.jdField_a_of_type_Int == 11)
      {
        a(2131379044, 2131379045, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131379061, 2131379062, 2131379063, 2131379064);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 12)
      {
        a(2131364625, 2131364626, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364629, 2131364630, 2131364631, 2131364632);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 13)
      {
        a(paramList, paramList1);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 14)
      {
        a(2131377630, 2131377631, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377632, 2131377633, 2131377634, 2131377635);
        return;
      }
    } while (paramList.jdField_a_of_type_Int != 15);
    this.jdField_f_of_type_Int = 2;
    a(2131377315, 2131377316, paramList.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, paramList.jdField_b_of_type_Int);
    a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377326, 2131377327, 2131377328, 2131377329);
  }
  
  private void a(@NotNull pwr parampwr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + parampwr);
    }
    this.jdField_a_of_type_Pwr = parampwr;
    View localView;
    if (parampwr.jdField_a_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371523);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368898)).setText(2131717167);
    }
    if (parampwr.jdField_b_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371522);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368898)).setText(2131717166);
    }
    rjh.a(getActivity(), 1, parampwr.jdField_b_of_type_JavaLangString);
    rjh.a(getActivity(), 2, parampwr.jdField_a_of_type_JavaLangString);
    rjh.a(getActivity(), 3, parampwr.jdField_c_of_type_JavaLangString);
  }
  
  private void aa()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371523), new pre(this));
  }
  
  private void ab()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371522), new prf(this));
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371519), new prg(this));
  }
  
  private void ad()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373084), new prh(this));
  }
  
  private void ae()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373087), new pri(this));
  }
  
  private void af()
  {
    pha.b(this.jdField_a_of_type_AndroidViewView.getContext(), pgc.u);
    String str = new phi().b().a();
    if (!TextUtils.isEmpty(str)) {
      oat.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bmqa.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", str, false);
    }
  }
  
  private void ag()
  {
    Object localObject = bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int j;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
    {
      at();
      j = 0;
    }
    for (;;)
    {
      if (j > 0)
      {
        localObject = new phi().b().a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          oat.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bmqa.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", (String)localObject, false);
        }
      }
      return;
      if ((localObject != null) && (((List)localObject).size() > 1))
      {
        c((List)localObject);
        j = 1;
      }
      else
      {
        pha.b(this.jdField_a_of_type_AndroidViewView.getContext(), pgc.v);
        j = 2;
      }
    }
  }
  
  private void ah()
  {
    new sti(getActivity()).a(String.format(anni.a(2131711628), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), anni.a(2131711892));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("number", String.valueOf(bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      oat.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", pha.a(localJSONObject), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void ai()
  {
    try
    {
      ogz localogz = (ogz)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
      if (localogz != null) {
        pha.a(getActivity(), localogz);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.readinjoy.self.SelfFragment", 1, "handleMedalImg error! msg=" + localException);
        Object localObject = null;
      }
    }
  }
  
  private void aj()
  {
    String str = rjh.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    if (!TextUtils.isEmpty(str)) {
      pha.a(getActivity(), str);
    }
    for (;;)
    {
      a("0X800AC6F", 0);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myVideoJumpUrl is empty");
    }
  }
  
  private void ak()
  {
    String str = rjh.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (!TextUtils.isEmpty(str)) {
      pha.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Pwr != null)
    {
      a("0X800AC74", this.jdField_a_of_type_Pwr.jdField_b_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    a("0X800AC74", 0);
  }
  
  private void al()
  {
    String str = rjh.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
    if (!TextUtils.isEmpty(str)) {
      pha.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Pwr != null)
    {
      a("0X800AC7C", this.jdField_a_of_type_Pwr.jdField_c_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    a("0X800AC7C", 0);
  }
  
  private void am()
  {
    rjh.a(getActivity(), null, 1);
  }
  
  private void an()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)bmqa.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131717168, 0).a();
    }
    for (;;)
    {
      rjh.a(getActivity(), localColumnInfo, 3);
      return;
      localColumnInfo.columnID = j;
    }
  }
  
  private void ao()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void ap()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void aq()
  {
    Object localObject = pha.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = pgc.g + bgku.encodeToString(((String)localObject).getBytes(), 2);
    if (!bmqa.t())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      pha.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    tlg.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bgku.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void ar()
  {
    oat.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
    startActivity(new Intent(getActivity(), ReadInJoyDraftboxActivity.class));
    PublicFragmentActivity.a(getActivity(), ReadInJoyDraftboxFragment.class);
  }
  
  private void as()
  {
    Object localObject1 = ReadInJoyUserInfoModule.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), null);
    if (localObject1 != null)
    {
      localObject2 = ReadInJoyUserInfoModule.a((ReadInJoyUserInfo)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    else
    {
      return;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(localObject2);
    Object localObject2 = new Intent(getActivity(), TroopAvatarWallPreviewActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putInt("index", 0);
    localBundle.putStringArrayList("seqNum", (ArrayList)localObject1);
    localBundle.putBoolean("needBottomBar", false);
    localBundle.putBoolean("IS_EDIT", false);
    localBundle.putBoolean("is_use_path", true);
    localBundle.putBoolean("is_show_action", true);
    localBundle.putBoolean("is_not_show_index", false);
    ((Intent)localObject2).putExtras(localBundle);
    getActivity().startActivity((Intent)localObject2);
  }
  
  private void at()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_b_of_type_AndroidAnimationValueAnimator == null) {
        this.jdField_b_of_type_AndroidAnimationValueAnimator = b();
      }
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillEnabled(true);
        this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationRotateAnimation);
      return;
      if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -afur.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new prk(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void au()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    rvd.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void av()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    rvd localrvd = rvd.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localrvd.a(str, j);
      return;
    }
  }
  
  private void aw()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void ax()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setHeadImgByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin(), false);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.setNickNameByUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
        this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView.getText());
      }
    }
    int j;
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      j = bmqa.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bmqa.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bmqa.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bmqa.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Stj != null) {
        this.jdField_a_of_type_Stj.a(bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label401;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        label218:
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "bindUserInfoViews userDesc = " + (String)localObject);
        }
      }
      long l;
      if (this.jdField_e_of_type_AndroidWidgetTextView != null)
      {
        l = bmqa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bmqa.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bmqa.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bool) {
          break label430;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label354:
      if ((!bool) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        if (bmqa.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label442;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      az();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label401:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label218;
      label430:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label354;
      label442:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void ay()
  {
    try
    {
      this.jdField_a_of_type_Float = getResources().getDimension(2131298683);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298685);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298686);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298684);
      this.jdField_b_of_type_Int = ((int)bgln.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void az()
  {
    ogz localogz = bmqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localogz == null) || (localogz.jdField_c_of_type_Int <= 0) || (localogz.d <= 0) || (TextUtils.isEmpty(localogz.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368271);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new prq(this, localImageView, localogz));
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    MySelfNormalItemRedPointInfo localMySelfNormalItemRedPointInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localMySelfNormalItemRedPointInfo != null)
    {
      if ((localMySelfNormalItemRedPointInfo.redPointType == 0) || (TextUtils.isEmpty(localMySelfNormalItemRedPointInfo.imgUrl))) {
        return 2;
      }
      return 3;
    }
    return 1;
  }
  
  private ValueAnimator b()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getHeight(), 0 });
    localValueAnimator.addUpdateListener(new prm(this));
    localValueAnimator.addListener(new pro(this));
    localValueAnimator.setDuration(300L);
    return localValueAnimator;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e(paramInt);
    d(paramInt);
  }
  
  private void b(List<bmqd> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365290);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
      int j = 0;
      if (j < paramList.size())
      {
        bmqd localbmqd = (bmqd)paramList.get(j);
        View localView = localLayoutInflater.inflate(2131561468, null);
        TextView localTextView = (TextView)localView.findViewById(2131368898);
        a(localbmqd.jdField_a_of_type_Int, localView, 2131368904, 2131368905, 2131368906, 2131368907);
        String str;
        if (localbmqd.jdField_a_of_type_JavaLangString == null)
        {
          str = "";
          label120:
          localTextView.setText(str);
          if ((localbmqd == null) || (j == paramList.size() - 1)) {
            break label189;
          }
          a(2, localbmqd.jdField_a_of_type_Int, localView, localbmqd.jdField_a_of_type_JavaLangString, localbmqd.jdField_b_of_type_JavaLangString, true);
          localLinearLayout.addView(localView);
        }
        for (;;)
        {
          j += 1;
          break;
          str = localbmqd.jdField_a_of_type_JavaLangString;
          break label120;
          label189:
          if (localbmqd != null)
          {
            a(3, localbmqd.jdField_a_of_type_Int, localView, localbmqd.jdField_a_of_type_JavaLangString, localbmqd.jdField_b_of_type_JavaLangString, true);
            localLinearLayout.addView(localView);
          }
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    a(2131365712, 2131365713, anni.a(2131711896), 2, 0);
    List localList1 = bmqa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList2 = bmqa.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377315);
    a(localList1, localList2);
    b(localList2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368138));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371550));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370472).setOnClickListener(this);
    d();
    h();
    if (pgn.a()) {
      a(2131372969, 2131372972, "PTS全家桶", 3, 0);
    }
    this.h = bmqa.u();
    if (((Integer)bmqa.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1) {
      bool = true;
    }
    this.i = bool;
    m();
    n();
    o();
    p();
    q();
    l();
    r();
    s();
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377304);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368182);
    t();
    u();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377169));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370568));
    v();
    w();
    ax();
    z();
    bmqa.i();
  }
  
  private void c(List<pyk> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = afur.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Stj.a(paramList);
      if (!this.jdField_f_of_type_Boolean) {
        break label158;
      }
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator = a();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillEnabled(true);
        this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
      return;
      j = afur.a(7.5F, getResources());
      break;
      label158:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -afur.a(70.0F, getResources()), 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377272).setVisibility(8);
      return;
    }
    int k = afur.a(44.5F, getResources());
    int j = k;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    Switch localSwitch = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131369419);
    localSwitch.setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
    localSwitch.setTrackResource(2130842458);
    localSwitch.setThumbResource(2130842457);
    localSwitch.setOnClickListener(this);
    localSwitch.setOnCheckedChangeListener(new pqf(this));
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    prx localprx = (prx)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localprx == null) || (localprx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localprx.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localprx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      bkjh.a(localprx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130850392, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      bkjh.a(localprx.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localprx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    bkjh.a(localprx.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bgey.a);
    localprx.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localprx.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130846360);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localprx.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (pgc.jdField_a_of_type_Boolean)
    {
      a(2131366521, 2131366522, anni.a(2131711687), 3, 0);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366521);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    ((TextView)localView.findViewById(2131374409)).setText(pgc.l);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377315);
    this.jdField_f_of_type_Int = 2;
    localView.setBackgroundResource(2130839442);
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377170);
    if ((this.h) || (this.i))
    {
      localLinearLayout.setVisibility(0);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  private void n()
  {
    int k = 1;
    int j;
    if (Aladdin.getConfig(302).getIntegerFromString("me_mywallet_switch", 0) == 1)
    {
      j = 1;
      if ((!RIJRedPacketManager.a().c()) || (!RIJRedPacketManager.a().e())) {
        break label82;
      }
    }
    for (;;)
    {
      if ((j != 0) || (k != 0)) {
        a(2131381085, 2131381086, Aladdin.getConfig(302).getString("entrance_title", anni.a(2131717244)), 3, 0);
      }
      return;
      j = 0;
      break;
      label82:
      k = 0;
    }
  }
  
  private void o()
  {
    if (this.h) {
      a(2131364770, 2131364771, anni.a(2131711876), 3, 0);
    }
  }
  
  private void p()
  {
    if (this.i) {
      a(2131371830, 2131371829, anni.a(2131711868), 3, 0);
    }
  }
  
  private void q() {}
  
  private void r()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366896);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366913));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        int j = bmqa.y(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(bmqa.a(j));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
        }
      }
    }
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366245);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366250));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366248));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363992));
      this.jdField_a_of_type_Stj = new stj(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Stj);
    }
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367002);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (bmqa.a(getActivity().getAppRuntime()).booleanValue()) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364961));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new pra(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377169));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370568));
    v();
    w();
    ax();
  }
  
  private void v()
  {
    String str = getResources().getString(2131717167);
    if (rjh.g())
    {
      j = 0;
      a(2131371523, 2131368898, str, 2, j);
      str = getResources().getString(2131717166);
      if (!rjh.f()) {
        break label92;
      }
    }
    label92:
    for (int j = 0;; j = 1)
    {
      a(2131371522, 2131368898, str, 2, j);
      a(2131371519, 2131368898, getResources().getString(2131717164), 2, 0);
      return;
      j = 1;
      break;
    }
  }
  
  private void w()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = afur.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -afur.a(100.0F, getResources()), afur.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new prl(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new prr(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369045));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370349));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370364));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370359));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379895));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379630));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365754));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369835));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380939);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370636));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370643));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370648));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370637));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379969));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364625).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367981).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379044).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377630).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369825).setOnClickListener(this);
      long l = bmqa.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bmqa.a(l, 9900000L, "999万", "0"));
      l = bmqa.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bmqa.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365747).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label663;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - afur.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370361)).setPadding(0, afur.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370354).setOnClickListener(this);
      x();
      y();
      oat.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label663:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846374);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846371);
      }
    }
  }
  
  private void x()
  {
    int j = bqcd.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370352);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (zby.b(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (zby.b(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (zby.b(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(pha.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376059);
      if (localViewStub != null) {
        localViewStub.inflate();
      }
    }
  }
  
  private void z()
  {
    ae();
    ad();
    ac();
    ab();
    aa();
    Z();
    Y();
    X();
    W();
    V();
    U();
    T();
    S();
    R();
    Q();
    P();
    O();
    N();
    M();
    L();
    K();
    J();
    I();
    H();
    G();
    F();
    E();
    D();
    C();
    B();
    A();
  }
  
  public int a()
  {
    return -1;
  }
  
  public void a()
  {
    if (this.i) {
      oat.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", pha.e(), false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new prs(this, paramString2, paramInt2, paramString1));
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      paramView.getBackground().setAlpha(255);
      return;
      paramView.setOnClickListener(null);
      break;
      paramView.setBackgroundResource(2130846371);
      continue;
      paramView.setBackgroundResource(2130846374);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842946);
      }
      else
      {
        paramView.setBackgroundResource(2130846373);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842943);
        }
        else
        {
          paramView.setBackgroundResource(2130846372);
          continue;
          paramView.setBackgroundColor(2130846371);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    ax();
  }
  
  protected void a(int paramInt, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramInt, 0, paramView, paramString1, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    l();
    au();
    av();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    pmh.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    aw();
  }
  
  public void ar_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.42(this));
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void f() {}
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
  }
  
  public void l()
  {
    int j = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Int > 0) {}
      for (j = 1;; j = 0)
      {
        bkjh.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380253), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      bkjh.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380253), j, this.jdField_c_of_type_Int, 2130850392, 99, null);
      return;
      j = 0;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    prw localprw = (prw)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramView.getId()));
    if (localprw != null) {
      localprw.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.i("Q.readinjoy.self.SelfFragment", 1, "onClick, no handler, id=" + paramView.getId());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("from_type");
      this.jdField_f_of_type_Boolean = paramBundle.getBoolean("show_type", false);
      this.jdField_g_of_type_Boolean = paramBundle.getBoolean("redTouch", false);
    }
    if ((getActivity() instanceof ReadInJoyNewFeedsActivity)) {
      this.jdField_f_of_type_Boolean = bmqa.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    pmk.a().a(this.jdField_a_of_type_Pmn);
    ay();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560258;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560261;
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(j, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    c();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_a_of_type_AndroidViewAnimationRotateAnimation != null)
    {
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.cancel();
      this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = null;
    }
    if (this.jdField_b_of_type_AndroidViewAnimationRotateAnimation != null)
    {
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.cancel();
      this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    pmk.a().b(this.jdField_a_of_type_Pmn);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onResume()
  {
    super.onResume();
    l();
    pmh.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    a();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment
 * JD-Core Version:    0.7.0.1
 */