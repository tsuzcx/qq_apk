import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class bkgx
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bkgy(this);
  public BubblePopupWindow a;
  public String a;
  
  public bkgx(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    bhuk localbhuk = new bhuk();
    localbhuk.a(i, anzj.a(2131708625));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhkx.a(paramView, localbhuk, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new bkgz(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgx
 * JD-Core Version:    0.7.0.1
 */