package com.tencent.biz.pubaccount.readinjoy.viola.view;

import ahip;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import qoi;
import sad;
import sae;

public abstract class ViolaLazyFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = 0;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new sad(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private SystemBarCompact jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  private String jdField_a_of_type_JavaLangString = "status_bar_color_style";
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  
  private void a(NavBarCommon paramNavBarCommon)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramNavBarCommon.findViewById(2131368429));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramNavBarCommon.findViewById(2131378015));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramNavBarCommon.findViewById(2131368742));
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramNavBarCommon.findViewById(2131368472));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramNavBarCommon.findViewById(2131368457));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramNavBarCommon.findViewById(2131368441));
  }
  
  public abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public ViewGroup a()
  {
    return this.jdField_b_of_type_AndroidViewViewGroup;
  }
  
  public Boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setAlpha(paramFloat);
  }
  
  public void a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((a() == null) || (a().getParent() == null)) {
      this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558877, paramViewGroup, false));
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377452));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
      }
      paramViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, (ViewGroup)this.jdField_a_of_type_AndroidViewView, false);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(3, 2131375329);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramViewGroup, localLayoutParams);
      this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
      return;
    }
    catch (Exception paramViewGroup)
    {
      QLog.e("ViolaLazyFragment", 1, paramViewGroup.getMessage());
    }
  }
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(Bundle paramBundle, ViewGroup paramViewGroup);
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangBoolean = paramBoolean;
  }
  
  public void a(Boolean paramBoolean, boolean paramBoolean1)
  {
    FragmentActivity localFragmentActivity;
    if ((paramBoolean1) && (paramBoolean != this.jdField_a_of_type_JavaLangBoolean))
    {
      localFragmentActivity = getActivity();
      if (paramBoolean.booleanValue()) {
        break label37;
      }
    }
    label37:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ahip.a(localFragmentActivity, paramBoolean1);
      this.jdField_a_of_type_JavaLangBoolean = paramBoolean;
      return;
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(paramCharSequence);
  }
  
  public void a(String paramString)
  {
    a(paramString, false);
  }
  
  public void a(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if (paramOnClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (("status_bar_color_style".equals(this.jdField_a_of_type_JavaLangString)) || (paramBoolean)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public ViewGroup b()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void b(ViewGroup paramViewGroup)
  {
    if ((getUserVisibleHint()) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_c_of_type_Boolean = true;
      c(paramViewGroup);
      return;
    }
    j();
  }
  
  public void b(String paramString)
  {
    if ((!this.jdField_b_of_type_Boolean) && (ImmersiveUtils.isSupporImmersive() == 1) && (!"status_bar_color_style".equals(paramString)) && ((getActivity() instanceof BaseActivity)) && (getActivity().mSystemBarComp != null))
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = getActivity().mSystemBarComp;
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarColor(Color.parseColor(paramString));
    }
  }
  
  public void b(String paramString, View.OnClickListener paramOnClickListener)
  {
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_d_of_type_AndroidWidgetTextView.setEnabled(true);
    if (paramOnClickListener != null) {
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public abstract void c();
  
  protected void c(ViewGroup paramViewGroup)
  {
    a(a(), paramViewGroup);
    d();
    a(getArguments(), this.jdField_b_of_type_AndroidViewViewGroup);
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setVisibility(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBackgroundColor(Color.parseColor(paramString));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBackgroundColor(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBackgroundColor(-1);
  }
  
  public void d()
  {
    if (getActivity() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375329));
    a(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon);
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  protected void e() {}
  
  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  protected void f() {}
  
  public void f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_d_of_type_AndroidWidgetTextView.getVisibility() != 0) && (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidWidgetTextView.getText()))) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(paramString));
    }
  }
  
  protected void g() {}
  
  public void g(String paramString)
  {
    if (getActivity() != null)
    {
      if (!"drawable_black".equals(paramString)) {
        break label46;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(getActivity().getResources().getDrawable(2130848498));
    }
    label46:
    while (!"drawable_white".equals(paramString)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(getActivity().getResources().getDrawable(2130849547));
  }
  
  protected void h() {}
  
  public void h(String paramString)
  {
    this.jdField_b_of_type_AndroidViewViewGroup.setBackgroundColor(Color.parseColor(paramString));
  }
  
  protected void i() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (Build.VERSION.SDK_INT >= 11) {
      paramActivity.getWindow().setFlags(16777216, 16777216);
    }
  }
  
  protected void j()
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558877, this.jdField_a_of_type_AndroidViewViewGroup, false));
    a(getArguments());
  }
  
  public void k()
  {
    if ((!this.jdField_c_of_type_Boolean) && (a() != null))
    {
      this.jdField_c_of_type_Boolean = true;
      c(this.jdField_a_of_type_AndroidViewViewGroup);
    }
  }
  
  public void l()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      if (getActivity().mSystemBarComp != null) {
        break label135;
      }
      getActivity().setImmersiveStatus(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon) != -1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getLayoutParams();
        localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon);
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      return;
      label135:
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(2, 0);
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarVisible(0, 0);
    }
  }
  
  public void o()
  {
    try
    {
      if (a() != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)a().findViewById(2131375329));
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getVisibility();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setVisibility(8);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onAttach:" + System.currentTimeMillis());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreate:" + System.currentTimeMillis());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onCreateView:" + System.currentTimeMillis());
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    if (Build.VERSION.SDK_INT >= 11) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    b(paramViewGroup);
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewLayoutInflater = null;
    if (this.jdField_c_of_type_Boolean) {
      i();
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_c_of_type_Boolean) {
      g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    b(this.jdField_a_of_type_JavaLangString);
    FragmentActivity localFragmentActivity = getActivity();
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      ahip.a(localFragmentActivity, bool);
      if (this.jdField_c_of_type_Boolean) {
        f();
      }
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    QLog.d("ViolaLazyFragment", 2, "debugForTimeCost onStart:" + System.currentTimeMillis());
    if ((this.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_Boolean) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_Boolean = true;
      e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (getUserVisibleHint()))
    {
      this.jdField_a_of_type_Boolean = false;
      h();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_d_of_type_Boolean) {
      r();
    }
  }
  
  public void p()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131375329));
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getVisibility() != 0) && (this.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setVisibility(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ViolaLazyFragment", 2, localThrowable, new Object[0]);
    }
  }
  
  public void q()
  {
    if (!this.jdField_b_of_type_Boolean) {
      a("#ffffff");
    }
    c("#ffffff");
    e("#000000");
    d("#000000");
    g("drawable_black");
    f("#000000");
  }
  
  public void r()
  {
    if (this.jdField_b_of_type_Int < 0) {
      this.jdField_b_of_type_Int = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    }
    qoi.a(getActivity());
  }
  
  public void s()
  {
    getActivity().getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new sae(this));
    int i = getActivity().getWindow().getDecorView().getSystemUiVisibility();
    getActivity().getWindow().getDecorView().setSystemUiVisibility(i | 0x2 | 0x400);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((paramBoolean) && (!this.jdField_c_of_type_Boolean)) {
      k();
    }
    if ((this.jdField_c_of_type_Boolean) && (a() != null))
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_Boolean = true;
        e();
        f();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    g();
    h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment
 * JD-Core Version:    0.7.0.1
 */