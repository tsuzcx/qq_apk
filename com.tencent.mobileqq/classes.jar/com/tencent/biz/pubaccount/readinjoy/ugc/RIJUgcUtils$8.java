package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian;

final class RIJUgcUtils$8
  implements Runnable
{
  RIJUgcUtils$8(Activity paramActivity) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    this.a.startActivity(localIntent);
    RIJUGCDianDian.a("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.8
 * JD-Core Version:    0.7.0.1
 */