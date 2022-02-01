package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import pay;
import spw;

public class ReadinjoyTabFrame$28$1
  implements Runnable
{
  public ReadinjoyTabFrame$28$1(spw paramspw) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    this.a.a.startActivity(localIntent);
    pay.a("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.1
 * JD-Core Version:    0.7.0.1
 */