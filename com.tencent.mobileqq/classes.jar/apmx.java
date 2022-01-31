import android.view.View;
import android.view.View.OnClickListener;

class apmx
  implements View.OnClickListener
{
  apmx(apmu paramapmu, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Apmu.a == null) {
      return;
    }
    this.jdField_a_of_type_Apmu.a.hideSoftInputFromWindow();
    apmu.a(this.jdField_a_of_type_Apmu, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Apmu.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmx
 * JD-Core Version:    0.7.0.1
 */