package com.tencent.biz.pubaccount.readinjoy.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.PinnedFooterExpandableListView;
import ozs;
import rhh;
import rhi;
import rhj;
import rhq;
import ria;

public class FriendListFragment
  extends ReportV4Fragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private rhq jdField_a_of_type_Rhq;
  private ria jdField_a_of_type_Ria;
  private View.OnClickListener b;
  
  private rhq a()
  {
    if ((this.jdField_a_of_type_Ria != null) && (this.jdField_a_of_type_Ria.a() == 1)) {
      return new rhj(getActivity(), (QQAppInterface)ozs.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true, this.jdField_a_of_type_Ria);
    }
    return new rhq(getActivity(), (QQAppInterface)ozs.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
  }
  
  public void a(ria paramria)
  {
    this.jdField_a_of_type_Ria = paramria;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560260, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131366163));
    paramLayoutInflater = paramLayoutInflater.inflate(2131560261, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, false);
    paramLayoutInflater.findViewById(2131363930).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_Rhq = a();
    this.jdField_a_of_type_Rhq.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_Rhq.a(this.b);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Rhq);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167247);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getResources().getDrawable(2130839490));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Rhq);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupExpandListener(new rhh(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupCollapseListener(new rhi(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Rhq != null) {
      this.jdField_a_of_type_Rhq.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */