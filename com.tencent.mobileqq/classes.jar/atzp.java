import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class atzp
  implements AdapterView.OnItemClickListener
{
  atzp(atzm paramatzm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!atzm.a(this.a))
    {
      bool = true;
      atzm.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Atux != null) {
        this.a.jdField_a_of_type_Atux.a(atzm.a(this.a));
      }
      if (!atzm.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Auay.a(false);
      this.a.jdField_a_of_type_Auay.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Auay.e(atzm.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Auay.a(true);
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzp
 * JD-Core Version:    0.7.0.1
 */