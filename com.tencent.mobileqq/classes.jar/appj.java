import android.view.View;
import com.tencent.widget.AdapterView;

class appj
  implements bfpt
{
  appj(apph paramapph) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!apph.a(this.a))
    {
      bool = true;
      apph.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Apkr != null) {
        this.a.jdField_a_of_type_Apkr.a(apph.a(this.a));
      }
      if (!apph.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Apqu.a(false);
      this.a.jdField_a_of_type_Apqu.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Apqu.e(apph.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Apqu.a(true);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appj
 * JD-Core Version:    0.7.0.1
 */