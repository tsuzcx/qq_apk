import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.List;

class atre
  implements bkil
{
  atre(atra paramatra) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    atra.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Atsm;
    if (atra.a(this.a) == atra.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Atml != null) {
        this.a.jdField_a_of_type_Atml.a(paramInt);
      }
      paramAdapterView = (atoq)atra.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      atvf.b(BaseApplicationImpl.getContext().getString(2131692146));
      return;
    }
    this.a.jdField_a_of_type_Atoo.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Atoo.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Atsm.c(atra.a(this.a, atra.a(this.a)));
    this.a.jdField_a_of_type_Atsm.c();
    if (this.a.jdField_a_of_type_Atmk != null) {
      this.a.jdField_a_of_type_Atmk.c();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Atml.a(true);
      this.a.jdField_a_of_type_Atsm.a(false);
      atra.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atre
 * JD-Core Version:    0.7.0.1
 */