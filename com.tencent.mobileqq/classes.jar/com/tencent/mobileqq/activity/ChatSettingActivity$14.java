package com.tencent.mobileqq.activity;

import MQQ.GetRoamToastRsp;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;

class ChatSettingActivity$14
  extends SVIPObserver
{
  ChatSettingActivity$14(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onGetRoamToast(boolean paramBoolean, GetRoamToastRsp paramGetRoamToastRsp)
  {
    if (this.a.a == null) {
      return;
    }
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) && (paramGetRoamToastRsp != null) && (!TextUtils.isEmpty(paramGetRoamToastRsp.sToast)) && (((ISVIPHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramGetRoamToastRsp)))
    {
      localObject2 = paramGetRoamToastRsp.sToast;
      int i = ((String)localObject2).indexOf('#');
      localObject1 = localObject2;
      if (i >= 0)
      {
        int j = i + 1;
        int k = ((String)localObject2).indexOf('#', j);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = new SpannableStringBuilder();
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2, 0, i);
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2, j, k);
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject2, k + 1, ((String)localObject2).length());
          ((SpannableStringBuilder)localObject1).setSpan(new ForegroundColorSpan(-12541697), i, k - 1, 33);
        }
      }
      this.a.d.setText((CharSequence)localObject1);
      this.a.a.setTag(paramGetRoamToastRsp);
      this.a.a.setVisibility(0);
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009E31", "0X8009E31", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = ChatSettingActivity.c(this.a);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetRoamToast: ");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(",");
      if (paramGetRoamToastRsp == null) {
        paramGetRoamToastRsp = "null";
      } else {
        paramGetRoamToastRsp = paramGetRoamToastRsp.sToast;
      }
      ((StringBuilder)localObject2).append(paramGetRoamToastRsp);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    this.a.a.setVisibility(8);
  }
  
  public void onGetRoamType(String paramString, int paramInt)
  {
    ChatSettingActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.14
 * JD-Core Version:    0.7.0.1
 */