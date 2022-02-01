import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class assg
  implements View.OnLongClickListener
{
  public assg(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Athn.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bguh localbguh = new bguh();
    localbguh.a(2131365302, paramView.getContext().getString(2131691320));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bgkw.a(paramView, localbguh, new assh(this, paramView), new assi(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assg
 * JD-Core Version:    0.7.0.1
 */