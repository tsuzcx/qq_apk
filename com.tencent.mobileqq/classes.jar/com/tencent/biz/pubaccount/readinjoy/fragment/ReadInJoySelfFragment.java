package com.tencent.biz.pubaccount.readinjoy.fragment;

import actn;
import ajyc;
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
import axqw;
import bavi;
import bbca;
import bbct;
import bfqb;
import bhvh;
import bhvj;
import bhvk;
import bkur;
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
import noo;
import nuc;
import nut;
import omm;
import omx;
import onk;
import onr;
import org.json.JSONException;
import org.json.JSONObject;
import osc;
import osj;
import osm;
import osp;
import ovq;
import ovr;
import ovs;
import ovt;
import ovu;
import ovv;
import ovw;
import ovx;
import ovy;
import ovz;
import owa;
import owb;
import pbr;
import qke;
import rfv;
import rfw;
import rwa;
import vpp;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, osc
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
  protected osp a;
  private rfw jdField_a_of_type_Rfw;
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
  private HashMap<Integer, owb> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Osp = new ovs(this);
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, actn.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new ovy(this));
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
    paramView = new owb((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramView);
    d(paramInt1);
  }
  
  private void a(List<pbr> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = actn.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Rfw.a(paramList);
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
      j = actn.a(7.5F, getResources());
      break;
      label154:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -actn.a(70.0F, getResources()), 0.0F);
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
    localValueAnimator.addUpdateListener(new owa(this));
    localValueAnimator.addListener(new ovr(this));
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
    a(2131365390, 2131365391, ajyc.a(2131713122), 2, 0);
    Object localObject1 = bhvh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375970);
    int j;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (bhvj)((List)localObject1).get(j);
        if (((bhvj)localObject2).jdField_a_of_type_Int == 10)
        {
          localObject3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370476);
          if (localObject3 != null)
          {
            ((View)localObject3).setOnClickListener(this);
            if (((bhvj)localObject2).jdField_b_of_type_Int != 0) {
              break label166;
            }
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370477)).setText(((bhvj)localObject2).jdField_a_of_type_JavaLangString);
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
          if (((bhvj)localObject2).jdField_a_of_type_Int == 11)
          {
            a(2131377600, 2131377601, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhvj)localObject2).jdField_b_of_type_Int);
            a(((bhvj)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377612, 2131377613, 2131377614, 2131377615);
          }
          else if (((bhvj)localObject2).jdField_a_of_type_Int == 12)
          {
            a(2131364350, 2131364351, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhvj)localObject2).jdField_b_of_type_Int);
            a(((bhvj)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364354, 2131364355, 2131364356, 2131364357);
          }
          else
          {
            if (((bhvj)localObject2).jdField_a_of_type_Int == 13)
            {
              if (localList != null) {
                a(2131367532, 2131367533, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhvj)localObject2).jdField_b_of_type_Int);
              }
              for (;;)
              {
                a(((bhvj)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131367538, 2131367539, 2131367540, 2131367541);
                break;
                a(2131367532, 2131367533, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, 3, ((bhvj)localObject2).jdField_b_of_type_Int);
              }
            }
            if (((bhvj)localObject2).jdField_a_of_type_Int == 14)
            {
              a(2131376259, 2131376260, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhvj)localObject2).jdField_b_of_type_Int);
              a(((bhvj)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131376261, 2131376262, 2131376263, 2131376264);
            }
            else if (((bhvj)localObject2).jdField_a_of_type_Int == 15)
            {
              this.jdField_f_of_type_Int = 2;
              a(2131375970, 2131375971, ((bhvj)localObject2).jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, ((bhvj)localObject2).jdField_b_of_type_Int);
              a(((bhvj)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131375981, 2131375982, 2131375983, 2131375984);
            }
          }
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370476);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(this);
      }
      a(2131367532, 2131367533, ajyc.a(2131712963), 2, 0);
      a(13, this.jdField_a_of_type_AndroidViewView, 2131367538, 2131367539, 2131367540, 2131367541);
      a(2131364350, 2131364351, ajyc.a(2131712707), 2, 0);
      a(12, this.jdField_a_of_type_AndroidViewView, 2131364354, 2131364355, 2131364356, 2131364357);
      if (localList == null) {
        break label960;
      }
      a(2131377600, 2131377601, ajyc.a(2131713059), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131377612, 2131377613, 2131377614, 2131377615);
      a(2131376259, 2131376260, ajyc.a(2131713015), 2, 0);
      a(14, this.jdField_a_of_type_AndroidViewView, 2131376261, 2131376262, 2131376263, 2131376264);
      if (!omm.jdField_a_of_type_Boolean) {
        break label981;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131375970, 2131375971, ajyc.a(2131712706), this.jdField_f_of_type_Int, 0);
      label734:
      a(15, this.jdField_a_of_type_AndroidViewView, 2131375981, 2131375982, 2131375983, 2131375984);
      a(2131365390, 2131365391, ajyc.a(2131712887), 2, 0);
    }
    Object localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364967);
    label898:
    if ((localList != null) && (localList.size() > 0))
    {
      localObject3 = LayoutInflater.from(getActivity());
      j = 0;
      label815:
      if (j < localList.size())
      {
        bhvk localbhvk = (bhvk)localList.get(j);
        View localView = ((LayoutInflater)localObject3).inflate(2131561041, null);
        TextView localTextView = (TextView)localView.findViewById(2131368381);
        a(localbhvk.jdField_a_of_type_Int, localView, 2131368387, 2131368388, 2131368389, 2131368390);
        if (localbhvk.jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = "";
          localTextView.setText((CharSequence)localObject1);
          if ((localbhvk == null) || (j == localList.size() - 1)) {
            break label1020;
          }
          a(2, localbhvk.jdField_a_of_type_Int, localView, localbhvk.jdField_a_of_type_JavaLangString, localbhvk.jdField_b_of_type_JavaLangString, true);
          ((LinearLayout)localObject2).addView(localView);
        }
        for (;;)
        {
          j += 1;
          break label815;
          label960:
          a(2131377600, 2131377601, ajyc.a(2131712988), 3, 0);
          break;
          label981:
          this.jdField_f_of_type_Int = 3;
          a(2131375970, 2131375971, ajyc.a(2131712993), this.jdField_f_of_type_Int, 0);
          break label734;
          localObject1 = localbhvk.jdField_a_of_type_JavaLangString;
          break label898;
          label1020:
          if (localbhvk != null)
          {
            a(3, localbhvk.jdField_a_of_type_Int, localView, localbhvk.jdField_a_of_type_JavaLangString, localbhvk.jdField_b_of_type_JavaLangString, true);
            ((LinearLayout)localObject2).addView(localView);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367679));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370659));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369748).setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131375927).setVisibility(8);
    }
    while (omm.jdField_a_of_type_Boolean)
    {
      a(2131366177, 2131366178, ajyc.a(2131712913), 3, 0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366177);
      if (localObject1 == null)
      {
        return;
        int k = actn.a(44.5F, getResources());
        j = k;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          j = k + ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
        localObject1 = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131368796);
        ((Switch)localObject1).setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
        ((Switch)localObject1).setTrackResource(2130841983);
        ((Switch)localObject1).setThumbResource(2130841982);
        ((Switch)localObject1).setOnClickListener(this);
        ((Switch)localObject1).setOnCheckedChangeListener(new ovq(this));
      }
      else
      {
        ((TextView)((View)localObject1).findViewById(2131373204)).setText(omm.l);
        localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131375970);
        this.jdField_f_of_type_Int = 2;
        ((View)localObject1).setBackgroundResource(2130839179);
      }
    }
    if (omx.a()) {
      a(2131372039, 2131372042, "PTS全家桶", 3, 0);
    }
    this.h = bhvh.t();
    boolean bool;
    if (((Integer)bhvh.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1)
    {
      bool = true;
      this.i = bool;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375826);
      if ((!this.h) && (!this.i)) {
        break label1826;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      label1409:
      if (this.h) {
        a(2131364481, 2131364482, ajyc.a(2131713102), 3, 0);
      }
      if (this.i) {
        a(2131370936, 2131370935, ajyc.a(2131713094), 3, 0);
      }
      a();
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366513);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366530));
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          j = bhvh.y(getActivity().getAppRuntime());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvh.a(j));
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + j);
          }
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131365904);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365907));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365906));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363729));
        this.jdField_a_of_type_Rfw = new rfw(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Rfw);
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375959);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367716);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366609);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bhvh.a(getActivity().getAppRuntime()).booleanValue()) {
          break label1836;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364657));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new ovu(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375825));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369845));
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
    owb localowb = (owb)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localowb == null) || (localowb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localowb.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localowb.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      bfqb.a(localowb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130849292, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      bfqb.a(localowb.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localowb.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    bfqb.a(localowb.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bavi.a);
    localowb.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localowb.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130845463);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localowb.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = actn.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -actn.a(100.0F, getResources()), actn.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new ovv(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new ovw(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368507));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369625));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369641));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369636));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378339));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378148));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365434));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369190));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379216);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369912));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369919));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369925));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369913));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378384));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364350).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367532).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377600).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131376259).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369181).setOnClickListener(this);
      long l = bhvh.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bhvh.a(l, 9900000L, "999万", "0"));
      l = bhvh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bhvh.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365427).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label673;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - actn.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369638)).setPadding(0, actn.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369630).setOnClickListener(this);
      l();
      m();
      noo.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label673:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845477);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845474);
      }
    }
  }
  
  private void l()
  {
    int j = bkur.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369628);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vpp.b(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vpp.b(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (vpp.b(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void m()
  {
    if (ThemeUtil.isInNightMode(onk.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131374819);
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
    Object localObject = onk.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = omm.g + bbca.encodeToString(((String)localObject).getBytes(), 2);
    if (!bhvh.s())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    rwa.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bbca.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void q()
  {
    noo.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -actn.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ovz(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    qke.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    qke localqke = qke.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localqke.a(str, j);
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
      j = bhvh.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvh.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bhvh.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bhvh.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Rfw != null) {
        this.jdField_a_of_type_Rfw.a(bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bhvh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bhvh.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bhvh.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bhvh.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
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
      this.jdField_a_of_type_Float = getResources().getDimension(2131298575);
      this.jdField_b_of_type_Float = getResources().getDimension(2131298577);
      this.jdField_c_of_type_Float = getResources().getDimension(2131298578);
      this.jdField_d_of_type_Float = getResources().getDimension(2131298576);
      this.jdField_b_of_type_Int = ((int)bbct.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void y()
  {
    nuc localnuc = bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localnuc == null) || (localnuc.jdField_c_of_type_Int <= 0) || (localnuc.d <= 0) || (TextUtils.isEmpty(localnuc.jdField_b_of_type_JavaLangString))) {
      QLog.d("Q.readinjoy.self.SelfFragment", 1, "showMedal! no medal info! ");
    }
    ImageView localImageView;
    ViewTreeObserver localViewTreeObserver;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367801);
      localViewTreeObserver = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver();
    } while (!localViewTreeObserver.isAlive());
    localViewTreeObserver.addOnGlobalLayoutListener(new ovt(this, localImageView, localnuc));
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
        bfqb.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378645), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      bfqb.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378645), j, this.jdField_c_of_type_Int, 2130849292, 99, null);
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
      paramView.setOnClickListener(new ovx(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130845474);
      continue;
      paramView.setBackgroundResource(2130845477);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842432);
      }
      else
      {
        paramView.setBackgroundResource(2130845476);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842429);
        }
        else
        {
          paramView.setBackgroundResource(2130845475);
          continue;
          paramView.setBackgroundColor(2130845474);
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
    osj.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    v();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.11(this));
  }
  
  public void c()
  {
    if (this.i) {
      noo.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", onk.c(), false);
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
    case 2131364939: 
    default: 
    case 2131370476: 
    case 2131369636: 
    case 2131369748: 
    case 2131378148: 
    case 2131375970: 
    case 2131376259: 
    case 2131366177: 
    case 2131366513: 
    case 2131365904: 
    case 2131369630: 
    case 2131367532: 
    case 2131369919: 
    case 2131377600: 
    case 2131364350: 
    case 2131365390: 
    case 2131379239: 
    case 2131368507: 
    case 2131369625: 
    case 2131369912: 
    case 2131369925: 
    case 2131369913: 
    case 2131369181: 
    case 2131367679: 
    case 2131365427: 
    case 2131364481: 
    case 2131370936: 
    case 2131369845: 
      for (;;)
      {
        return;
        noo.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", onk.c(this.jdField_c_of_type_Int), false);
        onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), 2);
        noo.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", onk.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.q();
        return;
        p();
        noo.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", onk.c(), false);
        return;
        ThreadManager.postImmediately(new ReadInJoySelfFragment.6(this), null, true);
        startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
        b(15);
        axqw.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", onk.c());
        return;
        nut.a(this.jdField_a_of_type_AndroidViewView.getContext(), b(14));
        b(14);
        return;
        onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.m);
        return;
        onk.b(this.jdField_a_of_type_AndroidViewView.getContext(), omm.u);
        paramView = new onr().b().a();
        if (!TextUtils.isEmpty(paramView))
        {
          noo.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bhvh.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
          return;
          paramView = bhvh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
            paramView = new onr().b().a();
            if (TextUtils.isEmpty(paramView)) {
              break;
            }
            noo.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bhvh.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", paramView, false);
            return;
            if ((paramView != null) && (paramView.size() > 1))
            {
              a(paramView);
              j = 1;
            }
            else
            {
              onk.b(this.jdField_a_of_type_AndroidViewView.getContext(), omm.v);
              j = 2;
            }
          }
          continue;
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.n);
          paramView = onk.a();
          noo.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, b(13) + "", "", "", paramView.toString(), false);
          b(13);
          return;
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.o);
          paramView = onk.a();
          noo.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, b(11) + "", "", "", paramView.toString(), false);
          b(11);
          return;
          paramView = omm.p.replace("_bid", "_pbid") + "&_jbid=3257&_vjs=collectBox&_prenr=1";
          Bundle localBundle = new Bundle();
          localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView, localBundle);
          paramView = onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.2.8".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          noo.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, b(12) + "", "", "", paramView, false);
          b(12);
          return;
          q();
          return;
          rwa.a(this.jdField_a_of_type_AndroidViewView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
          return;
          getActivity().finish();
          return;
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.r);
          noo.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.2.8".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
          return;
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.s);
          noo.a(null, "CliOper", "", "", "0X8009927", "0X8009927", 0, 0, "", "", "", onk.c(), false);
          return;
          onk.a(this.jdField_a_of_type_AndroidViewView.getContext(), omm.t);
          return;
          new rfv(getActivity()).a(String.format(ajyc.a(2131712854), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), ajyc.a(2131713118));
          paramView = new JSONObject();
          try
          {
            paramView.put("number", String.valueOf(bhvh.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
            noo.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", onk.a(paramView), false);
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
          noo.a(null, "", "0X8009925", "0X8009925", 0, 0, "", "", "", "", false);
          return;
          rwa.a(getActivity(), null, "https://viola.qq.com/js/myFamily.js?_rij_violaUrl=1&v_tid=6&v_bundleName=myFamily&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740", null);
          return;
          rwa.a(getActivity(), null, "https://viola.qq.com/js/notes-center.js?_rij_violaUrl=1&v_nav_immer=1&v_tid=15&v_bid=3811&v_bundleName=notes-center&hideNav=1&statusBarStyle=1", null);
          noo.a(null, "", "0X800A607", "0X800A607", 0, 0, "", "", "", "", false);
          return;
          try
          {
            paramView = (nuc)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
            if (paramView != null)
            {
              onk.a(getActivity(), paramView);
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
    case 2131372039: 
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
      this.jdField_f_of_type_Boolean = bhvh.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    osm.a().a(this.jdField_a_of_type_Osp);
    x();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    int j = 2131560016;
    if (this.jdField_f_of_type_Boolean) {
      j = 2131560018;
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
    osm.a().b(this.jdField_a_of_type_Osp);
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
    osj.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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