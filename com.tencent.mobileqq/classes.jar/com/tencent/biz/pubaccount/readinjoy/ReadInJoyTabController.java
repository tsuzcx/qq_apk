package com.tencent.biz.pubaccount.readinjoy;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.HeaderViewController;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class ReadInJoyTabController
  extends HeaderViewController
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ReadInJoyObserver a;
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  
  public void a() {}
  
  public void a(ListView paramListView)
  {
    paramListView.addHeaderView(this.jdField_a_of_type_AndroidViewViewGroup);
  }
  
  public void a(List<TabChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabController", 2, "setAdapterData.");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.b();
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyTabController
 * JD-Core Version:    0.7.0.1
 */