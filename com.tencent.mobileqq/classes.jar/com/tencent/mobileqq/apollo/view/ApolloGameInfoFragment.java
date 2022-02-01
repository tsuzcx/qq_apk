package com.tencent.mobileqq.apollo.view;

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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.api.model.ApolloGameData;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ApolloGameInfoFragment
  extends PublicBaseFragment
  implements DecodeTaskCompletionListener
{
  public int a;
  public RelativeLayout a;
  public ApolloGameData a;
  public CmGameStartChecker.StartCheckParam a;
  private ApolloGameInfoFragment.ItemView jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView;
  public BaseActivity a;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = 5;
  private int g = 6;
  
  public void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131379546);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramView.setFitsSystemWindows(true);
      paramView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (NavBarCommon)paramView.findViewById(2131377159);
    ((TextView)paramLayoutInflater.findViewById(2131369487)).setText(HardCodeUtil.a(2131700426));
    paramLayoutInflater.setOnItemSelectListener(new ApolloGameInfoFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater.setBackgroundColor(-7829368);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131377159);
    paramLayoutInflater.setId(this.b);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    paramLayoutInflater = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(90.0F, getResources()), AIOUtils.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(45.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.b);
    paramLayoutInflater.setBackgroundResource(2130839496);
    paramLayoutInflater.setId(this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject1).setImageResource(2130838625);
    Object localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(90.0F, getResources()), AIOUtils.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, this.c);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText(HardCodeUtil.a(2131700443));
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(20.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.c);
    ((TextView)localObject1).setId(this.d);
    ((TextView)localObject1).setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ApolloGameInfoFragment.ItemView(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131700467));
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.d);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(40.0F, getResources());
    ((ApolloGameInfoFragment.ItemView)localObject2).setId(this.e);
    ((ApolloGameInfoFragment.ItemView)localObject2).b(HardCodeUtil.a(2131700435));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView = new ApolloGameInfoFragment.ItemView(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131700466));
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.e);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.setId(this.f);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new ApolloGameInfoFragment.ItemView(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131700442));
    Object localObject4 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, this.f);
    ((ApolloGameInfoFragment.ItemView)localObject3).setId(this.g);
    ((RelativeLayout.LayoutParams)localObject4).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    localObject4 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131377159);
    paramView.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject4);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData != null) {
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        localObject4 = getResources();
        paramView.mLoadingDrawable = ((Resources)localObject4).getDrawable(2130838628);
        paramView.mFailedDrawable = ((Resources)localObject4).getDrawable(2130838628);
        paramView.mRequestWidth = AIOUtils.a(90.0F, getResources());
        paramView.mRequestHeight = paramView.mRequestWidth;
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.logoUrl, paramView));
        ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.name);
        ((ApolloGameInfoFragment.ItemView)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.developerName);
        ((ApolloGameInfoFragment.ItemView)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.openId);
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin), 0, (byte)2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "logoUrl is null:" + this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin, 200, false, 1, true, (byte)0, 2);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin)))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.setVisibility(8);
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramLayoutInflater.setImageResource(2130838628);
          QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, paramView, new Object[0]);
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.a(paramView, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin);
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
      this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
      return;
    }
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData = null;
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[onCreate] startCheckParam is null");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559054, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)getActivity().app.getRuntimeService(IQQAvatarService.class, "")).getInstance(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    a(paramViewGroup, paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin)) && (paramBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloGameInfoFragment$ItemView.a(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloGameData.officialAccountUin);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "[onDestory] destory");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
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