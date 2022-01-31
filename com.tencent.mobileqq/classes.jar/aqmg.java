import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class aqmg
  implements View.OnLongClickListener
{
  public aqmg(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Arcc.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bdpi localbdpi = new bdpi();
    localbdpi.a(2131365065, paramView.getContext().getString(2131691562));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdft.a(paramView, localbdpi, new aqmh(this, paramView), new aqmi(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmg
 * JD-Core Version:    0.7.0.1
 */