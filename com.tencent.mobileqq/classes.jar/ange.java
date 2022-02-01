import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class ange
  implements INetEngine.IBreakDownFix
{
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq == null) || (paramNetResp == null)) {}
    do
    {
      do
      {
        return;
      } while (!(paramNetReq instanceof HttpNetReq));
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
      paramNetResp.mWrittenBlockLen = 0L;
      paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
      paramNetReq.mReqProperties.put("Range", paramNetResp);
      paramNetResp = paramNetReq.mReqUrl;
      if (paramNetResp.contains("range="))
      {
        String str = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.mReqUrl = (str + "range=" + paramNetReq.mStartDownOffset);
      }
    } while (!QLog.isColorLevel());
    QLog.i("MonitorSocketDownload", 2, "IBreakDownFix, " + paramNetResp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ange
 * JD-Core Version:    0.7.0.1
 */