package com.tencent.biz.lebasearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.widget.QQToast;

class LebaSearchPluginManagerActivity$5
  extends Handler
{
  LebaSearchPluginManagerActivity$5(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramMessage.what;
    if (i != -1)
    {
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        this.a.h.f = 1;
        LebaSearchPluginManagerActivity.b(this.a);
        localStringBuilder.append(this.a.getString(2131893796));
        localStringBuilder.append(this.a.getString(2131893790));
        localStringBuilder.append(this.a.h.b.strResName);
        QQToast.makeText(this.a, 2, localStringBuilder.toString(), 1).show(this.a.getTitleBarHeight());
        return;
      }
      this.a.h.f = 0;
      LebaSearchPluginManagerActivity.b(this.a);
      localStringBuilder.append(this.a.getString(2131893796));
      localStringBuilder.append(this.a.getString(2131893794));
      localStringBuilder.append(this.a.h.b.strResName);
      QQToast.makeText(this.a, 2, localStringBuilder.toString(), 1).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.5
 * JD-Core Version:    0.7.0.1
 */