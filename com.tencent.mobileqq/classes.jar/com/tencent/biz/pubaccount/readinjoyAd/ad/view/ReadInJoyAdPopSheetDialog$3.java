package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyAdPopSheetDialog$3
  implements Runnable
{
  ReadInJoyAdPopSheetDialog$3(ReadInJoyAdPopSheetDialog paramReadInJoyAdPopSheetDialog, String paramString) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    Object localObject = this.this$0;
    ReadInJoyAdPopSheetDialog.a((ReadInJoyAdPopSheetDialog)localObject, ReadInJoyAdPopSheetDialog.a((ReadInJoyAdPopSheetDialog)localObject));
    if (QLog.isColorLevel())
    {
      localObject = ReadInJoyAdPopSheetDialog.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init webview costTime=");
      localStringBuilder.append(SystemClock.currentThreadTimeMillis() - l);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(this.a)) && (ReadInJoyAdPopSheetDialog.a(this.this$0) != null))
    {
      ReadInJoyAdPopSheetDialog.a(this.this$0, SystemClock.currentThreadTimeMillis());
      ReadInJoyAdPopSheetDialog.a(this.this$0).post(new ReadInJoyAdPopSheetDialog.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.3
 * JD-Core Version:    0.7.0.1
 */