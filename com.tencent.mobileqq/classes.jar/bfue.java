import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class bfue
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bfuf(this);
  public BubblePopupWindow a;
  public String a;
  
  public bfue(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    bdkz localbdkz = new bdkz();
    localbdkz.a(i, alpo.a(2131710128));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bdbk.a(paramView, localbdkz, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new bfug(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfue
 * JD-Core Version:    0.7.0.1
 */