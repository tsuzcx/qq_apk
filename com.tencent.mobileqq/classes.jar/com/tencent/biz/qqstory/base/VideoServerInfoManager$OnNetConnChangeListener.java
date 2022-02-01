package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import java.util.concurrent.atomic.AtomicBoolean;

class VideoServerInfoManager$OnNetConnChangeListener
  implements INetEventHandler
{
  private VideoServerInfoManager$OnNetConnChangeListener(VideoServerInfoManager paramVideoServerInfoManager) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    SLog.d("Q.qqstory.publish:VideoServerInfoManager", "network change");
    this.a.b.set(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.VideoServerInfoManager.OnNetConnChangeListener
 * JD-Core Version:    0.7.0.1
 */