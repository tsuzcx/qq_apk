package com.tencent.av.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class MultiMembersVideoUI$1
  implements AdapterView.OnItemClickListener
{
  MultiMembersVideoUI$1(MultiMembersVideoUI paramMultiMembersVideoUI) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener != null)
    {
      MultiMembersUI.Holder localHolder = (MultiMembersUI.Holder)paramView.getTag();
      if (localHolder == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MultiMembersVideoUI", 2, "onItemClick-->holder is null");
        }
      }
      else if ((this.a.jdField_a_of_type_JavaUtilArrayList.size() > 8) && ((this.a.jdField_a_of_type_Int == 1) || (this.a.jdField_a_of_type_Int == 2))) {
        this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(localHolder.jdField_a_of_type_Long, localHolder.jdField_a_of_type_Int, paramInt, true);
      } else {
        this.a.jdField_a_of_type_ComTencentAvUtilsMultiVideoMembersClickListener.a(localHolder.jdField_a_of_type_Long, localHolder.jdField_a_of_type_Int, paramInt, false);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiMembersVideoUI.1
 * JD-Core Version:    0.7.0.1
 */