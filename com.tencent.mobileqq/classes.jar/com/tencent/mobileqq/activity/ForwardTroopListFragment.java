package com.tencent.mobileqq.activity;

import aeox;
import aepa;
import aepb;
import aepc;
import aepd;
import aepe;
import aepf;
import aepg;
import aeph;
import aepi;
import aepj;
import aepk;
import aepl;
import afmf;
import agej;
import amef;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import antg;
import anua;
import anzj;
import aoof;
import auxr;
import auxu;
import avad;
import bcie;
import bhlq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ForwardTroopListFragment
  extends PublicBaseFragment
{
  public aeox a;
  private aepa jdField_a_of_type_Aepa = new aepf(this);
  protected aepj a;
  protected aepk a;
  protected aepl a;
  private afmf jdField_a_of_type_Afmf = new aepg(this);
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private antg jdField_a_of_type_Antg = new aepe(this);
  protected anua a;
  private aoof jdField_a_of_type_Aoof;
  private auxu jdField_a_of_type_Auxu;
  private bcie jdField_a_of_type_Bcie = new aeph(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  protected SwipPinnedHeaderExpandableListView a;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ForwardTroopListFragment()
  {
    this.jdField_a_of_type_Anua = new aepd(this);
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private void a(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).a;
    if (a(paramView.jdField_a_of_type_JavaLangString, paramView.a())) {
      a(paramView.jdField_a_of_type_JavaLangString, paramView.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_Aeox.notifyDataSetChanged();
      return;
      a(paramView);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = a(paramString, paramInt);
    this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    h();
    paramString = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramString, true);
  }
  
  private void a(List<ResultRecord> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((ResultRecord)paramList.next());
      }
    }
  }
  
  private boolean a(ResultRecord paramResultRecord)
  {
    if (paramResultRecord == null) {
      return false;
    }
    String str = a(paramResultRecord.jdField_a_of_type_JavaLangString, paramResultRecord.a());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      k();
      return false;
    }
    paramResultRecord = ResultRecord.a(paramResultRecord);
    paramResultRecord.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_JavaUtilMap.put(str, paramResultRecord);
    h();
    paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, true);
    return true;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.jdField_a_of_type_JavaUtilMap.containsKey(a(paramString, paramInt));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370063));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, agej.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376581));
    i();
    d();
  }
  
  private void c()
  {
    a(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369073));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369044));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369042));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369088));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369042).setVisibility(8);
    this.c.setVisibility(0);
    this.c.setText("");
    this.d.setText(anzj.a(2131703743));
    this.b.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.height = agej.a(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = agej.a(75.0F, getResources());
    }
    localLayoutParams.rightMargin = agej.a(10.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(agej.a(7.0F, getResources()), 0, agej.a(7.0F, getResources()), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845216);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    h();
    this.c.setOnClickListener(new aepb(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aepc(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(agej.a(260.0F, getResources()));
    if (AppSetting.c)
    {
      this.d.setContentDescription(this.d.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.c.setContentDescription(anzj.a(2131703746));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_Aeox != null) {
        this.jdField_a_of_type_Aeox.b();
      }
      this.jdField_a_of_type_Aeox = new aeox(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_Aepa);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Aeox);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_Aeox);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aepj == null) {
      this.jdField_a_of_type_Aepj = new aepj(this);
    }
    if (this.jdField_a_of_type_Aepl == null) {
      this.jdField_a_of_type_Aepl = new aepl(this);
    }
    if (this.jdField_a_of_type_Aepk == null) {
      this.jdField_a_of_type_Aepk = new aepk(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aepj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aepl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aepk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Antg);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aepj);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aepl);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aepk);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anua);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Antg);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131703749));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(855836698);
    }
    for (;;)
    {
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "rightBtn width: " + this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(anzj.a(2131703739), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166997));
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377298));
    this.jdField_a_of_type_Aoof = new aoof(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Aoof, this.jdField_a_of_type_Afmf);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getActivity().getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = bhlq.a(getActivity(), getActivity().getResources().getString(2131698108), 0, 2131694181, null, new aepi(this));
    }
    if (!getActivity().isFinishing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "forward2MultiTargets map is empty !");
      }
      return;
    }
    if (this.jdField_a_of_type_Auxu == null) {
      this.jdField_a_of_type_Auxu = avad.a(getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new amef());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_Auxu.a(auxr.a.intValue(), localBundle);
    this.jdField_a_of_type_Auxu.f();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aeox != null) {
      this.jdField_a_of_type_Aeox.notifyDataSetChanged();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771979, 2130771978);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() != 8)
    {
      j();
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a()) {
      j();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559180, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b();
    c();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_Aeox != null) {
      this.jdField_a_of_type_Aeox.b();
    }
    this.jdField_a_of_type_Aoof.d();
    g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Auxu != null) {
      this.jdField_a_of_type_Auxu.y();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    g();
  }
  
  public void onResume()
  {
    super.onResume();
    f();
    if (this.jdField_a_of_type_Aeox == null) {
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new ForwardTroopListFragment.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */