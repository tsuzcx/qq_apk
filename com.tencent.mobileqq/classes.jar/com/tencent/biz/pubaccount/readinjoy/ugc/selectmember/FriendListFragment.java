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
import pkh;
import saw;
import sax;
import say;
import sbf;
import sbp;

public class FriendListFragment
  extends ReportV4Fragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private sbf jdField_a_of_type_Sbf;
  private sbp jdField_a_of_type_Sbp;
  private View.OnClickListener b;
  
  private sbf a()
  {
    if ((this.jdField_a_of_type_Sbp != null) && (this.jdField_a_of_type_Sbp.a() == 1)) {
      return new say(getActivity(), (QQAppInterface)pkh.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true, this.jdField_a_of_type_Sbp);
    }
    return new sbf(getActivity(), (QQAppInterface)pkh.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
  }
  
  public void a(sbp paramsbp)
  {
    this.jdField_a_of_type_Sbp = paramsbp;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560313, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131366294));
    paramLayoutInflater = paramLayoutInflater.inflate(2131560314, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, false);
    paramLayoutInflater.findViewById(2131364030).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_Sbf = a();
    this.jdField_a_of_type_Sbf.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_Sbf.a(this.b);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Sbf);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167296);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getResources().getDrawable(2130839546));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Sbf);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupExpandListener(new saw(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupCollapseListener(new sax(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Sbf != null) {
      this.jdField_a_of_type_Sbf.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */