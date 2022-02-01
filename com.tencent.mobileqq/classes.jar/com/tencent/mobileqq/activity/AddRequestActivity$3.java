package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class AddRequestActivity$3
  implements View.OnClickListener
{
  AddRequestActivity$3(String paramString1, Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString2, String paramString3, String paramString4) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      Object localObject = new Intent(this.b, QQBrowserActivity.class);
      this.b.startActivity(((Intent)localObject).putExtra("url", this.a));
      ReportController.b(this.c, "dc00898", "", "", "0X800B757", "0X800B757", 0, 0, this.d, this.e, "", "");
      if (QLog.isColorLevel())
      {
        localObject = this.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setEntityInfo jumpurl:");
        localStringBuilder.append(this.a);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.3
 * JD-Core Version:    0.7.0.1
 */