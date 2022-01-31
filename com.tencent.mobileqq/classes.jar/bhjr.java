import android.view.View;
import com.tencent.qqmini.sdk.runtime.widget.InnerWebView;

class bhjr
  implements bgsn
{
  bhjr(bhjq parambhjq, bgsi parambgsi, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_Bgsi.dismiss();
    paramView = this.jdField_a_of_type_Bgsi.a(paramInt);
    if ("发送给朋友".equals(paramView)) {
      InnerWebView.a(this.jdField_a_of_type_Bhjq.a, this.jdField_a_of_type_JavaLangString);
    }
    while (!"保存到手机".equals(paramView)) {
      return;
    }
    InnerWebView.b(this.jdField_a_of_type_Bhjq.a, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhjr
 * JD-Core Version:    0.7.0.1
 */