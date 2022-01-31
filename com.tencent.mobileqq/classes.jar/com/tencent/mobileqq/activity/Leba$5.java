package com.tencent.mobileqq.activity;

import abai;
import android.text.TextUtils;
import beyv;
import beyy;
import bfli;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class Leba$5
  implements Runnable
{
  public Leba$5(abai paramabai) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = WebProcessManager.a((String)localObject);
      if (System.currentTimeMillis() - l < 604800000L) {
        WebProcessManager.a(abai.a(), "key_health_dns_parse");
      }
      l = WebProcessManager.c((String)localObject);
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(abai.b(), "key_gamecenter_dns_parse");
      }
      l = WebProcessManager.a((String)localObject, "key_reader_click_time");
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(abai.c(), "key_reader_dns_parse");
      }
    }
    localObject = (bfli)this.this$0.a.getManager(129);
    if (localObject != null) {
      ((bfli)localObject).a(6);
    }
    localObject = (beyy)this.this$0.a.getManager(142);
    if (localObject != null) {
      beyv.a(((beyy)localObject).a(6), 500L);
    }
    ThreadManager.post(new Leba.5.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5
 * JD-Core Version:    0.7.0.1
 */