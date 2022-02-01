package com.tencent.biz.qrcode.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRDisplayActivity$19
  implements AdapterView.OnItemClickListener
{
  QRDisplayActivity$19(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QRDisplayActivity.a(this.a).dismiss();
    if (QLog.isColorLevel()) {
      QLog.i("QRDisplayActivity", 2, "onItemClick.chooseChannel: " + paramInt + "," + paramLong);
    }
    this.a.i = ((int)paramLong);
    QRDisplayActivity.a(this.a);
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.19
 * JD-Core Version:    0.7.0.1
 */