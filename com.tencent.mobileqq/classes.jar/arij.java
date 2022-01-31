import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.List;

class arij
  implements bhqr
{
  arij(arif paramarif) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    arif.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Arjx;
    if (arif.a(this.a) == arif.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Ardo != null) {
        this.a.jdField_a_of_type_Ardo.a(paramInt);
      }
      paramAdapterView = (argc)arif.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      armz.b(BaseApplicationImpl.getContext().getString(2131692559));
      return;
    }
    this.a.jdField_a_of_type_Arfz.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Arfz.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Arjx.c(arif.a(this.a, arif.a(this.a)));
    this.a.jdField_a_of_type_Arjx.c();
    if (this.a.jdField_a_of_type_Ardn != null) {
      this.a.jdField_a_of_type_Ardn.e();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Ardo.a(true);
      this.a.jdField_a_of_type_Arjx.a(false);
      arif.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arij
 * JD-Core Version:    0.7.0.1
 */