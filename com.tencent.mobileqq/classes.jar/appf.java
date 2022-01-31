import android.view.View;
import com.tencent.widget.AdapterView;

class appf
  implements bfpc
{
  appf(appd paramappd) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a;
    boolean bool;
    if (!appd.a(this.a))
    {
      bool = true;
      appd.a(paramAdapterView, bool);
      if (this.a.jdField_a_of_type_Apkn != null) {
        this.a.jdField_a_of_type_Apkn.a(appd.a(this.a));
      }
      if (!appd.a(this.a)) {
        break label110;
      }
      this.a.jdField_a_of_type_Apqq.a(false);
      this.a.jdField_a_of_type_Apqq.b(false);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Apqq.e(appd.a(this.a));
      return;
      bool = false;
      break;
      label110:
      this.a.jdField_a_of_type_Apqq.a(true);
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appf
 * JD-Core Version:    0.7.0.1
 */