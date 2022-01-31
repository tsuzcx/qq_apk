import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

class asen
  implements View.OnClickListener
{
  asen(asem paramasem) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bdjz == null) {
      return;
    }
    this.a.jdField_a_of_type_Bdjz.hideSoftInputFromWindow();
    paramView = new asbq(this.a.jdField_a_of_type_Bdjz);
    paramView.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692845), this.a.jdField_a_of_type_JavaLangString);
    this.a.jdField_a_of_type_Bdjz.addPreviewView(paramView.b());
    this.a.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asen
 * JD-Core Version:    0.7.0.1
 */