package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.RefreshVideoFileKeyRequest;
import com.tencent.biz.qqstory.network.response.RefreshVideoFileKeyResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoServerInfoManager$2
  implements CmdTaskManger.CommandCallback<RefreshVideoFileKeyRequest, RefreshVideoFileKeyResponse>
{
  VideoServerInfoManager$2(VideoServerInfoManager paramVideoServerInfoManager) {}
  
  public void a(RefreshVideoFileKeyRequest arg1, RefreshVideoFileKeyResponse paramRefreshVideoFileKeyResponse, ErrorMessage paramErrorMessage)
  {
    this.a.b = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {
      synchronized (this.a.d)
      {
        this.a.a = paramRefreshVideoFileKeyResponse.a;
        this.a.a.c();
        SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.a);
        this.a.f.set(false);
      }
    }
    SLog.b("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
    this.a.e.set(false);
    synchronized (this.a.c)
    {
      this.a.c.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager.2
 * JD-Core Version:    0.7.0.1
 */