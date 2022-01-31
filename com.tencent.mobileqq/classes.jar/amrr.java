import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import cooperation.weiyun.sdk.download.WyDownloader;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;

public class amrr
  implements INetEngine.INetEngineListener
{
  public amrr(WyDownloader paramWyDownloader, WyDownloader.IDownloadListener paramIDownloadListener, String paramString1, String paramString2) {}
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadListener.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 3) {
      return;
    }
    if (paramNetResp.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramNetResp.b;
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadListener.a(this.jdField_a_of_type_JavaLangString, this.b, bool, paramNetResp.jdField_a_of_type_JavaLangString, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrr
 * JD-Core Version:    0.7.0.1
 */