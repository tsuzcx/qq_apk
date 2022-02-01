package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableList.OnListChangedCallback;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.FollowingSearchResultModel;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.search.HybridSearchFragment.OnSearchResultClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySelectMemberFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, ObservableList.OnListChangedCallback<ObservableArrayList<ResultRecord>>, HybridSearchFragment.OnSearchResultClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoySelectMemberFragment.4(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ObservableArrayList<ResultRecord> a;
  private FollowingListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment;
  private FriendListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment;
  protected SelectMemberLimit a;
  private SelectedMemberListViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectedMemberListViewAdapter;
  private HybridSearchFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public ReadInJoySelectMemberFragment()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = new ObservableArrayList();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit = new SelectMemberLimit();
  }
  
  private static List<String> a(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramObservableArrayList = paramObservableArrayList.iterator();
    while (paramObservableArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramObservableArrayList.next()).a());
    }
    return localArrayList;
  }
  
  private void a()
  {
    ReadInJoyLogicEngine.a().p();
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mContentView.findViewById(2131367438) != null)
    {
      if (paramBundle != null) {
        return;
      }
      g();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment = new FriendListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment = new FollowingListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit);
      getChildFragmentManager().beginTransaction().add(2131367438, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).commit();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    j();
  }
  
  private void f()
  {
    h();
    d();
  }
  
  private void g()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a(((Bundle)localObject).getInt("opentype", 0));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b(((Bundle)localObject).getInt("maxSelect", 10));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.c(((Bundle)localObject).getInt("maxCount", 30));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b(((Bundle)localObject).getString("rowkey", ""));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a(((Bundle)localObject).getString("callback", ""));
      if (((Bundle)localObject).containsKey("filterUins"))
      {
        localObject = ((Bundle)localObject).getString("filterUins", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a(Arrays.asList(((String)localObject).split(",")));
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment = HybridSearchFragment.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.a(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131377574);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131377629));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new ReadInJoySelectMemberFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ReadInJoySelectMemberFragment.2(this));
  }
  
  private void i()
  {
    TextView localTextView = (TextView)getRightTextView();
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size();
    int i;
    if (j > 4)
    {
      i = 1;
      if (j <= 0) {
        break label152;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setRightViewTextDisable(1);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() != 1) {
        break label124;
      }
      localTextView.setText(MessageFormat.format(getString(2131718363), new Object[] { Integer.valueOf(j) }));
    }
    for (;;)
    {
      if (i == 0) {
        break label196;
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = AIOUtils.a(200.0F, getResources());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPosition(j - 1);
      return;
      i = 0;
      break;
      label124:
      localTextView.setText(MessageFormat.format(getString(2131718998), new Object[] { Integer.valueOf(j) }));
    }
    label152:
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == 1) {
      localTextView.setText(2131718360);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      break;
      localTextView.setText(2131718997);
    }
    label196:
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = -2;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
  }
  
  private void j()
  {
    Resources localResources = getResources();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == 1)
    {
      setTitle(localResources.getString(2131718358));
      setRightButton(2131718360, this);
    }
    for (;;)
    {
      setRightViewTextDisable(0);
      return;
      setTitle(localResources.getString(2131718985));
      setRightButton(2131718997, this);
    }
  }
  
  private void k()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    ResultRecord localResultRecord = ResultRecord.a(paramISearchResultModel.b(), paramISearchResultModel.a().toString());
    if ((paramISearchResultModel instanceof FollowingSearchResultModel)) {
      localResultRecord.a(2);
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.contains(localResultRecord))
      {
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() != 1) || (TextUtils.isEmpty(paramISearchResultModel.b())) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == null)) {
          break label194;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b()) {
          break;
        }
        paramISearchResultModel = getActivity().getResources().getString(2131718365, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.c()) });
        QQToast.a(getActivity(), paramISearchResultModel, 0).a();
      }
      return;
      localResultRecord.a(1);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a().contains(paramISearchResultModel.b()))
    {
      QQToast.a(getActivity(), getActivity().getResources().getString(2131718359), 0).a();
      return;
    }
    label194:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.add(localResultRecord);
    k();
  }
  
  protected void b()
  {
    c();
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    if (paramObservableArrayList.size() > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b())
    {
      String str = String.format(getString(2131694698), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.b()) });
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == 1) {
        str = getString(2131718365, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.c()) });
      }
      paramObservableArrayList.subList(paramInt1, paramInt1 + paramInt2).clear();
      QQToast.a(getActivity(), str, 0).a();
      return;
    }
    i();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList.size() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_set", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
      getActivity().setResult(-1, localIntent);
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    i();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.mContentView.findViewById(2131377752));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectedMemberListViewAdapter = new SelectedMemberListViewAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectedMemberListViewAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new ReadInJoySelectMemberFragment.3(this));
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mContentView == null)
    {
      QLog.e("IphoneTitleBarFragment", 1, "mContentView == null");
      return;
    }
    f();
    a(paramBundle);
    a();
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public void e()
  {
    if ((getActivity() != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {}
    try
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getActivity().getSystemService("input_method");
      if (localInputMethodManager.isActive())
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
        this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131560384;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.overridePendingTransition(2130771999, 2130771992);
  }
  
  public boolean onBackEvent()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0)
    {
      e();
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      return true;
    }
    c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b();
      continue;
      e();
      getChildFragmentManager().beginTransaction().setCustomAnimations(2130772056, 2130772057, 2130772050, 2130772051).hide(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFriendListFragment).add(2131367438, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberFollowingListFragment).addToBackStack(FollowingListFragment.class.getName()).commit();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130771992, 2130771980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ReadInJoySelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */