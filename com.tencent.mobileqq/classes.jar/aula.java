import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.forward.ForwardTextOption;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aula
  implements View.OnClickListener
{
  public aula(ForwardTextOption paramForwardTextOption) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_Bgpa == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_Bgpa.hideSoftInputFromWindow();
      auiq localauiq = new auiq(this.a.jdField_a_of_type_Bgpa);
      localauiq.a(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692399), this.a.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_Bgpa.addPreviewView(localauiq.b());
      this.a.E();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aula
 * JD-Core Version:    0.7.0.1
 */