package com.tencent.biz.qqstory.takevideo.artfilter;

import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResManager;

class ArtFilterBridgeActivity$1
  implements Runnable
{
  ArtFilterBridgeActivity$1(ArtFilterBridgeActivity paramArtFilterBridgeActivity) {}
  
  public void run()
  {
    AEResManager.a().a(AEResInfo.b, null, false);
    ShortVideoResDownload.a(this.this$0.app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterBridgeActivity.1
 * JD-Core Version:    0.7.0.1
 */