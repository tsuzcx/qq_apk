package com.tencent.biz.pubaccount.readinjoy.fragment;

import actj;
import ajya;
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
import axqy;
import bavw;
import bbco;
import bbdh;
import bfqs;
import bhvy;
import bhwa;
import bhwb;
import bkvi;
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
import nol;
import ntz;
import nuq;
import omj;
import omu;
import onh;
import ono;
import org.json.JSONException;
import org.json.JSONObject;
import orz;
import osg;
import osj;
import osm;
import ovn;
import ovo;
import ovp;
import ovq;
import ovr;
import ovs;
import ovt;
import ovu;
import ovv;
import ovw;
import ovx;
import ovy;
import pbo;
import qkb;
import rfs;
import rft;
import rvx;
import vpm;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, orz
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
  protected osm a;
  private rft jdField_a_of_type_Rft;
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
  private HashMap<Integer, ovy> jdField_b_of_type_JavaUtilHashMap = new HashMap();
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
    this.jdField_a_of_type_Osm = new ovp(this);
  }
  
  private ValueAnimator a()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, actj.a(55.0F, getActivity().getResources()) });
    localValueAnimator.addUpdateListener(new ovv(this));
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
    paramView = new ovy((DragTextView)paramView.findViewById(paramInt2), (RelativeLayout)paramView.findViewById(paramInt3), (URLImageView)paramView.findViewById(paramInt4), (DragTextView)paramView.findViewById(paramInt5));
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), paramView);
    d(paramInt1);
  }
  
  private void a(List<pbo> paramList)
  {
    HorizontalListView localHorizontalListView = this.jdField_a_of_type_ComTencentWidgetHorizontalListView;
    int j;
    if (paramList.size() == 2)
    {
      j = actj.a(11.0F, getResources());
      localHorizontalListView.setDividerWidth(j);
      this.jdField_a_of_type_Rft.a(paramList);
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
      j = actj.a(7.5F, getResources());
      break;
      label154:
      if (this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation == null)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -actj.a(70.0F, getResources()), 0.0F);
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
    localValueAnimator.addUpdateListener(new ovx(this));
    localValueAnimator.addListener(new ovo(this));
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
    a(2131365389, 2131365390, ajya.a(2131713133), 2, 0);
    Object localObject1 = bhvy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    List localList = bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_f_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375972);
    int j;
    Object localObject3;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      j = 0;
      if (j < ((List)localObject1).size())
      {
        localObject2 = (bhwa)((List)localObject1).get(j);
        if (((bhwa)localObject2).jdField_a_of_type_Int == 10)
        {
          localObject3 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370475);
          if (localObject3 != null)
          {
            ((View)localObject3).setOnClickListener(this);
            if (((bhwa)localObject2).jdField_b_of_type_Int != 0) {
              break label166;
            }
            ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370476)).setText(((bhwa)localObject2).jdField_a_of_type_JavaLangString);
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
          if (((bhwa)localObject2).jdField_a_of_type_Int == 11)
          {
            a(2131377600, 2131377601, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhwa)localObject2).jdField_b_of_type_Int);
            a(((bhwa)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131377612, 2131377613, 2131377614, 2131377615);
          }
          else if (((bhwa)localObject2).jdField_a_of_type_Int == 12)
          {
            a(2131364349, 2131364350, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhwa)localObject2).jdField_b_of_type_Int);
            a(((bhwa)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131364353, 2131364354, 2131364355, 2131364356);
          }
          else
          {
            if (((bhwa)localObject2).jdField_a_of_type_Int == 13)
            {
              if (localList != null) {
                a(2131367532, 2131367533, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhwa)localObject2).jdField_b_of_type_Int);
              }
              for (;;)
              {
                a(((bhwa)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131367538, 2131367539, 2131367540, 2131367541);
                break;
                a(2131367532, 2131367533, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, 3, ((bhwa)localObject2).jdField_b_of_type_Int);
              }
            }
            if (((bhwa)localObject2).jdField_a_of_type_Int == 14)
            {
              a(2131376261, 2131376262, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, 2, ((bhwa)localObject2).jdField_b_of_type_Int);
              a(((bhwa)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131376263, 2131376264, 2131376265, 2131376266);
            }
            else if (((bhwa)localObject2).jdField_a_of_type_Int == 15)
            {
              this.jdField_f_of_type_Int = 2;
              a(2131375972, 2131375973, ((bhwa)localObject2).jdField_a_of_type_JavaLangString, this.jdField_f_of_type_Int, ((bhwa)localObject2).jdField_b_of_type_Int);
              a(((bhwa)localObject2).jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView, 2131375983, 2131375984, 2131375985, 2131375986);
            }
          }
        }
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131370475);
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setOnClickListener(this);
      }
      a(2131367532, 2131367533, ajya.a(2131712974), 2, 0);
      a(13, this.jdField_a_of_type_AndroidViewView, 2131367538, 2131367539, 2131367540, 2131367541);
      a(2131364349, 2131364350, ajya.a(2131712718), 2, 0);
      a(12, this.jdField_a_of_type_AndroidViewView, 2131364353, 2131364354, 2131364355, 2131364356);
      if (localList == null) {
        break label960;
      }
      a(2131377600, 2131377601, ajya.a(2131713070), 2, 0);
      a(11, this.jdField_a_of_type_AndroidViewView, 2131377612, 2131377613, 2131377614, 2131377615);
      a(2131376261, 2131376262, ajya.a(2131713026), 2, 0);
      a(14, this.jdField_a_of_type_AndroidViewView, 2131376263, 2131376264, 2131376265, 2131376266);
      if (!omj.jdField_a_of_type_Boolean) {
        break label981;
      }
      this.jdField_f_of_type_Int = 2;
      a(2131375972, 2131375973, ajya.a(2131712717), this.jdField_f_of_type_Int, 0);
      label734:
      a(15, this.jdField_a_of_type_AndroidViewView, 2131375983, 2131375984, 2131375985, 2131375986);
      a(2131365389, 2131365390, ajya.a(2131712898), 2, 0);
    }
    Object localObject2 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364966);
    label898:
    if ((localList != null) && (localList.size() > 0))
    {
      localObject3 = LayoutInflater.from(getActivity());
      j = 0;
      label815:
      if (j < localList.size())
      {
        bhwb localbhwb = (bhwb)localList.get(j);
        View localView = ((LayoutInflater)localObject3).inflate(2131561040, null);
        TextView localTextView = (TextView)localView.findViewById(2131368381);
        a(localbhwb.jdField_a_of_type_Int, localView, 2131368387, 2131368388, 2131368389, 2131368390);
        if (localbhwb.jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = "";
          localTextView.setText((CharSequence)localObject1);
          if ((localbhwb == null) || (j == localList.size() - 1)) {
            break label1020;
          }
          a(2, localbhwb.jdField_a_of_type_Int, localView, localbhwb.jdField_a_of_type_JavaLangString, localbhwb.jdField_b_of_type_JavaLangString, true);
          ((LinearLayout)localObject2).addView(localView);
        }
        for (;;)
        {
          j += 1;
          break label815;
          label960:
          a(2131377600, 2131377601, ajya.a(2131712999), 3, 0);
          break;
          label981:
          this.jdField_f_of_type_Int = 3;
          a(2131375972, 2131375973, ajya.a(2131713004), this.jdField_f_of_type_Int, 0);
          break label734;
          localObject1 = localbhwb.jdField_a_of_type_JavaLangString;
          break label898;
          label1020:
          if (localbhwb != null)
          {
            a(3, localbhwb.jdField_a_of_type_Int, localView, localbhwb.jdField_a_of_type_JavaLangString, localbhwb.jdField_b_of_type_JavaLangString, true);
            ((LinearLayout)localObject2).addView(localView);
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView = ((ReadInJoyHeadImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367679));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNickNameTextView = ((ReadInJoyNickNameTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370659));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369747).setOnClickListener(this);
    if (this.jdField_a_of_type_Int == 1) {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131375929).setVisibility(8);
    }
    while (omj.jdField_a_of_type_Boolean)
    {
      a(2131366177, 2131366178, ajya.a(2131712924), 3, 0);
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366177);
      if (localObject1 == null)
      {
        return;
        int k = actj.a(44.5F, getResources());
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
        ((Switch)localObject1).setOnCheckedChangeListener(new ovn(this));
      }
      else
      {
        ((TextView)((View)localObject1).findViewById(2131373206)).setText(omj.l);
        localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131375972);
        this.jdField_f_of_type_Int = 2;
        ((View)localObject1).setBackgroundResource(2130839179);
      }
    }
    if (omu.a()) {
      a(2131372039, 2131372042, "PTS全家桶", 3, 0);
    }
    this.h = bhvy.t();
    boolean bool;
    if (((Integer)bhvy.a("readinjjoy_notes_config", Integer.valueOf(0))).intValue() == 1)
    {
      bool = true;
      this.i = bool;
      localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375828);
      if ((!this.h) && (!this.i)) {
        break label1826;
      }
      ((LinearLayout)localObject1).setVisibility(0);
      label1409:
      if (this.h) {
        a(2131364480, 2131364481, ajya.a(2131713113), 3, 0);
      }
      if (this.i) {
        a(2131370936, 2131370935, ajya.a(2131713105), 3, 0);
      }
      a();
      localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131366513);
      if (localObject1 != null)
      {
        ((View)localObject1).setOnClickListener(this);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366530));
        if (this.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          j = bhvy.y(getActivity().getAppRuntime());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvy.a(j));
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
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363728));
        this.jdField_a_of_type_Rft = new rft(getActivity(), this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_f_of_type_Boolean);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_Rft);
      }
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375961);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367716);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131366609);
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        if (!bhvy.a(getActivity().getAppRuntime()).booleanValue()) {
          break label1836;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131364656));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new ovr(this));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131375827));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369844));
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
    ovy localovy = (ovy)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localovy == null) || (localovy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView == null) || (localovy.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramInt);
    if (localObject == null)
    {
      localovy.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      bfqs.a(localovy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 0, this.jdField_c_of_type_Int, 2130849301, 99, null);
      return;
    }
    if ((((MySelfNormalItemRedPointInfo)localObject).redPointType == 0) || (TextUtils.isEmpty(((MySelfNormalItemRedPointInfo)localObject).imgUrl)))
    {
      bfqs.a(localovy.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, 1, this.jdField_c_of_type_Int, 0);
      localovy.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    bfqs.a(localovy.b, 1, this.jdField_c_of_type_Int, 0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    localURLDrawableOptions.mPlayGifImage = true;
    localObject = URLDrawable.getDrawable(((MySelfNormalItemRedPointInfo)localObject).imgUrl, localURLDrawableOptions);
    ((URLDrawable)localObject).setDecodeHandler(bavw.a);
    localovy.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    localovy.jdField_a_of_type_ComTencentImageURLImageView.setBackgroundResource(2130845469);
    if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
      ((URLDrawable)localObject).restartDownload();
    }
    localovy.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
  }
  
  private void h()
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_e_of_type_Int = actj.a(23.0F, getActivity().getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.a(true, -actj.a(100.0F, getResources()), actj.a(100.0F, getResources()));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollStateChangedListener(new ovs(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new ovt(this));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368507));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369624));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369640));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout = ((PressEffectLinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369635));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPresseffectPressEffectLinearLayout.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378342));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378151));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365433));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369190));
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379221);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369911));
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369918));
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369924));
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView = ((ReadInjoyMenuIconView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369912));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378389));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoyMenuIconView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131364349).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367532).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131377600).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131376261).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369181).setOnClickListener(this);
      long l = bhvy.c(getActivity().getAppRuntime());
      this.jdField_f_of_type_AndroidWidgetTextView.setText(bhvy.a(l, 9900000L, "999万", "0"));
      l = bhvy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(bhvy.a(l, 9900000L, "999万", "0"));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyHeadImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131365426).setOnClickListener(this);
      if (!(getActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label673;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      int j = this.jdField_a_of_type_AndroidViewView.getPaddingTop() - actj.a(22.0F, getResources());
      if (j > 0) {
        this.jdField_a_of_type_AndroidViewView.setPadding(0, j, 0, 0);
      }
      ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369637)).setPadding(0, actj.a(4.0F, getResources()), 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131369629).setOnClickListener(this);
      l();
      m();
      nol.a(null, "", "0X8009923", "0X8009923", 0, 0, "", "", "", "", false);
      return;
      label673:
      if (this.jdField_f_of_type_Int == 2) {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845483);
      } else {
        this.jdField_f_of_type_AndroidViewView.setBackgroundResource(2130845480);
      }
    }
  }
  
  private void l()
  {
    int j = bkvi.a(getActivity());
    Object localObject = (LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131369627);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    localLayoutParams.topMargin = j;
    ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vpm.b(getActivity(), 11.0F) + j);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = (vpm.b(getActivity(), 11.0F) + j);
    this.jdField_g_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = (vpm.b(getActivity(), 44.0F) + j);
    this.jdField_e_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void m()
  {
    if (ThemeUtil.isInNightMode(onh.a()))
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(2131374821);
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
    Object localObject = onh.a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      return;
    }
    String str = omj.g + bbco.encodeToString(((String)localObject).getBytes(), 2);
    if (!bhvy.s())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("bundle_param_click_time", System.currentTimeMillis());
      onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), str, (Bundle)localObject);
      return;
    }
    rvx.a(this.jdField_a_of_type_AndroidViewView.getContext(), "", "https://sqimg.qq.com/qq_product_operations/kan/viola_biz/bundle_accountPage.js?v_bid=3531&v_tid=6&_rij_violaUrl=1&v_bundleName=accountPage&hideNav=1&statusColor=1&v_nav_immer=1&adfrom=client&accountId=" + bbco.encodeToString(((String)localObject).getBytes(), 2), null);
  }
  
  private void q()
  {
    nol.a(null, "", "0X80096DE", "0X80096DE", 0, 0, "", "", "", "", false);
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
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -actj.a(70.0F, getResources()));
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
        this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ovw(this));
      }
      this.jdField_d_of_type_AndroidViewView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    qkb.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void u()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    qkb localqkb = qkb.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {}
    for (int j = 0;; j = 1)
    {
      localqkb.a(str, j);
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
      j = bhvy.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(bhvy.a(j));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      j = bhvy.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(bhvy.a(j));
    }
    Object localObject;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localObject = bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_Rft != null) {
        this.jdField_a_of_type_Rft.a(bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        localObject = bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
        l = bhvy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_e_of_type_AndroidWidgetTextView.setText(bhvy.a(l, 9900000L, "999万", "0"));
      }
      if (this.jdField_f_of_type_AndroidWidgetTextView != null)
      {
        l = bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        this.jdField_f_of_type_AndroidWidgetTextView.setText(bhvy.a(l, 9900000L, "999万", "0"));
      }
      boolean bool = bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).booleanValue();
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
        if (bhvy.x(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0) {
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
      this.jdField_b_of_type_Int = ((int)bbdh.i());
      return;
    }
    catch (Exception localException) {}
  }
  
  private void y()
  {
    ntz localntz = bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localntz == null) || (localntz.jdField_c_of_type_Int <= 0) || (localntz.d <= 0) || (TextUtils.isEmpty(localntz.jdField_b_of_type_JavaLangString))) {
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
    localViewTreeObserver.addOnGlobalLayoutListener(new ovq(this, localImageView, localntz));
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
        bfqs.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378650), j, this.jdField_c_of_type_Int, 0, 99, null);
        return;
      }
    }
    if (this.jdField_c_of_type_Int > 0) {}
    for (;;)
    {
      bfqs.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378650), j, this.jdField_c_of_type_Int, 2130849301, 99, null);
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
      paramView.setOnClickListener(new ovu(this, paramString2, paramInt2, paramString1));
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
      paramView.setBackgroundResource(2130845480);
      continue;
      paramView.setBackgroundResource(2130845483);
      continue;
      if (this.jdField_f_of_type_Boolean)
      {
        paramView.setBackgroundResource(2130842433);
      }
      else
      {
        paramView.setBackgroundResource(2130845482);
        continue;
        if (this.jdField_f_of_type_Boolean)
        {
          paramView.setBackgroundResource(2130842430);
        }
        else
        {
          paramView.setBackgroundResource(2130845481);
          continue;
          paramView.setBackgroundColor(2130845480);
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
    osg.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    v();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfFragment.11(this));
  }
  
  public void c()
  {
    if (this.i) {
      nol.a(null, "CliOper", "", "", "0X800A606", "0X800A606", 0, 0, "", "", "", onh.c(), false);
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
    case 2131364938: 
    default: 
    case 2131370475: 
    case 2131369635: 
    case 2131369747: 
    case 2131378151: 
    case 2131375972: 
    case 2131376261: 
    case 2131366177: 
    case 2131366513: 
    case 2131365904: 
    case 2131369629: 
    case 2131367532: 
    case 2131369918: 
    case 2131377600: 
    case 2131364349: 
    case 2131365389: 
    case 2131379244: 
    case 2131368507: 
    case 2131369624: 
    case 2131369911: 
    case 2131369924: 
    case 2131369912: 
    case 2131369181: 
    case 2131367679: 
    case 2131365426: 
    case 2131364480: 
    case 2131370936: 
    case 2131369844: 
      for (;;)
      {
        return;
        nol.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", onh.c(this.jdField_c_of_type_Int), false);
        onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), 2);
        nol.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", onh.c(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c()), false);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.q();
        return;
        p();
        nol.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", onh.c(), false);
        return;
        ThreadManager.postImmediately(new ReadInJoySelfFragment.6(this), null, true);
        startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
        b(15);
        axqy.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", onh.c());
        return;
        nuq.a(this.jdField_a_of_type_AndroidViewView.getContext(), b(14));
        b(14);
        return;
        onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.m);
        return;
        onh.b(this.jdField_a_of_type_AndroidViewView.getContext(), omj.u);
        paramView = new ono().b().a();
        if (!TextUtils.isEmpty(paramView))
        {
          nol.a(null, "CliOper", "", "", "0X80080EE", "0X80080EE", 0, 0, "" + bhvy.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "", "", paramView, false);
          return;
          paramView = bhvy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
            paramView = new ono().b().a();
            if (TextUtils.isEmpty(paramView)) {
              break;
            }
            nol.a(null, "CliOper", "", "", "0X80080EF", "0X80080EF", 0, 0, "" + bhvy.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + j, "", paramView, false);
            return;
            if ((paramView != null) && (paramView.size() > 1))
            {
              a(paramView);
              j = 1;
            }
            else
            {
              onh.b(this.jdField_a_of_type_AndroidViewView.getContext(), omj.v);
              j = 2;
            }
          }
          continue;
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.n);
          paramView = onh.a();
          nol.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, b(13) + "", "", "", paramView.toString(), false);
          b(13);
          return;
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.o);
          paramView = onh.a();
          nol.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, b(11) + "", "", "", paramView.toString(), false);
          b(11);
          return;
          paramView = omj.p.replace("_bid", "_pbid") + "&_jbid=3257&_vjs=collectBox&_prenr=1";
          Bundle localBundle = new Bundle();
          localBundle.putLong("bundle_param_click_time", System.currentTimeMillis());
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView, localBundle);
          paramView = onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.3.0".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
          nol.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, b(12) + "", "", "", paramView, false);
          b(12);
          return;
          q();
          return;
          rvx.a(this.jdField_a_of_type_AndroidViewView.getContext(), "viola测试页面", "https://kandian.qq.com/viola/bundle_home.js?v_bid=3256&statusColor=1", null);
          return;
          getActivity().finish();
          return;
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.r);
          nol.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), "8.3.0".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
          return;
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.s);
          nol.a(null, "CliOper", "", "", "0X8009927", "0X8009927", 0, 0, "", "", "", onh.c(), false);
          return;
          onh.a(this.jdField_a_of_type_AndroidViewView.getContext(), omj.t);
          return;
          new rfs(getActivity()).a(String.format(ajya.a(2131712865), new Object[] { this.jdField_f_of_type_AndroidWidgetTextView.getText() }), ajya.a(2131713129));
          paramView = new JSONObject();
          try
          {
            paramView.put("number", String.valueOf(bhvy.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)));
            nol.a(null, "CliOper", "", "", "0X8009926", "0X8009926", 0, 0, "", "", "", onh.a(paramView), false);
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
          nol.a(null, "", "0X8009925", "0X8009925", 0, 0, "", "", "", "", false);
          return;
          rvx.a(getActivity(), null, "https://viola.qq.com/js/myFamily.js?_rij_violaUrl=1&v_tid=6&v_bundleName=myFamily&hideNav=1&statusColor=1&v_nav_immer=1&v_bid=3740", null);
          return;
          rvx.a(getActivity(), null, "https://viola.qq.com/js/notes-center.js?_rij_violaUrl=1&v_nav_immer=1&v_tid=15&v_bid=3811&v_bundleName=notes-center&hideNav=1&statusBarStyle=1", null);
          nol.a(null, "", "0X800A607", "0X800A607", 0, 0, "", "", "", "", false);
          return;
          try
          {
            paramView = (ntz)this.jdField_a_of_type_ComTencentImageURLImageView.getTag();
            if (paramView != null)
            {
              onh.a(getActivity(), paramView);
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
      this.jdField_f_of_type_Boolean = bhvy.y(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_Boolean = getActivity().getIntent().getBooleanExtra("is_from_bb_circle", false);
    osj.a().a(this.jdField_a_of_type_Osm);
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
    osj.a().b(this.jdField_a_of_type_Osm);
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
    osg.a().e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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