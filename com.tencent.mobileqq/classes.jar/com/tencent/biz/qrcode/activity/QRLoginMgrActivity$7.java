package com.tencent.biz.qrcode.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class QRLoginMgrActivity$7
  extends FriendListObserver
{
  QRLoginMgrActivity$7(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onKickOutDevFResult isSuccess:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " result:", Integer.valueOf(paramInt1), " index:", Integer.valueOf(paramInt2) });
    }
    if (!paramBoolean)
    {
      if (QRLoginMgrActivity.f(this.a) == null) {
        QRLoginMgrActivity.a(this.a, new HashSet());
      }
      QRLoginMgrActivity.f(this.a).add(Long.valueOf(paramLong));
    }
    if (QRLoginMgrActivity.g(this.a) != null) {
      QRLoginMgrActivity.g(this.a).remove(Long.valueOf(paramLong));
    }
    if ((QRLoginMgrActivity.g(this.a) != null) && (QRLoginMgrActivity.g(this.a).size() != 0))
    {
      if (paramInt2 == 100)
      {
        QRLoginMgrActivity.h(this.a);
        if (paramBoolean)
        {
          QQToast.makeText(this.a.getApplicationContext(), 2, 2131914161, 0).show();
          return;
        }
        QQToast.makeText(this.a.getApplicationContext(), 1, 2131914134, 0).show();
      }
    }
    else
    {
      QRLoginMgrActivity.h(this.a);
      this.a.finish();
      if ((QRLoginMgrActivity.f(this.a) != null) && (QRLoginMgrActivity.f(this.a).size() > 0))
      {
        QQToast.makeText(this.a.getApplicationContext(), 1, 2131914134, 0).show();
        return;
      }
      QQToast.makeText(this.a.getApplicationContext(), 2, 2131914135, 0).show();
      Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("status", "logout");
      this.a.getApplicationContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.7
 * JD-Core Version:    0.7.0.1
 */