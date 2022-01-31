import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class aqgp
  implements View.OnClickListener
{
  aqgp(aqgo paramaqgo) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bbgu == null) {
      return;
    }
    this.a.jdField_a_of_type_Bbgu.hideSoftInputFromWindow();
    paramView = new aqdz(this.a.jdField_a_of_type_Bbgu);
    paramView.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692761), this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_Bbgu.addPreviewView(paramView.b());
    this.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgp
 * JD-Core Version:    0.7.0.1
 */