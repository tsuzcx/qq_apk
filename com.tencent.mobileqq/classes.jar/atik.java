import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class atik
  implements View.OnLongClickListener
{
  public atik(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Atzh.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bhuk localbhuk = new bhuk();
    localbhuk.a(2131365346, paramView.getContext().getString(2131691323));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, localbhuk, new atil(this, paramView), new atim(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atik
 * JD-Core Version:    0.7.0.1
 */