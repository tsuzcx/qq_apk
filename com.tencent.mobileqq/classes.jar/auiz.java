import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.List;

class auiz
  implements bljo
{
  auiz(auiv paramauiv) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    auiv.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Aukh;
    if (auiv.a(this.a) == auiv.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Aueg != null) {
        this.a.jdField_a_of_type_Aueg.a(paramInt);
      }
      paramAdapterView = (augl)auiv.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      auna.b(BaseApplicationImpl.getContext().getString(2131692151));
      return;
    }
    this.a.jdField_a_of_type_Augj.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Augj.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Aukh.c(auiv.a(this.a, auiv.a(this.a)));
    this.a.jdField_a_of_type_Aukh.c();
    if (this.a.jdField_a_of_type_Auef != null) {
      this.a.jdField_a_of_type_Auef.c();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Aueg.a(true);
      this.a.jdField_a_of_type_Aukh.a(false);
      auiv.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auiz
 * JD-Core Version:    0.7.0.1
 */