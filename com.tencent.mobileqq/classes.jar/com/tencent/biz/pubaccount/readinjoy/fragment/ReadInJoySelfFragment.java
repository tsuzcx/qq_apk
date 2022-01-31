package com.tencent.biz.pubaccount.readinjoy.fragment;

import aciy;
import ajjy;
import android.animation.ValueAnimator;
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
import awqx;
import azue;
import baaw;
import babp;
import beih;
import bgmq;
import bgms;
import bgmt;
import bjeh;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
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
import com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;
import ndn;
import nis;
import nji;
import obb;
import obm;
import obz;
import ocg;
import ogr;
import ogy;
import ohb;
import ohe;
import oke;
import okf;
import okg;
import okh;
import oki;
import okj;
import okk;
import okl;
import okm;
import okn;
import oko;
import okp;
import oqq;
import org.json.JSONException;
import org.json.JSONObject;
import pye;
import qtj;
import qtk;
import rjb;
import vct;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, ogr
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
  protected ohe a;
  private qtk jdField_a_of_type_Qtk;
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
  private HashMap<Integer, okp> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Ohe = new okg(this);
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, aciy.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new okm(this));
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
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(paramInt2)).setText(paramString);
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
    paramView = new okp((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramView);
    d(paramInt1);
  }
  
  private void a(List<oqq> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = aciy.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Qtk.a(paramList);
      if (!this.jdField_f_of_type_Boolean) {
        break label154;
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
      j = aciy.a(7.5F, getResources());
      break;
      label154:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -aciy.a(70.0F, getResources()), 0.0F);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    }
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
    localValueAnimator.addUpdateListener(new oko(this));
    localValueAnimator.addListener(new okf(this));
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
    a(2131299811, 2131299812, ajjy.a(2131647334), 2, 0);
    Object localObject1 = bgmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131310203);
    int j;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (bgms)((List)localObject1).get(j);
        if (((bgms)localObject2).jdField_a_of_type_Int == 10)
        {
          localObject3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131304811);
          if (localObject3 != null)
          {
            ((View)localObject3).setOnClickListener(this);
            if (((bgms)localObject2).jdField_b_of_type_Int != 0) {
              break label166;
            }
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304812)).setText(((bgms)localObject2).jdField_a_of_type_JavaLangString);
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
          if (((bgms)localObject2).jdField_a_of_type_Int == 11)
          {
            a(2131311785, 2131311786, ((bgms)localObject2).jdField_a_of_type_JavaLangString, 2, ((bgms)localObject2).jdField_b_of_type_Int);
            a(((bgms)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131311797, 2131311798, 2131311799, 2131311800);
          }
          else if (((bgms)localObject2).jdField_a_of_type_Int == 12)
          {
            a(2131298794, 2131298795, ((bgms)localObject2).jdField_a_of_type_JavaLangString, 2, ((bgms)localObject2).jdField_b_of_type_Int);
            a(((bgms)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131298798, 2131298799, 2131298800, 2131298801);
          }
          else
          {
            if (((bgms)localObject2).jdField_a_of_type_Int == 13)
            {
              if (localList != null) {
                a(2131301915, 2131301916, ((bgms)localObject2).jdField_a_of_type_JavaLangString, 2, ((bgms)localObject2).jdField_b_of_type_Int);
              }
              for (;;)
              {
                a(((bgms)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131301921, 2131301922, 2131301923, 2131301924);
                break;
                a(2131301915, 2131301916, ((bgms)localObject2).jdField_a_of_type_JavaLangString, 3, ((bgms)localObject2).jdField_b_of_type_Int);
              }
            }
            if (((bgms)localObject2).jdField_a_of_type_Int == 14)
            {
              a(2131310467, 2131310468, ((bgms)localObject2).jdField_a_of_type_JavaLangString, 2, ((bgms)localObject2).jdField_b_of_type_Int);
              a(((bgms)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131310469, 2131310470, 2131310471, 2131310472);
            }
            else if (((bgms)localObject2).jdField_a_of_type_Int == 15)
            {
              this.jdField_f_of_type_Int = 2;
              a(2131310203, 2131310204, ((bgms)localObject2).jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, ((bgms)localObject2).jdField_b_of_type_Int);
              a(((bgms)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131310214, 2131310215, 2131310216, 2131310217);
            }
          }
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131304811);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(this);
      }
      a(2131301915, 2131301916, ajjy.a(2131647175), 2, 0);
      a(13, this.jdField_a_of_type_AndroidViewView, 2131301921, 2131301922, 2131301923, 2131301924);
      a(2131298794, 2131298795, ajjy.a(2131646919), 2, 0);
      a(12, this.jdField_a_of_type_AndroidViewView, 2131298798, 2131298799, 2131298800, 2131298801);
      if (localList == null) {
        break label960;
      }
      a(2131311785, 2131311786, ajjy.a(2131647271), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131311797, 2131311798, 2131311799, 2131311800);
      a(2131310467, 2131310468, ajjy.a(2131647227), 2, 0);
      a(14, this.jdField_a_of_type_AndroidViewView, 2131310469, 2131310470, 2131310471, 2131310472);
      if (!obb.jdField_a_of_type_Boolean) {
        break label981;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131310203, 2131310204, ajjy.a(2131646918), this.jdField_f_of_type_Int, 0);
      label734:
      a(15, this.jdField_a_of_type_AndroidViewView, 2131310214, 2131310215, 2131310216, 2131310217);
      a(2131299811, 2131299812, ajjy.a(2131647099), 2, 0);
    }
    Object localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131299398);
    label898:
    if ((localList != null) && (localList.size() > 0))
    {
      localObject3 = LayoutInflater.from(getActivity());
      j = 0;
      label815:
      if (j < localList.size())
      {
        bgmt localbgmt = (bgmt)localList.get(j);
        View localView = ((LayoutInflater)localObject3).inflate(2131495454, null);
        TextView localTextView = (TextView)localView.findViewById(2131302757);
        a(localbgmt.jdField_a_of_type_Int, localView, 2131302763, 2131302764, 2131302765, 2131302766);
        if (localbgmt.jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = "";
          localTextView.setText((CharSequence)localObject1);
          if ((localbgmt == null) || (j == localList.size() - 1)) {
            break label1020;
          }
          a(2, localbgmt.jdField_a_of_type_Int, localView, localbgmt.jdField_a_of_type_JavaLangString, localbgmt.jdField_b_of_type_JavaLangString, true);
          ((LinearLayout)localObject2).addView(localView);
        }
        for (;;)
        {
          j += 1;
          break label815;
          label960:
          a(2131311785, 2131311786, ajjy.a(2131647200), 3, 0);
          break;
          label981:
          this.jdField_f_of_type_Int = 3;
          a(2131310203, 2131310204, ajjy.a(2131647205), this.jdField_f_of_type_Int, 0);
          break label734;
          localObject1 = localbgmt.jdField_a_of_type_JavaLangString;
          break label898;
          label1020:
          if (localbgmt != null)
          {
            a(3, localbgmt.jdField_a_of_type_Int, localView, localbgmt.jdField_a_of_type_JavaLangString, localbgmt.jdField_b_of_type_JavaLangString, true);
            ((LinearLayout)localObject2).addView(localView);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302061));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304993));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131304075).setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131310163).setVisibility(8);
    }
    while (obb.jdField_a_of_type_Boolean)
    {
      a(2131300575, 2131300576, ajjy.a(2131647125), 3, 0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131300575);
      if (localObject1 == null)
      {
        return;
        int k = aciy.a(44.5F, getResources());
        j = k;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
        localObject1 = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131303156);
        ((Switch)localObject1).setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
        ((Switch)localObject1).setTrackResource(2130841890);
        ((Switch)localObject1).setThumbResource(2130841889);
        ((Switch)localObject1).setOnClickListener(this);
        ((Switch)localObject1).setOnCheckedChangeListener(new oke(this));
      }
      else
      {
        ((TextView)((View)localObject1).findViewById(2131307493)).setText(obb.l);
        localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131310203);
        this.jdField_f_of_type_Int = 2;
        ((View)localObject1).setBackgroundResource(2130839154);
      }
    }
    if (obm.a()) {
      a(2131306342, 2131306345, "PTS全家桶", 3, 0);
    }
    this.h = bgmq.u();
    boolean bool;
    if (((Integer)bgmq.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1)
    {
      bool = true;
      this.i = bool;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131310062);
      if ((!this.h) && (!this.i)) {
        break label1826;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      label1409:
      if (this.h) {
        a(2131298921, 2131298922, ajjy.a(2131647314), 3, 0);
      }
      if (this.i) {
        a(2131305262, 2131305261, ajjy.a(2131647306), 3, 0);
      }
      a();
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131300904);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300921));
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          j = bgmq.y(getActivity().getAppRuntime());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(bgmq.a(j));
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
          }
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131300304);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300307));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300306));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131298174));
        this.jdField_a_of_type_Qtk = new qtk(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Qtk);
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131310192);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302098);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131300998);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bgmq.a(getActivity().getAppRuntime()).booleanValue()) {
          break label1836;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299097));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new oki(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131310061));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304167));
      h();
      w();
      return;
      bool = false;
      break;
      label1826:
      ((LinearLayout)localObject1).setVisibility(8);
      break label1409;
      label1836:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    okp localokp = (okp)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localokp == null) || (localokp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localokp.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localokp.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      beih.a(localokp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130849057, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      beih.a(localokp.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localokp.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    beih.a(localokp.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(azue.a);
    localokp.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localokp.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130845278);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localokp.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = aciy.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -aciy.a(100.0F, getResources()), aciy.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new okj(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new okk(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302883));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303951));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303968));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303963));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312514));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312324));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131299854));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303522));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131313381);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304233));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304239));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304245));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304234));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312560));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131298794).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131301915).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131311785).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131310467).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131303513).setOnClickListener(this);
      long l = bgmq.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bgmq.a(l, 9900000L, "999万", "0"));
      l = bgmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bgmq.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131299847).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label673;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - aciy.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303965)).setPadding(0, aciy.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131303957).setOnClickListener(this);
      l();
      m();
      ndn.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label673:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845293);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845290);
      }
    }
  }
  
  private void l()
  {
    int j = bjeh.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131303955);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vct.a(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vct.a(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (vct.a(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void m()
  {
    if (ThemeUtil.isInNightMode(obz.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131309077);
      if (localViewStub != null) {
        localViewStub.inflate();
      }
    }
  }
  
  private void n()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyDailySettingFragment.class);
  }
  
  private void o()
  {
    PublicFragmentActivity.a(getActivity(), ReadInJoyProteusFamilyFragment.class);
  }
  
  private void p()
  {
    Object localObject = obz.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = obb.g + baaw.encodeToString(((String)localObject).getBytes(), 2);
    if (!bgmq.t())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    rjb.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + baaw.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void q()
  {
    ndn.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
    PublicFragmentActivity.a(getActivity(), ReadInJoyDraftboxFragment.class);
  }
  
  private void r()
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
  
  private void s()
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -aciy.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new okn(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    pye.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    pye localpye = pye.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localpye.a(str, j);
      return;
    }
  }
  
  private void v()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  private void w()
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
      j = bgmq.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bgmq.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bgmq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bgmq.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Qtk != null) {
        this.jdField_a_of_type_Qtk.a(bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bgmq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bgmq.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bgmq.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bgmq.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
          break label442;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      y();
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
  
  private void x()
  {
    try
    {
      this.jdField_a_of_type_Float = getResources().getDimension(2131167482);
      this.jdField_b_of_type_Float = getResources().getDimension(2131167484);
      this.jdField_c_of_type_Float = getResources().getDimension(2131167485);
      this.jdField_d_of_type_Float = getResources().getDimension(2131167483);
      this.jdField_b_of_type_Int = ((int)babp.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void y()
  {
    nis localnis = bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localnis == null) || (localnis.jdField_c_of_type_Int <= 0) || (localnis.d <= 0) || (TextUtils.isEmpty(localnis.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302183);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new okh(this, localImageView, localnis));
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
        beih.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312821), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      beih.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312821), j, this.jdField_c_of_type_Int, 2130849057, 99, null);
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
      paramView.setOnClickListener(new okl(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130845290);
      continue;
      paramView.setBackgroundResource(2130845293);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842358);
      }
      else
      {
        paramView.setBackgroundResource(2130845292);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842355);
        }
        else
        {
          paramView.setBackgroundResource(2130845291);
          continue;
          paramView.setBackgroundColor(2130845290);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    w();
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
    t();
    u();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    ogy.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    v();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.11(this));
  }
  
  public void c()
  {
    if (this.i) {
      ndn.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", obz.c(), false);
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131299375: 
    default: 
    case 2131304811: 
    case 2131303963: 
    case 2131304075: 
    case 2131312324: 
    case 2131310203: 
    case 2131310467: 
    case 2131300575: 
    case 2131300904: 
    case 2131300304: 
    case 2131303957: 
    case 2131301915: 
    case 2131304239: 
    case 2131311785: 
    case 2131298794: 
    case 2131299811: 
    case 2131313404: 
    case 2131302883: 
    case 2131303951: 
    case 2131304233: 
    case 2131304245: 
    case 2131304234: 
    case 2131303513: 
    case 2131302061: 
    case 2131299847: 
    case 2131298921: 
    case 2131305262: 
    case 2131304167: 
      for (;;)
      {
        return;
        ndn.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", obz.c(this.jdField_c_of_type_Int), false);
        obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), 2);
        ndn.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", obz.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.q();
        return;
        p();
        ndn.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", obz.c(), false);
        return;
        ThreadManager.postImmediately(new ReadInJoySelfFragment.6(this), null, true);
        startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
        b(15);
        awqx.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", obz.c());
        return;
        nji.a(this.jdField_a_of_type_AndroidViewView.getContext(), b(14));
        b(14);
        return;
        obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.m);
        return;
        obz.b(this.jdField_a_of_type_AndroidViewView.getContext(), obb.u);
        paramView = new ocg().b().a();
        if (!TextUtils.isEmpty(paramView))
        {
          ndn.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bgmq.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
          return;
          paramView = bgmq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          int j;
          if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0)
          {
            s();
            j = 0;
          }
          for (;;)
          {
            if (j <= 0) {
              break label727;
            }
            paramView = new ocg().b().a();
            if (TextUtils.isEmpty(paramView)) {
              break;
            }
            ndn.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bgmq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", paramView, false);
            return;
            if ((paramView != null) && (paramView.size() > 1))
            {
              a(paramView);
              j = 1;
            }
            else
            {
              obz.b(this.jdField_a_of_type_AndroidViewView.getContext(), obb.v);
              j = 2;
            }
          }
          continue;
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.n);
          paramView = obz.a();
          ndn.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, b(13) + "", "", "", paramView.toString(), false);
          b(13);
          return;
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.o);
          paramView = obz.a();
          ndn.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, b(11) + "", "", "", paramView.toString(), false);
          b(11);
          return;
          paramView = obb.p.replace("_bid", "_pbid") + "&_jbid=3257&_vjs=collectBox&_prenr=1";
          Bundle localBundle = new Bundle();
          localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView, localBundle);
          paramView = obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.2.6".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          ndn.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, b(12) + "", "", "", paramView, false);
          b(12);
          return;
          q();
          return;
          rjb.a(this.jdField_a_of_type_AndroidViewView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
          return;
          getActivity().finish();
          return;
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.r);
          ndn.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.2.6".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
          return;
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.s);
          ndn.a(null, "CliOper", "", "", "0X8009927", "0X8009927", 0, 0, "", "", "", obz.c(), false);
          return;
          obz.a(this.jdField_a_of_type_AndroidViewView.getContext(), obb.t);
          return;
          new qtj(getActivity()).a(String.format(ajjy.a(2131647066), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), ajjy.a(2131647330));
          paramView = new JSONObject();
          try
          {
            paramView.put("number", String.valueOf(bgmq.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
            ndn.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", obz.a(paramView), false);
            return;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          r();
          return;
          p();
          ndn.a(null, "", "0X8009925", "0X8009925", 0, 0, "", "", "", "", false);
          return;
          rjb.a(getActivity(), null, "https://viola.qq.com/js/myFamily.js?_rij_violaUrl=1&v_tid=6&v_bundleName=myFamily&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740", null);
          return;
          rjb.a(getActivity(), null, "https://viola.qq.com/js/notes-center.js?_rij_violaUrl=1&v_nav_immer=1&v_tid=15&v_bid=3811&v_bundleName=notes-center&hideNav=1&statusBarStyle=1", null);
          ndn.a(null, "", "0X800A607", "0X800A607", 0, 0, "", "", "", "", false);
          return;
          try
          {
            paramView = (nis)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
            if (paramView != null)
            {
              obz.a(getActivity(), paramView);
              return;
            }
          }
          catch (Exception paramView)
          {
            for (;;)
            {
              paramView = null;
            }
          }
        }
      }
    case 2131306342: 
      label727:
      o();
      return;
    }
    n();
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
      this.jdField_f_of_type_Boolean = bgmq.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    ohb.a().a(this.jdField_a_of_type_Ohe);
    x();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131494450;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131494452;
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
    ohb.a().b(this.jdField_a_of_type_Ohe);
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
    ogy.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment
 * JD-Core Version:    0.7.0.1
 */