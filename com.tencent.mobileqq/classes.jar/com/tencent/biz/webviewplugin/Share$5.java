package com.tencent.biz.webviewplugin;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;

class Share$5
  implements Runnable
{
  Share$5(Share paramShare, String paramString) {}
  
  public void run()
  {
    try
    {
      if (!TextUtils.isEmpty(this.a))
      {
        QfavBuilder.a(0, this.this$0.e, this.this$0.b, null, this.this$0.h, this.this$0.i, null, null, false, -1L).c(this.a).a("lCategory", 10L).a(this.this$0.y, this.a);
        return;
      }
      QfavBuilder.a(0, this.this$0.e, this.this$0.b, null, this.this$0.h, this.this$0.i, null, null, false, -1L).c(this.this$0.H).a(this.this$0.y, this.this$0.H);
      return;
    }
    catch (Exception localException)
    {
      String str = Share.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QfavBuilder.newLink error:");
      localStringBuilder.append(localException.toString());
      QLog.e(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.5
 * JD-Core Version:    0.7.0.1
 */