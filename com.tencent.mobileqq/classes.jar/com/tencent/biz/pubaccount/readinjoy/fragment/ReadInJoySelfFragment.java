package com.tencent.biz.pubaccount.readinjoy.fragment;

import aepi;
import alud;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
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
import azqs;
import bcyz;
import bdfr;
import bdgk;
import bhvv;
import bkbq;
import bkbs;
import bkbt;
import bnle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
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
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import nrt;
import nxe;
import nxu;
import oqu;
import orf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import orz;
import owr;
import owy;
import oxb;
import oxe;
import par;
import pas;
import pat;
import pau;
import pav;
import paw;
import pax;
import pay;
import paz;
import pba;
import pbb;
import pbc;
import pfm;
import pha;
import qok;
import qzi;
import rvo;
import rvp;
import smk;
import xin;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, owr
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
  private String jdField_a_of_type_JavaLangString = "";
  protected oxe a;
  @Nullable
  private pfm jdField_a_of_type_Pfm;
  private rvp jdField_a_of_type_Rvp;
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
  private String jdField_b_of_type_JavaLangString = "";
  private HashMap<Integer, pbc> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  public float c;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ReadInjoyMenuIconView jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView;
  private String jdField_c_of_type_JavaLangString = "";
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
    this.jdField_a_of_type_Oxe = new pat(this);
  }
  
  private void A()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    qzi localqzi = qzi.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localqzi.a(str, j);
      return;
    }
  }
  
  private void B()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void C()
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
      j = bkbq.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bkbq.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bkbq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bkbq.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Rvp != null) {
        this.jdField_a_of_type_Rvp.a(bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label395;
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
        l = bkbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bkbq.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bkbq.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bool) {
          break label424;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      label348:
      if ((!bool) && (this.jdField_c_of_type_AndroidViewView != null))
      {
        if (bkbq.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label436;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      E();
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      label395:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label218;
      label424:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      break label348;
      label436:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void D()
  {
    try
    {
      this.jdField_a_of_type_Float = getResources().getDimension(2131298601);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298603);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298604);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298602);
      this.jdField_b_of_type_Int = ((int)bdgk.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void E()
  {
    nxe localnxe = bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localnxe == null) || (localnxe.jdField_c_of_type_Int <= 0) || (localnxe.d <= 0) || (TextUtils.isEmpty(localnxe.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367946);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new pau(this, localImageView, localnxe));
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, aepi.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new paz(this));
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
    paramView = new pbc((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramView);
    d(paramInt1);
  }
  
  private void a(String paramString, int paramInt)
  {
    int k = 1;
    orz localorz1 = new orz();
    boolean bool1 = qok.d();
    boolean bool2 = qok.a();
    orz localorz2;
    if (bool1)
    {
      j = 1;
      localorz2 = localorz1.a("ugc_video_flag", Integer.valueOf(j));
      if (!bool2) {
        break label96;
      }
    }
    label96:
    for (int j = k;; j = 0)
    {
      localorz2.a("ugc_column_flag", Integer.valueOf(j));
      if (paramInt != 0) {
        localorz1.a("my_column_cnt", Integer.valueOf(paramInt));
      }
      nrt.a(paramString, localorz1.a());
      return;
      j = 0;
      break;
    }
  }
  
  private void a(List<pha> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = aepi.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Rvp.a(paramList);
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
      j = aepi.a(7.5F, getResources());
      break;
      label158:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -aepi.a(70.0F, getResources()), 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void a(@NotNull pfm parampfm)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.readinjoy.self.SelfFragment", 2, "updateColumnInfo, columnInfoForSelfPage=" + parampfm);
    }
    this.jdField_a_of_type_Pfm = parampfm;
    View localView;
    if (parampfm.jdField_a_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370960);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368575)).setText(2131719039);
    }
    if (parampfm.jdField_b_of_type_Int > 0)
    {
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131370959);
      localView.setVisibility(0);
      ((TextView)localView.findViewById(2131368575)).setText(2131719038);
    }
    qok.a(getActivity(), 1, parampfm.jdField_b_of_type_JavaLangString);
    qok.a(getActivity(), 2, parampfm.jdField_a_of_type_JavaLangString);
    qok.a(getActivity(), 3, parampfm.jdField_c_of_type_JavaLangString);
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
    localValueAnimator.addUpdateListener(new pbb(this));
    localValueAnimator.addListener(new pas(this));
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
  
  private void d()
  {
    a(2131365476, 2131365477, alud.a(2131713517), 2, 0);
    Object localObject1 = bkbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376525);
    int j;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (bkbs)((List)localObject1).get(j);
        if (((bkbs)localObject2).jdField_a_of_type_Int == 10)
        {
          localObject3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370800);
          if (localObject3 != null)
          {
            ((View)localObject3).setOnClickListener(this);
            if (((bkbs)localObject2).jdField_b_of_type_Int != 0) {
              break label166;
            }
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370801)).setText(((bkbs)localObject2).jdField_a_of_type_JavaLangString);
            ((View)localObject3).setVisibility(0);
          }
        }
        for (;;)
        {
          j += 1;
          break;
          label166:
          ((View)localObject3).setVisibility(8);
          continue;
          if (((bkbs)localObject2).jdField_a_of_type_Int == 11)
          {
            a(2131378192, 2131378193, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, 2, ((bkbs)localObject2).jdField_b_of_type_Int);
            a(((bkbs)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131378207, 2131378208, 2131378209, 2131378210);
          }
          else if (((bkbs)localObject2).jdField_a_of_type_Int == 12)
          {
            a(2131364420, 2131364421, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, 2, ((bkbs)localObject2).jdField_b_of_type_Int);
            a(((bkbs)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364424, 2131364425, 2131364426, 2131364427);
          }
          else
          {
            if (((bkbs)localObject2).jdField_a_of_type_Int == 13)
            {
              if (localList != null) {
                a(2131367670, 2131367671, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, 2, ((bkbs)localObject2).jdField_b_of_type_Int);
              }
              for (;;)
              {
                a(((bkbs)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131367676, 2131367677, 2131367678, 2131367679);
                break;
                a(2131367670, 2131367671, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, 3, ((bkbs)localObject2).jdField_b_of_type_Int);
              }
            }
            if (((bkbs)localObject2).jdField_a_of_type_Int == 14)
            {
              a(2131376818, 2131376819, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, 2, ((bkbs)localObject2).jdField_b_of_type_Int);
              a(((bkbs)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131376820, 2131376821, 2131376822, 2131376823);
            }
            else if (((bkbs)localObject2).jdField_a_of_type_Int == 15)
            {
              this.jdField_f_of_type_Int = 2;
              a(2131376525, 2131376526, ((bkbs)localObject2).jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, ((bkbs)localObject2).jdField_b_of_type_Int);
              a(((bkbs)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131376536, 2131376537, 2131376538, 2131376539);
            }
          }
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370800);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(this);
      }
      a(2131367670, 2131367671, alud.a(2131713358), 2, 0);
      a(13, this.jdField_a_of_type_AndroidViewView, 2131367676, 2131367677, 2131367678, 2131367679);
      a(2131364420, 2131364421, alud.a(2131713102), 2, 0);
      a(12, this.jdField_a_of_type_AndroidViewView, 2131364424, 2131364425, 2131364426, 2131364427);
      if (localList == null) {
        break label960;
      }
      a(2131378192, 2131378193, alud.a(2131713454), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131378207, 2131378208, 2131378209, 2131378210);
      a(2131376818, 2131376819, alud.a(2131713410), 2, 0);
      a(14, this.jdField_a_of_type_AndroidViewView, 2131376820, 2131376821, 2131376822, 2131376823);
      if (!oqu.jdField_a_of_type_Boolean) {
        break label981;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131376525, 2131376526, alud.a(2131713101), this.jdField_f_of_type_Int, 0);
      label734:
      a(15, this.jdField_a_of_type_AndroidViewView, 2131376536, 2131376537, 2131376538, 2131376539);
      a(2131365476, 2131365477, alud.a(2131713282), 2, 0);
    }
    Object localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131365053);
    label898:
    if ((localList != null) && (localList.size() > 0))
    {
      localObject3 = LayoutInflater.from(getActivity());
      j = 0;
      label815:
      if (j < localList.size())
      {
        bkbt localbkbt = (bkbt)localList.get(j);
        View localView = ((LayoutInflater)localObject3).inflate(2131561244, null);
        TextView localTextView = (TextView)localView.findViewById(2131368575);
        a(localbkbt.jdField_a_of_type_Int, localView, 2131368581, 2131368582, 2131368583, 2131368584);
        if (localbkbt.jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = "";
          localTextView.setText((CharSequence)localObject1);
          if ((localbkbt == null) || (j == localList.size() - 1)) {
            break label1020;
          }
          a(2, localbkbt.jdField_a_of_type_Int, localView, localbkbt.jdField_a_of_type_JavaLangString, localbkbt.jdField_b_of_type_JavaLangString, true);
          ((LinearLayout)localObject2).addView(localView);
        }
        for (;;)
        {
          j += 1;
          break label815;
          label960:
          a(2131378192, 2131378193, alud.a(2131713383), 3, 0);
          break;
          label981:
          this.jdField_f_of_type_Int = 3;
          a(2131376525, 2131376526, alud.a(2131713388), this.jdField_f_of_type_Int, 0);
          break label734;
          localObject1 = localbkbt.jdField_a_of_type_JavaLangString;
          break label898;
          label1020:
          if (localbkbt != null)
          {
            a(3, localbkbt.jdField_a_of_type_Int, localView, localbkbt.jdField_a_of_type_JavaLangString, localbkbt.jdField_b_of_type_JavaLangString, true);
            ((LinearLayout)localObject2).addView(localView);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367819));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370989));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370029).setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131376482).setVisibility(8);
    }
    while (oqu.jdField_a_of_type_Boolean)
    {
      a(2131366267, 2131366268, alud.a(2131713308), 3, 0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366267);
      if (localObject1 == null)
      {
        return;
        int k = aepi.a(44.5F, getResources());
        j = k;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
        localObject1 = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131369033);
        ((Switch)localObject1).setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
        ((Switch)localObject1).setTrackResource(2130842148);
        ((Switch)localObject1).setThumbResource(2130842147);
        ((Switch)localObject1).setOnClickListener(this);
        ((Switch)localObject1).setOnCheckedChangeListener(new par(this));
      }
      else
      {
        ((TextView)((View)localObject1).findViewById(2131373706)).setText(oqu.l);
        localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131376525);
        this.jdField_f_of_type_Int = 2;
        ((View)localObject1).setBackgroundResource(2130839264);
      }
    }
    if (orf.a()) {
      a(2131372376, 2131372379, "PTS全家桶", 3, 0);
    }
    this.h = bkbq.u();
    boolean bool;
    if (((Integer)bkbq.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1)
    {
      bool = true;
      this.i = bool;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376381);
      if ((!this.h) && (!this.i)) {
        break label1865;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      label1409:
      if ((RIJRedPacketManager.a().c()) && (RIJRedPacketManager.a().e())) {
        a(2131380121, 2131380122, alud.a(2131719106), 3, 0);
      }
      if (this.h) {
        a(2131364554, 2131364555, alud.a(2131713497), 3, 0);
      }
      if (this.i) {
        a(2131371266, 2131371265, alud.a(2131713489), 3, 0);
      }
      a();
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366627);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366644));
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          j = bkbq.y(getActivity().getAppRuntime());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(bkbq.a(j));
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
          }
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131365992);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365997));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365995));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363786));
        this.jdField_a_of_type_Rvp = new rvp(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Rvp);
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376514);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367860);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366737);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bkbq.a(getActivity().getAppRuntime()).booleanValue()) {
          break label1875;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364736));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new pav(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376380));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370127));
      h();
      l();
      C();
      return;
      bool = false;
      break;
      label1865:
      ((LinearLayout)localObject1).setVisibility(8);
      break label1409;
      label1875:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    pbc localpbc = (pbc)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localpbc == null) || (localpbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localpbc.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localpbc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      bhvv.a(localpbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130849805, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      bhvv.a(localpbc.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localpbc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    bhvv.a(localpbc.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bcyz.a);
    localpbc.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localpbc.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130845921);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localpbc.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    String str = getResources().getString(2131719039);
    if (qok.d())
    {
      j = 0;
      a(2131370960, 2131368575, str, 2, j);
      str = getResources().getString(2131719038);
      if (!qok.c()) {
        break label92;
      }
    }
    label92:
    for (int j = 0;; j = 1)
    {
      a(2131370959, 2131368575, str, 2, j);
      a(2131370951, 2131368575, getResources().getString(2131719036), 2, 0);
      return;
      j = 1;
      break;
    }
  }
  
  private void l()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = aepi.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -aepi.a(100.0F, getResources()), aepi.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new paw(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new pax(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368709));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369907));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369922));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369917));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378994));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378764));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365519));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369441));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379980);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370195));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370202));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370208));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370196));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379053));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364420).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367670).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131378192).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131376818).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369431).setOnClickListener(this);
      long l = bkbq.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bkbq.a(l, 9900000L, "999万", "0"));
      l = bkbq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bkbq.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365512).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label669;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - aepi.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369919)).setPadding(0, aepi.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369912).setOnClickListener(this);
      m();
      n();
      nrt.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label669:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845935);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845932);
      }
    }
  }
  
  private void m()
  {
    int j = bnle.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369910);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (xin.b(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (xin.b(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (xin.b(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void n()
  {
    if (ThemeUtil.isInNightMode(ors.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131375335);
      if (localViewStub != null) {
        localViewStub.inflate();
      }
    }
  }
  
  private void o()
  {
    String str = qok.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    if (!TextUtils.isEmpty(str)) {
      ors.a(getActivity(), str);
    }
    for (;;)
    {
      a("0X800AC6F", 0);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myVideoJumpUrl is empty");
    }
  }
  
  private void p()
  {
    String str = qok.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    if (!TextUtils.isEmpty(str)) {
      ors.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Pfm != null)
    {
      a("0X800AC74", this.jdField_a_of_type_Pfm.jdField_b_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item myColumnJumpUrl is empty");
    }
    a("0X800AC74", 0);
  }
  
  private void q()
  {
    String str = qok.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
    if (!TextUtils.isEmpty(str)) {
      ors.a(getActivity(), str);
    }
    while (this.jdField_a_of_type_Pfm != null)
    {
      a("0X800AC7C", this.jdField_a_of_type_Pfm.jdField_c_of_type_Int);
      return;
      QLog.e("Q.readinjoy.self.SelfFragment", 1, "click video item mySubscribeJumpUrl is empty");
    }
    a("0X800AC7C", 0);
  }
  
  private void r()
  {
    qok.a(getActivity(), null, 1);
  }
  
  private void s()
  {
    ColumnInfo localColumnInfo = new ColumnInfo();
    int j = ((Integer)bkbq.a("key_sp_readinjoy_viola_test_column_id", Integer.valueOf(0), true)).intValue();
    if (j == 0) {
      QQToast.a(getActivity(), 2131719040, 0).a();
    }
    for (;;)
    {
      qok.a(getActivity(), localColumnInfo, 3);
      return;
      localColumnInfo.columnID = j;
    }
  }
  
  private void t()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void u()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void v()
  {
    Object localObject = ors.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = oqu.g + bdfr.encodeToString(((String)localObject).getBytes(), 2);
    if (!bkbq.t())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    smk.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bdfr.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void w()
  {
    nrt.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
    PublicFragmentActivity.a(getActivity(), ReadInJoyDraftboxFragment.class);
  }
  
  private void x()
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
  
  private void y()
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -aepi.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new pba(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    qzi.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public int a()
  {
    return -1;
  }
  
  public void a()
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
        bhvv.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379325), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      bhvv.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379325), j, this.jdField_c_of_type_Int, 2130849805, 99, null);
      return;
      j = 0;
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setOnClickListener(new pay(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130845932);
      continue;
      paramView.setBackgroundResource(2130845935);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842617);
      }
      else
      {
        paramView.setBackgroundResource(2130845934);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842614);
        }
        else
        {
          paramView.setBackgroundResource(2130845933);
          continue;
          paramView.setBackgroundColor(2130845932);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    C();
  }
  
  protected void a(int paramInt, View paramView, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramInt, 0, paramView, paramString1, paramString2, paramBoolean);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    a();
    z();
    A();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    owy.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    B();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.11(this));
  }
  
  public void c()
  {
    if (this.i) {
      nrt.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", ors.c(), false);
    }
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
  
  @SuppressLint({"DefaultLocale"})
  public void onClick(View paramView)
  {
    Bundle localBundle = null;
    switch (paramView.getId())
    {
    default: 
      QLog.i("Q.readinjoy.self.SelfFragment", 1, "onClick, no handler, id=" + paramView.getId());
    }
    for (;;)
    {
      return;
      nrt.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", ors.c(this.jdField_c_of_type_Int), false);
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), 2);
      nrt.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ors.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.q();
      return;
      v();
      nrt.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", ors.c(), false);
      return;
      ThreadManager.postImmediately(new ReadInJoySelfFragment.6(this), null, true);
      startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
      b(15);
      azqs.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ors.c());
      return;
      nxu.a(this.jdField_a_of_type_AndroidViewView.getContext(), b(14));
      b(14);
      return;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.m);
      return;
      ors.b(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.u);
      paramView = new orz().b().a();
      if (TextUtils.isEmpty(paramView)) {
        continue;
      }
      nrt.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bkbq.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
      return;
      paramView = bkbq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      int j;
      if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
      {
        y();
        j = 0;
      }
      for (;;)
      {
        if (j <= 0) {
          break label804;
        }
        paramView = new orz().b().a();
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        nrt.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bkbq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", paramView, false);
        return;
        if ((paramView != null) && (paramView.size() > 1))
        {
          a(paramView);
          j = 1;
        }
        else
        {
          ors.b(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.v);
          j = 2;
        }
      }
      label804:
      continue;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.n);
      paramView = ors.a();
      nrt.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, b(13) + "", "", "", paramView.toString(), false);
      b(13);
      return;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.o);
      paramView = ors.a();
      nrt.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, b(11) + "", "", "", paramView.toString(), false);
      b(11);
      return;
      paramView = oqu.p.replace("_bid", "_pbid") + "&_jbid=3257&_vjs=collectBox&_prenr=1";
      localBundle = new Bundle();
      localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView, localBundle);
      paramView = ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.3.5".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      nrt.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, b(12) + "", "", "", paramView, false);
      b(12);
      return;
      w();
      return;
      smk.a(this.jdField_a_of_type_AndroidViewView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
      return;
      getActivity().finish();
      return;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.r);
      nrt.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.3.5".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
      return;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.s);
      nrt.a(null, "CliOper", "", "", "0X8009927", "0X8009927", 0, 0, "", "", "", ors.c(), false);
      return;
      ors.a(this.jdField_a_of_type_AndroidViewView.getContext(), oqu.t);
      return;
      new rvo(getActivity()).a(String.format(alud.a(2131713249), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), alud.a(2131713513));
      paramView = new JSONObject();
      try
      {
        paramView.put("number", String.valueOf(bkbq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
        nrt.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", ors.a(paramView), false);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      x();
      return;
      v();
      nrt.a(null, "", "0X8009925", "0X8009925", 0, 0, "", "", "", "", false);
      return;
      smk.a(getActivity(), null, "https://viola.qq.com/js/myFamily.js?_rij_violaUrl=1&v_tid=6&v_bundleName=myFamily&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740", null);
      return;
      smk.a(getActivity(), null, "https://viola.qq.com/js/notes-center.js?_rij_violaUrl=1&v_nav_immer=1&v_tid=15&v_bid=3811&v_bundleName=notes-center&hideNav=1&statusBarStyle=1", null);
      nrt.a(null, "", "0X800A607", "0X800A607", 0, 0, "", "", "", "", false);
      return;
      try
      {
        paramView = (nxe)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
        if (paramView == null) {
          continue;
        }
        ors.a(getActivity(), paramView);
        return;
        u();
        return;
        t();
        return;
        str = String.format("https://viola.qq.com/js/redpackIndex.js?_rij_violaUrl=1&hideNav=1&statusColor=1&statusBarStyle=1&v_nav_immer=1&v_tid=6&v_bundleName=redpackIndex&v_bid=3740&redpack_type=%d&plat_source=%d&jump_source=%d", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3) });
        ors.a(paramView.getContext(), str);
        return;
        o();
        return;
        p();
        return;
        q();
        return;
        r();
        return;
        s();
        return;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          String str;
          paramView = str;
        }
      }
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
      this.jdField_f_of_type_Boolean = bkbq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    oxb.a().a(this.jdField_a_of_type_Oxe);
    D();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560115;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560118;
    }
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(j, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    d();
    return this.jdField_a_of_type_AndroidViewView;
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
    oxb.a().b(this.jdField_a_of_type_Oxe);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
  }
  
  public void onResume()
  {
    super.onResume();
    a();
    owy.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    c();
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