import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class apmz
  implements View.OnClickListener
{
  apmz(apmy paramapmy) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bafb == null) {
      return;
    }
    this.a.jdField_a_of_type_Bafb.hideSoftInputFromWindow();
    paramView = new apkk(this.a.jdField_a_of_type_Bafb);
    paramView.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131627122), this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_Bafb.addPreviewView(paramView.b());
    this.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmz
 * JD-Core Version:    0.7.0.1
 */