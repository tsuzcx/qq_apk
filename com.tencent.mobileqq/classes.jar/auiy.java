import android.view.View;
import com.tencent.widget.AdapterView;

class auiy
  implements bljm
{
  auiy(auiv paramauiv) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!auiv.a(this.a))
    {
      bool = true;
      auiv.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Aueg != null) {
        this.a.jdField_a_of_type_Aueg.a(auiv.a(this.a));
      }
      if (!auiv.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Aukh.a(false);
      this.a.jdField_a_of_type_Aukh.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aukh.e(auiv.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Aukh.a(true);
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiy
 * JD-Core Version:    0.7.0.1
 */