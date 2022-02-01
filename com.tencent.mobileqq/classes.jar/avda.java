import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardTextOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avda
  implements View.OnClickListener
{
  public avda(ForwardTextOption paramForwardTextOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bhpc == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_Bhpc.hideSoftInputFromWindow();
      avap localavap = new avap(this.a.jdField_a_of_type_Bhpc);
      localavap.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692404), this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Bhpc.addPreviewView(localavap.b());
      this.a.F();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avda
 * JD-Core Version:    0.7.0.1
 */