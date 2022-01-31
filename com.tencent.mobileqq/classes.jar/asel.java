import android.view.View;
import android.view.View.OnClickListener;

class asel
  implements View.OnClickListener
{
  asel(asei paramasei, boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Asei.a == null) {
      return;
    }
    this.jdField_a_of_type_Asei.a.hideSoftInputFromWindow();
    asei.a(this.jdField_a_of_type_Asei, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Asei.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asel
 * JD-Core Version:    0.7.0.1
 */