package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.text.TextUtils;
import android.widget.TextView;

class ReadInJoyAdVideoGuide$1
  implements Runnable
{
  ReadInJoyAdVideoGuide$1(ReadInJoyAdVideoGuide paramReadInJoyAdVideoGuide) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(ReadInJoyAdVideoGuide.a(this.this$0))) {}
    for (String str = ReadInJoyAdVideoGuide.a(this.this$0);; str = ReadInJoyAdVideoGuide.b(this.this$0))
    {
      if ((ReadInJoyAdVideoGuide.a(this.this$0) != null) && (!TextUtils.isEmpty(str))) {
        ReadInJoyAdVideoGuide.a(this.this$0).setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVideoGuide.1
 * JD-Core Version:    0.7.0.1
 */