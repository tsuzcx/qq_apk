package com.tencent.mobileqq.activity.richmedia;

import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.concurrent.atomic.AtomicInteger;

class VideoFilterTools$MyIconHttpListener
  implements INetEngineListener
{
  VideoFilterTools$MyIconHttpListener(VideoFilterTools paramVideoFilterTools) {}
  
  public void onResp(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      AVLog.printColorLog("VideoFilterTools", "download IconFile failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((VideoFilterTools.a(this.a).decrementAndGet() == 0) && (VideoFilterTools.a(this.a) != null)) {
      VideoFilterTools.a(this.a).a(true);
    }
    AVLog.printColorLog("VideoFilterTools", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.VideoFilterTools.MyIconHttpListener
 * JD-Core Version:    0.7.0.1
 */