package com.tencent.biz.pubaccount.readinjoy.fragment;

import amtj;
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
import bfol;
import bfuc;
import bjpg;
import bkwm;
import bkwo;
import bkwp;
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
import odq;
import oju;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import paa;
import pal;
import pay;
import pbg;
import pkg;
import pkm;
import pkp;
import pkt;
import pop;
import poq;
import por;
import pos;
import pot;
import pou;
import pov;
import pow;
import pox;
import poy;
import poz;
import ppa;
import ppb;
import ppc;
import ppd;
import ppe;
import ppf;
import ppg;
import pph;
import ppi;
import ppj;
import ppk;
import ppl;
import ppm;
import ppn;
import ppo;
import ppp;
import ppq;
import ppr;
import pps;
import ppt;
import ppu;
import ppv;
import ppw;
import ppx;
import ppy;
import ppz;
import pqa;
import pqb;
import pqc;
import pqd;
import pqe;
import pqf;
import puk;
import pwo;
import rha;
import rtb;
import son;
import soo;
import tgc;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, pkg
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
  Map<Integer, pqe> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected pkt a;
  @Nullable
  private puk jdField_a_of_type_Puk;
  private soo jdField_a_of_type_Soo;
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
  private HashMap<Integer, pqf> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Pkt = new ppx(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371436), new pqb(this));
  }
  
  private void B()
  {
    pqc localpqc = new pqc(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131379586), localpqc);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370429), localpqc);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370542), localpqc);
  }
  
  private void C()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131377218), new pqd(this));
  }
  
  private void D()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366597), new poq(this));
  }
  
  private void E()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365338), new por(this));
  }
  
  private void F()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366968), new pos(this));
  }
  
  private void G()
  {
    pot localpot = new pot(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370424), localpot);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131366321), localpot);
  }
  
  private void H()
  {
    pou localpou = new pou(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370715), localpou);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368085), localpou);
  }
  
  private void I()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131378977), new pov(this));
  }
  
  private void J()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364702), new pow(this));
  }
  
  private void K()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365787), new pox(this));
  }
  
  private void L()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131380862), new poy(this));
  }
  
  private void M()
  {
    poz localpoz = new poz(this);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369162), localpoz);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370419), localpoz);
  }
  
  private void N()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370708), new ppa(this));
  }
  
  private void O()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370720), new ppb(this));
  }
  
  private void P()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370709), new ppc(this));
  }
  
  private void Q()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369917), new ppd(this));
  }
  
  private void R()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131368236), new ppe(this));
  }
  
  private void S()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131365822), new ppf(this));
  }
  
  private void T()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131364847), new ppg(this));
  }
  
  private void U()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371903), new pph(this));
  }
  
  private void V()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131370640), new ppi(this));
  }
  
  private void W()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373052), new ppj(this));
  }
  
  private void X()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131369483), new ppl(this));
  }
  
  private void Y()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131380979), new ppm(this));
  }
  
  private void Z()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371599), new ppn(this));
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, AIOUtils.dp2px(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new pps(this));
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
    paramView = new pqf((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
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
      pay.a(paramContext, str1);
      return;
      str1 = URLDecoder.decode(str2);
    }
  }
  
  private void a(bkwo parambkwo)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371436);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      if (parambkwo.jdField_b_of_type_Int == 0)
      {
        ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371437)).setText(parambkwo.jdField_a_of_type_JavaLangString);
        localView.setVisibility(0);
      }
    }
    else
    {
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(bkwo parambkwo, List<bkwp> paramList)
  {
    if (paramList != null) {
      a(2131368085, 2131368086, parambkwo.jdField_a_of_type_JavaLangString, 2, parambkwo.jdField_b_of_type_Int);
    }
    for (;;)
    {
      a(parambkwo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131368092, 2131368093, 2131368094, 2131368095);
      return;
      a(2131368085, 2131368086, parambkwo.jdField_a_of_type_JavaLangString, 3, parambkwo.jdField_b_of_type_Int);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 1;
    pbg localpbg1 = new pbg();
    boolean bool1 = rha.q();
    boolean bool2 = rha.h();
    pbg localpbg2;
    if (bool1)
    {
      j = 1;
      localpbg2 = localpbg1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localpbg2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localpbg1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      odq.a(paramString, localpbg1.a());
      return;
      j = 0;
      break;
    }
  }
  
  private void a(List<bkwp> paramList)
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371436);
    if (localView != null)
    {
      localView.setVisibility(0);
      localView.setOnClickListener(this);
    }
    a(2131368085, 2131368086, amtj.a(2131712078), 2, 0);
    a(13, this.jdField_a_of_type_AndroidViewView, 2131368092, 2131368093, 2131368094, 2131368095);
    a(2131364702, 2131364703, amtj.a(2131711822), 2, 0);
    a(12, this.jdField_a_of_type_AndroidViewView, 2131364706, 2131364707, 2131364708, 2131364709);
    if (paramList != null)
    {
      a(2131378977, 2131378978, amtj.a(2131712174), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131378994, 2131378995, 2131378996, 2131378997);
      if (!paa.jdField_a_of_type_Boolean) {
        break label236;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131377218, 2131377219, amtj.a(2131711821), this.jdField_f_of_type_Int, 0);
    }
    for (;;)
    {
      a(15, this.jdField_a_of_type_AndroidViewView, 2131377229, 2131377230, 2131377231, 2131377232);
      a(2131365787, 2131365788, amtj.a(2131712002), 2, 0);
      return;
      a(2131378977, 2131378978, amtj.a(2131712103), 3, 0);
      break;
      label236:
      this.jdField_f_of_type_Int = 3;
      a(2131377218, 2131377219, amtj.a(2131712108), this.jdField_f_of_type_Int, 0);
    }
  }
  
  private void a(List<bkwo> paramList, List<bkwp> paramList1)
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
  
  private void a(List<bkwo> paramList, List<bkwp> paramList1, int paramInt)
  {
    paramList = (bkwo)paramList.get(paramInt);
    if (paramList.jdField_a_of_type_Int == 10) {
      a(paramList);
    }
    do
    {
      return;
      if (paramList.jdField_a_of_type_Int == 11)
      {
        a(2131378977, 2131378978, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131378994, 2131378995, 2131378996, 2131378997);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 12)
      {
        a(2131364702, 2131364703, paramList.jdField_a_of_type_JavaLangString, 2, paramList.jdField_b_of_type_Int);
        a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364706, 2131364707, 2131364708, 2131364709);
        return;
      }
      if (paramList.jdField_a_of_type_Int == 13)
      {
        a(paramList, paramList1);
        return;
      }
    } while (paramList.jdField_a_of_type_Int != 15);
    this.jdField_f_of_type_Int = 2;
    a(2131377218, 2131377219, paramList.jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, paramList.jdField_b_of_type_Int);
    a(paramList.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377229, 2131377230, 2131377231, 2131377232);
  }
  
  private void a(@NotNull puk parampuk)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + parampuk);
    }
    this.jdField_a_of_type_Puk = parampuk;
    View localView;
    if (parampuk.jdField_a_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371599);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369017)).setText(2131717515);
    }
    if (parampuk.jdField_b_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131371598);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131369017)).setText(2131717514);
    }
    rha.a(getActivity(), 1, parampuk.jdField_b_of_type_JavaLangString);
    rha.a(getActivity(), 2, parampuk.jdField_a_of_type_JavaLangString);
    rha.a(getActivity(), 3, parampuk.jdField_c_of_type_JavaLangString);
  }
  
  private void aa()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371598), new ppo(this));
  }
  
  private void ab()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131371595), new ppp(this));
  }
  
  private void ac()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373163), new ppq(this));
  }
  
  private void ad()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2131373166), new ppr(this));
  }
  
  private void ae()
  {
    pay.b(this.jdField_a_of_type_AndroidViewView.getContext(), paa.u);
    String str = new pbg().b().a();
    if (!TextUtils.isEmpty(str)) {
      odq.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bkwm.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", str, false);
    }
  }
  
  private void af()
  {
    Object localObject = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        localObject = new pbg().b().a();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          odq.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bkwm.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", (String)localObject, false);
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
        pay.b(this.jdField_a_of_type_AndroidViewView.getContext(), paa.v);
        j = 2;
      }
    }
  }
  
  private void ag()
  {
    new son(getActivity()).a(String.format(amtj.a(2131711969), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), amtj.a(2131712233));
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("number", String.valueOf(bkwm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
      odq.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", pay.a(localJSONObject), false);
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
      oju localoju = (oju)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
      if (localoju != null) {
        pay.a(getActivity(), localoju);
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
    String str = rha.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    if (!TextUtils.isEmpty(str)) {
      pay.a(getActivity(), str);
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
    String str = rha.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (!TextUtils.isEmpty(str)) {
      pay.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Puk != null)
    {
      a("0X800AC74", this.jdField_a_of_type_Puk.jdField_b_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    a("0X800AC74", 0);
  }
  
  private void ak()
  {
    String str = rha.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
    if (!TextUtils.isEmpty(str)) {
      pay.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Puk != null)
    {
      a("0X800AC7C", this.jdField_a_of_type_Puk.jdField_c_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    a("0X800AC7C", 0);
  }
  
  private void al()
  {
    rha.a(getActivity(), null, 1);
  }
  
  private void am()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)bkwm.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131717516, 0).a();
    }
    for (;;)
    {
      rha.a(getActivity(), localColumnInfo, 3);
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
    Object localObject = pay.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = paa.g + bfuc.encodeToString(((String)localObject).getBytes(), 2);
    if (!bkwm.u())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      pay.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    tgc.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bfuc.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void aq()
  {
    odq.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ppt(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void at()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    rtb.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void au()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    rtb localrtb = rtb.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localrtb.a(str, j);
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
      j = bkwm.t(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bkwm.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bkwm.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bkwm.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Soo != null) {
        this.jdField_a_of_type_Soo.a(bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bkwm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bkwm.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bkwm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bkwm.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bkwm.s(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
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
      this.jdField_a_of_type_Float = getResources().getDimension(2131298761);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298763);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298764);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298762);
      this.jdField_b_of_type_Int = ((int)DeviceInfoUtil.getPortraitWidth());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void ay()
  {
    oju localoju = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localoju == null) || (localoju.jdField_c_of_type_Int <= 0) || (localoju.d <= 0) || (TextUtils.isEmpty(localoju.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368369);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new ppy(this, localImageView, localoju));
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
    localValueAnimator.addUpdateListener(new ppu(this));
    localValueAnimator.addListener(new ppw(this));
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
  
  private void b(List<bkwp> paramList)
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365364);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LayoutInflater localLayoutInflater = LayoutInflater.from(getActivity());
      int j = 0;
      if (j < paramList.size())
      {
        bkwp localbkwp = (bkwp)paramList.get(j);
        View localView = localLayoutInflater.inflate(2131561393, null);
        TextView localTextView = (TextView)localView.findViewById(2131369017);
        String str;
        if (localbkwp.jdField_a_of_type_JavaLangString == null)
        {
          str = "";
          label97:
          localTextView.setText(str);
          if ((localbkwp == null) || (j == paramList.size() - 1)) {
            break label189;
          }
          a(localbkwp.jdField_a_of_type_Int, localView, 2131369023, 2131369024, 2131369025, 2131369026);
          a(2, localbkwp.jdField_a_of_type_Int, localView, localbkwp.jdField_a_of_type_JavaLangString, localbkwp.jdField_b_of_type_JavaLangString, true);
          localLinearLayout.addView(localView);
        }
        for (;;)
        {
          j += 1;
          break;
          str = localbkwp.jdField_a_of_type_JavaLangString;
          break label97;
          label189:
          if (localbkwp != null)
          {
            a(localbkwp.jdField_a_of_type_Int, localView, 2131369023, 2131369024, 2131369025, 2131369026);
            a(3, localbkwp.jdField_a_of_type_Int, localView, localbkwp.jdField_a_of_type_JavaLangString, localbkwp.jdField_b_of_type_JavaLangString, true);
            localLinearLayout.addView(localView);
          }
        }
      }
    }
  }
  
  private void c()
  {
    boolean bool = false;
    a(2131365787, 2131365788, amtj.a(2131712237), 2, 0);
    List localList1 = bkwm.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList2 = bkwm.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377218);
    a(localList1, localList2);
    b(localList2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368236));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371626));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370542).setOnClickListener(this);
    d();
    h();
    if (pal.a()) {
      a(2131373052, 2131373055, "PTS全家桶", 3, 0);
    }
    this.h = bkwm.v();
    if (((Integer)bkwm.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1) {
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
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377207);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368280);
    t();
    u();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377060));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370640));
    v();
    w();
    aw();
    z();
    bkwm.i();
  }
  
  private void c(List<pwo> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = AIOUtils.dp2px(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Soo.a(paramList);
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
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377175).setVisibility(8);
      return;
    }
    int k = AIOUtils.dp2px(44.5F, getResources());
    int j = k;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    Switch localSwitch = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131369494);
    localSwitch.setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
    localSwitch.setTrackResource(2130842517);
    localSwitch.setThumbResource(2130842516);
    localSwitch.setOnClickListener(this);
    localSwitch.setOnCheckedChangeListener(new pop(this));
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    pqf localpqf = (pqf)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localpqf == null) || (localpqf.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localpqf.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localpqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      bjpg.a(localpqf.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130850325, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      bjpg.a(localpqf.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localpqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    bjpg.a(localpqf.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bfol.a);
    localpqf.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localpqf.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130846285);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localpqf.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (paa.jdField_a_of_type_Boolean)
    {
      a(2131366597, 2131366598, amtj.a(2131712028), 3, 0);
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366597);
      if (localView != null) {}
    }
    else
    {
      return;
    }
    ((TextView)localView.findViewById(2131374314)).setText(paa.l);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377218);
    this.jdField_f_of_type_Int = 2;
    localView.setBackgroundResource(2130839485);
  }
  
  private void m()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377061);
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
        a(2131380979, 2131380980, Aladdin.getConfig(302).getString("entrance_title", amtj.a(2131717592)), 3, 0);
      }
      return;
      j = 0;
    }
  }
  
  private void o()
  {
    if (this.h) {
      a(2131364847, 2131364848, amtj.a(2131712217), 3, 0);
    }
  }
  
  private void p()
  {
    if (this.i) {
      a(2131371903, 2131371902, amtj.a(2131712209), 3, 0);
    }
  }
  
  private void q() {}
  
  private void r()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366968);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366982));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        int j = bkwm.t(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(bkwm.a(j));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
        }
      }
    }
  }
  
  private void s()
  {
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366321);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366326));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366324));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364042));
      this.jdField_a_of_type_Soo = new soo(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Soo);
    }
  }
  
  private void t()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367070);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (bkwm.a(getActivity().getAppRuntime()).booleanValue()) {
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365035));
    this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new ppk(this));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377060));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370640));
    v();
    w();
    aw();
  }
  
  private void v()
  {
    String str = getResources().getString(2131717515);
    if (rha.q())
    {
      j = 0;
      a(2131371599, 2131369017, str, 2, j);
      str = getResources().getString(2131717514);
      if (!rha.p()) {
        break label91;
      }
    }
    label91:
    for (int j = 0;; j = 1)
    {
      a(2131371598, 2131369017, str, 2, j);
      a(2131371595, 2131369017, getResources().getString(2131717512), 2, 0);
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new ppv(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new ppz(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369162));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370419));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370434));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370429));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379825));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379586));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365829));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369927));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131380839);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370708));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370715));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370720));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370709));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379887));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364702).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131368085).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131378977).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369917).setOnClickListener(this);
      long l = bkwm.b(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bkwm.a(l, 9900000L, "999万", "0"));
      l = bkwm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bkwm.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365822).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label649;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - AIOUtils.dp2px(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370431)).setPadding(0, AIOUtils.dp2px(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370424).setOnClickListener(this);
      x();
      y();
      odq.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label649:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846299);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130846296);
      }
    }
  }
  
  private void x()
  {
    int j = LiuHaiUtils.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370422);
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
    if (ThemeUtil.isInNightMode(pay.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131375964);
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
  
  public void C_()
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
      odq.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", pay.f(), false);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new pqa(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130846296);
      continue;
      paramView.setBackgroundResource(2130846299);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130843020);
      }
      else
      {
        paramView.setBackgroundResource(2130846298);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130843017);
        }
        else
        {
          paramView.setBackgroundResource(2130846297);
          continue;
          paramView.setBackgroundColor(2130846296);
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
    pkm.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_c_of_type_Int > 0) {}
      for (j = 1;; j = 0)
      {
        bjpg.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380163), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      bjpg.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380163), j, this.jdField_c_of_type_Int, 2130850325, 99, null);
      return;
      j = 0;
    }
  }
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    pqe localpqe = (pqe)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramView.getId()));
    if (localpqe != null) {
      localpqe.a();
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
      this.jdField_f_of_type_Boolean = bkwm.B(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    pkp.a().a(this.jdField_a_of_type_Pkt);
    ax();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560277;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560280;
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
    pkp.a().b(this.jdField_a_of_type_Pkt);
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
    pkm.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
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