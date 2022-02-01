package com.tencent.gamecenter.wadl.biz.ipc;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;

public class WadlQIPCConnector
{
  private static volatile WadlQIPCConnector a;
  private boolean b = false;
  private boolean c = false;
  private String d;
  private Object e = new Object();
  
  public static WadlQIPCConnector a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new WadlQIPCConnector();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    this.c = true;
    QLog.d("Wadl_QIPCConnector", 1, "begin connect:");
    QIPCClientHelper.getInstance().getClient().addListener(new WadlQIPCConnector.1(this));
    long l = System.currentTimeMillis();
    QIPCClientHelper.getInstance().getClient().connect(new WadlQIPCConnector.2(this, l));
  }
  
  public void b()
  {
    if ((!this.b) && (!this.c)) {
      c();
    }
    if (!this.b) {
      synchronized (this.e)
      {
        boolean bool = this.b;
        if (!bool) {
          try
          {
            this.e.wait(500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCConnector
 * JD-Core Version:    0.7.0.1
 */