import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

class apfz
  implements View.OnClickListener
{
  apfz(apfx paramapfx, awog paramawog) {}
  
  public void onClick(View paramView)
  {
    apfw localapfw = (apfw)this.jdField_a_of_type_Awog;
    localapfw.a(paramView);
    paramView = (CheckBox)paramView.findViewById(2131366225);
    if (paramView.getVisibility() == 0) {
      paramView.setChecked(localapfw.b());
    }
    if (apfx.a(this.jdField_a_of_type_Apfx) != null) {
      apfx.a(this.jdField_a_of_type_Apfx).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apfz
 * JD-Core Version:    0.7.0.1
 */