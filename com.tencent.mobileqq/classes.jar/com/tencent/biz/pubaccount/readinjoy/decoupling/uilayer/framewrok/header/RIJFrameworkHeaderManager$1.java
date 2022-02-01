package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.qphone.base.util.QLog;
import pgt;

public class RIJFrameworkHeaderManager$1
  implements Runnable
{
  public RIJFrameworkHeaderManager$1(pgt parampgt, View paramView1, int paramInt, View paramView2, ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    pgt.a(this.this$0).i();
    int i = this.jdField_a_of_type_AndroidViewView.getHeight();
    if ((i != this.jdField_a_of_type_Int) && (QLog.isColorLevel())) {
      QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",h = " + this.jdField_a_of_type_Int);
    }
    if (i > this.jdField_a_of_type_Int)
    {
      this.b.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      if (QLog.isColorLevel()) {
        QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager.1
 * JD-Core Version:    0.7.0.1
 */