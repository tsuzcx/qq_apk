package com.tencent.gdtad.util;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.params.GetUserInfoCallback;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AuthorizationItem;
import java.util.List;
import mqq.os.MqqHandler;

class GdtUserInfoAuthorizationHelper$1
  implements GetUserInfoCallback
{
  public void a(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("name");
    String str2 = paramBundle.getString("phone");
    paramBundle = paramBundle.getString("city");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getUserInfo : name -> ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", phone -> ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", city -> ");
      localStringBuilder.append(paramBundle);
      QLog.d("GdtUserInfoAuthorizationHelper", 2, localStringBuilder.toString());
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.a.contains(AuthorizationItem.a))
    {
      bool1 = bool2;
      if (TextUtils.isEmpty(str1)) {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (this.a.contains(AuthorizationItem.b))
    {
      bool2 = bool1;
      if (TextUtils.isEmpty(str2)) {
        bool2 = false;
      }
    }
    if ((this.a.contains(AuthorizationItem.c)) && (TextUtils.isEmpty(paramBundle))) {
      bool2 = false;
    }
    paramBundle = GdtUserInfoAuthorizationHelper.a(this.d, str1, str2, paramBundle, this.a);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      GdtUserInfoAuthorizationHelper.a(this.d, this.b, bool2, paramBundle, this.c, this.a);
      return;
    }
    ThreadManager.getUIHandler().post(new GdtUserInfoAuthorizationHelper.1.1(this, bool2, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.util.GdtUserInfoAuthorizationHelper.1
 * JD-Core Version:    0.7.0.1
 */