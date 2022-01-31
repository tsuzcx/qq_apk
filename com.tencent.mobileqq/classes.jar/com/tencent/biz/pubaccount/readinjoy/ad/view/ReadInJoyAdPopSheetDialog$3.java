package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import ocf;

public class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  public ReadInJoyAdPopSheetDialog$3(ocf paramocf, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    ocf.a(this.this$0, ocf.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(ocf.a(), 2, "init webview costTime=" + (SystemClock.currentThreadTimeMillis() - l));
    }
    if ((!TextUtils.isEmpty(this.a)) && (ocf.a(this.this$0) != null))
    {
      ocf.a(this.this$0, SystemClock.currentThreadTimeMillis());
      ocf.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */