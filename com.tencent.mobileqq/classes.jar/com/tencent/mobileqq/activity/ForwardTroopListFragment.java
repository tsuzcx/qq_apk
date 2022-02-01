package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardOptionBuilder;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.business.contact.presenter.ContactSearchResultPresenter.OnActionListener;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.ResultRecord.DefaultComparator;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar;
import com.tencent.mobileqq.selectmember.SelectedAndSearchBar.ISelectedAndSearchBarCallback;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
  protected ForwardTroopListFragment.MyMessageObserver a;
  protected ForwardTroopListFragment.MyRoamSettingObserver a;
  protected ForwardTroopListFragment.MyTroopMngObserver a;
  protected ForwardTroopListFragment.MyTroopModifyObserver a;
  protected ForwardTroopListFragment.MyTroopObserver a;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new ForwardTroopListFragment.5(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private ForwardBaseOption jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
  private ContactSearchFragment jdField_a_of_type_ComTencentMobileqqSearchBusinessContactFragmentContactSearchFragment;
  private ContactSearchResultPresenter.OnActionListener jdField_a_of_type_ComTencentMobileqqSearchBusinessContactPresenterContactSearchResultPresenter$OnActionListener = new ForwardTroopListFragment.8(this);
  private SelectedAndSearchBar.ISelectedAndSearchBarCallback jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback = new ForwardTroopListFragment.7(this);
  private SelectedAndSearchBar jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar;
  protected TroopCommonlyUsedObserver a;
  protected SwipPinnedHeaderExpandableListView a;
  private Map<String, ResultRecord> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private TextView b;
  private TextView c;
  private TextView d;
  
  public ForwardTroopListFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new ForwardTroopListFragment.4(this);
  }
  
  private String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(View paramView)
  {
    paramView = ((ForwardRecentItemView)paramView).a;
    if (a(paramView.uin, paramView.getUinType())) {
      a(paramView.uin, paramView.getUinType());
    } else {
      a(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter.notifyDataSetChanged();
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
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramString, true);
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
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramResultRecord, false);
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
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(paramResultRecord, true);
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
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370164));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, AIOUtils.b(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131376483));
    i();
    d();
  }
  
  private void c()
  {
    a(getArguments().getParcelableArrayList("selected_target_list"));
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369233));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369204));
    this.c = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369202));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369249));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131369202).setVisibility(8);
    this.c.setVisibility(0);
    this.c.setText("");
    this.d.setText(HardCodeUtil.a(2131704948));
    this.b.setVisibility(8);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.b(29.0F, getResources());
    if (Build.VERSION.SDK_INT <= 18) {
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.b(75.0F, getResources());
    }
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.b(10.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(AIOUtils.b(7.0F, getResources()), 0, AIOUtils.b(7.0F, getResources()), 0);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130845212);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    h();
    this.c.setOnClickListener(new ForwardTroopListFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ForwardTroopListFragment.2(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AIOUtils.b(260.0F, getResources()));
    if (AppSetting.d)
    {
      localObject = this.d;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
      this.c.setContentDescription(HardCodeUtil.a(2131704951));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView != null)
    {
      ForwardTroopListAdapter localForwardTroopListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter;
      if (localForwardTroopListAdapter != null) {
        localForwardTroopListAdapter.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter = new ForwardTroopListAdapter(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter$IForwardTroopListAdapterCallback);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter);
      this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setOnGroupClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver = new ForwardTroopListFragment.MyAvatarObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyRoamSettingObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyRoamSettingObserver = new ForwardTroopListFragment.MyRoamSettingObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopModifyObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopModifyObserver = new ForwardTroopListFragment.MyTroopModifyObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopMngObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopMngObserver = new ForwardTroopListFragment.MyTroopMngObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver = new ForwardTroopListFragment.MyTroopObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver = new ForwardTroopListFragment.MyMessageObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyRoamSettingObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopMngObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyTroopModifyObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListFragment$MyMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilMap.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131704954));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(855836698);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(HardCodeUtil.a(2131704944), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilMap.size()) }));
      this.jdField_a_of_type_AndroidWidgetTextView.setClickable(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167063));
    }
    Object localObject;
    if (AppSetting.d)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject).setContentDescription(((TextView)localObject).getText());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rightBtn width: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetTextView.getMeasuredWidth());
      QLog.i("contacts.fragment.TroopFragment", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method"));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar = ((SelectedAndSearchBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131377172));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a(null, this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar$ISelectedAndSearchBarCallback);
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(getBaseActivity().getWindow().peekDecorView().getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.b();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getBaseActivity(), getBaseActivity().getResources().getString(2131698940), 0, 2131694674, null, new ForwardTroopListFragment.9(this));
    }
    if (!getBaseActivity().isFinishing()) {
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
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption = ForwardOptionBuilder.a(getBaseActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity());
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilMap.values());
    Collections.sort(localArrayList, new ResultRecord.DefaultComparator());
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("forward_multi_target", localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.a(ForwardAbility.ForwardAbilityType.a.intValue(), localBundle);
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption.g();
  }
  
  void a()
  {
    ForwardTroopListAdapter localForwardTroopListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter;
    if (localForwardTroopListAdapter != null) {
      localForwardTroopListAdapter.notifyDataSetChanged();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.overridePendingTransition(2130771993, 2130771992);
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
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectedAndSearchBar.a()) {
      j();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getBaseActivity().app;
    this.jdField_a_of_type_AndroidContentContext = getBaseActivity();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559127, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_a_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_a_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(paramLayoutInflater.getContext()), 0, 0);
    }
    b();
    c();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.TroopFragment", 2, "doOnDestroy");
    }
    ForwardTroopListAdapter localForwardTroopListAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityForwardTroopListAdapter;
    if (localForwardTroopListAdapter != null) {
      localForwardTroopListAdapter.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    g();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ForwardBaseOption localForwardBaseOption = this.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
    if (localForwardBaseOption != null) {
      localForwardBaseOption.z();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardTroopListFragment
 * JD-Core Version:    0.7.0.1
 */