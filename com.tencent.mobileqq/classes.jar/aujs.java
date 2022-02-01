import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public final class aujs
  implements INetEngine.INetEngineListener
{
  private final IHostInterface.IHttpListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private aujs(String paramString, IHostInterface.IHttpListener paramIHttpListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener = paramIHttpListener;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if ((paramNetResp.mHttpCode == 200) || (paramNetResp.mHttpCode == 206)) {}
    for (String str = new String(paramNetResp.mRespData);; str = null)
    {
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener.onResponse(paramNetResp.mHttpCode, str);
      }
      Log.i("TdsReaderView_", "onResp url:" + this.jdField_a_of_type_JavaLangString + ", status=" + paramNetResp.mHttpCode + ", rsp=" + str);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujs
 * JD-Core Version:    0.7.0.1
 */