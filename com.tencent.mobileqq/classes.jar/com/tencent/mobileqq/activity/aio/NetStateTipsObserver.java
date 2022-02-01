package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.tips.NetStateTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.observer.BusinessObserver;

public class NetStateTipsObserver
  implements BusinessObserver
{
  private TipsManager a;
  private NetStateTipsBar b;
  private BaseActivity c;
  private QQAppInterface d;
  
  public NetStateTipsObserver(AIOContext paramAIOContext, NetStateTipsBar paramNetStateTipsBar)
  {
    this.c = paramAIOContext.b();
    this.a = paramAIOContext.c();
    this.b = paramNetStateTipsBar;
    this.d = paramAIOContext.a();
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      if (paramInt != 1) {
        return;
      }
      if ((!NetworkUtil.isNetSupport(this.c)) && (this.a.b() != this.b.b()))
      {
        this.a.a(this.b, new Object[0]);
        ReportController.b(this.d, "dc00898", "", "", "0X800BC3C", "0X800BC3C", 0, 0, "", "", "", "");
        return;
      }
      if ((NetworkUtil.isNetSupport(this.c)) && (this.a.b() == this.b.b())) {
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.NetStateTipsObserver
 * JD-Core Version:    0.7.0.1
 */