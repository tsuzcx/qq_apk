import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class assc
  implements View.OnClickListener
{
  public assc(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    }
    Button localButton = (Button)paramView.findViewById(2131365297);
    if (localButton.getTag() != null)
    {
      this.a.e = ((Integer)localButton.getTag()).intValue();
      if (this.a.jdField_a_of_type_Athn != null) {
        this.a.jdField_a_of_type_Athn.a(null);
      }
    }
    this.a.m();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assc
 * JD-Core Version:    0.7.0.1
 */