package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$16
  implements Runnable
{
  ApolloPanel$16(ApolloPanel paramApolloPanel, ApolloLinearLayout.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    ApolloLinearLayout.ViewHolder localViewHolder = this.a;
    if ((localViewHolder != null) && (localViewHolder.j != null) && (ApolloPanel.g(this.this$0) != null) && (ApolloPanel.g(this.this$0).e != null) && (this.a.b != null))
    {
      this.a.b.setBackgroundDrawable(this.a.j.getPanelDrawable(ApolloPanel.g(this.this$0).e, ApolloPanel.g(this.this$0).e.getResources().getDisplayMetrics().density));
      return;
    }
    QLog.d("[cmshow]ApolloPanel", 2, "holder.apolloInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.16
 * JD-Core Version:    0.7.0.1
 */