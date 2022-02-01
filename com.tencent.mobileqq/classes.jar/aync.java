import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class aync
  implements AdapterView.OnItemSelectedListener
{
  private aync(aymy paramaymy) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.jdField_a_of_type_Aymx.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.jdField_a_of_type_Aymx.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aync
 * JD-Core Version:    0.7.0.1
 */