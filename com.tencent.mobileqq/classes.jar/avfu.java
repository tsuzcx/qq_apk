import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avfu
  implements View.OnClickListener
{
  avfu(avft paramavft, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    SDKSetEmotionPreviewFragment.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avft.a.getActivity(), this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfu
 * JD-Core Version:    0.7.0.1
 */