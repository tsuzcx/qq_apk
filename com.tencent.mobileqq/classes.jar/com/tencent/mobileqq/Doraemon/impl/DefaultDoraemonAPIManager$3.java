package com.tencent.mobileqq.Doraemon.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIConfig;
import com.tencent.mobileqq.Doraemon.UserPermission;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class DefaultDoraemonAPIManager$3
  implements View.OnClickListener
{
  DefaultDoraemonAPIManager$3(DefaultDoraemonAPIManager paramDefaultDoraemonAPIManager, UserPermission paramUserPermission, APIConfig paramAPIConfig, JSONObject paramJSONObject, APICallback paramAPICallback) {}
  
  public void onClick(View paramView)
  {
    this.e.g();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reject ");
    localStringBuilder.append(this.a.a);
    QLog.i("DoraemonOpenAPI.apiMgr", 1, localStringBuilder.toString());
    DefaultDoraemonAPIManager.a(this.e, this.a, 1);
    DefaultDoraemonAPIManager.b(this.e, 4, this.b, this.c, this.d);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAPIManager.3
 * JD-Core Version:    0.7.0.1
 */