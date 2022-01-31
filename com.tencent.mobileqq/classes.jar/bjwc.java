import com.tencent.biz.ui.TouchWebView;
import cooperation.qzone.webviewwrapper.IWebviewListener;

class bjwc
  implements bjwg
{
  bjwc(bjwb parambjwb, IWebviewListener paramIWebviewListener) {}
  
  public void a()
  {
    if (bjwb.a(this.jdField_a_of_type_Bjwb) == null) {}
    do
    {
      return;
      if (bjwb.a(this.jdField_a_of_type_Bjwb).getVisibility() != 0) {
        bjwb.a(this.jdField_a_of_type_Bjwb).setVisibility(0);
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
 * Qualified Name:     bjwc
 * JD-Core Version:    0.7.0.1
 */