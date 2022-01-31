package com.tencent.mobileqq.activity;

import aata;
import aatd;
import aate;
import aatf;
import aatg;
import aath;
import aati;
import aatj;
import aatk;
import aatl;
import aatm;
import aatn;
import aato;
import abqm;
import aciy;
import ahri;
import ajee;
import ajey;
import ajjy;
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
import aphf;
import aphp;
import apjx;
import avrb;
import azwg;
import babr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.qphone.base.util.QLog;
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
  public aata a;
  private aatd jdField_a_of_type_Aatd = new aati(this);
  protected aatm a;
  protected aatn a;
  protected aato a;
  private abqm jdField_a_of_type_Abqm = new aatj(this);
  private ajee jdField_a_of_type_Ajee = new aath(this);
  protected ajey a;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aphp jdField_a_of_type_Aphp;
  private avrb jdField_a_of_type_Avrb = new aatk(this);
  private azwg jdField_a_of_type_Azwg;
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
    this.jdField_a_of_type_Ajey = new aatg(this);
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
      this.jdField_a_of_type_Aata.notifyDataSetChanged();
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
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303648));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131101491);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, aciy.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131309439));
    i();
    d();
  }
  
  private void c()
  {
    a(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302832));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302806));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302804));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302847));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131302804).setVisibility(8);
    this.c.setVisibility(0);
    this.c.setText("");
    this.d.setText(ajjy.a(2131639060));
    this.b.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.height = aciy.a(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = aciy.a(75.0F, getResources());
    }
    localLayoutParams.rightMargin = aciy.a(10.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(aciy.a(7.0F, getResources()), 0, aciy.a(7.0F, getResources()), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130844284);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    h();
    this.c.setOnClickListener(new aate(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aatf(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(aciy.a(260.0F, getResources()));
    if (AppSetting.c)
    {
      this.d.setContentDescription(this.d.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.c.setContentDescription(ajjy.a(2131639063));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_Aata != null) {
        this.jdField_a_of_type_Aata.b();
      }
      this.jdField_a_of_type_Aata = new aata(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_Aatd);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_Aata);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_Aata);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aatm == null) {
      this.jdField_a_of_type_Aatm = new aatm(this);
    }
    if (this.jdField_a_of_type_Aato == null) {
      this.jdField_a_of_type_Aato = new aato(this);
    }
    if (this.jdField_a_of_type_Aatn == null) {
      this.jdField_a_of_type_Aatn = new aatn(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aatm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aato);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aatn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajee);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aatm);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aato);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aatn);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajey);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajee);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131639066));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(ajjy.a(2131639056), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131101267));
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131310050));
    this.jdField_a_of_type_Azwg = new azwg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_Azwg, this.jdField_a_of_type_Abqm);
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
      this.jdField_a_of_type_AndroidAppDialog = babr.a(getActivity(), getActivity().getResources().getString(2131633271), 0, 2131629260, null, new aatl(this));
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
    if (this.jdField_a_of_type_Aphp == null) {
      this.jdField_a_of_type_Aphp = apjx.a(getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ahri());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_Aphp.a(aphf.a.intValue(), localBundle);
    this.jdField_a_of_type_Aphp.f();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aata != null) {
      this.jdField_a_of_type_Aata.notifyDataSetChanged();
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131493503, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b();
    c();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    if (this.jdField_a_of_type_Aata != null) {
      this.jdField_a_of_type_Aata.b();
    }
    this.jdField_a_of_type_Azwg.d();
    g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Aphp != null) {
      this.jdField_a_of_type_Aphp.w();
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
    if (this.jdField_a_of_type_Aata == null) {
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new ForwardTroopListFragment.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */