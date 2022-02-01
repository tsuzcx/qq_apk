package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import tze;

public class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  public ReadInJoyAdPopSheetDialog$3(tze paramtze, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    tze.a(this.this$0, tze.a(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d(tze.a(), 2, "init webview costTime=" + (SystemClock.currentThreadTimeMillis() - l));
    }
    if ((!TextUtils.isEmpty(this.a)) && (tze.a(this.this$0) != null))
    {
      tze.a(this.this$0, SystemClock.currentThreadTimeMillis());
      tze.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */