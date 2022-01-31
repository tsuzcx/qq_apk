package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import onh;
import rhf;

public class ReadinjoyTabFrame$31$1
  implements Runnable
{
  public ReadinjoyTabFrame$31$1(rhf paramrhf) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    this.a.a.startActivity(localIntent);
    onh.a("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.31.1
 * JD-Core Version:    0.7.0.1
 */