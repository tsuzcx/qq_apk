package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import ofx;

public class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  public ReadInJoyAdPopSheetDialog$3(ofx paramofx, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    ofx.a(this.this$0, ofx.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(ofx.a(), 2, "init webview costTime=" + (SystemClock.currentThreadTimeMillis() - l));
    }
    if ((!TextUtils.isEmpty(this.a)) && (ofx.a(this.this$0) != null))
    {
      ofx.a(this.this$0, SystemClock.currentThreadTimeMillis());
      ofx.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */