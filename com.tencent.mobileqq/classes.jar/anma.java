import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;
import cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder.WebviewStatusListener;
import cooperation.qzone.webviewwrapper.WebviewWrapper;

public class anma
  implements QzoneWebViewBaseBuilder.WebviewStatusListener
{
  public anma(WebviewWrapper paramWebviewWrapper, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (WebviewWrapper.a(this.jdField_a_of_type_CooperationQzoneWebviewwrapperWebviewWrapper) == null) {}
    do
    {
      return;
      if (WebviewWrapper.a(this.jdField_a_of_type_CooperationQzoneWebviewwrapperWebviewWrapper).getVisibility() != 0) {
        WebviewWrapper.a(this.jdField_a_of_type_CooperationQzoneWebviewwrapperWebviewWrapper).setVisibility(0);
      }
    } while (this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener == null);
    this.jdField_a_of_type_CooperationQzoneWebviewwrapperIWebviewListener.onPageFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anma
 * JD-Core Version:    0.7.0.1
 */