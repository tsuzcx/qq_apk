package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

class StoryPlayerImpl$6
  implements MessageQueue.IdleHandler
{
  StoryPlayerImpl$6(StoryPlayerImpl paramStoryPlayerImpl) {}
  
  public boolean queueIdle()
  {
    SLog.b("Q.qqstory.playernew.StoryPlayerImpl", "initSdk");
    TVK_SDKMgr.initSdk(StoryPlayerImpl.a(this.a).getContext().getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */