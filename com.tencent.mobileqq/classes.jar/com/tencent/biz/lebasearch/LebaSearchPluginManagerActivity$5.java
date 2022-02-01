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
        this.a.a.jdField_a_of_type_Byte = 1;
        LebaSearchPluginManagerActivity.a(this.a);
        localStringBuilder.append(this.a.getString(2131696034));
        localStringBuilder.append(this.a.getString(2131696028));
        localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
        QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
        return;
      }
      this.a.a.jdField_a_of_type_Byte = 0;
      LebaSearchPluginManagerActivity.a(this.a);
      localStringBuilder.append(this.a.getString(2131696034));
      localStringBuilder.append(this.a.getString(2131696032));
      localStringBuilder.append(this.a.a.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.strResName);
      QQToast.a(this.a, 2, localStringBuilder.toString(), 1).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity.5
 * JD-Core Version:    0.7.0.1
 */