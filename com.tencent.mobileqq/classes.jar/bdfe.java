import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdfe
  implements View.OnClickListener
{
  bdfe(bdfc parambdfc, bdeo parambdeo, bdek parambdek, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bdfc.a(this.jdField_a_of_type_Bdfc) != null) {
      bdfc.a(this.jdField_a_of_type_Bdfc).a(this.jdField_a_of_type_Bdeo, (bdep)this.jdField_a_of_type_Bdek, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfe
 * JD-Core Version:    0.7.0.1
 */