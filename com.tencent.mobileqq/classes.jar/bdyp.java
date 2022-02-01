import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdyp
  implements View.OnClickListener
{
  bdyp(bdyn parambdyn, bdxz parambdxz, bdxv parambdxv, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bdyn.a(this.jdField_a_of_type_Bdyn) != null) {
      bdyn.a(this.jdField_a_of_type_Bdyn).a(this.jdField_a_of_type_Bdxz, (bdya)this.jdField_a_of_type_Bdxv, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyp
 * JD-Core Version:    0.7.0.1
 */