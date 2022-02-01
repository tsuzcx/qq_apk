import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.widget.BubblePopupWindow;

public class bjxe
  implements View.OnLongClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new bjxf(this);
  public BubblePopupWindow a;
  public String a;
  
  public bjxe(QidianProfileCardActivity paramQidianProfileCardActivity)
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean onLongClick(View paramView)
  {
    int i = paramView.getId();
    this.jdField_a_of_type_JavaLangString = String.valueOf(paramView.getTag());
    bhjq localbhjq = new bhjq();
    localbhjq.a(i, anvx.a(2131709204));
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bhcw.a(paramView, localbhjq, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new bjxg(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxe
 * JD-Core Version:    0.7.0.1
 */