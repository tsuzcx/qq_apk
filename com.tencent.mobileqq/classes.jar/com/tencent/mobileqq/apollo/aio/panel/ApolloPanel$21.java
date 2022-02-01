package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$21
  implements Runnable
{
  ApolloPanel$21(ApolloPanel paramApolloPanel, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    ApolloLinearLayout.ViewHolder localViewHolder = this.a;
    if ((localViewHolder != null) && (localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo != null) && (ApolloPanel.a(this.this$0) != null) && (ApolloPanel.a(this.this$0).a != null) && (this.a.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.getPanelDrawable(ApolloPanel.a(this.this$0).a, ApolloPanel.a(this.this$0).a.getResources().getDisplayMetrics().density));
      return;
    }
    QLog.d("[cmshow]ApolloPanel", 2, "holder.apolloInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.21
 * JD-Core Version:    0.7.0.1
 */