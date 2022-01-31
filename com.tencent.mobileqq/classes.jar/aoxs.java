import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import java.util.List;

class aoxs
  implements behk
{
  aoxs(aoxp paramaoxp) {}
  
  public void a(AdapterView<?> paramAdapterView) {}
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    aoxp.a(this.a, paramInt);
    paramAdapterView = this.a.jdField_a_of_type_Aoyw;
    if (aoxp.a(this.a) == aoxp.b(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      paramAdapterView.d(bool);
      this.a.a(paramInt);
      if (this.a.jdField_a_of_type_Aotd != null) {
        this.a.jdField_a_of_type_Aotd.a(paramInt);
      }
      paramAdapterView = (aovl)aoxp.a(this.a).get(paramInt);
      if (paramAdapterView != null) {
        break;
      }
      apcb.b(BaseApplicationImpl.getContext().getString(2131626869));
      return;
    }
    this.a.jdField_a_of_type_Aovk.a().a(paramAdapterView);
    this.a.jdField_a_of_type_Aovk.a(paramInt, paramAdapterView);
    this.a.jdField_a_of_type_Aoyw.c(aoxp.a(this.a, aoxp.a(this.a)));
    this.a.jdField_a_of_type_Aoyw.c();
    if (this.a.jdField_a_of_type_Aotc != null) {
      this.a.jdField_a_of_type_Aotc.e();
    }
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_Aotd.a(true);
      this.a.jdField_a_of_type_Aoyw.a(false);
      aoxp.a(this.a, true);
    }
    this.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxs
 * JD-Core Version:    0.7.0.1
 */