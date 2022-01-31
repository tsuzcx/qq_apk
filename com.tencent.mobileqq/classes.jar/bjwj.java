import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class bjwj
  implements bjwg
{
  bjwj(bjwi parambjwi, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (bjwi.a(this.jdField_a_of_type_Bjwi) == null) {}
    do
    {
      return;
      if (bjwi.a(this.jdField_a_of_type_Bjwi).getVisibility() != 0) {
        bjwi.a(this.jdField_a_of_type_Bjwi).setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjwj
 * JD-Core Version:    0.7.0.1
 */