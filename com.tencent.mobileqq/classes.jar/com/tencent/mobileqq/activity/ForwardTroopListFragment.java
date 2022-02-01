package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.utils.DialogUtil;
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
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ForwardTroopListAdapter.IForwardTroopListAdapterCallback jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback = new ForwardTroopListFragment.6(this);
  protected ForwardTroopListAdapter a;
  protected ForwardTroopListFragment.MyAvatarObserver a;
  protected ForwardTroopListFragment.MyFriendListObserver a;
  protected ForwardTroopListFragment.MyMessageObserver a;
  protected ForwardTroopListFragment.MyTroopBusinessObserver a;
  protected ForwardTroopListFragment.MyTroopObserver a;
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$ISelectedAndSearchBarCallback = new ForwardTroopListFragment.7(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new ForwardTroopListFragment.5(this);
  protected BizTroopObserver a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment;
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchPresenterContactSearchResultPresenter$OnActionListener = new ForwardTroopListFragment.8(this);
  protected SwipPinnedHeaderExpandableListView a;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ForwardTroopListFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ForwardTroopListFragment.4(this);
  }
  
  private String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  private void a(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).a;
    if (a(paramView.uin, paramView.getUinType())) {
      a(paramView.uin, paramView.getUinType());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter.notifyDataSetChanged();
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
    String str = a(paramResultRecord.uin, paramResultRecord.getUinType());
    ResultRecord localResultRecord = (ResultRecord)this.jdField_a_of_type_JavaUtilMap.get(str);
    if (localResultRecord != null)
    {
      localResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
      paramResultRecord = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
      this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(paramResultRecord, false);
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 9)
    {
      k();
      return false;
    }
    paramResultRecord = ResultRecord.copyResultRecord(paramResultRecord);
    paramResultRecord.lastChooseTime = SystemClock.elapsedRealtime();
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
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370504));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376997));
    i();
    d();
  }
  
  private void c()
  {
    a(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369518));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369489));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369487));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369534));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369487).setVisibility(8);
    this.c.setVisibility(0);
    this.c.setText("");
    this.d.setText(HardCodeUtil.a(2131704872));
    this.b.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.height = AIOUtils.a(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      localLayoutParams.width = AIOUtils.a(75.0F, getResources());
    }
    localLayoutParams.rightMargin = AIOUtils.a(10.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.a(7.0F, getResources()), 0, AIOUtils.a(7.0F, getResources()), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845339);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    h();
    this.c.setOnClickListener(new ForwardTroopListFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ForwardTroopListFragment.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.a(260.0F, getResources()));
    if (AppSetting.d)
    {
      this.d.setContentDescription(this.d.getText());
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      this.c.setContentDescription(HardCodeUtil.a(2131704875));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter = new ForwardTroopListAdapter(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver = new ForwardTroopListFragment.MyAvatarObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyFriendListObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyFriendListObserver = new ForwardTroopListFragment.MyFriendListObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopBusinessObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopBusinessObserver = new ForwardTroopListFragment.MyTroopBusinessObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver = new ForwardTroopListFragment.MyTroopObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver = new ForwardTroopListFragment.MyMessageObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704878));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(855836698);
    }
    for (;;)
    {
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_AndroidWidgetTextView.getText());
      }
      if (QLog.isColorLevel()) {
        QLog.i("contacts.fragment.TroopFragment", 2, "rightBtn width: " + this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131704868), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167040));
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar = ((SelectedAndSearchBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377744));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar.a(null, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar$ISelectedAndSearchBarCallback);
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
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getActivity(), getActivity().getResources().getString(2131698861), 0, 2131694699, null, new ForwardTroopListFragment.9(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption == null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity());
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.f();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter.notifyDataSetChanged();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771981, 2130771980);
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
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559251, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption != null) {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.y();
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter == null) {
      e();
    }
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new ForwardTroopListFragment.3(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */