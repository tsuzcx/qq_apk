import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;

public final class arcv
  implements bapx
{
  private final IHostInterface.IHttpListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private arcv(String paramString, IHostInterface.IHttpListener paramIHttpListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener = paramIHttpListener;
  }
  
  public void onResp(baqw parambaqw)
  {
    if ((parambaqw.c == 200) || (parambaqw.c == 206)) {}
    for (String str = new String(parambaqw.a);; str = null)
    {
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener.onResponse(parambaqw.c, str);
      }
      Log.i("TdsReaderView_", "onResp url:" + this.jdField_a_of_type_JavaLangString + ", status=" + parambaqw.c + ", rsp=" + str);
      return;
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcv
 * JD-Core Version:    0.7.0.1
 */