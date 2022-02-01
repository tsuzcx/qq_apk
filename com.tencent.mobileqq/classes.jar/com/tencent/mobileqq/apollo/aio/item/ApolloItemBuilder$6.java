package com.tencent.mobileqq.apollo.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.vip.manager.QZoneVipInfoManager;

class ApolloItemBuilder$6
  implements ActionSheet.OnButtonClickListener
{
  ApolloItemBuilder$6(ApolloItemBuilder paramApolloItemBuilder, ApolloItemBuilder.Holder paramHolder, ApolloActionData paramApolloActionData, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      if ((1 != this.a.s) && (this.a.s != 2))
      {
        if (3 == this.a.s)
        {
          paramView = new Intent(this.d.e, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(this.b.url))
          {
            paramView.putExtra("url", this.b.url);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(ApolloConstant.t);
            localStringBuilder.append("&id=");
            localStringBuilder.append(this.b.actionId);
            paramView.putExtra("url", localStringBuilder.toString());
          }
          this.d.e.startActivity(paramView);
        }
        else if (4 != this.a.s)
        {
          ApolloMessageUtilImpl.resendApolloMessage(this.d.d, this.d.f.a, this.d.f.b, this.a.q.uniseq);
        }
      }
      else
      {
        if (!(this.d.e instanceof Activity))
        {
          QLog.e("[cmshow]ApolloItemBuilder", 1, "mContext is not activity");
          return;
        }
        QZoneVipInfoManager.a((Activity)this.d.e, this.d.d.getCurrentUin(), "lmx_actchat");
      }
    }
    this.c.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */