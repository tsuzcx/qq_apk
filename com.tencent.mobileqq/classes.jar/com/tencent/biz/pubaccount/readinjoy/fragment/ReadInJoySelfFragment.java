package com.tencent.biz.pubaccount.readinjoy.fragment;

import agej;
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
import anzj;
import bhez;
import bhkv;
import bhlo;
import blkk;
import bnrf;
import bnrh;
import bnri;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyDraftboxActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
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
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import ocd;
import oih;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import oyu;
import ozf;
import ozs;
import paa;
import peu;
import pfa;
import pfd;
import pfh;
import pjd;
import pje;
import pjf;
import pjg;
import pjh;
import pji;
import pjj;
import pjk;
import pjl;
import pjm;
import pjn;
import pjo;
import pjp;
import pjq;
import pjr;
import pjs;
import pjt;
import pju;
import pjv;
import pjw;
import pjx;
import pjy;
import pjz;
import pka;
import pkb;
import pkc;
import pkd;
import pke;
import pkf;
import pkg;
import pkh;
import pki;
import pkj;
import pkk;
import pkl;
import pkm;
import pkn;
import pko;
import pkp;
import pkq;
import pkr;
import pks;
import pkt;
import ppc;
import pqu;
import rab;
import rlz;
import skm;
import skn;
import tbz;
import zft;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, peu
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
  Map<Integer, pks> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected pfh a;
  @Nullable
  private ppc jdField_a_of_type_Ppc;
  private skn jdField_a_of_type_Skn;
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
  private HashMap<Integer, pkt> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Pfh = new pkl(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371468), new pkp(this));
  }
  
  private void B()
  {
    pkq localpkq = new pkq(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379805), localpkq);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370461), localpkq);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370574), localpkq);
  }
  
  private void C()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131377455), new pkr(this));
  }
  
  private void D()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366570), new pje(this));
  }
  
  private void E()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365308), new pjf(this));
  }
  
  private void F()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366947), new pjg(this));
  }
  
  private void G()
  {
    pjh localpjh = new pjh(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370456), localpjh);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366294), localpjh);
  }
  
  private void H()
  {
    pji localpji = new pji(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370747), localpji);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368053), localpji);
  }
  
  private void I()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379208), new pjj(this));
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364671), new pjk(this));
  }
  
  private void K()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365755), new pjl(this));
  }
  
  private void L()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131381143), new pjm(this));
  }
  
  private void M()
  {
    pjn localpjn = new pjn(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369134), localpjn);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370451), localpjn);
  }
  
  private void N()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370740), new pjo(this));
  }
  
  private void O()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370752), new pjp(this));
  }
  
  private void P()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370741), new pjq(this));
  }
  
  private void Q()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369923), new pjr(this));
  }
  
  private void R()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368212), new pjs(this));
  }
  
  private void S()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365790), new pjt(this));
  }
  
  private void T()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364817), new pju(this));
  }
  
  private void U()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371937), new pjv(this));
  }
  
  private void V()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370672), new pjw(this));
  }
  
  private void W()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373082), new pjx(this));
  }
  
  private void X()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369499), new pjz(this));
  }
  
  private void Y()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131381261), new pka(this));
  }
  
  private void Z()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371631), new pkb(this));
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, agej.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new pkg(this));
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
    paramView = new pkt((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
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
      ozs.a(paramContext, str1);
      return;
      str1 = URLDecoder.decode(str2);
    }
  }
  
  private void a(bnrh parambnrh)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371468);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      if (parambnrh.jdField_b_of_type_Int == 0)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371469)).setText(parambnrh.jdField_a_of_type_JavaLangString);
        localView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(bnrh parambnrh, List<bnri> paramList)
  {
    if (paramList != null) {
      a(2131368053, 2131368054, parambnrh.jdField_a_of_type_JavaLangString, 2, parambnrh.jdField_b_of_type_Int);
    }
    for (;;)
    {
      a(parambnrh.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131368061, 2131368062, 2131368063, 2131368064);
      return;
      a(2131368053, 2131368054, parambnrh.jdField_a_of_type_JavaLangString, 3, parambnrh.jdField_b_of_type_Int);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 1;
    paa localpaa1 = new paa();
    boolean bool1 = rab.o();
    boolean bool2 = rab.h();
    paa localpaa2;
    if (bool1)
    {
      j = 1;
      localpaa2 = localpaa1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localpaa2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localpaa1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      ocd.a(paramString, localpaa1.a());
      return;
      j = 0;
      break;
    }
  }
  
  private void a(List<bnri> paramList)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371468);
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    a(2131368053, 2131368054, anzj.a(2131711846), 2, 0);
    a(13, this.jdField_a_of_type_AndroidViewView, 2131368061, 2131368062, 2131368063, 2131368064);
    a(2131364671, 2131364672, anzj.a(2131711590), 2, 0);
    a(12, this.jdField_a_of_type_AndroidViewView, 2131364675, 2131364676, 2131364677, 2131364678);
    if (paramList != null)
    {
      a(2131379208, 2131379209, anzj.a(2131711942), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131379225, 2131379226, 2131379227, 2131379228);
      if (!oyu.jdField_a_of_type_Boolean) {
        break label236;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131377455, 2131377456, anzj.a(2131711589), this.jdField_f_of_type_Int, 0);
    }
    for (;;)
    {
      a(15, this.jdField_a_of_type_AndroidViewView, 2131377466, 2131377467, 2131377468, 2131377469);
      a(2131365755, 2131365756, anzj.a(2131711770), 2, 0);
      return;
      a(2131379208, 2131379209, anzj.a(2131711871), 3, 0);
      break;
      label236:
      this.jdField_f_of_type_Int = 3;
      a(2131377455, 2131377456, anzj.a(2131711876), this.jdField_f_of_type_Int, 0);
    }
  }
  
  private void a(List<bnrh> paramList, List<bnri> paramList1)
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
  
  private void a(List<bnrh> paramList, List<bnri> paramList1, int paramInt)
  {
    paramList = (bnrh)paramList.get(paramInt);
    if (paramList.jdField_a_of_type_Int == 10) {
      a(paramList);
    }
    do
    {
      return;
      if (paramList.jdField_a_of_type_Int == 11)
      {
        a(2131379208, 2131379209, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131379225, 2131379226, 2131379227, 2131379228);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 12)
      {
        a(2131364671, 2131364672, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364675, 2131364676, 2131364677, 2131364678);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 13)
      {
        a(paramList, paramList1);
        return;
      }
    } while (paramList.jdField_a_of_type_Int != 15);
    this.jdField_f_of_type_Int = 2;
    a(2131377455, 2131377456, paramList.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, paramList.jdField_b_of_type_Int);
    a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377466, 2131377467, 2131377468, 2131377469);
  }
  
  private void a(@NotNull ppc paramppc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + paramppc);
    }
    this.jdField_a_of_type_Ppc = paramppc;
    View localView;
    if (paramppc.jdField_a_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371631);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368991)).setText(2131717284);
    }
    if (paramppc.jdField_b_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371630);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368991)).setText(2131717283);
    }
    rab.a(getActivity(), 1, paramppc.jdField_b_of_type_JavaLangString);
    rab.a(getActivity(), 2, paramppc.jdField_a_of_type_JavaLangString);
    rab.a(getActivity(), 3, paramppc.jdField_c_of_type_JavaLangString);
  }
  
  private void aa()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371630), new pkc(this));
  }
  
  private void ab()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371627), new pkd(this));
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373197), new pke(this));
  }
  
  private void ad()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373200), new pkf(this));
  }
  
  private void ae()
  {
    ozs.b(this.jdField_a_of_type_AndroidViewView.getContext(), oyu.u);
    String str = new paa().b().a();
    if (!TextUtils.isEmpty(str)) {
      ocd.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bnrf.w(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", str, false);
    }
  }
  
  private void af()
  {
    Object localObject = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int j;
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
    {
      as();
      j = 0;
    }
    for (;;)
    {
      if (j > 0)
      {
        localObject = new paa().b().a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          ocd.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bnrf.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", (String)localObject, false);
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
        ozs.b(this.jdField_a_of_type_AndroidViewView.getContext(), oyu.v);
        j = 2;
      }
    }
  }
  
  private void ag()
  {
    new skm(getActivity()).a(String.format(anzj.a(2131711737), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), anzj.a(2131712001));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("number", String.valueOf(bnrf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      ocd.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", ozs.a(localJSONObject), false);
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
  
  private void ah()
  {
    try
    {
      oih localoih = (oih)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
      if (localoih != null) {
        ozs.a(getActivity(), localoih);
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
  
  private void ai()
  {
    String str = rab.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    if (!TextUtils.isEmpty(str)) {
      ozs.a(getActivity(), str);
    }
    for (;;)
    {
      a("0X800AC6F", 0);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myVideoJumpUrl is empty");
    }
  }
  
  private void aj()
  {
    String str = rab.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (!TextUtils.isEmpty(str)) {
      ozs.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Ppc != null)
    {
      a("0X800AC74", this.jdField_a_of_type_Ppc.jdField_b_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    a("0X800AC74", 0);
  }
  
  private void ak()
  {
    String str = rab.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
    if (!TextUtils.isEmpty(str)) {
      ozs.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Ppc != null)
    {
      a("0X800AC7C", this.jdField_a_of_type_Ppc.jdField_c_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    a("0X800AC7C", 0);
  }
  
  private void al()
  {
    rab.a(getActivity(), null, 1);
  }
  
  private void am()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)bnrf.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131717285, 0).a();
    }
    for (;;)
    {
      rab.a(getActivity(), localColumnInfo, 3);
      return;
      localColumnInfo.columnID = j;
    }
  }
  
  private void an()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void ao()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void ap()
  {
    Object localObject = ozs.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = oyu.g + bhkv.encodeToString(((String)localObject).getBytes(), 2);
    if (!bnrf.t())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      ozs.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    tbz.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bhkv.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void aq()
  {
    ocd.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
    startActivity(new Intent(getActivity(), ReadInJoyDraftboxActivity.class));
    PublicFragmentActivity.a(getActivity(), ReadInJoyDraftboxFragment.class);
  }
  
  private void ar()
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
  
  private void as()
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -agej.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new pkh(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void at()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    rlz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void au()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    rlz localrlz = rlz.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localrlz.a(str, j);
      return;
    }
  }
  
  private void av()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void aw()
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
      j = bnrf.w(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bnrf.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bnrf.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bnrf.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Skn != null) {
        this.jdField_a_of_type_Skn.a(bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bnrf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bnrf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bnrf.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bnrf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bnrf.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bnrf.v(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label442;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      ay();
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
  
  private void ax()
  {
    try
    {
      this.jdField_a_of_type_Float = getResources().getDimension(2131298696);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298698);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298699);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298697);
      this.jdField_b_of_type_Int = ((int)bhlo.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void ay()
  {
    oih localoih = bnrf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localoih == null) || (localoih.jdField_c_of_type_Int <= 0) || (localoih.d <= 0) || (TextUtils.isEmpty(localoih.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368345);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new pkm(this, localImageView, localoih));
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
    localValueAnimator.addUpdateListener(new pki(this));
    localValueAnimator.addListener(new pkk(this));
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
  
  private void b(List<bnri> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365334);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
      int j = 0;
      if (j < paramList.size())
      {
        bnri localbnri = (bnri)paramList.get(j);
        View localView = localLayoutInflater.inflate(2131561509, null);
        TextView localTextView = (TextView)localView.findViewById(2131368991);
        a(localbnri.jdField_a_of_type_Int, localView, 2131368997, 2131368998, 2131368999, 2131369000);
        String str;
        if (localbnri.jdField_a_of_type_JavaLangString == null)
        {
          str = "";
          label120:
          localTextView.setText(str);
          if ((localbnri == null) || (j == paramList.size() - 1)) {
            break label189;
          }
          a(2, localbnri.jdField_a_of_type_Int, localView, localbnri.jdField_a_of_type_JavaLangString, localbnri.jdField_b_of_type_JavaLangString, true);
          localLinearLayout.addView(localView);
        }
        for (;;)
        {
          j += 1;
          break;
          str = localbnri.jdField_a_of_type_JavaLangString;
          break label120;
          label189:
          if (localbnri != null)
          {
            a(3, localbnri.jdField_a_of_type_Int, localView, localbnri.jdField_a_of_type_JavaLangString, localbnri.jdField_b_of_type_JavaLangString, true);
            localLinearLayout.addView(localView);
          }
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    a(2131365755, 2131365756, anzj.a(2131712005), 2, 0);
    List localList1 = bnrf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList2 = bnrf.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377455);
    a(localList1, localList2);
    b(localList2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368212));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371658));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370574).setOnClickListener(this);
    d();
    h();
    if (ozf.a()) {
      a(2131373082, 2131373085, "PTS全家桶", 3, 0);
    }
    this.h = bnrf.u();
    if (((Integer)bnrf.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1) {
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
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377444);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368256);
    t();
    u();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377309));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370672));
    v();
    w();
    aw();
    z();
    bnrf.h();
  }
  
  private void c(List<pqu> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = agej.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Skn.a(paramList);
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
      j = agej.a(7.5F, getResources());
      break;
      label158:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -agej.a(70.0F, getResources()), 0.0F);
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377412).setVisibility(8);
      return;
    }
    int k = agej.a(44.5F, getResources());
    int j = k;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    Switch localSwitch = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131369510);
    localSwitch.setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
    localSwitch.setTrackResource(2130842471);
    localSwitch.setThumbResource(2130842470);
    localSwitch.setOnClickListener(this);
    localSwitch.setOnCheckedChangeListener(new pjd(this));
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    pkt localpkt = (pkt)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localpkt == null) || (localpkt.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localpkt.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localpkt.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      blkk.a(localpkt.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130850404, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      blkk.a(localpkt.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localpkt.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    blkk.a(localpkt.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bhez.a);
    localpkt.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localpkt.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130846377);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localpkt.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (oyu.jdField_a_of_type_Boolean)
    {
      a(2131366570, 2131366571, anzj.a(2131711796), 3, 0);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366570);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    ((TextView)localView.findViewById(2131374546)).setText(oyu.l);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377455);
    this.jdField_f_of_type_Int = 2;
    localView.setBackgroundResource(2130839450);
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377310);
    if ((this.h) || (this.i))
    {
      localLinearLayout.setVisibility(0);
      return;
    }
    localLinearLayout.setVisibility(8);
  }
  
  private void n()
  {
    int j = 1;
    if (Aladdin.getConfig(302).getIntegerFromString("me_mywallet_switch", 0) == 1) {}
    for (;;)
    {
      if (j != 0) {
        a(2131381261, 2131381262, Aladdin.getConfig(302).getString("entrance_title", anzj.a(2131717360)), 3, 0);
      }
      return;
      j = 0;
    }
  }
  
  private void o()
  {
    if (this.h) {
      a(2131364817, 2131364818, anzj.a(2131711985), 3, 0);
    }
  }
  
  private void p()
  {
    if (this.i) {
      a(2131371937, 2131371936, anzj.a(2131711977), 3, 0);
    }
  }
  
  private void q() {}
  
  private void r()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366947);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366964));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        int j = bnrf.w(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(bnrf.a(j));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
        }
      }
    }
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366294);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366299));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366297));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364018));
      this.jdField_a_of_type_Skn = new skn(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Skn);
    }
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367053);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (bnrf.a(getActivity().getAppRuntime()).booleanValue()) {
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365008));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new pjy(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377309));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370672));
    v();
    w();
    aw();
  }
  
  private void v()
  {
    String str = getResources().getString(2131717284);
    if (rab.o())
    {
      j = 0;
      a(2131371631, 2131368991, str, 2, j);
      str = getResources().getString(2131717283);
      if (!rab.n()) {
        break label91;
      }
    }
    label91:
    for (int j = 0;; j = 1)
    {
      a(2131371630, 2131368991, str, 2, j);
      a(2131371627, 2131368991, getResources().getString(2131717281), 2, 0);
      return;
      j = 1;
      break;
    }
  }
  
  private void w()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = agej.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -agej.a(100.0F, getResources()), agej.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new pkj(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new pkn(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369134));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370451));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370466));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370461));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380077));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379805));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365797));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369933));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381119);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370740));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370747));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370752));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370741));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380153));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364671).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368053).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379208).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369923).setOnClickListener(this);
      long l = bnrf.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bnrf.a(l, 9900000L, "999万", "0"));
      l = bnrf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bnrf.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365790).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label649;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - agej.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370463)).setPadding(0, agej.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370456).setOnClickListener(this);
      x();
      y();
      ocd.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label649:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846391);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846388);
      }
    }
  }
  
  private void x()
  {
    int j = LiuHaiUtils.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370454);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (zft.b(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (zft.b(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (zft.b(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(ozs.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376200);
      if (localViewStub != null) {
        localViewStub.inflate();
      }
    }
  }
  
  private void z()
  {
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
      ocd.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", ozs.e(), false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new pko(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130846388);
      continue;
      paramView.setBackgroundResource(2130846391);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842966);
      }
      else
      {
        paramView.setBackgroundResource(2130846390);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842963);
        }
        else
        {
          paramView.setBackgroundResource(2130846389);
          continue;
          paramView.setBackgroundColor(2130846388);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    aw();
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
    at();
    au();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    pfa.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    av();
  }
  
  public void ar_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.41(this));
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
        blkk.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380439), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      blkk.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380439), j, this.jdField_c_of_type_Int, 2130850404, 99, null);
      return;
      j = 0;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    pks localpks = (pks)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramView.getId()));
    if (localpks != null) {
      localpks.a();
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
      this.jdField_f_of_type_Boolean = bnrf.A(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    pfd.a().a(this.jdField_a_of_type_Pfh);
    ax();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560270;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560273;
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
    pfd.a().b(this.jdField_a_of_type_Pfh);
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
    pfa.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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