import com.tencent.kwstudio.office.base.Log;
import com.tencent.kwstudio.office.preview.IHostInterface.IHttpListener;

public final class apjy
  implements aysc
{
  private final IHostInterface.IHttpListener jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener;
  private final String jdField_a_of_type_JavaLangString;
  
  private apjy(String paramString, IHostInterface.IHttpListener paramIHttpListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener = paramIHttpListener;
  }
  
  public void onResp(aysz paramaysz)
  {
    if ((paramaysz.c == 200) || (paramaysz.c == 206)) {}
    for (String str = new String(paramaysz.a);; str = null)
    {
      if (this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener != null) {
        this.jdField_a_of_type_ComTencentKwstudioOfficePreviewIHostInterface$IHttpListener.onResponse(paramaysz.c, str);
      }
      Log.i("TdsReaderView_", "onResp url:" + this.jdField_a_of_type_JavaLangString + ", status=" + paramaysz.c + ", rsp=" + str);
      return;
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apjy
 * JD-Core Version:    0.7.0.1
 */