import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ayqi
  implements View.OnClickListener
{
  ayqi(FragmentActivity paramFragmentActivity, ayqn paramayqn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ayqt.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Ayqn.e, this.jdField_a_of_type_Ayqn.b, 60011);
    ayqp.b(this.jdField_a_of_type_Ayqn.f, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqi
 * JD-Core Version:    0.7.0.1
 */