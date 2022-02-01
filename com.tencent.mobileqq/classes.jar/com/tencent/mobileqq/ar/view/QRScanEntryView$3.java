package com.tencent.mobileqq.ar.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRScanEntryView$3
  implements View.OnClickListener
{
  QRScanEntryView$3(QRScanEntryView paramQRScanEntryView) {}
  
  public void onClick(View paramView)
  {
    this.a.findViewById(2131436471).setAlpha(1.0F);
    ScanTorchActivity localScanTorchActivity = (ScanTorchActivity)this.a.E;
    String str2 = this.a.C.getCurrentAccountUin();
    String str1;
    if (!TextUtils.isEmpty(localScanTorchActivity.mCurrentNickName)) {
      str1 = localScanTorchActivity.mCurrentNickName;
    } else {
      str1 = str2;
    }
    Intent localIntent = new Intent(localScanTorchActivity, QRDisplayActivity.class);
    localIntent.putExtra("from", "ScannerActivity");
    localIntent.putExtra("title", localScanTorchActivity.getString(2131914184));
    localIntent.putExtra("nick", str1);
    localIntent.putExtra("uin", str2);
    localIntent.putExtra("type", 1);
    localScanTorchActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.3
 * JD-Core Version:    0.7.0.1
 */