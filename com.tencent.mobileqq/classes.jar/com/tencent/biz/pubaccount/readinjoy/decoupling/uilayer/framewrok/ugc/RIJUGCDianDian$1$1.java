package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc;

import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.app.BaseActivity;
import pqq;
import pqr;

public class RIJUGCDianDian$1$1
  implements Runnable
{
  public RIJUGCDianDian$1$1(pqr parampqr) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.a, ReadInJoyDeliverUGCActivity.class);
    localIntent.putExtra("is_from_dian_dian", true);
    localIntent.putExtra("support_topic", true);
    this.this$0.a.startActivity(localIntent);
    pqq.a("3", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.ugc.RIJUGCDianDian.1.1
 * JD-Core Version:    0.7.0.1
 */