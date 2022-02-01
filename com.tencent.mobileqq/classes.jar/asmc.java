import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.IBreakDownFix;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.HashMap;

class asmc
  implements INetEngine.IBreakDownFix
{
  asmc(asma paramasma) {}
  
  public void fixReq(NetReq paramNetReq, NetResp paramNetResp)
  {
    if ((paramNetReq != null) && (paramNetResp != null) && ((paramNetReq instanceof HttpNetReq)))
    {
      paramNetReq = (HttpNetReq)paramNetReq;
      paramNetReq.mStartDownOffset += paramNetResp.mWrittenBlockLen;
      paramNetResp.mWrittenBlockLen = 0L;
      paramNetResp = "bytes=" + paramNetReq.mStartDownOffset + "-";
      paramNetReq.mReqProperties.put("Range", paramNetResp);
      paramNetResp = paramNetReq.mReqUrl;
      if (paramNetResp.contains("range="))
      {
        paramNetResp = paramNetResp.substring(0, paramNetResp.lastIndexOf("range="));
        paramNetReq.mReqUrl = (paramNetResp + "range=" + paramNetReq.mStartDownOffset);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmc
 * JD-Core Version:    0.7.0.1
 */