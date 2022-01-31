package com.tencent.mobileqq.apollo.view;

import ajbx;
import ajbz;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$20
  implements Runnable
{
  ApolloPanel$20(ApolloPanel paramApolloPanel, ajbz paramajbz) {}
  
  public void run()
  {
    if ((this.a == null) || (this.a.jdField_a_of_type_Ajbx == null) || (this.this$0.a == null) || (this.this$0.a.a == null) || (this.a.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "holder.apolloInfo == null");
      }
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.a.jdField_a_of_type_Ajbx.a(this.this$0.a.a, this.this$0.a.a.getResources().getDisplayMetrics().density));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.20
 * JD-Core Version:    0.7.0.1
 */