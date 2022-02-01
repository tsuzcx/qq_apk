import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auvq
  implements View.OnClickListener
{
  auvq(auvp paramauvp, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (BottomTabSettingFragment.a(this.jdField_a_of_type_Auvp.a) != ((Integer)paramView.getTag()).intValue()) {
      BottomTabSettingFragment.a(this.jdField_a_of_type_Auvp.a, this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvq
 * JD-Core Version:    0.7.0.1
 */