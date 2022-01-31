import android.view.View;
import com.tencent.widget.AdapterView;

class armr
  implements bhuw
{
  armr(armo paramarmo) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!armo.a(this.a))
    {
      bool = true;
      armo.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Arhx != null) {
        this.a.jdField_a_of_type_Arhx.a(armo.a(this.a));
      }
      if (!armo.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Arog.a(false);
      this.a.jdField_a_of_type_Arog.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Arog.e(armo.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Arog.a(true);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     armr
 * JD-Core Version:    0.7.0.1
 */