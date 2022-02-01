import android.view.View;
import com.tencent.widget.AdapterView;

class ayav
  implements bkil
{
  private ayav(ayar paramayar) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    bkil localbkil = this.a.jdField_a_of_type_Ayaq.a();
    if (localbkil != null) {
      localbkil.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    bkil localbkil = this.a.jdField_a_of_type_Ayaq.a();
    if (localbkil != null) {
      localbkil.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayav
 * JD-Core Version:    0.7.0.1
 */