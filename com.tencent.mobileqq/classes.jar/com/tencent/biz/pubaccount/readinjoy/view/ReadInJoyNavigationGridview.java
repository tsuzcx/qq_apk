package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import java.util.List;
import mmq;
import mmr;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ReadInJoyNavigationAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter;
  private ReadInJoyNavigationGridview.NaviMaskTouchListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviMaskTouchListener;
  private List jdField_a_of_type_JavaUtilList;
  private mmr jdField_a_of_type_Mmr;
  private boolean jdField_a_of_type_Boolean;
  
  public ReadInJoyNavigationGridview(Context paramContext, ReadInJoyNavigationGridview.NaviMaskTouchListener paramNaviMaskTouchListener)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_a_of_type_Mmr = new mmr(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviMaskTouchListener = paramNaviMaskTouchListener;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2130969635, this));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367253));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367252);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter = new ReadInJoyNavigationAdapter(paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new mmq(this));
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter.getCount();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetGridView;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_Mmr.removeMessages(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setChannelButtonListener(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter.a(paramChannelButtonListener);
  }
  
  public void setNaviBarAdapterDataSet(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Mmr.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */