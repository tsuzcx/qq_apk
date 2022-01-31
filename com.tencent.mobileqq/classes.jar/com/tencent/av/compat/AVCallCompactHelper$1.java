package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import lcx;
import lga;
import lkv;
import mqq.app.BaseActivity;

public class AVCallCompactHelper$1
  implements Runnable
{
  public AVCallCompactHelper$1(lkv paramlkv, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = lkv.a(this.this$0, lkv.a());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = lcx.a().a();
      String str2 = lkv.a(lkv.a(), localIntent);
      lga locallga = lcx.a().b(str2);
      localObject = locallga;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = locallga;
        str1 = str2;
        i = j;
        if (locallga != null)
        {
          localObject = locallga;
          str1 = str2;
          i = j;
          if (locallga.h())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = locallga;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */