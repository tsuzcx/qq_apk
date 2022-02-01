import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atta
  implements View.OnClickListener
{
  atta(atsz paramatsz, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    SDKSetEmotionPreviewFragment.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atsz.a.getActivity(), this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atta
 * JD-Core Version:    0.7.0.1
 */