import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class axkd
  implements View.OnClickListener
{
  axkd(FragmentActivity paramFragmentActivity, axki paramaxki, int paramInt) {}
  
  public void onClick(View paramView)
  {
    axko.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Axki.e, this.jdField_a_of_type_Axki.b, 60011);
    axkk.b(this.jdField_a_of_type_Axki.f, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkd
 * JD-Core Version:    0.7.0.1
 */