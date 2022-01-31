import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class anyb
  implements View.OnLongClickListener
{
  public anyb(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Aonw.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bakh localbakh = new bakh();
    localbakh.a(2131299411, paramView.getContext().getString(2131625931));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = baay.a(paramView, localbakh, new anyc(this, paramView), new anyd(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anyb
 * JD-Core Version:    0.7.0.1
 */