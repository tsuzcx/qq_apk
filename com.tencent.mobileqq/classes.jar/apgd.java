import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class apgd
  implements View.OnClickListener
{
  apgd(apgb paramapgb, awoi paramawoi) {}
  
  public void onClick(View paramView)
  {
    apga localapga = (apga)this.jdField_a_of_type_Awoi;
    localapga.a(paramView);
    paramView = (CheckBox)paramView.findViewById(2131366225);
    if (paramView.getVisibility() == 0) {
      paramView.setChecked(localapga.b());
    }
    if (apgb.a(this.jdField_a_of_type_Apgb) != null) {
      apgb.a(this.jdField_a_of_type_Apgb).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */