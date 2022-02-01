package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.BaseManger;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.HexUtil;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoServerInfoManager
  extends BaseManger
{
  public VideoServerInfoManager.ServerInfo a = new VideoServerInfoManager.ServerInfo();
  public long b;
  public final Object c = new Object();
  public final Object d = new Object();
  public AtomicBoolean e = new AtomicBoolean(false);
  public AtomicBoolean f = new AtomicBoolean(false);
  protected INetEventHandler g = new VideoServerInfoManager.OnNetConnChangeListener(this, null);
  
  private boolean g()
  {
    if (this.a.b()) {
      h();
    }
    return this.a.a();
  }
  
  private void h()
  {
    if (this.e.getAndSet(true))
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "task is running");
      return;
    }
    SLog.a("Q.qqstory.publish:VideoServerInfoManager", "start get server info", this.a);
    RefreshVideoFileKeyRequest localRefreshVideoFileKeyRequest = new RefreshVideoFileKeyRequest();
    CmdTaskManger.a().a(localRefreshVideoFileKeyRequest, new VideoServerInfoManager.2(this));
  }
  
  public void a()
  {
    super.a();
    AppNetConnInfo.registerNetChangeReceiver(QQStoryContext.a().c(), this.g);
    Bosses.get().postJob(new VideoServerInfoManager.1(this, "Q.qqstory.publish:VideoServerInfoManager"));
  }
  
  public void b()
  {
    super.b();
    AppNetConnInfo.unregisterNetEventHandler(this.g);
  }
  
  public void c()
  {
    g();
  }
  
  public byte[] d()
  {
    if (g()) {
      return this.a.f;
    }
    h();
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait start");
    try
    {
      synchronized (this.c)
      {
        this.c.wait(30000L);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      SLog.b("Q.qqstory.publish:VideoServerInfoManager", "wait exception", localInterruptedException);
      SLog.d("Q.qqstory.publish:VideoServerInfoManager", "wait end");
      ??? = this.a;
      if (((VideoServerInfoManager.ServerInfo)???).a()) {
        return ((VideoServerInfoManager.ServerInfo)???).f;
      }
      SLog.d("Q.qqstory.publish:VideoServerInfoManager", "return auth key with invalidate");
      return ((VideoServerInfoManager.ServerInfo)???).f;
    }
  }
  
  public String e()
  {
    byte[] arrayOfByte = d();
    if (arrayOfByte == null) {
      return null;
    }
    return HexUtil.bytes2HexStr(arrayOfByte);
  }
  
  public String f()
  {
    if (!this.a.b())
    {
      byte[] arrayOfByte = this.a.f;
      if (arrayOfByte != null) {
        return HexUtil.bytes2HexStr(arrayOfByte);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager
 * JD-Core Version:    0.7.0.1
 */