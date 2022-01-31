import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.List;

class arms
  implements bhuy
{
  arms(armo paramarmo) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    armo.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Arog;
    if (armo.a(this.a) == armo.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Arhx != null) {
        this.a.jdField_a_of_type_Arhx.a(paramInt);
      }
      paramAdapterView = (arkl)armo.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      arri.b(BaseApplicationImpl.getContext().getString(2131692560));
      return;
    }
    this.a.jdField_a_of_type_Arki.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Arki.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Arog.c(armo.a(this.a, armo.a(this.a)));
    this.a.jdField_a_of_type_Arog.c();
    if (this.a.jdField_a_of_type_Arhw != null) {
      this.a.jdField_a_of_type_Arhw.e();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Arhx.a(true);
      this.a.jdField_a_of_type_Arog.a(false);
      armo.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arms
 * JD-Core Version:    0.7.0.1
 */