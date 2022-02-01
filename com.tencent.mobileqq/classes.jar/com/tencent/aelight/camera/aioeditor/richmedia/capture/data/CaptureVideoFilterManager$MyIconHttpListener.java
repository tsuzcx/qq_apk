package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.concurrent.atomic.AtomicInteger;

class CaptureVideoFilterManager$MyIconHttpListener
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download IconFile failed. errorCode: ");
      localStringBuilder.append(paramNetResp.mErrCode);
      localStringBuilder.append(", errorMsg: ");
      localStringBuilder.append(paramNetResp.mErrDesc);
      localStringBuilder.append(", file: ");
      localStringBuilder.append(localFilterDesc.iconurl);
      AVLog.printColorLog("CaptureVideoFilterManager", localStringBuilder.toString());
      return;
    }
    if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.a(this.a) != null)) {
      CaptureVideoFilterManager.a(this.a).a(true);
    }
    paramNetResp = new StringBuilder();
    paramNetResp.append("download iconFile success. file: ");
    paramNetResp.append(localFilterDesc.iconurl);
    AVLog.printColorLog("CaptureVideoFilterManager", paramNetResp.toString());
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager.MyIconHttpListener
 * JD-Core Version:    0.7.0.1
 */