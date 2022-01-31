package com.tencent.mobileqq.apollo.view;

import aepi;
import allf;
import allg;
import alud;
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
import bdbb;
import bdbc;
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
  implements bdbc
{
  public int a;
  private allg jdField_a_of_type_Allg;
  public RelativeLayout a;
  private bdbb jdField_a_of_type_Bdbb;
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
    paramView = (RelativeLayout)paramView.findViewById(2131378043);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramView.setFitsSystemWindows(true);
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (NavBarCommon)paramView.findViewById(2131375863);
    ((TextView)paramLayoutInflater.findViewById(2131368624)).setText(alud.a(2131700730));
    paramLayoutInflater.setOnItemSelectListener(new allf(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater.setBackgroundColor(-7829368);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131375863);
    paramLayoutInflater.setId(this.b);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    paramLayoutInflater = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject1 = new RelativeLayout.LayoutParams(aepi.a(90.0F, getResources()), aepi.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = aepi.a(45.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.b);
    paramLayoutInflater.setBackgroundResource(2130839180);
    paramLayoutInflater.setId(this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject1).setImageResource(2130838397);
    Object localObject2 = new RelativeLayout.LayoutParams(aepi.a(90.0F, getResources()), aepi.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, this.c);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText(alud.a(2131700747));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = aepi.a(20.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.c);
    ((TextView)localObject1).setId(this.d);
    ((TextView)localObject1).setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new allg(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alud.a(2131700771));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.d);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = aepi.a(40.0F, getResources());
    ((allg)localObject2).setId(this.e);
    ((allg)localObject2).b(alud.a(2131700739));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_Allg = new allg(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alud.a(2131700770));
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.e);
    this.jdField_a_of_type_Allg.setId(this.f);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Allg, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new allg(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, alud.a(2131700746));
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, this.f);
    ((allg)localObject3).setId(this.g);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    localObject4 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131375863);
    paramView.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject4);
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData != null) {
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = getResources();
        paramView.mLoadingDrawable = ((Resources)localObject4).getDrawable(2130838400);
        paramView.mFailedDrawable = ((Resources)localObject4).getDrawable(2130838400);
        paramView.mRequestWidth = aepi.a(90.0F, getResources());
        paramView.mRequestHeight = paramView.mRequestWidth;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.logoUrl, paramView));
        ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.name);
        ((allg)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.developerName);
        ((allg)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId);
        paramView = this.jdField_a_of_type_Bdbb.a(1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin), 0, (byte)2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "logoUrl is null:" + this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
          }
          this.jdField_a_of_type_Bdbb.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin, 200, false, 1, true, (byte)0, 2);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)))
        {
          this.jdField_a_of_type_Allg.setVisibility(8);
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramLayoutInflater.setImageResource(2130838400);
          QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, paramView, new Object[0]);
        }
        this.jdField_a_of_type_Allg.a(paramView, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
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
    paramViewGroup = paramLayoutInflater.inflate(2131558913, paramViewGroup, false);
    this.jdField_a_of_type_Bdbb = new bdbb(getActivity().app);
    this.jdField_a_of_type_Bdbb.a(this);
    a(paramViewGroup, paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) && (paramBitmap != null) && (this.jdField_a_of_type_Allg != null)) {
      this.jdField_a_of_type_Allg.a(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "[onDestory] destory");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.d();
      this.jdField_a_of_type_Bdbb = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment
 * JD-Core Version:    0.7.0.1
 */