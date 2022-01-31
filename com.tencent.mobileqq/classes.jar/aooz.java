import android.content.Context;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class aooz
  implements View.OnLongClickListener
{
  public aooz(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public boolean onLongClick(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    if (!this.a.b())
    {
      this.a.jdField_a_of_type_Apev.a(null);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      return false;
    }
    paramView.setSelected(true);
    bbmf localbbmf = new bbmf();
    localbbmf.a(2131364978, paramView.getContext().getString(2131691507));
    this.a.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, localbbmf, new aopa(this, paramView), new aopb(this, paramView));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aooz
 * JD-Core Version:    0.7.0.1
 */