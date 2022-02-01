import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdxz
  implements View.OnClickListener
{
  bdxz(bdxx parambdxx, bdxj parambdxj, bdxf parambdxf, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (bdxx.a(this.jdField_a_of_type_Bdxx) != null) {
      bdxx.a(this.jdField_a_of_type_Bdxx).a(this.jdField_a_of_type_Bdxj, (bdxk)this.jdField_a_of_type_Bdxf, this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxz
 * JD-Core Version:    0.7.0.1
 */