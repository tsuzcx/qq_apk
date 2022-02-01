package com.tencent.aelight.camera.aeeditor.module.edit;

import com.tencent.aelight.camera.aeeditor.AEEditorPath.EDITOR.PAG;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AEEditorCommonEditFragment$21
  implements Runnable
{
  AEEditorCommonEditFragment$21(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void run()
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new AEEditorCommonEditFragment.21.1(this);
    localHttpNetReq.mReqUrl = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/Circle/AEEditor/AEEditorLoadingPagV2.zip";
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(AEEditorPath.EDITOR.PAG.c).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mExcuteTimeLimit = 30000L;
    try
    {
      ((IHttpEngineService)MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(localHttpNetReq);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.AEEditorCommonEditFragment.21
 * JD-Core Version:    0.7.0.1
 */