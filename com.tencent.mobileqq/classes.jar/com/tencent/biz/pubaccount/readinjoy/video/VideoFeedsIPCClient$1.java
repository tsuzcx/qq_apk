package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class VideoFeedsIPCClient$1
  extends QIPCModule
{
  VideoFeedsIPCClient$1(VideoFeedsIPCClient paramVideoFeedsIPCClient, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (VideoFeedsIPCClient.a(this.a))
    {
      Iterator localIterator = VideoFeedsIPCClient.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((VideoFeedsIPCClient.Observer)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCClient.1
 * JD-Core Version:    0.7.0.1
 */