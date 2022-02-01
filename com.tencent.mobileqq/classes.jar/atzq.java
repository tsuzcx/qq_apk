import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import java.util.List;

class atzq
  implements AdapterView.OnItemSelectedListener
{
  atzq(atzm paramatzm) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    atzm.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Auay;
    if (atzm.a(this.a) == atzm.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Atux != null) {
        this.a.jdField_a_of_type_Atux.a(paramInt);
      }
      paramAdapterView = (atxc)atzm.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      audr.b(BaseApplicationImpl.getContext().getString(2131692289));
      return;
    }
    this.a.jdField_a_of_type_Atxa.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Atxa.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Auay.c(atzm.a(this.a, atzm.a(this.a)));
    this.a.jdField_a_of_type_Auay.c();
    if (this.a.jdField_a_of_type_Atuw != null) {
      this.a.jdField_a_of_type_Atuw.c();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Atux.a(true);
      this.a.jdField_a_of_type_Auay.a(false);
      atzm.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzq
 * JD-Core Version:    0.7.0.1
 */