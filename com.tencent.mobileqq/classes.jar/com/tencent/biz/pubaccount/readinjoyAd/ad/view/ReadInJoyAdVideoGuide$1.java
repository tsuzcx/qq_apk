package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import android.widget.TextView;

class ReadInJoyAdVideoGuide$1
  implements Runnable
{
  ReadInJoyAdVideoGuide$1(ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide) {}
  
  public void run()
  {
    String str;
    if (!TextUtils.isEmpty(ReadInJoyAdVideoGuide.a(this.this$0))) {
      str = ReadInJoyAdVideoGuide.a(this.this$0);
    } else {
      str = ReadInJoyAdVideoGuide.b(this.this$0);
    }
    if ((ReadInJoyAdVideoGuide.c(this.this$0) != null) && (!TextUtils.isEmpty(str))) {
      ReadInJoyAdVideoGuide.c(this.this$0).setText(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.1
 * JD-Core Version:    0.7.0.1
 */