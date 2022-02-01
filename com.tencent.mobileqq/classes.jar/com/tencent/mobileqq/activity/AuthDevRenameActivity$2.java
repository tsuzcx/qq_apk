package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.QQToast;

class AuthDevRenameActivity$2
  extends SecSvcObserver
{
  AuthDevRenameActivity$2(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AuthDevRenameActivity.a(this.a);
    if (!paramBoolean)
    {
      paramArrayOfByte = this.a;
      QQToast.a(paramArrayOfByte, paramArrayOfByte.getString(2131692041), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.2
 * JD-Core Version:    0.7.0.1
 */