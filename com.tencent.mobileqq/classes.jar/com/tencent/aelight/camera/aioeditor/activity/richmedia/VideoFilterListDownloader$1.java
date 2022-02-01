package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;

class VideoFilterListDownloader$1
  implements Runnable
{
  VideoFilterListDownloader$1(VideoFilterListDownloader paramVideoFilterListDownloader, FilterDesc paramFilterDesc) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this.this$0.a;
    localHttpNetReq.mReqUrl = this.a.resurl;
    localHttpNetReq.mHttpMethod = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CaptureVideoFilterManager.b);
    localStringBuilder.append(this.a.name);
    localStringBuilder.append(".zip");
    localHttpNetReq.mOutPath = localStringBuilder.toString();
    localHttpNetReq.setUserData(this.a);
    localHttpNetReq.mFailedListener = this.this$0;
    if (this.a.bundle == null) {
      this.a.bundle = new Bundle();
    }
    this.a.bundle.putLong("requestStartTime", System.currentTimeMillis());
    AVNetEngine.a().sendReq(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader.1
 * JD-Core Version:    0.7.0.1
 */