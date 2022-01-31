package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import biib;
import biie;
import biux;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class Leba$5
  implements Runnable
{
  Leba$5(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = WebProcessManager.a((String)localObject);
      if (System.currentTimeMillis() - l < 604800000L) {
        WebProcessManager.a(Leba.a(), "key_health_dns_parse");
      }
      l = WebProcessManager.c((String)localObject);
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(Leba.b(), "key_gamecenter_dns_parse");
      }
      l = WebProcessManager.a((String)localObject, "key_reader_click_time");
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.a(Leba.c(), "key_reader_dns_parse");
      }
    }
    localObject = (biux)this.this$0.a.getManager(129);
    if (localObject != null) {
      ((biux)localObject).a(6);
    }
    localObject = (biie)this.this$0.a.getManager(142);
    if (localObject != null) {
      biib.a(((biie)localObject).a(6), 500L);
    }
    ThreadManager.post(new Leba.5.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5
 * JD-Core Version:    0.7.0.1
 */