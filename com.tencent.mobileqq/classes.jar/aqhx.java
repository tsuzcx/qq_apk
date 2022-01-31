import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class aqhx
  implements View.OnLongClickListener
{
  public aqhx(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Aqxt.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bdkz localbdkz = new bdkz();
    localbdkz.a(2131365063, paramView.getContext().getString(2131691561));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdbk.a(paramView, localbdkz, new aqhy(this, paramView), new aqhz(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhx
 * JD-Core Version:    0.7.0.1
 */