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
import com.tencent.widget.PinnedFooterExpandableListView;
import onh;
import qhb;
import qhc;
import qhd;
import qhk;
import qhu;

public class FriendListFragment
  extends Fragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private qhk jdField_a_of_type_Qhk;
  private qhu jdField_a_of_type_Qhu;
  private View.OnClickListener b;
  
  private qhk a()
  {
    if ((this.jdField_a_of_type_Qhu != null) && (this.jdField_a_of_type_Qhu.a() == 1)) {
      return new qhd(getActivity(), (QQAppInterface)onh.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true, this.jdField_a_of_type_Qhu);
    }
    return new qhk(getActivity(), (QQAppInterface)onh.a(), this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList = paramObservableArrayList;
  }
  
  public void a(qhu paramqhu)
  {
    this.jdField_a_of_type_Qhu = paramqhu;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131560008, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131365773));
    paramLayoutInflater = paramLayoutInflater.inflate(2131560009, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, false);
    paramLayoutInflater.findViewById(2131363648).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(paramLayoutInflater);
    this.jdField_a_of_type_Qhk = a();
    this.jdField_a_of_type_Qhk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_Qhk.a(this.b);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_Qhk);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167087);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(getResources().getDrawable(2130839212));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_Qhk);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupExpandListener(new qhb(this));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnGroupCollapseListener(new qhc(this));
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Qhk != null) {
      this.jdField_a_of_type_Qhk.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */