import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

class baak
  implements INetEngine.INetEngineListener
{
  baak(baah parambaah) {}
  
  public void onResp(NetResp paramNetResp)
  {
    Object localObject = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0) {
      lba.f("CaptureVideoFilterManager", "download file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + ((FilterDesc)localObject).resurl);
    }
    for (;;)
    {
      return;
      if (!((FilterDesc)localObject).resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        lba.f("CaptureVideoFilterManager", "download file failed: md5 is not match.");
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        return;
      }
      lba.f("CaptureVideoFilterManager", "download resFile success. file: " + ((FilterDesc)localObject).resurl);
      try
      {
        localObject = baah.b;
        FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, (String)localObject, false);
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
        if ((baah.a(this.a).decrementAndGet() == 0) && (baah.a(this.a) != null))
        {
          baah.a(this.a).a(true);
          return;
        }
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
        lba.f("CaptureVideoFilterManager", "unzip file failed.");
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baak
 * JD-Core Version:    0.7.0.1
 */