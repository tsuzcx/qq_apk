package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager;

public class ReadInJoyVideoStrategy
  implements IStrategy
{
  private static ReadInJoyVideoStrategy a = new ReadInJoyVideoStrategy();
  
  public void a(String paramString, IStrategy.URLCallback paramURLCallback)
  {
    ThirdVideoManager.a().a(paramString, new ReadInJoyVideoStrategy.1(this, paramURLCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.ReadInJoyVideoStrategy
 * JD-Core Version:    0.7.0.1
 */