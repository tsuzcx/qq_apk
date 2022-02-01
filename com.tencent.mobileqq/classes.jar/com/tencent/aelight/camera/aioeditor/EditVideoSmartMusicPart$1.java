package com.tencent.aelight.camera.aioeditor;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
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
    Object localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new EditVideoSmartMusicPart.1.1(this);
    ((HttpNetReq)localObject).mReqUrl = EditVideoSmartMusicPart.a(this.this$0);
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = EditVideoSmartMusicPart.a(this.this$0).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    ((IHttpEngineService)QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startDownloadAnim, url: ");
    ((StringBuilder)localObject).append(EditVideoSmartMusicPart.a(this.this$0));
    QLog.i("EditVideoSmartMusicPart", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */