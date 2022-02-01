package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import pch;
import pgt;

public class RIJFrameworkHeaderManager$2
  implements Runnable
{
  public RIJFrameworkHeaderManager$2(pgt parampgt, View paramView1, int paramInt1, int paramInt2, View paramView2, ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    if ((pch.b()) && (pch.a())) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        j = this.jdField_a_of_type_AndroidViewView.getHeight();
        if ((j != this.jdField_a_of_type_Int) && (QLog.isColorLevel())) {
          QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + j + ",heightDef =" + this.jdField_a_of_type_Int);
        }
        if (!pch.a()) {
          break;
        }
        if (j <= this.jdField_b_of_type_Int * 3)
        {
          i = j;
          if (j >= this.jdField_b_of_type_Int) {}
        }
        else
        {
          AIOUtils.catchedExceptionInReleaseV2("RIJFrameworkReportManager", "", new IllegalStateException("hideWithAnimation" + j));
          i = this.jdField_b_of_type_Int;
        }
        this.jdField_b_of_type_AndroidViewView.setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",heightDef =" + this.jdField_a_of_type_Int);
        }
      } while (i > this.jdField_b_of_type_Int);
      pgt.a(this.this$0).i();
      return;
    } while (j <= this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, j, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + j);
    }
    pgt.a(this.this$0).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager.2
 * JD-Core Version:    0.7.0.1
 */