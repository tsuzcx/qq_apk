import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

class asvj
  implements AdapterView.OnItemSelectedListener
{
  asvj(asvf paramasvf) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    asvf.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Aswr;
    if (asvf.a(this.a) == asvf.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Asqq != null) {
        this.a.jdField_a_of_type_Asqq.a(paramInt);
      }
      paramAdapterView = (assv)asvf.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      aszk.b(BaseApplicationImpl.getContext().getString(2131692199));
      return;
    }
    this.a.jdField_a_of_type_Asst.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Asst.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Aswr.c(asvf.a(this.a, asvf.a(this.a)));
    this.a.jdField_a_of_type_Aswr.c();
    if (this.a.jdField_a_of_type_Asqp != null) {
      this.a.jdField_a_of_type_Asqp.c();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Asqq.a(true);
      this.a.jdField_a_of_type_Aswr.a(false);
      asvf.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvj
 * JD-Core Version:    0.7.0.1
 */