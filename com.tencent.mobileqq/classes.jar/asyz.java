import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class asyz
  implements View.OnLongClickListener
{
  public asyz(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Atpx.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.resetSlideStatus();
      return false;
    }
    paramView.setSelected(true);
    bhjq localbhjq = new bhjq();
    localbhjq.a(2131365469, paramView.getContext().getString(2131691448));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, localbhjq, new asza(this, paramView), new aszb(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyz
 * JD-Core Version:    0.7.0.1
 */