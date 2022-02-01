package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class RIJFrameworkHeaderManager$2
  implements Runnable
{
  RIJFrameworkHeaderManager$2(RIJFrameworkHeaderManager paramRIJFrameworkHeaderManager, View paramView1, int paramInt1, int paramInt2, View paramView2, ReadInJoyXListView paramReadInJoyXListView) {}
  
  public void run()
  {
    RIJFrameworkHeaderManager.a(this.this$0).i();
    if ((ChannelModeConfigHandler.b()) && (ChannelModeConfigHandler.a())) {}
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
        if (!ChannelModeConfigHandler.a()) {
          break;
        }
        if (j <= this.jdField_b_of_type_Int * 3)
        {
          i = j;
          if (j >= this.jdField_b_of_type_Int) {}
        }
        else
        {
          AIOUtils.a("RIJFrameworkReportManager", "", new IllegalStateException("hideWithAnimation" + j));
          i = this.jdField_b_of_type_Int;
        }
        this.jdField_b_of_type_AndroidViewView.setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",heightDef =" + this.jdField_a_of_type_Int);
        }
      } while (i > this.jdField_b_of_type_Int);
      RIJFrameworkHeaderManager.a(this.this$0).i();
      return;
    } while (j <= this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, j, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + j);
    }
    RIJFrameworkHeaderManager.a(this.this$0).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager.2
 * JD-Core Version:    0.7.0.1
 */