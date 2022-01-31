import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class bglf
  implements bglj
{
  bglf(bgle parambgle, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (bgle.a(this.jdField_a_of_type_Bgle) == null) {}
    do
    {
      return;
      if (bgle.a(this.jdField_a_of_type_Bgle).getVisibility() != 0) {
        bgle.a(this.jdField_a_of_type_Bgle).setVisibility(0);
      }
    } while (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener == null);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onPageFinished();
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener != null) {
      this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onReceiveError(paramInt, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglf
 * JD-Core Version:    0.7.0.1
 */