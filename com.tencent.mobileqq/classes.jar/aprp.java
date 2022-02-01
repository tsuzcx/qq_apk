import com.tencent.mobileqq.conditionsearch.widget.TimeSelectView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;

public class aprp
  implements bjut
{
  private int jdField_a_of_type_Int;
  
  public aprp(TimeSelectView paramTimeSelectView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(VerticalGallery paramVerticalGallery)
  {
    int i = TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView)[this.jdField_a_of_type_Int].getSelectedItemPosition();
    if (TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView) != null) {
      TimeSelectView.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetTimeSelectView).a(this.jdField_a_of_type_Int, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aprp
 * JD-Core Version:    0.7.0.1
 */