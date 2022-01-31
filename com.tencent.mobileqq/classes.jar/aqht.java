import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class aqht
  implements View.OnClickListener
{
  public aqht(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    }
    paramView = (Button)paramView.findViewById(2131365058);
    if (paramView.getTag() != null)
    {
      this.a.e = ((Integer)paramView.getTag()).intValue();
      if (this.a.jdField_a_of_type_Aqxt != null) {
        this.a.jdField_a_of_type_Aqxt.a(null);
      }
    }
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqht
 * JD-Core Version:    0.7.0.1
 */