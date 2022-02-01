package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.widget.QQToast;

class AuthDevRenameActivity$2
  extends SecSvcObserver
{
  AuthDevRenameActivity$2(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString)
  {
    AuthDevRenameActivity.a(this.a);
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131692122), 0).b(this.a.getTitleBarHeight());
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.2
 * JD-Core Version:    0.7.0.1
 */