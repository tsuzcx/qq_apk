package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;
import ors;
import orv;

public class ReadInJoyUtils$15$1
  implements Runnable
{
  public ReadInJoyUtils$15$1(orv paramorv) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_dian_dian", true);
    localIntent.putExtra("support_topic", true);
    this.this$0.a.startActivity(localIntent);
    ors.a("3", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.15.1
 * JD-Core Version:    0.7.0.1
 */