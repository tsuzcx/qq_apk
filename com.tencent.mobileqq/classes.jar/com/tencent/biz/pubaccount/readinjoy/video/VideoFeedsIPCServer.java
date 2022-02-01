package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.mobileqq.qipc.QIPCModule;

public class VideoFeedsIPCServer
{
  private static VideoFeedsIPCServer a;
  
  public static VideoFeedsIPCServer a()
  {
    if (a == null) {}
    try
    {
      a = new VideoFeedsIPCServer();
      return a;
    }
    finally {}
  }
  
  public QIPCModule a()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsIPCServer
 * JD-Core Version:    0.7.0.1
 */