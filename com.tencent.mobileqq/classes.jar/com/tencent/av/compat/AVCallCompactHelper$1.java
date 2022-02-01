package com.tencent.av.compat;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import lbz;
import lfe;
import lkm;
import mqq.app.BaseActivity;

public class AVCallCompactHelper$1
  implements Runnable
{
  public AVCallCompactHelper$1(lkm paramlkm, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    Object localObject = null;
    Intent localIntent = lkm.a(this.this$0, lkm.a());
    String str1;
    int i;
    if ((this.a.isResume()) && (localIntent != null))
    {
      int j = lbz.a().a();
      String str2 = lkm.a(lkm.a(), localIntent);
      lfe locallfe = lbz.a().c(str2);
      localObject = locallfe;
      str1 = str2;
      i = j;
      if (j >= 2)
      {
        localObject = locallfe;
        str1 = str2;
        i = j;
        if (locallfe != null)
        {
          localObject = locallfe;
          str1 = str2;
          i = j;
          if (locallfe.j())
          {
            this.a.startActivity(localIntent);
            i = j;
            str1 = str2;
            localObject = locallfe;
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