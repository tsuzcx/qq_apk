import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awdx
  implements View.OnClickListener
{
  awdx(awdu paramawdu, awdt paramawdt, awdy paramawdy) {}
  
  public void onClick(View paramView)
  {
    awdu.a(this.jdField_a_of_type_Awdu).a(awdu.a(this.jdField_a_of_type_Awdu), this.jdField_a_of_type_Awdu, this.jdField_a_of_type_Awdt, this.jdField_a_of_type_Awdy);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdx
 * JD-Core Version:    0.7.0.1
 */