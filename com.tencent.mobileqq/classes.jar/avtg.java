import android.view.View;
import com.tencent.widget.AdapterView;

class avtg
  implements bhuy
{
  private avtg(avtc paramavtc) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.jdField_a_of_type_Int != 0)
    {
      this.a.jdField_a_of_type_Int = 0;
      this.a.a();
    }
    bhuy localbhuy = this.a.jdField_a_of_type_Avtb.a();
    if (localbhuy != null) {
      localbhuy.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    bhuy localbhuy = this.a.jdField_a_of_type_Avtb.a();
    if (localbhuy != null) {
      localbhuy.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avtg
 * JD-Core Version:    0.7.0.1
 */