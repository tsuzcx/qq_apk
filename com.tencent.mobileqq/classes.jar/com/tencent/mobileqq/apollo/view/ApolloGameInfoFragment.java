package com.tencent.mobileqq.apollo.view;

import aciy;
import ajbd;
import ajbe;
import ajjy;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import azwg;
import azwh;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ApolloGameInfoFragment
  extends PublicBaseFragment
  implements azwh
{
  public int a;
  private ajbe jdField_a_of_type_Ajbe;
  public RelativeLayout a;
  private azwg jdField_a_of_type_Azwg;
  public CmGameStartChecker.StartCheckParam a;
  public BaseActivity a;
  public ApolloGameData a;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = 5;
  private int g = 6;
  
  public void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131311638);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramView.setFitsSystemWindows(true);
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (NavBarCommon)paramView.findViewById(2131309578);
    ((TextView)paramLayoutInflater.findViewById(2131302804)).setText(ajjy.a(2131634550));
    paramLayoutInflater.setOnItemSelectListener(new ajbd(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater.setBackgroundColor(-7829368);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131309578);
    paramLayoutInflater.setId(this.b);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    paramLayoutInflater = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject1 = new RelativeLayout.LayoutParams(aciy.a(90.0F, getResources()), aciy.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = aciy.a(45.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.b);
    paramLayoutInflater.setBackgroundResource(2130839070);
    paramLayoutInflater.setId(this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject1).setImageResource(2130838328);
    Object localObject2 = new RelativeLayout.LayoutParams(aciy.a(90.0F, getResources()), aciy.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, this.c);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText(ajjy.a(2131634567));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = aciy.a(20.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.c);
    ((TextView)localObject1).setId(this.d);
    ((TextView)localObject1).setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ajbe(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131634591));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.d);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = aciy.a(40.0F, getResources());
    ((ajbe)localObject2).setId(this.e);
    ((ajbe)localObject2).b(ajjy.a(2131634559));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_Ajbe = new ajbe(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131634590));
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.e);
    this.jdField_a_of_type_Ajbe.setId(this.f);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Ajbe, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ajbe(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131634566));
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, this.f);
    ((ajbe)localObject3).setId(this.g);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    localObject4 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131309578);
    paramView.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject4);
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData != null) {
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = getResources();
        paramView.mLoadingDrawable = ((Resources)localObject4).getDrawable(2130838331);
        paramView.mFailedDrawable = ((Resources)localObject4).getDrawable(2130838331);
        paramView.mRequestWidth = aciy.a(90.0F, getResources());
        paramView.mRequestHeight = paramView.mRequestWidth;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.logoUrl, paramView));
        ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.name);
        ((ajbe)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.developerName);
        ((ajbe)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId);
        paramView = this.jdField_a_of_type_Azwg.a(1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin), 0, (byte)2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "logoUrl is null:" + this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
          }
          this.jdField_a_of_type_Azwg.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin, 200, false, 1, true, (byte)0, 2);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)))
        {
          this.jdField_a_of_type_Ajbe.setVisibility(8);
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramLayoutInflater.setImageResource(2130838331);
          QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, paramView, new Object[0]);
        }
        this.jdField_a_of_type_Ajbe.a(paramView, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
        return;
      }
    }
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[initView] gameData is null");
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = ((CmGameStartChecker.StartCheckParam)getActivity().getIntent().getSerializableExtra("extra_startcheckparam"));
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
      return;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData = null;
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[onCreate] startCheckParam is null");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131493317, paramViewGroup, false);
    this.jdField_a_of_type_Azwg = new azwg(getActivity().app);
    this.jdField_a_of_type_Azwg.a(this);
    a(paramViewGroup, paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) && (paramBitmap != null) && (this.jdField_a_of_type_Ajbe != null)) {
      this.jdField_a_of_type_Ajbe.a(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "[onDestory] destory");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment
 * JD-Core Version:    0.7.0.1
 */