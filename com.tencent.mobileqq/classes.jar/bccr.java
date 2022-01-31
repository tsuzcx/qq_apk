import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;

public class bccr
  implements bccw
{
  public bccr(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.jdField_a_of_type_Bccv.a(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramView.length());
    bdes.a("Grp_edu", "Grp_recite", "Recommend_Clk", 0, 0, new String[] { this.a.jdField_a_of_type_JavaLangString, paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bccr
 * JD-Core Version:    0.7.0.1
 */