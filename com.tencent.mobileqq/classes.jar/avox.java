import android.view.View;
import com.tencent.widget.AdapterView;

class avox
  implements bhqr
{
  private avox(avot paramavot) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    bhqr localbhqr = this.a.jdField_a_of_type_Avos.a();
    if (localbhqr != null) {
      localbhqr.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    bhqr localbhqr = this.a.jdField_a_of_type_Avos.a();
    if (localbhqr != null) {
      localbhqr.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avox
 * JD-Core Version:    0.7.0.1
 */