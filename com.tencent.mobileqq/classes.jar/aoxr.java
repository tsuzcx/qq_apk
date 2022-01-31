import android.view.View;
import com.tencent.widget.AdapterView;

class aoxr
  implements behi
{
  aoxr(aoxp paramaoxp) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!aoxp.a(this.a))
    {
      bool = true;
      aoxp.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Aotd != null) {
        this.a.jdField_a_of_type_Aotd.a(aoxp.a(this.a));
      }
      if (!aoxp.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Aoyw.a(false);
      this.a.jdField_a_of_type_Aoyw.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Aoyw.e(aoxp.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Aoyw.a(true);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxr
 * JD-Core Version:    0.7.0.1
 */