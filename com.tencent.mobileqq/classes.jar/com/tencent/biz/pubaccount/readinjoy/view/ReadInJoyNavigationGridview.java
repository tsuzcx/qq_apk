package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class ReadInJoyNavigationGridview
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ReadInJoyNavigationAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter;
  private ReadInJoyNavigationGridview.NaviBarHandler jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviBarHandler;
  private ReadInJoyNavigationGridview.NaviMaskTouchListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviMaskTouchListener;
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  
  public ReadInJoyNavigationGridview(Context paramContext, ReadInJoyNavigationGridview.NaviMaskTouchListener paramNaviMaskTouchListener)
  {
    super(paramContext);
    a(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviBarHandler = new ReadInJoyNavigationGridview.NaviBarHandler(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviMaskTouchListener = paramNaviMaskTouchListener;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560356, this));
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372135));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372136);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter = new ReadInJoyNavigationAdapter(paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setPadding(this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft(), ImmersiveUtils.getStatusBarHeight(paramContext), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight(), this.jdField_a_of_type_AndroidWidgetGridView.getPaddingBottom());
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ReadInJoyNavigationGridview.1(this));
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
  
  public List<ChannelCoverInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviBarHandler.removeMessages(1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setChannelButtonListener(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter.a(paramChannelButtonListener);
  }
  
  public void setNaviBarAdapterDataSet(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationGridview$NaviBarHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview
 * JD-Core Version:    0.7.0.1
 */