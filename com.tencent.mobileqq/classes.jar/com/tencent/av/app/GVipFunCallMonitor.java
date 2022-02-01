package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GVipFunCallMonitor
{
  private VideoAppInterface a;
  private boolean b = false;
  private BroadcastReceiver c;
  
  public GVipFunCallMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.a = paramVideoAppInterface;
    this.c = new GVipFunCallMonitor.VipFunCallReceiver(this);
  }
  
  public void a()
  {
    Object localObject = new IntentFilter("tencent.video.q2v.MultiVideo");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.AnnimateDownloadFinish");
    if (this.a.getApplication().registerReceiver(this.c, (IntentFilter)localObject) != null) {
      this.b = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("regist vipFunCall ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("GVipFunCallMonitor", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void b()
  {
    if (this.b)
    {
      this.a.getApplication().unregisterReceiver(this.c);
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GVipFunCallMonitor
 * JD-Core Version:    0.7.0.1
 */