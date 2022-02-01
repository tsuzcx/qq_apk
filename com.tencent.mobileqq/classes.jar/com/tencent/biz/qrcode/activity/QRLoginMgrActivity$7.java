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
      if (QRLoginMgrActivity.a(this.a) == null) {
        QRLoginMgrActivity.a(this.a, new HashSet());
      }
      QRLoginMgrActivity.a(this.a).add(Long.valueOf(paramLong));
    }
    if (QRLoginMgrActivity.a(this.a) != null) {
      QRLoginMgrActivity.a(this.a).remove(Long.valueOf(paramLong));
    }
    if ((QRLoginMgrActivity.a(this.a) != null) && (QRLoginMgrActivity.a(this.a).size() != 0))
    {
      if (paramInt2 == 100)
      {
        QRLoginMgrActivity.a(this.a);
        if (paramBoolean)
        {
          QQToast.a(this.a.getApplicationContext(), 2, 2131716697, 0).a();
          return;
        }
        QQToast.a(this.a.getApplicationContext(), 1, 2131716670, 0).a();
      }
    }
    else
    {
      QRLoginMgrActivity.a(this.a);
      this.a.finish();
      if ((QRLoginMgrActivity.a(this.a) != null) && (QRLoginMgrActivity.a(this.a).size() > 0))
      {
        QQToast.a(this.a.getApplicationContext(), 1, 2131716670, 0).a();
        return;
      }
      QQToast.a(this.a.getApplicationContext(), 2, 2131716671, 0).a();
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