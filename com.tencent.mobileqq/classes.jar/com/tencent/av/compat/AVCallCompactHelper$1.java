package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import lfb;
import lid;
import lmy;
import mqq.app.BaseActivity;

public class AVCallCompactHelper$1
  implements Runnable
{
  public AVCallCompactHelper$1(lmy paramlmy, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = lmy.a(this.this$0, lmy.a());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = lfb.a().a();
      String str2 = lmy.a(lmy.a(), localIntent);
      lid locallid = lfb.a().c(str2);
      localObject = locallid;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = locallid;
        str1 = str2;
        i = j;
        if (locallid != null)
        {
          localObject = locallid;
          str1 = str2;
          i = j;
          if (locallid.i())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = locallid;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.compat.AVCallCompactHelper.1
 * JD-Core Version:    0.7.0.1
 */