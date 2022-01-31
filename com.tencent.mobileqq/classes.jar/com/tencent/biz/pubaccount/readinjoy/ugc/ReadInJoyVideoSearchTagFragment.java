package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import lyw;
import lyx;
import lyy;
import lyz;
import lza;
import lzb;

public class ReadInJoyVideoSearchTagFragment
  extends PublicBaseFragment
{
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new lyx(this);
  private ArrayAdapter jdField_a_of_type_AndroidWidgetArrayAdapter;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lyw(this);
  
  private void b()
  {
    getView().setOnClickListener(new lyy(this));
  }
  
  private void c()
  {
    getView().findViewById(2131367356).setOnClickListener(new lyz(this));
  }
  
  private void d()
  {
    ListView localListView = (ListView)getView().findViewById(2131367357);
    View localView = new View(getActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.jdField_a_of_type_AndroidWidgetArrayAdapter = new ArrayAdapter(getActivity(), 2130969661, new ArrayList());
    localListView.setAdapter(this.jdField_a_of_type_AndroidWidgetArrayAdapter);
    localListView.setOnItemClickListener(new lza(this, getActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)getView().findViewById(2131367355));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new lzb(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  private void g()
  {
    PublicFragmentActivity localPublicFragmentActivity;
    SystemBarCompact localSystemBarCompact;
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)))
    {
      localPublicFragmentActivity = (PublicFragmentActivity)getActivity();
      localSystemBarCompact = localPublicFragmentActivity.mSystemBarComp;
      if ((localSystemBarCompact != null) && (b()) && (a()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(localPublicFragmentActivity.getAppRuntime())) {
          break label96;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label84;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label84:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label96:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      localPublicFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2131034165, 0);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969660, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    g();
    e();
    d();
    c();
    b();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void u_()
  {
    getActivity().overridePendingTransition(0, 2131034167);
    super.u_();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */