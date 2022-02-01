package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import ozs;
import slv;

public class ReadinjoyTabFrame$28$1
  implements Runnable
{
  public ReadinjoyTabFrame$28$1(slv paramslv) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_kan_dian", true);
    localIntent.putExtra("support_topic", true);
    this.a.a.startActivity(localIntent);
    ozs.a("1", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.28.1
 * JD-Core Version:    0.7.0.1
 */