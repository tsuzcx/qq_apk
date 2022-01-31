import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class bglm
  implements bglj
{
  bglm(bgll parambgll, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (bgll.a(this.jdField_a_of_type_Bgll) == null) {}
    do
    {
      return;
      if (bgll.a(this.jdField_a_of_type_Bgll).getVisibility() != 0) {
        bgll.a(this.jdField_a_of_type_Bgll).setVisibility(0);
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
 * Qualified Name:     bglm
 * JD-Core Version:    0.7.0.1
 */