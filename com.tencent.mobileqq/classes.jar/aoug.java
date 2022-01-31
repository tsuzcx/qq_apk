import com.tencent.av.AVLog;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager.OnResourceDownloadListener;
import java.util.concurrent.atomic.AtomicInteger;

public class aoug
  implements INetEngine.INetEngineListener
{
  public aoug(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2) {}
  
  public void a(NetResp paramNetResp)
  {
    FilterDesc localFilterDesc = (FilterDesc)paramNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.a();
    if (paramNetResp.jdField_a_of_type_Int != 0)
    {
      AVLog.c("CaptureVideoFilterManager", "download IconFile failed. errorCode: " + paramNetResp.b + ", errorMsg: " + paramNetResp.jdField_a_of_type_JavaLangString + ", file: " + localFilterDesc.c);
      return;
    }
    if ((CaptureVideoFilterManager.a(this.a).decrementAndGet() == 0) && (CaptureVideoFilterManager.a(this.a) != null)) {
      CaptureVideoFilterManager.a(this.a).a(true);
    }
    AVLog.c("CaptureVideoFilterManager", "download iconFile success. file: " + localFilterDesc.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoug
 * JD-Core Version:    0.7.0.1
 */