import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.ui.TouchWebView;

class befz
  implements RadioGroup.OnCheckedChangeListener
{
  befz(beft parambeft) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.a.jdField_a_of_type_Bekh != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_Bekh.a))) {
      this.a.jdField_a_of_type_Bekh.a(paramInt);
    }
    TouchWebView localTouchWebView;
    do
    {
      do
      {
        return;
        localTouchWebView = this.a.jdField_a_of_type_Bejh.a();
      } while (localTouchWebView == null);
      String str = localTouchWebView.getUrl();
      paramRadioGroup = str;
      if (TextUtils.isEmpty(str))
      {
        paramRadioGroup = str;
        if (this.a.jdField_a_of_type_AndroidContentIntent != null) {
          paramRadioGroup = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
        }
      }
    } while (TextUtils.isEmpty(paramRadioGroup));
    localTouchWebView.loadUrl(paramRadioGroup.replaceAll("(?<=[?&])subIndex=[^&]*", "subIndex=" + paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befz
 * JD-Core Version:    0.7.0.1
 */