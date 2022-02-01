import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;

public final class autd
  implements beuq
{
  private final IHostInterface.IHttpListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private autd(String paramString, IHostInterface.IHttpListener paramIHttpListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener = paramIHttpListener;
  }
  
  public void onResp(bevm parambevm)
  {
    if ((parambevm.c == 200) || (parambevm.c == 206)) {}
    for (String str = new String(parambevm.a);; str = null)
    {
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener.onResponse(parambevm.c, str);
      }
      Log.i("TdsReaderView_", "onResp url:" + this.jdField_a_of_type_JavaLangString + ", status=" + parambevm.c + ", rsp=" + str);
      return;
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     autd
 * JD-Core Version:    0.7.0.1
 */