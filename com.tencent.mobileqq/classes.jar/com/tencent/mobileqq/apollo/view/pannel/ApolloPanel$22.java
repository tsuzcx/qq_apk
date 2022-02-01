package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$22
  implements Runnable
{
  ApolloPanel$22(ApolloPanel paramApolloPanel, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null) || (this.this$0.a == null) || (this.this$0.a.a == null) || (this.a.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "holder.apolloInfo == null");
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.getPanelDrawable(this.this$0.a.a, this.this$0.a.a.getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.22
 * JD-Core Version:    0.7.0.1
 */