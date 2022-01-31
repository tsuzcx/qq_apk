import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class anxx
  implements View.OnClickListener
{
  public anxx(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    }
    paramView = (Button)paramView.findViewById(2131299406);
    if (paramView.getTag() != null)
    {
      this.a.e = ((Integer)paramView.getTag()).intValue();
      if (this.a.jdField_a_of_type_Aonw != null) {
        this.a.jdField_a_of_type_Aonw.a(null);
      }
    }
    this.a.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxx
 * JD-Core Version:    0.7.0.1
 */