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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import yxm;
import yxn;

public class ApolloGameInfoFragment
  extends PublicBaseFragment
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public RelativeLayout a;
  public BaseActivity a;
  public ApolloGameData a;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  private yxn jdField_a_of_type_Yxn;
  private int b = 1;
  private int c = 2;
  private int d = 3;
  private int e = 4;
  private int f = 5;
  
  public void a(View paramView, LayoutInflater paramLayoutInflater)
  {
    paramView = (RelativeLayout)paramView.findViewById(2131364019);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramView.setFitsSystemWindows(true);
      paramView.setPadding(0, ImmersiveUtils.a(paramLayoutInflater.getContext()), 0, 0);
    }
    paramLayoutInflater = (NavBarCommon)paramView.findViewById(2131363244);
    ((TextView)paramLayoutInflater.findViewById(2131363245)).setText("返回");
    paramLayoutInflater.setOnItemSelectListener(new yxm(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    paramLayoutInflater.setBackgroundColor(-7829368);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131363244);
    paramLayoutInflater.setId(this.b);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    paramLayoutInflater = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(90.0F, getResources()), AIOUtils.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(45.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.b);
    paramLayoutInflater.setBackgroundResource(2130838559);
    paramLayoutInflater.setId(this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramLayoutInflater, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    ((ImageView)localObject1).setImageResource(2130838065);
    Object localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(90.0F, getResources()), AIOUtils.a(90.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, this.c);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, this.c);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((TextView)localObject1).setTextSize(18.0F);
    ((TextView)localObject1).setText("厘米游戏");
    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(20.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, this.c);
    ((TextView)localObject1).setId(this.d);
    ((TextView)localObject1).setTextColor(-16777216);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new yxn(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "游戏开发者");
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.d);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(40.0F, getResources());
    ((yxn)localObject2).setId(this.e);
    ((yxn)localObject2).b("玩一玩");
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_Yxn = new yxn(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "相关公众号");
    localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, this.e);
    this.jdField_a_of_type_Yxn.setId(this.f);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = -1;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Yxn, (ViewGroup.LayoutParams)localObject3);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(-1);
    localObject3 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(3, 2131363244);
    paramView.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject3);
    if (this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData != null) {
      try
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        localObject3 = getResources();
        paramView.mLoadingDrawable = ((Resources)localObject3).getDrawable(2130838068);
        paramView.mFailedDrawable = ((Resources)localObject3).getDrawable(2130838068);
        paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.logoUrl, paramView));
        ((TextView)localObject1).setText(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.name);
        ((yxn)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.developerName);
        paramView = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin), 0, (byte)2);
        if (paramView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "logoUrl is null:" + this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin, 200, false, 1, true, (byte)0, 2);
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) || ("0".equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)))
        {
          this.jdField_a_of_type_Yxn.setVisibility(8);
          return;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramLayoutInflater.setImageResource(2130838068);
          QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, paramView, new Object[0]);
        }
        this.jdField_a_of_type_Yxn.a(paramView, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
        return;
      }
    }
    QLog.e("apollo_cmGame_ApolloGameInfoFragment", 1, "[initView] gameData is null");
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData = ((ApolloGameData)getActivity().getIntent().getSerializableExtra("extra_key_gameData"));
    this.jdField_a_of_type_Int = getActivity().getIntent().getIntExtra("extra_key_game_enter", -1);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2130968837, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(getActivity().app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    a(paramViewGroup, paramLayoutInflater);
    return paramViewGroup;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin)) && (paramBitmap != null) && (this.jdField_a_of_type_Yxn != null)) {
      this.jdField_a_of_type_Yxn.a(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqDataApolloGameData.officialAccountUin);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_cmGame_ApolloGameInfoFragment", 2, "[onDestory] destory");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameInfoFragment
 * JD-Core Version:    0.7.0.1
 */