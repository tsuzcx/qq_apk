import android.view.View;
import com.tencent.widget.AdapterView;

class aytp
  implements bljo
{
  private aytp(aytl paramaytl) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    bljo localbljo = this.a.jdField_a_of_type_Aytk.a();
    if (localbljo != null) {
      localbljo.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    bljo localbljo = this.a.jdField_a_of_type_Aytk.a();
    if (localbljo != null) {
      localbljo.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytp
 * JD-Core Version:    0.7.0.1
 */