import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class aqzb
  implements View.OnClickListener
{
  aqzb(aqyz paramaqyz, ayjl paramayjl) {}
  
  public void onClick(View paramView)
  {
    aqyy localaqyy = (aqyy)this.jdField_a_of_type_Ayjl;
    localaqyy.a(paramView);
    paramView = (CheckBox)paramView.findViewById(2131366313);
    if (paramView.getVisibility() == 0) {
      paramView.setChecked(localaqyy.b());
    }
    if (aqyz.a(this.jdField_a_of_type_Aqyz) != null) {
      aqyz.a(this.jdField_a_of_type_Aqyz).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzb
 * JD-Core Version:    0.7.0.1
 */