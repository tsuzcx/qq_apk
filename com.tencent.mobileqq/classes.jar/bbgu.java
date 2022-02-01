import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import java.util.concurrent.atomic.AtomicInteger;

class bbgu
  implements INetEngine.INetEngineListener
{
  bbgu(bbgq parambbgq) {}
  
  public void onResp(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp.mResult != 0)
    {
      lbd.f("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramNetResp.mErrCode + ", errorMsg: " + paramNetResp.mErrDesc + ", file: " + localFilterDesc.iconurl);
      return;
    }
    if ((bbgq.a(this.a).decrementAndGet() == 0) && (bbgq.a(this.a) != null)) {
      bbgq.a(this.a).a(true);
    }
    lbd.f("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.iconurl);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgu
 * JD-Core Version:    0.7.0.1
 */