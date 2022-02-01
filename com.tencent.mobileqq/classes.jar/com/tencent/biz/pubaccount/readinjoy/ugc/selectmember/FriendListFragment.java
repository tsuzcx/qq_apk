package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendListFragment
  extends ReportV4Fragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter;
  private SelectMemberLimit jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private View.OnClickListener b;
  
  private SelectMemberBuddyListAdapter a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit.a() == 1)) {
      return new ReadInJoySelectMemberAQAdapter(getActivity(), (QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit);
    }
    return new SelectMemberBuddyListAdapter(getActivity(), (QQAppInterface)ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
  }
  
  public void a(SelectMemberLimit paramSelectMemberLimit)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberLimit = paramSelectMemberLimit;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560385, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131366466));
    paramLayoutInflater = paramLayoutInflater.inflate(2131560386, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, false);
    paramLayoutInflater.findViewById(2131364130).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter = a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter.a(this.b);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167305);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getResources().getDrawable(2130839625));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupExpandListener(new FriendListFragment.1(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupCollapseListener(new FriendListFragment.2(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcSelectmemberSelectMemberBuddyListAdapter.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */