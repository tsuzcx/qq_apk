import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class bnqe
  implements bnqb
{
  bnqe(bnqd parambnqd, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (bnqd.a(this.jdField_a_of_type_Bnqd) == null) {}
    do
    {
      return;
      if (bnqd.a(this.jdField_a_of_type_Bnqd).getVisibility() != 0) {
        bnqd.a(this.jdField_a_of_type_Bnqd).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqe
 * JD-Core Version:    0.7.0.1
 */