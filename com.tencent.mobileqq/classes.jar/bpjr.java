import android.os.Bundle;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class bpjr
  implements INetEngine.INetEngineListener
{
  bpjr(bpjp parambpjp) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool = false;
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (localFilterDesc != null)
    {
      if (paramNetResp.mResult == 0) {
        break label96;
      }
      QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localFilterDesc.resurl);
      bpjp.a(this.a, localFilterDesc, 0L, 5);
    }
    for (;;)
    {
      bpjp.a(this.a, localFilterDesc, bool);
      return;
      label96:
      if (!localFilterDesc.resMD5.equalsIgnoreCase(SecUtil.getFileMd5(paramNetResp.mReq.mOutPath)))
      {
        QLog.e("VideoFilterListDownloader", 2, "MyListDownloaderListener file failed: md5 is not match.");
        FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
      }
      else
      {
        QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener resFile success. file: " + localFilterDesc.name + localFilterDesc.resurl);
        try
        {
          String str = bpnd.b;
          FileUtils.uncompressZip(paramNetResp.mReq.mOutPath, str, false);
          if (localFilterDesc.bundle == null) {
            localFilterDesc.bundle = new Bundle();
          }
          bpjp.a(this.a, localFilterDesc, FileUtils.getFileSizes(paramNetResp.mReq.mOutPath), 0);
          FileUtils.deleteFile(paramNetResp.mReq.mOutPath);
          bool = true;
        }
        catch (IOException paramNetResp)
        {
          paramNetResp.printStackTrace();
          QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener  unzip file failed.");
          bpjp.a(this.a, localFilterDesc, 0L, 4);
        }
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjr
 * JD-Core Version:    0.7.0.1
 */