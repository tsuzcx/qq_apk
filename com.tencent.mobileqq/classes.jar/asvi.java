import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class asvi
  implements AdapterView.OnItemClickListener
{
  asvi(asvf paramasvf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!asvf.a(this.a))
    {
      bool = true;
      asvf.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Asqq != null) {
        this.a.jdField_a_of_type_Asqq.a(asvf.a(this.a));
      }
      if (!asvf.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Aswr.a(false);
      this.a.jdField_a_of_type_Aswr.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aswr.e(asvf.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Aswr.a(true);
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvi
 * JD-Core Version:    0.7.0.1
 */