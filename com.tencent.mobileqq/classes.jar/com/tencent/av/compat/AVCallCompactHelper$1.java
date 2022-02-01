package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import lcb;
import lff;
import lkg;
import mqq.app.BaseActivity;

public class AVCallCompactHelper$1
  implements Runnable
{
  public AVCallCompactHelper$1(lkg paramlkg, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = lkg.a(this.this$0, lkg.a());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = lcb.a().a();
      String str2 = lkg.a(lkg.a(), localIntent);
      lff locallff = lcb.a().c(str2);
      localObject = locallff;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = locallff;
        str1 = str2;
        i = j;
        if (locallff != null)
        {
          localObject = locallff;
          str1 = str2;
          i = j;
          if (locallff.j())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = locallff;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CompatModeTag", 2, "checkThirdCallIntent, isResume[" + this.a.isResume() + "], count[" + i + "], session[" + str1 + "], info[" + localObject + "]");
      }
      return;
      i = 0;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */