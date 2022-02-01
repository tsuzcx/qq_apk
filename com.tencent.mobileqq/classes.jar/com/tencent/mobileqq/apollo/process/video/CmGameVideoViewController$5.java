package com.tencent.mobileqq.apollo.process.video;

import amtj;
import amtp;
import andq;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class CmGameVideoViewController$5
  implements Runnable
{
  public CmGameVideoViewController$5(amtp paramamtp, int paramInt, long paramLong) {}
  
  public void run()
  {
    if ((amtp.a(this.this$0) == null) || (TextUtils.isEmpty(amtp.a(this.this$0).c))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(amtp.a(this.this$0).c);
    String str3 = "";
    String str1 = str3;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      str1 = str3;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameVideoViewController", 2, new Object[] { "[cm_ad_report], type:", Integer.valueOf(this.jdField_a_of_type_Int), ",time:", Long.valueOf(this.jdField_a_of_type_Long) });
        }
        if (!TextUtils.isEmpty(str1)) {
          localStringBuilder.append("&video=").append(URLEncoder.encode(str1, "UTF-8"));
        }
        andq.a(localStringBuilder.toString(), null, null);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameVideoViewController", 1, localThrowable, new Object[0]);
        return;
      }
      if ((amtp.a(this.this$0) & 0x1) == 1) {
        break;
      }
      String str2 = amtp.a(this.this$0, 0L, 0L, 1L, 0L);
      amtp.a(this.this$0, amtp.a(this.this$0) | 0x1);
      continue;
      if ((amtp.a(this.this$0) & 0x2) == 2) {
        break;
      }
      str2 = "";
      amtp.a(this.this$0, amtp.a(this.this$0) | 0x2);
      continue;
      if ((amtp.a(this.this$0) & 0x4) == 4) {
        break;
      }
      str2 = amtp.a(this.this$0, 0L, this.jdField_a_of_type_Long, 1L, 0L);
      amtp.a(this.this$0, amtp.a(this.this$0) | 0x4);
      continue;
      if ((amtp.a(this.this$0) & 0x8) == 8) {
        break;
      }
      str2 = amtp.a(this.this$0, 0L, this.jdField_a_of_type_Long, 1L, 1L);
      amtp.a(this.this$0, amtp.a(this.this$0) | 0x8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameVideoViewController.5
 * JD-Core Version:    0.7.0.1
 */