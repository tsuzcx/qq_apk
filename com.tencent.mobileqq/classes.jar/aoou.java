import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class aoou
  implements View.OnLongClickListener
{
  public aoou(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Aper.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bblr localbblr = new bblr();
    localbblr.a(2131364979, paramView.getContext().getString(2131691507));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcc.a(paramView, localbblr, new aoov(this, paramView), new aoow(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoou
 * JD-Core Version:    0.7.0.1
 */