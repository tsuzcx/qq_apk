package com.tencent.biz.qqstory.takevideo2;

import blvn;
import bmbx;
import dov.com.qq.im.ae.download.AEResInfo;
import ynm;

public class StoryPublishLauncher$2
  implements Runnable
{
  public StoryPublishLauncher$2(ynm paramynm) {}
  
  public void run()
  {
    bmbx.b("Q.qqstory.publish.StoryPublishLauncher", "launchForResult requestAEKitDownload : AEKIT_ADDITIONAL_PACKAGE");
    blvn.a().a(AEResInfo.AE_RES_BASE_PACKAGE, null, false);
    blvn.a().a(AEResInfo.AE_RES_ADDITIONAL_PACKAGE, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher.2
 * JD-Core Version:    0.7.0.1
 */