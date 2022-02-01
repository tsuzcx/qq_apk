import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class bbgt
  implements INetEngine.INetEngineListener
{
  bbgt(bbgq parambbgq) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0) {
      lbd.f("CaptureVideoFilterManager", "download file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        lbd.f("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        return;
      }
      lbd.f("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = bbgq.b;
        FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        if ((bbgq.a(this.a).decrementAndGet() == 0) && (bbgq.a(this.a) != null))
        {
          bbgq.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        lbd.f("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgt
 * JD-Core Version:    0.7.0.1
 */