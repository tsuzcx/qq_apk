import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class bduj
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bduk(this);
  public BubblePopupWindow a;
  public String a;
  
  public bduj(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    bbmf localbbmf = new bbmf();
    localbbmf.a(i, ajya.a(2131709756));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView, localbbmf, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new bdul(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bduj
 * JD-Core Version:    0.7.0.1
 */