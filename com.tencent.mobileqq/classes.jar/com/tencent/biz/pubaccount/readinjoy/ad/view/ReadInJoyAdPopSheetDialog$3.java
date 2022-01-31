package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import nqz;

public class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  public ReadInJoyAdPopSheetDialog$3(nqz paramnqz, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    nqz.a(this.this$0, nqz.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(nqz.a(), 2, "init webview costTime=" + (SystemClock.currentThreadTimeMillis() - l));
    }
    if ((!TextUtils.isEmpty(this.a)) && (nqz.a(this.this$0) != null))
    {
      nqz.a(this.this$0, SystemClock.currentThreadTimeMillis());
      nqz.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */