package com.tencent.biz.pubaccount.readinjoy.fragment;

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
import anvx;
import bgxc;
import bhcu;
import blas;
import bmhv;
import bmhx;
import bmhy;
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
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
import olh;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import orr;
import pjj;
import pju;
import pkh;
import pnp;
import pqf;
import pqg;
import pqx;
import pvd;
import pvj;
import pvm;
import pvq;
import pzn;
import pzo;
import pzp;
import pzq;
import pzr;
import pzs;
import pzt;
import pzu;
import pzv;
import pzw;
import pzx;
import pzy;
import pzz;
import qaa;
import qab;
import qac;
import qad;
import qae;
import qaf;
import qag;
import qah;
import qai;
import qaj;
import qak;
import qal;
import qam;
import qan;
import qao;
import qap;
import qaq;
import qar;
import qas;
import qat;
import qau;
import qav;
import qaw;
import qax;
import qay;
import qaz;
import qba;
import qbb;
import qbc;
import qbd;
import qfe;
import qhu;
import rth;
import sfq;
import tby;
import tbz;
import tto;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, pvd
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
  Map<Integer, qbc> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected pvq a;
  @Nullable
  private qfe jdField_a_of_type_Qfe;
  private tbz jdField_a_of_type_Tbz;
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
  private HashMap<Integer, qbd> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Pvq = new qav(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371622), new qaz(this));
  }
  
  private void B()
  {
    qba localqba = new qba(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379898), localqba);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370612), localqba);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370725), localqba);
  }
  
  private void C()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131377491), new qbb(this));
  }
  
  private void D()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366708), new pzo(this));
  }
  
  private void E()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365433), new pzp(this));
  }
  
  private void F()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131367086), new pzq(this));
  }
  
  private void G()
  {
    pzr localpzr = new pzr(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370607), localpzr);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366426), localpzr);
  }
  
  private void H()
  {
    pzs localpzs = new pzs(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370900), localpzs);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368225), localpzs);
  }
  
  private void I()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379271), new pzt(this));
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364789), new pzu(this));
  }
  
  private void K()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365885), new pzv(this));
  }
  
  private void L()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131381214), new pzw(this));
  }
  
  private void M()
  {
    pzx localpzx = new pzx(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369324), localpzx);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370602), localpzx);
  }
  
  private void N()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370893), new pzy(this));
  }
  
  private void O()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370905), new pzz(this));
  }
  
  private void P()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370894), new qaa(this));
  }
  
  private void Q()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370087), new qab(this));
  }
  
  private void R()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368381), new qac(this));
  }
  
  private void S()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365920), new qad(this));
  }
  
  private void T()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364934), new qae(this));
  }
  
  private void U()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131372094), new qaf(this));
  }
  
  private void V()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370823), new qag(this));
  }
  
  private void W()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373262), new qah(this));
  }
  
  private void X()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369652), new qaj(this));
  }
  
  private void Y()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131381331), new qak(this));
  }
  
  private void Z()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371787), new qal(this));
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, AIOUtils.dp2px(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new qaq(this));
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
    paramView = new qbd((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
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
      pkh.a(paramContext, str1);
      return;
      str1 = URLDecoder.decode(str2);
    }
  }
  
  private void a(bmhx parambmhx)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371622);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      if (parambmhx.jdField_b_of_type_Int == 0)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371623)).setText(parambmhx.jdField_a_of_type_JavaLangString);
        localView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(bmhx parambmhx, List<bmhy> paramList)
  {
    if (paramList != null) {
      a(2131368225, 2131368226, parambmhx.jdField_a_of_type_JavaLangString, 2, parambmhx.jdField_b_of_type_Int);
    }
    for (;;)
    {
      a(parambmhx.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131368232, 2131368233, 2131368234, 2131368235);
      return;
      a(2131368225, 2131368226, parambmhx.jdField_a_of_type_JavaLangString, 3, parambmhx.jdField_b_of_type_Int);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 1;
    pqg localpqg1 = new pqg();
    boolean bool1 = rth.q();
    boolean bool2 = rth.h();
    pqg localpqg2;
    if (bool1)
    {
      j = 1;
      localpqg2 = localpqg1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localpqg2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localpqg1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      olh.a(paramString, localpqg1.a());
      return;
      j = 0;
      break;
    }
  }
  
  private void a(List<bmhy> paramList)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371622);
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    a(2131368225, 2131368226, anvx.a(2131712425), 2, 0);
    a(13, this.jdField_a_of_type_AndroidViewView, 2131368232, 2131368233, 2131368234, 2131368235);
    a(2131364789, 2131364790, anvx.a(2131712169), 2, 0);
    a(12, this.jdField_a_of_type_AndroidViewView, 2131364793, 2131364794, 2131364795, 2131364796);
    if (paramList != null)
    {
      a(2131379271, 2131379272, anvx.a(2131712521), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131379288, 2131379289, 2131379290, 2131379291);
      if (!pjj.jdField_a_of_type_Boolean) {
        break label236;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131377491, 2131377492, anvx.a(2131712168), this.jdField_f_of_type_Int, 0);
    }
    for (;;)
    {
      a(15, this.jdField_a_of_type_AndroidViewView, 2131377502, 2131377503, 2131377504, 2131377505);
      a(2131365885, 2131365886, anvx.a(2131712349), 2, 0);
      return;
      a(2131379271, 2131379272, anvx.a(2131712450), 3, 0);
      break;
      label236:
      this.jdField_f_of_type_Int = 3;
      a(2131377491, 2131377492, anvx.a(2131712455), this.jdField_f_of_type_Int, 0);
    }
  }
  
  private void a(List<bmhx> paramList, List<bmhy> paramList1)
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
  
  private void a(List<bmhx> paramList, List<bmhy> paramList1, int paramInt)
  {
    paramList = (bmhx)paramList.get(paramInt);
    if (paramList.jdField_a_of_type_Int == 10) {
      a(paramList);
    }
    do
    {
      return;
      if (paramList.jdField_a_of_type_Int == 11)
      {
        a(2131379271, 2131379272, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131379288, 2131379289, 2131379290, 2131379291);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 12)
      {
        a(2131364789, 2131364790, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364793, 2131364794, 2131364795, 2131364796);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 13)
      {
        a(paramList, paramList1);
        return;
      }
    } while (paramList.jdField_a_of_type_Int != 15);
    this.jdField_f_of_type_Int = 2;
    a(2131377491, 2131377492, paramList.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, paramList.jdField_b_of_type_Int);
    a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377502, 2131377503, 2131377504, 2131377505);
  }
  
  private void a(@NotNull qfe paramqfe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + paramqfe);
    }
    this.jdField_a_of_type_Qfe = paramqfe;
    View localView;
    if (paramqfe.jdField_a_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371787);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369180)).setText(2131717881);
    }
    if (paramqfe.jdField_b_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371786);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369180)).setText(2131717880);
    }
    rth.a(getActivity(), 1, paramqfe.jdField_b_of_type_JavaLangString);
    rth.a(getActivity(), 2, paramqfe.jdField_a_of_type_JavaLangString);
    rth.a(getActivity(), 3, paramqfe.jdField_c_of_type_JavaLangString);
  }
  
  private void aa()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371786), new qam(this));
  }
  
  private void ab()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371783), new qan(this));
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373374), new qao(this));
  }
  
  private void ad()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373377), new qap(this));
  }
  
  private void ae()
  {
    pqx.a(this.jdField_a_of_type_AndroidViewView.getContext(), pjj.u);
    String str = new pqg().b().a();
    if (!TextUtils.isEmpty(str)) {
      olh.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bmhv.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", str, false);
    }
  }
  
  private void af()
  {
    Object localObject = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        localObject = new pqg().b().a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          olh.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bmhv.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", (String)localObject, false);
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
        pqx.a(this.jdField_a_of_type_AndroidViewView.getContext(), pjj.v);
        j = 2;
      }
    }
  }
  
  private void ag()
  {
    new tby(getActivity()).a(String.format(anvx.a(2131712316), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), anvx.a(2131712580));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("number", String.valueOf(bmhv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      olh.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", pqf.a(localJSONObject), false);
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
      orr localorr = (orr)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
      if (localorr != null) {
        pnp.a(getActivity(), localorr);
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
    String str = rth.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    if (!TextUtils.isEmpty(str)) {
      pkh.a(getActivity(), str);
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
    String str = rth.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (!TextUtils.isEmpty(str)) {
      pkh.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Qfe != null)
    {
      a("0X800AC74", this.jdField_a_of_type_Qfe.jdField_b_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    a("0X800AC74", 0);
  }
  
  private void ak()
  {
    String str = rth.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
    if (!TextUtils.isEmpty(str)) {
      pkh.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Qfe != null)
    {
      a("0X800AC7C", this.jdField_a_of_type_Qfe.jdField_c_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    a("0X800AC7C", 0);
  }
  
  private void al()
  {
    rth.a(getActivity(), null, 1);
  }
  
  private void am()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)bmhv.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131717882, 0).a();
    }
    for (;;)
    {
      rth.a(getActivity(), localColumnInfo, 3);
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
    Object localObject = pkh.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = pjj.g + bhcu.encodeToString(((String)localObject).getBytes(), 2);
    if (!bmhv.x())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      pqx.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    tto.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bhcu.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void aq()
  {
    olh.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -AIOUtils.dp2px(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new qar(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void at()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    sfq.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void au()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    sfq localsfq = sfq.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localsfq.a(str, j);
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
      j = bmhv.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bmhv.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bmhv.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bmhv.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Tbz != null) {
        this.jdField_a_of_type_Tbz.a(bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bmhv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bmhv.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bmhv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bmhv.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bmhv.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
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
      this.jdField_a_of_type_Float = getResources().getDimension(2131298765);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298767);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298768);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298766);
      this.jdField_b_of_type_Int = ((int)DeviceInfoUtil.getPortraitWidth());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void ay()
  {
    orr localorr = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localorr == null) || (localorr.jdField_c_of_type_Int <= 0) || (localorr.d <= 0) || (TextUtils.isEmpty(localorr.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368526);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new qaw(this, localImageView, localorr));
  }
  
  private int b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
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
    localValueAnimator.addUpdateListener(new qas(this));
    localValueAnimator.addListener(new qau(this));
    localValueAnimator.setDuration(300L);
    return localValueAnimator;
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e(paramInt);
    d(paramInt);
  }
  
  private void b(List<bmhy> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365457);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
      int j = 0;
      if (j < paramList.size())
      {
        bmhy localbmhy = (bmhy)paramList.get(j);
        View localView = localLayoutInflater.inflate(2131561455, null);
        TextView localTextView = (TextView)localView.findViewById(2131369180);
        String str;
        if (localbmhy.jdField_a_of_type_JavaLangString == null)
        {
          str = "";
          label97:
          localTextView.setText(str);
          if ((localbmhy == null) || (j == paramList.size() - 1)) {
            break label189;
          }
          a(localbmhy.jdField_a_of_type_Int, localView, 2131369186, 2131369187, 2131369188, 2131369189);
          a(2, localbmhy.jdField_a_of_type_Int, localView, localbmhy.jdField_a_of_type_JavaLangString, localbmhy.jdField_b_of_type_JavaLangString, true);
          localLinearLayout.addView(localView);
        }
        for (;;)
        {
          j += 1;
          break;
          str = localbmhy.jdField_a_of_type_JavaLangString;
          break label97;
          label189:
          if (localbmhy != null)
          {
            a(localbmhy.jdField_a_of_type_Int, localView, 2131369186, 2131369187, 2131369188, 2131369189);
            a(3, localbmhy.jdField_a_of_type_Int, localView, localbmhy.jdField_a_of_type_JavaLangString, localbmhy.jdField_b_of_type_JavaLangString, true);
            localLinearLayout.addView(localView);
          }
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    a(2131365885, 2131365886, anvx.a(2131712584), 2, 0);
    List localList1 = bmhv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList2 = bmhv.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377491);
    a(localList1, localList2);
    b(localList2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368381));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371814));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370725).setOnClickListener(this);
    d();
    h();
    if (pju.a()) {
      a(2131373262, 2131373265, "PTS全家桶", 3, 0);
    }
    this.h = bmhv.y();
    if (((Integer)bmhv.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1) {
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
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377480);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368425);
    t();
    u();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377334));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370823));
    v();
    w();
    aw();
    z();
    bmhv.j();
  }
  
  private void c(List<qhu> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = AIOUtils.dp2px(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Tbz.a(paramList);
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
      j = AIOUtils.dp2px(7.5F, getResources());
      break;
      label158:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -AIOUtils.dp2px(70.0F, getResources()), 0.0F);
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377448).setVisibility(8);
      return;
    }
    int k = AIOUtils.dp2px(44.5F, getResources());
    int j = k;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    Switch localSwitch = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131369663);
    localSwitch.setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
    localSwitch.setTrackResource(2130842547);
    localSwitch.setThumbResource(2130842546);
    localSwitch.setOnClickListener(this);
    localSwitch.setOnCheckedChangeListener(new pzn(this));
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    }
    qbd localqbd = (qbd)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localqbd == null) || (localqbd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localqbd.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localqbd.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      blas.a(localqbd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130850431, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      blas.a(localqbd.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localqbd.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    blas.a(localqbd.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bgxc.a);
    localqbd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localqbd.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130846381);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localqbd.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (pjj.jdField_a_of_type_Boolean)
    {
      a(2131366708, 2131366709, anvx.a(2131712375), 3, 0);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366708);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    ((TextView)localView.findViewById(2131374552)).setText(pjj.l);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377491);
    this.jdField_f_of_type_Int = 2;
    localView.setBackgroundResource(2130839506);
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377335);
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
        a(2131381331, 2131381332, Aladdin.getConfig(302).getString("entrance_title", anvx.a(2131717959)), 3, 0);
      }
      return;
      j = 0;
    }
  }
  
  private void o()
  {
    if (this.h) {
      a(2131364934, 2131364935, anvx.a(2131712564), 3, 0);
    }
  }
  
  private void p()
  {
    if (this.i) {
      a(2131372094, 2131372093, anvx.a(2131712556), 3, 0);
    }
  }
  
  private void q() {}
  
  private void r()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367086);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367100));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        int j = bmhv.t(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(bmhv.a(j));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
        }
      }
    }
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366426);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366431));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366429));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364117));
      this.jdField_a_of_type_Tbz = new tbz(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Tbz);
    }
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367189);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (bmhv.a(getActivity().getAppRuntime()).booleanValue()) {
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365119));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new qai(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377334));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370823));
    v();
    w();
    aw();
  }
  
  private void v()
  {
    String str = getResources().getString(2131717881);
    if (rth.q())
    {
      j = 0;
      a(2131371787, 2131369180, str, 2, j);
      str = getResources().getString(2131717880);
      if (!rth.p()) {
        break label91;
      }
    }
    label91:
    for (int j = 0;; j = 1)
    {
      a(2131371786, 2131369180, str, 2, j);
      a(2131371783, 2131369180, getResources().getString(2131717878), 2, 0);
      return;
      j = 1;
      break;
    }
  }
  
  private void w()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = AIOUtils.dp2px(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -AIOUtils.dp2px(100.0F, getResources()), AIOUtils.dp2px(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new qat(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new qax(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369324));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370602));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370617));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370612));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380151));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379898));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365927));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370097));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131381191);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370893));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370900));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370905));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370894));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380223));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364789).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368225).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131379271).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370087).setOnClickListener(this);
      long l = bmhv.b(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bmhv.a(l, 9900000L, "999万", "0"));
      l = bmhv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bmhv.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365920).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label649;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - AIOUtils.dp2px(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370614)).setPadding(0, AIOUtils.dp2px(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370607).setOnClickListener(this);
      x();
      y();
      olh.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label649:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846395);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846392);
      }
    }
  }
  
  private void x()
  {
    int j = LiuHaiUtils.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370605);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (DisplayUtil.dip2px(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (DisplayUtil.dip2px(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (DisplayUtil.dip2px(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void y()
  {
    if (ThemeUtil.isInNightMode(pkh.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131376211);
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
  
  public void E_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.41(this));
  }
  
  public int a()
  {
    return -1;
  }
  
  public void a()
  {
    if (this.i) {
      olh.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", pqf.a(), false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new qay(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130846392);
      continue;
      paramView.setBackgroundResource(2130846395);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130843054);
      }
      else
      {
        paramView.setBackgroundResource(2130846394);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130843051);
        }
        else
        {
          paramView.setBackgroundResource(2130846393);
          continue;
          paramView.setBackgroundColor(2130846392);
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
    pvj.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    av();
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Int > 0) {}
      for (j = 1;; j = 0)
      {
        blas.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380498), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      blas.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380498), j, this.jdField_c_of_type_Int, 2130850431, 99, null);
      return;
      j = 0;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    qbc localqbc = (qbc)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramView.getId()));
    if (localqbc != null) {
      localqbc.a();
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
      this.jdField_f_of_type_Boolean = bmhv.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    pvm.a().a(this.jdField_a_of_type_Pvq);
    ax();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560323;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560326;
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(j, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
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
    pvm.a().b(this.jdField_a_of_type_Pvq);
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
    pvj.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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