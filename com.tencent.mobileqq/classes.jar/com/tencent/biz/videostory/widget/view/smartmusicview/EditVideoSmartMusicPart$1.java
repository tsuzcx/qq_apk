package com.tencent.biz.videostory.widget.view.smartmusicview;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import zzf;
import zzg;

public class EditVideoSmartMusicPart$1
  implements Runnable
{
  public EditVideoSmartMusicPart$1(zzf paramzzf) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new zzg(this);
    localHttpNetReq.mReqUrl = zzf.a(this.this$0);
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = zzf.a(this.this$0).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    QQStoryContext.a();
    QQStoryContext.a().getNetEngine(0).sendReq(localHttpNetReq);
    QLog.i("EditVideoSmartMusicPart", 1, "startDownloadAnim, url: " + zzf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.1
 * JD-Core Version:    0.7.0.1
 */