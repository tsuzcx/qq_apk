package com.tencent.biz.videostory.widget.view.smartmusicview;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class EditVideoSmartMusicPart$1
  implements Runnable
{
  EditVideoSmartMusicPart$1(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new EditVideoSmartMusicPart.1.1(this);
    localHttpNetReq.mReqUrl = EditVideoSmartMusicPart.a(this.this$0);
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = EditVideoSmartMusicPart.a(this.this$0).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + EditVideoSmartMusicPart.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */