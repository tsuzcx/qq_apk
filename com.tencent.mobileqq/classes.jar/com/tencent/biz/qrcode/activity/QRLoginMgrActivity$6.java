package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.logindev.LoginDevItem;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager.IDevListRefreshListener;
import java.util.List;

class QRLoginMgrActivity$6
  implements LoginDevicesManager.IDevListRefreshListener
{
  QRLoginMgrActivity$6(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void a(List<LoginDevItem> paramList)
  {
    this.a.runOnUiThread(new QRLoginMgrActivity.6.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.6
 * JD-Core Version:    0.7.0.1
 */