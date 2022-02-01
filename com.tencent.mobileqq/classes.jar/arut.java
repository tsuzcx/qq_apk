import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class arut
  implements View.OnLongClickListener
{
  public arut(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Aslr.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.resetSlideStatus();
      return false;
    }
    paramView.setSelected(true);
    bgaz localbgaz = new bgaz();
    localbgaz.a(2131365376, paramView.getContext().getString(2131691363));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bfue.a(paramView, localbgaz, new aruu(this, paramView), new aruv(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arut
 * JD-Core Version:    0.7.0.1
 */