import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

public final class atfg
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
    } while (!paramNetResp.contains("range="));
    paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
    paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfg
 * JD-Core Version:    0.7.0.1
 */