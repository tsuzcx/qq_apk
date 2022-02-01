import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.troop.homework.recite.ui.SearchReciteArticleFragment;

public class bgcz
  implements bgde
{
  public bgcz(SearchReciteArticleFragment paramSearchReciteArticleFragment) {}
  
  public void a(View paramView, int paramInt)
  {
    paramView = this.a.jdField_a_of_type_Bgdd.a(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramView);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramView.length());
    bhju.a("Grp_edu", "Grp_recite", "Recommend_Clk", 0, 0, new String[] { this.a.jdField_a_of_type_JavaLangString, paramView });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcz
 * JD-Core Version:    0.7.0.1
 */